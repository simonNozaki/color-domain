-- テーブル作成
create table if not exists public.application_properties (
    key_group varchar(100),
    key varchar(100),
    value varchar(100),
    description varchar(200),

    primary key(key_group, key)
);

-- シードデータ投入
insert into public.application_properties values
    ('ORDER.SIZE', '40', '40', ''),
    ('ORDER.SIZE', '42', '42', ''),
    ('ORDER.SIZE', '44', '44', ''),
    ('ORDER.SIZE', '46', '46', ''),
    ('ORDER.FIT', 'SKINNY', 'SKINNY', ''),
    ('ORDER.FIT', 'NORMAL', 'NORMAL', ''),
    ('ORDER.FIT', 'LOOSE', 'LOOSE', '');