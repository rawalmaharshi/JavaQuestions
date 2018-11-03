
public class Polynomial {
	
	DynamicArray coefficients;
	
	public Polynomial() {
		coefficients = new DynamicArray();
//		System.out.println(coefficients.size());
	}
	
	public void setCoefficient(int deg, int coeff) {
		//degree is nextIndex
		
		if(deg > coefficients.size()) {
			for (int i = 0; i < deg; i++) {
				coefficients.add(0);
			}
		}
		coefficients.set(deg, coeff);
	}
	
	public int getCoefficient (int deg) {
		int coeff = coefficients.get(deg);
		return coeff;
	}
	
	public int degree() {
		int deg = 0;
		for (int i = 0; i < coefficients.size(); i++) {
			if(coefficients.get(i) > 0) {
				deg = i;
			}
		}
		return deg;
	}
	
	public void print() {
		for (int i = 0; i< coefficients.size(); i++) {
			if(coefficients.get(i) == 0) {
				continue;
			}
			else
				System.out.print(coefficients.get(i) + "x" + i + " ");
		}
		System.out.println("");
	}
	
	public Polynomial add (Polynomial p) {
		Polynomial sum = new Polynomial();
		
		// this is p1 and p is p2
//		System.out.println(this.coefficients.size());
//		System.out.println(p.coefficients.size());
		int isBigger = (this.degree() > p.degree()) ? this.degree() : p.degree();
		for (int i = 0; i <= isBigger; i++) {
//			System.out.println("here" + i);
			if(this.getCoefficient(i) > 0 || p.getCoefficient(i) > 0) {
//				System.out.println("change");
				int newCoeff = this.getCoefficient(i) + p.getCoefficient(i);
//				System.out.println("This: " + this.getCoefficient(i) + "P: " + p.getCoefficient(i));
				sum.setCoefficient(i, newCoeff);
			}
		}
		
		return sum;
	}
	
//	public void subtract (Polynomial p) {
//		int isBigger = (this.degree() > p.degree()) ? this.degree() : p.degree();
//		for (int i = 0; i <= isBigger; i++) {
//			if(this.getCoefficient(i) > 0 || p.getCoefficient(i) > 0) {
//				int newCoeff = this.getCoefficient(i) - p.getCoefficient(i);
//				this.setCoefficient(i, newCoeff);
//			}
//		}
//	}
	
	public Polynomial subtract (Polynomial p) {
		Polynomial diff = new Polynomial();
		
		int isBigger = (this.degree() > p.degree()) ? this.degree() : p.degree();
		for (int i = 0; i <= isBigger; i++) {
			if(this.getCoefficient(i) > 0 || p.getCoefficient(i) > 0) {
				int newCoeff = this.getCoefficient(i) - p.getCoefficient(i);
				diff.setCoefficient(i, newCoeff);
			}
		}
		
		return diff;
	}
	
	public Polynomial multiply (Polynomial p) {
		Polynomial prod = new Polynomial();
		int bigDegree = (this.degree() >= p.degree()) ? this.degree() : p.degree();
		int smallDegree = (this.degree() <= p.degree()) ? this.degree() : p.degree();
		
		//initialize a new product array
		int prodSize = this.coefficients.size() + p.coefficients.size();
		for (int i = 0; i < prodSize; i++) {
			this.coefficients.add(0);
		}

		for (int i = 0; i <= bigDegree; i++) {
			for (int j = 0; j <= smallDegree; j++) {
				prod.setCoefficient(i + j, prod.getCoefficient(i+j) + this.getCoefficient(i) * p.getCoefficient(j)); 
			}
		}
		return prod;
	}
	
	public int evaluate (int x) {
		int ans = 0; 
		for (int i = 0; i <= this.degree(); i++) {
			int power = 1, term = 1;
			int j = i;
			while( j > 0) {
				power *= x;
				j--;
			}
			term *= this.getCoefficient(i) * power;			
			ans += term;
		}
		return ans;
	}
	
	public static Polynomial add (Polynomial p1, Polynomial p2) {
		Polynomial sumPoly = new Polynomial();
		int isBigger = (p1.degree() > p2.degree()) ? p1.degree() : p2.degree();
		for (int i = 0; i <= isBigger; i++) {
			if(p1.getCoefficient(i) > 0 || p2.getCoefficient(i) > 0) {
				int newCoeff = p1.getCoefficient(i) + p2.getCoefficient(i);
				sumPoly.setCoefficient(i, newCoeff);
			}
		}
		return sumPoly;
	}

}
