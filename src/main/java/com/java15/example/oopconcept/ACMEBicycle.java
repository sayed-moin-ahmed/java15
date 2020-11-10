package com.java15.example.oopconcept;

/**
 * blueprint or prototype
 */
public class ACMEBicycle implements Bicycle
{
    protected String owner;
    //Fields(State)
    private int currentGear=0;
    private int currentPedalCadence=0;
    private int currentSpeed=0;

    //Methods(Behavior)
    public void changeGear(){
        currentGear++;
    }

    public void changePedalCadence(){
        currentPedalCadence++;
    }

    public void changeCurrentSpeed(){
        currentSpeed++;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "currentGear=" + currentGear +
                ", currentPedalCadence=" + currentPedalCadence +
                ", currentSpeed=" + currentSpeed +
                '}';
    }
}
