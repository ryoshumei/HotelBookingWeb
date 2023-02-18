# HotelBookingWeb
A HotelBooking WebApp with SpringBoot,Mysql &amp; Mybatis ,html&amp;Bootstrap

## Environment


#### IDE: IntelliJ IDEA 2022.1.1 (Ultimate Edition)

#### JDK: corretto-17

#### Dependency: Gradle

#### FrontEnd & UI : 
html5<br>
Bootstrap<br>
Template Engine : Thymeleaf

#### BackEnd :
Java with Springboot version '3.0.2'<br>
Mybatis
Server: Tomcat in springboot

#### Database

Mysql 8.0

## Run

This is a Gradle project , you can use "build.gradle" to import the project.<br>

Database connection setting is in "src/main/resources/application.properties" , you can edit it to  match your Env.<br>

Default port is 8090 in this project, you can also change it in "application.properties".<br>

"src/main/resources/data.sql" includes guest&room testcase, you can edit/remove it according to your needs. .

Caution: database will be reset every time you run this project because of the query statement in "src/main/resources/schema.sql", you can edit/remove it according to your needs. <br>


## Features

### Book a room

#### Enter check_in & check_out date, number of people to stay to check which rooms are available.

<img src="https://previews.dropbox.com/p/thumb/AB07F9ZYNIViNaLJtq-MXz5BUxnFOwx2KqnVPcR8xkNZ3QiQQmWPbKX2qviMZgW3sN0W7mQcjZELGDGWXKfCFWpRNCq1qzCJQV2hsfUeolUsc8HTvRNRA-g1cIsfgmf598qOda3LZnehyRcSFWgZ15Hdvx_YG__UDgZshYoJt1CqzHdmZAYdMiSOYa9p9K6jQBKl77j6P15xRgFGpl9p5SjrkRnP1VaXJ3u7T1lRwNvRH167rURE8SqLIcyzCsmlohzCcR5psaNlYQBFCo8PGpeiKreZlP161JlzWFFhtzMFBa8s8Umu3PKho_8zhwZn_nmW0UXTrNoV9a79E7WVvkgnGj9fL9ppHNfYvlO3_FCLUjggEneOQjA2W7LEO1rGM-g/p.png" >

![Employee data](https://previews.dropbox.com/p/thumb/AB07F9ZYNIViNaLJtq-MXz5BUxnFOwx2KqnVPcR8xkNZ3QiQQmWPbKX2qviMZgW3sN0W7mQcjZELGDGWXKfCFWpRNCq1qzCJQV2hsfUeolUsc8HTvRNRA-g1cIsfgmf598qOda3LZnehyRcSFWgZ15Hdvx_YG__UDgZshYoJt1CqzHdmZAYdMiSOYa9p9K6jQBKl77j6P15xRgFGpl9p5SjrkRnP1VaXJ3u7T1lRwNvRH167rURE8SqLIcyzCsmlohzCcR5psaNlYQBFCo8PGpeiKreZlP161JlzWFFhtzMFBa8s8Umu3PKho_8zhwZn_nmW0UXTrNoV9a79E7WVvkgnGj9fL9ppHNfYvlO3_FCLUjggEneOQjA2W7LEO1rGM-g/p.png)

#### Select a room and enter guest information

#### Complete

### Check room_database and guests_database as an admin via browser.

### room_database

### guests database












