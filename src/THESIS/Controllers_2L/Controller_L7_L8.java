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

public class Controller_L7_L8 {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Controller L7 L8";
        pn.SetName("Controller L7 L8");

        pn.NetworkPort = 1083;


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

        DataTrain in7_1 = new DataTrain();
        in7_1.SetName("in7_1");
        pn.PlaceList.add(in7_1);

        DataTrain in8_1 = new DataTrain();
        in8_1.SetName("in8_1");
        pn.PlaceList.add(in8_1);

        DataInteger in7_2 = new DataInteger();
        in7_2.SetName("in7_2");
        in7_2.SetValue(0);
        pn.PlaceList.add(in7_2);

        DataInteger in8_2 = new DataInteger();
        in8_2.SetName("in8_2");
        in8_2.SetValue(0);
        pn.PlaceList.add(in8_2);

        DataString P1 = new DataString();
        P1.SetName("P1");
        pn.PlaceList.add(P1);

        DataString P2 = new DataString();
        P2.SetName("P2");
        pn.PlaceList.add(P2);

        DataTransfer OP_L7 = new DataTransfer();
        OP_L7.SetName("OP_L7");
        OP_L7.Value = new TransferOperation("localhost", "1083" , "L7");
        pn.PlaceList.add(OP_L7);

        DataTransfer OP_L8 = new DataTransfer();
        OP_L8.SetName("OP_L8");
        OP_L8.Value = new TransferOperation("localhost", "1083" , "L8");
        pn.PlaceList.add(OP_L8);


        //----------------------------t_ini------------------------------------
        PetriTransition t_ini = new PetriTransition(pn);
        t_ini.TransitionName = "t_ini";

        Condition t_iniCt1 = new Condition(t_ini, "ini", TransitionCondition.NotNull);

        GuardMapping grdt_ini = new GuardMapping();
        grdt_ini.condition= t_iniCt1;

        grdt_ini.Activations.add(new Activation(t_ini, "ini", TransitionOperation.SendOverNetwork, "OP_L7"));
        grdt_ini.Activations.add(new Activation(t_ini, "ini", TransitionOperation.SendOverNetwork, "OP_L8"));
        grdt_ini.Activations.add(new Activation(t_ini, "", TransitionOperation.MakeNull, "ini"));

        t_ini.GuardMappingList.add(grdt_ini);

        t_ini.Delay = 0;
        pn.Transitions.add(t_ini);

        // t0----------------------------------------------------------------
        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "t0";
        t0.InputPlaceName.add("g1g2");
        t0.InputPlaceName.add("in7_1");
        t0.InputPlaceName.add("in7_2");
        t0.InputPlaceName.add("in8_1");
        t0.InputPlaceName.add("in8_2");

        // not a single train before the intersection
        Condition t0Ct1a = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2a = new Condition(t0, "in7_1", TransitionCondition.IsNull);
        Condition t0Ct3a = new Condition(t0, "in8_1", TransitionCondition.IsNull);
        Condition t0Ct4a = new Condition(t0, "in7_2", TransitionCondition.NotNull); // always like this because the user introduces in the GUI each speed on the railways
        Condition t0Ct5a = new Condition(t0, "in8_2", TransitionCondition.NotNull);

        t0Ct5a.SetNextCondition(LogicConnector.AND, t0Ct4a);
        t0Ct4a.SetNextCondition(LogicConnector.AND, t0Ct3a);
        t0Ct3a.SetNextCondition(LogicConnector.AND, t0Ct2a);
        t0Ct2a.SetNextCondition(LogicConnector.AND, t0Ct1a);

        GuardMapping grdt0a = new GuardMapping();
        grdt0a.condition= t0Ct1a;
        grdt0a.Activations.add(new Activation(t0, null,null, TransitionOperation.CalculateLightTimeRailway,Delay));
        grdt0a.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0a.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0a.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L7"));
        grdt0a.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L8"));
        t0.GuardMappingList.add(grdt0a);

        // a train before the intersection on Railway 7
        Condition t0Ct1b = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2b = new Condition(t0, "in7_1", TransitionCondition.NotNull);
        Condition t0Ct3b = new Condition(t0, "in8_1", TransitionCondition.IsNull);
        Condition t0Ct4b = new Condition(t0, "in7_2", TransitionCondition.NotNull);
        Condition t0Ct5b = new Condition(t0, "in8_2", TransitionCondition.NotNull);

        t0Ct5b.SetNextCondition(LogicConnector.AND, t0Ct4b);
        t0Ct4b.SetNextCondition(LogicConnector.AND, t0Ct3b);
        t0Ct3b.SetNextCondition(LogicConnector.AND, t0Ct2b);
        t0Ct2b.SetNextCondition(LogicConnector.AND, t0Ct1b);

