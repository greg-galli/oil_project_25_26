# Tests Automatisés avec Newman

Ce projet contient une collection Postman permettant de tester l'API `player_service`.

## Prérequis

1.  **Node.js** doit être installé.
2.  Installez **Newman** et le reporter HTML :
    ```bash
    npm install -g newman newman-reporter-htmlextra
    ```
3.  L'application Spring Boot doit être lancée :
    ```bash
    ./mvnw spring-boot:run
    ```

## Exécution des tests

### 1. Exécution simple (Console uniquement)
C'est la méthode la plus simple pour vérifier que tout fonctionne.

```bash
newman run oil_25_26.postman_collection.json --env-var baseUrl=http://localhost:8080 --reporters cli
```

### 2. Exécution avec Rapport HTML
Pour générer un rapport visuel :

```bash
newman run oil_25_26.postman_collection.json --env-var baseUrl=http://localhost:8080 --reporters cli,htmlextra --reporter-htmlextra-export report.html
```
*Note : Assurez-vous qu'il n'y a pas d'espace après la virgule dans `--reporters cli,htmlextra`.*

Un fichier `report.html` sera créé contenant le détail des succès et échecs.

## Intégration Continue (CI)

Si vous utilisez GitLab CI, GitHub Actions ou Jenkins :

```bash
newman run oil_25_26.postman_collection.json --env-var baseUrl=http://localhost:8080 --bail
```