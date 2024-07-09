package THESIS.Controllers_1L;

import Components.*;
import DataObjects.*;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

import java.time.LocalTime;

public class Controller_L1 {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Controller L1";
        pn.SetName("Controller L1");

        pn.NetworkPort = 1082;

        DataString L1 = new DataString();
        L1.SetName("L1");
        L1.SetValue("L1");
        pn.ConstantPlaceList.add(L1);

        DataInteger Delay = new DataInteger();
        Delay.SetName("Delay");
        Delay.SetValue(0);
        pn.ConstantPlaceList.add(Delay);

        DataListTrainsQueue in_a1 = new DataListTrainsQueue(); // time to pass for the prev train
        in_a1.SetName("in_a1");
        pn.PlaceList.add(in_a1);

        DataListTrainsQueue in_a2 = new DataListTrainsQueue(); // time to pass for the prev train
        in_a2.SetName("in_a1");
        pn.PlaceList.add(in_a2);

        DataListTrainsQueue in_a3 = new DataListTrainsQueue(); // time to pass for the prev train
        in_a3.SetName("in_a3");
        pn.PlaceList.add(in_a3);

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

        DataString r = new DataString();
        r.SetName("r");
        pn.PlaceList.add(r);

        DataString i = new DataString();
        i.SetName("i");
        pn.PlaceList.add(i);

        DataString g = new DataString();
        g.SetName("g");
        g.SetValue("signal"); ///???
        pn.PlaceList.add(g);

        DataTransfer OP_L1 = new DataTransfer();
        OP_L1.SetName("OP_L1");
        OP_L1.Value = new TransferOperation("localhost", "1083" , "L1");
        pn.PlaceList.add(OP_L1);

        //----------------------------t_ini------------------------------------
        PetriTransition t_ini = new PetriTransition(pn);
        t_ini.TransitionName = "t_ini";

        Condition t_iniCt1 = new Condition(t_ini, "ini", TransitionCondition.NotNull);

        GuardMapping grdt_ini = new GuardMapping();
        grdt_ini.condition= t_iniCt1;

        grdt_ini.Activations.add(new Activation(t_ini, "ini", TransitionOperation.SendOverNetwork, "OP_L1"));
        grdt_ini.Activations.add(new Activation(t_ini, "", TransitionOperation.MakeNull, "ini"));

        t_ini.GuardMappingList.add(grdt_ini);

        t_ini.Delay = 0;
        pn.Transitions.add(t_ini);




        // t1----------------------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("g");
        t1.InputPlaceName.add("in_a1");
        t1.InputPlaceName.add("in_a2");
        t1.InputPlaceName.add("in_a3");


        // 1 comming train on A1
        Condition t1Ct1b = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2b = new Condition(t1, "in_a1", TransitionCondition.NotNull);
        Condition t1Ct3b = new Condition(t1, "in_a2", TransitionCondition.IsNull);
        Condition t1Ct4b = new Condition(t1, "in_a3", TransitionCondition.IsNull);

        t1Ct4b.SetNextCondition(LogicConnector.AND, t1Ct3b);
        t1Ct3b.SetNextCondition(LogicConnector.AND, t1Ct2b);
        t1Ct2b.SetNextCondition(LogicConnector.AND, t1Ct1b);

        GuardMapping grdt1b = new GuardMapping();
        grdt1b.condition= t1Ct1b;
        grdt1b.Activations.add(new Activation(t1, in_a1,null,null,TransitionOperation.CalculateLightTimeStation, Delay));
        grdt1b.Activations.add(new Activation(t1, Delay, L1, TransitionOperation.MessageBox_Controllers));
        grdt1b.Activations.add(new Activation(t1, Delay, L1, TransitionOperation.MessageBox_Controllers));
        grdt1b.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1b.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L1"));
        t1.GuardMappingList.add(grdt1b);


        // 1 comming train on A2
        Condition t1Ct1c = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2c = new Condition(t1, "in_a1", TransitionCondition.IsNull);
        Condition t1Ct3c= new Condition(t1, "in_a2", TransitionCondition.NotNull);
        Condition t1Ct4c = new Condition(t1, "in_a3", TransitionCondition.IsNull);

        t1Ct4c.SetNextCondition(LogicConnector.AND, t1Ct3c);
        t1Ct3c.SetNextCondition(LogicConnector.AND, t1Ct2c);
        t1Ct2c.SetNextCondition(LogicConnector.AND, t1Ct1c);

        GuardMapping grdt1c = new GuardMapping();
        grdt1c.condition= t1Ct1c;
        grdt1c.Activations.add(new Activation(t1, null,in_a2,null,TransitionOperation.CalculateLightTimeStation, Delay));
        grdt1c.Activations.add(new Activation(t1, Delay, L1, TransitionOperation.MessageBox_Controllers));
        grdt1c.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1c.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L1"));
        t1.GuardMappingList.add(grdt1c);


        // 1 comming train on A3
        Condition t1Ct1d = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2d = new Condition(t1, "in_a1", TransitionCondition.IsNull);
        Condition t1Ct3d = new Condition(t1, "in_a2", TransitionCondition.IsNull);
        Condition t1Ct4d = new Condition(t1, "in_a3", TransitionCondition.NotNull);

        t1Ct4d.SetNextCondition(LogicConnector.AND, t1Ct3d);
        t1Ct3d.SetNextCondition(LogicConnector.AND, t1Ct2d);
        t1Ct2d.SetNextCondition(LogicConnector.AND, t1Ct1d);

        GuardMapping grdt1d = new GuardMapping();
        grdt1d.condition= t1Ct1d;
        grdt1d.Activations.add(new Activation(t1, null,null,in_a3,TransitionOperation.CalculateLightTimeStation,Delay));
        grdt1d.Activations.add(new Activation(t1, Delay, L1, TransitionOperation.MessageBox_Controllers));
        grdt1d.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1d.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L1"));
        t1.GuardMappingList.add(grdt1d);


