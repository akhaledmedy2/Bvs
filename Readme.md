# Getting Started

### Reference Documentation
1-run build.bat in router and consumer1
2-use postman collection for testing
3-run below docker commands


## Docker Commands :-
1-docker pull mysql
2-docker run -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=bvs mysql

3-docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management

4-docker network create bvs-network

5-docker network connect bvs-network mysqldb

6-docker network connect bvs-network my-rabbit

7-docker build -t router .

8-docker run -p 8090:8080 --name router-service --network bvs-network router

9-docker build -t consumer1 .

10-docker run -p 9080:9090 --name consumer1-service --network bvs-network consumer1

## Note :- use swagger also to create router account and check postman collection for test