package THESIS.Stations;

import Components.*;
import DataObjects.*;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Station_A {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Station A";
        pn.SetName("Station A");

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

        DataListTrains Time_A1 = new DataListTrains();
        Time_A1.SetName("Time_A1");
        pn.PlaceList.add(Time_A1);

        DataListTrains Time_A2 = new DataListTrains();
        Time_A2.SetName("Time_A2");
        pn.PlaceList.add(Time_A2);

        DataListTrains Time_A3 = new DataListTrains();
        Time_A3.SetName("Time_A3");
        pn.PlaceList.add(Time_A3);

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

        DataTransfer OP_PA1 = new DataTransfer();
        OP_PA1.SetName("OP_PA1");
        OP_PA1.Value = new TransferOperation("localhost", "1080", "C_PA1");
        pn.PlaceList.add(OP_PA1);

        DataTransfer OP_PA2 = new DataTransfer();
        OP_PA2.SetName("OP_PA2");
        OP_PA2.Value = new TransferOperation("localhost", "1080", "C_PA2");
        pn.PlaceList.add(OP_PA2);

        DataTransfer OP_PA3 = new DataTransfer();
        OP_PA3.SetName("OP_PA3");
        OP_PA3.Value = new TransferOperation("localhost", "1080", "C_PA3");
        pn.PlaceList.add(OP_PA3);

        DataTransfer OP_PA4 = new DataTransfer();
        OP_PA4.SetName("OP_PA4");
        OP_PA4.Value = new TransferOperation("localhost", "1080", "C_PA4");
        pn.PlaceList.add(OP_PA4);

        DataTransfer OP_TimeA1 = new DataTransfer();
        OP_TimeA1.SetName("OP_TimeA1");
        OP_TimeA1.Value = new TransferOperation("localhost", "1080", "C_TimeA1");
        pn.PlaceList.add(OP_TimeA1);

        DataTransfer OP_TimeA2 = new DataTransfer();
        OP_TimeA2.SetName("OP_TimeA2");
        OP_TimeA2.Value = new TransferOperation("localhost", "1080", "C_TimeA2");
        pn.PlaceList.add(OP_TimeA2);

        DataTransfer OP_TimeA3 = new DataTransfer();
        OP_TimeA3.SetName("OP_TimeA3");
        OP_TimeA3.Value = new TransferOperation("localhost", "1080", "C_TimeA3");
        pn.PlaceList.add(OP_TimeA3);

        DataTransfer OP_TimeA4 = new DataTransfer();
        OP_TimeA4.SetName("OP_TimeA4");
        OP_TimeA4.Value = new TransferOperation("localhost", "1080", "C_TimeA4");
        pn.PlaceList.add(OP_TimeA4);

        DataString A1 = new DataString();
        A1.SetName("A1");
        A1.SetValue("A1");
        pn.ConstantPlaceList.add(A1);

        DataString A2 = new DataString();
        A2.SetName("A2");
        A2.SetValue("A2");
        pn.ConstantPlaceList.add(A2);

        DataString A3 = new DataString();
        A3.SetName("A3");
        A3.SetValue("A3");
        pn.ConstantPlaceList.add(A3);

        DataString A4 = new DataString();
        A4.SetName("A4");
        A4.SetValue("A4");
        pn.ConstantPlaceList.add(A4);

        DataInteger Zero = new DataInteger();
        Zero.SetName("Zero");
        Zero.SetValue(0);
        pn.ConstantPlaceList.add(Zero);

        DataInteger A1_Length = new DataInteger();
        A1_Length.SetName("A1_Length");
        A1_Length.SetValue(78);
        pn.ConstantPlaceList.add(A1_Length);

        DataInteger A2_Length = new DataInteger();
        A2_Length.SetName("A2_Length");
        A2_Length.SetValue(85);
        pn.ConstantPlaceList.add(A2_Length);

        DataInteger A3_Length = new DataInteger();
        A3_Length.SetName("A3_Length");
        A3_Length.SetValue(96);
        pn.ConstantPlaceList.add(A3_Length);

        DataInteger A4_Length = new DataInteger();
        A4_Length.SetName("A4_Length");
        A4_Length.SetValue(58);
        pn.ConstantPlaceList.add(A4_Length);

        DataInteger speed_on_platform = new DataInteger();
        speed_on_platform.SetName("Speed_On_Platform");
        speed_on_platform.SetValue(5);
        pn.ConstantPlaceList.add(speed_on_platform);

        DataLocalTime time = new DataLocalTime();
        time.SetName("Time");
        time.SetValue(null);
        pn.ConstantPlaceList.add(time);

        DataString t2_A1a = new DataString();
        t2_A1a.SetName("t2_A1");
        t2_A1a.SetValue("t2_A1");
        pn.ConstantPlaceList.add(t2_A1a);


        DataString t2_A2a = new DataString();
        t2_A2a.SetName("t2_A2");
        t2_A2a.SetValue("t2_A2");
        pn.ConstantPlaceList.add(t2_A2a);


        DataString t2_A3a = new DataString();
        t2_A3a.SetName("t2_A3");
        t2_A3a.SetValue("t2_A3");
        pn.ConstantPlaceList.add(t2_A3a);



        // t1_A1 ------------------------------------------------

        PetriTransition t1_A1 = new PetriTransition(pn);
        t1_A1.TransitionName = "t1_A1";
        t1_A1.InputPlaceName.add("Train_A1");

        // Handle case when input is null
        Condition t1_A1CtAllNull = new Condition(t1_A1, "Train_A1", TransitionCondition.IsNull);

        GuardMapping grdt1_A1AllNull = new GuardMapping();
        grdt1_A1AllNull.condition = t1_A1CtAllNull;
        grdt1_A1AllNull.Activations.add(new Activation(t1_A1, "", TransitionOperation.DoNothing, ""));
        t1_A1.GuardMappingList.add(grdt1_A1AllNull);



        Condition t1_A1Ct1a = new Condition(t1_A1, "Train_A1", TransitionCondition.NotNull);
        Condition t1_A1Ct2a = new Condition(t1_A1, "A1", TransitionCondition.IsNull);

        t1_A1Ct1a.SetNextCondition(LogicConnector.AND, t1_A1Ct2a);

        GuardMapping grdt1_A1a = new GuardMapping();
        grdt1_A1a.condition = t1_A1Ct1a;
        grdt1_A1a.Activations.add(new Activation(t1_A1, "Train_A1", TransitionOperation.Move, "A1"));
        t1_A1.GuardMappingList.add(grdt1_A1a);

        t1_A1.Delay = 0;
        pn.Transitions.add(t1_A1);

        // t2_A1 ------------------------------------------------

        PetriTransition t2_A1 = new PetriTransition(pn);
        t2_A1.TransitionName = "t2_A1";
        t2_A1.InputPlaceName.add("A1");

        Condition t2_A1Ct1a = new Condition(t2_A1, "A1", TransitionCondition.NotNull);
        Condition t2_A1Ct2a = new Condition(t2_A1, "Exit_A1", TransitionCondition.IsNull);
        Condition t2_A1Ct3a = new Condition(t2_A1, "A1", TransitionCondition.Check_Transition_Target_List, "t2_A1");

        t2_A1Ct2a.SetNextCondition(LogicConnector.AND, t2_A1Ct3a);
        t2_A1Ct1a.SetNextCondition(LogicConnector.AND, t2_A1Ct2a);

        GuardMapping grdt2_A1a = new GuardMapping();
        grdt2_A1a.condition = t2_A1Ct1a;
        grdt2_A1a.Activations.add(new Activation(t2_A1, "A1", TransitionOperation.Move, "Exit_A1"));
        t2_A1.GuardMappingList.add(grdt2_A1a);

        t2_A1.Delay = 3;
        pn.Transitions.add(t2_A1);

        // S1 ------------------------------------------------

        PetriTransition S1 = new PetriTransition(pn);
        S1.TransitionName = "S1";
        S1.InputPlaceName.add("Time_A1");
        S1.InputPlaceName.add("P_A1");
        S1.InputPlaceName.add("A1");


        Condition S1Ct2a = new Condition(S1, "A1", TransitionCondition.NotNull);
        Condition S1Ct3a = new Condition(S1, "P_A1", TransitionCondition.IsNull);
        Condition S1Ct1a = new Condition(S1, "A1", TransitionCondition.Check_Transition_Target_List_NO,"t2_A1");

        S1Ct2a.SetNextCondition(LogicConnector.AND, S1Ct3a);
        S1Ct1a.SetNextCondition(LogicConnector.AND, S1Ct2a);

        GuardMapping grdS1a = new GuardMapping();
        grdS1a.condition = S1Ct2a;
        grdS1a.Activations.add(new Activation(S1, "Time_A1", TransitionOperation.SendOverNetwork, "OP_A1"));
        grdS1a.Activations.add(new Activation(S1, "A1", TransitionOperation.Move, "P_A1"));
        S1.GuardMappingList.add(grdS1a);

        Condition S1Ct1b = new Condition(S1, "A1", TransitionCondition.IsNull);
        Condition S1Ct2b = new Condition(S1, "P_A1", TransitionCondition.NotNull);
        Condition S1Ct3b = new Condition(S1, "P_A1", TransitionCondition.Check_Transition_Target_List,"t2_A1");

        S1Ct2b.SetNextCondition(LogicConnector.AND, S1Ct3b);
        S1Ct1b.SetNextCondition(LogicConnector.AND, S1Ct2b);

        GuardMapping grdS1b = new GuardMapping();
        grdS1b.condition = S1Ct1b;
        grdS1b.Activations.add(new Activation(S1, "P_A1", TransitionOperation.Move, "A1"));
        S1.GuardMappingList.add(grdS1b);

        S1.Delay = 0;
        pn.Transitions.add(S1);

        // t3_A1 ------------------------------------------------

        PetriTransition t3_A1 = new PetriTransition(pn);
        t3_A1.TransitionName = "t3_A1";
        t3_A1.InputPlaceName.add("i1");
        t3_A1.InputPlaceName.add("P_A1");


        // Train leaving station
        Condition t3_A1Ct1a = new Condition(t3_A1, "i1", TransitionCondition.IsNull);
        Condition t3_A1Ct2a = new Condition(t3_A1, "P_A1", TransitionCondition.NotNull);
        Condition t3_A1Ct3a = new Condition(t3_A1, "P_A1", TransitionCondition.Check_Transition_Target_List_NO,"t2_A1");

        t3_A1Ct2a.SetNextCondition(LogicConnector.AND, t3_A1Ct3a);
        t3_A1Ct1a.SetNextCondition(LogicConnector.AND, t3_A1Ct2a);

        GuardMapping grdt3_A1a = new GuardMapping();
        grdt3_A1a.condition = t3_A1Ct1a;
        grdt3_A1a.Activations.add(new Activation(t3_A1, "P_A1", TransitionOperation.Move, "i1"));
        t3_A1.GuardMappingList.add(grdt3_A1a);

        // Train coming
        Condition t3_A1Ct1b = new Condition(t3_A1, "P_A1", TransitionCondition.IsNull);
        Condition t3_A1Ct2b = new Condition(t3_A1, "i1", TransitionCondition.NotNull); // HaveTrainForMe
        Condition t3_A1Ct3b = new Condition(t3_A1, "i1", TransitionCondition.Check_Transition_Target_List,"t2_A1");

        t3_A1Ct1b.SetNextCondition(LogicConnector.AND, t3_A1Ct3b);
        t3_A1Ct2b.SetNextCondition(LogicConnector.AND, t3_A1Ct1b);

        GuardMapping grdt3_A1b = new GuardMapping();
        grdt3_A1b.condition = t3_A1Ct1b;
        grdt3_A1b.Activations.add(new Activation(t3_A1, "i1", "A1_Length", "Zero", "Speed_On_Platform", TransitionOperation.CalculateTime, "Time"));
        grdt3_A1b.Activations.add(new Activation(t3_A1, "Time", TransitionOperation.SendOverNetwork, "OP_TimeA1"));
        grdt3_A1b.Activations.add(new Activation(t3_A1, "A1", TransitionOperation.SendOverNetwork, "OP_PA1"));
        grdt3_A1b.Activations.add(new Activation(t3_A1, "i1", TransitionOperation.Move, "P_A1"));
        t3_A1.GuardMappingList.add(grdt3_A1b);

        t3_A1.Delay = 0;
        pn.Transitions.add(t3_A1);

        /// PLATFORM A2

        // t1_A2 ------------------------------------------------

        PetriTransition t1_A2 = new PetriTransition(pn);
        t1_A2.TransitionName = "t1_A2";
        t1_A2.InputPlaceName.add("Train_A2");

        // Handle case when input is null
        Condition t1_A2CtAllNull = new Condition(t1_A2, "Train_A2", TransitionCondition.IsNull);

       GuardMapping grdt1_A2AllNull = new GuardMapping();
        grdt1_A2AllNull.condition = t1_A2CtAllNull;
        grdt1_A2AllNull.Activations.add(new Activation(t1_A2, "", TransitionOperation.DoNothing, ""));
        t1_A2.GuardMappingList.add(grdt1_A2AllNull);

        Condition t1_A2Ct1a = new Condition(t1_A2, "Train_A2", TransitionCondition.NotNull);
        Condition t1_A2Ct2a = new Condition(t1_A2, "A2", TransitionCondition.IsNull);

        t1_A2Ct1a.SetNextCondition(LogicConnector.AND, t1_A2Ct2a);

        GuardMapping grdt1_A2a = new GuardMapping();
        grdt1_A2a.condition = t1_A2Ct1a;
        grdt1_A2a.Activations.add(new Activation(t1_A2, "Train_A2", TransitionOperation.Move, "A2"));
        t1_A2.GuardMappingList.add(grdt1_A2a);

        t1_A2.Delay = 0;
        pn.Transitions.add(t1_A2);

        // t2_A2 ------------------------------------------------

        PetriTransition t2_A2 = new PetriTransition(pn);
        t2_A2.TransitionName = "t2_A2";
        t2_A2.InputPlaceName.add("A2");

        Condition t2_A2Ct1a = new Condition(t2_A2, "A2", TransitionCondition.NotNull);
        Condition t2_A2Ct2a = new Condition(t2_A2, "Exit_A2", TransitionCondition.IsNull);
        Condition t2_A2Ct3a = new Condition(t2_A2, "A2", TransitionCondition.Check_Transition_Target_List, "t2_A2");

        t2_A2Ct2a.SetNextCondition(LogicConnector.AND, t2_A2Ct3a);
        t2_A2Ct1a.SetNextCondition(LogicConnector.AND, t2_A2Ct2a);

        GuardMapping grdt2_A2a = new GuardMapping();
        grdt2_A2a.condition = t2_A2Ct1a;
        grdt2_A2a.Activations.add(new Activation(t2_A2, "A2", TransitionOperation.Move, "Exit_A2"));
        t2_A2.GuardMappingList.add(grdt2_A2a);

        t2_A2.Delay = 3; // Use the Delay constant
        pn.Transitions.add(t2_A2);

        // S2 ------------------------------------------------

        PetriTransition S2 = new PetriTransition(pn);
        S2.TransitionName = "S2";
        S2.InputPlaceName.add("Time_A2");
        S2.InputPlaceName.add("P_A2");
        S2.InputPlaceName.add("A2");

        Condition S2CtAllNull = new Condition(S2, "Time_A2", TransitionCondition.IsNull);
        S2CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(S2, "P_A2", TransitionCondition.IsNull));
        S2CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(S2, "A2", TransitionCondition.IsNull));

        GuardMapping grdS2AllNull = new GuardMapping();
        grdS2AllNull.condition = S2CtAllNull;
        grdS2AllNull.Activations.add(new Activation(S2, "", TransitionOperation.DoNothing, ""));
        S2.GuardMappingList.add(grdS2AllNull);

        Condition S2Ct2a = new Condition(S2, "A2", TransitionCondition.NotNull);
        Condition S2Ct3a = new Condition(S2, "P_A2", TransitionCondition.IsNull);
        Condition S2Ct1a = new Condition(S2, "A2", TransitionCondition.Check_Transition_Target_List_NO, "t2_A2");

        S2Ct2a.SetNextCondition(LogicConnector.AND, S2Ct3a);
        S2Ct1a.SetNextCondition(LogicConnector.AND, S2Ct2a);

        GuardMapping grdS2a = new GuardMapping();
        grdS2a.condition = S2Ct2a;
        grdS2a.Activations.add(new Activation(S2, "Time_A2", TransitionOperation.SendOverNetwork, "OP_A2"));
        grdS2a.Activations.add(new Activation(S2, "A2", TransitionOperation.Move, "P_A2"));
        S2.GuardMappingList.add(grdS2a);

        Condition S2Ct1b = new Condition(S2, "A2", TransitionCondition.IsNull);
        Condition S2Ct2b = new Condition(S2, "P_A2", TransitionCondition.NotNull);
        Condition S2Ct3b = new Condition(S2, "P_A2", TransitionCondition.Check_Transition_Target_List, "t2_A2");

        S2Ct2b.SetNextCondition(LogicConnector.AND, S2Ct3b);
        S2Ct1b.SetNextCondition(LogicConnector.AND, S2Ct2b);

        GuardMapping grdS2b = new GuardMapping();
        grdS2b.condition = S2Ct2b;
        grdS2b.Activations.add(new Activation(S2, "P_A2", TransitionOperation.Move, "A2"));
        S2.GuardMappingList.add(grdS2b);

        S2.Delay = 0;
        pn.Transitions.add(S2);

        // t3_A2 ------------------------------------------------

        PetriTransition t3_A2 = new PetriTransition(pn);
        t3_A2.TransitionName = "t3_A2";
        t3_A2.InputPlaceName.add("i1");
        t3_A2.InputPlaceName.add("P_A2");

        // Handle case when input is null
        Condition t3_A2CtAllNull = new Condition(t3_A2, "i1", TransitionCondition.IsNull);
        t3_A2CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t3_A2, "P_A2", TransitionCondition.IsNull));

        GuardMapping grdt3_A2AllNull = new GuardMapping();
        grdt3_A2AllNull.condition = t3_A2CtAllNull;
        grdt3_A2AllNull.Activations.add(new Activation(t3_A2, "", TransitionOperation.DoNothing, ""));
        t3_A2.GuardMappingList.add(grdt3_A2AllNull);

        // Train leaving station
        Condition t3_A2Ct1a = new Condition(t3_A2, "i1", TransitionCondition.IsNull);
        Condition t3_A2Ct2a = new Condition(t3_A2, "P_A2", TransitionCondition.NotNull);
        Condition t3_A2Ct3a = new Condition(t3_A2, "P_A2", TransitionCondition.Check_Transition_Target_List_NO, "t2_A2");

        t3_A2Ct2a.SetNextCondition(LogicConnector.AND, t3_A2Ct3a);
        t3_A2Ct1a.SetNextCondition(LogicConnector.AND, t3_A2Ct2a);

        GuardMapping grdt3_A2a = new GuardMapping();
        grdt3_A2a.condition = t3_A2Ct2a;
        grdt3_A2a.Activations.add(new Activation(t3_A2, "P_A2", TransitionOperation.Move, "i1"));
        t3_A2.GuardMappingList.add(grdt3_A2a);

        // Train coming
        Condition t3_A2Ct1b = new Condition(t3_A2, "P_A2", TransitionCondition.IsNull);
        Condition t3_A2Ct2b = new Condition(t3_A2, "i1", TransitionCondition.NotNull);
        Condition t3_A2Ct3b = new Condition(t3_A2, "i1", TransitionCondition.Check_Transition_Target_List, "t2_A2");

        t3_A2Ct1b.SetNextCondition(LogicConnector.AND, t3_A2Ct3b);
        t3_A2Ct2b.SetNextCondition(LogicConnector.AND, t3_A2Ct1b);

        GuardMapping grdt3_A2b = new GuardMapping();
        grdt3_A2b.condition = t3_A2Ct1b;
        grdt3_A2b.Activations.add(new Activation(t3_A2, "i1", "A2_Length", "Zero", "Speed_On_Platform", TransitionOperation.CalculateTime, "Time"));
        grdt3_A2b.Activations.add(new Activation(t3_A2, "Time", TransitionOperation.SendOverNetwork, "OP_TimeA2"));
        grdt3_A2b.Activations.add(new Activation(t3_A2, "A2", TransitionOperation.SendOverNetwork, "OP_PA2"));
        grdt3_A2b.Activations.add(new Activation(t3_A2, "i1", TransitionOperation.Move, "P_A2"));
        t3_A2.GuardMappingList.add(grdt3_A2b);

        t3_A2.Delay = 0;
        pn.Transitions.add(t3_A2);

        /// PLATFORM A3

        // t1_A3 ------------------------------------------------

        PetriTransition t1_A3 = new PetriTransition(pn);
        t1_A3.TransitionName = "t1_A3";
        t1_A3.InputPlaceName.add("Train_A3");

        // Handle case when input is null
        Condition t1_A3CtAllNull = new Condition(t1_A3, "Train_A3", TransitionCondition.IsNull);

        GuardMapping grdt1_A3AllNull = new GuardMapping();
        grdt1_A3AllNull.condition = t1_A3CtAllNull;
        grdt1_A3AllNull.Activations.add(new Activation(t1_A3, "", TransitionOperation.DoNothing, ""));
        t1_A3.GuardMappingList.add(grdt1_A3AllNull);

        Condition t1_A3Ct1a = new Condition(t1_A3, "Train_A3", TransitionCondition.NotNull);
        Condition t1_A3Ct2a = new Condition(t1_A3, "A3", TransitionCondition.IsNull);

        t1_A3Ct1a.SetNextCondition(LogicConnector.AND, t1_A3Ct2a);

        GuardMapping grdt1_A3a = new GuardMapping();
        grdt1_A3a.condition = t1_A3Ct1a;
        grdt1_A3a.Activations.add(new Activation(t1_A3, "Train_A3", TransitionOperation.Move, "A3"));
        t1_A3.GuardMappingList.add(grdt1_A3a);

        t1_A3.Delay = 0;
        pn.Transitions.add(t1_A3);

        // t2_A3 ------------------------------------------------

        PetriTransition t2_A3 = new PetriTransition(pn);
        t2_A3.TransitionName = "t2_A3";
        t2_A3.InputPlaceName.add("A3");

        Condition t2_A3Ct1a = new Condition(t2_A3, "A3", TransitionCondition.NotNull);
        Condition t2_A3Ct2a = new Condition(t2_A3, "Exit_A3", TransitionCondition.IsNull);
        Condition t2_A3Ct3a = new Condition(t2_A3, "A3", TransitionCondition.Check_Transition_Target_List, "t2_A3");

        t2_A3Ct2a.SetNextCondition(LogicConnector.AND, t2_A3Ct3a);
        t2_A3Ct1a.SetNextCondition(LogicConnector.AND, t2_A3Ct2a);

        GuardMapping grdt2_A3a = new GuardMapping();
        grdt2_A3a.condition = t2_A3Ct1a;
        grdt2_A3a.Activations.add(new Activation(t2_A3, "A3", TransitionOperation.Move, "Exit_A3"));
        t2_A3.GuardMappingList.add(grdt2_A3a);

        t2_A3.Delay = 3; // Use the Delay constant
        pn.Transitions.add(t2_A3);

        // S3 ------------------------------------------------

        PetriTransition S3 = new PetriTransition(pn);
        S3.TransitionName = "S3";
        S3.InputPlaceName.add("Time_A3");
        S3.InputPlaceName.add("P_A3");
        S3.InputPlaceName.add("A3");

        Condition S3CtAllNull = new Condition(S3, "Time_A3", TransitionCondition.IsNull);
        S3CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(S3, "P_A3", TransitionCondition.IsNull));
        S3CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(S3, "A3", TransitionCondition.IsNull));

        GuardMapping grdS3AllNull = new GuardMapping();
        grdS3AllNull.condition = S3CtAllNull;
        grdS3AllNull.Activations.add(new Activation(S3, "", TransitionOperation.DoNothing, ""));
        S3.GuardMappingList.add(grdS3AllNull);

        Condition S3Ct2a = new Condition(S3, "A3", TransitionCondition.NotNull);
        Condition S3Ct3a = new Condition(S3, "P_A3", TransitionCondition.IsNull);
        Condition S3Ct1a = new Condition(S3, "A3", TransitionCondition.Check_Transition_Target_List_NO, "t2_A3");

        S3Ct2a.SetNextCondition(LogicConnector.AND, S3Ct3a);
        S3Ct1a.SetNextCondition(LogicConnector.AND, S3Ct2a);


        GuardMapping grdS3a = new GuardMapping();
        grdS3a.condition = S3Ct2a;
        grdS3a.Activations.add(new Activation(S3, "Time_A3", TransitionOperation.SendOverNetwork, "OP_A3"));
        grdS3a.Activations.add(new Activation(S3, "A3", TransitionOperation.Move, "P_A3"));
        S3.GuardMappingList.add(grdS3a);

        Condition S3Ct1b = new Condition(S3, "A3", TransitionCondition.IsNull);
        Condition S3Ct2b = new Condition(S3, "P_A3", TransitionCondition.NotNull);
        Condition S3Ct3b = new Condition(S3, "P_A3", TransitionCondition.Check_Transition_Target_List, "t2_A3");

        S3Ct2b.SetNextCondition(LogicConnector.AND, S3Ct3b);
        S3Ct1b.SetNextCondition(LogicConnector.AND, S3Ct2b);


        GuardMapping grdS3b = new GuardMapping();
        grdS3b.condition = S3Ct2b;
        grdS3b.Activations.add(new Activation(S3, "P_A3", TransitionOperation.Move, "A3"));
        S3.GuardMappingList.add(grdS3b);

        S3.Delay = 0;
        pn.Transitions.add(S3);

        // t3_A3 ------------------------------------------------

        PetriTransition t3_A3 = new PetriTransition(pn);
        t3_A3.TransitionName = "t3_A3";
        t3_A3.InputPlaceName.add("i2");
        t3_A3.InputPlaceName.add("P_A3");

        // Handle case when input is null
        Condition t3_A3CtAllNull = new Condition(t3_A3, "i2", TransitionCondition.IsNull);
        t3_A3CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t3_A3, "P_A3", TransitionCondition.IsNull));
