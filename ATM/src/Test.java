import java.sql.*;

class TestBank implements Runnable {

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		LoginGUI l1 = new LoginGUI();
	}

}

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// @SuppressWarnings("unused")
		LoginGUI l = new LoginGUI();
//		TestBank tb = new TestBank();
//		new Thread(tb).start();
//		new Thread(tb).start();
	}
}
