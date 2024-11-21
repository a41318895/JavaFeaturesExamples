package java8Features.methodReferences.objectMethodReference;

public class StringUtil {

    private final String str1 ;

    // Constructor to set the instance status parameter 1st
    public StringUtil(String str1) {

        this.str1 = str1 ;
    }

    // Instance Methods
    public String concat(String str2) {

        return this.str1 + " " + str2 ;
    }

    public String toUpperCase(String str2) {

        return (this.str1 + " " + str2).toUpperCase() ;
    }

    public String reverse(String str2) {

        return new StringBuilder(this.str1 + " " + str2)
                .reverse()
                .toString() ;
    }

    // Handle Method: Accept a functionalInterface and the other parameter
    public String doHandleString(StringHandler<StringUtil> stringHandler, String str) {

        return stringHandler.handleString(this, str) ;
    }
}
