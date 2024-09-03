package THESIS.Controllers_2L;

import Components.*;
import DataObjects.DataInteger;
import DataObjects.DataString;
import DataObjects.DataTrain;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Controller_L9_L10 {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Controller L9 L10";
        pn.SetName("Controller L9 L10");

        pn.NetworkPort = 1085;

        DataString temp = new DataString(); //to make sure tSetDelay works before t1 and t2
        temp.SetName("temp");
        pn.PlaceList.add(temp);


        DataString L9 = new DataString();
        L9.SetName("L9");
        L9.SetValue("L9");
        pn.ConstantPlaceList.add(L9);

        DataString L10 = new DataString();
        L10.SetName("L10");
        L10.SetValue("L10");
        pn.ConstantPlaceList.add(L10);

        DataString Control = new DataString();
        Control.SetName("Control");
        pn.PlaceList.add(Control);

        DataInteger Delay = new DataInteger();
        Delay.SetName("Delay");
        Delay.SetValue(0);
        pn.PlaceList.add(Delay);

        DataString ini = new DataString();
        //ini.Printable = false;
        ini.SetName("ini");
        ini.SetValue("green");
        pn.ConstantPlaceList.add(ini);

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

        DataString g1g2 = new DataString();
        g1g2.SetName("g1g2");
        g1g2.SetValue("signal");
        pn.PlaceList.add(g1g2);

        DataString r1g2 = new DataString();
        r1g2.SetName("r1g2");
        pn.PlaceList.add(r1g2);

        DataString g1r2 = new DataString();
        g1r2.SetName("g1r2");
        pn.PlaceList.add(g1r2);

        DataTrain in9_1 = new DataTrain();
        in9_1.SetName("in9_1");
        pn.PlaceList.add(in9_1);

        DataTrain in10_1 = new DataTrain();
        in10_1.SetName("in10_1");
        pn.PlaceList.add(in10_1);

        DataInteger in9_2 = new DataInteger();
        in9_2.SetName("in9_2");
        pn.PlaceList.add(in9_2);

        DataInteger in10_2 = new DataInteger();
        in10_2.SetName("in10_2");
        pn.PlaceList.add(in10_2);

        DataString P1 = new DataString();
        P1.SetName("P1");
        pn.PlaceList.add(P1);

        DataString P2 = new DataString();
        P2.SetName("P2");
        pn.PlaceList.add(P2);

        DataTransfer OP_L9 = new DataTransfer();
        OP_L9.SetName("OP_L9");
        OP_L9.Value = new TransferOperation("localhost", "1083" , "L9");
        pn.PlaceList.add(OP_L9);

        DataTransfer OP_L10 = new DataTransfer();
        OP_L10.SetName("OP_L10");
        OP_L10.Value = new TransferOperation("localhost", "1083" , "L10");
        pn.PlaceList.add(OP_L10);


        //----------------------------t_ini------------------------------------
        PetriTransition t_ini = new PetriTransition(pn);
        t_ini.TransitionName = "t_ini";

        Condition t_iniCt1 = new Condition(t_ini, "ini", TransitionCondition.NotNull);

        GuardMapping grdt_ini = new GuardMapping();
        grdt_ini.condition= t_iniCt1;

        grdt_ini.Activations.add(new Activation(t_ini, "ini", TransitionOperation.SendOverNetwork, "OP_L9"));
        grdt_ini.Activations.add(new Activation(t_ini, "ini", TransitionOperation.SendOverNetwork, "OP_L10"));
        grdt_ini.Activations.add(new Activation(t_ini, "", TransitionOperation.MakeNull, "ini"));

        t_ini.GuardMappingList.add(grdt_ini);

        t_ini.Delay = 0;
        pn.Transitions.add(t_ini);

        // t1----------------------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("r1g2");
        t1.InputPlaceName.add("temp");


        Condition t1Ct1 = new Condition(t1, "r1g2", TransitionCondition.NotNull);
        Condition t1Ct2 = new Condition(t1, "Control", TransitionCondition.NotContains,"L9");
        Condition t1Ct3 = new Condition(t1, "temp", TransitionCondition.NotNull); //to make sure tSetDelay executes first

        t1Ct2.SetNextCondition(LogicConnector.AND, t1Ct3);
        t1Ct1.SetNextCondition(LogicConnector.AND, t1Ct2);

        GuardMapping grdt1 = new GuardMapping();
        grdt1.condition= t1Ct1;
        grdt1.Activations.add(new Activation(t1, "r1g2", TransitionOperation.Move, "P1"));
        t1.GuardMappingList.add(grdt1);


        Condition t1Ct1a = new Condition(t1, "r1g2", TransitionCondition.NotNull);
        Condition t1Ct2a = new Condition(t1, "Control", TransitionCondition.Contains,"L9");

        t1Ct1a.SetNextCondition(LogicConnector.AND, t1Ct2a);

        GuardMapping grdt1a = new GuardMapping();
        grdt1a.condition= t1Ct1a;
        grdt1a.Activations.add(new Activation(t1, "r1g2", TransitionOperation.Move, "P1"));
        t1.GuardMappingList.add(grdt1a);

        t1.Delay =0;


        // t2----------------------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("g1r2");
        t2.InputPlaceName.add("temp");


        Condition t2Ct1 = new Condition(t2, "g1r2", TransitionCondition.NotNull);
        Condition t2Ct2 = new Condition(t2, "Control", TransitionCondition.NotContains,"L10");
        Condition t2Ct3 = new Condition(t2, "temp", TransitionCondition.NotNull);

        t2Ct2.SetNextCondition(LogicConnector.AND, t2Ct3);
        t2Ct1.SetNextCondition(LogicConnector.AND, t2Ct2);

        GuardMapping grdt2 = new GuardMapping();
        grdt2.condition= t2Ct1;
        grdt2.Activations.add(new Activation(t2, "g1r2", TransitionOperation.Move, "P2"));
        t2.GuardMappingList.add(grdt2);


        Condition t2Ct1a = new Condition(t2, "g1r2", TransitionCondition.NotNull);
        Condition t2Ct2a = new Condition(t2, "Control", TransitionCondition.Contains,"L10");

        t2Ct1a.SetNextCondition(LogicConnector.AND, t2Ct2a);

        GuardMapping grdt2a = new GuardMapping();
        grdt2a.condition= t2Ct1a;
        grdt2a.Activations.add(new Activation(t2, "g1r2", TransitionOperation.Move, "P2"));
        t2.GuardMappingList.add(grdt2a);

        t2.Delay = 0;


        // t0----------------------------------------------------------------
        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "t0";
        t0.InputPlaceName.add("g1g2");
        t0.InputPlaceName.add("in9_1");
        t0.InputPlaceName.add("in9_2");
        t0.InputPlaceName.add("in10_1");
        t0.InputPlaceName.add("in10_2");


        // no trains
        Condition t0Ct1a1 = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2a1 = new Condition(t0, "in9_1", TransitionCondition.IsNull);
        Condition t0Ct3a1 = new Condition(t0, "in10_1", TransitionCondition.IsNull);
        Condition t0Ct4a1 = new Condition(t0, "in9_2", TransitionCondition.IsNull);
        Condition t0Ct5a1 = new Condition(t0, "in10_2", TransitionCondition.IsNull);


        t0Ct4a1.SetNextCondition(LogicConnector.AND, t0Ct5a1);
        t0Ct3a1.SetNextCondition(LogicConnector.AND, t0Ct4a1);
        t0Ct2a1.SetNextCondition(LogicConnector.AND, t0Ct3a1);
        t0Ct1a1.SetNextCondition(LogicConnector.AND, t0Ct2a1);

        GuardMapping grdt0a1 = new GuardMapping();
        grdt0a1.condition= t0Ct2a1;
        grdt0a1.Activations.add(new Activation(t0, "g1g2",TransitionOperation.Move,"g1g2"));
        t0.GuardMappingList.add(grdt0a1);

        // no trains

        Condition t0Ct1a2 = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2a2 = new Condition(t0, "in9_1", TransitionCondition.IsNull);
        Condition t0Ct3a2 = new Condition(t0, "in10_1", TransitionCondition.IsNull);
        Condition t0Ct4a2 = new Condition(t0, "in9_2", TransitionCondition.NotNull);
        Condition t0Ct5a2 = new Condition(t0, "in10_2", TransitionCondition.NotNull);

        t0Ct4a2.SetNextCondition(LogicConnector.AND, t0Ct5a2);
        t0Ct3a2.SetNextCondition(LogicConnector.AND, t0Ct4a2);
        t0Ct2a2.SetNextCondition(LogicConnector.AND, t0Ct3a2);
        t0Ct1a2.SetNextCondition(LogicConnector.AND, t0Ct2a2);

        GuardMapping grdt0a2 = new GuardMapping();
        grdt0a2.condition= t0Ct2a2;
        grdt0a2.Activations.add(new Activation(t0, "g1g2",TransitionOperation.Move,"g1g2"));

        t0.GuardMappingList.add(grdt0a2);

        // a train before the intersection on Railway 9
        Condition t0Ct1b = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2b = new Condition(t0, "in9_1", TransitionCondition.NotNull);
        Condition t0Ct3b = new Condition(t0, "in10_1", TransitionCondition.IsNull);
        Condition t0Ct4b = new Condition(t0, "in9_2", TransitionCondition.NotNull);
        Condition t0Ct5b = new Condition(t0, "in10_2", TransitionCondition.NotNull);

        t0Ct4b.SetNextCondition(LogicConnector.AND, t0Ct5b);
        t0Ct3b.SetNextCondition(LogicConnector.AND, t0Ct4b);
        t0Ct2b.SetNextCondition(LogicConnector.AND, t0Ct3b);
        t0Ct1b.SetNextCondition(LogicConnector.AND, t0Ct2b);


        GuardMapping grdt0b = new GuardMapping();
        grdt0b.condition= t0Ct1b;
        grdt0b.Activations.add(new Activation(t0, "in9_1","in9_2", TransitionOperation.CalculateLightTimeRailway,"Delay"));
        grdt0b.Activations.add(new Activation(t0, "Delay",  TransitionOperation.MessageBox_Controllers_TwoLights));
        grdt0b.Activations.add(new Activation(t0, "L10", TransitionOperation.Copy, "Control"));
        grdt0b.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Copy, "r1g2"));
        grdt0b.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0b.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L10"));
        t0.GuardMappingList.add(grdt0b);

        // a train before the intersection on Railway 10
        Condition t0Ct1c = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2c = new Condition(t0, "in9_1", TransitionCondition.IsNull);
        Condition t0Ct3c = new Condition(t0, "in10_1", TransitionCondition.NotNull);
        Condition t0Ct4c = new Condition(t0, "in9_2", TransitionCondition.NotNull);
        Condition t0Ct5c = new Condition(t0, "in10_2", TransitionCondition.NotNull);

        t0Ct4c.SetNextCondition(LogicConnector.AND, t0Ct5c);
        t0Ct3c.SetNextCondition(LogicConnector.AND, t0Ct4c);
        t0Ct2c.SetNextCondition(LogicConnector.AND, t0Ct3c);
        t0Ct1c.SetNextCondition(LogicConnector.AND, t0Ct2c);

        GuardMapping grdt0c = new GuardMapping();
        grdt0c.condition= t0Ct1c;
        grdt0c.Activations.add(new Activation(t0, "in10_1","in10_2", TransitionOperation.CalculateLightTimeRailway,"Delay"));
        grdt0c.Activations.add(new Activation(t0, "Delay", "L9", TransitionOperation.MessageBox_Controllers_TwoLights));
        grdt0c.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0c.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0c.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L9"));
        t0.GuardMappingList.add(grdt0c);


        // trains on both railways
        // train on 9 speed > train on 10 speed
        Condition t0Ct1d = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2d = new Condition(t0, "in9_1", TransitionCondition.NotNull);
        Condition t0Ct3d = new Condition(t0, "in10_1", TransitionCondition.NotNull);
        Condition t0Ct4d = new Condition(t0, "in9_2", TransitionCondition.NotNull);
        Condition t0Ct5d = new Condition(t0, "in10_2", TransitionCondition.NotNull);
        Condition t0Ct6d = new Condition(t0, "in9_2", TransitionCondition.MoreThan, "in10_2");


        t0Ct5d.SetNextCondition(LogicConnector.AND, t0Ct6d);
        t0Ct4d.SetNextCondition(LogicConnector.AND, t0Ct5d);
        t0Ct3d.SetNextCondition(LogicConnector.AND, t0Ct4d);
        t0Ct2d.SetNextCondition(LogicConnector.AND, t0Ct3d);
        t0Ct1d.SetNextCondition(LogicConnector.AND, t0Ct2d);

        GuardMapping grdt0d = new GuardMapping();
        grdt0d.condition = t0Ct1d;
        grdt0d.Activations.add(new Activation(t0, "in9_1", "in9_2", TransitionOperation.CalculateLightTimeRailway, "Delay"));
        grdt0d.Activations.add(new Activation(t0, "Delay", "L10", TransitionOperation.MessageBox_Controllers_TwoLights));
        grdt0d.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0d.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0d.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L10"));
        t0.GuardMappingList.add(grdt0d);

        // train on 10 speed > train on 9 speed
        Condition t0Ct1e = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2e = new Condition(t0, "in9_1", TransitionCondition.NotNull);
        Condition t0Ct3e = new Condition(t0, "in10_1", TransitionCondition.NotNull);
        Condition t0Ct4e = new Condition(t0, "in9_2", TransitionCondition.NotNull);
        Condition t0Ct5e = new Condition(t0, "in10_2", TransitionCondition.NotNull);
        Condition t0Ct6e = new Condition(t0, "in10_2", TransitionCondition.MoreThan, "in9_2");


        t0Ct5e.SetNextCondition(LogicConnector.AND, t0Ct6e);
        t0Ct4e.SetNextCondition(LogicConnector.AND, t0Ct5e);
        t0Ct3e.SetNextCondition(LogicConnector.AND, t0Ct4e);
        t0Ct2e.SetNextCondition(LogicConnector.AND, t0Ct3e);
        t0Ct1e.SetNextCondition(LogicConnector.AND, t0Ct2e);

        GuardMapping grdt0e = new GuardMapping();
        grdt0e.condition = t0Ct1e;
        grdt0e.Activations.add(new Activation(t0, "in10_1", "in10_2", TransitionOperation.CalculateLightTimeRailway, "Delay"));
        grdt0e.Activations.add(new Activation(t0, "Delay", "L9", TransitionOperation.MessageBox_Controllers_TwoLights));
        grdt0e.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0e.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0e.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L9"));
        t0.GuardMappingList.add(grdt0e);


        // trains speeds =, train 9 length > train 10 length => 10 passes
        Condition t0Ct1f = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2f = new Condition(t0, "in9_1", TransitionCondition.NotNull);
        Condition t0Ct3f = new Condition(t0, "in10_1", TransitionCondition.NotNull);
        Condition t0Ct4f = new Condition(t0, "in9_2", TransitionCondition.NotNull);
        Condition t0Ct5f = new Condition(t0, "in10_2", TransitionCondition.NotNull);
        Condition t0Ct6f = new Condition(t0, "in10_2", TransitionCondition.Equal, "in9_2");
        Condition t0Ct7f = new Condition(t0, "in9_1", TransitionCondition.MoreThan_Length, "in10_1");


        t0Ct6f.SetNextCondition(LogicConnector.AND, t0Ct7f);
        t0Ct5f.SetNextCondition(LogicConnector.AND, t0Ct6f);
        t0Ct4f.SetNextCondition(LogicConnector.AND, t0Ct5f);
        t0Ct3f.SetNextCondition(LogicConnector.AND, t0Ct4f);
        t0Ct2f.SetNextCondition(LogicConnector.AND, t0Ct3f);
        t0Ct1f.SetNextCondition(LogicConnector.AND, t0Ct2f);

        GuardMapping grdt0f = new GuardMapping();
        grdt0f.condition = t0Ct1f;
        grdt0f.Activations.add(new Activation(t0, "in10_1", "in10_2", TransitionOperation.CalculateLightTimeRailway, "Delay"));
        grdt0f.Activations.add(new Activation(t0, "Delay", "L9", TransitionOperation.MessageBox_Controllers_TwoLights));
        grdt0f.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0f.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0f.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L9"));
        t0.GuardMappingList.add(grdt0f);


        // trains speeds =, train 10 length > train 9 length => 9 passes
        Condition t0Ct1g = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2g = new Condition(t0, "in9_1", TransitionCondition.NotNull);
        Condition t0Ct3g = new Condition(t0, "in10_1", TransitionCondition.NotNull);
        Condition t0Ct4g = new Condition(t0, "in9_2", TransitionCondition.NotNull);
        Condition t0Ct5g = new Condition(t0, "in10_2", TransitionCondition.NotNull);
        Condition t0Ct6g = new Condition(t0, "in10_2", TransitionCondition.Equal, "in9_2");
        Condition t0Ct7g = new Condition(t0, "in10_1", TransitionCondition.MoreThan_Length, "in9_1");


        t0Ct6g.SetNextCondition(LogicConnector.AND, t0Ct7g);
        t0Ct5g.SetNextCondition(LogicConnector.AND, t0Ct6g);
        t0Ct4g.SetNextCondition(LogicConnector.AND, t0Ct5g);
        t0Ct3g.SetNextCondition(LogicConnector.AND, t0Ct4g);
        t0Ct2g.SetNextCondition(LogicConnector.AND, t0Ct3g);
        t0Ct1g.SetNextCondition(LogicConnector.AND, t0Ct2g);


        GuardMapping grdt0g = new GuardMapping();
        grdt0g.condition = t0Ct1g;
        grdt0g.Activations.add(new Activation(t0, "in9_1", "in9_2", TransitionOperation.CalculateLightTimeRailway, "Delay"));
        grdt0g.Activations.add(new Activation(t0, "Delay", "L10", TransitionOperation.MessageBox_Controllers_TwoLights));
        grdt0g.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0g.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0g.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L10"));
        t0.GuardMappingList.add(grdt0g);


        // trains speeds =, train lengths =, train 10 passes
        Condition t0Ct1i = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2i = new Condition(t0, "in9_1", TransitionCondition.NotNull);
        Condition t0Ct3i = new Condition(t0, "in10_1", TransitionCondition.NotNull);
        Condition t0Ct4i = new Condition(t0, "in9_2", TransitionCondition.NotNull);
        Condition t0Ct5i = new Condition(t0, "in10_2", TransitionCondition.NotNull);
        Condition t0Ct6i = new Condition(t0, "in10_2", TransitionCondition.Equal, "in9_2");
        Condition t0Ct7i = new Condition(t0, "in10_1", TransitionCondition.Equal_Length, "in9_1");


        t0Ct6i.SetNextCondition(LogicConnector.AND, t0Ct7i);
        t0Ct5i.SetNextCondition(LogicConnector.AND, t0Ct6i);
        t0Ct4i.SetNextCondition(LogicConnector.AND, t0Ct5i);
        t0Ct3i.SetNextCondition(LogicConnector.AND, t0Ct4i);
        t0Ct2i.SetNextCondition(LogicConnector.AND, t0Ct3i);
        t0Ct1i.SetNextCondition(LogicConnector.AND, t0Ct2i);

        GuardMapping grdt0i = new GuardMapping();
        grdt0i.condition = t0Ct1i;
        grdt0i.Activations.add(new Activation(t0, "in10_1", "in10_2", TransitionOperation.CalculateLightTimeRailway, "Delay"));
        grdt0i.Activations.add(new Activation(t0, "Delay", "L9", TransitionOperation.MessageBox_Controllers_TwoLights));
        grdt0i.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0i.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0i.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L9"));
        t0.GuardMappingList.add(grdt0i);

        t0.Delay = 0;
        pn.Transitions.add(t0);




