package util;


public class Regression {
	private int range;
	private LinkedList list;
	public static final int NUMBER_OF_SEGMENTS = 10;
	private static final double E = .000001;
	
	
	public Regression(int range , LinkedList list) {
		// TODO Auto-generated constructor stub
		this.range = range;
		this.list = list;
	}
	
	
	
	public double standardDeviation (double betaZero , double betaOne
			, double betaTwo , double betaThree ,  int size ) {
		double standardDeviation = 0;
		
		Node current = list.firstNode;
		
		while (current != null) {
			standardDeviation += Math.pow(current.getFourData() - betaZero -
					(betaOne * current.getFirstData()) - (betaTwo * current.getSecondData()) - (betaThree * current.getThirdData()) , 2);
			current = current.getNextNode();
		}
		
		standardDeviation = ((double) ( 1 / ( (double) size - 4 ) ) *  standardDeviation );
		standardDeviation = Math.sqrt(standardDeviation);
		return standardDeviation;
	}

	
	public double[] average(){
		Node current = list.firstNode;
		double averageW = 0;
		double averageX = 0;
		double averageY = 0;
		while(current != null){
			averageW += current.getFirstData();
			averageX += current.getSecondData();
			averageY += current.getThirdData();
			current = current.getNextNode();
		}
		
		averageW = averageW/range;
		averageX = averageX/range;
		averageY = averageY/range;
		
		double[] average = {averageW,averageX,averageY};
		return average;
	}
	
	public double getSQRTValue(double estimatedNew , double estimatedReuse , double  estimatedModify , double[] average){
		double value = 0;
		Node current = list.firstNode;
		double valueW = 0 , valueX = 0 , valueY = 0 ;
		while (current != null) {
			valueW += Math.pow((current.getFirstData() - estimatedNew ), 2);
			valueX += Math.pow((current.getSecondData() - estimatedReuse), 2);
			valueY += Math.pow((current.getThirdData() - estimatedModify), 2);
			current = current.getNextNode();
		}
		
		value = ( 1 + ( double ) ( 1 / range ) + (Math.pow((estimatedNew - average[0]), 2) / valueW) +
				(Math.pow((estimatedReuse - average[1]), 2) / valueX) +
				(Math.pow((estimatedModify - average[2]), 2) / valueY)
				);
		value = Math.sqrt(value);
		
		return value;
	}
	
	
	public double range(double tValue , double standardDeviation , double SQRT){
		return tValue * standardDeviation * SQRT;
	}
	
	public double estimatedZ (double[] betaValue, 
			double estimatedNew , double estimatedReuse , double  estimatedModify){
		return betaValue[0] + (estimatedNew * betaValue[1] ) + (estimatedReuse * betaValue[2]) + (estimatedModify * betaValue[3]);
	}
	
	public double getXValue(){
		
		float secondResult;
		float d = (float) 0.5;
		float x = 1;
		float p = .35f;
		float compareToTwo = 0;
		SimpsonRule ruleFirst = new SimpsonRule(range-4, x, 10);
		float firstResult = (float) ruleFirst.funcionP();
		float compareToOne = Math.abs(firstResult - p);
		
			if ((firstResult - p) == 0 || compareToOne <= E) {
				return x;
			}
		
			else {
				if ((firstResult - p) < 0) {
					x += d;
				}
			
				else {
					x -= d;
				}
			
				ruleFirst = new SimpsonRule(range-4, x, NUMBER_OF_SEGMENTS);
				secondResult = (float) ruleFirst.funcionP();
				compareToTwo = (float) Math.abs(secondResult - p);
				
				if ((secondResult - p) == 0 || compareToTwo <= E) {
					return x;
				}

				else {
					do {
						d = getDValue(d, firstResult - p,
								(float) (ruleFirst.funcionP() - p));
						if ((secondResult - p) < 0) {
							x += d;
						} else {
							x -= d;
						}
						ruleFirst = new SimpsonRule(range-4, x, NUMBER_OF_SEGMENTS);
						secondResult = (float) ruleFirst.funcionP();

					} while ((Math.abs(ruleFirst.funcionP() - p)) > E);
				return x;
				}
			}

	}


	public static float getDValue(float d, float dif, float dif2) {

		if (dif < 0 && dif2 < 0) {
			return d;

		} else {
			if (dif > 0 && dif2 > 0) {
				return d;

			} else {
				return d / 2;
			}
		}

	}

}
