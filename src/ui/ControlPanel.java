package ui;


import controller.AddRouteAction;
import controller.StartSimulationAction;
import model.RouteModel;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    public ControlPanel(MapPanel mapPanel, RouteModel routeModel) {
        JButton addRouteButton = new JButton("Rota Ekle");
        JButton startSimulationButton = new JButton("Simülasyonu Başlat");
        JButton clearButton = new JButton("Temizle");

        addRouteButton.addActionListener(new AddRouteAction(mapPanel, routeModel));
        startSimulationButton.addActionListener(new StartSimulationAction(mapPanel, routeModel));
        clearButton.addActionListener(e -> {
            routeModel.clearRoutes();
            mapPanel.repaint();
        });

        add(addRouteButton);
        add(startSimulationButton);
        add(clearButton);
    }
}
