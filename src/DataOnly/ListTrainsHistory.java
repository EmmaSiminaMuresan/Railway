package DataOnly;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

    public LocalTime Last_Dep_Time() {return Trains.get(Trains.size()-1).getDep_time();}
    public boolean AddTrain(DataListTrains train) {
        Trains.add(train);
        return true;
    }

//    public boolean CanAddtrain() {
////        if (Trains.size() < Size) {
////            return true;
////        } else {
////            for (int i = 0; i < Trains.size(); i++) {
////                if (Trains.get(i) == null) {
////                    return true;
////                }
////            }
////        }
//        return false;
//    }

//    public boolean CanNotAddtrain() {
////        if (Trains.size() >= Size) {
////            return true;
////        } else {
////            for (int i = 0; i < Trains.size(); i++) {
////                if (Trains.get(i) == null) {
////                    return false;
////                }
////            }
////        }
////        return false;
//    }
//
//    public String toString() {
//        ArrayList<String> temp1 = new ArrayList<String>();
//        for (DataListTrains train : Trains) {
//            if (train == null)
//                temp1.add("NULL");
//            else
//                temp1.add(train.toString());
//        }
//
//        return "(" + String.join(",", temp1) + ")";
//    }
}

