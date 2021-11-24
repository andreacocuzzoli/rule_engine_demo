
CREATE TABLE
    USER_DETAILS (id integer not null auto_increment, name varchar(255),surname varchar(255),
                primary key (id),
                CONSTRAINT UC_Person UNIQUE (name,surname)
);

CREATE TABLE
    REWARDED_EVENT (id integer not null auto_increment,
                    amount_spent double,
                    reward double,
                    shop_name varchar,
                    shop_address varchar,
                    shop_category varchar,
                    rewarded_promos varchar,
                    date datetime,
                    user_id integer not null
                    CONSTRAINT user_id  REFERENCES USER_DETAILS (id),
                    primary key (id)
);