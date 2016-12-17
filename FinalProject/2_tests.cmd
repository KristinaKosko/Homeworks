cd Test

call mvn clean
call mvn test 
call mvn site
start mvn jetty:run

timeout 10
start http://localhost:8080/
cd ..

pause