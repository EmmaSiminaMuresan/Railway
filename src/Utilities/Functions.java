package Utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriTransition;
import DataObjects.*;
import DataOnly.ListTrains;
import DataOnly.Train;
import DataOnly.TransferOperation;
import Enumerations.PetriObjectType;
import Enumerations.TransitionOperation;
import Interfaces.PetriObject;
import MetricsClasses.Metrics;
import MetricsClasses.PlaceTransition;
import PetriDataPackage.PetriData;
import PetriDataPackage.Guard;
import PetriDataPackage.GuardActivation;
import PetriDataPackage.GuardCondition;
import PetriDataPackage.Place;
import PetriDataPackage.Transition;
import javax.swing.JOptionPane;


import com.sun.jdi.Value;

import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Functions implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public PetriObject GetPetriObjectByName(String name, ArrayList<PetriObject> list) {
		for (PetriObject petriObject : list) {
			if (petriObject != null)
				if (petriObject.GetName().equals(name))
					return petriObject;
		}
		return null;
	}

	public Integer GetIndexByName(String name, ArrayList<PetriObject> list) {
		if (name == null)
			return -1;
		if (name.contains("-")) {
			String[] placePath = name.split("-");

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null)
					if (list.get(i).GetName().equals(placePath[0])) {
						if (list.get(i).GetType() == PetriObjectType.DataSubPetri) {
							DataSubPetriNet sp = (DataSubPetriNet) list.get(i);
							for (int x = 0; x < sp.Value.Petri.PlaceList.size(); x++) {
								if (sp.Value.Petri.PlaceList.get(x) != null)
									if (sp.Value.Petri.PlaceList.get(x).GetName().equals(placePath[1]))
										return x;
							}
						}
					}
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null)
					if (list.get(i).GetName().equals(name))
						return i;
			}
		}
		return -1;
	}


	public PetriObject GetFromListByName(String name, ArrayList<PetriObject> list) {
		if (name.contains("-")) {
			String[] placePath = name.split("-");

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null)
					if (list.get(i).GetName().equals(placePath[0])) {
						if (list.get(i).GetType() == PetriObjectType.DataSubPetri) {
							DataSubPetriNet sp = (DataSubPetriNet) list.get(i);
							for (int x = 0; x < sp.Value.Petri.PlaceList.size(); x++) {
								if (sp.Value.Petri.PlaceList.get(x) != null)
									if (sp.Value.Petri.PlaceList.get(x).GetName().equals(placePath[1]))
										return sp.Value.Petri.PlaceList.get(x);
							}
						}
					}
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null)
					if (list.get(i).GetName().equals(name))
						return list.get(i);
			}
		}
		return null;
	}

	public boolean SetToListByName(String name, ArrayList<PetriObject> list, PetriObject data) {
		int index = GetIndexByName(name, list);
		if (index == -1)
			return false;

		if (name.contains("-")) {
			String[] placePath = name.split("-");

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null)
					if (list.get(i).GetName().equals(placePath[0])) {
						if (list.get(i).GetType() == PetriObjectType.DataSubPetri) {
							DataSubPetriNet sp = (DataSubPetriNet) list.get(i);
							sp.Value.Petri.PlaceList.set(index, data);
							return true;
						}
					}
			}
		} else {
			list.set(index, data);
			return true;
		}
		return false;
	}

	public boolean SetNullToListByName(String name, ArrayList<PetriObject> list) {
		int index = GetIndexByName(name, list);
		if (index == -1)
			return false;

		if (name.contains("-")) {
			String[] placePath = name.split("-");

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null)
					if (list.get(i).GetName().equals(placePath[0])) {
						if (list.get(i).GetType() == PetriObjectType.DataSubPetri) {
							DataSubPetriNet sp = (DataSubPetriNet) list.get(i);
							sp.Value.Petri.PlaceList.get(index).SetValue(null);
							return true;
						}
					}
			}
		} else {
			list.get(index).SetValue(null);
			return true;
		}
		return false;
	}

	public boolean TransitionExist(String name, ArrayList<PetriTransition> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).GetName().equals(name))
				return true;
		}
		return false;
	}

	public boolean HaveCarForMe(PetriTransition t, ArrayList<DataCar> list) {
		if (list == null)
			return false;
		if (t == null)
			return false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null && list.get(i).Value != null)
				if (list.get(i).Value.Targets.contains(t.TransitionName))
					return true;
		}
		return false;
	}

	public Integer CarIndexForMe(PetriTransition t, ArrayList<DataCar> list) {
		if (list == null)
			return -1;
		if (t == null)
			return -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null && list.get(i).Value != null)
				if (list.get(i).Value.Targets.contains(t.TransitionName))
					return i;
		}
		return -1;
	}

	public boolean HaveCar(ArrayList<DataCar> list) {
		if (list == null)
			return false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null && list.get(i).Value != null)
				return true;
		}
		return false;
	}

	public boolean HaveREL(ArrayList<DataREL> list) {
		if (list == null)
			return false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null && list.get(i).Value != null)
				return true;
		}
		return false;
	}

	public PetriNet PetriDataToPetriNet(PetriData pd) {
		PetriNet pn = new PetriNet();
		pn.PetriNetName = pd.Name;
		pn.NetworkPort = pd.Port;

		for (Place p : pd.Places) {
			PetriObject pls;
			switch (p.Type) {
				case DataFloat: {
					pls = new DataFloat();
					break;
				}
				case DataString: {
					pls = new DataString();
					break;
				}
				case DataInteger: {
					pls = new DataInteger();
					break;
				}
				case DataCar: {
					pls = new DataCar();
					break;
				}
				case DataCarQueue: {
					pls = new DataCarQueue();
					break;
				}
				case DataREL: {
					pls = new DataREL();
					break;
				}
				case DataRELQueue: {
					pls = new DataRELQueue();
					break;
				}
				case DataSubPetri: {
					pls = new DataSubPetriNet();
					break;
				}
				case DataListTrains: {
					pls = new DataListTrains();
					break;
				}
				case DataListTrainsHistory: {
					pls = new DataListTrainsHistory();
					break;
				}
//				case DataListTrainsQueue: {
//					pls = new DataListTrainsQueue();
//					break;
//				}
				case DataLocalTime: {
					pls = new DataLocalTime();
					break;
				}
				case DataTrain: {
					pls = new DataTrain();
					break;
				}
				case DataTransfer: {
					pls = new DataTransfer();
					break;
				}
				default:
					pls = new DataFloat();
					break;
			}

			if (p.Type == PetriObjectType.DataTransfer) {
				DataTransfer trans = new DataTransfer();
				trans.SetName(p.Name);
				trans.Value = (TransferOperation) p.Val;
				pn.PlaceList.add(trans);
			} else {
				pls.SetName(p.Name);
				pls.SetValue(p.Val);
				pn.PlaceList.add(pls);
			}
		}

		for (Place p : pd.ConstantPlaces) {
			PetriObject pls;
			switch (p.Type) {
				case DataFloat: {
					pls = new DataFloat();
					break;
				}
				case DataString: {
					pls = new DataString();
					break;
				}
				case DataInteger: {
					pls = new DataInteger();
					break;
				}
				case DataCar: {
					pls = new DataCar();
					break;
				}
				case DataCarQueue: {
					pls = new DataCarQueue();
					break;
				}
				case DataREL: {
					pls = new DataREL();
					break;
				}
				case DataRELQueue: {
					pls = new DataRELQueue();
					break;
				}
				case DataSubPetri: {
					pls = new DataSubPetriNet();
					break;
				}
				case DataTransfer: {
					pls = new DataTransfer();
					break;
				}
				case DataListTrains: {
					pls = new DataListTrains();
					break;
				}
				case DataListTrainsHistory: {
					pls = new DataListTrainsHistory();
					break;
				}
//				case DataListTrainsQueue: {
//					pls = new DataListTrainsQueue();
//					break;
//				}
				case DataLocalTime: {
					pls = new DataLocalTime();
					break;
				}
				case DataTrain: {
					pls = new DataTrain();
					break;
				}
				default:
					pls = new DataFloat();
					break;
			}

			if (p.Type == PetriObjectType.DataTransfer) {
				DataTransfer trans = new DataTransfer();
				trans.SetName(p.Name);
				trans.Value = (TransferOperation) p.Val;
				pn.ConstantPlaceList.add(trans);
			} else {
				pls.SetName(p.Name);
				pls.SetValue(p.Val);
				pn.ConstantPlaceList.add(pls);
			}
		}

		for (Transition t : pd.Transitions) {
			PetriTransition trs = new PetriTransition(pn);
			trs.TransitionName = t.Name;
			for (String s : t.InputPlaces) {
				trs.InputPlaceName.add(s);
			}

			for (Guard g : t.Guards) {

				GuardMapping tempGuard = new GuardMapping();
				tempGuard.condition = ConvertToCondition(g.GuardCondition, trs);

				for (GuardActivation ga : g.GuardActivations) {
					Activation act = new Activation(trs);
					act.InputPlaceName = ga.InputPlaceName;
					act.InputPlaceNames = ga.InputPlaceNames;
					act.OutputPlaceName = ga.OutputPlaceName;
					act.OutputPlaceNames = ga.OutputPlaceNames;
					act.Operation = ga.Operation;
					act.Parent = trs;
					tempGuard.Activations.add(act);
				}
				trs.GuardMappingList.add(tempGuard);
			}
			trs.Delay = t.Delay;
			pn.Transitions.add(trs);
		}

		return pn;
	}

	public PetriData PetriNetToPetriData(PetriNet pn) {
		PetriData pd = new PetriData();

		pd.Name = pn.PetriNetName;
		pd.Port = pn.NetworkPort;

		for (PetriObject p : pn.PlaceList) {
			pd.Places.add(new Place(p.GetName(), p.GetType(), p.GetValue()));
		}

		for (PetriObject p : pn.ConstantPlaceList) {
			pd.ConstantPlaces.add(new Place(p.GetName(), p.GetType(), p.GetValue()));
		}

		for (PetriTransition t : pn.Transitions) {
			Transition trs = new Transition();
			trs.Name = t.TransitionName;
			for (String s : t.InputPlaceName) {
				trs.InputPlaces.add(s);
			}

			for (GuardMapping g : t.GuardMappingList) {

				Guard tempGuard = new Guard();
				tempGuard.GuardCondition = ConvertToGuardCondition(g.condition);

				for (Activation ga : g.Activations) {
					GuardActivation act = new GuardActivation();
					act.InputPlaceName = ga.InputPlaceName;
					act.InputPlaceNames = ga.InputPlaceNames;
					act.OutputPlaceName = ga.OutputPlaceName;
					act.OutputPlaceNames = ga.OutputPlaceNames;
					act.Operation = ga.Operation;
					tempGuard.GuardActivations.add(act);
				}
				trs.Guards.add(tempGuard);
			}
			trs.Delay = t.Delay;
			pd.Transitions.add(trs);
		}
		return pd;
	}

	public Condition ConvertToCondition(GuardCondition gCon, PetriTransition parent) {
		Condition con1 = new Condition();
		con1.condition = gCon.condition;
		con1.PlaceName1 = gCon.PlaceName1;
		con1.PlaceName2 = gCon.PlaceName2;
		if (gCon.NextCondition != null) {
			con1.SetNextCondition(gCon.Connector, ConvertToCondition(gCon.NextCondition, parent));
		}
		con1.Parent = parent;
		return con1;
	}

	public GuardCondition ConvertToGuardCondition(Condition con) {
		GuardCondition con1 = new GuardCondition();
		con1.condition = con.condition;
		con1.PlaceName1 = con.PlaceName1;
		con1.PlaceName2 = con.PlaceName2;
		if (con.NextCondition != null) {
			con1.SetNextCondition(con.Connector, ConvertToGuardCondition(con.NextCondition));
		}
		return con1;
	}

	public void ComputeMatrics(PetriNet pn) {
		Float inputArcs = 0F;
		Float outputArcs = 0F;
		Float Level = 1F;
		pn.Metrics = new Metrics();

		for (PetriTransition t : pn.Transitions) {
			inputArcs += t.InputPlaceName.size();
			ArrayList<String> outputPlaceNames = new ArrayList<String>();

			for (GuardMapping g : t.GuardMappingList) {
				for (Activation a : g.Activations) {
					if (a.OutputPlaceName != null && a.OutputPlaceName != "" && !a.OutputPlaceName.contains("-")
							&& !outputPlaceNames.contains(a.OutputPlaceName)
							&& a.Operation != TransitionOperation.MakeNull) {
						outputPlaceNames.add(a.OutputPlaceName);
						outputArcs++;

						PlaceTransition pt = new PlaceTransition();
						pt.InPlaceName = a.InputPlaceName;
						pt.TransitionName = t.TransitionName;
						pt.OutPlaceName = a.OutputPlaceName;
						if (!PlaceTransitionExists(pt, pn.Metrics.Pieces)) {
							pn.Metrics.Pieces.add(pt);
						}

					} else {
						if (a.OutputPlaceNames != null) {
							outputArcs += a.OutputPlaceNames.size();
						}
					}
					if (a.Operation == TransitionOperation.ActivateSubPetri) {
						Level = 2F;
					}
				}
			}
		}

		pn.Metrics.InputArcs = inputArcs;
		pn.Metrics.OutputArcs = outputArcs;
		pn.Metrics.StructuralComplexity = inputArcs + outputArcs;
		pn.Metrics.LevelNumber = Level;
	}

	public boolean PlaceTransitionExists(PlaceTransition pt, ArrayList<PlaceTransition> list) {
		for (PlaceTransition p : list) {
			if (p.toString() == pt.toString()) {
				return true;
			}
		}
		return false;
	}




	public DataListTrains Create_Train_Null(DataTrain T, DataLocalTime Dep_Time, DataString Dep_Platform, DataListTrainsHistory list, DataInteger length1, DataInteger length2, DataInteger length3, DataInteger speed) {

		// length1,length2 - for the new train, length 3 - for the last train
		// no upcoming train
		DataListTrains new_train_list = new DataListTrains();
		DataLocalTime leaving_time;
		int last_index;
		DataLocalTime dep_time = new DataLocalTime();
		if(list == null) last_index = 0;
		else last_index = list.LastIndex();


		if (list == null) { // first train to create in a day
			leaving_time = TimeAfterPassing(Dep_Time.Value.plusMinutes(10), T.GetLength(), length1.Value, length2.Value, speed); // 10 min for people to get on
			ListTrains new_train = new ListTrains(T.Value, Dep_Time.Value, leaving_time.Value, Dep_Platform.Value);
			new_train_list.SetValue(new_train);
		} else { // a train left
			if(length3 == null) {
				// the case when the last train departed from platform 3 so the leaving time of the last train matters - that would be the first
				// intersection with the new train

				// time of the prev train to leave the station/intersection with the new train
				LocalTime prev_time = list.GetLeavingTime(last_index);
				//System.out.println("prev time to pass the common intersection :" +prev_time);

				// time of the new train after it passed the common intersection + 10 min for passengers to gen on
				DataLocalTime new_time = TimeAfterPassing(Dep_Time.Value.plusMinutes(10), T.GetLength(), length1.Value, length2.Value, speed);
				//System.out.println("new time to pass the common intersection :" +new_time);

				if (new_time.Value.isAfter(prev_time.plusMinutes(10))) { // safety gap
					leaving_time = TimeAfterPassing(Dep_Time.Value.plusMinutes(10), T.GetLength(), length1.Value, length2.Value, speed);
					ListTrains new_train = new ListTrains(T.Value, Dep_Time.Value, leaving_time.Value, Dep_Platform.Value);
					new_train_list.SetValue(new_train);
				} else { // not enough time to pass/ not enough safety distance between trains
					// then the second train will depart when the last one left the station
					dep_time.Value = prev_time;
					leaving_time = TimeAfterPassing(prev_time, T.GetLength(), length1.Value, length2.Value, speed);
					ListTrains new_train = new ListTrains(T.Value, dep_time.Value, leaving_time.Value, Dep_Platform.Value);
					new_train_list.SetValue(new_train);
				}
			}else{
				// the last train left from platform 1 or 2 so we don't know the time when it gets to the intersection with the new train

				// 10 min for people to get on
				// time of the last train to exit the common intersection
				DataLocalTime prev_time = TimeAfterPassing(list.GetDepTime(last_index).plusMinutes(10), list.GetLength(last_index), length3.Value, 0, speed);
				//System.out.println("prev time to pass the common intersection :" +prev_time);

				DataLocalTime new_time = TimeAfterPassing(Dep_Time.Value.plusMinutes(10), T.GetLength(), length1.Value, 0, speed);
				//System.out.println("new time to pass the common intersection :" +new_time);

				if (new_time.Value.isAfter(prev_time.Value.plusMinutes(10))) { // safety gap
					leaving_time = TimeAfterPassing(Dep_Time.Value.plusMinutes(10), T.GetLength(), length1.Value, length2.Value, speed);
					ListTrains new_train = new ListTrains(T.Value, Dep_Time.Value, leaving_time.Value, Dep_Platform.Value);
					new_train_list.SetValue(new_train);
				} else { // not enough time to pass/ not enough safety distance between trains
					dep_time = prev_time; // when the last train exits the common intersection
					// then the new train will depart
					leaving_time = TimeAfterPassing(dep_time.Value.plusMinutes(10), T.GetLength(), length1.Value, length2.Value, speed);
					ListTrains new_train = new ListTrains(T.Value, dep_time.Value, leaving_time.Value, Dep_Platform.Value);
					new_train_list.SetValue(new_train);
				}
			}

			/*String prev_platform = list.GetPlatform(last_index);
			if (Dep_Platform.Value.equals(prev_platform)) { // same platform as the one before so only one length matters
				// times after passing the first common intersection
				// 10 min for people to get on
				DataLocalTime prev_time = TimeAfterPassing(list.GetDepTime(last_index).plusMinutes(10), list.GetLength(last_index), length3.Value, 0, speed);
				//System.out.println("prev time to pass the common intersection :" +prev_time);

				DataLocalTime new_time = TimeAfterPassing(Dep_Time.Value.plusMinutes(10), T.GetLength(), length1.Value, 0, speed);
				//System.out.println("new time to pass the common intersection :" +new_time);

				if (new_time.Value.isAfter(prev_time.Value.plusMinutes(10))) { // safety gap
					leaving_time = TimeAfterPassing(Dep_Time.Value.plusMinutes(10), T.GetLength(), length1.Value, length2.Value, speed);
					ListTrains new_train = new ListTrains(T.Value, Dep_Time.Value, leaving_time.Value, Dep_Platform.Value);
					new_train_list.SetValue(new_train);
				} else { // not enough time to pass/ not enough safety distance between trains
					dep_time = prev_time; // when the first train arrives at the first intersection
					// then the second train will depart
					leaving_time = TimeAfterPassing(dep_time.Value.plusMinutes(10), T.GetLength(), length1.Value, length2.Value, speed);
					ListTrains new_train = new ListTrains(T.Value, dep_time.Value, leaving_time.Value, Dep_Platform.Value);
					new_train_list.SetValue(new_train);
				}
			} else {
				if ((Dep_Platform.Contains("1") && list.GetPlatform(last_index).contains("2") ) || (( Dep_Platform.Contains("2")) && list.GetPlatform(last_index).contains("1"))) {
					// as the case of equality
					//if((Dep_Platform.Contains("1")
					DataLocalTime prev_time = TimeAfterPassing(list.GetDepTime(last_index).plusMinutes(10), list.GetLength(last_index), length1.Value, 0, speed);
					DataLocalTime new_time = TimeAfterPassing(Dep_Time.Value.plusMinutes(10), T.GetLength(), length1.Value, 0, speed);
					if (new_time.Value.isAfter(prev_time.Value.plusMinutes(10))) {
						leaving_time = TimeAfterPassing(Dep_Time.Value.plusMinutes(10), T.GetLength(), length1.Value, length2.Value, speed);
						ListTrains new_train = new ListTrains(T.Value, Dep_Time.Value, leaving_time.Value, Dep_Platform.Value);
						new_train_list.SetValue(new_train);
					} else {
						dep_time = prev_time; // when the first train arrives at the first intersection
						// then the second train will depart
						leaving_time = TimeAfterPassing(dep_time.Value.plusMinutes(10), T.GetLength(), length1.Value, length2.Value, speed);
						ListTrains new_train = new ListTrains(T.Value, dep_time.Value, leaving_time.Value, Dep_Platform.Value);
						new_train_list.SetValue(new_train);
					}
				} else {
					leaving_time = TimeAfterPassing(Dep_Time.Value, T.GetLength(), length1.Value, length2.Value, speed);
					if(leaving_time.Value.equals(list.GetLeavingTime(last_index))){
						// they both would pass the exit intersection at the same time
						// so the new train will leave 10 min later
						leaving_time.Value = leaving_time.Value.plusMinutes(10);
						dep_time.Value = Dep_Time.Value.plusMinutes(10);
						ListTrains new_train = new ListTrains(T.Value, dep_time.Value, leaving_time.Value, Dep_Platform.Value);
						new_train_list.SetValue(new_train);
					}
					else {
						if(leaving_time.Value.isBefore(list.GetLeavingTime(last_index)) && (Duration.between(leaving_time.Value,list.GetDepTime(last_index)).toMinutes()<10)){
							// the new train leaves earlier than the last one, but with a gap of less than 10 minutes
							Dep_Time.Value = Dep_Time.Value.minusMinutes(10);
							leaving_time = TimeAfterPassing(Dep_Time.Value,T.GetLength(),length1.Value,length2.Value,speed);
							ListTrains new_train = new ListTrains(T.Value, Dep_Time.Value, leaving_time.Value, Dep_Platform.Value);
							new_train_list.SetValue(new_train);
						}
						else{
							if(leaving_time.Value.isAfter(list.GetLeavingTime(last_index)) && (Duration.between(list.GetDepTime(last_index),leaving_time.Value).toMinutes()<10)) {
								// the new train leaves later than the last one, but with a gap of less than 10 minutes
								Dep_Time.Value = Dep_Time.Value.plusMinutes(10);
								leaving_time = TimeAfterPassing(Dep_Time.Value,T.GetLength(),length1.Value,length2.Value,speed);
								ListTrains new_train = new ListTrains(T.Value, Dep_Time.Value, leaving_time.Value, Dep_Platform.Value);
								new_train_list.SetValue(new_train);
							}
							else {
								// new train perfect
								leaving_time = TimeAfterPassing(Dep_Time.Value,T.GetLength(),length1.Value,length2.Value,speed);
								ListTrains new_train = new ListTrains(T.Value, Dep_Time.Value, leaving_time.Value, Dep_Platform.Value);
								new_train_list.SetValue(new_train);
							}
						}

					}
				}
			}*/

		}
		return new_train_list;
	}

	public DataListTrains Create_Train_NotNull(DataTrain T, DataLocalTime Dep_Time, DataString Dep_Platform, DataLocalTime C_Time, DataString C_Platform, DataInteger length1, DataInteger length2, DataInteger speed){
		// there is a coming train
		DataListTrains new_train_list = new DataListTrains();
		DataLocalTime leaving_time;


		if (Dep_Platform.GetString().equals(C_Platform.GetString())) {
			if (Dep_Time.Value.isAfter(C_Time.Value.plusMinutes(10))) {
				leaving_time = TimeAfterPassing(Dep_Time.Value, T.GetLength(), length1.Value, length2.Value, speed);
				ListTrains new_train = new ListTrains(T.Value, Dep_Time.Value, leaving_time.Value, Dep_Platform.Value);
				new_train_list.SetValue(new_train);
			} else {
				leaving_time = TimeAfterPassing(C_Time.Value.plusMinutes(20), T.GetLength(), length1.Value, length2.Value, speed);
				ListTrains new_train = new ListTrains(T.Value, C_Time.Value.plusMinutes(20), leaving_time.Value, Dep_Platform.Value);
				new_train_list.SetValue(new_train);
			}

		} else {
			if (C_Platform.Contains("4") && (Dep_Platform.Contains("2") || (Dep_Platform.Contains("1")))) {
				if (Dep_Time.Value.isAfter(C_Time.Value.plusMinutes(10))) {
					leaving_time = TimeAfterPassing(Dep_Time.Value, T.GetLength(), length1.Value, length2.Value, speed);
					ListTrains new_train = new ListTrains(T.Value, Dep_Time.Value, leaving_time.Value, Dep_Platform.Value);
					new_train_list.SetValue(new_train);
				} else {
					leaving_time = TimeAfterPassing(C_Time.Value.plusMinutes(20), T.GetLength(), length1.Value, length2.Value, speed);
					ListTrains new_train = new ListTrains(T.Value, C_Time.Value.plusMinutes(20), leaving_time.Value, Dep_Platform.Value);
					new_train_list.SetValue(new_train);
				}
			} else {
				leaving_time = TimeAfterPassing(Dep_Time.Value, T.GetLength(), length1.Value, length2.Value, speed);
				ListTrains new_train = new ListTrains(T.Value, Dep_Time.Value, leaving_time.Value, Dep_Platform.Value);
				new_train_list.SetValue(new_train);
			}
		}


		return new_train_list;
	}


	public DataLocalTime TimeAfterPassing(LocalTime dep_time,int train_length, int first_length, int second_length, DataInteger speed){


		double totalDistance = 2 * (train_length + first_length + second_length);
		//System.out.println("total dist " +totalDistance);

		double timeTakenSeconds = totalDistance / ((double) (speed.Value * 1000) /3600);
		//System.out.println("timeTakenSeconds " +timeTakenSeconds);
		Duration timeTaken = Duration.ofSeconds((long) timeTakenSeconds);
		//System.out.println("total timeTaken " +timeTaken);


		LocalTime finalTime = dep_time.plus(timeTaken);
		DataLocalTime place = new DataLocalTime();
		place.Value = finalTime;
		//System.out.println("finalTime " +finalTime);
		return place;
	}

