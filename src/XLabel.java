import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * @version 28/02/2011
 * @author Jaroslaw Pawlak
 */
public class XLabel extends JLabel{
    /**
     * Preffered width for new XLabels
     */
    public static int preferredWith = 80;

    private XLabel() {}

    public XLabel(String text) {
        super(text);
        setHorizontalAlignment(SwingConstants.CENTER);
        if (preferredWith != 0) {
            setPreferredSize(new Dimension(preferredWith, 20));
        }
    }
}