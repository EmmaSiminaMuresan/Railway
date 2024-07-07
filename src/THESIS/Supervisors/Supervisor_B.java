package THESIS.Supervisors;

import Components.*;
import DataObjects.*;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

import java.time.LocalTime;

public class Supervisor_B {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Supervisor B";
        pn.SetName("Supervisor B");

        pn.NetworkPort = 1091;

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

        DataLocalTime C_TimeB = new DataLocalTime(); // time to pass for the prev train
        C_TimeB.SetName("C_TimeB");
        C_TimeB.SetValue(null);
        pn.PlaceList.add(C_TimeB); /// IS THIS CONSTANT IF IT WILL CHANGE EACH TIME?

        DataLocalTime C_TimeB1 = new DataLocalTime(); // time to pass for the prev train
        C_TimeB1.SetName("C_TimeB1");
        C_TimeB1.SetValue(null);
        pn.PlaceList.add(C_TimeB1); /// IS THIS CONSTANT IF IT WILL CHANGE EACH TIME?

        DataLocalTime C_TimeB2 = new DataLocalTime(); // time to pass for the prev train
        C_TimeB2.SetName("C_TimeB2");
        C_TimeB2.SetValue(null);
        pn.PlaceList.add(C_TimeB2); /// IS THIS CONSTANT IF IT WILL CHANGE EACH TIME?

        DataLocalTime C_TimeB3 = new DataLocalTime(); // time to pass for the prev train
        C_TimeB3.SetName("C_TimeB");
        C_TimeB3.SetValue(null);
        pn.PlaceList.add(C_TimeB3); /// IS THIS CONSTANT IF IT WILL CHANGE EACH TIME?

        DataString C_PB = new DataString();
        C_PB.SetName("C_PB");
        C_PB.SetValue(null);
        pn.ConstantPlaceList.add(C_PB);

        DataString C_PB1 = new DataString();
        C_PB1.SetName("C_PB1");
        C_PB1.SetValue(null);
        pn.ConstantPlaceList.add(C_PB1);

        DataString C_PB2 = new DataString();
        C_PB2.SetName("C_PB2");
        C_PB2.SetValue(null);
        pn.ConstantPlaceList.add(C_PB2);

        DataString C_PB3= new DataString();
        C_PB3.SetName("C_PB3");
        C_PB3.SetValue(null);
        pn.ConstantPlaceList.add(C_PB3);

        DataString C_PB4 = new DataString();
        C_PB4.SetName("C_PB4");
        C_PB4.SetValue(null);
        pn.ConstantPlaceList.add(C_PB4);

        DataString filePath = new DataString();
        filePath.SetName("filePath");
        filePath.SetValue("Trains_Station_B.txt"); ///////////// change this for each station!!
        filePath.textfile();
        pn.ConstantPlaceList.add(filePath);

        DataString B1 = new DataString();
        B1.SetName("B1");
        B1.SetValue("B1");
        pn.ConstantPlaceList.add(B1);

        DataString B2 = new DataString();
        B2.SetName("B2");
        B2.SetValue("B2");
        pn.ConstantPlaceList.add(B2);

        DataString B3 = new DataString();
        B3.SetName("B3");
        B3.SetValue("B3");
        pn.ConstantPlaceList.add(B3);

        DataInteger B1_Length = new DataInteger();
        B1_Length.SetName("B1_Length");
        pn.ConstantPlaceList.add(B1_Length);

        DataInteger B2_Length = new DataInteger();
        B2_Length.SetName("B2_Length");
        pn.ConstantPlaceList.add(B2_Length);

        DataInteger B3_Length = new DataInteger();
        B3_Length.SetName("B3_Length");
        pn.ConstantPlaceList.add(B3_Length);

        DataInteger A4_Length = new DataInteger();
        A4_Length.SetName("B1_Length");
        pn.ConstantPlaceList.add(A4_Length);

        DataInteger speed_on_platform = new DataInteger();
        speed_on_platform.SetName("Speed_On_Platform");
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
        p1.SetName("Train_B");
        pn.PlaceList.add(p1);

        DataLocalTime p2 = new DataLocalTime();
        p2.SetName("Dep_Time_B");
        pn.PlaceList.add(p2);

