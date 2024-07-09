package DataOnly;

import java.io.Serializable;
import java.time.LocalTime;
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
    public LocalTime dep_time;
    public LocalTime leaving_time;
    public String platform;
    public List<String> Targets;

    public ListTrains(Train train, LocalTime time, String platform) {
        this.train = train;
        this.dep_time = time;
        this.platform = platform;
    }

    public ListTrains(Train train, LocalTime dep_time,LocalTime leaving_time, String platform) {
        this.train = train;
        this.dep_time = dep_time;
        this.leaving_time = leaving_time;
        this.platform = platform;
    }

    public ListTrains(Train train, LocalTime time,LocalTime leaving_time, String platform, String[] Targets) {
        this.train = train;
        this.dep_time = time;
        this.leaving_time = leaving_time;
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

    public LocalTime getDep_time() {
        return dep_time;
    }
    public LocalTime getLeaving_time() {return leaving_time;}

    public String getPlatform() {
        return platform;
    }

    public String geTrainNumber() {
        return train.Number;
    }

    public String toString() {
        return "Train " + train.toString() + " leaves at " + dep_time + " on platform " + platform;
    }

}