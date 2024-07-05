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

        Condition t0Ct1a = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2a = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3a = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4a = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5a = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6a = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7a = new Condition(t0, "List_A", TransitionCondition.IsNull);
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
        grdt0a.Activations.add(new Activation(t0,p1,p2,p3,null,A1_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, "D_Train_A"));
        t0.GuardMappingList.add(grdt0a);

        Condition t0Ct1b = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2b = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3b = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4b = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5b = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6b = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7b = new Condition(t0, "List_A", TransitionCondition.IsNull);
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
        grdt0b.Activations.add(new Activation(t0,p1,p2,p3,null,A2_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, "D_Train_A"));
        t0.GuardMappingList.add(grdt0b);


        Condition t0Ct1c = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2c = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3c = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4c = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5c = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6c = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7c = new Condition(t0, "List_A", TransitionCondition.IsNull);
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
        grdt0c.Activations.add(new Activation(t0,p1,p2,p3,null,A3_Length,null,speed_on_platform, TransitionOperation.CreateTrain_Null, "D_Train_A"));
        t0.GuardMappingList.add(grdt0c);


        Condition t0Ct1d = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2d = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3d = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4d = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5d = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6d = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7d = new Condition(t0, "List_A", TransitionCondition.NotNull);
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
        grdt0d.Activations.add(new Activation(t0,p1,p2,p3,p5,A1_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, "D_Train_A"));
        t0.GuardMappingList.add(grdt0d);


        Condition t0Ct1c = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2c = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3c = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4c = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5c = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6c = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7c = new Condition(t0, "List_A", TransitionCondition.NotNull);
        Condition t0Ct8c = new Condition(t0, "Platform_A", TransitionCondition.Contains,"A2");

        t0Ct7c.SetNextCondition(LogicConnector.AND, t0Ct8c);
        t0Ct6c.SetNextCondition(LogicConnector.AND, t0Ct7c);
        t0Ct5c.SetNextCondition(LogicConnector.AND, t0Ct6c);
        t0Ct4c.SetNextCondition(LogicConnector.AND, t0Ct5c);
        t0Ct3c.SetNextCondition(LogicConnector.AND, t0Ct4c);
        t0Ct2c.SetNextCondition(LogicConnector.AND, t0Ct3c);
        t0Ct1c.SetNextCondition(LogicConnector.AND, t0Ct2c);


        GuardMapping grdt0c = new GuardMapping();
        grdt0c.condition = t0Ct1c;
        grdt0c.Activations.add(new Activation(t0,p1,p2,p3,p5,A2_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, "D_Train_A"));
        t0.GuardMappingList.add(grdt0c);


        Condition t0Ct1c = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2c = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3c = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4c = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5c = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6c = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7c = new Condition(t0, "List_A", TransitionCondition.NotNull);
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
        grdt0c.Activations.add(new Activation(t0,p1,p2,p3,p5,A3_Length,null,speed_on_platform, TransitionOperation.CreateTrain_Null, "D_Train_A"));
        t0.GuardMappingList.add(grdt0c);


