package edu.illinois.cs.cs125.fall2019.mp;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class AreaDivider {
    /**
     * @param latitude of the north boundary
     */
    private double north;

    /**
     * @param longitude of the east boundary
     */
    private double east;

    /**
     * @param latitude of south boundary
     */
    private double south;

    /**
     * @param longitude of west boundary
     */
    private double west;

    /**
     * @param the requested side length of each cell, in meters
     */
    private double cellSize;


    AreaDivider(final double setNorth, final double setEast, final
        double setSouth, final double setWest, final double setCellSize) {
        north = setNorth;
        east = setEast;
        south = setSouth;
        west = setWest;
        cellSize = setCellSize;

    }

    public static com.google.android.gms.maps.model.LatLngBounds getCellBounds(final int x, final int y) {
        return LatLngBounds.builder().build();
    }

    /***
     * @return number of cells in the x direction
     */
    public int getXCells() {
        return (int) Math.ceil(LatLngUtils.distance(north, east, north, west) / cellSize);
    }

    /**
     * @param location = location in terms of latitude and longitude
     * @return x coordinate of location
     */
    public int getXCoordinate(final com.google.android.gms.maps.model.LatLng location) {
/*        if (location.longitude >= west && location.longitude <= cellSize + west) {
            return 0;
        }*/
//        for (int i = 1; i <= getXCells(); i++) {
//            if (location.longitude <= (cellSize * i) + west && location.longitude >= (cellSize * (i - 1)) + west) {
//                return i - 1;
//            }
//        }
        for (int i = 1; i <= getXCells(); i++) {
            double leftDistance = Math.ceil(LatLngUtils.distance(north,
                    (west + (cellSize * (i - 1))), north, location.longitude));
            double rightDistance = Math.ceil(LatLngUtils.distance(north,
                    location.longitude, north, (west + (cellSize * i))));
            i