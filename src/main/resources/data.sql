-- Insert clubs
INSERT INTO club (id, name, description) VALUES (1, 'Computer Science Club', 'Club for CS enthusiasts');
INSERT INTO club (id, name, description) VALUES (2, 'Debate Club', 'Public speaking and debate');
INSERT INTO club (id, name, description) VALUES (3, 'Photography Club', 'Photography and visual arts');
INSERT INTO club (id, name, description) VALUES (4, 'Music Club', 'Music and performing arts');

-- Insert members for Computer Science Club
INSERT INTO member (id, name, role, score, club_id) VALUES (1, 'Ahmed Hassan', 'President', 95, 1);
INSERT INTO member (id, name, role, score, club_id) VALUES (2, 'Fatima Ali', 'Vice President', 92, 1);
INSERT INTO member (id, name, role, score, club_id) VALUES (3, 'Omar Mohamed', 'Treasurer', 88, 1);
INSERT INTO member (id, name, role, score, club_id) VALUES (4, 'Noor Khalid', 'Secretary', 85, 1);
INSERT INTO member (id, name, role, score, club_id) VALUES (5, 'Sara Ibrahim', 'Member', 80, 1);

-- Insert members for Debate Club
INSERT INTO member (id, name, role, score, club_id) VALUES (6, 'Mariam Rashid', 'President', 93, 2);
INSERT INTO member (id, name, role, score, club_id) VALUES (7, 'Hassan Karim', 'Vice President', 90, 2);
INSERT INTO member (id, name, role, score, club_id) VALUES (8, 'Layla Noor', 'Member', 87, 2);
INSERT INTO member (id, name, role, score, club_id) VALUES (9, 'Zainab Mustafa', 'Member', 84, 2);

-- Insert members for Photography Club
INSERT INTO member (id, name, role, score, club_id) VALUES (10, 'Karim Saeed', 'President', 91, 3);
INSERT INTO member (id, name, role, score, club_id) VALUES (11, 'Hana Waleed', 'Vice President', 89, 3);
INSERT INTO member (id, name, role, score, club_id) VALUES (12, 'Rania Hassan', 'Member', 86, 3);

-- Insert members for Music Club
INSERT INTO member (id, name, role, score, club_id) VALUES (13, 'Amira Saleh', 'President', 94, 4);
INSERT INTO member (id, name, role, score, club_id) VALUES (14, 'Youssef Adel', 'Vice President', 91, 4);
INSERT INTO member (id, name, role, score, club_id) VALUES (15, 'Dina Mansour', 'Member', 82, 4);
INSERT INTO member (id, name, role, score, club_id) VALUES (16, 'Tarek Jamal', 'Member', 79, 4);
