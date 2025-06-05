import javax.swing.*;
import java.util.Vector;

public class TemperatureListModel extends AbstractListModel {

    Vector<Float> temperatures;

    public TemperatureListModel() {
        this.temperatures = new Vector<Float>();
    }

    @Override
    public int getSize() {
        return temperatures.size();
    }

    @Override
    public Object getElementAt(int index) {
        return temperatures.elementAt(index);
    }

    public void add(Float el) {
        this.temperatures.add(el);
    }
}
