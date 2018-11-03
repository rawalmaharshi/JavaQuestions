
public class PolynomialUse {

	public static void main(String[] args) {
		Polynomial p1 = new Polynomial();
		p1.setCoefficient(0, 3);
		p1.setCoefficient(2, 2);
//		p1.print();
		
		Polynomial p2 = new Polynomial();
		p2.setCoefficient(0, 3);
		p2.setCoefficient(2, 2);
		p2.setCoefficient(1, 4);
		p2.setCoefficient(2, 5);
//		p2.setCoefficient(3, 6);
//		p2.setCoefficient(125, 8);
//		p2.print();

		Polynomial sum = p1.subtract(p2);
		p1.print();
		p2.print();
		sum.print();
		
//		Polynomial prod = p2.multiply(p1);
//		p2.print();
//		p1.print();
//		prod.print();
////		
		Polynomial p3 = Polynomial.add(p1, p2);
//		p3.print();
//		p1.print();
//		p2.print();
		
		int answer = p2.evaluate(3);
//		System.out.println(answer);
	}

}
