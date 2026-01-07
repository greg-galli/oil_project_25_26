# Tests Automatisés avec Newman & Bruno

Ce projet permet de tester l'API `player_service` via **Postman (Newman)** ou **Bruno (Bru CLI)**.

## Prérequis

1.  **Node.js** doit être installé.
2.  L'application Spring Boot doit être lancée :
    ```bash
    ./gradlew bootRun
    ```

---

## Option A : Tests avec Postman (Newman)
## Exécution des tests

### Installation

```bash
npm install -g newman 
npm install -g newman-reporter-htmlextra
```

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

---

## Option B : Tests avec Bruno (Bru CLI)

### Installation
```bash
npm install -g @usebruno/cli
```

### Exécution
Depuis le dossier de qui contient le fichier `bruno.json` :

```bash
cd bruno/oil_25_26
```

```bash
bru run -r --env-var baseUrl=http://localhost:8080
```

### Sortie JSON (pour CI/CD)
```bash
bru run -r --env-var baseUrl=http://localhost:8080 --output json
```
