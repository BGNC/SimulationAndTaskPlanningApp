import model.RouteModel;
import ui.ControlPanel;
import ui.MapPanel;

import javax.swing.*;
import java.awt.*;

public class MissionPlanningApp extends JFrame {
    private MapPanel mapPanel;
    private ControlPanel controlPanel;
    private RouteModel routeModel;

    public MissionPlanningApp() {
        setTitle("Görev Planlama ve Simülasyon Aracı");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        routeModel = new RouteModel();
        mapPanel = new MapPanel(routeModel);
        controlPanel = new ControlPanel(mapPanel, routeModel);

        add(mapPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MissionPlanningApp app = new MissionPlanningApp();
            app.setVisible(true);
        });

    }
}