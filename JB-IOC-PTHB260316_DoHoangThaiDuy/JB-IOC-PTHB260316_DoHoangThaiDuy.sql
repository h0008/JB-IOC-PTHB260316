CREATE DATABASE HotelManagement;
\c HotelManagement
CREATE SCHEMA Hotel;
/*
    PART 1. Data manipulation with tables
    1. Create tables (10 points): Create 4 tables: Customer, Room, Booking, Payment. with the appropriate structure and data types. Ensure that there are primary keys (PK) and foreign keys (FK) to link the tables.
*/
-- Description of table structures.
-- Customer table:
CREATE TABLE Hotel.Customer (
                                customer_id VARCHAR(5) PRIMARY KEY NOT NULL,
                                customer_full_name VARCHAR(100) NOT NULL,
                                customer_email VARCHAR(100) NOT NULL,
                                customer_phone VARCHAR(15) NOT NULL,
                                customer_address VARCHAR(255) NOT NULL
);
-- Room table:
CREATE TABLE Hotel.Room (
                            room_id VARCHAR(5) PRIMARY KEY NOT NULL,
                            room_type VARCHAR(50) NOT NULL,
                            room_price DECIMAL(10, 2) NOT NULL,
                            room_status VARCHAR(20) NOT NULL,
                            room_area INT NOT NULL
);
-- Booking table:
CREATE TABLE Hotel.Booking (
                               booking_id SERIAL PRIMARY KEY NOT NULL, -- Using SERIAL is the equivalent of AUTO_INCREMENT in PostgreSQL.
                               customer_id VARCHAR(5) NOT NULL REFERENCES Customer(customer_id),
                               room_id VARCHAR(5) NOT NULL REFERENCES Room(room_id),
                               check_in_date DATE NOT NULL,
                               check_out_date DATE NOT NULL,
                               total_amount DECIMAL(10, 2)
);
-- Payment table:
CREATE TABLE Hotel.Payment (
                               payment_id SERIAL PRIMARY KEY NOT NULL, -- Using SERIAL is the equivalent of AUTO_INCREMENT in PostgreSQL.
                               booking_id INT NOT NULL REFERENCES Booking(booking_id),
                               payment_method VARCHAR(50) NOT NULL,
                               payment_date DATE NOT NULL,
                               payment_amount DECIMAL(10, 2) NOT NULL
);
-- 2. Insert data (6 points) Add data to the 4 created tables.
-- Insert data into the Customer table:
INSERT INTO Customer (customer_id, customer_full_name, customer_email, customer_phone, customer_address) VALUES
                                                                                                             ('C001','Nguyen Anh Tu', 'tu.nguyen@example.com', 0912345678,'Hanoi, Vietnam'),
                                                                                                             ('C002','Tran Thi Mai', 'mai.tran@example.com', 0923456789, 'Ho Chi Minh, Vietnam'),
                                                                                                             ('C003','Le Minh Hoang', 'hoang.le@example.com', 0934567890, 'Danang, Vietnam'),
                                                                                                             ('C004','Pham Hoang Nam', 'nam.pham@example.com', 0945678901, 'Hue, Vietnam'),
                                                                                                             ('C005','Vu Minh Thu', 'thu.vu@example.com', 0956789012, 'Hai Phong, Vietnam'),
                                                                                                             ('C006','Nguyen Thi Lan', 'lan.nguyen@example.com',0967890123, 'Quang Ninh, Vietnam'),
                                                                                                             ('C007','Bui Minh Tuan ', 'tuan.bui@example.com', 0978901234, 'Bac Giang, Vietnam'),
                                                                                                             ('C008','Pham Quang Hieu', 'hieu.pham@example.com', 0989012345, 'Quang Nam, Vietnam'),
                                                                                                             ('C009','Le Thi Lan', 'lan.le@example.com', 0990123456, 'Da Lat, Vietnam'),
                                                                                                             ('C010','Nguyen Thi Mai', 'mai.nguyen@example.com', 0901234567, 'Can Tho, Vietnam');
-- Insert data into the Room table:
INSERT INTO Room (room_id, room_type, room_price, room_status, room_area) VALUES
                                                                              ('R001', 'Single', 100.00, 'Available', 25),
                                                                              ('R002', 'Double', 150.00, 'Booked', 40),
                                                                              ('R003', 'Suite', 250.00, 'Available', 60),
                                                                              ('R004', 'Single', 120.00, 'Booked', 30),
                                                                              ('R005', 'Double', 160.00, 'Available', 35);
