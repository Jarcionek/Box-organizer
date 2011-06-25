import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JTextField;

/**
 * @version 28/02/2011
 * @author Jaroslaw Pawlak
 */
public class XTextField extends JTextField {
    private XTextField() {}

    public XTextField(final XFrame frame) {
        super();
        setHorizontalAlignment(JTextField.CENTER);
        setPreferredSize(new Dimension(80, 20));
        addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                int ch = e.getKeyChar();
                if (ch == KeyEvent.VK_ENTER) {
                    frame.calculate();
                } else if (ch != KeyEvent.VK_BACK_SPACE
                        && ch != KeyEvent.VK_DELETE
                        && !(ch >= 48 && ch <= 57)
                        && !e.isControlDown() /* for copy/cut/paste only */) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                frame.calculate();
            }

        });
        addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                XTextField.this.setSelectionStart(0);
                XTextField.this.setSelectionEnd(XTextField.this.getText().length());
            }

        });
    }

    @Override
    public void paste() {
        try {
            Transferable content = Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getContents(null);
            if(content != null && content.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String result = (String) content.getTransferData(DataFlavor.stringFlavor);
                String text = this.getText();
                text = text.substring(0, this.getSelectionStart())
                        + result.replaceAll("[^0123456789]", "")
                        + text.substring(this.getSelectionEnd());
                this.setText(text);
            }
        } catch (UnsupportedFlavorException ex) {
        } catch (IOException ex) {}
    }
}