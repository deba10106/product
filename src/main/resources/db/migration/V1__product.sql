CREATE TABLE products
   (
      id          	BIGSERIAL    	NOT NULL PRIMARY KEY,
      name       	VARCHAR(255)	NOT NULL,
      user_id	    bigint			NOT NULL,
      description	VARCHAR(255),
      price			money,
      expiry_at		DATE,
      created_by	VARCHAR(255),
      created_at    DATE,
      updated_at    DATE,
      is_deleted	BOOLEAN DEFAULT FALSE
  );
 