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

public class Controller_L11_L12 {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Controller L11 L12";
        pn.SetName("Controller L11 L12");

        pn.NetworkPort = 1086;


        DataString L11_L12 = new DataString();
        L11_L12.SetName("L11_L12");
        L11_L12.SetValue("L11_L12");
        pn.ConstantPlaceList.add(L11_L12);

        DataInteger Delay = new DataInteger();
        Delay.SetName("Delay");
        Delay.SetValue(0);
        pn.ConstantPlaceList.add(Delay);

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

        DataTrain in11_1 = new DataTrain();
        in11_1.SetName("in11_1");
        pn.PlaceList.add(in11_1);

        DataTrain in12_1 = new DataTrain();
        in12_1.SetName("in12_1");
        pn.PlaceList.add(in12_1);

        DataInteger in11_2 = new DataInteger();
        in11_2.SetName("in11_2");
        pn.PlaceList.add(in11_2);

        DataInteger in12_2 = new DataInteger();
        in12_2.SetName("in12_2");
        pn.PlaceList.add(in12_2);

        DataString P1 = new DataString();
        P1.SetName("P1");
        pn.PlaceList.add(P1);

        DataString P2 = new DataString();
        P2.SetName("P2");
        pn.PlaceList.add(P2);

        DataTransfer OP_L11 = new DataTransfer();
        OP_L11.SetName("OP_L11");
        OP_L11.Value = new TransferOperation("localhost", "1083" , "L11");
        pn.PlaceList.add(OP_L11);

        DataTransfer OP_L12 = new DataTransfer();
        OP_L12.SetName("OP_L12");
        OP_L12.Value = new TransferOperation("localhost", "1083" , "L12");
        pn.PlaceList.add(OP_L12);


        //----------------------------t_ini------------------------------------
        PetriTransition t_ini = new PetriTransition(pn);
        t_ini.TransitionName = "t_ini";

        Condition t_iniCt1 = new Condition(t_ini, "ini", TransitionCondition.NotNull);

        GuardMapping grdt_ini = new GuardMapping();
        grdt_ini.condition= t_iniCt1;

        grdt_ini.Activations.add(new Activation(t_ini, "ini", TransitionOperation.SendOverNetwork, "OP_L11"));
        grdt_ini.Activations.add(new Activation(t_ini, "ini", TransitionOperation.SendOverNetwork, "OP_L12"));
        grdt_ini.Activations.add(new Activation(t_ini, "", TransitionOperation.MakeNull, "ini"));

        t_ini.GuardMappingList.add(grdt_ini);

        t_ini.Delay = 0;
        pn.Transitions.add(t_ini);

        // t0----------------------------------------------------------------
        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "t0";
        t0.InputPlaceName.add("g1g2");
        t0.InputPlaceName.add("in11_1");
        t0.InputPlaceName.add("in11_2");
        t0.InputPlaceName.add("in12_1");
        t0.InputPlaceName.add("in12_2");

        // no trains
        Condition t0Ct1a1 = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2a1 = new Condition(t0, "in11_1", TransitionCondition.IsNull);
        Condition t0Ct3a1 = new Condition(t0, "in12_1", TransitionCondition.IsNull);
        Condition t0Ct4a1 = new Condition(t0, "in11_2", TransitionCondition.IsNull);
        Condition t0Ct5a1 = new Condition(t0, "in12_2", TransitionCondition.IsNull);

        t0Ct5a1.SetNextCondition(LogicConnector.AND, t0Ct4a1);
        t0Ct4a1.SetNextCondition(LogicConnector.AND, t0Ct3a1);
        t0Ct3a1.SetNextCondition(LogicConnector.AND, t0Ct2a1);
        t0Ct2a1.SetNextCondition(LogicConnector.AND, t0Ct1a1);

        GuardMapping grdt0a1 = new GuardMapping();
        grdt0a1.condition= t0Ct2a1;
        grdt0a1.Activations.add(new Activation(t0, "",TransitionOperation.DoNothing,""));
        t0.GuardMappingList.add(grdt0a1);