//tSetDelay--------------------------------------------------------
        PetriTransition tSetDelay = new PetriTransition(pn);
        tSetDelay.TransitionName = "tSetDelay";
        tSetDelay.InputPlaceName.add("Delay");
        tSetDelay.InputPlaceName.add("Delay");


        Condition tSetCt1 = new Condition(tSetDelay, "i", TransitionCondition.NotNull);

        GuardMapping grdtSet = new GuardMapping();
        grdtSet.condition= tSetCt1;
        grdtSet.Activations.add(new Activation(t1, "Delay", TransitionOperation.DynamicDelay,""));
        grdtSet.Activations.add(new Activation(t2, "Delay", TransitionOperation.DynamicDelay,""));
        grdtSet.Activations.add(new Activation(tSetDelay, "red", TransitionOperation.Move, "temp")); //to make sure it executes before t1 and t2
        tSetDelay.GuardMappingList.add(grdtSet);

        tSetDelay.Delay = 0;
        pn.Transitions.add(tSetDelay);
        pn.Transitions.add(t1);

        pn.Transitions.add(t2);





        // t3----------------------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "t3";
        t3.InputPlaceName.add("P1");


        Condition t3Ct1 = new Condition(t3, "P1", TransitionCondition.NotNull);


        GuardMapping grdt3 = new GuardMapping();
        grdt3.condition= t3Ct1;
        grdt3.Activations.add(new Activation(t3, "green", TransitionOperation.SendOverNetwork, "OP_L9"));
        grdt3.Activations.add(new Activation(t3, "P1", TransitionOperation.Move, "g1g2"));
        t3.GuardMappingList.add(grdt3);

        t3.Delay = 0;
        pn.Transitions.add(t3);


        // t4----------------------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "t4";
        t4.InputPlaceName.add("P1");


        Condition t4Ct1 = new Condition(t4, "P2", TransitionCondition.NotNull);


        GuardMapping grdt4 = new GuardMapping();
        grdt4.condition= t4Ct1;
        grdt4.Activations.add(new Activation(t4, "green", TransitionOperation.SendOverNetwork, "OP_L10"));
        grdt4.Activations.add(new Activation(t4, "P2", TransitionOperation.Move, "g1g2"));
        t4.GuardMappingList.add(grdt4);

        t4.Delay = 0;
        pn.Transitions.add(t4);


        System.out.println("Controller L9 L10 started \n ------------------------------");
        pn.Delay = 3000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.setTitle("Controller L9 L10");
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
