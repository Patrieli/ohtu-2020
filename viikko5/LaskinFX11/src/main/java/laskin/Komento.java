package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Komento {

    Button nollaa;
    TextField tuloskentta;
    TextField syotekentta;
    Sovelluslogiikka sovellus;
    Button undo;
    int previousValue;

    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.nollaa = nollaa;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = sovellus;
        this.undo = undo;
        this.previousValue = 0;
    }

    public void suorita() {
    }

    public void peru() {
        sovellus.nollaa();
        sovellus.plus(previousValue);
        syotekentta.setText("");
        tuloskentta.setText("" + previousValue);
        undo.disableProperty().set(true);
        if ( previousValue==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
    }

    public int handleText(TextField syotekentta) {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        return arvo;
    }

    public void refresh() {
        int laskunTulos = sovellus.tulos();
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        undo.disableProperty().set(false);
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
    }

    public void savePreviousValue(int prev) {
        this.previousValue = prev;
    }
}
