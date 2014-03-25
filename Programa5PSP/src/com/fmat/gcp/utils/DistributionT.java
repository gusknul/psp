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
		float p = (float) gamma( (float) ((float)(DOF + 1.0) / 2.0) );
		float q = (float) Math.pow(DOF * Math.PI, .5);
		float e = (float) gamma((float) (DOF/2.0));
		float t = p/ (q * e);
		float s = (float) Math.pow((float) ((1) + ((Math.pow(x, 2))/DOF)) , (float)-((DOF+1)/2));
		result = t * s;
		return result;
	}
	
	
	
	public float gamma(float x){
		
		if(x == 1){
			return x;
		}
		
		else{
			
			if(x == (0.5)){
				return (float) Math.sqrt(Math.PI);
			}
			
			else{
				return (float) ((x - 1.0 ) * gamma((float) (x-1.0)));
			}
			
		}
	}
	

	
}
