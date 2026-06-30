/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

START BATCH DDL;

CREATE TABLE Singers (
    SingerId   BIGINT PRIMARY KEY,
    FirstName  VARCHAR(1024),
    LastName   VARCHAR(1024),
    SingerInfo BYTEA,
    BirthDate  DATE
);

CREATE INDEX SingersByFirstLastName ON Singers(FirstName, LastName);

CREATE VIEW SingersView SQL SECURITY INVOKER AS
SELECT s.SingerId AS SingerId, s.FirstName AS FirstName, s.LastName AS LastName
FROM Singers s
ORDER BY s.LastName, s.FirstName;

CREATE TABLE Albums (
    SingerId  BIGINT NOT NULL,
    AlbumId   BIGINT NOT NULL,
    AlbumTitle VARCHAR,
    MarketingBudget BIGINT,
    PRIMARY KEY(SingerId, AlbumId),
    FOREIGN KEY(SingerId) REFERENCES Singers(SingerID)
);

CREATE INDEX AlbumsByAlbumTitle ON Albums(AlbumTitle);

CREATE TABLE Songs (
    SingerId  BIGINT NOT NULL,
    AlbumId   BIGINT NOT NULL,
    TrackId   BIGINT NOT NULL,
    SongName  VARCHAR,
    Duration  BIGINT,
    SongGenre VARCHAR(25),
    PRIMARY KEY(SingerId, AlbumId, TrackId),
    FOREIGN KEY(SingerId, AlbumId) REFERENCES Albums(SingerId, AlbumId)
);

CREATE UNIQUE INDEX SongsBySingerAlbumSongNameDesc ON Songs(SingerId, AlbumId, SongName DESC);

CREATE INDEX SongsBySongName ON Songs(SongName);

CREATE TABLE Concerts (
    VenueId      BIGINT NOT NULL,
    SingerId     BIGINT NOT NULL,
    ConcertDate  DATE   NOT NULL,
    BeginTime    TIMESTAMPTZ,
    EndTime      TIMESTAMPTZ,
    TicketPrices BIGINT[],
    PRIMARY KEY(VenueId, SingerId, ConcertDate),
    FOREIGN KEY(SingerId) REFERENCES Singers(SingerId)
);

CREATE TABLE TableWithAllColumnTypes (
    ColInt64     BIGINT PRIMARY KEY,
    ColFloat64   FLOAT8 NOT NULL,
    ColFloat32   FLOAT4 NOT NULL,
    ColBool      BOOL NOT NULL,
    ColString    VARCHAR(100) NOT NULL,
    ColStringMax TEXT,
    ColBytes     BYTEA NOT NULL,
    ColDate      DATE NOT NULL,
    ColTimestamp TIMESTAMP WITH TIME ZONE,
    ColNumeric   NUMERIC NOT NULL,
    ColJson      VARCHAR NOT NULL
);
CREATE TABLE all_nullable_types (
    ColInt64	    bigint primary key,
    ColFloat64	    float8,
    ColFloat32	    float4,
    ColBool		    boolean,
    ColString		varchar(100),
    ColBytes		bytea,
    ColDate		    date,
    ColTimestamp	timestamptz,
    ColNumeric	    numeric,
    ColJson		    jsonb,

    ColInt64Array		bigint[],
    ColFloat64Array     float8[],
    ColFloat32Array     float4[],
    ColBoolArray		boolean[],
    ColStringArray	    varchar(100)[],
    ColBytesArray		bytea[],
    ColDateArray		date[],
    ColTimestampArray	timestamptz[],
    ColNumericArray	    numeric[],
    ColJsonArray		jsonb[]
);

CREATE TABLE TableWithRef (
    Id          BIGINT NOT NULL PRIMARY KEY,
    RefFloat    FLOAT8 NOT NULL,
    RefString   VARCHAR(100) NOT NULL,
    CONSTRAINT Fk_TableWithRef_TableWithAllColumnTypes
        FOREIGN KEY (RefFloat, RefString)
        REFERENCES TableWithAllColumnTypes (ColFloat64, ColString)
);

RUN BATCH;
