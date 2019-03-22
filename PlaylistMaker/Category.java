package PlaylistMaker;

public class Category {

	public static int a=0;
	
	private int id;
	private int noOfFiles;
	private String name;
	private Song[] song;

	public Category(String name, int noOfFiles) {
		this.id = a++;
		this.name = name;
		this.song = new Song[noOfFiles];
		this.noOfFiles= noOfFiles;

	}
	
	public int getNoOfFiles() {
		return this.noOfFiles;
	}

	public void setNoOfFiles(int noOfFiles) {
		this.noOfFiles = noOfFiles;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void writeSongs(int noOfFiles) {
		for (int i=0; i<this.noOfFiles;i++) {
			System.out.println(this.name + ": "+ this.song[i].getId() + " " + this.song[i].getArtist() + " - " + this.song[i].getName());
		}
		
	}

	public void addSong(Song song, int a) {
			if (this.song[a] != null);
			this.song[a] = song;
			
		
	}
	
	public boolean backSong(int noOfFiles) {
		for (int i = 0; i < noOfFiles; i++) {
	            System.out.println(this.song[i].getPath());			
		}
		
		return true;
	}
	
	

	public String getName() {
		return name;
	}
	
	public int getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Song[] getSong() {
		return song;
	}

	public void setSong(Song[] song) {
		this.song = song;
	}

	
	public void write() {
		for (int i=1; i<id-1;i++) {
		System.out.println(this.getName() + this.song[i]); 
		}
	}

	@Override
	public String toString() {
		return this.getName() + " " + this.id;
	}
	
	

}
