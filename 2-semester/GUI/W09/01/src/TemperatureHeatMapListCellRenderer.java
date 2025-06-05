import javax.swing.*;
import java.awt.*;

public class TemperatureHeatMapListCellRenderer extends JLabel implements ListCellRenderer {
    public TemperatureHeatMapListCellRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        float celcius = (float) value;
        System.out.println(celcius);
        float farenheit = (((float)value * 9/5) + 32);
        setText(celcius + " stopni C = " + farenheit);

        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));

        if (celcius < 6) {
            System.out.println(celcius + " blue");
            setBackground(Color.BLUE);
        }
        else if (celcius > 25) {
            System.out.println(celcius + " red");
            setBackground(Color.RED);
        }
        else {
            System.out.println(celcius + " white");
            setBackground(Color.LIGHT_GRAY);
        }

        return this;
    }
}
