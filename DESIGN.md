DESIGN 

Version 1.0
# Design application
<p id="image" align="center">
  <img src="./docs/projet_pdl.png" alt="Présentation du projet">
</p>

 Cette application a pour objectif de permettre la visualisation et l'édition des données sous la forme de diagrammes à bulles interactif. (<a href="#image">Voir image plus haut</a>) 

 Cet outil de visualisation prendra en entrée un fichier texte dans un format spécifique à l'outil et affichera le contenu de ce fichier sous la forme d'un diagramme à bulles.

## Documentation du projet
Bubbles est une application de visualisation des données contenues dans un fichier json préalablement importé par l'utilisateur. Elle donne la possibilité à l'utilisateur d'interagir avec les bulles (représentation des données), en modifiant soit la couleur, la taille, la police et les libellés des bulles. Elle propose aussi à l'utilisateur un ensemble de modèle de diagramme (template) pour la visualisation des données. <p id="param">Ce dernier à donc le choix entre les modèles proposés par l'application ou utiliser les paramètres (couleur, taille, police) de visualisation définis dans son fichier json (taille, couleur, police, etc...).</p>

<strong style="text-decoration : underline">NB</strong> : Le fichier doit être dans un format bien défini ([Voir un exemple du fichier](./docs/test_simple.json))

### Présentation de quelques interfaces
<p id="image" align="center" style="display:flex">
  <img src="./docs/acueil.png" alt="Première page" width="50%" style="margin-right :5%">
  <img src="./docs/affichage.png" alt="Page d'accueil" width="50%">
</p>

### Explication du projet

## Diagramme de cas d'utilisation
<p id="usecase">
<p id="image" align="center">
  <img src="./docs/Use_Case_Diagram1.jpg" alt="Diagramme de cas d'utilisation">
</p>

Ce diagramme illustre les différentes fonctionnalités de l'application Bubbles. 

<!-- En effet, l'utilisateur a la possibilité d'importer un fichier json (suivant le format recommandé [fichier json](./docs/test_simple.json)) contenant les données à visualiser. Il peut choisir un template/modèle de diagramme (diagramme pré-conçu dans l'application) pour la visualisation des données. -->

La fonctionnalité <strong>importer un fichier</strong> permet a l'utilisateur de charger son fichier json (suivant le format recommandé [fichier json](./docs/test_simple.json)) contenant les données à visualiser. Il peut choisir un template/modèle de diagramme (diagramme pré-conçu dans l'application) pour la visualisation des données ou utiliser les paramètres de base contenu dans son fichier (<a href="#param">Voir la documentation</a>).

<strong>La manipulation des données</strong> se fait, soit directement dans le fichier (lorsque l'utilisateur n'est pas connecté), soit en base de données. L'utilisateur peut donc modifier le texte (police, libellé) contenu dans les bulles ou les bulles elles-mêmes (taille, couleur). 

Ensuite, il a la possibilité de <strong>déployer ou de cacher</strong> les enfants d'une bulle parente, <strong>exporter</strong> sous forme de fichier texte le sous-enfant des bulles sélectionnées ou sous forme d'image le diagramme à bulle ne contenant que les bulles sélectionnées, ainsi que les bulles supérieures qui les relient. 

Il peut aussi <strong>consulter son historique</strong> (les données issues des fichiers importés précédemment). Cette fonctionnalité nécessite la connexion de l'utilisateur. </p>

## Diagramme de classe
<p id="image" align="center">
  <img src="./docs/Class_Diagram.jpg" alt="Diagramme de classe">
</p>

Ce diagramme présente les différentes entités de notre application. L' application possède cinq entités dont l'entité  <strong>Data</strong> qui représente la donnée de chaque bulle. Elle est extraite du fichier importé par l'utilisateur. Ces données peuvent être exporter soit sous la forme d'un fichier txt ou sous la forme d'une image. 

La fonction <strong>export()</strong> permet d'exporter et de présenter sous la forme d'un fichier texte l'ensemble des bulles (data) sélectionnées. Et la fonction </strong>exportImage(data : Data[])</strong> permet d'exporter sous la forme d’une image (éventuellement d’un pdf) le diagramme à bulles ne contenant que les bulles (Data) sélectionnées ainsi que les bulles « supérieures » qui les relies.

Par suite, selon le diagramme les données sont liées à un fichier(<strong>File</strong>) et un fichier possède zéro ou plusieurs données. IL est possible de visualiser un fichier (<strong>visualiser()</strong>) ou d'importer un fichier (<strong>importer()</strong>).Ainsi, un utilisateur peut enregistrer zéro ou plusieurs fichiers. 

Dans notre système, nous proposons des modèles à l'utilisateur, qui sont enregistrés dans la table <strong>Diagramme</strong>. Un diagramme est lié à zéro ou plusieurs fichiers et un fichier est lié à zéro ou un diagramme.

## Diagramme de séquence
<p id="image" align="center">
  <img src="./docs/Sequence_Diagram.jpg" alt="Diagramme de séquence">
</p>

Lorsqu'un utilisateur demande à importer un fichier, le système lui demande si ce fichier doit être public ou pas, puis le système se charge de traiter le fichier, c'est-à-dire de vérifier si le fichier correspond au format recommandé, la taille et le type de fichier. 

Si l'utilisateur est connecté, son fichier est enregistré dans la base de données, pour faciliter l'affichage de ses historiques (<a href="#usecase">Voir plus de détail</a>). A la fin de l'enregistrement, le système retourne à l'utilisateur la visualisation de ses données (diagramme à bulle). Notons que ce dernier a aussi la possibilité de choisir un modèle de visualisation des données.