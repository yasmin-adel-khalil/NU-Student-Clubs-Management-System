-- Create CLUB table if not exists
CREATE TABLE IF NOT EXISTS club (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(500)
);

-- Create MEMBER table if not exists
CREATE TABLE IF NOT EXISTS member (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(100),
    score INT,
    club_id BIGINT,
    FOREIGN KEY (club_id) REFERENCES club(id)
);
