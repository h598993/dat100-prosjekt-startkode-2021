package no.hvl.dat100.prosjekt.modell;

import java.util.Arrays;
import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkef√∏lgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling samling av kort som skal sorteres.
	 */

	public static void sorter(KortSamling samling) {

		// START
		Kort[] usortertTab = samling.getAllekort();
		Kort[] sortertTab = new Kort[usortertTab.length];

		// kopierer over i ny tabell
		for (int i = 0; i < usortertTab.length; i++) {
			sortertTab[i] = usortertTab[i];
		}
		// fjerner alt i orginalen
		samling.fjernAlle();
		// sorterer tabellen
		Arrays.sort(sortertTab);
		// legger sortert korttokk tilbake i samlingen

		for (int i = 0; i < sortertTab.length; i++) {
			samling.leggTil(sortertTab[i]);
		}
		// END
	}

	/**
	 * Stokkar en kortsamling.
	 * 
	 * @param samling samling av kort som skal stokkes.
	 */
	public static void stokk(KortSamling samling) {

		// START
		Random rand = new Random();

		Kort[] kortstokk = samling.getAllekort();
		Kort[] hjelpestokk = new Kort[kortstokk.length];
		// gÂr gjennom kortstokken og bytter plassering pÂ kortene.
		for (int i = 0; i < kortstokk.length; i++) {

			int r = i + rand.nextInt(kortstokk.length - i);

			Kort hjelpeVariabel = kortstokk[r];
			kortstokk[r] = kortstokk[i];
			kortstokk[i] = hjelpeVariabel;
		}
		// kopierer den ferdig stokkede kortstokken i en midlertidig stokk.
		for (int i = 0; i < kortstokk.length; i++) {
			hjelpestokk[i] = kortstokk[i];
		}

		// fjerner den opprinnelige stokken
		samling.fjernAlle();
		// legger til ferdig stokket kortstokk til samlingen, fra den midlertidige
		// stokken
		for (int i = 0; i < hjelpestokk.length; i++) {
			samling.leggTil(hjelpestokk[i]);
		}

		// END
	}

}
