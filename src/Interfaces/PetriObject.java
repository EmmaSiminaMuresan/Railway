package Interfaces;

import Enumerations.PetriObjectType;

import java.time.LocalTime;
import java.util.List;

public interface PetriObject {
	
	public void Execute();

	public void Start();
	
	public void Stop();
	
	public PetriObjectType GetType();

	public Object GetValue();
	public List<String> getTargets();
	public String GetPlatform(int i);
	public LocalTime GetDepTime(int i);
	public LocalTime GetLeavingTime(int i);

	public void SetValue(Object value);
	
	public void AddElement(Object value);
	
	public String GetName();

	public void SetName(String name);
	
	public String toString();
	
	public boolean IsPrintable();
	
	public void SetToken(boolean token);

	public boolean GetToken();
}
