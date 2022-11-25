package org.academiadecodigo.thisfunctionals;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PaintGrid {
    private static final int PADDING = 10;
    private int cols;
    private int rows;
    private Rectangle field;
    private int cellsize = 20;
    private Rectangle[][] inside = new Rectangle[cellsize][cellsize];

    private int width;
    private int heigh;

    public PaintGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        /*this.inside = inside;
        this.width = width;
        this.heigh = heigh;*/
        init();
       createrect();
       Painting p1 = new Painting();


    }
    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

    public void init() {
        this.field = new Rectangle(PADDING, PADDING, cols*cellsize, rows*cellsize);
        field.draw();

    }
    public int getWidth() {
        return this.field.getWidth();
    }

    public int getHeigh() {
        return this.field.getHeight();
    }

    public int getCellSize() {
        return cellsize;
    }
    public int getX(){
        return this.field.getX();
    }
    public int getY(){
        return this.field.getY();
    }

    public void createrect() {
        for (int i = 0; i < cols; i++) { //x
            for (int j = 0; j < rows; j++) { //y
                this.inside[i][j] = new Rectangle(PADDING + i * cellsize, PADDING + j * cellsize, cellsize, cellsize);
                this.inside[i][j].draw();

            }
        }
    }





}


