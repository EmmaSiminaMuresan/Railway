package Enumerations;

import java.io.Serializable;

public enum TransitionOperation implements Serializable{
	Undefined,
	Add,
	Sub,
	Prod,
	Div,
	Mod,
	Move,
	Copy,
	AddElement,
	PopElementWithTarget,
	PopElementWithoutTarget,
	PopElementWithTargetToQueue,
	PopElementWithoutTargetToQueue,
	SendOverNetwork,
	SendROverNetwork,
	SendPetriNetOverNetwork,
	PopElement_R_E,
	ActivateSubPetri,
	StopPetriNet,
	MakeNull,
	CalculateTime,
	CalculateDelay,
	CalculateLightTimeStation,
	CalculateLightTimeRailway,
	CreateTrain_NotNull,
	DoNothing,
	PopElement_Train,
	MessageBox_Controllers,
	MessageBox_SupervisorA,
	MessageBox_SupervisorB,
	MessageBox_SupervisorC,
	SendTrainOverNetwork,
	CreateTrain_Null,
	RemoveFirst,
	SaveAndDelete,
	
	Add_FloatFlaot,  //the new activations for floatfloat
	Sub_FloatFloat,
	Prod_FloatFloat,
	Div_FloatFloat,
	
	DynamicDelay
}
