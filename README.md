# FinalProject-1
Drop DATABASE GymSystem;
CREATE DATABASE GymSystem;

USE GymSystem;

Create table customer(
	cusId VARCHAR(6) NOT NULL,
	cusName VARCHAR(10),
	address VARCHAR(40),
	contact VARCHAR(10),
	dob DATE,
	gender VARCHAR(10),
	email VARCHAR(30),
	weigth VARCHAR(30),
	height VARCHAR(30),
	CONSTRAINT PRIMARY KEY (cusId)
);
Create Table instructor(
	traId VARCHAR(20),
	traname VARCHAR(20),
	tragender VARCHAR(20),
	traNum VARCHAR(20),
	traJoinDate Date,
	traQty DECIMAL(20,2),
	traCost DECIMAL(20,2),
	traPayMonth DECIMAL(20,2),
	traTotal DECIMAL(20,2),
	CONSTRAINT PRIMARY KEY(traId)
);
Create Table equipment(
	equId VARCHAR(20),
	name VARCHAR(20),
	image VARCHAR(20),
	equQty DECIMAL(10,2),
	equCost DECIMAL(10,2),
	CONSTRAINT PRIMARY KEY (equId)
);

Create Table schedule(
	schId VARCHAR(20),
	schName VARCHAR(20),
	equId VARCHAR(20),
	schAddTime VARCHAR(20),
	schAddMon VARCHAR(20),
	CONSTRAINT PRIMARY KEY(schId),
	CONSTRAINT FOREIGN KEY(equId) REFERENCES equipment(equId) on Delete Cascade on Update Cascade

);
Create table register(
	regId VARCHAR(30),
	traId VARCHAR(30),
	cusId VARCHAR(6),
	startDate DATE,
	endDate DATE,
	subcription VARCHAR(30),
	AmountType VARCHAR(30),	
	payment DECIMAL(10,2),
	CONSTRAINT PRIMARY KEY(regId),
	CONSTRAINT FOREIGN KEY(cusId) REFERENCES customer(cusId) on Delete Cascade on Update Cascade,
	CONSTRAINT FOREIGN KEY(traId) REFERENCES instructor(traId) on Delete Cascade on Update Cascade

);
Create table attendance(
	attId VARCHAR(30),
	cusId VARCHAR(30),
	attDate DATE,
	attQty VARCHAR(2),
	CONSTRAINT PRIMARY KEY (attId),
	CONSTRAINT FOREIGN KEY(cusId) REFERENCES customer(cusId) on Delete Cascade on Update Cascade
);
Create table supliment(
	supId VARCHAR(20),
	name VARCHAR(20),
	supQty DECIMAL(10,2),
	supCost DECIMAL(10,2),
	CONSTRAINT PRIMARY KEY (supId)
);
Create table orders(
	ordId VARCHAR(20),
	date VARCHAR(20),
	cusId VARCHAR(20),
	CONSTRAINT PRIMARY KEY (ordId),
	CONSTRAINT FOREIGN KEY(cusId) REFERENCES customer(cusId) on Delete Cascade on Update Cascade
);


Create table orderDetail(
	ordId VARCHAR(6) NOT NULL,
	supId VARCHAR(6) NOT NULL,
	qty INT(11),
	unitPrice DECIMAL(8,2),
	CONSTRAINT PRIMARY KEY (ordId,supId),
	CONSTRAINT FOREIGN KEY(ordId) REFERENCES orders(ordId) on Delete Cascade on Update Cascade,
	CONSTRAINT FOREIGN KEY(supId) REFERENCES supliment(supId) on Delete Cascade on Update Cascade

);
Create table payments(
	payId VARCHAR(30),
	cusId VARCHAR(30),
	paytype VARCHAR(30),
	payAmount Decimal(10,2),
	payStatus VARCHAR(30),
	CONSTRAINT PRIMARY KEY (payId),
	CONSTRAINT FOREIGN KEY(cusId) REFERENCES customer(cusId) on Delete Cascade on Update Cascade
);










///////////////////////////////////////////////////////////////////////////////////////

Drop DATABASE GymSystem;
CREATE DATABASE GymSystem;

USE GymSystem;

Create table customer(
	cusId VARCHAR(20) NOT NULL,
	cusName VARCHAR(10),
	nic VARCHAR(50),
	address VARCHAR(40),
	contact VARCHAR(10),
	dob VARCHAR(30),
	gender VARCHAR(10),
	email VARCHAR(30),
	CONSTRAINT PRIMARY KEY (cusId)
);

