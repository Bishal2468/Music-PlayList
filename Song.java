package assignment2;
/*
Matriculation Number -  Name
 761318      : Bishal Karki
 */

public class Song {
	private String title, artist;
	 private int ranking;

	public Song(String title, String artist, int ranking){
		this.artist = artist;
		this.ranking = ranking;
		this.title = title;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}



	@Override
	public  boolean equals(Object song) {
		//if the object is compared with itself then return true
		if (song == this)
			return true;
		if(!(song instanceof Song))
			return false;

		return title.equals(((Song) song).getTitle()) && artist.equals(((Song) song).getArtist()) && ranking == ((Song) song).getRanking();

	}
	}




