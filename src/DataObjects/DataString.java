package DataObjects;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalTime;

import Enumerations.PetriObjectType;
import Interfaces.PetriObject;

public class DataString implements Interfaces.PetriObject, Cloneable, Serializable {
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
		return PetriObjectType.DataString;
	}

	public String Value;

	@Override
	public Object GetValue() {
		return Value;
	}

	public String GetString() {return Value;}
	public void textfile(){
		if(GetValue().toString().contains(".txt")){
			try(BufferedWriter writer = new BufferedWriter(new FileWriter(Value))){

			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void SetValue(Object value) {
		if (value == null) {
			Value = null;
			SetToken(false);
		}
		if (value instanceof String) {
			Value = (String) value;
			SetToken(true);
		}
	}

	// Overriding clone() method of Object class
	public PetriObject clone() throws CloneNotSupportedException {
		return (DataString) super.clone();
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
			return GetName() + "(Null)";
		}
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

	@Override
	public void AddElement(Object value) {
		// TODO Auto-generated method stub

	}

	public boolean Contains(String search){
		boolean result = Value.contains(search);
		return result;
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
