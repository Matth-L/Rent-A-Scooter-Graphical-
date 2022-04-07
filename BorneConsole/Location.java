package BorneConsole;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Location {
    static int numDeRetour = 0;
    Date dateDebut;
    Date dateFin;
    int scootId;
    int numR;

    Location(Date dateDeb, Date dateEnd, int s) {
        dateDebut = dateDeb;
        dateFin = dateEnd;
        scootId = s;
        numDeRetour++;
        numR = numDeRetour;

    }

    // prend une date de format jour/mois/année
    static Date stringToDate(String date) {
        if (date.trim().equals("")) {
            // date = ""-> null
            return null;
        } else {
            SimpleDateFormat dateFrt = new SimpleDateFormat("dd/MM/yyyy");
            // pas de clémence
            dateFrt.setLenient(false);
            try {
                Date d = dateFrt.parse(date);
                return d;
            } catch (ParseException erreur) {
                // mauvaise date -> null
                return null;
            }
        }
    }

    // teste si une date est dans un autre intervalle de date.
    // Si elle y est retourne faux sinon vrai.
    boolean dateInter(Date dateDeb, Date dateF) {
        if (dateF.before(dateDebut)) {
            return false;
        } else if (dateDeb.after(dateFin)) {
            return false;
        } else {
            return true;
        }
    }

    boolean dateTest(Date dat) {
        if (dat.after(dateDebut) && dat.before(dateFin)) {
            return true;
        } else {
            return false;
        }
    }

    void setDateFin(Date f) {
        this.dateFin = f;
    }

}