package PlaylistMaker;

//import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.Writer;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Playlist {
	public static void main(String[] args) {

		Song[] song;
		Song[] final_playlist = new Song[1];
		String path;
		Category category;
		
		final_playlist[0] = new Song("path", "artist", "name");

		path = "C:\\MUZIKA\\01 PREPODNE";
		song = makeSongArray(path);
		
		final_playlist = makeRandom(song, 20, final_playlist);
		
		System.out.println(final_playlist.length);
		
	}
	
	
	
	public static Song[] makeSongArray(String path) {
		// Pravi niz objekta Song od fajlova iz unetog direktorijuma
		
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		int numberOfFiles = folder.listFiles().length;
		Song[] song = new Song[numberOfFiles];
		int a = 0;
		for (File file : listOfFiles) {
			if (file.isFile()) {
				String artist = file.getName().substring(0, file.getName().indexOf(" - "));
				String name = file.getName().substring(file.getName().indexOf("- ") + 2, file.getName().indexOf("."));
				song[a] = new Song(path, artist, name);
				a++;
			}
		}
		return song;
		
	}

	public static Song[] makeRandom(Song[] song, int numberOfSongs, Song[] final_playlist) {
	// Pravljenje random niza objekta Song u odnosu na zadat broj

		Random r = new Random();
		int rnd = r.nextInt(song.length - 0);
		int br = 0;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Song[] song_temp = new Song[numberOfSongs];
		numbers.clear();

		while (br < numberOfSongs) {
			if (!numbers.contains(rnd)) {
				boolean isIn = false;
				for (int j=0; j<final_playlist.length;j++)
				if (final_playlist[j].getName().equals(song[rnd].getName())) isIn=true;
				if (isIn == false) {
				numbers.add(rnd);
				song_temp[br] = song[rnd];
				br++;
				}
			}
			rnd = r.nextInt(song.length - 0);

		}
		return song_temp;
	}

    public Song[] expandPlaylist(Song[] song, Song[] final_playlist) {
		int expandNumber = song.length;
		int number = final_playlist.length;
		Song[] song_temp = new Song[expandNumber + number];

		for (int i = 0; i < number; i++)
			song_temp[i] = final_playlist[i];
		for (int i = number; i < (number + expandNumber); i++)
			song_temp[i] = final_playlist[i];
	    return final_playlist;
	}

		
	public void playlist2File() {
/*	DBPlaylist database = new DBPlaylist("jdbc:sqlite:" + DBConfig.dbPathPlaylist);
	try {
		database.addCategory(category.getId(), category.getName());

	} catch (SQLException e) {
		e.printStackTrace();
	}*/

	
	
	
	
	
}
	
	
	public void makeCategory() {
//		int br = 0;
		Song song;
		String dir;
		Category category;

		dir = "C:\\MUZIKA\\01 PREPODNE";

		File folder = new File(dir);
		File[] listOfFiles = folder.listFiles();

		String nameOfCategory = dir.substring(dir.indexOf("\\") + 1, dir.length());
		int numberOfFiles = folder.listFiles().length;
		category = new Category(nameOfCategory, numberOfFiles);
		int a = 0;
		for (File file : listOfFiles) {
			if (file.isFile()) {
				String path = dir + "\\" + file.getName();
				String artist = file.getName().substring(0, file.getName().indexOf(" - "));
				String name = file.getName().substring(file.getName().indexOf("- ") + 2, file.getName().indexOf("."));
				song = new Song(path, artist, name);
				category.addSong(song, a++);
			}
		}
		//makeRandom(category, 10, category.getSong().length);

		// category.writeSongs(3);
		category.getName();

	}
	public static boolean makePlaylist() {
		

		Random r = new Random();
		int low = 100;
		int high = 300;
		String p = "C:\\Users\\Ivan\\Desktop\\test.m3u";

		// Writer writer = null;

		// try {
		// writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(p),
		// "utf-8"));

		// writer.write("#EXTM3U");

		// String song_name;
		// String song_path;
		// writer.write(System.lineSeparator());
		// writer.write("#EXTINF:"+ rnd + "," + category.getSong()[rnd1].getArtist() + "
		// - " + category.getSong()[rnd1].getName());
		// writer.write(System.lineSeparator());
		// song_path = category.getSong()[rnd1].getPath();
		// writer.write(song_path);

		// } catch (IOException ex) {
		// Report
		// } finally {
		// try {
		// writer.close();
		// } catch (Exception ex) {
		/* ignore */
		// }
//	}

		return true;
	}
}
