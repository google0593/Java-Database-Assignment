DROP TABLE IF EXISTS "Employee";
CREATE TABLE "Employee" ("EmployeeID" TEXT PRIMARY KEY  NOT NULL , "Name" TEXT, "Surname" TEXT, "Age" INTEGER, "Contact#" INTEGER, "Address" TEXT, "Salary" DOUBLE, "Grade" INTEGER);
INSERT INTO "Employee" VALUES('E4232','Nikko','Jucutan',23,2123213,'9/33 Kay Drive',NULL,32);
INSERT INTO "Employee" VALUES('E312','asdas','asdas',23,21312,'asdas',NULL,23);
INSERT INTO "Employee" VALUES('E232','asdas','asda',23,23,'23',NULL,23);
INSERT INTO "Employee" VALUES('E123','asdas','asdas',23,23,'asd',23,23);
INSERT INTO "Employee" VALUES('E4444','asd','asd',23,213,'asd',23,23);
INSERT INTO "Employee" VALUES('E12321','asdasd','asdas',23,12312,'asda',23,23);
INSERT INTO "Employee" VALUES('E8543','Nikko','Jucutan',23,245454,'34343',322,23);
DROP TABLE IF EXISTS "Manager";
CREATE TABLE "Manager" ("EmployeeID" TEXT PRIMARY KEY  NOT NULL  DEFAULT (null) ,"Name" TEXT,"Surname" TEXT,"Age" INTEGER,"Contact#" INTEGER DEFAULT (null) ,"Address" TEXT,"Salary" DOUBLE DEFAULT (null) ,"Car" TEXT,"ParkingArea" INTEGER DEFAULT (null) ,"Make" TEXT,"Model" TEXT,"Registration" TEXT);
INSERT INTO "Manager" VALUES('M1234','Nikko','Jucutan',45,9090909,'7 Normandy Place',4545454,'Honda',43,'I have no','Idea','opopo');
INSERT INTO "Manager" VALUES('M12312','asda','asd',23,23,'asd',23,'Toyota',23,'sadas','asdas','dasd');
