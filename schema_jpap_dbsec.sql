BEGIN;


CREATE TABLE IF NOT EXISTS public.authority
(
    authority character varying(255) NOT NULL,
    PRIMARY KEY (authority)
);

CREATE TABLE IF NOT EXISTS public.euser
(
    username character varying(255) NOT NULL,
    account_non_expired boolean,
    account_non_locked boolean,
    credentials_non_expired boolean,
    enabled boolean,
    password character varying(255),
    PRIMARY KEY (username)
);

CREATE TABLE IF NOT EXISTS public.user_authority
(
    user_id character varying(255) NOT NULL,
    authority_id character varying(255) NOT NULL
);

ALTER TABLE IF EXISTS public.user_authority
    ADD FOREIGN KEY (authority_id)
    REFERENCES public.authority (authority)
    NOT VALID;


ALTER TABLE IF EXISTS public.user_authority
    ADD FOREIGN KEY (user_id)
    REFERENCES public.euser (username)
    NOT VALID;

END;
