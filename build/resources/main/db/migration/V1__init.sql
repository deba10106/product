CREATE TABLE users
  (
     id          BIGSERIAL    NOT NULL PRIMARY KEY,
     email      VARCHAR(255),
     NAME       VARCHAR(255)
 );
CREATE TABLE products
   (
      id          	BIGSERIAL    	NOT NULL PRIMARY KEY,
      name       	VARCHAR(255)	NOT NULL,
      description	VARCHAR(255)	NOT NULL,
      category		VARCHAR(255),
      price		BIGSERIAL,
      expiry_dt		DATE,
      created_by		VARCHAR(255),
      created_dt    DATE,
      last_updated_by 	VARCHAR(255),
      last_updated_dt	DATE,
      status		VARCHAR(255)
  );
  CREATE TABLE transactions
   (
      id          BIGSERIAL    	NOT NULL PRIMARY KEY,
      buyer_id    BIGSERIAL    	NOT NULL,
      seller_id   BIGSERIAL    	NOT NULL,
      product_id  BIGSERIAL    	NOT NULL,
      created_by  VARCHAR(255),
      created_dt    DATE,
      last_updated_by 	VARCHAR(255),
      last_updated_dt	DATE
  );
  CREATE TABLE reviews
   (
      id          BIGSERIAL    	NOT NULL PRIMARY KEY,
      user_id    BIGSERIAL    	NOT NULL,
      star_rating    BIGSERIAL    	NOT NULL,
      remarks		VARCHAR(255),
      created_by  VARCHAR(255),
      created_dt    DATE,
      last_updated_by 	VARCHAR(255),
      last_updated_dt	DATE
  );

