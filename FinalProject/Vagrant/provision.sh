#!/bin/bash

###Apache
default_apache_index="/var/www/html/index.html"
apache_config_file="/etc/apache2/envvars"
apache_vhost_file="/etc/apache2/sites-available/vagrant_vhost.conf"
project_web_root="src"
apache_go() {
	# Install Apache
	apt-get -y install apache2

	sed -i "s/^\(.*\)www-data/\1ubuntu/g" ${apache_config_file}
	chown -R ubuntu:ubuntu /var/log/apache2

	if [ ! -f "${apache_vhost_file}" ]; then
		cat << EOF > ${apache_vhost_file}
<VirtualHost *:80>
    DocumentRoot /vagrant/${project_web_root}
    
    LogLevel debug
    ErrorLog /var/log/apache2/error.log
    CustomLog /var/log/apache2/access.log combined

    <Directory /vagrant/${project_web_root}>
        AllowOverride All
        Require all granted
    </Directory>
</VirtualHost>
EOF
	fi

	a2dissite 000-default
	a2ensite vagrant_vhost

	a2enmod rewrite

	service apache2 reload
	update-rc.d apache2 enable
}


php_config_file="/etc/php5/apache2/php.ini"
php_go() {
	apt-get -y install php7.0 php-mysql libapache2-mod-php

	sed -i "s/display_startup_errors = Off/display_startup_errors = On/g" ${php_config_file}
	sed -i "s/display_errors = Off/display_errors = On/g" ${php_config_file}

	service apache2 reload
}

mysql_config_file="/etc/mysql/my.cnf"
mysql_go() {
	# Install MySQL
	echo "mysql-server mysql-server/root_password password root" | debconf-set-selections
	echo "mysql-server mysql-server/root_password_again password root" | debconf-set-selections
	apt-get -y install mysql-client mysql-server

	sed -i "s/bind-address\s*=\s*127.0.0.1/bind-address = 0.0.0.0/" ${mysql_config_file}

	# Allow root access from any host
	echo "GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'root' WITH GRANT OPTION" | mysql -u root --password=root
	echo "GRANT PROXY ON ''@'' TO 'root'@'%' WITH GRANT OPTION" | mysql -u root --password=root

	# create user with password password
	echo "CREATE DATABASE wordpress;" | mysql -u root --password=root
	echo "CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';" | mysql -u root --password=root
    echo "GRANT ALL PRIVILEGES ON wordpress.* TO 'user'@'localhost';" | mysql -u root --password=root

	if [ -d "/vagrant/provision-sql" ]; then
		echo "Executing all SQL files in /vagrant/provision-sql folder ..."
		echo "-------------------------------------"
		for sql_file in /vagrant/provision-sql/*.sql
		do
			echo "EXECUTING $sql_file..."
	  		time mysql -u root --password=root < $sql_file
	  		echo "FINISHED $sql_file"
	  		echo ""
		done
	fi

	service mysql restart
	update-rc.d apache2 enable
}

update_go() {
	# Update the server
	apt-get update
	apt-get -y upgrade
}

network_go() {
	IPADDR=$(/sbin/ifconfig eth0 | awk '/inet / { print $2 }' | sed 's/addr://')
	sed -i "s/^${IPADDR}.*//" /etc/hosts
	echo ${IPADDR} ubuntu.localhost >> /etc/hosts			# Just to quiet down some error messages
}

# This function is called at the very bottom of the file
main() {
	update_go #update packages
	network_go
	apache_go
	mysql_go
	php_go
}


main
exit 0