//
        GuardMapping grdt3_A3AllNull = new GuardMapping();
        grdt3_A3AllNull.condition = t3_A3CtAllNull;
        grdt3_A3AllNull.Activations.add(new Activation(t3_A3, "", TransitionOperation.DoNothing, ""));
        t3_A3.GuardMappingList.add(grdt3_A3AllNull);

        // Train leaving station
        Condition t3_A3Ct1a = new Condition(t3_A3, "i2", TransitionCondition.IsNull);
        Condition t3_A3Ct2a = new Condition(t3_A3, "P_A3", TransitionCondition.NotNull);
        Condition t3_A3Ct3a = new Condition(t3_A3, "P_A3", TransitionCondition.Check_Transition_Target_List_NO, "t2_A3");

        t3_A3Ct2a.SetNextCondition(LogicConnector.AND, t3_A3Ct3a);
        t3_A3Ct1a.SetNextCondition(LogicConnector.AND, t3_A3Ct2a);


        GuardMapping grdt3_A3a = new GuardMapping();
        grdt3_A3a.condition = t3_A3Ct2a;
        grdt3_A3a.Activations.add(new Activation(t3_A3, "P_A3", TransitionOperation.Move, "i2"));
        t3_A3.GuardMappingList.add(grdt3_A3a);

        // Train coming
        Condition t3_A3Ct1b = new Condition(t3_A3, "P_A3", TransitionCondition.IsNull);
        Condition t3_A3Ct2b = new Condition(t3_A3, "i2", TransitionCondition.NotNull);
        Condition t3_A3Ct3b = new Condition(t3_A3, "i2", TransitionCondition.Check_Transition_Target_List, "t2_A3");

        t3_A3Ct1b.SetNextCondition(LogicConnector.AND, t3_A3Ct3b);
        t3_A3Ct2b.SetNextCondition(LogicConnector.AND, t3_A3Ct1b);


        GuardMapping grdt3_A3b = new GuardMapping();
        grdt3_A3b.condition = t3_A3Ct1b;
        grdt3_A3b.Activations.add(new Activation(t3_A3, "i2", "A3_Length", "Zero", "Speed_On_Platform", TransitionOperation.CalculateTime, "Time"));
        grdt3_A3b.Activations.add(new Activation(t3_A3, "Time", TransitionOperation.SendOverNetwork, "OP_TimeA3"));
        grdt3_A3b.Activations.add(new Activation(t3_A3, "A3", TransitionOperation.SendOverNetwork, "OP_PA3"));
        grdt3_A3b.Activations.add(new Activation(t3_A3, "i2", TransitionOperation.Move, "P_A3"));
        t3_A3.GuardMappingList.add(grdt3_A3b);

        t3_A3.Delay = 0;
        pn.Transitions.add(t3_A3);

        /// PLATFORM A4

