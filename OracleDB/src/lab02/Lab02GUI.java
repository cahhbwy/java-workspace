package lab02;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.Vector;

public class Lab02GUI extends JFrame {
	private JTable ucTable;
	private JTable ufTable;
	private JTable utTable;
	private JTable uhTable;
	private JTable ofTable;
	private JTextField ofNametf;
	private JTextField ofFromtf;
	private JTextField ofArivtf;
	private JTextField otNametf;
	private JTextField otCitytf;
	private JTable otTable;
	private JTextField ohNametf;
	private JTextField ohCitytf;
	private JTable ohTable;
	private JTable lcTable;
	private JTable lfTable;
	private JTable ltTable;
	private JTable lhTable;
	private JTable lrTable;
	private Lab02Core core;
	private JTextArea textArea;

	public Lab02GUI() {
		core = new Lab02Core();
		core.connect();
		getContentPane().setEnabled(false);
		setTitle("旅行预订系统");
		getContentPane().setLayout(new BorderLayout());

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JTabbedPane updateTab = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("录入", null, updateTab, null);

		JPanel uCustomer = new JPanel();
		updateTab.addTab("客户", null, uCustomer, null);
		uCustomer.setLayout(new BorderLayout(0, 0));

		ucTable = new JTable();
		ucTable.setModel(new DefaultTableModel(new Object[100][1], new String[] { "姓名" }) {
			Class[] columnTypes = new Class[] { String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		ucTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane ucScrollPane = new JScrollPane(ucTable);
		uCustomer.add(ucScrollPane, BorderLayout.CENTER);

		JPanel ucPanel = new JPanel();
		uCustomer.add(ucPanel, BorderLayout.SOUTH);
		ucPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton ucnbtn = new JButton("清空");
		ucnbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ucTable.editCellAt(-1, -1);
				ucTable.setModel(new DefaultTableModel(new Object[100][1], new String[] { "姓名" }) {
					Class[] columnTypes = new Class[] { String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
			}
		});
		ucPanel.add(ucnbtn);

		JButton ucybtn = new JButton("确定");
		ucybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ucTable.editCellAt(-1, -1);
				Vector<Customers> customers = new Vector<>();
				TableModel tm = ucTable.getModel();
				for (int i = 0; i < 100; i++) {
					if (tm.getValueAt(i, 0) != null) {
						customers.addElement(new Customers((String) tm.getValueAt(i, 0)));
					}
				}
				core.insertCustomers(customers);
			}
		});
		ucPanel.add(ucybtn);

		JPanel uFlight = new JPanel();
		updateTab.addTab("航班", null, uFlight, null);
		uFlight.setLayout(new BorderLayout(0, 0));
		ufTable = new JTable();
		ufTable.setModel(new DefaultTableModel(new Object[100][5], new String[] { "班次", "座位数", "起点", "终点", "价格" }) {
			Class[] columnTypes = new Class[] { String.class, Integer.class, String.class, String.class,
					Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		ufTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane ufScrollPane = new JScrollPane(ufTable);
		uFlight.add(ufScrollPane);

		JPanel ufPanel = new JPanel();
		uFlight.add(ufPanel, BorderLayout.SOUTH);
		ufPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton ufnbtn = new JButton("清空");
		ufnbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ufTable.editCellAt(-1, -1);
				ufTable.setModel(
						new DefaultTableModel(new Object[100][6], new String[] { "班次", "座位数", "起点", "终点", "价格" }) {
							Class[] columnTypes = new Class[] { String.class, Integer.class, String.class, String.class,
									Integer.class };

							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						});
			}
		});
		ufPanel.add(ufnbtn);

		JButton ufybtn = new JButton("确定");
		ufybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ufTable.editCellAt(-1, -1);
				Vector<Flights> flights = new Vector<>();
				TableModel tm = ufTable.getModel();
				for (int i = 0; i < 100; i++) {
					if (tm.getValueAt(i, 0) != null && tm.getValueAt(i, 1) != null && tm.getValueAt(i, 2) != null
							&& tm.getValueAt(i, 3) != null && tm.getValueAt(i, 4) != null) {
						flights.addElement(new Flights((String) tm.getValueAt(i, 0), (int) tm.getValueAt(i, 4),
								(int) tm.getValueAt(i, 1), (int) tm.getValueAt(i, 1), (String) tm.getValueAt(i, 2),
								(String) tm.getValueAt(i, 3)));
					}
				}
				core.insertFlight(flights);
			}
		});
		ufPanel.add(ufybtn);

		JPanel uTaxi = new JPanel();
		updateTab.addTab("出租车", null, uTaxi, null);
		uTaxi.setLayout(new BorderLayout(0, 0));

		utTable = new JTable();
		utTable.setModel(new DefaultTableModel(new Object[100][3], new String[] { "城市", "总数", "价格" }) {
			Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		utTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane utScrollPane = new JScrollPane(utTable);
		uTaxi.add(utScrollPane);

		JPanel utPanel = new JPanel();
		uTaxi.add(utPanel, BorderLayout.SOUTH);
		utPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton utnbtn = new JButton("清空");
		utnbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utTable.editCellAt(-1, -1);
				utTable.setModel(new DefaultTableModel(new Object[100][3], new String[] { "城市", "总数", "价格" }) {
					Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
			}
		});
		utPanel.add(utnbtn);

		JButton utybtn = new JButton("确定");
		utybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utTable.editCellAt(-1, -1);
				Vector<Cars> cars = new Vector<>();
				TableModel tm = utTable.getModel();
				for (int i = 0; i < 100; i++) {
					if (tm.getValueAt(i, 0) != null && tm.getValueAt(i, 1) != null && tm.getValueAt(i, 2) != null) {
						utTable.getModel().getValueAt(i, 0);
						cars.addElement(new Cars((String) tm.getValueAt(i, 0), (int) tm.getValueAt(i, 2),
								(int) tm.getValueAt(i, 1), (int) tm.getValueAt(i, 1)));
					}
				}
				core.insertCars(cars);
			}
		});
		utPanel.add(utybtn);

		JPanel uHotel = new JPanel();
		updateTab.addTab("宾馆", null, uHotel, null);
		uHotel.setLayout(new BorderLayout(0, 0));

		uhTable = new JTable();
		uhTable.setModel(new DefaultTableModel(new Object[100][4], new String[] { "城市", "房间总数", "价格" }) {
			Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		uhTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane uhScrollPane = new JScrollPane(uhTable);
		uHotel.add(uhScrollPane, BorderLayout.CENTER);

		JPanel uhPanel = new JPanel();
		uHotel.add(uhPanel, BorderLayout.SOUTH);
		uhPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton uhnbtn = new JButton("清空");
		uhnbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uhTable.editCellAt(-1, -1);
				uhTable.setModel(new DefaultTableModel(new Object[100][4], new String[] { "城市", "房间总数", "价格" }) {
					Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
			}
		});
		uhPanel.add(uhnbtn);

		JButton uhybtn = new JButton("确定");
		uhybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uhTable.editCellAt(-1, -1);
				Vector<Hotels> hotels = new Vector<>();
				TableModel tm = uhTable.getModel();
				for (int i = 0; i < 100; i++) {
					if (tm.getValueAt(i, 0) != null && tm.getValueAt(i, 1) != null && tm.getValueAt(i, 2) != null) {
						hotels.addElement(new Hotels((String) tm.getValueAt(i, 0), (int) tm.getValueAt(i, 2),
								(int) tm.getValueAt(i, 1), (int) tm.getValueAt(i, 1)));
					}
				}
				core.insertHotels(hotels);
			}
		});
		uhPanel.add(uhybtn);

		JTabbedPane orderTab = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("预订", null, orderTab, null);

		JPanel oFlight = new JPanel();
		orderTab.addTab("航班", null, oFlight, null);
		oFlight.setLayout(new BorderLayout(0, 0));

		JPanel ofMPanel = new JPanel();
		oFlight.add(ofMPanel, BorderLayout.NORTH);

		JLabel ofNamelbl = new JLabel("姓名");
		ofMPanel.add(ofNamelbl);

		ofNametf = new JTextField();
		ofMPanel.add(ofNametf);
		ofNametf.setColumns(10);

		JLabel ofFromlbl = new JLabel("起点");
		ofMPanel.add(ofFromlbl);

		ofFromtf = new JTextField();
		ofMPanel.add(ofFromtf);
		ofFromtf.setColumns(10);

		JLabel ofArivlbl = new JLabel("终点");
		ofMPanel.add(ofArivlbl);

		ofArivtf = new JTextField();
		ofMPanel.add(ofArivtf);
		ofArivtf.setColumns(10);

		JButton oflookupBtn = new JButton("查询");
		ofMPanel.add(oflookupBtn);
		oflookupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ofTable.editCellAt(-1, -1);
				ofTable.setModel(new DefaultTableModel(new Object[100][7],
						new String[] { "班次", "起点", "终点", "座位总数", "剩余座位", "价格", "预订" }) {
					Class[] columnTypes = new Class[] { String.class, String.class, String.class, Integer.class,
							Integer.class, Integer.class, Boolean.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, true };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				String from = ofFromtf.getText();
				if (from.isEmpty()) {
					from = null;
				}
				String ariv = ofArivtf.getText();
				if (ariv.isEmpty()) {
					ariv = null;
				}
				ResultSet result = core.showFlight(from, ariv);
				try {
					int i = 0;
					while (result.next()) {
						ofTable.getModel().setValueAt(result.getString(1), i, 0);
						ofTable.getModel().setValueAt(result.getString(5), i, 1);
						ofTable.getModel().setValueAt(result.getString(6), i, 2);
						ofTable.getModel().setValueAt(result.getInt(3), i, 3);
						ofTable.getModel().setValueAt(result.getInt(4), i, 4);
						ofTable.getModel().setValueAt(result.getInt(2), i, 5);
						i++;
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		ofTable = new JTable();
		ofTable.setModel(new DefaultTableModel(new Object[100][7],
				new String[] { "班次", "起点", "终点", "座位总数", "剩余座位", "价格", "预订" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, Integer.class, Integer.class,
					Integer.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ofTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane ofScrollPane = new JScrollPane(ofTable);
		oFlight.add(ofScrollPane, BorderLayout.CENTER);

		JPanel ofPanel = new JPanel();
		oFlight.add(ofPanel, BorderLayout.SOUTH);

		JButton ofybtn = new JButton("确定");
		ofybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ofTable.editCellAt(-1, -1);
				ResultSet result = core.showCustomer(ofNametf.getText());
				try {
					if (result.next()) {
						TableModel tm = ofTable.getModel();
						for (int i = 0; i < 100; i++) {
							if (tm.getValueAt(i, 0) != null && tm.getValueAt(i, 6) != null
									&& (boolean) tm.getValueAt(i, 6)) {
								if (core.updateFlight((String) tm.getValueAt(i, 0),
										new Flights((String) tm.getValueAt(i, 0), (int) tm.getValueAt(i, 5),
												(int) tm.getValueAt(i, 3), (int) tm.getValueAt(i, 4) - 1,
												(String) tm.getValueAt(i, 1), (String) tm.getValueAt(i, 2)))) {
									core.insertReservations(
											new Reservations(ofNametf.getText(), 1, (String) tm.getValueAt(i, 0)));
								}else{
									JOptionPane.showMessageDialog(ofNamelbl, "预定失败，请检查剩余数量");
								}
							}
						}
					} else {
						System.out.println("无此客户");
						JOptionPane.showMessageDialog(ofNamelbl, "无此客户");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		ofPanel.add(ofybtn);

		JPanel oTaxi = new JPanel();
		orderTab.addTab("出租车", null, oTaxi, null);
		oTaxi.setLayout(new BorderLayout(0, 0));

		JPanel otMPanel = new JPanel();
		oTaxi.add(otMPanel, BorderLayout.NORTH);

		JLabel otNamelbl = new JLabel("姓名");
		otMPanel.add(otNamelbl);

		otNametf = new JTextField();
		otNametf.setColumns(10);
		otMPanel.add(otNametf);

		JLabel otCitylbl = new JLabel("城市");
		otMPanel.add(otCitylbl);

		otCitytf = new JTextField();
		otCitytf.setColumns(10);
		otMPanel.add(otCitytf);

		JButton otlookupBtn = new JButton("查询");
		otMPanel.add(otlookupBtn);
		otlookupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				otTable.setModel(
						new DefaultTableModel(new Object[100][5], new String[] { "城市", "总数", "可用数量", "价格", "选中" }) {
							Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class,
									Integer.class, Boolean.class };

							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}

							boolean[] columnEditables = new boolean[] { false, false, false, false, true };

							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						});
				String location = otCitytf.getText();
				if (location.isEmpty()) {
					location = null;
				}
				ResultSet result = core.showCar(location);
				try {
					int i = 0;
					while (result.next()) {
						otTable.getModel().setValueAt(result.getString(1), i, 0);
						otTable.getModel().setValueAt(result.getInt(3), i, 1);
						otTable.getModel().setValueAt(result.getInt(4), i, 2);
						otTable.getModel().setValueAt(result.getInt(2), i, 3);
						i++;
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		otTable = new JTable();
		otTable.setModel(new DefaultTableModel(new Object[100][5], new String[] { "城市", "总数", "可用数量", "价格", "选中" }) {
			Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class, Integer.class,
					Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		otTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane otScrollPane = new JScrollPane(otTable);
		oTaxi.add(otScrollPane, BorderLayout.CENTER);

		JPanel otPanel = new JPanel();
		oTaxi.add(otPanel, BorderLayout.SOUTH);

		JButton btybtn = new JButton("确定");
		btybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				otTable.editCellAt(-1, -1);
				ResultSet result = core.showCustomer(otNametf.getText());
				try {
					if (result.next()) {
						TableModel tm = otTable.getModel();
						for (int i = 0; i < 100; i++) {
							if (tm.getValueAt(i, 0) != null && tm.getValueAt(i, 4) != null
									&& (boolean) tm.getValueAt(i, 4)) {
								if (core.updateCar((String) tm.getValueAt(i, 0),
										new Cars((String) tm.getValueAt(i, 0), (int) tm.getValueAt(i, 3),
												(int) tm.getValueAt(i, 1), (int) tm.getValueAt(i, 2) - 1))) {
									core.insertReservations(
											new Reservations(otNametf.getText(), 3, (String) tm.getValueAt(i, 0)));
								}else{
									JOptionPane.showMessageDialog(otNamelbl, "预定失败，请检查剩余数量");
								}
							}
						}
					} else {
						System.out.println("无此客户");
						JOptionPane.showMessageDialog(otNamelbl, "无此客户");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		otPanel.add(btybtn);

		JPanel oHotel = new JPanel();
		orderTab.addTab("宾馆", null, oHotel, null);
		oHotel.setLayout(new BorderLayout(0, 0));

		JPanel ohMPanel = new JPanel();
		oHotel.add(ohMPanel, BorderLayout.NORTH);

		JLabel ohNamelbl = new JLabel("姓名");
		ohMPanel.add(ohNamelbl);

		ohNametf = new JTextField();
		ohNametf.setColumns(10);
		ohMPanel.add(ohNametf);

		JLabel ohCitylbl = new JLabel("城市");
		ohMPanel.add(ohCitylbl);

		ohCitytf = new JTextField();
		ohCitytf.setColumns(10);
		ohMPanel.add(ohCitytf);

		JButton ohlookupBtn = new JButton("查询");
		ohMPanel.add(ohlookupBtn);
		ohlookupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ohTable.setModel(
						new DefaultTableModel(new Object[100][5], new String[] { "城市", "房间总数", "剩余房间", "价格", "选中" }) {
							Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class,
									Integer.class, Boolean.class };

							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}

							boolean[] columnEditables = new boolean[] { false, false, false, false, true };

							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						});
				String location = ohCitytf.getText();
				if (location.isEmpty()) {
					location = null;
				}
				ResultSet result = core.showHotel(location);
				try {
					int i = 0;
					while (result.next()) {
						ohTable.getModel().setValueAt(result.getString(1), i, 0);
						ohTable.getModel().setValueAt(result.getInt(3), i, 1);
						ohTable.getModel().setValueAt(result.getInt(4), i, 2);
						ohTable.getModel().setValueAt(result.getInt(2), i, 3);
						i++;
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		ohTable = new JTable();
		ohTable.setModel(new DefaultTableModel(new Object[100][5], new String[] { "城市", "房间总数", "剩余房间", "价格", "选中" }) {
			Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class, Integer.class,
					Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ohTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane ohScrollPane = new JScrollPane(ohTable);
		oHotel.add(ohScrollPane, BorderLayout.CENTER);

		JPanel ohPanel = new JPanel();
		oHotel.add(ohPanel, BorderLayout.SOUTH);

		JButton ohybtn = new JButton("确定");
		ohybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ohTable.editCellAt(-1, -1);
				ResultSet result = core.showCustomer(ohNametf.getText());
				try {
					if (result.next()) {
						TableModel tm = ohTable.getModel();
						for (int i = 0; i < 100; i++) {
							if (tm.getValueAt(i, 0) != null && tm.getValueAt(i, 4) != null
									&& (boolean) tm.getValueAt(i, 4)) {
								if (core.updateHotel((String) tm.getValueAt(i, 0),
										new Hotels((String) tm.getValueAt(i, 0), (int) tm.getValueAt(i, 3),
												(int) tm.getValueAt(i, 1), (int) tm.getValueAt(i, 2) - 1))) {
									core.insertReservations(
											new Reservations(ohNametf.getText(), 2, (String) tm.getValueAt(i, 0)));
								}else{
									JOptionPane.showMessageDialog(ohNamelbl, "预定失败，请检查剩余数量");
								}
							}
						}
					} else {
						System.out.println("无此客户");
						JOptionPane.showMessageDialog(ohNamelbl, "无此客户");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		ohPanel.add(ohybtn);

		JTabbedPane lookupTab = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("查询", null, lookupTab, null);

		JPanel lCustomer = new JPanel();
		lookupTab.addTab("客户", null, lCustomer, null);
		lCustomer.setLayout(new BorderLayout(0, 0));

		JPanel lcMPanel = new JPanel();
		lCustomer.add(lcMPanel, BorderLayout.NORTH);

		JLabel lccustNamelbl = new JLabel("姓名");
		lcMPanel.add(lccustNamelbl);

		JTextField lccustNametf = new JTextField();
		lcMPanel.add(lccustNametf);
		lccustNametf.setColumns(10);

		JButton lcLookupBtn = new JButton("查询");
		lcMPanel.add(lcLookupBtn);
		lcLookupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lcTable.setModel(new DefaultTableModel(new Object[100][2], new String[] { "姓名", "选中" }) {
					Class[] columnTypes = new Class[] { String.class, Boolean.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					boolean[] columnEditables = new boolean[] { false, true };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				String custName = lccustNametf.getText();
				if (custName.isEmpty()) {
					custName = null;
				}
				ResultSet result = core.showCustomer(custName);
				try {
					int i = 0;
					while (result.next()) {
						lcTable.getModel().setValueAt(result.getString(1), i++, 0);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		lcTable = new JTable();
		lcTable.setModel(new DefaultTableModel(new Object[100][2], new String[] { "姓名", "选中" }) {
			Class[] columnTypes = new Class[] { String.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		lcTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane lcScrollPane = new JScrollPane(lcTable);
		lCustomer.add(lcScrollPane);

		JPanel lcPanel = new JPanel();
		lCustomer.add(lcPanel, BorderLayout.SOUTH);

		JButton lcDelbtn = new JButton("删除");
		lcPanel.add(lcDelbtn);
		lcDelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lcTable.editCellAt(-1, -1);
				TableModel tm = lcTable.getModel();
				for (int i = 0; i < 100; i++) {
					if (tm.getValueAt(i, 0) != null && tm.getValueAt(i, 1) != null
							&& (boolean) tm.getValueAt(i, 1) == true) {
						core.deleteCustomer((String) tm.getValueAt(i, 0));
						core.deleteReservation((String) tm.getValueAt(i, 0));
					}
				}
			}
		});

		JPanel lFlight = new JPanel();
		lookupTab.addTab("航班", null, lFlight, null);
		lFlight.setLayout(new BorderLayout(0, 0));

		JPanel lfMPanel = new JPanel();
		lFlight.add(lfMPanel, BorderLayout.NORTH);

		JLabel lfFromlbl = new JLabel("起点");
		lfMPanel.add(lfFromlbl);

		JTextField lfFromtf = new JTextField();
		lfMPanel.add(lfFromtf);
		lfFromtf.setColumns(10);

		JLabel lfArivlbl = new JLabel("终点");
		lfMPanel.add(lfArivlbl);

		JTextField lfArivtf = new JTextField();
		lfMPanel.add(lfArivtf);
		lfArivtf.setColumns(10);

		JButton lfLookupBtn = new JButton("查询");
		lfMPanel.add(lfLookupBtn);
		lfLookupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lfTable.setModel(new DefaultTableModel(new Object[100][7],
						new String[] { "班次", "起点", "终点", "座位总数", "剩余座位", "价格", "选中" }) {
					Class[] columnTypes = new Class[] { String.class, String.class, String.class, Integer.class,
							Integer.class, Integer.class, Boolean.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					boolean[] columnEditables = new boolean[] { false, true, true, true, false, true, true };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				String from = lfFromtf.getText();
				if (from.isEmpty()) {
					from = null;
				}
				String ariv = lfArivtf.getText();
				if (ariv.isEmpty()) {
					ariv = null;
				}
				ResultSet result = core.showFlight(from, ariv);
				try {
					int i = 0;
					while (result.next()) {
						lfTable.getModel().setValueAt(result.getString(1), i, 0);
						lfTable.getModel().setValueAt(result.getString(5), i, 1);
						lfTable.getModel().setValueAt(result.getString(6), i, 2);
						lfTable.getModel().setValueAt(result.getInt(3), i, 3);
						lfTable.getModel().setValueAt(result.getInt(4), i, 4);
						lfTable.getModel().setValueAt(result.getInt(2), i, 5);
						i++;
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		lfTable = new JTable();
		lfTable.setModel(new DefaultTableModel(new Object[100][7],
				new String[] { "班次", "起点", "终点", "座位总数", "剩余座位", "价格", "选中" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, Integer.class, Integer.class,
					Integer.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, true, true, true, false, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		lfTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane lfScrollPane = new JScrollPane(lfTable);
		lFlight.add(lfScrollPane, BorderLayout.CENTER);

		JPanel lfPanel = new JPanel();
		lFlight.add(lfPanel, BorderLayout.SOUTH);

		JButton lfDelbtn = new JButton("删除");
		lfPanel.add(lfDelbtn);
		lfDelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lfTable.editCellAt(-1, -1);
				TableModel tm = lfTable.getModel();
				for (int i = 0; i < 100; i++) {
					if (tm.getValueAt(i, 0) != null && tm.getValueAt(i, 6) != null
							&& (boolean) tm.getValueAt(i, 6) == true) {
						core.deleteFlight((String) tm.getValueAt(i, 0));
						core.deleteReservation(1, (String) tm.getValueAt(i, 0));
					}
				}
			}
		});

		JButton lfModbtn = new JButton("修改");
		lfPanel.add(lfModbtn);
		lfModbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lfTable.editCellAt(-1, -1);
				TableModel tm = lfTable.getModel();
				for (int i = 0; i < 100; i++) {
					if (tm.getValueAt(i, 0) != null && tm.getValueAt(i, 6) != null
							&& (boolean) tm.getValueAt(i, 6) == true) {
						core.updateFlight((String) tm.getValueAt(i, 0),
								new Flights((String) tm.getValueAt(i, 0), (int) tm.getValueAt(i, 5),
										(int) tm.getValueAt(i, 3), (int) tm.getValueAt(i, 4),
										(String) tm.getValueAt(i, 1), (String) tm.getValueAt(i, 2)));
					}
				}
			}
		});

		JPanel lTaxi = new JPanel();
		lookupTab.addTab("出租车", null, lTaxi, null);
		lTaxi.setLayout(new BorderLayout(0, 0));

		JPanel ltMPanel = new JPanel();
		lTaxi.add(ltMPanel, BorderLayout.NORTH);

		JLabel ltCitylbl = new JLabel("城市");
		ltMPanel.add(ltCitylbl);

		JTextField ltCitytf = new JTextField();
		ltMPanel.add(ltCitytf);
		ltCitytf.setColumns(10);

		JButton ltLookupBtn = new JButton("查询");
		ltMPanel.add(ltLookupBtn);
		ltLookupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ltTable.setModel(
						new DefaultTableModel(new Object[100][5], new String[] { "城市", "总数", "可用数量", "价格", "选中" }) {
							Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class,
									Integer.class, Boolean.class };

							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}

							boolean[] columnEditables = new boolean[] { false, true, false, true, true };

							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						});
				String location = ltCitytf.getText();
				if (location.isEmpty()) {
					location = null;
				}
				ResultSet result = core.showCar(location);
				try {
					int i = 0;
					while (result.next()) {
						ltTable.getModel().setValueAt(result.getString(1), i, 0);
						ltTable.getModel().setValueAt(result.getInt(3), i, 1);
						ltTable.getModel().setValueAt(result.getInt(4), i, 2);
						ltTable.getModel().setValueAt(result.getInt(2), i, 3);
						i++;
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		ltTable = new JTable();
		ltTable.setModel(new DefaultTableModel(new Object[100][5], new String[] { "城市", "总数", "可用数量", "价格", "选中" }) {
			Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class, Integer.class,
					Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, true, false, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ltTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane ltScrollPane = new JScrollPane(ltTable);
		lTaxi.add(ltScrollPane, BorderLayout.CENTER);

		JPanel ltPanel = new JPanel();
		lTaxi.add(ltPanel, BorderLayout.SOUTH);

		JButton ltDelbtn = new JButton("删除");
		ltPanel.add(ltDelbtn);
		ltDelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ltTable.editCellAt(-1, -1);
				TableModel tm = ltTable.getModel();
				for (int i = 0; i < 100; i++) {
					if (tm.getValueAt(i, 0) != null && tm.getValueAt(i, 4) != null
							&& (boolean) tm.getValueAt(i, 4) == true) {
						core.deleteCar((String) tm.getValueAt(i, 0));
						core.deleteReservation(3, (String) tm.getValueAt(i, 0));
					}
				}
			}
		});

		JButton ltModbtn = new JButton("修改");
		ltPanel.add(ltModbtn);
		ltModbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ltTable.editCellAt(-1, -1);
				TableModel tm = ltTable.getModel();
				for (int i = 0; i < 100; i++) {
					if (tm.getValueAt(i, 0) != null && tm.getValueAt(i, 4) != null
							&& (boolean) tm.getValueAt(i, 4) == true) {
						core.updateCar((String) tm.getValueAt(i, 0), new Cars((String) tm.getValueAt(i, 0),
								(int) tm.getValueAt(i, 3), (int) tm.getValueAt(i, 1), (int) tm.getValueAt(i, 2)));
					}
				}
			}
		});

		JPanel lHotel = new JPanel();
		lookupTab.addTab("宾馆", null, lHotel, null);
		lHotel.setLayout(new BorderLayout(0, 0));

		JPanel lhMPanel = new JPanel();
		lHotel.add(lhMPanel, BorderLayout.NORTH);

		JLabel lhCitylbl = new JLabel("城市");
		lhMPanel.add(lhCitylbl);

		JTextField lhCitytf = new JTextField();
		lhMPanel.add(lhCitytf);
		lhCitytf.setColumns(10);

		JButton lhLookupBtn = new JButton("查询");
		lhMPanel.add(lhLookupBtn);
		lhLookupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lhTable.setModel(
						new DefaultTableModel(new Object[100][5], new String[] { "城市", "房间总数", "剩余房间", "价格", "选中" }) {
							Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class,
									Integer.class, Boolean.class };

							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}

							boolean[] columnEditables = new boolean[] { false, true, false, true, true };

							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						});
				String location = lhCitytf.getText();
				if (location.isEmpty()) {
					location = null;
				}
				ResultSet result = core.showHotel(location);
				try {
					int i = 0;
					while (result.next()) {
						lhTable.getModel().setValueAt(result.getString(1), i, 0);
						lhTable.getModel().setValueAt(result.getInt(3), i, 1);
						lhTable.getModel().setValueAt(result.getInt(4), i, 2);
						lhTable.getModel().setValueAt(result.getInt(2), i, 3);
						i++;
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		lhTable = new JTable();
		lhTable.setModel(new DefaultTableModel(new Object[100][5], new String[] { "城市", "房间总数", "剩余房间", "价格", "选中" }) {
			Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class, Integer.class,
					Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, true, false, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		lhTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane lhScrollPane = new JScrollPane(lhTable);
		lHotel.add(lhScrollPane, BorderLayout.CENTER);

		JPanel lhPanel = new JPanel();
		lHotel.add(lhPanel, BorderLayout.SOUTH);

		JButton lhDelbtn = new JButton("删除");
		lhPanel.add(lhDelbtn);
		lhDelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lhTable.editCellAt(-1, -1);
				TableModel tm = lhTable.getModel();
				for (int i = 0; i < 100; i++) {
					if (tm.getValueAt(i, 0) != null && tm.getValueAt(i, 4) != null
							&& (boolean) tm.getValueAt(i, 4) == true) {
						core.deleteHotel((String) tm.getValueAt(i, 0));
						core.deleteReservation(2, (String) tm.getValueAt(i, 0));
					}
				}
			}
		});

		JButton lhModbtn = new JButton("修改");
		lhPanel.add(lhModbtn);
		lhModbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lhTable.editCellAt(-1, -1);
				TableModel tm = lhTable.getModel();
				for (int i = 0; i < 100; i++) {
					if (tm.getValueAt(i, 0) != null && tm.getValueAt(i, 4) != null
							&& (boolean) tm.getValueAt(i, 4) == true) {
						core.updateHotel((String) tm.getValueAt(i, 0), new Hotels((String) tm.getValueAt(i, 0),
								(int) tm.getValueAt(i, 3), (int) tm.getValueAt(i, 1), (int) tm.getValueAt(i, 2)));
					}
				}
			}
		});

		JPanel lResv = new JPanel();
		lookupTab.addTab("预订情况", null, lResv, null);
		lResv.setLayout(new BorderLayout(0, 0));

		JPanel lrMPanel = new JPanel();
		lResv.add(lrMPanel, BorderLayout.NORTH);

		JLabel lrCustomerlbl = new JLabel("客户姓名");
		lrMPanel.add(lrCustomerlbl);

		JTextField lrCustomerf = new JTextField();
		lrMPanel.add(lrCustomerf);
		lrCustomerf.setColumns(10);

		JButton lrLookupBtn = new JButton("查询");
		lrMPanel.add(lrLookupBtn);
		lrLookupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lrTable.setModel(
						new DefaultTableModel(new Object[100][5], new String[] { "姓名", "城市/航班", "种类", "价格", "选中" }) {
							Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class,
									Boolean.class };

							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}

							boolean[] columnEditables = new boolean[] { false, false, false, false, true };

							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						});
				String custName = lrCustomerf.getText();
				if (custName.isEmpty()) {
					custName = null;
				}
				ResultSet result = core.showReservation(custName);
				Vector<Travel> travel = new Vector<>();
				travels = new Vector<>();
				textArea.setText("");
				int sumCost = 0;
				try {
					int i = 0;
					String type[] = { "航班", "宾馆", "出租车" };
					while (result.next()) {
						lrTable.getModel().setValueAt(result.getString(1), i, 0);
						lrTable.getModel().setValueAt(result.getString(2), i, 1);
						lrTable.getModel().setValueAt(type[result.getInt(3) - 1], i, 2);
						lrTable.getModel().setValueAt(result.getInt(4), i, 3);
						if (custName != null) {
							sumCost += result.getInt(4);
							if (result.getInt(3) == 1) {
								String sql = "select FromCity,ArivCity from Flights where flightNum=?";
								PreparedStatement pstm = core.con.prepareStatement(sql);
								pstm.setString(1, result.getString(2));
								ResultSet resultTemp = pstm.executeQuery();
								if (resultTemp.next()) {
									travel.addElement(new Travel(resultTemp.getString(1), resultTemp.getString(2)));
								}
							}
						}
						i++;
					}
					if (custName != null) {
						mergeTravel(travel);
						for (LinkedList<Travel> linkedList : travels) {
							textArea.setText(textArea.getText() + linkedList.getFirst().from);
							for (Travel t : linkedList) {
								textArea.setText(textArea.getText() + " - " + t.ariv);
							}
							textArea.setText(textArea.getText() + "\n");
						}
						textArea.setText(textArea.getText() + "Cost:" + sumCost);
						if (checkTravel()) {
							textArea.setText(textArea.getText() + "\n路线完整");
						} else {
							textArea.setText(textArea.getText() + "\n路线不完整");
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		lrTable = new JTable();
		lrTable.setModel(new DefaultTableModel(new Object[100][5], new String[] { "姓名", "城市/航班", "种类", "价格", "选中" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		lrTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane lrScrollPane = new JScrollPane(lrTable);
		lResv.add(lrScrollPane, BorderLayout.CENTER);

		JPanel lrPanel = new JPanel();
		lResv.add(lrPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_lrPanel = new GridBagLayout();
		gbl_lrPanel.columnWidths = new int[] { 50, 50, 50, 50, 50, 50, 50, 50, 50 };
		gbl_lrPanel.rowHeights = new int[] { 30, 30, 30 };
		gbl_lrPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_lrPanel.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		lrPanel.setLayout(gbl_lrPanel);

		textArea = new JTextArea();
		textArea.setColumns(8);
		textArea.setRows(3);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.gridheight = 3;
		gbc_textArea.gridwidth = 5;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 0;
		lrPanel.add(textArea, gbc_textArea);

		JButton lrDelbtn = new JButton("删除");
		GridBagConstraints gbc_lrDelbtn = new GridBagConstraints();
		gbc_lrDelbtn.insets = new Insets(0, 0, 5, 5);
		gbc_lrDelbtn.gridx = 6;
		gbc_lrDelbtn.gridy = 1;
		lrPanel.add(lrDelbtn, gbc_lrDelbtn);
		lrDelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lrTable.editCellAt(-1, -1);
				TableModel tm = lrTable.getModel();
				for (int i = 0; i < 100; i++) {
					if (tm.getValueAt(i, 0) != null && tm.getValueAt(i, 4) != null
							&& (boolean) tm.getValueAt(i, 4) == true) {
						switch ((String) tm.getValueAt(i, 2)) {
						case "航班":
							core.deleteReservation((String) tm.getValueAt(i, 0), 1, (String) tm.getValueAt(i, 1));
							break;
						case "宾馆":
							core.deleteReservation((String) tm.getValueAt(i, 0), 2, (String) tm.getValueAt(i, 1));
							break;
						case "出租车":
							core.deleteReservation((String) tm.getValueAt(i, 0), 3, (String) tm.getValueAt(i, 1));
							break;
						default:
							break;
						}
					}
				}
			}
		});

		setVisible(true);
		setSize(800, 600);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				core.disconnect();
				System.exit(0);
			}
		});
	}

	class Travel {
		String from;
		String ariv;

		public Travel(String from, String ariv) {
			this.from = from;
			this.ariv = ariv;
		}
	}

	Vector<LinkedList<Travel>> travels;

	private void mergeTravel(Vector<Travel> travel) {
		boolean state;
		while (!travel.isEmpty()) {
			state = false;
			for (int i = 0; i < travel.size(); i++) {
				Travel t = travel.get(i);
				for (LinkedList<Travel> linkedList : travels) {
					if (t.from.equals(linkedList.getLast().ariv)) {
						linkedList.addLast(t);
						travel.removeElement(t);
						state = true;
						i--;
						continue;
					}
					if (t.ariv.equals(linkedList.getFirst().from)) {
						linkedList.addFirst(t);
						travel.removeElement(t);
						state = true;
						i--;
					}
				}
			}
			if (!state) {
				LinkedList<Travel> ll = new LinkedList<>();
				ll.add(travel.get(0));
				travel.removeElementAt(0);
				travels.addElement(ll);
			}
		}
		return;
	}

	private boolean checkTravel() {
		if (travels.size() == 1) {
			if (travels.get(0).getFirst().from.equals(travels.get(0).getLast().ariv)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		new Lab02GUI();
	}

}
