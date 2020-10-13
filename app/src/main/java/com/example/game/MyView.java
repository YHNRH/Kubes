package com.example.game;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class MyView extends View {

    ArrayList<Kub> iTvar = new ArrayList<>();
    ArrayList<Kub> listNatashaKrasotkaiTvar = new ArrayList<>();
    Paint p;
    // координаты для рисования квадрата
    Kub k1;
    int cc =0;
    int cheburek = 0;
    float x_down = 0;
    float x_zalupa = 0;
    int kostyl = 0;
    int superkostyl = 0;
    String buf = "0";
    int height = 1000;
    int width = 500;
    int side = width/5;
    public MyView(Context context) {
        super(context);
        p = new Paint();
        hui();
    }

    public boolean onTouchEvent(MotionEvent event) {
        // координаты Touch-события
        float evX = event.getX();
        float evY = event.getY();
    switch (event.getAction()) {
            // касание началось
            case MotionEvent.ACTION_DOWN:
                // если касание было начато в пределах квадрата
                Log.d("msg", "najato");
                x_down = evX;
                kostyl =1;
                break;
            // тащим
            case MotionEvent.ACTION_MOVE:
                // если режим перетаскивания включен
                x_zalupa = evX;
                if(x_zalupa>x_down+200 && kostyl == 1) {
                    Log.d("msg", "jopa");
                    kostyl = 0;
                    k1.setX(1);
                }

                if(x_zalupa+200<x_down && kostyl == 1) {
                    Log.d("msg", "jopa_left");
                    kostyl = 0;
                    k1.setX(-1);
                }

                break;
            // касание завершено
            case MotionEvent.ACTION_UP:
                // выключаем режим перетаски
                Log.d("msg", " ne " +
                        "najato");

                break;
        default:

    }
        return true;
    }
    protected void onDraw(Canvas canvas) {
        // рисуем квадрат

        p.setColor(Color.BLACK);
        canvas.drawRect(0,0,width,height, p);
        p.setTextSize(50.0f);
        canvas.drawText(String.valueOf(cc),width+side, 50, p);
        switch (k1.color)


        { case (1):
            p.setColor(Color.BLUE);
            break;
            case (2):
                p.setColor(Color.RED);
                break;
            case (3):
                p.setColor(Color.MAGENTA);
                break;
            case (4):
                p.setColor(Color.GREEN);
                break;
            case (5):
                p.setColor(Color.YELLOW);
                break;
            case (6):
                p.setColor(Color.CYAN);
                break;
        }

        canvas.drawRect(k1.getX(),k1.getY(),k1.getX()+side,k1.getY()+side, p);

        for (Kub k : listNatashaKrasotkaiTvar)
        {
            switch (k.color)


            { case (1):
                p.setColor(Color.BLUE);
                canvas.drawRect(k.getX(), k.getY(), k.getX() + side, k.getY() + side, p);
                break;
                case (2):
                    p.setColor(Color.RED);
                    canvas.drawRect(k.getX(), k.getY(), k.getX() + side, k.getY() + side, p);
                    break;
                case (3):
                    p.setColor(Color.MAGENTA);
                    canvas.drawRect(k.getX(), k.getY(), k.getX() + side, k.getY() + side, p);
                    break;
                case (4):
                    p.setColor(Color.GREEN);
                    canvas.drawRect(k.getX(), k.getY(), k.getX() + side, k.getY() + side, p);
                    break;
                case (5):
                    p.setColor(Color.YELLOW);
                    canvas.drawRect(k.getX(), k.getY(), k.getX() + side, k.getY() + side, p);
                    break;
                case (6):
                    p.setColor(Color.CYAN);
                    canvas.drawRect(k.getX(), k.getY(), k.getX() + side, k.getY() + side, p);
                    break;
            }
        }
    }

    public void hui()
    {
    Thread tr = new Thread(
            () ->
            {
                while (true) {




                    if(cheburek==0){
                        if (superkostyl==0)
                        {k1 = new Kub((int)(Math.random()*6+1), side, width, listNatashaKrasotkaiTvar,0);
                            cheburek = 1;
                        superkostyl++;
                        }
                        else if(k1.state==1) {
                            iTvar.add(k1);
                            k1 = new Kub((int)(Math.random()*6+1), side, width, listNatashaKrasotkaiTvar,0);
                            cheburek = 1;
                        }

                        else {
                            listNatashaKrasotkaiTvar.add(k1);
                            k1 = new Kub((int)(Math.random()*6+1), side, width, listNatashaKrasotkaiTvar,0);
                            cheburek = 1;
                        }
                    }
                    else if (cheburek==1){

                            try {
                                if(iTvar.size()/2<=1)
                                Thread.sleep(50);
                                else if(iTvar.size()/2==2)

                                Thread.sleep(36);

                                else if(iTvar.size()/2>=3)

                                    Thread.sleep(25);


                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            this.invalidate();

                            k1.setY();
                        }
                    if(k1.getY()+side>=height )
                    {
                        cheburek=0; // 1 horosho 0 ploho

                    }
                    cc=iTvar.size();
                    for(Kub vsk : listNatashaKrasotkaiTvar)
                    {
                        if ( vsk.color == k1.color && k1.getX()==vsk.getX() && k1.getY()+side+(side/10)==vsk.getY()){
                            k1.state=1;


                        }
                        if( k1.getY()+side>=vsk.getY() && k1.getX()==vsk.getX())
                        {
                            cheburek=0; // 1 horosho 0 ploho


                        }

                    }

                }


                    }
            );
        tr.start();
}

}
