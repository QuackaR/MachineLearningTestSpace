package de.krien.machinelearning.algorithms;

import de.krien.machinelearning.test.data.HouseData;
import de.krien.machinelearning.test.object.House1A;

import java.util.List;

public class GradientDescentForOneFeature {

    private final static int MAX_ITERATIONS = 5;
    private final float LEARNING_RATE = 0.1f;      // alpha
    private final float ACCURACY = 0.0001f;          // epsilon

    private float intercept = 1f;                   // theta0
    private float slope = 1f;                     // theta1
    private float interceptOld;
    private float slopeOld;

    public static void main(String[] args) {
        GradientDescentForOneFeature gD = new GradientDescentForOneFeature();
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
        float interceptAccuracy = Math.abs(interceptOld - intercept);
        float slopeAccuracy = Math.abs(slopeOld - slope);
        if(interceptAccuracy < ACCURACY && slopeAccuracy < ACCURACY) {
            return true;
        } else {
            return false;
        }
    }

    //Cost Function
    private void iterate(List<House1A> data) {
        float interceptGradient = 0f;
        float slopeGradient = 0f;
        for(House1A house : data) {
            interceptGradient = interceptGradient + calculateInterceptGradient(intercept, slope, house, data.size());
            slopeGradient = slopeGradient + calculateSlopeGradient(intercept, slope, house, data.size());
        }
        System.out.println("interceptGradient: " + interceptGradient);
        System.out.println("slopeGradient: " + slopeGradient);
        interceptOld = intercept;
        slopeOld = slope;
        intercept = intercept - (LEARNING_RATE * interceptGradient);
        slope = slope - (LEARNING_RATE * slopeGradient);
    }

    private float calculateInterceptGradient(float intercept, float slope, House1A house, int size) {
        float houseSize = house.getSizeInSquareMeters();
        float calculatedValue = intercept + (slope * houseSize);
        float realValue = house.getPriceInEuro();
        float gradient = -(2/(float)size) * (calculatedValue - realValue);
        return gradient;
    }

    private float calculateSlopeGradient(float intercept, float slope, House1A house, int size) {
        float houseSize = house.getSizeInSquareMeters();
        float calculatedValue = intercept + (slope * houseSize);
        float realValue = house.getPriceInEuro();
        float gradient = -(2/(float)size) * houseSize * (calculatedValue - realValue);
        return gradient;
    }

    public float getIntercept() {
        return intercept;
    }

    public float getSlope() {
        return slope;
    }
}
