package ui;

import model.RouteModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MapPanel extends JPanel {
    private RouteModel routeModel;

    public MapPanel(RouteModel routeModel) {
        this.routeModel = routeModel;
        setBackground(Color.LIGHT_GRAY);

        // Fare tıklamalarını dinlemek için MouseAdapter ekleyin
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();  // Tıklanan noktayı al
                routeModel.addPoint(point);  // Modele ekle
                repaint();  // Haritayı güncelle
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Rota noktalarını çiz
        g.setColor(Color.BLUE);
        for (int i = 0; i < routeModel.getPoints().size(); i++) {
            Point point = routeModel.getPoints().get(i);
            g.fillOval(point.x - 5, point.y - 5, 10, 10); // Noktayı çizin

            // İki nokta arasında çizgi çizin
            if (i > 0) {
                Point previousPoint = routeModel.getPoints().get(i - 1);
                g.drawLine(previousPoint.x, previousPoint.y, point.x, point.y);
            }
        }

        // Simülasyon sırasında hareket eden noktayı kırmızı olarak gösterin
        if (routeModel.isSimulating() && routeModel.getCurrentIndex() < routeModel.getPoints().size()) {
            g.setColor(Color.RED);
            Point currentPoint = routeModel.getPoints().get(routeModel.getCurrentIndex());
            g.fillOval(currentPoint.x - 5, currentPoint.y - 5, 10, 10);
        }
    }
}
