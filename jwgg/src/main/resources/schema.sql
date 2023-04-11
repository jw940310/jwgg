drop table if exists item CASCADE;
create table item
(
    id        bigint generated by default as identity,
    item_name varchar(10),
    price     integer,
    quantity  integer,
    primary key (id)
);

drop table if exists member CASCADE;
create table member
(
    id        bigint generated by default as identity,
    login_id varchar(10),
    name     varchar(10),
    password  varchar(10),
    primary key (id)
);

drop table if exists champ CASCADE;
create table champ
(
    champ_id        INT generated by default as identity,
    champ_name varchar(10) UNIQUE,
    champ_line     varchar(10),
    champ_eng_name VARCHAR(20),
    champ_eng_line VARCHAR(20),
    primary key (champ_id)
);

drop table if exists counter CASCADE;
CREATE TABLE counter (
  login_id        bigint generated by default as identity,
  id INT,
  cid INT,
  FOREIGN KEY ( login_id) REFERENCES member(id),
  FOREIGN KEY (id) REFERENCES champ(champ_id),
  FOREIGN KEY (cid) REFERENCES champ(champ_id)
);

--ALTER TABLE champ ALTER COLUMN champ_id RESTART WITH 1;

--insert into champ (champ_name, champ_line) values ('베인','원딜'); --1
--insert into champ (champ_name, champ_line) values ('시비르','원딜'); --2
--insert into champ (champ_name, champ_line) values ('카이사','원딜'); --3
--insert into champ (champ_name, champ_line) values ('루시안','원딜'); --4
--
--insert into counter (id, cid) values (1,3);
--insert into counter (id, cid) values (2,4);
INSERT INTO champ (champ_name, champ_line, champ_eng_name, champ_eng_line) VALUES
('가렌','탑','Garen','top'),
('갈리오','미드','Galio','middle'),
('갱플랭크','탑','Gangplank','top'),
('그라가스','정글','Gragas','jungle'),
('그레이브즈','정글','Graves','jungle'),
('그웬','탑','Gnar','top'),
('나미','서폿','Gwen','utility'),
('나서스','탑','Nasus','top'),
('노틸러스','서폿','Nautilus','utility'),
('녹턴','정글','Nocturne','jungle'),
('누누와 윌럼프','정글','Nunu','jungle'),
('니달리','정글','Nidalee','jungle'),
('니코','미드','Neeko','middle'),
('닐라','원딜','Nilah','bottom'),
('다리우스','탑','Darius','top'),
('다이애나','정글','Diana','jungle'),
('드레이븐','원딜','Draven','bottom'),
('라이즈','미드','Ryze','middle'),
('라칸','서폿','Rakan','utility'),
('람머스','정글','Rammus','jungle'),
('럭스','서폿','Lux','utility'),
('럼블','탑','Rumble','top'),
('레나타 글라스크','서폿','Renata','utility'),
('레넥톤','탑','Renekton','top'),
('레오나','서폿','Leona','utility'),
('렉사이','정글','RekSai','jungle'),
('렐','서폿','Rell','utility'),
('렝가','탑','Rengar','top'),
('루시안','원딜','Lucian','bottom'),
('룰루','서폿','Lulu','utility'),
('르블랑','미드','Leblanc','middle'),
('리 신','정글','LeeSin','jungle'),
('리븐','탑','Riven','top'),
('리산드라','미드','Lissandra','middle'),
('릴리아','정글','Lillia','jungle'),
('마스터 이','정글','MasterYi','jungle'),
('마오카이','탑','Maokai','top'),
('말자하','미드','Malzahar','middle'),
('말파이트','탑','Malphite','top'),
('모데카이저','탑','Mordekaiser','top'),
('모르가나','서폿','Morgana','utility'),
('문도 박사','탑','DrMundo','top'),
('미스 포츈','원딜','MissFortune','bottom'),
('밀리오','서폿','Milio','utility'),
('바드','서폿','Bard','utility'),
('바루스','원딜','Varus','bottom'),
('바이','정글','Vi','jungle'),
('베이가','미드','Veigar','middle'),
('베인','원딜','Vayne','bottom'),
('벡스','미드','Vex','middle'),
('벨베스','정글','Belveth','jungle'),
('벨코즈','서폿','Velkoz','utility'),
('볼리베어','탑','Volibear','top'),
('브라움','서폿','Braum','utility'),
('브랜드','서폿','Brand','utility'),
('블라디미르','미드','Vladimir','middle'),
('블리츠크랭크','서폿','Blitzcrank','utility'),
('비에고','정글','Viego','jungle'),
('빅토르','미드','Viktor','middle'),
('뽀삐','정글','Poppy','jungle'),
('사미라','원딜','Samira','bottom'),
('사이온','탑','Sion','top'),
('사일러스','정글','Sylas','jungle'),
('샤코','정글','Shaco','jungle'),
('세나','서폿','Senna','utility'),
('세라핀','서폿','Seraphine','utility'),
('세주아니','정글','Sejuani','jungle'),
('세트','탑','Sett','top'),
('소나','서폿','Sona','utility'),
('소라카','서폿','Soraka','utility'),
('쉔','탑','Shen','top'),
('쉬바나','정글','Shyvana','jungle'),
('스웨인','서폿','Swain','utility'),
('스카너','정글','Skarner','jungle'),
('시비르','원딜','Sivir','bottom'),
('신 짜오','정글','XinZhao','jungle'),
('신드라','미드','Syndra','middle'),
('신지드','탑','Singed','top'),
('쓰레쉬','서폿','Thresh','utility'),
('아리','미드','Ahri','middle'),
('아무무','서폿','Amumu','utility'),
('아우렐리온 솔','미드','AurelionSol','middle'),
('아이번','정글','Ivern','jungle'),
('아지르','미드','Azir','middle'),
('아칼리','미드','Akali','middle'),
('아크샨','미드','Akshan','middle'),
('아트록스','탑','Aatrox','top'),
('아펠리오스','원딜','Aphelios','bottom'),
('알리스타','서폿','Alistar','utility'),
('애니','미드','Annie','middle'),
('애니비아','미드','Anivia','middle'),
('애쉬','원딜','Ashe','bottom'),
('야스오','미드','Yasuo','middle'),
('에코','정글','Ekko','jungle'),
('엘리스','정글','Elise','jungle'),
('오공','정글','MonkeyKing','jungle'),
('오른','탑','Ornn','top'),
('오리아나','미드','Orianna','middle'),
('올라프','탑','Olaf','top'),
('요네','미드','Yone','middle'),
('요릭','탑','Yorick','top'),
('우디르','정글','Udyr','jungle'),
('우르곳','탑','Urgot','top'),
('워윅','정글','Warwick','jungle'),
('유미','서폿','Yuumi','utility'),
('이렐리아','미드','Irelia','middle'),
('이블린','정글','Evelynn','jungle'),
('이즈리얼','원딜','Ezreal','bottom'),
('일라오이','탑','Illaoi','top'),
('자르반 4세','정글','JarvanIV','jungle'),
('자야','원딜','Xayah','bottom'),
('자이라','서폿','Zyra','utility'),
('자크','정글','Zac','jungle'),
('잔나','서폿','Janna','utility'),
('잭스','탑','Jax','top'),
('제드','미드','Zed','middle'),
('제라스','서폿','Xerath','utility'),
('제리','원딜','Zeri','bottom'),
('제이스','탑','Jayce','top'),
('조이','미드','Zoe','middle'),
('직스','원딜','Ziggs','bottom'),
('진','원딜','Jhin','bottom'),
('질리언','서폿','Zilean','utility'),
('징크스','원딜','Jinx','bottom'),
('초가스','탑','Chogath','top'),
('카르마','서폿','Karma','utility'),
('카밀','탑','Camille','top'),
('카사딘','미드','Kassadin','middle'),
('카서스','정글','Karthus','jungle'),
('카시오페아','미드','Cassiopeia','middle'),
('카이사','원딜','Kaisa','bottom'),
('카직스','정글','Khazix','jungle'),
('카타리나','미드','Katarina','middle'),
('칼리스타','원딜','Kalista','bottom'),
('케넨','탑','Kennen','top'),
('케이틀린','원딜','Caitlyn','bottom'),
('케인','정글','Kayn','jungle'),
('케일','탑','Kayle','top'),
('코그모','원딜','KogMaw','bottom'),
('코르키','미드','Corki','middle'),
('퀸','탑','Quinn','top'),
('크산테','탑','KSante','top'),
('클레드','탑','Kled','top'),
('키아나','미드','Qiyana','middle'),
('킨드레드','정글','Kindred','jungle'),
('타릭','서폿','Taric','utility'),
('탈론','미드','Talon','middle'),
('탈리야','미드','Taliyah','middle'),
('탐 켄치','탑','TahmKench','top'),
('트런들','정글','Trundle','jungle'),
('트리스타나','원딜','Tristana','bottom'),
('트린다미어','탑','Tryndamere','top'),
('트위스티드 페이트','미드','TwistedFate','middle'),
('트위치','원딜','Twitch','bottom'),
('티모','탑','Teemo','top'),
('파이크','서폿','Pyke','utility'),
('판테온','미드','Pantheon','middle'),
('피들스틱','정글','Fiddlesticks','jungle'),
('피오라','탑','Fiora','top'),
('피즈','미드','Fizz','middle'),
('하이머딩거','서폿','Heimerdinger','utility'),
('헤카림','정글','Hecarim','jungle')