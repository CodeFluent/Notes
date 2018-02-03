/**
 * Line draws a line onto a Canvas by taking in 4 double values (that are always positive)
 * which are subtracted from the y-axis to make the graph.
 */

package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Line extends Pane{

    private double y1;
    private double y2;
    private double y3;
    private double y4;

    public Line() {
        y1 = 0.0;
        y2 = 0.0;
        y3 = 0.0;
        y4 = 0.0;
    }

    public Line(double y1, double y2, double y3, double y4) {
        // always make absolute so that it shows in the 300x300 Canvas.
        this.y1 = Math.abs(y1);
        this.y2 = Math.abs(y2);
        this.y3 = Math.abs(y3);
        this.y4 = Math.abs(y4);
    }


    public void drawLine(GraphicsContext gc) {

        final double canvas_height = gc.getCanvas().getHeight();
        final double canvas_width = gc.getCanvas().getWidth();

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(4);
        gc.strokeRect(0,0, canvas_width, canvas_height);

        gc.beginPath();
        gc.moveTo(50, canvas_height - y1 );
        gc.lineTo(75, canvas_height - y2 );
        gc.lineTo(100, canvas_height - y3);
        gc.lineTo(125, canvas_height - y4);
        gc.stroke();
    }

}


