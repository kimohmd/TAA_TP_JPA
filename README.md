# TP JPA et Servlet Kanban board

## Exécution
placez-vous dans la racine du projet.

lancer le système de base de données:
```bash 
./run-hsqldb-server.sh 
```
lancer le manager:
```bash 
./show-hsqldb.sh
```
login : sa – et pas de mot de passe : -- URL de connexion : jdbc:hsqldb:hsql://localhost/

lancer jetty:
```bash
mvn jetty:run
```
rendez-vous dans [http://localhost:8080/kanban.html](http://localhost:8080/kanban.html)
le formulaire permet de peupler la BDD, une fois envoyé vous serez redirigé vers [http://localhost:8080/bdd](http://localhost:8080/bdd) où vous avez une vue des données enregistrées.
vous pouvez toujours vérifier que les données sont bien enregistrées dans la bdd depuis le manager.


## Auteur
Abdel Karim HAMMAD