// t4_A1 ------------------------------------------------

        PetriTransition t4_A1 = new PetriTransition(pn);
        t4_A1.TransitionName = "t4_A1";
        t4_A1.InputPlaceName.add("i1");
        t4_A1.InputPlaceName.add("i2");

        // Handle case when input is null
        Condition t4_A1CtAllNull = new Condition(t4_A1, "i1", TransitionCondition.IsNull);
        t4_A1CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t4_A1, "i2", TransitionCondition.IsNull));
//
        GuardMapping grdt4_A1AllNull = new GuardMapping();
        grdt4_A1AllNull.condition = t4_A1CtAllNull;
        grdt4_A1AllNull.Activations.add(new Activation(t4_A1, "", TransitionOperation.DoNothing, ""));
        t4_A1.GuardMappingList.add(grdt4_A1AllNull);

// Train leaving station
        Condition t4_A1Ct1a = new Condition(t4_A1, "i2", TransitionCondition.IsNull);
        Condition t4_A1Ct2a = new Condition(t4_A1, "i1", TransitionCondition.NotNull);
        Condition t4_A1Ct3a = new Condition(t4_A1, "i1", TransitionCondition.Check_Transition_Target_List_NO, "t2_A1");
        Condition t4_A1Ct4a = new Condition(t4_A1, "i1", TransitionCondition.Check_Transition_Target_List_NO, "t2_A2");

        t4_A1Ct3a.SetNextCondition(LogicConnector.OR, t4_A1Ct4a);
        t4_A1Ct2a.SetNextCondition(LogicConnector.AND, t4_A1Ct3a);
        t4_A1Ct1a.SetNextCondition(LogicConnector.AND, t4_A1Ct2a);

        GuardMapping grdt4_A1a = new GuardMapping();
        grdt4_A1a.condition = t4_A1Ct2a;
        grdt4_A1a.Activations.add(new Activation(t4_A1, "i1", TransitionOperation.Move, "i2"));
        t4_A1.GuardMappingList.add(grdt4_A1a);

