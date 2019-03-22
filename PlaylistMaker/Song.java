package PlaylistMaker;

public class Song {
	
	public static int a=0;
	
	private int id;
	private String path;
	private String category;
	private String name;
	private String artist;
	private String genre;
	private String rhythm;
	private String speed;
	
	public Song(String path,String artist,String name) {
		this.id = a++;
		this.path = path;
		this.name = name;
		this.artist = artist;
		this.genre = "";
		this.rhythm = "";
		this.speed = "";
		
		
		
	}
	
	


	public int getId() {
		return this.id;
	}


	public String getCategory() {
		return this.category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getName() {
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getArtist() {
		return this.artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public String getGenre() {
		return this.genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getPath() {
		return this.path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	@Override
	public String toString() {
		return "Uspesno kreiran";
	}
	
	
	
	

}
