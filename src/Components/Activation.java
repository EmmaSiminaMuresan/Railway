package Components;

import java.io.Serializable;
import java.util.ArrayList;

import DataObjects.*;
import DataOnly.*;
import Enumerations.TransitionOperation;
import Interfaces.PetriObject;
import Utilities.Functions;

public class Activation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PetriTransition Parent;

	public String InputPlaceName;
	public ArrayList<String> InputPlaceNames;
	ArrayList<PetriObject> InputPlaces;
	public String OutputPlaceName;
	public ArrayList<String> OutputPlaceNames;
	public TransitionOperation Operation;
	public Functions util;

	String TrainPlaceName ;
	String  dep_timePlaceName;
	String dep_platformPlaceName;
	String DataListTrainsHistoryPlaceName ;
	String length1PlaceName;
	String length2PlaceName;
	String length3PlaceName;
	String length4PlaceName;


	String speedPlaceName;
	String  DataListTrainsPlaceName;
	String C_TimePlaceName;
	String TimePlaceName;
	String C_PlatformPlaceName;
	String list_trainPlaceName;
	String old_historyPlaceName;
	String new_historyPlaceName;
	String filePathPlaceName;
	String secondsPlaceName;
	String ControllerPlaceName;

	public DataTrain T;
	public DataLocalTime Dep_Time;
	public DataString Dep_Platform;
	public DataLocalTime C_Time;
	public DataString C_Platform;
	public DataListTrainsHistory list;
	public DataInteger length1;
	public DataInteger length2;
	public DataInteger length3;

	public DataInteger speed;
	public DataListTrains list_train;
	public DataListTrains list_queue_in;
	public DataListTrainsHistory old_history;
	public DataString filePath;

	public DataListTrains time;
	public DataInteger seconds;
	public DataString Controller;


	public Activation(PetriTransition Parent) {
		util = new Functions();
	}

	public Activation(PetriTransition Parent, String InputPlaceName, TransitionOperation Condition,
			String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
	}

	public Activation(PetriTransition Parent, String InputPlaceName, TransitionOperation Condition,
					  ArrayList<String> OutputPlaceNames) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceNames = OutputPlaceNames;
		this.Operation = Condition;
	}



	public Activation(PetriTransition Parent, ArrayList<String> InputPlaceNames, TransitionOperation Condition,
					  String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceNames = InputPlaceNames;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
	}

	public Activation(PetriTransition Parent, String secondsPlaceName, String controllerPlaceName, TransitionOperation Condition) {
		util = new Functions();
		this.Parent = Parent;
		this.secondsPlaceName = secondsPlaceName;
		this.ControllerPlaceName = controllerPlaceName;
		this.Operation = Condition;
	}

	public Activation(PetriTransition Parent, String old_historyPlaceName, String filePathPlaceName, TransitionOperation Condition,
					  String new_historyPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.old_historyPlaceName = old_historyPlaceName;
		this.filePathPlaceName = filePathPlaceName;
		this.new_historyPlaceName = new_historyPlaceName;
		this.Operation = Condition;
	}

	public Activation(PetriTransition Parent, String list_trainPlaceName, TransitionOperation Condition) {
		util = new Functions();
		this.Parent = Parent;
		this.list_trainPlaceName = list_trainPlaceName;
		this.Operation = Condition;
	}


//	public Activation(PetriTransition Parent, String list_queue_in,  TransitionOperation Condition,
//					  String list_queue_out) {
//		util = new Functions();
//		this.Parent = Parent;
//		this.list_queue_in = list_queue_in;
//		this.list_queue_out = list_queue_out;
//		this.Operation = Condition;
//
//	}

	public Activation(PetriTransition Parent, String trainPlaceName,  String length1PlaceName, String length2PlaceName,  String speedPlaceName, TransitionOperation Condition,
					  String timePlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.TrainPlaceName = trainPlaceName;
		this.length1PlaceName = length1PlaceName;
		this.length2PlaceName = length2PlaceName;
		this.speedPlaceName = speedPlaceName;
		this.TimePlaceName = timePlaceName;
		this.Operation = Condition;
	}

//	public Activation(PetriTransition Parent,String train,  String speed, TransitionOperation Condition,
//					  String time) {
//		util = new Functions();
//		this.Parent = Parent;
//		this.T = train;
//		this.speed = speed;
//		this.seconds = time;
//		this.Operation = Condition;
//	}

//	public Activation(PetriTransition Parent, String time, TransitionOperation Condition,
//					  String seconds) {
//		util = new Functions();
//		this.Parent = Parent;
//		this.time = time;
//		this.seconds = seconds;
//		this.Operation = Condition;
//	}

	public Activation(PetriTransition Parent,
					  String trainPlaceName,
					  String dep_timePlaceName,
					  String dep_platformPlaceName,
					  String c_timePlaceName,
					  String c_platformPlaceName,
					  String length1PlaceName,
					  String length2PlaceName,
					  String speedPlaceName,
					  TransitionOperation Condition,
					  String list_trainPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.list_trainPlaceName = list_trainPlaceName;
		this.Operation = Condition;
		this.TrainPlaceName = trainPlaceName;
		this.dep_timePlaceName = dep_timePlaceName;
		this.dep_platformPlaceName = dep_platformPlaceName;
		this.C_TimePlaceName = c_timePlaceName;
		this.C_PlatformPlaceName = c_platformPlaceName;
		this.length1PlaceName = length1PlaceName;
		this.length2PlaceName = length2PlaceName;
		this.speedPlaceName = speedPlaceName;
	}

