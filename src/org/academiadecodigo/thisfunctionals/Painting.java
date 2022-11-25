package org.academiadecodigo.thisfunctionals;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.geom.Rectangle2D;

public class Painting implements KeyboardHandler {
    public static final int PADDING = 10;
    public static final int CELLSIZE = 20;

    private Rectangle paintRect;
    private Rectangle paintRect2;
    private Painting[] paintR = new Painting[];

    public Painting() {

        paintRect = new Rectangle(PADDING, PADDING, CELLSIZE, CELLSIZE);
        paintRect2 = new Rectangle(PADDING, PADDING, CELLSIZE, CELLSIZE);
        paintRect.setColor(Color.BLUE);
        keyboardInit();
        paintRect.fill();

    }


    public void keyboardInit() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent pressRight = new KeyboardEvent();
        pressRight.setKey(KeyboardEvent.KEY_RIGHT);
        pressRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pressLeft = new KeyboardEvent();
        pressLeft.setKey(KeyboardEvent.KEY_LEFT);
        pressLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pressDown = new KeyboardEvent();
        pressDown.setKey(KeyboardEvent.KEY_DOWN);
        pressDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pressUp = new KeyboardEvent();
        pressUp.setKey(KeyboardEvent.KEY_UP);
        pressUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(pressRight);
        keyboard.addEventListener(pressLeft);
        keyboard.addEventListener(pressDown);
        keyboard.addEventListener(pressUp);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        for (Painting p : paintR) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
                if (p.paintRect.getY() + CELLSIZE <= CELLSIZE * CELLSIZE) {
                    paintRect.translate(0, 20);
                    paintRect.fill();

                }
            /*if (paintRect.getY() + CELLSIZE <= CELLSIZE*CELLSIZE ) {
                paintRect.translate(0, 20);
                paintRect.fill();
                //paintRect.grow(paintRect.getX(), paintRect.getY());
                }*/
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                if (p.paintRect.getX() + CELLSIZE <= CELLSIZE * CELLSIZE) {
                    paintRect.translate(20, 0);
                    paintRect.fill();

                }
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
                if (paintRect.getY() > PADDING) {
                    paintRect.translate(0, -20);
                    paintRect.fill();
                }

            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
                if (paintRect.getX() > PADDING) {
                    paintRect.translate(-20, 0);
                    paintRect.fill();
                }
            }
            // if (PADDING == KeyboardEvent.KEY_LEFT){
            //}

        }
    }

        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){

        }
}


