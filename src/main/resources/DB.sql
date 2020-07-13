Create table "CAR"(
    ID int,
    MODEL text,
    MAX_SPEED int,
    ENG_POWER int,
    TIME_TO_100 double,
    WEIGHT int,
    CONSTRAINT "ID" PRIMARY KEY (ID)
);
INSERT INTO CAR VALUES ( 1, 'Reno', 220, 300,3.7, 899 );
