BEGIN;


CREATE TABLE IF NOT EXISTS public.course
(
    id bigint NOT NULL,
    name character varying(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.student
(
    id bigint NOT NULL,
    firstname character varying(255),
    lastname character varying(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.student_course
(
    student_id bigint NOT NULL,
    course_id bigint NOT NULL
);

ALTER TABLE IF EXISTS public.student_course
    ADD FOREIGN KEY (course_id)
    REFERENCES public.course (id)
    NOT VALID;


ALTER TABLE IF EXISTS public.student_course
    ADD FOREIGN KEY (student_id)
    REFERENCES public.student (id)
    NOT VALID;

END;
