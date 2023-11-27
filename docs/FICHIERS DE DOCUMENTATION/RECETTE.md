CAHIER DE RECETTE

Version 2

# 1- Conformité aux spécifications générales
Plusieurs tests seront effectués sur l'application afin de verifier sa conformité par rapport au cahier des charges donné par le client.

## 1-1- Test fonctionnel
### 1-1-1- Scénario 1

1. Titre : Chargement du Fichier comportant les Données
1. Spécification de test : Test fonctionnel
1. Exigences du test : Charger un fichier non vide
1. Elément à tester <l'executable> :
1. Procédure du test :
	- Lancer l'application : la page d'accueil s'affiche
	- Cliquer sur **GET STARTED** : La 2e page pour la chargement du fichier apparaît
	- Cliquer sur le bouton **charger votre fichier** : le pop up d'upload s'affiche
	- Cliquer sur le bouton **UPLOAD** : choisir un fichier valide dnans vos dossiers et entrer
	- Valider avec le bouton **validate** : un diagramme à différents niveaux contenant les données du fichier pris en entrée s'affiche  

### 1-1-2- Scénario 2

1. Titre : Hierachisation du Diagramme
1. Spécification de test : Test fonctionnel
1. Exigences du test :
	- Chaque niveau de bulle supérieur doit pouvoir deployer un sous niveau de bulle jusqu'au plus bas niveau possible
	- Il est possible de revenir au supérieur en cliquant sur la bulle correspondante
1. Elément à tester <l'executable> :
1. Procédure du test :
	- Une fois sur la page du diagramme, faire un clic sur la bulle centrale : un ensemble de bulle de niveau 2 s'affiche
	- Faire un clic sur la sous bulle de votre choix de ce niveau ou de toutes les sous bulles : un autre ensemble de sous bulles de niveau 3 s'affiche
	- Faire un clic sur la bulle central : toutes les autres sous bulles remontent et seule la bulle centrale est visible

### 1-1-3- Scénario 3

1. Titre : Interaction et visualisation des données
1. Spécification de test : Test fonctionnel
1. Exigences du test :
	- Pouvoir selectionner une bulle et zoomer pour voir les données écrites
1. Elément à tester <l'executable> :
1. Procédure du test :
	- Double cliquer sur une bulle : elle affiche les informations qu'elle contient

### 1-1-4- Scénario 4

1. Titre : Exportation des données
1. Spécification de test : Test fonctionnel
1. Exigences du test :
	- Pouvoir exporter les données du diagramme
	- Choisir la manière d'exporter les données, soit sous forme d'image ou sous forme de fichier texte
	- Le fichier exporté contient les données du sous ensemble des bulles conformément au format choisi
1. Elément à tester <l'executable> :
1. Procédure du test :
	- Cliquer sur une bulle du plus bas niveau
	- Cliquer sur exporter
	- Choisir le format d'exportation
	- Valider 

### 1-1-5- Scénario 5

1. Titre : Modification des bulles
1. Spécification de test : Test fonctionnel
1. Exigences du test : 
	- Modifier les données des bulles
	- Sauvegarder les modifications
1. Elément à tester <l'executable> :
1. Procédure du test :
	- Cliquer sur la bulle
	- Cliquer sur modifier
	- Enregistrer la modification

### 1-1-6- Scénario 6

1. Titre : Personnalisation du diagramme
1. Spécification de test : Test fonctionnel
1. Exigences du test : Faire un choix de modèle de diagramme
1. Elément à tester <l'executable> :
1. Procédure du test :
	- Une fois dans l'application sur la 2e page, Cliquer sur un des template proposé : il présente un apercu du diagramme selectionné
	- Valider le template en cliquant sur **choisir** 
	- Cliquer sur le bouton **UPLOAD** pour charger votre fichier : vos dossiers d'ordinateur s'affiche et vous faites un choix de fichier valide
	- Cliquer sur **validate** : 

