import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * @version 28/02/2011
 * @author Jaroslaw Pawlak
 */
class XButton extends JButton {
    private static final int AMOUNT = 1;

    private XButton() {}

    /**
     * @param textField true for incrementer, false for decrementer
     * @param incrementer
     */
    public XButton(final XFrame frame, final XTextField textField, final boolean incrementer) {
        super();
        setPreferredSize(new Dimension(40, 20));
        if (incrementer) {
            this.setText("+");
        } else {
            this.setText("-");
        }
        this.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int x = textField.getText().equals("") ?
                    0 : Integer.parseInt(textField.getText());
                x += incrementer ? AMOUNT : -AMOUNT;
                x = x < 0 ? 0 : x;
                textField.setText("" + x);
                frame.calculate();
            }

        });
    }
}
