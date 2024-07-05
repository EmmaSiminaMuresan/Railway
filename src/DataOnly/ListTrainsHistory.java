package DataOnly;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import DataObjects.DataListTrains;
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

///// i should have also the .txt file (3 files each station)

    public ListTrainsHistory() {

    }

    public boolean AddTrain(DataListTrains train) {
        String timeString = "23:59:59";

        DataListTrains lastTrain = Trains.get(Trains.size() - 1);
        LocalTime lastDepTime = lastTrain.getTime();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime timeStringC = LocalTime.parse(timeString, formatter);

        if (lastDepTime.isBefore(timeStringC)) {
            Trains.add(train);
            return true;
        }
        return true;
    }

//
//        if (formattedTime) {
//            Trains.add(train);
//            return true;
//        } else {
//            for (int i = 0; i < Trains.size(); i++) {
//                if (Trains.get(i) == null) {
//                    Trains.set(i, train);
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

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

