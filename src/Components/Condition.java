package Components;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;

import DataObjects.DataListTrains;
import DataObjects.DataListTrainsHistory;
import DataObjects.DataTrain;
import DataOnly.*;
import Enumerations.LogicConnector;
import Enumerations.PetriNetState;
import Enumerations.PetriObjectType;
import Enumerations.TransitionCondition;
import Interfaces.PetriObject;
import Utilities.Functions;

public class Condition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PetriTransition Parent;

	public PetriObject Value1;
	public PetriObject Value2;

	public String PlaceName1;
	public String PlaceName2;

	public TransitionCondition condition;

	public Condition NextCondition;
	public LogicConnector Connector = LogicConnector.AND;
	public Functions util;

	public Condition() {
		util = new Functions();
	}

	public Condition(PetriTransition Parent, String PlaceName1, TransitionCondition condition, String PlaceName2) {
		util = new Functions();
		this.Parent = Parent;
		this.PlaceName1 = PlaceName1;
		this.PlaceName2 = PlaceName2;
		this.condition = condition;
	}

	public Condition(PetriTransition Parent, String PlaceName1, TransitionCondition condition) {
		util = new Functions();
		this.Parent = Parent;
		this.PlaceName1 = PlaceName1;
		this.condition = condition;
	}

	public void refreshData() {
		this.Value1 = util.GetPetriObjectByName(PlaceName1, Parent.Parent.PlaceList);
		if (Value1 == null) {
			Integer indx = util.GetIndexByName(PlaceName1, Parent.Parent.ConstantPlaceList);
			if (indx > -1)
				this.Value1 = util.GetPetriObjectByName(PlaceName1, Parent.Parent.ConstantPlaceList);
		}
		this.Value2 = util.GetPetriObjectByName(PlaceName2, Parent.Parent.PlaceList);
		if (Value2 == null) {
			Integer indx = util.GetIndexByName(PlaceName2, Parent.Parent.ConstantPlaceList);
			if (indx > -1)
				this.Value2 = util.GetPetriObjectByName(PlaceName2, Parent.Parent.ConstantPlaceList);
		}
	}

	public void SetNextCondition(LogicConnector Connector, Condition NextCondition) {
		this.NextCondition = NextCondition;
		this.Connector = Connector;
	}

	boolean Check() {
		refreshData();
		switch (condition) {
		case NotNull:
			if (Value1 != null && Value1.GetValue() != null)
				return true;
			break;
		case IsNull:
			if (Value1 == null || Value1.GetValue() == null)
				return true;
			break;
		case NotEqual:
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			if (!Value1.GetValue().equals(Value2.GetValue()))
				return true;
			break;
		case Equal:
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			if (Value1.GetValue().equals(Value2.GetValue()))
				return true;
			break;
		case MoreThanOrEqual: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			switch (Value1.GetType()) {
			case DataInteger:
				if ((Integer) Value1.GetValue() >= (Integer) Value2.GetValue())
					return true;
				break;
			case DataFloat:
				if ((Float) Value1.GetValue() >= (Float) Value2.GetValue())
					return true;
				break;
			default:
				break;
			}
			break;
		}
		case LessThanOrEqual: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			switch (Value1.GetType()) {
			case DataInteger:
				if ((Integer) Value1.GetValue() <= (Integer) Value2.GetValue())
					return true;
				break;
			case DataFloat:
				if ((Float) Value1.GetValue() <= (Float) Value2.GetValue())
					return true;
				break;
			default:
				break;
			}
			break;
		}
		case MoreThan: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			switch (Value1.GetType()) {
			case DataInteger:
				if ((Integer) Value1.GetValue() > (Integer) Value2.GetValue())
					return true;
				break;
			case DataFloat:
				if ((Float) Value1.GetValue() > (Float) Value2.GetValue())
					return true;
				break;
			default:
				break;
			}
			break;
		}
		case LessThan: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			switch (Value1.GetType()) {
			case DataInteger:
				if ((Integer) Value1.GetValue() < (Integer) Value2.GetValue())
					return true;
				break;
			case DataFloat:
				if ((Float) Value1.GetValue() < (Float) Value2.GetValue())
					return true;
				break;
			default:
				break;
			}
			break;
		}
		case Contains: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			if (Value1.GetType() == PetriObjectType.DataString) {
				if (((String) Value1.GetValue()).contains((String) Value2.GetValue()))
					return true;
			}
			break;
		}
		case NotContains: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			if (Value1.GetType() == PetriObjectType.DataString) {
				if (!((String) Value1.GetValue()).contains((String) Value2.GetValue()))
					return true;
			}
			break;
		}
			case HaveCar: {
				if (Value1 == null)
					return false;
				if (Value1.GetValue() == null)
					return false;
				if (Value1.GetType() == PetriObjectType.DataCarQueue) {
					if (util.HaveCar(((CarQueue) Value1.GetValue()).Cars)) {
						return true;
					}
				}
				break;
			}
		case HaveCarForMe: {
			if (Value1 == null)
				return false;
			if (Value1.GetValue() == null)
				return false;
			if (Value1.GetType() == PetriObjectType.DataCarQueue) {
				if (util.HaveCarForMe(Parent, ((CarQueue) Value1.GetValue()).Cars)) {
					return true;
				}
			}
			break;
		}
		case CanAddCars: {
			if (Value1 == null)
				return false;
			if (Value1.GetValue() == null)
				return false;
			if (Value1.GetType() == PetriObjectType.DataCarQueue) {
				if (((CarQueue) Value1.GetValue()).CanAddCar()) {
					return true;
				}
			}
			break;
		}
		case CanNotAddCars: {
			if (Value1 == null)
				return false;
			if (Value1.GetValue() == null)
				return false;
			if (Value1.GetType() == PetriObjectType.DataCarQueue) {
				if (((CarQueue) Value1.GetValue()).CanNotAddCar()) {
					return true;
				}
			}
			break;
		}
