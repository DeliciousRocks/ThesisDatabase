select * from createuser('sean', 'abc123', 0);
select * from createuser('bob', 'abc123', 0);


select * from addnewapp('file1', 'package1', 1.0, 2.0, 'v1', 'version1', 'iOS', '', 'myApp1', 'developer1');
select * from addnewapp('file2', 'package2', 1.0, 2.0, 'v1', 'version1', 'iOS', '', 'myApp2', 'developer1');


insert into permission values ('permission1', 'false');
insert into permission values ('permission2', 'true');

insert into apphaspermission values (0, 'permission1', 'true', 'true');
insert into apphaspermission values (0, 'permission2', 'false', 'true');
insert into apphaspermission values (1, 'permission1', 'true', 'false');
insert into apphaspermission values (1, 'permission2', 'false', 'false');


/*
COPY apphasframework (appid, packagename) FROM stdin;
\.

*/
--
-- TOC entry 2308 (class 0 OID 51191)
-- Dependencies: 177
-- Data for Name: apphaspermission; Type: TABLE DATA; Schema: public; Owner: postgres
--
/*
INSERT INTO apphaspermission values (0	android.permission.DISABLE_KEYGUARD	t	f
INSERT INTO apphaspermission values (0	android.permission.VIBRATE	f	t
INSERT INTO apphaspermission values (0	android.permission.WAKE_LOCK	t	f
INSERT INTO apphaspermission values (1	android.permission.INTERNET	t	t
INSERT INTO apphaspermission values (1	android.permission.ACCESS_NETWORK_STATE	f	t
INSERT INTO apphaspermission values (2	android.permission.READ_EXTERNAL_STORAGE	f	t
INSERT INTO apphaspermission values (2	android.permission.DISABLE_KEYGUARD	t	f
INSERT INTO apphaspermission values (2	android.permission.USE_CREDENTIALS	t	t
INSERT INTO apphaspermission values (2	android.permission.GET_TASKS	t	t
INSERT INTO apphaspermission values (2	android.permission.INTERNET	t	t
INSERT INTO apphaspermission values (2	android.permission.WRITE_EXTERNAL_STORAGE	t	t
INSERT INTO apphaspermission values (2	android.permission.MANAGE_ACCOUNTS	f	t
INSERT INTO apphaspermission values (2	android.permission.VIBRATE	t	t
INSERT INTO apphaspermission values (2	android.permission.GET_ACCOUNTS	t	f
INSERT INTO apphaspermission values (2	android.permission.WAKE_LOCK	f	t
INSERT INTO apphaspermission values (2	android.permission.ACCESS_NETWORK_STATE	f	t
INSERT INTO apphaspermission values (2	android.permission.BIND_ACCESSIBILITY_SERVICE	t	f
INSERT INTO apphaspermission values (3	android.permission.READ_EXTERNAL_STORAGE	f	t
INSERT INTO apphaspermission values (3	android.permission.USE_CREDENTIALS	f	t
INSERT INTO apphaspermission values (3	android.permission.SEND_SMS	t	t
INSERT INTO apphaspermission values (3	android.permission.WRITE_EXTERNAL_STORAGE	t	t
INSERT INTO apphaspermission values (3	android.permission.WRITE_CALL_LOG	t	f
INSERT INTO apphaspermission values (3	android.permission.WRITE_SMS	t	f
INSERT INTO apphaspermission values (3	android.permission.RECEIVE_SMS	t	f
INSERT INTO apphaspermission values (3	android.permission.ACCESS_COARSE_LOCATION	t	t
INSERT INTO apphaspermission values (3	android.permission.GET_ACCOUNTS	t	t
INSERT INTO apphaspermission values (3	android.permission.READ_CONTACTS	t	f
3	android.permission.READ_PHONE_STATE	t	t
3	android.permission.READ_SMS	t	f
3	android.permission.ACCESS_SUPERUSER	t	f
3	android.permission.INTERNET	t	t
3	android.permission.ACCESS_FINE_LOCATION	t	t
3	android.permission.MANAGE_ACCOUNTS	f	t
3	android.permission.VIBRATE	t	t
3	android.permission.READ_CALL_LOG	t	f
3	android.permission.WAKE_LOCK	f	t
4	android.permission.READ_EXTERNAL_STORAGE	f	t
4	android.permission.READ_PHONE_STATE	t	t
4	android.permission.CAMERA	t	t
4	android.permission.WRITE_EXTERNAL_STORAGE	t	t
4	android.permission.INTERNET	t	t
4	android.permission.VIBRATE	f	t
4	android.permission.ACCESS_WIFI_STATE	t	t
4	android.permission.WAKE_LOCK	t	t
5	android.permission.READ_PHONE_STATE	f	t
5	android.permission.READ_EXTERNAL_STORAGE	f	t
5	android.permission.WRITE_EXTERNAL_STORAGE	t	t
5	android.permission.INTERNET	t	t
5	android.permission.VIBRATE	t	t
5	android.permission.WAKE_LOCK	f	t
5	android.permission.ACCESS_NETWORK_STATE	t	t
5	android.permission.RECORD_AUDIO	t	t
6	android.permission.READ_EXTERNAL_STORAGE	f	t
6	android.permission.WRITE_EXTERNAL_STORAGE	t	t
6	android.permission.ACCESS_WIFI_STATE	t	t
6	android.permission.CALL_PHONE	t	f
6	com.htc.launcher.permission.READ_SETTINGS	t	f
6	android.permission.RESTART_PACKAGES	t	t
6	android.permission.KILL_BACKGROUND_PROCESSES	t	t
6	android.permission.MODIFY_AUDIO_SETTINGS	t	t
6	android.permission.READ_PHONE_STATE	t	f
6	android.permission.DISABLE_KEYGUARD	t	f
6	android.permission.RECEIVE_BOOT_COMPLETED	t	f
6	android.permission.BLUETOOTH	f	t
6	android.permission.INTERNET	t	t
6	android.permission.CHANGE_WIFI_STATE	t	t
6	android.permission.VIBRATE	f	t
6	com.android.launcher.permission.READ_SETTINGS	t	f
6	android.permission.BLUETOOTH_ADMIN	f	t
6	android.permission.WAKE_LOCK	t	t
7	android.permission.READ_EXTERNAL_STORAGE	f	t
7	android.permission.NFC	t	f
7	com.fsck.k9.permission.READ_ATTACHMENT	t	f
7	android.permission.INTERNET	t	t
7	android.permission.WRITE_EXTERNAL_STORAGE	t	t
7	android.permission.GET_ACCOUNTS	t	t
8	android.permission.RECEIVE_BOOT_COMPLETED	t	t
8	android.permission.INTERNET	f	t
8	android.permission.READ_LOGS	t	f
8	android.permission.VIBRATE	f	t
8	android.permission.ACCESS_NETWORK_STATE	f	t
9	android.permission.READ_EXTERNAL_STORAGE	t	t
9	android.permission.WRITE_EXTERNAL_STORAGE	t	t
9	android.permission.INTERNET	t	t
10	com.android.vending.BILLING	t	f
10	android.permission.INTERNET	t	t
10	android.permission.WRITE_EXTERNAL_STORAGE	t	f
10	android.permission.ACCESS_COARSE_LOCATION	t	f
10	android.permission.WAKE_LOCK	f	t
10	android.permission.ACCESS_NETWORK_STATE	t	t
11	android.permission.READ_EXTERNAL_STORAGE	f	t
11	android.permission.WRITE_EXTERNAL_STORAGE	t	t
11	android.permission.READ_LOGS	t	f
11	android.permission.ACCESS_WIFI_STATE	t	t
11	android.permission.ACCESS_COARSE_LOCATION	t	t
11	android.permission.BATTERY_STATS	t	f
11	android.permission.READ_PHONE_STATE	t	f
11	android.permission.RECEIVE_BOOT_COMPLETED	t	f
11	android.permission.INTERNET	t	t
11	android.permission.CHANGE_WIFI_STATE	t	t
11	android.permission.ACCESS_FINE_LOCATION	f	t
11	android.permission.CHANGE_NETWORK_STATE	t	f
11	android.permission.ACCESS_NETWORK_STATE	t	t
11	android.permission.WAKE_LOCK	t	t
12	android.permission.READ_PHONE_STATE	t	f
12	android.permission.INTERNET	f	t
12	android.permission.VIBRATE	f	t
12	android.permission.WAKE_LOCK	t	f
13	android.permission.READ_PHONE_STATE	f	t
13	android.permission.READ_EXTERNAL_STORAGE	f	t
13	android.permission.INTERNET	t	t
13	android.permission.WRITE_EXTERNAL_STORAGE	t	t
13	android.permission.VIBRATE	t	t
13	android.permission.ACCESS_WIFI_STATE	t	f
13	android.permission.WAKE_LOCK	f	t
13	android.permission.ACCESS_NETWORK_STATE	t	t
14	android.permission.READ_EXTERNAL_STORAGE	f	t
14	android.permission.INTERNET	t	t
14	android.permission.WRITE_EXTERNAL_STORAGE	t	t
14	android.permission.WAKE_LOCK	f	t
14	android.permission.ACCESS_NETWORK_STATE	t	t
15	android.permission.READ_EXTERNAL_STORAGE	f	t
15	android.permission.SYSTEM_ALERT_WINDOW	t	f
15	android.permission.WRITE_EXTERNAL_STORAGE	f	t
15	android.permission.INTERNET	t	t
15	android.permission.VIBRATE	t	t
15	android.permission.WAKE_LOCK	f	t
15	android.permission.ACCESS_NETWORK_STATE	f	t
16	android.permission.READ_EXTERNAL_STORAGE	f	t
16	android.permission.RECEIVE_BOOT_COMPLETED	f	t
16	android.permission.INTERNET	t	t
16	android.permission.WRITE_EXTERNAL_STORAGE	t	t
16	android.permission.ACCESS_NETWORK_STATE	f	t
16	android.permission.WAKE_LOCK	t	f
17	android.permission.READ_EXTERNAL_STORAGE	f	t
17	com.android.launcher.permission.INSTALL_SHORTCUT	t	f
17	android.permission.USE_CREDENTIALS	f	t
17	android.permission.RECEIVE_BOOT_COMPLETED	t	f
17	android.permission.INTERNET	t	t
17	android.permission.WRITE_EXTERNAL_STORAGE	t	t
17	android.permission.ACCESS_FINE_LOCATION	t	t
17	android.permission.MANAGE_ACCOUNTS	f	t
17	android.permission.VIBRATE	t	t
17	android.permission.ACCESS_COARSE_LOCATION	t	t
17	android.permission.CALL_PHONE	t	f
17	android.permission.CHANGE_NETWORK_STATE	f	t
17	android.permission.ACCESS_NETWORK_STATE	t	t
17	android.permission.WAKE_LOCK	t	t
18	android.permission.READ_EXTERNAL_STORAGE	f	t
18	android.permission.WRITE_EXTERNAL_STORAGE	f	t
18	android.permission.VIBRATE	t	t
18	android.permission.WAKE_LOCK	f	t
21	android.permission.READ_EXTERNAL_STORAGE	f	t
21	android.permission.USE_CREDENTIALS	t	t
21	android.permission.SYSTEM_ALERT_WINDOW	t	f
21	android.permission.INTERNET	t	t
21	android.permission.WRITE_EXTERNAL_STORAGE	t	t
21	android.permission.MANAGE_ACCOUNTS	f	t
21	android.permission.VIBRATE	f	t
21	android.permission.GET_ACCOUNTS	t	f
21	android.permission.ACCESS_NETWORK_STATE	t	t
22	jackpal.androidterm.permission.RUN_SCRIPT	t	f
23	android.permission.READ_EXTERNAL_STORAGE	f	t
23	android.permission.RECEIVE_BOOT_COMPLETED	f	t
23	android.permission.INTERNET	f	t
23	android.permission.WRITE_EXTERNAL_STORAGE	t	t
23	android.permission.ACCESS_NETWORK_STATE	f	t
23	android.permission.WAKE_LOCK	t	f
\.
*/

