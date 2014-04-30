package util;

public class Gauss {
	private static final double E = 1e-10;
	private LinkedList list;
	private int size;
	
	public Gauss(LinkedList list, int size){
		this.list = list;
		this.size = size;
	}
	
	public double[][] getElementsMatrix(){
		
		double wI = 0, xI = 0, yI = 0; 
		double wI2 = 0, xI2 = 0, yI2 = 0;
		double wIXI = 0, wIYI = 0, xIYI = 0;
		
		
		Node current = list.firstNode;
		
		while (current != null) {
			
			wI += current.getFirstData();
			xI += current.getSecondData();
			yI += current.getThirdData();
			wI2 += Math.pow(current.getFirstData(), 2);
			xI2 += Math.pow(current.getSecondData(), 2);
			yI2 += Math.pow(current.getThirdData(), 2);
			wIXI += (current.getFirstData() * current.getSecondData());
			wIYI += (current.getFirstData() * current.getThirdData());
			xIYI += (current.getSecondData() * current.getThirdData());
			current = current.getNextNode();
		}
		
		double equation [][] = {{size,wI,xI,yI}, {wI, wI2, wIXI,wIYI}, {xI,wIXI,xI2,xIYI}, {yI,wIYI,xIYI,yI2}};
		return equation;
	}
	
	
	public double[] bMatrix(){
		double wIZI = 0, xIZI = 0, yIZI= 0, zI = 0;
		Node current = list.firstNode;
		
		while ( current != null ) {
			zI += current.getFourData();
			wIZI += (current.getFirstData() * current.getFourData());
			xIZI += (current.getSecondData() * current.getFourData());
			yIZI += (current.getThirdData()  * current.getFourData());
			current = current.getNextNode();
		}
		
		double[] bMatrix = { zI , wIZI , xIZI , yIZI }; 
		
		return bMatrix;
	}
	
	
	public double[] lsolve(double[][] A, double[] b) {
        int N  = b.length;

        for (int p = 0; p < N; p++) {

            // find pivot row and swap
            int max = p;
            for (int i = p + 1; i < N; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p]; A[p] = A[max]; A[max] = temp;
            double   t    = b[p]; b[p] = b[max]; b[max] = t;

            if (Math.abs(A[p][p]) <= E) {
                throw new RuntimeException("Matrix is singular or nearly singular");
            }

            for (int i = p + 1; i < N; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < N; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        double[] x = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }
	

}
