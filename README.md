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
> L'option `--times <X>` permet d'arrêter le programme après `X` fois de l'affichage de la matrice (premier exclu).  
> L'option `--file <path>` permet d'instancier une matrice déjà faite avec in fichier, pour `⬜`, `O` et `0` pour les cellules vivantes et `⬛` et `X` pour les mortes.
>> Voir `base.txt` pour un exemple

---

## Cloner le dépôt
```bash
git clone https://github.com/nolansio/Game-of-Life game_of_life
cd game_of_life
```

## Build l'application
```bash
./gradlew build --refresh-dependencies
```

## Lancer l'application avec le code source
```bash
./gradlew run
# ./gradlew run --args="--auto --times 5 --file base.txt"
```

## Lancer l'application avec l'exécutable JAR
```bash
java -jar game_of_life-X.X.X.jar
# java -jar game_of_life-X.X.X.jar --auto --times 5 --file base.txt
```

> [!NOTE]
> Pour arrêter l'application en mode manuelle, saisir `stop` ou `exit` dans le terminal