        // a train before the intersection on Railway 11
        Condition t0Ct1b = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2b = new Condition(t0, "in11_1", TransitionCondition.NotNull);
        Condition t0Ct3b = new Condition(t0, "in12_1", TransitionCondition.IsNull);
        Condition t0Ct4b = new Condition(t0, "in11_2", TransitionCondition.NotNull);
        Condition t0Ct5b = new Condition(t0, "in12_2", TransitionCondition.NotNull);

        t0Ct5b.SetNextCondition(LogicConnector.AND, t0Ct4b);
        t0Ct4b.SetNextCondition(LogicConnector.AND, t0Ct3b);
        t0Ct3b.SetNextCondition(LogicConnector.AND, t0Ct2b);
        t0Ct2b.SetNextCondition(LogicConnector.AND, t0Ct1b);

        GuardMapping grdt0b = new GuardMapping();
        grdt0b.condition= t0Ct1b;
        grdt0b.Activations.add(new Activation(t0, "in11_1","in11_2", TransitionOperation.CalculateLightTimeRailway,"Delay"));

        grdt0b.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0b.Activations.add(new Activation(t0, "Delay", "L11_L12", TransitionOperation.MessageBox_Controllers));
        grdt0b.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0b.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L12"));
        t0.GuardMappingList.add(grdt0b);

        // a train before the intersection on Railway 12
        Condition t0Ct1c = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2c = new Condition(t0, "in11_1", TransitionCondition.IsNull);
        Condition t0Ct3c = new Condition(t0, "in12_1", TransitionCondition.NotNull);
        Condition t0Ct4c = new Condition(t0, "in11_2", TransitionCondition.NotNull);
        Condition t0Ct5c = new Condition(t0, "in12_2", TransitionCondition.NotNull);

        t0Ct5c.SetNextCondition(LogicConnector.AND, t0Ct4c);
        t0Ct4c.SetNextCondition(LogicConnector.AND, t0Ct3c);
        t0Ct3c.SetNextCondition(LogicConnector.AND, t0Ct2c);
        t0Ct2c.SetNextCondition(LogicConnector.AND, t0Ct1c);

        GuardMapping grdt0c = new GuardMapping();
        grdt0c.condition= t0Ct1c;
        grdt0c.Activations.add(new Activation(t0, "in12_1","in12_2", TransitionOperation.CalculateLightTimeRailway,"Delay"));
        grdt0c.Activations.add(new Activation(t0, "Delay", "L11_L12", TransitionOperation.MessageBox_Controllers));
        grdt0c.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0c.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0c.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L11"));
        t0.GuardMappingList.add(grdt0c);


        // trains on both railways
        // train on 11 speed > train on 12 speed
        Condition t0Ct1d = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2d = new Condition(t0, "in11_1", TransitionCondition.NotNull);
        Condition t0Ct3d = new Condition(t0, "in12_1", TransitionCondition.NotNull);
        Condition t0Ct4d = new Condition(t0, "in11_2", TransitionCondition.NotNull);
        Condition t0Ct5d = new Condition(t0, "in12_2", TransitionCondition.NotNull);
        Condition t0Ct6d = new Condition(t0, "in11_2", TransitionCondition.MoreThan,"in12_2");

        t0Ct6d.SetNextCondition(LogicConnector.AND, t0Ct5d);
        t0Ct5d.SetNextCondition(LogicConnector.AND, t0Ct4d);
        t0Ct4d.SetNextCondition(LogicConnector.AND, t0Ct3d);
        t0Ct3d.SetNextCondition(LogicConnector.AND, t0Ct2d);
        t0Ct2d.SetNextCondition(LogicConnector.AND, t0Ct1d);

        GuardMapping grdt0d = new GuardMapping();
        grdt0d.condition= t0Ct1d;
        grdt0d.Activations.add(new Activation(t0, "in11_1","in11_2", TransitionOperation.CalculateLightTimeRailway,"Delay"));
        grdt0d.Activations.add(new Activation(t0, "Delay", "L11_L12", TransitionOperation.MessageBox_Controllers));
        grdt0d.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0d.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0d.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L12"));
        t0.GuardMappingList.add(grdt0d);

