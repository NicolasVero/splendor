# Splendor

Ce dépôt s'appuie sur un des trois sujets de fin d'année qui avait été proposé en DUT Informatique.  
Je m'étais donné le défi de refaire ce projet seul dans un temps donné. 

## Règles 

Le projet s'appuie sur le jeu de société éponyme.  
Règles du jeu : https://www.regledujeu.fr/splendor/

## Projet 

Le projet a été fait en Java (Java SE 17). Il est construit selon un modèle MVC.

![Diagramme UML du projet](https://nicolas-vero.fr/img/projets/splendor/diagramme_uml.png)

J'ai décidé de séparer les fichiers .java et les fichiers .class pour plus de compréhension : 
> Les fichiers non compilés sont situés dans le dossier splendor  
> Les fichiers compilés sont situés dans le dossier application


## Lancer le projet 

Pour lancer le projet, il suffit d'exécuter le fichier *Splendor.exe.bat* **OU** lancer ces commandes depuis le dossier racine :
```
javac -d application @compile.list -encoding utf8
cd application
java splendor.Controleur
```

> [!IMPORTANT]
> Certaines actions décrites dans les règles du jeu ne sont pas disponibles
