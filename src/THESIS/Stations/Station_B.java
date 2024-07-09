package THESIS.Stations;

import Components.*;
import DataObjects.*;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Station_B {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Station B";
        pn.SetName("Station B");

        pn.NetworkPort = 1089;


        DataTrain p1 = new DataTrain();
        p1.SetName("Train_B1");
        pn.PlaceList.add(p1);

        DataTrain p2 = new DataTrain();
        p2.SetName("Train_B2");
        pn.PlaceList.add(p2);

        DataTrain p3 = new DataTrain();
        p3.SetName("Train_B3");
        pn.PlaceList.add(p3);

        DataTrain p4 = new DataTrain();
        p4.SetName("Exit_B1");
        pn.PlaceList.add(p4);

        DataTrain p5 = new DataTrain();
        p5.SetName("Exit_B2");
        pn.PlaceList.add(p5);

        DataTrain p6 = new DataTrain();
        p6.SetName("Exit_B3");
        pn.PlaceList.add(p6);

        DataTrain p7 = new DataTrain();
        p7.SetName("B1");
        pn.PlaceList.add(p7);

        DataTrain p8 = new DataTrain();
        p8.SetName("B2");
        pn.PlaceList.add(p8);

        DataTrain p9 = new DataTrain();
        p9.SetName("B3");
        pn.PlaceList.add(p9);

        DataTrain p10 = new DataTrain();
        p10.SetName("P_B1");
        pn.PlaceList.add(p10);

        DataTrain p11 = new DataTrain();
        p11.SetName("P_B2");
        pn.PlaceList.add(p11);

        DataTrain p12 = new DataTrain();
        p12.SetName("P_B3");
        pn.PlaceList.add(p12);

        DataTrain p13 = new DataTrain();
        p13.SetName("i3");
        pn.PlaceList.add(p13);

        DataTrain p14 = new DataTrain();
        p14.SetName("i4");
        pn.PlaceList.add(p14);

        DataListTrainsQueue Time_B1 = new DataListTrainsQueue();
        Time_B1.SetName("Time_B1");
        pn.PlaceList.add(Time_B1);

        DataListTrainsQueue Time_B2 = new DataListTrainsQueue();
        Time_B2.SetName("Time_B2");
        pn.PlaceList.add(Time_B2);

        DataListTrainsQueue Time_B3 = new DataListTrainsQueue();
        Time_B3.SetName("Time_B3");
        pn.PlaceList.add(Time_B3);

        DataTransfer OP_B1 = new DataTransfer();
        OP_B1.SetName("OP_B1");
        OP_B1.Value = new TransferOperation("localhost", "1087", "in_b1");
        pn.PlaceList.add(OP_B1);

        DataTransfer OP_B2 = new DataTransfer();
        OP_B2.SetName("OP_B2");
        OP_B2.Value = new TransferOperation("localhost", "1087", "in_b2");
        pn.PlaceList.add(OP_B2);

        DataTransfer OP_B3 = new DataTransfer();
        OP_B3.SetName("OP_B3");
        OP_B3.Value = new TransferOperation("localhost", "1087", "in_b3");
        pn.PlaceList.add(OP_B3);

        DataTransfer OP_i4 = new DataTransfer();
        OP_i4.SetName("OP_i4");
        OP_i4.Value = new TransferOperation("localhost", "1083", "inB");
        pn.PlaceList.add(OP_i4);

        DataTransfer OP_PB1 = new DataTransfer();
        OP_PB1.SetName("OP_PB1");
        OP_PB1.Value = new TransferOperation("localhost", "1091", "C_PB1");
        pn.PlaceList.add(OP_PB1);

        DataTransfer OP_PB2 = new DataTransfer();
        OP_PB2.SetName("OP_PB2");
        OP_PB2.Value = new TransferOperation("localhost", "1091", "C_PB2");
        pn.PlaceList.add(OP_PB2);

        DataTransfer OP_PB3 = new DataTransfer();
        OP_PB3.SetName("OP_PB3");
        OP_PB3.Value = new TransferOperation("localhost", "1091", "C_PB3");
        pn.PlaceList.add(OP_PB3);

        DataTransfer OP_PB4 = new DataTransfer();
        OP_PB4.SetName("OP_PB4");
        OP_PB1.Value = new TransferOperation("localhost", "1091", "C_PB4");
        pn.PlaceList.add(OP_PB4);

        DataTransfer OP_TimeB1 = new DataTransfer();
        OP_TimeB1.SetName("OP_TimeB1");
        OP_TimeB1.Value = new TransferOperation("localhost", "1091", "C_TimeB1");
        pn.PlaceList.add(OP_TimeB1);

        DataTransfer OP_TimeB2 = new DataTransfer();
        OP_TimeB2.SetName("OP_TimeB2");
        OP_TimeB2.Value = new TransferOperation("localhost", "1091", "C_TimeB2");
        pn.PlaceList.add(OP_TimeB2);

        DataTransfer OP_TimeB3 = new DataTransfer();
        OP_TimeB3.SetName("OP_TimeB3");
        OP_TimeB3.Value = new TransferOperation("localhost", "1091", "C_TimeB3");
        pn.PlaceList.add(OP_TimeB3);

        DataTransfer OP_TimeB4 = new DataTransfer();
        OP_TimeB4.SetName("OP_TimeB4");
        OP_TimeB4.Value = new TransferOperation("localhost", "1091", "C_TimeB4");
        pn.PlaceList.add(OP_TimeB4);

        DataString B1 = new DataString();
        B1.SetName("B1");
        B1.SetValue("B1");
        pn.ConstantPlaceList.add(B1);

        DataString B2 = new DataString();
        B2.SetName("B2");
        B2.SetValue("B2");
        pn.ConstantPlaceList.add(B2);

        DataString B3 = new DataString();
        B3.SetName("B3");
        B3.SetValue("B3");
        pn.ConstantPlaceList.add(B3);

        DataString B4 = new DataString();
        B4.SetName("B4");
        B4.SetValue("B4");
        pn.ConstantPlaceList.add(B4);

        DataInteger B1_Length = new DataInteger();
        B1_Length.SetName("B1_Length");
        pn.ConstantPlaceList.add(B1_Length);

        DataInteger B2_Length = new DataInteger();
        B2_Length.SetName("B2_Length");
        pn.ConstantPlaceList.add(B2_Length);

        DataInteger B3_Length = new DataInteger();
        B3_Length.SetName("B3_Length");
        pn.ConstantPlaceList.add(B3_Length);

        DataInteger B4_Length = new DataInteger();
        B4_Length.SetName("B1_Length");
        pn.ConstantPlaceList.add(B4_Length);

        DataInteger speed_on_platform = new DataInteger();
        speed_on_platform.SetName("Speed_On_Platform");
        pn.ConstantPlaceList.add(speed_on_platform);

        DataLocalTime time = new DataLocalTime(); // needed for when it is pass 23:59:59
        time.SetName("Time");
        time.SetValue(null);
        pn.ConstantPlaceList.add(time);

        // t1_B1 ------------------------------------------------

        PetriTransition t1_B1 = new PetriTransition(pn);
        t1_B1.TransitionName = "t1_B1";
        t1_B1.InputPlaceName.add("Train_B1");


        Condition t1_B1Ct1a = new Condition(t1_B1, "Train_B1", TransitionCondition.NotNull);
        Condition t1_B1Ct2a = new Condition(t1_B1, "B1", TransitionCondition.IsNull);

        t1_B1Ct1a.SetNextCondition(LogicConnector.AND, t1_B1Ct2a);

        GuardMapping grdt1_B1a = new GuardMapping();
        grdt1_B1a.condition = t1_B1Ct1a;
        grdt1_B1a.Activations.add(new Activation(t1_B1, "Train_B1", TransitionOperation.Move, "B1"));
        t1_B1.GuardMappingList.add(grdt1_B1a);


        t1_B1.Delay = 0;
        pn.Transitions.add(t1_B1);


        // t2_B1 ------------------------------------------------

        PetriTransition t2_B1 = new PetriTransition(pn);
        t2_B1.TransitionName = "t2_B1";
        t2_B1.InputPlaceName.add("B1");


        Condition t2_B1Ct1a = new Condition(t2_B1, "B1", TransitionCondition.NotNull);
        Condition t2_B1Ct2a = new Condition(t2_B1, "Exit_B1", TransitionCondition.IsNull);

        t2_B1Ct1a.SetNextCondition(LogicConnector.AND, t2_B1Ct2a);

        GuardMapping grdt2_B1a = new GuardMapping();
        grdt2_B1a.condition = t2_B1Ct1a;
        grdt2_B1a.Activations.add(new Activation(t2_B1, "B1", TransitionOperation.Move, "Exit_B1"));
        t2_B1.GuardMappingList.add(grdt2_B1a);


        t2_B1.Delay = 3; // fictional time for people to get off
        pn.Transitions.add(t2_B1);


        // S4 ------------------------------------------------

        PetriTransition S4 = new PetriTransition(pn);
        S4.TransitionName = "S4";
        S4.InputPlaceName.add("Time_B1");
        S4.InputPlaceName.add("P_B1");
        S4.InputPlaceName.add("B1");


        Condition S4Ct1a = new Condition(S4, "Train_B1", TransitionCondition.NotNull);
        Condition S4Ct2a = new Condition(S4, "B1", TransitionCondition.NotNull);
        Condition S4Ct3a = new Condition(S4, "P_B1", TransitionCondition.IsNull);

        S4Ct2a.SetNextCondition(LogicConnector.AND, S4Ct3a);
        S4Ct1a.SetNextCondition(LogicConnector.AND, S4Ct2a);

        GuardMapping grdS4a = new GuardMapping();
        grdS4a.condition = S4Ct1a;
        grdS4a.Activations.add(new Activation(S4, "Time_B1", TransitionOperation.SendOverNetwork, "OP_B1"));
        grdS4a.Activations.add(new Activation(S4, "B1", TransitionOperation.Move, "P_B1"));
        S4.GuardMappingList.add(grdS4a);


        Condition S4Ct1b = new Condition(S4, "Train_B1", TransitionCondition.IsNull);
        Condition S4Ct2b = new Condition(S4, "B1", TransitionCondition.IsNull);
        Condition S4Ct3b = new Condition(S4, "P_B1", TransitionCondition.NotNull);

        S4Ct2b.SetNextCondition(LogicConnector.AND, S4Ct3b);
        S4Ct1b.SetNextCondition(LogicConnector.AND, S4Ct2b);

        GuardMapping grdS4b = new GuardMapping();
        grdS4b.condition = S4Ct1b;
        grdS4b.Activations.add(new Activation(S4, "P_B1", TransitionOperation.Move, "B1"));
        S4.GuardMappingList.add(grdS4b);


        S4.Delay = 0;
        pn.Transitions.add(S4);



        // t3_B1------------------------------------------------

        PetriTransition t3_B1 = new PetriTransition(pn);
        t3_B1.TransitionName = "t3_B1";
        t3_B1.InputPlaceName.add("i3");
        t3_B1.InputPlaceName.add("P_B1");


        // train leaving station
        Condition t3_B1Ct2a = new Condition(t3_B1, "i3", TransitionCondition.IsNull);
        Condition t3_B1Ct3a = new Condition(t3_B1, "P_B1", TransitionCondition.NotNull);

        t3_B1Ct2a.SetNextCondition(LogicConnector.AND, t3_B1Ct3a);

        GuardMapping grdt3_B1a = new GuardMapping();
        grdt3_B1a.condition = t3_B1Ct2a;
        grdt3_B1a.Activations.add(new Activation(t3_B1, "P_B1", TransitionOperation.Move, "i3"));
        t3_B1.GuardMappingList.add(grdt3_B1a);

        // train coming
        Condition t3_B1Ct1b = new Condition(t3_B1, "P_B1", TransitionCondition.IsNull);
        Condition t3_B1Ct2b = new Condition(t3_B1, "i3", TransitionCondition.HaveTrainForMe);

        t3_B1Ct2b.SetNextCondition(LogicConnector.AND, t3_B1Ct1b);

        GuardMapping grdt3_B1b = new GuardMapping();
        grdt3_B1b.condition = t3_B1Ct1b;
        grdt3_B1b.Activations.add(new Activation(t3_B1, p14,B1_Length,null,speed_on_platform, TransitionOperation.CalculateTime, time));
        grdt3_B1b.Activations.add(new Activation(t3_B1, "Time", TransitionOperation.SendOverNetwork, "OP_TimeB1"));
        grdt3_B1b.Activations.add(new Activation(t3_B1, "B1", TransitionOperation.SendOverNetwork, "OP_PB1"));
        grdt3_B1b.Activations.add(new Activation(t3_B1, "i3", TransitionOperation.Move, "P_B1"));
        t3_B1.GuardMappingList.add(grdt3_B1b);


        t3_B1.Delay = 0;
        pn.Transitions.add(t3_B1);



        /// PLATFORM B2

        // t1_B2 ------------------------------------------------

        PetriTransition t1_B2 = new PetriTransition(pn);
        t1_B2.TransitionName = "t1_B2";
        t1_B2.InputPlaceName.add("Train_B2");


        Condition t1_B2Ct1a = new Condition(t1_B2, "Train_B2", TransitionCondition.NotNull);
        Condition t1_B2Ct2a = new Condition(t1_B2, "B2", TransitionCondition.IsNull);

        t1_B2Ct1a.SetNextCondition(LogicConnector.AND, t1_B2Ct2a);

        GuardMapping grdt1_B2a = new GuardMapping();
        grdt1_B2a.condition = t1_B2Ct1a;
        grdt1_B2a.Activations.add(new Activation(t1_B2, "Train_B2", TransitionOperation.Move, "B2"));
        t1_B2.GuardMappingList.add(grdt1_B2a);


        t1_B2.Delay = 0;
        pn.Transitions.add(t1_B2);


        // t2_B2 ------------------------------------------------

        PetriTransition t2_B2 = new PetriTransition(pn);
        t2_B2.TransitionName = "t2_B2";
        t2_B2.InputPlaceName.add("B2");


        Condition t2_B2Ct1a = new Condition(t2_B2, "B2", TransitionCondition.NotNull);
        Condition t2_B2Ct2a = new Condition(t2_B2, "Exit_B2", TransitionCondition.IsNull);

        t2_B2Ct1a.SetNextCondition(LogicConnector.AND, t2_B2Ct2a);

        GuardMapping grdt2_B2a = new GuardMapping();
        grdt2_B2a.condition = t2_B2Ct1a;
        grdt2_B2a.Activations.add(new Activation(t2_B2, "B2", TransitionOperation.Move, "Exit_B2"));
        t2_B2.GuardMappingList.add(grdt2_B2a);


        t2_B2.Delay = 3; // fictional time for people to get off
        pn.Transitions.add(t2_B2);


        // S5 ------------------------------------------------

        PetriTransition S5 = new PetriTransition(pn);
        S5.TransitionName = "S5";
        S5.InputPlaceName.add("Time_B2");
        S5.InputPlaceName.add("P_B2");
        S5.InputPlaceName.add("B2");


        Condition S5Ct1a = new Condition(S5, "Train_B2", TransitionCondition.NotNull);
        Condition S5Ct2a = new Condition(S5, "B2", TransitionCondition.NotNull);
        Condition S5Ct3a = new Condition(S5, "P_B2", TransitionCondition.IsNull);

        S5Ct2a.SetNextCondition(LogicConnector.AND, S5Ct3a);
        S5Ct1a.SetNextCondition(LogicConnector.AND, S5Ct2a);

        GuardMapping grdS5a = new GuardMapping();
        grdS5a.condition = S5Ct1a;
        grdS5a.Activations.add(new Activation(S5, "Time_B2", TransitionOperation.SendOverNetwork, "OP_B2"));
        grdS5a.Activations.add(new Activation(S5, "B2", TransitionOperation.Move, "P_B2"));
        S5.GuardMappingList.add(grdS5a);


        Condition S5Ct1b = new Condition(S5, "Train_B2", TransitionCondition.IsNull);
        Condition S5Ct2b = new Condition(S5, "B2", TransitionCondition.IsNull);
        Condition S5Ct3b = new Condition(S5, "P_B2", TransitionCondition.NotNull);

        S5Ct2b.SetNextCondition(LogicConnector.AND, S5Ct3b);
        S5Ct1b.SetNextCondition(LogicConnector.AND, S5Ct2b);

        GuardMapping grdS5b = new GuardMapping();
        grdS5b.condition = S5Ct1b;
        grdS5b.Activations.add(new Activation(S5, "P_B2", TransitionOperation.Move, "B2"));
        S5.GuardMappingList.add(grdS5b);


        S5.Delay = 0;
        pn.Transitions.add(S5);

        // t3_B2------------------------------------------------

        PetriTransition t3_B2 = new PetriTransition(pn);
        t3_B2.TransitionName = "t3_B2";
        t3_B2.InputPlaceName.add("i4");
        t3_B2.InputPlaceName.add("P_B2");



        Condition t3_B2Ct2a = new Condition(t3_B2, "i4", TransitionCondition.IsNull);
        Condition t3_B2Ct3a = new Condition(t3_B2, "P_B2", TransitionCondition.NotNull);

        t3_B2Ct2a.SetNextCondition(LogicConnector.AND, t3_B2Ct3a);

        GuardMapping grdt3_B2a = new GuardMapping();
        grdt3_B2a.condition = t3_B2Ct2a;
        grdt3_B2a.Activations.add(new Activation(t3_B2, "P_B2", TransitionOperation.Move, "i4"));
        t3_B2.GuardMappingList.add(grdt3_B2a);


        // train coming
        Condition t3_B2Ct1b = new Condition(t3_B2, "P_B2", TransitionCondition.IsNull);
        Condition t3_B2Ct2b = new Condition(t3_B2, "i4", TransitionCondition.HaveTrainForMe);

        t3_B2Ct2b.SetNextCondition(LogicConnector.AND, t3_B2Ct1b);

        GuardMapping grdt3_B2b = new GuardMapping();
        grdt3_B2b.condition = t3_B2Ct1b;
        grdt3_B2b.Activations.add(new Activation(t3_B2, p14,B2_Length,null,speed_on_platform, TransitionOperation.CalculateTime, time));
        grdt3_B2b.Activations.add(new Activation(t3_B2, "Time", TransitionOperation.SendOverNetwork, "OP_TimeB2"));
        grdt3_B2b.Activations.add(new Activation(t3_B2, "B2", TransitionOperation.SendOverNetwork, "OP_PB2"));
        grdt3_B2b.Activations.add(new Activation(t3_B2, "i4", TransitionOperation.Move, "P_B2"));
        t3_B2.GuardMappingList.add(grdt3_B2b);


        t3_B2.Delay = 0;
        pn.Transitions.add(t3_B2);


        // Connecting platform B4

        // t4_B1------------------------------------------------

        PetriTransition t4_B1 = new PetriTransition(pn);
        t4_B1.TransitionName = "t4_B1";
        t4_B1.InputPlaceName.add("i3");
        t4_B1.InputPlaceName.add("i4");


        // train leaving station
        Condition t4_B1Ct2a = new Condition(t4_B1, "i3", TransitionCondition.IsNull);
        Condition t4_B1Ct4a = new Condition(t4_B1, "i4", TransitionCondition.HaveTrainForMe);

        t4_B1Ct2a.SetNextCondition(LogicConnector.AND, t4_B1Ct4a);

        GuardMapping grdt4_B1a = new GuardMapping();
        grdt4_B1a.condition = t4_B1Ct2a;
        grdt4_B1a.Activations.add(new Activation(t4_B1, "i4", TransitionOperation.Move, "i3"));
        t4_B1.GuardMappingList.add(grdt4_B1a);


        // train coming and having as target Platform B3
        Condition t4_B1Ct1b = new Condition(t4_B1, "i4", TransitionCondition.IsNull);
        Condition t4_B1Ct2b = new Condition(t4_B1, "i3", TransitionCondition.HaveTrainForMe);
        Condition t4_B1Ct3b = new Condition(t4_B1, "i3", TransitionCondition.Platform,"B3");

        t4_B1Ct3b.SetNextCondition(LogicConnector.AND, t4_B1Ct2b);
        t4_B1Ct2b.SetNextCondition(LogicConnector.AND, t4_B1Ct1b);

        GuardMapping grdt4_B1b = new GuardMapping();
        grdt4_B1b.condition = t4_B1Ct1b;
        grdt4_B1b.Activations.add(new Activation(t4_B1, p14,B3_Length,B4_Length,speed_on_platform, TransitionOperation.CalculateTime, time));
        grdt4_B1b.Activations.add(new Activation(t4_B1, "Time", TransitionOperation.SendOverNetwork, "OP_TimeB4"));
        grdt4_B1b.Activations.add(new Activation(t4_B1, "B4", TransitionOperation.SendOverNetwork, "OP_PB4"));
        grdt4_B1b.Activations.add(new Activation(t4_B1, "i3", TransitionOperation.Move, "i4"));
        t4_B1.GuardMappingList.add(grdt4_B1b);


        // train coming and having as target Platform B2
        Condition t4_B1Ct1c = new Condition(t4_B1, "i4", TransitionCondition.IsNull);
        Condition t4_B1Ct2c = new Condition(t4_B1, "i3", TransitionCondition.HaveTrainForMe);
        Condition t4_B1Ct3c = new Condition(t4_B1, "i3", TransitionCondition.Platform,"B2");

        t4_B1Ct3c.SetNextCondition(LogicConnector.AND, t4_B1Ct2c);
        t4_B1Ct2c.SetNextCondition(LogicConnector.AND, t4_B1Ct1c);

        GuardMapping grdt4_B1c = new GuardMapping();
        grdt4_B1c.condition = t4_B1Ct1b;
        grdt4_B1c.Activations.add(new Activation(t4_B1, p14,B2_Length,B4_Length,speed_on_platform, TransitionOperation.CalculateTime, time));
        grdt4_B1c.Activations.add(new Activation(t4_B1, "Time", TransitionOperation.SendOverNetwork, "OP_TimeB4"));
        grdt4_B1c.Activations.add(new Activation(t4_B1, "B4", TransitionOperation.SendOverNetwork, "OP_PB4"));
        grdt4_B1c.Activations.add(new Activation(t4_B1, "i3", TransitionOperation.Move, "i4"));
        t4_B1.GuardMappingList.add(grdt4_B1c);


        t4_B1.Delay = 0;
        pn.Transitions.add(t4_B1);


        /// PLATFORM B3

        // t1_B3 ------------------------------------------------

        PetriTransition t1_B3 = new PetriTransition(pn);
        t1_B3.TransitionName = "t1_B3";
        t1_B3.InputPlaceName.add("Train_B3");


        Condition t1_B3Ct1a = new Condition(t1_B3, "Train_B3", TransitionCondition.NotNull);
        Condition t1_B3Ct2a = new Condition(t1_B3, "B3", TransitionCondition.IsNull);

        t1_B3Ct1a.SetNextCondition(LogicConnector.AND, t1_B3Ct2a);

        GuardMapping grdt1_B3a = new GuardMapping();
        grdt1_B3a.condition = t1_B3Ct1a;
        grdt1_B3a.Activations.add(new Activation(t1_B3, "Train_B3", TransitionOperation.Move, "B3"));
        t1_B3.GuardMappingList.add(grdt1_B3a);


        t1_B3.Delay = 0;
        pn.Transitions.add(t1_B3);


        // t2_B3 ------------------------------------------------

        PetriTransition t2_B3 = new PetriTransition(pn);
        t2_B3.TransitionName = "t2_B3";
        t2_B3.InputPlaceName.add("B3");


        Condition t2_B3Ct1a = new Condition(t2_B3, "B3", TransitionCondition.NotNull);
        Condition t2_B3Ct2a = new Condition(t2_B3, "Exit_B3", TransitionCondition.IsNull);

        t2_B3Ct1a.SetNextCondition(LogicConnector.AND, t2_B3Ct2a);

        GuardMapping grdt2_B3a = new GuardMapping();
        grdt2_B3a.condition = t2_B3Ct1a;
        grdt2_B3a.Activations.add(new Activation(t2_B3, "B3", TransitionOperation.Move, "Exit_B3"));
        t2_B3.GuardMappingList.add(grdt2_B3a);


        t2_B3.Delay = 3; // fictional time for people to get off
        pn.Transitions.add(t2_B3);


        // S6 ------------------------------------------------

        PetriTransition S6 = new PetriTransition(pn);
        S6.TransitionName = "S6";
        S6.InputPlaceName.add("Time_B3");
        S6.InputPlaceName.add("P_B3");
        S6.InputPlaceName.add("B3");


        Condition S6Ct1a = new Condition(S6, "Train_B3", TransitionCondition.NotNull);
        Condition S6Ct2a = new Condition(S6, "B3", TransitionCondition.NotNull);
        Condition S6Ct3a = new Condition(S6, "P_B3", TransitionCondition.IsNull);

        S6Ct2a.SetNextCondition(LogicConnector.AND, S6Ct3a);
        S6Ct1a.SetNextCondition(LogicConnector.AND, S6Ct2a);

        GuardMapping grdS6a = new GuardMapping();
        grdS6a.condition = S6Ct1a;
        grdS6a.Activations.add(new Activation(S6, "Time_B3", TransitionOperation.SendOverNetwork, "OP_B3"));
        grdS6a.Activations.add(new Activation(S6, "B3", TransitionOperation.Move, "P_B3"));
        S6.GuardMappingList.add(grdS6a);


        Condition S6Ct1b = new Condition(S6, "Train_B3", TransitionCondition.IsNull);
        Condition S6Ct2b = new Condition(S6, "B3", TransitionCondition.IsNull);
        Condition S6Ct3b = new Condition(S6, "P_B3", TransitionCondition.NotNull);

        S6Ct2b.SetNextCondition(LogicConnector.AND, S6Ct3b);
        S6Ct1b.SetNextCondition(LogicConnector.AND, S6Ct2b);

        GuardMapping grdS6b = new GuardMapping();
        grdS6b.condition = S6Ct1b;
        grdS6b.Activations.add(new Activation(S6, "P_B3", TransitionOperation.Move, "B3"));
        S6.GuardMappingList.add(grdS6b);


        S6.Delay = 0;
        pn.Transitions.add(S6);


        // t3_B3------------------------------------------------

        PetriTransition t3_B3 = new PetriTransition(pn);
        t3_B3.TransitionName = "t3_B3";
        t3_B3.InputPlaceName.add("i4");
        t3_B3.InputPlaceName.add("P_B3");


        // train leaving
        Condition t3_B3Ct2a = new Condition(t3_B3, "i4", TransitionCondition.IsNull);
        Condition t3_B3Ct3a = new Condition(t3_B3, "P_B3", TransitionCondition.NotNull);

        t3_B3Ct2a.SetNextCondition(LogicConnector.AND, t3_B3Ct3a);

        GuardMapping grdt3_B3a = new GuardMapping();
        grdt3_B3a.condition = t3_B3Ct2a;
        grdt3_B3a.Activations.add(new Activation(t3_B3, "P_B3", TransitionOperation.Move, "i4"));
        t3_B3.GuardMappingList.add(grdt3_B3a);



        // train coming
        Condition t3_B3Ct1b = new Condition(t3_B3, "P_B3", TransitionCondition.IsNull);
        Condition t3_B3Ct2b = new Condition(t3_B3, "i4", TransitionCondition.HaveTrainForMe);

        t3_B3Ct2b.SetNextCondition(LogicConnector.AND, t3_B3Ct1b);

        GuardMapping grdt3_B3b = new GuardMapping();
        grdt3_B3b.condition = t3_B3Ct1b;
        grdt3_B3b.Activations.add(new Activation(t3_B3, p14,B3_Length,null,speed_on_platform, TransitionOperation.CalculateTime, time));
        grdt3_B3b.Activations.add(new Activation(t3_B3, "Time", TransitionOperation.SendOverNetwork, "OP_TimeB3"));
        grdt3_B3b.Activations.add(new Activation(t3_B3, "B3", TransitionOperation.SendOverNetwork, "OP_PB3"));
        grdt3_B3b.Activations.add(new Activation(t3_B3, "i4", TransitionOperation.Move, "P_B3"));
        t3_B3.GuardMappingList.add(grdt3_B3b);


        t3_B3.Delay = 0;
        pn.Transitions.add(t3_B3);



        // t4_B2------------------------------------------------

        PetriTransition t4_B2 = new PetriTransition(pn);
        t4_B2.TransitionName = "t4_B2";
        t4_B2.InputPlaceName.add("i3");


        Condition t4_B2Ct2a = new Condition(t4_B2, "i3", TransitionCondition.HaveTrainForMe);

        GuardMapping grdt4_B2a = new GuardMapping();
        grdt4_B2a.condition = t4_B2Ct2a;
        grdt4_B2a.Activations.add(new Activation(t4_B2, "i3", TransitionOperation.SendOverNetwork, "OP_i3"));
        t4_B2.GuardMappingList.add(grdt4_B2a);


        t3_B3.Delay = 0;
        pn.Transitions.add(t3_B3);

        System.out.println("Station B started \n ------------------------------");
        pn.Delay = 3000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }


}
