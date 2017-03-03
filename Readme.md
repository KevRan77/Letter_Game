# TP Architecture Logicielle / Inf4043 - 2017 - Jeux de lettres

-  Binôme  : RANAIVO Kevin et REMY Nora

## Règles du jeux 
- Objectif du jeux :
  - Le premier joueur ayant 10 mots gagne la partie

- Déroulement du jeux :
  - Il faut choisir entre : 
    - 1) Joueur VS Joueur
    - 2) Joueur VS IA
      
    en saisissant 1 ou 2 au clavier. Valider votre choix en appuyant sur entrer.
  - Si 1) alors il faut entrer le nombre de joueurs sinon il suffit d'indiquer les noms des joueurs.
  - Trois options sont possibles pour chaque joueur, (1) Ecrire un mot avec les lettres disponibles du pot commun, (2) Passer son tour, (3) Voler un mot. 
  -  Chaque joueur tire une lettre aléatoire via le sac de lettres, et les ajoutent au pot commun
  - Le joueur qui a tiré la lettre la plus petite dans l'alphabet commence
  - Pour voler un mot, il est nécéssaire d'indiquer le nom du joueur à qui on veut voler, son mot et le nouveau mot. 

## Architecture
 - Packages : 
 Le projet est découpé en 4 packages afin de répartir les différentes classes en fonction de leurs rôles.
    - Package Game (Ce package est responsable du lancement du jeu.): 
      - Main.java lance le jeu
    - Package Components (Ce package est responsable des éléments nécéssaires au fonctionnement du jeu.) : 
      - Alphabet.java est une énumération contenant l'alphabet et la génération aléatoire des lettes avec une occurence plus forte pour les voyelles.
      - MutualBag.java gère le pot commun avec des méthodes qui ajoutent les lettres au pot commun, vérifie que les lettres écrites soient dadans.
      - Player.java associe toutes les caractéristiques liées au joueur.
      - Words.java gère toutes les méthodes liées aux mots (Ajout, Vol, Vérification avec le dictionnaire, etc.).
    - Package Core (Ce package est responsable du coeur du jeu avec les méthodes principales.) : 
      - Game.java affiche les différents menus, indique quel joueur commence, et appelle les différentes méthodes en fonction des choix de l'utilisateur
      - IA.java associe toutes les caractéristiques liées à l'intelligence artificielle.
      - LetterDraw.java définit les tirages de lettres aléatoires.
      - ScoreWord.java associe toutes les caractéristiques liées aux scores des joueurs.
    - Package Interface (Ce package est responsable des interfaces.) : 
      - IGame.java représente l'interface de game.
      
 - Design Pattern :
    - Singleton : 
        - MutualBag : le pot commun est instancié qu'une seule fois par la méthode du singleton car durant toute une partie il n'y a qu'un seul pot commun. (private static MutualBag instanceMutualBag = new MutualBag(); public static MutualBag getInstanceMutualBag() { return instanceMutualBag; })

## Compilation
- $ mvn package 
- $ sudo java -cp target/LetterGame-0.0.0-SNAPSHOT.jar fr.esiea.Ranaivo_Remy.Game.Main
