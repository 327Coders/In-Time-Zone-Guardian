
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class SystemTrayTester {

    private static SystemTray st;
    private static PopupMenu pm;

    public static void stt() {

        if (SystemTray.isSupported()) {// 判断当前平台是否支持系统托盘
            st = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage(
                    SystemTrayTester.class.getResource("R-C.jpg"));// 定义托盘图标的图片
            createPopupMenu();
            TrayIcon ti = new TrayIcon(image, "TimeZone", pm);
            ti.setImageAutoSize(true);
            try {
                st.add(ti);
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void createPopupMenu() {

        pm = new PopupMenu();
        MenuItem openBrowser = new MenuItem("首选项");
        openBrowser.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

// openBrowser("http://hi.baidu.com/riffling/blog");
            }
        });

        MenuItem sendMail = new MenuItem("关于");
        sendMail.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

// sendMail("mailto:chinajash@yahoo.com.cn");
            }
        });

        MenuItem edit = new MenuItem("Edit Text File");
        sendMail.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

// edit();
            }
        });

        MenuItem exitMenu = new MenuItem("退出");
        exitMenu.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
        pm.add(openBrowser);
        pm.add(sendMail);
        pm.addSeparator();
        pm.add(exitMenu);
    }

}