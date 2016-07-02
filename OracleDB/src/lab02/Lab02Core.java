package lab02;

import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Flights {
	String flightNum;
	int price;
	int numSeats;
	int numAvail;
	String fromCity;
	String arivCity;

	public Flights(String flightname, int price, int numSeats, int numAvail, String fromCity, String arivCity) {
		super();
		this.flightNum = flightname;
		this.price = price;
		this.numSeats = numSeats;
		this.numAvail = numAvail;
		this.fromCity = fromCity;
		this.arivCity = arivCity;
	}
}

class Hotels {
	String location;
	int price;
	int numRooms;
	int numAvail;

	public Hotels(String location, int price, int numRooms, int numAvail) {
		super();
		this.location = location;
		this.price = price;
		this.numRooms = numRooms;
		this.numAvail = numAvail;
	}
}

class Cars {
	String location;
	int price;
	int numCars;
	int numAvail;

	public Cars(String location, int price, int numCars, int numAvail) {
		super();
		this.location = location;
		this.price = price;
		this.numCars = numCars;
		this.numAvail = numAvail;
	}
}

class Customers {
	String custName;

	public Customers(String custName) {
		super();
		this.custName = custName;
	}
}

class Reservations {
	String custName;
	int resvType;
	String resvKey;

	public Reservations(String custName, int resvType, String resvKey) {
		this.custName = custName;
		this.resvKey = resvKey;
		this.resvType = resvType;
	}
}

public class Lab02Core {

	String driver = "oracle.jdbc.OracleDriver"; // 驱动标识符
	String url = "jdbc:oracle:thin:@localhost:1521:DBLAB"; // 链接字符串
	String user = "monk"; // 数据库的用户名
	String password = "wy10242048"; // 数据库的密码
	Connection con = null;
	PreparedStatement pstm = null;
	Statement stm = null;
	ResultSet result = null;
	boolean flag = false;

