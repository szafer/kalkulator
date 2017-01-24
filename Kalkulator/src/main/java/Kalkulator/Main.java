package Kalkulator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main extends JFrame {
	private static final long serialVersionUID = 3716736922037967139L;
	public static JFrame frmK;
	public static KalkulatorPanel kalkulatorPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmK.setVisible(true);
					final UIManager.LookAndFeelInfo[] plafInfos = UIManager.getInstalledLookAndFeels();
					try {
						UIManager.setLookAndFeel(plafInfos[1].getClassName());//proponuje 1 lub 3 - wygląda fajnie
						SwingUtilities.updateComponentTreeUI(frmK);
						// frmK.pack();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		frmK = new JFrame();
		frmK.setTitle("Kalkulator");
		frmK.setBounds(100, 100, 420, 620);
		frmK.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmK.getContentPane().removeAll();
		JPanel panel = (JPanel) frmK.getContentPane();
		panel.add(new KalkulatorPanel());
		frmK.setContentPane(panel);
	}

}
