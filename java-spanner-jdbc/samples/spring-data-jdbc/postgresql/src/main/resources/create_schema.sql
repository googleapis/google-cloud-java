/*
 This script creates the database schema for this sample application.
 All lines that start with /* skip_on_open_source_pg */ are skipped when the application is running on a
 normal PostgreSQL database. The same lines are executed when the application is running on a Cloud
 Spanner database. The script is executed by the DatabaseSeeder class.
*/

create sequence if not exists id_generator
/* skip_on_open_source_pg */ bit_reversed_positive
;
    
create table if not exists singers (
    id         bigint not null primary key default nextval('id_generator'),
    first_name varchar,
    last_name  varchar,
    full_name  varchar generated always as (CASE WHEN first_name IS NULL THEN last_name
                                                 WHEN last_name  IS NULL THEN first_name
                                                 ELSE first_name || ' ' || last_name END) stored,
    active     boolean default true,
    created_at timestamptz default current_timestamp,
    updated_at timestamptz default current_timestamp
);

create table if not exists albums (
    id               bigint not null primary key default nextval('id_generator'),
    title            varchar not null,
    marketing_budget numeric,
    release_date     date,
    cover_picture    bytea,
    singer_id        bigint not null,
    created_at timestamptz default current_timestamp,
    updated_at timestamptz default current_timestamp,
    constraint fk_albums_singers foreign key (singer_id) references singers (id)
);

create table if not exists tracks (
    id           bigint not null,
    track_number bigint not null,
    title        varchar not null,
    sample_rate  float8 not null,
    created_at timestamptz default current_timestamp,
    updated_at timestamptz default current_timestamp,
    primary key (id, track_number)
)
/* skip_on_open_source_pg */ interleave in parent albums on delete cascade
;

create table if not exists venues (
    id          bigint not null primary key default nextval('id_generator'),
    name        varchar not null,
    description jsonb not null,
    created_at timestamptz default current_timestamp,
    updated_at timestamptz default current_timestamp
);

create table if not exists concerts (
    id          bigint not null primary key default nextval('id_generator'),
    venue_id    bigint not null,
    singer_id   bigint not null,
    name        varchar not null,
    start_time  timestamptz not null,
    end_time    timestamptz not null,
    created_at timestamptz default current_timestamp,
    updated_at timestamptz default current_timestamp,
    constraint fk_concerts_venues  foreign key (venue_id)  references venues  (id),
    constraint fk_concerts_singers foreign key (singer_id) references singers (id),
    constraint chk_end_time_after_start_time check (end_time > start_time)
);
