# Module 8 Lab Guide (part 1)
## Getting Started
[Lab Introduction Video](https://youtu.be/4qre8IRmaUw)

### Code Style Requirements
Please review the [CS121 Style Guide](https://docs.google.com/document/d/1LWbGQBKkApnNAzzgwOSvRM03DmhYWx5yEfecT2WXfjI/edit?usp=sharing) and apply it in all lab activities and projects this semester. Coding Style will assessed as part of your lab and project grades. 

### Code Quality Requirements
- Code must compile without warnings using openjdk11
- Code must run without errors or warnings on safe-path and edge test cases
- More to come as we learn about input validation and exception handling  

## Lab Warmup - Sphere Calculator
### Problem Description
In this activity we revisit an activity from earlier in the semester.  Write an application that prompts the user for the radius of a sphere and calculates its volume and surface area.  Use the following formulas, in which r represents the sphere's radius.  Display the results to four decimal places using JLabels and thethe DecimalFormat class. The calculated values should be updated with the user clicks the Calculate button or when the user presses enter in the text field.

<img src="images/volume-and-surface-area-formula.png" alt="Sphere Formulas" width="350">

### Program Design
The screenshot above shows a sample GUI for this activity.  You may use the same layout or design your own.  Either way, your GUI must contain the following components

+ **JButton:** You must include a JButton that will calculate the surface area and volume based upon the radius value stored in the JTextField. See the error handling section below for how to address unexpected values.
+ **JTextField:** You must include a JTextField that will allow the user to specify a radius value. Pressing enter in this field should trigger the same result as clickign the JButton.
+ **JLabel:** You must include a JLabel that includes the tagged value for volume
+ **JLabel:** You must include a JLabel that includes the tagged value for surface area

### Error Handling
When the Calculate JButton is pressed or when enter is pressed in the JTextField, it will read the current values from the radius JTextField.  If the user specified a non-numerical value for the volume, you should catch the NumberFormatException and display a JOptionPane with the message "Please enter numbers only!".  If the user specified a negative number, display a JOptionPane with the message "Please enter positive values only!".

### Implementation Guide
1. Expand the folder named  SphereCalculatorGUI and create a new file named SphereCalculatorGUI.java and open it.
3. Design a program to satisfy the requirements in the Problem Description and the Program Design above
4. Test the program and pay particular attention to boundary/edge cases and invalid input.
5. Commit the changes to your local repository with a message stating that Lab Warmup is completed.
6. Push the changes from your local repository to the github classroom repository.

## Activity 2 - Cup of Dice
### Problem Description
In this activity we are once again reusing the Die class and DieButton class from the deeper look videos. In this activity you are going to create class named CupOfDice to represent a cup of dice.  Ok, so it isn't a literal cup, but you get the idea. :).  In this activity, the end user will be able specify the number of dice in the cup from 0 to 15. The end user will be able to press a button to shake ALL the dice in the cup or click an individual die to role just that one. In order to replicate the drama and anticipation of shaking a real cup and turing it over, whenever  the dice are rolled they should hide their facevalue until the reveal button is clicked. For this program you may use either an Array or an ArrayList<DieButton> to hold the dice. When the user clicks the shake button, the Score should be blanked out. When the user clicks the reveal button, the Score should be updated with the sum of the face values of each die in the cup.
     
<img src="images/Lab08-CupOfDice.png" alt="Dynamic Die Screenshot" >

### Requirements
The screenshot above shows a sample GUI for this activity.  You may use the same layout and general design or create your own.  Either way, your GUI must contain the following components:
+ **DieButton:** You must use the DieButton class to represent each of the 0 - 15 dice. Each DieButton should have 6 sides, but may use any of the skins from A1 or from the Mod08 examples.
+ **Array or ArrayList:** You must use either an Array or an ArrayList to hold the DieButtons in the cup.  Each have their pros and cons and I'll leave that particular design decision to you. :)
+ **JButton:** You must use a JButton to reveal the face values on each of the die in the cup after they've been rolled.
+ **JButton:** You must use a JButton to shake the cup which in turn will role each of the diein the cup.
+ **JSlider:** You must use a JSlider combined with an AdjustmentListener to reconfigure the number of die in the cup. Each individual DieButton should be removed from the parent panel, the Array or ArrayList cleared and then new DieButtons created, added to the Array or ArrayList and added to the parent panel.
+ **JLabel:** You must use a JLabel to display the current Score to the user.  This should be set to an and empty string when the Shake button is pressed and updated with the sum of all the dice in the cup when the Reveal button is pressed.
+ **JPanels:** You must use JPanels as subpanels with TitleBorders to identify the components as shown in the screenshot above.


### Implementation Guide
1. Expand the folder named A2-CupOfDice and create a new file named CupOfDice.java
2. Copy Die.java and DieButton.java from the [Mod08 Code Examples](https://github.com/lhindman/cs121-mod08-examples.git) into the A2-CupOfDice folder.
3. Copy a die skin folder of your choice into the A2-CupOfDice folder.
4. Design a program to satisfy the requirements in the Problem Description and enter the program code in CupOfDice.java
5. Test the program and pay particular attention to boundary/edge cases and invalid input.
6. Commit the changes to your local repository with a message stating that Activity 2 is completed.
7. Push the changes from your local repository to the github classroom repository.
