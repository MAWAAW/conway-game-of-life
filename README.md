# Conway's Game of Life - Implémentation Java

Ce projet est une implémentation du **Jeu de la Vie de Conway** en **Java**, avec une interface graphique utilisant **AWT/Swing**. Il fait usage de plusieurs **patrons de conception**, notamment **Commande**, **Observateur**, et **Visiteur**, pour structurer et gérer l'état du jeu, l'interaction utilisateur et le rendu.

## Table des matières

1. [Aperçu](#aperçu)
2. [Patrons de conception](#patrons-de-conception)
   - [Patron Commande](#patron-commande)
   - [Patron Observateur](#patron-observateur)
   - [Patron Visiteur](#patron-visiteur)
3. [Installation](#installation)
4. [Utilisation](#utilisation)
5. [Fonctionnalités](#fonctionnalités)
6. [Comment ça fonctionne](#comment-ça-fonctionne)

---

## Aperçu

Le **Jeu de la Vie de Conway** est un automate cellulaire où une grille de cellules évolue au fil du temps selon des règles simples basées sur le nombre de voisins vivants de chaque cellule. Cette implémentation permet de visualiser le jeu en temps réel et propose une interface graphique intuitive.

### Principes du jeu

- **Grille de cellules** : Chaque cellule peut être vivante ou morte.
- **Simulation** : À chaque itération, les cellules changent d'état en fonction de règles prédéfinies.
- **Interaction** : Le joueur peut démarrer, arrêter, réinitialiser la simulation et configurer la grille.

---

## Patrons de conception

### Patron Commande

Le **patron Commande** encapsule les actions de l'utilisateur (démarrer, arrêter, réinitialiser la simulation) dans des objets Commande, permettant ainsi une gestion flexible des interactions.

- **Classes utilisées** :
  - `CommandeDémarrer` : Démarre la simulation.
  - `CommandeArrêter` : Met en pause la simulation.
  - `CommandeRéinitialiser` : Réinitialise la grille à l'état initial.

### Patron Observateur

Le **patron Observateur** permet à l'interface graphique d'être automatiquement mise à jour lorsque l'état des cellules change. Chaque cellule est un **Observable**, et la vue (grille graphique) observe ces changements.

- **Classes utilisées** :
  - `Cellule` (Observable)
  - `VueCellule` (Observateur)

### Patron Visiteur

Le **patron Visiteur** permet d'appliquer des opérations sur les cellules sans modifier leur structure, telles que compter les cellules vivantes ou inverser leur état.

- **Classes utilisées** :
  - `VisiteurCompteur` : Compte les cellules vivantes.
  - `VisiteurInversion` : Inverse l'état d'une cellule.

---

## Installation

1. **Cloner le dépôt GitHub** :
   ```bash
   git clone https://github.com/MAWAAW/conway-game-of-life.git

2. **Compiler le projet Java** :
   ```bash
   javac *.java

3. **Exécuter le programme** :
   ```bash
   java JeuDeLaVie

---

## Utilisation

- **Démarrer la simulation** : Cliquez sur "Démarrer" pour commencer à visualiser le jeu.
- **Arrêter la simulation** : Cliquez sur "Pause" pour interrompre l'évolution des cellules.
- **Réinitialiser la grille** : Utilisez "Réinitialiser" pour revenir à l'état initial.

---

## Fonctionnalités

- Simulation en temps réel de **Conway's Game of Life**.
- **Interface graphique** intuitive construite avec **AWT/Swing**.
- **Contrôle utilisateur** pour démarrer, arrêter et réinitialiser la simulation.
- Utilisation des patrons de conception pour une architecture flexible et maintenable.

---

## Comment ça fonctionne

1. Le **patron Commande** gère les interactions utilisateur.
2. Le **patron Observateur** met à jour l'interface graphique en fonction des changements d'état des cellules.
3. Le **patron Visiteur** permet des opérations comme le comptage des cellules vivantes ou l'inversion de leur état.
