public class Test {

	/*************************************************************/
	/* WICHTIG: Das bestehen dieser Tests sagt nahezu gar nichts */
	/* ueber das korrekte Funktionieren ihres Programms */
	/* aus. Es dient einzig und allein als Rahmen zur */
	/* leichteren Implementierung eigener Tests! */

	/*
	 * Nach Durchfuehrung der Tests startet der Crawler mit GUI. Mit ihm koennen
	 * neue LinkMatrizen erstellt werden.
	 */
	/*************************************************************/
	public static void main(String[] args) throws Exception {

		System.out
				.println("WICHTIG: Das bestehen dieser Tests sagt nahezu gar nichts "
						+ "ueber das korrekte Funktionieren ihres Programms aus.\n"
						+ "Es dient einzig und allein als Rahmen zurleichteren Implementierung eigener Tests!");

		boolean test_gauss = true;
		boolean test_pagerank = true;
		boolean test_crawler = true;

		double b[] = { 1, 1 };
		double C[][] = { { 1, 0 }, { 0, 1 } };
		double A[][] = { { 1, 1 }, { 1, 1 } };
		double xC[] = { 1, 1 };
		double xA[] = { 1, -1 };
		double x[];
		
		double testM1[][] = { {4,0,0} , {3,7,0} , {9,2,1} };
		double testB1[] = {1,1,1};
		double resultMB1[] = {-53D/28D,-1D/7D, 1D};
		
		double testM2[][] = {{6}};
		double testB2[] = {1D/6D};
		double resultMB2[] = {1/36D};
		
		double testM3[][] = {{0}};
		double testB3[] = {1D/6D};
		double resultMB3[] = {0};
		
		double testM4[][] = {{0}};
		double testB4[] = {1D/6D, 0D};
		double resultMB4[] = {0};

		/******************************/
		/* Test der Klasse Gauss */
		/******************************/
		if (test_gauss) {
			System.out.println("-----------------------------------------");
			System.out
					.println("primitiver und unvollstaendiger Test der Klasse Gauss");

			System.out
					.println("  primitiver und unvollstaendiger Test der Methode backSubst");
			x = Gauss.backSubst(C, b);
			if (Util.vectorCompare(x, xC)) {
				System.out.println("    Richtiges Ergebnis");
			} else {
				System.out.println("    FEHLER: falsches Ergebnis:");
				Util.printVector(x);
				System.out.println("            richtiges Ergebnis:");
				Util.printVector(xC);
			}
			
			// Eigener Test
			
			System.out.println("	Test fuer M1 * x = B1:\n");
			x = Gauss.backSubst(testM1, testB1);
			if(Util.vectorCompare(x, resultMB1)) {
				System.out.println("		Richtiges Ergebnis zu M1 * x = B1\n");
			} else {
				System.out.println("    FEHLER: falsches Ergebnis:");
				Util.printVector(x);
				System.out.println("            richtiges Ergebnis:");
				Util.printVector(resultMB1);
			}
			
			System.out.println("	Test fuer M2 * x = B2:\n");
			x = Gauss.backSubst(testM2, testB2);
			if(Util.vectorCompare(x, resultMB2)) {
				System.out.println("		Richtiges Ergebnis zu M2 * x = B2\n");
			} else {
				System.out.println("    FEHLER: falsches Ergebnis:");
				Util.printVector(x);
				System.out.println("            richtiges Ergebnis:");
				Util.printVector(resultMB2);
			}
			
			System.out.println("	Test fuer M3 * x = B3:\n");
			x = Gauss.backSubst(testM3, testB3);
			if(Util.vectorCompare(x, resultMB3)) {
				System.out.println("		Richtiges Ergebnis zu M3 * x = B3\n");
			} else {
				System.out.println("    FEHLER: falsches Ergebnis:");
				Util.printVector(x);
				System.out.println("            richtiges Ergebnis:");
				Util.printVector(resultMB3);
			}
			
			System.out.println("	Test fuer M4 * x = B4:\n");
			x = Gauss.backSubst(testM4, testB4);
			if(Util.vectorCompare(x, resultMB4)) {
				System.out.println("		Richtiges Ergebnis zu M4 * x = B4\n");
			} else {
				System.out.println("    FEHLER: falsches Ergebnis:");
				Util.printVector(x);
				System.out.println("            richtiges Ergebnis:");
				Util.printVector(resultMB4);
			}

			System.out
					.println("  primitiver und unvollstaendiger Test der Methode solve");
			x = Gauss.solve(C, b);
			if (Util.vectorCompare(x, xC)) {
				System.out.println("    Richtiges Ergebnis");
			} else {
				System.out.println("    FEHLER: falsches Ergebnis:");
				Util.printVector(x);
				System.out.println("            richtiges Ergebnis:");
				Util.printVector(xC);
			}
			

			double testM5[][] = {{1,2,-2}, {1,1,0}, {1,1,1}};
			double testB5[] = {3,2,1};
			double resultMB5[] = {-1,5,-1};
			
			double testM6[][] = {{1,0,0}, {1,1,0}, {1,1,1}};
			double testB6[] = {3,2,1};
			double resultMB6[] = {1,1,1};
			
			double testM7[][] = {{1,1,1}, {0,1,1}, {0,0,1}};
			double testB7[] = {1,2,3};
			double resultMB7[] = {1,1,1};
			
			
			System.out.println("	Test fuer M5 * x = B5:\n");
			x = Gauss.solve(testM5, testB5);
			if(Util.vectorCompare(x, resultMB5)) {
				System.out.println("		Richtiges Ergebnis zu M5 * x = B5\n");
			} else {
				System.out.println("    FEHLER: falsches Ergebnis:");
				Util.printVector(x);
				System.out.println("            richtiges Ergebnis:");
				Util.printVector(resultMB5);
			}
			
			System.out.println("	Test fuer M6 * x = B6:\n");
			x = Gauss.solve(testM6, testB6);
			if(Util.vectorCompare(x, resultMB6)) {
				System.out.println("		Richtiges Ergebnis zu M6 * x = B6\n");
			} else {
				System.out.println("    FEHLER: falsches Ergebnis:");
				Util.printVector(x);
				System.out.println("            richtiges Ergebnis:");
				Util.printVector(resultMB6);
			}
			
			System.out.println("	Test fuer M7 * x = B7:\n");
			x = Gauss.solve(testM7, testB7);
			if(Util.vectorCompare(x, resultMB7)) {
				System.out.println("		Richtiges Ergebnis zu M7 * x = B7\n");
			} else {
				System.out.println("    FEHLER: falsches Ergebnis:");
				Util.printVector(x);
				System.out.println("            richtiges Ergebnis:");
				Util.printVector(resultMB7);
			}
			
			// A[][] = { { 1, 1 }, { 1, 1 } };

			System.out
					.println("  primitiver und unvollstaendiger Test der Methode solveSing");
			x = Gauss.solveSing(A);
			double lambda = xA[0] / x[0];
			for (int i = 0; i < x.length; i++) {
				x[i] *= lambda;
			}
			if (Util.vectorCompare(x, xA)) {
				System.out.println("    Richtiges Ergebnis");
			} else {
				System.out.println("    FEHLER: falsches Ergebnis:");
				Util.printVector(x);
				System.out.println("            richtiges Ergebnis:");
				Util.printVector(xA);
			}
			
			double testM8[][] = {{1,1,2}, {3,-1,1}, {-1,3,3}};
			double resultMB8[] = {-2,1,1}; 
			
			System.out.println("	Test fuer M8 * x = B8:\n");
			x = Gauss.solveSing(testM8);
			if(Util.vectorCompare(x, resultMB8)) {
				System.out.println("		Richtiges Ergebnis zu M8 * x = B8\n");
			} else {
				System.out.println("    FEHLER: falsches Ergebnis:");
				Util.printVector(x);
				System.out.println("            richtiges Ergebnis:");
				Util.printVector(resultMB8);
			}
			
		}

		/******************************/
		/* Test der Klasse PageRank */
		/******************************/
		if (test_pagerank) {
			System.out.println("-----------------------------------------");
			System.out
					.println("primitiver und unvollstaendiger Test der Klasse PageRank");

			LinkMatrix lm = new LinkMatrix();
			/*
			 * Es koennte sein, dass in Eclipse die Datei nicht gefunden wird.
			 * Sie muessen entweder den gesamten absoluten Pfad angeben oder die
			 * Umgebung entsprechend einrichten.
			 */
			lm.read("irgendwo.txt");

			System.out
					.println("  primitiver und unvollstaendiger Test der Methode buildMatrix");

			A = PageRank.buildProbabilityMatrix(lm.L, 0.15);
			double A0[][] = { { 0.5, 0.5 }, { 0.5, 0.5 } };
			if (Util.matrixCompare(A, A0)) {
				System.out.println("    Richtiges Ergebnis");
			} else {
				System.out.println("    FEHLER: falsches Ergebnis:");
				Util.printMatrix(A);
				System.out.println("            richtiges Ergebnis:");
				Util.printMatrix(A0);
			}

			System.out
					.println("  primitiver und unvollstaendiger Test der Methode rank");
			String r[] = PageRank.getSortedURLs(lm.urls, lm.L, 0.15);

			String r0[] = { "http://www.irgendwo.de", "http://www.nirgendwo.de" };
			String r1[] = { "http://www.nirgendwo.de", "http://www.irgendwo.de" };
			if (Util.rankingCompare(r, r0)) {
				System.out.println("    Richtiges Ergebnis");
			} else if (Util.rankingCompare(r, r1)) {
				System.out.println("    Richtiges Ergebnis");
			} else {
				System.out.println("    FEHLER: falsches Ergebnis:");
				Util.printStringArray(r);
				System.out.println("            richtiges Ergebnis:");
				Util.printStringArray(r0);
			}
		}

		if (test_crawler) {
			(new GUI()).setVisible(true);
		}
	}
}
