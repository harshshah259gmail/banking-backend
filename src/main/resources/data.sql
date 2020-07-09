DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS customer;


    CREATE TABLE customer (
      	  customer_id INT AUTO_INCREMENT  PRIMARY KEY,
      	  first_name VARCHAR(250) NOT NULL,
      	  last_name VARCHAR(250) NOT NULL,
      	  address VARCHAR(250) DEFAULT NULL,
      	  phone_number VARCHAR(250) DEFAULT NULL,
      	  social_security_number VARCHAR(250) DEFAULT NULL

      	);

    CREATE TABLE account (
    	  account_number INT AUTO_INCREMENT  PRIMARY KEY,
    	  account_type VARCHAR(250) NOT NULL,
    	  currency_type VARCHAR(250) NOT NULL,
    	  amount double NOT NULL,
    	  customer_id int NOT NULL,

    	  FOREIGN KEY (customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE
    	  );

	INSERT INTO customer (first_name, last_name, address,phone_number,social_security_number) VALUES
                                                               	  ('Elon', 'Musk', 'Los Angeles','612345278','123456'),
                                                               	  ('Bill', 'Gates', 'San Fransico','632345278','123457'),
                                                               	  ('Steve', 'Job', 'Sillicon Valley','642345278','123458');


    INSERT INTO account (account_type, currency_type, amount,customer_id) VALUES
                                                                  	  ('SAVING','USD', 20000,1),
                                                                  	  ('SAVING','USD', 30000,2),
                                                                  	  ('SAVING','USD', 40000,3),
                                                                  	  ('CURRENT','USD', 100,1),
                                                                  	  ('CURRENT','USD', 500000,2),
                                                                  	  ('CURRENT','USD', 400000,3);