        GuardMapping grdt0b = new GuardMapping();
        grdt0b.condition= t0Ct1b;
        grdt0b.Activations.add(new Activation(t0, in7_1,in7_2, TransitionOperation.CalculateLightTimeRailway,Delay));
        grdt0b.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0b.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0b.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L8"));
        t0.GuardMappingList.add(grdt0b);

        // a train before the intersection on Railway 8
        Condition t0Ct1c = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2c = new Condition(t0, "in7_1", TransitionCondition.IsNull);
        Condition t0Ct3c = new Condition(t0, "in8_1", TransitionCondition.NotNull);
        Condition t0Ct4c = new Condition(t0, "in7_2", TransitionCondition.NotNull);
        Condition t0Ct5c = new Condition(t0, "in8_2", TransitionCondition.NotNull);

        t0Ct5c.SetNextCondition(LogicConnector.AND, t0Ct4c);
        t0Ct4c.SetNextCondition(LogicConnector.AND, t0Ct3c);
        t0Ct3c.SetNextCondition(LogicConnector.AND, t0Ct2c);
        t0Ct2c.SetNextCondition(LogicConnector.AND, t0Ct1c);

        GuardMapping grdt0c = new GuardMapping();
        grdt0c.condition= t0Ct1c;
        grdt0c.Activations.add(new Activation(t0, in8_1,in8_2, TransitionOperation.CalculateLightTimeRailway,Delay));
        grdt0c.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0c.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0c.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L7"));
        t0.GuardMappingList.add(grdt0c);


        // trains on both railways
        // train on 7 speed > train on 8 speed
        Condition t0Ct1d = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2d = new Condition(t0, "in7_1", TransitionCondition.NotNull);
        Condition t0Ct3d = new Condition(t0, "in8_1", TransitionCondition.NotNull);
        Condition t0Ct4d = new Condition(t0, "in7_2", TransitionCondition.NotNull);
        Condition t0Ct5d = new Condition(t0, "in8_2", TransitionCondition.NotNull);
        Condition t0Ct6d = new Condition(t0, "in7_2", TransitionCondition.MoreThan,"in8_2");

        t0Ct6d.SetNextCondition(LogicConnector.AND, t0Ct5d);
        t0Ct5d.SetNextCondition(LogicConnector.AND, t0Ct4d);
        t0Ct4d.SetNextCondition(LogicConnector.AND, t0Ct3d);
        t0Ct3d.SetNextCondition(LogicConnector.AND, t0Ct2d);
        t0Ct2d.SetNextCondition(LogicConnector.AND, t0Ct1d);

        GuardMapping grdt0d = new GuardMapping();
        grdt0d.condition= t0Ct1d;
        grdt0d.Activations.add(new Activation(t0, in7_1,in7_2, TransitionOperation.CalculateLightTimeRailway,Delay));
        grdt0d.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0d.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0d.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L8"));
        t0.GuardMappingList.add(grdt0d);

        // train on 8 speed > train on 7 speed
        Condition t0Ct1e = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2e = new Condition(t0, "in7_1", TransitionCondition.NotNull);
        Condition t0Ct3e = new Condition(t0, "in8_1", TransitionCondition.NotNull);
        Condition t0Ct4e = new Condition(t0, "in7_2", TransitionCondition.NotNull);
        Condition t0Ct5e = new Condition(t0, "in8_2", TransitionCondition.NotNull);
        Condition t0Ct6e = new Condition(t0, "in8_2", TransitionCondition.MoreThan,"in7_2");

        t0Ct6e.SetNextCondition(LogicConnector.AND, t0Ct5e);
        t0Ct5e.SetNextCondition(LogicConnector.AND, t0Ct4e);
        t0Ct4e.SetNextCondition(LogicConnector.AND, t0Ct3e);
        t0Ct3e.SetNextCondition(LogicConnector.AND, t0Ct2e);
        t0Ct2e.SetNextCondition(LogicConnector.AND, t0Ct1e);

        GuardMapping grdt0e = new GuardMapping();
        grdt0e.condition= t0Ct1e;
        grdt0e.Activations.add(new Activation(t0, in8_1,in8_2, TransitionOperation.CalculateLightTimeRailway,Delay));
        grdt0e.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0e.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0e.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L7"));
        t0.GuardMappingList.add(grdt0e);

        // trains speeds =, train 7 length > train 8 length => 8 passes
        Condition t0Ct1f = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2f = new Condition(t0, "in7_1", TransitionCondition.NotNull);
        Condition t0Ct3f = new Condition(t0, "in8_1", TransitionCondition.NotNull);
        Condition t0Ct4f = new Condition(t0, "in7_2", TransitionCondition.NotNull);
        Condition t0Ct5f = new Condition(t0, "in8_2", TransitionCondition.NotNull);
        Condition t0Ct6f = new Condition(t0, "in8_2", TransitionCondition.Equal,"in7_2");
        Condition t0Ct7f = new Condition(t0, "in7_1", TransitionCondition.MoreThan_Length,"in8_1");