        // train on 12 speed > train on 11 speed
        Condition t0Ct1e = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2e = new Condition(t0, "in11_1", TransitionCondition.NotNull);
        Condition t0Ct3e = new Condition(t0, "in12_1", TransitionCondition.NotNull);
        Condition t0Ct4e = new Condition(t0, "in11_2", TransitionCondition.NotNull);
        Condition t0Ct5e = new Condition(t0, "in12_2", TransitionCondition.NotNull);
        Condition t0Ct6e = new Condition(t0, "in12_2", TransitionCondition.MoreThan,"in11_2");

        t0Ct6e.SetNextCondition(LogicConnector.AND, t0Ct5e);
        t0Ct5e.SetNextCondition(LogicConnector.AND, t0Ct4e);
        t0Ct4e.SetNextCondition(LogicConnector.AND, t0Ct3e);
        t0Ct3e.SetNextCondition(LogicConnector.AND, t0Ct2e);
        t0Ct2e.SetNextCondition(LogicConnector.AND, t0Ct1e);

        GuardMapping grdt0e = new GuardMapping();
        grdt0e.condition= t0Ct1e;
        grdt0e.Activations.add(new Activation(t0, "in12_1","in12_2", TransitionOperation.CalculateLightTimeRailway,"Delay"));
        grdt0e.Activations.add(new Activation(t0, "Delay", "L11_L12", TransitionOperation.MessageBox_Controllers));
        grdt0e.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0e.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0e.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L11"));
        t0.GuardMappingList.add(grdt0e);

        // trains speeds =, train 11 length > train 12 length => 12 passes
        Condition t0Ct1f = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2f = new Condition(t0, "in11_1", TransitionCondition.NotNull);
        Condition t0Ct3f = new Condition(t0, "in12_1", TransitionCondition.NotNull);
        Condition t0Ct4f = new Condition(t0, "in11_2", TransitionCondition.NotNull);
        Condition t0Ct5f = new Condition(t0, "in12_2", TransitionCondition.NotNull);
        Condition t0Ct6f = new Condition(t0, "in12_2", TransitionCondition.Equal,"in11_2");
        Condition t0Ct11f = new Condition(t0, "in11_1", TransitionCondition.MoreThan_Length,"in12_1");

        t0Ct11f.SetNextCondition(LogicConnector.AND, t0Ct6f);
        t0Ct6f.SetNextCondition(LogicConnector.AND, t0Ct5f);
        t0Ct5f.SetNextCondition(LogicConnector.AND, t0Ct4f);
        t0Ct4f.SetNextCondition(LogicConnector.AND, t0Ct3f);
        t0Ct3f.SetNextCondition(LogicConnector.AND, t0Ct2f);
        t0Ct2f.SetNextCondition(LogicConnector.AND, t0Ct1f);

        GuardMapping grdt0f = new GuardMapping();
        grdt0f.condition= t0Ct1f;
        grdt0f.Activations.add(new Activation(t0, "in12_1","in12_2", TransitionOperation.CalculateLightTimeRailway,"Delay"));
        grdt0f.Activations.add(new Activation(t0, "Delay", "L11_L12", TransitionOperation.MessageBox_Controllers));
        grdt0f.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0f.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0f.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L11"));
        t0.GuardMappingList.add(grdt0f);

        // trains speeds =, train 12 length > train 11 length => 11 passes
        Condition t0Ct1g = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2g = new Condition(t0, "in11_1", TransitionCondition.NotNull);
        Condition t0Ct3g = new Condition(t0, "in12_1", TransitionCondition.NotNull);
        Condition t0Ct4g = new Condition(t0, "in11_2", TransitionCondition.NotNull);
        Condition t0Ct5g = new Condition(t0, "in12_2", TransitionCondition.NotNull);
        Condition t0Ct6g = new Condition(t0, "in12_2", TransitionCondition.Equal,"in11_2");
        Condition t0Ct11g = new Condition(t0, "in12_1", TransitionCondition.MoreThan_Length,"in11_1");

        t0Ct11g.SetNextCondition(LogicConnector.AND, t0Ct6g);
        t0Ct6g.SetNextCondition(LogicConnector.AND, t0Ct5g);
        t0Ct5g.SetNextCondition(LogicConnector.AND, t0Ct4g);
        t0Ct4g.SetNextCondition(LogicConnector.AND, t0Ct3g);
        t0Ct3g.SetNextCondition(LogicConnector.AND, t0Ct2g);
        t0Ct2g.SetNextCondition(LogicConnector.AND, t0Ct1g);