INSERT INTO customer VALUES('C001','Malindu','200034403405','Balangoda','0773942128','1999-15-13','Male','malinduamesh@gmail.com');
INSERT INTO customer VALUES('C002','Kalindu','200034406401','Balangoda','0773543243','1992-1-22','Male','kalinduravis@gmail.com');
INSERT INTO customer VALUES('C003','Savindu','199934406409','Balangoda','0773435432','1994-2-24','Male','salindukalu@gmail.com');
INSERT INTO customer VALUES('C004','Ravindu','198334436001','Balangoda','0734552342','1995-5-26','Male','ralindukavi@gmail.com');
INSERT INTO customer VALUES('C005','Kamalaa','196734906443','Balangoda','0774325532','1991-10-14','Male','kalindumadu@gmail.com');

Create Table instructor(
	traId VARCHAR(20),
	traname VARCHAR(20),
	nic VARCHAR(20),
	tragender VARCHAR(20),
	traContact VARCHAR(20),
	traDOB VARCHAR(30),
	CONSTRAINT PRIMARY KEY(traId)
);


INSERT INTO instructor VALUES('D001','Gathsara','227045723','Male','0773942128','2018-09-25');
INSERT INTO instructor VALUES('D002','Lochana','237045723','Male','0773543243','2018-01-27');
INSERT INTO instructor VALUES('D003','Udara','247045723','Male','0773435432','2018-07-05');
INSERT INTO instructor VALUES('D004','Yohan','257045723','Male','0734552342','2018-05-15');
INSERT INTO instructor VALUES('D005','Bashana','267045723','Male','0774325532','2018-01-21');


Create Table equipment(
	equId VARCHAR(20),
	name VARCHAR(20),
	equQty DECIMAL(10,2),
	equCost DECIMAL(10,2),
	CONSTRAINT PRIMARY KEY (equId)
);

INSERT INTO equipment VALUES('P001','Dummbell',10,1000);
INSERT INTO equipment VALUES('P002','Dip_Station',12,10000);
INSERT INTO equipment VALUES('P003','Battle_Ropes',3,20300);
INSERT INTO equipment VALUES('P004','Bench_Press',12,30100);
INSERT INTO equipment VALUES('P005','Incline_Bench_Press',10,20300);
INSERT INTO equipment VALUES('P006','Hammer_Machine',4,10002);
INSERT INTO equipment VALUES('P007','Preacher Bench',20,53000);
INSERT INTO equipment VALUES('P008','Reverse_Hyper',14,3000);

Create Table schedule(
	schId VARCHAR(20),
	schGoal VARCHAR(20),
	schType VARCHAR(20),
	schLevel VARCHAR(20),
	schDuration VARCHAR(20),
	schPerWeek VARCHAR(20),
	schPerTime VARCHAR(20),
	CONSTRAINT PRIMARY KEY(schId)

);

INSERT INTO schedule VALUES('P001','LoseFat','beginer','Hard','4 weeks','2 times','35-40 minutes');

Create Table scheduleDetails(
	equId VARCHAR(20),
	schId VARCHAR(20),
	CONSTRAINT PRIMARY KEY(equId,schId),
	CONSTRAINT FOREIGN KEY(equId) REFERENCES equipment(equId) on Delete Cascade on Update Cascade,
	CONSTRAINT FOREIGN KEY(schId) REFERENCES schedule(schId) on Delete Cascade on Update Cascade
);

Create table register(
	regId VARCHAR(30),
	traId VARCHAR(30),
	cusId VARCHAR(6),
	memShip VARCHAR(30),
	startDate VARCHAR(30),
	endDate VARCHAR(20),
	regFeeType VARCHAR(30),	
	regFee DECIMAL(10,2),
	CONSTRAINT PRIMARY KEY(regId),
	CONSTRAINT FOREIGN KEY(cusId) REFERENCES customer(cusId) on Delete Cascade on Update Cascade,
	CONSTRAINT FOREIGN KEY(traId) REFERENCES instructor(traId) on Delete Cascade on Update Cascade

);

