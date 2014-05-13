create table Marque (
    Marque_Id int8 not null,
    Marque_Nom varchar(30),
    primary key (Marque_Id)
);

create table Client (
    Client_Id int8 not null,
    Client_Nom varchar(30),
    Client_Prenom varchar(30),
    primary key (Client_Id)
);

create table Modele (
    Modele_Id int8 not null,
    Modele_MarqueId int8,
    Modele_ClientId int8,
    Modele_Nom varchar(50),
    Modele_PrixCatalogue float8,
    primary key (Modele_Id)
);

create table Guitare (
    Guitare_Id int8 not null,
    Guitare_ModeleId int8,
    primary key (Guitare_Id)
);

CREATE SEQUENCE musicmanager_id_seq;

ALTER TABLE client
ALTER COLUMN client_id
SET DEFAULT nextval('musicmanager_id_seq');

ALTER TABLE guitare
ALTER COLUMN guitare_id
SET DEFAULT nextval('musicmanager_id_seq');

ALTER TABLE modele
ALTER COLUMN modele_id
SET DEFAULT nextval('musicmanager_id_seq');

ALTER TABLE marque
ALTER COLUMN marque_id
SET DEFAULT nextval('musicmanager_id_seq');