        DataString p3 = new DataString();
        p3.SetName("Platform_B");
        pn.PlaceList.add(p3);

        DataListTrains p4 = new DataListTrains();
        p4.SetName("D_Train_B");
        pn.PlaceList.add(p4);

        DataListTrainsQueue p5 = new DataListTrainsQueue();
        p5.Value.Size = 2;
        p5.SetName("List_B");
        pn.PlaceList.add(p5);

        DataListTrainsHistory p6 = new DataListTrainsHistory();
        p6.SetName("H_List_B");
        pn.PlaceList.add(p6);

        DataTransfer T1_B = new DataTransfer();
        T1_B.SetName("T1_B");
        T1_B.Value = new TransferOperation("localhost", "1081", "Train_B1");
        pn.PlaceList.add(T1_B);

        DataTransfer T2_B = new DataTransfer();
        T2_B.SetName("T2_B");
        T2_B.Value = new TransferOperation("localhost", "1081", "Train_B2");
        pn.PlaceList.add(T2_B);

        DataTransfer T3_B = new DataTransfer();
        T3_B.SetName("T3_B");
        T3_B.Value = new TransferOperation("localhost", "1081", "Train_B3");
        pn.PlaceList.add(T3_B);

        DataTransfer Time1_B = new DataTransfer();
        Time1_B.SetName("Time1_B");
        Time1_B.Value = new TransferOperation("localhost", "1081", "Time_B1");
        pn.PlaceList.add(Time1_B);

        DataTransfer Time2_B = new DataTransfer();
        Time2_B.SetName("Time2_B");
        Time2_B.Value = new TransferOperation("localhost", "1081", "Time_B2");
        pn.PlaceList.add(Time2_B);

        DataTransfer Time3_B = new DataTransfer();
        Time3_B.SetName("Time3_B");
        Time3_B.Value = new TransferOperation("localhost", "1081", "Time_B3");
        pn.PlaceList.add(Time3_B);

        // T0 ------------------------------------------------
        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "t0";
        t0.InputPlaceName.add("Train_B");
        t0.InputPlaceName.add("Dep_Time_B");
        t0.InputPlaceName.add("Platform_B");
        t0.InputPlaceName.add("C_PB");
        t0.InputPlaceName.add("C_TimeB");
        t0.InputPlaceName.add("H_List_B");


        // no comming train

        Condition t0Ct1a = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2a = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3a = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4a = new Condition(t0, "C_PB", TransitionCondition.IsNull);
        Condition t0Ct5a = new Condition(t0, "C_TimeB", TransitionCondition.IsNull);
        Condition t0Ct6a = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7a = new Condition(t0, "H_List_B", TransitionCondition.Have_NoListTrain_History);
        Condition t0Ct8a = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B1");

        t0Ct7a.SetNextCondition(LogicConnector.AND, t0Ct8a);
        t0Ct6a.SetNextCondition(LogicConnector.AND, t0Ct7a);
        t0Ct5a.SetNextCondition(LogicConnector.AND, t0Ct6a);
        t0Ct4a.SetNextCondition(LogicConnector.AND, t0Ct5a);
        t0Ct3a.SetNextCondition(LogicConnector.AND, t0Ct4a);
        t0Ct2a.SetNextCondition(LogicConnector.AND, t0Ct3a);
        t0Ct1a.SetNextCondition(LogicConnector.AND, t0Ct2a);

        GuardMapping grdt0a = new GuardMapping();
        grdt0a.condition = t0Ct1a;
        grdt0a.Activations.add(new Activation(t0,p1,p2,p3,null,B1_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, p4));
        t0.GuardMappingList.add(grdt0a);


        Condition t0Ct1b = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2b = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3b = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4b = new Condition(t0, "C_PB", TransitionCondition.IsNull);
        Condition t0Ct5b = new Condition(t0, "C_TimeB", TransitionCondition.IsNull);
        Condition t0Ct6b = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7b = new Condition(t0, "H_List_B", TransitionCondition.Have_NoListTrain_History);
        Condition t0Ct8b = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B2");

