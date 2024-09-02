package THESIS.Stations;

import Components.*;
import DataObjects.*;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Station_C {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Station C";
        pn.SetName("Station C");

        pn.NetworkPort = 1090;

        DataTrain p1 = new DataTrain();
        p1.SetName("Train_C1");
        pn.PlaceList.add(p1);

        DataTrain p2 = new DataTrain();
        p2.SetName("Train_C2");
        pn.PlaceList.add(p2);

        DataTrain p3 = new DataTrain();
        p3.SetName("Train_C3");
        pn.PlaceList.add(p3);

        DataTrain p4 = new DataTrain();
        p4.SetName("Exit_C1");
        pn.PlaceList.add(p4);

        DataTrain p5 = new DataTrain();
        p5.SetName("Exit_C2");
        pn.PlaceList.add(p5);

        DataTrain p6 = new DataTrain();
        p6.SetName("Exit_C3");
        pn.PlaceList.add(p6);

        DataTrain p7 = new DataTrain();
        p7.SetName("C1");
        pn.PlaceList.add(p7);

        DataTrain p8 = new DataTrain();
        p8.SetName("C2");
        pn.PlaceList.add(p8);

        DataTrain p9 = new DataTrain();
        p9.SetName("C3");
        pn.PlaceList.add(p9);

        DataTrain p10 = new DataTrain();
        p10.SetName("P_C1");
        pn.PlaceList.add(p10);

        DataTrain p11 = new DataTrain();
        p11.SetName("P_C2");
        pn.PlaceList.add(p11);

        DataTrain p12 = new DataTrain();
        p12.SetName("P_C3");
        pn.PlaceList.add(p12);

        DataTrain p13 = new DataTrain();
        p13.SetName("i9");
        pn.PlaceList.add(p13);

        DataTrain p14 = new DataTrain();
        p14.SetName("i8");
        pn.PlaceList.add(p14);

        DataListTrains Time_C1 = new DataListTrains();
        Time_C1.SetName("Time_C1");
        pn.PlaceList.add(Time_C1);

        DataListTrains Time_C2 = new DataListTrains();
        Time_C2.SetName("Time_C2");
        pn.PlaceList.add(Time_C2);

        DataListTrains Time_C3 = new DataListTrains();
        Time_C3.SetName("Time_C3");
        pn.PlaceList.add(Time_C3);

        DataTransfer OP_C1 = new DataTransfer();
        OP_C1.SetName("OP_C1");
        OP_C1.Value = new TransferOperation("localhost", "1088", "in_C1");
        pn.PlaceList.add(OP_C1);

        DataTransfer OP_C2 = new DataTransfer();
        OP_C2.SetName("OP_C2");
        OP_C2.Value = new TransferOperation("localhost", "1088", "in_C2");
        pn.PlaceList.add(OP_C2);

        DataTransfer OP_C3 = new DataTransfer();
        OP_C3.SetName("OP_C3");
        OP_C3.Value = new TransferOperation("localhost", "1088", "in_C3");
        pn.PlaceList.add(OP_C3);

        DataTransfer OP_i8 = new DataTransfer();
        OP_i8.SetName("OP_i8");
        OP_i8.Value = new TransferOperation("localhost", "1083", "inC");
        pn.PlaceList.add(OP_i8);

        DataTransfer OP_PC1 = new DataTransfer();
        OP_PC1.SetName("OP_PC1");
        OP_PC1.Value = new TransferOperation("localhost", "1092", "C_PC1");
        pn.PlaceList.add(OP_PC1);

        DataTransfer OP_PC2 = new DataTransfer();
        OP_PC2.SetName("OP_PC2");
        OP_PC2.Value = new TransferOperation("localhost", "1092", "C_PC2");
        pn.PlaceList.add(OP_PC2);

        DataTransfer OP_PC3 = new DataTransfer();
        OP_PC3.SetName("OP_PC3");
        OP_PC3.Value = new TransferOperation("localhost", "1092", "C_PC3");
        pn.PlaceList.add(OP_PC3);

        DataTransfer OP_PC4 = new DataTransfer();
        OP_PC4.SetName("OP_PC4");
        OP_PC4.Value = new TransferOperation("localhost", "1092", "C_PC4");
        pn.PlaceList.add(OP_PC4);

        DataTransfer OP_TimeC1 = new DataTransfer();
        OP_TimeC1.SetName("OP_TimeC1");
        OP_TimeC1.Value = new TransferOperation("localhost", "1092", "C_TimeC1");
        pn.PlaceList.add(OP_TimeC1);

        DataTransfer OP_TimeC2 = new DataTransfer();
        OP_TimeC2.SetName("OP_TimeC2");
        OP_TimeC2.Value = new TransferOperation("localhost", "1092", "C_TimeC2");
        pn.PlaceList.add(OP_TimeC2);

        DataTransfer OP_TimeC3 = new DataTransfer();
        OP_TimeC3.SetName("OP_TimeC3");
        OP_TimeC3.Value = new TransferOperation("localhost", "1092", "C_TimeC3");
        pn.PlaceList.add(OP_TimeC3);

        DataTransfer OP_TimeC4 = new DataTransfer();
        OP_TimeC4.SetName("OP_TimeC4");
        OP_TimeC4.Value = new TransferOperation("localhost", "1092", "C_TimeC4");
        pn.PlaceList.add(OP_TimeC4);

        DataString C1 = new DataString();
        C1.SetName("C1");
        C1.SetValue("C1");
        pn.ConstantPlaceList.add(C1);

        DataString C2 = new DataString();
        C2.SetName("C2");
        C2.SetValue("C2");
        pn.ConstantPlaceList.add(C2);

        DataString C3 = new DataString();
        C3.SetName("C3");
        C3.SetValue("C3");
        pn.ConstantPlaceList.add(C3);

        DataString C4 = new DataString();
        C4.SetName("C4");
        C4.SetValue("C4");
        pn.ConstantPlaceList.add(C4);

        DataInteger Zero = new DataInteger();
        Zero.SetName("Zero");
        Zero.SetValue(0);
        pn.ConstantPlaceList.add(Zero);

        DataInteger C1_Length = new DataInteger();
        C1_Length.SetName("C1_Length");
        C1_Length.SetValue(78);
        pn.ConstantPlaceList.add(C1_Length);

        DataInteger C2_Length = new DataInteger();
        C2_Length.SetName("C2_Length");
        C2_Length.SetValue(85);
        pn.ConstantPlaceList.add(C2_Length);

        DataInteger C3_Length = new DataInteger();
        C3_Length.SetName("C3_Length");
        C3_Length.SetValue(96);
        pn.ConstantPlaceList.add(C3_Length);

        DataInteger C4_Length = new DataInteger();
        C4_Length.SetName("C4_Length");
        C4_Length.SetValue(58);
        pn.ConstantPlaceList.add(C4_Length);

        DataInteger speed_on_platform = new DataInteger();
        speed_on_platform.SetName("Speed_On_Platform");
        speed_on_platform.SetValue(5);
        pn.ConstantPlaceList.add(speed_on_platform);

        DataInteger Delay = new DataInteger();
        Delay.SetName("Delay");
        Delay.SetValue(3);
        pn.ConstantPlaceList.add(Delay);

        DataLocalTime time = new DataLocalTime();
        time.SetName("Time");
        time.SetValue(null);
        pn.ConstantPlaceList.add(time);

        // t1_C1 ------------------------------------------------

        PetriTransition t1_C1 = new PetriTransition(pn);
        t1_C1.TransitionName = "t1_C1";
        t1_C1.InputPlaceName.add("Train_C1");

        // Handle case when input is null
        Condition t1_C1CtAllNull = new Condition(t1_C1, "Train_C1", TransitionCondition.IsNull);

        GuardMapping grdt1_C1AllNull = new GuardMapping();
        grdt1_C1AllNull.condition = t1_C1CtAllNull;
        grdt1_C1AllNull.Activations.add(new Activation(t1_C1, "", TransitionOperation.DoNothing, ""));
        t1_C1.GuardMappingList.add(grdt1_C1AllNull);

        Condition t1_C1Ct1a = new Condition(t1_C1, "Train_C1", TransitionCondition.NotNull);
        Condition t1_C1Ct2a = new Condition(t1_C1, "C1", TransitionCondition.IsNull);

        t1_C1Ct1a.SetNextCondition(LogicConnector.AND, t1_C1Ct2a);

        GuardMapping grdt1_C1a = new GuardMapping();
        grdt1_C1a.condition = t1_C1Ct1a;
        grdt1_C1a.Activations.add(new Activation(t1_C1, "Train_C1", TransitionOperation.Move, "C1"));
        t1_C1.GuardMappingList.add(grdt1_C1a);

        t1_C1.Delay = 0;
        pn.Transitions.add(t1_C1);

        // t2_C1 ------------------------------------------------

        PetriTransition t2_C1 = new PetriTransition(pn);
        t2_C1.TransitionName = "t2_C1";
        t2_C1.InputPlaceName.add("C1");

        Condition t2_C1Ct1a = new Condition(t2_C1, "C1", TransitionCondition.NotNull);
        Condition t2_C1Ct2a = new Condition(t2_C1, "Exit_C1", TransitionCondition.IsNull);
        Condition t2_C1Ct3a = new Condition(t2_C1, "C1", TransitionCondition.Check_Transition_Target_List, "t2_C1");

        t2_C1Ct2a.SetNextCondition(LogicConnector.AND, t2_C1Ct3a);
        t2_C1Ct1a.SetNextCondition(LogicConnector.AND, t2_C1Ct2a);

        GuardMapping grdt2_C1a = new GuardMapping();
        grdt2_C1a.condition = t2_C1Ct1a;
        grdt2_C1a.Activations.add(new Activation(t2_C1, "C1", TransitionOperation.Move, "Exit_C1"));
        t2_C1.GuardMappingList.add(grdt2_C1a);

        t2_C1.Delay = 3; // Use the Delay constant
        pn.Transitions.add(t2_C1);

        // S13 ------------------------------------------------

        PetriTransition S13 = new PetriTransition(pn);
        S13.TransitionName = "S13";
        S13.InputPlaceName.add("Time_C1");
        S13.InputPlaceName.add("P_C1");
        S13.InputPlaceName.add("C1");

        Condition S13CtAllNull = new Condition(S13, "Time_C1", TransitionCondition.IsNull);
        S13CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(S13, "P_C1", TransitionCondition.IsNull));
        S13CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(S13, "C1", TransitionCondition.IsNull));

        GuardMapping grdS13AllNull = new GuardMapping();
        grdS13AllNull.condition = S13CtAllNull;
        grdS13AllNull.Activations.add(new Activation(S13, "", TransitionOperation.DoNothing, ""));
        S13.GuardMappingList.add(grdS13AllNull);

        Condition S13Ct2a = new Condition(S13, "C1", TransitionCondition.NotNull);
        Condition S13Ct3a = new Condition(S13, "P_C1", TransitionCondition.IsNull);

        S13Ct2a.SetNextCondition(LogicConnector.AND, S13Ct3a);

        GuardMapping grdS13a = new GuardMapping();
        grdS13a.condition = S13Ct2a;
        grdS13a.Activations.add(new Activation(S13, "Time_C1", TransitionOperation.SendOverNetwork, "OP_C1"));
        grdS13a.Activations.add(new Activation(S13, "C1", TransitionOperation.Move, "P_C1"));
        S13.GuardMappingList.add(grdS13a);

        Condition S13Ct2b = new Condition(S13, "C1", TransitionCondition.IsNull);
        Condition S13Ct3b = new Condition(S13, "P_C1", TransitionCondition.NotNull);

        S13Ct2b.SetNextCondition(LogicConnector.AND, S13Ct3b);

        GuardMapping grdS13b = new GuardMapping();
        grdS13b.condition = S13Ct2b;
        grdS13b.Activations.add(new Activation(S13, "P_C1", TransitionOperation.Move, "C1"));
        S13.GuardMappingList.add(grdS13b);

        S13.Delay = 0;
        pn.Transitions.add(S13);

        // t3_C1 ------------------------------------------------

        PetriTransition t3_C1 = new PetriTransition(pn);
        t3_C1.TransitionName = "t3_C1";
        t3_C1.InputPlaceName.add("i9");
        t3_C1.InputPlaceName.add("P_C1");

        // Handle case when input is null
        Condition t3_C1CtAllNull = new Condition(t3_C1, "i9", TransitionCondition.IsNull);
        t3_C1CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t3_C1, "P_C1", TransitionCondition.IsNull));

        GuardMapping grdt3_C1AllNull = new GuardMapping();
        grdt3_C1AllNull.condition = t3_C1CtAllNull;
        grdt3_C1AllNull.Activations.add(new Activation(t3_C1, "", TransitionOperation.DoNothing, ""));
        t3_C1.GuardMappingList.add(grdt3_C1AllNull);

        // Train leaving station
        Condition t3_C1Ct2a = new Condition(t3_C1, "i9", TransitionCondition.IsNull);
        Condition t3_C1Ct3a = new Condition(t3_C1, "P_C1", TransitionCondition.NotNull);

        t3_C1Ct2a.SetNextCondition(LogicConnector.AND, t3_C1Ct3a);

        GuardMapping grdt3_C1a = new GuardMapping();
        grdt3_C1a.condition = t3_C1Ct2a;
        grdt3_C1a.Activations.add(new Activation(t3_C1, "P_C1", TransitionOperation.Move, "i9"));
        t3_C1.GuardMappingList.add(grdt3_C1a);

        // Train coming
        Condition t3_C1Ct1b = new Condition(t3_C1, "P_C1", TransitionCondition.IsNull);
        Condition t3_C1Ct2b = new Condition(t3_C1, "i9", TransitionCondition.NotNull); // HaveTrainForMe

        t3_C1Ct2b.SetNextCondition(LogicConnector.AND, t3_C1Ct1b);

        GuardMapping grdt3_C1b = new GuardMapping();
        grdt3_C1b.condition = t3_C1Ct1b;
        grdt3_C1b.Activations.add(new Activation(t3_C1, "i9", "C1_Length", "Zero", "Speed_On_Platform", TransitionOperation.CalculateTime, "Time"));
        grdt3_C1b.Activations.add(new Activation(t3_C1, "Time", TransitionOperation.SendOverNetwork, "OP_TimeC1"));
        grdt3_C1b.Activations.add(new Activation(t3_C1, "C1", TransitionOperation.SendOverNetwork, "OP_PC1"));
        grdt3_C1b.Activations.add(new Activation(t3_C1, "i9", TransitionOperation.Move, "P_C1"));
        t3_C1.GuardMappingList.add(grdt3_C1b);

        t3_C1.Delay = 0;
        pn.Transitions.add(t3_C1);

        /// PLATFORM C2

        // t1_C2 ------------------------------------------------

        PetriTransition t1_C2 = new PetriTransition(pn);
        t1_C2.TransitionName = "t1_C2";
        t1_C2.InputPlaceName.add("Train_C2");

        // Handle case when input is null
        Condition t1_C2CtAllNull = new Condition(t1_C2, "Train_C2", TransitionCondition.IsNull);

        GuardMapping grdt1_C2AllNull = new GuardMapping();
        grdt1_C2AllNull.condition = t1_C2CtAllNull;
        grdt1_C2AllNull.Activations.add(new Activation(t1_C2, "", TransitionOperation.DoNothing, ""));
        t1_C2.GuardMappingList.add(grdt1_C2AllNull);

        Condition t1_C2Ct1a = new Condition(t1_C2, "Train_C2", TransitionCondition.NotNull);
        Condition t1_C2Ct2a = new Condition(t1_C2, "C2", TransitionCondition.IsNull);

        t1_C2Ct1a.SetNextCondition(LogicConnector.AND, t1_C2Ct2a);

        GuardMapping grdt1_C2a = new GuardMapping();
        grdt1_C2a.condition = t1_C2Ct1a;
        grdt1_C2a.Activations.add(new Activation(t1_C2, "Train_C2", TransitionOperation.Move, "C2"));
        t1_C2.GuardMappingList.add(grdt1_C2a);

        t1_C2.Delay = 0;
        pn.Transitions.add(t1_C2);

        // t2_C2 ------------------------------------------------

        PetriTransition t2_C2 = new PetriTransition(pn);
        t2_C2.TransitionName = "t2_C2";
        t2_C2.InputPlaceName.add("C2");

        Condition t2_C2Ct1a = new Condition(t2_C2, "C2", TransitionCondition.NotNull);
        Condition t2_C2Ct2a = new Condition(t2_C2, "Exit_C2", TransitionCondition.IsNull);
        Condition t2_C2Ct3a = new Condition(t2_C2, "C2", TransitionCondition.Check_Transition_Target_List, "t2_C2");

        t2_C2Ct2a.SetNextCondition(LogicConnector.AND, t2_C2Ct3a);
        t2_C2Ct1a.SetNextCondition(LogicConnector.AND, t2_C2Ct2a);

        GuardMapping grdt2_C2a = new GuardMapping();
        grdt2_C2a.condition = t2_C2Ct1a;
        grdt2_C2a.Activations.add(new Activation(t2_C2, "C2", TransitionOperation.Move, "Exit_C2"));
        t2_C2.GuardMappingList.add(grdt2_C2a);

        t2_C2.Delay = 3; // Use the Delay constant
        pn.Transitions.add(t2_C2);

        // S14 ------------------------------------------------

        PetriTransition S14 = new PetriTransition(pn);
        S14.TransitionName = "S14";
        S14.InputPlaceName.add("Time_C2");
        S14.InputPlaceName.add("P_C2");
        S14.InputPlaceName.add("C2");

        Condition S14CtAllNull = new Condition(S14, "Time_C2", TransitionCondition.IsNull);
        S14CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(S14, "P_C2", TransitionCondition.IsNull));
        S14CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(S14, "C2", TransitionCondition.IsNull));

        GuardMapping grdS14AllNull = new GuardMapping();
        grdS14AllNull.condition = S14CtAllNull;
        grdS14AllNull.Activations.add(new Activation(S14, "", TransitionOperation.DoNothing, ""));
        S14.GuardMappingList.add(grdS14AllNull);

        Condition S14Ct2a = new Condition(S14, "C2", TransitionCondition.NotNull);
        Condition S14Ct3a = new Condition(S14, "P_C2", TransitionCondition.IsNull);

        S14Ct2a.SetNextCondition(LogicConnector.AND, S14Ct3a);

        GuardMapping grdS14a = new GuardMapping();
        grdS14a.condition = S14Ct2a;
        grdS14a.Activations.add(new Activation(S14, "Time_C2", TransitionOperation.SendOverNetwork, "OP_C2"));
        grdS14a.Activations.add(new Activation(S14, "C2", TransitionOperation.Move, "P_C2"));
        S14.GuardMappingList.add(grdS14a);

        Condition S14Ct2b = new Condition(S14, "C2", TransitionCondition.IsNull);
        Condition S14Ct3b = new Condition(S14, "P_C2", TransitionCondition.NotNull);

        S14Ct2b.SetNextCondition(LogicConnector.AND, S14Ct3b);

        GuardMapping grdS14b = new GuardMapping();
        grdS14b.condition = S14Ct2b;
        grdS14b.Activations.add(new Activation(S14, "P_C2", TransitionOperation.Move, "C2"));
        S14.GuardMappingList.add(grdS14b);

        S14.Delay = 0;
        pn.Transitions.add(S14);

        // t3_C2 ------------------------------------------------

        PetriTransition t3_C2 = new PetriTransition(pn);
        t3_C2.TransitionName = "t3_C2";
        t3_C2.InputPlaceName.add("i9");
        t3_C2.InputPlaceName.add("P_C2");

        // Handle case when input is null
        Condition t3_C2CtAllNull = new Condition(t3_C2, "i9", TransitionCondition.IsNull);
        t3_C2CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t3_C2, "P_C2", TransitionCondition.IsNull));

        GuardMapping grdt3_C2AllNull = new GuardMapping();
        grdt3_C2AllNull.condition = t3_C2CtAllNull;
        grdt3_C2AllNull.Activations.add(new Activation(t3_C2, "", TransitionOperation.DoNothing, ""));
        t3_C2.GuardMappingList.add(grdt3_C2AllNull);

        // Train leaving station
        Condition t3_C2Ct2a = new Condition(t3_C2, "i9", TransitionCondition.IsNull);
        Condition t3_C2Ct3a = new Condition(t3_C2, "P_C2", TransitionCondition.NotNull);

        t3_C2Ct2a.SetNextCondition(LogicConnector.AND, t3_C2Ct3a);

        GuardMapping grdt3_C2a = new GuardMapping();
        grdt3_C2a.condition = t3_C2Ct2a;
        grdt3_C2a.Activations.add(new Activation(t3_C2, "P_C2", TransitionOperation.Move, "i9"));
        t3_C2.GuardMappingList.add(grdt3_C2a);

        // Train coming
        Condition t3_C2Ct1b = new Condition(t3_C2, "P_C2", TransitionCondition.IsNull);
        Condition t3_C2Ct2b = new Condition(t3_C2, "i9", TransitionCondition.NotNull);

        t3_C2Ct2b.SetNextCondition(LogicConnector.AND, t3_C2Ct1b);

        GuardMapping grdt3_C2b = new GuardMapping();
        grdt3_C2b.condition = t3_C2Ct1b;
        grdt3_C2b.Activations.add(new Activation(t3_C2, "i9", "C2_Length", "Zero", "Speed_On_Platform", TransitionOperation.CalculateTime, "Time"));
        grdt3_C2b.Activations.add(new Activation(t3_C2, "Time", TransitionOperation.SendOverNetwork, "OP_TimeC2"));
        grdt3_C2b.Activations.add(new Activation(t3_C2, "C2", TransitionOperation.SendOverNetwork, "OP_PC2"));
        grdt3_C2b.Activations.add(new Activation(t3_C2, "i9", TransitionOperation.Move, "P_C2"));
        t3_C2.GuardMappingList.add(grdt3_C2b);

        t3_C2.Delay = 0;
        pn.Transitions.add(t3_C2);

        /// PLATFORM C3

        // t1_C3 ------------------------------------------------

        PetriTransition t1_C3 = new PetriTransition(pn);
        t1_C3.TransitionName = "t1_C3";
        t1_C3.InputPlaceName.add("Train_C3");

        // Handle case when input is null
        Condition t1_C3CtAllNull = new Condition(t1_C3, "Train_C3", TransitionCondition.IsNull);

        GuardMapping grdt1_C3AllNull = new GuardMapping();
        grdt1_C3AllNull.condition = t1_C3CtAllNull;
        grdt1_C3AllNull.Activations.add(new Activation(t1_C3, "", TransitionOperation.DoNothing, ""));
        t1_C3.GuardMappingList.add(grdt1_C3AllNull);

        Condition t1_C3Ct1a = new Condition(t1_C3, "Train_C3", TransitionCondition.NotNull);
        Condition t1_C3Ct2a = new Condition(t1_C3, "C3", TransitionCondition.IsNull);

        t1_C3Ct1a.SetNextCondition(LogicConnector.AND, t1_C3Ct2a);

        GuardMapping grdt1_C3a = new GuardMapping();
        grdt1_C3a.condition = t1_C3Ct1a;
        grdt1_C3a.Activations.add(new Activation(t1_C3, "Train_C3", TransitionOperation.Move, "C3"));
        t1_C3.GuardMappingList.add(grdt1_C3a);

        t1_C3.Delay = 0;
        pn.Transitions.add(t1_C3);

        // t2_C3 ------------------------------------------------

        PetriTransition t2_C3 = new PetriTransition(pn);
        t2_C3.TransitionName = "t2_C3";
        t2_C3.InputPlaceName.add("C3");

        Condition t2_C3Ct1a = new Condition(t2_C3, "C3", TransitionCondition.NotNull);
        Condition t2_C3Ct2a = new Condition(t2_C3, "Exit_C3", TransitionCondition.IsNull);
        Condition t2_C3Ct3a = new Condition(t2_C3, "C3", TransitionCondition.Check_Transition_Target_List, "t2_C3");

        t2_C3Ct2a.SetNextCondition(LogicConnector.AND, t2_C3Ct3a);
        t2_C3Ct1a.SetNextCondition(LogicConnector.AND, t2_C3Ct2a);

        GuardMapping grdt2_C3a = new GuardMapping();
        grdt2_C3a.condition = t2_C3Ct1a;
        grdt2_C3a.Activations.add(new Activation(t2_C3, "C3", TransitionOperation.Move, "Exit_C3"));
        t2_C3.GuardMappingList.add(grdt2_C3a);

        t2_C3.Delay = 3; // Use the Delay constant
        pn.Transitions.add(t2_C3);

        // S15 ------------------------------------------------

        PetriTransition S15 = new PetriTransition(pn);
        S15.TransitionName = "S15";
        S15.InputPlaceName.add("Time_C3");
        S15.InputPlaceName.add("P_C3");
        S15.InputPlaceName.add("C3");

        Condition S15CtAllNull = new Condition(S15, "Time_C3", TransitionCondition.IsNull);
        S15CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(S15, "P_C3", TransitionCondition.IsNull));
        S15CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(S15, "C3", TransitionCondition.IsNull));

        GuardMapping grdS15AllNull = new GuardMapping();
        grdS15AllNull.condition = S15CtAllNull;
        grdS15AllNull.Activations.add(new Activation(S15, "", TransitionOperation.DoNothing, ""));
        S15.GuardMappingList.add(grdS15AllNull);

        Condition S15Ct2a = new Condition(S15, "C3", TransitionCondition.NotNull);
        Condition S15Ct3a = new Condition(S15, "P_C3", TransitionCondition.IsNull);

        S15Ct2a.SetNextCondition(LogicConnector.AND, S15Ct3a);

        GuardMapping grdS15a = new GuardMapping();
        grdS15a.condition = S15Ct2a;
        grdS15a.Activations.add(new Activation(S15, "Time_C3", TransitionOperation.SendOverNetwork, "OP_C3"));
        grdS15a.Activations.add(new Activation(S15, "C3", TransitionOperation.Move, "P_C3"));
        S15.GuardMappingList.add(grdS15a);

        Condition S15Ct2b = new Condition(S15, "C3", TransitionCondition.IsNull);
        Condition S15Ct3b = new Condition(S15, "P_C3", TransitionCondition.NotNull);

        S15Ct2b.SetNextCondition(LogicConnector.AND, S15Ct3b);

        GuardMapping grdS15b = new GuardMapping();
        grdS15b.condition = S15Ct2b;
        grdS15b.Activations.add(new Activation(S15, "P_C3", TransitionOperation.Move, "C3"));
        S15.GuardMappingList.add(grdS15b);

        S15.Delay = 0;
        pn.Transitions.add(S15);

        // t3_C3 ------------------------------------------------

        PetriTransition t3_C3 = new PetriTransition(pn);
        t3_C3.TransitionName = "t3_C3";
        t3_C3.InputPlaceName.add("i8");
        t3_C3.InputPlaceName.add("P_C3");

        // Handle case when input is null
        Condition t3_C3CtAllNull = new Condition(t3_C3, "i8", TransitionCondition.IsNull);
        t3_C3CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t3_C3, "P_C3", TransitionCondition.IsNull));

        GuardMapping grdt3_C3AllNull = new GuardMapping();
        grdt3_C3AllNull.condition = t3_C3CtAllNull;
        grdt3_C3AllNull.Activations.add(new Activation(t3_C3, "", TransitionOperation.DoNothing, ""));
        t3_C3.GuardMappingList.add(grdt3_C3AllNull);

        // Train leaving station
        Condition t3_C3Ct2a = new Condition(t3_C3, "i8", TransitionCondition.IsNull);
        Condition t3_C3Ct3a = new Condition(t3_C3, "P_C3", TransitionCondition.NotNull);

        t3_C3Ct2a.SetNextCondition(LogicConnector.AND, t3_C3Ct3a);

        GuardMapping grdt3_C3a = new GuardMapping();
        grdt3_C3a.condition = t3_C3Ct2a;
        grdt3_C3a.Activations.add(new Activation(t3_C3, "P_C3", TransitionOperation.Move, "i8"));
        t3_C3.GuardMappingList.add(grdt3_C3a);

        // Train coming
        Condition t3_C3Ct1b = new Condition(t3_C3, "P_C3", TransitionCondition.IsNull);
        Condition t3_C3Ct2b = new Condition(t3_C3, "i8", TransitionCondition.NotNull);

        t3_C3Ct2b.SetNextCondition(LogicConnector.AND, t3_C3Ct1b);

        GuardMapping grdt3_C3b = new GuardMapping();
        grdt3_C3b.condition = t3_C3Ct1b;
        grdt3_C3b.Activations.add(new Activation(t3_C3, "i8", "C3_Length", "Zero", "Speed_On_Platform", TransitionOperation.CalculateTime, "Time"));
        grdt3_C3b.Activations.add(new Activation(t3_C3, "Time", TransitionOperation.SendOverNetwork, "OP_TimeC3"));
        grdt3_C3b.Activations.add(new Activation(t3_C3, "C3", TransitionOperation.SendOverNetwork, "OP_PC3"));
        grdt3_C3b.Activations.add(new Activation(t3_C3, "i8", TransitionOperation.Move, "P_C3"));
        t3_C3.GuardMappingList.add(grdt3_C3b);

        t3_C3.Delay = 0;
        pn.Transitions.add(t3_C3);

        /// PLATFORM C4

        // t4_C1 ------------------------------------------------

        PetriTransition t4_C1 = new PetriTransition(pn);
        t4_C1.TransitionName = "t4_C1";
        t4_C1.InputPlaceName.add("i9");
        t4_C1.InputPlaceName.add("i8");

        // Handle case when input is null
        Condition t4_C1CtAllNull = new Condition(t4_C1, "i9", TransitionCondition.IsNull);
        t4_C1CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t4_C1, "i8", TransitionCondition.IsNull));

        GuardMapping grdt4_C1AllNull = new GuardMapping();
        grdt4_C1AllNull.condition = t4_C1CtAllNull;
        grdt4_C1AllNull.Activations.add(new Activation(t4_C1, "", TransitionOperation.DoNothing, ""));
        t4_C1.GuardMappingList.add(grdt4_C1AllNull);

        // Train leaving station
        Condition t4_C1Ct2a = new Condition(t4_C1, "i8", TransitionCondition.IsNull);
        Condition t4_C1Ct4a = new Condition(t4_C1, "i9", TransitionCondition.NotNull);

        t4_C1Ct2a.SetNextCondition(LogicConnector.AND, t4_C1Ct4a);

        GuardMapping grdt4_C1a = new GuardMapping();
        grdt4_C1a.condition = t4_C1Ct2a;
        grdt4_C1a.Activations.add(new Activation(t4_C1, "i9", TransitionOperation.Move, "i8"));
        t4_C1.GuardMappingList.add(grdt4_C1a);

        // Train coming and having as target Platform C1
        Condition t4_C1Ct1b = new Condition(t4_C1, "i9", TransitionCondition.IsNull);
        Condition t4_C1Ct2b = new Condition(t4_C1, "i8", TransitionCondition.NotNull);
        Condition t4_C1Ct3b = new Condition(t4_C1, "i8", TransitionCondition.Platform, "C1");

        t4_C1Ct3b.SetNextCondition(LogicConnector.AND, t4_C1Ct2b);
        t4_C1Ct2b.SetNextCondition(LogicConnector.AND, t4_C1Ct1b);

        GuardMapping grdt4_C1b = new GuardMapping();
        grdt4_C1b.condition = t4_C1Ct1b;
        grdt4_C1b.Activations.add(new Activation(t4_C1, "i8", "C1_Length", "C4_Length", "Speed_On_Platform", TransitionOperation.CalculateTime, "Time"));
        grdt4_C1b.Activations.add(new Activation(t4_C1, "Time", TransitionOperation.SendOverNetwork, "OP_TimeC4"));
        grdt4_C1b.Activations.add(new Activation(t4_C1, "C4", TransitionOperation.SendOverNetwork, "OP_PC4"));
        grdt4_C1b.Activations.add(new Activation(t4_C1, "i8", TransitionOperation.Move, "i9"));
        t4_C1.GuardMappingList.add(grdt4_C1b);

        // Train coming and having as target Platform C2
        Condition t4_C1Ct1c = new Condition(t4_C1, "i9", TransitionCondition.IsNull);
        Condition t4_C1Ct2c = new Condition(t4_C1, "i8", TransitionCondition.NotNull);
        Condition t4_C1Ct3c = new Condition(t4_C1, "i8", TransitionCondition.Platform, "C2");

        t4_C1Ct3c.SetNextCondition(LogicConnector.AND, t4_C1Ct2c);
        t4_C1Ct2c.SetNextCondition(LogicConnector.AND, t4_C1Ct1c);

        GuardMapping grdt4_C1c = new GuardMapping();
        grdt4_C1c.condition = t4_C1Ct1b;
        grdt4_C1c.Activations.add(new Activation(t4_C1, "i8", "C2_Length", "C4_Length", "Speed_On_Platform", TransitionOperation.CalculateTime, "Time"));
        grdt4_C1c.Activations.add(new Activation(t4_C1, "Time", TransitionOperation.SendOverNetwork, "OP_TimeC4"));
        grdt4_C1c.Activations.add(new Activation(t4_C1, "C4", TransitionOperation.SendOverNetwork, "OP_PC4"));
        grdt4_C1c.Activations.add(new Activation(t4_C1, "i8", TransitionOperation.Move, "i9"));
        t4_C1.GuardMappingList.add(grdt4_C1c);

        t4_C1.Delay = 0;
        pn.Transitions.add(t4_C1);


        // t4_C2 ------------------------------------------------

        PetriTransition t4_C2 = new PetriTransition(pn);
        t4_C2.TransitionName = "t4_C2";
        t4_C2.InputPlaceName.add("i8");

