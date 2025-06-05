import javax.swing.*;
import java.util.Vector;

public class Window extends JFrame {
    public Window() {
        generateFrame();
    }

    public void generateFrame() {
        Vector<Float> temperatures = new Vector<>();

        TemperatureListModel tempListModel = new TemperatureListModel();

        tempListModel.add(2.14f);
        tempListModel.add(17f);
        tempListModel.add(8.14f);
        tempListModel.add(14.14f);
        tempListModel.add(53.14f);
        tempListModel.add(93.14f);
        tempListModel.add(23.14f);
        tempListModel.add(31.14f);
        tempListModel.add(-113.14f);
        tempListModel.add(113.14f);
        tempListModel.add(-33.14f);

        JList tempList = new JList();

        tempList.setModel(tempListModel);
        tempList.setCellRenderer(new TemperatureHeatMapListCellRenderer());

        JScrollPane jScrollPane = new JScrollPane(tempList);

        this.getContentPane().add(jScrollPane);

        setSize(800, 800);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
