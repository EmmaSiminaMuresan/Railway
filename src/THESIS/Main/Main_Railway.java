package THESIS.Main;

import Components.*;
import DataObjects.DataInteger;
import DataObjects.DataString;
import DataObjects.DataTrain;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Main_Railway {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Main Railway";
        pn.SetName("Main Railway");

        pn.NetworkPort = 1083;

        int x=7;

        DataTrain inA = new DataTrain();
        inA.SetName("inA");
        pn.PlaceList.add(inA);

        DataTrain inB = new DataTrain();
        inB.SetName("inB");
        pn.PlaceList.add(inB);

        DataTrain inC = new DataTrain();
        inC.SetName("inC");
        pn.PlaceList.add(inC);

        DataTrain P1 = new DataTrain();
        P1.SetName("P1");
        pn.PlaceList.add(P1);

        DataTrain P2 = new DataTrain();
        P2.SetName("P2");
        pn.PlaceList.add(P2);

        DataTrain P3 = new DataTrain();
        P3.SetName("P3");
        pn.PlaceList.add(P3);

        DataTrain P7_1 = new DataTrain();
        P7_1.SetName("P7_1");
        pn.PlaceList.add(P7_1);

        DataTrain P7_2 = new DataTrain();
        P7_2.SetName("P7_2");
        pn.PlaceList.add(P7_2);

        DataTrain P8_1 = new DataTrain();
        P8_1.SetName("P8_1");
        pn.PlaceList.add(P8_1);

        DataTrain P8_2 = new DataTrain();
        P8_2.SetName("P8_2");
        pn.PlaceList.add(P8_2);

        DataTrain P9_1 = new DataTrain();
        P9_1.SetName("P9_1");
        pn.PlaceList.add(P9_1);

        DataTrain P9_2 = new DataTrain();
        P9_2.SetName("P9_2");
        pn.PlaceList.add(P9_2);

        DataTrain P10_1 = new DataTrain();
        P10_1.SetName("P10_1");
        pn.PlaceList.add(P10_1);

        DataTrain P10_2 = new DataTrain();
        P10_2.SetName("P10_2");
        pn.PlaceList.add(P10_2);

        DataTrain P11_1 = new DataTrain();
        P11_1.SetName("P11_1");
        pn.PlaceList.add(P11_1);

        DataTrain P11_2 = new DataTrain();
        P11_2.SetName("P11_2");
        pn.PlaceList.add(P11_2);

        DataTrain P12_1 = new DataTrain();
        P12_1.SetName("P12_1");
        pn.PlaceList.add(P12_1);

        DataTrain P12_2 = new DataTrain();
        P12_2.SetName("P12_2");
        pn.PlaceList.add(P12_2);

        DataTrain i5 = new DataTrain();
        i5.SetName("i5");
        pn.PlaceList.add(i5);

        DataTrain i6 = new DataTrain();
        i6.SetName("i6");
        pn.PlaceList.add(i6);

        DataTrain i7 = new DataTrain();
        i7.SetName("i7");
        pn.PlaceList.add(i7);

        DataString red = new DataString();
        //red.Printable = false;
        red.SetName("red");
        red.SetValue("red");
        pn.ConstantPlaceList.add(red);

        DataString green = new DataString();
        //green.Printable = false;
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataString L1 = new DataString();
        L1.SetName("L1");
        pn.ConstantPlaceList.add(L1);

        DataString L2 = new DataString();
        L2.SetName("L2");
        pn.ConstantPlaceList.add(L2);

        DataString L3 = new DataString();
        L3.SetName("L3");
        pn.ConstantPlaceList.add(L3);

        DataString L7 = new DataString();
        L7.SetName("L7");
        pn.ConstantPlaceList.add(L7);

        DataString L8 = new DataString();
        L8.SetName("L8");
        pn.ConstantPlaceList.add(L8);

        DataString L9 = new DataString();
        L9.SetName("L9");
        pn.ConstantPlaceList.add(L9);

        DataString L10 = new DataString();
        L10.SetName("L10");
        pn.ConstantPlaceList.add(L10);

        DataString L11 = new DataString();
        L11.SetName("L11");
        pn.ConstantPlaceList.add(L11);

        DataString L12 = new DataString();
        L12.SetName("L12");
        pn.ConstantPlaceList.add(L12);

        DataInteger in7 = new DataInteger();
        in7.SetName("in7");
        in7.SetValue(x);  /////////
        pn.ConstantPlaceList.add(in7);

        DataInteger in8 = new DataInteger();
        in8.SetName("in8");
        in8.SetValue(x);//////////
        pn.ConstantPlaceList.add(in8);

        DataInteger in9 = new DataInteger();
        in9.SetName("in9");
        in9.SetValue(x);//////////
        pn.ConstantPlaceList.add(in9);

        DataInteger in10 = new DataInteger();
        in10.SetName("in10");
        in10.SetValue(x);  /////////
        pn.ConstantPlaceList.add(in10);

        DataInteger in11 = new DataInteger();
        in11.SetName("in11");
        in11.SetValue(x);//////////
        pn.ConstantPlaceList.add(in11);

        DataInteger in12 = new DataInteger();
        in12.SetName("in12");
        in12.SetValue(x);//////////
        pn.ConstantPlaceList.add(in12);

        // Train sent to the station
        // station A
        DataTransfer OP_i2 = new DataTransfer();
        OP_i2.SetName("OP_i2");
        OP_i2.Value = new TransferOperation("localhost", "1081" , "i2");
        pn.PlaceList.add(OP_i2);

        // station B
        DataTransfer OP_i3 = new DataTransfer();
        OP_i3.SetName("OP_i3");
        OP_i3.Value = new TransferOperation("localhost", "1089" , "i3");
        pn.PlaceList.add(OP_i3);

        // station C
        DataTransfer OP_i8 = new DataTransfer();
        OP_i8.SetName("OP_i8");
        OP_i8.Value = new TransferOperation("localhost", "1090" , "i8");
        pn.PlaceList.add(OP_i8);

        // controller L7 L8
        DataTransfer OP7_1 = new DataTransfer();
        OP7_1.SetName("OP7_1");
        OP7_1.Value = new TransferOperation("localhost", "1084" , "in7_1");
        pn.PlaceList.add(OP7_1);

        DataTransfer OP7_2 = new DataTransfer();
        OP7_2.SetName("OP7_2");
        OP7_2.Value = new TransferOperation("localhost", "1084" , "in7_2");
        pn.PlaceList.add(OP7_2);

        DataTransfer OP8_1 = new DataTransfer();
        OP8_1.SetName("OP8_1");
        OP8_1.Value = new TransferOperation("localhost", "1084" , "in8_1");
        pn.PlaceList.add(OP8_1);

        DataTransfer OP8_2 = new DataTransfer();
        OP8_2.SetName("OP8_2");
        OP8_2.Value = new TransferOperation("localhost", "1084" , "in8_2");
        pn.PlaceList.add(OP8_2);

        // controller L9 L10
        DataTransfer OP9_1 = new DataTransfer();
        OP9_1.SetName("OP9_1");
        OP9_1.Value = new TransferOperation("localhost", "1085" , "in9_1");
        pn.PlaceList.add(OP9_1);

        DataTransfer OP9_2 = new DataTransfer();
        OP9_2.SetName("OP9_2");
        OP9_2.Value = new TransferOperation("localhost", "1085" , "in9_2");
        pn.PlaceList.add(OP9_2);

        DataTransfer OP10_1 = new DataTransfer();
        OP10_1.SetName("OP10_1");
        OP10_1.Value = new TransferOperation("localhost", "1085" , "in10_1");
        pn.PlaceList.add(OP10_1);

        DataTransfer OP10_2 = new DataTransfer();
        OP10_2.SetName("OP10_2");
        OP10_2.Value = new TransferOperation("localhost", "1085" , "in10_2");
        pn.PlaceList.add(OP10_2);

        // controller L11 L12
        DataTransfer OP11_1 = new DataTransfer();
        OP11_1.SetName("OP11_1");
        OP11_1.Value = new TransferOperation("localhost", "1086" , "in11_1");
        pn.PlaceList.add(OP11_1);

        DataTransfer OP11_2 = new DataTransfer();
        OP11_2.SetName("OP11_2");
        OP11_2.Value = new TransferOperation("localhost", "1086" , "in11_2");
        pn.PlaceList.add(OP11_2);

        DataTransfer OP12_1 = new DataTransfer();
        OP12_1.SetName("OP12_1");
        OP12_1.Value = new TransferOperation("localhost", "1086" , "in12_1");
        pn.PlaceList.add(OP12_1);

        DataTransfer OP12_2 = new DataTransfer();
        OP12_2.SetName("OP12_2");
        OP12_2.Value = new TransferOperation("localhost", "1086" , "in12_2");
        pn.PlaceList.add(OP12_2);


        // t7_1 ------------------------------------------------

        PetriTransition t7_1 = new PetriTransition(pn);
        t7_1.TransitionName = "t7_1";
        t7_1.InputPlaceName.add("inA");


        Condition t7_1Ct1a = new Condition(t7_1, "inA", TransitionCondition.NotNull);
        Condition t7_1Ct2a = new Condition(t7_1, "P7_1", TransitionCondition.IsNull);

        t7_1Ct1a.SetNextCondition(LogicConnector.AND, t7_1Ct2a);

        GuardMapping grdt7_1a = new GuardMapping();
        grdt7_1a.condition = t7_1Ct1a;
        grdt7_1a.Activations.add(new Activation(t7_1, "inA", TransitionOperation.Move, "P7_1"));
        t7_1.GuardMappingList.add(grdt7_1a);


        t7_1.Delay = 0;
        pn.Transitions.add(t7_1);

        // S7------------------------------------------------

        PetriTransition S7 = new PetriTransition(pn);
        S7.TransitionName = "S7";
        S7.InputPlaceName.add("in7");
        S7.InputPlaceName.add("P7_1");


        Condition S7Ct1a = new Condition(S7, "in7", TransitionCondition.NotNull);
        Condition S7Ct2a = new Condition(S7, "P7_1", TransitionCondition.NotNull);

        S7Ct1a.SetNextCondition(LogicConnector.AND, S7Ct2a);

        GuardMapping grdS7a = new GuardMapping();
        grdS7a.condition = S7Ct1a;
        grdS7a.Activations.add(new Activation(S7, "in7", TransitionOperation.SendOverNetwork, "OP7_2"));
        grdS7a.Activations.add(new Activation(S7, "P7_1", TransitionOperation.SendOverNetwork, "OP7_1"));
        grdS7a.Activations.add(new Activation(S7, "P7_1", TransitionOperation.Move, "P7_2"));
        grdS7a.Activations.add(new Activation(S7, "in7", TransitionOperation.Move, "in7"));
        S7.GuardMappingList.add(grdS7a);


        // NO:
        Condition S7Ct1b = new Condition(S7, "in7", TransitionCondition.NotNull);
        Condition S7Ct2b = new Condition(S7, "P7_1", TransitionCondition.IsNull);

        S7Ct2b.SetNextCondition(LogicConnector.AND, S7Ct1b);

        GuardMapping grdS7b = new GuardMapping();
        grdS7b.condition = S7Ct1b;
        grdS7b.Activations.add(new Activation(S7, "in7", TransitionOperation.SendOverNetwork, "OP7_2"));
        grdS7b.Activations.add(new Activation(S7, "P7_1", TransitionOperation.SendOverNetwork, "OP7_1"));
        grdS7b.Activations.add(new Activation(S7, "in7", TransitionOperation.Move, "in7"));
        S7.GuardMappingList.add(grdS7b);

        S7.Delay = 0;
        pn.Transitions.add(S7);

        // t7_2 ------------------------------------------------

        PetriTransition t7_2 = new PetriTransition(pn);
        t7_2.TransitionName = "t7_2";
        t7_2.InputPlaceName.add("P7_2");
        t7_2.InputPlaceName.add("L7");


        Condition t7_2Ct1a = new Condition(t7_2, "P7_2", TransitionCondition.NotNull);
        Condition t7_2Ct2a = new Condition(t7_2, "L7", TransitionCondition.Equal,"green");
        Condition t7_2Ct3a = new Condition(t7_2, "i5", TransitionCondition.IsNull);

        t7_2Ct3a.SetNextCondition(LogicConnector.AND, t7_2Ct2a);
        t7_2Ct2a.SetNextCondition(LogicConnector.AND, t7_2Ct1a);

        GuardMapping grdt7_2a = new GuardMapping();
        grdt7_2a.condition = t7_2Ct1a;
        grdt7_2a.Activations.add(new Activation(t7_2, "P7_2", TransitionOperation.Move, "i5"));
        grdt7_2a.Activations.add(new Activation(t7_2, "L7", TransitionOperation.Move, "L7"));
        t7_2.GuardMappingList.add(grdt7_2a);


        t7_2.Delay = 0;
        pn.Transitions.add(t7_2);


        // t2_1------------------------------------------------

        PetriTransition t2_1 = new PetriTransition(pn);
        t2_1.TransitionName = "t2_1";
        t2_1.InputPlaceName.add("i5");


        Condition t2_1Ct2a = new Condition(t2_1, "i5", TransitionCondition.HaveTrainForMe);
        Condition t2_1Ct3a = new Condition(t2_1, "P2", TransitionCondition.IsNull);

        t2_1Ct2a.SetNextCondition(LogicConnector.AND, t2_1Ct3a);

        GuardMapping grdt2_1a = new GuardMapping();
        grdt2_1a.condition = t2_1Ct2a;
        grdt2_1a.Activations.add(new Activation(t2_1, "i5", TransitionOperation.Move, "P2"));
        t2_1.GuardMappingList.add(grdt2_1a);


        t2_1.Delay = 0;
        pn.Transitions.add(t2_1);


        // t2_2 ------------------------------------------------

        PetriTransition t2_2 = new PetriTransition(pn);
        t2_2.TransitionName = "t2_2";
        t2_2.InputPlaceName.add("P2");
        t2_2.InputPlaceName.add("L2");


        Condition t2_2Ct1a = new Condition(t2_2, "P2", TransitionCondition.NotNull);
        Condition t2_2Ct2a = new Condition(t2_2, "L2", TransitionCondition.Equal,"green");

        t2_2Ct2a.SetNextCondition(LogicConnector.AND, t2_2Ct1a);

        GuardMapping grdt2_2a = new GuardMapping();
        grdt2_2a.condition = t2_2Ct1a;
        grdt2_2a.Activations.add(new Activation(t2_2, "L2", TransitionOperation.Move, "L2"));
        grdt2_2a.Activations.add(new Activation(t2_2, "P2", TransitionOperation.SendOverNetwork, "OP_i3"));

        t2_2.GuardMappingList.add(grdt2_2a);


        t2_2.Delay = 0;
        pn.Transitions.add(t2_2);



        // t10_1 ------------------------------------------------

        PetriTransition t10_1 = new PetriTransition(pn);
        t10_1.TransitionName = "t10_1";
        t10_1.InputPlaceName.add("inB");


        Condition t10_1Ct1a = new Condition(t10_1, "inB", TransitionCondition.NotNull);
        Condition t10_1Ct2a = new Condition(t10_1, "P10_1", TransitionCondition.IsNull);

        t10_1Ct1a.SetNextCondition(LogicConnector.AND, t10_1Ct2a);

        GuardMapping grdt10_1a = new GuardMapping();
        grdt10_1a.condition = t10_1Ct1a;
        grdt10_1a.Activations.add(new Activation(t10_1, "inB", TransitionOperation.Move, "P10_1"));
        t10_1.GuardMappingList.add(grdt10_1a);


        t10_1.Delay = 0;
        pn.Transitions.add(t10_1);

        // S10------------------------------------------------

        PetriTransition S10 = new PetriTransition(pn);
        S10.TransitionName = "S10";
        S10.InputPlaceName.add("in10");
        S10.InputPlaceName.add("P10_1");


        Condition S10Ct1a = new Condition(S10, "in10", TransitionCondition.NotNull);
        Condition S10Ct2a = new Condition(S10, "P10_1", TransitionCondition.NotNull);

        S10Ct1a.SetNextCondition(LogicConnector.AND, S10Ct2a);

        GuardMapping grdS10a = new GuardMapping();
        grdS10a.condition = S10Ct1a;
        grdS10a.Activations.add(new Activation(S10, "in10", TransitionOperation.SendOverNetwork, "OP10_2"));
        grdS10a.Activations.add(new Activation(S10, "P10_1", TransitionOperation.SendOverNetwork, "OP10_1"));
        grdS10a.Activations.add(new Activation(S10, "P10_1", TransitionOperation.Move, "P10_2"));
        grdS10a.Activations.add(new Activation(S10, "in10", TransitionOperation.Move, "in10"));
        S10.GuardMappingList.add(grdS10a);


        Condition S10Ct1b = new Condition(S10, "in10", TransitionCondition.NotNull);
        Condition S10Ct2b = new Condition(S10, "P10_1", TransitionCondition.IsNull);

        S10Ct2b.SetNextCondition(LogicConnector.AND, S10Ct1b);

        GuardMapping grdS10b = new GuardMapping();
        grdS10b.condition = S10Ct1b;
        grdS10b.Activations.add(new Activation(S10, "in10", TransitionOperation.SendOverNetwork, "OP10_2"));
        grdS10b.Activations.add(new Activation(S10, "P10_1", TransitionOperation.SendOverNetwork, "OP10_1"));
        grdS10b.Activations.add(new Activation(S10, "in10", TransitionOperation.Move, "in10"));
        S10.GuardMappingList.add(grdS10b);

        S10.Delay = 0;
        pn.Transitions.add(S10);

        // t10_2 ------------------------------------------------

        PetriTransition t10_2 = new PetriTransition(pn);
        t10_2.TransitionName = "t10_2";
        t10_2.InputPlaceName.add("P10_2");
        t10_2.InputPlaceName.add("L10");


        Condition t10_2Ct1a = new Condition(t10_2, "P10_2", TransitionCondition.NotNull);
        Condition t10_2Ct2a = new Condition(t10_2, "L10", TransitionCondition.Equal,"green");
        Condition t10_2Ct3a = new Condition(t10_2, "i6", TransitionCondition.IsNull);

        t10_2Ct3a.SetNextCondition(LogicConnector.AND, t10_2Ct2a);
        t10_2Ct2a.SetNextCondition(LogicConnector.AND, t10_2Ct1a);

        GuardMapping grdt10_2a = new GuardMapping();
        grdt10_2a.condition = t10_2Ct1a;
        grdt10_2a.Activations.add(new Activation(t10_2, "P10_2", TransitionOperation.Move, "i6"));
        grdt10_2a.Activations.add(new Activation(t10_2, "L10", TransitionOperation.Move, "L10"));
        t10_2.GuardMappingList.add(grdt10_2a);


        t10_2.Delay = 0;
        pn.Transitions.add(t10_2);


        // t3_1------------------------------------------------

        PetriTransition t3_1 = new PetriTransition(pn);
        t3_1.TransitionName = "t3_1";
        t3_1.InputPlaceName.add("i6");


        Condition t3_1Ct2a = new Condition(t3_1, "i6", TransitionCondition.HaveTrainForMe);
        Condition t3_1Ct3a = new Condition(t3_1, "P3", TransitionCondition.IsNull);

        t3_1Ct2a.SetNextCondition(LogicConnector.AND, t3_1Ct3a);

        GuardMapping grdt3_1a = new GuardMapping();
        grdt3_1a.condition = t3_1Ct2a;
        grdt3_1a.Activations.add(new Activation(t3_1, "i6", TransitionOperation.Move, "P3"));
        t3_1.GuardMappingList.add(grdt3_1a);


        t3_1.Delay = 0;
        pn.Transitions.add(t3_1);


        // t3_2 ------------------------------------------------

        PetriTransition t3_2 = new PetriTransition(pn);
        t3_2.TransitionName = "t3_2";
        t3_2.InputPlaceName.add("P3");
        t3_2.InputPlaceName.add("L3");


        Condition t3_2Ct1a = new Condition(t3_2, "P3", TransitionCondition.NotNull);
        Condition t3_2Ct2a = new Condition(t3_2, "L3", TransitionCondition.Equal,"green");

        t3_2Ct2a.SetNextCondition(LogicConnector.AND, t3_2Ct1a);

        GuardMapping grdt3_2a = new GuardMapping();
        grdt3_2a.condition = t3_2Ct1a;
        grdt3_2a.Activations.add(new Activation(t3_2, "L3", TransitionOperation.Move, "L3"));
        grdt3_2a.Activations.add(new Activation(t3_2, "P3", TransitionOperation.SendOverNetwork, "OP_i8"));
        t3_2.GuardMappingList.add(grdt3_2a);


        t3_2.Delay = 0;
        pn.Transitions.add(t3_2);



        // t12_1 ------------------------------------------------

        PetriTransition t12_1 = new PetriTransition(pn);
        t12_1.TransitionName = "t12_1";
        t12_1.InputPlaceName.add("inC");


        Condition t12_1Ct1a = new Condition(t12_1, "inC", TransitionCondition.NotNull);
        Condition t12_1Ct2a = new Condition(t12_1, "P12_1", TransitionCondition.IsNull);

        t12_1Ct1a.SetNextCondition(LogicConnector.AND, t12_1Ct2a);

        GuardMapping grdt12_1a = new GuardMapping();
        grdt12_1a.condition = t12_1Ct1a;
        grdt12_1a.Activations.add(new Activation(t12_1, "inC", TransitionOperation.Move, "P12_1"));
        t12_1.GuardMappingList.add(grdt12_1a);


        t12_1.Delay = 0;
        pn.Transitions.add(t12_1);

        // S12------------------------------------------------

        PetriTransition S12 = new PetriTransition(pn);
        S12.TransitionName = "S12";
        S12.InputPlaceName.add("in12");
        S12.InputPlaceName.add("P12_1");


        Condition S12Ct1a = new Condition(S12, "in12", TransitionCondition.NotNull);
        Condition S12Ct2a = new Condition(S12, "P12_1", TransitionCondition.NotNull);

        S12Ct1a.SetNextCondition(LogicConnector.AND, S12Ct2a);

        GuardMapping grdS12a = new GuardMapping();
        grdS12a.condition = S12Ct1a;
        grdS12a.Activations.add(new Activation(S12, "in12", TransitionOperation.SendOverNetwork, "OP12_2"));
        grdS12a.Activations.add(new Activation(S12, "P12_1", TransitionOperation.SendOverNetwork, "OP12_1"));
        grdS12a.Activations.add(new Activation(S12, "P12_1", TransitionOperation.Move, "P12_2"));
        grdS12a.Activations.add(new Activation(S12, "in12", TransitionOperation.Move, "in12"));
        S12.GuardMappingList.add(grdS12a);


        Condition S12Ct1b = new Condition(S12, "in12", TransitionCondition.NotNull);
        Condition S12Ct2b = new Condition(S12, "P12_1", TransitionCondition.IsNull);

        S12Ct2b.SetNextCondition(LogicConnector.AND, S12Ct1b);

        GuardMapping grdS12b = new GuardMapping();
        grdS12b.condition = S12Ct1b;
        grdS12b.Activations.add(new Activation(S12, "in12", TransitionOperation.SendOverNetwork, "OP12_2"));
        grdS12b.Activations.add(new Activation(S12, "P12_1", TransitionOperation.SendOverNetwork, "OP12_1"));
        grdS12b.Activations.add(new Activation(S12, "in12", TransitionOperation.Move, "in12"));
        S12.GuardMappingList.add(grdS12b);

        S12.Delay = 0;
        pn.Transitions.add(S12);

        // t12_2 ------------------------------------------------

        PetriTransition t12_2 = new PetriTransition(pn);
        t12_2.TransitionName = "t12_2";
        t12_2.InputPlaceName.add("P12_2");
        t12_2.InputPlaceName.add("L12");


        Condition t12_2Ct1a = new Condition(t12_2, "P12_2", TransitionCondition.NotNull);
        Condition t12_2Ct2a = new Condition(t12_2, "L12", TransitionCondition.Equal,"green");
        Condition t12_2Ct3a = new Condition(t12_2, "i7", TransitionCondition.IsNull);

        t12_2Ct3a.SetNextCondition(LogicConnector.AND, t12_2Ct2a);
        t12_2Ct2a.SetNextCondition(LogicConnector.AND, t12_2Ct1a);

        GuardMapping grdt12_2a = new GuardMapping();
        grdt12_2a.condition = t12_2Ct1a;
        grdt12_2a.Activations.add(new Activation(t12_2, "P12_2", TransitionOperation.Move, "i7"));
        grdt12_2a.Activations.add(new Activation(t12_2, "L12", TransitionOperation.Move, "L12"));
        t12_2.GuardMappingList.add(grdt12_2a);


        t12_2.Delay = 0;
        pn.Transitions.add(t12_2);


        // t1_1------------------------------------------------

        PetriTransition t1_1 = new PetriTransition(pn);
        t1_1.TransitionName = "t1_1";
        t1_1.InputPlaceName.add("i7");


        Condition t1_1Ct2a = new Condition(t1_1, "i7", TransitionCondition.HaveTrainForMe);
        Condition t1_1Ct3a = new Condition(t1_1, "P1", TransitionCondition.IsNull);

        t1_1Ct2a.SetNextCondition(LogicConnector.AND, t1_1Ct3a);

        GuardMapping grdt1_1a = new GuardMapping();
        grdt1_1a.condition = t1_1Ct2a;
        grdt1_1a.Activations.add(new Activation(t1_1, "i7", TransitionOperation.Move, "P1"));
        t1_1.GuardMappingList.add(grdt1_1a);


        t1_1.Delay = 0;
        pn.Transitions.add(t1_1);


        // t1_2 ------------------------------------------------

        PetriTransition t1_2 = new PetriTransition(pn);
        t1_2.TransitionName = "t1_2";
        t1_2.InputPlaceName.add("P1");
        t1_2.InputPlaceName.add("L1");


        Condition t1_2Ct1a = new Condition(t1_2, "P1", TransitionCondition.NotNull);
        Condition t1_2Ct2a = new Condition(t1_2, "L1", TransitionCondition.Equal,"green");

        t1_2Ct2a.SetNextCondition(LogicConnector.AND, t1_2Ct1a);

        GuardMapping grdt1_2a = new GuardMapping();
        grdt1_2a.condition = t1_2Ct1a;
        grdt1_2a.Activations.add(new Activation(t1_2, "L1", TransitionOperation.Move, "L1"));
        grdt1_2a.Activations.add(new Activation(t1_2, "P1", TransitionOperation.SendOverNetwork, "OP_i2"));
        t1_2.GuardMappingList.add(grdt1_2a);


        t1_2.Delay = 0;
        pn.Transitions.add(t1_2);


        // t8_1------------------------------------------------

        PetriTransition t8_1 = new PetriTransition(pn);
        t8_1.TransitionName = "t8_1";
        t8_1.InputPlaceName.add("i7");


        Condition t8_1Ct2a = new Condition(t8_1, "i7", TransitionCondition.HaveTrainForMe);
        Condition t8_1Ct3a = new Condition(t8_1, "P8_1", TransitionCondition.IsNull);

        t8_1Ct2a.SetNextCondition(LogicConnector.AND, t8_1Ct3a);

        GuardMapping grdt8_1a = new GuardMapping();
        grdt8_1a.condition = t8_1Ct2a;
        grdt8_1a.Activations.add(new Activation(t8_1, "i7", TransitionOperation.Move, "P8_1"));
        t8_1.GuardMappingList.add(grdt8_1a);


        t8_1.Delay = 0;
        pn.Transitions.add(t8_1);

        // S8------------------------------------------------

        PetriTransition S8 = new PetriTransition(pn);
        S8.TransitionName = "S8";
        S8.InputPlaceName.add("in8");
        S8.InputPlaceName.add("P8_1");


        Condition S8Ct1a = new Condition(S8, "in8", TransitionCondition.NotNull);
        Condition S8Ct2a = new Condition(S8, "P8_1", TransitionCondition.NotNull);

        S8Ct1a.SetNextCondition(LogicConnector.AND, S8Ct2a);

        GuardMapping grdS8a = new GuardMapping();
        grdS8a.condition = S8Ct1a;
        grdS8a.Activations.add(new Activation(S8, "in8", TransitionOperation.SendOverNetwork, "OP8_2"));
        grdS8a.Activations.add(new Activation(S8, "P8_1", TransitionOperation.SendOverNetwork, "OP8_1"));
        grdS8a.Activations.add(new Activation(S8, "P8_1", TransitionOperation.Move, "P8_2"));
        grdS8a.Activations.add(new Activation(S8, "in8", TransitionOperation.Move, "in8"));
        S8.GuardMappingList.add(grdS8a);


        Condition S8Ct1b = new Condition(S8, "in8", TransitionCondition.NotNull);
        Condition S8Ct2b = new Condition(S8, "P8_1", TransitionCondition.IsNull);

        S8Ct2b.SetNextCondition(LogicConnector.AND, S8Ct1b);

        GuardMapping grdS8b = new GuardMapping();
        grdS8b.condition = S8Ct1b;
        grdS8b.Activations.add(new Activation(S8, "in8", TransitionOperation.SendOverNetwork, "OP8_2"));
        grdS8b.Activations.add(new Activation(S8, "P8_1", TransitionOperation.SendOverNetwork, "OP8_1"));
        grdS8b.Activations.add(new Activation(S8, "in8", TransitionOperation.Move, "in8"));
        S8.GuardMappingList.add(grdS8b);

        S8.Delay = 0;
        pn.Transitions.add(S8);

        // t8_2 ------------------------------------------------

        PetriTransition t8_2 = new PetriTransition(pn);
        t8_2.TransitionName = "t8_2";
        t8_2.InputPlaceName.add("P8_2");
        t8_2.InputPlaceName.add("L8");


        Condition t8_2Ct1a = new Condition(t8_2, "P8_2", TransitionCondition.NotNull);
        Condition t8_2Ct2a = new Condition(t8_2, "L8", TransitionCondition.Equal,"green");
        Condition t8_2Ct3a = new Condition(t8_2, "i5", TransitionCondition.IsNull);

        t8_2Ct3a.SetNextCondition(LogicConnector.AND, t8_2Ct2a);
        t8_2Ct2a.SetNextCondition(LogicConnector.AND, t8_2Ct1a);

        GuardMapping grdt8_2a = new GuardMapping();
        grdt8_2a.condition = t8_2Ct1a;
        grdt8_2a.Activations.add(new Activation(t8_2, "P8_2", TransitionOperation.Move, "i5"));
        grdt8_2a.Activations.add(new Activation(t8_2, "L8", TransitionOperation.Move, "L8"));
        t8_2.GuardMappingList.add(grdt8_2a);


        t8_2.Delay = 0;
        pn.Transitions.add(t8_2);


        // t9_1------------------------------------------------

        PetriTransition t9_1 = new PetriTransition(pn);
        t9_1.TransitionName = "t9_1";
        t9_1.InputPlaceName.add("i5");


        Condition t9_1Ct2a = new Condition(t9_1, "i5", TransitionCondition.HaveTrainForMe);
        Condition t9_1Ct3a = new Condition(t9_1, "P9_1", TransitionCondition.IsNull);

        t9_1Ct2a.SetNextCondition(LogicConnector.AND, t9_1Ct3a);

        GuardMapping grdt9_1a = new GuardMapping();
        grdt9_1a.condition = t9_1Ct2a;
        grdt9_1a.Activations.add(new Activation(t9_1, "i5", TransitionOperation.Move, "P9_1"));
        t9_1.GuardMappingList.add(grdt9_1a);


        t9_1.Delay = 0;
        pn.Transitions.add(t9_1);

        // S9------------------------------------------------

        PetriTransition S9 = new PetriTransition(pn);
        S9.TransitionName = "S9";
        S9.InputPlaceName.add("in9");
        S9.InputPlaceName.add("P9_1");


        Condition S9Ct1a = new Condition(S9, "in9", TransitionCondition.NotNull);
        Condition S9Ct2a = new Condition(S9, "P9_1", TransitionCondition.NotNull);

        S9Ct1a.SetNextCondition(LogicConnector.AND, S9Ct2a);

        GuardMapping grdS9a = new GuardMapping();
        grdS9a.condition = S9Ct1a;
        grdS9a.Activations.add(new Activation(S9, "in9", TransitionOperation.SendOverNetwork, "OP9_2"));
        grdS9a.Activations.add(new Activation(S9, "P9_1", TransitionOperation.SendOverNetwork, "OP9_1"));
        grdS9a.Activations.add(new Activation(S9, "P9_1", TransitionOperation.Move, "P9_2"));
        grdS9a.Activations.add(new Activation(S9, "in9", TransitionOperation.Move, "in9"));
        S9.GuardMappingList.add(grdS9a);


        Condition S9Ct1b = new Condition(S9, "in9", TransitionCondition.NotNull);
        Condition S9Ct2b = new Condition(S9, "P9_1", TransitionCondition.IsNull);

        S9Ct2b.SetNextCondition(LogicConnector.AND, S9Ct1b);

        GuardMapping grdS9b = new GuardMapping();
        grdS9b.condition = S9Ct1b;
        grdS9b.Activations.add(new Activation(S9, "in9", TransitionOperation.SendOverNetwork, "OP9_2"));
        grdS9b.Activations.add(new Activation(S9, "P9_1", TransitionOperation.SendOverNetwork, "OP9_1"));
        grdS9b.Activations.add(new Activation(S9, "in9", TransitionOperation.Move, "in9"));
        S9.GuardMappingList.add(grdS9b);

        S9.Delay = 0;
        pn.Transitions.add(S9);

        // t9_2 ------------------------------------------------

        PetriTransition t9_2 = new PetriTransition(pn);
        t9_2.TransitionName = "t9_2";
        t9_2.InputPlaceName.add("P9_2");
        t9_2.InputPlaceName.add("L9");


        Condition t9_2Ct1a = new Condition(t9_2, "P9_2", TransitionCondition.NotNull);
        Condition t9_2Ct2a = new Condition(t9_2, "L9", TransitionCondition.Equal,"green");
        Condition t9_2Ct3a = new Condition(t9_2, "i6", TransitionCondition.IsNull);

        t9_2Ct3a.SetNextCondition(LogicConnector.AND, t9_2Ct2a);
        t9_2Ct2a.SetNextCondition(LogicConnector.AND, t9_2Ct1a);

        GuardMapping grdt9_2a = new GuardMapping();
        grdt9_2a.condition = t9_2Ct1a;
        grdt9_2a.Activations.add(new Activation(t9_2, "P9_2", TransitionOperation.Move, "i6"));
        grdt9_2a.Activations.add(new Activation(t9_2, "L9", TransitionOperation.Move, "L9"));
        t9_2.GuardMappingList.add(grdt9_2a);


        t9_2.Delay = 0;
        pn.Transitions.add(t9_2);


        // t11_1------------------------------------------------

        PetriTransition t11_1 = new PetriTransition(pn);
        t11_1.TransitionName = "t11_1";
        t11_1.InputPlaceName.add("i6");


        Condition t11_1Ct2a = new Condition(t11_1, "i6", TransitionCondition.HaveTrainForMe);
        Condition t11_1Ct3a = new Condition(t11_1, "P11_1", TransitionCondition.IsNull);

        t11_1Ct2a.SetNextCondition(LogicConnector.AND, t11_1Ct3a);

        GuardMapping grdt11_1a = new GuardMapping();
        grdt11_1a.condition = t11_1Ct2a;
        grdt11_1a.Activations.add(new Activation(t11_1, "i6", TransitionOperation.Move, "P11_1"));
        t11_1.GuardMappingList.add(grdt11_1a);


        t11_1.Delay = 0;
        pn.Transitions.add(t11_1);

        // S11------------------------------------------------

        PetriTransition S11 = new PetriTransition(pn);
        S11.TransitionName = "S11";
        S11.InputPlaceName.add("in11");
        S11.InputPlaceName.add("P11_1");


        Condition S11Ct1a = new Condition(S11, "in11", TransitionCondition.NotNull);
        Condition S11Ct2a = new Condition(S11, "P11_1", TransitionCondition.NotNull);

        S11Ct1a.SetNextCondition(LogicConnector.AND, S11Ct2a);

        GuardMapping grdS11a = new GuardMapping();
        grdS11a.condition = S11Ct1a;
        grdS11a.Activations.add(new Activation(S11, "in11", TransitionOperation.SendOverNetwork, "OP11_2"));
        grdS11a.Activations.add(new Activation(S11, "P11_1", TransitionOperation.SendOverNetwork, "OP11_1"));
        grdS11a.Activations.add(new Activation(S11, "P11_1", TransitionOperation.Move, "P11_2"));
        grdS11a.Activations.add(new Activation(S11, "in11", TransitionOperation.Move, "in11"));
        S11.GuardMappingList.add(grdS11a);


        Condition S11Ct1b = new Condition(S11, "in11", TransitionCondition.NotNull);
        Condition S11Ct2b = new Condition(S11, "P11_1", TransitionCondition.IsNull);

        S11Ct2b.SetNextCondition(LogicConnector.AND, S11Ct1b);

        GuardMapping grdS11b = new GuardMapping();
        grdS11b.condition = S11Ct1b;
        grdS11b.Activations.add(new Activation(S11, "in11", TransitionOperation.SendOverNetwork, "OP11_2"));
        grdS11b.Activations.add(new Activation(S11, "P11_1", TransitionOperation.SendOverNetwork, "OP11_1"));
        grdS11b.Activations.add(new Activation(S11, "in11", TransitionOperation.Move, "in11"));
        S11.GuardMappingList.add(grdS11b);

        S11.Delay = 0;
        pn.Transitions.add(S11);

        // t11_2 ------------------------------------------------

        PetriTransition t11_2 = new PetriTransition(pn);
        t11_2.TransitionName = "t11_2";
        t11_2.InputPlaceName.add("P11_2");
        t11_2.InputPlaceName.add("L11");


        Condition t11_2Ct1a = new Condition(t11_2, "P11_2", TransitionCondition.NotNull);
        Condition t11_2Ct2a = new Condition(t11_2, "L11", TransitionCondition.Equal,"green");
        Condition t11_2Ct3a = new Condition(t11_2, "i7", TransitionCondition.IsNull);

        t11_2Ct3a.SetNextCondition(LogicConnector.AND, t11_2Ct2a);
        t11_2Ct2a.SetNextCondition(LogicConnector.AND, t11_2Ct1a);

        GuardMapping grdt11_2a = new GuardMapping();
        grdt11_2a.condition = t11_2Ct1a;
        grdt11_2a.Activations.add(new Activation(t11_2, "P11_2", TransitionOperation.Move, "i7"));
        grdt11_2a.Activations.add(new Activation(t11_2, "L11", TransitionOperation.Move, "L11"));
        t11_2.GuardMappingList.add(grdt11_2a);


        t11_2.Delay = 0;
        pn.Transitions.add(t11_2);

        System.out.println("Main Railway started \n ------------------------------");
        pn.Delay = 3000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);

    }
}