//////////////////////////////////// coming train
        Condition t0Ct1a = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2a = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3a = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4a = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5a = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6a = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7a = new Condition(t0, "List_A", TransitionCondition.IsNull);
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
        grdt0a.Activations.add(new Activation(t0,p1,p2,p3,null,A1_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, "D_Train_A"));
        t0.GuardMappingList.add(grdt0a);

        Condition t0Ct1b = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2b = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3b = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4b = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5b = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6b = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7b = new Condition(t0, "List_A", TransitionCondition.IsNull);
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
        grdt0b.Activations.add(new Activation(t0,p1,p2,p3,null,A2_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, "D_Train_A"));
        t0.GuardMappingList.add(grdt0b);


        Condition t0Ct1c = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2c = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3c = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4c = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5c = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6c = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7c = new Condition(t0, "List_A", TransitionCondition.IsNull);
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
        grdt0c.Activations.add(new Activation(t0,p1,p2,p3,null,A3_Length,null,speed_on_platform, TransitionOperation.CreateTrain_Null, "D_Train_A"));
        t0.GuardMappingList.add(grdt0c);


        Condition t0Ct1d = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2d = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3d = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4d = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5d = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6d = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7d = new Condition(t0, "List_A", TransitionCondition.NotNull);
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
        grdt0d.Activations.add(new Activation(t0,p1,p2,p3,p5,A1_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, "D_Train_A"));
        t0.GuardMappingList.add(grdt0d);


        Condition t0Ct1c = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2c = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3c = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4c = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5c = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6c = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7c = new Condition(t0, "List_A", TransitionCondition.NotNull);
        Condition t0Ct8c = new Condition(t0, "Platform_A", TransitionCondition.Contains,"A2");

        t0Ct7c.SetNextCondition(LogicConnector.AND, t0Ct8c);
        t0Ct6c.SetNextCondition(LogicConnector.AND, t0Ct7c);
        t0Ct5c.SetNextCondition(LogicConnector.AND, t0Ct6c);
        t0Ct4c.SetNextCondition(LogicConnector.AND, t0Ct5c);
        t0Ct3c.SetNextCondition(LogicConnector.AND, t0Ct4c);
        t0Ct2c.SetNextCondition(LogicConnector.AND, t0Ct3c);
        t0Ct1c.SetNextCondition(LogicConnector.AND, t0Ct2c);


        GuardMapping grdt0c = new GuardMapping();
        grdt0c.condition = t0Ct1c;
        grdt0c.Activations.add(new Activation(t0,p1,p2,p3,p5,A2_Length,A4_Length,speed_on_platform, TransitionOperation.CreateTrain_Null, "D_Train_A"));
        t0.GuardMappingList.add(grdt0c);


        Condition t0Ct1c = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2c = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3c = new Condition(t0, "Platform_A", TransitionCondition.NotNull);
        Condition t0Ct4c = new Condition(t0, "C_PA", TransitionCondition.IsNull);
        Condition t0Ct5c = new Condition(t0, "C_TimeA", TransitionCondition.IsNull);
        Condition t0Ct6c = new Condition(t0, "D_Train_A", TransitionCondition.IsNull);
        Condition t0Ct7c = new Condition(t0, "List_A", TransitionCondition.NotNull);
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
        grdt0c.Activations.add(new Activation(t0,p1,p2,p3,p5,A3_Length,null,speed_on_platform, TransitionOperation.CreateTrain_Null, "D_Train_A"));
        t0.GuardMappingList.add(grdt0c);

        t0.Delay = 0;
        pn.Transitions.add(t0);

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("D_Train_A");

        //// SHOULD I PUT THIS UP? I use it again for t4
        int list_size = p5.GetSize();
        DataInteger list_size_place = new DataInteger();
        list_size_place.SetName("List_Size");
        list_size_place.SetValue(list_size);
        pn.ConstantPlaceList.add(list_size_place);
        ////

        /// first train on platform
        Condition t1Ct1 = new Condition(t1, "D_Train_A", TransitionCondition.NotNull);
        Condition t1Ct2 = new Condition(t1, "List_A", TransitionCondition.CanAddTrains_List);
        Condition t1Ct3 = new Condition(t1, "List_Size", TransitionCondition.Equal, "zero");
        Condition t1Ct4 = new Condition(t1, "Platform_A", TransitionCondition.Equal, "A1");
        t1Ct1.SetNextCondition(LogicConnector.AND, t1Ct2);
        t1Ct1.SetNextCondition(LogicConnector.AND, t1Ct3);
        t1Ct1.SetNextCondition(LogicConnector.AND, t1Ct4);

        /// ???? CALCULATE TIME and add it to place DataLocalTime time which will be send over network
        GuardMapping grdt1a = new GuardMapping();
        grdt1a.condition = t1Ct1;
        grdt1a.Activations.add(new Activation(t1, "", TransitionOperation.CalculateTime, "time"));
        grdt1a.Activations.add(new Activation(t1, "D_Train_A", TransitionOperation.AddElement, "List_A"));
        t1.GuardMappingList.add(grdt1a);

        /// HOW IT IS ADD IN THE LIST_A?? AT THE END??

        /// 2 more for A2 AND A3


        /// 2nd train on platform
        // how can i delete the 1st train on platform afterwards
        // and keep the 2nd one?

        String prev_platform = p5.GetPlatform(0);
        DataString prev_platform_place = new DataString();
        prev_platform_place.SetName("Prev_Platform");
        prev_platform_place.Value = prev_platform;

        LocalTime prev_dep_time = p5.GetDepTime(0);
        DataLocalTime prev_time_place = new DataLocalTime();
        prev_time_place.SetName("Prev_Dep_Time");
        prev_time_place.Value = prev_dep_time;

        int prev_train_length = p5.GetLength(0);
        DataInteger prev_train_length_place = new DataInteger();
        prev_train_length_place.SetName("Prev_Train_Length");
        prev_train_length_place.Value = prev_train_length;


        Condition t1Ct1b = new Condition(t1, "D_Train_A", TransitionCondition.NotNull);
        Condition t1Ct2b = new Condition(t1, "List_A", TransitionCondition.CanAddTrains_List);
        Condition t1Ct3b = new Condition(t1, "List_Size", TransitionCondition.Equal, "one");
        Condition t1Ct4b = new Condition(t1, "Platform_A", TransitionCondition.Equal, "A1");
        t1Ct1b.SetNextCondition(LogicConnector.AND, t1Ct2b);
        t1Ct2b.SetNextCondition(LogicConnector.AND, t1Ct3b);
        t1Ct3b.SetNextCondition(LogicConnector.AND, t1Ct4b);

        t1.Delay = 0;
        pn.Transitions.add(t1);

        // T2 ------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("D_Train_A");

        /// CHECK THE FOLLOWING COMMENTS!

        Condition t2Ct1 = new Condition(t2, "D_Train_A", TransitionCondition.NotNull);
        Condition t2Ct2 = new Condition(t2, "H_List_A", TransitionCondition.CanAddTrains_HList);
        t2Ct1.SetNextCondition(LogicConnector.AND, t2Ct2);

        GuardMapping grdt2 = new GuardMapping();
        grdt2.condition = t2Ct1;
        grdt2.Activations.add(new Activation(t2, "D_Train_A", TransitionOperation.AddElement, "H_List_A"));
        t2.GuardMappingList.add(grdt2);

        t2.Delay = 0;
        pn.Transitions.add(t2);


        // T3 ------------------------------------------------
        // 12.	T3 what should it do? Conditions guard and maps??
        // Should check if time is pass 23:59:59 and if
        // so it will add at the back of the .txt the whole list
        // and then it will delete it? How should conditions
        // guards and maps should look then?

        // or should i check this in t2 because if it is past 23:59:59
        // then it should be added in the H_list. everything said before
        // should be done in t2

        // then what is with t3?

        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "t3";
        t3.InputPlaceName.add("H_List_A");

        // i have present_time as a place with current time

        t3.Delay = 0;
        pn.Transitions.add(t3);


        // T4 ------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "t4";
        t4.InputPlaceName.add("List_A");

        // i have present_time as a place with current time

        Condition t4Ct1 = new Condition(t1, "List_Size", TransitionCondition.Equal, "one");
        Condition t4Ct2 = new Condition(t1, "List_Size", TransitionCondition.Equal, "two");
        Condition t4Ct3 = new Condition(t1, "Platform_A", TransitionCondition.Contains, "A1"); //????

        /// how can be (t4Ct1 OR t4Ct2) AND t4Ct3 -> 2 separate subguards
        t4Ct1.SetNextCondition(LogicConnector.OR, t4Ct2);
        t4Ct1.SetNextCondition(LogicConnector.AND, t4Ct3); /// ????

        GuardMapping grdt4 = new GuardMapping();
        grdt4.condition = t4Ct1;
        grdt4.Activations.add(new Activation(t1, "current_time", TransitionOperation.SendOverNetwork, "Time1_A"));
        grdt4.Activations.add(new Activation(t1, "Train_A", TransitionOperation.SendOverNetwork, "T1_A")); /// can i do this??
        t4.GuardMappingList.add(grdt4);


        /// same for A2 and A3
        t4.Delay = 0;
        pn.Transitions.add(t4);
    }
}
