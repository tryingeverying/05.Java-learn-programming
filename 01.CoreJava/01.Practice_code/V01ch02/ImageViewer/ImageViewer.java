import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 * A program for viewing images.
 * @version 11.0.2 2023-03-25
 * @author Cay Horstmann
 */
public class ImageViewer {

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
/** 
* 图片浏览器
*/
class ImageViewerFrame extends JFrame
{
    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 800;

    public ImageViewerFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        // 创建一个窗口
        label = new JLabel();
        add(label);

        // 设置一个文件选择按钮
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        // 设置一个菜单栏
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu  menu = new JMenu("file");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("open");
        menu.add(openItem);
        openItem.addActionListener(event -> {
            // 展示文件选择对话框
                int result = chooser.showOpenDialog(null);

                // 如果文件被选择，在窗口中展示图片
                if (result == JFileChooser.APPROVE_OPTION)
                {
                    String name = chooser.getSelectedFile().getPath();
                    label.setIcon(new ImageIcon(name));
                }
            });
        JMenuItem exitItem = new JMenuItem("exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }
}












