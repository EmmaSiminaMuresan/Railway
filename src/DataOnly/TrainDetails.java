package DataOnly;

import java.io.Serializable;

import DataObjects.DataString;
import DataObjects.DataInteger;
import DataObjects.DataTrain;


public class TrainDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    public DataTrain dataTrain;
    public DataString departureTime;
    public DataString platform;
    public DataInteger A1_Length;
    public DataInteger A2_Length;
    public DataInteger A3_Length;
    public DataInteger A4_Length;
    public DataInteger speedOnPlatform;

    public TrainDetails(DataTrain dataTrain, DataString departureTime, DataString platform,
                        DataInteger A1_Length, DataInteger A2_Length, DataInteger A3_Length,
                        DataInteger A4_Length, DataInteger speedOnPlatform) {
        this.dataTrain = dataTrain;
        this.departureTime = departureTime;
        this.platform = platform;
        this.A1_Length = A1_Length;
        this.A2_Length = A2_Length;
        this.A3_Length = A3_Length;
        this.A4_Length = A4_Length;
        this.speedOnPlatform = speedOnPlatform;
    }
}
