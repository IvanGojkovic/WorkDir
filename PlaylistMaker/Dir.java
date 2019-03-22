package PlaylistMaker;

import java.io.File;

public class Dir {

    private int id=0;
    private Song[] song;
    
    public Dir(String path) {
    	this.id = id;
    	
    	
    	id++;
    
    	
    }
    
    
    public void getDir(String path) {
	File folder = new File(path);
	File[] listOfFiles = folder.listFiles();

	for (File file : listOfFiles) {
	    if (file.isFile()) {
	    	

	    }
	}
    }
	
	
}
