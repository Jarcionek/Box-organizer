import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @version 28/02/2011
 * @author Jaroslaw Pawlak
 */
public class ArrangementDrawing extends JPanel {
    private static final int MARGIN = 10;

    private Box box = null;
    private Box container = null;

    public ArrangementDrawing() {}

    public void setBoxes(Box box, Box container) {
        this.box = box;
        this.container = container;
    }

    @Override
    public void paint(Graphics g) {
        if (box != null && container != null && box.countIn(container) > 0) {
            int width = g.getClipBounds().width - 2 * MARGIN;
            int height = g.getClipBounds().height - 2 * MARGIN;

            int cLength = (int) (0.8d * width);
            int cHeight = (int) (0.8d * height);
            int cWidth = (int) Math.sqrt((width - cLength) * (width - cLength)
                    + (height - cHeight) * (height - cHeight));

            int bLength = (int) (1.0d * cLength * box.getLength() / container.getLength());
            int bHeight = (int) (1.0d * cHeight * box.getHeight() / container.getHeight());
            int bWidth = (int) (1.0d * cWidth * box.getWidth() / container.getWidth());


            //BACK RECTANGLES
            g.setColor(Color.red);
            g.drawRect(MARGIN + width - cLength,
                    MARGIN,
                    cLength,
                    cHeight);
            g.setColor(Color.blue);
            g.drawRect(MARGIN + (width - cLength) * bWidth / cWidth,
                    MARGIN + height - bHeight - ((height - cHeight) * bWidth / cWidth),
                    bLength,
                    bHeight);

            //DEPTH
            g.setColor(Color.red);
            g.drawLine(MARGIN,
                    MARGIN + height - cHeight,
                    MARGIN + width - cLength,
                    MARGIN);
            g.drawLine(MARGIN + cLength,
                    MARGIN + height - cHeight,
                    MARGIN + width,
                    MARGIN);
            g.drawLine(MARGIN,
                    MARGIN + height,
                    MARGIN + width - cLength,
                    MARGIN + cHeight);
            g.drawLine(MARGIN + cLength,
                    MARGIN + height,
                    MARGIN + width,
                    MARGIN + cHeight);
            
            g.setColor(Color.blue);
            g.drawLine(MARGIN,
                    MARGIN + height - bHeight,
                    MARGIN + (width - cLength) * bWidth / cWidth,
                    MARGIN + height - bHeight - ((height - cHeight) * bWidth / cWidth));
            g.drawLine(MARGIN + bLength,
                    MARGIN + height - bHeight,
                    MARGIN + (width - cLength) * bWidth / cWidth + bLength,
                    MARGIN + height - bHeight - ((height - cHeight) * bWidth / cWidth));
            g.drawLine(MARGIN,
                    MARGIN + height,
                    MARGIN + (width - cLength) * bWidth / cWidth,
                    MARGIN + height - bHeight - ((height - cHeight) * bWidth / cWidth) + bHeight);
            g.drawLine(MARGIN + bLength,
                    MARGIN + height,
                    MARGIN + (width - cLength) * bWidth / cWidth + bLength,
                    MARGIN + height - bHeight - ((height - cHeight) * bWidth / cWidth) + bHeight);

            //FRONT RECTANGLES
            g.setColor(Color.red);
            g.drawRect(MARGIN,
                    MARGIN + height - cHeight,
                    cLength,
                    cHeight);
            g.setColor(Color.red);
            g.setColor(Color.blue);
            g.drawRect(MARGIN,
                    MARGIN + height - bHeight,
                    bLength,
                    bHeight);
        }
    }
}