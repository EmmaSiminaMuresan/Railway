package THESIS.Supervisors;

import Components.*;
import DataObjects.*;
import DataOnly.ListTrains;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

import java.util.ArrayList;

public class Supervisor_A {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Supervisor A";

        pn.NetworkPort = 1080;

        DataTrain p1 = new DataTrain();
        p1.SetName("Train_A");
        pn.PlaceList.add(p1);

        DataString p2 = new DataString();
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
        ArrayList<String> InPutPlaceNames = new ArrayList<String>();
        InPutPlaceNames.add("Train_A");
        InPutPlaceNames.add("Dep_Time_A");
        InPutPlaceNames.add("Platform_A");

        Condition t0Ct1 = new Condition(t0, "Train_A", TransitionCondition.NotNull);
        Condition t0Ct2 = new Condition(t0, "Dep_Time_A", TransitionCondition.NotNull);
        Condition t0Ct3 = new Condition(t0, "Platform_A", TransitionCondition.NotNull);

        t0Ct1.SetNextCondition(LogicConnector.AND, t0Ct2);
        t0Ct1.SetNextCondition(LogicConnector.AND, t0Ct3);

        ListTrains train = new ListTrains(p1.Value,p2.Value,p3.Value);
        p4.SetValue(train);

        GuardMapping grdt0 = new GuardMapping();
        grdt0.condition = t0Ct1;
        grdt0.Activations.add(new Activation(t0,InPutPlaceNames , TransitionOperation.AddElement, "D_Train_A"));
        t0.GuardMappingList.add(grdt0);


        t0.Delay = 0;
        pn.Transitions.add(t0);

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("D_Train_A");

        Condition t1Ct1 = new Condition(t1, "D_Train_A", TransitionCondition.NotNull);
        Condition t1Ct2 = new Condition(t1, "List_A", TransitionCondition.CanAddTrains_List);
        t1Ct1.SetNextCondition(LogicConnector.AND, t1Ct2);

        GuardMapping grdt1 = new GuardMapping();
        grdt1.condition = t1Ct1;
        grdt1.Activations.add(new Activation(t1, "D_Train_A", TransitionOperation.AddElement, "List_A"));
        t1.GuardMappingList.add(grdt1);

        t1.Delay = 0;
        pn.Transitions.add(t1);

        // T2 ------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("List_A");

        Condition t2Ct1 = new Condition(t2, "D_Train_A", TransitionCondition.HaveListTrainForMe);
        Condition t2Ct2 = new Condition(t2, "List_A", TransitionCondition.CanAddTrains_List);
        t2Ct1.SetNextCondition(LogicConnector.AND, t2Ct2);

        GuardMapping grdt2 = new GuardMapping();
        grdt2.condition = t2Ct1;
        grdt2.Activations.add(new Activation(t2, "D_Train_A", TransitionOperation.AddElement, "List_A"));
        t2.GuardMappingList.add(grdt2);

        t2.Delay = 0;
        pn.Transitions.add(t2);

    }
}