--
-- TOC entry 2304 (class 0 OID 51155)
-- Dependencies: 173
-- Data for Name: application; Type: TABLE DATA; Schema: public; Owner: postgres
--

insert into application values (0, 'AcDisplay (Deprecated', 'com_achep_activedisplay-13.apk', 'com.achep.activedisplay', 19, 19, '13', '1.2.5', '2015-04-08 15:10:30.738638-04', 1, 'AChep', 'Android');
insert into application values (1, 'ActionsContentView Example', 'sample_actionscontentview-9.apk', 'sample.actionscontentview', 8, 17, '9', '1.5.2', '2015-04-08 15:13:17.26679-04', 1, 'Steven Rudenko', 'Android');
insert into application values (2, 'Active Notify', 'com_aky_peek_notification-14.apk', 'com.aky.peek.notification', 11, 19, '14', '1.50', '2015-04-08 15:15:40.257147-04', 1, 'Akshay Chordiya', 'Android');
insert into application values (3, 'aeGis', 'com_decad3nce_aegis-39.apk', 'com.decad3nce.aegis', 14, 17, '39', '2.1.2.1', '2015-04-08 15:18:33.734496-04', 1, 'Adnan Begovic', 'Android');
insert into application values (4, 'AndEngine - Examples', 'org_anddev_andengine_examples-36.apk', 'org.anddev.andengine.examples', 4, 4, '36', '1.3.6', '2015-04-08 15:25:18.840137-04', 1, 'Nicolas Gramlich', 'Android');
insert into application values (5, 'AnkiDroid Flashcards', 'com_ichi2_anki-20402300.apk', 'com.ichi2.anki', 7, 19, '20402300', '2.4.2', '2015-04-08 15:49:46.83314-04', 1, 'AnkiDroid Open Source Team', 'Android');
insert into application values (6, 'AppAlarm Pro ', 'com_episode6_android_appalarm_pro-31.apk', 'com.episode6.android.appalarm.pro', 3, 3, '31', '1.2.7', '2015-04-08 15:53:02.509491-04', 1, 'episode6', 'Android');
/*
insert into application values (7, 'APG, org_thialfihar_android_apg-11199.apk', org.thialfihar.android.apg, 9, 19, 11199, 1.1.1, 2015-04-08 15:55:10.027206-04, 1, Thialfihar, 'Android');
insert into application values (8, 'App Tracker, com_nolanlawson_apptracker-10.apk', com.nolanlawson.apptracker, 3, 8, 10, 1.0.9, 2015-04-08 15:59:59.825196-04, 1, Nolan Lawson, 'Android');
insert into application values (9, 'Axel (XML Editor / Viewer)', 'fr_xgouchet_xmleditor-14.apk', fr.xgouchet.xmleditor, 11, 18, 14, 2.4.1, 2015-04-08 16:02:18.70608-04, 1, Xavier Gouchet, 'Android');
insert into application values (10, 'Beebdroid (BBC Micro emulator)', com_littlefluffytoys_beebdroid-7.apk, com.littlefluffytoys.beebdroid, 9, 10, 7, 1.4, 2015-04-08 16:16:53.374737-04, 1, Little Fluffy Toys Ltd, 'Android');
insert into application values (11, 'Better Wifi On/Off, com_asksven_betterwifionoff-43.apk, com.asksven.betterwifionoff, 7, 15, 43, 2.1.0.0, 2015-04-08 16:19:38.432472-04, 1, Sven Knispel, 'Android');
insert into application values (12, 'Binaural Beats Therapy - beta, com_ihunda_android_binauralbeat-44.apk, com.ihunda.android.binauralbeat, 10, 18, 44, 4.4, 2015-04-08 16:21:15.031992-04, 1, Giorgio Regni, 'Android');
insert into application values (13, 'Book Catalogue, com_eleybourn_bookcatalogue-169.apk, com.eleybourn.bookcatalogue, 7, 16, 169, 5.1.2, 2015-04-08 16:25:39.354874-04, 1, Evan Leybourn, 'Android');
insert into application values (14, 'Book of Mormon Stories, gabe_android_BookOfMormon-8.apk, gabe.android.BookOfMormon, 8, 10, 8, 2.6, 2015-04-08 16:27:35.9255-04, 1, Gabriel Black, 'Android');
insert into application values (15, 'Calculator (CyanogenMod), com_android2_calculator3-63.apk, com.android2.calculator3, 14, 19, 63, 4.3, 2015-04-08 16:30:04.668608-04, 1, Xlythe (Calculator), 'Android');
insert into application values (16, 'Chord Reader, com_nolanlawson_chordreader-8.apk, com.nolanlawson.chordreader, 3, 4, 8, 1.0.1, 2015-04-08 16:31:42.882458-04, 1, Nolan Lawson, 'Android');
insert into application values (17, 'Congress, com_sunlightlabs_android_congress-54.apk, com.sunlightlabs.android.congress, 9, 19, 54, 4.6.1, 2015-04-08 16:36:50.072834-04, 1, Sunlight Foundation, 'Android');
insert into application values (18, 'Core, ru_o2genum_coregame-3.apk, ru.o2genum.coregame, 3, 8, 3, 1.0, 2015-04-08 16:38:16.082883-04, 1, Andrey Moiseev, 'Android');
insert into application values (19, 'Countdown Notifier Pro, com_berry_cnotifierpro-2.apk, com.berry.cnotifierpro, 7, 7, 2, 1.0.1, 2015-04-08 16:39:43.639623-04, 1,  Berry Mobile, 'Android');
insert into application values (20, 'CPU Spy , com_bvalosek_cpuspy-9.apk, com.bvalosek.cpuspy, 7, 14, 9, 0.4.0, 2015-04-08 16:44:52.924413-04, 1, Brandon Valosek, 'Android');
insert into application values (21, 'CPU Spy Reborn, com_mirko_csr-14.apk, com.mirko.csr, 14, 17, 14, 2.1.2, 2015-04-08 16:46:32.141791-04, 1, Mirko Dimartino, 'Android');
insert into application values (22, 'droidplot, com_droidplot-7.apk, com.droidplot, 17, 17, 7, 0.0.6.1, 2015-04-08 16:49:30.301507-04, 1, Corbin Champion, 'Android');
insert into application values (23, 'Keep Score, com_nolanlawson_keepscore-28.apk, com.nolanlawson.keepscore, 7, 8, 28, 1.5.1, 2015-04-08 19:04:45.141064-04, 1, Nolan Lawson, 'Android');
\.

--
-- TOC entry 2305 (class 0 OID 51168)
-- Dependencies: 174
-- Data for Name: framework; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY framework (frameworkname, potentiallyinsecure) FROM stdin;
\.


--
-- TOC entry 2306 (class 0 OID 51173)
-- Dependencies: 175
-- Data for Name: permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY permission (permissionname, potentiallyinsecure) FROM stdin;
android.permission.DISABLE_KEYGUARD	\N
android.permission.VIBRATE	\N
android.permission.WAKE_LOCK	\N
android.permission.INTERNET	\N
android.permission.ACCESS_NETWORK_STATE	\N
android.permission.READ_EXTERNAL_STORAGE	\N
android.permission.USE_CREDENTIALS	\N
android.permission.GET_TASKS	\N
android.permission.WRITE_EXTERNAL_STORAGE	\N
android.permission.MANAGE_ACCOUNTS	\N
android.permission.GET_ACCOUNTS	\N
android.permission.BIND_ACCESSIBILITY_SERVICE	\N
android.permission.SEND_SMS	\N
android.permission.WRITE_CALL_LOG	\N
android.permission.WRITE_SMS	\N
android.permission.RECEIVE_SMS	\N
android.permission.ACCESS_COARSE_LOCATION	\N
android.permission.READ_CONTACTS	\N
android.permission.READ_PHONE_STATE	\N
android.permission.READ_SMS	\N
android.permission.ACCESS_SUPERUSER	\N
android.permission.ACCESS_FINE_LOCATION	\N
android.permission.READ_CALL_LOG	\N
android.permission.CAMERA	\N
android.permission.ACCESS_WIFI_STATE	\N
android.permission.RECORD_AUDIO	\N
android.permission.CALL_PHONE	\N
com.htc.launcher.permission.READ_SETTINGS	\N
android.permission.RESTART_PACKAGES	\N
android.permission.KILL_BACKGROUND_PROCESSES	\N
android.permission.MODIFY_AUDIO_SETTINGS	\N
android.permission.RECEIVE_BOOT_COMPLETED	\N
android.permission.BLUETOOTH	\N
android.permission.CHANGE_WIFI_STATE	\N
com.android.launcher.permission.READ_SETTINGS	\N
android.permission.BLUETOOTH_ADMIN	\N
android.permission.NFC	\N
com.fsck.k9.permission.READ_ATTACHMENT	\N
android.permission.READ_LOGS	\N
com.android.vending.BILLING	\N
android.permission.BATTERY_STATS	\N
android.permission.CHANGE_NETWORK_STATE	\N
android.permission.SYSTEM_ALERT_WINDOW	\N
com.android.launcher.permission.INSTALL_SHORTCUT	\N
jackpal.androidterm.permission.RUN_SCRIPT	\N
\.


--
-- TOC entry 2303 (class 0 OID 51147)
-- Dependencies: 172
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (username, userid, password, role) FROM stdin;
Walter	1	A1B2C3	0
\.
*/
