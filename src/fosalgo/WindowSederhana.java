package fosalgo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class WindowSederhana extends JFrame {

    //variable
    private JPanel jContentPane = null;
    private JPanel jPanelNorth = null;
    private Canvas canvas = null;
    private JLabel jLabelNumRows = null;
    private JTextField jTextFieldNumRows = null;
    private JLabel jLabelNumCols = null;
    private JTextField jTextFieldNumCols = null;
    private JButton jButtonReset = null;

    public WindowSederhana() {
        initialize();
    }

    public void initialize() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(this.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        setTitle("Jendela Dunia");
        setSize(800, 600);
        setContentPane(getJContentPane());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getJPanelNorth(), BorderLayout.NORTH);
            jContentPane.add(getCanvas(), BorderLayout.CENTER);
        }
        return jContentPane;
    }

    private JPanel getJPanelNorth() {
        if (jPanelNorth == null) {
            jPanelNorth = new JPanel();
            jPanelNorth.setBackground(Color.ORANGE);
            jPanelNorth.setLayout(new FlowLayout());
            jPanelNorth.add(getJLabelNumRows());
            jPanelNorth.add(getJTextFieldNumRows());
            jPanelNorth.add(getJLabelNumCols());
            jPanelNorth.add(getJTextFieldNumCols());
            jPanelNorth.add(getJButtonReset());
        }
        return jPanelNorth;
    }

    private Canvas getCanvas() {
        if (canvas == null) {
            canvas = new Canvas();
            Handler handler = new Handler(this, canvas);
            canvas.addMouseListener(handler);
            canvas.addMouseMotionListener(handler);
            canvas.addMouseWheelListener(handler);
            canvas.addKeyListener(handler);
        }
        return canvas;
    }
    
    private JLabel getJLabelNumRows(){
        if(jLabelNumRows==null){
            jLabelNumRows = new JLabel("Num Rows");
        }
        return jLabelNumRows;
    }
    
    private JTextField getJTextFieldNumRows(){
        if(jTextFieldNumRows==null){
            jTextFieldNumRows = new JTextField();
            jTextFieldNumRows.setPreferredSize(new Dimension(60, 30));
        }
        return jTextFieldNumRows;
    }
    
    private JLabel getJLabelNumCols(){
        if(jLabelNumCols==null){
            jLabelNumCols = new JLabel("Num Cols");
        }
        return jLabelNumCols;
    }
    
    private JTextField getJTextFieldNumCols(){
        if(jTextFieldNumCols==null){
            jTextFieldNumCols = new JTextField();
            jTextFieldNumCols.setPreferredSize(new Dimension(60, 30));
        }
        return jTextFieldNumCols;
    }
    
    private JButton getJButtonReset(){
        if(jButtonReset==null){
            jButtonReset = new JButton("Reset Array");
            jButtonReset.setPreferredSize(new Dimension(120, 30));
            jButtonReset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String sRows = jTextFieldNumRows.getText();
                    String sCols = jTextFieldNumCols.getText();                    
                    int rows = Integer.parseInt(sRows);
                    int cols = Integer.parseInt(sCols);
                    canvas.resetGrid(rows, cols);
                }
            });
        }
        return jButtonReset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WindowSederhana ws = new WindowSederhana();
            }
        });
    }
}
