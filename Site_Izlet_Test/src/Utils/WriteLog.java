package Utils;

import java.io.FileWriter;
import java.io.IOException;

public class WriteLog {

	public static final String LOG_FILENAME = "C:\\Users\\Ivan\\Desktop\\TestLog.txt";

	// Klasa WriteLog sluzi za kreiranje Log fajla automatskog testa

	// OTVARANJE NOVOG FAJLA TestLog (OVERWRITE)
	public static void newTest(String text) throws IOException {
		try (FileWriter writer = new FileWriter(LOG_FILENAME)) {
			writer.write(text);

		}
	}

	// DODAVANJE NOVOG REDA U TestLog
	public static void write(String text) {
		try {
			FileWriter fw = new FileWriter(LOG_FILENAME, true);
			fw.write(text);
			System.out.println(text);
			fw.write(System.getProperty("line.separator"));
			fw.close();
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}

	}

	// ZAGLAVLJE ZA SVAKI TEST

	public static void header(String name) {
		StringBuilder sb = new StringBuilder();
		sb.append(System.getProperty("line.separator"));
		sb.append("********************************************************");
		sb.append(System.getProperty("line.separator"));
		sb.append(name);
		sb.append(System.getProperty("line.separator"));
		sb.append("********************************************************");

		String text = sb.toString();
		WriteLog.write(text);

	}

	public static void endTest(float minutes, int n) {
		StringBuilder sb = new StringBuilder();
		String formattedMinutes = String.format("%.02f", minutes);
		sb.append(System.getProperty("line.separator"));
		sb.append("********************************************************");
		sb.append(System.getProperty("line.separator"));
		sb.append("Automatski test sajta Izlet uspsno zavrsen");
		sb.append(System.getProperty("line.separator"));
		sb.append("Test je trajao " + formattedMinutes + " minuta");
		sb.append(System.getProperty("line.separator"));
		sb.append("Pronadjeno : " + n + " gresaka!");
		sb.append(System.getProperty("line.separator"));
		sb.append("********************************************************");

		String text = sb.toString();
		WriteLog.write(text);

	}

}
