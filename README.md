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

<img src="https://ucb0a2de3b12fdf568319f279753.previews.dropboxusercontent.com/p/thumb/AB26RokXWe_bcr3E2W51x0o0Y0iujgC822Ye2BNtBQTvjevdWC1ZZCpl2E83mCJt5kKVVty5myYagC0zjnTSOL75jz-di8xjuAsvxDD5zu2mhF-taFQZ2PVwXL18-4JTJIPbBGno7rTM4h78dJofb2c06HTjU8QXH8_9GzvQeYdrY5RGYS_p7l2r93p5Hysk6_o_bluZ2QfKcNQON-GpZ7s6lQ_KwE_VbemQ7TqDqzc6fkTBBpSnqsBVCcJTbU8nC5kPGVmJeOeDE5QxovSnHiE6F3y1NEHe5s-aKg0r6EsumishRVe78kiZdi5fyFI7BBEA9O_-jcOGcysnIy6z55FKRXasNiniBglVzAbzQe39OV4Hip33CtutoZCK-Ll1oZsckSFOcFDCR61kA99G17nrZYnG_hQqqraVW7V3iIeMEw/p.png">

#### Select an available room and enter guest information

<img src="https://ucdcb01b1a6d1eefb097bd3234cc.previews.dropboxusercontent.com/p/thumb/AB3rjz2aG9jhrUgOLW2JnSDQMxAIt2Jf5F_VMAS7cfqv-C7mkmukQ8sFpHg0AOnWd_nr1H8KIwik_reFHTvSKrKcd5cVyeKX5ARD1PmYVewnb7JEI5z9eYdOVA9Vfz0uf1n7YKW9o9LS61yrRO9oAcSHvdTiZpBgGW_O0BRPa6hLAYCkARg_XyunWSpGNOLuUBH0uL2e7gKBSbtcNTD1KT70F0RFj-J_1OLTOEbtb9KrQ_ZkQIhJU0y6QR-IKsyd4hxklAUQExGff7XJS6L45OxtpUrsXN9-BCxtbmLvWNr6YSSJF8shEaT-oQ6dUW1loVad85fQSn3yrjOhUfzPJi8L-D1xw_IjTxFtn9cbvQWH1fUUf88NCQ1bGAFrnf6ycL12SZJ9N2Yh0NPrCmD8g0vGTdRaeag-ydttc9bYc3hIOg/p.png">

<img src="https://uc42df3992b50188507c3ed6e381.previews.dropboxusercontent.com/p/thumb/AB1TeLlH5nGTjRHtJyKbuiQ7c2QZE73pTHZYZlkUZ-wHAozq5Nt3N5PNn4Wp0MnGrf8Ggl5UiYITQqQbfrzXOtzz7y2-6Bx3QWZapZeBq-C6EwY6jyWNzItqyoWGAX-8Jo6dcAEIlM3Ffe2tQr-q4-Ec5UdcKEU4NbqO9AOW7sWG05Fd3DUimA3cCyo0auXVSlOPjWsfCmYbKaDYgSHuaIKEtOx4oUELoQbtPGmzBAK0Xqm91Nr3w0gc0r5yH8_oaNxNuqFlxeB5ajtnHhTft1BrPMO-CtF0t5vJ74g0y8rYLM5n3AludCrugG_i5k2czC4XOvVazSwbjPu8oGP2Ll25a2ggMsRGXmV9o9pxQndxZvsXsIMDE32n1Z0mtp0Oly0pSzS30eJtLBnM3qZfPEwyfnHPg-J88_kRZkNq3qyMKA/p.png">


#### Complete

<img src="https://uc29d50949b2bef9dc2fce388217.previews.dropboxusercontent.com/p/thumb/AB2l4CHb8k0QWls2mpVPHXRHYW1gmSw9KKWZmxocNbPXiA4b2J9yCyJQy5gTQcMYbuMl9FKd5qDIisoGYgrUFpdDNai4h03XbJSSq-A3rqjCYt-zoexd6WPCzQ-Qp5k2yCAQYxLF1fTsYNQG1hy7yp3EHIk0NVM1nGT1kSAXikth4ajE2CdyvTmgBfnnVTEpp48XTJZnXbfC9ob5vUg6ItaAUN8xMRKZoVNyeZ0oMMKpvLyVmMqZ4kNu6_-RgX8W5TVs3OruKOZiPy-rLu1mz8pv1GwV95Ozm01-ES10QNKoeMeW5nAa6YcVvK04Gv0Dokf0k10mcfU-F41xHT8vqyrR5t9y8ou2HBV7mjmu1W8Au5xXTWQhDLoqwHZlxZdwi3mXKQ5taD5M2E5PzL175OTx8AbBD8Fz45HCGU0lOjLvJA/p.png">

### Check room_database and guests_database as an admin via browser.

### room_database

<img src="https://uc025190a26332a22ad9a2ea2038.previews.dropboxusercontent.com/p/thumb/AB3IW5hu7jvcwx8_LzEDULSujyr12ztBvdC4VywIweoWWFurmj07-IA3WmZ8vdd1ZXj8OAz1rIZwWPcxz1Kt_i4dNUpiXrFI4aUpWgsJ5R7paAxifCcC5EPdqfR2NAYQJb_Z_jEsokY2vDUINVgvaycXM-Ekqd_VX7LH1glftokZ32DBmQbRXr5B9vSkrdlc7_qyT9_XK-Cj78Y7D6mlstG2JpSSxnk-j_Kc6tr2BggaX5OYcUEO_CO5PGzkg4D_d1z4-LdMyHjc8ZMC53Lx_H3rwAIwwpVCM8fcWXELdxeIkdpy-Xj_ynQhXKBZLV29cKai-MIMfF258ZVRI9KbBHF18pQUNaEK85ZAQO92paxguE1uBKYHPc_GUB12FQgAEsVNs1ue4NUUSs7Ub1k9PfyTfngpQE39fAmzECRF-EFshA/p.png">

### guests database

<img src="https://ucf055c047eccf90c40cea3c4421.previews.dropboxusercontent.com/p/thumb/AB139VV0VB79PJ7DX_cAD6pl3Oc0lXvnaj71KE_-Ae1j0i3SxeHMbHGeZJDpNHx56qygp6MS_-3vMEe4KqRGApgir_zQJoIPACCZuFtzfASm6wBEof4DlFbftA_8GNG_2rOUHfRbPeTMpGCX7WKrPLDxZ7LNc1-orcxQ8TF2PKyPJkEb4JaGHk9ymlMVP9yXL89EuwAfyzaryimZQsB2n5FpMSCAYYDKdgtFN6Lw4VXNxS4zeht-nld0mHRGsh4NaIlOYLFbyofTmsGB1gpauS-xVYufWMSmvIAqF4J4QinQZGbCpn8NQKqODslRSPJ8_l0VY6MEmE8kjGHYAaQiX9jDdONMQzYFyc77o-AgqkBJ-RETEsS_XzNlluhXx2JC99ULh1LmNn2hUAk7pN9fueE53vcPDVQ_Aa0GLFf67Q7XsA/p.png">












