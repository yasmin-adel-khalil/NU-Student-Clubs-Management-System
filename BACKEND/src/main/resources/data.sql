-- Insert IEEE NU Branch club
INSERT INTO club (name, description) VALUES ('IEEE NU Branch', 'IEEE student branch at NU - multiple committees');

-- Insert members for IEEE NU Branch
-- PR Committee: 1 mid-season best + 1 end-season best
INSERT INTO member (name, role, committee, score, season, club_id) VALUES ('Salma Nasser', 'Best Mid', 'PR', 96, 'MID', 1);
INSERT INTO member (name, role, committee, score, season, club_id) VALUES ('Yara Fathy', 'Best End', 'PR', 94, 'END', 1);

-- HR Committee: 1 mid-season best + 1 end-season best
INSERT INTO member (name, role, committee, score, season, club_id) VALUES ('Mohamed Sami', 'Best Mid', 'HR', 95, 'MID', 1);
INSERT INTO member (name, role, committee, score, season, club_id) VALUES ('Noha Adel', 'Best End', 'HR', 93, 'END', 1);

-- Operations Committee: 1 mid-season best + 1 end-season best
INSERT INTO member (name, role, committee, score, season, club_id) VALUES ('Khaled Omar', 'Best Mid', 'Operations', 97, 'MID', 1);
INSERT INTO member (name, role, committee, score, season, club_id) VALUES ('Lina Samir', 'Best End', 'Operations', 92, 'END', 1);

-- Marketing Committee: 1 mid-season best + 1 end-season best
INSERT INTO member (name, role, committee, score, season, club_id) VALUES ('Omar Saad', 'Best Mid', 'Marketing', 94, 'MID', 1);
INSERT INTO member (name, role, committee, score, season, club_id) VALUES ('Mona Elshamy', 'Best End', 'Marketing', 90, 'END', 1);

-- Media Committee: 1 mid-season best + 1 end-season best
INSERT INTO member (name, role, committee, score, season, club_id) VALUES ('Ibrahim Hany', 'Best Mid', 'Media', 95, 'MID', 1);
INSERT INTO member (name, role, committee, score, season, club_id) VALUES ('Dalia Mostafa', 'Best End', 'Media', 91, 'END', 1);

-- Insert a sample event
INSERT INTO event (name, date, place, description) VALUES (
	'NU club festival - FALL 25',
	'25-26 November 2025',
	'Tarek Khalil Garden',
	'Discover NU''s vibrant community at the Semester Club Festival! All student clubs will be there, giving you the chance to explore their activities, learn how to join, and enjoy fun games and challenges for a chance to win great prizes. It''s the perfect opportunity to find your place and get involved!'
);
