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

INSERT INTO spotify.account (AccountId, Email, Password)
VALUES ('anh', 'hoangminhanh3221@gmail.com', '12345'),
('minh', 'hma3221.ah@email.com', '12345'),
('meomeo', 'meomeo@email.com', '12345'),
('gaugau', 'gaugau@email.com', '12345'),
('hoang', 'hma0302.ah@email.com', '12345');

INSERT INTO spotify.role (RoleId, RoleName)
VALUES ('R01', 'Normal'),
('R02', 'Premium'),
('R03', 'Artist'),
('R04', 'Admin'),
('R05', 'Editor');

INSERT INTO spotify.authority (AccountId, RoleId)
VALUES ('anh', 'R04'),
('minh', 'R05'),
('hoang', 'R01'),
('meomeo', 'R01'),
('meomeo', 'R02'),
('gaugau', 'R01'),
('gaugau', 'R02'),
('gaugau', 'R03');

INSERT INTO spotify.user (UserName, Gender, DOB, Country, UserImage, AccountId)
VALUES ('Nguyễn Thị Mèo', 1, '2001-01-01', 'Việt Nam', 'user1.jpg', 'meomeo'),
('Lê Thị Chó', 1, '2000-03-15', 'Việt Nam', 'user2.jpg', 'gaugau'),
('Hoàng Minh Ảnh', 0, '2001-02-03', 'Việt Nam', 'user3.jpg', 'hoang');

INSERT INTO spotify.artist (ArtistName, Genre, MonthlyListener, Follower, Gender, ArtistImage, IsDeleted)
VALUES ('Taylor Swift', 'Pop, Rap, EDM', 0, 0, 1, 'artist1.jpg', 0),
('Rihanna', 'Pop, Rap, EDM', 0, 0, 1, 'artist2.jpg', 0),
('The Weekend', 'Pop, Rap, EDM', 0, 0, 0, 'artist3.jpg', 0),
('Justin Bieber', 'Pop, Rap, EDM', 0, 0, 0, 'artist4.jpg', 0);

INSERT INTO spotify.album (AlbumName, AlbumImage, AlbumTitle, Genre, IsDeleted, ReleaseDate, ArtistId)
VALUES ('Fearless', 'album1.jpg', 'Album mới phát hành','Country, Pop', 0, '2008-11-11T00:00:00', 1),
('Speak Now', 'album2.jpg', 'Album mới phát hành','Country, Pop', 0, '2008-11-11T00:00:00', 1),
('Red', 'album3.jpg', 'Album mới phát hành','Country, Pop', 0, '2012-10-22T00:00:00', 1),
('1989', 'album4.jpg', 'Album mới phát hành','Pop', 0, '2014-10-27T00:00:00', 1),
('Reputation', 'album5.jpg', 'Album mới phát hành','Pop', 0, '2017-11-10T00:00:00', 1),
('Lover', 'album6.jpg', 'Album mới phát hành','Pop', 0, '2019-08-23T00:00:00', 1),
('Folklore', 'album7.jpg', 'Album mới phát hành','Indie Folk, Alternative', 0, '2020-07-24T00:00:00', 1),
('Evermore', 'album8.jpg', 'Album mới phát hành','Indie Folk, Alternative', 0, '2020-12-11T00:00:00', 1),
('Fearless (Taylor''s Version)', 'album9.jpg', 'Album mới phát hành','Country, Pop', 0, '2021-04-09T00:00:00', 1),
('Music of the Sun', 'album10.jpg', 'Album mới phát hành','R&B, Pop, Reggae', 0, '2021-04-09T00:00:00', 1),
('A Girl Like Me', 'album11.jpg', 'Album mới phát hành','R&B, Pop, Reggae', 0, '2021-04-09T00:00:00', 1),
('Good Girl Gone Bad', 'album12.jpg', 'Album mới phát hành','R&B, Pop, Dance-Pop', 0, '2021-04-09T00:00:00', 1),
('Rated R', 'album13.jpg', 'Album mới phát hành','R&B, Pop, Hip-Hop', 0, '2021-04-09T00:00:00', 1);

INSERT INTO spotify.song (SongName, SongImage, Path, DurationSeconds, IsDeleted, AlbumId, ArtistId)
VALUES ('Fearless (Taylor''s Version)', 'song1.jpg', 'song1.mp3', 240, 0, 9, 1),
('Love Story (Taylor''s Version)', 'song2.jpg', 'song2.mp3', 210, 0, 9, 1),
('White Horse (Taylor''s Version)', 'song3.jpg', 'song3.mp3', 230, 0, 9, 1),
('Consideration', 'song4.jpg', 'song4.mp3', 180, 0, 10, 2),
('Kiss It Better', 'song5.jpg', 'song5.mp3', 220, 0, 10, 2),
('Work', 'song6.jpg', 'song6.mp3', 200, 0, 11, 2);

INSERT INTO spotify.playlist (Description, IsPublic, PlaylistImage, PlaylistName)
VALUES ('Nhạc trẻ hay nhất', 0, 'playlist1.jpg', 'Nhạc Việt 2023'),
('Nhạc US-UK', 0, 'playlist2.jpg', 'Nhạc US-UK 2023');


INSERT INTO spotify.favorite (DatetimeFavorite, SongId, UserId)
VALUES ('2023-09-01T00:00:00', 1, 1),
('2023-09-01T00:00:00', 3, 1),
('2023-09-01T00:00:00', 4, 1),
('2023-09-01T00:00:00', 6, 1),
('2023-09-01T00:00:00', 2, 2),
('2023-09-01T00:00:00', 3, 2),
('2023-09-02T00:00:00', 5, 2),
('2023-09-02T00:00:00', 6, 2),
('2023-09-02T00:00:00', 1, 3);

INSERT INTO spotify.follower (DatetimeFollow, ArtistId, UserId)
VALUES ('2023-09-01T00:00:00', 1, 1),
('2023-09-01T00:00:00', 2, 1),
('2023-09-01T00:00:00', 3, 1),
('2023-09-01T00:00:00', 1, 2),
('2023-09-01T00:00:00', 4, 2);

INSERT INTO spotify.history (DatetimeListened, SongId, UserId)
VALUES ('2023-09-01T00:00:00', 1, 1),
('2023-09-01T00:00:00', 2, 1),
('2023-09-01T00:00:00', 3, 1),
('2023-09-01T00:00:00', 1, 2),
('2023-09-01T00:00:00', 4, 2);

INSERT INTO spotify.playlist_song (CreateDate, PlaylistId, SongId)
VALUES ('2023-09-01T00:00:00', 1, 1),
('2023-09-01T00:00:00', 1, 2),
('2023-09-01T00:00:00', 1, 3),
('2023-09-01T00:00:00', 1, 6),
('2023-09-01T00:00:00', 2, 1),
('2023-09-01T00:00:00', 2, 2);

INSERT INTO spotify.playlist_user (CreateDate, PlaylistId, UserId)
VALUES ('2023-09-01T00:00:00', 1, 1),
('2023-09-01T00:00:00', 2, 2);
