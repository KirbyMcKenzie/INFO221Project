
import dao.StudentDAO;
import dao.StudentJdbcDAO;
import gui.MainMenuFrame;
import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {

		final StudentDAO dao = new StudentJdbcDAO();
//		final StudentDAO dao = new StudentCollectionsDAO();

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MainMenuFrame(dao).setVisible(true);
			}

		});
	}
}
