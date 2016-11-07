package de.krien.machinelearning.algorithms;

import de.krien.machinelearning.test.data.HouseData;
import de.krien.machinelearning.test.object.House1A;

import java.util.List;
import java.util.Random;

public class LinearRegressionGradientDescentOneFeature {

    private final static int MAX_ITERATIONS = 49999;
    private final float LEARNING_RATE = 0.00000001f;        // alpha
    private final float ACCURACY = 0.001f;                  // epsilon

    private float intercept;                           // theta0
    private float slope;                               // theta1
    private float interceptOld;
    private float slopeOld;

    public static void main(String[] args) {
        LinearRegressionGradientDescentOneFeature gD = new LinearRegressionGradientDescentOneFeature();
        gD.calculate(HouseData.ONE_FEATURE_HOUSE_DATA2);
        System.out.println("Intercept: " +  gD.getIntercept());
        System.out.println("Slope: " +  gD.getSlope());
    }

    public void calculate(List<House1A> data) {
        intercept = new Random().nextFloat() * 100;
        slope = new Random().nextFloat() * 100;

        int iteration = 0;
        while(!isConvergent() && iteration++ < MAX_ITERATIONS) {
            iterate(data);
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
        interceptOld = intercept;
        slopeOld = slope;
        intercept = intercept - (LEARNING_RATE * (1/(float)data.size()) * interceptGradient);
        slope = slope - (LEARNING_RATE * (1/(float)data.size()) * slopeGradient);
    }

    private float calculateInterceptGradient(float intercept, float slope, House1A house, int size) {
        float houseSize = house.getSizeInSquareMeters();
        float calculatedValue = intercept + (slope * houseSize);
        float realValue = house.getPriceInEuro();
        float gradient = (calculatedValue - realValue);
        return gradient;
    }

    private float calculateSlopeGradient(float intercept, float slope, House1A house, int size) {
        float houseSize = house.getSizeInSquareMeters();
        float calculatedValue = intercept + (slope * houseSize);
        float realValue = house.getPriceInEuro();
        float gradient = houseSize * (calculatedValue - realValue);
        return gradient;
    }

    public float getIntercept() {
        return intercept;
    }

    public float getSlope() {
        return slope;
    }
}