        // 2 coming trains on A1 A2
        Condition t1Ct1e = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2e = new Condition(t1, "in_a1", TransitionCondition.NotNull);
        Condition t1Ct3e = new Condition(t1, "in_a2", TransitionCondition.NotNull);
        Condition t1Ct4e = new Condition(t1, "in_a3", TransitionCondition.IsNull);

        t1Ct4e.SetNextCondition(LogicConnector.AND, t1Ct3e);
        t1Ct3e.SetNextCondition(LogicConnector.AND, t1Ct2e);
        t1Ct2e.SetNextCondition(LogicConnector.AND, t1Ct1e);

        GuardMapping grdt1e = new GuardMapping();
        grdt1e.condition= t1Ct1e;

        grdt1e.Activations.add(new Activation(t1, in_a1, in_a2, null, TransitionOperation.CalculateLightTimeStation, Delay));
        grdt1e.Activations.add(new Activation(t1, Delay, L1, TransitionOperation.MessageBox_Controllers));
        grdt1e.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1e.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L1"));
        t1.GuardMappingList.add(grdt1e);

        // 2 coming trains on A1 A3
        Condition t1Ct1f = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2f = new Condition(t1, "in_a1", TransitionCondition.NotNull);
        Condition t1Ct3f = new Condition(t1, "in_a2", TransitionCondition.IsNull);
        Condition t1Ct4f = new Condition(t1, "in_a3", TransitionCondition.NotNull);

        t1Ct4f.SetNextCondition(LogicConnector.AND, t1Ct3f);
        t1Ct3f.SetNextCondition(LogicConnector.AND, t1Ct2f);
        t1Ct2f.SetNextCondition(LogicConnector.AND, t1Ct1f);

        GuardMapping grdt1f = new GuardMapping();
        grdt1f.condition= t1Ct1f;
        grdt1f.Activations.add(new Activation(t1, in_a1, null, in_a3, TransitionOperation.CalculateLightTimeStation, Delay));
        grdt1f.Activations.add(new Activation(t1, Delay, L1, TransitionOperation.MessageBox_Controllers));
        grdt1f.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1f.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L1"));
        t1.GuardMappingList.add(grdt1f);

        // 2 coming trains on A2 A3
        Condition t1Ct1g = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2g = new Condition(t1, "in_a1", TransitionCondition.IsNull);
        Condition t1Ct3g = new Condition(t1, "in_a2", TransitionCondition.NotNull);
        Condition t1Ct4g = new Condition(t1, "in_a3", TransitionCondition.NotNull);

        t1Ct4g.SetNextCondition(LogicConnector.AND, t1Ct3g);
        t1Ct3g.SetNextCondition(LogicConnector.AND, t1Ct2g);
        t1Ct2g.SetNextCondition(LogicConnector.AND, t1Ct1g);

        GuardMapping grdt1g = new GuardMapping();
        grdt1g.condition= t1Ct1g;
        grdt1g.Activations.add(new Activation(t1, null, in_a2, in_a3, TransitionOperation.CalculateLightTimeStation, Delay));
        grdt1g.Activations.add(new Activation(t1, Delay, L1, TransitionOperation.MessageBox_Controllers));
        grdt1g.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1g.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L1"));
        t1.GuardMappingList.add(grdt1g);

        // 3 coming trains
        Condition t1Ct1h = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2h = new Condition(t1, "in_a1", TransitionCondition.NotNull);
        Condition t1Ct3h = new Condition(t1, "in_a2", TransitionCondition.NotNull);
        Condition t1Ct4h = new Condition(t1, "in_a3", TransitionCondition.NotNull);

        t1Ct4h.SetNextCondition(LogicConnector.AND, t1Ct3h);
        t1Ct3h.SetNextCondition(LogicConnector.AND, t1Ct2h);
        t1Ct2h.SetNextCondition(LogicConnector.AND, t1Ct1h);

        GuardMapping grdt1h = new GuardMapping();
        grdt1h.condition= t1Ct1h;
        grdt1h.Activations.add(new Activation(t1, in_a1, in_a2, in_a3, TransitionOperation.CalculateLightTimeStation, Delay));
        grdt1h.Activations.add(new Activation(t1, Delay, L1, TransitionOperation.MessageBox_Controllers));
        grdt1h.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1h.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L1"));
        t1.GuardMappingList.add(grdt1h);


        t1.Delay = 0;
        pn.Transitions.add(t1);


        // t2----------------------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("r");


        Condition t2Ct1 = new Condition(t2, "r", TransitionCondition.NotNull);


        GuardMapping grdt2 = new GuardMapping();
        grdt2.condition= t2Ct1;
        grdt2.Activations.add(new Activation(t2, "r", TransitionOperation.Move, "i"));
        t2.GuardMappingList.add(grdt2);

        t2.Delay = 5;
        pn.Transitions.add(t2);

        // t0----------------------------------------------------------------
        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "t0";
        t0.InputPlaceName.add("i");


        Condition t0Ct1 = new Condition(t0, "i", TransitionCondition.NotNull);

        GuardMapping grdt0 = new GuardMapping();
        grdt0.condition= t0Ct1;
        grdt0.Activations.add(new Activation(t0, "i", TransitionOperation.Move, "g"));
        grdt0.Activations.add(new Activation(t0, "green", TransitionOperation.SendOverNetwork, "OP_L1"));
        t0.GuardMappingList.add(grdt0);

        t0.Delay = 0;
        pn.Transitions.add(t0);

        System.out.println("Controller L1 started \n ------------------------------");
        pn.Delay = 3000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);

    }
}
