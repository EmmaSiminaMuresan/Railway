package THESIS.Stations;

import Components.PetriNet;
import DataObjects.*;
import DataOnly.TransferOperation;
public class Station_A {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Station A";

        pn.NetworkPort = 1081;

        DataTrain p1 = new DataTrain();
        p1.SetName("Train_A1");
        pn.PlaceList.add(p1);

        DataTrain p2 = new DataTrain();
        p2.SetName("Train_A2");
        pn.PlaceList.add(p2);

        DataTrain p3 = new DataTrain();
        p3.SetName("Train_A3");
        pn.PlaceList.add(p3);

        DataTrain p4 = new DataTrain();
        p4.SetName("Exit_A1");
        pn.PlaceList.add(p4);

        DataTrain p5 = new DataTrain();
        p5.SetName("Exit_A2");
        pn.PlaceList.add(p5);

        DataTrain p6 = new DataTrain();
        p6.SetName("Exit_A3");
        pn.PlaceList.add(p6);

        DataTrain p7 = new DataTrain();
        p7.SetName("A1");
        pn.PlaceList.add(p7);

        DataTrain p8 = new DataTrain();
        p8.SetName("A2");
        pn.PlaceList.add(p8);

        DataTrain p9 = new DataTrain();
        p9.SetName("A3");
        pn.PlaceList.add(p9);

        DataTrain p10 = new DataTrain();
        p10.SetName("P_A1");
        pn.PlaceList.add(p10);

        DataTrain p11 = new DataTrain();
        p11.SetName("P_A2");
        pn.PlaceList.add(p11);

        DataTrain p12 = new DataTrain();
        p12.SetName("P_A3");
        pn.PlaceList.add(p12);

        DataTrain p13 = new DataTrain();
        p13.SetName("i1");
        pn.PlaceList.add(p13);

        DataTrain p14 = new DataTrain();
        p14.SetName("i2");
        pn.PlaceList.add(p14);

        DataLocalTime Time_A1 = new DataLocalTime(); // time to pass for the prev train
        Time_A1.SetName("Time_A1");
        Time_A1.SetValue(null);
        pn.PlaceList.add(Time_A1); /// IS THIS CONSTANT IF IT WILL CHANGE EACH TIME?

        DataLocalTime Time_A2 = new DataLocalTime(); // time to pass for the prev train
        Time_A2.SetName("Time_A2");
        Time_A2.SetValue(null);
        pn.PlaceList.add(Time_A2); /// IS THIS CONSTANT IF IT WILL CHANGE EACH TIME?

        DataLocalTime Time_A3 = new DataLocalTime(); // time to pass for the prev train
        Time_A3.SetName("Time_A3");
        Time_A3.SetValue(null);
        pn.PlaceList.add(Time_A3); /// IS THIS CONSTANT IF IT WILL CHANGE EACH TIME?

        DataTransfer OP_A1 = new DataTransfer();
        OP_A1.SetName("OP_A1");
        OP_A1.Value = new TransferOperation("localhost", "1082", "in_a1");
        pn.PlaceList.add(OP_A1);

        DataTransfer OP_A2 = new DataTransfer();
        OP_A2.SetName("OP_A2");
        OP_A2.Value = new TransferOperation("localhost", "1082", "in_a2");
        pn.PlaceList.add(OP_A2);

        DataTransfer OP_A3 = new DataTransfer();
        OP_A3.SetName("OP_A3");
        OP_A3.Value = new TransferOperation("localhost", "1082", "in_a3");
        pn.PlaceList.add(OP_A3);

        DataTransfer OP_i2 = new DataTransfer();
        OP_i2.SetName("OP_i2");
        OP_i2.Value = new TransferOperation("localhost", "1083", "inA");
        pn.PlaceList.add(OP_i2);

        // t1_A1


    }
}
