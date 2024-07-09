package PetriDataPackage;

import java.io.Serializable;
import java.util.ArrayList;

import Components.PetriTransition;
import DataObjects.*;
import Enumerations.TransitionOperation;
import Utilities.Functions;

public class GuardActivation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String InputPlaceName;
	public ArrayList<String> InputPlaceNames;
	public String OutputPlaceName;
	public ArrayList<String> OutputPlaceNames;
	public TransitionOperation Operation;

	public DataTrain T;
	public DataLocalTime Dep_Time;
	public DataString Dep_Platform;
	public DataLocalTime C_Time;
	public DataLocalTime Time;
	public DataString C_Platform;
	public DataListTrainsHistory list;
	public DataInteger length1;
	public DataInteger length2;
	public DataInteger speed;
	public DataListTrains list_train;
	public DataListTrainsQueue list_queue_in;
	public DataListTrainsQueue list_queue_out;
	public DataListTrainsHistory old_history;
	public DataListTrainsHistory new_history;
	public DataString filePath;

	public DataListTrainsQueue time;
	public DataInteger seconds;
	public DataString Controller;

	public GuardActivation() {
	}
	
	public GuardActivation(String InputPlaceName, TransitionOperation Condition, String OutputPlaceName) {
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
	}

	public GuardActivation(ArrayList<String> InputPlaceNames, TransitionOperation Condition,
			String OutputPlaceName) {
		this.InputPlaceNames = InputPlaceNames;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
	}

	public GuardActivation(String InputPlaceName, TransitionOperation Condition,
			ArrayList<String> OutputPlaceNames) {
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceNames = OutputPlaceNames;
		this.Operation = Condition;
	}

	public GuardActivation( DataInteger seconds, DataString controller, TransitionOperation Condition) {
		this.seconds = seconds;
		this.Controller = controller;
		this.Operation = Condition;
	}

	public GuardActivation(  DataListTrainsHistory old_history, DataString filePath, TransitionOperation Condition,
					  DataListTrainsHistory new_history) {
		  
		 
		this.old_history = old_history;
		this.filePath = filePath;
		this.new_history = new_history;
		this.Operation = Condition;
	}

	public GuardActivation(  DataListTrains list_train, TransitionOperation Condition) {
		  
		 
		this.list_train = list_train;
		this.Operation = Condition;
	}

	public GuardActivation(  DataListTrainsQueue list_queue_in,  TransitionOperation Condition,
					  DataListTrainsQueue list_queue_out) {
		  
		 
		this.list_queue_in = list_queue_in;
		this.list_queue_out = list_queue_out;
		this.Operation = Condition;

	}

	public GuardActivation(  DataTrain train,  DataInteger length1, DataInteger length2,  DataInteger speed, TransitionOperation Condition,
					  DataLocalTime time) {
		  
		 
		this.T = train;
		this.length1 = length1;
		this.length2 = length2;
		this.speed = speed;
		this.Time = time;
		this.Operation = Condition;
	}

	public GuardActivation( DataTrain train,  DataInteger speed, TransitionOperation Condition,
					  DataInteger time) {
		  
		 
		this.T = train;
		this.speed = speed;
		this.seconds = time;
		this.Operation = Condition;
	}

	public GuardActivation(  DataListTrainsQueue time, TransitionOperation Condition,
					  DataInteger seconds) {
		  
		 
		this.time = time;
		this.seconds = seconds;
		this.Operation = Condition;
	}

	public GuardActivation(DataListTrainsQueue list_queue_in, TransitionOperation Condition) {

		this.list_queue_in = list_queue_in;
		this.Operation = Condition;
	}

	public GuardActivation(  DataTrain train, DataLocalTime dep_time, DataString dep_platform, DataLocalTime c_time, DataString c_platform,DataListTrainsHistory list, DataInteger length1, DataInteger length2,  DataInteger speed, TransitionOperation Condition,
					  DataListTrains list_train) {
		  
		 
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

	public GuardActivation(  DataTrain train, DataLocalTime dep_time, DataString dep_platform, DataListTrainsHistory list, DataInteger length1, DataInteger length2,  DataInteger speed, TransitionOperation Condition,
					  DataListTrains list_train) {
		  
		 
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


}
