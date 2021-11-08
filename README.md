# Swing
Afpa. Gestion Commande
J'ai développé un logiciel de type desktop qui gère les commandes pour une fromagerie. 
Cette application est conçue pour deux types d'utilisateurs : 
1. Utilisateur « Admin » 
2. Utilisateur « Commerçant » qui peut effectuer un nombre limité d'actions.
Tous les utilisateurs doivent se connecter et être identifié. Apres un connexion réussi une fenêtre s’ouvre selon le rôle de l’utilisateur.
	Le commerçant a accès à une seule fenêtre qui le permet de passer une commande. Il peut ajouter des articles (fromages) à la commande, supprimer des articles et passer une commande.
	L’administrateur a accès à 4 fenêtres et il peut gérer les utilisateurs : ajout / modification/ suppression.

Système de gestion d’une fromagerie : projet chez Afpa

	DOMAINE D’INTERVENTION :
	Conception de la base de données avec la méthode Merise.
	Conception et développement de composants d'interface utilisateur avec la librairie Swing.
	Sécurité : prévention des attaques par injections SQL
	Authentification : si l'utilisateur n'est pas authentifié, il ne peut pas avoir accès à l'application.
	Autorisation : l'action que l'utilisateur peut effectuer sur la base de données est déterminée par son rôle :
•	Admin : gérer le stock, effectuer des opérations CRUD sur les produits ou les utilisateurs.
•	Commerçant : avoir un accès limité et effectuer moins d'opérations. Il ne peut accéder à certaines fenêtres réservées à l'administrateur.
	Accès aux données : Conception et développement de la persistance des données avec Le modèle DAO
•	Composant « connexion » : s’occupe d’établir les connexions avec la base de données
•	Composants DAO : contient les requêtes SQL qui sont nécessaires pour le Business Logic

	ENVIRONNEMENT TECHNIQUE :
	Swing
	JDBC
	SQLite
	Netbeans



