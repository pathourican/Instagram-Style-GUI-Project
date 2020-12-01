/*
 * Patrick Hourican | pjh4as
 * 
 * CS 2110 - HW 1 Part B
 */

import java.util.ArrayList;
import java.util.HashSet;

public class Library extends PhotoContainer{
	
	private final int id;
	private HashSet<Album> albums;
	
	public Library(String name, int id) {
		// Initializes the fields of Library.
		super(name); // Super lets the fields inherit the properties of the identical fields in Photo.
		this.id = id;
		this.albums = new HashSet<Album>();
	}

	public int getId() {
		// Returns the int value for id.
		return id;
	}

	public HashSet<Album> getAlbums() {
		// Returns the HashSet albums.
		return albums;
	}
	
	public boolean removePhoto(Photo p) {
		/*
		 *  Checks if p is in photos, if true, p is removed from photos and true is returned. 
		 *  If p is not in photos, false is returned.
		 */
		if(photos.contains(p)) {
			photos.remove(p);
			for(Album a: albums) {
				if(a.getPhotos().contains(p)) {
					a.removePhoto(p);
				}
			}
			return true;
		}
		else {
			return false;
		}
	}

	public boolean createAlbum(String albumName) {
		
		// An album object with name albumName is created and added to albums if it does not already exist. 
		
		Album a = new Album(albumName); // An album object is created with the name albumName.
		
		if(albums.contains(a)) {
			/*
			 *  HashSet albums is iterated over and compared using the equals method to test the name of each 
			 *  Album in the albums against albumName (Album a).
			 * 	If an Album exists in albums, false is returned. If not, the album is added to albums, and true is returned.
			 */
			return false;
		}
		else {
			albums.add(a);
			return true;
		}
	}
	
	public boolean removeAlbum(String albumName) {
		
		/*
		 *  An album is casted with name albumName, if the album is contained in albums, it is removed.
		 */
		
		Album a = new Album(albumName); // An album is created with the name albumName.
		
		if(albums.contains(a)) {
			// If albums contains an album with the name albumName, it is removed from the HashSet albums and true is returned.
			albums.remove(a);
			return true;
		}
		else {
			// If albums does not contains an album with the name albumName, false is returned.
			return false;
		}
	}
	
	private Album getAlbumByName(String albumName) {

		/*
		 * Casts albumName to an Album object, then tests if albums contains 
		 * an album with name albumName, if not null is returned.
		 */
		
		Album a = new Album(albumName); // An album is created with the name albumName.

		if(albums.contains(a)) {
			// If the albums set has an album with the name albumName, it is returned, if not null is returned.
			return a;
		}
		else {
			return null;
		}	
	}

	public boolean addPhotoToAlbum(Photo p, String albumName) {

		/*
		 * If the album with albumName is existent and Photo p is in photos,
		 * then photo p is added to the photos in album albumName.
		 */
		
		if(getAlbumByName(albumName) == null) {
			// If the album in albums with name albumName does not exist, false is returned.
			return false;
		}

		if(photos.contains(p)) {
			// If the photos list in library contains the photo p, then it is added to the album with name albumName, and true is returned.

			if(getAlbumByName(albumName).hasPhoto(p)) {
				return false;
			}
			else {
				getAlbumByName(albumName).addPhoto(p);
				return true;
			}
		}
		else {
			return false;
		}
	}

	public boolean removePhotoFromAlbum(Photo p, String albumName) {
		
		/*
		 * Checks if the Album albumName exists and the photo p exists in the photos of albumName.
		 * If both conditions are met, the photo p is removed from the photos of albumName.
		 */
		
		if(getAlbumByName(albumName) == null) {
			// If the album albumName does not exist in albums or the photo p does not exist is albumName, false is returned.
			return false;
		}
		else {
			// If photo p exists in the album albumName, the photo p is removed from the album in albums.
			getAlbumByName(albumName).removePhoto(p);
			return true;
		}
		
	}

	public boolean equals(Object o) {
		// Compares the name and id values of the current Library object and the object passed.
		if(o == null) {
			// Tests for null value for o, returns false if null value indicated.
			return false;
		}

		if(o instanceof Library) {

			Library l = (Library) o; // Casts object o as a Library object called l.

			if(this.id == l.id) {
				/*
				 *  Tests if the id value for the current object Library and object l (o) are equal,
				 *  if both condition is met, they are equal and true is returned.
				 *  If both condition is not met, false is returned.
				 */
				return true;
			}
			else {
				return false;
			}
		}

		return false;
	}

	public String toString() {
		// Returns the values in a string, pairing a string to the value as a label.
		return "Name: " + name + " ID: " + id + " Library: " + photos + " Albums: " + albums;
	}

