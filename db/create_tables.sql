DROP SCHEMA public CASCADE;
CREATE SCHEMA public
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;

    -- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-05-15 09:22:16.983

-- tables
-- Table: app_service
CREATE TABLE app_service (
                             app_code bigserial  NOT NULL,
                             service_code bigserial  NOT NULL,
                             name varchar(120)  NOT NULL,
                             type varchar(50)  NOT NULL,
                             sub_type varchar(50)  NOT NULL,
                             description text  NOT NULL,
                             last_modified timestamp  NOT NULL,
                             CONSTRAINT app_service_pk PRIMARY KEY (service_code)
);

-- Table: application
CREATE TABLE application (
                             app_code bigserial  NOT NULL,
                             name varchar(120)  NOT NULL,
                             app_group varchar(50)  NOT NULL,
                             app_type varchar(50)  NOT NULL,
                             description text  NOT NULL,
                             app_cost decimal  NOT NULL,
                             last_modified timestamp  NOT NULL,
                             CONSTRAINT id PRIMARY KEY (app_code)
);

-- foreign keys
-- Reference: app_service_application (table: app_service)
ALTER TABLE app_service ADD CONSTRAINT app_service_application
    FOREIGN KEY (app_code)
        REFERENCES application (app_code)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.
