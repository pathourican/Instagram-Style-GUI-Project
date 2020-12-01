import java.util.Comparator;

public class PhotoRatingComparator implements Comparator<Photo> {
	public int compare(Photo a, Photo b) {
		/*
		 * Checks if the ratings are equal, if so returns the comparison of the captions.
		 * If not equal, returns the comparison of the ratings.
		 */
		if(a.getRating() == b.getRating()) {
			// if the ratings are equal the caption comparison is returned.
			return a.getCaption().compareTo(b.getCaption());
		}
		else {
			// return the comparison in the rating.
			return b.getRating() - a.getRating();
		}
	}
}

