package Enumerations;

import java.io.Serializable;

public enum PetriObjectType implements Serializable{
	Undefined,
	PetriNet,
	DataInteger,
	DataFloat,
	PetriPlace,
	PetriTransition,
	DataString,
	DataCar,
	DataCarQueue,
	DataTransfer,
	DataREL,
	DataRELQueue,
	DataSubPetri,
	PetriData,
	DataBoolean,
	DataTrain,
	DataTrainQueue,
	DataDate,
	DataListTrains,
	DataListTrainsHistory,
	DataListTrainsQueue,
	DataLocalTime,
	
	DataFloatFloat	//the new data type
}
