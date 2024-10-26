CREATE TABLE User (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    personalInfo TEXT,
    -- Additional constraints if needed
    -- e.g., CHECK (length(password) >= 8) for a minimum password length
);

-- Create User_Roles Table for storing multiple roles for each user
CREATE TABLE User_Roles (
    user_id BIGINT,
    role VARCHAR(255),
    PRIMARY KEY (user_id, role),
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);

-- Create Order Table, which links to the User table
CREATE TABLE Order (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    total_amount DECIMAL(10, 2),
    status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Perfume (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    fragrance_notes VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    rating FLOAT,
    CONSTRAINT chk_price CHECK (price >= 0)
);

-- Schema for OrderItem Table
CREATE TABLE IF NOT EXISTS OrderItem (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    perfume_id BIGINT,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (perfume_id) REFERENCES Perfume(id) ON DELETE CASCADE
);

-- Schema for Review Table
CREATE TABLE IF NOT EXISTS Review (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    perfume_id BIGINT,
    user_id BIGINT NOT NULL,  -- Assuming a User table with user_id as the primary key
    rating FLOAT CHECK (rating >= 0 AND rating <= 5),
    comment TEXT,
    FOREIGN KEY (perfume_id) REFERENCES Perfume(id) ON DELETE CASCADE
);

-- Example of creating indexes to speed up searches on frequently queried columns
CREATE INDEX idx_perfume_brand ON Perfume (brand);
CREATE INDEX idx_perfume_price ON Perfume (price);