        t0Ct7b.SetNextCondition(LogicConnector.AND, t0Ct8b);
        t0Ct6b.SetNextCondition(LogicConnector.AND, t0Ct7b);
        t0Ct5b.SetNextCondition(LogicConnector.AND, t0Ct6b);
        t0Ct4b.SetNextCondition(LogicConnector.AND, t0Ct5b);
        t0Ct3b.SetNextCondition(LogicConnector.AND, t0Ct4b);
        t0Ct2b.SetNextCondition(LogicConnector.AND, t0Ct3b);
        t0Ct1b.SetNextCondition(LogicConnector.AND, t0Ct2b);

        GuardMapping grdt0b = new GuardMapping();
        grdt0b.condition = t0Ct1b;
        grdt0b.Activations.add(new Activation(t0,p1,p2,p3,null,B2_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, p4));
        t0.GuardMappingList.add(grdt0b);


        Condition t0Ct1c = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2c = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3c = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4c = new Condition(t0, "C_PB", TransitionCondition.IsNull);
        Condition t0Ct5c = new Condition(t0, "C_TimeB", TransitionCondition.IsNull);
        Condition t0Ct6c = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7c = new Condition(t0, "H_List_B", TransitionCondition.Have_NoListTrain_History);
        Condition t0Ct8c = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B3");

        t0Ct7c.SetNextCondition(LogicConnector.AND, t0Ct8c);
        t0Ct6c.SetNextCondition(LogicConnector.AND, t0Ct7c);
        t0Ct5c.SetNextCondition(LogicConnector.AND, t0Ct6c);
        t0Ct4c.SetNextCondition(LogicConnector.AND, t0Ct5c);
        t0Ct3c.SetNextCondition(LogicConnector.AND, t0Ct4c);
        t0Ct2c.SetNextCondition(LogicConnector.AND, t0Ct3c);
        t0Ct1c.SetNextCondition(LogicConnector.AND, t0Ct2c);

        GuardMapping grdt0c = new GuardMapping();
        grdt0c.condition = t0Ct1c;
        grdt0c.Activations.add(new Activation(t0,p1,p2,p3,null,B3_Length,null,speed_on_platform, TransitionOperation.CreateTrain_Null, p4));
        t0.GuardMappingList.add(grdt0c);


        Condition t0Ct1d = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2d = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3d = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4d = new Condition(t0, "C_PB", TransitionCondition.IsNull);
        Condition t0Ct5d = new Condition(t0, "C_TimeB", TransitionCondition.IsNull);
        Condition t0Ct6d = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7d = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8d = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B1");

        t0Ct7d.SetNextCondition(LogicConnector.AND, t0Ct8d);
        t0Ct6d.SetNextCondition(LogicConnector.AND, t0Ct7d);
        t0Ct5d.SetNextCondition(LogicConnector.AND, t0Ct6d);
        t0Ct4d.SetNextCondition(LogicConnector.AND, t0Ct5d);
        t0Ct3d.SetNextCondition(LogicConnector.AND, t0Ct4d);
        t0Ct2d.SetNextCondition(LogicConnector.AND, t0Ct3d);
        t0Ct1d.SetNextCondition(LogicConnector.AND, t0Ct2d);

        GuardMapping grdt0d = new GuardMapping();
        grdt0d.condition = t0Ct1d;
        grdt0d.Activations.add(new Activation(t0,p1,p2,p3,p6,B1_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, p4));
        t0.GuardMappingList.add(grdt0d);


        Condition t0Ct1e = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2e = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3e = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4e = new Condition(t0, "C_PB", TransitionCondition.IsNull);
        Condition t0Ct5e = new Condition(t0, "C_TimeB", TransitionCondition.IsNull);
        Condition t0Ct6e = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7e = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8e = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B2");

        t0Ct7e.SetNextCondition(LogicConnector.AND, t0Ct8e);
        t0Ct6e.SetNextCondition(LogicConnector.AND, t0Ct7e);
        t0Ct5e.SetNextCondition(LogicConnector.AND, t0Ct6e);
        t0Ct4e.SetNextCondition(LogicConnector.AND, t0Ct5e);
        t0Ct3e.SetNextCondition(LogicConnector.AND, t0Ct4e);
        t0Ct2e.SetNextCondition(LogicConnector.AND, t0Ct3e);
        t0Ct1e.SetNextCondition(LogicConnector.AND, t0Ct2e);

