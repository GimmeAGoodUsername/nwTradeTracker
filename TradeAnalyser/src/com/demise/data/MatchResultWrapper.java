package com.demise.data;

public class MatchResultWrapper {
    private int x;
    private int y;
    private double match;
    private int scaledx,scaledy;

    public int getScaledx() {
        return scaledx;
    }

    public void setScaledx( int scaledx ) {
        this.scaledx = scaledx;
    }

    public int getScaledy() {
        return scaledy;
    }

    public void setScaledy( int scaledy ) {
        this.scaledy = scaledy;
    }

    public int getX() {
        return x;
    }

    public void setX( int x ) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY( int y ) {
        this.y = y;
    }

    public double getMatch() {
        return match;
    }

    public void setMatch( double match ) {
        this.match = match;
    }

    @Override
    public String toString() {
        return "MatchResultWrapper{" +
                "x=" + x +
                ", y=" + y +
                ", match=" + match +
                ", scaledx=" + scaledx +
                ", scaledy=" + scaledy +
                '}';
    }
}
