package Components;

import java.io.Serializable;
import java.util.ArrayList;

import DataObjects.*;
import DataOnly.CarQueue;
import DataOnly.FloatFloat;
import DataOnly.RELQueue;
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

	public DataTrain T;
	public DataLocalTime Dep_Time;
	public DataString Dep_Platform;
	public DataLocalTime C_Time;
	public DataString C_Platform;
	public DataListTrainsQueue list;
	public DataInteger length1;
	public DataInteger length2;
	public DataInteger speed;
	public DataListTrains list_train;
	public DataListTrainsQueue list_queue_in;
	public DataListTrainsQueue list_queue_out;
	public DataListTrainsHistory old_history;
	public DataListTrainsHistory new_history;
	public DataString filePath;


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



	public Activation(PetriTransition Parent, DataListTrainsHistory old_history, DataString filePath, TransitionOperation Condition,
					  DataListTrainsHistory new_history) {
		util = new Functions();
		this.Parent = Parent;
		this.old_history = old_history;
		this.filePath = filePath;
		this.new_history = new_history;
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

	public Activation(PetriTransition Parent, DataListTrainsQueue list_queue_in,  TransitionOperation Condition,
					  DataListTrainsQueue list_queue_out) {
		util = new Functions();
		this.Parent = Parent;
		this.list_queue_in = list_queue_in;
		this.list_queue_out = list_queue_out;
		this.Operation = Condition;

	}

//	public Activation(PetriTransition Parent, DataTrain train, DataLocalTime dep_time, DataString dep_platform, DataLocalTime c_time, DataString c_platform,DataListTrainsQueue list, DataInteger length1, DataInteger length2,  DataInteger speed, TransitionOperation Condition,
//					  DataListTrains list_train) {
//		util = new Functions();
//		this.Parent = Parent;
//		this.T = train;
//		this.Dep_Time = dep_time;
//	}

	public Activation(PetriTransition Parent, DataTrain train, DataLocalTime dep_time, DataString dep_platform, DataLocalTime c_time, DataString c_platform,DataListTrainsQueue list, DataInteger length1, DataInteger length2,  DataInteger speed, TransitionOperation Condition,
					  DataListTrains list_train) {
		util = new Functions();
		this.Parent = Parent;
		this.list_train = list_train;
		this.Operation = Condition;
		this.T = train;
		this.Dep_Time = dep_time;
		this.Dep_Platform = dep_platform;
		this.C_Time = c_time;
		this.C_Platform = c_platform;
		this.list = list;
		this.length1 = length1;
		this.length2 = length2;
		this.speed = speed;
	}

	public Activation(PetriTransition Parent, DataTrain train, DataLocalTime dep_time, DataString dep_platform, DataListTrainsQueue list, DataInteger length1, DataInteger length2,  DataInteger speed, TransitionOperation Condition,
					  DataListTrains list_train) {
		util = new Functions();
		this.Parent = Parent;
		this.list_train = list_train;
		this.Operation = Condition;
		this.T = train;
		this.Dep_Time = dep_time;
		this.Dep_Platform = dep_platform;
		this.list = list;
		this.length1 = length1;
		this.length2 = length2;
		this.speed = speed;

	}


	public Activation(PetriTransition Parent, String InputPlaceName, TransitionOperation Condition,
			ArrayList<String> OutputPlaceNames) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceNames = OutputPlaceNames;
		this.Operation = Condition;
	}

	
	public void Activate() throws CloneNotSupportedException {

//		if (Operation == TransitionOperation.CalculateTime)
//			CalculateTime();

		if (Operation == TransitionOperation.SaveAndDelete)
			SaveAndDelete();

		if (Operation == TransitionOperation.RemoveFirst)
			RemoveFirst();

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

//	private void CalculateTime() throws CloneNotSupportedException{
//		DataLocalTime result = new DataLocalTime();
//		result = util.Calculate_Time(old_history,filePath);
//
//		new_history.SetValue(result);
//	}
	private void SaveAndDelete() throws CloneNotSupportedException{
		DataListTrainsHistory result = new DataListTrainsHistory();
		result = util.Save_And_Delete(old_history,filePath);

		new_history.SetValue(result);
	}
	private void RemoveFirst() throws CloneNotSupportedException{
		DataListTrainsQueue result = new DataListTrainsQueue();
		result = util.Remove_First(list_queue_in);

		list_queue_out.SetValue(result);
	}

	private void CreateTrain_Null() throws CloneNotSupportedException{
		DataListTrains result = new DataListTrains();
		result = util.Create_Train_Null(T,Dep_Time,Dep_Platform,list, length1,  length2, speed);

		list_train.SetValue(result);
	}
	private void CreateTrain_NotNull() throws CloneNotSupportedException{
		DataListTrains result = new DataListTrains();
		result = util.Create_Train_NotNull(T,Dep_Time,Dep_Platform,C_Time, C_Platform, length1,  length2, speed);

		list_train.SetValue(result);
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

		if (temp instanceof DataTrain) {
			result = (PetriObject) ((DataTrain) temp).clone();
		}

		if (temp instanceof DataTrainQueue) {
			result = (PetriObject) ((DataTrainQueue) temp).clone();
		}

		if (temp instanceof DataListTrains) {
			result = (PetriObject) ((DataListTrains) temp).clone();
		}

		if (temp instanceof DataListTrainsHistory) {
			result = (PetriObject) ((DataListTrainsHistory) temp).clone();
		}

		if (temp instanceof DataListTrainsQueue) {
			result = (PetriObject) ((DataListTrainsQueue) temp).clone();
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

		if (temp instanceof DataTrainQueue) {
			result = (PetriObject) ((DataTrainQueue) temp).clone();
		}

		if (temp instanceof DataListTrains) {
			result = (PetriObject) ((DataListTrains) temp).clone();
		}

		if (temp instanceof DataListTrainsHistory) {
			result = (PetriObject) ((DataListTrainsHistory) temp).clone();
		}

		if (temp instanceof DataListTrainsQueue) {
			result = (PetriObject) ((DataListTrainsQueue) temp).clone();
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

		if (temp instanceof DataTrainQueue) {
			result = (PetriObject) ((DataTrainQueue) temp).clone();
		}

		if (temp instanceof DataListTrains) {
			result = (PetriObject) ((DataListTrains) temp).clone();
		}

		if (temp instanceof DataListTrainsHistory) {
			result = (PetriObject) ((DataListTrainsHistory) temp).clone();
		}

		if (temp instanceof DataListTrainsQueue) {
			result = (PetriObject) ((DataListTrainsQueue) temp).clone();
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
