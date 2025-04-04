import java.io.Serializable;

public class Piornik implements Serializable {
    Olowek dep1;
    Dep2 dep2;

    public Piornik (Olowek dep1, Dep2 dep2){
        this.dep1 = dep1;
        this.dep2 = dep2;
    }
}
