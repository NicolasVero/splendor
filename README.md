# Splendor

This submission is based on one of the three end-of-year subjects that had been offered in the Computer Science DUT.  
I set myself the challenge of redoing this project on my own in a given time.

## Rules 

The project is based on the board game *Splendor*.  
Game rules: https://www.regledujeu.fr/splendor/

## Project  

The project was developed in Java (Java SE 17). It is built according to an MVC model.  

![UML diagram of the project](https://nicolas-vero.fr/img/projets/splendor/diagramme_uml.png)

I decided to separate the .java files and the .class files for better understanding: 
> Non-compiled files are located in the splendor folder  
> Compiled files are located in the application folder



## Launch the project 

To launch the project, simply run the *Splendor.exe.bat* file **OR** run these commands from the root folder:
```
javac -d application @compile.list -encoding utf8
cd application
java splendor.Controleur
```