        GuardMapping grdt0e = new GuardMapping();
        grdt0e.condition = t0Ct1e;
        grdt0e.Activations.add(new Activation(t0,p1,p2,p3,p6,B2_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, p4));
        t0.GuardMappingList.add(grdt0e);


        Condition t0Ct1f = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2f = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3f = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4f = new Condition(t0, "C_PB", TransitionCondition.IsNull);
        Condition t0Ct5f = new Condition(t0, "C_TimeB", TransitionCondition.IsNull);
        Condition t0Ct6f = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7f = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8f = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B3");

        t0Ct7f.SetNextCondition(LogicConnector.AND, t0Ct8f);
        t0Ct6f.SetNextCondition(LogicConnector.AND, t0Ct7f);
        t0Ct5f.SetNextCondition(LogicConnector.AND, t0Ct6f);
        t0Ct4f.SetNextCondition(LogicConnector.AND, t0Ct5f);
        t0Ct3f.SetNextCondition(LogicConnector.AND, t0Ct4f);
        t0Ct2f.SetNextCondition(LogicConnector.AND, t0Ct3f);
        t0Ct1f.SetNextCondition(LogicConnector.AND, t0Ct2f);

        GuardMapping grdt0f = new GuardMapping();
        grdt0f.condition = t0Ct1f;
        grdt0f.Activations.add(new Activation(t0,p1,p2,p3,p6,B3_Length,null,speed_on_platform, TransitionOperation.CreateTrain_Null, p4));
        t0.GuardMappingList.add(grdt0f);


        // there is a comming train

        Condition t0Ct1g = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2g = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3g = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4g = new Condition(t0, "C_PB", TransitionCondition.NotNull);
        Condition t0Ct5g = new Condition(t0, "C_TimeB", TransitionCondition.NotNull);
        Condition t0Ct6g = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7g = new Condition(t0, "H_List_B", TransitionCondition.Have_NoListTrain_History);
        Condition t0Ct8g = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B1");

        t0Ct7g.SetNextCondition(LogicConnector.AND, t0Ct8g);
        t0Ct6g.SetNextCondition(LogicConnector.AND, t0Ct7g);
        t0Ct5g.SetNextCondition(LogicConnector.AND, t0Ct6g);
        t0Ct4g.SetNextCondition(LogicConnector.AND, t0Ct5g);
        t0Ct3g.SetNextCondition(LogicConnector.AND, t0Ct4g);
        t0Ct2g.SetNextCondition(LogicConnector.AND, t0Ct3g);
        t0Ct1g.SetNextCondition(LogicConnector.AND, t0Ct2g);

        GuardMapping grdt0g = new GuardMapping();
        grdt0g.condition = t0Ct1g;
        grdt0g.Activations.add(new Activation(t0,p1,p2,p3,C_TimeB,C_PB,null,B1_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_NotNull, p4));
        t0.GuardMappingList.add(grdt0g);


        Condition t0Ct1h = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2h = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3h = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4h = new Condition(t0, "C_PB", TransitionCondition.NotNull);
        Condition t0Ct5h = new Condition(t0, "C_TimeB", TransitionCondition.NotNull);
        Condition t0Ct6h = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7h = new Condition(t0, "H_List_B", TransitionCondition.Have_NoListTrain_History);
        Condition t0Ct8h = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B2");

        t0Ct7h.SetNextCondition(LogicConnector.AND, t0Ct8h);
        t0Ct6h.SetNextCondition(LogicConnector.AND, t0Ct7h);
        t0Ct5h.SetNextCondition(LogicConnector.AND, t0Ct6h);
        t0Ct4h.SetNextCondition(LogicConnector.AND, t0Ct5h);
        t0Ct3h.SetNextCondition(LogicConnector.AND, t0Ct4h);
        t0Ct2h.SetNextCondition(LogicConnector.AND, t0Ct3h);
        t0Ct1h.SetNextCondition(LogicConnector.AND, t0Ct2h);


        GuardMapping grdt0h = new GuardMapping();
        grdt0h.condition = t0Ct1h;
        grdt0h.Activations.add(new Activation(t0,p1,p2,p3,C_TimeB,C_PB,null,B2_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_NotNull, p4));
        t0.GuardMappingList.add(grdt0h);


