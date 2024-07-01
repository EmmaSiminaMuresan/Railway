package DataOnly;

import java.io.Serializable;
import java.util.ArrayList;

import DataObjects.DataTrain;
public class TrainQueue implements Cloneable, Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Overriding clone() method of Object class
    public TrainQueue clone() throws CloneNotSupportedException {
        return (TrainQueue) super.clone();
    }

    public ArrayList<DataTrain> Trains = new ArrayList<DataTrain>();

    public Integer Size = 2;

    public TrainQueue() {

    }

    public boolean AddTrain(DataTrain train) {
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

    public boolean CanAddtrain() {
        if (Trains.size() < Size) {
            return true;
        } else {
            for (int i = 0; i < Trains.size(); i++) {
                if (Trains.get(i) == null) {
                    return true;
                }
            }
        }
        return false;
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

    public DataTrain PopTrain(String target) {
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
                DataTrain temp = (DataTrain) Trains.get(index).clone();
                Trains.set(index, null);
                return temp;

            } catch (CloneNotSupportedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    public DataTrain PopTrainWithoutTarget() {
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
                DataTrain temp = (DataTrain) Trains.get(index).clone();
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
        for (DataTrain train : Trains) {
            if (train == null)
                temp1.add("NULL");
            else
                temp1.add(train.toString());
        }

        return "(" + String.join(",", temp1) + ")";
    }
}
