DESIGN 

Version 2

<p id="image" align="center">
  <img src="../projet_pdl.png" alt="Présentation du projet">
</p>

 L'objectif de cette application est de permettre la visualisation et l'édition des données sous la forme de diagramme à bulles interactif. (<a href="#image">Voir image plus haut</a>) 

 Cet outil de visualisation prendra en entrée un fichier texte dans un format spécifique à l'outil et affichera le contenu de ce fichier sous la forme d'un diagramme à bulles.

# Présentation interface du projet
([INTERFACE ACCEUIL](../Capture%20d'écran%202023-11-27%20115137.png))
Cette image présente l'interface d'accueil. 
La partie droite vous présente la possibilité de choisir un template de diagramme
pour générer votre graphe ou alors charger un fichier de type json.
La partie gauche vous donne accès au compte de client avec des informations sur le profil et la possibilité de se déconnecter

([INTERFACE Diagramme](../Capture%20d'écran%202023-11-27%20124708.png))
C'est sur cette interface que le diagramme est visualisé. 
La partie de gauche ne change pas, elle reste disponible pour permettre au client de se déconnecter 
ou accéder aux informations de son compte.
La partie droite es divisée en deux parties :
- la première est celle ou le diagramme est affiché avec des options d'ajout ou de retrait de bulles et des options d'exports
- la deuxième permet une modification du diagramme : taille des bulles, couleurs, etc.



# Notion de template

Un template dans notre application est une option que nous donnons à l'utilisateur pour lui permettre de créer sur place son diagramme sans se soucier de préciser
les couleurs ou autres paramètres de forme. Quand un template est choisi, les données de forme sont conservées, mais celles de fond sont celles
fournies par l'utilisateur
Générer un diagramme implique donc deux cas :
1. On charge un fichier avec toutes les informations de fond et forme qui seront utilisés 
2. On utilise un diagramme template et dans ce cas toutes les informations de fond données dans le fichier chargé sont ignorés et remplacés par ceux du diagramme

# Diagrammes
## Diagramme de cas d'utilisation
<p id="usecase">
<p id="image" align="center">
  <img src="../Use_Case_Diagram1.jpg" alt="Diagramme de cas d'utilisation">
</p>

  Ce diagramme illustre les différentes fonctionnalités de l'application Bubbles. 

  La fonctionnalité <strong>importer un fichier</strong> permet à l'utilisateur de charger un fichier JSON (suivant le format recommandé [fichier json](../test_simple.json)) contenant les données à visualiser. Il peut choisir un template/modèle de diagramme (diagramme préconçu dans l'application) pour visualiser les données ou utiliser les paramètres de base contenus dans son fichier (<a href="#param">Voir la documentation</a>).

  <strong>La manipulation des données</strong> peut se faire de deux manières : soit directement dans le fichier (lorsque l'utilisateur n'est pas connecté), soit en utilisant la base de données. L'utilisateur à la possibilité de  modifier le texte (police, libellé) contenu dans les bulles, ainsi que les bulles elles-mêmes (taille, couleur). 

  Ensuite, il a la possibilité de <strong>déployer ou de cacher</strong> les enfants d'une bulle parente, <strong>exporter</strong> sous forme de fichier texte les sous-enfants des bulles sélectionnées ou sous forme d'image le diagramme à bulles ne contenant que les bulles sélectionnées, ainsi que les bulles supérieures qui les relient. 

  Il peut aussi <strong>consulter son historique</strong> (les données issues des fichiers importés précédemment). Cependant, cette fonctionnalité nécessite que l'utilisateur soit connecté. </p>

## Diagramme de classe
<p id="image" align="center">
  <img src="../Class_Diagram.jpg" alt="Diagramme de classe">
</p>

  Ce diagramme présente les différentes entités de notre application. 
  L'application comprend cinq entités dont l'entité  <strong>Data</strong> qui représente les données de chaque bulle. Ces données sont extraites du fichier importé par l'utilisateur et peuvent être exporter soit sous forme d'un fichier texte ou d'image. 

  La fonction <strong>export</strong> permet d'exporter et de présenter sous la forme d'un fichier texte l'ensemble des bulles sélectionnées. La fonction <strong>exportImage(data : Data[])</strong> permet d'exporter sous forme d’image, voir en PDF, le diagramme à bulles contenant les bulles sélectionnées, ainsi que les bulles « supérieures » qui les relies.

  Selon le diagramme les données sont liées à un fichier représenté par l'entité <strong>File</strong>. Un fichier peut contenir zéro ou plusieurs données. Il est possible de visualiser un fichier en appelant la méthode <strong>visualiser</strong> ou d'importer un fichier par la méthode <strong>importer</strong>. Un utilisateur a la possibilité d'enregistrer zéro ou plusieurs fichiers. 

  Les modèles/templates que nous présentons à l'utilisateur, sont enregistrés dans la table <strong>Diagramme</strong>. Un diagramme est lié à zéro ou plusieurs fichiers et un fichier est lié à zéro ou un diagramme.

## Diagramme de séquence
<p id="image" align="center">
  <img src="../Sequence_Diagram.jpg" alt="Diagramme de séquence">
</p>

  Lorsqu'un utilisateur demande à importer un fichier, le système lui demande si ce fichier doit être public ou non. Ensuite, le système procède à la vérification du fichier pour s'assurer qu'il correspond au format recommandé, la taille et le type de fichier. 

  Si l'utilisateur est connecté, son fichier est enregistré dans la base de données, pour faciliter la consultation de son historique (Pour plus de détails <a href="#usecase">veuillez consulter</a>). Une fois l'enregistrement terminé, le système affiche à l'utilisateur la visualisation de ses données sous forme de diagramme à bulles.