Projet TP — Java Design Patterns (Tri et Réservations)

Ce dépôt contient un TP simple montrant :
- Une classe `ReservationController` (création et calcul des réservations).
- Un utilitaire `Tri` avec trois algorithmes de tri (Bubble, Insertion, Selection).
- Tests unitaires JUnit pour valider le comportement.

Prérequis
- JDK 11+ installé
- Apache Maven installé

Configurer l'environnement (Windows PowerShell)
1. Définir `JAVA_HOME` sur le dossier du JDK (exemple) :

```powershell
setx JAVA_HOME "C:\Program Files\Java\jdk-17.0.x"
```

2. Ajouter Maven au `PATH` (si Maven est dans `C:\Users\evant\Downloads\apache-maven-3.9.16`):

```powershell
setx MAVEN_HOME "C:\Users\evant\Downloads\apache-maven-3.9.16"
setx PATH "$env:PATH;C:\Users\evant\Downloads\apache-maven-3.9.16\bin"
```

3. Fermer et rouvrir le terminal pour que `setx` prenne effet.

Vérifier l'installation

```powershell
java -version
mvn -version
```

Lancer les tests

- En PowerShell (script fourni) :

```powershell
.\run-tests.ps1
```

- En bash (script fourni) :

```bash
./run-tests.sh
```

Contenu important
- `src/main/java/org/sebsy/strategy/Tri.java` — implémente trois algorithmes de tri et validations.
- `src/main/java/org/sebsy/grasps/ReservationController.java` — contrôleur de réservation avec validations.
- `src/test/java/...` — tests unitaires JUnit.

Besoin d'aide
Si tu veux que j'exécute les tests ici, fournis le chemin du JDK installé sur cette machine ou exécute les scripts et colle la sortie. Je peux aussi créer un build GitHub Actions si tu veux l'intégration continue.
