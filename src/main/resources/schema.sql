DROP TABLE IF EXISTS drivers;
DROP TABLE IF EXISTS cars;
DROP TABLE IF EXISTS manufacturers;

--Manufacturers
CREATE TABLE manufacturers (
    id LONG SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


--Cars
CREATE TYPE engine_type AS ENUM ('GAS', 'ELECTRIC');

CREATE TABLE cars (
    id LONG SERIAL PRIMARY KEY,
    license_plate VARCHAR(15) NOT NULL,
    seat_count INT NOT NULL,
    convertible BOOLEAN NOT NULL DEFAULT FALSE,
    rating double NOT NULL,
    engine_type engine_type NOT NULL,
    manufacturer_id LONG NOT NULL
);

ALTER TABLE cars
    ADD FOREIGN KEY (manufacturer_id)
    REFERENCES manufacturers(id);

--CREATE TABLE drivers (
--    id LONG SERIAL PRIMARY KEY,
--    license_number VARCHAR(15) NOT NULL UNIQUE,
--    years_of_experience INT NOT NULL,
--    car_id LONG NULL UNIQUE
--);
--
--ALTER TABLE drivers
--    ADD FOREIGN KEY (car_id)
--    REFERENCES cars(id);




