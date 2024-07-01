package THESIS.Stations;

import Components.PetriNet;
import DataObjects.*;
import DataOnly.TransferOperation;
public class Station_A {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Station A";

        pn.NetworkPort = 1081;
    }
}
