package com.company;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FirstGUI extends JFrame implements ActionListener {
    private JPanel rootPanel;
    JButton btnSelect;
    JButton btnSwap;
    JButton btnSWAP;
    JButton btnPlay;
    JTextField txtLine1;
    JTextField txtLine2;
    JTextField txtLine3;
    JTextField txtLine4;
    JLabel lblLine1;
    JLabel lblLine2;
    JLabel lblLine3;
    JLabel lblLine4;
    JLabel txtBackground;
    Font ButtonFont = new Font("y", Font.ITALIC + Font.BOLD, 15);
    Myfile obj = new Myfile();
    String filepath;
    byte Swapctr = 0;
    byte SWAPctr = 0;
    private static final byte txtWIDTH = 35;
    private static final byte txtHEIGHT = 20;
    private static final byte btnHEIGHT = 25;

    FirstGUI() {
        txtBackground = new JLabel("", new ImageIcon("new_background.jpg"), JLabel.CENTER);
        txtBackground.setBounds(0, 0, 440, 300);

        //fourth pear
        lblLine4 = new JLabel();
        lblLine4.setText("Word number on this line:");
        lblLine4.setForeground(Color.WHITE);
        lblLine4.setBounds(10, 200, 150, txtHEIGHT);
        lblLine4.setVisible(false);
        txtLine4 = new JFormattedTextField();
        txtLine4.setBounds(160, 200, txtWIDTH, txtHEIGHT);
        txtLine4.setVisible(false);
        //third pear
        lblLine2 = new JLabel();
        lblLine2.setText("Second line:");
        lblLine2.setForeground(Color.WHITE);
        lblLine2.setBounds(10, 165, 80, txtHEIGHT);
        txtLine2 = new JFormattedTextField();
        lblLine2.setVisible(false);
        txtLine2.setBounds(90, 165, txtWIDTH, txtHEIGHT);
        txtLine2.setVisible(false);
        txtLine2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                methodforListener();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                methodforListener();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                methodforListener();
            }
        });
        //second pear
        lblLine3 = new JLabel();
        lblLine3.setText("Word number on this line:");
        lblLine3.setForeground(Color.WHITE);
        lblLine3.setBounds(10, 70, 150, txtHEIGHT);
        lblLine3.setVisible(false);
        txtLine3 = new JFormattedTextField();
        txtLine3.setBounds(160, 70, txtWIDTH, txtHEIGHT);
        txtLine3.setVisible(false);
        //first pear
        lblLine1 = new JLabel();
        lblLine1.setText("First line:");
        lblLine1.setForeground(Color.WHITE);
        lblLine1.setBounds(10, 35, 80, txtHEIGHT);
        lblLine1.setVisible(false);
        txtLine1 = new JFormattedTextField();
        txtLine1.setBounds(70, 35, txtWIDTH, txtHEIGHT);
        txtLine1.setVisible(false);


        Icon next = new ImageIcon("play.png");
        btnPlay = new JButton();
        btnPlay.setIcon(next);
        btnPlay.setHorizontalTextPosition(JButton.RIGHT);
        btnPlay.setText("Click me when you are ready!");
        btnPlay.setBounds(67, 225, 290, btnHEIGHT+10);
        btnCSS(btnPlay);

        btnSelect = new JButton("Select File");
        btnSelect.setBounds(147, 2, 146, btnHEIGHT);
        btnCSS(btnSelect);
        btnSelect.setVisible(true);

        btnSwap = new JButton("Swap Lines");
        btnSwap.setBounds(0, 2, 147, btnHEIGHT);
        btnCSS(btnSwap);


        btnSWAP = new JButton("Swap Words");
        btnSWAP.setBounds(293, 2, 146, btnHEIGHT);
        btnCSS(btnSWAP);

        txtBackground.add(btnPlay);
        txtBackground.add(lblLine4);
        txtBackground.add(txtLine4);
        txtBackground.add(lblLine3);
        txtBackground.add(txtLine3);
        txtBackground.add(lblLine2);
        txtBackground.add(txtLine2);
        txtBackground.add(lblLine1);
        txtBackground.add(txtLine1);
        txtBackground.add(btnSWAP);
        txtBackground.add(btnSelect);
        txtBackground.add(btnSwap);
        this.add(txtBackground);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(rootPanel);
        this.setTitle("SAP");
        this.setSize(440, 300);
        this.setVisible(true);
        this.setLocation(550, 300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSwap) {
            ++Swapctr;
            if (Swapctr % 2 == 1 && SWAPctr % 2 == 0) {
                btnSwap.setBackground(Color.GRAY);
                btnSwap.setForeground(Color.WHITE);
                lblLine1.setVisible(true);
                lblLine2.setVisible(true);
                txtLine1.setVisible(true);
                txtLine2.setVisible(true);
            } else if (Swapctr % 2 == 1 && SWAPctr % 2 == 1) {
                btnSwap.setBackground(Color.GRAY);
                btnSwap.setForeground(Color.WHITE);
                btnSWAP.setBackground(Color.WHITE);
                btnSWAP.setForeground(Color.BLACK);
                ++SWAPctr;
                lblLine3.setVisible(false);
                lblLine4.setVisible(false);
                txtLine3.setVisible(false);
                txtLine4.setVisible(false);

            } else {
                btnSwap.setBackground(Color.WHITE);
                btnSwap.setForeground(Color.BLACK);
                lblLine1.setVisible(false);
                lblLine2.setVisible(false);
                txtLine1.setVisible(false);
                txtLine2.setVisible(false);
            }
        }
        if (e.getSource() == btnSWAP) {
            ++SWAPctr;
            if (SWAPctr % 2 == 1 && Swapctr % 2 == 0) {
                btnSWAP.setBackground(Color.GRAY);
                btnSWAP.setForeground(Color.WHITE);
                lblLine1.setVisible(true);
                lblLine2.setVisible(true);
                txtLine1.setVisible(true);
                txtLine2.setVisible(true);
                lblLine3.setVisible(true);
                lblLine4.setVisible(true);
                txtLine3.setVisible(true);
                txtLine4.setVisible(true);
            } else if (SWAPctr % 2 == 1 && Swapctr % 2 == 1) {
                btnSWAP.setBackground(Color.GRAY);
                btnSWAP.setForeground(Color.WHITE);
                btnSwap.setBackground(Color.WHITE);
                btnSwap.setForeground(Color.BLACK);
                ++Swapctr;
                lblLine3.setVisible(true);
                lblLine4.setVisible(true);
                txtLine3.setVisible(true);
                txtLine4.setVisible(true);
            } else {
                btnSWAP.setBackground(Color.WHITE);
                btnSWAP.setForeground(Color.BLACK);
                lblLine1.setVisible(false);
                lblLine2.setVisible(false);
                txtLine1.setVisible(false);
                txtLine2.setVisible(false);
                lblLine3.setVisible(false);
                lblLine4.setVisible(false);
                txtLine3.setVisible(false);
                txtLine4.setVisible(false);
            }
        }
        if (e.getSource() == btnSelect) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));   //open my folder
            int response = fileChooser.showOpenDialog(null);    //select file to open
            if (response == JFileChooser.APPROVE_OPTION) {
                filepath = fileChooser.getSelectedFile().getAbsolutePath();
                if (filepath.contains("txt")) {
                    obj.readFileData(filepath);                           //read text
                    btnSelect.setEnabled(false);
                    btnSwap.setVisible(true);
                    btnSWAP.setVisible(true);
                    btnSelect.setText("File Selected");
                } else {
                    JOptionPane.showMessageDialog(null, "You must select file with .txt extension.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Next time try to select file.");
            }
        }
        if (e.getSource() == btnPlay) {
            if (txtLine1.getText().equals("0") || txtLine2.getText().equals("0")
                    || txtLine3.getText().equals("0") || txtLine4.getText().equals("0")) {
                JOptionPane.showMessageDialog(null, "txtFields cant be Zero");
            } else {
                if (Swapctr % 2 == 1) {                                               //case swapping Lines
                    if (txtLine1.getText().matches("^[0-9]+$")
                            && txtLine2.getText().matches("^[0-9]+$")) {        //chek 2 TextFields
                        if (Integer.parseInt(txtLine1.getText()) <= obj.getLine().size()
                                && Integer.parseInt(txtLine2.getText()) <= obj.getLine().size()) {
                            obj.swapLines(Byte.parseByte(txtLine1.getText()), Byte.parseByte(txtLine2.getText()), filepath);  //passing 2 TextFields and path to method
                            msgforEnd();
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect input! Selected file don't have so many lines or words on each line.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "txtFields must contain numbers! Usually must be between 1 and 9!");
                    }
                }
                if (SWAPctr % 2 == 1) {                                               // case swapping Words
                    if (txtLine1.getText().matches("^[0-9]+$")
                            && txtLine2.getText().matches("^[0-9]+$")
                            && txtLine3.getText().matches("^[0-9]+$")
                            && txtLine4.getText().matches("^[0-9]+$")) {        //if all TextFields
                        if (Integer.parseInt(txtLine1.getText()) <= obj.getLine().size()
                                && Integer.parseInt(txtLine2.getText()) <= obj.getLine().size()
                                && Integer.parseInt(txtLine3.getText()) <= obj.getLine().get(Integer.parseInt(txtLine1.getText()) - 1).length
                                && Integer.parseInt(txtLine4.getText()) <= obj.getLine().get(Integer.parseInt(txtLine2.getText()) - 1).length) { // gives error
                            obj.swapWords(Byte.parseByte(txtLine1.getText()), Byte.parseByte(txtLine2.getText()),
                                    Byte.parseByte(txtLine3.getText()), Byte.parseByte(txtLine4.getText()), filepath);    // passing 4 TextFields amd path to method
                            msgforEnd();
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect input! Selected file don't have so many lines or words on each line.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "txtFields must contain numbers! Usually must be between 1 and 9!");
                    }
                }
            }
        }
    }

    void methodforListener() {
        btnPlay.setVisible(true);
    }

    void msgforEnd() {
        int confirmed = JOptionPane.showConfirmDialog(null,
                "Close program?", "Swapping completed!",
                JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            dispose();
        }
        if (confirmed == JOptionPane.NO_OPTION) {
            btnSelect.setText("Select file");
            btnSelect.setEnabled(true);
            btnSWAP.setVisible(false);
            btnSwap.setVisible(false);
            btnPlay.setVisible(false);
            txtLine1.setVisible(false);
            txtLine2.setVisible(false);
            txtLine3.setVisible(false);
            txtLine4.setVisible(false);
            lblLine1.setVisible(false);
            lblLine2.setVisible(false);
            lblLine3.setVisible(false);
            lblLine4.setVisible(false);
            btnSwap.setBackground(Color.WHITE);
            btnSwap.setForeground(Color.BLACK);
            btnSWAP.setBackground(Color.WHITE);
            btnSWAP.setForeground(Color.BLACK);
            txtLine1.setText("");
            txtLine2.setText("");
            txtLine3.setText("");
            txtLine4.setText("");
            Swapctr = 0;
            SWAPctr = 0;
        }
    }

    void btnCSS(JButton btn){
        btn.setForeground(Color.black);
        btn.setBackground(Color.WHITE);
        btn.setFont(ButtonFont);
        btn.setVisible(false);
        btn.setFocusable(false);
        btn.addActionListener(this);
    }
}
