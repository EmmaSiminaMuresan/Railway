package DataObjects;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import DataOnly.ListTrains;
import DataOnly.Train;
import Enumerations.PetriObjectType;
import Interfaces.PetriObject;
public class DataListTrains implements Interfaces.PetriObject, Cloneable, Serializable{
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
    public PetriObjectType GetType() {
        return PetriObjectType.DataListTrains;
    }

    public ListTrains Value = null;

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
        if (value instanceof ListTrains) {
            Value = (ListTrains) value;
            SetToken(true);
        }
    }

    // Overriding clone() method of Object class
    public PetriObject clone() throws CloneNotSupportedException {
        return (DataListTrains) super.clone();
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

    public ListTrains getValue() {
        return Value;
    }

    public Train getTrain() {return Value.getTrain();}
    public List<Object> getTrainAttributes() {return Value.getTrainAttributes();}

    public LocalTime getDep_time() {
        return Value.getDep_time();
    }

    public LocalTime getLeaving_time() {
        return Value.getLeaving_time();
    }

    public String getPlatform(){
        return Value.getPlatform();
    }
    public int GetLength() {return Value.getTrain().Length;}

    public String GetTrainNumber() { return Value.geTrainNumber();}

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
