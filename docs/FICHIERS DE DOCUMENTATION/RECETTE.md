CAHIER DE RECETTE

Version 2

Ce document vise à décrire les différents tests qui vont être effectués pour s'assurer du bon fonctionnement de l'application.


# 1- Conformité aux spécifications générales
Plusieurs tests seront effectués sur l'application afin de verifier sa conformité par rapport au cahier des charges donné par le client.

## 1-1- Test fonctionnel
### 1-1-1- Scénario 1

1. Titre : Chargement du Fichier comportant les Données
2. Spécification de test : Test fonctionnel
3. Exigences du test : Charger un fichier non vide
4. Attendu : ouverture de la page présentant un diagramme
5. Résultat : OK
6. Procédure du test :
	- Lancer l'application : la page d'accueil s'affiche
	- Cliquer sur **GET STARTED** : La 2e page pour le chargement du fichier apparaît
	- Cliquer sur le bouton **charger votre fichier** : le pop up d'upload s'affiche
	- Cliquer sur le bouton **UPLOAD** : choisir un fichier valide dans vos dossiers et entrer
	- Valider avec le bouton **validate** : un diagramme à différents niveaux contenant les données du fichier pris en entrée s'affiche  

### 1-1-2- Scénario 2

1. Titre : Hiérarchisation du Diagramme
2. Spécification de test : Test fonctionnel
3. Exigences du test :
	- Chaque niveau de bulle supérieur doit pouvoir deployer un sous niveau de bulle jusqu'au plus bas niveau possible
	- Il est possible de revenir au supérieur en cliquant sur la bulle correspondante
4. Attendu : Les bulles doivent se deployer et se cacher
5. Résultat : OK
6. Procédure du test :
	- Une fois sur la page du diagramme, faire un clic sur la bulle centrale : un ensemble de bulle de niveau 2 s'affiche
	- Faire un clic sur la sous bulle de votre choix de ce niveau ou de toutes les sous bulles : un autre ensemble de sous bulles de niveau 3 s'affiche
	- Faire un clic sur la bulle centrale : toutes les autres sous bulles remontent et seule la bulle centrale est visible

### 1-1-3- Scénario 3

1. Titre : Interaction et visualisation des données
2. Spécification de test : Test fonctionnel
3. Exigences du test :
	- Pouvoir sélectionner une bulle et lire les données écrites
4. Attendu : Affichage des données contenues dans les bulles
5. Résultat : OK
6. Procédure du test :
	- Double cliqué sur une bulle : elle affiche les informations qu'elle contient

### 1-1-4- Scénario 4

1. Titre : Exportation des données
2. Spécification de test : Test fonctionnel
3. Exigences du test :
	- Pouvoir exporter les données du diagramme
	- Choisir la manière d'exporter les données, soit sous forme d'image ou sous forme de fichier texte
	- Le fichier exporté contient les données du sous ensemble des bulles conformément au format choisi
4. Attendu : Un fichier de type texte ou image exporté (enregistré localement sur votre appareil)
5. Résultat : en cours d'implémentation
6. Procédure du test :
	- Cliquer sur une bulle du plus bas niveau
	- Cliquer sur exporter
	- Choisir le format d'exportation
	- Valider 

### 1-1-5- Scénario 5

1. Titre : Modification des données contenues dans les bulles
2. Spécification de test : Test fonctionnel
3. Exigences du test : 
	- Modifier les données des bulles
	- Sauvegarder les modifications
4. Attendu : Écrire dans la bulle sélectionnée et enregistrement de cette modification
5. Résultat : OK
6. Procédure du test :
	- Cliquer sur la bulle
	- Effectuer la modification souhaitée
	- Enregistrer la modification

### 1-1-6- Scénario 6

1. Titre : Personnalisation du diagramme
2. Spécification de test : Test fonctionnel
3. Exigences du test : Faire un choix de modèle de diagramme
4. Attendu : Changer la forme de ses bulles, sa couleur, la police d'écriture, la taille du texte
5. Résultat : OK 
6. Procédure du test :
	- Une fois dans l'application sur la 2e page, Cliquer sur un des template proposé : il présente un apercu du diagramme selection
	- Valider le template en cliquant sur **choisir** 
	- Cliquer sur le bouton **UPLOAD** pour charger votre fichier : vos dossiers d'ordinateur s'affichent et vous faites un choix de fichier valide
	- Cliquer sur **validate**
	- Sur la barre latérale droite, changer la couleur, la taille d'écriture la forme de bulle au besoin