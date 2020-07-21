<img src="https://lylemi-projet-al04.s3.eu-west-3.amazonaws.com/image-logo/le-logo-noir.png">

Le projet Lyl'Emi Sugar and Salt est une application qui permet de trouver des recettes de cuisine.
Cette application est un regroupement de recettes venant de différents sites de recettes de cuisine.
Pour le moment il s'agit des sites *marmiton.org* et *750g.com*.
Ce projet a été construit avec une architecture back-end en **Spring Boot** et front-end **Angular 9**.
Les recettes scrapées en **NodeJS v12** et sont stockées dans une base de données non relationnnelle **MongoDB**.
Une autre base de données **MySQL** est utilisée pour stocker des données liées à l'utilisation du site, telles que l'enregistrement de compte utilisateur ou encore les ID des recettes favorites.

Ce projet est divisé en 4 repositories GitHub:  
https://github.com/lylia0204/site_cuisine_micro-services = microservice utilisateur : enregistrement utilisateurs et ajout aux favoris
https://github.com/lylia0204/site_cuisine_micro-services-recherche  = microservice recherche de recettes
https://github.com/lylia0204/site_cuisine-angular = partie Angular  
https://github.com/lylia0204/site_cuisine_scraper = partie alimentation de la base de donnée MongoDB (scrapping des sites).

Les technologies utilisées pour le deployement sont:   
AWS EC2 pour le deployement des microservices  
AWS RDS pour l'hebergement de la base de données MySql.  
AWS ElasticBeans pour la partie nodeJS.  
AWS S3 pour la partie Angular.
 

---------------------------------------------------------------------------------------------------------------------------------------
# site_cuisine_micro-services USER

Environnement de developpement:

**Java V8**  
**Spring Boot**
**Spring security** pour securiser les connections utilisateurs
**MAVEN** 
**MySQL**
**Talent API Tester** extention de chrome pour tester l'application

Procédure:

IDE **Eclipse** est trés bien pour cette partie.

Créer un dossier: (Git bash here)
```sh
$ git https://github.com/lylia0204/site_cuisine_micro-services.git
$ cd site_cuisine_micro-services
```
Importer le dossier dans votre IDE : 

PORT_EVENT : un port libre  
HOST_NAME : le même que celui utilisé pour API Node
DB_NAME : le nom de votre BDD Mysql
MY_SQL_URL : l'URL de BDD
MY_SQL_PASSWORD: mot de passe de la BDD.
JWT_SECRET: mot de passe pour securiser le token
JWT_EXPIRATION: temps d'expiration du token


en ligne de commande:
```sh
$ set NOM_DE_LA_VARIABLE=valeur 
```
 
```sh
$ mvn clean install package
```

Executer l'application.  

Avec le jar:
```sh
$ java -jar ms_user-0.0.1.jar.jar
```
Pour la base de données:
créer la base de données, aprés eexecution de l'application  
executer les commandes dans roles.sql.

Aller dans Talent API Tester 
Methode Post avec l'URL signup : http://HOST_NAME/api/auth/signup

En JSON on entre les données utilisateur:   
{

    "name": "name",
    "username": "username",
    "email":"email@email",
    "role": [
        "user" ou "admin"
    ],
    "password": "password"
}


Pour se connecter:
Methode Post avec l'URL signin : http://HOST_NAME/api/auth/signin

{
   
    "username": "username",
    "password": "password"
}

Pour tester l'ajout de recette:

Methode Post avec l'URL : http://HOST_NAME/api/user/favoriterecipe/ajouter

{
   
    "recipeID": "xxx",
   
}

pour ajouter une recette à un utilisateur:

Methode Post avec l'URL : http://HOST_NAME/api/user/favoriterecipe/add/{username}/{recipeID}

Pour voir toutes les recettes d'un utilisateur:

Methode GET avec l'URL : http://HOST_NAME/api/user/favoriterecipe/favoriterecipe/findall/{username}


