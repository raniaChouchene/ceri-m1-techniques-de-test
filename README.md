# tests

**Nom et Prénom**: Chouchene Rania  
**Groupe**: G1 classique M1 ILSEN 
## Badges

[![codecov](https://codecov.io/github/raniaChouchene/ceri-m1-techniques-de-test/graph/badge.svg?token=OGF8K4SKOT)](https://codecov.io/github/raniaChouchene/ceri-m1-techniques-de-test)

[![CircleCI](https://dl.circleci.com/status-badge/img/circleci/8xP7i7kutk8fowA52YizE3/5vTXjkExPP9eLTud7TA2wA/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/circleci/8xP7i7kutk8fowA52YizE3/5vTXjkExPP9eLTud7TA2wA/tree/master)

[![Checkstyle](https://img.shields.io/badge/Checkstyle-passed-brightgreen)](https://circleci.com/gh/Rania2245/ceri-m1-techniques-de-test/tree/main)

## Description du Projet

Ce projet a pour objectif de mettre en place un environnement de développement où la qualité du code est surveillée en continu, ce qui contribue à créer des applications plus robustes et fiables
configurer JaCoCo pour Générer des Rapports :
JaCoCo est une bibliothèque qui s'intègre à Maven pour générer des rapports de couverture de code. En configurant JaCoCo dans votre projet, vous pouvez produire des rapports qui montrent quelles parties de votre code sont couvertes par les tests. Ces rapports sont essentiels pour identifier les zones non testées qui pourraient nécessiter des tests supplémentaires.
Intégration avec CircleCI :
CircleCI est un outil d'intégration continue qui automatise le processus de test. En configurant CircleCI pour exécuter vos tests et générer des rapports de couverture, vous vous assurez que chaque changement de code est validé avant d'être fusionné. Publier les résultats sur Codecov via CircleCI garantit que les résultats de couverture sont disponibles immédiatement après l'exécution des tests


## Choix Techniques

- **Langages Utilisés** : 
  - **Java** :utilisé pour créer les classes et les fonctions.
 
 

- **Frameworks et Bibliothèques** : 

  - **JUnit et Mockito** : Pour écrire et exécuter des tests unitaires et d'intégration, garantissant la fiabilité du code.

- **Gestion de Versions** : 
  - **Git** : Pour le suivi des modifications du code source et la collaboration en équipe. Utilisation de branches pour gérer les nouvelles fonctionnalités et les corrections de bugs.

- **Intégration Continue** : 
  - **CircleCI** : Configuré pour automatiser les tests à chaque push dans le dépôt, assurant que le code reste fonctionnel et sans erreurs.
  - **Codecov** : Utilisé pour suivre la couverture des tests, permettant de s'assurer qu'une partie significative du code est testée.
 
    


## Analyse du code du Team Rocket :
La classe RocketPokemonFactory implémente l'interface IPokemonFactory et génère des objets Pokemon en suivant la logique de la Team Rocket. Les principaux éléments à noter dans l'implémentation sont les suivants :

## Map d'index à noms de Pokémon :

Le code initialise une map immuable index2name qui associe des indices à des noms de Pokémon. Cela permet de retrouver un nom de Pokémon en fonction de son indice.
Cependant, l’implémentation n'inclut pas de mappage pour certains indices et prévoit d'ajouter des noms de Pokémon via un commentaire (//TODO : Gotta map them all !).
 ## Génération des statistiques de Pokémon :
La méthode generateRandomStat() génère un nombre aléatoire entre 0 et 1 (en utilisant rn.nextInt(2)) et le répète un million de fois pour calculer une moyenne approximative. Cette approche est inefficace et lente. Elle semble volontairement exagérée pour générer un nombre aléatoire entre 0 et 15. Une méthode plus simple pourrait être utilisée.
 ## Création de Pokémon :
La méthode createPokemon() utilise l’indice pour déterminer le nom du Pokémon. Si l'indice n'est pas trouvé dans index2name, le nom par défaut est "MISSINGNO".
Si l'indice est inférieur à 0, des statistiques spéciales sont attribuées au Pokémon (attack, defense, stamina à 1000 et iv à 0).
Pour les autres indices, des statistiques aléatoires sont générées et l'IV est fixé à 1.
Défauts potentiels et problèmes
## Performances et efficacité :
La méthode generateRandomStat() est inefficace. Elle effectue un grand nombre d'itérations inutiles pour générer un simple nombre entre 0 et 15. La méthode peut être remplacée par return new Random().nextInt(16);, ce qui est plus simple et performant.
## Gestion de l'index non mappé :
Si un indice non mappé est passé, le nom "MISSINGNO" est attribué. Bien que cela soit correct dans le contexte, il serait utile de s'assurer que des tests couvrent cette situation, notamment pour vérifier que l'implémentation est robuste et cohérente avec les attentes des autres parties du système.
## L'IV est toujours à 1 sauf pour les indices négatifs :
Pour les indices valides (supérieurs ou égaux à 0), l'IV est systématiquement défini à 1. Cela peut ne pas correspondre à la réalité des statistiques de Pokémon, où l'IV varie normalement en fonction des valeurs de l'attaque, de la défense et de l'endurance.
Absence de gestion d'erreurs pour les indices invalides :

Si un indice invalide (par exemple, un nombre trop grand ou un indice qui ne correspond à aucun Pokémon) est passé, le système renvoie "MISSINGNO", mais il pourrait être plus robuste en lançant une exception ou en gérant mieux ce cas avec des mécanismes de validation plus clairs.

