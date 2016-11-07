package de.krien.machinelearning.algorithms;

import de.krien.machinelearning.test.data.FeatureSetTestData;
import de.krien.machinelearning.test.object.FeatureSet;

import java.util.List;
import java.util.Random;

public class LinearRegressionGradientDescent {

    private final static int MAX_ITERATIONS = 49999999;
    private final float LEARNING_RATE = 0.000001f;        // alpha
    private final float ACCURACY = 0.0000000000001f;    // epsilon

    private float intercept;                            // theta0
    private float interceptOld;
    private float[] features;                           // theta1-n
    private float[] featuresOld;

    public static void main(String[] args) {
        LinearRegressionGradientDescent gD = new LinearRegressionGradientDescent();
        gD.calculate(FeatureSetTestData.THREE_FEATURES_SET);
        System.out.println("Intercept: " + gD.getIntercept());
        for(int i = 0; i < gD.getFeatures().length; i++) {
            System.out.println("Feature " + i + ": " +  gD.getFeatures()[i]);
        }
    }

    public void calculate(List<FeatureSet> data) {
        intercept = new Random().nextFloat() * 100;
        features = new float[data.get(0).getFeatures().length];
        features[0] = 1.0f;
        for(int i = 0; i < features.length; i++) {
            features[i] = new Random().nextFloat() * 100;
        }

        int iteration = 0;
        while(!isConvergent() && iteration++ < MAX_ITERATIONS) {
            iterate(data);
        }
        System.out.println("Iterations: " + iteration);
    }

    private boolean isConvergent() {
        if(featuresOld == null || interceptOld == 0) {
            return false;
        }

        float[] featureAccuracy = new float[features.length + 1];
        for(int i = 0; i < features.length; i++) {
            featureAccuracy[i] = Math.abs(featuresOld[i] - features[i]);
        }
        featureAccuracy[featureAccuracy.length-1] = Math.abs(interceptOld - intercept);

        boolean convergent = true;
        for(int i = 0; i < featureAccuracy.length; i++) {
            if (featureAccuracy[i] >= ACCURACY) {
                convergent = false;
            }
        }
        return convergent;
    }

    //Cost Function
    private void iterate(List<FeatureSet> data) {
        float interceptGradient = 0f;
        float[] featureGradient = new float[features.length];
        for(int dataIndex = 0; dataIndex < data.size(); dataIndex++) {
            interceptGradient = interceptGradient + calculateInterceptGradient(data.get(dataIndex));
            for(int featureIndex = 0; featureIndex < features.length; featureIndex++) {
                featureGradient[featureIndex] = featureGradient[featureIndex] + calculateFeatureGradient(featureIndex, data.get(dataIndex));
            }
        }
        interceptOld = intercept;
        intercept = intercept - (LEARNING_RATE * (1/(float)data.size()) * interceptGradient);
        featuresOld = features.clone();
        for(int i = 0; i < features.length; i++) {
            features[i] = features[i] - (LEARNING_RATE * (1/(float)data.size()) * featureGradient[i]);
        }
    }

    private float calculateInterceptGradient(FeatureSet dataSet) {
        float featuresValue = 0f;
        for(int i = 0; i < features.length; i++)  {
            featuresValue += dataSet.getFeatures()[i] * features[i];
        }
        float calculatedValue = intercept + featuresValue;
        float realValue = dataSet.getResult();
        float gradient = (calculatedValue - realValue);
        return gradient;
    }

    private float calculateFeatureGradient(int featureIndex, FeatureSet dataSet) {
        float featuresValue = 0f;
        for(int i = 0; i < features.length; i++)  {
            featuresValue += dataSet.getFeatures()[i] * features[i];
        }
        float calculatedValue = intercept + featuresValue;
        float realValue = dataSet.getResult();
        float gradient = features[featureIndex] * (calculatedValue - realValue);
        //System.out.println("Feature " + featureIndex + " is " + features[featureIndex] + ". Gradient is " + gradient + " (FeatureValue: " + featureValue + "; CalculatedValue: " + calculatedValue + "; RealValue: " + realValue + ").");
        return gradient;
    }

    public float[] getFeatures() {
        return features;
    }

    public float getIntercept() {
        return intercept;
    }
}
