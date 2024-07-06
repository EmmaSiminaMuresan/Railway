package THESIS.Supervisors;

import Components.*;
import DataObjects.*;
import DataOnly.ListTrains;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.PetriObjectType;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;
import Interfaces.PetriObject;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Supervisor_A {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Supervisor A";

        pn.NetworkPort = 1080;

        int x = 7; ///// READ FROM THE KEYBOARD;

        LocalTime currentTime = LocalTime.now();

        DataLocalTime present_time = new DataLocalTime(); // needed for when it is pass 23:59:59
        present_time.SetName("present_time");
        present_time.SetValue(currentTime);
        pn.ConstantPlaceList.add(present_time);

        DataLocalTime current_time = new DataLocalTime(); // time to pass for the current train
        current_time.SetName("current_time");
        current_time.SetValue(null);
        pn.ConstantPlaceList.add(current_time); /// IS THIS CONSTANT IF IT WILL CHANGE EACH TIME?

        DataLocalTime prev_time = new DataLocalTime(); // time to pass for the prev train
        prev_time.SetName("prev_time");
        prev_time.SetValue(null);
        pn.ConstantPlaceList.add(prev_time); /// IS THIS CONSTANT IF IT WILL CHANGE EACH TIME?

        DataLocalTime C_TimeA = new DataLocalTime(); // time to pass for the prev train
        C_TimeA.SetName("C_TimeA");
        C_TimeA.SetValue(null);
        pn.PlaceList.add(C_TimeA); /// IS THIS CONSTANT IF IT WILL CHANGE EACH TIME?

        DataLocalTime C_TimeA1 = new DataLocalTime(); // time to pass for the prev train
        C_TimeA1.SetName("C_TimeA1");
        C_TimeA1.SetValue(null);
        pn.PlaceList.add(C_TimeA1); /// IS THIS CONSTANT IF IT WILL CHANGE EACH TIME?

        DataLocalTime C_TimeA2 = new DataLocalTime(); // time to pass for the prev train
        C_TimeA2.SetName("C_TimeA2");
        C_TimeA2.SetValue(null);
        pn.PlaceList.add(C_TimeA2); /// IS THIS CONSTANT IF IT WILL CHANGE EACH TIME?

        DataLocalTime C_TimeA3 = new DataLocalTime(); // time to pass for the prev train
        C_TimeA3.SetName("C_TimeA");
        C_TimeA3.SetValue(null);
        pn.PlaceList.add(C_TimeA3); /// IS THIS CONSTANT IF IT WILL CHANGE EACH TIME?

        DataString C_PA = new DataString();
        C_PA.SetName("C_PA");
        C_PA.SetValue(null);
        pn.ConstantPlaceList.add(C_PA);

        DataString C_PA1 = new DataString();
        C_PA1.SetName("C_PA1");
        C_PA1.SetValue(null);
        pn.ConstantPlaceList.add(C_PA1);

        DataString C_PA2 = new DataString();
        C_PA2.SetName("C_PA2");
        C_PA2.SetValue(null);
        pn.ConstantPlaceList.add(C_PA2);

        DataString C_PA3= new DataString();
        C_PA3.SetName("C_PA3");
        C_PA3.SetValue(null);
        pn.ConstantPlaceList.add(C_PA3);

        DataString C_PA4 = new DataString();
        C_PA4.SetName("C_PA4");
        C_PA4.SetValue(null);
        pn.ConstantPlaceList.add(C_PA4);

        DataString filePath = new DataString();
        filePath.SetName("filePath");
        filePath.SetValue("Trains_Station_A.txt"); ///////////// change this for each station!!
        filePath.textfile();
        pn.ConstantPlaceList.add(filePath);

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

        DataInteger A1_Length = new DataInteger();
        A1_Length.SetName("A1_Length");
        A1_Length.SetValue(x);  /////////
        pn.ConstantPlaceList.add(A1_Length);

        DataInteger A2_Length = new DataInteger();
        A2_Length.SetName("A2_Length");
        A2_Length.SetValue(x);//////////
        pn.ConstantPlaceList.add(A2_Length);

        DataInteger A3_Length = new DataInteger();
        A3_Length.SetName("A3_Length");
        A3_Length.SetValue(x);//////////
        pn.ConstantPlaceList.add(A3_Length);

        DataInteger A4_Length = new DataInteger();
        A4_Length.SetName("A1_Length");
        A4_Length.SetValue(x);////////////
        pn.ConstantPlaceList.add(A4_Length);

        DataInteger speed_on_platform = new DataInteger();
        speed_on_platform.SetName("Speed_On_Platform");
        speed_on_platform.SetValue(x); //////////////
        pn.ConstantPlaceList.add(speed_on_platform);

        DataInteger zero = new DataInteger();
        zero.SetName("Zero");
        zero.SetValue(0);
        pn.ConstantPlaceList.add(zero);

        DataInteger one = new DataInteger();
        one.SetName("One");
        one.SetValue(1);
        pn.ConstantPlaceList.add(one);

        DataInteger two = new DataInteger();
        two.SetName("Two");
        two.SetValue(2);
        pn.ConstantPlaceList.add(two);

        DataTrain p1 = new DataTrain();
        p1.SetName("Train_A");
        pn.PlaceList.add(p1);

        DataLocalTime p2 = new DataLocalTime();
        p2.SetName("Dep_Time_A");
        pn.PlaceList.add(p2);

        DataString p3 = new DataString();
        p3.SetName("Platform_A");
        pn.PlaceList.add(p3);

        DataListTrains p4 = new DataListTrains();
        p4.SetName("D_Train_A");
        pn.PlaceList.add(p4);

        DataListTrainsQueue p5 = new DataListTrainsQueue();
        p5.Value.Size = 2;
        p5.SetName("List_A");
        pn.PlaceList.add(p5);

        DataListTrainsHistory p6 = new DataListTrainsHistory();
        p6.SetName("H_List_A");
        pn.PlaceList.add(p6);

        DataTransfer T1_A = new DataTransfer();
        T1_A.SetName("T1_A");
        T1_A.Value = new TransferOperation("localhost", "1081", "Train_A1");
        pn.PlaceList.add(T1_A);

        DataTransfer T2_A = new DataTransfer();
        T2_A.SetName("T2_A");
        T2_A.Value = new TransferOperation("localhost", "1081", "Train_A2");
        pn.PlaceList.add(T2_A);

        DataTransfer T3_A = new DataTransfer();
        T3_A.SetName("T3_A");
        T3_A.Value = new TransferOperation("localhost", "1081", "Train_A3");
        pn.PlaceList.add(T3_A);

        DataTransfer Time1_A = new DataTransfer();
        Time1_A.SetName("Time1_A");
        Time1_A.Value = new TransferOperation("localhost", "1081", "Time_A1");
        pn.PlaceList.add(Time1_A);

        DataTransfer Time2_A = new DataTransfer();
        Time2_A.SetName("Time2_A");
        Time2_A.Value = new TransferOperation("localhost", "1081", "Time_A2");
        pn.PlaceList.add(Time2_A);

        DataTransfer Time3_A = new DataTransfer();
        Time3_A.SetName("Time3_A");
        Time3_A.Value = new TransferOperation("localhost", "1081", "Time_A3");
        pn.PlaceList.add(Time3_A);

        // T0 ------------------------------------------------
        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "t0";
        t0.InputPlaceName.add("Train_A");
        t0.InputPlaceName.add("Dep_Time_A");
        t0.InputPlaceName.add("Platform_A");
        t0.InputPlaceName.add("C_PA");
        t0.InputPlaceName.add("C_TimeA");
        t0.InputPlaceName.add("List_A");


        // no comming train

        Condition t0Ct1a = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2a = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3a = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4a = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5a = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6a = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7a = new Condition(t0, "List_A", TransitionCondition.Have_NoListTrain);
        Condition t0Ct8a = new Condition(t0, "Platform_A", TransitionCondition.Contains,"A1");

        t0Ct7a.SetNextCondition(LogicConnector.AND, t0Ct8a);
        t0Ct6a.SetNextCondition(LogicConnector.AND, t0Ct7a);
        t0Ct5a.SetNextCondition(LogicConnector.AND, t0Ct6a);
        t0Ct4a.SetNextCondition(LogicConnector.AND, t0Ct5a);
        t0Ct3a.SetNextCondition(LogicConnector.AND, t0Ct4a);
        t0Ct2a.SetNextCondition(LogicConnector.AND, t0Ct3a);
        t0Ct1a.SetNextCondition(LogicConnector.AND, t0Ct2a);

        GuardMapping grdt0a = new GuardMapping();
        grdt0a.condition = t0Ct1a;
        grdt0a.Activations.add(new Activation(t0,p1,p2,p3,null,A1_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, p4));
        t0.GuardMappingList.add(grdt0a);


        Condition t0Ct1b = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2b = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3b = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4b = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5b = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6b = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7b = new Condition(t0, "List_A", TransitionCondition.Have_NoListTrain);
        Condition t0Ct8b = new Condition(t0, "Platform_A", TransitionCondition.Contains,"A2");

        t0Ct7b.SetNextCondition(LogicConnector.AND, t0Ct8b);
        t0Ct6b.SetNextCondition(LogicConnector.AND, t0Ct7b);
        t0Ct5b.SetNextCondition(LogicConnector.AND, t0Ct6b);
        t0Ct4b.SetNextCondition(LogicConnector.AND, t0Ct5b);
        t0Ct3b.SetNextCondition(LogicConnector.AND, t0Ct4b);
        t0Ct2b.SetNextCondition(LogicConnector.AND, t0Ct3b);
        t0Ct1b.SetNextCondition(LogicConnector.AND, t0Ct2b);

        GuardMapping grdt0b = new GuardMapping();
        grdt0b.condition = t0Ct1b;
        grdt0b.Activations.add(new Activation(t0,p1,p2,p3,null,A2_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, p4));
        t0.GuardMappingList.add(grdt0b);


        Condition t0Ct1c = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2c = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3c = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4c = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5c = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6c = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7c = new Condition(t0, "List_A", TransitionCondition.Have_NoListTrain);
        Condition t0Ct8c = new Condition(t0, "Platform_A", TransitionCondition.Contains,"A3");

        t0Ct7c.SetNextCondition(LogicConnector.AND, t0Ct8c);
        t0Ct6c.SetNextCondition(LogicConnector.AND, t0Ct7c);
        t0Ct5c.SetNextCondition(LogicConnector.AND, t0Ct6c);
        t0Ct4c.SetNextCondition(LogicConnector.AND, t0Ct5c);
        t0Ct3c.SetNextCondition(LogicConnector.AND, t0Ct4c);
        t0Ct2c.SetNextCondition(LogicConnector.AND, t0Ct3c);
        t0Ct1c.SetNextCondition(LogicConnector.AND, t0Ct2c);

        GuardMapping grdt0c = new GuardMapping();
        grdt0c.condition = t0Ct1c;
        grdt0c.Activations.add(new Activation(t0,p1,p2,p3,null,A3_Length,null,speed_on_platform, TransitionOperation.CreateTrain_Null, p4));
        t0.GuardMappingList.add(grdt0c);


        Condition t0Ct1d = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2d = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3d = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4d = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5d = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6d = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7d = new Condition(t0, "List_A", TransitionCondition.HaveListTrain);
        Condition t0Ct8d = new Condition(t0, "Platform_A", TransitionCondition.Contains,"A1");

        t0Ct7d.SetNextCondition(LogicConnector.AND, t0Ct8d);
        t0Ct6d.SetNextCondition(LogicConnector.AND, t0Ct7d);
        t0Ct5d.SetNextCondition(LogicConnector.AND, t0Ct6d);
        t0Ct4d.SetNextCondition(LogicConnector.AND, t0Ct5d);
        t0Ct3d.SetNextCondition(LogicConnector.AND, t0Ct4d);
        t0Ct2d.SetNextCondition(LogicConnector.AND, t0Ct3d);
        t0Ct1d.SetNextCondition(LogicConnector.AND, t0Ct2d);

        GuardMapping grdt0d = new GuardMapping();
        grdt0d.condition = t0Ct1d;
        grdt0d.Activations.add(new Activation(t0,p1,p2,p3,p5,A1_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, p4));
        t0.GuardMappingList.add(grdt0d);


        Condition t0Ct1e = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2e = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3e = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4e = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5e = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6e = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7e = new Condition(t0, "List_A", TransitionCondition.HaveListTrain);
        Condition t0Ct8e = new Condition(t0, "Platform_A", TransitionCondition.Contains,"A2");

        t0Ct7e.SetNextCondition(LogicConnector.AND, t0Ct8e);
        t0Ct6e.SetNextCondition(LogicConnector.AND, t0Ct7e);
        t0Ct5e.SetNextCondition(LogicConnector.AND, t0Ct6e);
        t0Ct4e.SetNextCondition(LogicConnector.AND, t0Ct5e);
        t0Ct3e.SetNextCondition(LogicConnector.AND, t0Ct4e);
        t0Ct2e.SetNextCondition(LogicConnector.AND, t0Ct3e);
        t0Ct1e.SetNextCondition(LogicConnector.AND, t0Ct2e);

        GuardMapping grdt0e = new GuardMapping();
        grdt0e.condition = t0Ct1e;
        grdt0e.Activations.add(new Activation(t0,p1,p2,p3,p5,A2_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, p4));
        t0.GuardMappingList.add(grdt0e);


        Condition t0Ct1f = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2f = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3f = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4f = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5f = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6f = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7f = new Condition(t0, "List_A", TransitionCondition.HaveListTrain);
        Condition t0Ct8f = new Condition(t0, "Platform_A", TransitionCondition.Contains,"A3");

        t0Ct7f.SetNextCondition(LogicConnector.AND, t0Ct8f);
        t0Ct6f.SetNextCondition(LogicConnector.AND, t0Ct7f);
        t0Ct5f.SetNextCondition(LogicConnector.AND, t0Ct6f);
        t0Ct4f.SetNextCondition(LogicConnector.AND, t0Ct5f);
        t0Ct3f.SetNextCondition(LogicConnector.AND, t0Ct4f);
        t0Ct2f.SetNextCondition(LogicConnector.AND, t0Ct3f);
        t0Ct1f.SetNextCondition(LogicConnector.AND, t0Ct2f);

        GuardMapping grdt0f = new GuardMapping();
        grdt0f.condition = t0Ct1f;
        grdt0f.Activations.add(new Activation(t0,p1,p2,p3,p5,A3_Length,null,speed_on_platform, TransitionOperation.CreateTrain_Null, p4));
        t0.GuardMappingList.add(grdt0f);


        // there is a comming train

        Condition t0Ct1g = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2g = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3g = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4g = new Condition(t0, "C_PA", TransitionCondition.NotNull);
        Condition t0Ct5g = new Condition(t0, "C_TimeA", TransitionCondition.NotNull);
        Condition t0Ct6g = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7g = new Condition(t0, "List_A", TransitionCondition.Have_NoListTrain);
        Condition t0Ct8g = new Condition(t0, "Platform_A", TransitionCondition.Contains,"A1");

        t0Ct7g.SetNextCondition(LogicConnector.AND, t0Ct8g);
        t0Ct6g.SetNextCondition(LogicConnector.AND, t0Ct7g);
        t0Ct5g.SetNextCondition(LogicConnector.AND, t0Ct6g);
        t0Ct4g.SetNextCondition(LogicConnector.AND, t0Ct5g);
        t0Ct3g.SetNextCondition(LogicConnector.AND, t0Ct4g);
        t0Ct2g.SetNextCondition(LogicConnector.AND, t0Ct3g);
        t0Ct1g.SetNextCondition(LogicConnector.AND, t0Ct2g);

        GuardMapping grdt0g = new GuardMapping();
        grdt0g.condition = t0Ct1g;
        grdt0g.Activations.add(new Activation(t0,p1,p2,p3,C_TimeA,C_PA,null,A1_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_NotNull, p4));
        t0.GuardMappingList.add(grdt0g);


        Condition t0Ct1h = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2h = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3h = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4h = new Condition(t0, "C_PA", TransitionCondition.NotNull);
        Condition t0Ct5h = new Condition(t0, "C_TimeA", TransitionCondition.NotNull);
        Condition t0Ct6h = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7h = new Condition(t0, "List_A", TransitionCondition.Have_NoListTrain);
        Condition t0Ct8h = new Condition(t0, "Platform_A", TransitionCondition.Contains,"A2");

        t0Ct7h.SetNextCondition(LogicConnector.AND, t0Ct8h);
        t0Ct6h.SetNextCondition(LogicConnector.AND, t0Ct7h);
        t0Ct5h.SetNextCondition(LogicConnector.AND, t0Ct6h);
        t0Ct4h.SetNextCondition(LogicConnector.AND, t0Ct5h);
        t0Ct3h.SetNextCondition(LogicConnector.AND, t0Ct4h);
        t0Ct2h.SetNextCondition(LogicConnector.AND, t0Ct3h);
        t0Ct1h.SetNextCondition(LogicConnector.AND, t0Ct2h);


        GuardMapping grdt0h = new GuardMapping();
        grdt0h.condition = t0Ct1h;
        grdt0h.Activations.add(new Activation(t0,p1,p2,p3,C_TimeA,C_PA,null,A2_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_NotNull, p4));
        t0.GuardMappingList.add(grdt0h);


        Condition t0Ct1i = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2i = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3i = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4i = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5i = new Condition(t0, "C_TimeA", TransitionCondition.NotNull);
        Condition t0Ct6i = new Condition(t0, "D_Train_A", TransitionCondition.NotNull);
        Condition t0Ct7i = new Condition(t0, "List_A", TransitionCondition.Have_NoListTrain);
        Condition t0Ct8i = new Condition(t0, "Platform_A", TransitionCondition.Contains,"A3");

        t0Ct7i.SetNextCondition(LogicConnector.AND, t0Ct8i);
        t0Ct6i.SetNextCondition(LogicConnector.AND, t0Ct7i);
        t0Ct5i.SetNextCondition(LogicConnector.AND, t0Ct6i);
        t0Ct4i.SetNextCondition(LogicConnector.AND, t0Ct5i);
        t0Ct3i.SetNextCondition(LogicConnector.AND, t0Ct4i);
        t0Ct2i.SetNextCondition(LogicConnector.AND, t0Ct3i);
        t0Ct1i.SetNextCondition(LogicConnector.AND, t0Ct2i);


        GuardMapping grdt0i = new GuardMapping();
        grdt0i.condition = t0Ct1i;
        grdt0i.Activations.add(new Activation(t0,p1,p2,p3,C_TimeA,C_PA,null,A3_Length,null,speed_on_platform, TransitionOperation.CreateTrain_NotNull, p4));
        t0.GuardMappingList.add(grdt0i);


        Condition t0Ct1j = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2j = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3j = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4j = new Condition(t0, "C_PA", TransitionCondition.NotNull);
        Condition t0Ct5j = new Condition(t0, "C_TimeA", TransitionCondition.NotNull);
        Condition t0Ct6j = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7j = new Condition(t0, "List_A", TransitionCondition.HaveListTrain);
        Condition t0Ct8j = new Condition(t0, "Platform_A", TransitionCondition.Contains,"A1");

        t0Ct7j.SetNextCondition(LogicConnector.AND, t0Ct8j);
        t0Ct6j.SetNextCondition(LogicConnector.AND, t0Ct7j);
        t0Ct5j.SetNextCondition(LogicConnector.AND, t0Ct6j);
        t0Ct4j.SetNextCondition(LogicConnector.AND, t0Ct5j);
        t0Ct3j.SetNextCondition(LogicConnector.AND, t0Ct4j);
        t0Ct2j.SetNextCondition(LogicConnector.AND, t0Ct3j);
        t0Ct1j.SetNextCondition(LogicConnector.AND, t0Ct2j);


        GuardMapping grdt0j = new GuardMapping();
        grdt0j.condition = t0Ct1j;
        grdt0j.Activations.add(new Activation(t0,p1,p2,p3,C_TimeA,C_PA,p5,A1_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_NotNull, p4));
        t0.GuardMappingList.add(grdt0j);


        Condition t0Ct1k = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2k = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3k = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4k = new Condition(t0, "C_PA", TransitionCondition.NotNull);
        Condition t0Ct5k = new Condition(t0, "C_TimeA", TransitionCondition.NotNull);
        Condition t0Ct6k = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7k = new Condition(t0, "List_A", TransitionCondition.HaveListTrain);
        Condition t0Ct8k = new Condition(t0, "Platform_A", TransitionCondition.Contains,"A2");

        t0Ct7k.SetNextCondition(LogicConnector.AND, t0Ct8k);
        t0Ct6k.SetNextCondition(LogicConnector.AND, t0Ct7k);
        t0Ct5k.SetNextCondition(LogicConnector.AND, t0Ct6k);
        t0Ct4k.SetNextCondition(LogicConnector.AND, t0Ct5k);
        t0Ct3k.SetNextCondition(LogicConnector.AND, t0Ct4k);
        t0Ct2k.SetNextCondition(LogicConnector.AND, t0Ct3k);
        t0Ct1k.SetNextCondition(LogicConnector.AND, t0Ct2k);


        GuardMapping grdt0k = new GuardMapping();
        grdt0k.condition = t0Ct1k;
        grdt0k.Activations.add(new Activation(t0,p1,p2,p3,C_TimeA,C_PA,p5,A2_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_NotNull, p4));
        t0.GuardMappingList.add(grdt0k);


        Condition t0Ct1l = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2l = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3l = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4l = new Condition(t0, "C_PA", TransitionCondition.NotNull);
        Condition t0Ct5l = new Condition(t0, "C_TimeA", TransitionCondition.NotNull);
        Condition t0Ct6l = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7l = new Condition(t0, "List_A", TransitionCondition.HaveListTrain);
        Condition t0Ct8l = new Condition(t0, "Platform_A", TransitionCondition.Contains,"A3");

        t0Ct7l.SetNextCondition(LogicConnector.AND, t0Ct8l);
        t0Ct6l.SetNextCondition(LogicConnector.AND, t0Ct7l);
        t0Ct5l.SetNextCondition(LogicConnector.AND, t0Ct6l);
        t0Ct4l.SetNextCondition(LogicConnector.AND, t0Ct5l);
        t0Ct3l.SetNextCondition(LogicConnector.AND, t0Ct4l);
        t0Ct2l.SetNextCondition(LogicConnector.AND, t0Ct3l);
        t0Ct1l.SetNextCondition(LogicConnector.AND, t0Ct2l);


        GuardMapping grdt0l = new GuardMapping();
        grdt0l.condition = t0Ct1l;
        grdt0l.Activations.add(new Activation(t0,p1,p2,p3,C_TimeA,C_PA,p5,A3_Length,null,speed_on_platform, TransitionOperation.CreateTrain_NotNull, p4));
        t0.GuardMappingList.add(grdt0l);

        t0.Delay = 0;
        pn.Transitions.add(t0);

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("D_Train_A");


        Condition t1Ct1a = new Condition(t1, "D_Train_A", TransitionCondition.NotNull);
        Condition t1Ct2a = new Condition(t1, "List_A", TransitionCondition.CanAddTrains_List);

        t1Ct1a.SetNextCondition(LogicConnector.AND, t1Ct2a);

        GuardMapping grdt1a = new GuardMapping();
        grdt1a.condition = t1Ct1a;
        grdt1a.Activations.add(new Activation(t1, "D_Train_A", TransitionOperation.AddElement, "List_A"));
        grdt1a.Activations.add(new Activation(t1, "D_Train_A", TransitionOperation.Move, "D_Train_A"));
        t1.GuardMappingList.add(grdt1a);


        Condition t1Ct1b = new Condition(t1, "D_Train_A", TransitionCondition.NotNull);
        Condition t1Ct2b = new Condition(t1, "List_A", TransitionCondition.CanNotAddTrains_List);

        t1Ct1b.SetNextCondition(LogicConnector.AND, t1Ct2b);

        GuardMapping grdt1b = new GuardMapping();
        grdt1b.condition = t1Ct1b;
        grdt1b.Activations.add(new Activation(t1, p5, TransitionOperation.RemoveFirst, p5));
        grdt1b.Activations.add(new Activation(t1, "D_Train_A", TransitionOperation.AddElement, "List_A"));
        grdt1b.Activations.add(new Activation(t1, "D_Train_A", TransitionOperation.Move, "D_Train_A"));
        t1.GuardMappingList.add(grdt1b);


        t1.Delay = 0;
        pn.Transitions.add(t1);

        // T2 ------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("D_Train_A");


        Condition t2Ct1 = new Condition(t2, "D_Train_A", TransitionCondition.NotNull);


        GuardMapping grdt2 = new GuardMapping();
        grdt2.condition = t2Ct1;
        grdt2.Activations.add(new Activation(t2, "D_Train_A", TransitionOperation.AddElement, "H_List_A"));
        t2.GuardMappingList.add(grdt2);

        t2.Delay = 0;
        pn.Transitions.add(t2);


        // T3 ------------------------------------------------


        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "t3";
        t3.InputPlaceName.add("H_List_A");


        Condition t3Ct1a = new Condition(t3, "H_List_A", TransitionCondition.HaveListTrain_History);
        Condition t3Ct2a = new Condition(t3, "H_List_A", TransitionCondition.CheckTime_Before);

        t3Ct1a.SetNextCondition(LogicConnector.AND, t3Ct2a);

        GuardMapping grdt3a = new GuardMapping();
        grdt3a.condition = t3Ct2a;
        grdt3a.Activations.add(new Activation(t3, "H_List_A", TransitionOperation.Move, "H_List_A"));
        t3.GuardMappingList.add(grdt3a);



        Condition t3Ct1b = new Condition(t3, "H_List_A", TransitionCondition.HaveListTrain_History);
        Condition t3Ct2b= new Condition(t3, "H_List_A", TransitionCondition.CheckTime_After);

        t3Ct1b.SetNextCondition(LogicConnector.AND, t3Ct2b);

        GuardMapping grdt3b = new GuardMapping();
        grdt3b.condition = t3Ct2b;
        grdt3b.Activations.add(new Activation(t3,p6, filePath , TransitionOperation.SaveAndDelete, p6));
        t3.GuardMappingList.add(grdt3b);

        t3.Delay = 0;
        pn.Transitions.add(t3);


        // T4 ------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "t4";
        t4.InputPlaceName.add("List_A");


        Condition t4Ct1a = new Condition(t4, "List_A", TransitionCondition.HaveListTrain);
        Condition t4Ct1b = new Condition(t4, "List_A", TransitionCondition.Platform1);

        t4Ct1a.SetNextCondition(LogicConnector.AND, t4Ct1b);

        GuardMapping grdt4a = new GuardMapping();
        grdt4a.condition = t4Ct1a;
        grdt4a.Activations.add(new Activation(t4, "current_time", TransitionOperation.SendOverNetwork, "Time1_A"));
        grdt4a.Activations.add(new Activation(t4, "Train_A", TransitionOperation.SendOverNetwork, "T1_A"));
        t4.GuardMappingList.add(grdt4a);


        t4.Delay = 0;
        pn.Transitions.add(t4);

        // T5 ------------------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "t5";
        t5.InputPlaceName.add("C_TimeA1");
        t5.InputPlaceName.add("C_TimeA2");
        t5.InputPlaceName.add("C_TimeA3");
        t5.InputPlaceName.add("C_TimeA4");


        Condition t5Ct1a = new Condition(t1, "C_TimeA1", TransitionCondition.NotNull);

        GuardMapping grdt5a = new GuardMapping();
        grdt5a.condition = t5Ct1a;
        grdt5a.Activations.add(new Activation(t5, "C_TimeA1", TransitionOperation.Move, "C_TimeA"));
        t5.GuardMappingList.add(grdt5a);


        Condition t5Ct1b = new Condition(t1, "C_TimeA2", TransitionCondition.NotNull);

        GuardMapping grdt5b = new GuardMapping();
        grdt5b.condition = t5Ct1b;
        grdt5b.Activations.add(new Activation(t5, "C_TimeA2", TransitionOperation.Move, "C_TimeA"));
        t5.GuardMappingList.add(grdt5b);


        Condition t5Ct1c = new Condition(t1, "C_TimeA3", TransitionCondition.NotNull);

        GuardMapping grdt5c = new GuardMapping();
        grdt5c.condition = t5Ct1c;
        grdt5c.Activations.add(new Activation(t5, "C_TimeA3", TransitionOperation.Move, "C_TimeA"));
        t5.GuardMappingList.add(grdt5c);


        Condition t5Ct1d = new Condition(t1, "C_TimeA4", TransitionCondition.NotNull);

        GuardMapping grdt5d = new GuardMapping();
        grdt5d.condition = t5Ct1d;
        grdt5d.Activations.add(new Activation(t5, "C_TimeA4", TransitionOperation.Move, "C_TimeA"));
        t5.GuardMappingList.add(grdt5d);


        t5.Delay = 0;
        pn.Transitions.add(t5);


        // T6 ------------------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "t6";
        t6.InputPlaceName.add("C_PA1");
        t6.InputPlaceName.add("C_PA2");
        t6.InputPlaceName.add("C_PA3");
        t6.InputPlaceName.add("C_PA4");


        Condition t6Ct1a = new Condition(t1, "C_PA1", TransitionCondition.NotNull);

        GuardMapping grdt6a = new GuardMapping();
        grdt6a.condition = t6Ct1a;
        grdt6a.Activations.add(new Activation(t6, "C_PA1", TransitionOperation.Move, "C_PA"));
        t6.GuardMappingList.add(grdt6a);


        Condition t6Ct1b = new Condition(t1, "C_PA2", TransitionCondition.NotNull);

        GuardMapping grdt6b = new GuardMapping();
        grdt6b.condition = t6Ct1b;
        grdt6b.Activations.add(new Activation(t6, "C_PA2", TransitionOperation.Move, "C_PA"));
        t6.GuardMappingList.add(grdt6b);


        Condition t6Ct1c = new Condition(t1, "C_PA3", TransitionCondition.NotNull);

        GuardMapping grdt6c = new GuardMapping();
        grdt6c.condition = t6Ct1c;
        grdt6c.Activations.add(new Activation(t6, "C_PA3", TransitionOperation.Move, "C_PA"));
        t6.GuardMappingList.add(grdt6c);


        Condition t6Ct1d = new Condition(t1, "C_PA4", TransitionCondition.NotNull);

        GuardMapping grdt6d = new GuardMapping();
        grdt6d.condition = t6Ct1d;
        grdt6d.Activations.add(new Activation(t6, "C_PA4", TransitionOperation.Move, "C_PA"));
        t6.GuardMappingList.add(grdt6d);


        t6.Delay = 0;
        pn.Transitions.add(t6);
    }
}
