#! /bin/bash

docker run --name ftgo-monolith-database-dev --rm \
-d \
-p 3308:3306 \
-e MYSQL_DATABASE=monolith-db \
-e MYSQL_USER=mysqluser \
-e MYSQL_PASSWORD=mysqlpw \
-e MYSQL_ROOT_PASSWORD=mysqlrootpw \
mysql:latest