        Condition t0Ct1i = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2i = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3i = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4i = new Condition(t0, "C_PB", TransitionCondition.IsNull);
        Condition t0Ct5i = new Condition(t0, "C_TimeB", TransitionCondition.NotNull);
        Condition t0Ct6i = new Condition(t0, "D_Train_B", TransitionCondition.NotNull);
        Condition t0Ct7i = new Condition(t0, "H_List_B", TransitionCondition.Have_NoListTrain_History);
        Condition t0Ct8i = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B3");

        t0Ct7i.SetNextCondition(LogicConnector.AND, t0Ct8i);
        t0Ct6i.SetNextCondition(LogicConnector.AND, t0Ct7i);
        t0Ct5i.SetNextCondition(LogicConnector.AND, t0Ct6i);
        t0Ct4i.SetNextCondition(LogicConnector.AND, t0Ct5i);
        t0Ct3i.SetNextCondition(LogicConnector.AND, t0Ct4i);
        t0Ct2i.SetNextCondition(LogicConnector.AND, t0Ct3i);
        t0Ct1i.SetNextCondition(LogicConnector.AND, t0Ct2i);


        GuardMapping grdt0i = new GuardMapping();
        grdt0i.condition = t0Ct1i;
        grdt0i.Activations.add(new Activation(t0,p1,p2,p3,C_TimeB,C_PB,null,B3_Length,null,speed_on_platform, TransitionOperation.CreateTrain_NotNull, p4));
        t0.GuardMappingList.add(grdt0i);


        Condition t0Ct1j = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2j = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3j = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4j = new Condition(t0, "C_PB", TransitionCondition.NotNull);
        Condition t0Ct5j = new Condition(t0, "C_TimeB", TransitionCondition.NotNull);
        Condition t0Ct6j = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7j = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8j = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B1");

        t0Ct7j.SetNextCondition(LogicConnector.AND, t0Ct8j);
        t0Ct6j.SetNextCondition(LogicConnector.AND, t0Ct7j);
        t0Ct5j.SetNextCondition(LogicConnector.AND, t0Ct6j);
        t0Ct4j.SetNextCondition(LogicConnector.AND, t0Ct5j);
        t0Ct3j.SetNextCondition(LogicConnector.AND, t0Ct4j);
        t0Ct2j.SetNextCondition(LogicConnector.AND, t0Ct3j);
        t0Ct1j.SetNextCondition(LogicConnector.AND, t0Ct2j);


        GuardMapping grdt0j = new GuardMapping();
        grdt0j.condition = t0Ct1j;
        grdt0j.Activations.add(new Activation(t0,p1,p2,p3,C_TimeB,C_PB,p6,B1_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_NotNull, p4));
        t0.GuardMappingList.add(grdt0j);


        Condition t0Ct1k = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2k = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3k = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4k = new Condition(t0, "C_PB", TransitionCondition.NotNull);
        Condition t0Ct5k = new Condition(t0, "C_TimeB", TransitionCondition.NotNull);
        Condition t0Ct6k = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7k = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8k = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B2");

        t0Ct7k.SetNextCondition(LogicConnector.AND, t0Ct8k);
        t0Ct6k.SetNextCondition(LogicConnector.AND, t0Ct7k);
        t0Ct5k.SetNextCondition(LogicConnector.AND, t0Ct6k);
        t0Ct4k.SetNextCondition(LogicConnector.AND, t0Ct5k);
        t0Ct3k.SetNextCondition(LogicConnector.AND, t0Ct4k);
        t0Ct2k.SetNextCondition(LogicConnector.AND, t0Ct3k);
        t0Ct1k.SetNextCondition(LogicConnector.AND, t0Ct2k);


        GuardMapping grdt0k = new GuardMapping();
        grdt0k.condition = t0Ct1k;
        grdt0k.Activations.add(new Activation(t0,p1,p2,p3,C_TimeB,C_PB,p6,B2_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_NotNull, p4));
        t0.GuardMappingList.add(grdt0k);


        Condition t0Ct1l = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2l = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3l = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4l = new Condition(t0, "C_PB", TransitionCondition.NotNull);
        Condition t0Ct5l = new Condition(t0, "C_TimeB", TransitionCondition.NotNull);
        Condition t0Ct6l = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7l = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8l = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B3");

