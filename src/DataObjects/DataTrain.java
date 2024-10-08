package DataObjects;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import DataOnly.Train;
import Enumerations.PetriObjectType;
import Interfaces.PetriObject;
public class DataTrain implements Interfaces.PetriObject, Cloneable, Serializable{
    private static final long serialVersionUID = 1L;
    @Override
    public void AddElement(Object value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void Execute() {
        // TODO Auto-generated method stub

    }

    @Override
    public void Start() {
        // TODO Auto-generated method stub

    }

    @Override
    public void Stop() {
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
    public PetriObjectType GetType() {
        return PetriObjectType.DataTrain;
    }

    public Train Value ;

    @Override
    public Object GetValue() {
        return Value;
    }
    public int GetLength() {
        if(this.Value == null) return 0;
        if(Value.Length != 0)
            return Value.Length;
        else return 0;
    }

    @Override
    public void SetValue(Object value) {
        if (value == null) {
            Value = null;
            SetToken(false);
        }
        if (value instanceof Train) {
            Value = (Train) value;
            SetToken(true);
        }
    }

    // Overriding clone() method of Object class
    public PetriObject clone() throws CloneNotSupportedException {
        return (DataTrain) super.clone();
    }

    @Override
    public List<String> getTargets() {
        return Value.getTargets();
    }

    public boolean Printable = true;

    @Override
    public boolean IsPrintable() {
        return Printable;
    }

    public List<Object> getAttributes() {return Value.getAttributes();}


    public String toString() {
        if (Value != null) {
            return GetName() + "(" + GetValue().toString() + ")";
        } else {
            return GetName() +"(Null)";
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
