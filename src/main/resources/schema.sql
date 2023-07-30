CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(100) UNIQUE,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE,
                       password VARCHAR(255),
                       banned BOOLEAN DEFAULT FALSE,
                       role VARCHAR(50) DEFAULT 'ROLE_USER' CHECK (role IN ('ROLE_USER', 'ROLE_ADMIN')),
                       active BOOLEAN DEFAULT TRUE,
                       total_transactions INT DEFAULT 0,
                       balance DECIMAL(10, 2) DEFAULT 0.00,
                       currency VARCHAR(3) DEFAULT 'USD' CHECK (currency IN ('USD', 'PLN', 'UAH')),
                       rating DECIMAL(3, 2) DEFAULT 0,
                       registered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       profile VARCHAR(255)
);

CREATE TABLE products (
                          id SERIAL PRIMARY KEY,
                          title VARCHAR(255),
                          description VARCHAR(250),
                          published_at TIMESTAMP,
                          price DECIMAL(10, 2),
                          active BOOLEAN DEFAULT TRUE,
                          google_drive_file_link VARCHAR(255)
);

CREATE TABLE product_reviews (
                          id SERIAL PRIMARY KEY,
                          product_id INT REFERENCES products(id),
                          title VARCHAR(255),
                          rating DECIMAL(3, 2),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          published_at TIMESTAMP
);

CREATE TABLE carts (
                       id SERIAL PRIMARY KEY,
                       user_id INT REFERENCES users(id),
                       status VARCHAR(50) CHECK (status IN ('in_progress', 'completed')),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       total_price DECIMAL(10, 2)
);

CREATE TABLE cart_items (
                       id SERIAL PRIMARY KEY,
                       cart_id INT REFERENCES carts(id),
                       product_id INT REFERENCES products(id),
                       quantity INT DEFAULT 1
);
