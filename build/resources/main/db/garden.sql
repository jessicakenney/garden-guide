CREATE TABLE IF NOT EXISTS gardens (
 id int PRIMARY KEY auto_increment,
 userName VARCHAR,
 gardenName VARCHAR
);

CREATE TABLE IF NOT EXISTS gardenplants (
 id int PRIMARY KEY auto_increment,
 plantId INT,
 gardenId INT,
 datePlanted DATE,
);