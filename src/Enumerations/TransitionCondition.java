package Enumerations;

import java.io.Serializable;

public enum TransitionCondition implements Serializable{
	Undefined,
	Equal,
	NotEqual,
	MoreThan,
	MoreThanOrEqual,
	LessThan,
	LessThanOrEqual,
	Contains,
	NotContains,
	IsNull,
	NotNull,
	HaveCarForMe,
	CanAddCars,
	CanNotAddCars,
	HaveCar,
	HaveREL,
	SubPetriStopped,

	CanAddTrains_List,
	CanAddTrains_HList,
	CanNotAddTrains_HList,
	CanNotAddTrains_List,
	HaveTrainForMe,
	HaveListTrain_History,
	Have_NoListTrain,
	HaveListTrain,
	CheckTime_After,
	CheckTime_Before,
	
	Equal_FloatFloat,   //the new transition conditions for floatfloat
	MoreThan_FloatFloat,
	MoreThanOrEqual_FloatFloat,
	LessThan_FloatFloat,
	LessThanOrEqual_FloatFloat,
}
