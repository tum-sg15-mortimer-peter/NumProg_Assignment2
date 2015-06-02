import java.lang.*;

public class Gauss {

	/**
	 * Diese Methode soll die Loesung x des LGS R*x=b durch
	 * Rueckwaertssubstitution ermitteln.
	 * PARAMETER: 
	 * R: Eine obere Dreiecksmatrix der Groesse n x n 
	 * b: Ein Vektor der Laenge n
	 */
	public static double[] backSubst(double[][] R, double[] b) {
		
		//TODO: Diese Methode ist zu implementieren
		double calc_b[] = new double[b.length];
		double calc_R[][] = new double[R.length][R[0].length];
		
		// check for valid array lengths
		if(R.length != b.length) {
			double error[] = {0};
			return error;
		}
		
		// copy array values to their calc variables to
		// to not change the parameter values
		
		System.arraycopy(b,0,calc_b,0,b.length);
		System.arraycopy(R,0,calc_R,0,R.length);
		
		double add = 0.0;
		
		for(int i = R.length-1; i >= 0; i--) {
			for(int j = i-1; j >= 0; j--) {
				add = (-1D) * (calc_R[i][j]/calc_R[i][i]);
				if(add == 0D) {continue;}
				calc_R[i][j] +=  calc_R[i][i]* add;
				calc_b[j] +=  calc_b[i]* add;
			}
			
			if(calc_R[i][i] == 0) {
				double error[] = {0};
				return error;
			}
			
			calc_b[i] /= calc_R[i][i];
		}
		
		return calc_b;
		
	}
	

	/**
	 * Diese Methode soll die Loesung x des LGS A*x=b durch Gauss-Elimination mit
	 * Spaltenpivotisierung ermitteln. A und b sollen dabei nicht veraendert werden. 
	 * PARAMETER: A:
	 * Eine regulaere Matrix der Groesse n x n 
	 * b: Ein Vektor der Laenge n
	 */
	public static double[] solve(double[][] A, double[] b) {
		//TODO: Diese Methode ist zu implementieren
		double calc_b[] = new double[b.length];
		double calc_A[][] = new double[A.length][A[0].length];
				
		// check for valid array lengths
		if(A.length != b.length) {
			double error[] = {0};
			return error;
		}
				
		// copy array values to their calc variables to
		// to not change the parameter values
				
		System.arraycopy(b,0,calc_b,0,b.length);
		System.arraycopy(A,0,calc_A,0,A.length);
		
		for(int i = 0; i < b.length-1; i++) {
			// Pivot Suche
			int pivot_index = i;
			double pivot_element = calc_A[i][i];
			for(int k = i; k < b.length; k++) {
				if(Math.abs(calc_A[i][k]) > Math.abs(pivot_element)) {
					pivot_index = k;
					pivot_element = calc_A[i][k];
				}
			}
			if(pivot_index != i) {	// check if even necessary

				// switch pivot element line
				double buffer = 0D;
				for(int k = 0; k < b.length; k++) {
					buffer = calc_A[k][i];
					calc_A[k][i] = calc_A[k][pivot_index]; 
					calc_A[k][pivot_index] = buffer;
				}
				
				// also switch values in b
				double b_buffer = 0D;
				b_buffer = calc_b[i];
				calc_b[i] = calc_b[pivot_index];
				calc_b[pivot_index] = b_buffer;
				
			}
			
			// subtracting every row j > i by a(j,i)/a(i,i)
			double divisor = calc_A[i][i];
			if(divisor == 0) {
				double error[] = {0};
				return error;
			}
			for(int j = i+1; j < b.length; j++) {
				double add = calc_A[i][j]/divisor;
				for(int k = 0; k < b.length; k++) {
					if(add != 0D) {
						calc_A[k][j] -= calc_A[k][i]*add;
					}
				}
				calc_b[j] -= calc_b[i]*add;
				
			}
			
		}
		
		return backSubst(calc_A,calc_b);
		
		
	}

