package DataOnly;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataObjects.DataListTrains;
import com.sun.jdi.Value;

public class ListTrainsHistory implements Cloneable, Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Overriding clone() method of Object class
    public ListTrainsHistory clone() throws CloneNotSupportedException {
        return (ListTrainsHistory) super.clone();
    }

    public ArrayList<DataListTrains> Trains = new ArrayList<DataListTrains>();


    public ListTrainsHistory() {
    }

    public int GetSize() {return Trains.size();}

    public void Remove(int i){
        Trains.remove(i);
    }

    public String getPlatform(int i) {return Trains.get(i).getPlatform();}

    public LocalTime GetLeavingTime(int i) {return Trains.get(i).getLeaving_time();}

    public LocalTime GetDepTime(int i) {return Trains.get(i).getDep_time();}

    public int GetLength(int i) {return Trains.get(i).GetLength();}

    public int LastIndex(){
        if(Trains.isEmpty())  return 0;
        else return Trains.size()-1;

    }

    public LocalTime Last_Dep_Time() {
        if(Trains.size()>0){
            return Trains.get(Trains.size()-1).getDep_time();
        }
       return null;
    }
    public boolean AddTrain(DataListTrains train) {
        Trains.add(train);
        return true;
    }


    public String toString() {
       ArrayList<String> temp1 = new ArrayList<String>();
        for (DataListTrains train : Trains) {
            if (train == null)
               temp1.add("NULL");
            else
                temp1.add(train.toString());
        }

        return "(" + String.join(",", temp1) + ")";
    }
}

