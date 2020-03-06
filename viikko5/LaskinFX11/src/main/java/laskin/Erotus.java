package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {

    public Erotus(final TextField tuloskentta, final TextField syotekentta,  final Button nollaa, final Button undo, final Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    public void suorita() {
        savePreviousValue(sovellus.tulos());
        sovellus.miinus(handleText(syotekentta));
        refresh();
    }

}
