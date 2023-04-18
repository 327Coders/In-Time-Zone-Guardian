import com.sun.awt.AWTUtilities;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Timer;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Mon Apr 17 18:00:51 CST 2023
 */



/**
 * @author withcoco
 */
public class RestForm extends JFrame {
    private ImageIcon bgImage = new ImageIcon("asset/RestFormPic.jpg");
    int work_min;
    int rest_min;
    boolean shield;
    boolean strong;
    JavaCallC javaCallC = new JavaCallC();
    public RestForm(int work_min,int rest_min,boolean shield,boolean strong) {
//        this.setType(JFrame.Type.UTILITY);
//        new SystemTrayTester().stt();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        this.setSize(screenSize);
        this.setUndecorated(true);
        AWTUtilities.setWindowOpacity(this, 0.6f);
//        fullScreen();
        this.work_min = work_min;
        this.rest_min =rest_min;
        this.shield = shield;
        this.strong = strong;
        initComponents();
        if (strong == true){
            javaCallC.keyboardBlockerOn();
        }
        System.out.println(strong);
    }
    public void fullScreen(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        panel5 = new JPanel();
        panel7 = new JPanel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        panel8 = new JPanel();
        label13 = new JLabel();
        MinLabel = new JLabel();
        label15 = new JLabel();
        SecondLabel = new JLabel();
        label17 = new JLabel();

        //======== this ========
        setPreferredSize(new Dimension(1920, 1080));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBackground(new Color(0x003c3f41, true));
            dialogPane.setPreferredSize(new Dimension(1920, 1080));
            dialogPane.setLayout(new BorderLayout());

            //======== panel5 ========
            {
                panel5.setBackground(new Color(0xff0031));
                panel5.setPreferredSize(new Dimension(1920, 154));
                panel5.setLayout(new GridLayout(2, 1));

                //======== panel7 ========
                {
                    panel7.setBackground(new Color(0xff3333));
                    panel7.setPreferredSize(new Dimension(1920, 77));
                    panel7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 400));

                    //---- label10 ----
                    label10.setText(" \u60a8\u5df2\u7ecf\u4e45\u5750");
                    label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 40f));
                    label10.setForeground(Color.black);
                    panel7.add(label10);

                    //---- label11 ----
                    label11.setText(work_min+"");
                    label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 40f));
                    label11.setForeground(Color.black);
                    panel7.add(label11);

                    //---- label12 ----
                    label12.setText("\u5206\u949f\u4e86\uff0c\u7ad9\u8d77\u6765\u4f11\u606f\u4e00\u4e0b\u5427\uff01");
                    label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 40f));
                    label12.setForeground(Color.black);
                    panel7.add(label12);
                }
                panel5.add(panel7);

                //======== panel8 ========
                {
                    panel8.setBackground(new Color(0xcc0033));
                    panel8.setLayout(new FlowLayout());

                    //---- label13 ----
                    label13.setText("\u8fd8\u5269");
                    label13.setFont(label13.getFont().deriveFont(label13.getFont().getSize() + 40f));
                    label13.setForeground(Color.black);
                    panel8.add(label13);

                    //---- MinLabel ----
                    MinLabel.setText(rest_min+"");
                    MinLabel.setFont(MinLabel.getFont().deriveFont(MinLabel.getFont().getSize() + 40f));
                    MinLabel.setForeground(Color.black);
                    panel8.add(MinLabel);

                    //---- label15 ----
                    label15.setText("\u5206");
                    label15.setFont(label15.getFont().deriveFont(label15.getFont().getSize() + 40f));
                    label15.setForeground(Color.black);
                    panel8.add(label15);

                    //---- SecondLabel ----
                    SecondLabel.setText("0");
                    SecondLabel.setFont(SecondLabel.getFont().deriveFont(SecondLabel.getFont().getSize() + 40f));
                    SecondLabel.setForeground(Color.black);
                    panel8.add(SecondLabel);

                    //---- label17 ----
                    label17.setText("\u79d2");
                    label17.setFont(label17.getFont().deriveFont(label17.getFont().getSize() + 40f));
                    label17.setForeground(Color.black);
                    panel8.add(label17);
                }
                panel5.add(panel8);
            }
            dialogPane.add(panel5, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
//        panel5.setBackground(null);
//        panel5.setOpaque(false);
//        panel7.setBackground(null);
//        panel7.setOpaque(false);
//        panel8.setBackground(null);
//        panel8.setOpaque(false);
//        contentPane.setBackground(null);
        dialogPane.setBackground(null);
        dialogPane.setOpaque(false);
        panel5.setBackground(null);
        panel5.setOpaque(false);
        panel7.setBackground(null);
        panel7.setOpaque(false);
        panel8.setBackground(null);
        panel8.setOpaque(false);
        //背景图层Panel,充当容器---最底层
        JPanel bgPanel = new JPanel();
        bgPanel.setSize(bgImage.getIconWidth(),bgImage.getIconHeight());
        this.add(bgPanel);

        //背景图片，添加到背景图层Panel里面
        JLabel bgLabel = new JLabel(bgImage);
        bgPanel.add(bgLabel);
//        this.setBackground(new Color(0, 0, 153, 80));
    }
    public void switchStatus(int work_min,int rest_min,boolean shield,boolean strong){
        if (strong == true){
            javaCallC.keyboardBlockerOff();
        }
        this.dispose();
        WorkForm workForm = new WorkForm(work_min,rest_min,shield,strong);
        workForm.setVisible(true);
    }
    private int limitSec =60;
    private int curSec=60;
    public void countDown(int limitMin) throws InterruptedException {
        int limitMinNow = limitMin-1;
        System.out.println("count down from " + limitSec + " s ");
        java.util.Timer timer = new Timer();
        while (limitMinNow >= 0){
            Thread.sleep(1000);
            curSec--;
            System.out.println(curSec);
            SecondLabel.setText(curSec+"");
            MinLabel.setText(limitMinNow+"");
            if (curSec == 0){
                limitMinNow --;
                curSec= 3;
                if (limitMinNow == -1){
                    switchStatus(work_min,rest_min,shield,strong);
                }
            }
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel panel5;
    private JPanel panel7;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JPanel panel8;
    private JLabel label13;
    private JLabel MinLabel;
    private JLabel label15;
    private JLabel SecondLabel;
    private JLabel label17;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
