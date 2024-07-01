package DataOnly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Train implements Cloneable, Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Overriding clone() method of Object class
    public Train clone() throws CloneNotSupportedException {
        return (Train) super.clone();
    }

    public String Number;
    public int Length;
    public List<String> Targets;

    public Train(int Length, String Number, ArrayList<String> Targets) {
        this.Length = Length;
        this.Number = Number;
        this.Targets = new ArrayList<String>();
        this.Targets.addAll(Targets);
    }

    public Train(int Length, String Number, String[] Targets) {
        this.Length = Length;
        this.Number = Number;
        this.Targets = new ArrayList<String>();
        for (String string : Targets) {
            this.Targets.add(string);
        }
    }

    public List<Object> getAttributes() {
        List<Object> attributes = new ArrayList<>();
        attributes.add(Length);
        attributes.add(Number);
        return attributes;
    }
    public int getLength() {
        return Length;
    }

    public String toString() {
        return "Train " + Number + " having " + Length + " m";
    }

}
