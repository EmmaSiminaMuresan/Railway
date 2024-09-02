package THESIS.Controllers_1L;

import Components.*;
import DataObjects.*;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;


public class Controller_L3 {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Controller L3";
        pn.SetName("Controller L3");

        pn.NetworkPort = 1088;

        DataString L3 = new DataString();
        L3.SetName("L3");
        L3.SetValue("L3");
        pn.ConstantPlaceList.add(L3);

        DataInteger Delay = new DataInteger();
        Delay.SetName("Delay");
        Delay.SetValue(0);
        pn.ConstantPlaceList.add(Delay);

        DataInteger Delay_Simulation = new DataInteger();
        Delay_Simulation.SetName("Delay_Simulation");
        Delay_Simulation.SetValue(0);
        pn.ConstantPlaceList.add(Delay_Simulation);

        DataListTrains in_c1 = new DataListTrains();
        in_c1.SetName("in_c1");
        //in_c1.SetValue(null); // Explicitly set to null
        pn.PlaceList.add(in_c1);

        DataListTrains in_c2 = new DataListTrains();
        in_c2.SetName("in_c2");
        //in_c2.SetValue(null); // Explicitly set to null
        pn.PlaceList.add(in_c2);

        DataListTrains in_c3 = new DataListTrains();
        in_c3.SetName("in_c3");
        //in_c3.SetValue(null); // Explicitly set to null
        pn.PlaceList.add(in_c3);


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
        g.SetValue("signal");
        pn.PlaceList.add(g);

        DataTransfer OP_L3 = new DataTransfer();
        OP_L3.SetName("OP_L3");
        OP_L3.Value = new TransferOperation("localhost", "1083" , "L3");
        pn.PlaceList.add(OP_L3);

        //----------------------------t_ini------------------------------------
        PetriTransition t_ini = new PetriTransition(pn);
        t_ini.TransitionName = "t_ini";

        Condition t_iniCt1 = new Condition(t_ini, "ini", TransitionCondition.NotNull);

        GuardMapping grdt_ini = new GuardMapping();
        grdt_ini.condition= t_iniCt1;

        grdt_ini.Activations.add(new Activation(t_ini, "ini", TransitionOperation.SendOverNetwork, "OP_L3"));
        grdt_ini.Activations.add(new Activation(t_ini, "", TransitionOperation.MakeNull, "ini"));

        t_ini.GuardMappingList.add(grdt_ini);

        t_ini.Delay = 0;
        pn.Transitions.add(t_ini);


        // t1----------------------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("g");
        t1.InputPlaceName.add("in_c1");
        t1.InputPlaceName.add("in_c2");
        t1.InputPlaceName.add("in_c3");

        // Handle case when all inputs are null - evaluated first
        Condition t1CtAllNull = new Condition(t1, "in_c1", TransitionCondition.IsNull);
        t1CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t1, "in_c2", TransitionCondition.IsNull));
        t1CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t1, "in_c3", TransitionCondition.IsNull));
        t1CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t1, "g", TransitionCondition.NotNull));

        GuardMapping grdT1AllNull = new GuardMapping();
        grdT1AllNull.condition = t1CtAllNull;
        grdT1AllNull.Activations.add(new Activation(t1, "", TransitionOperation.DoNothing, ""));
        t1.GuardMappingList.add(grdT1AllNull);

        //This transition changes the delay for t2 so the red light is on until the delay reaches 0 where it decrements with each tic

        // 1 comming train on C1
        Condition t1Ct1b = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2b = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3b = new Condition(t1, "in_c2", TransitionCondition.IsNull);
        Condition t1Ct4b = new Condition(t1, "in_c3", TransitionCondition.IsNull);
        //the connections must be reversed!!!!
        //t1Ct4b.SetNextCondition(LogicConnector.AND, t1Ct3b);
        //t1Ct3b.SetNextCondition(LogicConnector.AND, t1Ct2b);
        //t1Ct2b.SetNextCondition(LogicConnector.AND, t1Ct1b);
        t1Ct3b.SetNextCondition(LogicConnector.AND, t1Ct4b);
        t1Ct2b.SetNextCondition(LogicConnector.AND, t1Ct3b);
        t1Ct1b.SetNextCondition(LogicConnector.AND, t1Ct2b);
        //fix the rest !!!
        GuardMapping grdt1b = new GuardMapping();
        grdt1b.condition= t1Ct1b;
        grdt1b.Activations.add(new Activation(t1, "in_c1",TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1b.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay,"Delay_Simulation"));
        // grdt1b.Activations.add(new Activation(t2, "Delay_Simulation", TransitionOperation.DynamicDelay,""));
        //better to set the delay for t2 from the delay calculation function and t2 must be defined first
        grdt1b.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1b.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1b.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1b);


        // 1 comming train on C2
        Condition t1Ct1c = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2c = new Condition(t1, "in_c1", TransitionCondition.IsNull);
        Condition t1Ct3c= new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4c = new Condition(t1, "in_c3", TransitionCondition.IsNull);

        t1Ct3c.SetNextCondition(LogicConnector.AND, t1Ct4c);
        t1Ct2c.SetNextCondition(LogicConnector.AND, t1Ct3c);
        t1Ct1c.SetNextCondition(LogicConnector.AND, t1Ct2c);