        GuardMapping grdt0g = new GuardMapping();
        grdt0g.condition= t0Ct1g;
        grdt0g.Activations.add(new Activation(t0, "in11_1","in11_2", TransitionOperation.CalculateLightTimeRailway,"Delay"));
        grdt0g.Activations.add(new Activation(t0, "Delay", "L11_L12", TransitionOperation.MessageBox_Controllers));
        grdt0g.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0g.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0g.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L12"));
        t0.GuardMappingList.add(grdt0g);

        // trains speeds =, train lengths =, train 11 passes
        Condition t0Ct1h = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2h = new Condition(t0, "in11_1", TransitionCondition.NotNull);
        Condition t0Ct3h = new Condition(t0, "in12_1", TransitionCondition.NotNull);
        Condition t0Ct4h = new Condition(t0, "in11_2", TransitionCondition.NotNull);
        Condition t0Ct5h = new Condition(t0, "in12_2", TransitionCondition.NotNull);
        Condition t0Ct6h = new Condition(t0, "in12_2", TransitionCondition.Equal,"in11_2");
        Condition t0Ct11h = new Condition(t0, "in12_1", TransitionCondition.Equal_Length,"in11_1");

        t0Ct11h.SetNextCondition(LogicConnector.AND, t0Ct6h);
        t0Ct6h.SetNextCondition(LogicConnector.AND, t0Ct5h);
        t0Ct5h.SetNextCondition(LogicConnector.AND, t0Ct4h);
        t0Ct4h.SetNextCondition(LogicConnector.AND, t0Ct3h);
        t0Ct3h.SetNextCondition(LogicConnector.AND, t0Ct2h);
        t0Ct2h.SetNextCondition(LogicConnector.AND, t0Ct1h);

        GuardMapping grdt0h = new GuardMapping();
        grdt0h.condition= t0Ct1h;
        grdt0h.Activations.add(new Activation(t0, "in11_1","in11_2", TransitionOperation.CalculateLightTimeRailway,"Delay"));
        grdt0h.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0h.Activations.add(new Activation(t0, "Delay", "L11_L12", TransitionOperation.MessageBox_Controllers));
        grdt0h.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0h.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L12"));
        t0.GuardMappingList.add(grdt0h);

        t0.Delay = 0;
        pn.Transitions.add(t0);


        // t1----------------------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("r1g2");


        Condition t1Ct1 = new Condition(t1, "r1g2", TransitionCondition.NotNull);


        GuardMapping grdt1 = new GuardMapping();
        grdt1.condition= t1Ct1;
        grdt1.Activations.add(new Activation(t1, "r1g2", TransitionOperation.Move, "P1"));
        t1.GuardMappingList.add(grdt1);

        t1.Delay =5;
        pn.Transitions.add(t1);


        // t2----------------------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("g1r2");


        Condition t2Ct1 = new Condition(t2, "g1r2", TransitionCondition.NotNull);


        GuardMapping grdt2 = new GuardMapping();
        grdt2.condition= t2Ct1;
        grdt2.Activations.add(new Activation(t2, "g1r2", TransitionOperation.Move, "P2"));
        t2.GuardMappingList.add(grdt2);

        t2.Delay = 5;
        pn.Transitions.add(t2);


        // t3----------------------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "t3";
        t3.InputPlaceName.add("P1");


        Condition t3Ct1 = new Condition(t3, "P1", TransitionCondition.NotNull);


        GuardMapping grdt3 = new GuardMapping();
        grdt3.condition= t3Ct1;
        grdt3.Activations.add(new Activation(t3, "green", TransitionOperation.SendOverNetwork, "OP_L12_"));
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
        grdt4.Activations.add(new Activation(t4, "green", TransitionOperation.SendOverNetwork, "OP_L12"));
        grdt4.Activations.add(new Activation(t4, "P2", TransitionOperation.Move, "g1g2"));
        t4.GuardMappingList.add(grdt4);

        t4.Delay = 0;
        pn.Transitions.add(t4);

        System.out.println("Controller L11 L12 started \n ------------------------------");
        pn.Delay = 3000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.setTitle("Controller L11 L12");
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
