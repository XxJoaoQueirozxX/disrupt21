# DISRUPT 21 - De Volta para o Futuro
Projeto para o DISRUPT21 FIAP 2020 do grupo Storm It Solutions.
A aplicação consiste em uma página WEB para melhorar a experiência do usuário com o filme **De Volta para o Futuro** para isso a aplicação fornece ao usuário informações sobre os personagens (em suas diferentes versões durante o filme) e sobre os acontecimentos do filme sendo possível ver os personagens relacionados à esse acontecimento e suas consequências.


## Tecnologias Utilizadas:
##### Front-end:
- HTML5
- CSS3
- JavaScript
- JSP
- Bootstrap

##### Back-end
- Servlets

##### Banco de dados
- Oracle DB

## Conceitos Aplicados
- OOP
- Acesso a banco de dados com JDBC utilizando o padrão DAO
- Exception Handler
- Interfaces


## Prints
![pagina-home](https://github.com/XxJoaoQueirozxX/disrupt21/blob/main/prints/home.png?raw=true)

![menu-lateral](https://github.com/XxJoaoQueirozxX/disrupt21/blob/main/prints/acontecimento.png?raw=true)

![timeline-acontecimentos](https://github.com/XxJoaoQueirozxX/disrupt21/blob/main/prints/ac.png?raw=true)

![acontecimento](https://github.com/XxJoaoQueirozxX/disrupt21/blob/main/prints/ac-in.png?raw=true)

![personagem](https://github.com/XxJoaoQueirozxX/disrupt21/blob/main/prints/personagem.png?raw=true)


## Scripts SQL 
#### Criação das tabelas e sequences
    CREATE TABLE t_bttf_acontecimento (
        id_acontecimento  NUMBER(3) NOT NULL,
        ds_acontecimento  VARCHAR2(300) NOT NULL,
        nm_acontecimento  VARCHAR2(300) NOT NULL,
        dt_acontecimento  DATE NOT NULL,
        bl_alternativo    CHAR(1) NOT NULL,
        url_foto          VARCHAR2(300) NOT NULL,
        timeline          NUMBER (10) NOT NULL
    );
    
    ALTER TABLE t_bttf_acontecimento ADD CONSTRAINT pk_t_bttf_acontecimento PRIMARY KEY ( id_acontecimento );
    
    CREATE TABLE t_bttf_consequencia (
        id_consequencia   NUMBER(3) NOT NULL,
        id_acontecimento  NUMBER(3) NOT NULL,
        ds_consequencia   VARCHAR2(600) NOT NULL
    );
    
    
    ALTER TABLE t_bttf_consequencia ADD CONSTRAINT pk_t_bttf_consequencia PRIMARY KEY ( id_consequencia );
    
    CREATE TABLE t_bttf_personagem (
        id_personagem   NUMBER(3) NOT NULL,
        nm_personagem   VARCHAR2(60) NOT NULL,
        nm_ator         VARCHAR2(60) NOT NULL,
        ds_personagem   VARCHAR2(300) NOT NULL,
        relacao_marty   VARCHAR2(300) NOT NULL,
        url_foto        VARCHAR2(300) NOT NULL,
        bl_viajante     CHAR(1) NOT NULL,
        bl_alternativo  CHAR(1) NOT NULL
    );
    
    ALTER TABLE t_bttf_personagem ADD CONSTRAINT pk_t_bttf_personagem PRIMARY KEY ( id_personagem );
    
    CREATE TABLE t_bttf_personagem_acont (
        id_personagem_acont  NUMBER(10) NOT NULL,
        id_acontecimento     NUMBER(3) NOT NULL,
        id_personagem        NUMBER(3) NOT NULL
    );
    
    ALTER TABLE t_bttf_personagem_acont ADD CONSTRAINT pk_t_bttf_personagem_acont PRIMARY KEY ( id_personagem_acont );
    
    ALTER TABLE t_bttf_consequencia
        ADD CONSTRAINT fk_t_bttf_consequencia_acont FOREIGN KEY ( id_acontecimento )
            REFERENCES t_bttf_acontecimento ( id_acontecimento );
    
    ALTER TABLE t_bttf_personagem_acont
        ADD CONSTRAINT fk_t_bttf_person_acont FOREIGN KEY ( id_acontecimento )
            REFERENCES t_bttf_acontecimento ( id_acontecimento );
    
    ALTER TABLE t_bttf_personagem_acont
        ADD CONSTRAINT fk_t_bttf_person_acont_person FOREIGN KEY ( id_personagem )
            REFERENCES t_bttf_personagem ( id_personagem );
            
    CREATE SEQUENCE SQ_T_BTTF_ACONTECIMENTO
        INCREMENT BY 1
        START WITH 1
        MAXVALUE 999
        MINVALUE 1
        NOCYCLE
        CACHE 5;
        
    CREATE SEQUENCE SQ_T_BTTF_CONSEQUENCIA
        INCREMENT BY 1
        START WITH 1
        MAXVALUE 999
        MINVALUE 1
        NOCYCLE
        CACHE 5;
        
    CREATE SEQUENCE SQ_T_BTTF_PERSONAGEM
        INCREMENT BY 1
        START WITH 1
        MAXVALUE 999
        MINVALUE 1
        NOCYCLE
        CACHE 5;
    
    CREATE SEQUENCE SQ_T_BTTF_PERSONAGEM_ACONT
        INCREMENT BY 1
        START WITH 1
        MAXVALUE 9999999999
        MINVALUE 1
        NOCYCLE
        CACHE 5;

### População da Base de dados
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'MARTY MCFLY', 'MICHAEL J. FOX',
    'Marty McFly e um adolescente que vive com sua familia sem expectativas da vida,
    na cidade de Hill Valley, na California. Mas tudo muda quando Marty junto de seu grande amigo Doc Brown
    decidem explorar a viagem no tempo.', 'Principal',
    'https://images-na.ssl-images-amazon.com/images/I/51FwllOWE3L._AC_.jpg',
    1, 1);
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'EMMETT LATHROP BROWN', 'CHRISTOPHER LLOYD',
    'Doutor Emmett Lathrop Brown, ou apenas Doc Brown e
    uma das mente mais brilhantes de seu tempo. Alem de cientista, Doc Brown tambem e um ilustre inventor,
    que sempre trabalhou em invençoes disruptivas e mirabolantes.
    Ate que, em 1985, relevou sua obra prima: o DeLorean maquina do tempo.', 'Melhor amigo',
    'https://i.pinimg.com/736x/94/ce/ea/94ceea61a99369da776f7b741e0f4ce3.jpg',
    1, 1);
    
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'EMMETT LATHROP BROWN (1955)', 'CHRISTOPHER LLOYD',
    'Doc Emmett Lathrop Brown e um residente de Hill Valley, na California. Com a ciencia como profissao,
    Doc e um "estudante de todas as ciencias" que passa grande parte do tempo inventando. Ele ten um cao chamado Copernico, em homenagem ao astronomo Nicolau Copernico.', 'Conhecido',
    'https://www.estrelando.com.br/uploads/2020/11/05/5-de-novembro-de-volta-para-o-futuro-curiosidades-1604588539.gallery.jpg',
    0, 0);
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'EINSTEIN', 'TIGER',
    'Einstein e o animal de estimaçao do Doc Brown em 1985.
    Doc ja teve outros mascotes com nomes de cientistas famosos, neste caso o homenageado foi Albert Einstein,
    Era, portanto, bastante apropriado que ele se tornasse o primeiro viajante do tempo da historia.', 'Mascote',
    'https://pbs.twimg.com/profile_images/733690816686739458/S3l10Kjg_400x400.jpg',
    1, 1);
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'LORRAINE BAINES MCFLY', 'LEA THOMPSON',
    'Lorraine Baines-McFly e esposa de George McFly e mae de Dave, Linda e Marty. Muito cuidadosa e moralista, ela sempre
    adverte os filhos sobre "os perigos da juventude". Lorraine tem problemas com alcool e com seu peso,
    alem de viver deprimida lembrando saudosamente de seu querido passado.', 'Mae Chata',
    'https://img2.looper.com/img/gallery/dumb-things-in-back-to-the-future-everyone-ignored/so-much-old-age-makeup-in-back-to-the-future-1570467802.jpg',
    0, 0);
    
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'LORRAINE BAINES (1955)', 'LEA THOMPSON',
    'Lorraine Baines e uma adolescente que mora com seus pais e seus cinco irmaos. Estudante da Hill Valley High School,
    Lorraine gosta de sair com seus amigos e embarcar em suas paixoes juvenis.', 'Conhecida',
    'https://assets.mycast.io/characters/lorraine-baines-mcfly-928978-normal.jpg?1598493543',
    0, 1);
    
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'LORRAINE BAINES MCFLY (Alternativa)', 'LEA THOMPSON',
    'Lorraine Baines McFly e a mae de Dave, Linda e Marty e esposa de George McFly, uma mulher empoderada e sem medo de ir atras do que quer.
    Lorraine gosta de jogar tenis com seu marido, com quem venceu o campeonato do clube de tenis por seis anos seguidos.', 'Mae Legal',
    'https://cdn.discordapp.com/attachments/704050098023170119/779479678816878602/unknown.png',
    0, 1);
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'GEORGE DOUGLAS MCFLY', 'CRISPIN GLOVER',
    'George Douglas McFly e o pai de Dave, Linda e Marty, e marido de Lorraine Baines McFly. Um menino inseguro que cresceu
    e se tornou um nerd covarde incapaz de se defender. George trabalha em uma empresa, onde tem como supervisor Biff Tannen,
    que o agride desde os tempos do colegio.', 'Pai Nerd',
    'https://i0.wp.com/macguff.in/wp-content/uploads/2015/10/Back-to-the-Future-Movie-Header-Image.jpg?fit=630%2C400&ssl=1',
    0, 0);
    
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'GEORGE DOUGLAS MCFLY (1955)', 'CRISPIN GLOVER',
    'George e um jovem que gosta de assistir programas antigos e de ficçao cientifica.
    Timido e desajeitado, ele e muito supersticioso, tambem tem uma risada bem peculiar. Quando tinha 12 anos,
    ele quase defendeu um colega que apanhava, mas nao o fez e tem se odiado por isso desde entao.', 'Conhecido',
    'https://pbs.twimg.com/profile_images/1234626998/GeorgeMcfly_400x400.jpg',
    0, 1);
    
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'GEORGE DOUGLAS MCFLY (Alternativo)', 'CRISPIN GLOVER',
    'George Mcfly e um prospero escritor de ficçao cientifica, que vive muito bem com sua familia em Hill Valley, na California.
    Alem de uma postura exemplar, George ostenta sua confiança em tudo que faz, seja em seu relacionamento com Lorraine, no trabalho,
    ou lidando com Biff, seu "capacho".', 'Pai Descolado',
    'https://i.pinimg.com/originals/0d/79/cb/0d79cb2642f170c3eb9a0b921fe53c3c.jpg',
    0, 1);
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'BIFF HOWARD TANNEN', 'THOMAS F. WILSON',
    'Biff Howard Tanen e um morador nativo da cidade de Hill Valley, onde e facilmente reconhecido por sua fama de valentao.
    E como tal, Biff passou a vida intimidando e se aproveitando dos outros, especialmente de George, que foi responsavel pela promoçao de Biff,
    que tornou-se supervidor dele.', 'Inimigos',
    'https://i.pinimg.com/originals/a0/42/7a/a0427a9f370661be8072e4f5e53f502e.jpg',
    0, 0);
    
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'BIFF HOWARD TANNEN (1955)', 'THOMAS F. WILSON',
    'Biff Howard Tanen e o valentao da Hill Valley High School. Junto de seus comparsas, Biff faz o que bem entende no colegio, ja
    que suas notas estao sempre garantidas por George, que faz todos os trabalhos dele. Biff sempre teve uma queda por Lorraine,
    mas nunca passou perto de ser correspondido.', 'Inimigos',
    'https://upload.wikimedia.org/wikipedia/en/thumb/1/15/BiffTannenBackToTheFuture1985.jpg/220px-BiffTannenBackToTheFuture1985.jpg',
    0, 1);
    
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'BIFF HOWARD TANNEN (Alternativo)', 'THOMAS F. WILSON',
    'Biff Tanen nasceu e foi criado em Hill Valley, na California. Biff nao se deu muito bem na escola depois que George parou de "ajuda-lo", e isso o levou a entrar para os negocios de limpeza de automoveis,
    tendo os Mcfly como seus clientes fieis, a quem presta seus serviços subservientemente.', 'Conhecido',
    'https://i.pinimg.com/originals/f0/30/26/f0302692cc4ba339469f5554f971be04.jpg',
    0, 1);
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'JENNIFER JANE PARKER', 'CLAUDIA WELLS',
    'Jennifer e uma estudante da Hill Valley High School, onde conheceu Marty, seu namorado. Alem de ser a quarta pessoa a viajar no tempo,
    Jennifer tambem e uma pessoa muito positiva, sempre motivando Marty e o incentivando a se dedicar, tanto aos estudos quanto no seu sonho de ser musico.',
    'Namorada','https://img1.looper.com/img/gallery/back-to-the-futures-jennifer-is-still-as-gorgeous-as-ever/intro-1588596163.jpg',
    1, 1);
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'GOLDIE WILSON', 'DONALD FULLILOVE',
    'Durante toda sua juventude, Goldie observou sua mae trabalhando sem nunca sair do lugar, por isso estava determinado a fazer
    algo para melhorar sua situaçao. Essa determinaçao (junto de um comentario de Marty sobre o futuro) levariam Goldie a se tornar prefeito de sua cidade, Hill Valley.','Desconhecido',
    'https://i.pinimg.com/originals/05/75/9d/05759d664bb37d38060107a3f3895f13.jpg',
    0, 0);
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'DAVE MCFLY', 'MARC MCCLURE',
    'Dave McFly e um jovem adulto conformado com seu trabalho em uma rede de restaurantes
    fast-food, seguindo sua vida rotineira e sem grandes pretençoes quanto ao futuro.', 'Irmao',
    'https://pbs.twimg.com/profile_images/1234629925/Dave_Mcfly_400x400.jpg',
    0, 0);
    
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'DAVE MCFLY (Alternativo)', 'MARC MCCLURE',
    'Dave McFly e empregado de um importante escritorio, que sempre anda bem vestido e cheio de confiança e ambiçoes.', 'Irmao',
    'https://upload.wikimedia.org/wikipedia/ru/9/93/Dave_mcfly.jpg',
    0, 1);
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'LINDA MCFLY', 'WENDIE JO SPERBER',
    'Linda McFly e uma adolescente que mora com sua familia em Hill Valley, Linda e filha do meio de dois irmaos, e a unica mulher,
    ela tem uma vida cheia de problemas e exerce o papel de "secretaria eletronica" da familia.', 'Irma',
    'https://assets.mycast.io/characters/linda-mcfly-448204-normal.jpg?1579283030',
    0, 0);
    
    INSERT INTO T_BTTF_PERSONAGEM
    (ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)
    VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, 'LINDA MCFLY (Alternativa)', 'WENDIE JO SPERBER',
    'Linda McFly vive feliz com sua familia na cidade de Hill Valley, onde trabalha numa botique. Linda chama a atençao de muitos garotos,
    e tem muitos pretendentes.', 'Irma',
    'https://cdn.discordapp.com/attachments/704050098023170119/779478621567451146/Captura_de_tela_2020-11-20_194804.png',
    0, 1);
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_ACONTECIMENTO
    (ID_ACONTECIMENTO, DS_ACONTECIMENTO, NM_ACONTECIMENTO, DT_ACONTECIMENTO, BL_ALTERNATIVO, URL_FOTO, TIMELINE)
    VALUES (SQ_T_BTTF_ACONTECIMENTO.NEXTVAL,
    'Nesta primeira versao do ano, Marty e sua familia vivem uma situaçao
    infeliz. Lorraine tem problemas com alcool, com seu peso e depressao,Linda e Dave sofrem com falhas
    profissionais e sociais, George e um covarde sem autoestima ou perspectiva de vida, alem de ser sempre humilhado por Biff.',
    '1985 nao prospero', TO_DATE ('26/10/1985', 'DD/MM/YYYY'), 0,
    'https://cdn.discordapp.com/attachments/706640489956245516/778075105715945492/unknown.png',
    1);
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_ACONTECIMENTO
    (ID_ACONTECIMENTO, DS_ACONTECIMENTO, NM_ACONTECIMENTO, DT_ACONTECIMENTO, BL_ALTERNATIVO, URL_FOTO, TIMELINE)
    VALUES (SQ_T_BTTF_ACONTECIMENTO.NEXTVAL,
    'Marty e Doc Brown se encontram no estacionamento do shopping Twin Pines,
    as 1h15. Doc revela sua maquina do tempo construida a partir de um DeLorean
    modificado alimentado por plutonio. Como teste, Einstein (cao) foi enviado
    com sucesso para 1 min no futuro.',
    'A primeira viagem no tempo', TO_DATE ('27/10/1985', 'DD/MM/YYYY'), 0,
    'https://i.pinimg.com/originals/60/98/0f/60980f7cf17d282a03b535d6ac38e550.jpg',
    1);
    
    INSERT INTO T_BTTF_CONSEQUENCIA
    (ID_CONSEQUENCIA, ID_ACONTECIMENTO, DS_CONSEQUENCIA)
    VALUES (SQ_T_BTTF_CONSEQUENCIA.NEXTVAL, SQ_T_BTTF_ACONTECIMENTO.CURRVAL,
    'Com o sucesso do teste, Doc Brown comprovou suas teorias de viagem no tempo,
    e tambem pode observar seu processo. Isso garantiu a eficacia do Delorean
    e deu ao Doc a certeza da confiabilidade de sua maquina.');
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_ACONTECIMENTO
    (ID_ACONTECIMENTO, DS_ACONTECIMENTO, NM_ACONTECIMENTO, DT_ACONTECIMENTO, BL_ALTERNATIVO, URL_FOTO, TIMELINE)
    VALUES (SQ_T_BTTF_ACONTECIMENTO.NEXTVAL,
    'No estacionamento do shopping Twin Pines, apos a chegada de Einstein, Doc e Marty sao surpreendidos
    por um ataque de traficantes libios, de quem Doc Brown roubou o plutonio usado para alimentar o DeLorean.',
    'Ataque Libio', TO_DATE ('26/10/1985', 'DD/MM/YYYY'), 0,
    'https://cdn.discordapp.com/attachments/706640489956245516/778080387774677012/unknown.png',
    1);
    
    INSERT INTO T_BTTF_CONSEQUENCIA
    (ID_CONSEQUENCIA, ID_ACONTECIMENTO, DS_CONSEQUENCIA)
    VALUES (SQ_T_BTTF_CONSEQUENCIA.NEXTVAL, SQ_T_BTTF_ACONTECIMENTO.CURRVAL,
    '<li>Na primeira chance que tem, os traficantes atiram no Doc Brown, que e atingido por varios
    disparos e cai no chao ja sem vida. </li>
    <li>Marty utiliza o DeLorean para fugir dos libios e acidentalmente acaba voltando para o ano de 1955</li>');
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_ACONTECIMENTO
    (ID_ACONTECIMENTO, DS_ACONTECIMENTO, NM_ACONTECIMENTO, DT_ACONTECIMENTO, BL_ALTERNATIVO, URL_FOTO, TIMELINE)
    VALUES (SQ_T_BTTF_ACONTECIMENTO.NEXTVAL,
    'Ainda absorvendo a ideia de ter voltado no tempo, Marty entra numa lanchonete para usar o telefone
    para contatar o Doc Brown, mas acaba encontrando seu pai com 17 anos, coincidentemente quando Biff e seus
    comparsas aparecem para agredi-lo.', 'Reencontro Familiar', TO_DATE ('05/11/1955', 'DD/MM/YYYY'), 0,
    'https://cdn.discordapp.com/attachments/706640489956245516/778083363684352030/unknown.png',
    1);
    
    INSERT INTO T_BTTF_CONSEQUENCIA
    (ID_CONSEQUENCIA, ID_ACONTECIMENTO, DS_CONSEQUENCIA)
    VALUES (SQ_T_BTTF_CONSEQUENCIA.NEXTVAL, SQ_T_BTTF_ACONTECIMENTO.CURRVAL,
    'Marty, conturbado com tudo que acontecia, comenta que
    Goldie Wilson, naquela epoca funcionario da lanchonete, se tornaria
    prefeito de Hill Valley. O que foi o suficiente para que Goldie se
    maravilhasse com a ideia, iniciando sua vida politica a partir dali.');
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_ACONTECIMENTO
    (ID_ACONTECIMENTO, DS_ACONTECIMENTO, NM_ACONTECIMENTO, DT_ACONTECIMENTO, BL_ALTERNATIVO, URL_FOTO, TIMELINE)
    VALUES (SQ_T_BTTF_ACONTECIMENTO.NEXTVAL,
    'George cai dos galhos de uma arvore de onde espiava Lorraine no meio da rua, instintivamente Marty salva seu pai
    e e atropelado em seu lugar por Sam, pai de Lorraine.', 'Paixao Acidental', TO_DATE ('05/11/1955', 'DD/MM/YYYY'), 0,
    'https://cdn.discordapp.com/attachments/706640489956245516/778084062572445726/unknown.png',
    1);
    
    INSERT INTO T_BTTF_CONSEQUENCIA
    (ID_CONSEQUENCIA, ID_ACONTECIMENTO, DS_CONSEQUENCIA)
    VALUES (SQ_T_BTTF_CONSEQUENCIA.NEXTVAL, SQ_T_BTTF_ACONTECIMENTO.CURRVAL,
    '<li>Lorraine se apaixona por Marty, que foi acolhido por sua familia no lugar de George. </li>
    <li>Marty e seus irmao sao gradativamente apagados da existencia, ja que Lorraine nao se apaixonou por George. </li>
    <li>George percebe a paixao de Lorraine por Marty, e se recusa a tentar qualquer coisa com ela. </li>
    ');
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_ACONTECIMENTO
    (ID_ACONTECIMENTO, DS_ACONTECIMENTO, NM_ACONTECIMENTO, DT_ACONTECIMENTO, BL_ALTERNATIVO, URL_FOTO, TIMELINE)
    VALUES (SQ_T_BTTF_ACONTECIMENTO.NEXTVAL,
    'Doc Brown sofre um acidente domestico quando escorrega no banheiro e bate a cabeça na pia e sofre um desmaio.
    Quando recobra a conciencia, Brown tem em sua mente uma imagem nitida do que viria a se tornar o capacitor de fluxo.',
    'Invençao da viagem no tempo', TO_DATE ('05/11/1955', 'DD/MM/YYYY'), 0,
    'https://cdn.discordapp.com/attachments/706640489956245516/778092936856207360/unknown.png',
    1);
    
    INSERT INTO T_BTTF_CONSEQUENCIA
    (ID_CONSEQUENCIA, ID_ACONTECIMENTO, DS_CONSEQUENCIA)
    VALUES (SQ_T_BTTF_CONSEQUENCIA.NEXTVAL, SQ_T_BTTF_ACONTECIMENTO.CURRVAL,
    'Tendo a imagem que vislumbrou em seu desmaio como base, Doc Brown desenvolveu o capacitor de fluxo, que possibilitaria a viagem no tempo em 1985');
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_ACONTECIMENTO
    (ID_ACONTECIMENTO, DS_ACONTECIMENTO, NM_ACONTECIMENTO, DT_ACONTECIMENTO, BL_ALTERNATIVO, URL_FOTO, TIMELINE)
    VALUES (SQ_T_BTTF_ACONTECIMENTO.NEXTVAL,
    'Aconselhado pelo Doc Brown, Marty incentiva seu pai a conquistar sua mae a fim de desfazer a alteraçao que provocou e
    restaurar sua existencia e de seus irmaos.', 'Corrigindo o Passado', TO_DATE ('05/11/1955', 'DD/MM/YYYY'), 1,
    'https://cdn.discordapp.com/attachments/706640489956245516/778097560639766538/unknown.png',
    2);
    
    INSERT INTO T_BTTF_CONSEQUENCIA
    (ID_CONSEQUENCIA, ID_ACONTECIMENTO, DS_CONSEQUENCIA)
    VALUES (SQ_T_BTTF_CONSEQUENCIA.NEXTVAL, SQ_T_BTTF_ACONTECIMENTO.CURRVAL,
    'George recebe os concelhos de Marty sobre romance e sobre a vida, o que começa a mudar a concepçao de George sobre si e o sobre o mundo.');
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_ACONTECIMENTO
    (ID_ACONTECIMENTO, DS_ACONTECIMENTO, NM_ACONTECIMENTO, DT_ACONTECIMENTO, BL_ALTERNATIVO, URL_FOTO, TIMELINE)
    VALUES (SQ_T_BTTF_ACONTECIMENTO.NEXTVAL,
    'Num ato combinado de coragem, George vai ate o carro onde estariam Marty e Lorraine, mas acaba encontrando Biff
    abusando dela. George nocauteia Biff e salva Lorraine.', 'O começo de um novo Futuro', TO_DATE ('05/11/1955', 'DD/MM/YYYY'), 1,
    'https://cdn.discordapp.com/attachments/706640489956245516/778098618606944257/unknown.png',
    2);
    
    INSERT INTO T_BTTF_CONSEQUENCIA
    (ID_CONSEQUENCIA, ID_ACONTECIMENTO, DS_CONSEQUENCIA)
    VALUES (SQ_T_BTTF_CONSEQUENCIA.NEXTVAL, SQ_T_BTTF_ACONTECIMENTO.CURRVAL,
    'George conquista sua autoconfiança, a partir desse ponto o futuro dos McFly começa a mudar.
    <br>Lorraine ve George com outros olhos, dispertando seus sentimentos por ele.
    <br>Biff percebe que George nao mais e o covarde que humilhava, e a relaçao entre os dois nunca mais seria a mesma.');
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_ACONTECIMENTO
    (ID_ACONTECIMENTO, DS_ACONTECIMENTO, NM_ACONTECIMENTO, DT_ACONTECIMENTO, BL_ALTERNATIVO, URL_FOTO, TIMELINE)
    VALUES (SQ_T_BTTF_ACONTECIMENTO.NEXTVAL,
    'Durante o baile, Marty cobria o guitarrista da banda e apos ver seus pais finalmente apaixonados, Marty
    e a banda tocam uma ultima musica, "Johnny B. Goode", que se quer existia na epoca. Marvin liga para o primo,
    Chuck Berry, que "pega a musica pra si".', 'Go Johnny Go!', TO_DATE ('05/11/1955', 'DD/MM/YYYY'), 1,
    'https://cdn.discordapp.com/attachments/706640489956245516/778100907337711626/unknown.png',
    2);
    
    INSERT INTO T_BTTF_CONSEQUENCIA
    (ID_CONSEQUENCIA, ID_ACONTECIMENTO, DS_CONSEQUENCIA)
    VALUES (SQ_T_BTTF_CONSEQUENCIA.NEXTVAL, SQ_T_BTTF_ACONTECIMENTO.CURRVAL,
    'Ao ver Marty tocando a musica inedita, Marvin liga para o primo, Chuck Berry que compoe, entao, a cançao "Johnny B Goode" que se tornaria um dos maiores classicos de todos os tempos e o imortalizaria um dos guitarrista mais influentes da historia.');
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_ACONTECIMENTO
    (ID_ACONTECIMENTO, DS_ACONTECIMENTO, NM_ACONTECIMENTO, DT_ACONTECIMENTO, BL_ALTERNATIVO, URL_FOTO, TIMELINE)
    VALUES (SQ_T_BTTF_ACONTECIMENTO.NEXTVAL,
    'Sabendo do raio que cairia na torre do relogio, Marty e Doc Brown utilizam da energia do raio para alimentar o DeLorean e mandar Marty de volta pro futuro.', 'De volta para o Futuro', TO_DATE ('05/11/1955', 'DD/MM/YYYY'), 1,
    'https://cdn.discordapp.com/attachments/706640489956245516/778101940194246676/unknown.png',
    2);
    
    INSERT INTO T_BTTF_CONSEQUENCIA
    (ID_CONSEQUENCIA, ID_ACONTECIMENTO, DS_CONSEQUENCIA)
    VALUES (SQ_T_BTTF_CONSEQUENCIA.NEXTVAL, SQ_T_BTTF_ACONTECIMENTO.CURRVAL,
    'Com o impacto do raio, o relogio da torre para de funcionar.');
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_ACONTECIMENTO
    (ID_ACONTECIMENTO, DS_ACONTECIMENTO, NM_ACONTECIMENTO, DT_ACONTECIMENTO, BL_ALTERNATIVO, URL_FOTO, TIMELINE)
    VALUES (SQ_T_BTTF_ACONTECIMENTO.NEXTVAL,
    'Afim de evitar que o pior aconteça, Marty entrega ao Doc Brown uma carta alertando-o sobre o ataque dos traficantes libios.
    Mas a carta e rasgada pelo Doc, que insiste em nao aceitar informaçoes do futuro temendo causar catastrofes maiores.', 'Um bom conselho', TO_DATE ('05/11/1955', 'DD/MM/YYYY'), 1,
    'https://cdn.discordapp.com/attachments/706640489956245516/778392536875663394/unknown.png',
    2);
    
    INSERT INTO T_BTTF_CONSEQUENCIA
    (ID_CONSEQUENCIA, ID_ACONTECIMENTO, DS_CONSEQUENCIA)
    VALUES (SQ_T_BTTF_CONSEQUENCIA.NEXTVAL, SQ_T_BTTF_ACONTECIMENTO.CURRVAL,
    'Apos as tentativas falhas de avisar-lo, Marty se surpreende ao ver que Doc Brown tomou as providencias para evitar seu assassinato, vestindo um colete balistico e sobrevivendo, assim, ao ataque dos traficantes.');
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_ACONTECIMENTO
    (ID_ACONTECIMENTO, DS_ACONTECIMENTO, NM_ACONTECIMENTO, DT_ACONTECIMENTO, BL_ALTERNATIVO, URL_FOTO, TIMELINE)
    VALUES (SQ_T_BTTF_ACONTECIMENTO.NEXTVAL,
    'Marty retorna para 1985 e se depara com as consequencias de suas alteraçoes: sua familia
    esta otima, seus irmaos tem bons empregos, seus pais levam um relacionamento e uma vida
    muito mais saudavel e bem sucedida.', '1985 Prospero', TO_DATE ('05/11/1955', 'DD/MM/YYYY'), 1,
    'https://www.thedad.com/wp-content/uploads/2019/06/Screen-Shot-2019-06-05-at-5.03.51-PM.png?w=640',
    2);
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO T_BTTF_ACONTECIMENTO
    (ID_ACONTECIMENTO, DS_ACONTECIMENTO, NM_ACONTECIMENTO, DT_ACONTECIMENTO, BL_ALTERNATIVO, URL_FOTO, TIMELINE)
    VALUES (SQ_T_BTTF_ACONTECIMENTO.NEXTVAL,
    'Doc Brown parte sozinho em uma viagem para 2015 afim de obter informaçoes sobre o futuro.
    Mas oque ele descobre faz com que volte para 1985 buscando a ajuda de Marty, que embarca com ele de volta a 2015 para evitar uma catastrofe envolvendo os filhos de Marty e Jennifer.', 'Um pe em 2015', TO_DATE ('05/11/1955', 'DD/MM/YYYY'), 1,
    'https://cdn.discordapp.com/attachments/706640489956245516/778396004457512976/unknown.png',
    2);
    
    INSERT INTO T_BTTF_CONSEQUENCIA
    (ID_CONSEQUENCIA, ID_ACONTECIMENTO, DS_CONSEQUENCIA)
    VALUES (SQ_T_BTTF_CONSEQUENCIA.NEXTVAL, SQ_T_BTTF_ACONTECIMENTO.CURRVAL,
    'Doc Brown, Marty, Jennifer e Einstein embarcam no DeLorean rumo a 2015 para concertar o futuro. <br>Biff ve o DeLorean levantar voo e desaparecer num clarao no ceu, o que gera consequencias gravissimas para aquela timeline.');
    
    
    ------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 nao prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'MARTY MCFLY'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 nao prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'EMMETT LATHROP BROWN'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 nao prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'LORRAINE BAINES MCFLY'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 nao prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'GEORGE DOUGLAS MCFLY (Alternativo)'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 nao prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'BIFF HOWARD TANNEN' ));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 nao prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'JENNIFER JANE PARKER'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 nao prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'DAVE MCFLY'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 nao prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'LINDA MCFLY'));
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'A primeira viagem no tempo'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'EINSTEIN'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'A primeira viagem no tempo'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'EMMETT LATHROP BROWN'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'A primeira viagem no tempo'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'MARTY MCFLY'));
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Ataque Libio'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'EMMETT LATHROP BROWN'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Ataque Libio'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'MARTY MCFLY'));
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Reencontro Familiar'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'MARTY MCFLY'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Reencontro Familiar'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'GEORGE DOUGLAS MCFLY (1955)'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Reencontro Familiar'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'BIFF HOWARD TANNEN (1955)'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Reencontro Familiar'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'GOLDIE WILSON'));
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Paixao Acidental'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'MARTY MCFLY'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Paixao Acidental'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'LORRAINE BAINES (1955)'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Paixao Acidental'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'GEORGE DOUGLAS MCFLY (1955)'));
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Invençao da viagem no tempo'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'EMMETT LATHROP BROWN (1955)'));
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Corrigindo o Passado'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'MARTY MCFLY'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Corrigindo o Passado'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'GEORGE DOUGLAS MCFLY (1955)'));
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'O começo de um novo Futuro'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'MARTY MCFLY'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'O começo de um novo Futuro'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'LORRAINE BAINES (1955)'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'O começo de um novo Futuro'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'GEORGE DOUGLAS MCFLY (1955)'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'O começo de um novo Futuro'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'BIFF HOWARD TANNEN (1955)'));
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Go Johnny Go!'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'MARTY MCFLY'));
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'De volta para o Futuro'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'MARTY MCFLY'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'De volta para o Futuro'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'EMMETT LATHROP BROWN (1955)'));
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Um bom conselho'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'MARTY MCFLY'));
    
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Um bom conselho'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'EMMETT LATHROP BROWN (1955)'));
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 Prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'MARTY MCFLY'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 Prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'EMMETT LATHROP BROWN'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 Prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'LORRAINE BAINES MCFLY (Alternativa)'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 Prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'GEORGE DOUGLAS MCFLY (Alternativo)'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 Prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'BIFF HOWARD TANNEN (Alternativo)'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 Prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'JENNIFER JANE PARKER'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 Prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'DAVE MCFLY (Alternativo)'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 Prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'LINDA MCFLY (Alternativa)'));
    
    ------------------------------------------------------------------------------------------------------------
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Um pe em 2015'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'MARTY MCFLY'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Um pe em 2015'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'EMMETT LATHROP BROWN'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Um pe em 2015'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'JENNIFER JANE PARKER'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = 'Um pe em 2015'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'EINSTEIN'));
    
    INSERT INTO t_bttf_personagem_acont
    (ID_PERSONAGEM_ACONT, ID_ACONTECIMENTO, ID_PERSONAGEM)
    VALUES (SQ_T_BTTF_PERSONAGEM_ACONT.NEXTVAL,
    	(SELECT (ID_ACONTECIMENTO) FROM T_BTTF_ACONTECIMENTO WHERE NM_ACONTECIMENTO = '1985 Prospero'),
    	(SELECT (ID_PERSONAGEM) FROM T_BTTF_PERSONAGEM WHERE NM_PERSONAGEM = 'BIFF HOWARD TANNEN (Alternativo)'));
    
    commit;