        t0Ct7l.SetNextCondition(LogicConnector.AND, t0Ct8l);
        t0Ct6l.SetNextCondition(LogicConnector.AND, t0Ct7l);
        t0Ct5l.SetNextCondition(LogicConnector.AND, t0Ct6l);
        t0Ct4l.SetNextCondition(LogicConnector.AND, t0Ct5l);
        t0Ct3l.SetNextCondition(LogicConnector.AND, t0Ct4l);
        t0Ct2l.SetNextCondition(LogicConnector.AND, t0Ct3l);
        t0Ct1l.SetNextCondition(LogicConnector.AND, t0Ct2l);


        GuardMapping grdt0l = new GuardMapping();
        grdt0l.condition = t0Ct1l;
        grdt0l.Activations.add(new Activation(t0,p1,p2,p3,C_TimeB,C_PB,p6,B3_Length,null,speed_on_platform, TransitionOperation.CreateTrain_NotNull, p4));
        t0.GuardMappingList.add(grdt0l);

        t0.Delay = 0;
        pn.Transitions.add(t0);

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("D_Train_B");


        Condition t1Ct1a = new Condition(t1, "D_Train_B", TransitionCondition.NotNull);
        Condition t1Ct2a = new Condition(t1, "List_B", TransitionCondition.CanAddTrains_List);

        t1Ct1a.SetNextCondition(LogicConnector.AND, t1Ct2a);

        GuardMapping grdt1a = new GuardMapping();
        grdt1a.condition = t1Ct1a;
        grdt1a.Activations.add(new Activation(t1, "D_Train_B", TransitionOperation.AddElement, "List_B"));
        grdt1a.Activations.add(new Activation(t1, "D_Train_B", TransitionOperation.Move, "D_Train_B"));
        t1.GuardMappingList.add(grdt1a);


        Condition t1Ct1b = new Condition(t1, "D_Train_B", TransitionCondition.NotNull);
        Condition t1Ct2b = new Condition(t1, "List_B", TransitionCondition.CanNotAddTrains_List);

        t1Ct1b.SetNextCondition(LogicConnector.AND, t1Ct2b);

        GuardMapping grdt1b = new GuardMapping();
        grdt1b.condition = t1Ct1b;
        grdt1b.Activations.add(new Activation(t1, p5, TransitionOperation.RemoveFirst, p5));
        grdt1b.Activations.add(new Activation(t1, "D_Train_B", TransitionOperation.AddElement, "List_B"));
        grdt1b.Activations.add(new Activation(t1, "D_Train_B", TransitionOperation.Move, "D_Train_B"));
        t1.GuardMappingList.add(grdt1b);


        t1.Delay = 0;
        pn.Transitions.add(t1);

        // T2 ------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("D_Train_B");


        Condition t2Ct1 = new Condition(t2, "D_Train_B", TransitionCondition.NotNull);


        GuardMapping grdt2 = new GuardMapping();
        grdt2.condition = t2Ct1;
        grdt2.Activations.add(new Activation(t2, "D_Train_B", TransitionOperation.AddElement, "H_List_B"));
        t2.GuardMappingList.add(grdt2);

        t2.Delay = 0;
        pn.Transitions.add(t2);


        // T3 ------------------------------------------------


        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "t3";
        t3.InputPlaceName.add("H_List_B");


