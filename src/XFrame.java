import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @version 28/02/2011
 * @author Jaroslaw Pawlak
 */
public class XFrame extends JFrame {
    private static final DecimalFormat ratio = new DecimalFormat("#.##%");
    private static final DecimalFormat number = new DecimalFormat("#,###");

    private XLabel boxWidthLabel;
    private XLabel boxLengthLabel;
    private XLabel boxHeightLabel;
    private XLabel boxWeightLabel;
    private XLabel boxAmountLabel;
    private XLabel boxVolumeDescLabel;
    private XLabel boxTotalWeightDescLabel;
    private XLabel boxTotalVolumeDescLabel;

    private XTextField boxWidthTextField;
    private XTextField boxLengthTextField;
    private XTextField boxHeightTextField;
    private XTextField boxWeightTextField;
    private XTextField boxAmountTextField;
    private XLabel boxVolumeLabel;
    private XLabel boxTotalWeightLabel;
    private XLabel boxTotalVolumeLabel;

    private XButton boxWidthUpButton;
    private XButton boxWidthDownButton;
    private XButton boxLengthUpButton;
    private XButton boxLengthDownButton;
    private XButton boxHeightUpButton;
    private XButton boxHeightDownButton;
    private XButton boxWeightUpButton;
    private XButton boxWeightDownButton;
    private XButton boxAmountUpButton;
    private XButton boxAmountDownButton;


    private XLabel containerWidthLabel;
    private XLabel containerLengthLabel;
    private XLabel containerHeightLabel;
    private XLabel containerWeightLabel;
    private XLabel containerVolumeDescLabel;

    private XTextField containerWidthTextField;
    private XTextField containerLengthTextField;
    private XTextField containerHeightTextField;
    private XTextField containerWeightTextField;
    private XLabel containerVolumeLabel;

    private XButton containerWidthUpButton;
    private XButton containerWidthDownButton;
    private XButton containerLengthUpButton;
    private XButton containerLengthDownButton;
    private XButton containerHeightUpButton;
    private XButton containerHeightDownButton;
    private XButton containerWeightUpButton;
    private XButton containerWeightDownButton;


    private XLabel bestArrangementWidthLabel;
    private XLabel bestArrangementLengthLabel;
    private XLabel bestArrangementHeightLabel;
    private ArrangementDrawing arrangementDrawing;


    private XLabel boxesInContainerDescLabel;
    private XLabel boxesInContainerLabel;
    private XLabel volumeRatioDescLabel;
    private XLabel volumeRatioLabel;
    private XLabel weightRatioDescLabel;
    private XLabel weightRatioLabel;
    private XLabel requiredContainersDescLabel;
    private XLabel requiredContainersLabel;
    private XLabel allocationDescLabel;
    private XLabel allocationOneLabel;
    private XLabel allocationORLabel;
    private XLabel allocationTwoLabel;


    private XTextArea textArea;
    private JButton resetButton;
    private JButton printButton;

