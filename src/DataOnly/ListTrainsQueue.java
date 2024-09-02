package DataOnly;


import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import DataObjects.DataListTrains;
import DataObjects.DataListTrainsQueue;
import DataObjects.DataREL;
import DataObjects.DataTrain;
import com.sun.jdi.Value;

public class ListTrainsQueue implements Cloneable, Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Overriding clone() method of Object class
    public ListTrainsQueue clone() throws CloneNotSupportedException {
        return (ListTrainsQueue) super.clone();
    }

    public ArrayList<DataListTrains> Trains = new ArrayList<DataListTrains>();

    public Integer Size = 2;

    public ListTrainsQueue() {

    }
    public DataTrain PopTrains() {
        Integer index = -1;
        for (int i = 0; i < Trains.size(); i++) {
            if (Trains.get(i) != null && Trains.get(i).Value.train != null) {
                index = i;
                break;
            }
        }

        if (index == -1)
            return null;
        if (Trains.get(index) != null) {
            Train train = Trains.get(index).getTrain();
            DataTrain temp = new DataTrain();
            temp.SetValue(train);
            Trains.set(index, null);
            return temp;

        }
        return null;
    }
    public void setSize(int size){
        this.Size = size;
    }

    public int getSize() {return Trains.size();}

    public String getPlatform(int i) {
        if(getSize()==0) return null;
        else return Trains.get(i).getPlatform();
    }

    public LocalTime GetLeavingTime(int i) {return Trains.get(i).getLeaving_time();}

    public LocalTime GetDepTime(int i) {
        return Trains.get(i).getDep_time();
    }

    public int GetLength(int i) {return Trains.get(i).GetLength();}

    public boolean AddTrain(DataListTrains train) {
        if (Trains.size() < Size) {
            Trains.add(train);
            return true;
        } else {
            for (int i = 0; i < Trains.size(); i++) {
                if (Trains.get(i) == null) {
                    Trains.set(i, train);
                    return true;
                }
            }
        }
        return false;
    }

//    public boolean CanAddtrain() {
//        if (Trains.size() < Size) {
//            return true;
//        } else {
//            for (int i = 0; i < Trains.size(); i++) {
//                if (Trains.get(i) == null) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
public boolean CanAddtrain(Object trainToAdd) {
    // Assuming Trains is a ListTrainsQueue, which holds multiple DataListTrains objects
    for (DataListTrains existingTrain : Trains) {
        if (existingTrain != null) {
            // Check if the trainToAdd is already in the ListTrainsQueue
            if (existingTrain.equals(trainToAdd)) {
                return false; // Train is already in the list, so it cannot be added again
            }
        }
    }

    // Check if there's space to add a new train
    if (Trains.size() < Size) {
        return true;
    } else {
        // Check if there are any null slots available
        for (int i = 0; i < Trains.size(); i++) {
            if (Trains.get(i) == null) {
                return true;
            }
        }
    }

    return false; // No space available or the train is already added
}



    public boolean CanNotAddtrain() {
        if (Trains.size() >= Size) {
            return true;
        } else {
            for (int i = 0; i < Trains.size(); i++) {
                if (Trains.get(i) == null) {
                    return false;
                }
            }
        }
        return false;
    }

    public void Remove(){
        Trains.remove(0);
    }

    public int LastIndex(){
        if(Trains.isEmpty())  return 0;
        else return Trains.size()-1;

    }

    public DataListTrains PopTrain(String target) {
        Integer index = -1;
        for (int i = 0; i < Trains.size(); i++) {
            if (Trains.get(i) != null && Trains.get(i).Value != null)
                if (Trains.get(i).Value.Targets.contains(target)) {
                    index = i;
                    break;
                }
        }

        if (index == -1)
            return null;
        if (Trains.get(index) != null) {
            try {
                DataListTrains temp = (DataListTrains) Trains.get(index).clone();
                Trains.set(index, null);
                return temp;

            } catch (CloneNotSupportedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    public DataListTrains PopTrainWithoutTarget() {
        Integer index = -1;
        for (int i = 0; i < Trains.size(); i++) {
            if (Trains.get(i) != null && Trains.get(i).Value != null) {
                index = i;
                break;
            }
        }

        if (index == -1)
            return null;
        if (Trains.get(index) != null) {
            try {
                DataListTrains temp = (DataListTrains) Trains.get(index).clone();
                Trains.set(index, null);
                return temp;

            } catch (CloneNotSupportedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
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

