INSERT INTO kunde (id, nachname, vorname, seit, art, newsletter, rabatt, umsatz, email, password, erzeugt, aktualisiert) VALUES (100,'Admin','Admin','01.01.2001','F',1,Null,Null,'admin@hs-karlsruhe.de','1','04.04.2006 10:00:00','01.08.2006 07:15:00');
INSERT INTO kunde (id, nachname, vorname, seit, art, newsletter, rabatt, umsatz, email, password, erzeugt, aktualisiert) VALUES (101,'Daniels','Jack','01.02.2001','F',1,Null,Null,'101@hs-karlsruhe.de','1','04.04.2006 10:00:00','01.08.2006 07:15:00');
INSERT INTO kunde (id, nachname, vorname, seit, art, newsletter, rabatt, umsatz, email, password, erzeugt, aktualisiert) VALUES (102,'Alpha','Alfred','28.02.2002','P',1,Null,Null,'102@hs-karlsruhe.de','102','01.08.2007 11:00:00','03.10.2004 22:30:00');
INSERT INTO kunde (id, nachname, vorname, seit, art, newsletter, rabatt, umsatz, email, password, erzeugt, aktualisiert) VALUES (103,'Hubert','Anton','15.09.2003','F',0,NULL,NULL,'103@hs-karlsruhe.de','103','02.09.2010 12:00:00','02.11.2003 10:52:00');
INSERT INTO kunde (id, nachname, vorname, seit, art, newsletter, rabatt, umsatz, email, password, erzeugt, aktualisiert) VALUES (104,'Delta','Dirk','30.04.2004','F',1,NULL,NULL,'104@hs-karlsruhe.de','104','22.09.2013 09:23:00','02.02.2004 18:50:00');
INSERT INTO kunde (id, nachname, vorname, seit, art, newsletter, rabatt, umsatz, email, password, erzeugt, aktualisiert) VALUES (105,'Epsilon','Emil','31.03.2005','P',0,Null,Null,'105@hs-karlsruhe.de','105','01.08.2006 22:00:00','01.08.2006 19:22:00');

INSERT INTO adresse (id, plz, ort, strasse, hausnr, kunde_fk, erzeugt, aktualisiert) VALUES (200,'76133','Karlsruhe','Moltkestraﬂe','30',100,'01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO adresse (id, plz, ort, strasse, hausnr, kunde_fk, erzeugt, aktualisiert) VALUES (201,'76133','Karlsruhe','Moltkestraﬂe','31',101,'02.08.2006 00:00:00','02.08.2006 00:00:00');
INSERT INTO adresse (id, plz, ort, strasse, hausnr, kunde_fk, erzeugt, aktualisiert) VALUES (202,'76133','Karlsruhe','Moltkestraﬂe','32',102,'03.08.2006 00:00:00','03.08.2006 00:00:00');
INSERT INTO adresse (id, plz, ort, strasse, hausnr, kunde_fk, erzeugt, aktualisiert) VALUES (203,'76133','Karlsruhe','Moltkestraﬂe','33',103,'04.08.2006 00:00:00','04.08.2006 00:00:00');
INSERT INTO adresse (id, plz, ort, strasse, hausnr, kunde_fk, erzeugt, aktualisiert) VALUES (204,'76133','Karlsruhe','Moltkestraﬂe','34',104,'05.08.2006 00:00:00','05.08.2006 00:00:00');
INSERT INTO adresse (id, plz, ort, strasse, hausnr, kunde_fk, erzeugt, aktualisiert) VALUES (205,'76133','Karlsruhe','Moltkestraﬂe','35',105,'06.08.2006 00:00:00','06.08.2006 00:00:00');

INSERT INTO artikel (id, aktualisiert, erzeugt, ausgesondert, bezeichnung, preis) VALUES (300, '01-01-2014', '01-01-2014', 1, 'Testartikel' , 5.90);
INSERT INTO artikel (id, aktualisiert, erzeugt, ausgesondert, bezeichnung, preis) VALUES (301, '01-01-2014', '01-01-2014', 0, 'Dreirad' , 5.95);
INSERT INTO artikel (id, aktualisiert, erzeugt, ausgesondert, bezeichnung, preis) VALUES (302, '01-01-2014', '01-01-2014', 0, 'Supertoller Artikel', 23.13)
INSERT INTO artikel (id, aktualisiert, erzeugt, ausgesondert, bezeichnung, preis) VALUES (303, '01-01-2014', '01-01-2014', 0, 'Trekkingrad', 1223.13)
INSERT INTO artikel (id, aktualisiert, erzeugt, ausgesondert, bezeichnung, preis) VALUES (304, '01-01-2014', '01-01-2014', 0, 'Rennrad', 923.13)
INSERT INTO artikel (id, aktualisiert, erzeugt, ausgesondert, bezeichnung, preis) VALUES (305, '01-01-2014', '01-01-2014', 0, 'Mountainbike', 723.13)

INSERT INTO bestellung (id, kunde_fk, idx, erzeugt, aktualisiert) VALUES (400,101,0,'01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO bestellung (id, kunde_fk, idx, erzeugt, aktualisiert) VALUES (401,101,1,'02.08.2006 00:00:00','02.08.2006 00:00:00');
INSERT INTO bestellung (id, kunde_fk, idx, erzeugt, aktualisiert) VALUES (402,102,0,'03.08.2006 00:00:00','03.08.2006 00:00:00');
INSERT INTO bestellung (id, kunde_fk, idx, erzeugt, aktualisiert) VALUES (403,102,1,'04.08.2006 00:00:00','04.08.2006 00:00:00');
INSERT INTO bestellung (id, kunde_fk, idx, erzeugt, aktualisiert) VALUES (404,104,0,'05.08.2006 00:00:00','05.08.2006 00:00:00');

INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (500,400,300,1,'01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (501,400,301,4,'01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (502,401,302,5,'02.08.2006 00:00:00','02.08.2006 00:00:00');
INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (503,402,303,3,'03.08.2006 00:00:00','03.08.2006 00:00:00');
INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (504,402,304,2,'03.08.2006 00:00:00','03.08.2006 00:00:00');
INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (505,403,305,1,'04.08.2006 00:00:00','04.08.2006 00:00:00');
INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (507,404,301,2,'05.08.2006 00:00:00','05.08.2006 00:00:00');
INSERT INTO bestellposition (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (508,404,302,8,'05.08.2006 00:00:00','05.08.2006 00:00:00');