	public static ArrayList<Photo> commonPhotos(Library a, Library b) {

		ArrayList<Photo> commonPhoto = new ArrayList<Photo>(); // Create the new ArrayList commonPhoto to add to and return.

		/*
		 * Using the first loop to go through the photos in Library a, accessing its photos ArrayList.
		 * Within each run of the first loop, the value in Library a is tested against each value for Library b 
		 * in the nested for loop. 
		 * If a value for Library a and b match through the loops, it is added to the commonPhoto ArrayList.
		 * 
		 * The current commonPhoto ArrayList is returned after the last loop is executed.
		 */
		for(int i = 0; i < a.photos.size(); i++) {
			for(int x = 0;x < b.photos.size(); x++) {
				if(a.photos.get(i).equals(b.photos.get(x))) {
					commonPhoto.add(a.photos.get(i));
				}
			}
		}
		return commonPhoto;
	}

	public static double similarity(Library a, Library b) {

		/*
		 * If neither lists within a or b are empty,
		 * the size of the list within a is checked to see if it is greater than the list in b.
		 * The size of commonPhotos divided by the size of a (if b is greater) 
		 * or b (if a is greater) is then returned.
		 */

		if(a.photos.size() == 0 || b.photos.size() ==0) {
			// If the size of the photos ArrayList in either Library a OR b are equal to zero, then 0.0 is returned.
			return 0.0;
		}
		else {
			/* 
			 * The size value of the list commonPhoto in commonPhotos
			 * is casted as a double (to return a double) and divided by the size of b if the expression is true,
			 * and divided by the list size of a if the expression is false.
			 */
			if(a.photos.size() > b.photos.size()) {

				return (double) commonPhotos(a,b).size() / b.photos.size();
			}
			else {
				return (double) commonPhotos(a,b).size() / a.photos.size();
			}
		}
	}
	
	public static void main(String[] args) {
		

		
		
		/*
		Photo p1 = new Photo("File1", "Cap1", 5);
		Photo p2 = new Photo("File2", "Cap2", 9);
		Photo p3 = new Photo("File2", "Cap2", 9); // p3 equal to p2 to check in equals and other methods.
		Photo p4 = new Photo("File3", "Cap3", 10);
		
		Library l1 = new Library("Library 1", 123);
		Library l2 = new Library("Library 2", 123);
		Library l3 = new Library("Library 3", 456);
		Library l4 = new Library("Library 4", 789);
		Library l5 = new Library("Library 5", 789);
		
		System.out.println(l1.getId());
		System.out.println(l2.getId());
		
		System.out.println(l1.getName());
		System.out.println(l2.getName());
		
		System.out.println(l1);
		l1.setName("Lib 1");
		System.out.println(l1);
		
		System.out.println(" ");
		
		System.out.println(l1.addPhoto(p1));
		l1.addPhoto(p2);
		System.out.println(l1.addPhoto(p3));
		System.out.println(l1.hasPhoto(p1)); // Should print true.
		System.out.println(l1.deletePhoto(p1)); // Should print true and delete photo.
		System.out.println(l1.hasPhoto(p1)); // Should print false.
		System.out.println(l1.deletePhoto(p1)); // Should print false.
		*/
		
		/*
		 * Area above should print:
		 * 
		 * true
		 * false
		 * true
		 * true
		 * false
		 * false
		 */
		
		/*
		System.out.println(" ");
		
		System.out.println(l1.numPhotos()); // Should print 1.
		l1.addPhoto(p3); // Should not add to list, p1 and p3 equal.
		System.out.println(l1);
		System.out.println(l1.numPhotos()); // Should still print 1.
		l1.addPhoto(p4);
		System.out.println(l1.numPhotos()); // Should print 2.
		
		System.out.println(" ");
		
		System.out.println(l1.equals(l2)); // Should print true (same id #).
		System.out.println(l1.equals(l3)); // Should print false.
		System.out.println(l1.equals(null)); // Should print false (null catch).
		
		System.out.println(" ");
		
		System.out.println(l1.toString()); // Print String converted information for l1.
		System.out.println(l2.toString()); // Print String converted information for l2.
		
		System.out.println(" ");
		
		l2.addPhoto(p1);
		l2.addPhoto(p2);
		l2.addPhoto(p4);
		
		l3.addPhoto(p1);
		l3.addPhoto(p2);
		l3.addPhoto(p4);
		
		System.out.println(l1.getPhotos());
		System.out.println(l2.getPhotos());
		
		System.out.println(" ");
		
		/*
		 *  l1 contains p1 and p2.
		 *  l2 contains p1, p2, and p4.
		 *  l3 contains p1, p2, p3.
		 */
		
		/*
		
		System.out.println(commonPhotos(l1,l2)); // Prints a list containing p1 and p2.
		System.out.println(commonPhotos(l2, l3)); // Prints a list containing p1, p2 and p4.
		
		System.out.println(" ");
		
		System.out.println(similarity(l5, l4)); // Should print 0.0, l5 has an empty list.
		System.out.println(similarity(l1,l2)); // Should print 1.0 .
		System.out.println(similarity(l2,l3)); // Should print 1.0 .		
		
		*/
	}
}