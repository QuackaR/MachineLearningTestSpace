package de.krien.machinelearning.test.object;

/**
 * Created by Anon-PC on 05.11.2016.
 */
public class House1A {

    private float sizeInSquareMeters;
    private float priceInEuro;

    public House1A(float sizeInSquareMeters, float priceInEuro) {
        this.sizeInSquareMeters = sizeInSquareMeters;
        this.priceInEuro = priceInEuro;
    }

    public float getSizeInSquareMeters() {
        return sizeInSquareMeters;
    }

    public void setSizeInSquareMeters(float sizeInSquareMeters) {
        this.sizeInSquareMeters = sizeInSquareMeters;
    }

    public float getPriceInEuro() {
        return priceInEuro;
    }

    public void setPriceInEuro(float priceInEuro) {
        this.priceInEuro = priceInEuro;
    }
}
