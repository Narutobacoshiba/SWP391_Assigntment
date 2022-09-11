CREATE TABLE UserAccount(
username NVARCHAR(100) PRIMARY KEY,
[password] NVARCHAR(100),
[dob] NVARCHAR(100),
[address] NVARCHAR(200)
)

INSERT INTO UserAccount(username, [password], [dob], [address])
VALUES
('hadt','12345678','19/09/1991','dai hoc FPT, Hoa Lac, Ha Noi')