//	public Activation(PetriTransition Parent, DataTrain train, DataLocalTime dep_time, DataString dep_platform, DataListTrainsHistory list, DataInteger length1, DataInteger length2,  DataInteger speed, TransitionOperation Condition,
//					  DataListTrains list_train) {
//		util = new Functions();
//		this.Parent = Parent;
//		this.list_train = list_train;
//		this.Operation = Condition;
//		this.T = train;
//		this.Dep_Time = dep_time;
//		this.Dep_Platform = dep_platform;
//		this.list = list;
//		this.length1 = length1;
//		this.length2 = length2;
//		this.speed = speed;
//	}

	public Activation(PetriTransition Parent,
					  String TrainPlaceName ,
					  String  dep_timePlaceName,
					  String dep_platformPlaceName,
					  String DataListTrainsHistoryPlaceName ,
					  String length1PlaceName,
					  String length2PlaceName,
					  String length3PlaceName,
					  String length4PlaceName,
					  String speedPlaceName,
					  TransitionOperation Condition,
					  String  DataListTrainsPlaceName ) {
		util = new Functions();
		this.Parent = Parent;
		this.TrainPlaceName = TrainPlaceName;
		this.Operation = Condition;
		this.dep_timePlaceName= dep_timePlaceName;
		this.dep_platformPlaceName = dep_platformPlaceName;
		this.DataListTrainsHistoryPlaceName = DataListTrainsHistoryPlaceName;
		this.length1PlaceName = length1PlaceName;
		this.length2PlaceName = length2PlaceName;
		this.length3PlaceName = length3PlaceName;
		this.length4PlaceName = length4PlaceName;
		this.speedPlaceName = speedPlaceName;
		this.DataListTrainsPlaceName=DataListTrainsPlaceName;
	}


	
	public void Activate() throws CloneNotSupportedException {
//		if (Operation == TransitionOperation.PopElement_Train)
//			PopElement_Train();

//		if (Operation == TransitionOperation.DoNothing)
//			return;

		if (Operation == TransitionOperation.CalculateDelay)
			CalculateDelay();

		if (Operation == TransitionOperation.SendTrainOverNetwork)
			SendTrainOverNetwork();

		if (Operation == TransitionOperation.MessageBox_SupervisorA)
			MessageBox_SupervisorA();

		if (Operation == TransitionOperation.MessageBox_SupervisorB)
			MessageBox_SupervisorB();

		if (Operation == TransitionOperation.MessageBox_SupervisorC)
			MessageBox_SupervisorC();

		if (Operation == TransitionOperation.MessageBox_Controllers)
			MessageBox_Controllers();

		if (Operation == TransitionOperation.CalculateLightTimeRailway)
			CalculateLightTimeRailway();

		if (Operation == TransitionOperation.CalculateLightTimeStation)
			CalculateLightTimeStation();

		if (Operation == TransitionOperation.CalculateTime)
			CalculateTime();

		if (Operation == TransitionOperation.SaveAndDelete)
			SaveAndDelete();

//		if (Operation == TransitionOperation.RemoveFirst)
//			RemoveFirst();

		if (Operation == TransitionOperation.CreateTrain_Null)
			CreateTrain_Null();

		if (Operation == TransitionOperation.CreateTrain_NotNull)
			CreateTrain_NotNull();

		if (Operation == TransitionOperation.Move)
			Move();

		if (Operation == TransitionOperation.Copy)
			Copy();

		if (Operation == TransitionOperation.Add)
			Add();

		if (Operation == TransitionOperation.Prod)
			Prod();

		if (Operation == TransitionOperation.Sub)
			Sub();

		if (Operation == TransitionOperation.Div)
			Div();

		if (Operation == TransitionOperation.AddElement)
			AddElement();

		if (Operation == TransitionOperation.PopElementWithTarget)
			PopElementWithTarget();

		if (Operation == TransitionOperation.PopElement_R_E)
			PopElement_R_E();

		if (Operation == TransitionOperation.DynamicDelay)
			DynamicDelay();

		if (Operation == TransitionOperation.PopElementWithTargetToQueue)
			PopElementWithTargetToQueue();

		if (Operation == TransitionOperation.PopElementWithoutTarget)
			PopElementWithoutTarget();

		if (Operation == TransitionOperation.PopElementWithoutTargetToQueue)
			PopElementWithoutTargetToQueue();

		if (Operation == TransitionOperation.SendOverNetwork)
			SendOverNetwork();

		if (Operation == TransitionOperation.SendROverNetwork)
			SendROverNetwork();

		if (Operation == TransitionOperation.SendPetriNetOverNetwork)
			SendPetriNetOverNetwork();

		if (Operation == TransitionOperation.ActivateSubPetri)
			ActivateSubPetri();

		if (Operation == TransitionOperation.StopPetriNet)
			Parent.Parent.Stop();

		if (Operation == TransitionOperation.MakeNull)
			MakeNull();
		// -------------FloatFloat Modifications--------------------
		if (Operation == TransitionOperation.Add_FloatFlaot)
			Add_FloatFlaot();
		if (Operation == TransitionOperation.Sub_FloatFloat)
			Sub_FloatFlaot();
		if (Operation == TransitionOperation.Prod_FloatFloat)
			Prod_FloatFloat();
		if (Operation == TransitionOperation.Div_FloatFloat)
			Div_FloatFlaot();
		// ---------------------------------------------------------
	}