-- Insert data into the Booking table:
INSERT INTO Booking (booking_id, customer_id, room_id, check_in_date, check_out_date, total_amount) VALUES
                                                                                                        (1, 'C001', 'R001', '2025-03-01', '2025-03-05', 400.0),
                                                                                                        (2, 'C002', 'R002', '2025-03-02', '2025-03-06', 600.0),
                                                                                                        (3, 'C003', 'R003', '2025-03-03', '2025-03-07', 1000.0),
                                                                                                        (4, 'C004', 'R004', '2025-03-04', '2025-03-08', 480.0),
                                                                                                        (5, 'C005', 'R005', '2025-03-05', '2025-03-09', 800.0),
                                                                                                        (6, 'C006', 'R001', '2025-03-06', '2025-03-10', 400.0),
                                                                                                        (7, 'C007', 'R002', '2025-03-07', '2025-03-11', 600.0),
                                                                                                        (8, 'C008', 'R003', '2025-03-08', '2025-03-12', 1000.0),
                                                                                                        (9, 'C009', 'R004', '2025-03-09', '2025-03-13', 480.0),
                                                                                                        (10, 'C010', 'R005', '2025-03-10', '2025-03-14', 800.0);
-- Insert data into the Payment table:
INSERT INTO Payment (payment_id, booking_id, payment_method, payment_date, payment_amount) VALUES
                                                                                               (1, 1, 'Cash', '2025-03-05', 400.0),
                                                                                               (2, 2, 'Credit Card', '2025-03-06', 600.0),
                                                                                               (3, 3, 'Bank Transfer', '2025-03-07', 1000.0),
                                                                                               (4, 4, 'Cash', '2025-03-08', 480.0),
                                                                                               (5, 5, 'Credit Card', '2025-03-09', 800.0),
                                                                                               (6, 6, 'Bank Transfer', '2025-03-10', 400.0),
                                                                                               (7, 7, 'Cash', '2025-03-11', 600.0),
                                                                                               (8, 8, 'Credit Card', '2025-03-12', 1000.0),
                                                                                               (9, 9, 'Bank Transfer', '2025-03-13', 480.0),
                                                                                               (10, 10, 'Cash', '2025-03-14', 800.0);
/*
    3. Updating data (8 points) Write an UPDATE statement to update the total_amount in the Booking table according to public formula: total_amount = room_price * (number of days of stay).
- Conditions:
+ Only update rooms whose status (room_status) is "Booked".
+ Only update when the check-in date (check_in_date) has passed (e.g., check_in_date < CURDATE() ).
(Note: Candidates need to use JOIN to get room_price from the Room table and datediff function to calculate the number of days of stay).
(Teacher's note: Just use check_out_date - check_in_date since there is no datediff function in PostgreSQL),
 */
UPDATE Booking b
SET total_amount = r.room_price * (b.check_out_date - b.check_in_date)
FROM Room r
WHERE b.room_id = r.room_id
  AND r.room_status = 'Booked'
  AND b.check_in_date < CURRENT_DATE;
/*
    4. Deleting data (6 points) Write a DELETE statement to delete all records from the Booking table where
- Payment method (payment_method) is "Cash" in the Payment table.
- And the total amount (total_amount) in the Booking table is less than 500.
 */
-- Student's note: We need to delete the corresponding records in the Payment table first before deleting from the Booking table since there is a foreign key constraint. So we will first have to delete it from the Payment table and then from the Booking table.
DELETE FROM Payment
WHERE booking_id IN (
    SELECT booking_id
    FROM Booking
    WHERE total_amount < 500
      AND booking_id IN (
        SELECT booking_id
        FROM Payment
        WHERE payment_method = 'Cash'
    )
);
DELETE FROM Booking
WHERE total_amount < 500 AND booking_id IN (
    SELECT booking_id
    FROM Payment
    WHERE payment_method = 'Cash'
);

