package record.pureDataClassToRecord;

import record.pureDataClassToRecord.pureData.PointPureDataClass;
import record.pureDataClassToRecord.record.PointRecord;

public class Test {

    /*
        In Pure Data Class,
        we still need to implement constructor to initialize
        some non-initialized value of member variables.
        We also need to write member variables declaration
        and public getters to access them.

        But in Record,
        It offers a default public constructor to new an instance,
        and we are no need to write member variable declaration,
        and also no need to implement the public getters.
        Every member variables we defined are private to access directly,
        because it is an immutable class.
     */
    public static void main(String[] args) {

        // PointPureDataCLass
        PointPureDataClass pointPureDataClass1 = new PointPureDataClass(4, 5) ;
        PointPureDataClass pointPureDataClass2 = new PointPureDataClass(4, 5) ;
        PointPureDataClass pointPureDataClass3 = new PointPureDataClass(5, 6) ;

        System.out.println("pointPureDataClass1 equals pointPureDataClass2 ? : " + pointPureDataClass1.equals(pointPureDataClass2)) ;
        System.out.println("pointPureDataClass1 equals pointPureDataClass3 ? : " + pointPureDataClass1.equals(pointPureDataClass3)) ;

        System.out.println("pointPureDataClass1: " + pointPureDataClass1) ;


        // PointRecord
        PointRecord pR1 = new PointRecord(4, 5) ;
        System.out.println("pR1's XCoordinate: " + pR1.xCoordinate()) ;
        System.out.println("pR1's YCoordinate: " + pR1.yCoordinate()) ;

        //pR1.xCoordinate = 5  // ERROR: Can't access

        PointRecord pR2 = new PointRecord(5, 6) ;
        System.out.println("Is pR1 equals pR2 ? : " + pR2.equals(pR1)) ;
    }
}
