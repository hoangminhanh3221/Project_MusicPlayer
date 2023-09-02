CREATE DATABASE spotify;

USE spotify;

CREATE TABLE spotify.account (
    AccountId VARCHAR(20) PRIMARY KEY,
    Email VARCHAR(50) NOT NULL UNIQUE,
    Password VARCHAR(50) NOT NULL,
    IsDeleted BOOLEAN NOT NULL
);

CREATE TABLE spotify.role (
    RoleId VARCHAR(10) PRIMARY KEY,
    RoleName VARCHAR(50) not null,
    IsDeleted BOOLEAN NOT NULL
);

CREATE TABLE spotify.authority (
    AuthorityId INT AUTO_INCREMENT PRIMARY KEY,
    AccountId VARCHAR(20) NOT NULL ,
    RoleId VARCHAR(10) NOT NULL,
    FOREIGN KEY (AccountId) REFERENCES account(AccountId),
    FOREIGN KEY (RoleId) REFERENCES role(RoleId)
);

CREATE TABLE spotify.user (
    UserId INT AUTO_INCREMENT PRIMARY KEY,
    UserName VARCHAR(50) NOT NULL,
    Gender BOOLEAN NOT NULL,
    DOB DATE NOT NULL,
    Country VARCHAR(50) NOT NULL,
    UserImage VARCHAR(50) NOT NULL,
    AccountId VARCHAR(50) NOT NULL,
    FOREIGN KEY (AccountId) REFERENCES account(AccountId)
);

CREATE TABLE spotify.artist (
    ArtistId INT AUTO_INCREMENT PRIMARY KEY,
    ArtistName VARCHAR(50) NOT NULL,
    Genre VARCHAR(50) NOT NULL,
    MonthlyListener BIGINT NOT NULL,
    Follower BIGINT NOT NULL,
    Gender BOOLEAN NOT NULL,
    ArtistImage VARCHAR(50) NOT NULL
);

CREATE TABLE spotify.album (
    AlbumId INT AUTO_INCREMENT PRIMARY KEY,
    AlbumName VARCHAR(50) NOT NULL,
    AlbumTitle VARCHAR(255) NOT NULL,
    ReleaseDate DATE NOT NULL,
    Genre VARCHAR(50) NOT NULL,
    AlbumImage VARCHAR(50) NOT NULL,
    ArtistId INT NOT NULL,
    FOREIGN KEY (ArtistId) REFERENCES artist(ArtistId)
);

CREATE TABLE spotify.song (
    SongId INT AUTO_INCREMENT PRIMARY KEY,
    SongName VARCHAR(50) NOT NULL,
    DurationSeconds INT NOT NULL,
    Path VARCHAR(50) NOT NULL,
    AlbumId INT NOT NULL,
    ArtistId INT NOT NULL,
    FOREIGN KEY (AlbumId) REFERENCES album(AlbumId),
    FOREIGN KEY (ArtistId) REFERENCES artist(ArtistId)
);

CREATE TABLE spotify.playist (
    PlayistId INT AUTO_INCREMENT PRIMARY KEY,
    PlayistName VARCHAR(50) NOT NULL,
    Description VARCHAR(255) NOT NULL,
    PlayistImage VARCHAR(50) NOT NULL,
    IsPublic BOOLEAN NOT NULL,
    IsDeleted BOOLEAN NOT NULL,
    UserId INT NOT NULL,
    FOREIGN KEY (UserId) REFERENCES user(UserId)
);

CREATE TABLE spotify.playist_user (
    PlayistUserId INT AUTO_INCREMENT PRIMARY KEY,
    PlayistId INT NOT NULL,
    UserId INT NOT NULL,
    CreateDate DATETIME NOT NULL,
    FOREIGN KEY (UserId) REFERENCES user(UserId),
    FOREIGN KEY (PlayistId) REFERENCES playist(PlayistId)
);

CREATE TABLE spotify.playlist_song (
    PlayistSongId INT AUTO_INCREMENT PRIMARY KEY,
    PlayistId INT NOT NULL,
    SongId INT NOT NULL,
    CreateDate DATETIME NOT NULL,
    FOREIGN KEY (SongId) REFERENCES song(SongId),
    FOREIGN KEY (PlayistId) REFERENCES playist(PlayistId)
);

CREATE TABLE spotify.history (
    HistoryId INT AUTO_INCREMENT PRIMARY KEY,
    UserId INT NOT NULL,
    SongId INT NOT NULL,
    DatetimeListened DATETIME NOT NULL,
    FOREIGN KEY (UserId) REFERENCES user(UserId),
    FOREIGN KEY (SongId) REFERENCES song(SongId)
);

CREATE TABLE spotify.like (
    LikeId INT AUTO_INCREMENT PRIMARY KEY,
    UserId INT NOT NULL,
    SongId INT NOT NULL,
    DatetimeLike DATETIME NOT NULL,
    FOREIGN KEY (UserId) REFERENCES user(UserId),
    FOREIGN KEY (SongId) REFERENCES song(SongId)
);

CREATE TABLE spotify.follower (
    FollowerId INT AUTO_INCREMENT PRIMARY KEY,
    UserId INT NOT NULL,
    ArtistId INT NOT NULL,
    DatetimeFollow DATETIME NOT NULL,
    FOREIGN KEY (UserId) REFERENCES user(UserId),
    FOREIGN KEY (ArtistId) REFERENCES artist(ArtistId)
);
