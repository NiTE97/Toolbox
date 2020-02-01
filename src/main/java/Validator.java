/**
 * Klasse zum Ueberpruefen von Werten/Eingabe
 */

public class Validator {
    
    public static void check(boolean bedingung, String msg){
        if(bedingung){
            throw new IllegalArgumentException(msg);
        }
    }
    
    /**
     * Methode zum Ueberpruefen des Datentyps
     * 
     * ALLE "object" muessen mit Namen und Datentyp angepasst werden!
     * @param o
     */
    @Override
    public boolean equals (Object o) {
        if (o instanceof Object ){
             Object object = (Object)o;
        return true;
        }else{
            return false;
}
    
}
    // Gehoert zu equals()
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
}
