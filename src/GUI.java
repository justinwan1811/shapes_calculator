// CMPT 275 Assignment 3
// Author: Chin Ho Wan 301308171
// file: GUI
// GUI for input and output

package A3;

import jdk.nashorn.internal.objects.Global;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class GUI extends JComponent{
    private static JLabel top_instr, instr1_label, instr2_label;
    private static JLabel par1_label, par2_label, circ_label, area_label, circ_res, area_res;
    private static JLabel sel_err, p1_err, p2_err;
    private static JTextField par1_text, par2_text;
    private static JButton shape_sel, cal_button;
    private static JFrame frame;
    private static JPanel panelbottom;
    private static MyPanel paneltop;
    private static JRadioButton tri_sel, rect_sel, elli_sel, sqr_sel, cir_sel;

    public static void window() {

        frame = new JFrame("Shape Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setLayout(null);

        // Panel for shape selection --------------------------------------
        paneltop = new MyPanel();
        paneltop.setBounds(0,0,800,300);
        paneltop.setBackground(Color.lightGray);
        paneltop.setBorder(BorderFactory.createLineBorder(Color.black));
        paneltop.setLayout(null);
        frame.add(paneltop);

        // Jlabel for select instruction
        top_instr = new JLabel("Please select a shape:");
        top_instr.setFont(new Font("Calibri", Font.BOLD, 18));
        top_instr.setBounds(20,40,250,25);
        paneltop.add(top_instr);

        // JRadioButton for Triangle
        tri_sel = new JRadioButton();
        tri_sel.setBounds(80, 200, 50,50);
        tri_sel.setBackground(Color.lightGray);
        paneltop.add(tri_sel);

        // JRadioButton for Rectangle
        rect_sel = new JRadioButton();
        rect_sel.setBounds(220, 200, 50,50);
        rect_sel.setBackground(Color.lightGray);
        paneltop.add(rect_sel);

        // JRadioButton for Ellipse
        elli_sel = new JRadioButton();
        elli_sel.setBounds(360, 200, 50,50);
        elli_sel.setBackground(Color.lightGray);
        paneltop.add(elli_sel);

        // JRadioButton for Square
        sqr_sel = new JRadioButton();
        sqr_sel.setBounds(500, 200, 50,50);
        sqr_sel.setBackground(Color.lightGray);
        paneltop.add(sqr_sel);

        // JRadioButton for Circle
        cir_sel = new JRadioButton();
        cir_sel.setBounds(640, 200, 50,50);
        cir_sel.setBackground(Color.lightGray);
        paneltop.add(cir_sel);

        // Grouping all the radio button, so that only one can be selected
        ButtonGroup bg = new ButtonGroup();
        bg.add(tri_sel);
        bg.add(rect_sel);
        bg.add(elli_sel);
        bg.add(sqr_sel);
        bg.add(cir_sel);

        shape_sel = new JButton("Select Shape");
        shape_sel.setBounds(320,260,120,30);
        paneltop.add(shape_sel);

        //bottom panel for input and output --------------------------------------
        panelbottom = new JPanel();
        panelbottom.setBounds(180,320,400,320);
        panelbottom.setBackground(Color.white);
        panelbottom.setBorder(BorderFactory.createLineBorder(Color.black));
        panelbottom.setLayout(null);
        frame.add(panelbottom);

        instr1_label = new JLabel("--");
        instr1_label.setBounds(20,10,250,25);
        panelbottom.add(instr1_label);

        instr2_label = new JLabel("--");
        instr2_label.setBounds(20,40,250,25);
        panelbottom.add(instr2_label);

        par1_label = new JLabel("--");
        par1_label.setBounds(20,80,100,25);
        panelbottom.add(par1_label);

        par2_label = new JLabel("--");
        par2_label.setBounds(20,120,100,25);
        panelbottom.add(par2_label);

        par1_text = new JTextField();
        par1_text.setBounds(150,80,100,25);
        panelbottom.add(par1_text);
        par1_text.setEnabled(false);

        par2_text = new JTextField();
        par2_text.setBounds(150,120,100,25);
        panelbottom.add(par2_text);
        par2_text.setEnabled(false);

        cal_button = new JButton("Calculate");
        cal_button.setBounds(150,160,100,30);
        panelbottom.add(cal_button);
        cal_button.setEnabled(false);

        circ_label = new JLabel("--");
        circ_label.setBounds(30,220,140,30);
        panelbottom.add(circ_label);

        area_label = new JLabel("--");
        area_label.setBounds(210,220,140,30);
        panelbottom.add(area_label);

        Border border = LineBorder.createBlackLineBorder();
        circ_res = new JLabel();
        circ_res.setBounds(30,250,120,30);
        circ_res.setOpaque(true);
        circ_res.setBackground(Color.lightGray);
        circ_res.setBorder(border);
        panelbottom.add(circ_res);

        area_res = new JLabel();
        area_res.setBounds(190,250,120,30);
        area_res.setOpaque(true);
        area_res.setBackground(Color.lightGray);
        area_res.setBorder(border);
        panelbottom.add(area_res);

        // Label for error display (in red colour if encountered)
        sel_err = new JLabel();
        sel_err.setForeground(Color.red);
        sel_err.setBounds(450,260,150,30);
        paneltop.add(sel_err);

        p1_err = new JLabel();
        p1_err.setForeground(Color.red);
        p1_err.setBounds(260,80,120,30);
        panelbottom.add(p1_err);

        p2_err = new JLabel();
        p2_err.setForeground(Color.red);
        p2_err.setBounds(260,120,150,30);
        panelbottom.add(p2_err);


        //initialize all shapes and use setter to update its name (Name and parameter's name)
        Shape triangle = new Triangle();
        triangle.setName("Triangle");
        triangle.setName_p1("Side");

        Shape rectangle = new Rectangle();
        rectangle.setName("Rectangle");
        rectangle.setName_p1("Width");
        rectangle.setName_p1("Height");

        Shape ellipse = new Ellipse();
        ellipse.setName("Ellipse");
        ellipse.setName_p1("Width");
        ellipse.setName_p1("Height");

        Shape square = new Square();
        square.setName("Square");
        square.setName_p1("Width");

        Shape circle = new Circle();
        circle.setName("Circle");
        circle.setName_p1("Radius");

        // Action Listener for the top Select-Shape Button
        shape_sel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset all labels and buttons
                // Enable or display -- for each component
                instr1_label.setText("--");
                instr2_label.setText("--");
                par1_label.setText("--");
                par2_label.setText("--");
                par1_text.setText("");
                par2_text.setText("");
                circ_label.setText("--");
                area_label.setText("--");
                circ_res.setText("");
                area_res.setText("");
                par1_text.setEnabled(false);
                par2_text.setEnabled(false);
                cal_button.setEnabled(false);
                panelbottom.add(par2_text);
                panelbottom.add(par2_label);
                panelbottom.repaint();
                panelbottom.validate();
                // Reset the error message
                sel_err.setText("");
                p1_err.setText("");
                p2_err.setText("");
                circ_label.setText("Circumference (cm)");
                area_label.setText("Area (cm^2)");

                if(tri_sel.isSelected()) {
                    // Display all necessary content for each shape
                    instr1_label.setText("You have selected Triangle.");
                    instr2_label.setText("Enter the parameters for Triangle:");
                    par1_label.setText("Side (cm)");
                    par1_text.setEnabled(true);
                    cal_button.setEnabled(true);
                    panelbottom.remove(par2_text);
                    panelbottom.remove(par2_label);
                    panelbottom.repaint();
                    panelbottom.validate();
                }
                else if(rect_sel.isSelected()) {
                    instr1_label.setText("You have selected Rectangle.");
                    instr2_label.setText("Enter the parameters for Rectangle:");
                    par1_label.setText("Width (cm)");
                    par2_label.setText("Height (cm)");
                    par1_text.setEnabled(true);
                    par2_text.setEnabled(true);
                    cal_button.setEnabled(true);
                }
                else if(elli_sel.isSelected()) {
                    instr1_label.setText("You have selected Ellipse.");
                    instr2_label.setText("Enter the parameters for Ellipse:");
                    par1_label.setText("Width (cm)");
                    par2_label.setText("Height (cm)");
                    par1_text.setEnabled(true);
                    par2_text.setEnabled(true);
                    cal_button.setEnabled(true);
                }
                else if(sqr_sel.isSelected()) {
                    instr1_label.setText("You have selected Square.");
                    instr2_label.setText("Enter the parameters for Square:");
                    par1_label.setText("Width (cm)");
                    par1_text.setEnabled(true);
                    cal_button.setEnabled(true);
                    panelbottom.remove(par2_text);
                    panelbottom.remove(par2_label);
                    panelbottom.repaint();
                    panelbottom.validate();
                }
                else if(cir_sel.isSelected()) {
                    instr1_label.setText("You have selected Circle.");
                    instr2_label.setText("Enter the parameters for Circle:");
                    par1_label.setText("Radius (cm)");
                    par1_text.setEnabled(true);
                    cal_button.setEnabled(true);
                    panelbottom.remove(par2_text);
                    panelbottom.remove(par2_label);
                    panelbottom.repaint();
                    panelbottom.validate();
                }
                else {
                    // Display error message if select button pressed without selecting the shape
                    sel_err.setText("Please select a shape");
                }
            }
        });

        // Action Listener for the Calculate button in bottom panel
        // Rounding problem maybe*********************************
        cal_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset the error message
                p1_err.setText("");
                p2_err.setText("");

                if(tri_sel.isSelected()) {
                    // use check_value function to validate the input
                    // n is the number of parameters which based on the shape
                    if (check_value(1)) {
                        // Use the setter the update the parameters
                        double p1 = Double.parseDouble(par1_text.getText());
                        triangle.setParam1(p1);

                        // Calculate circumference and area and round it to 2 decimal places
                        double circum = triangle.calculateCircumference();
                        circum = Math.round(circum * 100.0) / 100.0;
                        double area = triangle.calculateArea();
                        area = Math.round(area * 100.0) / 100.0;

                        // Display the results on GUI
                        String res1 = Double.toString(circum);
                        circ_res.setText(res1);
                        String res2 = Double.toString(area);
                        area_res.setText(res2);
                    }
                }
                else if(rect_sel.isSelected()) {
                    if (check_value(2)) {
                        // Use the setter the update the parameters
                        double p1 = Double.parseDouble(par1_text.getText());
                        rectangle.setParam1(p1);
                        double p2 = Double.parseDouble(par2_text.getText());
                        rectangle.setParam2(p2);

                        // Calculate circumference and area and round it to 2 decimal places
                        double circum = rectangle.calculateCircumference();
                        circum = Math.round(circum * 100.0) / 100.0;
                        double area = rectangle.calculateArea();
                        area = Math.round(area * 100.0) / 100.0;

                        // Display the results on GUI
                        String res1 = Double.toString(circum);
                        circ_res.setText(res1);
                        String res2 = Double.toString(area);
                        area_res.setText(res2);
                    }
                }
                else if(elli_sel.isSelected()) {
                    if (check_value(2)) {
                        // Use the setter the update the parameters
                        double p1 = Double.parseDouble(par1_text.getText());
                        ellipse.setParam1(p1);
                        double p2 = Double.parseDouble(par2_text.getText());
                        ellipse.setParam2(p2);

                        // Calculate circumference and area and round it to 2 decimal places
                        double circum = ellipse.calculateCircumference();
                        circum = Math.round(circum * 100.0) / 100.0;
                        double area = ellipse.calculateArea();
                        area = Math.round(area * 100.0) / 100.0;

                        // Display the results on GUI
                        String res1 = Double.toString(circum);
                        circ_res.setText(res1);
                        String res2 = Double.toString(area);
                        area_res.setText(res2);
                    }
                }
                else if(sqr_sel.isSelected()) {
                    if (check_value(1)) {
                        // Use the setter the update the parameters
                        double p1 = Double.parseDouble(par1_text.getText());
                        square.setParam1(p1);

                        // Calculate circumference and area and round it to 2 decimal places
                        double circum = square.calculateCircumference();
                        circum = Math.round(circum * 100.0) / 100.0;
                        double area = square.calculateArea();
                        area = Math.round(area * 100.0) / 100.0;

                        // Display the results on GUI
                        String res1 = Double.toString(circum);
                        circ_res.setText(res1);
                        String res2 = Double.toString(area);
                        area_res.setText(res2);
                    }
                }
                else if(cir_sel.isSelected()) {
                    if (check_value(1)) {
                        // Use the setter the update the parameters
                        double p1 = Double.parseDouble(par1_text.getText());
                        circle.setParam1(p1);

                        // Calculate circumference and area and round it to 2 decimal places
                        double circum = circle.calculateCircumference();
                        circum = Math.round(circum * 100.0) / 100.0;
                        double area = circle.calculateArea();
                        area = Math.round(area * 100.0) / 100.0;

                        // Display the results on GUI
                        String res1 = Double.toString(circum);
                        circ_res.setText(res1);
                        String res2 = Double.toString(area);
                        area_res.setText(res2);
                    }
                }
            }
        });
        frame.setVisible(true);
    }

    // Function for input validations (all inputs); n is the number of parameter
    public static boolean check_value( int n) {
        boolean pass_flag = true;

        // Validation for parameter 1
        String par1 = par1_text.getText();
        double p1;
        try {
            p1 = Double.parseDouble(par1);
            // Check if the input is out of range
            if (p1 <= 0 ) {
                p1_err.setText("Error: Negative value");
                pass_flag = false;
            }
        } catch (Exception error) {
            // Case for empty input or invalid number
            if (par1.length() == 0) {
                p1_err.setText("Empty input!");
            } else {
                p1_err.setText("Error: Invalid Input!");
            }
            pass_flag = false;
        }

        if (n == 2) {
            // Validation for parameter 2
            String par2 = par2_text.getText();
            double p2;
            try {
                p2 = Double.parseDouble(par2);
                //check if the input is out of range
                if (p2 <= 0 ) {
                    p2_err.setText("Error: Negative value");
                    pass_flag = false;
                }
            } catch (Exception error) {
                // Case for empty input or invalid number
                if (par2.length() == 0) {
                    p2_err.setText("Empty input!");
                } else {
                    p2_err.setText("Error: Invalid Input!");
                }
                pass_flag = false;
            }
        }
        return pass_flag;
    }
}

