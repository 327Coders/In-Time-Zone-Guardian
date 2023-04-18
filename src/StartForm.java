import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Mon Apr 17 12:52:55 CST 2023
 */

class ImagePanel extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon icon = new ImageIcon("C:\\work\\327\\In-Time-Zone-Guardian\\In-Time-Zone-Guardian\\asset\\R-C.jpg");
        g.drawImage(icon.getImage(), 0, 0, null);
    }
}

/**
 * @author Brainrain
 */
public class StartForm extends JFrame {
    private ImageIcon bgImage = new ImageIcon("asset/R-C.jpg");
    public int getWork_min() {
        return work_min;
    }

    public int getRest_min() {
        return rest_min;
    }

    public int work_min;
    public int rest_min;

    public boolean isShield() {
        return shield;
    }

    public boolean isStrong() {
        return strong;
    }

    public boolean shield;
    public boolean strong;






    public StartForm() {
        initComponents();
        work_min = Integer.parseInt(WorkSpinner.getValue().toString());
        rest_min = Integer.parseInt(WorkSpinner.getValue().toString());

    }

    private void Start(ActionEvent e) {
        // TODO add your code here
        work_min = Integer.parseInt(WorkSpinner.getValue().toString());
        rest_min = Integer.parseInt(WorkSpinner.getValue().toString());
        shield = ShieldCheckBox.isSelected();
        strong = StrongCheckBox.isSelected();
        WorkForm workForm = new WorkForm(work_min,rest_min,shield,strong);
        this.dispose();
        workForm.setVisible(true);
        this.setDefaultCloseOperation(3);


        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - workForm.getWidth();
        int y = (int) rect.getMaxY() - workForm.getWidth();
        workForm.setLocation(x, y);
    }

    private void WorkSpinnerStateChanged(ChangeEvent e) {
        // TODO add your code here
    }

    class ImagePanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon icon = new ImageIcon("asset\\R-C.jpg");
            g.drawImage(icon.getImage(), 0, 0, null);
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        MainPanel = new JPanel();
        TimePanel = new JPanel();
        TimeLabel = new JLabel();
        WorkPanel = new JPanel();
        WorkLabel1 = new JLabel();
        WorkSpinner = new JSpinner();
        WorkLabel2 = new JLabel();
        RestPanel = new JPanel();
        RestLabel1 = new JLabel();
        RestSpinner = new JSpinner();
        RestLabel2 = new JLabel();
        CheckLabel = new JLabel();
        ShieldPanel = new JPanel();
        space = new JLabel();
        ShieldCheckBox = new JCheckBox();
        StrongPanel = new JPanel();
        label10 = new JLabel();
        StrongCheckBox = new JCheckBox();
        panel4 = new JPanel();
        StartButton = new JButton();

        //======== this ========
        setTitle("TimeZone");
        setIconImage(new ImageIcon("C:\\work\\327\\In-Time-Zone-Guardian\\In-Time-Zone-Guardian\\asset\\R-C.jpg").getImage());
        setPreferredSize(new Dimension(280, 350));
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setPreferredSize(new Dimension(280, 350));
            dialogPane.setLayout(new BorderLayout());

