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
				} catch (DzielenikZaDuzyException e) {
					komunikatBl1();
				}
			}
		});

		JButton minus = new JButton("-");
		minus.setFont(font);
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
				} catch (DzielenikZaDuzyException e) {
					komunikatBl1();
				}
			}

		});

		JButton dzielenie = new JButton("/");
		dzielenie.setFont(font);
		dzielenie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dzialanie.run(txtWyswietlacz.getText(), RodzajDzialania.DZIELENIE);
					txtWyswietlacz.setText("");
					komunikat();
				} catch (DzielenikZaDuzyException e) {
					komunikatBl1();
				} catch (BlednaLiczbaException e) {
					komunikatBl();
				} catch (Dzielenie0Exception e) {
					komunikatBl0();
				}
			}
		});

		JButton mnozenie = new JButton("*");
		mnozenie.setFont(font);
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
				} catch (DzielenikZaDuzyException e) {
					komunikatBl1();
				}
			}
		});

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
				} catch (DzielenikZaDuzyException e) {
					komunikatBl1();
				}
			}
		});

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
				} catch (DzielenikZaDuzyException e) {
					komunikatBl1();
				}
			}
		});

		JLabel label_5 = new JLabel("");

		JButton btn0 = new JButton("0");
		btn0.setFont(font);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("0"));
				lbKomunikat.setText("");
			}
		});

		JButton btn1 = new JButton("1");
		btn1.setFont(font);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("1"));
				lbKomunikat.setText("");
			}
		});

		JButton btn2 = new JButton("2");
		btn2.setFont(font);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("2"));
				komunikat();
			}
		});

		JButton btn3 = new JButton("3");
		btn3.setFont(font);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("3"));
				komunikat();
			}
		});

		JButton btn4 = new JButton("4");
		btn4.setFont(font);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("4"));
				komunikat();
			}
		});

		JButton btn5 = new JButton("5");
		btn5.setFont(font);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("5"));
				komunikat();
			}
		});

		JButton btn6 = new JButton("6");
		btn6.setFont(font);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("6"));
				komunikat();
			}
		});

		JButton btn7 = new JButton("7");
		btn7.setFont(font);
		btn7.setFont(font);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("7"));
				komunikat();
			}
		});

		JButton btn8 = new JButton("8");
		btn8.setFont(font);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("8"));
				komunikat();
			}
		});

		JButton btn9 = new JButton("9");
		btn9.setFont(font);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtWyswietlacz.setText(dzialanie.przeliczLiczbe("9"));
				komunikat();
			}
		});

		txtWyswietlacz = new JTextField();
		txtWyswietlacz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				komunikat();
			}
		});
		txtWyswietlacz.setHorizontalAlignment(SwingConstants.RIGHT);
		txtWyswietlacz.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtWyswietlacz.setText(wartosc);
		txtWyswietlacz.setAutoscrolls(true);
		txtWyswietlacz.setColumns(10);

		lbKomunikat = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(lbKomunikat, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
					.addGap(81))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(plus, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addComponent(minus, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(mnozenie, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addComponent(btn0, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(btnC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(btnWynik, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(dzielenie, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtWyswietlacz, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtWyswietlacz, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(lbKomunikat, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addComponent(plus, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(minus, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(mnozenie, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn0, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnWynik, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(dzielenie, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);

	}

	protected void komunikatBl1() {
		lbKomunikat.setText("Max dzielnika zostało okreslone na 1000000000");

	}

	public void komunikatBl0() {
		lbKomunikat.setText("Nie można dzielić przez 0");
	}

	public void komunikatBl() {
	//	System.out.println("Błędna liczba");
		lbKomunikat.setText("W celu wykonania działania podaj liczbę całkowitą");
	}

	public void komunikat() {
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
