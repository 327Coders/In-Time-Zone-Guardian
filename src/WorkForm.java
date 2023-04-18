import com.sun.awt.AWTUtilities;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.border.*;

/*
 * Created by JFormDesigner on Mon Apr 17 16:27:07 CST 2023
 */



/**
 * @author withcoco
 */
public class WorkForm extends JFrame {

    int work_min;
    int rest_min;
    boolean shield;
    boolean strong;
    int xOld,yOld;
    private ImageIcon bgImage = new ImageIcon("asset/WorkFormPic.jpg");
    public WorkForm(int work_min,int rest_min,boolean shield,boolean strong) {
        this.setType(JFrame.Type.UTILITY);
        new SystemTrayTester().stt();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xOld = e.getX();//记录鼠标按下时的坐标
                yOld = e.getY();
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int xOnScreen = e.getXOnScreen();
                int yOnScreen = e.getYOnScreen();
                int xx = xOnScreen - xOld;
                int yy = yOnScreen - yOld;
                WorkForm.this.setLocation(xx, yy);//设置拖拽后，窗口的位置
            }
        });
        this.setUndecorated(true);
        AWTUtilities.setWindowOpacity(this, 0.5f);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.work_min = work_min;
        this.rest_min =rest_min;
        this.shield = shield;
        this.strong = strong;
        initComponents();
        new Thread(new Runnable() {
            public void run() {
                try {
                    countDown(work_min);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    private void initComponents() {
        dialogPane = new JPanel();;
        panel1 = new JPanel();;
        label1 = new JLabel();
        panel2 = new JPanel();
        label3 = new JLabel();
        MinLabel = new JLabel();
        label5 = new JLabel();
        SecondLabel = new JLabel("0");
        label7 = new JLabel();

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        panel1 = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        label3 = new JLabel();
        MinLabel = new JLabel();
        label5 = new JLabel();
        SecondLabel = new JLabel();
        label7 = new JLabel();

        //======== this ========
        setPreferredSize(new Dimension(200, 100));
        setResizable(false);
        setIconImage(new ImageIcon("C:\\work\\327\\In-Time-Zone-Guardian\\withfanta-java\\In-Time-Zone-Guardian\\asset\\WorkFormPic.jpg").getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBackground(new Color(0x66ff00));
            dialogPane.setLayout(new BorderLayout());

            //======== panel1 ========
            {
                panel1.setBackground(new Color(0x66ff00));
                panel1.setLayout(new GridLayout(2, 1));

                //---- label1 ----
                label1.setText("   \u60a8\u6b63\u5728\u5de5\u4f5c\uff0c\u8bf7\u52a0\u6cb9\uff01");
                label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
                label1.setForeground(Color.white);
                panel1.add(label1);

                //======== panel2 ========
                {
                    panel2.setBackground(new Color(0x66ff00));
                    panel2.setLayout(new FlowLayout());

                    //---- label3 ----
                    label3.setText("\u8fd8\u5269\u4e0b");
                    label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 8f));
                    label3.setForeground(Color.white);
                    panel2.add(label3);

                    //---- MinLabel ----
                    MinLabel.setText(work_min+"");
                    MinLabel.setFont(MinLabel.getFont().deriveFont(MinLabel.getFont().getSize() + 8f));
                    MinLabel.setForeground(Color.white);
                    panel2.add(MinLabel);

                    //---- label5 ----
                    label5.setText("\u5206");
                    label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 8f));
                    label5.setForeground(Color.white);
                    panel2.add(label5);

                    //---- SecondLabel ----
                    SecondLabel.setText("0");
                    SecondLabel.setFont(SecondLabel.getFont().deriveFont(SecondLabel.getFont().getSize() + 8f));
                    SecondLabel.setForeground(Color.white);
                    panel2.add(SecondLabel);

                    //---- label7 ----
                    label7.setText("\u79d2");
                    label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 8f));
                    label7.setForeground(Color.white);
                    panel2.add(label7);
                }
                panel1.add(panel2);
            }
            dialogPane.add(panel1, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        dialogPane.setBackground(null);
        dialogPane.setOpaque(false);
        panel1.setBackground(null);
        panel1.setOpaque(false);
        panel2.setBackground(null);
        panel2.setOpaque(false);

        //背景图层Panel,充当容器---最底层
        JPanel bgPanel = new JPanel();
        bgPanel.setSize(bgImage.getIconWidth(),bgImage.getIconHeight());
        this.add(bgPanel);

        //背景图片，添加到背景图层Panel里面
        JLabel bgLabel = new JLabel(bgImage);
        bgPanel.add(bgLabel);
    }
    public void switchStatus(int work_min,int rest_min,boolean shield,boolean strong){
        this.dispose();
        RestForm restForm = new RestForm(work_min,rest_min,shield,strong);
        restForm.setVisible(true);
        this.setDefaultCloseOperation(3);
        try {
            restForm.countDown(rest_min);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel2;
    private JLabel label3;
    private JLabel MinLabel;
    private JLabel label5;
    private JLabel SecondLabel;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
