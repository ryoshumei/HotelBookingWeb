# HotelBookingWeb
A HotelBooking WebApp with SpringBoot,Mysql &amp; Mybatis ,html&amp;Bootstrap

## Update
2023-02-26<br>
Added buttons for admin pages for accessing between checkGuests&checkRooms pages

2023-02-24<br>
Added SpringSecurity with LoginForm(Admin Login Page).
Added 2 admin testcase with hashed password in database:<br>
Plz use testcases below to access admin pages. 
Admin ID : test1  Password: test1 <br>
Admin ID : test2  Password: test2 <br>
Admin pages are : <br>
"http://localhost:8090/admin/checkGuests" <br>
"http://localhost:8090/admin/checkRooms" <br>
For local env.


2023-02-19<br>
Added FormValidation in FrontEnd with Javascript.

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

<img src="./images_for_readme/1.png" >

<img src="./images_for_readme/1-1.png">

#### Select an available room and enter guest information

<img src="./images_for_readme/2.png">

<img src="./images_for_readme/2-1.png">


#### Complete

<img src="./images_for_readme/3.png">

### Check room_database and guests_database as an admin via browser.

### Admin Login Page
<img src="./images_for_readme/admin_login.png">

### room_database

<img src="./images_for_readme/admin_room.png">

### guests database

<img src="./images_for_readme/admin_guest.png">











