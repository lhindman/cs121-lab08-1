import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * Implementation of Module 8 lab activity
 * @author Luke Hindman
 */
@SuppressWarnings("serial")
public class TriangleCalculator extends JPanel {
    /* instance variables */
    private JButton calcButton;
    private JTextField sideAField, sideBField, sideCField;
    private JLabel areaLabel;


    /* constructors */
    public TriangleCalculator() 
    {
        /* Instantiate GUI components */
        calcButton = new JButton("Calculate");
        sideAField = new JTextField(5);
        sideBField = new JTextField(5);
        sideCField = new JTextField(5);
        areaLabel = new JLabel("Triangle Area: ");

        /* Set up listener binding */
        calcButton.addActionListener(new CalcListener());

        /* Set up side entry subPanel */
         JPanel sideASubPanel = new JPanel();
        sideASubPanel.setLayout(new BoxLayout(sideASubPanel, BoxLayout.X_AXIS));
        sideASubPanel.add(Box.createHorizontalGlue());
        sideASubPanel.add(new JLabel("Side a:"));
        sideASubPanel.add(Box.createRigidArea(new Dimension(5,0)));
        sideASubPanel.add(sideAField);
        sideASubPanel.add(Box.createHorizontalGlue());
        
        JPanel sideBSubPanel = new JPanel();
        sideBSubPanel.setLayout(new BoxLayout(sideBSubPanel, BoxLayout.X_AXIS));
        sideBSubPanel.add(Box.createHorizontalGlue());
        sideBSubPanel.add(new JLabel("Side b:"));
        sideBSubPanel.add(Box.createRigidArea(new Dimension(5,0)));
        sideBSubPanel.add(sideBField);
        sideBSubPanel.add(Box.createHorizontalGlue());

        JPanel sideCSubPanel = new JPanel();
        sideCSubPanel.setLayout(new BoxLayout(sideCSubPanel, BoxLayout.X_AXIS));
        sideCSubPanel.add(Box.createHorizontalGlue());
        sideCSubPanel.add(new JLabel("Side c:"));
        sideCSubPanel.add(Box.createRigidArea(new Dimension(5,0)));
        sideCSubPanel.add(sideCField);
        sideCSubPanel.add(Box.createHorizontalGlue());

        JPanel sideSubPanel = new JPanel();
        sideSubPanel.setLayout(new BoxLayout(sideSubPanel,BoxLayout.Y_AXIS));
        sideSubPanel.add(Box.createVerticalGlue());
        sideSubPanel.add(sideASubPanel);
        sideSubPanel.add(Box.createRigidArea(new Dimension(0,5)));
        sideSubPanel.add(sideBSubPanel);
        sideSubPanel.add(Box.createRigidArea(new Dimension(0,5)));
        sideSubPanel.add(sideCSubPanel);
        sideSubPanel.add(Box.createVerticalGlue());

        JPanel entrySubPanel = new JPanel();
        entrySubPanel.add(sideSubPanel);
        entrySubPanel.add(calcButton);

        /* Set up area sub panel */
        JPanel areaSubPanel = new JPanel();
        areaSubPanel.add(areaLabel);

        /* Set up the parent panel */
        this.setPreferredSize(new Dimension(400,100));
        this.setLayout(new BorderLayout());
        this.add(entrySubPanel,BorderLayout.CENTER);
        this.add(areaSubPanel,BorderLayout.SOUTH);


    }

    /* other methods */
    private void updateAreaCalculation(double a, double b, double c)
    {
        double perimeter = a + b + c;
        double s = perimeter / 2;
        double area = Math.sqrt(s * (s -a ) * (s - b) * (s - c));

        DecimalFormat myFormat = new DecimalFormat("#,###,###.###");

        this.areaLabel.setText("Triangle Area: " + myFormat.format(area));
    }




    /* listener */

    private class CalcListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String userA = sideAField.getText();
            String userB = sideBField.getText();
            String userC = sideCField.getText();

            try {
                double sideA = Double.parseDouble(userA);
                double sideB = Double.parseDouble(userB);
                double sideC = Double.parseDouble(userC);

                if (sideA < 0 || sideB < 0 || sideC < 0) {
                    JOptionPane.showMessageDialog(null, "Please enter positive values only!");
                    sideAField.setText("");
                    sideBField.setText("");
                    sideCField.setText("");
                    areaLabel.setText("Triangle Area: ");
                } else if(sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA ) {
                    JOptionPane.showMessageDialog(null, "Side lengths do not form a triangle!");
                    areaLabel.setText("Triangle Area: ");
                } else {
                    updateAreaCalculation(sideA, sideB, sideC);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter numbers only!");
                sideAField.setText("");
                sideBField.setText("");
                sideCField.setText("");
                areaLabel.setText("Triangle Area: ");
            }

        }

    }


    /* driver */

    public static void main(String[] args) 
    {
        JFrame myFrame = new JFrame("Triangle Calculator - By Luke Hindman");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.add(new TriangleCalculator());
        myFrame.pack();
        myFrame.setVisible(true);
    }
}
