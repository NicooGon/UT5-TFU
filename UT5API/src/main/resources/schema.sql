USE ut5dbv4;

CREATE TABLE IF NOT EXISTS artist
(
    artist_id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    name VARCHAR (255) NOT NULL,
    UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS album (
    album_id INT PRIMARY KEY AUTO_INCREMENT,
    album_name VARCHAR(255) NOT NULL,
    artist_id INT,
    CONSTRAINT fk_artist_id FOREIGN KEY (artist_id) REFERENCES artist(artist_id),
    UNIQUE(album_name, artist_id)
);

CREATE TABLE IF NOT EXISTS song (
    song_id INT PRIMARY KEY AUTO_INCREMENT,
    song_name VARCHAR(255) NOT NULL,
    artist_id INT,
    album_id INT,
    CONSTRAINT fk_song_artist_id FOREIGN KEY (artist_id) REFERENCES artist(artist_id),
    CONSTRAINT fk_song_album_id FOREIGN KEY (album_id) REFERENCES album(album_id),
    UNIQUE(song_name, album_id, artist_id)
);

CREATE TABLE IF NOT EXISTS users (
   user_id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(100) NOT NULL,
   email VARCHAR(100) UNIQUE NOT NULL,
   username VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS playlist (
   playlist_id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(100) NOT NULL,
   user_id INT,
   CONSTRAINT fk_playlist_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);