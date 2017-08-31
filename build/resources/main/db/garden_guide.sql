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
    rowspacing character varying,
    image character varying
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
1	2017-01-01	2017-02-28	Seed Indoors	1
2	2017-02-01	2017-08-30	Plant Starts	1
3	2017-01-01	2017-01-30	Seed Indoors	2
4	2017-02-01	2017-09-30	Seed Outdoors	2
5	2017-03-01	2017-04-30	Plant Starts	2
6	2017-03-01	2017-09-30	Seed Outdoors	3
7	2017-03-01	2017-04-30	Plant Starts	3
8	2017-02-01	2017-02-28	Seed Indoors	4
9	2017-02-01	2017-04-30	Seed Outdoors	4
10	2017-04-15	2017-05-31	Seed Indoors	5
11	2017-05-15	2017-08-15	Plant Starts	5
12	2017-05-01	2017-06-30	Plant Starts	6
13	2017-04-01	2017-09-30	Seed Outdoors	7
14	2017-04-01	2017-04-30	Plant Starts	7
15	2017-02-01	2017-03-31	Seed Indoors	8
16	2017-04-01	2017-07-30	Seed Outdoors	8
17	2017-03-01	2017-08-15	Plant Starts	8
18	2017-04-01	2017-07-30	Seed Outdoors	9
19	2017-04-01	2017-07-30	Plant Starts	9
20	2017-02-01	2017-03-31	Seed Indoors	10
21	2017-04-01	2017-09-30	Seed Outdoors	10
22	2017-03-01	2017-08-15	Plant Starts	10
23	2017-10-01	2017-10-31	Plant Starts	10
24	2017-04-01	2017-07-30	Seed Outdoors	11
25	2017-04-01	2017-08-15	Plant Starts	11
26	2017-02-01	2017-03-31	Seed Indoors	12
27	2017-04-01	2017-08-31	Seed Outdoors	12
28	2017-04-01	2017-08-15	Plant Starts	12
29	2017-02-01	2017-03-31	Seed Indoors	13
30	2017-04-15	2017-05-31	Seed Outdoors	13
31	2017-04-15	2017-05-30	Plant Starts	13
32	2017-02-01	2017-03-31	Seed Indoors	14
33	2017-04-15	2017-05-31	Seed Outdoors	14
34	2017-04-15	2017-06-30	Plant Starts	14
35	2017-02-01	2017-02-28	Seed Indoors	15
36	2017-03-01	2017-08-31	Seed Outdoors	15
37	2017-03-01	2017-05-31	Plant Starts	15
38	2017-02-01	2017-02-28	Seed Indoors	16
39	2017-01-01	2017-12-31	Plant Starts	16
40	2017-02-01	2017-02-28	Seed Indoors	17
41	2017-03-01	2017-05-31	Seed Outdoors	17
42	2017-03-01	2017-04-30	Plant Starts	17
43	2017-10-01	2017-10-31	Plant Starts	17
44	2017-02-01	2017-08-31	Seed Outdoors	18
45	2017-03-01	2017-04-30	Plant Starts	18
46	2017-04-01	2017-05-31	Seed Outdoors	19
47	2017-04-01	2017-05-31	Plant Starts	19
48	2017-06-01	2017-07-15	Seed Outdoors	20
49	2017-05-15	2017-07-15	Plant Starts	20
50	2017-04-15	2017-05-31	Seed Indoors	21
51	2017-05-01	2017-07-31	Plant Starts	21
52	2017-06-01	2017-06-30	Seed Outdoors	21
53	2017-04-01	2017-06-30	Seed Outdoors	22
54	2017-04-01	2017-05-31	Plant Starts	22
55	2017-08-01	2017-08-15	Plant Starts	22
56	2017-02-15	2017-03-31	Seed Indoors	23
57	2017-05-01	2017-07-15	Plant Starts	23
58	2017-01-01	2017-02-28	Seed Indoors	24
59	2017-04-01	2017-04-30	Seed Outdoors	24
60	2017-04-01	2017-04-30	Plant Starts	24
61	2017-06-01	2017-06-30	Seed Outdoors	24
62	2017-09-01	2017-09-30	Seed Outdoors	24
63	2017-01-01	2017-01-30	Seed Indoors	25
64	2017-02-01	2017-03-31	Seed Outdoors	25
65	2017-09-01	2017-11-30	Seed Outdoors	25
66	2017-04-01	2017-05-31	Seed Outdoors	26
67	2017-04-01	2017-05-31	Plant Starts	26
68	2017-07-15	2017-07-31	Seed Outdoors	26
69	2017-08-01	2017-08-15	Plant Starts	26
70	2017-02-01	2017-03-31	Seed Outdoors	27
71	2017-02-01	2017-02-28	Plant Starts	27
72	2017-09-01	2017-11-30	Seed Outdoors	27
73	2017-01-01	2017-02-28	Seed Indoors	28
74	2017-03-01	2017-09-30	Seed Outdoors	28
75	2017-03-01	2017-05-31	Plant Starts	28
76	2017-07-01	2017-09-30	Plant Starts	28
77	2017-02-01	2017-02-28	Seed Indoors	29
78	2017-04-01	2017-07-31	Seed Outdoors	29
79	2017-04-01	2017-05-31	Plant Starts	29
80	2017-01-01	2017-03-31	Seed Indoors	30
81	2017-05-01	2017-05-31	Seed Outdoors	30
82	2017-04-01	2017-08-31	Plant Starts	30
83	2017-01-01	2017-03-31	Seed Indoors	31
84	2017-04-01	2017-09-30	Seed Outdoors	31
85	2017-03-01	2017-05-31	Plant Starts	31
86	2017-07-01	2017-10-31	Plant Starts	31
87	2017-04-15	2017-06-30	Seed Indoors	32
88	2017-06-01	2017-06-30	Plant Starts	32
89	2017-01-01	2017-01-31	Seed Indoors	33
90	2017-02-01	2017-04-30	Seed Outdoors	33
91	2017-03-01	2017-04-30	Plant Starts	33
92	2017-08-01	2017-08-31	Seed Outdoors	33
93	2017-08-01	2017-08-31	Plant Starts	33
94	2017-01-01	2017-02-28	Seed Indoors	34
95	2017-02-01	2017-02-28	Seed Outdoors	34
96	2017-02-01	2017-03-31	Plant Starts	34
97	2017-09-01	2017-11-30	Seed Outdoors	34
98	2017-01-01	2017-12-31	Plant Starts	35
99	2017-02-01	2017-02-28	Seed Indoors	36
100	2017-01-01	2017-12-31	Plant Starts	36
101	2017-05-01	2017-07-31	Seed Outdoors	37
102	2017-01-01	2017-01-30	Seed Indoors	38
103	2017-02-01	2017-04-30	Seed Outdoors	38
104	2017-02-01	2017-04-30	Plant Starts	38
105	2017-07-01	2017-08-31	Seed Outdoors	38
106	2017-02-15	2017-03-31	Seed Indoors	39
107	2017-05-15	2017-07-15	Plant Starts	39
108	2017-02-01	2017-05-31	Seed Outdoors	40
109	2017-04-15	2017-04-30	Seed Indoors	41
110	2017-05-15	2017-06-30	Seed Outdoors	41
111	2017-06-01	2017-06-30	Plant Starts	41
112	2017-04-01	2017-05-31	Seed Outdoors	42
113	2017-04-01	2017-05-31	Plant Starts	42
114	2017-01-01	2017-02-28	Seed Outdoors	43
115	2017-04-01	2017-05-31	Seed Outdoors	43
116	2017-07-31	2017-09-30	Seed Outdoors	43
117	2017-01-01	2017-12-31	Plant Starts	44
118	2017-05-01	2017-06-30	Seed Outdoors	45
119	2017-01-01	2017-12-31	Plant Starts	46
120	2017-05-01	2017-05-31	Seed Outdoors	47
121	2017-03-01	2017-05-31	Plant Starts	47
122	2017-08-01	2017-09-30	Seed Outdoors	47
123	2017-08-01	2017-10-31	Plant Starts	47
124	2017-01-01	2017-03-31	Seed Indoors	48
125	2017-02-01	2017-07-31	Seed Outdoors	48
126	2017-04-01	2017-05-31	Plant Starts	48
127	2017-08-01	2017-08-31	Plant Starts	48
128	2017-09-01	2017-10-31	Seed Outdoors	49
129	2017-09-01	2017-10-31	Seed Outdoors	49
130	2017-04-01	2017-04-30	Seed Outdoors	50
131	2017-04-01	2017-05-31	Plant Starts	50
132	2017-09-01	2017-09-30	Plant Starts	50
133	2017-01-01	2017-01-30	Seed Indoors	51
134	2017-02-01	2017-05-31	Seed Outdoors	51
135	2017-03-01	2017-05-31	Plant Starts	51
136	2017-07-01	2017-08-31	Seed Outdoors	51
137	2017-08-01	2017-08-31	Plant Starts	51
138	2017-04-15	2017-04-30	Seed Indoors	52
139	2017-05-15	2017-07-15	Seed Outdoors	52
140	2017-05-15	2017-07-15	Plant Starts	52
141	2017-02-01	2017-03-31	Seed Indoors	53
142	2017-05-15	2017-05-31	Plant Starts	53
143	2017-02-15	2017-03-31	Seed Indoors	54
144	2017-05-15	2017-06-30	Plant Starts	54
145	2017-04-01	2017-08-31	Seed Outdoors	55
146	2017-04-15	2017-04-30	Seed Indoors	56
147	2017-05-15	2017-07-15	Seed Outdoors	56
148	2017-05-15	2017-07-15	Plant Starts	56
\.


