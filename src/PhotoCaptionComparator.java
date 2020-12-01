import java.util.Comparator;

public class PhotoCaptionComparator implements Comparator<Photo> {
	public int compare(Photo a, Photo b) {
		/*
		 * First checks if the captions of the Photos are equal, if so returns the comparison of the ratings.
		 * If not equal, returns the comparison of the two captions.
		 */
		if(a.getCaption().compareTo(b.getCaption()) == 0) {
			// if the compareTo method returns 0 the two strings are equal, if captions are equal, the rating comparison is returned.
			return b.getRating() - a.getRating();
		}
		else {
			/* if the captions are not equal, uses compareTo() to return negative number
			 * if the a caption is lexicographically greater than the b string, and positive if the opposite
			 * is true.
			 */
			
			return a.getCaption().compareTo(b.getCaption());
		}
	}

}
