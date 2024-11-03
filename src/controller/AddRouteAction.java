package controller;


import ui.MapPanel;
import model.RouteModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRouteAction implements ActionListener {
    private MapPanel mapPanel;
    private RouteModel routeModel;

    public AddRouteAction(MapPanel mapPanel, RouteModel routeModel) {
        this.mapPanel = mapPanel;
        this.routeModel = routeModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(mapPanel, "Haritaya tıklayarak rota noktalarını ekleyin.");
    }
}
