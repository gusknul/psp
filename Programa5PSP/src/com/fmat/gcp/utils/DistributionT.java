package com.fmat.gcp.utils;

public class DistributionT {
	
	private int DOF;	
	public DistributionT(int DOF){
		this.DOF = DOF;
	}

	public int getDOF() {
		return DOF;
	}

	public void setDOF(int dOF) {
		DOF = dOF;
	}
	
	public float distributionT(double x){
		float result = 0;
		
		float p = (float) gamma( (float)(DOF + 1.0) / 2.0 );
		float q = (float) Math.pow(DOF * Math.PI, .5);
		float e = (float) gamma((float) (DOF/2.0));
		float t = p/ (q * e);
		float s = (float) Math.pow((float) ((1) + ((Math.pow(x, 2))/DOF)) , (float)-((DOF+1)/2));
		result = t * s;
		return result;
	}
	
	public double logGamma(double x) {
	      double tmp = (x - 0.5) * Math.log(x + 4.5) - (x + 4.5);
	      double ser = 1.0 + 76.18009173    / (x + 0)   - 86.50532033    / (x + 1)
	                       + 24.01409822    / (x + 2)   -  1.231739516   / (x + 3)
	                       +  0.00120858003 / (x + 4)   -  0.00000536382 / (x + 5);
	      return tmp + Math.log(ser * Math.sqrt(2 * Math.PI));
	   }
	   
	public double gamma(double x) { 
	   	return Math.exp(logGamma(x)); 
	   }
	
}
