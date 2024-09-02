package THESIS.Supervisors;

import Components.*;
import DataObjects.*;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Supervisor_B {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Supervisor B";
        pn.SetName("Supervisor B");

        pn.NetworkPort = 1091;


        DataLocalTime C_TimeB = new DataLocalTime();
        C_TimeB.SetName("C_TimeB");
        pn.PlaceList.add(C_TimeB);

        DataLocalTime C_TimeB1 = new DataLocalTime();
        C_TimeB1.SetName("C_TimeB1");
        pn.PlaceList.add(C_TimeB1);

        DataLocalTime C_TimeB2 = new DataLocalTime();
        C_TimeB2.SetName("C_TimeB2");
        pn.PlaceList.add(C_TimeB2);

        DataLocalTime C_TimeB3 = new DataLocalTime();
        C_TimeB3.SetName("C_TimeB");
        pn.PlaceList.add(C_TimeB3);

        DataString C_PB = new DataString();
        C_PB.SetName("C_PB");
        pn.ConstantPlaceList.add(C_PB);

        DataString C_PB1 = new DataString();
        C_PB1.SetName("C_PB1");
        pn.ConstantPlaceList.add(C_PB1);

        DataString C_PB2 = new DataString();
        C_PB2.SetName("C_PB2");
        pn.ConstantPlaceList.add(C_PB2);

        DataString C_PB3= new DataString();
        C_PB3.SetName("C_PB3");
        pn.ConstantPlaceList.add(C_PB3);

        DataString C_PB4 = new DataString();
        C_PB4.SetName("C_PB4");
        pn.ConstantPlaceList.add(C_PB4);

        DataString filePath = new DataString();
        filePath.SetName("filePath");
        filePath.SetValue("Trains_Station_B.txt");
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

        DataTrain temp = new DataTrain();
        temp.SetName("Temp");
        pn.ConstantPlaceList.add(temp);

        DataInteger Zero = new DataInteger();
        Zero.SetName("Zero");
        Zero.SetValue(0);
        pn.ConstantPlaceList.add(Zero);

        DataInteger B1_Length = new DataInteger();
        B1_Length.SetName("B1_Length");
        B1_Length.SetValue(140);
        pn.ConstantPlaceList.add(B1_Length);

        DataInteger B2_Length = new DataInteger();
        B2_Length.SetName("B2_Length");
        B2_Length.SetValue(100);
        pn.ConstantPlaceList.add(B2_Length);

        DataInteger B3_Length = new DataInteger();
        B3_Length.SetName("B3_Length");
        B3_Length.SetValue(130);
        pn.ConstantPlaceList.add(B3_Length);

        DataInteger B4_Length = new DataInteger();
        B4_Length.SetName("B4_Length");
        B4_Length.SetValue(70);
        pn.ConstantPlaceList.add(B4_Length);

        DataInteger speed_on_platform = new DataInteger();
        speed_on_platform.SetName("Speed_On_Platform");
        speed_on_platform.SetValue(5);
        pn.ConstantPlaceList.add(speed_on_platform);


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

        DataListTrains p5 = new DataListTrains();
        p5.SetName("List_B");
        pn.PlaceList.add(p5);

        DataListTrainsHistory p6 = new DataListTrainsHistory();
        p6.SetName("H_List_B");
        pn.PlaceList.add(p6);

        DataTransfer T1_B = new DataTransfer();
        T1_B.SetName("T1_B");
        T1_B.Value = new TransferOperation("localhost", "1089", "Train_B1");
        pn.PlaceList.add(T1_B);

        DataTransfer T2_B = new DataTransfer();
        T2_B.SetName("T2_B");
        T2_B.Value = new TransferOperation("localhost", "1089", "Train_B2");
        pn.PlaceList.add(T2_B);

        DataTransfer T3_B = new DataTransfer();
        T3_B.SetName("T3_B");
        T3_B.Value = new TransferOperation("localhost", "1089", "Train_B3");
        pn.PlaceList.add(T3_B);

        DataTransfer Time1_B = new DataTransfer();
        Time1_B.SetName("Time1_B");
        Time1_B.Value = new TransferOperation("localhost", "1089", "Time_B1");
        pn.PlaceList.add(Time1_B);

        DataTransfer Time2_B = new DataTransfer();
        Time2_B.SetName("Time2_B");
        Time2_B.Value = new TransferOperation("localhost", "1089", "Time_B2");
        pn.PlaceList.add(Time2_B);

        DataTransfer Time3_B = new DataTransfer();
        Time3_B.SetName("Time3_B");
        Time3_B.Value = new TransferOperation("localhost", "1089", "Time_B3");
        pn.PlaceList.add(Time3_B);




// t4 ------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "t4";
        t4.InputPlaceName.add("C_TimeB1");
        t4.InputPlaceName.add("C_TimeB2");
        t4.InputPlaceName.add("C_TimeB3");
        t4.InputPlaceName.add("C_TimeB4");

  /*      // Handle case when all inputs are null
        Condition t4CtAllNull = new Condition(t4, "C_TimeB1", TransitionCondition.IsNull);
        t4CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t4, "C_TimeB2", TransitionCondition.IsNull));
        t4CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t4, "C_TimeB3", TransitionCondition.IsNull));
        t4CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t4, "C_TimeB4", TransitionCondition.IsNull));

        GuardMapping grdt4AllNull = new GuardMapping();
        grdt4AllNull.condition = t4CtAllNull;
        grdt4AllNull.Activations.add(new Activation(t4, "", TransitionOperation.DoNothing, ""));
        t4.GuardMappingList.add(grdt4AllNull);

*/
        Condition t4Ct1a = new Condition(t4, "C_TimeB1", TransitionCondition.NotNull);

        GuardMapping grdt4a = new GuardMapping();
        grdt4a.condition = t4Ct1a;
        grdt4a.Activations.add(new Activation(t4, "C_TimeB1", TransitionOperation.Move, "C_TimeB"));
        t4.GuardMappingList.add(grdt4a);


        Condition t4Ct1b = new Condition(t4, "C_TimeB2", TransitionCondition.NotNull);

        GuardMapping grdt4b = new GuardMapping();
        grdt4b.condition = t4Ct1b;
        grdt4b.Activations.add(new Activation(t4, "C_TimeB2", TransitionOperation.Move, "C_TimeB"));
        t4.GuardMappingList.add(grdt4b);


        Condition t4Ct1c = new Condition(t4, "C_TimeB3", TransitionCondition.NotNull);

        GuardMapping grdt4c = new GuardMapping();
        grdt4c.condition = t4Ct1c;
        grdt4c.Activations.add(new Activation(t4, "C_TimeB3", TransitionOperation.Move, "C_TimeB"));
        t4.GuardMappingList.add(grdt4c);


        Condition t4Ct1d = new Condition(t4, "C_TimeB4", TransitionCondition.NotNull);

        GuardMapping grdt4d = new GuardMapping();
        grdt4d.condition = t4Ct1d;
        grdt4d.Activations.add(new Activation(t4, "C_TimeB4", TransitionOperation.Move, "C_TimeB"));
        t4.GuardMappingList.add(grdt4d);


        t4.Delay = 0;
        pn.Transitions.add(t4);


        // t5 ------------------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "t5";
        t5.InputPlaceName.add("C_PB1");
        t5.InputPlaceName.add("C_PB2");
        t5.InputPlaceName.add("C_PB3");
        t5.InputPlaceName.add("C_PB4");

/*
//        // Handle case when all inputs are null
        Condition t5CtAllNull = new Condition(t5, "C_PB1", TransitionCondition.IsNull);
        t5CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t5, "C_PB2", TransitionCondition.IsNull));
        t5CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t5, "C_PB3", TransitionCondition.IsNull));
        t5CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t5, "C_PB4", TransitionCondition.IsNull));

        GuardMapping grdt5AllNull = new GuardMapping();
        grdt5AllNull.condition = t5CtAllNull;
        grdt5AllNull.Activations.add(new Activation(t5, "", TransitionOperation.DoNothing, ""));
        t5.GuardMappingList.add(grdt5AllNull);
*/

        Condition t5Ct1a = new Condition(t5, "C_PB1", TransitionCondition.NotNull);

        GuardMapping grdt5a = new GuardMapping();
        grdt5a.condition = t5Ct1a;
        grdt5a.Activations.add(new Activation(t5, "C_PB1", TransitionOperation.Move, "C_PB"));
        t5.GuardMappingList.add(grdt5a);


        Condition t5Ct1b = new Condition(t5, "C_PB2", TransitionCondition.NotNull);

        GuardMapping grdt5b = new GuardMapping();
        grdt5b.condition = t5Ct1b;
        grdt5b.Activations.add(new Activation(t5, "C_PB2", TransitionOperation.Move, "C_PB"));
        t5.GuardMappingList.add(grdt5b);


        Condition t5Ct1c = new Condition(t5, "C_PB3", TransitionCondition.NotNull);

        GuardMapping grdt5c = new GuardMapping();
        grdt5c.condition = t5Ct1c;
        grdt5c.Activations.add(new Activation(t5, "C_PB3", TransitionOperation.Move, "C_PB"));
        t5.GuardMappingList.add(grdt5c);


        Condition t5Ct1d = new Condition(t5, "C_PB4", TransitionCondition.NotNull);

        GuardMapping grdt5d = new GuardMapping();
        grdt5d.condition = t5Ct1d;
        grdt5d.Activations.add(new Activation(t5, "C_PB4", TransitionOperation.Move, "C_PB"));
        t5.GuardMappingList.add(grdt5d);


        t5.Delay = 0;
        pn.Transitions.add(t5);




        // T0 ------------------------------------------------
        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "t0";
        t0.InputPlaceName.add("Train_B");
        t0.InputPlaceName.add("Dep_Time_B");
        t0.InputPlaceName.add("Platform_B");
        t0.InputPlaceName.add("C_PB");
        t0.InputPlaceName.add("C_TimeB");
        t0.InputPlaceName.add("H_List_B");


       /* // Handle case when all inputs are null
        Condition t0CtAllNull = new Condition(t0, "Train_B", TransitionCondition.IsNull);
        t0CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t0, "Dep_Time_B", TransitionCondition.IsNull));
        t0CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t0, "Platform_B", TransitionCondition.IsNull));
        t0CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t0, "C_PB", TransitionCondition.IsNull));
        t0CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t0, "C_TimeB", TransitionCondition.IsNull));
        t0CtAllNull.SetNextCondition(LogicConnector.AND, new Condition(t0, "H_List_B", TransitionCondition.IsNull));

        GuardMapping grdT0AllNull = new GuardMapping();
        grdT0AllNull.condition = t0CtAllNull;
        grdT0AllNull.Activations.add(new Activation(t0, "", TransitionOperation.DoNothing, ""));
        t0.GuardMappingList.add(grdT0AllNull);
*/
        // no comming train
        // first train created on platform B1
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
        grdt0a.Activations.add(new Activation(
                t0,
                p1.GetName(),
                p2.GetName(),
                p3.GetName(),
                null,
                B1_Length.GetName(),
                B4_Length.GetName(),
                "Zero",
                "Zero",
                speed_on_platform.GetName(),
                TransitionOperation.CreateTrain_Null,
                p4.GetName()));
        grdt0a.Activations.add(new Activation(t0,p4.GetName(), TransitionOperation.MessageBox_SupervisorA));
        t0.GuardMappingList.add(grdt0a);

        // first train created on platform B2
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
        grdt0b.Activations.add(new Activation(t0,
                "Train_B",
                "Dep_Time_B",
                "Platform_B",
                null,
                "B2_Length",
                "B4_Length",
                "Zero",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_B"));
        grdt0b.Activations.add(new Activation(t0, "D_Train_B", TransitionOperation.MessageBox_SupervisorA));
        t0.GuardMappingList.add(grdt0b);

        // first train created on platform B3
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
        grdt0c.Activations.add(new Activation(t0,"Train_B",
                "Dep_Time_B",
                "Platform_B",
                null,
                "B3_Length",
                "Zero",
                "Zero",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_B"));
        grdt0c.Activations.add(new Activation(t0, "D_Train_B", TransitionOperation.MessageBox_SupervisorA));
        t0.GuardMappingList.add(grdt0c);


        //Not the first train created in the day
        // Platform of the new : B1
        // Platform of the last : B1
        Condition t0Ct1d = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2d = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3d = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4d = new Condition(t0, "C_PB", TransitionCondition.IsNull);
        Condition t0Ct5d = new Condition(t0, "C_TimeB", TransitionCondition.IsNull);
        Condition t0Ct6d = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7d = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8d = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B1");
        Condition t0Ct9d = new Condition(t0, "H_List_B", TransitionCondition.Check_Platform_History,"B1");

        t0Ct8d.SetNextCondition(LogicConnector.AND, t0Ct9d);
        t0Ct7d.SetNextCondition(LogicConnector.AND, t0Ct8d);
        t0Ct6d.SetNextCondition(LogicConnector.AND, t0Ct7d);
        t0Ct5d.SetNextCondition(LogicConnector.AND, t0Ct6d);
        t0Ct4d.SetNextCondition(LogicConnector.AND, t0Ct5d);
        t0Ct3d.SetNextCondition(LogicConnector.AND, t0Ct4d);
        t0Ct2d.SetNextCondition(LogicConnector.AND, t0Ct3d);
        t0Ct1d.SetNextCondition(LogicConnector.AND, t0Ct2d);

        GuardMapping grdt0d = new GuardMapping();
        grdt0d.condition = t0Ct1d;
        grdt0d.Activations.add(new Activation(t0,"Train_B",
                "Dep_Time_B",
                "Platform_B",
                "H_List_B",
                "B1_Length",
                "B4_Length",
                "B1_Length",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_B"));
        grdt0d.Activations.add(new Activation(t0, "D_Train_B", TransitionOperation.MessageBox_SupervisorA));
        t0.GuardMappingList.add(grdt0d);

        // Platform of the new : B1
        // Platform of the last : B2
        Condition t0Ct1d1 = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2d1 = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3d1 = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4d1 = new Condition(t0, "C_PB", TransitionCondition.IsNull);
        Condition t0Ct5d1 = new Condition(t0, "C_TimeB", TransitionCondition.IsNull);
        Condition t0Ct6d1 = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7d1 = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8d1 = new Condition(t0, "Platform_B", TransitionCondition.Contains, "B1");
        Condition t0Ct9d1 = new Condition(t0, "H_List_B", TransitionCondition.Check_Platform_History, "B2");

        t0Ct8d1.SetNextCondition(LogicConnector.AND, t0Ct9d1);
        t0Ct7d1.SetNextCondition(LogicConnector.AND, t0Ct8d1);
        t0Ct6d1.SetNextCondition(LogicConnector.AND, t0Ct7d1);
        t0Ct5d1.SetNextCondition(LogicConnector.AND, t0Ct6d1);
        t0Ct4d1.SetNextCondition(LogicConnector.AND, t0Ct5d1);
        t0Ct3d1.SetNextCondition(LogicConnector.AND, t0Ct4d1);
        t0Ct2d1.SetNextCondition(LogicConnector.AND, t0Ct3d1);
        t0Ct1d1.SetNextCondition(LogicConnector.AND, t0Ct2d1);

        GuardMapping grdt0d1 = new GuardMapping();
        grdt0d1.condition = t0Ct1d1;
        grdt0d1.Activations.add(new Activation(t0, "Train_B",
                "Dep_Time_B",
                "Platform_B",
                "H_List_B",
                "B1_Length",
                "B4_Length",
                "B2_Length",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_B"));
        grdt0d1.Activations.add(new Activation(t0, "D_Train_B", TransitionOperation.MessageBox_SupervisorA));
        t0.GuardMappingList.add(grdt0d1);

        // Platform of the new : B1
        // Platform of the last : B3
        Condition t0Ct1d2 = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2d2 = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3d2 = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4d2 = new Condition(t0, "C_PB", TransitionCondition.IsNull);
        Condition t0Ct5d2 = new Condition(t0, "C_TimeB", TransitionCondition.IsNull);
        Condition t0Ct6d2 = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7d2 = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8d2 = new Condition(t0, "Platform_B", TransitionCondition.Contains, "B1");
        Condition t0Ct9d2 = new Condition(t0, "H_List_B", TransitionCondition.Check_Platform_History, "B3");

        t0Ct8d2.SetNextCondition(LogicConnector.AND, t0Ct9d2);
        t0Ct7d2.SetNextCondition(LogicConnector.AND, t0Ct8d2);
        t0Ct6d2.SetNextCondition(LogicConnector.AND, t0Ct7d2);
        t0Ct5d2.SetNextCondition(LogicConnector.AND, t0Ct6d2);
        t0Ct4d2.SetNextCondition(LogicConnector.AND, t0Ct5d2);
        t0Ct3d2.SetNextCondition(LogicConnector.AND, t0Ct4d2);
        t0Ct2d2.SetNextCondition(LogicConnector.AND, t0Ct3d2);
        t0Ct1d2.SetNextCondition(LogicConnector.AND, t0Ct2d2);

        GuardMapping grdt0d2 = new GuardMapping();
        grdt0d2.condition = t0Ct1d2;
        grdt0d2.Activations.add(new Activation(t0, "Train_B",
                "Dep_Time_B",
                "Platform_B",
                "H_List_B",
                "B1_Length",
                "B4_Length",
                "Zero",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_B"));
        grdt0d2.Activations.add(new Activation(t0, "D_Train_B", TransitionOperation.MessageBox_SupervisorA));
        t0.GuardMappingList.add(grdt0d2);


        // Platform of the new : B2
        // Platform of the last : B1
        Condition t0Ct1e1 = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2e1 = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3e1 = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4e1 = new Condition(t0, "C_PB", TransitionCondition.IsNull);
        Condition t0Ct5e1 = new Condition(t0, "C_TimeB", TransitionCondition.IsNull);
        Condition t0Ct6e1 = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7e1 = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8e1 = new Condition(t0, "Platform_B", TransitionCondition.Contains, "B2");
        Condition t0Ct9e1 = new Condition(t0, "H_List_B", TransitionCondition.Check_Platform_History, "B1");

        t0Ct8e1.SetNextCondition(LogicConnector.AND, t0Ct9e1);
        t0Ct7e1.SetNextCondition(LogicConnector.AND, t0Ct8e1);
        t0Ct6e1.SetNextCondition(LogicConnector.AND, t0Ct7e1);
        t0Ct5e1.SetNextCondition(LogicConnector.AND, t0Ct6e1);
        t0Ct4e1.SetNextCondition(LogicConnector.AND, t0Ct5e1);
        t0Ct3e1.SetNextCondition(LogicConnector.AND, t0Ct4e1);
        t0Ct2e1.SetNextCondition(LogicConnector.AND, t0Ct3e1);
        t0Ct1e1.SetNextCondition(LogicConnector.AND, t0Ct2e1);

        GuardMapping grdt0e1 = new GuardMapping();
        grdt0e1.condition = t0Ct1e1;
        grdt0e1.Activations.add(new Activation(t0,"Train_B",
                "Dep_Time_B",
                "Platform_B",
                "H_List_B",
                "B2_Length",
                "B4_Length",
                "B1_Length",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_B"));
        grdt0e1.Activations.add(new Activation(t0, "D_Train_B", TransitionOperation.MessageBox_SupervisorA));
        t0.GuardMappingList.add(grdt0e1);

        // Platform of the new : B2
        // Platform of the last : B2
        Condition t0Ct1e2 = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2e2 = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3e2 = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4e2 = new Condition(t0, "C_PB", TransitionCondition.IsNull);
        Condition t0Ct5e2 = new Condition(t0, "C_TimeB", TransitionCondition.IsNull);
        Condition t0Ct6e2 = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7e2 = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8e2 = new Condition(t0, "Platform_B", TransitionCondition.Contains, "B2");
        Condition t0Ct9e2 = new Condition(t0, "H_List_B", TransitionCondition.Check_Platform_History, "B2");

        t0Ct8e2.SetNextCondition(LogicConnector.AND, t0Ct9e2);
        t0Ct7e2.SetNextCondition(LogicConnector.AND, t0Ct8e2);
        t0Ct6e2.SetNextCondition(LogicConnector.AND, t0Ct7e2);
        t0Ct5e2.SetNextCondition(LogicConnector.AND, t0Ct6e2);
        t0Ct4e2.SetNextCondition(LogicConnector.AND, t0Ct5e2);
        t0Ct3e2.SetNextCondition(LogicConnector.AND, t0Ct4e2);
        t0Ct2e2.SetNextCondition(LogicConnector.AND, t0Ct3e2);
        t0Ct1e2.SetNextCondition(LogicConnector.AND, t0Ct2e2);

        GuardMapping grdt0e2 = new GuardMapping();
        grdt0e2.condition = t0Ct1e2;
        grdt0e2.Activations.add(new Activation(t0,"Train_B",
                "Dep_Time_B",
                "Platform_B",
                "H_List_B",
                "B2_Length",
                "B4_Length",
                "B2_Length",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_B"));
        grdt0e2.Activations.add(new Activation(t0, "D_Train_B", TransitionOperation.MessageBox_SupervisorA));
        t0.GuardMappingList.add(grdt0e2);

        // Platform of the new : B2
        // Platform of the last : B3
        Condition t0Ct1e3 = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2e3 = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3e3 = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4e3 = new Condition(t0, "C_PB", TransitionCondition.IsNull);
        Condition t0Ct5e3 = new Condition(t0, "C_TimeB", TransitionCondition.IsNull);
        Condition t0Ct6e3 = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7e3 = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8e3 = new Condition(t0, "Platform_B", TransitionCondition.Contains, "B2");
        Condition t0Ct9e3 = new Condition(t0, "H_List_B", TransitionCondition.Check_Platform_History, "B3");

        t0Ct8e3.SetNextCondition(LogicConnector.AND, t0Ct9e3);
        t0Ct7e3.SetNextCondition(LogicConnector.AND, t0Ct8e3);
        t0Ct6e3.SetNextCondition(LogicConnector.AND, t0Ct7e3);
        t0Ct5e3.SetNextCondition(LogicConnector.AND, t0Ct6e3);
        t0Ct4e3.SetNextCondition(LogicConnector.AND, t0Ct5e3);
        t0Ct3e3.SetNextCondition(LogicConnector.AND, t0Ct4e3);
        t0Ct2e3.SetNextCondition(LogicConnector.AND, t0Ct3e3);
        t0Ct1e3.SetNextCondition(LogicConnector.AND, t0Ct2e3);

        GuardMapping grdt0e3 = new GuardMapping();
        grdt0e3.condition = t0Ct1e3;
        grdt0e3.Activations.add(new Activation(t0,"Train_B",
                "Dep_Time_B",
                "Platform_B",
                "H_List_B",
                "B2_Length",
                "B4_Length",
                "Zero",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_B"));
        grdt0e3.Activations.add(new Activation(t0, "D_Train_B", TransitionOperation.MessageBox_SupervisorA));
        t0.GuardMappingList.add(grdt0e3);


        // Platform of the new : B3
        // Platform of the last : B1, B2 or B3 doesn't matter, we take into account the leaving time of the station = intersection with the new train
        Condition t0Ct1f1 = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2f1 = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3f1 = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4f1 = new Condition(t0, "C_PB", TransitionCondition.IsNull);
        Condition t0Ct5f1 = new Condition(t0, "C_TimeB", TransitionCondition.IsNull);
        Condition t0Ct6f1 = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        Condition t0Ct7f1 = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8f1 = new Condition(t0, "Platform_B", TransitionCondition.Contains, "B3");

        t0Ct7f1.SetNextCondition(LogicConnector.AND, t0Ct8f1);
        t0Ct6f1.SetNextCondition(LogicConnector.AND, t0Ct7f1);
        t0Ct5f1.SetNextCondition(LogicConnector.AND, t0Ct6f1);
        t0Ct4f1.SetNextCondition(LogicConnector.AND, t0Ct5f1);
        t0Ct3f1.SetNextCondition(LogicConnector.AND, t0Ct4f1);
        t0Ct2f1.SetNextCondition(LogicConnector.AND, t0Ct3f1);
        t0Ct1f1.SetNextCondition(LogicConnector.AND, t0Ct2f1);

        GuardMapping grdt0f1 = new GuardMapping();
        grdt0f1.condition = t0Ct1f1;
        grdt0f1.Activations.add(new Activation(t0,"Train_B",
                "Dep_Time_B",
                "Platform_B",
                "H_List_B",
                "B3_Length",
                "Zero",
                "Zero",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_B"));
        grdt0f1.Activations.add(new Activation(t0, "D_Train_B", TransitionOperation.MessageBox_SupervisorA));
        t0.GuardMappingList.add(grdt0f1);



        // there is a comming train
        Condition t0Ct1g = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2g = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3g = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4g = new Condition(t0, "C_PB", TransitionCondition.NotNull);
        Condition t0Ct5g = new Condition(t0, "C_TimeB", TransitionCondition.NotNull);
        Condition t0Ct6g = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        // Condition t0Ct7g = new Condition(t0, "H_List_B", TransitionCondition.Have_NoListTrain_History);
        Condition t0Ct7g = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B1");

        // t0Ct7g.SetNextCondition(LogicConnector.AND, t0Ct8g);
        t0Ct6g.SetNextCondition(LogicConnector.AND, t0Ct7g);
        t0Ct5g.SetNextCondition(LogicConnector.AND, t0Ct6g);
        t0Ct4g.SetNextCondition(LogicConnector.AND, t0Ct5g);
        t0Ct3g.SetNextCondition(LogicConnector.AND, t0Ct4g);
        t0Ct2g.SetNextCondition(LogicConnector.AND, t0Ct3g);
        t0Ct1g.SetNextCondition(LogicConnector.AND, t0Ct2g);

        GuardMapping grdt0g = new GuardMapping();
        grdt0g.condition = t0Ct1g;
        grdt0g.Activations.add(new Activation(t0,"Train_B",
                "Dep_Time_B",
                "Platform_B",
                "C_TimeB",
                "C_PB",
                "B1_Length",
                "B4_Length",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_NotNull,
                "D_Train_B"));
        grdt0g.Activations.add(new Activation(t0, "D_Train_B", TransitionOperation.MessageBox_SupervisorA));
        t0.GuardMappingList.add(grdt0g);


        Condition t0Ct1h = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2h = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3h = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4h = new Condition(t0, "C_PB", TransitionCondition.NotNull);
        Condition t0Ct5h = new Condition(t0, "C_TimeB", TransitionCondition.NotNull);
        Condition t0Ct6h = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        //Condition t0Ct7h = new Condition(t0, "H_List_B", TransitionCondition.Have_NoListTrain_History);
        Condition t0Ct7h = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B2");

        // t0Ct7h.SetNextCondition(LogicConnector.AND, t0Ct8h);
        t0Ct6h.SetNextCondition(LogicConnector.AND, t0Ct7h);
        t0Ct5h.SetNextCondition(LogicConnector.AND, t0Ct6h);
        t0Ct4h.SetNextCondition(LogicConnector.AND, t0Ct5h);
        t0Ct3h.SetNextCondition(LogicConnector.AND, t0Ct4h);
        t0Ct2h.SetNextCondition(LogicConnector.AND, t0Ct3h);
        t0Ct1h.SetNextCondition(LogicConnector.AND, t0Ct2h);


        GuardMapping grdt0h = new GuardMapping();
        grdt0h.condition = t0Ct1h;
        grdt0h.Activations.add(new Activation(t0,"Train_B",
                "Dep_Time_B",
                "Platform_B",
                "C_TimeB",
                "C_PB",
                "B2_Length",
                "B4_Length",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_NotNull,
                "D_Train_B"));
        grdt0h.Activations.add(new Activation(t0, "D_Train_B", TransitionOperation.MessageBox_SupervisorA));
        t0.GuardMappingList.add(grdt0h);


        Condition t0Ct1i = new Condition(t0, "Train_B", TransitionCondition.NotNull);
        Condition t0Ct2i = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
        Condition t0Ct3i = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
        Condition t0Ct4i = new Condition(t0, "C_PB", TransitionCondition.NotNull);
        Condition t0Ct5i = new Condition(t0, "C_TimeB", TransitionCondition.NotNull);
        Condition t0Ct6i = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
        //Condition t0Ct7i = new Condition(t0, "H_List_B", TransitionCondition.Have_NoListTrain_History);
        Condition t0Ct7i = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B3");

        //t0Ct7i.SetNextCondition(LogicConnector.AND, t0Ct8i);
        t0Ct6i.SetNextCondition(LogicConnector.AND, t0Ct7i);
        t0Ct5i.SetNextCondition(LogicConnector.AND, t0Ct6i);
        t0Ct4i.SetNextCondition(LogicConnector.AND, t0Ct5i);
        t0Ct3i.SetNextCondition(LogicConnector.AND, t0Ct4i);
        t0Ct2i.SetNextCondition(LogicConnector.AND, t0Ct3i);
        t0Ct1i.SetNextCondition(LogicConnector.AND, t0Ct2i);


        GuardMapping grdt0i = new GuardMapping();
        grdt0i.condition = t0Ct1i;
        grdt0i.Activations.add(new Activation(t0,"Train_B",
                "Dep_Time_B",
                "Platform_B",
                "C_TimeB",
                "C_PB",
                "B3_Length",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_NotNull,
                "D_Train_B"));
        grdt0i.Activations.add(new Activation(t0, "D_Train_B", TransitionOperation.MessageBox_SupervisorA));
        t0.GuardMappingList.add(grdt0i);


//        // not the first created train in that day
//        Condition t0Ct1j = new Condition(t0, "Train_B", TransitionCondition.NotNull);
//        Condition t0Ct2j = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
//        Condition t0Ct3j = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
//        Condition t0Ct4j = new Condition(t0, "C_PB", TransitionCondition.NotNull);
//        Condition t0Ct5j = new Condition(t0, "C_TimeB", TransitionCondition.NotNull);
//        Condition t0Ct6j = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
//        Condition t0Ct7j = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
//        Condition t0Ct8j = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B1");
//
//        t0Ct7j.SetNextCondition(LogicConnector.AND, t0Ct8j);
//        t0Ct6j.SetNextCondition(LogicConnector.AND, t0Ct7j);
//        t0Ct5j.SetNextCondition(LogicConnector.AND, t0Ct6j);
//        t0Ct4j.SetNextCondition(LogicConnector.AND, t0Ct5j);
//        t0Ct3j.SetNextCondition(LogicConnector.AND, t0Ct4j);
//        t0Ct2j.SetNextCondition(LogicConnector.AND, t0Ct3j);
//        t0Ct1j.SetNextCondition(LogicConnector.AND, t0Ct2j);
//
//
//        GuardMapping grdt0j = new GuardMapping();
//        grdt0j.condition = t0Ct1j;
//        grdt0j.Activations.add(new Activation(t0,"Train_B","Dep_Time_B","Platform_B","C_TimeB","C_PB","H_List_B","B1_Length","B4_Length","Speed_On_Platform", TransitionOperation.CreateTrain_NotNull, "D_Train_B"));
//        grdt0j.Activations.add(new Activation(t0, "D_Train_B", TransitionOperation.MessageBox_SupervisorA));
//        t0.GuardMappingList.add(grdt0j);
//
//
//        Condition t0Ct1k = new Condition(t0, "Train_B", TransitionCondition.NotNull);
//        Condition t0Ct2k = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
//        Condition t0Ct3k = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
//        Condition t0Ct4k = new Condition(t0, "C_PB", TransitionCondition.NotNull);
//        Condition t0Ct5k = new Condition(t0, "C_TimeB", TransitionCondition.NotNull);
//        Condition t0Ct6k = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
//        Condition t0Ct7k = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
//        Condition t0Ct8k = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B2");
//
//        t0Ct7k.SetNextCondition(LogicConnector.AND, t0Ct8k);
//        t0Ct6k.SetNextCondition(LogicConnector.AND, t0Ct7k);
//        t0Ct5k.SetNextCondition(LogicConnector.AND, t0Ct6k);
//        t0Ct4k.SetNextCondition(LogicConnector.AND, t0Ct5k);
//        t0Ct3k.SetNextCondition(LogicConnector.AND, t0Ct4k);
//        t0Ct2k.SetNextCondition(LogicConnector.AND, t0Ct3k);
//        t0Ct1k.SetNextCondition(LogicConnector.AND, t0Ct2k);
//
//
//        GuardMapping grdt0k = new GuardMapping();
//        grdt0k.condition = t0Ct1k;
//        grdt0k.Activations.add(new Activation(t0,"Train_B",
//                "Dep_Time_B",
//                "Platform_B",
//                "C_TimeB",
//                "C_PB",
//                "H_List_B",
//                "B2_Length",
//                "B4_Length",
//                "Speed_On_Platform",
//                TransitionOperation.CreateTrain_NotNull,
//                "D_Train_B"));
//        grdt0k.Activations.add(new Activation(t0, "D_Train_B", TransitionOperation.MessageBox_SupervisorA));
//        t0.GuardMappingList.add(grdt0k);
//
//
//        Condition t0Ct1l = new Condition(t0, "Train_B", TransitionCondition.NotNull);
//        Condition t0Ct2l = new Condition(t0, "Dep_Time_B", TransitionCondition.NotNull);
//        Condition t0Ct3l = new Condition(t0, "Platform_B", TransitionCondition.NotNull);
//        Condition t0Ct4l = new Condition(t0, "C_PB", TransitionCondition.NotNull);
//        Condition t0Ct5l = new Condition(t0, "C_TimeB", TransitionCondition.NotNull);
//        Condition t0Ct6l = new Condition(t0, "D_Train_B", TransitionCondition.IsNull);
//        Condition t0Ct7l = new Condition(t0, "H_List_B", TransitionCondition.HaveListTrain_History);
//        Condition t0Ct8l = new Condition(t0, "Platform_B", TransitionCondition.Contains,"B3");
//
//        t0Ct7l.SetNextCondition(LogicConnector.AND, t0Ct8l);
//        t0Ct6l.SetNextCondition(LogicConnector.AND, t0Ct7l);
//        t0Ct5l.SetNextCondition(LogicConnector.AND, t0Ct6l);
//        t0Ct4l.SetNextCondition(LogicConnector.AND, t0Ct5l);
//        t0Ct3l.SetNextCondition(LogicConnector.AND, t0Ct4l);
//        t0Ct2l.SetNextCondition(LogicConnector.AND, t0Ct3l);
//        t0Ct1l.SetNextCondition(LogicConnector.AND, t0Ct2l);
//
//
//        GuardMapping grdt0l = new GuardMapping();
//        grdt0l.condition = t0Ct1l;
//        grdt0l.Activations.add(new Activation(t0,"Train_B","Dep_Time_B","Platform_B","C_TimeB","C_PB","H_List_B","B3_Length","Zero","Speed_On_Platform", TransitionOperation.CreateTrain_NotNull, "D_Train_B"));
//        grdt0l.Activations.add(new Activation(t0, "D_Train_B", TransitionOperation.MessageBox_SupervisorA));
//        t0.GuardMappingList.add(grdt0l);

        t0.Delay = 0;
        pn.Transitions.add(t0);

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("D_Train_B");


       /* // Handle case when all inputs are null
        Condition t1CtAllNull = new Condition(t1, "D_Train_B", TransitionCondition.IsNull);

        GuardMapping grdT1AllNull = new GuardMapping();
        grdT1AllNull.condition = t1CtAllNull;
        grdT1AllNull.Activations.add(new Activation(t1, "", TransitionOperation.DoNothing, ""));
        t1.GuardMappingList.add(grdT1AllNull);
*/

        Condition t1Ct1a = new Condition(t1, "D_Train_B", TransitionCondition.NotNull);
        Condition t1Ct2a = new Condition(t1, "List_B", TransitionCondition.IsNull); // CanAddTrains_List

        t1Ct1a.SetNextCondition(LogicConnector.AND, t1Ct2a);

        GuardMapping grdt1a = new GuardMapping();
        grdt1a.condition = t1Ct1a;
        grdt1a.Activations.add(new Activation(t1, "D_Train_B", TransitionOperation.AddElement, "H_List_B"));
        grdt1a.Activations.add(new Activation(t1, "D_Train_B", TransitionOperation.Move, "List_B"));
        //grdt1a.Activations.add(new Activation(t1, "D_Train_B", TransitionOperation.MakeNull, "D_Train_B"));
        t1.GuardMappingList.add(grdt1a);

//
//        Condition t1Ct1b = new Condition(t1, "D_Train_B", TransitionCondition.NotNull);
//        Condition t1Ct2b = new Condition(t1, "List_B", TransitionCondition.CanNotAddTrains_List);
//
//        t1Ct1b.SetNextCondition(LogicConnector.AND, t1Ct2b);
//
//        GuardMapping grdt1b = new GuardMapping();
//        grdt1b.condition = t1Ct1b;
//        grdt1b.Activations.add(new Activation(t1, "List_B", TransitionOperation.RemoveFirst, "List_B"));
//        grdt1b.Activations.add(new Activation(t1, "D_Train_B", TransitionOperation.AddElement, "List_B"));
//        grdt1b.Activations.add(new Activation(t1, "D_Train_B", TransitionOperation.Move, "D_Train_B"));
//        t1.GuardMappingList.add(grdt1b);


        t1.Delay = 0;
        pn.Transitions.add(t1);

//        // T2 ------------------------------------------------
//        PetriTransition t2 = new PetriTransition(pn);
//        t2.TransitionName = "t2";
//        t2.InputPlaceName.add("D_Train_B");
//
//
//
//
//        Condition t2Ct1 = new Condition(t2, "D_Train_B", TransitionCondition.NotNull);
//
//
//        GuardMapping grdt2 = new GuardMapping();
//        grdt2.condition = t2Ct1;
//        grdt2.Activations.add(new Activation(t2, "D_Train_B", TransitionOperation.AddElement, "H_List_B"));
//        t2.GuardMappingList.add(grdt2);
//
//        t2.Delay = 0;
//        pn.Transitions.add(t2);


        // t2 ------------------------------------------------


        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("H_List_B");


     /*   // Handle case when all inputs are null
        Condition t2CtAllNull = new Condition(t2, "H_List_B", TransitionCondition.IsNull);

        GuardMapping grdt2AllNull = new GuardMapping();
        grdt2AllNull.condition = t2CtAllNull;
        grdt2AllNull.Activations.add(new Activation(t2, "", TransitionOperation.DoNothing, ""));
        t2.GuardMappingList.add(grdt2AllNull);

*/

        Condition t2Ct1a = new Condition(t2, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t2Ct2a = new Condition(t2, "H_List_B", TransitionCondition.CheckTime_Before);

        t2Ct1a.SetNextCondition(LogicConnector.AND, t2Ct2a);

        GuardMapping grdt2a = new GuardMapping();
        grdt2a.condition = t2Ct2a;
        grdt2a.Activations.add(new Activation(t2, "H_List_B", TransitionOperation.Move, "H_List_B"));
        t2.GuardMappingList.add(grdt2a);



        Condition t2Ct1b = new Condition(t2, "H_List_B", TransitionCondition.HaveListTrain_History);
        Condition t2Ct2b= new Condition(t2, "H_List_B", TransitionCondition.CheckTime_After);

        t2Ct1b.SetNextCondition(LogicConnector.AND, t2Ct2b);

        GuardMapping grdt2b = new GuardMapping();
        grdt2b.condition = t2Ct2b;
        grdt2b.Activations.add(new Activation(t2,"H_List_B", "filePath", TransitionOperation.SaveAndDelete, "H_List_B"));
        t2.GuardMappingList.add(grdt2b);

        t2.Delay = 0;
        pn.Transitions.add(t2);


        // T3 ------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "t3";
        t3.InputPlaceName.add("List_B");

/*
        // Handle case when all inputs are null
        Condition t3CtAllNull = new Condition(t3, "List_B", TransitionCondition.IsNull);

        GuardMapping grdt3AllNull = new GuardMapping();
        grdt3AllNull.condition = t3CtAllNull;
        grdt3AllNull.Activations.add(new Activation(t3, "", TransitionOperation.DoNothing, ""));
        t3.GuardMappingList.add(grdt3AllNull);

*/
        Condition t3Ct1a = new Condition(t3, "List_B", TransitionCondition.NotNull); //HaveListTrain
        Condition t3Ct2a = new Condition(t3,"List_B", TransitionCondition.Platform_To_Send, "B1");

        t3Ct1a.SetNextCondition(LogicConnector.AND, t3Ct2a);

        GuardMapping grdt3a = new GuardMapping();
        grdt3a.condition = t3Ct1a;
        grdt3a.Activations.add(new Activation(t3, "List_B", TransitionOperation.SendTrainOverNetwork, "T1_B"));
        grdt3a.Activations.add(new Activation(t3, "List_B", TransitionOperation.SendOverNetwork, "Time1_B"));
        //grdt3a.Activations.add(new Activation(t3, "List_B", TransitionOperation.PopElement_Train, "List_B"));
        grdt3a.Activations.add(new Activation(t3, "List_B", TransitionOperation.MakeNull, "List_B"));
        t3.GuardMappingList.add(grdt3a);


        Condition t3Ct1b = new Condition(t3, "List_B", TransitionCondition.NotNull);
        Condition t3Ct2b = new Condition(t3, "List_B", TransitionCondition.Platform_To_Send, "B2");

        t3Ct1b.SetNextCondition(LogicConnector.AND, t3Ct2b);

        GuardMapping grdt3b = new GuardMapping();
        grdt3b.condition = t3Ct1b;
        grdt3b.Activations.add(new Activation(t3, "List_B", TransitionOperation.SendTrainOverNetwork, "T2_B"));
        grdt3b.Activations.add(new Activation(t3, "List_B", TransitionOperation.SendOverNetwork, "Time2_B"));
        //grdt3b.Activations.add(new Activation(t3, "List_B", TransitionOperation.PopElement_Train, "Temp"));
        grdt3b.Activations.add(new Activation(t3, "List_B", TransitionOperation.MakeNull, "List_B"));
        t3.GuardMappingList.add(grdt3b);



        Condition t3Ct1c = new Condition(t3, "List_B", TransitionCondition.NotNull);
        Condition t3Ct2c = new Condition(t3,"List_B", TransitionCondition.Platform_To_Send, "B3");

        t3Ct1c.SetNextCondition(LogicConnector.AND, t3Ct2c);

        GuardMapping grdt3c = new GuardMapping();
        grdt3c.condition = t3Ct1c;
        grdt3c.Activations.add(new Activation(t3, "List_B", TransitionOperation.SendTrainOverNetwork, "T3_B"));
        grdt3c.Activations.add(new Activation(t3, "List_B", TransitionOperation.SendOverNetwork, "Time3_B"));
        //grdt3c.Activations.add(new Activation(t3, "List_B", TransitionOperation.PopElement_Train, "List_B"));
        grdt3c.Activations.add(new Activation(t3, "List_B", TransitionOperation.MakeNull, "List_B"));
        t3.GuardMappingList.add(grdt3c);


        t3.Delay = 0;
        pn.Transitions.add(t3);


        System.out.println("Supervisor B started \n ------------------------------");
        pn.Delay = 3000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.setTitle("Supervisor B");
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
