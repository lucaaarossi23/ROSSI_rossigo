package app;

import com.github.lalyos.jfiglet.FigletFont;
import eccezioni.CodiceFiscaleNonValidoException;
import eccezioni.RossiGoException;
import modello.Bici;
import modello.Monopattino;
import servizio.FlottaService;
import servizio.Utente;
import java.io.IOException;
import static java.lang.IO.println;

public class Main {
    static void main() throws IOException {
        println(FigletFont.convertOneLine("ROSSIGO"));

        FlottaService flotta = new FlottaService();

        Bici bici1 = new Bici("B01", 80, "LIBERO", 7);
        Bici bici2 = new Bici("B02", 10, "LIBERO", 6);

        Monopattino mono1 = new Monopattino("M01", 90, "LIBERO");
        Monopattino mono2 = new Monopattino("M02", 60, "LIBERO");

        flotta.registraVeicolo(bici1);
        flotta.registraVeicolo(bici2);
        flotta.registraVeicolo(mono1);
        flotta.registraVeicolo(mono2);

        Utente u1 = new Utente("U01", "Mario", "mario@gmail.com", "RSSLCU08H23L840O", 20.0);

        Utente u2 = new Utente("U02", "Luca", "luca@gmail.com", "RSSLCU08H23L840O", 5.0);

        Utente u3 = new Utente("U03", "Riccardo", "riccardo@gmail.com", "CODICEFISCALEERRATO", 10.0);

        //1 - REGISTRAZIONE UTENTI
        try {
            flotta.registraUtente(u1);
            println("utente registrato correttamente");
        } catch (CodiceFiscaleNonValidoException e) {
            println("registrazione fallita: " + e.getMessage());
        }

        try {
            flotta.registraUtente(u2);
            println("Utente registrato correttamente");
        } catch (CodiceFiscaleNonValidoException e) {
            println("Registrazione fallita: " + e.getMessage());
        }

        //2 - ECCEZIONE CODICE FISCALE
        try {
            flotta.registraUtente(u3);
            println("Utente registrato correttamente");
        } catch (CodiceFiscaleNonValidoException e) {
            println("Registrazione fallita: " + e.getMessage());
        }

        //3 - SBLOCCA VEICOLO
        println("\n--UTENTE 1 NOLEGGIA BICI 1--");
        try {
            flotta.sbloccaVeicolo("B01", "U01");
            println("Veicolo sbloccato");
        } catch (RossiGoException e) {
            println("Noleggio non riuscito: " + e.getMessage());
        }

        //4 - ECCEZIONE BICI IN USO
        println("\n--UTENTE 2 NOLEGGIA BICI 1--");
        try {
            flotta.sbloccaVeicolo("B01", "U02");
            println("Veicolo sbloccato");
        } catch (RossiGoException e) {
            println("Noleggio non riuscito: " + e.getMessage());
        }

        //5 - ECCEZIONE BATTERIA SCARICA
        println("\n--UTENTE 1 NOLEGGIA BICI 2");
        try {
            flotta.sbloccaVeicolo("B02", "U01");
            println("Veicolo sbloccato");
        } catch (RossiGoException e) {
            println("Noleggio non riuscito: " + e.getMessage());
        }

        //6 - ECCEZIONE UTENTE INESISTENTE
        println("\n--UTENTE INESISTENTE NOLEGGIA MONOPATTINO 1");
        try {
            flotta.sbloccaVeicolo("M01", "U10");
            println("Veicolo sbloccato");
        } catch (RossiGoException e) {
            println("Noleggio non riuscito: " + e.getMessage());
        }

        //7 - TERMINA NOLEGGIO
        flotta.terminaNoleggio("B01", 20);
        println("\nNoleggio terminato");
        println("Credito dell'utente associato: " + u1.getCredito() + " euro");
        println("Batteria veicolo: " + bici1.getLivelloBatteria() + "%");
    }
}
