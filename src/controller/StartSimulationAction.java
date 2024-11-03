package controller;



import ui.MapPanel;
import model.RouteModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartSimulationAction implements ActionListener {
    private MapPanel mapPanel;
    private RouteModel routeModel;
    private Timer simulationTimer;

    public StartSimulationAction(MapPanel mapPanel, RouteModel routeModel) {
        this.mapPanel = mapPanel;
        this.routeModel = routeModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (routeModel.getPoints().size() < 2) {
            JOptionPane.showMessageDialog(mapPanel, "Simülasyonu başlatmak için en az iki nokta ekleyin.");
            return;
        }

        routeModel.startSimulation();

        simulationTimer = new Timer(500, event -> {
            routeModel.incrementIndex();
            if (routeModel.getCurrentIndex() >= routeModel.getPoints().size()) {
                simulationTimer.stop();
                routeModel.stopSimulation();
                JOptionPane.showMessageDialog(mapPanel, "Simülasyon Tamamlandı.");
            }
            mapPanel.repaint();
        });
        simulationTimer.start();
    }
}

