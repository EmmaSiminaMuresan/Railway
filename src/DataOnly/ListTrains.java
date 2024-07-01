package DataOnly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class ListTrains implements Cloneable, Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Overriding clone() method of Object class
    public ListTrains clone() throws CloneNotSupportedException {
        return (ListTrains) super.clone();
    }

    public Train train;
    public String time;
    public String platform;
    public List<String> Targets;

    public ListTrains(Train train, String time, String platform) {
        this.train = train;
        this.time = time;
        this.platform = platform;
    }

    public ListTrains(Train train, String time, String platform, String[] Targets) {
        this.train = train;
        this.time = time;
        this.platform = platform;
        this.Targets = new ArrayList<String>();
        for (String string : Targets) {
            this.Targets.add(string);
        }
    }
    public List<Object> getTrainAttributes() {
        return train.getAttributes();
    }

    public Train getTrain(){
        return train;
    }

    public String getTime() {
        return time;
    }

    public String getPlatform() {
        return platform;
    }

    public String toString() {
        return "Train " + train.toString() + " leaves at " + time + " on platform " + platform;
    }

}