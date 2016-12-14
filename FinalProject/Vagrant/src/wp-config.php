<?php
/**
 * Основные параметры WordPress.
 *
 * Скрипт для создания wp-config.php использует этот файл в процессе
 * установки. Необязательно использовать веб-интерфейс, можно
 * скопировать файл в "wp-config.php" и заполнить значения вручную.
 *
 * Этот файл содержит следующие параметры:
 *
 * * Настройки MySQL
 * * Секретные ключи
 * * Префикс таблиц базы данных
 * * ABSPATH
 *
 * @link https://codex.wordpress.org/Editing_wp-config.php
 *
 * @package WordPress
 */

// ** Параметры MySQL: Эту информацию можно получить у вашего хостинг-провайдера ** //
/** Имя базы данных для WordPress */
define('DB_NAME', 'wordpress');

/** Имя пользователя MySQL */
define('DB_USER', 'user');

/** Пароль к базе данных MySQL */
define('DB_PASSWORD', 'user');

/** Имя сервера MySQL */
define('DB_HOST', 'localhost');

/** Кодировка базы данных для создания таблиц. */
define('DB_CHARSET', 'utf8mb4');

/** Схема сопоставления. Не меняйте, если не уверены. */
define('DB_COLLATE', '');

/**#@+
 * Уникальные ключи и соли для аутентификации.
 *
 * Смените значение каждой константы на уникальную фразу.
 * Можно сгенерировать их с помощью {@link https://api.wordpress.org/secret-key/1.1/salt/ сервиса ключей на WordPress.org}
 * Можно изменить их, чтобы сделать существующие файлы cookies недействительными. Пользователям потребуется авторизоваться снова.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         'PvL8.YV-j>J3iZ.pEvN;L=Y*uz;k9w,m/g.G#09*R%r&KTwnl]|~or[ab,|h>GNw');
define('SECURE_AUTH_KEY',  'vg0GZ#K+&**W# WsEuScS.3<cxT}{N/ch=t4dV]|SCoBfD/$P&x4N3$akb)rc,@W');
define('LOGGED_IN_KEY',    '#?WYNq-~s=e*79ki@}}LW:waueXbi23/K{:V-`KMzbCF|{k;rM1!Q.C)A#)YA}PC');
define('NONCE_KEY',        'nxl-0 -5|55;KqhRI}>FGJ:DoQF}atFP%<[Z `%fw}TbV/17&}hoDj]8%%C7BK~!');
define('AUTH_SALT',        'W,hiQa%q.yzM1Eg? z1Zv}Na)PSoVDx-R ;`~-&MI?&m@ewrq7E&M%.]$j+p[Yfl');
define('SECURE_AUTH_SALT', 'cbXn!n~(5af9ap-1 .VT5(yPha`V61H3`vC_2D6r]Ws =Z#XcLZ EJaHie{q<;,0');
define('LOGGED_IN_SALT',   'of@08ZF,MPepdp)KY.c>N`<(%u^sc[Aca$[1V==47uQChlhG_YN[MkKz,?psi*^a');
define('NONCE_SALT',       'ryH[OImt_0fsW*fHQ(>NlIq4*E;g^tqprS8)Iv6w?qVqY+ZO~3zvQoj(Ik|-ZNa)');

/**#@-*/

/**
 * Префикс таблиц в базе данных WordPress.
 *
 * Можно установить несколько сайтов в одну базу данных, если использовать
 * разные префиксы. Пожалуйста, указывайте только цифры, буквы и знак подчеркивания.
 */
$table_prefix  = 'wp_';

/**
 * Для разработчиков: Режим отладки WordPress.
 *
 * Измените это значение на true, чтобы включить отображение уведомлений при разработке.
 * Разработчикам плагинов и тем настоятельно рекомендуется использовать WP_DEBUG
 * в своём рабочем окружении.
 * 
 * Информацию о других отладочных константах можно найти в Кодексе.
 *
 * @link https://codex.wordpress.org/Debugging_in_WordPress
 */
define('WP_DEBUG', false);

/* Это всё, дальше не редактируем. Успехов! */

/** Абсолютный путь к директории WordPress. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Инициализирует переменные WordPress и подключает файлы. */
require_once(ABSPATH . 'wp-settings.php');