// Train coming and having as target Platform A1
        Condition t4_A1Ct1b = new Condition(t4_A1, "i1", TransitionCondition.IsNull);
        Condition t4_A1Ct2b = new Condition(t4_A1, "i2", TransitionCondition.NotNull);
        Condition t4_A1Ct3b = new Condition(t4_A1, "i2", TransitionCondition.Platform, "A1");
        Condition t4_A1Ct4b = new Condition(t4_A1, "i2", TransitionCondition.Check_Transition_Target_List, "t2_A1");
        Condition t4_A1Ct5b = new Condition(t4_A1, "i2", TransitionCondition.Check_Transition_Target_List, "t2_A2");


        t4_A1Ct4b.SetNextCondition(LogicConnector.OR, t4_A1Ct5b);
        t4_A1Ct3b.SetNextCondition(LogicConnector.AND, t4_A1Ct4b);
        t4_A1Ct2b.SetNextCondition(LogicConnector.AND, t4_A1Ct3b);
        t4_A1Ct1b.SetNextCondition(LogicConnector.AND, t4_A1Ct2b);

        GuardMapping grdt4_A1b = new GuardMapping();
        grdt4_A1b.condition = t4_A1Ct1b;
        grdt4_A1b.Activations.add(new Activation(t4_A1, "i2", "A1_Length", "A4_Length", "Speed_On_Platform", TransitionOperation.CalculateTime, "Time"));
        grdt4_A1b.Activations.add(new Activation(t4_A1, "Time", TransitionOperation.SendOverNetwork, "OP_TimeA4"));
        grdt4_A1b.Activations.add(new Activation(t4_A1, "A4", TransitionOperation.SendOverNetwork, "OP_PA4"));
        grdt4_A1b.Activations.add(new Activation(t4_A1, "i2", TransitionOperation.Move, "i1"));
        t4_A1.GuardMappingList.add(grdt4_A1b);