	/**
	 * Diese Methode soll eine Loesung p!=0 des LGS A*p=0 ermitteln. A ist dabei
	 * eine nicht invertierbare Matrix. A soll dabei nicht veraendert werden.
	 * 
	 * Gehen Sie dazu folgendermassen vor (vgl.Aufgabenblatt): 
	 * -Fuehren Sie zunaechst den Gauss-Algorithmus mit Spaltenpivotisierung 
	 *  solange durch, bis in einem Schritt alle moeglichen Pivotelemente
	 *  numerisch gleich 0 sind (d.h. <1E-10) 
	 * -Betrachten Sie die bis jetzt entstandene obere Dreiecksmatrix T und
	 *  loesen Sie Tx = -v durch Rueckwaertssubstitution 
	 * -Geben Sie den Vektor (x,1,0,...,0) zurueck
	 * 
	 * Sollte A doch intvertierbar sein, kann immer ein Pivot-Element gefunden werden(>=1E-10).
	 * In diesem Fall soll der 0-Vektor zurueckgegeben werden. 
	 * PARAMETER: 
	 * A: Eine singulaere Matrix der Groesse n x n 
	 */
	public static double[] solveSing(double[][] A) {
		//TODO: Diese Methode ist zu implementieren
		
		double T [][];
		double v [];
		
		if(A.length != A[0].length) {
			double error[] = {0};
			return error;
		}
		
		double calc_A[][] = new double[A.length][A.length];
		System.arraycopy(A,0,calc_A,0,A.length);
		
		for(int i = 0; i < A.length; i++) {
			// Pivot Suche
			int pivot_index = i;
			double pivot_element = calc_A[i][i];
			for(int k = i; k < A.length; k++) {
				if(Math.abs(calc_A[i][k]) > Math.abs(pivot_element)) {
					pivot_index = k;
					pivot_element = calc_A[i][k];
				}
			}
			// matrix can't be solved by Gauss anymore
			if(pivot_element == 0) {
				T = new double[i][i];
				v = new double[i];
				
				// copy the values into the triangle T
				for(int a = 0; a < i; a++) {
					for(int b = 0; b < i; b++) {
						T[a][b] = calc_A[a][b];
					}
				}
				
				// copy the values into the vector v
				for(int a = 0; a < i; a++) {
					v[a] = -1 * calc_A[i][a];
				}
				
				double x[] = backSubst(T,v);
				double result[] = new double[A.length];
				for(int c = 0; c < x.length; c++) {
					result[c] = x[c];
				}
				result[x.length] = 1;
				// the rest is initialized as zero anyways in Java
				return result;
				
			}
			
			if(pivot_index != i) {	// check if even necessary

				// switch pivot element line
				double buffer = 0D;
				for(int k = 0; k < A.length; k++) {
					buffer = calc_A[k][i];
					calc_A[k][i] = calc_A[k][pivot_index]; 
					calc_A[k][pivot_index] = buffer;
				}
							
							
			}
						
			// subtracting every row j > i by a(j,i)/a(i,i)
			double divisor = calc_A[i][i];
			if(divisor == 0) {
				double error[] = {0};
				return error;
			}
			for(int j = i+1; j < A.length; j++) {
				double add = calc_A[i][j]/divisor;
				for(int k = 0; k < A.length; k++) {
					if(add != 0D) {
						calc_A[k][j] -= calc_A[k][i]*add;
					}
				}	
			}
		}
		
		double error[] = {0};
		return error;
		
	}

	/**
	 * Diese Methode berechnet das Matrix-Vektor-Produkt A*x mit A einer nxm
	 * Matrix und x einem Vektor der Laenge m. Sie eignet sich zum Testen der
	 * Gauss-Loesung
	 */
	public static double[] matrixVectorMult(double[][] A, double[] x) {
		int n = A.length;
		int m = x.length;

		double[] y = new double[n];

		for (int i = 0; i < n; i++) {
			y[i] = 0;
			for (int j = 0; j < m; j++) {
				y[i] += A[i][j] * x[j];
			}
		}

		return y;
	}
}
