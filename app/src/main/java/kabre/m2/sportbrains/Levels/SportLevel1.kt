package kabre.m2.sportbrains.Levels

import kabre.m2.sportbrains.Model.QuestionModel

class SportLevel1 {

    fun questionListFoot1(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur a remporté le plus de Ballons d'Or ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Michel Platini",
                "Johan Cruyff",
                "a",
                5,
                "ballons_or",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quelle équipe a remporté la Coupe du Monde 2018 ?",
                "Allemagne",
                "Brésil",
                "France",
                "Croatie",
                "c",
                5,
                "coupe_monde_2018",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Qui est le meilleur buteur de l'histoire de la Ligue des Champions ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Raúl González",
                "Robert Lewandowski",
                "b",
                5,
                "buter",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel club a remporté le plus de titres de Ligue des Champions ?",
                "FC Barcelone",
                "Bayern Munich",
                "AC Milan",
                "Real Madrid",
                "d",
                5,
                "titres",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel joueur a marqué le but de la main, surnommé 'La main de Dieu' ?",
                "Diego Maradona",
                "Pelé",
                "Zinedine Zidane",
                "David Beckham",
                "a",
                5,
                "main_dieu",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel est le stade principal de l'équipe nationale d'Angleterre ?",
                "Old Trafford",
                "Anfield",
                "Wembley",
                "Emirates Stadium",
                "c",
                5,
                "stade",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quelle équipe nationale est surnommée 'La Seleção' ?",
                "Argentine",
                "Italie",
                "Brésil",
                "Espagne",
                "c",
                5,
                "brasil_2014",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel pays a accueilli la Coupe du Monde 2014 ?",
                "Afrique du Sud",
                "Brésil",
                "Allemagne",
                "Russie",
                "b",
                5,
                "brasil_2014",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Qui détient le record du plus grand nombre de buts en une saison de Premier League ?",
                "Thierry Henry",
                "Erling Haaland",
                "Alan Shearer",
                "Harry Kane",
                "b",
                5,
                "record",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel club a remporté la Ligue 1 française pour la saison 2022-2023 ?",
                "Olympique de Marseille",
                "AS Monaco",
                "Lille OSC",
                "Paris Saint-Germain",
                "d",
                5,
                "club",
                null
            )
        )
        return question
    }

    fun questionListFoot2(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur détient le record du plus grand nombre de buts marqués en une seule Coupe du Monde ?",
                "Just Fontaine",
                "Gerd Müller",
                "Ronaldo",
                "Miroslav Klose",
                "a",
                5,
                "record",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quelle équipe a remporté la première Coupe du Monde en 1930 ?",
                "Argentine",
                "Uruguay",
                "Brésil",
                "Italie",
                "b",
                10,
                "premiere_cup",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel entraîneur a remporté le plus de Ligues des Champions ?",
                "Alex Ferguson",
                "Carlo Ancelotti",
                "Zinedine Zidane",
                "Pep Guardiola",
                "b",
                10,
                "titres",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel joueur est surnommé 'El Fenómeno' ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Ronaldinho",
                "Ronaldo Nazário",
                "d",
                10,
                "record",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel pays a remporté l'Euro 2016 ?",
                "Espagne",
                "Portugal",
                "France",
                "Italie",
                "b",
                5,
                "euro",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel joueur a marqué le but le plus rapide en Coupe du Monde ?",
                "Hakan Şükür",
                "Pelé",
                "Kylian Mbappé",
                "Cristiano Ronaldo",
                "a",
                5,
                "record",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel club est surnommé 'Les Reds' ?",
                "Manchester United",
                "Liverpool",
                "Arsenal",
                "Chelsea",
                "b",
                5,
                "red",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel pays a remporté le plus de Coupes d'Afrique des Nations (CAN) ?",
                "Cameroun",
                "Égypte",
                "Nigeria",
                "Côte d'Ivoire",
                "b",
                5,
                "african_cup",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel joueur a remporté le plus de fois la Ligue des Champions ?",
                "Cristiano Ronaldo",
                "Lionel Messi",
                "Francisco Gento",
                "Clarence Seedorf",
                "c",
                5,
                "joueur_ligue",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel club a remporté la Premier League 2022-2023 ?",
                "Manchester City",
                "Liverpool",
                "Chelsea",
                "Manchester United",
                "a",
                5,
                "premiere_ligue",
                null
            )
        )

        return question
    }

    fun questionListFoot3(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur a marqué le but décisif pour l'Allemagne en finale de la Coupe du Monde 2014 ?",
                "Mario Götze",
                "Thomas Müller",
                "Miroslav Klose",
                "Mesut Özil",
                "a",
                5,
                "jbr",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel club est surnommé 'Les Blaugranas' ?",
                "Real Madrid",
                "FC Barcelone",
                "Atlético Madrid",
                "Valence CF",
                "b",
                5,
                "cbd",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel pays a remporté la Copa América en 2021 ?",
                "Brésil",
                "Argentine",
                "Chili",
                "Uruguay",
                "b",
                5,
                "ca",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel joueur est le plus jeune à avoir remporté le Ballon d'Or ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Michael Owen",
                "Kylian Mbappé",
                "c",
                5,
                "ballons_or",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel club est surnommé 'La Vieille Dame' ?",
                "AC Milan",
                "Inter Milan",
                "Juventus",
                "Naples",
                "c",
                5,
                "vd",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel joueur a marqué le plus de buts en une seule saison de Liga ?",
                "Cristiano Ronaldo",
                "Lionel Messi",
                "Luis Suárez",
                "Karim Benzema",
                "b",
                5,
                "record",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quelle équipe a remporté le plus de fois la Copa Libertadores ?",
                "Boca Juniors",
                "River Plate",
                "São Paulo",
                "Independiente",
                "d",
                5,
                "liberda",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel pays a remporté la Coupe du Monde féminine en 2019 ?",
                "Allemagne",
                "États-Unis",
                "Japon",
                "Pays-Bas",
                "b",
                5,
                "bf",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel joueur a remporté le plus de titres en Premier League ?",
                "Frank Lampard",
                "Steven Gerrard",
                "Ryan Giggs",
                "Paul Scholes",
                "c",
                5,
                "rg",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel joueur est le meilleur buteur de l'histoire de l'équipe nationale du Portugal ?",
                "Eusébio",
                "Pauleta",
                "Cristiano Ronaldo",
                "Luis Figo",
                "c",
                5,
                "record",
                null
            )
        )

        return question
    }

    fun questionListFoot4(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur a remporté le plus de fois la Coupe d'Afrique des Nations (CAN) ?",
                "Samuel Eto'o",
                "Didier Drogba",
                "Yaya Touré",
                "Essam El-Hadary",
                "d",
                5,
                "african_cup",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel stade est surnommé 'La Bombonera' ?",
                "Maracanã",
                "Camp Nou",
                "San Siro",
                "Estadio Alberto J. Armando",
                "d",
                5,
                "stade",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel joueur a été surnommé 'Le Roi Pelé' ?",
                "Diego Maradona",
                "Pelé",
                "Zico",
                "Romário",
                "b",
                5,
                "roi",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel club a remporté la Série A italienne pour la saison 2022-2023 ?",
                "Inter Milan",
                "AC Milan",
                "Juventus",
                "Naples",
                "d",
                5,
                "saitali",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel joueur a marqué le plus de buts en une seule Coupe du Monde féminine ?",
                "Marta",
                "Birgit Prinz",
                "Michelle Akers",
                "Abby Wambach",
                "c",
                5,
                "record",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel club a remporté le plus de titres en Bundesliga ?",
                "Borussia Dortmund",
                "Hambourg SV",
                "Bayern Munich",
                "Borussia Mönchengladbach",
                "c",
                5,
                "q_36",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel pays a remporté la Coupe d'Asie des nations en 2019 ?",
                "Australie",
                "Japon",
                "Corée du Sud",
                "Qatar",
                "d",
                5,
                "q_37",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel joueur a été le premier à atteindre 100 buts en Ligue des Champions ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Raúl González",
                "Karim Benzema",
                "b",
                5,
                "q_38",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel joueur a remporté le Golden Foot en 2021 ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Robert Lewandowski",
                "Luka Modrić",
                "b",
                5,
                "q_39",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel club a remporté la Ligue des Champions de l'AFC en 2020 ?",
                "Al-Hilal",
                "Guangzhou Evergrande",
                "Jeonbuk Hyundai Motors",
                "Ulsan Hyundai",
                "d",
                5,
                "q_40",
                null
            )
        )


        return question
    }

    fun questionListFoot5(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur a remporté le Soulier d'Or européen en 2021 ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Robert Lewandowski",
                "Kylian Mbappé",
                "c",
                5,
                "q_41",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel club est surnommé 'Les Gunners' ?",
                "Chelsea",
                "Manchester City",
                "Arsenal",
                "Tottenham Hotspur",
                "c",
                5,
                "q_42",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel pays a remporté la Coupe du Monde 2010 ?",
                "Allemagne",
                "Brésil",
                "Espagne",
                "Pays-Bas",
                "c",
                5,
                "q_43",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel joueur a marqué le plus de buts en une seule saison de Bundesliga ?",
                "Gerd Müller",
                "Robert Lewandowski",
                "Klaus Fischer",
                "Timo Werner",
                "b",
                5,
                "q_44",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel club a remporté le plus de titres en Ligue 1 française ?",
                "Paris Saint-Germain",
                "Marseille",
                "Lyon",
                "Saint-Étienne",
                "d",
                5,
                "q_45",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel joueur a été le premier à remporter trois Coupes du Monde ?",
                "Diego Maradona",
                "Pelé",
                "Zinedine Zidane",
                "Franz Beckenbauer",
                "b",
                5,
                "q_46",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel club est surnommé 'Les Rossoneri' ?",
                "Inter Milan",
                "AC Milan",
                "Juventus",
                "Naples",
                "b",
                5,
                "q_47",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel pays a remporté le plus de titres de Copa América ?",
                "Brésil",
                "Argentine",
                "Uruguay",
                "Colombie",
                "c",
                5,
                "q_48",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel joueur a remporté le premier Ballon d'Or en 1956 ?",
                "Stanley Matthews",
                "Alfredo Di Stéfano",
                "Raymond Kopa",
                "Ferenc Puskás",
                "a",
                5,
                "q_49",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel club a remporté la Ligue Europa en 2021 ?",
                "Villarreal CF",
                "Manchester United",
                "Sevilla FC",
                "AS Roma",
                "a",
                5,
                "q_50",
                null
            )
        )

        return question
    }

    fun questionListFoot6(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur détient le record du plus grand nombre de sélections en équipe nationale ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Ahmed Hassan",
                "Sergio Ramos",
                "b",
                5,
                "q_51",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel joueur est surnommé 'El Pibe de Oro' ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Diego Maradona",
                "Carlos Tevez",
                "c",
                5,
                "q_52",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel club a remporté le plus de titres en Serie A italienne ?",
                "Inter Milan",
                "AC Milan",
                "Juventus",
                "AS Roma",
                "c",
                5,
                "q_53",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel pays a remporté le Championnat d'Europe des Nations en 2004 ?",
                "Portugal",
                "Grèce",
                "France",
                "Italie",
                "b",
                5,
                "q_54",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel joueur est le meilleur buteur de l'histoire de l'équipe nationale brésilienne ?",
                "Pelé",
                "Ronaldo",
                "Neymar",
                "Romário",
                "c",
                5,
                "q_55",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel club a remporté le plus de fois la FA Cup ?",
                "Arsenal",
                "Manchester United",
                "Chelsea",
                "Liverpool",
                "a",
                5,
                "q_56",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel joueur a remporté le plus de fois le Ballon d'Or Féminin ?",
                "Marta",
                "Ada Hegerberg",
                "Megan Rapinoe",
                "Alexia Putellas",
                "d",
                5,
                "q_57",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel pays a remporté la Coupe du Monde des moins de 20 ans en 2019 ?",
                "Argentine",
                "Portugal",
                "Ukraine",
                "Corée du Sud",
                "c",
                5,
                "q_58",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel joueur a marqué le plus de buts en une seule saison de Premier League ?",
                "Thierry Henry",
                "Mohamed Salah",
                "Alan Shearer",
                "Harry Kane",
                "b",
                5,
                "q_59",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel club a remporté la Ligue des Champions de l'AFC en 2021 ?",
                "Al-Hilal",
                "Guangzhou Evergrande",
                "Jeonbuk Hyundai Motors",
                "Ulsan Hyundai",
                "a",
                5,
                "q_60",
                null
            )
        )

        return question
    }

    fun questionListFoot7(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur a remporté le premier FIFA World Player de l'année en 1991 ?",
                "Marco van Basten",
                "Lothar Matthäus",
                "Romário",
                "George Weah",
                "b",
                5,
                "q_61",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel club est surnommé 'Les Blues' ?",
                "Manchester City",
                "Chelsea",
                "Everton",
                "Leicester City",
                "b",
                5,
                "q_62",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel pays a remporté le premier Championnat d'Europe en 1960 ?",
                "Espagne",
                "Italie",
                "Union soviétique",
                "Allemagne de l'Ouest",
                "c",
                5,
                "q_63",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel joueur est surnommé 'Il Capitano' ?",
                "Franco Baresi",
                "Alessandro Del Piero",
                "Francesco Totti",
                "Paolo Maldini",
                "d",
                5,
                "q_64",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel club a remporté le plus de titres en Major League Soccer (MLS) ?",
                "LA Galaxy",
                "Seattle Sounders",
                "DC United",
                "Toronto FC",
                "a",
                5,
                "q_65",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel joueur est le meilleur buteur de l'histoire de l'équipe nationale allemande ?",
                "Gerd Müller",
                "Miroslav Klose",
                "Jürgen Klinsmann",
                "Lukas Podolski",
                "b",
                5,
                "q_66",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel club a remporté le plus de fois le championnat du Brésil (Brasileirão) ?",
                "São Paulo",
                "Palmeiras",
                "Flamengo",
                "Corinthians",
                "b",
                5,
                "q_67",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel pays a remporté le plus de titres de la Gold Cup ?",
                "Mexique",
                "États-Unis",
                "Costa Rica",
                "Canada",
                "a",
                5,
                "q_68",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel joueur est surnommé 'Le Fenomeno' ?",
                "Zlatan Ibrahimović",
                "Cristiano Ronaldo",
                "Ronaldo Nazário",
                "Ronaldinho",
                "c",
                5,
                "q_69",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel club a remporté le plus de fois la Coupe de la Ligue française ?",
                "Paris Saint-Germain",
                "Marseille",
                "Bordeaux",
                "Monaco",
                "a",
                5,
                "q_70",
                null
            )
        )


        return question
    }

    fun questionListFoot8(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur a été le premier à remporter le Ballon d'Or Africain ?",
                "George Weah",
                "Roger Milla",
                "Samuel Eto'o",
                "Salif Keita",
                "d",
                5,
                "q_71",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel club a remporté le plus de titres en Ligue des Champions féminine de l'UEFA ?",
                "Lyon",
                "Paris Saint-Germain",
                "Wolfsburg",
                "Chelsea",
                "a",
                5,
                "q_72",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel pays a remporté la première édition de la Coupe du Monde des clubs en 2000 ?",
                "Brésil",
                "Argentine",
                "Espagne",
                "Italie",
                "a",
                5,
                "q_73",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel joueur a remporté le plus de fois le prix Puskás du plus beau but de l'année ?",
                "Cristiano Ronaldo",
                "Neymar",
                "Lionel Messi",
                "Zlatan Ibrahimović",
                "c",
                5,
                "q_74",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel club a remporté le plus de fois le championnat d'Espagne (La Liga) ?",
                "FC Barcelone",
                "Atlético Madrid",
                "Valence CF",
                "Real Madrid",
                "d",
                5,
                "q_75",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel joueur a remporté le plus de fois le Ballon d'Or sans jamais gagner la Coupe du Monde ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Johan Cruyff",
                "Michel Platini",
                "b",
                5,
                "q_76",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel pays a remporté le plus de titres de la Coupe du Monde féminine ?",
                "Allemagne",
                "États-Unis",
                "Japon",
                "Norvège",
                "b",
                5,
                "q_77",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel joueur a marqué le but le plus rapide en finale de la Ligue des Champions ?",
                "Paolo Maldini",
                "Steven Gerrard",
                "Karim Benzema",
                "Cristiano Ronaldo",
                "a",
                5,
                "q_78",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel club a remporté le plus de titres en Super Lig turque ?",
                "Fenerbahçe",
                "Galatasaray",
                "Beşiktaş",
                "Trabzonspor",
                "b",
                5,
                "q_79",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel joueur a remporté le prix du meilleur jeune joueur de la Coupe du Monde 2018 ?",
                "Kylian Mbappé",
                "Paul Pogba",
                "Harry Kane",
                "Eden Hazard",
                "a",
                5,
                "q_80",
                null
            )
        )


        return question
    }

    fun questionListFoot9(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()

        question.add(
            QuestionModel(
                81,
                "Quel joueur a marqué le plus de buts en une seule Coupe du Monde ?",
                "Miroslav Klose",
                "Just Fontaine",
                "Pelé",
                "Ronaldo",
                "b",
                5,
                "q_81",
                null
            )
        )

        question.add(
            QuestionModel(
                82,
                "Quel club a remporté le plus de titres en Eredivisie néerlandaise ?",
                "PSV Eindhoven",
                "Ajax Amsterdam",
                "Feyenoord",
                "AZ Alkmaar",
                "b",
                5,
                "q_82",
                null
            )
        )

        question.add(
            QuestionModel(
                83,
                "Quel pays a remporté la Coupe du Monde des moins de 17 ans en 2019 ?",
                "Brésil",
                "Mexique",
                "Nigéria",
                "France",
                "a",
                5,
                "q_83",
                null
            )
        )

        question.add(
            QuestionModel(
                84,
                "Quel joueur a remporté le plus de fois le prix du meilleur joueur africain de l'année ?",
                "George Weah",
                "Didier Drogba",
                "Samuel Eto'o",
                "Yaya Touré",
                "c",
                5,
                "q_84",
                null
            )
        )

        question.add(
            QuestionModel(
                85,
                "Quel club a remporté le plus de fois la Ligue des Champions de la CONCACAF ?",
                "Club América",
                "Cruz Azul",
                "Monterrey",
                "Guadalajara",
                "a",
                5,
                "q_85",
                null
            )
        )

        question.add(
            QuestionModel(
                86,
                "Quel joueur est le plus capé de l'histoire du FC Barcelone ?",
                "Xavi Hernandez",
                "Lionel Messi",
                "Andrés Iniesta",
                "Carles Puyol",
                "b",
                5,
                "q_86",
                null
            )
        )

        question.add(
            QuestionModel(
                87,
                "Quel pays a remporté le premier Championnat d'Europe féminin en 1984 ?",
                "Allemagne",
                "Suède",
                "Norvège",
                "France",
                "b",
                5,
                "q_87",
                null
            )
        )

        question.add(
            QuestionModel(
                88,
                "Quel joueur a remporté le plus de fois le prix du meilleur joueur de l'année de la FIFA (The Best) ?",
                "Cristiano Ronaldo",
                "Lionel Messi",
                "Robert Lewandowski",
                "Luka Modrić",
                "b",
                5,
                "q_88",
                null
            )
        )

        question.add(
            QuestionModel(
                89,
                "Quel club a remporté le plus de fois la Ligue des Champions africaine ?",
                "Espérance de Tunis",
                "Al Ahly",
                "Raja Casablanca",
                "Zamalek",
                "b",
                5,
                "q_89",
                null
            )
        )

        question.add(
            QuestionModel(
                90,
                "Quel pays a remporté la Coupe des Confédérations en 2013 ?",
                "Brésil",
                "Espagne",
                "Allemagne",
                "Italie",
                "a",
                5,
                "q_90",
                null
            )
        )

        return question
    }

    fun questionListFoot10(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()

        question.add(
            QuestionModel(
                1,
                "Quel joueur a remporté le plus de fois le Golden Foot ?",
                "Cristiano Ronaldo",
                "Lionel Messi",
                "Francesco Totti",
                "Ronaldinho",
                "c",
                5,
                "q_91",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel club a remporté le plus de titres en Primeira Liga portugaise ?",
                "Sporting CP",
                "Porto",
                "Benfica",
                "Braga",
                "c",
                5,
                "q_92",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel joueur est surnommé 'Le Phénomène' ?",
                "Cristiano Ronaldo",
                "Zlatan Ibrahimović",
                "Ronaldinho",
                "Ronaldo Nazário",
                "d",
                5,
                "q_93",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel pays a remporté le Championnat d'Europe des moins de 21 ans en 2021 ?",
                "Allemagne",
                "Portugal",
                "Espagne",
                "France",
                "a",
                5,
                "q_94",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel club a remporté le plus de fois la Ligue des Champions de l'OFC ?",
                "Waitakere United",
                "Team Wellington",
                "Hienghène Sport",
                "Auckland City",
                "d",
                5,
                "q_95",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel joueur a remporté le plus de fois le Soulier d'Or de la Jupiler Pro League belge ?",
                "Eden Hazard",
                "Romelu Lukaku",
                "Jan Ceulemans",
                "Vincent Kompany",
                "c",
                5,
                "q_96",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel club a remporté le plus de fois la Copa Libertadores ?",
                "River Plate",
                "Boca Juniors",
                "Independiente",
                "Santos",
                "c",
                5,
                "q_97",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel joueur a marqué le but le plus rapide en Coupe du Monde ?",
                "Pele",
                "Cristiano Ronaldo",
                "Hakan Şükür",
                "Lionel Messi",
                "c",
                5,
                "q_98",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel club est surnommé 'Les Red Devils' ?",
                "Liverpool",
                "Manchester City",
                "Manchester United",
                "Arsenal",
                "c",
                5,
                "q_99",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel joueur a remporté le prix du meilleur gardien de but de la FIFA en 2021 ?",
                "Thibaut Courtois",
                "Manuel Neuer",
                "Ederson",
                "Gianluigi Donnarumma",
                "d",
                5,
                "q_100",
                null
            )
        )

        return question
    }

    fun questionListFoot11(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur a remporté le premier Ballon d'Or féminin en 2018 ?",
                "Marta",
                "Alex Morgan",
                "Ada Hegerberg",
                "Megan Rapinoe",
                "c",
                5,
                "q_101",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel pays a remporté le premier tournoi de la Copa América en 1916 ?",
                "Argentine",
                "Brésil",
                "Uruguay",
                "Chili",
                "c",
                5,
                "q_102",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel joueur a marqué le plus de buts en une seule saison de la Ligue des Champions de l'UEFA ?",
                "Cristiano Ronaldo",
                "Lionel Messi",
                "Robert Lewandowski",
                "Karim Benzema",
                "a",
                5,
                "q_103",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel club a remporté le plus de titres en Bundesliga allemande ?",
                "Borussia Dortmund",
                "Bayern Munich",
                "Hambourg SV",
                "Werder Brême",
                "b",
                5,
                "q_104",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel pays a remporté la Coupe du Monde des moins de 20 ans féminine en 2018 ?",
                "Allemagne",
                "États-Unis",
                "Japon",
                "Espagne",
                "c",
                5,
                "q_105",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel joueur a remporté le prix du meilleur jeune joueur de l'année de la FIFA en 2020 ?",
                "Erling Haaland",
                "Jadon Sancho",
                "Alphonso Davies",
                "Ansu Fati",
                "c",
                5,
                "q_106",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel club a remporté le plus de titres en Super League grecque ?",
                "AEK Athènes",
                "PAOK Salonique",
                "Panathinaïkos",
                "Olympiakos",
                "d",
                5,
                "q_107",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel pays a remporté le plus de titres en Coupe d'Afrique des Nations ?",
                "Cameroun",
                "Égypte",
                "Nigeria",
                "Ghana",
                "b",
                5,
                "q_108",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel joueur a marqué le but le plus rapide en Premier League ?",
                "Sadio Mané",
                "Alan Shearer",
                "Christian Benteke",
                "Shane Long",
                "d",
                5,
                "q_109",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel club a remporté le plus de fois la Ligue des Champions féminine de la CONCACAF ?",
                "UANL Tigres",
                "Monterrey",
                "Houston Dash",
                "North Carolina Courage",
                "a",
                5,
                "q_110",
                null
            )
        )


        return question
    }

    fun questionListFoot12(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()

        question.add(
            QuestionModel(
                1,
                "Quel joueur a marqué le plus de buts en une seule Coupe du Monde ?",
                "Miroslav Klose",
                "Just Fontaine",
                "Pelé",
                "Ronaldo",
                "b",
                5,
                "q_111",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel club a remporté le plus de titres en Ligue 1 française ?",
                "Marseille",
                "Lyon",
                "Saint-Étienne",
                "Paris Saint-Germain",
                "d",
                5,
                "q_112",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel pays a remporté le premier Championnat d'Europe féminin en 1984 ?",
                "Allemagne",
                "Suède",
                "Norvège",
                "France",
                "b",
                5,
                "q_113",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel joueur a remporté le prix du meilleur joueur de la Copa América en 2019 ?",
                "Lionel Messi",
                "James Rodríguez",
                "Everton",
                "Gabriel Jesus",
                "c",
                5,
                "q_114",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel club a remporté le plus de titres en J.League japonaise ?",
                "Yokohama F. Marinos",
                "Kashima Antlers",
                "Gamba Osaka",
                "Sanfrecce Hiroshima",
                "b",
                5,
                "q_115",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel pays a remporté le plus de titres en Coupe du Monde des clubs de la FIFA ?",
                "Brésil",
                "Espagne",
                "Italie",
                "Argentine",
                "b",
                5,
                "q_116",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel joueur a remporté le plus de fois le prix du meilleur joueur de la Copa Libertadores ?",
                "Juan Román Riquelme",
                "Pelé",
                "Carlos Tevez",
                "Zico",
                "a",
                5,
                "q_117",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel club a remporté le plus de titres en Scottish Premiership ?",
                "Aberdeen",
                "Celtic",
                "Rangers",
                "Hearts",
                "b",
                5,
                "q_118",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel pays a remporté le Championnat d'Europe des moins de 19 ans en 2019 ?",
                "Portugal",
                "Espagne",
                "Italie",
                "France",
                "d",
                5,
                "q_119",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel joueur a remporté le prix du meilleur jeune joueur de la Copa América en 2011 ?",
                "Neymar",
                "James Rodríguez",
                "Paulo Dybala",
                "Luis Suárez",
                "a",
                5,
                "q_120",
                null
            )
        )

        return question
    }

    fun questionListFoot13(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur a marqué le plus de buts en une saison de Premier League ?",
                "Mohamed Salah",
                "Alan Shearer",
                "Cristiano Ronaldo",
                "Sergio Agüero",
                "a",
                5,
                "q_121",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel club a remporté le plus de titres en Copa del Rey ?",
                "FC Barcelone",
                "Real Madrid",
                "Athletic Bilbao",
                "Atlético Madrid",
                "a",
                5,
                "q_122",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel joueur est le plus capé de l'histoire de l'équipe nationale française ?",
                "Hugo Lloris",
                "Lilian Thuram",
                "Zinedine Zidane",
                "Patrick Vieira",
                "a",
                5,
                "q_123",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel club a remporté le plus de titres en Ligue des Champions de l'UEFA ?",
                "FC Barcelone",
                "AC Milan",
                "Liverpool",
                "Real Madrid",
                "d",
                5,
                "q_124",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel joueur a remporté le plus de fois le Soulier d'Or en Europe ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Eusébio",
                "Gerd Müller",
                "a",
                5,
                "q_125",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel pays a remporté la Coupe d'Afrique des Nations en 2017 ?",
                "Cameroun",
                "Égypte",
                "Ghana",
                "Nigeria",
                "a",
                5,
                "q_126",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel club a remporté le plus de titres en Argentine ?",
                "River Plate",
                "Boca Juniors",
                "Racing Club",
                "Independiente",
                "b",
                5,
                "q_127",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel joueur a remporté le plus de fois le prix du meilleur joueur de l'année en Premier League ?",
                "Cristiano Ronaldo",
                "Sergio Agüero",
                "Frank Lampard",
                "Mohamed Salah",
                "a",
                5,
                "q_128",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel club a remporté le plus de titres en Eredivisie néerlandaise ?",
                "PSV Eindhoven",
                "Ajax Amsterdam",
                "Feyenoord",
                "AZ Alkmaar",
                "b",
                5,
                "q_129",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel joueur a marqué le plus de buts en une seule saison de Serie A ?",
                "Ciro Immobile",
                "Cristiano Ronaldo",
                "Paolo Rossi",
                "Gunnar Nordahl",
                "d",
                5,
                "q_130",
                null
            )
        )


        return question
    }

    fun questionListFoot14(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur a été le plus jeune à marquer un but en Coupe du Monde ?",
                "Pelé",
                "Kylian Mbappé",
                "Johan Cruyff",
                "Gerd Müller",
                "b",
                5,
                "q_131",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel club a remporté le plus de titres en Ligue 1 ?",
                "Lille",
                "Marseille",
                "Paris Saint-Germain",
                "Saint-Étienne",
                "c",
                5,
                "q_132",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel joueur a remporté le Ballon d'Or en 2010 ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Andrés Iniesta",
                "Xavi Hernández",
                "a",
                5,
                "q_133",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel club a remporté le plus de titres en Ligue des Champions de l'UEFA ?",
                "AC Milan",
                "Liverpool",
                "FC Barcelone",
                "Real Madrid",
                "d",
                5,
                "q_134",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel pays a remporté le plus de Coupes du Monde féminines ?",
                "États-Unis",
                "Allemagne",
                "Norvège",
                "Suède",
                "a",
                5,
                "q_135",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel joueur est le meilleur buteur de l'histoire du Real Madrid ?",
                "Raúl",
                "Cristiano Ronaldo",
                "Karim Benzema",
                "Ferenc Puskás",
                "b",
                5,
                "q_136",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel club a remporté le plus de titres en Copa Libertadores ?",
                "Boca Juniors",
                "River Plate",
                "Independiente",
                "Peñarol",
                "c",
                5,
                "q_137",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel joueur a remporté le plus de fois le Soulier d'Or européen ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Eusébio",
                "Gerd Müller",
                "a",
                5,
                "q_138",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel club a remporté le plus de titres en Primeira Liga portugaise ?",
                "Benfica",
                "Porto",
                "Sporting CP",
                "Braga",
                "a",
                5,
                "q_139",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel joueur a marqué le plus de buts en une saison de Bundesliga ?",
                "Robert Lewandowski",
                "Gerd Müller",
                "Klaus Fischer",
                "Ulf Kirsten",
                "a",
                5,
                "q_140",
                null
            )
        )


        return question
    }

    fun questionListFoot15(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur a marqué le plus de buts en une seule saison de Ligue 1 ?",
                "Zlatan Ibrahimović",
                "Kylian Mbappé",
                "Edinson Cavani",
                "Jean-Pierre Papin",
                "c",
                5,
                "q_141",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel pays a remporté la Coupe du Monde de la FIFA en 1966 ?",
                "Angleterre",
                "Allemagne",
                "Brésil",
                "Argentine",
                "a",
                5,
                "q_142",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel club a remporté le plus de titres en Bundesliga allemande ?",
                "Bayern Munich",
                "Borussia Dortmund",
                "Hambourg SV",
                "Werder Brême",
                "a",
                5,
                "q_143",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel joueur a remporté le plus de titres de meilleur buteur en Premier League ?",
                "Alan Shearer",
                "Harry Kane",
                "Sergio Agüero",
                "Cristiano Ronaldo",
                "a",
                5,
                "q_144",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel pays a remporté la Coupe d'Asie en 2019 ?",
                "Qatar",
                "Japon",
                "Corée du Sud",
                "Australie",
                "a",
                5,
                "q_145",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel club a remporté le plus de titres en Ligue des Champions de l'UEFA féminine ?",
                "Lyon",
                "Paris Saint-Germain",
                "Wolfsburg",
                "Arsenal",
                "a",
                5,
                "q_146",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel joueur est le meilleur buteur de l'histoire de la Coupe du Monde ?",
                "Miroslav Klose",
                "Just Fontaine",
                "Pelé",
                "Ronaldo",
                "a",
                5,
                "q_147",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel club a remporté le plus de titres en Serie A italienne ?",
                "Juventus",
                "AC Milan",
                "Inter Milan",
                "Roma",
                "a",
                5,
                "q_148",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel joueur a été élu meilleur joueur de la Coupe du Monde 2022 ?",
                "Lionel Messi",
                "Kylian Mbappé",
                "Luka Modrić",
                "Karim Benzema",
                "a",
                5,
                "q_149",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel joueur a remporté le plus de fois le titre de meilleur joueur de l'année en Ligue 1 ?",
                "Zlatan Ibrahimović",
                "Kylian Mbappé",
                "Thierry Henry",
                "Edinson Cavani",
                "c",
                5,
                "q_150",
                null
            )
        )


        return question
    }

    fun questionListFoot16(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()

        question.add(
            QuestionModel(
                1,
                "Quel joueur a remporté le plus de fois le Prix Puskás du meilleur but de l'année ?",
                "Cristiano Ronaldo",
                "Lionel Messi",
                "Zlatan Ibrahimović",
                "Son Heung-min",
                "b",
                5,
                "q_151",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel club a remporté le plus de titres en Eredivisie néerlandaise ?",
                "Ajax Amsterdam",
                "PSV Eindhoven",
                "Feyenoord",
                "AZ Alkmaar",
                "a",
                5,
                "q_152",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel pays a remporté la Coupe du Monde de la FIFA en 2014 ?",
                "Allemagne",
                "Argentine",
                "Brésil",
                "Pays-Bas",
                "a",
                5,
                "q_153",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel joueur a été le meilleur buteur de la Ligue des Champions en 2021-2022 ?",
                "Karim Benzema",
                "Robert Lewandowski",
                "Mohamed Salah",
                "Kylian Mbappé",
                "a",
                5,
                "q_154",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel club a remporté le plus de fois le FA Cup anglaise ?",
                "Manchester United",
                "Arsenal",
                "Liverpool",
                "Chelsea",
                "b",
                5,
                "q_155",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel joueur est le plus jeune à avoir marqué un but en Ligue des Champions de l'UEFA ?",
                "Anssumane Fati",
                "Kylian Mbappé",
                "Wayne Rooney",
                "Raúl",
                "a",
                5,
                "q_156",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel pays a remporté le Championnat d'Europe des Nations en 2020 ?",
                "Italie",
                "Espagne",
                "Angleterre",
                "France",
                "a",
                5,
                "q_157",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel club a remporté le plus de titres en Super Lig turque ?",
                "Galatasaray",
                "Fenerbahçe",
                "Beşiktaş",
                "Trabzonspor",
                "a",
                5,
                "q_158",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel joueur a été le plus jeune à débuter en tant que capitaine en Coupe du Monde ?",
                "Dino Zoff",
                "Pelé",
                "Diego Maradona",
                "Lionel Messi",
                "a",
                5,
                "q_159",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel club a remporté le plus de titres en Liga espagnole ?",
                "Real Madrid",
                "FC Barcelone",
                "Atlético Madrid",
                "Athletic Bilbao",
                "a",
                5,
                "q_160",
                null
            )
        )

        return question
    }

    fun questionListFoot17(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()

        question.add(
            QuestionModel(
                1,
                "Quel joueur a remporté le plus de fois le titre de meilleur buteur en Serie A italienne ?",
                "Silvio Piola",
                "Gunnar Nordahl",
                "Cristiano Ronaldo",
                "Francesco Totti",
                "b",
                5,
                "q_161",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel pays a remporté la Coupe du Monde de la FIFA en 1930 ?",
                "Uruguay",
                "Argentine",
                "Brésil",
                "Chili",
                "a",
                5,
                "q_162",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel club a remporté le plus de titres en Copa Libertadores au XXIe siècle ?",
                "Boca Juniors",
                "River Plate",
                "Palmeiras",
                "Independiente",
                "c",
                5,
                "q_163",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel joueur a marqué le plus de buts en une seule saison de Liga espagnole ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Telmo Zarra",
                "Raúl",
                "a",
                5,
                "q_164",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel pays a remporté la Coupe d'Afrique des Nations en 2019 ?",
                "Algérie",
                "Sénégal",
                "Cameroun",
                "Maroc",
                "a",
                5,
                "q_165",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel joueur a remporté le plus de fois le Prix du Meilleur Gardien de l'Année de la FIFA ?",
                "Manuel Neuer",
                "Gianluigi Buffon",
                "Thibaut Courtois",
                "Iker Casillas",
                "d",
                5,
                "q_166",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel club a remporté le plus de titres en Primeira Liga portugaise dans les années 2000 ?",
                "Porto",
                "Benfica",
                "Sporting CP",
                "Braga",
                "a",
                5,
                "q_167",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel joueur est le meilleur buteur de l'histoire de l'équipe nationale brésilienne ?",
                "Pelé",
                "Neymar",
                "Romário",
                "Ronaldo",
                "b",
                5,
                "q_168",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel club a remporté le plus de titres en Serie B italienne ?",
                "Palermo",
                "Juventus",
                "Genoa",
                "Bologna",
                "c",
                5,
                "q_169",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel joueur a marqué le plus de buts en une seule saison de Bundesliga ?",
                "Robert Lewandowski",
                "Gerd Müller",
                "Klaus Fischer",
                "Ulf Kirsten",
                "a",
                5,
                "q_170",
                null
            )
        )

        return question
    }

    fun questionListFoot18(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur a marqué le plus de buts en une seule saison de Premier League ?",
                "Mohamed Salah",
                "Alan Shearer",
                "Cristiano Ronaldo",
                "Sergio Agüero",
                "a",
                5,
                "q_171",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel club a remporté le plus de titres en Ligue 1 française ?",
                "Paris Saint-Germain",
                "Marseille",
                "Saint-Étienne",
                "Lille",
                "a",
                5,
                "q_172",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel joueur a remporté le Ballon d'Or en 2006 ?",
                "Fabio Cannavaro",
                "Zinedine Zidane",
                "Ronaldinho",
                "Kaká",
                "a",
                5,
                "q_173",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel pays a remporté la Coupe du Monde en 2018 ?",
                "France",
                "Croatie",
                "Angleterre",
                "Belgique",
                "a",
                5,
                "q_174",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel club a remporté le plus de titres en Liga espagnole au XXIe siècle ?",
                "Real Madrid",
                "FC Barcelone",
                "Atlético Madrid",
                "Valencia",
                "b",
                5,
                "q_175",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel joueur a remporté le plus de fois le Prix du Meilleur Jeune Joueur de l'Année de la FIFA ?",
                "Lionel Messi",
                "Kylian Mbappé",
                "Andrés Iniesta",
                "Cristiano Ronaldo",
                "b",
                5,
                "q_176",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel club a remporté le plus de titres en Super Lig turque ?",
                "Galatasaray",
                "Fenerbahçe",
                "Beşiktaş",
                "Trabzonspor",
                "a",
                5,
                "q_177",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel joueur a marqué le plus de buts en une saison de Ligue des Champions de l'UEFA ?",
                "Cristiano Ronaldo",
                "Robert Lewandowski",
                "Lionel Messi",
                "Raúl",
                "b",
                5,
                "q_178",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel club a remporté le plus de titres en Copa América ?",
                "Argentine",
                "Brésil",
                "Uruguay",
                "Chili",
                "c",
                5,
                "q_179",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel joueur a marqué le plus de buts en une saison de Serie A ?",
                "Ciro Immobile",
                "Cristiano Ronaldo",
                "Paolo Rossi",
                "Gunnar Nordahl",
                "d",
                5,
                "q_180",
                null
            )
        )


        return question
    }

    fun questionListFoot19(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur a marqué le plus de buts en une saison de Premier League ?",
                "Mohamed Salah",
                "Alan Shearer",
                "Cristiano Ronaldo",
                "Sergio Agüero",
                "a",
                5,
                "q_181",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel club a remporté le plus de titres en Serie A ?",
                "Juventus",
                "AC Milan",
                "Inter Milan",
                "Roma",
                "a",
                5,
                "q_182",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel joueur a remporté le Ballon d'Or en 2011 ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Andrés Iniesta",
                "Xavi Hernández",
                "a",
                5,
                "q_183",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel pays a remporté la Coupe du Monde de la FIFA en 1982 ?",
                "Italie",
                "Brésil",
                "Argentine",
                "Allemagne de l'Ouest",
                "a",
                5,
                "q_184",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel club a remporté le plus de titres en Ligue des Champions de l'UEFA ?",
                "Real Madrid",
                "AC Milan",
                "Liverpool",
                "FC Barcelone",
                "a",
                5,
                "q_185",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel joueur a été élu meilleur joueur de la Coupe du Monde 2014 ?",
                "Lionel Messi",
                "Manuel Neuer",
                "Neymar",
                "Thomas Müller",
                "b",
                5,
                "q_186",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel club a remporté le plus de titres en Copa Libertadores ?",
                "Independiente",
                "Boca Juniors",
                "River Plate",
                "Peñarol",
                "a",
                5,
                "q_187",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel joueur a remporté le plus de fois le Prix Puskás du meilleur but de l'année ?",
                "Cristiano Ronaldo",
                "Lionel Messi",
                "Zlatan Ibrahimović",
                "Son Heung-min",
                "b",
                5,
                "q_188",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel pays a remporté la Coupe d'Afrique des Nations en 2013 ?",
                "Nigeria",
                "Ghana",
                "Cameroun",
                "Burkina Faso",
                "a",
                5,
                "q_189",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel club a remporté le plus de titres en Eredivisie néerlandaise ?",
                "Ajax Amsterdam",
                "PSV Eindhoven",
                "Feyenoord",
                "AZ Alkmaar",
                "a",
                5,
                "q_190",
                null
            )
        )


        return question
    }

    fun questionListFoot20(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()

        question.add(
            QuestionModel(
                1,
                "Quel joueur a marqué le plus de buts en une saison de Liga espagnole ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Telmo Zarra",
                "Raúl",
                "a",
                5,
                "q_191",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel pays a remporté la Coupe du Monde en 1994 ?",
                "Brésil",
                "Italie",
                "Argentine",
                "Allemagne",
                "a",
                5,
                "q_192",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel club a remporté le plus de titres en Copa Libertadores au XXIe siècle ?",
                "Boca Juniors",
                "River Plate",
                "Palmeiras",
                "Independiente",
                "c",
                5,
                "q_193",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel joueur a remporté le Prix Puskás du meilleur but de l'année en 2020 ?",
                "Son Heung-min",
                "Robert Lewandowski",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "a",
                5,
                "q_194",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel club a remporté le plus de titres en Ligue 1 française dans les années 2010 ?",
                "Paris Saint-Germain",
                "Marseille",
                "Lille",
                "Lyon",
                "a",
                5,
                "q_195",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel joueur a marqué le plus de buts en une saison de Serie A italienne ?",
                "Gunnar Nordahl",
                "Cristiano Ronaldo",
                "Ciro Immobile",
                "Paolo Rossi",
                "a",
                5,
                "q_196",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel pays a remporté la Coupe d'Afrique des Nations en 2015 ?",
                "Côte d'Ivoire",
                "Ghana",
                "Algérie",
                "Cameroun",
                "a",
                5,
                "q_197",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel joueur a marqué le plus de buts en une saison de Bundesliga allemande ?",
                "Robert Lewandowski",
                "Gerd Müller",
                "Klaus Fischer",
                "Ulf Kirsten",
                "a",
                5,
                "q_198",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel club a remporté le plus de titres en Eredivisie néerlandaise au XXe siècle ?",
                "Ajax Amsterdam",
                "PSV Eindhoven",
                "Feyenoord",
                "AZ Alkmaar",
                "a",
                5,
                "q_199",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel joueur a remporté le Ballon d'Or en 1995 ?",
                "George Weah",
                "Jürgen Klinsmann",
                "Paolo Maldini",
                "Roberto Baggio",
                "a",
                5,
                "q_200",
                null
            )
        )

        return question
    }

    fun questionListFoot21(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur a remporté le plus de fois le Prix du Meilleur Joueur de l'Année par l'UEFA ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Andrés Iniesta",
                "Xavi Hernández",
                "b",
                5,
                "q_201",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel club a remporté le plus de titres en Bundesliga allemande dans les années 2010 ?",
                "Bayern Munich",
                "Borussia Dortmund",
                "RB Leipzig",
                "Bayer Leverkusen",
                "a",
                5,
                "q_202",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel pays a remporté la Coupe du Monde en 2006 ?",
                "Italie",
                "France",
                "Allemagne",
                "Argentine",
                "a",
                5,
                "q_203",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel joueur est le meilleur buteur de l'histoire du FC Barcelone ?",
                "Lionel Messi",
                "Luis Suárez",
                "Xavi Hernández",
                "Andrés Iniesta",
                "a",
                5,
                "q_204",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel club a remporté le plus de titres en Copa Libertadores ?",
                "Independiente",
                "Boca Juniors",
                "River Plate",
                "Peñarol",
                "a",
                5,
                "q_205",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel joueur a marqué le plus de buts en une saison de Premier League ?",
                "Mohamed Salah",
                "Alan Shearer",
                "Cristiano Ronaldo",
                "Sergio Agüero",
                "a",
                5,
                "q_206",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel pays a remporté la Coupe d'Asie en 2015 ?",
                "Australie",
                "Japon",
                "Corée du Sud",
                "Iran",
                "a",
                5,
                "q_207",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel joueur a remporté le plus de fois le Soulier d'Or européen ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Eusébio",
                "Gerd Müller",
                "a",
                5,
                "q_208",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel club a remporté le plus de titres en Ligue 1 française dans les années 2000 ?",
                "Paris Saint-Germain",
                "Marseille",
                "Lille",
                "Lyon",
                "d",
                5,
                "q_209",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel joueur a marqué le plus de buts en une saison de Serie A ?",
                "Gunnar Nordahl",
                "Cristiano Ronaldo",
                "Ciro Immobile",
                "Paolo Rossi",
                "a",
                5,
                "q_210",
                null
            )
        )


        return question
    }

    fun questionListFoot22(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Quel joueur a marqué le plus de buts en une saison de Ligue des Champions de l'UEFA ?",
                "Cristiano Ronaldo",
                "Lionel Messi",
                "Robert Lewandowski",
                "Raúl",
                "a",
                5,
                "q_211",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel pays a remporté la Coupe du Monde en 1974 ?",
                "Allemagne de l'Ouest",
                "Pays-Bas",
                "Brésil",
                "Argentine",
                "a",
                5,
                "q_212",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel joueur a été le meilleur buteur de la Ligue 1 française en 2022 ?",
                "Kylian Mbappé",
                "Lionel Messi",
                "Neymar",
                "Wissam Ben Yedder",
                "a",
                5,
                "q_213",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel club a remporté le plus de titres en Serie A italienne dans les années 2010 ?",
                "Juventus",
                "AC Milan",
                "Inter Milan",
                "Roma",
                "a",
                5,
                "q_214",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel joueur a marqué le plus de buts en une saison de Bundesliga allemande ?",
                "Robert Lewandowski",
                "Gerd Müller",
                "Klaus Fischer",
                "Ulf Kirsten",
                "a",
                5,
                "q_215",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel pays a remporté la Coupe d'Afrique des Nations en 2021 ?",
                "Algérie",
                "Sénégal",
                "Maroc",
                "Égypte",
                "b",
                5,
                "q_216",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel joueur a été élu meilleur joueur de la Coupe du Monde 2018 ?",
                "Luka Modrić",
                "Kylian Mbappé",
                "Eden Hazard",
                "Cristiano Ronaldo",
                "a",
                5,
                "q_217",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel club a remporté le plus de titres en Premier League anglaise ?",
                "Manchester United",
                "Liverpool",
                "Manchester City",
                "Arsenal",
                "a",
                5,
                "q_218",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel joueur a marqué le plus de buts en une saison de Liga espagnole ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Telmo Zarra",
                "Raúl",
                "a",
                5,
                "q_219",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel pays a remporté la Coupe du Monde de la FIFA en 1958 ?",
                "Brésil",
                "Suède",
                "France",
                "Allemagne de l'Ouest",
                "a",
                5,
                "q_220",
                null
            )
        )


        return question
    }

    fun questionListFoot23(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()

        question.add(
            QuestionModel(
                1,
                "Quel joueur a marqué le plus de buts en une seule saison de Serie A ?",
                "Gunnar Nordahl",
                "Cristiano Ronaldo",
                "Ciro Immobile",
                "Paolo Rossi",
                "a",
                5,
                "q_221",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel club a remporté le plus de titres en Copa América ?",
                "Uruguay",
                "Argentine",
                "Brésil",
                "Chili",
                "a",
                5,
                "q_222",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel joueur a remporté le plus de fois le Ballon d'Or ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Johan Cruyff",
                "Michel Platini",
                "a",
                5,
                "q_223",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel pays a remporté la Coupe du Monde en 1986 ?",
                "Argentine",
                "Allemagne de l'Ouest",
                "Brésil",
                "France",
                "a",
                5,
                "q_224",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel club a remporté le plus de titres en Ligue 1 française au XXIe siècle ?",
                "Paris Saint-Germain",
                "Lyon",
                "Marseille",
                "Monaco",
                "a",
                5,
                "q_225",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel joueur a marqué le plus de buts en une saison de Premier League ?",
                "Mohamed Salah",
                "Alan Shearer",
                "Cristiano Ronaldo",
                "Sergio Agüero",
                "a",
                5,
                "q_226",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel pays a remporté la Coupe d'Asie en 2019 ?",
                "Qatar",
                "Japon",
                "Corée du Sud",
                "Australie",
                "a",
                5,
                "q_227",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel joueur a remporté le Prix du Meilleur Jeune Joueur de l'Année de la FIFA en 2022 ?",
                "Jude Bellingham",
                "Pedri",
                "Kylian Mbappé",
                "Erling Haaland",
                "a",
                5,
                "q_228",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel club a remporté le plus de titres en Eredivisie néerlandaise dans les années 2010 ?",
                "Ajax Amsterdam",
                "PSV Eindhoven",
                "Feyenoord",
                "AZ Alkmaar",
                "a",
                5,
                "q_229",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel joueur a marqué le plus de buts en une saison de Ligue des Champions de l'UEFA ?",
                "Cristiano Ronaldo",
                "Lionel Messi",
                "Robert Lewandowski",
                "Raúl",
                "a",
                5,
                "q_230",
                null
            )
        )

        return question
    }

    fun questionListFoot24(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()

        question.add(
            QuestionModel(
                1,
                "Quel joueur a remporté le plus de fois le Golden Boot en Premier League ?",
                "Alan Shearer",
                "Sergio Agüero",
                "Mohamed Salah",
                "Harry Kane",
                "a",
                5,
                "q_231",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel club a remporté le plus de titres en Bundesliga allemande au XXIe siècle ?",
                "Bayern Munich",
                "Borussia Dortmund",
                "RB Leipzig",
                "Bayer Leverkusen",
                "a",
                5,
                "q_232",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel joueur est le meilleur buteur de l’histoire de la Coupe du Monde ?",
                "Miroslav Klose",
                "Ronaldo Nazário",
                "Pele",
                "Lionel Messi",
                "a",
                5,
                "q_233",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel club a remporté le plus de titres en Serie A italienne dans les années 2000 ?",
                "Juventus",
                "AC Milan",
                "Inter Milan",
                "Roma",
                "a",
                5,
                "q_234",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel joueur a marqué le plus de buts en une saison de La Liga espagnole ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Telmo Zarra",
                "Raúl",
                "a",
                5,
                "q_235",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel pays a remporté la Coupe du Monde en 1998 ?",
                "France",
                "Brésil",
                "Pays-Bas",
                "Argentine",
                "a",
                5,
                "q_236",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel joueur a remporté le Ballon d'Or en 2018 ?",
                "Luka Modrić",
                "Cristiano Ronaldo",
                "Lionel Messi",
                "Antoine Griezmann",
                "a",
                5,
                "q_237",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel club a remporté le plus de titres en Copa Libertadores dans les années 2010 ?",
                "River Plate",
                "Boca Juniors",
                "Palmeiras",
                "Independiente",
                "c",
                5,
                "q_238",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel joueur a marqué le plus de buts en une saison de Ligue 1 française ?",
                "Kylian Mbappé",
                "Zlatan Ibrahimović",
                "Jean-Pierre Papin",
                "Karim Benzema",
                "a",
                5,
                "q_239",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel club a remporté le plus de titres en Eredivisie néerlandaise au XXe siècle ?",
                "Ajax Amsterdam",
                "PSV Eindhoven",
                "Feyenoord",
                "AZ Alkmaar",
                "a",
                5,
                "q_240",
                null
            )
        )

        return question
    }

    fun questionListFoot25(): MutableList<QuestionModel>{
        val question: MutableList<QuestionModel> = mutableListOf()

        question.add(
            QuestionModel(
                1,
                "Quel joueur a marqué le plus de buts en une saison de Liga espagnole ?",
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Telmo Zarra",
                "Raúl",
                "a",
                5,
                "q_241",
                null
            )
        )

        question.add(
            QuestionModel(
                2,
                "Quel pays a remporté la Coupe du Monde en 2010 ?",
                "Espagne",
                "Pays-Bas",
                "Allemagne",
                "Brésil",
                "a",
                5,
                "q_242",
                null
            )
        )

        question.add(
            QuestionModel(
                3,
                "Quel club a remporté le plus de titres en Premier League anglaise dans les années 2000 ?",
                "Manchester United",
                "Arsenal",
                "Chelsea",
                "Liverpool",
                "a",
                5,
                "q_243",
                null
            )
        )

        question.add(
            QuestionModel(
                4,
                "Quel joueur a marqué le plus de buts en une saison de Ligue des Champions de l'UEFA ?",
                "Cristiano Ronaldo",
                "Lionel Messi",
                "Robert Lewandowski",
                "Raúl",
                "a",
                5,
                "q_244",
                null
            )
        )

        question.add(
            QuestionModel(
                5,
                "Quel joueur a remporté le Ballon d'Or en 2019 ?",
                "Lionel Messi",
                "Virgil van Dijk",
                "Cristiano Ronaldo",
                "Robert Lewandowski",
                "a",
                5,
                "q_245",
                null
            )
        )

        question.add(
            QuestionModel(
                6,
                "Quel pays a remporté la Coupe d'Afrique des Nations en 2017 ?",
                "Cameroun",
                "Égypte",
                "Ghana",
                "Maroc",
                "a",
                5,
                "q_246",
                null
            )
        )

        question.add(
            QuestionModel(
                7,
                "Quel joueur a été le meilleur buteur de la Serie A italienne en 2021 ?",
                "Cristiano Ronaldo",
                "Romelu Lukaku",
                "Ciro Immobile",
                "Zlatan Ibrahimović",
                "b",
                5,
                "q_247",
                null
            )
        )

        question.add(
            QuestionModel(
                8,
                "Quel club a remporté le plus de titres en Copa Libertadores dans les années 2000 ?",
                "Boca Juniors",
                "River Plate",
                "São Paulo",
                "Peñarol",
                "c",
                5,
                "q_248",
                null
            )
        )

        question.add(
            QuestionModel(
                9,
                "Quel joueur a marqué le plus de buts en une saison de Bundesliga allemande ?",
                "Robert Lewandowski",
                "Gerd Müller",
                "Klaus Fischer",
                "Ulf Kirsten",
                "a",
                5,
                "q_249",
                null
            )
        )

        question.add(
            QuestionModel(
                10,
                "Quel club a remporté le plus de titres en Eredivisie néerlandaise dans les années 2000 ?",
                "Ajax Amsterdam",
                "PSV Eindhoven",
                "Feyenoord",
                "AZ Alkmaar",
                "a",
                5,
                "q_250",
                null
            )
        )

        return question
    }
}