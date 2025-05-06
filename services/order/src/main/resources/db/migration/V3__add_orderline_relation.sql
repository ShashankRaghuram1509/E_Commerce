CREATE TABLE order_line (
    id SERIAL PRIMARY KEY,
    product_id VARCHAR(255),
    quantity INT,
    price NUMERIC(10,2),
    order_id INT,
    FOREIGN KEY (order_id) REFERENCES customer_order(id)
);