-- PART 2. Querying data
-- 5. (3 points) Retrieve all customers including their customer ID, Full name, Email, Phone number and Address order by Full name in increasing order.
SELECT customer_id, customer_full_name, customer_email, customer_phone, customer_address
FROM Customer
ORDER BY customer_full_name; -- Default is ASC, so we can omit it for increasing order
-- 6. (3 points) Retrieve all rooms including room ID, room type, room price and room area, sorted by room price in descending order.
SELECT room_id, room_type, room_price, room_status, room_area
FROM Room
ORDER BY room_price DESC;
-- 7. (3 points) Retrieve customer information and booked hotel room, including customer code, customer full name, room code, date, check-in and check-out dates.
SELECT c.customer_id, c.customer_full_name, b.room_id, b.check_in_date, b.check_out_date
FROM Customer c
         INNER JOIN Booking b ON c.customer_id = b.customer_id;
-- 8. (3 points) Get the list of customers and the total amount paid when booking, including customer code, customer full name, payment method and payment amount, sorted by payment amount in descending order.
SELECT c.customer_id, c.customer_full_name, p.payment_method, p.payment_amount
FROM Customer c
         INNER JOIN Booking b ON c.customer_id = b.customer_id
         INNER JOIN Payment p ON b.booking_id = p.booking_id
ORDER BY p.payment_amount DESC;
-- 9. (3 points) Get customer information from positions 2 to 4 in the Customer table sorted by customer name.
SELECT customer_id, customer_full_name, customer_email, customer_phone, customer_address
FROM Customer
ORDER BY customer_full_name;
-- 10. (5 points) Get a list of customers who have booked at least 2 rooms and have a total payment amount of over 1000, including customer code, customer's full name and number of rooms booked.
SELECT c.customer_id, c.customer_full_name, COUNT(DISTINCT b.room_id) AS rooms_booked
FROM Customer c
         INNER JOIN Booking b ON c.customer_id = b.customer_id
         INNER JOIN Payment p ON b.booking_id = p.booking_id
GROUP BY c.customer_id, c.customer_full_name
HAVING COUNT(DISTINCT b.room_id) >= 2 AND SUM(p.payment_amount) > 1000;
-- 11. (5 points) Get a list of rooms with a total payment amount of less than 1000 and booked by at least 3 customers, including room code, room type, room price and total payment amount.
SELECT r.room_id, r.room_type, r.room_price, SUM(p.payment_amount)
FROM Room r
         INNER JOIN Booking b ON r.room_id = b.room_id
         INNER JOIN Payment p ON b.booking_id = p.booking_id
GROUP BY r.room_id, r.room_type, r.room_price
HAVING SUM(p.payment_amount) < 1000 AND COUNT(DISTINCT b.customer_id) >= 3;
-- 12. (5 points) Get a list of customers with a total payment amount greater than 1000, including customer code, customer full name, item, room code, total payment amount.
SELECT c.customer_id, c.customer_full_name, r.room_id, SUM(p.payment_amount)
FROM Customer c
         INNER JOIN Booking b ON c.customer_id = b.customer_id
         INNER JOIN Room r ON b.room_id = r.room_id
         INNER JOIN Payment p ON b.booking_id = p.booking_id
GROUP BY c.customer_id, c.customer_full_name, r.room_id
HAVING SUM(p.payment_amount) > 1000;
-- 13. (6 points) Get a list of customers (Customer Code, Full Name, Email, Phone Number) whose full name contains the word "Minh" or address (address) in "Hanoi". Sort results by name in ascending order.
SELECT customer_id, customer_full_name, customer_email, customer_phone, customer_address
FROM Customer
WHERE customer_full_name ILIKE '%Minh%' OR customer_address ILIKE '%Hanoi%' -- LIKE is fine here too as we only have "Hanoi" and "Minh" in the data, but ILIKE is more flexible for case-insensitive search
ORDER BY customer_full_name;
-- 14. (4 points) Get a list of all rooms (Room code, Room type, Price), sorted by room price in descending order. Display 5 next rooms after the first 5 rooms (i.e., get the results of the 2nd page, knowing each page has 5 rooms).
SELECT room_id, room_type, room_price
FROM Room
ORDER BY room_price DESC
OFFSET 5 ROWS FETCH NEXT 5 ROWS ONLY; -- This will skip the first 5 rows
-- PART 3. Creating Views
-- 15. (5 points) Create a view to get information about booked rooms and customers, provided the check-in date is less than 2025-03-10. Need to display the following information: Room code, Room type, Customer code, customer name
CREATE VIEW Hotel.BookedRooms AS -- BookedRooms is the name of the view, and we will create it in the Hotel schema
SELECT r.room_id, r.room_type, c.customer_id, c.customer_full_name
FROM Room r
         INNER JOIN Booking b ON r.room_id = b.room_id
         INNER JOIN Customer c ON b.customer_id = c.customer_id