//	public DataListTrainsQueue Remove_First(DataListTrainsQueue list_1){
//
//		DataListTrainsQueue new_list = new DataListTrainsQueue();
//
//		if(list_1.Value!=null){
//			list_1.Value.Remove();
//			new_list = list_1;
//		}
//
//
//		return new_list;
//	}

	public DataListTrainsHistory Save_And_Delete(DataListTrainsHistory list_1, DataString filePath){

		DataListTrainsHistory new_list;

		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.Value,true))) {
			for(int i = 0; i < list_1.GetSize() - 1; i++){
				writer.write(list_1.GetElement(i).toString());
				writer.newLine();
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		for(int i = 0; i < list_1.GetSize() - 1; i++){
			list_1.Value.Remove(i);
		}

		new_list = list_1;

		return new_list;
	}

	public String Platform(Train T){
		String platform = null;
		String target = null;
		List<String> targets = null;
		targets = T.getTargets();

		target = targets.get(targets.size()-1);
		if(target.startsWith("t3_")){
			if(target.endsWith("A1")) platform = "A1";
			if(target.endsWith("A2")) platform = "A2";
			if(target.endsWith("A3")) platform = "A3";
			if(target.endsWith("B1")) platform = "B1";
			if(target.endsWith("B2")) platform = "B2";
			if(target.endsWith("B3")) platform = "B3";
			if(target.endsWith("C1")) platform = "C1";
			if(target.endsWith("C2")) platform = "C2";
			if(target.endsWith("C3")) platform = "C3";
		}

		return platform;
	}

	public boolean CheckTransitionTargetList(Train T, String transition) {
		List<String> targets = T.getTargets();

		if (targets != null && targets.contains(transition)) {
			return true;
		}
		return false;
	}

	public DataInteger Calculate_Delay(int seconds){
		DataInteger time = new DataInteger();
		time.SetValue(seconds/100);

		return time;
	}

	public DataInteger Calculate_Light_Time_Station(DataListTrains Time){
		DataInteger time = new DataInteger();
		time.SetValue((int)(Duration.between(Time.GetDepTime(0), Time.GetLeavingTime(0))).getSeconds());

		return time;
	}

	public DataInteger Calculate_Light_Time_Railway(int length, int speed){

		DataInteger time = new DataInteger();
		time.SetValue((2*(500 + length)/(speed*1000/3600))); // 500 m from the sensor to the intersection

		return time;
	}


	public DataLocalTime Calculate_Time(DataTrain T,DataInteger length1,DataInteger length2,DataInteger speed){
		// time for the coming train to reach the platform for the people to get off

		DataLocalTime time = new DataLocalTime();
		//if(T.Value == null) time.SetValue(null);
		 time = TimeAfterPassing(LocalTime.now(),T.GetLength(),length1.Value,length2.Value,speed);

		return time;
	}

	public boolean Train_Length(Train t1, Train t2){
		if(t1.Length > t2.Length) return true;
		else return false;
	}

	public boolean Equal_Length(Train t1, Train t2){
		if(t1.Length == t2.Length) return true;
		else return false;
	}



	public void MessageBox_Controllers_One_Light(DataInteger seconds,DataString controller){
		String message = seconds.GetValue().toString() + " seconds for red light " + controller.GetString();
		JOptionPane.showMessageDialog(null, message, controller.GetString(), JOptionPane.INFORMATION_MESSAGE);
	}

	public void MessageBox_Controllers_Two_Lights(DataInteger seconds){
		String message = seconds.GetValue().toString() + " seconds for red light " ;
		JOptionPane.showMessageDialog(null, message);
	}


	public void MessageBox_SupervisorA(DataListTrains list){
		String message = "Train " + list.GetTrainNumber() + " depart at " + list.getDep_time() + " on platform " +list.getPlatform();
		JOptionPane.showMessageDialog(null, message, "Supervisor A", JOptionPane.INFORMATION_MESSAGE);
	}

	public void MessageBox_SupervisorB(DataListTrains list){
		String message = "Train " + list.GetTrainNumber() + " depart at " + list.getDep_time() + " on platform " +list.getPlatform();
		JOptionPane.showMessageDialog(null, message, "Supervisor B", JOptionPane.INFORMATION_MESSAGE);
	}

	public void MessageBox_SupervisorC(DataListTrains list){
		String message = "Train " + list.GetTrainNumber() + " depart at " + list.getDep_time() + " on platform " +list.getPlatform();
		JOptionPane.showMessageDialog(null, message, "Supervisor C", JOptionPane.INFORMATION_MESSAGE);
	}

//	public boolean HaveListTrain(ArrayList<DataListTrains> list) {
//		if (list == null)
//			return false;
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i) != null && list.get(i).Value != null)
//				return true;
//		}
//		return false;
//	}
	public boolean HaveListTrain_History(ArrayList<DataListTrains> list) {
		if (list == null)
			return false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null && list.get(i).Value != null)
				return true;
		}
		return false;
	}

//	public boolean HaveTrainForMe(PetriTransition t, DataTrain Train) {
//		if (Train == null)
//			return false;
//		if (t == null)
//			return false;
//		if(Train.Value.Targets.contains(t.TransitionName))
//			return true;
//		return false;
//	}
}