// Train coming and having as target Platform A2
        Condition t4_A1Ct1c = new Condition(t4_A1, "i1", TransitionCondition.IsNull);
        Condition t4_A1Ct2c = new Condition(t4_A1, "i2", TransitionCondition.NotNull);
        Condition t4_A1Ct3c = new Condition(t4_A1, "i2", TransitionCondition.Platform, "A2");
        Condition t4_A1Ct4c = new Condition(t4_A1, "i2", TransitionCondition.Check_Transition_Target_List, "t2_A1");
        Condition t4_A1Ct5c = new Condition(t4_A1, "i2", TransitionCondition.Check_Transition_Target_List, "t2_A2");


        t4_A1Ct4c.SetNextCondition(LogicConnector.OR, t4_A1Ct5c);
        t4_A1Ct3c.SetNextCondition(LogicConnector.AND, t4_A1Ct4c);
        t4_A1Ct2c.SetNextCondition(LogicConnector.AND, t4_A1Ct3c);
        t4_A1Ct1c.SetNextCondition(LogicConnector.AND, t4_A1Ct2c);

        GuardMapping grdt4_A1c = new GuardMapping();
        grdt4_A1c.condition = t4_A1Ct2c;
        grdt4_A1c.Activations.add(new Activation(t4_A1, "i2", "A2_Length", "A4_Length", "Speed_On_Platform", TransitionOperation.CalculateTime, "Time"));
        grdt4_A1c.Activations.add(new Activation(t4_A1, "Time", TransitionOperation.SendOverNetwork, "OP_TimeA4"));
        grdt4_A1c.Activations.add(new Activation(t4_A1, "A4", TransitionOperation.SendOverNetwork, "OP_PA4"));
        grdt4_A1c.Activations.add(new Activation(t4_A1, "i2", TransitionOperation.Move, "i1"));
        t4_A1.GuardMappingList.add(grdt4_A1c);

        t4_A1.Delay = 0;
        pn.Transitions.add(t4_A1);

