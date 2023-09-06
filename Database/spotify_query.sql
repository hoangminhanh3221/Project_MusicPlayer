CREATE DATABASE spotify;

USE spotify;

CREATE TABLE spotify.account (
    AccountId VARCHAR(20) PRIMARY KEY,
    Email VARCHAR(50) NOT NULL UNIQUE,
    Password VARCHAR(50) NOT NULL
);

CREATE TABLE spotify.role (
    RoleId VARCHAR(10) PRIMARY KEY,
    RoleName VARCHAR(50) NOT NULL
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
    Gender BIT NOT NULL,
    DOB DATE NOT NULL,
    Country VARCHAR(50) NOT NULL,
    UserImage VARCHAR(50) NOT NULL,
    AccountId VARCHAR(20) NOT NULL,
    FOREIGN KEY (AccountId) REFERENCES account(AccountId)
);


CREATE TABLE spotify.artist (
    ArtistId INT AUTO_INCREMENT PRIMARY KEY,
    ArtistName VARCHAR(50) NOT NULL,
    Genre VARCHAR(50) NOT NULL,
    MonthlyListener BIGINT NOT NULL,
    Follower BIGINT NOT NULL,
    Gender BIT NOT NULL,
    ArtistImage VARCHAR(50) NOT NULL,
    IsDeleted BIT NOT NULL
);

CREATE TABLE spotify.album (
    AlbumId INT AUTO_INCREMENT PRIMARY KEY,
    AlbumName VARCHAR(50) NOT NULL,
    AlbumTitle VARCHAR(255) NOT NULL,
    ReleaseDate DATETIME NOT NULL,
    Genre VARCHAR(50) NOT NULL,
    AlbumImage VARCHAR(50) NOT NULL,
    IsDeleted BIT NOT NULL,
    ArtistId INT NOT NULL,
    FOREIGN KEY (ArtistId) REFERENCES artist(ArtistId)
);

CREATE TABLE spotify.song (
    SongId INT AUTO_INCREMENT PRIMARY KEY,
    SongName VARCHAR(50) NOT NULL,
    DurationSeconds INT NOT NULL,
    Path VARCHAR(50) NOT NULL,
    IsDeleted BIT NOT NULL,
    AlbumId INT NOT NULL,
    ArtistId INT NOT NULL,
    FOREIGN KEY (AlbumId) REFERENCES album(AlbumId),
    FOREIGN KEY (ArtistId) REFERENCES artist(ArtistId)
);

CREATE TABLE spotify.playlist (
    PlaylistId INT AUTO_INCREMENT PRIMARY KEY,
    PlaylistName VARCHAR(50) NOT NULL,
    Description VARCHAR(255) NOT NULL,
    PlaylistImage VARCHAR(50) NOT NULL,
    IsPublic BIT NOT NULL
);

CREATE TABLE spotify.playlist_user (
    PlaylistUserId INT AUTO_INCREMENT PRIMARY KEY,
    CreateDate DATETIME NOT NULL,
    PlaylistId INT NOT NULL,
    UserId INT NOT NULL,
    FOREIGN KEY (UserId) REFERENCES user(UserId),
    FOREIGN KEY (PlaylistId) REFERENCES Playlist(PlaylistId)
);

CREATE TABLE spotify.playlist_song (
    PlaylistSongId INT AUTO_INCREMENT PRIMARY KEY,
    CreateDate DATETIME NOT NULL,
    PlaylistId INT NOT NULL,
    SongId INT NOT NULL,
    FOREIGN KEY (SongId) REFERENCES song(SongId),
    FOREIGN KEY (PlaylistId) REFERENCES Playlist(PlaylistId)
);

CREATE TABLE spotify.history (
    HistoryId INT AUTO_INCREMENT PRIMARY KEY,
    DatetimeListened DATETIME NOT NULL,
    UserId INT NOT NULL,
    SongId INT NOT NULL,
    FOREIGN KEY (UserId) REFERENCES user(UserId),
    FOREIGN KEY (SongId) REFERENCES song(SongId)
);

CREATE TABLE spotify.favorite (
    FavoriteId INT AUTO_INCREMENT PRIMARY KEY,
    DatetimeFavorite DATETIME NOT NULL,
    UserId INT NOT NULL,
    SongId INT NOT NULL,
    FOREIGN KEY (UserId) REFERENCES user(UserId),
    FOREIGN KEY (SongId) REFERENCES song(SongId)
);

CREATE TABLE spotify.follower (
    FollowerId INT AUTO_INCREMENT PRIMARY KEY,
    DatetimeFollow DATETIME NOT NULL,
    UserId INT NOT NULL,
    ArtistId INT NOT NULL,
    FOREIGN KEY (UserId) REFERENCES user(UserId),
    FOREIGN KEY (ArtistId) REFERENCES artist(ArtistId)
);
