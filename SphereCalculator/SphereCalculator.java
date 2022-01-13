import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

@SuppressWarnings("serial")
public class SphereCalculator extends JPanel
{
    /* Instance Variables */

    private JTextField radiusField;
    private JButton calcButton;
    private JLabel volumeResultLabel;
    private JLabel areaResultLabel;


    /* Constructor */
    public SphereCalculator() 
    {
        /* Instantiate the GUI components */
        this.radiusField = new JTextField(5);
        this.calcButton = new JButton("Calculate");
        this.volumeResultLabel = new JLabel("Volume: ");
        this.areaResultLabel = new JLabel("Surface Area: ");

        /* Bind the field and button to the listener */
        ActionListener listener = new CalcListener();
        calcButton.addActionListener(listener);
        radiusField.addActionListener(listener);

        /* Set up entry subpanel */
        JLabel radiusLabel = new JLabel("Radius:");
        
        JPanel entrySubPanel = new JPanel();
        entrySubPanel.setLayout(new BoxLayout(entrySubPanel,BoxLayout.X_AXIS));
        JPanel radiusSubPanel = new JPanel();
        radiusSubPanel.add(radiusLabel);
        radiusSubPanel.add(radiusField);
        entrySubPanel.add(radiusSubPanel);
        entrySubPanel.add(Box.createHorizontalGlue());
        entrySubPanel.add(calcButton);


        /* Set up results subpanel */
        JPanel resultsSubPanel = new JPanel();
        resultsSubPanel.setLayout(new BoxLayout(resultsSubPanel, BoxLayout.Y_AXIS));
        resultsSubPanel.add(Box.createVerticalGlue());
        resultsSubPanel.add(volumeResultLabel);
        resultsSubPanel.add(Box.createRigidArea(new Dimension(0,10)));
        resultsSubPanel.add(areaResultLabel);
        resultsSubPanel.add(Box.createVerticalGlue());

        /* Set up the "parent" panel */
        this.setPreferredSize(new Dimension(400,100));
        this.setLayout(new BorderLayout());
        this.add(entrySubPanel,BorderLayout.NORTH);
        this.add(resultsSubPanel,BorderLayout.CENTER);
    }

    /* Other Methods */
    private void updateCalculation(double radius) 
    {
        double sphereVolume = (4.0/3.0) * Math.PI * Math.pow(radius,3);
        double sphereSurfaceArea = 4 * Math.PI * Math.pow(radius, 2);

        DecimalFormat myFormat = new DecimalFormat("#,###,###.####");

        volumeResultLabel.setText("Volume: " + myFormat.format(sphereVolume));
        areaResultLabel.setText("Surface Area: " + myFormat.format(sphereSurfaceArea));

    }



    /* Listener */

    private class CalcListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String radiusString = radiusField.getText();
            try
            {
                double radius = Double.parseDouble(radiusString);
                if (radius >= 0) {
                    updateCalculation(radius);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter positive values only!" );
                    radiusField.setText("");
                }
                
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter numbers only!");
                radiusField.setText("");
            }


        }

    }






    public static void main(String[] args)
    {
        JFrame myFrame = new JFrame("Sphere Calculator - By Luke Hindman");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.add(new SphereCalculator() );

        myFrame.pack();
        myFrame.setVisible(true);

    }
}