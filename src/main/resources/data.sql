-- Inserting Sample Data into T_PEOPLE
INSERT INTO T_PEOPLE (FULL_NAME, PIN) VALUES ('Иван Петров', '0123456789');
INSERT INTO T_PEOPLE (FULL_NAME, PIN) VALUES ('Мария Иванова', NULL);
INSERT INTO T_PEOPLE (FULL_NAME, PIN) VALUES ('John Doe', '9876543210');
INSERT INTO T_PEOPLE (FULL_NAME, PIN) VALUES ('Петър Иванов', '1234567890');
INSERT INTO T_PEOPLE (FULL_NAME, PIN) VALUES ('Anna-Maria Smith', '0987654321');

-- Inserting Sample Data into T_MAILS
INSERT INTO T_MAILS (T_PEOPLE_ID, EMAIL_TYPE, EMAIL) VALUES (1, 'work', 'ivan.petrov@company.com');
INSERT INTO T_MAILS (T_PEOPLE_ID, EMAIL_TYPE, EMAIL) VALUES (1, 'home', 'ivan.petrov.home@company.com');
INSERT INTO T_MAILS (T_PEOPLE_ID, EMAIL_TYPE, EMAIL) VALUES (2, 'home', 'maria.ivanova@gmail.com');
INSERT INTO T_MAILS (T_PEOPLE_ID, EMAIL_TYPE, EMAIL) VALUES (3, 'work', 'john.doe@business.com');
INSERT INTO T_MAILS (T_PEOPLE_ID, EMAIL_TYPE, EMAIL) VALUES (4, 'home', 'peter.ivanov@email.bg');
INSERT INTO T_MAILS (T_PEOPLE_ID, EMAIL_TYPE, EMAIL) VALUES (5, 'work', 'anna.smith@enterprise.com');


-- Inserting Sample Data into T_ADDRESSES
INSERT INTO T_ADDRESSES (T_PEOPLE_ID, ADDR_TYPE, ADDR_INFO) VALUES (1, 'home', 'ул. Латинка №2');
INSERT INTO T_ADDRESSES (T_PEOPLE_ID, ADDR_TYPE, ADDR_INFO) VALUES (2, 'work', 'бул. Христо Ботев №35');
INSERT INTO T_ADDRESSES (T_PEOPLE_ID, ADDR_TYPE, ADDR_INFO) VALUES (3, 'home', '9012 Pine Street');
INSERT INTO T_ADDRESSES (T_PEOPLE_ID, ADDR_TYPE, ADDR_INFO) VALUES (4, 'work', 'ж.к.Дружба 1, бл.234 А');
INSERT INTO T_ADDRESSES (T_PEOPLE_ID, ADDR_TYPE, ADDR_INFO) VALUES (5, 'home', 'ул. Мусала 24');