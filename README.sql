################################################
#  Perry's walk through creating a postgres DB:
################################################

1. Review in curriculum: https://www.learnhowtoprogram.com/java-june-2017/database-basics/backing-up-and-restoring-schema


2.
From within postgres you can manually populate a database then save it and dump it to a file
which can then be loaded in your app:
	String connectionString = "jdbc:h2:~/recipe-box.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'"; //check me! 
		**Needs to be edit'd to point to postgres file instead of h2 crap.
					jdbh:point to postgres here!

3.
Last login: Mon Aug 28 12:21:31 on ttys002
Epicodus-5C:recipe-box Guest$ pg_dump example > example.sql
Epicodus-5C:recipe-box Guest$ ls
README.md	build.gradle	gradle		gradlew.bat	recipeBox.JSON
build		example.sql	gradlew		recipe-box.iml	src
Epicodus-5C:recipe-box Guest$ psql example < example.sql
SET
SET
SET
SET
SET
SET
SET
SET
CREATE EXTENSION
COMMENT

4. Somehow a mirror'd databasw will be created for test purposes ...not sure details
see below CREATE DATABASE example_test WITH TEMPLATE example
################################################
# jms 8.29 hooked up postgres
################################################
psql
CREATE DATABASE garden_guide;
CREATE DATABASE garden_guide_test WITH TEMPLATE garden_guide;
\c garden_guide #connect to database
>>
CREATE TABLE plants (id int, plantName varchar, daysToMaturity varchar, plantSpacing varchar, rowSpacing varchar);

INSERT INTO plants (plantName,daysToMaturity,plantSpacing,rowSpacing) VALUE ("tomato",92,"1 foot","2ft");
INSERT INTO plants (plantName,daysToMaturity,plantSpacing,rowSpacing) VALUE ("carrot",82,"1 foot","2ft");
INSERT INTO plants (plantName,daysToMaturity,plantSpacing,rowSpacing) VALUE ("beet",72,"1 foot","2ft");
INSERT INTO plants (plantName,daysToMaturity,plantSpacing,rowSpacing) VALUE ("basil",22,"1 foot","2ft");
INSERT INTO plants (plantName,daysToMaturity,plantSpacing,rowSpacing) VALUE ("cilantro",12,"1 foot","2ft");
INSERT INTO plants (plantName,daysToMaturity,plantSpacing,rowSpacing) VALUE ("jalapeno",62,"1 foot","2ft");
<<
\c #connect to original db (\l)  \conninfo
DROP DATABASE garden_guide
\q

###############################################3
http GET localhost:4567/gardenguideapi/plants
http POST localhost:4567/gardenguideapi/plants/new < plants.json

###  psql for garden_guide_test  ############
momma=# \c garden_guide
You are now connected to database "garden_guide" as user "momma".
garden_guide=# \dt
No relations found.
garden_guide=# CREATE DATABASE garden_guide_test WITH TEMPLATE garden_guide;
CREATE TABLE plants (id serial PRIMARY KEY, plantName varchar, daysToMaturity varchar, plantSpacing varchar, rowSpacing varchar);
CREATE TABLE events (id serial PRIMARY KEY, startDate DATE,endDate DATE, type VARCHAR, plantId INT);


DROP DATABASE name_of_database;
$ pg_dump name_of_database > outfile

################################################



Epicodus-5C:recipe-box Guest$ psql
psql (9.6.3)
Type "help" for help.

Guest=# \list
                                 List of databases
      Name      | Owner | Encoding |   Collate   |    Ctype    | Access privileges 
----------------+-------+----------+-------------+-------------+-------------------
 Guest          | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
 postgres       | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
 template0      | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/Guest         +
                |       |          |             |             | Guest=CTc/Guest
 template1      | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/Guest         +
                |       |          |             |             | Guest=CTc/Guest
 test_database  | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
 test_database2 | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
(6 rows)

Guest=# DROP database test_database2;
DROP DATABASE
Guest=# CREATE DATABASE example;
CREATE DATABASE
Guest=# \list
                                List of databases
     Name      | Owner | Encoding |   Collate   |    Ctype    | Access privileges 
---------------+-------+----------+-------------+-------------+-------------------
 Guest         | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
 example       | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
 postgres      | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
 template0     | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/Guest         +
               |       |          |             |             | Guest=CTc/Guest
 template1     | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/Guest         +
               |       |          |             |             | Guest=CTc/Guest
 test_database | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
(6 rows)

Guest=# CREATE DATABASE example_test WITH TEMPLATE example;
CREATE DATABASE
Guest=# \list
                                List of databases
     Name      | Owner | Encoding |   Collate   |    Ctype    | Access privileges 
---------------+-------+----------+-------------+-------------+-------------------
 Guest         | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
 example       | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
 example_test  | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
 postgres      | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
 template0     | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/Guest         +
               |       |          |             |             | Guest=CTc/Guest
 template1     | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/Guest         +
               |       |          |             |             | Guest=CTc/Guest
 test_database | Guest | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
(7 rows)

Guest=# DROP DATABASE example;
DROP DATABASE
Guest=# DROP DATABASE example_test;
DROP DATABASE
Guest=# CREATE DATABASE example;
CREATE DATABASE
Guest=# 

