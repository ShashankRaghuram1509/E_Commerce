CREATE TABLE customer_order (
    id SERIAL PRIMARY KEY,
    reference VARCHAR(255),
    total_amount NUMERIC,
    payment_method VARCHAR(255),
    customer_id VARCHAR(255),
    created_at TIMESTAMP NOT NULL,
    last_modified_date TIMESTAMP
);
