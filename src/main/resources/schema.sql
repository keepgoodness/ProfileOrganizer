    --Creating T_PEOPLE Table
    CREATE TABLE IF NOT EXISTS T_PEOPLE  (
        ID BIGSERIAL NOT NULL,
        FULL_NAME varchar(90) NOT NULL,
        PIN varchar(10),
        CONSTRAINT t_people_pkey PRIMARY KEY (ID)
        );

    -- Adding Check Constraint for FULL_NAME
    ALTER TABLE IF EXISTS T_PEOPLE
        ADD CONSTRAINT chk_full_name
            CHECK (REGEXP_LIKE(FULL_NAME, '^[a-zA-Zа-яА-Я -]+$'));
    -- Adding Check Constraint for PIN
    ALTER TABLE T_PEOPLE
        ADD CONSTRAINT chk_pin
            CHECK (PIN IS NULL OR REGEXP_LIKE(PIN, '^\d{10}$'));

    -- Creating T_MAILS Table
    CREATE TABLE T_MAILS (
        ID BIGSERIAL NOT NULL PRIMARY KEY,
        T_PEOPLE_ID BIGSERIAL,
        EMAIL_TYPE VARCHAR(5) NOT NULL,
        EMAIL VARCHAR(40) NULL,
        CONSTRAINT fk_mail_people FOREIGN KEY (t_people_id) REFERENCES public.t_people (id)
    );

    -- Adding Check Constraints
    ALTER TABLE T_MAILS
        ADD CONSTRAINT chk_email
            CHECK (EMAIL IS NULL OR REGEXP_LIKE(EMAIL, '^(?!\.)[A-Za-z0-9._%+-]+(?<!\.)@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'));

    -- Creating T_ADDRESSES Table
    CREATE TABLE T_ADDRESSES (
        ID BIGSERIAL NOT NULL PRIMARY KEY,
        T_PEOPLE_ID BIGSERIAL NOT NULL,
        ADDR_TYPE VARCHAR(5) NOT NULL,
        ADDR_INFO VARCHAR(300) NULL,
        CONSTRAINT fk_addresses_people FOREIGN KEY (t_people_id) REFERENCES public.t_people (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
    );