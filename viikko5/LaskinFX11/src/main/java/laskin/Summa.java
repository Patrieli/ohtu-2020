package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {

    public Summa(final TextField tuloskentta, final TextField syotekentta,  final Button nollaa, final Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    public void suorita() {
        savePreviousValue(sovellus.tulos());
        sovellus.plus(handleText(syotekentta));
        refresh();
    }

}
