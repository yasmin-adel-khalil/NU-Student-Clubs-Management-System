-- Create CLUB table if not exists
CREATE TABLE IF NOT EXISTS club (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(500)
);

-- Create MEMBER table if not exists
CREATE TABLE IF NOT EXISTS member (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(100),
    committee VARCHAR(100),
    score INT,
    season VARCHAR(50),
    club_id BIGINT,
    FOREIGN KEY (club_id) REFERENCES club(id)
);

-- Create EVENT table if not exists
CREATE TABLE IF NOT EXISTS event (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    date VARCHAR(100),
    place VARCHAR(255),
    description VARCHAR(1000)
);
