package THESIS.Supervisors;

import Components.*;
import DataObjects.*;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Supervisor_C {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Supervisor C";
        pn.SetName("Supervisor C");

        pn.NetworkPort = 1092;


        DataLocalTime C_TimeC = new DataLocalTime();
        C_TimeC.SetName("C_TimeC");
        pn.PlaceList.add(C_TimeC);

        DataLocalTime C_TimeC1 = new DataLocalTime();
        C_TimeC1.SetName("C_TimeC1");
        pn.PlaceList.add(C_TimeC1);

        DataLocalTime C_TimeC2 = new DataLocalTime();
        C_TimeC2.SetName("C_TimeC2");
        pn.PlaceList.add(C_TimeC2);

        DataLocalTime C_TimeC3 = new DataLocalTime();
        C_TimeC3.SetName("C_TimeC");
        pn.PlaceList.add(C_TimeC3);

        DataString C_PC = new DataString();
        C_PC.SetName("C_PC");
        pn.PlaceList.add(C_PC);

        DataString C_PC1 = new DataString();
        C_PC1.SetName("C_PC1");
        pn.PlaceList.add(C_PC1);

        DataString C_PC2 = new DataString();
        C_PC2.SetName("C_PC2");
        pn.PlaceList.add(C_PC2);

        DataString C_PC3= new DataString();
        C_PC3.SetName("C_PC3");
        pn.PlaceList.add(C_PC3);

        DataString C_PC4 = new DataString();
        C_PC4.SetName("C_PC4");
        pn.PlaceList.add(C_PC4);

        DataString filePath = new DataString();
        filePath.SetName("filePath");
        filePath.SetValue("Trains_Station_C.txt");
        filePath.textfile();
        pn.ConstantPlaceList.add(filePath);

        DataString C1 = new DataString();
        C1.SetName("C1");
        C1.SetValue("C1");
        pn.ConstantPlaceList.add(C1);

        DataString C2 = new DataString();
        C2.SetName("C2");
        C2.SetValue("C2");
        pn.ConstantPlaceList.add(C2);

        DataString C3 = new DataString();
        C3.SetName("C3");
        C3.SetValue("C3");
        pn.ConstantPlaceList.add(C3);

        DataInteger Zero = new DataInteger();
        Zero.SetName("Zero");
        Zero.SetValue(0);
        pn.ConstantPlaceList.add(Zero);

        DataInteger C1_Length = new DataInteger();
        C1_Length.SetName("C1_Length");
        C1_Length.SetValue(140);
        pn.ConstantPlaceList.add(C1_Length);

        DataInteger C2_Length = new DataInteger();
        C2_Length.SetName("C2_Length");
        C2_Length.SetValue(100);
        pn.ConstantPlaceList.add(C2_Length);

        DataInteger C3_Length = new DataInteger();
        C3_Length.SetName("C3_Length");
        C3_Length.SetValue(130);
        pn.ConstantPlaceList.add(C3_Length);

        DataInteger C4_Length = new DataInteger();
        C4_Length.SetName("C4_Length");
        C4_Length.SetValue(70);
        pn.ConstantPlaceList.add(C4_Length);

        DataInteger speed_on_platform = new DataInteger();
        speed_on_platform.SetName("Speed_On_Platform");
        speed_on_platform.SetValue(5);
        pn.ConstantPlaceList.add(speed_on_platform);


        DataTrain p1 = new DataTrain();
        p1.SetName("Train_C");
        pn.PlaceList.add(p1);

        DataLocalTime p2 = new DataLocalTime();
        p2.SetName("Dep_Time_C");
        pn.PlaceList.add(p2);

        DataString p3 = new DataString();
        p3.SetName("Platform_C");
        pn.PlaceList.add(p3);

        DataListTrains p4 = new DataListTrains();
        p4.SetName("D_Train_C");
        pn.PlaceList.add(p4);

        DataListTrains p5 = new DataListTrains();
        p5.SetName("List_C");
        pn.PlaceList.add(p5);

        DataListTrainsHistory p6 = new DataListTrainsHistory();
        p6.SetName("H_List_C");
        pn.PlaceList.add(p6);

        DataTransfer T1_C = new DataTransfer();
        T1_C.SetName("T1_C");
        T1_C.Value = new TransferOperation("localhost", "1090", "Train_C1");
        pn.PlaceList.add(T1_C);

        DataTransfer T2_C = new DataTransfer();
        T2_C.SetName("T2_C");
        T2_C.Value = new TransferOperation("localhost", "1090", "Train_C2");
        pn.PlaceList.add(T2_C);

        DataTransfer T3_C = new DataTransfer();
        T3_C.SetName("T3_C");
        T3_C.Value = new TransferOperation("localhost", "1090", "Train_C3");
        pn.PlaceList.add(T3_C);

        DataTransfer Time1_C = new DataTransfer();
        Time1_C.SetName("Time1_C");
        Time1_C.Value = new TransferOperation("localhost", "1090", "Time_C1");
        pn.PlaceList.add(Time1_C);

        DataTransfer Time2_C = new DataTransfer();
        Time2_C.SetName("Time2_C");
        Time2_C.Value = new TransferOperation("localhost", "1090", "Time_C2");
        pn.PlaceList.add(Time2_C);

        DataTransfer Time3_C = new DataTransfer();
        Time3_C.SetName("Time3_C");
        Time3_C.Value = new TransferOperation("localhost", "1090", "Time_C3");
        pn.PlaceList.add(Time3_C);




// t4 ------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "t4";
        t4.InputPlaceName.add("C_TimeC1");
        t4.InputPlaceName.add("C_TimeC2");
        t4.InputPlaceName.add("C_TimeC3");
        t4.InputPlaceName.add("C_TimeC4");

        Condition t4Ct1a = new Condition(t4, "C_TimeC1", TransitionCondition.NotNull);

        GuardMapping grdt4a = new GuardMapping();
        grdt4a.condition = t4Ct1a;
        grdt4a.Activations.add(new Activation(t4, "C_TimeC1", TransitionOperation.Move, "C_TimeC"));
        t4.GuardMappingList.add(grdt4a);


        Condition t4Ct1b = new Condition(t4, "C_TimeC2", TransitionCondition.NotNull);

        GuardMapping grdt4b = new GuardMapping();
        grdt4b.condition = t4Ct1b;
        grdt4b.Activations.add(new Activation(t4, "C_TimeC2", TransitionOperation.Move, "C_TimeC"));
        t4.GuardMappingList.add(grdt4b);


        Condition t4Ct1c = new Condition(t4, "C_TimeC3", TransitionCondition.NotNull);

        GuardMapping grdt4c = new GuardMapping();
        grdt4c.condition = t4Ct1c;
        grdt4c.Activations.add(new Activation(t4, "C_TimeC3", TransitionOperation.Move, "C_TimeC"));
        t4.GuardMappingList.add(grdt4c);


        Condition t4Ct1d = new Condition(t4, "C_TimeC4", TransitionCondition.NotNull);

        GuardMapping grdt4d = new GuardMapping();
        grdt4d.condition = t4Ct1d;
        grdt4d.Activations.add(new Activation(t4, "C_TimeC4", TransitionOperation.Move, "C_TimeC"));
        t4.GuardMappingList.add(grdt4d);


        t4.Delay = 0;
        pn.Transitions.add(t4);


        // t5 ------------------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "t5";
        t5.InputPlaceName.add("C_PC1");
        t5.InputPlaceName.add("C_PC2");
        t5.InputPlaceName.add("C_PC3");
        t5.InputPlaceName.add("C_PC4");



        Condition t5Ct1a = new Condition(t5, "C_PC1", TransitionCondition.NotNull);

        GuardMapping grdt5a = new GuardMapping();
        grdt5a.condition = t5Ct1a;
        grdt5a.Activations.add(new Activation(t5, "C_PC1", TransitionOperation.Move, "C_PC"));
        t5.GuardMappingList.add(grdt5a);


        Condition t5Ct1b = new Condition(t5, "C_PC2", TransitionCondition.NotNull);

        GuardMapping grdt5b = new GuardMapping();
        grdt5b.condition = t5Ct1b;
        grdt5b.Activations.add(new Activation(t5, "C_PC2", TransitionOperation.Move, "C_PC"));
        t5.GuardMappingList.add(grdt5b);


        Condition t5Ct1c = new Condition(t5, "C_PC3", TransitionCondition.NotNull);

        GuardMapping grdt5c = new GuardMapping();
        grdt5c.condition = t5Ct1c;
        grdt5c.Activations.add(new Activation(t5, "C_PC3", TransitionOperation.Move, "C_PC"));
        t5.GuardMappingList.add(grdt5c);


        Condition t5Ct1d = new Condition(t5, "C_PC4", TransitionCondition.NotNull);

        GuardMapping grdt5d = new GuardMapping();
        grdt5d.condition = t5Ct1d;
        grdt5d.Activations.add(new Activation(t5, "C_PC4", TransitionOperation.Move, "C_PC"));
        t5.GuardMappingList.add(grdt5d);


        t5.Delay = 0;
        pn.Transitions.add(t5);




        // T0 ------------------------------------------------
        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "t0";
        t0.InputPlaceName.add("Train_C");
        t0.InputPlaceName.add("Dep_Time_C");
        t0.InputPlaceName.add("Platform_C");
        t0.InputPlaceName.add("C_PC");
        t0.InputPlaceName.add("C_TimeC");
        t0.InputPlaceName.add("H_List_C");

        // no comming train
        // first train created on platform C1
        Condition t0Ct1a = new Condition(t0, "Train_C", TransitionCondition.NotNull);
        Condition t0Ct2a = new Condition(t0, "Dep_Time_C", TransitionCondition.NotNull);
        Condition t0Ct3a = new Condition(t0, "Platform_C", TransitionCondition.NotNull);
        Condition t0Ct4a = new Condition(t0, "C_PC", TransitionCondition.IsNull);
        Condition t0Ct5a = new Condition(t0, "C_TimeC", TransitionCondition.IsNull);
        Condition t0Ct6a = new Condition(t0, "D_Train_C", TransitionCondition.IsNull);
        Condition t0Ct7a = new Condition(t0, "H_List_C", TransitionCondition.Have_NoListTrain_History);
        Condition t0Ct8a = new Condition(t0, "Platform_C", TransitionCondition.Contains,"C1");

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
                C1_Length.GetName(),
                C4_Length.GetName(),
                "Zero",
                "Zero",
                speed_on_platform.GetName(),
                TransitionOperation.CreateTrain_Null,
                p4.GetName()));
        grdt0a.Activations.add(new Activation(t0,p4.GetName(), TransitionOperation.MessageBox_SupervisorC));
        t0.GuardMappingList.add(grdt0a);

        // first train created on platform C2
        Condition t0Ct1b = new Condition(t0, "Train_C", TransitionCondition.NotNull);
        Condition t0Ct2b = new Condition(t0, "Dep_Time_C", TransitionCondition.NotNull);
        Condition t0Ct3b = new Condition(t0, "Platform_C", TransitionCondition.NotNull);
        Condition t0Ct4b = new Condition(t0, "C_PC", TransitionCondition.IsNull);
        Condition t0Ct5b = new Condition(t0, "C_TimeC", TransitionCondition.IsNull);
        Condition t0Ct6b = new Condition(t0, "D_Train_C", TransitionCondition.IsNull);
        Condition t0Ct7b = new Condition(t0, "H_List_C", TransitionCondition.Have_NoListTrain_History);
        Condition t0Ct8b = new Condition(t0, "Platform_C", TransitionCondition.Contains,"C2");

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
                "Train_C",
                "Dep_Time_C",
                "Platform_C",
                null,
                "C2_Length",
                "C4_Length",
                "Zero",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_C"));
        grdt0b.Activations.add(new Activation(t0, "D_Train_C", TransitionOperation.MessageBox_SupervisorC));
        t0.GuardMappingList.add(grdt0b);

        // first train created on platform C3
        Condition t0Ct1c = new Condition(t0, "Train_C", TransitionCondition.NotNull);
        Condition t0Ct2c = new Condition(t0, "Dep_Time_C", TransitionCondition.NotNull);
        Condition t0Ct3c = new Condition(t0, "Platform_C", TransitionCondition.NotNull);
        Condition t0Ct4c = new Condition(t0, "C_PC", TransitionCondition.IsNull);
        Condition t0Ct5c = new Condition(t0, "C_TimeC", TransitionCondition.IsNull);
        Condition t0Ct6c = new Condition(t0, "D_Train_C", TransitionCondition.IsNull);
        Condition t0Ct7c = new Condition(t0, "H_List_C", TransitionCondition.Have_NoListTrain_History);
        Condition t0Ct8c = new Condition(t0, "Platform_C", TransitionCondition.Contains,"C3");

        t0Ct7c.SetNextCondition(LogicConnector.AND, t0Ct8c);
        t0Ct6c.SetNextCondition(LogicConnector.AND, t0Ct7c);
        t0Ct5c.SetNextCondition(LogicConnector.AND, t0Ct6c);
        t0Ct4c.SetNextCondition(LogicConnector.AND, t0Ct5c);
        t0Ct3c.SetNextCondition(LogicConnector.AND, t0Ct4c);
        t0Ct2c.SetNextCondition(LogicConnector.AND, t0Ct3c);
        t0Ct1c.SetNextCondition(LogicConnector.AND, t0Ct2c);

        GuardMapping grdt0c = new GuardMapping();
        grdt0c.condition = t0Ct1c;
        grdt0c.Activations.add(new Activation(t0,"Train_C",
                "Dep_Time_C",
                "Platform_C",
                null,
                "C3_Length",
                "Zero",
                "Zero",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_C"));
        grdt0c.Activations.add(new Activation(t0, "D_Train_C", TransitionOperation.MessageBox_SupervisorC));
        t0.GuardMappingList.add(grdt0c);


        //Not the first train created in the day
        // Platform of the new : C1
        // Platform of the last : C1
        Condition t0Ct1d = new Condition(t0, "Train_C", TransitionCondition.NotNull);
        Condition t0Ct2d = new Condition(t0, "Dep_Time_C", TransitionCondition.NotNull);
        Condition t0Ct3d = new Condition(t0, "Platform_C", TransitionCondition.NotNull);
        Condition t0Ct4d = new Condition(t0, "C_PC", TransitionCondition.IsNull);
        Condition t0Ct5d = new Condition(t0, "C_TimeC", TransitionCondition.IsNull);
        Condition t0Ct6d = new Condition(t0, "D_Train_C", TransitionCondition.IsNull);
        Condition t0Ct7d = new Condition(t0, "H_List_C", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8d = new Condition(t0, "Platform_C", TransitionCondition.Contains,"C1");
        Condition t0Ct9d = new Condition(t0, "H_List_C", TransitionCondition.Check_Platform_History,"C1");

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
        grdt0d.Activations.add(new Activation(t0,"Train_C",
                "Dep_Time_C",
                "Platform_C",
                "H_List_C",
                "C1_Length",
                "C4_Length",
                "C1_Length",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_C"));
        grdt0d.Activations.add(new Activation(t0, "D_Train_C", TransitionOperation.MessageBox_SupervisorC));
        t0.GuardMappingList.add(grdt0d);

        // Platform of the new : C1
        // Platform of the last : C2
        Condition t0Ct1d1 = new Condition(t0, "Train_C", TransitionCondition.NotNull);
        Condition t0Ct2d1 = new Condition(t0, "Dep_Time_C", TransitionCondition.NotNull);
        Condition t0Ct3d1 = new Condition(t0, "Platform_C", TransitionCondition.NotNull);
        Condition t0Ct4d1 = new Condition(t0, "C_PC", TransitionCondition.IsNull);
        Condition t0Ct5d1 = new Condition(t0, "C_TimeC", TransitionCondition.IsNull);
        Condition t0Ct6d1 = new Condition(t0, "D_Train_C", TransitionCondition.IsNull);
        Condition t0Ct7d1 = new Condition(t0, "H_List_C", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8d1 = new Condition(t0, "Platform_C", TransitionCondition.Contains, "C1");
        Condition t0Ct9d1 = new Condition(t0, "H_List_C", TransitionCondition.Check_Platform_History, "C2");

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
        grdt0d1.Activations.add(new Activation(t0, "Train_C",
                "Dep_Time_C",
                "Platform_C",
                "H_List_C",
                "C1_Length",
                "C4_Length",
                "C2_Length",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_C"));
        grdt0d1.Activations.add(new Activation(t0, "D_Train_C", TransitionOperation.MessageBox_SupervisorC));
        t0.GuardMappingList.add(grdt0d1);

        // Platform of the new : C1
        // Platform of the last : C3
        Condition t0Ct1d2 = new Condition(t0, "Train_C", TransitionCondition.NotNull);
        Condition t0Ct2d2 = new Condition(t0, "Dep_Time_C", TransitionCondition.NotNull);
        Condition t0Ct3d2 = new Condition(t0, "Platform_C", TransitionCondition.NotNull);
        Condition t0Ct4d2 = new Condition(t0, "C_PC", TransitionCondition.IsNull);
        Condition t0Ct5d2 = new Condition(t0, "C_TimeC", TransitionCondition.IsNull);
        Condition t0Ct6d2 = new Condition(t0, "D_Train_C", TransitionCondition.IsNull);
        Condition t0Ct7d2 = new Condition(t0, "H_List_C", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8d2 = new Condition(t0, "Platform_C", TransitionCondition.Contains, "C1");
        Condition t0Ct9d2 = new Condition(t0, "H_List_C", TransitionCondition.Check_Platform_History, "C3");

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
        grdt0d2.Activations.add(new Activation(t0, "Train_C",
                "Dep_Time_C",
                "Platform_C",
                "H_List_C",
                "C1_Length",
                "C4_Length",
                "Zero",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_C"));
        grdt0d2.Activations.add(new Activation(t0, "D_Train_C", TransitionOperation.MessageBox_SupervisorC));
        t0.GuardMappingList.add(grdt0d2);


        // Platform of the new : C2
        // Platform of the last : C1
        Condition t0Ct1e1 = new Condition(t0, "Train_C", TransitionCondition.NotNull);
        Condition t0Ct2e1 = new Condition(t0, "Dep_Time_C", TransitionCondition.NotNull);
        Condition t0Ct3e1 = new Condition(t0, "Platform_C", TransitionCondition.NotNull);
        Condition t0Ct4e1 = new Condition(t0, "C_PC", TransitionCondition.IsNull);
        Condition t0Ct5e1 = new Condition(t0, "C_TimeC", TransitionCondition.IsNull);
        Condition t0Ct6e1 = new Condition(t0, "D_Train_C", TransitionCondition.IsNull);
        Condition t0Ct7e1 = new Condition(t0, "H_List_C", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8e1 = new Condition(t0, "Platform_C", TransitionCondition.Contains, "C2");
        Condition t0Ct9e1 = new Condition(t0, "H_List_C", TransitionCondition.Check_Platform_History, "C1");

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
        grdt0e1.Activations.add(new Activation(t0,"Train_C",
                "Dep_Time_C",
                "Platform_C",
                "H_List_C",
                "C2_Length",
                "C4_Length",
                "C1_Length",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_C"));
        grdt0e1.Activations.add(new Activation(t0, "D_Train_C", TransitionOperation.MessageBox_SupervisorC));
        t0.GuardMappingList.add(grdt0e1);

        // Platform of the new : C2
        // Platform of the last : C2
        Condition t0Ct1e2 = new Condition(t0, "Train_C", TransitionCondition.NotNull);
        Condition t0Ct2e2 = new Condition(t0, "Dep_Time_C", TransitionCondition.NotNull);
        Condition t0Ct3e2 = new Condition(t0, "Platform_C", TransitionCondition.NotNull);
        Condition t0Ct4e2 = new Condition(t0, "C_PC", TransitionCondition.IsNull);
        Condition t0Ct5e2 = new Condition(t0, "C_TimeC", TransitionCondition.IsNull);
        Condition t0Ct6e2 = new Condition(t0, "D_Train_C", TransitionCondition.IsNull);
        Condition t0Ct7e2 = new Condition(t0, "H_List_C", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8e2 = new Condition(t0, "Platform_C", TransitionCondition.Contains, "C2");
        Condition t0Ct9e2 = new Condition(t0, "H_List_C", TransitionCondition.Check_Platform_History, "C2");

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
        grdt0e2.Activations.add(new Activation(t0,"Train_C",
                "Dep_Time_C",
                "Platform_C",
                "H_List_C",
                "C2_Length",
                "C4_Length",
                "C2_Length",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_C"));
        grdt0e2.Activations.add(new Activation(t0, "D_Train_C", TransitionOperation.MessageBox_SupervisorC));
        t0.GuardMappingList.add(grdt0e2);

        // Platform of the new : C2
        // Platform of the last : C3
        Condition t0Ct1e3 = new Condition(t0, "Train_C", TransitionCondition.NotNull);
        Condition t0Ct2e3 = new Condition(t0, "Dep_Time_C", TransitionCondition.NotNull);
        Condition t0Ct3e3 = new Condition(t0, "Platform_C", TransitionCondition.NotNull);
        Condition t0Ct4e3 = new Condition(t0, "C_PC", TransitionCondition.IsNull);
        Condition t0Ct5e3 = new Condition(t0, "C_TimeC", TransitionCondition.IsNull);
        Condition t0Ct6e3 = new Condition(t0, "D_Train_C", TransitionCondition.IsNull);
        Condition t0Ct7e3 = new Condition(t0, "H_List_C", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8e3 = new Condition(t0, "Platform_C", TransitionCondition.Contains, "C2");
        Condition t0Ct9e3 = new Condition(t0, "H_List_C", TransitionCondition.Check_Platform_History, "C3");

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
        grdt0e3.Activations.add(new Activation(t0,"Train_C",
                "Dep_Time_C",
                "Platform_C",
                "H_List_C",
                "C2_Length",
                "C4_Length",
                "Zero",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_C"));
        grdt0e3.Activations.add(new Activation(t0, "D_Train_C", TransitionOperation.MessageBox_SupervisorC));
        t0.GuardMappingList.add(grdt0e3);


        // Platform of the new : C3
        // Platform of the last : C1, C2 or C3 doesn't matter, we take into account the leaving time of the station = intersection with the new train
        Condition t0Ct1f1 = new Condition(t0, "Train_C", TransitionCondition.NotNull);
        Condition t0Ct2f1 = new Condition(t0, "Dep_Time_C", TransitionCondition.NotNull);
        Condition t0Ct3f1 = new Condition(t0, "Platform_C", TransitionCondition.NotNull);
        Condition t0Ct4f1 = new Condition(t0, "C_PC", TransitionCondition.IsNull);
        Condition t0Ct5f1 = new Condition(t0, "C_TimeC", TransitionCondition.IsNull);
        Condition t0Ct6f1 = new Condition(t0, "D_Train_C", TransitionCondition.IsNull);
        Condition t0Ct7f1 = new Condition(t0, "H_List_C", TransitionCondition.HaveListTrain_History);
        Condition t0Ct8f1 = new Condition(t0, "Platform_C", TransitionCondition.Contains, "C3");

        t0Ct7f1.SetNextCondition(LogicConnector.AND, t0Ct8f1);
        t0Ct6f1.SetNextCondition(LogicConnector.AND, t0Ct7f1);
        t0Ct5f1.SetNextCondition(LogicConnector.AND, t0Ct6f1);
        t0Ct4f1.SetNextCondition(LogicConnector.AND, t0Ct5f1);
        t0Ct3f1.SetNextCondition(LogicConnector.AND, t0Ct4f1);
        t0Ct2f1.SetNextCondition(LogicConnector.AND, t0Ct3f1);
        t0Ct1f1.SetNextCondition(LogicConnector.AND, t0Ct2f1);

        GuardMapping grdt0f1 = new GuardMapping();
        grdt0f1.condition = t0Ct1f1;
        grdt0f1.Activations.add(new Activation(t0,"Train_C",
                "Dep_Time_C",
                "Platform_C",
                "H_List_C",
                "C3_Length",
                "Zero",
                "Zero",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_Null,
                "D_Train_C"));
        grdt0f1.Activations.add(new Activation(t0, "D_Train_C", TransitionOperation.MessageBox_SupervisorC));
        t0.GuardMappingList.add(grdt0f1);



        // there is a comming train
        Condition t0Ct1g = new Condition(t0, "Train_C", TransitionCondition.NotNull);
        Condition t0Ct2g = new Condition(t0, "Dep_Time_C", TransitionCondition.NotNull);
        Condition t0Ct3g = new Condition(t0, "Platform_C", TransitionCondition.NotNull);
        Condition t0Ct4g = new Condition(t0, "C_PC", TransitionCondition.NotNull);
        Condition t0Ct5g = new Condition(t0, "C_TimeC", TransitionCondition.NotNull);
        Condition t0Ct6g = new Condition(t0, "D_Train_C", TransitionCondition.IsNull);
        Condition t0Ct7g = new Condition(t0, "Platform_C", TransitionCondition.Contains,"C1");

        t0Ct6g.SetNextCondition(LogicConnector.AND, t0Ct7g);
        t0Ct5g.SetNextCondition(LogicConnector.AND, t0Ct6g);
        t0Ct4g.SetNextCondition(LogicConnector.AND, t0Ct5g);
        t0Ct3g.SetNextCondition(LogicConnector.AND, t0Ct4g);
        t0Ct2g.SetNextCondition(LogicConnector.AND, t0Ct3g);
        t0Ct1g.SetNextCondition(LogicConnector.AND, t0Ct2g);

        GuardMapping grdt0g = new GuardMapping();
        grdt0g.condition = t0Ct1g;
        grdt0g.Activations.add(new Activation(t0,"Train_C",
                "Dep_Time_C",
                "Platform_C",
                "C_TimeC",
                "C_PC",
                "C1_Length",
                "C4_Length",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_NotNull,
                "D_Train_C"));
        grdt0g.Activations.add(new Activation(t0, "D_Train_C", TransitionOperation.MessageBox_SupervisorC));
        t0.GuardMappingList.add(grdt0g);


        Condition t0Ct1h = new Condition(t0, "Train_C", TransitionCondition.NotNull);
        Condition t0Ct2h = new Condition(t0, "Dep_Time_C", TransitionCondition.NotNull);
        Condition t0Ct3h = new Condition(t0, "Platform_C", TransitionCondition.NotNull);
        Condition t0Ct4h = new Condition(t0, "C_PC", TransitionCondition.NotNull);
        Condition t0Ct5h = new Condition(t0, "C_TimeC", TransitionCondition.NotNull);
        Condition t0Ct6h = new Condition(t0, "D_Train_C", TransitionCondition.IsNull);
        Condition t0Ct7h = new Condition(t0, "Platform_C", TransitionCondition.Contains,"C2");

        t0Ct6h.SetNextCondition(LogicConnector.AND, t0Ct7h);
        t0Ct5h.SetNextCondition(LogicConnector.AND, t0Ct6h);
        t0Ct4h.SetNextCondition(LogicConnector.AND, t0Ct5h);
        t0Ct3h.SetNextCondition(LogicConnector.AND, t0Ct4h);
        t0Ct2h.SetNextCondition(LogicConnector.AND, t0Ct3h);
        t0Ct1h.SetNextCondition(LogicConnector.AND, t0Ct2h);


        GuardMapping grdt0h = new GuardMapping();
        grdt0h.condition = t0Ct1h;
        grdt0h.Activations.add(new Activation(t0,"Train_C",
                "Dep_Time_C",
                "Platform_C",
                "C_TimeC",
                "C_PC",
                "C2_Length",
                "C4_Length",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_NotNull,
                "D_Train_C"));
        grdt0h.Activations.add(new Activation(t0, "D_Train_C", TransitionOperation.MessageBox_SupervisorC));
        t0.GuardMappingList.add(grdt0h);


        Condition t0Ct1i = new Condition(t0, "Train_C", TransitionCondition.NotNull);
        Condition t0Ct2i = new Condition(t0, "Dep_Time_C", TransitionCondition.NotNull);
        Condition t0Ct3i = new Condition(t0, "Platform_C", TransitionCondition.NotNull);
        Condition t0Ct4i = new Condition(t0, "C_PC", TransitionCondition.NotNull);
        Condition t0Ct5i = new Condition(t0, "C_TimeC", TransitionCondition.NotNull);
        Condition t0Ct6i = new Condition(t0, "D_Train_C", TransitionCondition.IsNull);
        Condition t0Ct7i = new Condition(t0, "Platform_C", TransitionCondition.Contains,"C3");

        t0Ct6i.SetNextCondition(LogicConnector.AND, t0Ct7i);
        t0Ct5i.SetNextCondition(LogicConnector.AND, t0Ct6i);
        t0Ct4i.SetNextCondition(LogicConnector.AND, t0Ct5i);
        t0Ct3i.SetNextCondition(LogicConnector.AND, t0Ct4i);
        t0Ct2i.SetNextCondition(LogicConnector.AND, t0Ct3i);
        t0Ct1i.SetNextCondition(LogicConnector.AND, t0Ct2i);


        GuardMapping grdt0i = new GuardMapping();
        grdt0i.condition = t0Ct1i;
        grdt0i.Activations.add(new Activation(t0,"Train_C",
                "Dep_Time_C",
                "Platform_C",
                "C_TimeC",
                "C_PC",
                "C3_Length",
                "Zero",
                "Speed_On_Platform",
                TransitionOperation.CreateTrain_NotNull,
                "D_Train_C"));
        grdt0i.Activations.add(new Activation(t0, "D_Train_C", TransitionOperation.MessageBox_SupervisorC));
        t0.GuardMappingList.add(grdt0i);


        t0.Delay = 0;
        pn.Transitions.add(t0);

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("D_Train_C");



        Condition t1Ct1a = new Condition(t1, "D_Train_C", TransitionCondition.NotNull);
        Condition t1Ct2a = new Condition(t1, "List_C", TransitionCondition.IsNull); // CanAddTrains_List

        t1Ct1a.SetNextCondition(LogicConnector.AND, t1Ct2a);

        GuardMapping grdt1a = new GuardMapping();
        grdt1a.condition = t1Ct1a;
        grdt1a.Activations.add(new Activation(t1, "D_Train_C", TransitionOperation.AddElement, "H_List_C"));
        grdt1a.Activations.add(new Activation(t1, "D_Train_C", TransitionOperation.Move, "List_C"));
        t1.GuardMappingList.add(grdt1a);


        t1.Delay = 0;
        pn.Transitions.add(t1);


        // t2 ------------------------------------------------


        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("H_List_C");



        Condition t2Ct1a = new Condition(t2, "H_List_C", TransitionCondition.HaveListTrain_History);
        Condition t2Ct2a = new Condition(t2, "H_List_C", TransitionCondition.CheckTime_Before);

        t2Ct1a.SetNextCondition(LogicConnector.AND, t2Ct2a);

        GuardMapping grdt2a = new GuardMapping();
        grdt2a.condition = t2Ct2a;
        grdt2a.Activations.add(new Activation(t2, "H_List_C", TransitionOperation.Move, "H_List_C"));
        t2.GuardMappingList.add(grdt2a);



        Condition t2Ct1b = new Condition(t2, "H_List_C", TransitionCondition.HaveListTrain_History);
        Condition t2Ct2b= new Condition(t2, "H_List_C", TransitionCondition.CheckTime_After);

        t2Ct1b.SetNextCondition(LogicConnector.AND, t2Ct2b);

        GuardMapping grdt2b = new GuardMapping();
        grdt2b.condition = t2Ct2b;
        grdt2b.Activations.add(new Activation(t2,"H_List_C", "filePath", TransitionOperation.SaveAndDelete, "H_List_C"));
        t2.GuardMappingList.add(grdt2b);

        t2.Delay = 0;
        pn.Transitions.add(t2);


        // T3 ------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "t3";
        t3.InputPlaceName.add("List_C");

        Condition t3Ct1a = new Condition(t3, "List_C", TransitionCondition.NotNull); //HaveListTrain
        Condition t3Ct2a = new Condition(t3,"List_C", TransitionCondition.Platform_To_Send, "C1");

        t3Ct1a.SetNextCondition(LogicConnector.AND, t3Ct2a);

        GuardMapping grdt3a = new GuardMapping();
        grdt3a.condition = t3Ct1a;
        grdt3a.Activations.add(new Activation(t3, "List_C", TransitionOperation.SendTrainOverNetwork, "T1_C"));
        grdt3a.Activations.add(new Activation(t3, "List_C", TransitionOperation.SendOverNetwork, "Time1_C"));
        grdt3a.Activations.add(new Activation(t3, "List_C", TransitionOperation.MakeNull, "List_C"));
        t3.GuardMappingList.add(grdt3a);


        Condition t3Ct1b = new Condition(t3, "List_C", TransitionCondition.NotNull);
        Condition t3Ct2b = new Condition(t3, "List_C", TransitionCondition.Platform_To_Send, "C2");

        t3Ct1b.SetNextCondition(LogicConnector.AND, t3Ct2b);

        GuardMapping grdt3b = new GuardMapping();
        grdt3b.condition = t3Ct1b;
        grdt3b.Activations.add(new Activation(t3, "List_C", TransitionOperation.SendTrainOverNetwork, "T2_C"));
        grdt3b.Activations.add(new Activation(t3, "List_C", TransitionOperation.SendOverNetwork, "Time2_C"));
        grdt3b.Activations.add(new Activation(t3, "List_C", TransitionOperation.MakeNull, "List_C"));
        t3.GuardMappingList.add(grdt3b);



        Condition t3Ct1c = new Condition(t3, "List_C", TransitionCondition.NotNull);
        Condition t3Ct2c = new Condition(t3,"List_C", TransitionCondition.Platform_To_Send, "C3");

        t3Ct1c.SetNextCondition(LogicConnector.AND, t3Ct2c);

        GuardMapping grdt3c = new GuardMapping();
        grdt3c.condition = t3Ct1c;
        grdt3c.Activations.add(new Activation(t3, "List_C", TransitionOperation.SendTrainOverNetwork, "T3_C"));
        grdt3c.Activations.add(new Activation(t3, "List_C", TransitionOperation.SendOverNetwork, "Time3_C"));
        grdt3c.Activations.add(new Activation(t3, "List_C", TransitionOperation.MakeNull, "List_C"));
        t3.GuardMappingList.add(grdt3c);


        t3.Delay = 0;
        pn.Transitions.add(t3);


        System.out.println("Supervisor C started \n ------------------------------");
        pn.Delay = 3000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.setTitle("Supervisor C");
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