	public void connect() {
		try {
			Class.forName(driver);
			System.out.println("开始尝试连接数据库！");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("连接成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			if (result != null)
				result.close();
			if (pstm != null)
				pstm.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();
			System.out.println("数据库连接已关闭！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertFlight(Vector<Flights> flights) {
		String sql = "insert into Flights values(?,?,?,?,?,?)";
		try {
			pstm = con.prepareStatement(sql);
			for (Flights flight : flights) {
				pstm.setString(1, flight.flightNum);
				pstm.setInt(2, flight.price);
				pstm.setInt(3, flight.numSeats);
				pstm.setInt(4, flight.numAvail);
				pstm.setString(5, flight.fromCity);
				pstm.setString(6, flight.arivCity);
				pstm.addBatch();
			}
			pstm.executeBatch();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean updateFlight(String flightNum, Flights flight) {
		try {
			stm = con.createStatement();
			stm.executeUpdate(new String("update flights set price=") + flight.price + ",numAvail=(" + flight.numSeats
					+ "-numSeats)+" + flight.numAvail + ",numseats=" + flight.numSeats + ",fromCity='" + flight.fromCity
					+ "',arivCity='" + flight.arivCity + "' where flightnum='" + flightNum + "'");
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ResultSet showFlight(String from, String ariv) {
		try {
			if (from == null) {
				if (ariv == null) {
					String sql = "select * from Flights";
					pstm = con.prepareStatement(sql);
				} else {
					String sql = "select * from Flights where ARIVCITY=?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, ariv);
				}
			} else {
				if (ariv == null) {
					String sql = "select * from Flights where FROMCITY=?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, from);
				} else {
					String sql = "select * from Flights where FROMCITY=? AND ARIVCITY=?";
					pstm = con.prepareStatement(sql);
					pstm.setString(1, from);
					pstm.setString(2, ariv);
				}
			}
			result = pstm.executeQuery();
			// System.out.println("航班班次 座位总数 剩余座位 航班起点 航班终点 航班价格");
			// while (result.next()) {
			// System.out.printf("%10s%10d%10d%10s%10s%10d\n", result.getString(1), result.getInt(3), result.getInt(4),
			// result.getString(5), result.getString(6), result.getInt(2));
			// }
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteFlight(String flightnum) {
		try {
			stm = con.createStatement();
			stm.executeUpdate(new String("delete from flights where flightnum='") + flightnum + "'");
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertHotels(Vector<Hotels> hotels) {
		String sql = "insert into hotels values(?,?,?,?)";
		try {
			pstm = con.prepareStatement(sql);
			for (Hotels hotel : hotels) {
				pstm.setString(1, hotel.location);
				pstm.setInt(2, hotel.price);
				pstm.setInt(3, hotel.numRooms);
				pstm.setInt(4, hotel.numAvail);
				pstm.addBatch();
			}
			pstm.executeBatch();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean updateHotel(String location, Hotels hotel) {
		try {
			stm = con.createStatement();
			stm.executeUpdate(new String("update Hotels set price=") + hotel.price + ",numAvail=(" + hotel.numRooms
					+ "-numRooms)+" + hotel.numAvail + ",numRooms=" + hotel.numRooms + " where location='" + location + "'");
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ResultSet showHotel(String location) {
		try {
			if (location == null) {
				String sql = "select * from Hotels";
				pstm = con.prepareStatement(sql);
			} else {
				String sql = "select * from Hotels where LOCATION=?";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, location);
			}
			result = pstm.executeQuery();
			// System.out.println("城市 房间总数 剩余房间 价格");
			// while (result.next()) {
			// System.out.printf("%10s%10d%10d%10d\n", result.getString(1), result.getInt(3), result.getInt(4),
			// result.getInt(2));
			// }
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteHotel(String location) {
		try {
			stm = con.createStatement();
			stm.executeUpdate(new String("delete from Hotels where location='") + location + "'");
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertCars(Vector<Cars> cars) {
		String sql = "insert into cars values(?,?,?,?)";
		try {
			pstm = con.prepareStatement(sql);
			for (Cars car : cars) {
				pstm.setString(1, car.location);
				pstm.setInt(2, car.price);
				pstm.setInt(3, car.numCars);
				pstm.setInt(4, car.numAvail);
				pstm.addBatch();
			}
			pstm.executeBatch();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean updateCar(String location, Cars car) {
		try {
			stm = con.createStatement();
			stm.executeUpdate(new String("update Cars set price=") + car.price + ",numAvail=(" + car.numCars
					+ "-numCars)+" + car.numAvail + ",numCars=" + car.numCars + " where location='" + location + "'");
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ResultSet showCar(String location) {
		try {
			if (location == null) {
				String sql = "select * from Cars";
				pstm = con.prepareStatement(sql);
			} else {
				String sql = "select * from Cars where LOCATION=?";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, location);
			}
			result = pstm.executeQuery();
			// System.out.println("城市 总数 可用数量 价格");
			// while (result.next()) {
			// System.out.printf("%10s%10d%10d%10d\n", result.getString(1), result.getInt(3), result.getInt(4),
			// result.getInt(2));
			// }
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteCar(String location) {
		try {
			stm = con.createStatement();
			stm.executeUpdate(new String("delete from Cars where location='") + location + "'");
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertCustomers(Vector<Customers> customers) {
		String sql = "insert into Customers values(?)";
		try {
			pstm = con.prepareStatement(sql);
			for (Customers customer : customers) {
				pstm.setString(1, customer.custName);
				pstm.addBatch();
			}
			pstm.executeBatch();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCustomer(String custName, Customers customer) {
		try {
			stm = con.createStatement();
			stm.executeUpdate(new String("update Customers set custName=") + customer.custName + "' where location='"
					+ custName + "'");
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet showCustomer(String custName) {
		try {
			if (custName == null) {
				String sql = "select * from Customers";
				pstm = con.prepareStatement(sql);
			} else {
				String sql = "select * from Customers where custName=?";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, custName);
			}
			result = pstm.executeQuery();
			// System.out.println("姓名");
			// while (result.next()) {
			// System.out.printf("%10s\n", result.getString(1));
			// }
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteCustomer(String custName) {
		try {
			stm = con.createStatement();
			stm.executeUpdate(new String("delete from Customers where custName='") + custName + "'");
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertReservations(Reservations reservation) {
		try {
			stm = con.createStatement();
			stm.executeUpdate(new String("insert into reservations values('" + reservation.custName + "',"
					+ reservation.resvType + ",'" + reservation.resvKey + "')"));
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet showReservation(String custName) {
		// String type[] = { "航班", "宾馆", "出租车" };
		try {
			if (custName == null) {
				String sql = "select reservations.custname,flights.flightnum,reservations.resvtype,flights.price from reservations,flights where reservations.resvType=1 and reservations.resvkey=flights.flightnum union select reservations.custname,hotels.location,reservations.resvtype,hotels.price from reservations,hotels where reservations.resvType=2 and reservations.resvkey=hotels.location union select reservations.custname,cars.location,reservations.resvtype,cars.price from reservations,cars where reservations.resvType=3 and reservations.resvkey=cars.location";
				pstm = con.prepareStatement(sql);
			} else {
				String sql = "select reservations.custname,flights.flightnum,reservations.resvtype,flights.price from reservations,flights where reservations.custname=? and reservations.resvType=1 and reservations.resvkey=flights.flightnum union select reservations.custname,hotels.location,reservations.resvtype,hotels.price from reservations,hotels where reservations.custname=? and reservations.resvType=2 and reservations.resvkey=hotels.location union select reservations.custname,cars.location,reservations.resvtype,cars.price from reservations,cars where reservations.custname=? and reservations.resvType=3 and reservations.resvkey=cars.location";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, custName);
				pstm.setString(2, custName);
				pstm.setString(3, custName);
			}
			result = pstm.executeQuery();
			// System.out.println("姓名 城市/航班 种类 价格");
			// while (result.next()) {
			// System.out.printf("%10s%10s%10s%10d\n", result.getString(1), result.getString(2), type[result.getInt(3) - 1],
			// result.getInt(4));
			// }
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteReservation(String custName) {
		try {
			stm = con.createStatement();
			stm.executeUpdate(new String(
					"update flights set numAvail=numAvail+1 where flightNum=(select resvKey from reservations where custName='"
							+ custName + "' and resvType=1)"));
			stm.close();
			stm = con.createStatement();
			stm.executeUpdate(new String(
					"update Hotels set numAvail=numAvail+1 where location=(select resvKey from reservations where custName='"
							+ custName + "' and resvType=2)"));
			stm.close();
			stm = con.createStatement();
			stm.executeUpdate(new String(
					"update Cars set numAvail=numAvail+1 where location=(select resvKey from reservations where custName='"
							+ custName + "' and resvType=3)"));
			stm.close();
			stm = con.createStatement();
			stm.executeUpdate(new String("delete from Reservations where custName='") + custName + "'");
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteReservation(int resvType, String resvKey) {
		try {
			stm = con.createStatement();
			stm.executeUpdate(
					new String("delete from Reservations where resvType=" + resvType + " and resvKey='" + resvKey + "'"));
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteReservation(String custName, int resvType, String resvKey) {
		try {
			stm = con.createStatement();
			switch (resvType) {
				case 1:
					stm.executeUpdate(
							new String("update flights set numAvail=numAvail+1 where flightNum='" + resvKey + "'"));
					break;
				case 2:
					stm.executeUpdate(new String("update Hotels set numAvail=numAvail+1 where location='" + resvKey + "'"));
					break;
				case 3:
					stm.executeUpdate(new String("update Cars set numAvail=numAvail+1 where location='" + resvKey + "'"));
					break;
				default:
					break;
			}
			stm.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			stm = con.createStatement();
			stm.executeUpdate(new String("delete from Reservations where custName='") + custName + "' and resvType='"
					+ resvType + "' and resvKey='" + resvKey + "'");
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Lab02Core core = new Lab02Core();
		core.connect();
		// core.showFlight(null, null);
		// core.showReservation("Bob");
		// core.showCustomer(null);
		// core.showCar(null);
		// core.showReservation(null);
		core.disconnect();
	}

}
