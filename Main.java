package assignment2;

public class Main {

	public static void main(String[] args){
		Song song1 = new Song("Tum milaye","Himmant", 1);
		Song song2 = new Song("Football","Jonny", 4);
		Song song3 = new Song("Avtar","Pull", 1);
		Song song4 = new Song("Badi muskil","Atif", 2);
		Song song5 = new Song("ratro rachandra","Deepa", 6);
		Song song6 = new Song("kuchi kuchi","karki",3);
		Song song7 = new Song("I love you","Huma",8);



		Playlist ll = new Playlist();

		Playlist pl = new Playlist();
		Playlist l2 = new Playlist();

		ll.add(song1);
		ll.add(song2);
		ll.add(song3);
		ll.add(song4);
		pl.add(song5);
		pl.add(song6);
		pl.add(song7);
		l2.add(song2);
		l2.add(song3);
		l2.add(song4);
		l2.add(song5);
		l2.add(song6);

		System.out.println("\n playlist ll ");
		ll.printList();

		System.out.println("\n playlist pl ");
		pl.printList();
		//Playlist newPlaylist = ll.appendList(ll, pl);
		//System.out.println("\n playlist new playlist");
		//newPlaylist.printList();

    Playlist pplaylist = ll.shuffleMerge(ll,pl);
		System.out.println("\n playlist pplaylist playlist");
    pplaylist.printList();



    Playlist abc = ll.frontBackSplit(l2);
    System.out.println("fornt playlist");
    abc.printList();



     //Playlist altPlaylist = pplaylist.alternatingSplit(pplaylist);
     	//System.out.println("\n playlist pplaylist playlist");
    //pplaylist.printList();

//	System.out.println("\n playlist altPlaylist playlist");
//    altPlaylist.printList();


          //  ll.alternatingSplit(l2);
      // ll.frontBackSplit(l2);



	}
}
