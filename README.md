# gestionCommandes

Télécharger le projet.

Décompresser le projet.

Utiliser la commande : gradlew (dans un terminal à la raçinne du projet). A la première execution cette commande prend du temps car elle commence par télécharger le gestionnaire de librairies Gradle, puis elle télécharge toutes les librairies du framework Spring, et elle compile de projet.

Utiliser la commende : gradlew eclipse (dans un terminal à la raçinne du projet) pour convertir le projet en un projet eclipse.

Importer le projet dans Eclipse pour pouvoir éditer le code : File -> Import -> Existing project into workspace -> ...

Lancer le Web Services : le main Java se trouve dans src/main/java/commandes/GestionCommandesApplications. Lancer en tant qu'application Java.

Utiliser un navigateur avec un plugin (postman ou rest client) pour tester le web service :

	- Envoyer un HTTP POST sur l'URL http://localhost:8080/commandes contenant du json pour ajouter une commande :  {"typeProduit": 1, "nombreProduits":3}  Ne pas oublier de préciser dans le header http content-type: application/json.
	
	- Envoyer un HTTP GET sur l'URL http://localhost:8080/commandes ayant comme header http content-type: application/json pour récupérer la liste des commandes.