//			case TransitionTargetList:{
//				if (Value1 == null || Value2 == null)
//					return false;
//				if (Value1.GetValue() == null || Value2.GetValue() == null)
//					return false;
//				if (Value1.GetType() == PetriObjectType.DataTrain) {
//					if (Value1.getTargets().contains((String)Value2.GetValue()))
//						return true;
//				}
//				if (Value1.GetType() == PetriObjectType.DataListTrains) {
//					if (Value1.getTargets().contains((String)Value2.GetValue()))
//						return true;
//				}
////				if (Value1.GetType() == PetriObjectType.DataListTrainsQueue) {
////					if (Value1.getTargets().contains((String)Value2.GetValue()))
////						return true;
////				}
//				if (Value1.GetType() == PetriObjectType.DataListTrainsHistory) {
//					if (Value1.getTargets().contains((String)Value2.GetValue()))
//						return true;
//				}
//				break;
//			}


			case Platform_To_Send: {
				if (Value1 == null || Value2 == null)
					return false;
				if (Value1.GetValue() == null || Value2.GetValue() == null)
					return false;
				if (Value1.GetType() == PetriObjectType.DataListTrains) {
					if(Value1.GetPlatform(0)==null) return false;
					if ((Value1.GetPlatform(0)).contains((String) Value2.GetValue()))
						return true;
				}
				break;
			}

			case Equal_Length: {
				if (Value1 == null || Value2 == null)
					return false;
				if (Value1.GetValue() == null || Value2.GetValue() == null)
					return false;
				if (Value1.GetType() == PetriObjectType.DataTrain) {
					if (util.Equal_Length((Train) Value1.GetValue(),(Train) Value2.GetValue())) {
						return true;
					}
					else return false;
				}
				break;
			}
			case MoreThan_Length: {
				if (Value1 == null || Value2 == null)
					return false;
				if (Value1.GetValue() == null || Value2.GetValue() == null)
					return false;
				if (Value1.GetType() == PetriObjectType.DataTrain) {
					if (util.Train_Length((Train) Value1.GetValue(),(Train) Value2.GetValue())) {
						return true;
					}
					else return false;
				}
				break;
			}
			case Platform: {
				if (Value1 == null || Value2 == null)
					return false;
				if (Value1.GetValue() == null || Value2.GetValue() == null)
					return false;
				if (Value1.GetType() == PetriObjectType.DataTrain) {
					if (util.Platform((Train) Value1.GetValue()).contains((String) Value2.GetValue())) {
						return true;
					}
					else return false;
				}
				break;
			}
			case Check_Transition_Target_List: {
				if (Value1 == null || Value2 == null)
					return false;
				if (Value1.GetValue() == null || Value2 == null)
					return false;
				if (Value1.GetType() == PetriObjectType.DataTrain) {
					if (util.CheckTransitionTargetList(((Train) Value1.GetValue()),(String) Value2.GetValue())) {
						return true;
					}
					else return false;
				}
				break;
			}

			case Check_Transition_Target_List_NO: {
				if (Value1 == null || Value2 == null)
					return false;
				if (Value1.GetValue() == null || Value2 == null)
					return false;
				if (Value1.GetType() == PetriObjectType.DataTrain) {
					if (!util.CheckTransitionTargetList(((Train) Value1.GetValue()),(String) Value2.GetValue())) {
						return true;
					}
					else return false;
				}
				break;
			}

