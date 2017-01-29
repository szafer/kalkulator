package Kalkulator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

public class KalkulatorPanel extends JPanel {
	private static final long serialVersionUID = 2673417466259590471L;
	private JLabel lbKomunikat;
	private JTextField txtWyswietlacz;
	private String wartosc = new String("0");
	private Dzialanie dzialanie;
	private Font font = new Font("Calibri", Font.PLAIN, 30);

	public KalkulatorPanel() {
		dzialanie = new Dzialanie();

		JButton plus = new JButton("+");
		plus.setFont(font);
		plus.addActionListener(generujActionListener(RodzajDzialania.PLUS));

		JButton minus = new JButton("-");
		minus.setFont(font);
		minus.addActionListener(generujActionListener(RodzajDzialania.MINUS));

		JButton dzielenie = new JButton("/");
		dzielenie.setFont(font);
		dzielenie.addActionListener(generujActionListener(RodzajDzialania.DZIELENIE));

		JButton mnozenie = new JButton("*");
		mnozenie.setFont(font);
		mnozenie.addActionListener(generujActionListener(RodzajDzialania.MNOZENIE));

		JButton btnC = new JButton("C");
		btnC.setFont(font);
		btnC.addActionListener(generujActionListener(RodzajDzialania.CANCEL));

		JButton btnWynik = new JButton("=");
		btnWynik.setFont(font);
		btnWynik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dzialanie.run(txtWyswietlacz.getText(), RodzajDzialania.WYNIK);
					txtWyswietlacz.setText(dzialanie.getPamiec().toString());
			 		dzialanie.setPamiec("0");
					message();
				} catch (BlednaLiczbaException e) {
					errorBl();
				} catch (Dzielenie0Exception e) {
					errorD0();
				} catch (DzielenikZaDuzyException e) {
					errorDZD();
				}
			}
		});

		JLabel label_5 = new JLabel("");

		JButton btn0 = new JButton("0");
		btn0.setFont(font);
		btn0.addActionListener(generujListenerPrzelicz("0"));

		JButton btn1 = new JButton("1");
		btn1.setFont(font);
		btn1.addActionListener(generujListenerPrzelicz("1"));

		JButton btn2 = new JButton("2");
		btn2.setFont(font);
		btn2.addActionListener(generujListenerPrzelicz("2"));

		JButton btn3 = new JButton("3");
		btn3.setFont(font);
		btn3.addActionListener(generujListenerPrzelicz("3"));

		JButton btn4 = new JButton("4");
		btn4.setFont(font);
		btn4.addActionListener(generujListenerPrzelicz("4"));

		JButton btn5 = new JButton("5");
		btn5.setFont(font);
		btn5.addActionListener(generujListenerPrzelicz("5"));

		JButton btn6 = new JButton("6");
		btn6.setFont(font);
		btn6.addActionListener(generujListenerPrzelicz("6"));

		JButton btn7 = new JButton("7");
		btn7.setFont(font);
		btn7.setFont(font);
		btn7.addActionListener(generujListenerPrzelicz("7"));

		JButton btn8 = new JButton("8");
		btn8.setFont(font);
		btn8.addActionListener(generujListenerPrzelicz("8"));

		JButton btn9 = new JButton("9");
		btn9.setFont(font);
		btn9.addActionListener(generujListenerPrzelicz("9"));

		txtWyswietlacz = new JTextField();
		txtWyswietlacz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				message();
			}
		});
		txtWyswietlacz.setHorizontalAlignment(SwingConstants.RIGHT);
		txtWyswietlacz.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtWyswietlacz.setText(wartosc);
		txtWyswietlacz.setAutoscrolls(true);
		txtWyswietlacz.setColumns(10);

		lbKomunikat = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(27)
						.addComponent(lbKomunikat, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE).addGap(81))
				.addGroup(groupLayout.createSequentialGroup().addGap(17)
						.addGroup(createParallelGroup(btn4, btn7, groupLayout))
						.addGap(11)
						.addGroup(createParallelGroup(btn5, btn8, groupLayout))
						.addGap(9)
						.addGroup(createParallelGroup(btn6, btn9, groupLayout))
						.addGap(17)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(plus, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(14).addComponent(label_5,
										GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
								.addComponent(minus, GroupLayout.PREFERRED_SIZE, 80,
										GroupLayout.PREFERRED_SIZE)))
				.addGroup(createSequentialGroup(mnozenie, btn1, btn2, btn3, groupLayout))
				.addGroup(createSequentialGroup(dzielenie, btn0, btnC, btnWynik, groupLayout))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(txtWyswietlacz, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addContainerGap().addComponent(txtWyswietlacz,
								GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGap(19)
						.addComponent(lbKomunikat, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGap(15)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 80,
														GroupLayout.PREFERRED_SIZE)
												.addGap(8).addComponent(btn4, GroupLayout.PREFERRED_SIZE, 80,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 80,
														GroupLayout.PREFERRED_SIZE)
												.addGap(8).addComponent(btn5, GroupLayout.PREFERRED_SIZE, 80,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 80,
														GroupLayout.PREFERRED_SIZE)
												.addGap(8).addComponent(btn6, GroupLayout.PREFERRED_SIZE, 80,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(plus, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup().addGap(77).addComponent(label_5,
												GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addGap(88).addComponent(minus,
												GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
						.addGap(8)
						.addGroup(createParallelGroup(btn2, btn1, groupLayout)
								.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(mnozenie, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGap(9)
						.addGroup(createParallelGroup(btnC, btn0, groupLayout)
								.addComponent(btnWynik, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(dzielenie, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))));
		setLayout(groupLayout);

	}

	private SequentialGroup createSequentialGroup(JButton mnozenie, JButton btn1, JButton btn2, JButton btn3,
			GroupLayout groupLayout) {
		return groupLayout.createSequentialGroup().addGap(17)
				.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(11)
				.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(9)
				.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(17)
				.addComponent(mnozenie, GroupLayout.PREFERRED_SIZE, 80,
						GroupLayout.PREFERRED_SIZE);
	}

	private ParallelGroup createParallelGroup(JButton btn4, JButton btn7, GroupLayout groupLayout) {
		return groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
				.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE);
	}

	private ActionListener generujListenerPrzelicz(final String liczbaString) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe(liczbaString));
			}
		};
	}
	
	private ActionListener generujActionListener(final RodzajDzialania rodzajDzialania) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dzialanie.run(txtWyswietlacz.getText(), rodzajDzialania);
					txtWyswietlacz.setText("");
					message();
				} catch (BlednaLiczbaException e) {
					errorBl();
				} catch (Dzielenie0Exception e) {
					errorD0();
				} catch (DzielenikZaDuzyException e) {
					errorDZD();
				}
			}

		};
	}

	protected void errorDZD() {
		lbKomunikat.setText("Max dzielnika zostało okreslone na 1000000000");

	}

	public void errorD0() {
		lbKomunikat.setText("Nie można dzielić przez 0");
	}

	public void errorBl() {
		lbKomunikat.setText("W celu wykonania działania podaj liczbę całkowitą dodatnią");
	}

	public void message() {
		if (!dzialanie.getPamiec().equals("0")) {
			lbKomunikat.setText("W pamięci:   " + dzialanie.getPamiec().toString());
		} else {
			lbKomunikat.setText("");
		}
	}

	public JLabel getLbKomunikat() {
		return lbKomunikat;
	}

	public void setLbKomunikat(JLabel lbKomunikat) {
		this.lbKomunikat = lbKomunikat;
	}

	public JTextField getTxtWyswietlacz() {
		return txtWyswietlacz;
	}

	public void setTxtWyswietlacz(JTextField txtWyswietlacz) {
		this.txtWyswietlacz = txtWyswietlacz;
	}

}
