# XML-projekat
Verzija jave je 1.8
## Postavljanje baza
- Za XML koristi se <b>exist</b> baza a za meta podatke koristi se <b>fuseki</b> (https://jena.apache.org/documentation/fuseki2/)
#### Kako se instalira
- Skida se tomcat verzija 8 (https://tomcat.apache.org/download-80.cgi)
- U webapps tomcata postavite existPoverenik.war, existSluzbenik.war, fusekiPoverenik.war i fusekiSluzbenik.war
  fajlove
- Onda u lib folderu pokrenite tomcat preko komande 'startup'
- kada pokrenete tomcat u fuseki baze napravite kolekcije:zahtevi,resenja,obavestenja,zalbenaodluku,zalbecutanje,izvestaji
## Frontend
- Koristi se xonomy (https://github.com/michmech/xonomy) i jQuery
- kada otvorite angular projekte prvo instalirajte module komandom 'npm install', a zatim ih pokrenite sa komandom 'ng serve'
## Backend
- otvorite backend projekte u razvojnom okruženju sa podržanim Spring Boot-om
- instalirajte sve dependencies preko 'maven run' i zatim pokrenite aplikaciju
## Portovi
#### Poverenik
 - spring: http://localhost:8082
 - angular: http://localhost:4201
 - exist db: http://localhost:8081/existPoverenik
 - fuseki db: http://localhost:8081/fusekiPoverenik/
#### Sluzbenik
 - spring:http://localhost:8080
 - angular:http://localhost:4200
 - exist db:http://localhost:8081/existSluzbenik
 - fuseki db:http://localhost:8081/fusekiSluzbenik/
#### Mail
 - spring:http://localhost:8088
## Ostalo
 -građani se mogu registrovati i prijaviti na oba portala
 -službenik i poverenik  se prijavljuju sa mailom Email0@email.com i šifrom user
