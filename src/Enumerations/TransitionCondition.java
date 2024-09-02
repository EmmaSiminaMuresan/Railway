package Enumerations;

import java.io.Serializable;

public enum TransitionCondition implements Serializable{
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
	Check_Platform_History,
	Check_Transition_Target_List_NO,
	Check_Transition_Target_List,
	Platform,
	Platform_To_Send,
	//HasElements,
	CheckDepartureTime,
	EqualDepartureTime,
	CheckLeavingTime,
	HaveListTrain_History,
	Have_NoListTrain_History,
	CheckTime_After,
	CheckTime_Before,
	
	Equal_FloatFloat,   //the new transition conditions for floatfloat
	MoreThan_FloatFloat,
	MoreThanOrEqual_FloatFloat,
	LessThan_FloatFloat,
	LessThanOrEqual_FloatFloat,
}
