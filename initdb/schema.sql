create table if not exists public.application_properties (
    key_group varchar(100),
    key varchar(100),
    value varchar(100),
    description varchar(200),

    primary key(key_group, key)
);