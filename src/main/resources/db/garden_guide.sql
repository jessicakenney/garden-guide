--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: events; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE events (
    id integer NOT NULL,
    startdate date,
    enddate date,
    type character varying,
    plantid integer
);


ALTER TABLE events OWNER TO "Guest";

--
-- Name: events_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE events_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE events_id_seq OWNER TO "Guest";

--
-- Name: events_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE events_id_seq OWNED BY events.id;


--
-- Name: plants; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE plants (
    id integer NOT NULL,
    plantname character varying,
    daystomaturity integer,
    plantspacing character varying,
    rowspacing character varying
);


ALTER TABLE plants OWNER TO "Guest";

--
-- Name: plants_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE plants_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE plants_id_seq OWNER TO "Guest";

--
-- Name: plants_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE plants_id_seq OWNED BY plants.id;


--
-- Name: events id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY events ALTER COLUMN id SET DEFAULT nextval('events_id_seq'::regclass);


--
-- Name: plants id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY plants ALTER COLUMN id SET DEFAULT nextval('plants_id_seq'::regclass);


--
-- Data for Name: events; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY events (id, startdate, enddate, type, plantid) FROM stdin;
\.


--
-- Name: events_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('events_id_seq', 1, false);


--
-- Data for Name: plants; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY plants (id, plantname, daystomaturity, plantspacing, rowspacing) FROM stdin;
\.


--
-- Name: plants_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('plants_id_seq', 1, false);


--
-- Name: events events_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY events
    ADD CONSTRAINT events_pkey PRIMARY KEY (id);


--
-- Name: plants plants_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY plants
    ADD CONSTRAINT plants_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

