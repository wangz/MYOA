CREATE TABLE  affice  (
	afficeid int NOT NULL ,
	 title   varchar  (40) NOT NULL ,
	 time   datetime  NOT NULL ,
	 employeeid   int  NOT NULL ,
	 content   text ,
	 PRIMARY KEY (afficeid)
);

CREATE TABLE     bumf  (
	 bumfid   int  NOT NULL ,
	 sendter   int  NOT NULL ,
	 accepter   int  NOT NULL ,
	 title   varchar  (40)     NOT NULL ,
	 time   datetime  NOT NULL ,
	 content   text      NOT NULL ,
	 affix   varchar  (40)     NOT NULL ,
	 examine   bit  NOT NULL ,
	 sign   bit  NOT NULL ,
 PRIMARY KEY (bumfid)
) ;

CREATE TABLE     department  (
	 departmentid   int  NOT NULL ,
	 name   varchar  (20)     NOT NULL ,
	 explain1   varchar (255)  NOT NULL,
	 PRIMARY KEY (departmentid)
) ;
    

CREATE TABLE     emexcellence  (
	 excellenceid   int  NOT NULL ,
	 employeeid   int  NOT NULL ,
	 time   datetime  NOT NULL ,
	 levelid   int  NOT NULL ,
	 departmentid   int  NOT NULL ,
 PRIMARY KEY (excellenceid)
) ;
    

CREATE TABLE     eminfo  (
	 employeeid   int  NOT NULL ,
	 name   varchar  (20)     NOT NULL ,
	 sex   bit  NOT NULL ,
	 birthday   datetime  NOT NULL ,
	 learn   varchar  (10)     NOT NULL ,
	 post   varchar  (10)     NOT NULL ,
	 departmentid   int  NOT NULL ,
	 jobid   int  NOT NULL ,
	 tel   varchar  (20)     NOT NULL ,
	 addr   varchar  (100)     NOT NULL ,
	 stateid   int  NOT NULL ,
	 limit1   bit  NOT NULL ,
 PRIMARY KEY (employeeid)
);
    

CREATE TABLE     emstate  (
	 stateid   int  NOT NULL ,
	 name   varchar  (10)     NOT NULL ,
	 explain1   text      NULL ,
 PRIMARY KEY (stateid)
) ;
    

CREATE TABLE     info  (
	 infoid   int  NOT NULL ,
	 title   varchar  (40)     NOT NULL ,
	 time   datetime  NOT NULL ,
	 sendter   int  NOT NULL ,
	 accepter   int  NOT NULL ,
	 content   text      NOT NULL ,
	 new   bit  NULL ,
	 PRIMARY KEY (infoid)
) ;
    

CREATE TABLE     job  (
	 jobid   int  NOT NULL ,
	 name   varchar  (20)     NOT NULL ,
	 explain1   text      NULL ,
	PRIMARY KEY (jobid)
) ;
    

CREATE TABLE     password  (
	 employeeid   int  NOT NULL ,
	 password   varchar  (20)     NOT NULL ,
	 time   datetime  NOT NULL ,
PRIMARY KEY (employeeid)
) ;
    

CREATE TABLE     sign  (
	 signid   int  NOT NULL ,
	 time   datetime  NOT NULL ,
	 employeeid   int  NOT NULL ,
	 late   bit  NOT NULL ,
	 quit   bit  NOT NULL ,
	 leave1   bit  NOT NULL ,
	 work   bit  NOT NULL ,
	 signstateid   int  NOT NULL ,
PRIMARY KEY (signid)
) ;
    

CREATE TABLE     signstate  (
	 signstateid   int  NOT NULL ,
	 describestate   varchar  (20)     NOT NULL ,
	 time   datetime  NOT NULL,
PRIMARY KEY (signstateid)
) ;
    
