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