//			case HaveTrainForMe: {
//				if (Value1 == null)
//					return false;
//				if (Value1.GetValue() == null)
//					return false;
//				if (Value1.GetType() == PetriObjectType.DataTrain) {
//					if (util.HaveTrainForMe(Parent, ((DataTrain) Value1))) {
//						return true;
//					}
//				}
//				break;
//			}
			case HaveListTrain_History: {
				if (Value1 == null)
					return false;
				if (Value1.GetValue() == null)
					return false;
				if (Value1.GetType() == PetriObjectType.DataListTrainsHistory) {
					if (util.HaveListTrain_History(((ListTrainsHistory) Value1.GetValue()).Trains)) {
						return true;
					}
				}
				break;
			}
			case Have_NoListTrain_History: {
				if (Value1 == null)
					return false;
				if (Value1.GetValue() == null)
					return false;
				if (Value1.GetType() == PetriObjectType.DataListTrainsHistory) {
					if (!util.HaveListTrain_History(((ListTrainsHistory) Value1.GetValue()).Trains)) {
						return true;
					}
				}
				break;
			}
			case Check_Platform_History: {
				if (Value1 == null || Value2 == null)
					return false;
				if (Value1.GetValue() == null || Value2.GetValue() == null)
					return false;
				if (Value1.GetType() == PetriObjectType.DataListTrainsHistory) {
					DataListTrainsHistory history = (DataListTrainsHistory) Value1;
					String platformToCheck = (String) Value2.GetValue();

					if (history != null) {
						int lastIndex = history.LastIndex();
						String platform = history.GetPlatform(lastIndex);

						if (platform != null && platform.equals(platformToCheck)) {
							return true;
						}
					}
					return false;
				}
				break;
			}

//			case HaveListTrain: {
//				if (Value1 == null)
//					return false;
//				if (Value1.GetValue() == null)
//					return false;
//				if (Value1.GetType() == PetriObjectType.DataListTrainsQueue) {
//					if (util.HaveListTrain(((ListTrainsQueue) Value1.GetValue()).Trains)) {
//						return true;
//					}
//				}
//				break;
//			}
//			case Have_NoListTrain: {
//				if (Value1 == null)
//					return false;
//				if (Value1.GetValue() == null)
//					return false;
//				if (Value1.GetType() == PetriObjectType.DataListTrainsQueue) {
//					if (!util.HaveListTrain(((ListTrainsQueue) Value1.GetValue()).Trains)) {
//						return true;
//					}
//				}
//				break;
//			}
			case CheckTime_Before:
				if (Value1.GetType() == PetriObjectType.DataListTrainsHistory)
				{
					LocalTime lt=((DataListTrainsHistory) Value1).Value.Last_Dep_Time();
					if(lt!=null)
						if (lt.isBefore(LocalTime.of(23,59,59)) ||
								lt.equals(LocalTime.of(23,59,59))) {
							return true;
						}
				}
				break;
			case CheckTime_After: {
				LocalTime lt=((DataListTrainsHistory) Value1).Value.Last_Dep_Time();
				if(lt!=null)
					if (Value1.GetType() == PetriObjectType.DataListTrainsHistory)
						if (lt.isAfter(LocalTime.of(23, 59, 59))) {
							return true;
						}
				break;
			}
//			case HasElements: {
//				if (Value1 == null)
//					return false;
//				if (Value1.GetValue() == null)
//					return false;
//				if (Value1.GetType() == PetriObjectType.DataListTrainsQueue) {
//					if (!((ListTrainsQueue) Value1.GetValue()).Trains.isEmpty()) {
//						return true;
//					} else return false;
//				} else return false;
//
//			}


			case CheckDepartureTime: {
				if (Value1 == null || Value2 == null)
					return false;
				if (Value1.GetValue() == null || Value2.GetValue() == null)
					return false;
				if (Value1.GetType() == PetriObjectType.DataListTrains) {
					if (Value1.GetDepTime(0).isAfter(Value2.GetDepTime(0))) {
						return true;
					}
					else return false;
				}
				break;
			}

			case EqualDepartureTime: {
				if (Value1 == null || Value2 == null)
					return false;
				if (Value1.GetValue() == null || Value2.GetValue() == null)
					return false;
				if (Value1.GetType() == PetriObjectType.DataListTrains) {
					if (Value1.GetDepTime(0).equals((Value2.GetDepTime(0)))) {
						return true;
					}
					else return false;
				}
				break;
			}

			case CheckLeavingTime: {
				if (Value1 == null || Value2 == null)
					return false;
				if (Value1.GetValue() == null || Value2.GetValue() == null)
					return false;
				if (Value1.GetType() == PetriObjectType.DataListTrains) {
					if (Value1.GetLeavingTime(0).isAfter(Value2.GetLeavingTime(0))) {
						return true;
					}
					else return false;
				}
				break;
			}


