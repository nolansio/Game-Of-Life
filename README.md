# Game of Life

## Technologies utilisées
- **Langage** : Java 25
- **Outil de build** : Gradle

> [!NOTE]
> Le plugin [Shadow](https://github.com/GradleUp/shadow) est utilisé pour générer un fichier JAR incluant toutes les dépendances.
>> Le fichier généré se termine par le suffixe `-all.jar`.

- Exécutables retrouvables dans `./build/libs/`

> [!TIP]
> L'option `--auto` permet d'exécuter le programme en continu sans attendre de saisie manuelle entre chaque affichage de la matrice.  
> L'option `--times X` permet d'arrêter le programme après `X` fois de l'affichage de la matrice (premier exclu).


---

## Cloner le dépôt
```bash
git clone https://github.com/nolansio/Game-Of-Life game_of_life
cd game_of_life
```

## Build l'application
```bash
./gradlew build --refresh-dependencies
```

## Lancer l'application avec le code source
```bash
./gradlew run
# ./gradlew run --args="--auto --times 5"
```

## Lancer l'application avec l'exécutable JAR
```bash
java -jar game_of_life-X.X.X.jar
# java -jar game_of_life-X.X.X.jar --auto --times 5
```

> [!NOTE]
> Pour arrêter l'application en mode manuelle, saisir `stop` ou `exit` dans le terminal
