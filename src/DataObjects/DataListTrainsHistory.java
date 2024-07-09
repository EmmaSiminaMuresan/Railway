package DataObjects;


import java.io.Serializable;
import java.time.LocalTime;

import DataOnly.ListTrains;
import DataOnly.ListTrainsHistory;
import Enumerations.PetriObjectType;
import Interfaces.PetriObject;
public class DataListTrainsHistory implements Interfaces.PetriObject, Cloneable, Serializable {
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
        return PetriObjectType.DataListTrainsHistory;
    }

    public ListTrainsHistory Value = new ListTrainsHistory();


    @Override
    public void SetValue(Object value) {

    }

    // Overriding clone() method of Object class
    public PetriObject clone() throws CloneNotSupportedException {
        return (DataListTrainsHistory) super.clone();
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
    public Object GetValue() {
        return Value;
    }

    @Override
    public String GetPlatform(int i) {return Value.getPlatform(i);}

    @Override
    public LocalTime GetDepTime(int i) {return Value.GetDepTime(i);}

    @Override
    public LocalTime GetLeavingTime(int i) {return Value.GetLeavingTime(i);}
    public int GetLength(int i) {return Value.GetLength(i);}

    public int LastIndex() {return Value.LastIndex();}
    @Override
    public String GetName() {
        return name;
    }
    public int GetSize() {return Value.GetSize();}
    public ListTrains GetElement(int i){return Value.Trains.get(i).Value;}

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



