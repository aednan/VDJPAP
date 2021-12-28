# VDJPAP

# Beschreibung

Das Projekt besteht aus zwei Hauptkomponenten, dem Backend (jpap) und dem Frontend (jpap_frontend). Das Backend ist eine Rest-Api mit dem Endpunkt GET:fetchAll, dieser ist mit einer Spring-Sicherheitsschicht geschützt und nur autorisierte Benutzer können den Inhalt von diesem Endpunkt abrufen.

# Datenbanken

das Backend besteht aus 3 getrennten Datenbanken, jpap_db1, jpap_db2 und jpap_dbsec.
für das ERP-Modell für jede der Datenbanken sehen Sie bitte die png-Datei, die sich im Stammverzeichnis des Ordners befindet.

### jpap_db1
Datenbankname: jpap_db1
Datenbank-Benutzername: postgres
Datenbank-Passwort: postgres

### jpap_dbsec
Datenbankname: jpap_dbsec
Datenbank-Benutzername: postgres
Datenbank-Passwort: postgres

### jpap_db2
Datenbankname: jpap_db2
Datenbank-Benutzername: postgres
Datenbank-Passwort: postgres

## Endpoint: GET /student/fetchAll

der fecthAll-Endpunkt ruft die Daten aus den beiden Datenbanken jpap_db1 und jpap_db2 ab, nachdem er den Benutzer authentifiziert hat, was durch die Suche nach einer Übereinstimmung des angegebenen Benutzernamens und Passworts in der Datenbank jpap_dbsec erfolgt ist

# APP

um die App zu starten, vergewissern Sie sich bitte, dass die 3 Datenbanken erstellt wurden, bevor Sie die App starten.
das Frontend kann verwendet werden, um den Inhalt des Backend-Endpunkts zu demonstrieren und anzuzeigen


#### Backend server port: 8080
#### Frontend server port: 3000

Bitte stellen Sie sicher, dass keiner der Ports von anderen Diensten verwendet wird, andernfalls sollte die Portnummer im Frontend oder Backend entsprechend geändert werden, wenn einer der Ports von anderen Diensten verwendet ist.

## um den Backend-Server zu starten

Befehl: mvn spring-boot:run

Maven sollte bereits installiert sein, ansonsten siehe bitte https://maven.apache.org/install.html

## um den Frontend-Server zu starten

Befehl: npm start 

Nodejs sollte bereits installiert sein, ansonsten siehe bitte https://nodejs.dev/learn/how-to-install-nodejs


# Backend

das Backend verwendet Spring Framework mit Java (JDK 17) und Maven.

verwendete Bibliotheken: 

- spring-boot-starter-data-jpa
- spring-boot-starter-web
- spring-boot-starter-security
- postgresql Driver
- mapstruct && mapstruct-processor

# Frontend

das Frontend wird mit der Reactjs-Bibliothek entwickelt.

verwendete Bibliotheken: 

- @emotion/react: ^11.7.1
- @emotion/styled: ^11.6.0
- @mui/icons-material: ^5.2.5
- @mui/material: ^5.2.5
- @mui/x-data-grid: ^5.2.1
- @testing-library/jest-dom: ^5.16.1",
- @testing-library/react": ^12.1.2",
- @testing-library/user-event: ^13.5.0
- axios": ^0.24.0
- Base64": ^1.1.0
- react": ^17.0.2
- react-dom": ^17.0.2
- react-router-dom: ^5.3.0
- react-scripts: "5.0.0
- web-vitals: ^2.1.2

# Curl

eine direkte Interaktion mit dem Backend ohne das Frontend kann über einen Rest-Client oder ein Curl-Tool erfolgen;

Befehl: curl --request GET \
             --url http://localhost:8080/student/fetchAll \
             --header 'Authorization: Basic YWRtaW46YWRtaW4='
