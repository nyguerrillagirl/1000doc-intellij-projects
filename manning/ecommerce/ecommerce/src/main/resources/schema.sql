CREATE TABLE products (
                          id IDENTITY PRIMARY KEY,
                          category VARCHAR(50) NOT NULL,
                          image_url VARCHAR(255) NOT NULL,
                          name VARCHAR(255) NOT NULL,
                          text VARCHAR(500) DEFAULT NULL,
                          price_per_item DECIMAL(10,2) NOT NULL
);
