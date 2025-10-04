CREATE TABLE accounts (
  id INT PRIMARY KEY,
  username VARCHAR(50),
  balance DECIMAL(10,2)
);

CREATE TABLE transactions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  account_id INT,
  to_account VARCHAR(50),
  amount DECIMAL(10,2),
  tx_time TIMESTAMP
);

INSERT INTO accounts (id, username, balance) VALUES (1, 'user1', 1000.00);