    public XFrame() {
        super("Calculator");
        this.createComponents();
        this.setContentPane(this.createContentPane());
        this.setMinimumSize(new Dimension(400, 300));
        this.center();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void createComponents() {
        boxWidthLabel = new XLabel("Width");
        boxLengthLabel = new XLabel("Length");
        boxHeightLabel = new XLabel("Height");
        boxWeightLabel = new XLabel("Weight");
        boxAmountLabel = new XLabel("Amount");
        boxVolumeDescLabel = new XLabel("Volume:");
        boxTotalWeightDescLabel = new XLabel("Total weight:");
        boxTotalVolumeDescLabel = new XLabel("Total volume:");

        boxWidthTextField = new XTextField(this);
        boxLengthTextField = new XTextField(this);
        boxHeightTextField = new XTextField(this);
        boxWeightTextField = new XTextField(this);
        boxAmountTextField = new XTextField(this);
        XLabel.preferredWith = 0;
        boxVolumeLabel = new XLabel("");
        boxTotalWeightLabel = new XLabel("");
        boxTotalVolumeLabel = new XLabel("");

        boxWidthUpButton = new XButton(this, boxWidthTextField, true);
        boxWidthDownButton = new XButton(this, boxWidthTextField, false);
        boxLengthUpButton = new XButton(this, boxLengthTextField, true);
        boxLengthDownButton = new XButton(this, boxLengthTextField, false);
        boxHeightUpButton = new XButton(this, boxHeightTextField, true);
        boxHeightDownButton = new XButton(this, boxHeightTextField, false);
        boxWeightUpButton = new XButton(this, boxWeightTextField, true);
        boxWeightDownButton = new XButton(this, boxWeightTextField, false);
        boxAmountUpButton = new XButton(this, boxAmountTextField, true);
        boxAmountDownButton = new XButton(this, boxAmountTextField, false);


        XLabel.preferredWith = 60;
        containerWidthLabel = new XLabel("Width");
        containerLengthLabel = new XLabel("Length");
        containerHeightLabel = new XLabel("Height");
        containerWeightLabel = new XLabel("Weight");
        containerVolumeDescLabel = new XLabel("Volume:");

        containerWidthTextField = new XTextField(this);
        containerLengthTextField = new XTextField(this);
        containerHeightTextField = new XTextField(this);
        containerWeightTextField = new XTextField(this);
        XLabel.preferredWith = 0;
        containerVolumeLabel = new XLabel("");

	containerWidthUpButton = new XButton(this, containerWidthTextField, true);
        containerWidthDownButton = new XButton(this, containerWidthTextField, false);
        containerLengthUpButton = new XButton(this, containerLengthTextField, true);
        containerLengthDownButton = new XButton(this, containerLengthTextField, false);
        containerHeightUpButton = new XButton(this, containerHeightTextField, true);
        containerHeightDownButton = new XButton(this, containerHeightTextField, false);
        containerWeightUpButton = new XButton(this, containerWeightTextField, true);
        containerWeightDownButton = new XButton(this, containerWeightTextField, false);

        XLabel.preferredWith = 120;
        boxesInContainerDescLabel = new XLabel("Max. boxes in container:");
        boxesInContainerLabel = new XLabel("");
        volumeRatioDescLabel = new XLabel("Volume ratio:");
        volumeRatioLabel = new XLabel("");
        weightRatioDescLabel = new XLabel("Weight ratio:");
        weightRatioLabel = new XLabel("");
        requiredContainersDescLabel = new XLabel("Required containers:");
        requiredContainersLabel = new XLabel("");
        XLabel.preferredWith = 280;
        allocationDescLabel = new XLabel("Possible allocation:");
        allocationDescLabel.setBorder(BorderFactory
                .createMatteBorder(1, 0, 0, 0, Color.black));
        allocationOneLabel = new XLabel("");
        allocationORLabel = new XLabel("");
        allocationTwoLabel = new XLabel("");

        XLabel.preferredWith = 0;
        bestArrangementWidthLabel = new XLabel("");
        bestArrangementLengthLabel = new XLabel("");
        bestArrangementHeightLabel = new XLabel("");
        arrangementDrawing = new ArrangementDrawing();

        textArea = new XTextArea();
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                XFrame.this.calculate();
            }

        });
        printButton = new JButton("Print");
        printButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textArea.setFocusable(false);
                Color c = textArea.getSelectionColor();
                textArea.setSelectionColor(null);

                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(textArea);
                if (job.printDialog()) {
                    try {
                        job.print();
                    } catch (PrinterException ex) {}
                }

                textArea.setSelectionColor(c);
                textArea.setFocusable(true);
            }

        });
    }

    private JComponent createContentPane() {
        final int GAP = 5;
        final GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 0, GAP, GAP);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                XFrame.this.calculate();
            }

        });

        JPanel boxTab = new JPanel(new GridBagLayout());
        boxTab.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, 0, 0));
        c.gridy = 0;
        boxTab.add(boxWidthLabel, c);
        boxTab.add(boxWidthTextField, c);
        boxTab.add(boxWidthDownButton, c);
        boxTab.add(boxWidthUpButton, c);
        c.gridy = 1;
        boxTab.add(boxLengthLabel, c);
        boxTab.add(boxLengthTextField, c);
        boxTab.add(boxLengthDownButton, c);
        boxTab.add(boxLengthUpButton, c);
        c.gridy = 2;
        boxTab.add(boxHeightLabel, c);
        boxTab.add(boxHeightTextField, c);
        boxTab.add(boxHeightDownButton, c);
        boxTab.add(boxHeightUpButton, c);
        c.gridy = 3;
        boxTab.add(boxWeightLabel, c);
        boxTab.add(boxWeightTextField, c);
        boxTab.add(boxWeightDownButton, c);
        boxTab.add(boxWeightUpButton, c);
        c.gridy = 4;
        boxTab.add(boxAmountLabel, c);
        boxTab.add(boxAmountTextField, c);
        boxTab.add(boxAmountDownButton, c);
        boxTab.add(boxAmountUpButton, c);
        c.gridy = 5;
        boxTab.add(boxVolumeDescLabel, c);
        c.gridwidth = 3;
        boxTab.add(boxVolumeLabel, c);
        c.gridwidth = 1;
        c.gridy = 6; 
        boxTab.add(boxTotalWeightDescLabel, c);
        c.gridwidth = 3;
        boxTab.add(boxTotalWeightLabel, c);
        c.gridwidth = 1;
        c.gridy = 7;
        boxTab.add(boxTotalVolumeDescLabel, c);
        c.gridwidth = 3;
        boxTab.add(boxTotalVolumeLabel, c);
        c.gridwidth = 1;
        tabbedPane.addTab("Box", boxTab);

        JPanel containerTab = new JPanel(new GridBagLayout());
        containerTab.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, 0, 0));
        c.gridy = 0;
        containerTab.add(containerWidthLabel, c);
        containerTab.add(containerWidthTextField, c);
        containerTab.add(containerWidthDownButton, c);
        containerTab.add(containerWidthUpButton, c);
        c.gridy = 1;
        containerTab.add(containerLengthLabel, c);
        containerTab.add(containerLengthTextField, c);
        containerTab.add(containerLengthDownButton, c);
        containerTab.add(containerLengthUpButton, c);
        c.gridy = 2;
        containerTab.add(containerHeightLabel, c);
        containerTab.add(containerHeightTextField, c);
        containerTab.add(containerHeightDownButton, c);
        containerTab.add(containerHeightUpButton, c);
        c.gridy = 3;
        containerTab.add(containerWeightLabel, c);
        containerTab.add(containerWeightTextField, c);
        containerTab.add(containerWeightDownButton, c);
        containerTab.add(containerWeightUpButton, c);
        c.gridy = 4;
        containerTab.add(containerVolumeDescLabel, c);
        c.gridwidth = 3;
        containerTab.add(containerVolumeLabel, c);
        c.gridwidth = 1;
        tabbedPane.addTab("Container", containerTab);

        JPanel arrangementTab = new JPanel(new BorderLayout(GAP, GAP));
        JPanel top = new JPanel(new GridLayout(3, 1, GAP, GAP));
        top.add(bestArrangementWidthLabel);
        top.add(bestArrangementLengthLabel);
        top.add(bestArrangementHeightLabel);
        arrangementTab.add(top, BorderLayout.NORTH);
        arrangementTab.add(arrangementDrawing, BorderLayout.CENTER);
        tabbedPane.addTab("Arrangement", arrangementTab);

        JPanel calculationsTab = new JPanel(new GridBagLayout());
        calculationsTab.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, 0, 0));
        c.gridy = 0;
        calculationsTab.add(boxesInContainerDescLabel, c);
        calculationsTab.add(boxesInContainerLabel, c);
        c.gridy = 1;
        calculationsTab.add(volumeRatioDescLabel, c);
        calculationsTab.add(volumeRatioLabel, c);
        c.gridy = 2;
        calculationsTab.add(weightRatioDescLabel, c);
        calculationsTab.add(weightRatioLabel, c);
        c.gridy = 3;
        calculationsTab.add(requiredContainersDescLabel, c);
        calculationsTab.add(requiredContainersLabel, c);
        c.gridwidth = 2;
        c.gridy = 4;
        calculationsTab.add(allocationDescLabel, c);
        c.gridy = 5;
        calculationsTab.add(allocationOneLabel, c);
        c.gridy = 6;
        calculationsTab.add(allocationORLabel, c);
        c.gridy = 7;
        calculationsTab.add(allocationTwoLabel, c);
        tabbedPane.addTab("Calculations", calculationsTab);

        JPanel printTab = new JPanel(new BorderLayout());
        printTab.add(new JScrollPane(textArea), BorderLayout.CENTER);
        JPanel printButtons = new JPanel(new GridLayout(1, 2));
        printButtons.add(resetButton);
        printButtons.add(printButton);
        printTab.add(printButtons, BorderLayout.SOUTH);
        tabbedPane.addTab("Print", printTab);

        return tabbedPane;
    }

    /**
     * Must be invoked after setting size
     */
    public void center() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((size.width - this.getWidth()) / 2,
                (size.height - this.getHeight()) / 2);
    }

    public void calculate() {
        Box box = null;
        Box container = null;
        int boxes = 0;
        String text = "";
        String temp;

        //BOX
        try {
            int width = Integer.parseInt(boxWidthTextField.getText());
            int length = Integer.parseInt(boxLengthTextField.getText());
            int height = Integer.parseInt(boxHeightTextField.getText());
            int weight = boxWeightTextField.getText().equals("")?
                0 : Integer.parseInt(boxWeightTextField.getText());
            box = new Box(width, length, height, weight);
        } catch (Exception ex) {}

        //AMOUNT OF BOXES
        if (!boxAmountTextField.getText().equals("")) {
            try {
                boxes = Integer.parseInt(boxAmountTextField.getText());
            } catch (NumberFormatException ex) {}
        }

        //CONTAINER
        try {
            int width = Integer.parseInt(containerWidthTextField.getText());
            int length = Integer.parseInt(containerLengthTextField.getText());
            int height = Integer.parseInt(containerHeightTextField.getText());
            int weight = containerWeightTextField.getText().equals("")?
                0 : Integer.parseInt(containerWeightTextField.getText());
            container = new Box(width, length, height, weight);
        } catch (Exception ex) {}

        //CALCULATIONS
        arrangementDrawing.setBoxes(null, null);

        if (box != null) {
            boxVolumeLabel.setText(number.format(box.getVolume()));
            text += "Box sizes: " + box.getWidth() + " x " + box.getLength()
                    + " x " + box.getHeight() + "\n";
            text += "Box's volume: " + number.format(box.getVolume()) + "\n";
            text += "Box's weight: " + box.getWeight() + "\n";
        } else {
            boxVolumeLabel.setText("");
            boxTotalWeightLabel.setText("");
            boxTotalVolumeLabel.setText("");

            bestArrangementWidthLabel.setText("");
            bestArrangementLengthLabel.setText("");
            bestArrangementHeightLabel.setText("");

            boxesInContainerLabel.setText("");
            volumeRatioLabel.setText("");
            weightRatioLabel.setText("");
            requiredContainersLabel.setText("");
            allocationOneLabel.setText("");
            allocationORLabel.setText("");
            allocationTwoLabel.setText("");
        }

        if (boxes == 0) {
            boxTotalWeightLabel.setText("");
            boxTotalVolumeLabel.setText("");
            volumeRatioLabel.setText("");
            weightRatioLabel.setText("");
            requiredContainersLabel.setText("");
            allocationOneLabel.setText("");
            allocationORLabel.setText("");
            allocationTwoLabel.setText("");
        }

        if (box != null && boxes != 0) {
            boxTotalWeightLabel.setText(number.format(1L * boxes * box.getWeight()));
            boxTotalVolumeLabel.setText(number.format(boxes * box.getVolume()));
            text += "Amount of boxes: " + boxes + "\n";
            text += "Total boxes' weight: " + number.format(1L * boxes * box.getWeight()) + "\n";
            text += "Total boxes' volume: " + number.format(boxes * box.getVolume()) + "\n";
            text += "\n";
        }

        if (container != null) {
            containerVolumeLabel.setText(number.format(container.getVolume()));
            text += "Container sizes: " + container.getWidth() + " x " + container.getLength()
                    + " x " + container.getHeight() + "\n";
            text += "Container's volume: " + number.format(container.getVolume()) + "\n";
            text += "Container's weight: " + container.getWeight() + "\n";
            text += "\n";
        } else {
            containerVolumeLabel.setText("");

            bestArrangementWidthLabel.setText("");
            bestArrangementLengthLabel.setText("");
            bestArrangementHeightLabel.setText("");

            boxesInContainerLabel.setText("");
            volumeRatioLabel.setText("");
            weightRatioLabel.setText("");
            requiredContainersLabel.setText("");
            allocationOneLabel.setText("");
            allocationORLabel.setText("");
            allocationTwoLabel.setText("");
        }

        if (box != null && container != null) {
            int boxesPerContainer = box.countIn(container);
            boxesInContainerLabel.setText("" + boxesPerContainer);

            if (boxesPerContainer > 0) {
                Box best = box.getBestArrangement(container);
                text += "Best arrangement:\n";
                bestArrangementWidthLabel.setText(temp = "Box's " + best.getWidth()
                        + " parallel to container's " + container.getWidth());
                text += temp + "\n";
                bestArrangementLengthLabel.setText(temp = "Box's " + best.getLength()
                        + " parallel to container's " + container.getLength());
                text += temp + "\n";
                bestArrangementHeightLabel.setText(temp = "Box's " + best.getHeight()
                        + " parallel to container's " + container.getHeight());
                text += temp + "\n";
                text += "\n";
                arrangementDrawing.setBoxes(best, container);
            } else {
                bestArrangementWidthLabel.setText("");
                bestArrangementLengthLabel.setText("");
                bestArrangementHeightLabel.setText("");
            }

            text += "Maximum boxes in container: " + boxesPerContainer + "\n";
        }

        if (box != null && container != null && boxes != 0) {
            int boxesPerContainer = box.countIn(container);
            if (!boxAmountTextField.getText().equals("") && boxesPerContainer > 0) {
                int reqContainers = (int) Math.ceil(1.0d * boxes / boxesPerContainer);

                volumeRatioLabel.setText(temp = ratio.format(1.0d * boxes * box.getVolume()
                        / reqContainers / container.getVolume()));
                text += "Volume ratio: " + temp + "\n";
                if (container.getWeight() != 0) {
                    weightRatioLabel.setText(temp = ratio.format(1.0d * boxes * box.getWeight()
                            / reqContainers / container.getWeight() ));
                } else {
                    weightRatioLabel.setText(temp = "0%");
                }
                text += "Weight ratio: " + temp + "\n";
                text += "Required containers: " + reqContainers + "\n";
                text += "Possible allocation:\n";
                text += calculateRequiredContainers(boxes, boxesPerContainer, reqContainers);
            } else {
                volumeRatioLabel.setText("");
                weightRatioLabel.setText("");
                requiredContainersLabel.setText("");
                allocationOneLabel.setText("");
                allocationORLabel.setText("");
                allocationTwoLabel.setText("");
            }
        }

        textArea.setText(text.trim());
        textArea.setCaretPosition(0);
    }

    private String calculateRequiredContainers(int boxes, int boxesPerContainer, int reqContainers) {
        requiredContainersLabel.setText("" + reqContainers);

        if (boxes <= boxesPerContainer) {
            String result = "1 container x " + boxes + " box"
                    + (boxes == 1 ? "" : "es");
            allocationOneLabel.setText(result);
            allocationORLabel.setText("");
            allocationTwoLabel.setText("");
            return result;
        }

        String one = "";
        String two = "";
        int es = 0;
        int temp = boxes / reqContainers * reqContainers;

        //equal case
        if (temp == boxes) {
            one += (es = reqContainers) + " container" + (es == 1 ? "" : "s") + " x "
                    + (es = boxes / reqContainers) + " box" + (es == 1 ? "" : "es");
        } else {
            int noOfContainers = boxes - temp;
            one += (es = noOfContainers) + " container" + (es == 1 ? "" : "s") + " x "
                    + (es = boxes / reqContainers + 1) + " box" + (es == 1 ? "" : "es") + " + "
                    + (es = reqContainers - noOfContainers) + " container" + (es == 1 ? "" : "s") + " x "
                    + (es = boxes / reqContainers) + " box" + (es == 1 ? "" : "es");
        }

        //max case
        if ((temp = boxes / boxesPerContainer) != 0) {
            two += (es = temp) + " container" + (es == 1 ? "" : "s") + " x "
                    + (es = boxesPerContainer) + " box" + (es == 1 ? "" : "es");
            temp = boxes / boxesPerContainer * boxesPerContainer;
            if (temp != boxes) {
                two += " + 1 container x " + (es = boxes - temp) + " box"
                        + (es == 1 ? "" : "es");
            }
        }

        if (one.equals(two)) {
            allocationOneLabel.setText(one);
            allocationORLabel.setText("");
            allocationTwoLabel.setText("");
            return one;
        } else {
            allocationOneLabel.setText(one);
            allocationORLabel.setText("or");
            allocationTwoLabel.setText(two);
            return one + "\n" + two;
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {}

        new XFrame();
    }
}