//	private void PopElement_Train() throws CloneNotSupportedException {
//
//		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
//		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.Parent.PlaceList);
//
//		DataTrain temp = ((ListTrainsQueue) ((DataListTrains) Parent.Parent.PlaceList.get(inputIndex)).GetValue()).PopTrains();
//
//		PetriObject result = util.GetPetriObjectByName(OutputPlaceName, Parent.Parent.PlaceList);
//
//		if (temp != null) {
//			result.SetValue(temp.Value);
//
//			Parent.Parent.PlaceList.set(outputIndex, result);
//		}
//	}
	private void CalculateDelay() throws CloneNotSupportedException{
		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList); // ???

		DataInteger result;
		seconds = (DataInteger)util.GetFromListByName(InputPlaceName, Parent.Parent.PlaceList); // or Parent.PlaceList??

		result = util.Calculate_Delay(seconds.Value);
		result.SetName(OutputPlaceName);
		Parent.Parent.PlaceList.set(outputIndex, result);
	}
	private void MessageBox_SupervisorA() throws CloneNotSupportedException{
		// the correct way to get the required data using the name
		list_train= (DataListTrains) util.GetFromListByName(list_trainPlaceName, Parent.Parent.PlaceList);
		util.MessageBox_SupervisorA(list_train);
	}
	private void MessageBox_SupervisorB() throws CloneNotSupportedException{
		list_train= (DataListTrains) util.GetFromListByName(list_trainPlaceName, Parent.Parent.PlaceList);
		util.MessageBox_SupervisorB(list_train);
	}
	private void MessageBox_SupervisorC() throws CloneNotSupportedException{
		list_train= (DataListTrains) util.GetFromListByName(list_trainPlaceName, Parent.Parent.PlaceList);
		util.MessageBox_SupervisorC(list_train);
	}
	private void MessageBox_Controllers() throws CloneNotSupportedException{
		seconds = (DataInteger) util.GetFromListByName(list_trainPlaceName, Parent.Parent.PlaceList);
		//Controller = (DataString) util.GetFromListByName(ControllerPlaceName, Parent.Parent.PlaceList);
		util.MessageBox_Controllers(seconds);
	}
	private void CalculateLightTimeStation() throws CloneNotSupportedException{
		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList); // ???

		DataInteger result;
		time = (DataListTrains)util.GetFromListByName(InputPlaceName, Parent.TempMarking); // or Parent.PlaceList??

		result = util.Calculate_Light_Time_Station(time);
		result.SetName(OutputPlaceName);
		Parent.Parent.PlaceList.set(outputIndex, result);
	}
	private void CalculateLightTimeRailway() throws CloneNotSupportedException{
		Integer outputIndex = util.GetIndexByName(new_historyPlaceName, Parent.Parent.PlaceList); // ???


		DataInteger result;
		T = (DataTrain)util.GetFromListByName(old_historyPlaceName, Parent.TempMarking);
		speed = (DataInteger)util.GetFromListByName(filePathPlaceName, Parent.TempMarking);
		result = util.Calculate_Light_Time_Railway(T.GetLength(),speed.Value);

		result.SetName(new_historyPlaceName);
		Parent.Parent.PlaceList.set(outputIndex, result);  /// constant place list? maybe.
	}

//	private void CalculateLightTimeRailway() throws CloneNotSupportedException {
//		Integer outputIndex = util.GetIndexByName(secondsPlaceName, Parent.Parent.PlaceList);
//
//		DataInteger result;
//		DataTrain T = (DataTrain) util.GetFromListByName(old_historyPlaceName, Parent.TempMarking);
//		DataInteger speed = (DataInteger) util.GetFromListByName("in7_2", Parent.Parent.PlaceList);
//
//		if (T == null) {
//			System.out.println("Error: Train data (T) is null.");
//		} else {
//			System.out.println("Train length: " + T.GetLength());
//		}
//
//		if (speed == null) {
//			System.out.println("Error: Speed data (in7_2) is null.");
//		} else {
//			System.out.println("Speed value: " + speed.GetValue());
//		}
//
//		if (T != null && speed != null) {
//			result = util.Calculate_Light_Time_Railway(T.GetLength(), speed.Value);
//			result.SetName(secondsPlaceName);
//			Parent.Parent.PlaceList.set(outputIndex, result);
//			System.out.println("Calculated light time: " + result.GetValue());
//		}
//	}


	private void CalculateTime() throws CloneNotSupportedException{
		Integer outputIndex = util.GetIndexByName(TimePlaceName, Parent.Parent.ConstantPlaceList); // ???

		DataLocalTime result;
		T = (DataTrain)util.GetFromListByName(TrainPlaceName, Parent.TempMarking);
		length1 = (DataInteger)util.GetFromListByName(length1PlaceName, Parent.Parent.ConstantPlaceList);
		length2 = (DataInteger)util.GetFromListByName(length2PlaceName, Parent.Parent.ConstantPlaceList);
		speed = (DataInteger)util.GetFromListByName(speedPlaceName, Parent.Parent.ConstantPlaceList);
		result = util.Calculate_Time(T,length1,length2,speed);

		result.SetName(TimePlaceName);
		Parent.Parent.PlaceList.set(outputIndex, result);

	}
	private void SaveAndDelete() throws CloneNotSupportedException{
		Integer outputIndex = util.GetIndexByName(new_historyPlaceName, Parent.Parent.PlaceList); // ???

		DataListTrainsHistory result;
		old_history = (DataListTrainsHistory) util.GetFromListByName(old_historyPlaceName, Parent.Parent.PlaceList);
		filePath = (DataString) util.GetFromListByName(filePathPlaceName, Parent.Parent.ConstantPlaceList);;
		result = util.Save_And_Delete(old_history,filePath);

		result.SetName(new_historyPlaceName);
		Parent.Parent.PlaceList.set(outputIndex, result);
	}
