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

<img src="https://ucba08171bb76c38b8186e655ae0.previews.dropboxusercontent.com/p/thumb/AB1iawsIPshRTuYIULIYap1J_mBeQm-qi2hfNjBN6clFO6HxIXb_TbSc28GC-kbOg8Rk9mInirjHE5RE8hjF2kutR5jXwwkcHbm37IysrgTveobz25-yqkrmLoywnlruiYUVKR-NY9pwYdOdbV-8QgIk3m9JTjOwN2vZwAeq5ztgivMJjf6_eDxFMr4RaBpod0a47Ur9ECPiBKQUVQZjz0TDjiIML7G3qQR3QrsE1nb1sK8AVEGI3EyUm6Arh4qpEN9he-exbLE2WICK5KZLWpB7XJIq9cgIAmWeCtybxqFbIQtaMpQWyEZVaaA-Fwi3_jp4XW8ecjac9GSfMLDb2OIL1_O_kb1LHV70AfFZsdQXtHxBp_ErU0qWgxFORsjWw4F_WajOXSYlBV9WN5hNR-VLti6iChNhhw0Do6T8fKUGcg/p.png" >


#### Select a room and enter guest information

#### Complete

### Check room_database and guests_database as an admin via browser.

### room_database

### guests database












