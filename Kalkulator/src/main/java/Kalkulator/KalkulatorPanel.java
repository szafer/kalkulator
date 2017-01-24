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
		plus.setBounds(294, 169, 80, 80);
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				try {
					dzialanie.run(txtWyswietlacz.getText(), RodzajDzialania.PLUS);
					txtWyswietlacz.setText("");
					komunikat();
				} catch (BlednaLiczbaException e) {
					komunikatBl();
				} catch (Dzielenie0Exception e) {
					komunikatBl0();
				}
			}

			private void komunikatBl0() {
				// TODO Auto-generated method stub

			}
		});
		add(plus);

		JButton minus = new JButton("-");
		minus.setFont(font);
		minus.setBounds(294, 257, 80, 80);
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dzialanie.run(txtWyswietlacz.getText(), RodzajDzialania.MINUS);
					txtWyswietlacz.setText("");
					komunikat();
				} catch (BlednaLiczbaException e) {
					komunikatBl();
				} catch (Dzielenie0Exception e) {
					komunikatBl0();
				}
			}

		});
		add(minus);

		JButton dzielenie = new JButton("/");
		dzielenie.setFont(font);
		dzielenie.setBounds(294, 434, 80, 80);
		dzielenie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dzialanie.run(txtWyswietlacz.getText(), RodzajDzialania.DZIELENIE);
					txtWyswietlacz.setText("");
					komunikat();
				} catch (BlednaLiczbaException e) {
					komunikatBl();
				} catch (Dzielenie0Exception e) {
					komunikatBl0();
				}
			}
		});
		add(dzielenie);

		JButton mnozenie = new JButton("*");
		mnozenie.setFont(font);
		mnozenie.setBounds(294, 345, 80, 80);
		mnozenie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dzialanie.run(txtWyswietlacz.getText(), RodzajDzialania.MNOZENIE);
					txtWyswietlacz.setText("");
					komunikat();
				} catch (BlednaLiczbaException e) {
					komunikatBl();
				} catch (Dzielenie0Exception e) {
					komunikatBl0();
				}
			}
		});
		add(mnozenie);

		JButton btnC = new JButton("C");
		btnC.setFont(font);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dzialanie.run(txtWyswietlacz.getText(), RodzajDzialania.CANCEL);
					txtWyswietlacz.setText("");
					komunikat();
				} catch (BlednaLiczbaException e) {
					komunikatBl();
				} catch (Dzielenie0Exception e) {
					komunikatBl0();
				}
			}
		});
		btnC.setBounds(108, 434, 80, 80);
		add(btnC);

		JButton btnWynik = new JButton("=");
		btnWynik.setFont(font);
		btnWynik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dzialanie.run(txtWyswietlacz.getText(), RodzajDzialania.WYNIK);
					txtWyswietlacz.setText(dzialanie.getPamiec().toString());
					dzialanie.setPamiec("0");
					komunikat();
				} catch (BlednaLiczbaException e) {
					komunikatBl();
				} catch (Dzielenie0Exception e) {
					komunikatBl0();
				}
			}
		});
		btnWynik.setBounds(197, 434, 80, 80);
		add(btnWynik);

		setLayout(null);

		JLabel label_5 = new JLabel("");
		label_5.setBounds(308, 246, 80, 80);
		add(label_5);

		JButton btn0 = new JButton("0");
		btn0.setFont(font);
		btn0.setBounds(17, 434, 80, 80);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("0"));
				lbKomunikat.setText("");
			}
		});
		add(btn0);

		JButton btn1 = new JButton("1");
		btn1.setFont(font);
		btn1.setBounds(17, 345, 80, 80);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("1"));
				lbKomunikat.setText("");
			}
		});
		add(btn1);

		JButton btn2 = new JButton("2");
		btn2.setFont(font);
		btn2.setBounds(108, 345, 80, 80);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("2"));
				komunikat();
			}
		});

		add(btn2);

		JButton btn3 = new JButton("3");
		btn3.setFont(font);
		btn3.setBounds(197, 345, 80, 80);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("3"));
				komunikat();
			}
		});
		add(btn3);

		JButton btn4 = new JButton("4");
		btn4.setFont(font);
		btn4.setBounds(17, 257, 80, 80);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("4"));
				komunikat();
			}
		});
		add(btn4);

		JButton btn5 = new JButton("5");
		btn5.setFont(font);
		btn5.setBounds(108, 257, 80, 80);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("5"));
				komunikat();
			}
		});
		add(btn5);

		JButton btn6 = new JButton("6");
		btn6.setFont(font);
		btn6.setBounds(197, 257, 80, 80);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("6"));
				komunikat();
			}
		});
		add(btn6);

		JButton btn7 = new JButton("7");
		btn7.setFont(font);
		btn7.setFont(font);
		btn7.setBounds(17, 169, 80, 80);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("7"));
				komunikat();
			}
		});
		add(btn7);

		JButton btn8 = new JButton("8");
		btn8.setFont(font);
		btn8.setBounds(108, 169, 80, 80);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("8"));
				komunikat();
			}
		});
		add(btn8);

		JButton btn9 = new JButton("9");
		btn9.setFont(font);
		btn9.setBounds(197, 169, 80, 80);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("9"));
				komunikat();
			}
		});
		add(btn9);

		txtWyswietlacz = new JTextField();
		txtWyswietlacz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				komunikat();
			}
		});
		txtWyswietlacz.setHorizontalAlignment(SwingConstants.RIGHT);
		txtWyswietlacz.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtWyswietlacz.setBounds(17, 19, 357, 93);
		txtWyswietlacz.setText(wartosc);
		txtWyswietlacz.setAutoscrolls(true);
		add(txtWyswietlacz);
		txtWyswietlacz.setColumns(10);

		lbKomunikat = new JLabel("");
		lbKomunikat.setBounds(27, 131, 342, 23);
		add(lbKomunikat);

	}

	protected void komunikatBl0() {
		lbKomunikat.setText("Nie można dzielić przez 0 ");
	}

	protected void komunikatBl() {
		System.out.println("Błędna liczba");
		lbKomunikat.setText("W celu wykonania działania podaj liczbę całkowitą");
	}

	protected void komunikat() {
		if (!dzialanie.getPamiec().equals("0")) {
			lbKomunikat.setText("W pamięci:   " + dzialanie.getPamiec().toString());
		} else {
			lbKomunikat.setText("");
		}
	}
}
