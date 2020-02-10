
/**
 Murray Jones
 CS27500 Professor Zhao
 Assignment 1 
 */

/**
 * @author mjone
 *
 */
public class QuadraticExpression {
	
	double a , b, c;
	
	/**
	 * Declaring variables
	 */
	
	
	
	public QuadraticExpression()  {  
		/**
		 * default constructor which initializes all the coefficients to 0.
		 */
	
	}

	public QuadraticExpression( double a, double b, double c ) {  
		/**
		 * Constructor that takes in three parameters.
		 */
		
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public String toString() {    
		/**
		 * A toString method. 
		 */
		return a +" x^2 + " + b + "x + " + c;   
		
		/**
		 * Returns the expression as a string.
		 */
		
	}
	
	public double evaluate(double x)  {  
		/**
		 * An evaluate method that returns the value of the expression when x is a number.
		 */
		return a * x * x + b * x + c; 
	}
	
	public void setA(double newA) {    
		/**
		 * Set method a
		 */
		a = newA;
	}
	
	public void setB(double newB) {   
		/**
		 * Set method for b
		 */
		b = newB;
	}
	
	public void setC(double newC) {   
		/**
		 * Set method for c
		 */
		c = newC;
	}
	
	
	public static QuadraticExpression scale(double r, QuadraticExpression q)  {   
		/**
		 * Created a method that returns r times q
		 */
		
		QuadraticExpression s3 = new QuadraticExpression();
		s3.a = q.a * r;
		s3.b = q.b * r;
		s3.c = q.c * r;
		return s3;
		
		
	} 
	
	
	public int numberOfRoots() {  
		/**
		 * Method created to return the number of roots.
		 * Use if-else statements to calculate and find the number of roots.
		 */
		
		if (a == 0 && b == 0 && c == 0)  // if the number of roots are infinite
			return 3;
		
		else if ((a == 0 && b == 0) || b * b - 4 * a * c < 0)  // If there are no roots
			return 0;
		
		else if (a == 0 || (b * b - 4 * a * c == 0))
			return 1;
		
		return 2;	
	}
	
	public void add(QuadraticExpression q)  {
		
		
		this.a += q.a;
		this.b += q.b;
		this.c += q.c;
}
		


	
	public double smallerRoot() throws Exception {
		/**
		 * Method to compute the smallest root
		 * if no root, throw exception
		 * if one, return it
		 * if two roots, return smallest
		 */
		int roots = numberOfRoots();
		/** Calling numberOfRoots function to get number of roots
		 * 
		 */
		if(roots == 0)
			throw new Exception();
		
		else if(roots == 3)
			return -Double.MAX_VALUE;
		else {
			
			double D =  Math.sqrt (b * b - 4 * a * c);
			
			if(D == 0)
				return -(b / (2 * a));
			
			else  {
				double root1 = (-b + D) / (2 * a);
				double root2 = (-b - D) / (2 * a);
				
				if(root1 < root2) 
					return root1;
				
				return root2;
			}
		}
	}
	
	public double largerRoot() throws Exception  {
		/**
		 * Method to find and compute the largest root
		 * if no root, throw exception
		 * if two roots, return largest
		 * if infinite roots, return MAX_VALUE
		 */
		int roots = numberOfRoots();
		
		if(roots == 0)
			throw new Exception();
		
		else if (roots == 3)
			return Double.MAX_VALUE;
		
		else {
			
			double D = Math.sqrt(b * b - 4 * a * c);
			
			if(D == 0)
				return -(b / (2 * a));
			
			else  {
				
				double root1 = (-b + D) / (2 * a);
				double root2 = (-b - D) / (2 * a);
				
				if(root1 > root2)
					return root1;
				
				return root2;
			}
		}
		
	}

	public boolean equals(QuadraticExpression exp)  {
		
		/**
		 * Equals method that overrides the method in the equals method from the Objects class.
		 * return true if same a, same b, and same c.
		 */
		if(exp.a == this.a && exp.b == this.b && exp.c == this.c)
			return true;
		
		return false;
	}
	
	public QuadraticExpression clone() {
		/**
		 * Method to create the clone.
		 */
		
			QuadraticExpression c3 = new QuadraticExpression();
			c3.a = this.a;
			c3.b = this.b;
			c3.c = this.c;
			return c3;
	}
	
	
	public static QuadraticExpression add(QuadraticExpression a1, QuadraticExpression a2) {  
		/**
		 * Method to  return the sum of q1 and q2
		 */
		
		QuadraticExpression a3 = new QuadraticExpression();
		a3.a = a1.a + a2.a;
		a3.b = a1.b + a2.b;
		a3.c = a1.c + a2.c;
		return a3;
	}
	
}


