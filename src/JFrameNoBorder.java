import java.awt.Image;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;


public class JFrameNoBorder extends JFrame{

    //背景图片bgImage
    private ImageIcon bgImage = new ImageIcon("asset/WorkFormPic.jpg");
    //用于处理拖动事件，表示鼠标按下时的坐标，相对于JFrame
    int xOld = 0;
    int yOld = 0;

    public JFrameNoBorder() {

        getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);
        bgImage.setImageObserver(null);
        this.setSize(( bgImage).getIconWidth(),bgImage.getIconHeight());

        //处理拖动事件---去掉默认边框后，不能拖动了，具体实现如下
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
                JFrameNoBorder.this.setLocation(xx, yy);//设置拖拽后，窗口的位置
            }
        });

        /**
         * JLayeredPane用于添加两个图层的，一个用于背景，一个用于界面
         * JLayeredPane 将该深度范围分成几个不同的层。将组件放入相应的层，这样更容易确保组件正确地重叠
         * 在调用 add 的过程中通过传递 int值，从而在 Component 上设置 layer 属性
         */
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(bgImage.getIconWidth(), bgImage.getIconHeight());
        getContentPane().add(layeredPane);

        //背景图层Panel,充当容器---最底层
        JPanel bgPanel = new JPanel();
        bgPanel.setSize(bgImage.getIconWidth(),bgImage.getIconHeight());
        layeredPane.add(bgPanel);

        //背景图片，添加到背景图层Panel里面
        JLabel bgLabel = new JLabel(bgImage);
        bgPanel.add(bgLabel);

        //主界面，也就是背景上面的一层Panel，可用于添加控件
        JPanel mainPanel = new JPanel();
        mainPanel.setSize(200,200);
        mainPanel.setLayout(null);
        layeredPane.add(mainPanel);

        //关闭按钮
        JButton closeButton = new JButton();
        closeButton.setIcon(new ImageIcon("src/images/closebtn.png"));
        closeButton.setSize(30, 30);
        mainPanel.add(closeButton);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.setUndecorated(true);
    }

    public static void main(String[] args) {
        JFrameNoBorder j = new JFrameNoBorder();
        j.setVisible(true);
    }

}