//			case CanAddTrains_List: {
//				if (Value1 == null)
//					return false;
//				if (Value1.GetValue() == null)
//					return false;
//				if (Value1.GetType() == PetriObjectType.DataListTrainsQueue) {
//					DataListTrains trainToAdd = (DataListTrains) Value2;
//					if (((ListTrainsQueue) Value1.GetValue()).CanAddtrain(trainToAdd)) {
//						return true;
//					} else {
//						return false;
//					}
//				}
//				break;
//			}

//			case CanNotAddTrains_List: {
//				if (Value1 == null)
//					return false;
//				if (Value1.GetValue() == null)
//					return false;
//				if (Value1.GetType() == PetriObjectType.DataListTrainsQueue) {
//					if (((ListTrainsQueue) Value1.GetValue()).CanNotAddtrain()) {
//						return true;
//					}else return false;
//				}
//				break;
//			}
		case HaveREL: {
			if (Value1 == null)
				return false;
			if (Value1.GetValue() == null)
				return false;
			if (Value1.GetType() == PetriObjectType.DataRELQueue) {
				if (util.HaveREL(((RELQueue) Value1.GetValue()).RELs)) {
					return true;
				}
			}
			break;
		}

		case SubPetriStopped: {
			if (Value1 == null)
				return false;
			if (Value1.GetValue() == null)
				return false;
			if (Value1.GetType() == PetriObjectType.DataSubPetri) {
				if (((SubPetri) Value1.GetValue()).Petri.PetriState == PetriNetState.Stopped) {
					return true;
				}
			}
			break;
		}

		// ---------------New Conditions for FloatFloat---------------------
		case Equal_FloatFloat: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			if (((FloatFloat) Value1.GetValue()).V1 == ((FloatFloat) Value2.GetValue()).V1
					&& ((FloatFloat) Value1.GetValue()).V2 == ((FloatFloat) Value2.GetValue()).V2)
				return true;
			break;
		}
		case MoreThan_FloatFloat: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			if (((FloatFloat) Value1.GetValue()).V1 > ((FloatFloat) Value2.GetValue()).V1
					&& ((FloatFloat) Value1.GetValue()).V2 > ((FloatFloat) Value2.GetValue()).V2)
				return true;
			break;
		}
		case MoreThanOrEqual_FloatFloat: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			if (((FloatFloat) Value1.GetValue()).V1 >= ((FloatFloat) Value2.GetValue()).V1
					&& ((FloatFloat) Value1.GetValue()).V2 >= ((FloatFloat) Value2.GetValue()).V2)
				return true;
			break;
		}
		case LessThan_FloatFloat: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			if (((FloatFloat) Value1.GetValue()).V1 < ((FloatFloat) Value2.GetValue()).V1
					&& ((FloatFloat) Value1.GetValue()).V2 < ((FloatFloat) Value2.GetValue()).V2)
				return true;
			break;
		}
		case LessThanOrEqual_FloatFloat: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			if (((FloatFloat) Value1.GetValue()).V1 <= ((FloatFloat) Value2.GetValue()).V1
					&& ((FloatFloat) Value1.GetValue()).V2 <= ((FloatFloat) Value2.GetValue()).V2)
				return true;
			break;
		}
		// ---------------------End of Modification-------------------------------

		default:
			break;
		}
		return false;
	}

	public ArrayList<Condition> conditionList;

	public boolean CheckCondition() {
		refreshData();
		conditionList = new ArrayList<Condition>();
		FullList(this);

		boolean andCondition = true;
		for (Condition condition : conditionList) {
			if (condition.Connector == LogicConnector.AND) {
				if (!condition.Check()) {
					andCondition = false;
					break;
				}
			}
		}

		if (andCondition)
			return true;

		for (Condition condition : conditionList) {
			if (condition.Connector == LogicConnector.OR) {
				if (condition.Check()) {
					return true;
				}
			}
		}

		return false;
	}

	void FullList(Condition obj) {
		if (obj == null)
			return;
		conditionList.add(obj);
		FullList(obj.NextCondition);
	}
}
