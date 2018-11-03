
public class ComplexNumber {
	private int real;
	private int imaginary;
	
	public ComplexNumber(int real, int imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public int getImaginary() {
		return imaginary;
	}

	public int getReal() {
		return real;
	}
	
	public void setReal (int real) {
		this.real = real;
	}
	
	public void setImaginary (int imaginary) {
		this.imaginary = imaginary;
	}
	
	public void print () {
		if(this.imaginary > 0)
			System.out.println(this.real + " + i" + this.imaginary);
		else
			System.out.println(this.real + " " + this.imaginary + "i");
	}
	
	public void add (ComplexNumber c2) {
		this.real += c2.real;
		this.imaginary += c2.imaginary;
	}
	
	public void multiply (ComplexNumber c2) {
		int realMul = this.real * c2.real - this.imaginary * c2.imaginary; //Minus is for i^2 [iota square]
		int imaginaryMul = this.real * c2.imaginary + this.imaginary * c2.real;
		
		this.real = realMul;
		this.imaginary = imaginaryMul;
	}
	
	public ComplexNumber conjugate () {
		this.imaginary = -1 * this.imaginary;
		ComplexNumber conjugate = new ComplexNumber(this.real, this.imaginary);
		return conjugate; 
	}
	
	public static ComplexNumber add (ComplexNumber c1, ComplexNumber c2) {
		int newReal = c1.real + c2.real;
		int newImaginary = c1.imaginary + c2.imaginary;
		ComplexNumber sum = new ComplexNumber(newReal, newImaginary);
		return sum;
	}
}
