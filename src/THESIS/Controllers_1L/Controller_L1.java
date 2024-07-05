package THESIS.Controllers_1L;

import Components.*;
import DataObjects.DataInteger;
import DataObjects.DataLocalTime;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

import java.time.LocalTime;

public class Controller_L1 {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Controller L1";

        pn.NetworkPort = 1082;

        LocalTime currentTime = LocalTime.now();

        DataLocalTime current_time = new DataLocalTime(); // time to pass for the current train
        current_time.SetName("current_time");
        current_time.SetValue(currentTime);
        pn.PlaceList.add(current_time); /// IS THIS CONSTANT IF IT WILL CHANGE EACH TIME?

        DataLocalTime in_a1 = new DataLocalTime(); // time to pass for the prev train
        in_a1.SetName("in_a1");
        in_a1.SetValue(null);
        pn.PlaceList.add(in_a1);

        DataLocalTime in_a2 = new DataLocalTime(); // time to pass for the prev train
        in_a2.SetName("in_a1");
        in_a2.SetValue(null);
        pn.PlaceList.add(in_a2);

        DataLocalTime in_a3 = new DataLocalTime(); // time to pass for the prev train
        in_a3.SetName("in_a3");
        in_a3.SetValue(null);
        pn.PlaceList.add(in_a3);

        DataInteger L_time = new DataInteger();
        L_time.SetName("L_time");
        L_time.SetValue(0);
        pn.PlaceList.add(L_time);

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
        grdt_ini.Activations.add(new Activation(t_ini, "", TransitionOperation.MakeNull, "ini")); ///WHY?

        t_ini.GuardMappingList.add(grdt_ini);

        t_ini.Delay = 0;
        pn.Transitions.add(t_ini);


    }
}
