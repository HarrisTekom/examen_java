# Java MySQL Connection – E-commerce Project

## Description

Ce projet montre comment connecter une application **Java** à une base de données **MySQL** en utilisant **JDBC**.

Le programme récupère les données d'une table `PRODUITS` et affiche les informations dans la console.

Projet réalisé dans le cadre d’un exercice de développement Java.

---

## Technologies utilisées

* Java
* JDBC
* MySQL
* Eclipse IDE
* MySQL Workbench
* GitHub

---

## Structure de la base de données

Base de données :

```
e_commerce_electroniquedb
```

Table utilisée :

```
PRODUITS
```

Colonnes :

* id_produit
* nom_produit
* categorie_produit
* prix
* stock_disponible

---

## Fonctionnement du programme

Le programme réalise les étapes suivantes :

1. Chargement du driver MySQL
2. Connexion à la base de données
3. Exécution d’une requête SQL
4. Récupération des résultats avec ResultSet
5. Affichage des produits dans la console
6. Fermeture de la connexion

---

## Exemple de sortie

```
ID Produit : 1
Nom : Smartphone Samsung
Catégorie : Téléphone
Prix : 699.99 €
Stock : 25
```

Projet réalisé par un étudiant en développement Java.
