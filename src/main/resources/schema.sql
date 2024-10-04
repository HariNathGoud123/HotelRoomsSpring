CREATE TABLE hotel (
    hotelid INT AUTO_INCREMENT PRIMARY KEY,
    hotelname VARCHAR(100) NOT NULL,
    location VARCHAR(100),
    rating INT
);


CREATE TABLE IF NOT EXISTS room (
    roomid INT AUTO_INCREMENT PRIMARY KEY,
    roomnumber VARCHAR(100) NOT NULL,
    type VARCHAR(50),
    price DECIMAL(10, 2),
    hotelid INT,
    FOREIGN KEY (hotelid) REFERENCES hotel(hotelid)
);