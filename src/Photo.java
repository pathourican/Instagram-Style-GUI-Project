import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * Patrick Hourican | pjh4as
 * 
 * CS 2110 - HW 1 Part A
 */

public class Photo implements Comparable<Photo> {
	private final String caption;
	private final String filename;
	private final String dateTaken;
	private int rating;
	protected BufferedImage imageData;
	
	public Photo(String filename, String caption) {
		// The constructor initializes the fields of Photo.
		this.filename = filename;
		this.caption = caption;
		this.rating = 1;
		this.dateTaken = "1901-01-01";
	}
	
	public Photo(String filename, String caption, String dateTaken, int rating) {
		// The constructor takes all 4 fields and initializes them, while also checking validity of rating and dateTaken.
		
		this.filename = filename;
		this.caption = caption;
		
		if(rating < 1 || rating > 5) {
			/*
			 *  If the rating is outside the valid range of 1-5, then it is set to the default value of 1.
			 *  If rating is within 1-5, the value is initialized as given in the constructor.
			 */
			this.rating = 1;
		}
		else {
			this.rating = rating;
		}
		
		if(DateLibrary.isValidDate(dateTaken)) {
			/*
			 *  If the dateTaken is a valid date, the value is initialized as given in the 
			 *  constructor. If not valid, the value is initialized as the default value of "1901-01-01".
			 */
			this.dateTaken = dateTaken;
		}
		else {
			this.dateTaken = "1901-01-01";
		}
		
	}
	
	public boolean loadImageData(String filename) {
		
		/*
		 * Uses try/catch block to load the image in the File that corresponds 
		 * to the filename of the image, setting the returned data equal to 
		 * imageData and returns true.
		 * 
		 * If any type of exception is caught, an error message is displayed in the console and 
		 * false is returned.
		 * 
		 * @param filename - the filename of the Photo is taken in to find the image in the File.
		 */
		
		try {
			imageData = ImageIO.read(new File(filename));
			return true;
		} catch (Exception e) {
			
			System.out.println("Error loading image data.");
			return false;
		}
	}
	
	public BufferedImage getImageData() {
		// Retrieves and returns the imageData of the current BufferedImage object.
		return imageData;
	}
	
	public String getFilename() {
		// Retrieves and returns the String value of filename.
		return filename;
	}
	
	public String getCaption() {
		// Retrieves and returns the String value of caption.
		return caption;
	}
	
	public String getDateTaken() {
		// Retrieved and returns the String value of dateTaken.
		return dateTaken;
	}
	
	public int getRating() {
		// Retrieves and returns the int value of rating.
		return rating;
	}
	
	public boolean setRating(int newRating) {
		/*
		 * The method takes an int value for newRating and compares it 
		 * to rating. If the values are not already equal and within the 1 to 5 range,
		 * the newRating value is assigned to rating as the new value and the method returns true.
		 * If the conditions are not met, the rating value remains the same and
		 * the method returns false.
		 */
		if(newRating != rating && (newRating>=1 && newRating<=5)) {
			this.rating = newRating;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean equals(Object o) {
		// Checks if the object passed is equal to the another indicated current Photo object (object1.equals(o)).
		
		if(o == null) {
			// Checks if value of o is a null value, if so, false is returned.
			return false;
		}
		
		if(o instanceof Photo) {
			
			Photo p = (Photo) o; // Casts o as a Photo object in value p.
			
			if(this.caption == p.caption && this.filename == p.filename) {
				/*
				 *  If both the caption and filename strings of the current Photo object are 
				 *  equal to the values for the Photo Object o that is passed, both Photo Objects
				 *  are then the same, returning true.
				 *  If not equal, returns false.
				 */
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	public int hashCode() {
		return filename.hashCode();
	}
	
	public String toString() {
		// Returns the current field values in a string, pairing a string to the value as a label.
		return "Filename: " + filename + " Caption: " + caption + " Rating: " + rating;
	}
	
	public int compare(Photo p) {
		/*
		 * Uses the compareTo() method to return a negative number if 
		 * the first string is lexicographically greater than the second, and 
		 * a positive number if the opposite is true.
		 */
		
		if(dateTaken == (p.getDateTaken())) {
			return caption.compareTo(p.getCaption());
		} else {
			return dateTaken.compareTo(p.getDateTaken());
		}
	}
	
	public static void main(String[] args) {
		
		/*Photo post1 = new Photo("File", "Cap", 7);
		System.out.println(post1);
		post1.setRating(5);
		System.out.println(post1);
		
		System.out.println(""); //Space to view tests separately in the console.
		
		Photo post2 = new Photo("File2", "Cap2");
		System.out.println(post2);
		post2.setRating(4);
		System.out.println(post2);

		System.out.println(post2.equals(post1)); // Tests if post1 and post2 are equal, checking for equals to return false.
		
		System.out.println(""); //Space to view tests separately in the console.
		
		Photo post3 = new Photo("File", "Cap", 7);
		
		System.out.println(post3.equals(post1)); // Tests if post3 and post1 are equal, checking for equals to return true.
		*/
	}

	@Override
	public int compareTo(Photo p) {
		// TODO Auto-generated method stub
		if(dateTaken.compareTo(p.getDateTaken()) == 0) {
			return caption.compareTo(p.getCaption());
		}
		
		return dateTaken.compareTo(p.getDateTaken());
	}

}