// t4_A2 ------------------------------------------------

        PetriTransition t4_A2 = new PetriTransition(pn);
        t4_A2.TransitionName = "t4_A2";
        t4_A2.InputPlaceName.add("i2");

        // Handle case when input is null
        Condition t4_A2CtAllNull = new Condition(t4_A2, "i2", TransitionCondition.IsNull);

        GuardMapping grdt4_A2AllNull = new GuardMapping();
        grdt4_A2AllNull.condition = t4_A2CtAllNull;
        grdt4_A2AllNull.Activations.add(new Activation(t4_A2, "", TransitionOperation.DoNothing, ""));
        t4_A2.GuardMappingList.add(grdt4_A2AllNull);

        // leaving train
        Condition t4_A2Ct1a = new Condition(t4_A2, "i2", TransitionCondition.NotNull);
        Condition t4_A2Ct2a = new Condition(t4_A2, "i2", TransitionCondition.Check_Transition_Target_List_NO, "t2_A1");
        Condition t4_A2Ct3a = new Condition(t4_A2, "i2", TransitionCondition.Check_Transition_Target_List_NO, "t2_A2");
        Condition t4_A2Ct4a = new Condition(t4_A2, "i2", TransitionCondition.Check_Transition_Target_List_NO, "t2_A3");

        t4_A2Ct2a.SetNextCondition(LogicConnector.OR, t4_A2Ct3a);
        t4_A2Ct3a.SetNextCondition(LogicConnector.OR, t4_A2Ct4a);
        t4_A2Ct1a.SetNextCondition(LogicConnector.AND, t4_A2Ct2a);


        GuardMapping grdt4_A2a = new GuardMapping();
        grdt4_A2a.condition = t4_A2Ct1a;
        grdt4_A2a.Activations.add(new Activation(t4_A2, "i2", TransitionOperation.SendOverNetwork, "OP_i2"));
        grdt4_A2a.Activations.add(new Activation(t4_A2, "i2", TransitionOperation.MakeNull, "i2"));
        t4_A2.GuardMappingList.add(grdt4_A2a);

        t4_A2.Delay = 0;
        pn.Transitions.add(t4_A2);



        System.out.println("Station A started \n ------------------------------");
        pn.Delay = 3000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.setTitle("Station A");
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
