package DataObjects;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import DataOnly.SubPetri;
import Enumerations.PetriObjectType;
import Interfaces.PetriObject;

public class DataSubPetriNet implements PetriObject, Cloneable, Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void Execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub

	}
	@Override
	public List<String> getTargets(){
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String GetPlatform(int i){
		// TODO Auto-generated method stub
		return "";
	}
	@Override
	public LocalTime GetDepTime(int i){
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public LocalTime GetLeavingTime(int i){
		// TODO Auto-generated method stub
		return null;

	}
	@Override
	public void Stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public PetriObjectType GetType() {
		return PetriObjectType.DataSubPetri;
	}

	public SubPetri Value;

	@Override
	public Object GetValue() {
		return Value;
	}

	@Override
	public void SetValue(Object value) {
		if (value == null) {
			Value = null;
			SetToken(false);
		}
		if (value instanceof SubPetri) {
			Value = (SubPetri) value;
			SetToken(true);
		}
	}

	@Override
	public void AddElement(Object value) {
		// TODO Auto-generated method stub

	}

	private String name = "";

	@Override
	public String GetName() {
		return name;
	}

	@Override
	public void SetName(String name) {
		this.name = name;
	}

	public boolean Printable = true;
	@Override
	public boolean IsPrintable() {
		return Printable;
	}

	public String toString() {
		if (Value != null) {
			return GetName() + "(" + GetValue().toString() + ")";
		} else {
			return GetName() +"(Null)";
		}
	}
	// Overriding clone() method of Object class
	public PetriObject clone() throws CloneNotSupportedException {
		return (DataSubPetriNet) super.clone();
	}

	private boolean token;

	@Override
	public void SetToken(boolean token) {
		this.token = token;
	}

	@Override
	public boolean GetToken() {
		return this.token;
	}
}
