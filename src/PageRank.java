import java.util.Arrays;
import java.util.Comparator;

public class PageRank {

	/**
	 * Diese Methode erstellt die Matrix A~ fuer das PageRank-Verfahren
	 * PARAMETER: 
	 * L: die Linkmatrix (s. Aufgabenblatt) 
	 * rho: Wahrscheinlichkeit, anstatt einem Link zu folgen,
	 *      zufaellig irgendeine Seite zu besuchen
	 */
	public static double[][] buildProbabilityMatrix(int[][] L, double rho) {
		//TODO: Diese Methode ist zu implementieren
		if(L == null || rho > 1D || rho < 0D) {
			return null;
		}
		
		double resultMatrix[][] = new double[L.length][L[0].length];
		int num_Links[] = new int[L.length];	// holds number of links this website has (including itself)
		
		// initialize num_Links matrix 
		for(int i = 0; i < num_Links.length; i++) {
			for(int j = 0; j < L.length; j++) {
				num_Links[i] += L[j][i];	// can only be zero or one
			}
		}
		
		
		for(int i = 0; i < L.length; i++) {
			for(int j = 0; j < L.length; j++) {
				resultMatrix[i][j] = (1D-rho)*L[i][j]*(1D/(double)num_Links[j]) + rho/L.length;
			}
		}
		
		return resultMatrix;
	}

	/**
	 * Diese Methode berechnet die PageRanks der einzelnen Seiten,
	 * also das Gleichgewicht der Aufenthaltswahrscheinlichkeiten.
	 * (Entspricht dem p-Strich aus der Angabe)
	 * Die Ausgabe muss dazu noch normiert sein.
	 * PARAMETER:
	 * L: die Linkmatrix (s. Aufgabenblatt) 
	 * rho: Wahrscheinlichkeit, zufaellig irgendeine Seite zu besuchen
	 * ,anstatt einem Link zu folgen.
	 *      
	 */
	public static double[] rank(int[][] L, double rho) {
		//TODO: Diese Methode ist zu implementieren
		return new double[2];
	}

	/**
	 * Diese Methode erstellt eine Rangliste der uebergebenen URLs nach
	 * absteigendem PageRank. 
 	 * PARAMETER:
 	 * urls: Die URLs der betrachteten Seiten
 	 * L: die Linkmatrix (s. Aufgabenblatt) 
 	 * rho: Wahrscheinlichkeit, anstatt einem Link zu folgen,
 	 *      zufaellig irgendeine Seite zu besuchen
	 */ 
	public static String[] getSortedURLs(String[] urls, int[][] L, double rho) {
		int n = L.length;

		double[] p = rank(L, rho);

		RankPair[] sortedPairs = new RankPair[n];
		for (int i = 0; i < n; i++) {
			sortedPairs[i] = new RankPair(urls[i], p[i]);
		}

		Arrays.sort(sortedPairs, new Comparator<RankPair>() {

			public int compare(RankPair o1, RankPair o2) {
				return -Double.compare(o1.pr, o2.pr);
			}
		});

		String[] sortedUrls = new String[n];
		for (int i = 0; i < n; i++) {
			sortedUrls[i] = sortedPairs[i].url;
		}

		return sortedUrls;
	}

	/**
	 * Ein RankPair besteht aus einer URL und dem zugehoerigen Rang, und dient
	 * als Hilfsklasse zum Sortieren der Urls
	 */
	private static class RankPair {
		public String url;
		public double pr;

		public RankPair(String u, double p) {
			url = u;
			pr = p;
		}
	}
}
