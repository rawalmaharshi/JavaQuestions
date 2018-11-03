package subsmissions;

import java.util.Scanner;

/* Signature of four required functions is given in the code. You can create other functions as well if you need.
*  Also you should submit your code even if you are not done with all the functions. 
*/

class DynamicArray {

	private int data[];
	private int nextIndex;
	
	public DynamicArray() {
		data = new int[5];
		nextIndex = 0;
	}
	
	public int size () {
		return nextIndex;
	}
	
	public void add (int element) {
		if (nextIndex == data.length) {
			restructure();
		}
		data[nextIndex] = element;
		nextIndex++;
	}
	
	public void set (int index, int element) {
//		System.out.println(index);
//		System.out.println(nextIndex);
//		System.out.println(element);
		if (index > nextIndex) {
			//TODO error out
			return;
		}
		if (index < nextIndex) {
			data[index] = element;
		} else {
			add(element);
		}
	}
	
	public int get (int index) {
		if (index >= nextIndex) {
			//error out
			return 0; //return 0
		}
		return data[index];
	}
	
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int removeLast() {
		if (size() == 0) {
			//error out
			return -1;
		}
		int value = data[nextIndex -1];
		data[nextIndex -1] = 0;
		nextIndex--;
		return value;
	}
	
	private void restructure() {
		int temp[] = data;
		data = new int[data.length * 2];
		for(int i = 0; i < temp.length; i++) {
			data[i] = temp[i];
		}
	}
}


public class Polynomial {

  	DynamicArray coefficients;
	
	public Polynomial() {
		coefficients = new DynamicArray();
	}
  
	
	public int getCoefficient (int degree) {
		int coeff = coefficients.get(degree);
		return coeff;
	}
	
	public int degree() {
		int degree = coefficients.size() - 1;
//		System.out.println("Coefficients Size" + coefficients.size());
//		for (int i = 0; i < coefficients.size(); i++) {
//			if(coefficients.get(i) > 0) {
//				degree = i;
//			}
//		}
		return degree;
	}
	
	/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
	 *  then corresponding term(with specified degree and value is added into the polynomial. If the degree
	 *  is already present in the polynomial then previous coefficient is replaced by
	 *  new coefficient value passed as function argument
	*/
	public void setCoefficient(int degree, int coeff){
		if(degree > coefficients.size()) {
			for (int i = coefficients.size() + 1; i <= degree; i++) {
				coefficients.add(0);
			}
		}
		coefficients.set(degree, coeff);	
	}
	
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print(){
		for (int i = 0; i< coefficients.size(); i++) {
			if(coefficients.get(i) == 0) {
				continue;
			}
			else
				System.out.print(coefficients.get(i) + "x" + i + " ");
		}
		System.out.println("");
	}

	
	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){
		Polynomial sum = new Polynomial();
		
		int isBigger = (this.degree() >= p.degree()) ? this.degree() : p.degree();
		for (int i = 0; i <= isBigger; i++) {
			int newCoeff = this.getCoefficient(i) + p.getCoefficient(i);
			sum.setCoefficient(i, newCoeff);
		}
		
		return sum;	
	}
	
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
      Polynomial diff = new Polynomial();
		int isBigger = (this.degree() >= p.degree()) ? this.degree() : p.degree();
		for (int i = 0; i <= isBigger; i++) {
			int newCoeff = this.getCoefficient(i) - p.getCoefficient(i);
			diff.setCoefficient(i, newCoeff);
		}
		
		return diff;
			
	}
	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){
		Polynomial prod = new Polynomial();
//		int bigDegree = (this.degree() >= p.degree()) ? this.degree() : p.degree();
//		int smallDegree = (this.degree() <= p.degree()) ? this.degree() : p.degree();
		
		//initialize a new product array
		int prodSize = this.degree() + p.degree() + 1;
		System.out.println("Product Array Size: " + prodSize);
		for (int i = 0; i < prodSize; i++) {
			prod.coefficients.add(0);
		}

		for (int i = 0; i <= this.degree(); i++) {
			for (int j = 0; j <= p.degree(); j++) {
				prod.setCoefficient(i + j, prod.getCoefficient(i+j) + this.getCoefficient(i) * p.getCoefficient(j)); 
			}
		}
		return prod;
	}
	
	// Main used internally is shown here just for your reference.
	public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int degree1[] = new int[n];
			for(int i = 0; i < n; i++){
				degree1[i] = s.nextInt();
			}
			int coeff1[] = new int[n];
			for(int i = 0; i < n; i++){
				coeff1[i] = s.nextInt();
			}
			Polynomial first = new Polynomial();
			for(int i = 0; i < n; i++){
				first.setCoefficient(degree1[i],coeff1[i]);
			}
			n = s.nextInt();
			int degree2[] = new int[n];
			for(int i = 0; i < n; i++){
				degree2[i] = s.nextInt();
			}
			 int coeff2[] = new int[n];
			for(int i = 0; i < n; i++){
				coeff2[i] = s.nextInt();
			}
			Polynomial second = new Polynomial();
			for(int i = 0; i < n; i++){
				second.setCoefficient(degree2[i],coeff2[i]);
			}
			int choice = s.nextInt();
			System.out.print("First Polynomial: ");
			first.print();
			System.out.print("Second Polynomial: ");
			second.print();
			Polynomial result;
			switch(choice){
			// Add
			case 1: 
				 result = first.add(second);
				 System.out.print("Sum: ");
				result.print();
				break;
			// Subtract	
			case 2 :
				 result = first.subtract(second);
				 System.out.print("Difference: ");
				result.print();
				break;
			// Multiply
			case 3 :
				 result = first.multiply(second);
				 System.out.print("Multiplication: ");
				result.print();
				break;
			}
			s.close();
		}
}
