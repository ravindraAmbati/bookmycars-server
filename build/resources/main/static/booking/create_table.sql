CREATE TABLE booking(
	id SERIAL PRIMARY KEY,
	source VARCHAR NOT NULL,
	destination VARCHAR NOT NULL,
	startDate VARCHAR NOT NULL,
	endDate VARCHAR,
	pickupTime VARCHAR,
	name VARCHAR NOT NULL,
	contactNo VARCHAR NOT NULL
);