--
-- Name: events_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('events_id_seq', 148, true);


--
-- Data for Name: plants; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY plants (id, plantname, daystomaturity, plantspacing, rowspacing, image) FROM stdin;
1	Artichoke	85	24	54	/images/plants/artichoke.jpg
2	Arugula	40	5	12	/images/plants/arugala.jpg
3	Asian Greens	45	9	21	/images/plants/asian_greens.jpg
4	Asparagus	730	12	60	/images/plants/asparagus.jpg
5	Basil	80	21	12	/images/plants/basil.jpg
6	Beans	56	2	42	/images/plants/beans.jpg
7	Beets	50	4	16	/images/plants/beets.jpg
8	Broccoli	63	18	27	/images/plants/broccoli.jpg
9	Brussels Sprouts	110	24	24	/images/plants/brussel_sprouts.jpg
10	Cabbage	48	21	36	/images/plants/cabbage.jpg
11	Carrots	58	2	14	/images/plants/carrots.jpg
12	Cauliflower	68	18	30	/images/plants/cauliflower.jpg
13	Celeriac	95	13	20	/images/plants/celeriac.jpg
14	Celery	80	12	18	/images/plants/celery.jpg
15	Chard	55	10	12	/images/plants/chard.jpg
16	Chives	80	5	12	/images/plants/chives.jpg
17	Choi	50	9	12	/images/plants/choi.jpg
18	Cilantro	53	8	8	/images/plants/cilantro.jpg
19	Collards	50	14	30	/images/plants/collards.jpg
20	Corn	91	10	27	/images/plants/corn.jpg
21	Cucumber	48	36	36	/images/plants/cucumber.jpg
22	Dill	50	12	24	/images/plants/dill.jpg
23	Eggplant	67	15	30	/images/plants/eggplant.jpg
24	Endive	50	9	12	/images/plants/endive.jpg
25	Fava Beans	75	9	24	/images/plants/fava_bean.jpg
26	Fennel	80	12	24	/images/plants/fennel.jpg
27	Garlic	180	5	15	/images/plants/garlic.jpg
28	Kale	60	21	24	/images/plants/kale.jpg
29	Kohlrabi	42	5	15	/images/plants/kohlrabi.jpg
30	Leeks	120	5	15	/images/plants/leeks.jpg
31	Lettuce	52	13	17	/images/plants/lettuce.jpg
32	Melon	75	42	66	/images/plants/melon.jpg
33	Mustard Greens	45	3	12	/images/plants/mustard_greens.jpg
34	Onions	170	5	20	/images/plants/onions.jpg
35	Oregano	80	9	12	/images/plants/oregano.jpg
36	Parsley	75	7	15	/images/plants/parsley.jpg
37	Parsnips	110	4	15	/images/plants/parsnips.jpg
38	Peas	58	1	21	/images/plants/peas.jpg
39	Peppers	85	15	27	/images/plants/peppers.jpg
40	Potatoes	180	12	18	/images/plants/potatoes.jpg
41	Pumpkin	90	84	42	/images/plants/pumpkin.jpg
42	Radicchio	60	12	12	/images/plants/radicchio.jpg
43	Radish	50	2	10	/images/plants/radish.jpg
44	Rosemary	150	24	24	/images/plants/rosemary.jpg
45	Rutabaga	90	3	12	/images/plants/rutabaga.jpg
46	Sage	90	20	20	/images/plants/sage.jpg
47	Salad Greens	40	3	12	/images/plants/salad_greens.jpg
48	Scallions	65	2	15	/images/plants/scallions.jpg
49	Shallots	110	5	15	/images/plants/shallots.jpg
50	Sorrel	60	8	15	/images/plants/sorrel.jpg
51	Spinach	37	3	15	/images/plants/spinach.png
52	Summer Squash	48	30	30	/images/plants/summer_squash.jpg
53	Tomatillos	60	30	30	/images/plants/tomatillos.jpg
54	Tomatoes	76	24	24	/images/plants/tomatoes.png
55	Turnips	38	2	24	/images/plants/turnips.jpg
56	Winter Squash	90	30	30	/images/plants/winter_squash.jpg
\.


--
-- Name: plants_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('plants_id_seq', 56, true);


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