//t2 dynamic delay is not set here??
        GuardMapping grdt1c = new GuardMapping();
        grdt1c.condition= t1Ct1c;
        grdt1c.Activations.add(new Activation(t1, "in_c2",TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1c.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay,"Delay_Simulation"));
        grdt1c.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1c.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1c.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1c);


        // 1 comming train on C3
        Condition t1Ct1d = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2d = new Condition(t1, "in_c1", TransitionCondition.IsNull);
        Condition t1Ct3d = new Condition(t1, "in_c2", TransitionCondition.IsNull);
        Condition t1Ct4d = new Condition(t1, "in_c3", TransitionCondition.NotNull);

        t1Ct3d.SetNextCondition(LogicConnector.AND, t1Ct4d);
        t1Ct2d.SetNextCondition(LogicConnector.AND, t1Ct3d);
        t1Ct1d.SetNextCondition(LogicConnector.AND, t1Ct2d);
//t2 dynamic delay is not set here??
        GuardMapping grdt1d = new GuardMapping();
        grdt1d.condition= t1Ct1d;
        grdt1d.Activations.add(new Activation(t1, "in_c3", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1d.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1d.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1d.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1d.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1d);


        // 2 coming trains on C1 C2
        // dep time C1 > dep time C2
        Condition t1Ct1e = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2e = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3e = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4e = new Condition(t1, "in_c3", TransitionCondition.IsNull);
        Condition t1Ct5e = new Condition(t1, "in_c1", TransitionCondition.CheckDepartureTime,"in_c2");

        t1Ct4e.SetNextCondition(LogicConnector.AND, t1Ct5e);
        t1Ct3e.SetNextCondition(LogicConnector.AND, t1Ct4e);
        t1Ct2e.SetNextCondition(LogicConnector.AND, t1Ct3e);
        t1Ct1e.SetNextCondition(LogicConnector.AND, t1Ct2e);

        GuardMapping grdt1e = new GuardMapping();
        grdt1e.condition= t1Ct1e;
        grdt1e.Activations.add(new Activation(t1, "in_c1", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1e.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1e.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1e.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1e.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1e);

        // 2 coming trains on C1 C2
        // dep time C2 > dep time C1
        Condition t1Ct1e1 = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2e1 = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3e1 = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4e1 = new Condition(t1, "in_c3", TransitionCondition.IsNull);
        Condition t1Ct5e1 = new Condition(t1, "in_c2", TransitionCondition.CheckDepartureTime,"in_c1");

        t1Ct4e1.SetNextCondition(LogicConnector.AND, t1Ct5e1);
        t1Ct3e1.SetNextCondition(LogicConnector.AND, t1Ct4e1);
        t1Ct2e1.SetNextCondition(LogicConnector.AND, t1Ct3e1);
        t1Ct1e1.SetNextCondition(LogicConnector.AND, t1Ct2e1);

        GuardMapping grdt1e1 = new GuardMapping();
        grdt1e1.condition= t1Ct1e1;
        grdt1e1.Activations.add(new Activation(t1, "in_c2", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1e1.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1e1.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1e1.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1e1.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1e1);

        // 2 coming trains on C1 C2
        // dep time C2 = dep time C1 , leaving time C1 > C2
        Condition t1Ct1e2 = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2e2 = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3e2 = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4e2 = new Condition(t1, "in_c3", TransitionCondition.IsNull);
        Condition t1Ct5e2 = new Condition(t1, "in_c1", TransitionCondition.EqualDepartureTime,"in_c2");
        Condition t1Ct6e2 = new Condition(t1, "in_c1", TransitionCondition.CheckLeavingTime,"in_c2");

        t1Ct5e2.SetNextCondition(LogicConnector.AND, t1Ct6e2);
        t1Ct4e2.SetNextCondition(LogicConnector.AND, t1Ct5e2);
        t1Ct3e2.SetNextCondition(LogicConnector.AND, t1Ct4e2);
        t1Ct2e2.SetNextCondition(LogicConnector.AND, t1Ct3e2);
        t1Ct1e2.SetNextCondition(LogicConnector.AND, t1Ct2e2);

        GuardMapping grdt1e2 = new GuardMapping();
        grdt1e2.condition= t1Ct1e2;
        grdt1e2.Activations.add(new Activation(t1, "in_c2", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1e2.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1e2.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1e2.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1e2.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1e2);


        // 2 coming trains on C1 C2
        // dep time C2 = dep time C1 , leaving time C2 > C1
        Condition t1Ct1e3 = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2e3 = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3e3 = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4e3 = new Condition(t1, "in_c3", TransitionCondition.IsNull);
        Condition t1Ct5e3 = new Condition(t1, "in_c1", TransitionCondition.EqualDepartureTime,"in_c2");
        Condition t1Ct6e3 = new Condition(t1, "in_c2", TransitionCondition.CheckLeavingTime,"in_c1");

        t1Ct5e3.SetNextCondition(LogicConnector.AND, t1Ct6e3);
        t1Ct4e3.SetNextCondition(LogicConnector.AND, t1Ct5e3);
        t1Ct3e3.SetNextCondition(LogicConnector.AND, t1Ct4e3);
        t1Ct2e3.SetNextCondition(LogicConnector.AND, t1Ct3e3);
        t1Ct1e3.SetNextCondition(LogicConnector.AND, t1Ct2e3);

        GuardMapping grdt1e3 = new GuardMapping();
        grdt1e3.condition= t1Ct1e3;
        grdt1e3.Activations.add(new Activation(t1, "in_c3", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1e3.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1e3.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1e3.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1e3.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1e3);


        // 2 coming trains on C1 C3
        // dep time C1 > dep time C3
        Condition t1Ct1f = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2f = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3f = new Condition(t1, "in_c2", TransitionCondition.IsNull);
        Condition t1Ct4f = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5f = new Condition(t1, "in_c1", TransitionCondition.CheckDepartureTime,"in_c3");

        t1Ct4f.SetNextCondition(LogicConnector.AND, t1Ct5f);
        t1Ct3f.SetNextCondition(LogicConnector.AND, t1Ct4f);
        t1Ct2f.SetNextCondition(LogicConnector.AND, t1Ct3f);
        t1Ct1f.SetNextCondition(LogicConnector.AND, t1Ct2f);
//t2 dynamic delay is not set here??
        GuardMapping grdt1f = new GuardMapping();
        grdt1f.condition= t1Ct1f;
        grdt1f.Activations.add(new Activation(t1, "in_c1", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1f.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1f.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1f.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1f.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1f);

        // dep time C3 > dep time C1
        Condition t1Ct1f1 = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2f1 = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3f1 = new Condition(t1, "in_c2", TransitionCondition.IsNull);
        Condition t1Ct4f1 = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5f1 = new Condition(t1, "in_c3", TransitionCondition.CheckDepartureTime,"in_c1");

        t1Ct4f1.SetNextCondition(LogicConnector.AND, t1Ct5f1);
        t1Ct3f1.SetNextCondition(LogicConnector.AND, t1Ct4f1);
        t1Ct2f1.SetNextCondition(LogicConnector.AND, t1Ct3f1);
        t1Ct1f1.SetNextCondition(LogicConnector.AND, t1Ct2f1);
//t2 dynamic delay is not set here??
        GuardMapping grdt1f1 = new GuardMapping();
        grdt1f1.condition= t1Ct1f1;
        grdt1f1.Activations.add(new Activation(t1, "in_c3", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1f1.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1f1.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1f1.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1f1.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1f1);

        // dep time C3 = dep time C1, leaving time C1 > C3
        Condition t1Ct1f2 = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2f2 = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3f2 = new Condition(t1, "in_c2", TransitionCondition.IsNull);
        Condition t1Ct4f2 = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5f2 = new Condition(t1, "in_c3", TransitionCondition.EqualDepartureTime,"in_c1");
        Condition t1Ct6f2 = new Condition(t1, "in_c1", TransitionCondition.CheckLeavingTime,"in_c3");

        t1Ct5f2.SetNextCondition(LogicConnector.AND, t1Ct6f2);
        t1Ct4f2.SetNextCondition(LogicConnector.AND, t1Ct5f2);
        t1Ct3f2.SetNextCondition(LogicConnector.AND, t1Ct4f2);
        t1Ct2f2.SetNextCondition(LogicConnector.AND, t1Ct3f2);
        t1Ct1f2.SetNextCondition(LogicConnector.AND, t1Ct2f2);
//t2 dynamic delay is not set here??
        GuardMapping grdt1f2 = new GuardMapping();
        grdt1f2.condition= t1Ct1f2;
        grdt1f2.Activations.add(new Activation(t1, "in_c1", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1f2.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1f2.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1f2.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1f2.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1f2);


        // dep time C3 = dep time C1, leaving time C3 > C1
        Condition t1Ct1f3 = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2f3 = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3f3 = new Condition(t1, "in_c2", TransitionCondition.IsNull);
        Condition t1Ct4f3 = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5f3 = new Condition(t1, "in_c3", TransitionCondition.EqualDepartureTime,"in_c1");
        Condition t1Ct6f3 = new Condition(t1, "in_c3", TransitionCondition.CheckLeavingTime,"in_c1");

        t1Ct5f3.SetNextCondition(LogicConnector.AND, t1Ct6f3);
        t1Ct4f3.SetNextCondition(LogicConnector.AND, t1Ct5f3);
        t1Ct3f3.SetNextCondition(LogicConnector.AND, t1Ct4f3);
        t1Ct2f3.SetNextCondition(LogicConnector.AND, t1Ct3f3);
        t1Ct1f3.SetNextCondition(LogicConnector.AND, t1Ct2f3);
//t2 dynamic delay is not set here??
        GuardMapping grdt1f3 = new GuardMapping();
        grdt1f3.condition= t1Ct1f3;
        grdt1f3.Activations.add(new Activation(t1, "in_c3", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1f3.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1f3.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1f3.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1f3.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1f3);


        // 2 coming trains on C2 C3
        // dep time C2 > dep time C3
        Condition t1Ct1g = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2g = new Condition(t1, "in_c1", TransitionCondition.IsNull);
        Condition t1Ct3g = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4g = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5g = new Condition(t1, "in_c2", TransitionCondition.CheckDepartureTime,"in_c3");

        t1Ct4g.SetNextCondition(LogicConnector.AND, t1Ct5g);
        t1Ct3g.SetNextCondition(LogicConnector.AND, t1Ct4g);
        t1Ct2g.SetNextCondition(LogicConnector.AND, t1Ct3g);
        t1Ct1g.SetNextCondition(LogicConnector.AND, t1Ct2g);
//t2 dynamic delay is not set here??
        GuardMapping grdt1g = new GuardMapping();
        grdt1g.condition = t1Ct1g;
        grdt1g.Activations.add(new Activation(t1, "in_c2", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1g.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1g.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1g.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1g.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1g);


        // dep time C3 > dep time C2
        Condition t1Ct1g1 = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2g1 = new Condition(t1, "in_c1", TransitionCondition.IsNull);
        Condition t1Ct3g1 = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4g1 = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5g1 = new Condition(t1, "in_c3", TransitionCondition.CheckDepartureTime,"in_c2");

        t1Ct4g1.SetNextCondition(LogicConnector.AND, t1Ct5g1);
        t1Ct3g1.SetNextCondition(LogicConnector.AND, t1Ct4g1);
        t1Ct2g1.SetNextCondition(LogicConnector.AND, t1Ct3g1);
        t1Ct1g1.SetNextCondition(LogicConnector.AND, t1Ct2g1);
//t2 dynamic delay is not set here??
        GuardMapping grdt1g1 = new GuardMapping();
        grdt1g1.condition = t1Ct1g1;
        grdt1g1.Activations.add(new Activation(t1, "in_c3", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1g1.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1g1.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1g1.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1g1.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1g1);

        // dep time C3 = dep time C2, leaving time C2 > C3
        Condition t1Ct1g2 = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2g2 = new Condition(t1, "in_c1", TransitionCondition.IsNull);
        Condition t1Ct3g2 = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4g2 = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5g2 = new Condition(t1, "in_c3", TransitionCondition.EqualDepartureTime,"in_c2");
        Condition t1Ct6g2 = new Condition(t1, "in_c2", TransitionCondition.CheckLeavingTime,"in_c3");

        t1Ct5g2.SetNextCondition(LogicConnector.AND, t1Ct6g2);
        t1Ct4g2.SetNextCondition(LogicConnector.AND, t1Ct5g2);
        t1Ct3g2.SetNextCondition(LogicConnector.AND, t1Ct4g2);
        t1Ct2g2.SetNextCondition(LogicConnector.AND, t1Ct3g2);
        t1Ct1g2.SetNextCondition(LogicConnector.AND, t1Ct2g2);
//t2 dynamic delay is not set here??
        GuardMapping grdt1g2 = new GuardMapping();
        grdt1g2.condition = t1Ct1g2;
        grdt1g2.Activations.add(new Activation(t1, "in_c2", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1g2.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1g2.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1g2.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1g2.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1g2);

        // dep time C3 = dep time C2, leaving time C3 > C2
        Condition t1Ct1g3 = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2g3 = new Condition(t1, "in_c1", TransitionCondition.IsNull);
        Condition t1Ct3g3 = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4g3 = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5g3 = new Condition(t1, "in_c3", TransitionCondition.EqualDepartureTime,"in_c2");
        Condition t1Ct6g3 = new Condition(t1, "in_c3", TransitionCondition.CheckLeavingTime,"in_c2");

        t1Ct5g3.SetNextCondition(LogicConnector.AND, t1Ct6g3);
        t1Ct4g3.SetNextCondition(LogicConnector.AND, t1Ct5g3);
        t1Ct3g3.SetNextCondition(LogicConnector.AND, t1Ct4g3);
        t1Ct2g3.SetNextCondition(LogicConnector.AND, t1Ct3g3);
        t1Ct1g3.SetNextCondition(LogicConnector.AND, t1Ct2g3);
//t2 dynamic delay is not set here??
        GuardMapping grdt1g3 = new GuardMapping();
        grdt1g3.condition = t1Ct1g3;
        grdt1g3.Activations.add(new Activation(t1, "in_c3", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1g3.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1g3.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1g3.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1g3.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1g3);




        // 3 coming trains, dep time C1 > C2, C2 > C3
        Condition t1Ct1h = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2h = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3h = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4h = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5h = new Condition(t1, "in_c1", TransitionCondition.CheckDepartureTime, "in_c2");
        Condition t1Ct6h = new Condition(t1, "in_c2", TransitionCondition.CheckDepartureTime, "in_c3");

        t1Ct5h.SetNextCondition(LogicConnector.AND, t1Ct6h);
        t1Ct4h.SetNextCondition(LogicConnector.AND, t1Ct5h);
        t1Ct3h.SetNextCondition(LogicConnector.AND, t1Ct4h);
        t1Ct2h.SetNextCondition(LogicConnector.AND, t1Ct3h);
        t1Ct1h.SetNextCondition(LogicConnector.AND, t1Ct2h);
//t2 dynamic delay is not set here??
        GuardMapping grdt1h = new GuardMapping();
        grdt1h.condition = t1Ct1h;
        grdt1h.Activations.add(new Activation(t1, "in_c1", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1h.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1h.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1h.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1h.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1h);

        // 3 coming trains, dep time C1 > C3, C3 > C2
        Condition t1Ct1i = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2i = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3i = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4i = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5i = new Condition(t1, "in_c1", TransitionCondition.CheckDepartureTime, "in_c3");
        Condition t1Ct6i = new Condition(t1, "in_c3", TransitionCondition.CheckDepartureTime, "in_c2");


        t1Ct5i.SetNextCondition(LogicConnector.AND, t1Ct6i);
        t1Ct4i.SetNextCondition(LogicConnector.AND, t1Ct5i);
        t1Ct3i.SetNextCondition(LogicConnector.AND, t1Ct4i);
        t1Ct2i.SetNextCondition(LogicConnector.AND, t1Ct3i);
        t1Ct1i.SetNextCondition(LogicConnector.AND, t1Ct2i);
//t2 dynamic delay is not set here??
        GuardMapping grdt1i = new GuardMapping();
        grdt1i.condition = t1Ct1i;
        grdt1i.Activations.add(new Activation(t1, "in_c1", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1i.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1i.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1i.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1i.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1i);


        // 3 coming trains, dep time C2 > C1, C1 > C3
        Condition t1Ct1j = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2j = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3j = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4j = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5j = new Condition(t1, "in_c2", TransitionCondition.CheckDepartureTime, "in_c1");
        Condition t1Ct6j = new Condition(t1, "in_c1", TransitionCondition.CheckDepartureTime, "in_c3");

        t1Ct5j.SetNextCondition(LogicConnector.AND, t1Ct6j);
        t1Ct4j.SetNextCondition(LogicConnector.AND, t1Ct5j);
        t1Ct3j.SetNextCondition(LogicConnector.AND, t1Ct4j);
        t1Ct2j.SetNextCondition(LogicConnector.AND, t1Ct3j);
        t1Ct1j.SetNextCondition(LogicConnector.AND, t1Ct2j);
//t2 dynamic delay is not set here??
        GuardMapping grdt1j = new GuardMapping();
        grdt1j.condition = t1Ct1j;
        grdt1j.Activations.add(new Activation(t1, "in_c2", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1j.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1j.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1j.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1j.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1j);

        // 3 coming trains, dep time C2 > C3, C3 > C1
        Condition t1Ct1k = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2k = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3k = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4k = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5k = new Condition(t1, "in_c2", TransitionCondition.CheckDepartureTime, "in_c3");
        Condition t1Ct6k = new Condition(t1, "in_c3", TransitionCondition.CheckDepartureTime, "in_c1");

        t1Ct5k.SetNextCondition(LogicConnector.AND, t1Ct6k);
        t1Ct4k.SetNextCondition(LogicConnector.AND, t1Ct5k);
        t1Ct3k.SetNextCondition(LogicConnector.AND, t1Ct4k);
        t1Ct2k.SetNextCondition(LogicConnector.AND, t1Ct3k);
        t1Ct1k.SetNextCondition(LogicConnector.AND, t1Ct2k);
//t2 dynamic delay is not set here??
        GuardMapping grdt1k = new GuardMapping();
        grdt1k.condition = t1Ct1k;
        grdt1k.Activations.add(new Activation(t1, "in_c2", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1k.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1k.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1k.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1k.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1k);

        // 3 coming trains, dep time C3 > C1, C1 > C2
        Condition t1Ct1l = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2l = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3l = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4l = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5l = new Condition(t1, "in_c3", TransitionCondition.CheckDepartureTime, "in_c1");
        Condition t1Ct6l = new Condition(t1, "in_c1", TransitionCondition.CheckDepartureTime, "in_c2");

        t1Ct5l.SetNextCondition(LogicConnector.AND, t1Ct6l);
        t1Ct4l.SetNextCondition(LogicConnector.AND, t1Ct5l);
        t1Ct3l.SetNextCondition(LogicConnector.AND, t1Ct4l);
        t1Ct2l.SetNextCondition(LogicConnector.AND, t1Ct3l);
        t1Ct1l.SetNextCondition(LogicConnector.AND, t1Ct2l);
//t2 dynamic delay is not set here??
        GuardMapping grdt1l = new GuardMapping();
        grdt1l.condition = t1Ct1l;
        grdt1l.Activations.add(new Activation(t1, "in_c3", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1l.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1l.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1l.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1l.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1l);

        // 3 coming trains, dep time C3 > C2, C2 > C1
        Condition t1Ct1m = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2m = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3m = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4m = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5m = new Condition(t1, "in_c3", TransitionCondition.CheckDepartureTime, "in_c2");
        Condition t1Ct6m = new Condition(t1, "in_c2", TransitionCondition.CheckDepartureTime, "in_c1");


        t1Ct5m.SetNextCondition(LogicConnector.AND, t1Ct6m);
        t1Ct4m.SetNextCondition(LogicConnector.AND, t1Ct5m);
        t1Ct3m.SetNextCondition(LogicConnector.AND, t1Ct4m);
        t1Ct2m.SetNextCondition(LogicConnector.AND, t1Ct3m);
        t1Ct1m.SetNextCondition(LogicConnector.AND, t1Ct2m);
//t2 dynamic delay is not set here??
        GuardMapping grdt1m = new GuardMapping();
        grdt1m.condition = t1Ct1m;
        grdt1m.Activations.add(new Activation(t1, "in_c3", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1m.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1m.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1m.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1m.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1m);


        // 3 coming trains, dep time C1 = C2, C3 > C1
        Condition t1Ct1o = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2o = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3o = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4o = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5o = new Condition(t1, "in_c1", TransitionCondition.EqualDepartureTime, "in_c2");
        Condition t1Ct6o = new Condition(t1, "in_c3", TransitionCondition.CheckDepartureTime, "in_c1");

        t1Ct5o.SetNextCondition(LogicConnector.AND, t1Ct6o);
        t1Ct4o.SetNextCondition(LogicConnector.AND, t1Ct5o);
        t1Ct3o.SetNextCondition(LogicConnector.AND, t1Ct4o);
        t1Ct2o.SetNextCondition(LogicConnector.AND, t1Ct3o);
        t1Ct1o.SetNextCondition(LogicConnector.AND, t1Ct2o);
//t2 dynamic delay is not set here??
        GuardMapping grdt1o = new GuardMapping();
        grdt1o.condition = t1Ct1o;
        grdt1o.Activations.add(new Activation(t1, "in_c3", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1o.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1o.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1o.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1o.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1o);

        // 3 coming trains, dep time C1 = C2, C1 > C3
        Condition t1Ct1o1 = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2o1 = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3o1 = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4o1 = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5o1 = new Condition(t1, "in_c1", TransitionCondition.EqualDepartureTime, "in_c2");
        Condition t1Ct6o1 = new Condition(t1, "in_c1", TransitionCondition.CheckDepartureTime, "in_c3");

        t1Ct5o1.SetNextCondition(LogicConnector.AND, t1Ct6o1);
        t1Ct4o1.SetNextCondition(LogicConnector.AND, t1Ct5o1);
        t1Ct3o1.SetNextCondition(LogicConnector.AND, t1Ct4o1);
        t1Ct2o1.SetNextCondition(LogicConnector.AND, t1Ct3o1);
        t1Ct1o1.SetNextCondition(LogicConnector.AND, t1Ct2o1);
//t2 dynamic delay is not set here??
        GuardMapping grdt1o1 = new GuardMapping();
        grdt1o1.condition = t1Ct1o1;
        grdt1o1.Activations.add(new Activation(t1, "in_c1", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1o1.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1o1.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1o1.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1o1.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1o1);

        // 3 coming trains, dep time C1 = C3, C2 > C1
        Condition t1Ct1p = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2p = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3p = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4p = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5p = new Condition(t1, "in_c1", TransitionCondition.EqualDepartureTime, "in_c3");
        Condition t1Ct6p = new Condition(t1, "in_c2", TransitionCondition.CheckDepartureTime, "in_c1");

        t1Ct5p.SetNextCondition(LogicConnector.AND, t1Ct6p);
        t1Ct4p.SetNextCondition(LogicConnector.AND, t1Ct5p);
        t1Ct3p.SetNextCondition(LogicConnector.AND, t1Ct4p);
        t1Ct2p.SetNextCondition(LogicConnector.AND, t1Ct3p);
        t1Ct1p.SetNextCondition(LogicConnector.AND, t1Ct2p);
//t2 dynamic delay is not set here??
        GuardMapping grdt1p = new GuardMapping();
        grdt1p.condition = t1Ct1p;
        grdt1p.Activations.add(new Activation(t1, "in_c2", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1p.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1p.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1p.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1p.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1p);

        // 3 coming trains, dep time C1 = C3, C1 > C2
        Condition t1Ct1q = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2q = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3q = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4q = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5q = new Condition(t1, "in_c1", TransitionCondition.EqualDepartureTime, "in_c3");
        Condition t1Ct6q = new Condition(t1, "in_c1", TransitionCondition.CheckDepartureTime, "in_c2");

        t1Ct5q.SetNextCondition(LogicConnector.AND, t1Ct6q);
        t1Ct4q.SetNextCondition(LogicConnector.AND, t1Ct5q);
        t1Ct3q.SetNextCondition(LogicConnector.AND, t1Ct4q);
        t1Ct2q.SetNextCondition(LogicConnector.AND, t1Ct3q);
        t1Ct1q.SetNextCondition(LogicConnector.AND, t1Ct2q);
//t2 dynamic delay is not set here??
        GuardMapping grdt1q = new GuardMapping();
        grdt1q.condition = t1Ct1q;
        grdt1q.Activations.add(new Activation(t1, "in_c1", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1q.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1q.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1q.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1q.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1q);


        // 3 coming trains, dep time C2 = C3, C2 > C1
        Condition t1Ct1r = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2r = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3r = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4r = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5r = new Condition(t1, "in_c2", TransitionCondition.EqualDepartureTime, "in_c3");
        Condition t1Ct6r = new Condition(t1, "in_c2", TransitionCondition.CheckDepartureTime, "in_c1");

        t1Ct5r.SetNextCondition(LogicConnector.AND, t1Ct6r);
        t1Ct4r.SetNextCondition(LogicConnector.AND, t1Ct5r);
        t1Ct3r.SetNextCondition(LogicConnector.AND, t1Ct4r);
        t1Ct2r.SetNextCondition(LogicConnector.AND, t1Ct3r);
        t1Ct1r.SetNextCondition(LogicConnector.AND, t1Ct2r);
//t2 dynamic delay is not set here??
        GuardMapping grdt1r = new GuardMapping();
        grdt1r.condition = t1Ct1r;
        grdt1r.Activations.add(new Activation(t1, "in_c2", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1r.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1r.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1r.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1r.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1r);


        // 3 coming trains, dep time C2 = C3, C1 > C2
        Condition t1Ct1s = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2s = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3s = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4s = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5s = new Condition(t1, "in_c2", TransitionCondition.EqualDepartureTime, "in_c3");
        Condition t1Ct6s = new Condition(t1, "in_c1", TransitionCondition.CheckDepartureTime, "in_c2");

        t1Ct5s.SetNextCondition(LogicConnector.AND, t1Ct6s);
        t1Ct4s.SetNextCondition(LogicConnector.AND, t1Ct5s);
        t1Ct3s.SetNextCondition(LogicConnector.AND, t1Ct4s);
        t1Ct2s.SetNextCondition(LogicConnector.AND, t1Ct3s);
        t1Ct1s.SetNextCondition(LogicConnector.AND, t1Ct2s);

        GuardMapping grdt1s = new GuardMapping();
        grdt1s.condition = t1Ct1s;
        grdt1s.Activations.add(new Activation(t1, "in_c1", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1s.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1s.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1s.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1s.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1s);

        // 3 coming trains, dep time C1 = C2 = C3, leaving time C1 > C2, C2 > C3
        Condition t1Ct1t = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2t = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3t = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4t = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5t = new Condition(t1, "in_c1", TransitionCondition.EqualDepartureTime, "in_c2");
        Condition t1Ct6t = new Condition(t1, "in_c2", TransitionCondition.EqualDepartureTime, "in_c3");
        Condition t1Ct7t = new Condition(t1, "in_c1", TransitionCondition.CheckLeavingTime, "in_c2");
        Condition t1Ct8t = new Condition(t1, "in_c2", TransitionCondition.CheckLeavingTime, "in_c3");

        t1Ct7t.SetNextCondition(LogicConnector.AND, t1Ct8t);
        t1Ct6t.SetNextCondition(LogicConnector.AND, t1Ct7t);
        t1Ct5t.SetNextCondition(LogicConnector.AND, t1Ct6t);
        t1Ct4t.SetNextCondition(LogicConnector.AND, t1Ct5t);
        t1Ct3t.SetNextCondition(LogicConnector.AND, t1Ct4t);
        t1Ct2t.SetNextCondition(LogicConnector.AND, t1Ct3t);
        t1Ct1t.SetNextCondition(LogicConnector.AND, t1Ct2t);

        GuardMapping grdt1t = new GuardMapping();
        grdt1t.condition = t1Ct1t;
        grdt1t.Activations.add(new Activation(t1, "in_c1", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1t.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1t.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1t.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1t.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1t);


        // 3 coming trains, dep time C1 = C2 = C3, leaving time C1 > C3, C3 > C2
        Condition t1Ct1u = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2u = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3u = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4u = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5u = new Condition(t1, "in_c1", TransitionCondition.EqualDepartureTime, "in_c2");
        Condition t1Ct6u = new Condition(t1, "in_c2", TransitionCondition.EqualDepartureTime, "in_c3");
        Condition t1Ct7u = new Condition(t1, "in_c1", TransitionCondition.CheckLeavingTime, "in_c3");
        Condition t1Ct8u = new Condition(t1, "in_c3", TransitionCondition.CheckLeavingTime, "in_c2");

        t1Ct7u.SetNextCondition(LogicConnector.AND, t1Ct8u);
        t1Ct6u.SetNextCondition(LogicConnector.AND, t1Ct7u);
        t1Ct5u.SetNextCondition(LogicConnector.AND, t1Ct6u);
        t1Ct4u.SetNextCondition(LogicConnector.AND, t1Ct5u);
        t1Ct3u.SetNextCondition(LogicConnector.AND, t1Ct4u);
        t1Ct2u.SetNextCondition(LogicConnector.AND, t1Ct3u);
        t1Ct1u.SetNextCondition(LogicConnector.AND, t1Ct2u);

        GuardMapping grdt1u = new GuardMapping();
        grdt1u.condition = t1Ct1u;
        grdt1u.Activations.add(new Activation(t1, "in_c1", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1u.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1u.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1u.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1u.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1u);

        // 3 coming trains, dep time C1 = C2 = C3, leaving time C2 > C1, C1 > C3
        Condition t1Ct1v = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2v = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3v = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4v = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5v = new Condition(t1, "in_c1", TransitionCondition.EqualDepartureTime, "in_c2");
        Condition t1Ct6v = new Condition(t1, "in_c2", TransitionCondition.EqualDepartureTime, "in_c3");
        Condition t1Ct7v = new Condition(t1, "in_c2", TransitionCondition.CheckLeavingTime, "in_c1");
        Condition t1Ct8v = new Condition(t1, "in_c1", TransitionCondition.CheckLeavingTime, "in_c3");

        t1Ct7v.SetNextCondition(LogicConnector.AND, t1Ct8v);
        t1Ct6v.SetNextCondition(LogicConnector.AND, t1Ct7v);
        t1Ct5v.SetNextCondition(LogicConnector.AND, t1Ct6v);
        t1Ct4v.SetNextCondition(LogicConnector.AND, t1Ct5v);
        t1Ct3v.SetNextCondition(LogicConnector.AND, t1Ct4v);
        t1Ct2v.SetNextCondition(LogicConnector.AND, t1Ct3v);
        t1Ct1v.SetNextCondition(LogicConnector.AND, t1Ct2v);

        GuardMapping grdt1v = new GuardMapping();
        grdt1v.condition = t1Ct1v;
        grdt1v.Activations.add(new Activation(t1, "in_c2", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1v.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1v.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1v.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1v.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1v);

        // 3 coming trains, dep time C1 = C2 = C3, leaving time C2 > C3, C3 > C1
        Condition t1Ct1w = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2w = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3w = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4w = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5w = new Condition(t1, "in_c1", TransitionCondition.EqualDepartureTime, "in_c2");
        Condition t1Ct6w = new Condition(t1, "in_c2", TransitionCondition.EqualDepartureTime, "in_c3");
        Condition t1Ct7w = new Condition(t1, "in_c2", TransitionCondition.CheckLeavingTime, "in_c3");
        Condition t1Ct8w = new Condition(t1, "in_c3", TransitionCondition.CheckLeavingTime, "in_c1");

        t1Ct7w.SetNextCondition(LogicConnector.AND, t1Ct8w);
        t1Ct6w.SetNextCondition(LogicConnector.AND, t1Ct7w);
        t1Ct5w.SetNextCondition(LogicConnector.AND, t1Ct6w);
        t1Ct4w.SetNextCondition(LogicConnector.AND, t1Ct5w);
        t1Ct3w.SetNextCondition(LogicConnector.AND, t1Ct4w);
        t1Ct2w.SetNextCondition(LogicConnector.AND, t1Ct3w);
        t1Ct1w.SetNextCondition(LogicConnector.AND, t1Ct2w);

        GuardMapping grdt1w = new GuardMapping();
        grdt1w.condition = t1Ct1w;
        grdt1w.Activations.add(new Activation(t1, "in_c2", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1w.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1w.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1w.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1w.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1w);

        // 3 coming trains, dep time C1 = C2 = C3, leaving time C3 > C1, C1 > C2
        Condition t1Ct1x = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2x = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3x = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4x = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5x = new Condition(t1, "in_c1", TransitionCondition.EqualDepartureTime, "in_c2");
        Condition t1Ct6x = new Condition(t1, "in_c2", TransitionCondition.EqualDepartureTime, "in_c3");
        Condition t1Ct7x = new Condition(t1, "in_c3", TransitionCondition.CheckLeavingTime, "in_c1");
        Condition t1Ct8x = new Condition(t1, "in_c1", TransitionCondition.CheckLeavingTime, "in_c2");

        t1Ct7x.SetNextCondition(LogicConnector.AND, t1Ct8x);
        t1Ct6x.SetNextCondition(LogicConnector.AND, t1Ct7x);
        t1Ct5x.SetNextCondition(LogicConnector.AND, t1Ct6x);
        t1Ct4x.SetNextCondition(LogicConnector.AND, t1Ct5x);
        t1Ct3x.SetNextCondition(LogicConnector.AND, t1Ct4x);
        t1Ct2x.SetNextCondition(LogicConnector.AND, t1Ct3x);
        t1Ct1x.SetNextCondition(LogicConnector.AND, t1Ct2x);

        GuardMapping grdt1x = new GuardMapping();
        grdt1x.condition = t1Ct1x;
        grdt1x.Activations.add(new Activation(t1, "in_c3", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1x.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1x.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1x.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1x.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1x);

        // 3 coming trains, dep time C1 = C2 = C3, leaving time C3 > C2, C2 > C1
        Condition t1Ct1y = new Condition(t1, "g", TransitionCondition.NotNull);
        Condition t1Ct2y = new Condition(t1, "in_c1", TransitionCondition.NotNull);
        Condition t1Ct3y = new Condition(t1, "in_c2", TransitionCondition.NotNull);
        Condition t1Ct4y = new Condition(t1, "in_c3", TransitionCondition.NotNull);
        Condition t1Ct5y = new Condition(t1, "in_c1", TransitionCondition.EqualDepartureTime, "in_c2");
        Condition t1Ct6y = new Condition(t1, "in_c2", TransitionCondition.EqualDepartureTime, "in_c3");
        Condition t1Ct7y = new Condition(t1, "in_c3", TransitionCondition.CheckLeavingTime, "in_c2");
        Condition t1Ct8y = new Condition(t1, "in_c2", TransitionCondition.CheckLeavingTime, "in_c1");

        t1Ct7y.SetNextCondition(LogicConnector.AND, t1Ct8y);
        t1Ct6y.SetNextCondition(LogicConnector.AND, t1Ct7y);
        t1Ct5y.SetNextCondition(LogicConnector.AND, t1Ct6y);
        t1Ct4y.SetNextCondition(LogicConnector.AND, t1Ct5y);
        t1Ct3y.SetNextCondition(LogicConnector.AND, t1Ct4y);
        t1Ct2y.SetNextCondition(LogicConnector.AND, t1Ct3y);
        t1Ct1y.SetNextCondition(LogicConnector.AND, t1Ct2y);

        GuardMapping grdt1y = new GuardMapping();
        grdt1y.condition = t1Ct1y;
        grdt1y.Activations.add(new Activation(t1, "in_c3", TransitionOperation.CalculateLightTimeStation, "Delay"));
        grdt1y.Activations.add(new Activation(t1, "Delay", TransitionOperation.CalculateDelay, "Delay_Simulation"));  // Added CalculateDelay
        grdt1y.Activations.add(new Activation(t1, "Delay", "L3", TransitionOperation.MessageBox_Controllers));
        grdt1y.Activations.add(new Activation(t1, "g", TransitionOperation.Move, "r"));
        grdt1y.Activations.add(new Activation(t1, "red", TransitionOperation.SendOverNetwork, "OP_L3"));
        t1.GuardMappingList.add(grdt1y);

        t1.Delay = 0;
        pn.Transitions.add(t1);


// t2----------------------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("r");

        Condition t2DoNothingCondition = new Condition(t2, "r", TransitionCondition.IsNull);

        GuardMapping grdT2DoNothing = new GuardMapping();
        grdT2DoNothing.condition = t2DoNothingCondition;
        grdT2DoNothing.Activations.add(new Activation(t2, "", TransitionOperation.DoNothing, ""));
        t2.GuardMappingList.add(grdT2DoNothing);



        Condition t2Ct1 = new Condition(t2, "r", TransitionCondition.NotNull);


        GuardMapping grdt2 = new GuardMapping();
        grdt2.condition= t2Ct1;
        grdt2.Activations.add(new Activation(t2, "r", TransitionOperation.Move, "i"));
        grdt2.Activations.add(new Activation(t2, "Delay_Simulation", TransitionOperation.DynamicDelay,""));
        t2.GuardMappingList.add(grdt2);



        t2.Delay = 0;
        pn.Transitions.add(t2);




        // t0----------------------------------------------------------------
        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "t0";
        t0.InputPlaceName.add("i");


        Condition t0DoNothingCondition = new Condition(t0, "i", TransitionCondition.IsNull);

        GuardMapping grdT0DoNothing = new GuardMapping();
        grdT0DoNothing.condition = t0DoNothingCondition;
        grdT0DoNothing.Activations.add(new Activation(t0, "", TransitionOperation.DoNothing, ""));
        t0.GuardMappingList.add(grdT0DoNothing);


        Condition t0Ct1 = new Condition(t0, "i", TransitionCondition.NotNull);

        GuardMapping grdt0 = new GuardMapping();
        grdt0.condition= t0Ct1;
        grdt0.Activations.add(new Activation(t0, "i", TransitionOperation.Move, "g"));
        grdt0.Activations.add(new Activation(t0, "green", TransitionOperation.SendOverNetwork, "OP_L3"));
        t0.GuardMappingList.add(grdt0);

        t0.Delay = 0;
        pn.Transitions.add(t0);

        System.out.println("Controller L3 started \n ------------------------------");
        pn.Delay = 3000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.setTitle("Controller L3 - A Station");
        frame.petriNet = pn;
        frame.setVisible(true);

    }
}