//	private void RemoveFirst() throws CloneNotSupportedException{
//		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList); // ???
//
//		DataListTrains result;
//		list_queue_in = (DataListTrains) util.GetFromListByName(InputPlaceName, Parent.Parent.PlaceList);;
//		result = util.Remove_First(list_queue_in);
//
//		result.SetName(OutputPlaceName);
//		Parent.Parent.PlaceList.set(outputIndex, result);
//	}

	private void CreateTrain_Null() throws CloneNotSupportedException{

		Integer outputIndex = util.GetIndexByName(DataListTrainsPlaceName, Parent.Parent.PlaceList);

		// example to understand how things works
//		PetriObject tt = util.GetFromListByName("Train_A", Parent.TempMarking);
//		PetriObject tttt = util.GetFromListByName(Parent.InputPlaceName.get(0), Parent.TempMarking);

		// if you have the data place names comes from constructor you can use them according to the source
		// will get some from constants and others from tempMarkings
		T = (DataTrain)util.GetFromListByName(TrainPlaceName, Parent.TempMarking);
		Dep_Time=(DataLocalTime)util.GetFromListByName(dep_timePlaceName, Parent.TempMarking);
		Dep_Platform = (DataString)util.GetFromListByName(dep_platformPlaceName, Parent.TempMarking);
		speed = (DataInteger)util.GetFromListByName(speedPlaceName, Parent.Parent.ConstantPlaceList);
		length1 = (DataInteger)util.GetFromListByName(length1PlaceName, Parent.Parent.ConstantPlaceList);
		length2 = (DataInteger)util.GetFromListByName(length2PlaceName, Parent.Parent.ConstantPlaceList);
		length3 = (DataInteger)util.GetFromListByName(length3PlaceName, Parent.Parent.ConstantPlaceList);

		if(DataListTrainsHistoryPlaceName!=null) list = (DataListTrainsHistory)util.GetFromListByName(DataListTrainsHistoryPlaceName,Parent.TempMarking);
		else list = null;

		DataListTrains methodResult= util.Create_Train_Null(T,Dep_Time,Dep_Platform,list, length1,  length2,length3, speed);
		methodResult.SetName(DataListTrainsPlaceName);
		Parent.Parent.PlaceList.set(outputIndex, methodResult);
	}
	private void CreateTrain_NotNull() throws CloneNotSupportedException{
		Integer outputIndex = util.GetIndexByName(DataListTrainsPlaceName, Parent.Parent.PlaceList);

		DataListTrains result;
		T = (DataTrain)util.GetFromListByName(TrainPlaceName, Parent.TempMarking);
		Dep_Time=(DataLocalTime)util.GetFromListByName(dep_timePlaceName, Parent.TempMarking);
		Dep_Platform = (DataString)util.GetFromListByName(dep_platformPlaceName, Parent.TempMarking);
		C_Time = (DataLocalTime) util.GetFromListByName(C_TimePlaceName, Parent.TempMarking); ///////////// ????
		C_Platform = (DataString) util.GetFromListByName(C_PlatformPlaceName, Parent.TempMarking); ///////////// ????
		speed = (DataInteger)util.GetFromListByName(speedPlaceName, Parent.Parent.ConstantPlaceList);
		length1 = (DataInteger)util.GetFromListByName(length1PlaceName, Parent.Parent.ConstantPlaceList);
		length2 = (DataInteger)util.GetFromListByName(length2PlaceName, Parent.Parent.ConstantPlaceList);

		result = util.Create_Train_NotNull(T,Dep_Time,Dep_Platform,C_Time, C_Platform, length1,  length2, speed);

		result.SetName(DataListTrainsPlaceName);
		Parent.Parent.PlaceList.set(outputIndex, result);
	}

	private void SendTrainOverNetwork() throws CloneNotSupportedException {

		PetriObject output = util.GetPetriObjectByName(OutputPlaceName, Parent.Parent.PlaceList);
		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.TempMarking);

		PetriObject result = null;

		if (output instanceof DataTransfer) {
			result = (PetriObject) ((DataTransfer) output).clone();
		}

		if (inputIndex == -1)
			return;

		DataListTrains temp = (DataListTrains) Parent.TempMarking.get(inputIndex);

		DataTrain toSend = new DataTrain();
		toSend.SetName(OutputPlaceName);
		toSend.SetValue(temp.Value.getTrain());

		result.SetValue((PetriObject) (toSend).clone());

	}
	private void MakeNull() throws CloneNotSupportedException {
		PetriObject temp = util.GetFromListByName(OutputPlaceName, Parent.Parent.PlaceList);
		if (temp == null) {
			util.SetNullToListByName(OutputPlaceName, Parent.Parent.ConstantPlaceList);
		} else {
			util.SetNullToListByName(OutputPlaceName, Parent.Parent.PlaceList);
		}
	}


	private void Move() throws CloneNotSupportedException {

		PetriObject temp = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (temp == null) {
			temp = util.GetFromListByName(InputPlaceName, Parent.Parent.ConstantPlaceList);
		}
		PetriObject result = null;



		if (temp instanceof DataFloat) {
			result = (PetriObject) ((DataFloat) temp).clone();
		}

		if (temp instanceof DataInteger) {
			result = (PetriObject) ((DataInteger) temp).clone();
		}

		if (temp instanceof DataLocalTime) {
			result = (PetriObject) ((DataLocalTime) temp).clone();
		}

		if (temp instanceof DataTrain) {
			result = (PetriObject) ((DataTrain) temp).clone();
		}

		if (temp instanceof DataListTrains) {
			result = (PetriObject) ((DataListTrains) temp).clone();
		}

		if (temp instanceof DataListTrainsHistory) {
			result = (PetriObject) ((DataListTrainsHistory) temp).clone();
		}

		if (temp instanceof DataString) {
			result = (PetriObject) ((DataString) temp).clone();
		}

		if (temp instanceof DataCar) {
			result = (PetriObject) ((DataCar) temp).clone();
		}

		if (temp instanceof DataSubPetriNet) {
			result = (PetriObject) ((DataSubPetriNet) temp).clone();
		}

		// --------------------DataFloatFloat modification--------------
		if (temp instanceof DataFloatFloat) {
			result = (PetriObject) ((DataFloatFloat) temp).clone();
		}
		// -------------------------------------------------------------

		if (result == null) {
			return;
		}

		if (OutputPlaceName.contains("-")) {
			result.SetName(OutputPlaceName.split("-")[1]);
		} else {
			result.SetName(OutputPlaceName);
		}

		result.SetValue(temp.GetValue());

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void Copy() throws CloneNotSupportedException {

		PetriObject temp = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (temp == null) {
			temp = util.GetFromListByName(InputPlaceName, Parent.Parent.ConstantPlaceList);
		}
		PetriObject result = null;
		PetriObject resultBack = null;

		if (temp instanceof DataLocalTime) {
			result = (PetriObject) ((DataLocalTime) temp).clone();
			resultBack = (PetriObject) ((DataLocalTime) temp).clone();
		}

		if (temp instanceof DataListTrains) {
			result = (PetriObject) ((DataListTrains) temp).clone();
			resultBack = (PetriObject) ((DataListTrains) temp).clone();
		}


		if (temp instanceof DataListTrainsHistory) {
			result = (PetriObject) ((DataListTrainsHistory) temp).clone();
			resultBack = (PetriObject) ((DataListTrainsHistory) temp).clone();
		}

		if (temp instanceof DataTrain) {
			result = (PetriObject) ((DataTrain) temp).clone();
			resultBack = (PetriObject) ((DataTrain) temp).clone();
		}

		if (temp instanceof DataFloat) {
			result = (PetriObject) ((DataFloat) temp).clone();
			resultBack = (PetriObject) ((DataFloat) temp).clone();
		}

		if (temp instanceof DataInteger) {
			result = (PetriObject) ((DataInteger) temp).clone();
			resultBack = (PetriObject) ((DataInteger) temp).clone();
		}

		if (temp instanceof DataString) {
			result = (PetriObject) ((DataString) temp).clone();
			resultBack = (PetriObject) ((DataString) temp).clone();
		}

		if (temp instanceof DataCar) {
			result = (PetriObject) ((DataCar) temp).clone();
			resultBack = (PetriObject) ((DataCar) temp).clone();
		}

		if (temp instanceof DataSubPetriNet) {
			result = (PetriObject) ((DataSubPetriNet) temp).clone();
			resultBack = (PetriObject) ((DataSubPetriNet) temp).clone();
		}

		if (result == null) {
			return;
		}

		if (OutputPlaceName.contains("-")) {
			result.SetName(OutputPlaceName.split("-")[1]);
		} else {
			result.SetName(OutputPlaceName);
		}

		result.SetValue(temp.GetValue());

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);

		if (InputPlaceName.contains("-")) {

		} else {
			util.SetToListByName(InputPlaceName, Parent.Parent.PlaceList, resultBack);
		}
	}


	private void Add() throws CloneNotSupportedException {
		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
		PetriObject result = null;

		for (String placeName : InputPlaceNames) {
			PetriObject temp;
			Integer inputIndex = util.GetIndexByName(placeName, Parent.TempMarking);
			if (inputIndex == -1) {
				temp = util.GetFromListByName(placeName, Parent.Parent.ConstantPlaceList);
			} else {
				temp = Parent.TempMarking.get(inputIndex);
			}

			if (temp == null) {
				continue;
			}

			if (temp instanceof DataFloat) {
				if (result == null) {
					result = (PetriObject) ((DataFloat) temp).clone();
				} else {
					result.SetValue((float) result.GetValue() + (float) temp.GetValue());
				}
			}

			if (temp instanceof DataInteger) {
				if (result == null) {
					result = (PetriObject) ((DataInteger) temp).clone();
				} else {
					result.SetValue((Integer) result.GetValue() + (Integer) temp.GetValue());
				}
			}
		}
		result.SetName(OutputPlaceName);
		Parent.Parent.PlaceList.set(outputIndex, result);
	}

	private void Prod() throws CloneNotSupportedException {
		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
		PetriObject result = null;

		for (String placeName : InputPlaceNames) {
			PetriObject temp;
			Integer inputIndex = util.GetIndexByName(placeName, Parent.TempMarking);
			if (inputIndex == -1) {
				temp = util.GetFromListByName(placeName, Parent.Parent.ConstantPlaceList);
			} else {
				temp = Parent.TempMarking.get(inputIndex);
			}

			if (temp == null) {
				continue;
			}

//			Integer inputIndex = util.GetIndexByName(placeName, Parent.TempMarking);
//			if (inputIndex == -1)
//				continue;
//
//			PetriObject temp = Parent.TempMarking.get(inputIndex);

			if (temp instanceof DataFloat) {
				if (result == null) {
					result = (PetriObject) ((DataFloat) temp).clone();
				} else {
					result.SetValue((float) result.GetValue() * (float) temp.GetValue());
				}
			}

			if (temp instanceof DataInteger) {
				if (result == null) {
					result = (PetriObject) ((DataInteger) temp).clone();
				} else {
					result.SetValue((Integer) result.GetValue() * (Integer) temp.GetValue());
				}
			}
		}
		result.SetName(OutputPlaceName);
		Parent.Parent.PlaceList.set(outputIndex, result);
	}

	private void Sub() throws CloneNotSupportedException {
		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
		PetriObject result = null;

		for (String placeName : InputPlaceNames) {
			PetriObject temp;
			Integer inputIndex = util.GetIndexByName(placeName, Parent.TempMarking);
			if (inputIndex == -1) {
				temp = util.GetFromListByName(placeName, Parent.Parent.ConstantPlaceList);
			} else {
				temp = Parent.TempMarking.get(inputIndex);
			}

			if (temp == null) {
				continue;
			}

			if (temp instanceof DataFloat) {
				if (result == null) {
					result = (PetriObject) ((DataFloat) temp).clone();
				} else {
					result.SetValue((float) result.GetValue() - (float) temp.GetValue());
				}
			}

			if (temp instanceof DataInteger) {
				if (result == null) {
					result = (PetriObject) ((DataInteger) temp).clone();
				} else {
					result.SetValue((Integer) result.GetValue() - (Integer) temp.GetValue());
				}
			}
		}
		result.SetName(OutputPlaceName);
		Parent.Parent.PlaceList.set(outputIndex, result);
	}

	private void Div() throws CloneNotSupportedException {
		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
		PetriObject result = null;

		for (String placeName : InputPlaceNames) {
			PetriObject temp;
			Integer inputIndex = util.GetIndexByName(placeName, Parent.TempMarking);
			if (inputIndex == -1) {
				temp = util.GetFromListByName(placeName, Parent.Parent.ConstantPlaceList);
			} else {
				temp = Parent.TempMarking.get(inputIndex);
			}

			if (temp == null) {
				continue;
			}

//			Integer inputIndex = util.GetIndexByName(placeName, Parent.TempMarking);
//			if (inputIndex == -1)
//				continue;
//
//			PetriObject temp = Parent.TempMarking.get(inputIndex);

			if (temp instanceof DataFloat) {
				if (result == null) {
					result = (PetriObject) ((DataFloat) temp).clone();
				}
				float current = (float) result.GetValue();
				if (current == 0) {
					result.SetValue((float) temp.GetValue());
				} else {
					result.SetValue((float) result.GetValue() / (float) temp.GetValue());
				}
			}

			if (temp instanceof DataInteger) {
				if (result == null) {
					result = (PetriObject) ((DataInteger) temp).clone();
				}
				Integer current = (Integer) result.GetValue();
				if (current == 0) {
					result.SetValue((Integer) temp.GetValue());
				} else {
					result.SetValue((Integer) result.GetValue() / (Integer) temp.GetValue());
				}
			}
		}
		result.SetName(OutputPlaceName);
		Parent.Parent.PlaceList.set(outputIndex, result);
	}

	private void AddElement() throws CloneNotSupportedException {
		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.TempMarking);

		PetriObject temp = Parent.TempMarking.get(inputIndex);

		PetriObject result = null;

		if (temp instanceof DataCar) {
			result = (PetriObject) ((DataCar) temp).clone();
		}

		if (temp instanceof DataREL) {
			result = (PetriObject) ((DataREL) temp).clone();
		}

		if (temp instanceof DataTrain) {
			result = (PetriObject) ((DataTrain) temp).clone();
		}

		if (temp instanceof DataListTrains) {
			result = (PetriObject) ((DataListTrains) temp).clone();
		}

		if (temp instanceof DataListTrainsHistory) {
			result = (PetriObject) ((DataListTrainsHistory) temp).clone();
		}

		if (temp instanceof DataLocalTime) {
			result = (PetriObject) ((DataLocalTime) temp).clone();
		}


		result.SetName(OutputPlaceName);
		result.SetValue(temp.GetValue());

		Parent.Parent.PlaceList.get(outputIndex).AddElement(result);
	}

	private void PopElementWithTarget() throws CloneNotSupportedException {
		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.Parent.PlaceList);
		PetriObject temp = ((CarQueue) ((DataCarQueue) Parent.Parent.PlaceList.get(inputIndex)).GetValue())
				.PopCar(Parent.TransitionName);

		PetriObject result = null;

		if (temp instanceof DataCar) {
			result = (PetriObject) ((DataCar) temp).clone();
		}

		if (temp instanceof DataTrain) {
			result = (PetriObject) ((DataTrain) temp).clone();
		}

		if (temp instanceof DataListTrains) {
			result = (PetriObject) ((DataListTrains) temp).clone();
		}

		if (temp instanceof DataListTrainsHistory) {
			result = (PetriObject) ((DataListTrainsHistory) temp).clone();
		}



		result.SetName(OutputPlaceName);
		result.SetValue(temp.GetValue());

		Parent.Parent.PlaceList.set(outputIndex, result);
	}

	private void PopElement_R_E() throws CloneNotSupportedException {

		Integer outputIndexR = util.GetIndexByName(OutputPlaceNames.get(0), Parent.Parent.PlaceList);
		Integer outputIndexE = util.GetIndexByName(OutputPlaceNames.get(1), Parent.Parent.PlaceList);
		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.Parent.PlaceList);

		DataREL temp = ((RELQueue) ((DataRELQueue) Parent.Parent.PlaceList.get(inputIndex)).GetValue()).PopREL();

		PetriObject resultR = util.GetPetriObjectByName(OutputPlaceNames.get(0), Parent.Parent.PlaceList);
		PetriObject resultE = util.GetPetriObjectByName(OutputPlaceNames.get(1), Parent.Parent.PlaceList);

		if (temp != null) {
			resultR.SetValue(temp.Value.R);
			resultE.SetValue(temp.Value.E);

			Parent.Delay = temp.Value.E;
			Parent.Parent.PlaceList.set(outputIndexR, resultR);
			Parent.Parent.PlaceList.set(outputIndexE, resultE);
		}
	}

	private void PopElementWithTargetToQueue() throws CloneNotSupportedException {

		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.Parent.PlaceList);
		PetriObject temp = ((CarQueue) ((DataCarQueue) Parent.Parent.PlaceList.get(inputIndex)).GetValue())
				.PopCar(Parent.TransitionName);

		PetriObject result = null;

		if (temp instanceof DataCar) {
			result = (PetriObject) ((DataCar) temp).clone();
		}

		result.SetName(OutputPlaceName);
		result.SetValue(temp.GetValue());

		DataCarQueue out = (DataCarQueue) (Parent.Parent.PlaceList.get(outputIndex));
		out.AddElement(result);
	}

	private void PopElementWithoutTarget() throws CloneNotSupportedException {

		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.Parent.PlaceList);
		PetriObject temp = ((CarQueue) ((DataCarQueue) Parent.Parent.PlaceList.get(inputIndex)).GetValue())
				.PopCartWithoutTarget();

		PetriObject result = null;

		if (temp == null)
			return;

		if (temp instanceof DataCar) {
			result = (PetriObject) ((DataCar) temp).clone();
		}

		result.SetName(OutputPlaceName);
		result.SetValue(temp.GetValue());

		Parent.Parent.PlaceList.set(outputIndex, result);
	}

	private void PopElementWithoutTargetToQueue() throws CloneNotSupportedException {
		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.Parent.PlaceList);
		PetriObject temp = ((CarQueue) ((DataCarQueue) Parent.Parent.PlaceList.get(inputIndex)).GetValue())
				.PopCartWithoutTarget();

		PetriObject result = null;

		if (temp == null)
			return;

		if (temp instanceof DataCar) {
			result = (PetriObject) ((DataCar) temp).clone();
		}

		result.SetName(OutputPlaceName);
		result.SetValue(temp.GetValue());

		DataCarQueue out = (DataCarQueue) (Parent.Parent.PlaceList.get(outputIndex));
		out.AddElement(result);
	}

	private void SendOverNetwork() throws CloneNotSupportedException {
		PetriObject output = util.GetPetriObjectByName(OutputPlaceName, Parent.Parent.PlaceList);

		PetriObject temp;
		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.TempMarking);
		if (inputIndex == -1) {
			temp = util.GetFromListByName(InputPlaceName, Parent.Parent.ConstantPlaceList);
		} else {
			temp = Parent.TempMarking.get(inputIndex);
		}

		if (temp == null) {
			return;
		}
		PetriObject result = null;
		if (output instanceof DataTransfer) {
			result = (PetriObject) ((DataTransfer) output).clone();
		}
