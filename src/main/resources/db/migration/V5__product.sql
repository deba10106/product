CREATE TABLE products
   (
      id          	BIGSERIAL    	NOT NULL PRIMARY KEY,
      name       	VARCHAR(255)	NOT NULL,
      description	VARCHAR(255)	NOT NULL,
      category		VARCHAR(255),
      price			money,
      status		VARCHAR(255),
      expiry_dt		DATE,
      created_by		VARCHAR(255),
      created_dt    DATE,
      last_updated_by 	VARCHAR(255),
      last_updated_dt	DATE
  );
 