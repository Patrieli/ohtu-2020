package ohtu.verkkokauppa;
import java.util.*;

public interface KirjanpitoIF {
    public void lisaaTapahtuma(String tapahtuma);
    public ArrayList<String> getTapahtumat();
}