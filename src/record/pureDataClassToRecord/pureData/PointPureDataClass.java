package record.pureDataClassToRecord.pureData;

public class PointPureDataClass {

    // Member Variables
    private final int xCoordinate ;

    private final int yCoordinate ;

    // Constructor
    public PointPureDataClass(int xCoordinate, int yCoordinate) {

        this.xCoordinate = xCoordinate ;
        this.yCoordinate = yCoordinate ;
    }

    // Getters
    public int xCoordinate() {

        return this.xCoordinate ;
    }

    public int yCoordinate() {

        return this.yCoordinate ;
    }

    // Override methods
    @Override
    public boolean equals(Object obj) {

        // The same instance
        if (this == obj) return true ;

        // If input obj is null, or they're not the instance of same class
        if (obj == null || getClass() != obj.getClass()) return false ;

        // They're the instance of same Class, but not the same instance
        PointPureDataClass point = (PointPureDataClass) obj ;

        if (this.xCoordinate != point.xCoordinate()) return false ;

        return this.yCoordinate == point.yCoordinate ;
    }

    @Override
    public String toString() {

        return String.format("[ X: %d, Y: %d ]", this.xCoordinate, this.yCoordinate) ;
    }
}
