package com.example.game;

import java.util.ArrayList;

public class Kub {
    int x =0;
    int y = 0;
    int color;
    int side;
    int width;
    int state;
    int kostyl1;
    int pointss;
    ArrayList<Kub> svc;
    public Kub(int color, int side, int width, ArrayList<Kub> svc,int state)
    {   this.state = state;
        this.color = color;
        this.side = side;
        this.width = width;
        this.svc = svc;

    }
    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setY()
    {
        this.y=y+side/10;
    }

    public void setX(int a)
    {
        kostyl1 =0;
        switch(a) {
            case 1:
                for (Kub k : svc){
                    if(this.x+side==k.x && this.y+side>=k.y)
                        kostyl1=1; // ploho
                }
                if(x<width-side && kostyl1 ==0)
            this.x = x + side * a;
                break;
            case -1:
                for (Kub k : svc){
                    if(this.x-side==k.x && this.y+side>=k.y)
                        kostyl1=1; // ploho
                }
                if(x>0 && kostyl1==0)
                    this.x = x + side * a;
                break;
            case 100:
                this.x = 500;
                break;
        }
    }
}
