package de.krien.machinelearning.algorithms;

public class GradientDescentForOneFeatureBD {

    /*
    private final static int MAX_ITERATIONS = 5;
    private final BigDecimal LEARNING_RATE = new BigDecimal(0.001);   // alpha
    private final BigDecimal ACCURACY = new BigDecimal(0.0001);     // epsilon

    private BigDecimal intercept = new BigDecimal(0);               // theta0
    private BigDecimal slope = new BigDecimal(999);                   // theta1
    private BigDecimal interceptOld;
    private BigDecimal slopeOld;

    public static void main(String[] args) {
        GradientDescentForOneFeatureBD gD = new GradientDescentForOneFeatureBD();
        gD.calculate(HouseData.ONE_FEATURE_HOUSE_DATA2);
        System.out.println("Intercept: " +  gD.getIntercept());
        System.out.println("Slope: " +  gD.getSlope());
    }

    public void calculate(List<House1A> data) {
        int iteration = 0;
        while(!isConvergent() && iteration++ < MAX_ITERATIONS) {
            iterate(data);
            System.out.println("Converged:" + isConvergent());
            System.out.println("Interations: " + iteration);
            System.out.println("intercept: " + intercept);
            System.out.println("slope: " + slope);
            System.out.println("#################");
        }
    }

    private boolean isConvergent() {
        if(interceptOld == null || slopeOld == null) {
            return false;
        }

        BigDecimal interceptAccuracy = interceptOld.subtract(intercept).abs();
        BigDecimal slopeAccuracy = slopeOld.subtract(slope).abs();
        if(interceptAccuracy.compareTo(ACCURACY) < 0 && slopeAccuracy.compareTo(ACCURACY) < 0) {
            return true;
        } else {
            return false;
        }
    }

    //Cost Function
    private void iterate(List<House1A> data) {
        BigDecimal interceptGradient = new BigDecimal(0);
        BigDecimal slopeGradient = new BigDecimal(0);
        for(House1A house : data) {
            interceptGradient = interceptGradient.add(calculateInterceptGradient(intercept, slope, house, data.size()));
            slopeGradient = slopeGradient.add(calculateSlopeGradient(intercept, slope, house, data.size()));
        }
        System.out.println("interceptGradient: " + interceptGradient);
        System.out.println("slopeGradient: " + slopeGradient);
        interceptOld = intercept;
        slopeOld = slope;
        intercept = intercept.subtract(LEARNING_RATE.multiply(interceptGradient));
        slope = slope.subtract(LEARNING_RATE.multiply(slopeGradient));
    }

    private BigDecimal calculateInterceptGradient(BigDecimal intercept, BigDecimal slope, House1A house, int size) {
        BigDecimal houseSize = house.getSizeInSquareMeters();
        BigDecimal calculatedValue = intercept.add(slope.multiply(houseSize));
        BigDecimal realValue = house.getPriceInEuro();
        BigDecimal error = calculatedValue.subtract(realValue);
        BigDecimal gradient = new BigDecimal(-2).divide(new BigDecimal(size), 5, BigDecimal.ROUND_HALF_UP).multiply(error);
        return gradient;
    }

    private BigDecimal calculateSlopeGradient(BigDecimal intercept, BigDecimal slope, House1A house, int size) {
        BigDecimal houseSize = house.getSizeInSquareMeters();
        BigDecimal calculatedValue = intercept.add(slope.multiply(houseSize));
        BigDecimal realValue = house.getPriceInEuro();
        BigDecimal error = houseSize.multiply(calculatedValue.subtract(realValue));
        BigDecimal gradient = new BigDecimal(-2).divide(new BigDecimal(size), 5, BigDecimal.ROUND_HALF_UP).multiply(error);
        return gradient;
    }

    public BigDecimal getIntercept() {
        return intercept;
    }

    public BigDecimal getSlope() {
        return slope;
    }

    */
}
