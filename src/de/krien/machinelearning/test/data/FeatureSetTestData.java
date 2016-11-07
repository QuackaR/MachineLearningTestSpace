package de.krien.machinelearning.test.data;

import de.krien.machinelearning.test.object.FeatureSet;

import java.util.ArrayList;
import java.util.List;

public class FeatureSetTestData {

    // y = 50 + 2*x1 + 5*x2
    public final static List<FeatureSet> THREE_FEATURES_SET = new ArrayList<FeatureSet>() {
        {
            add(new FeatureSet(new float[] {1.0f, 2.0f}, 57.0f));
            add(new FeatureSet(new float[] {2.0f, 2.0f}, 59.0f));
            add(new FeatureSet(new float[] {3.0f, 2.0f}, 61.0f));
            add(new FeatureSet(new float[] {4.0f, 2.0f}, 63.0f));
            add(new FeatureSet(new float[] {5.0f, 2.0f}, 65.0f));
            add(new FeatureSet(new float[] {6.0f, 2.0f}, 67.0f));
            add(new FeatureSet(new float[] {7.0f, 2.0f}, 69.0f));
            add(new FeatureSet(new float[] {8.0f, 2.0f}, 71.0f));
            add(new FeatureSet(new float[] {9.0f, 2.0f}, 73.0f));

            add(new FeatureSet(new float[] {1.0f, 2.0f}, 62.0f));
            add(new FeatureSet(new float[] {1.0f, 3.0f}, 67.0f));
            add(new FeatureSet(new float[] {1.0f, 4.0f}, 72.0f));
            add(new FeatureSet(new float[] {1.0f, 5.0f}, 77.0f));
            add(new FeatureSet(new float[] {1.0f, 6.0f}, 82.0f));
            add(new FeatureSet(new float[] {1.0f, 7.0f}, 87.0f));
            add(new FeatureSet(new float[] {1.0f, 8.0f}, 92.0f));
            add(new FeatureSet(new float[] {1.0f, 9.0f}, 97.0f));
        }};

    // y = 50 + 2*x1 + 5*x2 + 10*x3
    public final static List<FeatureSet> FOUR_FEATURES_SET = new ArrayList<FeatureSet>() {
        {
            add(new FeatureSet(new float[] {1.0f, 1.0f, 1.0f}, 67.0f));
            add(new FeatureSet(new float[] {2.0f, 1.0f, 1.0f}, 69.0f));
            add(new FeatureSet(new float[] {3.0f, 1.0f, 1.0f}, 71.0f));
            add(new FeatureSet(new float[] {4.0f, 1.0f, 1.0f}, 73.0f));
            add(new FeatureSet(new float[] {5.0f, 1.0f, 1.0f}, 75.0f));
            add(new FeatureSet(new float[] {6.0f, 1.0f, 1.0f}, 77.0f));
            add(new FeatureSet(new float[] {7.0f, 1.0f, 1.0f}, 79.0f));
            add(new FeatureSet(new float[] {8.0f, 1.0f, 1.0f}, 81.0f));
            add(new FeatureSet(new float[] {9.0f, 1.0f, 1.0f}, 83.0f));

            add(new FeatureSet(new float[] {1.0f, 1.0f, 1.0f}, 67.0f));
            add(new FeatureSet(new float[] {1.0f, 2.0f, 1.0f}, 72.0f));
            add(new FeatureSet(new float[] {1.0f, 3.0f, 1.0f}, 77.0f));
            add(new FeatureSet(new float[] {1.0f, 4.0f, 1.0f}, 82.0f));
            add(new FeatureSet(new float[] {1.0f, 5.0f, 1.0f}, 87.0f));
            add(new FeatureSet(new float[] {1.0f, 6.0f, 1.0f}, 92.0f));
            add(new FeatureSet(new float[] {1.0f, 7.0f, 1.0f}, 97.0f));
            add(new FeatureSet(new float[] {1.0f, 8.0f, 1.0f}, 102.0f));
            add(new FeatureSet(new float[] {1.0f, 9.0f, 1.0f}, 107.0f));

            add(new FeatureSet(new float[] {1.0f, 1.0f, 1.0f}, 67.0f));
            add(new FeatureSet(new float[] {1.0f, 1.0f, 2.0f}, 77.0f));
            add(new FeatureSet(new float[] {1.0f, 1.0f, 3.0f}, 87.0f));
            add(new FeatureSet(new float[] {1.0f, 1.0f, 4.0f}, 97.0f));
            add(new FeatureSet(new float[] {1.0f, 1.0f, 5.0f}, 107.0f));
            add(new FeatureSet(new float[] {1.0f, 1.0f, 6.0f}, 117.0f));
            add(new FeatureSet(new float[] {1.0f, 1.0f, 7.0f}, 127.0f));
            add(new FeatureSet(new float[] {1.0f, 1.0f, 8.0f}, 137.0f));
            add(new FeatureSet(new float[] {1.0f, 1.0f, 9.0f}, 147.0f));
        }};
}