// Handle case when input is null
        Condition t4_C2CtAllNull = new Condition(t4_C2, "i8", TransitionCondition.IsNull);

        GuardMapping grdt4_C2AllNull = new GuardMapping();
        grdt4_C2AllNull.condition = t4_C2CtAllNull;
        grdt4_C2AllNull.Activations.add(new Activation(t4_C2, "", TransitionOperation.DoNothing, ""));
        t4_C2.GuardMappingList.add(grdt4_C2AllNull);

// leaving train
        Condition t4_C2Ct1a = new Condition(t4_C2, "i8", TransitionCondition.NotNull);
        Condition t4_C2Ct2a = new Condition(t4_C2, "i8", TransitionCondition.Check_Transition_Target_List_NO, "t2_C1");
        Condition t4_C2Ct3a = new Condition(t4_C2, "i8", TransitionCondition.Check_Transition_Target_List_NO, "t2_C2");
        Condition t4_C2Ct4a = new Condition(t4_C2, "i8", TransitionCondition.Check_Transition_Target_List_NO, "t2_C3");

        t4_C2Ct2a.SetNextCondition(LogicConnector.OR, t4_C2Ct3a);
        t4_C2Ct3a.SetNextCondition(LogicConnector.OR, t4_C2Ct4a);
        t4_C2Ct1a.SetNextCondition(LogicConnector.AND, t4_C2Ct2a);

        GuardMapping grdt4_C2a = new GuardMapping();
        grdt4_C2a.condition = t4_C2Ct1a;
        grdt4_C2a.Activations.add(new Activation(t4_C2, "i8", TransitionOperation.SendOverNetwork, "OP_i8"));
        grdt4_C2a.Activations.add(new Activation(t4_C2, "i8", TransitionOperation.MakeNull, "i8"));
        t4_C2.GuardMappingList.add(grdt4_C2a);

        t4_C2.Delay = 0;
        pn.Transitions.add(t4_C2);


        System.out.println("Station C started \n ------------------------------");
        pn.Delay = 3000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.setTitle("Station C");
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