        t0Ct7f.SetNextCondition(LogicConnector.AND, t0Ct6f);
        t0Ct6f.SetNextCondition(LogicConnector.AND, t0Ct5f);
        t0Ct5f.SetNextCondition(LogicConnector.AND, t0Ct4f);
        t0Ct4f.SetNextCondition(LogicConnector.AND, t0Ct3f);
        t0Ct3f.SetNextCondition(LogicConnector.AND, t0Ct2f);
        t0Ct2f.SetNextCondition(LogicConnector.AND, t0Ct1f);

        GuardMapping grdt0f = new GuardMapping();
        grdt0f.condition= t0Ct1f;
        grdt0f.Activations.add(new Activation(t0, in8_1,in8_2, TransitionOperation.CalculateLightTimeRailway,Delay));
        grdt0f.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0f.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0f.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L7"));
        t0.GuardMappingList.add(grdt0f);

        // trains speeds =, train 8 length > train 7 length => 7 passes
        Condition t0Ct1g = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2g = new Condition(t0, "in7_1", TransitionCondition.NotNull);
        Condition t0Ct3g = new Condition(t0, "in8_1", TransitionCondition.NotNull);
        Condition t0Ct4g = new Condition(t0, "in7_2", TransitionCondition.NotNull);
        Condition t0Ct5g = new Condition(t0, "in8_2", TransitionCondition.NotNull);
        Condition t0Ct6g = new Condition(t0, "in8_2", TransitionCondition.Equal,"in7_2");
        Condition t0Ct7g = new Condition(t0, "in8_1", TransitionCondition.MoreThan_Length,"in7_1");

        t0Ct7g.SetNextCondition(LogicConnector.AND, t0Ct6g);
        t0Ct6g.SetNextCondition(LogicConnector.AND, t0Ct5g);
        t0Ct5g.SetNextCondition(LogicConnector.AND, t0Ct4g);
        t0Ct4g.SetNextCondition(LogicConnector.AND, t0Ct3g);
        t0Ct3g.SetNextCondition(LogicConnector.AND, t0Ct2g);
        t0Ct2g.SetNextCondition(LogicConnector.AND, t0Ct1g);

        GuardMapping grdt0g = new GuardMapping();
        grdt0g.condition= t0Ct1g;
        grdt0g.Activations.add(new Activation(t0, in7_1,in7_2, TransitionOperation.CalculateLightTimeRailway,Delay));
        grdt0g.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0g.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0g.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L8"));
        t0.GuardMappingList.add(grdt0g);

        // trains speeds =, train lengths =, train 7 passes
        Condition t0Ct1h = new Condition(t0, "g1g2", TransitionCondition.NotNull);
        Condition t0Ct2h = new Condition(t0, "in7_1", TransitionCondition.NotNull);
        Condition t0Ct3h = new Condition(t0, "in8_1", TransitionCondition.NotNull);
        Condition t0Ct4h = new Condition(t0, "in7_2", TransitionCondition.NotNull);
        Condition t0Ct5h = new Condition(t0, "in8_2", TransitionCondition.NotNull);
        Condition t0Ct6h = new Condition(t0, "in8_2", TransitionCondition.Equal,"in7_2");
        Condition t0Ct7h = new Condition(t0, "in8_1", TransitionCondition.Equal_Length,"in7_1");

        t0Ct7h.SetNextCondition(LogicConnector.AND, t0Ct6h);
        t0Ct6h.SetNextCondition(LogicConnector.AND, t0Ct5h);
        t0Ct5h.SetNextCondition(LogicConnector.AND, t0Ct4h);
        t0Ct4h.SetNextCondition(LogicConnector.AND, t0Ct3h);
        t0Ct3h.SetNextCondition(LogicConnector.AND, t0Ct2h);
        t0Ct2h.SetNextCondition(LogicConnector.AND, t0Ct1h);

        GuardMapping grdt0h = new GuardMapping();
        grdt0h.condition= t0Ct1h;
        grdt0h.Activations.add(new Activation(t0, in7_1,in7_2, TransitionOperation.CalculateLightTimeRailway,Delay));
        grdt0h.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "r1g2"));
        grdt0h.Activations.add(new Activation(t0, "g1g2", TransitionOperation.Move, "g1r2"));
        grdt0h.Activations.add(new Activation(t0, "red", TransitionOperation.SendOverNetwork, "OP_L8"));
        t0.GuardMappingList.add(grdt0h);

        t0.Delay = 0;
        pn.Transitions.add(t0);



    }
}
