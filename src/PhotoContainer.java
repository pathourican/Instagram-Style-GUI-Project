import java.util.ArrayList;

/*
 * Patrick Hourican
 * pjh4as
 * CS 2110 - HW 3
 */

abstract class PhotoContainer {
	protected static String name;
	protected ArrayList<Photo> photos;
	
	public PhotoContainer(String name) {
		// Constructor initializes the fields with values given as parameters.
		this.name = name;
		photos = new ArrayList<Photo>();
	}

	public String getName() {
		// Retrieves and returns name value.
		return name;
	}

	public void setName(String newName1) {
		// Sets the name field equal to the newName1 parameter.
		name = newName1;
	}

	public ArrayList<Photo> getPhotos() {
		// Retrieves and returns HashSet photos.
		return photos;
	}

	public boolean addPhoto(Photo p) {

		// Checks if the photo exists in the list of photos, if not then it adds it to photos.

		if(p == null) {
			// If p value is null, or blank, the method returns false.
			return false;
		}
		else {
			if(photos.contains(p)) {
				// If photos has the photo p in it, nothing is added to photos and the boolean false is returned.
				return false;
			}
			else {
				// If p is not in photos, p is added to photos and true is returned.
				photos.add(p);
				return true;
			}
		}
	}

	public boolean hasPhoto(Photo p) {
		// If p is in photos, boolean value true is returned, if not, boolean value false is returned.
		if(photos.contains(p)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean removePhoto(Photo p) {
		/*
		 *  If p is in the Album, it is removed and true is returned.
		 *  If p is not in the Album, nothing is removed and false is returned.
		 */

		if(photos.contains(p)) {
			photos.remove(p);
			return true;
		}
		else {
			return false;
		}
	}

	public int numPhotos() {
		// Uses the size() operation to find the amount of items in the HashSet photos, and returns the value.
		return photos.size();
	}

	public boolean equals(Object o) {
		if(o == null) {
			// If the given Object o is a null value, boolean value false is returned.
			return false;
		}

		if(o instanceof Album) {
			Album a = (Album) o; // Casts o as a Album object as a.

			if(this.name == a.name) {
				/*
				 *  If both the string name of the current Album object is 
				 *  equal to the name of the Album Object o that is passed, both Album Objects
				 *  then have the same name, returning true.
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

	public String toString() {
		// Returns the current field values in a string, pairing a string to the value as a label.
		return "Name: " + name + " Photo Album: " + photos;
	}

	public int hashCode() {
		// Returns the hashcode number representation of the String.
		return name.hashCode();
	}
	
	
	
	
	// Library
	
	
	
	
	public ArrayList<Photo> getPhotos(int rating) {

		/*
		 * Checks if a photo is in range of 1 and 5 inclusive, then adds the photo to
		 * the list getPhoto if the rating is greater than or equal to the given rating param.
		 */

		ArrayList<Photo> getPhoto = new ArrayList<Photo>(); // New ArrayList is initialized to add photo objects to.

		for(int i = 0; i< photos.size(); i++) {
			// loop iterates over photos, each photo object in photos is run in the if statements.

			if(photos.get(i).getRating() < 1 || photos.get(i).getRating() > 5) {
				// returns null if the rating is greater than 5 or less than 1 (invalid format).
				return null;
			}

			if(photos.get(i).getRating() >= rating) {
				// If the photo rating is greater than or equal to the rating parameter.
				getPhoto.add(photos.get(i));
			}
		}

		return getPhoto; // returns the ArrayList of photos that meet the conditional.
	}
	
	public ArrayList<Photo> getPhotosInYear(int year) {

		/*
		 * Checks if the photo is a valid year through getYear() return value,
		 * then adds the photo to the list photoInYear if the photo was posted in the 
		 * same year as the given year param.
		 */

		if(year < 0) {
			return null;
		}
		
		ArrayList<Photo> photoInYear = new ArrayList<Photo>(); // Initializes a new ArrayList to add the valid photos to from the photos feed.
		
		for(int i = 0; i< photos.size(); i++) {
			// For loop is used to access each photo in the photos feed (ArrayList photos).

			if(DateLibrary.getYear(photos.get(i).getDateTaken()) == year) {
				// If the year the photo was posted is equal to the given year parameter, the photo is added to the ArrayList photoInYear.
				photoInYear.add(photos.get(i));
			}
		}

		return photoInYear; // ArrayList of photos from the photos feed that match the given year is returned.
	}
	
	public ArrayList<Photo> getPhotosInMonth(int month, int year) {

		/*
		 * Checks if the photo is a valid year through getYear() and getMonth() return values,
		 * then adds the photo to the list photoInMonth if the photo was posted in the 
		 * same month year as the given month and year params.
		 */
		
		
		if(month <1 && month >12) {
			return null;
		}

		if(year < 0001 && year > 9999) {
			return null;
		}
		
		ArrayList<Photo> photoInMonth = new ArrayList<Photo>(); // Initializes a new ArrayList to add the valid photos to from the photos feed.

		for(int i = 0; i< photos.size(); i++) {
			// For loop is used to access each photo in the photos feed (ArrayList photos).
			if(DateLibrary.getYear(photos.get(i).getDateTaken()) == -1) {
				/*
				 *  If either the Year or the Month of the photo object are invalid, indicated by the getMonth() or getYear() 
				 *  methods of the DateLibrary class with a return value of -1, null is returned.
				 */
				return null;
			}

			if(DateLibrary.getMonth(photos.get(i).getDateTaken()) == -1) {
				/*
				 *  If either the Year or the Month of the photo object are invalid, indicated by the getMonth() or getYear() 
				 *  methods of the DateLibrary class with a return value of -1, null is returned.
				 */
				return null;
			}

			if(DateLibrary.getYear(photos.get(i).getDateTaken()) == year && DateLibrary.getMonth(photos.get(i).getDateTaken()) == month) {
				/*
				 * If either the Year or the Month of the photo object are equal to the given month and year parameters, indicated by the getMonth() or getYear() 
				 *  methods of the DateLibrary class, the date the photo was taken is added to the ArrayList photoInMonth.
				 */
				photoInMonth.add(photos.get(i));
			}
		}

		return photoInMonth; // ArrayList of photos from the photos feed that match the date indicated is returned.
	}

	public ArrayList<Photo> getPhotosBetween(String beginDate, String endDate) {

		/*
		 * First checks if the beginDate and endDate are valid (if the beginDate is before the endDate),
		 * then checks if the date of the photo is between the beginDate and endDate, using getDay(), getYear() and getMonth().
		 */

		ArrayList<Photo> photosBetween = new ArrayList<Photo>();

		if(!DateLibrary.isValidDate(beginDate)) {
			return null;
		}
		
		if(!DateLibrary.isValidDate(endDate)) {
			return null;
		}
		
		if(beginDate.compareTo(endDate) > 0) {
			return null;
		}
		
		for(int i = 0; i<photos.size();i++) {
			
			if((beginDate.compareTo(photos.get(i).getDateTaken()) < 0) && (photos.get(i).getDateTaken().compareTo(endDate) < 0)) {
				photosBetween.add(photos.get(i));
			}
		}
		
		return photosBetween;
	}
	
}