        Condition t3Ct1a = new Condition(t3, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t3Ct2a = new Condition(t3, "H_List_B", TransitionCondition.CheckTime_Before);

        t3Ct1a.SetNextCondition(LogicConnector.AND, t3Ct2a);

        GuardMapping grdt3a = new GuardMapping();
        grdt3a.condition = t3Ct2a;
        grdt3a.Activations.add(new Activation(t3, "H_List_B", TransitionOperation.Move, "H_List_B"));
        t3.GuardMappingList.add(grdt3a);



        Condition t3Ct1b = new Condition(t3, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t3Ct2b= new Condition(t3, "H_List_B", TransitionCondition.CheckTime_After);

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
        t4.InputPlaceName.add("List_B");


        Condition t4Ct1a = new Condition(t4, "List_B", TransitionCondition.HaveListTrain);
        Condition t4Ct1b = new Condition(t4, "List_B", TransitionCondition.Platform);//////no

        t4Ct1a.SetNextCondition(LogicConnector.AND, t4Ct1b);

        GuardMapping grdt4a = new GuardMapping();
        grdt4a.condition = t4Ct1a;
        grdt4a.Activations.add(new Activation(t4, "current_time", TransitionOperation.SendOverNetwork, "Time1_B"));
        grdt4a.Activations.add(new Activation(t4, "Train_B", TransitionOperation.SendOverNetwork, "T1_B"));
        t4.GuardMappingList.add(grdt4a);


        t4.Delay = 0;
        pn.Transitions.add(t4);

        // T5 ------------------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "t5";
        t5.InputPlaceName.add("C_TimeB1");
        t5.InputPlaceName.add("C_TimeB2");
        t5.InputPlaceName.add("C_TimeB3");
        t5.InputPlaceName.add("C_TimeB4");


        Condition t5Ct1a = new Condition(t1, "C_TimeB1", TransitionCondition.NotNull);

        GuardMapping grdt5a = new GuardMapping();
        grdt5a.condition = t5Ct1a;
        grdt5a.Activations.add(new Activation(t5, "C_TimeB1", TransitionOperation.Move, "C_TimeB"));
        t5.GuardMappingList.add(grdt5a);


        Condition t5Ct1b = new Condition(t1, "C_TimeB2", TransitionCondition.NotNull);

        GuardMapping grdt5b = new GuardMapping();
        grdt5b.condition = t5Ct1b;
        grdt5b.Activations.add(new Activation(t5, "C_TimeB2", TransitionOperation.Move, "C_TimeB"));
        t5.GuardMappingList.add(grdt5b);


        Condition t5Ct1c = new Condition(t1, "C_TimeB3", TransitionCondition.NotNull);

        GuardMapping grdt5c = new GuardMapping();
        grdt5c.condition = t5Ct1c;
        grdt5c.Activations.add(new Activation(t5, "C_TimeB3", TransitionOperation.Move, "C_TimeB"));
        t5.GuardMappingList.add(grdt5c);


        Condition t5Ct1d = new Condition(t1, "C_TimeB4", TransitionCondition.NotNull);

        GuardMapping grdt5d = new GuardMapping();
        grdt5d.condition = t5Ct1d;
        grdt5d.Activations.add(new Activation(t5, "C_TimeB4", TransitionOperation.Move, "C_TimeB"));
        t5.GuardMappingList.add(grdt5d);


        t5.Delay = 0;
        pn.Transitions.add(t5);


        // T6 ------------------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "t6";
        t6.InputPlaceName.add("C_PB1");
        t6.InputPlaceName.add("C_PB2");
        t6.InputPlaceName.add("C_PB3");
        t6.InputPlaceName.add("C_PB4");


        Condition t6Ct1a = new Condition(t1, "C_PB1", TransitionCondition.NotNull);

        GuardMapping grdt6a = new GuardMapping();
        grdt6a.condition = t6Ct1a;
        grdt6a.Activations.add(new Activation(t6, "C_PB1", TransitionOperation.Move, "C_PB"));
        t6.GuardMappingList.add(grdt6a);


        Condition t6Ct1b = new Condition(t1, "C_PB2", TransitionCondition.NotNull);

        GuardMapping grdt6b = new GuardMapping();
        grdt6b.condition = t6Ct1b;
        grdt6b.Activations.add(new Activation(t6, "C_PB2", TransitionOperation.Move, "C_PB"));
        t6.GuardMappingList.add(grdt6b);


        Condition t6Ct1c = new Condition(t1, "C_PB3", TransitionCondition.NotNull);

        GuardMapping grdt6c = new GuardMapping();
        grdt6c.condition = t6Ct1c;
        grdt6c.Activations.add(new Activation(t6, "C_PB3", TransitionOperation.Move, "C_PB"));
        t6.GuardMappingList.add(grdt6c);


        Condition t6Ct1d = new Condition(t1, "C_PB4", TransitionCondition.NotNull);

        GuardMapping grdt6d = new GuardMapping();
        grdt6d.condition = t6Ct1d;
        grdt6d.Activations.add(new Activation(t6, "C_PB4", TransitionOperation.Move, "C_PB"));
        t6.GuardMappingList.add(grdt6d);


        t6.Delay = 0;
        pn.Transitions.add(t6);
    }
}
