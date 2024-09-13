CREATE SCHEMA app
    AUTHORIZATION postgres;

    CREATE TABLE app.artist
    (
        id bigserial NOT NULL,
        name character varying NOT NULL,
        PRIMARY KEY (id)
    );

    ALTER TABLE IF EXISTS app.artist
        OWNER to postgres;

    CREATE TABLE app.artist
        (
            id bigint,
            name character varying NOT NULL,
            PRIMARY KEY (id)
        );

        ALTER TABLE IF EXISTS app.artist
            OWNER to postgres;

        CREATE TABLE app.genre
        (
            id bigserial,
            name character varying NOT NULL,
            PRIMARY KEY (id)
        );

        ALTER TABLE IF EXISTS app.genre
            OWNER to postgres;

        CREATE TABLE app.vote
        (
            id bigserial,
            create_at timestamptz NOT NULL,
            artist_id bigint NOT NULL,
            about text NOT NULL,
            PRIMARY KEY (id),
            FOREIGN KEY (artist_id) REFERENCES app.artist (id)
        );

         ALTER TABLE IF EXISTS app.vote
             OWNER to postgres;

         CREATE TABLE app.cross_vote_genre
         (
             vote_id bigint,
             genre_id bigint,
             FOREIGN KEY (vote_id) REFERENCES app.vote (id),
             FOREIGN KEY (genre_id) REFERENCES app.genre (id),
             UNIQUE (vote_id, genre_id)
         );

         ALTER TABLE IF EXISTS app.cross_vote_genre
             OWNER to postgres;


         INSERT INTO app.vote(
	         id, create_at, artist_id, about)
	         VALUES (?, ?, ?, ?);


	         SELECT name, COUNT(app.vote.id)
             	FROM
             	app.artist INNER JOIN app.vote
             	ON app.artist.id = app.vote.artist_id
             	GROUP BY app.artist.name;



         SELECT app.genre.name, COUNT(app.vote.id)
         	FROM
         	app.genre INNER JOIN app.cross_vote_genre
         	ON app.genre.id = app.cross_vote_genre.genre_id
         	INNER JOIN app.vote ON app.cross_vote_genre.vote_id =
         	app.vote.id
         	GROUP BY app.genre.id
         	ORDER BY 2;