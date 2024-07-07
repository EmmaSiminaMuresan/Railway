package THESIS.Controllers_1L;

import Components.*;
import DataObjects.DataInteger;
import DataObjects.DataLocalTime;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Controller_L2 {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Controller L2";
        pn.SetName("Controller L2");

        pn.NetworkPort = 1087;

        DataInteger Delay = new DataInteger();
        Delay.SetName("Delay");
        Delay.SetValue(0);
        pn.ConstantPlaceList.add(Delay);

        DataLocalTime in_b1 = new DataLocalTime(); // time to pass for the prev train
        in_b1.SetName("in_b1");
        in_b1.SetValue(null);
        pn.PlaceList.add(in_b1);

        DataLocalTime in_b2 = new DataLocalTime(); // time to pass for the prev train
        in_b2.SetName("in_b1");
        in_b2.SetValue(null);
        pn.PlaceList.add(in_b2);

        DataLocalTime in_b3 = new DataLocalTime(); // time to pass for the prev train
        in_b3.SetName("in_b3");
        in_b3.SetValue(null);
        pn.PlaceList.add(in_b3);

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

        DataTransfer OP_L2 = new DataTransfer();
        OP_L2.SetName("OP_L2");
        OP_L2.Value = new TransferOperation("localhost", "1083" , "L2");
        pn.PlaceList.add(OP_L2);

        //----------------------------t_ini------------------------------------
        PetriTransition t_ini = new PetriTransition(pn);
        t_ini.TransitionName = "t_ini";

        Condition t_iniCt1 = new Condition(t_ini, "ini", TransitionCondition.NotNull);

        GuardMapping grdt_ini = new GuardMapping();
        grdt_ini.condition= t_iniCt1;

        grdt_ini.Activations.add(new Activation(t_ini, "ini", TransitionOperation.SendOverNetwork, "OP_L2"));
        grdt_ini.Activations.add(new Activation(t_ini, "", TransitionOperation.MakeNull, "ini"));

        t_ini.GuardMappingList.add(grdt_ini);

        t_ini.Delay = 0;
        pn.Transitions.add(t_ini);

        // t0----------------------------------------------------------------
        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "t0";
        t0.InputPlaceName.add("i");


        Condition t0Ct1 = new Condition(t0, "i", TransitionCondition.NotNull);

        GuardMapping grdt0 = new GuardMapping();
        grdt0.condition= t0Ct1;
        grdt0.Activations.add(new Activation(t0, "i", TransitionOperation.Move, "g"));
        grdt0.Activations.add(new Activation(t0, "green", TransitionOperation.SendOverNetwork, "OP_L2"));
        t0.GuardMappingList.add(grdt0);

        t0.Delay = 0;
        pn.Transitions.add(t0);


        // t1----------------------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("g");
        t1.InputPlaceName.add("in_b1");
        t1.InputPlaceName.add("in_b2");
        t1.InputPlaceName.add("in_b3");

        // no leaving train from the station
        Condition t1Ct1a = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2a = new Condition(t1, "in_b1", TransitionCondition.IsNull);
        Condition t1Ct3a = new Condition(t1, "in_b2", TransitionCondition.IsNull);
        Condition t1Ct4a = new Condition(t1, "in_b3", TransitionCondition.IsNull);

        t1Ct4a.SetNextCondition(LogicConnector.AND, t1Ct3a);
        t1Ct3a.SetNextCondition(LogicConnector.AND, t1Ct2a);
        t1Ct2a.SetNextCondition(LogicConnector.AND, t1Ct1a);

        GuardMapping grdt1a = new GuardMapping();
        grdt1a.condition= t1Ct1a;
        grdt1a.Activations.add(new Activation(t1, null,null,null,TransitionOperation.CalculateLightTimeStation, Delay));
        grdt1a.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1a.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L2"));
        t1.GuardMappingList.add(grdt1a);


        // 1 comming train on A1
        Condition t1Ct1b = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2b = new Condition(t1, "in_b1", TransitionCondition.NotNull);
        Condition t1Ct3b = new Condition(t1, "in_b2", TransitionCondition.IsNull);
        Condition t1Ct4b = new Condition(t1, "in_b3", TransitionCondition.IsNull);

        t1Ct4b.SetNextCondition(LogicConnector.AND, t1Ct3b);
        t1Ct3b.SetNextCondition(LogicConnector.AND, t1Ct2b);
        t1Ct2b.SetNextCondition(LogicConnector.AND, t1Ct1b);

        GuardMapping grdt1b = new GuardMapping();
        grdt1b.condition= t1Ct1b;
        grdt1b.Activations.add(new Activation(t1, in_b1,null,null,TransitionOperation.CalculateLightTimeStation, Delay));
        grdt1b.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1b.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L2"));
        t1.GuardMappingList.add(grdt1b);


        // 1 comming train on A2
        Condition t1Ct1c = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2c = new Condition(t1, "in_b1", TransitionCondition.IsNull);
        Condition t1Ct3c= new Condition(t1, "in_b2", TransitionCondition.NotNull);
        Condition t1Ct4c = new Condition(t1, "in_b3", TransitionCondition.IsNull);

        t1Ct4c.SetNextCondition(LogicConnector.AND, t1Ct3c);
        t1Ct3c.SetNextCondition(LogicConnector.AND, t1Ct2c);
        t1Ct2c.SetNextCondition(LogicConnector.AND, t1Ct1c);

        GuardMapping grdt1c = new GuardMapping();
        grdt1c.condition= t1Ct1c;
        grdt1c.Activations.add(new Activation(t1, null,in_b2,null,TransitionOperation.CalculateLightTimeStation, Delay));
        grdt1c.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1c.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L2"));
        t1.GuardMappingList.add(grdt1c);


        // 1 comming train on A3
        Condition t1Ct1d = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2d = new Condition(t1, "in_b1", TransitionCondition.IsNull);
        Condition t1Ct3d = new Condition(t1, "in_b2", TransitionCondition.IsNull);
        Condition t1Ct4d = new Condition(t1, "in_b3", TransitionCondition.NotNull);

        t1Ct4d.SetNextCondition(LogicConnector.AND, t1Ct3d);
        t1Ct3d.SetNextCondition(LogicConnector.AND, t1Ct2d);
        t1Ct2d.SetNextCondition(LogicConnector.AND, t1Ct1d);

        GuardMapping grdt1d = new GuardMapping();
        grdt1d.condition= t1Ct1d;
        grdt1d.Activations.add(new Activation(t1, null,null,in_b3,TransitionOperation.CalculateLightTimeStation,Delay));
        grdt1d.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1d.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L2"));
        t1.GuardMappingList.add(grdt1d);


        // 2 comming trains on A1,A2

        /// IF I WOULD PUT In the activation in1,2,3 all the time and i would not have the last 3 conditions
        // wouldnt it be ok? because in the CalculateLightTimeStation i treat all the cases and i have as inputs
        // for now all these times as places DataLocalTime(in the activation)
        // if we agree that i can receive directly both DataListTrainQueue which is List_b then i can substract
        // the departure times and leaving times and so i will change the function accordingly

        Condition t1Ct1e = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2e = new Condition(t1, "in_b1", TransitionCondition.IsNull);
        Condition t1Ct3e = new Condition(t1, "in_b2", TransitionCondition.IsNull);
        Condition t1Ct4e = new Condition(t1, "in_b3", TransitionCondition.NotNull);

        t1Ct4e.SetNextCondition(LogicConnector.AND, t1Ct3e);
        t1Ct3e.SetNextCondition(LogicConnector.AND, t1Ct2e);
        t1Ct2e.SetNextCondition(LogicConnector.AND, t1Ct1e);

        GuardMapping grdt1e = new GuardMapping();
        grdt1e.condition= t1Ct1e;
        grdt1e.Activations.add(new Activation(t1, null,null,in_b3,TransitionOperation.CalculateLightTimeStation,Delay));
        grdt1e.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1e.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L2"));
        t1.GuardMappingList.add(grdt1e);


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
    }
}
