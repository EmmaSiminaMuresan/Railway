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

	Equal_Length,
	MoreThan_Length,
	CanAddTrains_List,
	CanNotAddTrains_List,
	Platform,
	HaveTrainForMe,
	HaveListTrain_History,
	Have_NoListTrain,
	Have_NoListTrain_History,
	HaveListTrain,
	CheckTime_After,
	CheckTime_Before,
	
	Equal_FloatFloat,   //the new transition conditions for floatfloat
	MoreThan_FloatFloat,
	MoreThanOrEqual_FloatFloat,
	LessThan_FloatFloat,
	LessThanOrEqual_FloatFloat,
}