            //======== MainPanel ========
            {
                MainPanel.setLayout(new GridLayout(7, 1));

                //======== TimePanel ========
                {
                    TimePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- TimeLabel ----
                    TimeLabel.setText("\u8ba1\u65f6\u5668\uff1a");
                    TimeLabel.setFont(TimeLabel.getFont().deriveFont(TimeLabel.getFont().getSize() + 10f));
                    TimePanel.add(TimeLabel);
                }
                MainPanel.add(TimePanel);

                //======== WorkPanel ========
                {
                    WorkPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- WorkLabel1 ----
                    WorkLabel1.setText("\u5de5\u4f5c\u65f6\u95f4\uff1a");
                    WorkLabel1.setFont(WorkLabel1.getFont().deriveFont(WorkLabel1.getFont().getSize() + 5f));
                    WorkPanel.add(WorkLabel1);

                    //---- WorkSpinner ----
                    WorkSpinner.setModel(new SpinnerNumberModel(30, null, null, 1));
                    WorkSpinner.setMinimumSize(new Dimension(80, 30));
                    WorkSpinner.setPreferredSize(new Dimension(60, 30));
                    WorkSpinner.addChangeListener(e -> WorkSpinnerStateChanged(e));
                    WorkPanel.add(WorkSpinner);

                    //---- WorkLabel2 ----
                    WorkLabel2.setText("\uff08\u5206\u949f\uff09");
                    WorkLabel2.setFont(WorkLabel2.getFont().deriveFont(WorkLabel2.getFont().getSize() + 5f));
                    WorkPanel.add(WorkLabel2);
                }
                MainPanel.add(WorkPanel);

                //======== RestPanel ========
                {
                    RestPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- RestLabel1 ----
                    RestLabel1.setText("\u4f11\u606f\u65f6\u95f4\uff1a");
                    RestLabel1.setFont(RestLabel1.getFont().deriveFont(RestLabel1.getFont().getSize() + 5f));
                    RestPanel.add(RestLabel1);

                    //---- RestSpinner ----
                    RestSpinner.setMinimumSize(new Dimension(80, 30));
                    RestSpinner.setPreferredSize(new Dimension(60, 30));
                    RestSpinner.setModel(new SpinnerNumberModel(5, 1, null, 1));
                    RestPanel.add(RestSpinner);

                    //---- RestLabel2 ----
                    RestLabel2.setText("\uff08\u5206\u949f\uff09");
                    RestLabel2.setFont(RestLabel2.getFont().deriveFont(RestLabel2.getFont().getSize() + 5f));
                    RestPanel.add(RestLabel2);
                }
                MainPanel.add(RestPanel);

                //---- CheckLabel ----
                CheckLabel.setText("\u9009\u9879\uff1a");
                CheckLabel.setFont(CheckLabel.getFont().deriveFont(CheckLabel.getFont().getSize() + 10f));
                MainPanel.add(CheckLabel);

                //======== ShieldPanel ========
                {
                    ShieldPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- space ----
                    space.setText("     ");
                    space.setFont(space.getFont().deriveFont(space.getFont().getSize() + 5f));
                    ShieldPanel.add(space);

                    //---- ShieldCheckBox ----
                    ShieldCheckBox.setText("\u4f11\u606f\u65f6\u5c4f\u853d\u952e\u76d8\u548c\u9f20\u6807");
                    ShieldCheckBox.setFont(ShieldCheckBox.getFont().deriveFont(ShieldCheckBox.getFont().getSize() + 3f));
                    ShieldCheckBox.setSelected(true);
                    ShieldCheckBox.setBackground(new Color(0x8e3c3f41, true));
                    ShieldCheckBox.setOpaque(false);
                    ShieldPanel.add(ShieldCheckBox);
                }
                MainPanel.add(ShieldPanel);

                //======== StrongPanel ========
                {
                    StrongPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

                    //---- label10 ----
                    label10.setText("     ");
                    label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 5f));
                    StrongPanel.add(label10);

                    //---- StrongCheckBox ----
                    StrongCheckBox.setText("\u5f3a\u529b\u6a21\u5f0f\uff08\u614e\u7528\uff09");
                    StrongCheckBox.setFont(StrongCheckBox.getFont().deriveFont(StrongCheckBox.getFont().getSize() + 3f));
                    StrongCheckBox.setOpaque(false);
                    StrongPanel.add(StrongCheckBox);
                }
                MainPanel.add(StrongPanel);

                //======== panel4 ========
                {
                    panel4.setLayout(new FlowLayout());

                    //---- StartButton ----
                    StartButton.setFont(StartButton.getFont().deriveFont(StartButton.getFont().getSize() + 5f));
                    StartButton.setForeground(new Color(0x33ff33));
                    StartButton.setSelectedIcon(null);
                    StartButton.setIcon(new ImageIcon("C:\\work\\327\\In-Time-Zone-Guardian\\withfanta-java\\In-Time-Zone-Guardian\\asset\\Start.png"));
                    StartButton.addActionListener(e -> Start(e));
                    panel4.add(StartButton);
                }
                MainPanel.add(panel4);
            }
            dialogPane.add(MainPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        dialogPane.setBackground(null);
        dialogPane.setOpaque(false);
        MainPanel.setBackground(null);
        MainPanel.setOpaque(false);
        TimePanel.setBackground(null);
        TimePanel.setOpaque(false);
        WorkPanel.setBackground(null);
        WorkPanel.setOpaque(false);
        RestPanel.setBackground(null);
        RestPanel.setOpaque(false);
        ShieldPanel.setBackground(null);
        ShieldPanel.setOpaque(false);
        StrongPanel.setBackground(null);
        StrongPanel.setOpaque(false);
        panel4.setBackground(null);
        panel4.setOpaque(false);
        //背景图层Panel,充当容器---最底层
        JPanel bgPanel = new JPanel();
        bgPanel.setSize(bgImage.getIconWidth(),bgImage.getIconHeight());
        this.add(bgPanel);

        //背景图片，添加到背景图层Panel里面
        JLabel bgLabel = new JLabel(bgImage);
        bgPanel.add(bgLabel);
    }














    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel MainPanel;
    private JPanel TimePanel;
    private JLabel TimeLabel;
    private JPanel WorkPanel;
    private JLabel WorkLabel1;
    private JSpinner WorkSpinner;
    private JLabel WorkLabel2;
    private JPanel RestPanel;
    private JLabel RestLabel1;
    private JSpinner RestSpinner;
    private JLabel RestLabel2;
    private JLabel CheckLabel;
    private JPanel ShieldPanel;
    private JLabel space;
    private JCheckBox ShieldCheckBox;
    private JPanel StrongPanel;
    private JLabel label10;
    private JCheckBox StrongCheckBox;
    private JPanel panel4;
    private JButton StartButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