//		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.TempMarking);
//
//
//
//		if (inputIndex == -1)
//			return;
//
//		PetriObject temp = Parent.TempMarking.get(inputIndex);

		if (temp instanceof DataFloat) {
			result.SetValue((PetriObject) ((DataFloat) temp).clone());
		}

		if (temp instanceof DataInteger) {
			result.SetValue((PetriObject) ((DataInteger) temp).clone());
		}

		if (temp instanceof DataString) {
			result.SetValue((PetriObject) ((DataString) temp).clone());
		}

		if (temp instanceof DataCar) {
			result.SetValue((PetriObject) ((DataCar) temp).clone());
		}

		if (temp instanceof DataSubPetriNet) {
			result.SetValue((PetriObject) ((DataSubPetriNet) temp).clone());
		}

		if (temp instanceof DataLocalTime) {
			result.SetValue((PetriObject) ((DataLocalTime) temp).clone());
		}

		if (temp instanceof DataTrain) {
			result.SetValue((PetriObject) ((DataTrain) temp).clone());
		}

		if (temp instanceof DataListTrains) {
			result.SetValue((PetriObject) ((DataListTrains) temp).clone());
		}

		if (temp instanceof DataListTrainsHistory) {
			result.SetValue((PetriObject) ((DataListTrainsHistory) temp).clone());
		}

