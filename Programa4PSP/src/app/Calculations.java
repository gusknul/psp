package app;

public class Calculations {
	
	private float mean;
	private double standardDeviation;
	private float verySmall;
	private float small;
	private float medium;
	private float large;
	private float veryLarge;
	private LinkedList list;
	private int range;
	
	Calculations (LinkedList list, int range){
		this.list = list;
		this.range = range;
	}
	
	public float getMeanLogarithmic() {
		
		Node current = list.firstNode;
		while (current != null) {
			mean += Math.log(current.getData());
			current = current.getNextNode();
			
		}
		mean = mean/range;
		return mean;
	}
	
	public double getStandardDeviation() {
		Node current = list.firstNode;
		
		while (current != null) {
			double temp = Math.log(current.getData());
			standardDeviation += Math.pow((temp - mean), 2);
			current = current.getNextNode();
			
		}
		range = range -1;
		standardDeviation = (standardDeviation / (range));
		standardDeviation = (float) Math.sqrt(standardDeviation);
		
		return standardDeviation;
	}
	
	public float getVerySmall() {
		verySmall = (float) Math.exp(mean - (2 * standardDeviation));
		return verySmall;
	}
	public float getSmall() {
		small = (float) Math.exp(mean - standardDeviation);
		return small;
	}
	public float getMedium() {
		medium = (float) Math.exp(mean);
		return medium;
	}
	public float getLarge() {
		large = (float) Math.exp(mean + standardDeviation);
		return large;
	}
	public float getVeryLarge() {
		veryLarge = (float) Math.exp(mean + (2 * standardDeviation));
		return veryLarge;
	}
	
	
}
