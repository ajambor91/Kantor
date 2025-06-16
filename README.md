# Kantor
**Aplikacja pokazowa!**
## Czym jest Kantor? 
Kantor, to aplikacja, którą buduję na kanale YouTube [@BitTechWorld](https://www.youtube.com/@bitstechworld/videos), żeby móc podzielić się swoją praca z szerszą publiką.
Aplikacja jest pokazowa, **z tego powodu w repozytorium dostępne są "sekrety" jako exampleuser itd.**.
Kantor to aplikacja w Spring 3.5.0 z bazami danych PostgreSQL, MongoDB, oraz narzędziami jak HashiCorp Vault. Cały proces kodowania, oraz konfiguracji narzędzi pokazuję w serii filmów na YouTube na moim kanale. 
W planach aplikacja będzie umożliwiać rejestracje oraz autoryzacje użytkwników z uwzględnieniem OAuth2, aplikacja będzie oparta na mikrousługach, w planach jest dodanie CI/CD, grafany, nginxa oraz innych.
**Panuje tutaj zasada 1 commit = 1 odcinek** , więc nie zawsze aplikacja będzie działac, ponieważ nie chcę nagrywać dłuższych odcinków niż 30 minutowe, a nie zawsze uda mi się zaimplementować zaplanowane feature'y i doprowadzić aplikację do stanu używalności.
## Co potrzeba do odpalenia?
1. Docker - tak, na początku wystarczy docker
2. Opcjonalne: Java 23, żeby móc zbudować aplikacje bez środowiska docker

## Jak odpalić?
1. Pobierz to repozytorium:
```bash 
    git clone https://github.com/ajambor91/Kantor.git
```
2. Przejdź do katalogu repozytorium i uruchom:
```bash
    docker compose build
    docker compose up -d
```
3. Skonfiguruj Vault - pokazane w odcinku nr 4 z integracji HashiCorp Vault, komendy są w pliku `commands` w katalogu `vault`
4. Uruchom ponownie aplikację users, np.
```bash 
    docker compose up -d users
```


