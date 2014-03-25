package com.fmat.gcp.utils;


public class SimpsonRule {
	
	
	private float x;
	private float w;
	private int numberOfSegments;
	private int DOF;
	
	public SimpsonRule( int DOF , float x, int numberOfSegments){
		this.DOF = DOF;
		this.x = x;
		this.numberOfSegments = numberOfSegments;
	}
	
	public double funcionP(){
		w = x / numberOfSegments;
		float result1 = 0;
		float result2 = 0;
		float result3 = 0;
		DistributionT distribution = new DistributionT(DOF);
	
			int i = 1;
			while(i <= (numberOfSegments - 1)){
				result2 = result2 + (4 * distribution.distributionT((float) (i*w)));
				i = i+2;
			}
			
			int j = 2;
			while(j <= (numberOfSegments - 2)){
				result3 = result3 + (2 * distribution.distributionT((float) (j*w)));
				j=j+2;
			}
		result1 = (w/3) * (distribution.distributionT(0)  + result2 + result3 + distribution.distributionT((float) x));
		
		return result1 ;
	}

	public int getDOF() {
		return DOF;
	}

	public void setDOF(int dOF) {
		DOF = dOF;
	}
	
	public float getW() {
		return w;
	}

	public void setW(float w) {
		this.w = w;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public int getNumberOfSegments() {
		return numberOfSegments;
	}

	public void setNumberOfSegments(int numberOfSegments) {
		this.numberOfSegments = numberOfSegments;
	}

}
