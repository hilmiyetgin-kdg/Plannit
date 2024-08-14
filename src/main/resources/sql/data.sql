INSERT INTO PROFILE (USERNAME, EMAIL, FIRST_NAME, LAST_NAME, PHONE_NUMBER) VALUES
   ('johndoe', 'johndoe@example.com', 'John', 'Doe', '123-456-7890'),
   ('janedoe', 'janedoe@example.com', 'Jane', 'Doe', '098-765-4321'),
   ('alice', 'alice@example.com', 'Alice', 'Smith', '555-123-4567'),
   ('bobmartin', 'bobmartin@example.com', 'Bob', 'Martin', '555-234-5678'),
   ('carolking', 'carolking@example.com', 'Carol', 'King', '555-345-6789'),
   ('davidsmith', 'davidsmith@example.com', 'David', 'Smith', '555-456-7890'),
   ('emilyjones', 'emilyjones@example.com', 'Emily', 'Jones', '555-567-8901'),
   ('frankwilliams', 'frankwilliams@example.com', 'Frank', 'Williams', '555-678-9012'),
   ('gracemiller', 'gracemiller@example.com', 'Grace', 'Miller', '555-789-0123'),
   ('henrywilson', 'henrywilson@example.com', 'Henry', 'Wilson', '555-890-1234'),
   ('ireneclark', 'ireneclark@example.com', 'Irene', 'Clark', '555-901-2345'),
   ('jameslee', 'jameslee@example.com', 'James', 'Lee', '555-012-3456'),
   ('karenyoung', 'karenyoung@example.com', 'Karen', 'Young', '555-123-4560'),
   ('larrywalker', 'larrywalker@example.com', 'Larry', 'Walker', '555-234-5670'),
   ('monicahall', 'monicahall@example.com', 'Monica', 'Hall', '555-345-6780'),
   ('nathanwright', 'nathanwright@example.com', 'Nathan', 'Wright', '555-456-7891'),
   ('oliviaallen', 'oliviaallen@example.com', 'Olivia', 'Allen', '555-567-8902'),
   ('paulking', 'paulking@example.com', 'Paul', 'King', '555-678-9013'),
   ('quinncarter', 'quinncarter@example.com', 'Quinn', 'Carter', '555-789-0124'),
   ('rebeccaparker', 'rebeccaparker@example.com', 'Rebecca', 'Parker', '555-890-1235');


INSERT INTO event (title, description, location, start_date, end_date, organizer_id)
VALUES
    ('Summer Music Festival', 'Annual outdoor music festival featuring local bands', 'Central Park', '2024-07-15 14:00:00', '2024-07-15 22:00:00', 1),
    ('Tech Conference 2024', 'Exploring the latest trends in AI and machine learning', 'Convention Center', '2024-09-10 09:00:00', '2024-09-12 17:00:00', 2),
    ('Community Cleanup Day', 'Join us in cleaning up our local beaches', 'Sunny Beach', '2024-05-22 08:00:00', '2024-05-22 12:00:00', 3),
    ('Art Exhibition Opening', 'Featuring works from emerging local artists', 'Downtown Gallery', '2024-08-05 18:00:00', '2024-08-05 21:00:00', 1),
    ('Charity Run for Education', '5K run to raise funds for local schools', 'City Park', '2024-10-01 07:00:00', '2024-10-01 11:00:00', 2),
    ('Cooking Workshop: Italian Cuisine', 'Learn to cook authentic Italian dishes', 'Culinary Institute', '2024-06-18 17:00:00', '2024-06-18 20:00:00', 3),
    ('Book Club Meeting: Sci-Fi Novels', 'Discussing classic and contemporary science fiction', 'Public Library', '2024-07-28 19:00:00', '2024-07-28 21:00:00', 1),
    ('Yoga in the Park', 'Free yoga session for all skill levels', 'Riverside Park', '2024-08-12 07:00:00', '2024-08-12 08:30:00', 2),
    ('Local Business Networking Event', 'Connect with other entrepreneurs in your area', 'Chamber of Commerce', '2024-09-05 18:00:00', '2024-09-05 20:00:00', 3),
    ('Halloween Costume Party', 'Annual spooky celebration with prizes for best costumes', 'Community Center', '2024-10-31 20:00:00', '2024-11-01 01:00:00', 1);

INSERT INTO user_event (profile_id, event_id, rsvp_status, timestamp)
VALUES
    (1, 1, 'ATTENDING', '2024-05-01 10:00:00'),
    (2, 2, 'ATTENDING', '2024-06-15 14:30:00'),
    (3, 3, 'ATTENDING', '2024-04-10 09:45:00'),
    (1, 4, 'ATTENDING', '2024-07-01 16:20:00'),
    (2, 5, 'ATTENDING', '2024-08-20 11:15:00'),
    (3, 6, 'ATTENDING', '2024-05-25 13:40:00'),
    (1, 7, 'ATTENDING', '2024-06-30 18:50:00'),
    (2, 8, 'ATTENDING', '2024-07-15 08:30:00'),
    (3, 9, 'ATTENDING', '2024-08-01 17:00:00'),
    (1, 10, 'ATTENDING', '2024-09-15 19:25:00');

INSERT INTO user_event (profile_id, event_id, rsvp_status, timestamp)
VALUES
    (2, 1, 'ATTENDING', '2024-05-02 11:30:00'),
    (3, 1, 'MAYBE', '2024-05-03 14:45:00'),
    (1, 2, 'ATTENDING', '2024-06-16 10:00:00'),
    (3, 2, 'NOT_ATTENDING', '2024-06-17 09:15:00'),
    (1, 3, 'ATTENDING', '2024-04-11 16:30:00'),
    (2, 3, 'MAYBE', '2024-04-12 12:00:00'),
    (2, 4, 'ATTENDING', '2024-07-02 18:45:00'),
    (3, 4, 'ATTENDING', '2024-07-03 10:30:00'),
    (1, 5, 'MAYBE', '2024-08-21 15:20:00'),
    (3, 5, 'ATTENDING', '2024-08-22 11:00:00');