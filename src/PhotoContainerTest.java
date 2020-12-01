import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PhotoContainerTest {

	@Test
	public void removePhotoTest() {

		Library l = new Library("Lib", 01);
		
		Photo p1 = new Photo("File", "Cap", "2020-01-01", 5);
		Photo p2 = new Photo("File", "Cap", "2020-01-01", 5);
		Photo p3 = new Photo("File", "Cap", "2020-01-01", 5);
		Photo p4 = new Photo("File", "Cap", "2020-01-01", 5);
		
		
		l.addPhoto(p1);
		l.addPhoto(p2);
		l.addPhoto(p3);
		
		// Expected
		ArrayList<Photo> removePhotoE = new ArrayList<Photo>();
		
		removePhotoE.add(p1);
		removePhotoE.add(p2);
		
		// Test 1
		
		assertTrue(l.removePhoto(p1));
		
		// Test 2
		
		assertFalse(l.removePhoto(p4));
	}
	
	@Test
	public void compareToTest() {
		Photo p1 = new Photo("File", "Cap", "2020-01-01", 5);
		Photo p2 = new Photo("File", "Cap", "2020-01-01", 5);
		Photo p3 = new Photo("File", "Cap", "2020-01-02", 5);
		
		// Expected
		
		int i = 0;
		int a = -1;
		
		// Test 1
		
		assertEquals(i, p2.compareTo(p1));
		
		// Test 2
		
		assertEquals(a, p1.compareTo(p3));
	}
	
	@Test
	public void compareTest() {
		
		// compare() in PhotoRatingComparator
		
		Photo p1 = new Photo("File", "Cap", "2020-01-01", 5);
		Photo p2 = new Photo("File", "Cap2", "2020-01-01", 6);
		Photo p3 = new Photo("File", "Cap", "2020-01-02", 5);
		Photo p4 = new Photo("File", "Cap", "2020-01-01", 5);
		
		// Expected
		int r = -1;
		int re = 1;
		
		// Test 1
		
		assertEquals(r, p1.compare(p2));
		
		// Test 2
		
		assertEquals(re, p3.compare(p4));
		
		
		// compare() in PhotoCaptionComparator
		
		Photo p5 = new Photo("File", "Cap", "2020-01-01", 5);
		Photo p6 = new Photo("File", "Cap2", "2020-01-01", 6);
		Photo p7 = new Photo("File", "Cap3", "2020-01-02", 5);
		Photo p8 = new Photo("File", "Cap4", "2020-01-01", 5);
		
		// Expected 
		int c = -1;
		int ce = 1;
		
		// Test 1
		
		assertEquals(c, p5.compare(p6));
		
		// Test 2
		
		assertEquals(ce, p7.compare(p8));
	}

}