WHERE b.check_in_date < '2025-03-10';
-- 16. (5 points) Create a view to get customer information and booked rooms, provided the room area is larger than 30 m². Need to display the following information: Customer code, Customer name, Room code, Room area
-- Student's note: Assuming room_area is in square meters (m²) as mentioned in the question, we will create the view based on that assumption.
CREATE VIEW Hotel.LargeRooms AS -- LargeRooms is the name of the view, and we will create it in the Hotel schema
SELECT c.customer_id, c.customer_full_name, r.room_id, r.room_area
FROM Customer c
         JOIN Booking b ON c.customer_id = b.customer_id
         JOIN Room r ON b.room_id = r.room_id
WHERE r.room_area > 30;
-- PART 4: Creating Triggers
-- 17. (5 points) Create a check_insert_booking trigger to check each other's data when inserting into the Booking table. Check if the booking date is after the check-out date, then an error message that says "The booking date cannot be after the check-out date!" and cancel the operation of inserting data into the table.
CREATE FUNCTION check_insert_booking()
    RETURNS TRIGGER AS $$
BEGIN
    IF NEW.check_in_date > NEW.check_out_date THEN
        RAISE EXCEPTION 'The booking date cannot be after the check-out date!';
    END IF;
    RETURN NEW;
END;
$$
    LANGUAGE plpgsql; -- Choosing PL/pgSQL as the language for the trigger function
CREATE TRIGGER check_insert_booking
    BEFORE INSERT ON Booking
    FOR EACH ROW
EXECUTE FUNCTION check_insert_booking();
-- 18. (5 points) Create a trigger named update_room_status_on_booking to automatically update the room status to "Booked" when a room is booked (when a record is INSERT into the Booking table).
CREATE FUNCTION update_room_status_on_booking()
    RETURNS TRIGGER AS $$
BEGIN
    UPDATE Room
    SET room_status = 'Booked'
    WHERE room_id = NEW.room_id;
    RETURN NEW;
END;
$$
    LANGUAGE plpgsql;
CREATE TRIGGER update_room_status_on_booking
    AFTER INSERT ON Booking
    FOR EACH ROW
EXECUTE FUNCTION update_room_status_on_booking();
-- PART 5: Creating Store Procedure
-- 19. (5 points) Write a stored procedure named add_customer to add a new customer with all the necessary information.
CREATE FUNCTION add_customer(
    p_customer_id VARCHAR(5),
    p_customer_full_name VARCHAR(100),
    p_customer_email VARCHAR(100),
    p_customer_phone VARCHAR(15),
    p_customer_address VARCHAR(255)
)RETURNS VOID AS $$
BEGIN
    INSERT INTO Customer (customer_id, customer_full_name, customer_email, customer_phone, customer_address)
    VALUES (p_customer_id, p_customer_full_name, p_customer_email, p_customer_phone, p_customer_address);
END;
$$
    LANGUAGE plpgsql;
/*
    20. (5 points) Let's create a Stored Procedure named add_payment to add a new payment for a booking.
This procedure receives input parameters:
- p_booking_id: Booking code (booking_id).
- p_payment_method: Payment method (payment_method).
- p_payment_amount: Payment amount (payment_amount).
- p_payment_date: Payment date (payment_date).
*/
CREATE FUNCTION add_payment(
    p_booking_id INT,
    p_payment_method VARCHAR(50),
    p_payment_amount DECIMAL(10, 2),
    p_payment_date DATE
) RETURNS VOID AS $$
BEGIN
    INSERT INTO Payment (booking_id, payment_method, payment_amount, payment_date)
    VALUES (p_booking_id, p_payment_method, p_payment_amount, p_payment_date);
END;
$$
    LANGUAGE plpgsql;
-- Bonus points: clean code, full comments, beautiful presentation plus maximum 5 points.
-- Note: Points are only calculated when done correctly as required.
/*
Grading scale:
Sentence Content Point
Part 1. Working with data, 30 points
Part 2. Data query, 40 points
Part 3. Creating views, 10 points
Part 4. Creating triggers, 10 points
Part 5. Creating Store Procedure, 10 points
Total score: 100 points
*/