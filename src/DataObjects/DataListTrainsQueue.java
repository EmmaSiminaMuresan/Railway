package DataObjects;

import java.io.Serializable;
import java.time.LocalTime;

import DataOnly.ListTrainsQueue;
import Enumerations.PetriObjectType;
import Interfaces.PetriObject;
public class DataListTrainsQueue implements Interfaces.PetriObject, Cloneable, Serializable {
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
    public void Stop() {
        // TODO Auto-generated method stub

    }

    @Override
    public PetriObjectType GetType() {
        return PetriObjectType.DataListTrainsQueue;
    }

    public ListTrainsQueue Value = new ListTrainsQueue();

    @Override
    public Object GetValue() {
        return Value;
    }

    public int GetSize() {return Value.getSize();}

    public String GetPlatform(int i) {return Value.getPlatform(i);}

    public LocalTime GetDepTime(int i) {return Value.GetDepTime(i);}

    public LocalTime GetLeavingTime(int i) {return Value.GetLeavingTime(i);}
    public int GetLength(int i) {return Value.GetLength(i);}

    public int LastIndex() {return Value.LastIndex();}

    @Override
    public void SetValue(Object value) {

    }

    // Overriding clone() method of Object class
    public PetriObject clone() throws CloneNotSupportedException {
        return (DataListTrainsQueue) super.clone();
    }

    public boolean Printable = true;
    @Override
    public boolean IsPrintable() {
        return Printable;
    }
    public String toString() {
        if (Value != null) {
            return GetName() + "|" + Value.toString() + "|";
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

    @Override
    public void AddElement(Object value) {
        if (value == null) {
            Value = null;
            SetToken(false);
        }
        if (value instanceof DataListTrains) {
            Value.AddTrain((DataListTrains) value);
            SetToken(true);
        }
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


