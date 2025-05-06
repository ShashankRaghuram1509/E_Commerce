ALTER TABLE customer_order
ADD COLUMN payment_method VARCHAR(50),
ADD COLUMN created_at TIMESTAMP NOT NULL DEFAULT NOW(),
ADD COLUMN last_modified_date TIMESTAMP;