//		if (temp instanceof DataListTrains) {
//			result.SetValue((PetriObject) ((DataListTrains) temp).clone());
//		}

	}



	private void SendROverNetwork() throws CloneNotSupportedException {

		PetriObject output = util.GetPetriObjectByName(OutputPlaceName, Parent.Parent.PlaceList);
		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.TempMarking);

		PetriObject result = null;

		if (output instanceof DataTransfer) {
			result = (PetriObject) ((DataTransfer) output).clone();
		}

		if (inputIndex == -1)
			return;

		DataRELQueue temp = (DataRELQueue) Parent.TempMarking.get(inputIndex);

		DataInteger toSend = new DataInteger();
		toSend.SetName(OutputPlaceName);
		toSend.SetValue(temp.Value.GetFirstREL().Value.R);

		if (temp.Value.GetFirstREL().Value.R != ((DataInteger) Parent.TempMarking.get(1)).Value) {
			if (toSend instanceof DataInteger) {
				result.SetValue((PetriObject) ((DataInteger) toSend).clone());
			}
		}
	}





//	private void SendTrainOverNetwork() throws CloneNotSupportedException {
//		// Retrieve the output object using the output place name
//		PetriObject output = util.GetPetriObjectByName(OutputPlaceName, Parent.Parent.PlaceList);
//		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.TempMarking);
//
//		PetriObject result = null;
//
//		// Check if the output is a DataTransfer instance, and if so, clone it to result
//		if (output instanceof DataTransfer) {
//			result = (PetriObject) ((DataTransfer) output).clone();
//		}
//
//		// Return if the input index is invalid
//		if (inputIndex == -1)
//			return;
//
//		// Retrieve the DataListTrains object from TempMarking
//		DataListTrains tempQueue = (DataListTrains) Parent.TempMarking.get(inputIndex);
//
//		// Return if the queue is empty
//		if (tempQueue.Value == null) {
//			return;
//		}
//
//		// Get the last added DataListTrains from the queue
//		DataListTrains lastAddedTrain = tempQueue.Value.Trains.get(tempQueue.Value.Trains.size()-1);
//
//		// Prepare the DataTrain object to be sent over the network
//		DataTrain toSend = new DataTrain();
//		toSend.SetName(OutputPlaceName);
//		toSend.SetValue(lastAddedTrain.getTrain());
//
//		// Compare with another train in TempMarking if necessary
//		if (Parent.TempMarking.size() > 1 &&
//				!lastAddedTrain.getTrain().equals(((DataTrain) Parent.TempMarking.get(1)).Value)) {
//
//			// Ensure that the result object is not null before setting its value
//			if (result != null) {
//				result.SetValue((PetriObject) toSend.clone());
//			}
//		} else {
//			// Directly set the train to the result's value if the above condition is not met
//			if (result != null) {
//				result.SetValue(toSend);
//			}
//		}
//
//		// Ensure that the result is stored in the appropriate output place
//		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
//	}



	private void SendPetriNetOverNetwork() throws CloneNotSupportedException {

		PetriObject output = util.GetPetriObjectByName(OutputPlaceName, Parent.Parent.PlaceList);
		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.TempMarking);

		PetriObject result = null;

		if (output instanceof DataTransfer) {
			result = (PetriObject) ((DataTransfer) output).clone();
		}

		if (inputIndex == -1)
			return;

		PetriObject temp = Parent.TempMarking.get(inputIndex);

		if (temp instanceof DataSubPetriNet) {
			PetriObject ob = ((DataSubPetriNet) temp).clone();
			DataSubPetriNet sub = (DataSubPetriNet) ob;
			result.SetValue((PetriObject) util.PetriNetToPetriData(sub.Value.Petri));
		}
	}

	private void ActivateSubPetri() throws CloneNotSupportedException {
		PetriObject temp = util.GetFromListByName(InputPlaceName, Parent.Parent.PlaceList);
		if (temp == null)
			return;

		if (temp instanceof DataSubPetriNet) {
			((DataSubPetriNet) temp).Value.StartSubPetri();
		}
	}

	// -------------FloatFloat Modifications--------------------
	private void Add_FloatFlaot() throws CloneNotSupportedException {
		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
		PetriObject result = null;

		for (String placeName : InputPlaceNames) {
			PetriObject temp;
			Integer inputIndex = util.GetIndexByName(placeName, Parent.TempMarking);
			if (inputIndex == -1) {
				temp = util.GetFromListByName(placeName, Parent.Parent.ConstantPlaceList);
			} else {
				temp = Parent.TempMarking.get(inputIndex);
			}

			if (temp == null) {
				continue;
			}

			if (temp instanceof DataFloatFloat) {
				if (result == null) {
					result = (PetriObject) ((DataFloatFloat) temp).clone();
				} else {
					FloatFloat ff = new FloatFloat(
							((FloatFloat) result.GetValue()).V1 + ((FloatFloat) temp.GetValue()).V1,
							((FloatFloat) result.GetValue()).V2 + ((FloatFloat) temp.GetValue()).V2);
					result.SetValue(ff);
				}
			}

		}
		result.SetName(OutputPlaceName);
		Parent.Parent.PlaceList.set(outputIndex, result);
	}

	private void Sub_FloatFlaot() throws CloneNotSupportedException {
		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
		PetriObject result = null;

		for (String placeName : InputPlaceNames) {
			PetriObject temp;
			Integer inputIndex = util.GetIndexByName(placeName, Parent.TempMarking);
			if (inputIndex == -1) {
				temp = util.GetFromListByName(placeName, Parent.Parent.ConstantPlaceList);
			} else {
				temp = Parent.TempMarking.get(inputIndex);
			}

			if (temp == null) {
				continue;
			}

			if (temp instanceof DataFloatFloat) {
				if (result == null) {
					result = (PetriObject) ((DataFloatFloat) temp).clone();
				} else {
					FloatFloat ff = new FloatFloat(
							((FloatFloat) result.GetValue()).V1 - ((FloatFloat) temp.GetValue()).V1,
							((FloatFloat) result.GetValue()).V2 - ((FloatFloat) temp.GetValue()).V2);
					result.SetValue(ff);
				}
			}

		}
		result.SetName(OutputPlaceName);
		Parent.Parent.PlaceList.set(outputIndex, result);
	}

	private void Prod_FloatFloat() throws CloneNotSupportedException {
		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
		PetriObject result = null;

		for (String placeName : InputPlaceNames) {
			PetriObject temp;
			Integer inputIndex = util.GetIndexByName(placeName, Parent.TempMarking);
			if (inputIndex == -1) {
				temp = util.GetFromListByName(placeName, Parent.Parent.ConstantPlaceList);
			} else {
				temp = Parent.TempMarking.get(inputIndex);
			}

			if (temp == null) {
				continue;
			}

			if (temp instanceof DataFloatFloat) {
				if (result == null) {
					result = (PetriObject) ((DataFloatFloat) temp).clone();
				} else {
					FloatFloat ff = new FloatFloat(
							((FloatFloat) result.GetValue()).V1 * ((FloatFloat) temp.GetValue()).V1,
							((FloatFloat) result.GetValue()).V2 * ((FloatFloat) temp.GetValue()).V2);
					result.SetValue(ff);
				}
			}

		}
		result.SetName(OutputPlaceName);
		Parent.Parent.PlaceList.set(outputIndex, result);
	}

	private void Div_FloatFlaot() throws CloneNotSupportedException {
		Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
		PetriObject result = null;

		for (String placeName : InputPlaceNames) {
			PetriObject temp;
			Integer inputIndex = util.GetIndexByName(placeName, Parent.TempMarking);
			if (inputIndex == -1) {
				temp = util.GetFromListByName(placeName, Parent.Parent.ConstantPlaceList);
			} else {
				temp = Parent.TempMarking.get(inputIndex);
			}

			if (temp == null) {
				continue;
			}

			if (temp instanceof DataFloatFloat) {
				if (result == null) {
					result = (PetriObject) ((DataFloatFloat) temp).clone();
				} else {
					FloatFloat ff = new FloatFloat(
							((FloatFloat) result.GetValue()).V1 / ((FloatFloat) temp.GetValue()).V1,
							((FloatFloat) result.GetValue()).V2 / ((FloatFloat) temp.GetValue()).V2);
					result.SetValue(ff);
				}
			}

		}
		result.SetName(OutputPlaceName);
		Parent.Parent.PlaceList.set(outputIndex, result);
	}

	// --------------------------DynamicDelay----------------------------------

	private void DynamicDelay() throws CloneNotSupportedException {
		PetriObject temp = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (temp != null) {
			if (temp instanceof DataInteger)
				Parent.Delay = ((Integer) (temp.GetValue()));
		} else {
			temp = util.GetFromListByName(InputPlaceName, Parent.Parent.ConstantPlaceList);
			if (temp != null) {
				if (temp instanceof DataInteger)
					Parent.Delay = ((Integer) (temp.GetValue()));
			}
		}
	}
}
