package model;

import java.awt.*;
import java.util.ArrayList;

public class RouteModel {
    private ArrayList<Point> points = new ArrayList<>();
    private int currentIndex = 0;
    private boolean simulating = false;

    public ArrayList<Point> getPoints() {
        return points;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public boolean isSimulating() {
        return simulating;
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void clearRoutes() {
        points.clear();
        currentIndex = 0;
        simulating = false;
    }

    public void startSimulation() {
        currentIndex = 0;
        simulating = true;
    }

    public void incrementIndex() {
        currentIndex++;
    }

    public void stopSimulation() {
        simulating = false;
    }
}
