package de.krien.machinelearning.test.object;

/**
 * Created by Anon-PC on 05.11.2016.
 */
public class FeatureSet {

    private float[] features;
    private float result;

    public FeatureSet(float[] features, float result) {
        this.features = features;
        this.result = result;
    }

    public float[] getFeatures() {
        return features;
    }

    public void setFeatures(float[] features) {
        this.features = features;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }
}