Create table attendance(
	attId VARCHAR(30),
	cusId VARCHAR(30),
	attDate VARCHAR(30),
	attTime VARCHAR(30),
	CONSTRAINT PRIMARY KEY (attId),
	CONSTRAINT FOREIGN KEY(cusId) REFERENCES customer(cusId) on Delete Cascade on Update Cascade
);

Create table insAttendance(
	attId VARCHAR(30),
	traId VARCHAR(20),
	attDate DATE,
	CONSTRAINT PRIMARY KEY (attId),
	CONSTRAINT FOREIGN KEY(traId) REFERENCES instructor(traId) on Delete Cascade on Update Cascade
);

Create table AttendanceMem(){
	attId VARCHAR(30),
	cusId VARCHAR(30),
	InsID VARCHAR(30),
	attInDate VARCHAR(30),
	attOutDate VARCHAR(30),
	CONSTRAINT PRIMARY KEY (attId),
	CONSTRAINT FOREIGN KEY(cusId) REFERENCES customer(cusId) on Delete Cascade on Update Cascade,
	CONSTRAINT FOREIGN KEY(InsID) REFERENCES AttendanceIns(InsID) on Delete Cascade on Update Cascade
}
Create table AttendanceIns(){
	attId VARCHAR(30),
	traId VARCHAR(20),
	attInDate VARCHAR(20),
	attOutDate VARCHAR(20),
	CONSTRAINT PRIMARY KEY (attId),
	CONSTRAINT FOREIGN KEY(traId) REFERENCES instructor(traId) on Delete Cascade on Update Cascade

}
Create table supliment(
	supId VARCHAR(20),
	name VARCHAR(20),
	supQty DECIMAL(10),
	supCost DECIMAL(10,2),
	CONSTRAINT PRIMARY KEY (supId)
);

INSERT INTO supliment VALUES('Z001','WHEY PROTEIN',10,10000);
INSERT INTO supliment VALUES('Z002','ANIMAL MASS',10,14500.00);
INSERT INTO supliment VALUES('Z003','BULK MUSCLE',10,13000.00);
INSERT INTO supliment VALUES('Z004','ANS N MASS',10,13000.00);
INSERT INTO supliment VALUES('Z005','BPI BEST PROTEIN',10,11500.00);
INSERT INTO supliment VALUES('Z006','BSN SYNTHA',10,9500.00);
INSERT INTO supliment VALUES('Z007','CARNIVOR LBS',10,11500.00);
INSERT INTO supliment VALUES('Z008','CARNIVOR',10,17500.00);

Create table orders(
	ordId VARCHAR(20),
	date VARCHAR(20),
	cusId VARCHAR(20),
	CONSTRAINT PRIMARY KEY (ordId),
	CONSTRAINT FOREIGN KEY(cusId) REFERENCES customer(cusId) on Delete Cascade on Update Cascade
);


Create table orderDetail(
	ordId VARCHAR(20) NOT NULL,
	supId VARCHAR(6) NOT NULL,
	qty INT(11),
	unitPrice DECIMAL(8,2),
	CONSTRAINT PRIMARY KEY (ordId,supId),
	CONSTRAINT FOREIGN KEY(ordId) REFERENCES orders(ordId) on Delete Cascade on Update Cascade,
	CONSTRAINT FOREIGN KEY(supId) REFERENCES supliment(supId) on Delete Cascade on Update Cascade

);
Create table payments(
	payId VARCHAR(30),
	cusId VARCHAR(30),
	paytype VARCHAR(30),
	payAmount Decimal(10,2),
	date DATE,
	CONSTRAINT PRIMARY KEY (payId),
	CONSTRAINT FOREIGN KEY(cusId) REFERENCES customer(cusId) on Delete Cascade on Update Cascade
);
Create table memberShip(
	memShipid VARCHAR(20),
	name VARCHAR(20),
	duration VARCHAR(20),
	Fee Decimal(10,2),
	CONSTRAINT PRIMARY KEY (memShipid)
);

INSERT INTO memberShip VALUES('P001','Genaral','1 Year',5000);
INSERT INTO memberShip VALUES('P002','Premium','1 Year',7500);
INSERT INTO memberShip VALUES('P003','Gold','1 Year',10000);

create table assignWorkout(
	assWorkId VARCHAR(20),
	memId VARCHAR(20),
	schId VARCHAR(20),
	assInDate VARCHAR(20),
	assOutDate VARCHAR(20),
	CONSTRAINT PRIMARY KEY(assWorkId)
);
