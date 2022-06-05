# CathayInterviewDemo

## 建立Table SQL語法
```sql
CREATE TABLE Currency_mapping (
    id INT auto_increment,
    currency_name VARCHAR(50) NOT NULL,
    currency_ch_name VARCHAR(20) NOT NULL,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```
