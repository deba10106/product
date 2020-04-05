CREATE TABLE carts
   (
      id          	BIGSERIAL    	NOT NULL PRIMARY KEY,
      user_id       bigint			NOT NULL,
      created_by	VARCHAR(255),
      created_at    DATE,
      updated_at	DATE,
      is_deleted	BOOLEAN DEFAULT FALSE
  );
 