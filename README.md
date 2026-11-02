# RossiGo - Servizio di mobilità urbana

RossiGo simula un servizio di noleggio di biciclette e monopattini in una città.

Il programma permette di registrare utenti e veicoli, avviare e terminare noleggi, gestire il credito degli utenti e  controllare la disponibilità e la batteria dei mezzi.

## Librerie esterne

- codice-fiscale: Libreria utilizzata per verificare la validità dei codici fiscali.
- JFiglet: Libreria utilizzata per generare il titolo RossiGo in ASCII art.

## Funzionalità

- Registrazione dei veicoli
- Registrazione degli utenti
- Sblocco dei veicoli
- Controllo del credito e della batteria
- Calcolo del costo del noleggio
- Aggiornamento del credito e della batteria

## Scenari simulati

1. Registrazione di utenti con codice fiscale valido
2. Registrazione con codice fiscale non valido
3. Sblocco di una bicicletta disponibile
4. Tentativo di sbloccare una bici già in uso
5. Tentativo di sbloccare una bici con batteria scarica
6. Noleggio da parte di un utente inesistente
8. Termine di un noleggio
