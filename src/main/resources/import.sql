INSERT INTO AIRLINE (name) VALUES ('Airline center');
INSERT INTO COUNTRY (name,airline_id) VALUES ('Brasil',1);
INSERT INTO HOTEL (street,address,amount,capacity,name,country_id) VALUES ('9 de julio', '1611',2500,5,'Hotel Panamericano',1);
INSERT INTO PASSPORT (birthday,lastname,name,num_doc,type_doc) VALUES ('2021-05-15','Guzman','Alberto','22111333','DNI');
INSERT INTO RESERVATION (amount_total,embark,slot,hotel_id,passport_id)  VALUES (5000,'2021-12-22',2,1,1);