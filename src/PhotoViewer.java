/*
 * Homework 4
 * Patrick Hourican, pjh4as
 * 
 * Sources: Professor McBurney Office Hours, Big Java Book (Chapter 20), Class Slides, GUI Lab, 
 * Java API awt and swing documentation.
 * .
 */

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class PhotoViewer extends JFrame {
	
	/*
	 * All GUI elements are initialized as instance
	 * variables with their J type.
	 */
	
	private PhotoContainer imageLibrary;
	private JLabel imagePresented;

	private JPanel ratingPanel;
	private JButton nextButton;
	private JPanel nextPanel;
	private JButton prevButton;
	private JPanel prevPanel;
	private ActionListener nextButtonListener;
	private ActionListener prevButtonListener;

	private JPanel imagePanel;
	
	private JLabel caption;
	private JLabel title;
	
	private JRadioButton rating1;
	private JRadioButton rating2;
	private JRadioButton rating3;
	private JRadioButton rating4;
	private JRadioButton rating5;
	private ButtonGroup ratingGroup;
	private ActionListener rating1Listener;
	private ActionListener rating2Listener;
	private ActionListener rating3Listener;
	private ActionListener rating4Listener;
	private ActionListener rating5Listener;
	
	private static int counter;

	// Frame size variables.
	private static final int frameWidth = 800;
	private static final int frameHeight = 800;

	public PhotoContainer getImageLibrary() {
		// Retrieves and returns the imageLibrary from the indicated PhotoContainer object.
		return imageLibrary;
	}
	
	public boolean setImageLibrary(PhotoContainer lib) {
		/* 
		 * Sets the parameter equal to the PhotoContainer imageLibrary.
		 * 
		 * @param lib - a PhotoContainer or library (Library is a PhotoContainer as it extends it).
		 * @return - returns true, indicating that lib was set equal to imageLibrary successfully.
		 */
		
		this.imageLibrary = lib;
		return true;
	}

	public PhotoViewer() {
		/*
		 * Constructor, takes no parameters.
		 * 
		 * Sets the value of a counter to 0, to keep track of the index of the 
		 * current photo in the array of photos in the PhotoContainer imageLibrary.
		 * 
		 * Sets the dimensions of the JFrame.
		 */
		
		counter = 0;
		
		setSize(frameWidth, frameHeight);
	}

	class nextButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			/*
			 * ActionListener for the Next button, nextButton.
			 * 
			 * When the button is pressed the counter is incremented to match the photo 
			 * being set to the image panel by then calling the displayImage(counter) function.
			 */
			
			if(counter == 4) {
				/*
				 * if the value of counter is 4 (last index in list), it sets counter to 0 to 
				 * make the image displayed by displayImage(counter) be the first image (cycling around
				 * from last to first).
				 */
				counter = 0;
				displayImage(counter);
			}
			else {
				// increments the counter and displays the image through displayImage(counter) if the counter is not 4.
				counter++;
				displayImage(counter);
			}
		}
	}
	
	class prevButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			/*
			 * ActionListener for the Previous button, prevButton.
			 * 
			 * When the button is pressed the counter is decremented to match the photo 
			 * being set to the image panel by then calling the displayImage(counter) function.
			 */
			
			if(counter == 0) {
				/*
				 * if the value of counter is 0 (first index in list), it sets counter to 4 to 
				 * make the image displayed by displayImage(counter) be the last image (cycling around
				 * from first to last).
				 */
				counter = 4;
				displayImage(counter);
			}
			else {
				// decrements the counter and displays the image through displayImage(counter) if the counter is not 0.
				counter--;
				displayImage(counter);
			}
		}
	}
	
	class rating1Listener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			/*
			 * When rating1 button is pressed, the selection of the ratingGroup is cleared
			 * so the previous selection is erased. The rating1 button is then set be selected,
			 * making the button appear as selected.
			 * 
			 * The image in the array photos in imageLibrary is then set to the rating value 1 using
			 * setRating(int rating).
			 */

			ratingGroup.clearSelection();
			rating1.setSelected(true);

			imageLibrary.getPhotos().get(counter).setRating(1);
		}
	}

	class rating2Listener implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			/*
			 * When rating2 button is pressed, the selection of the ratingGroup is cleared
			 * so the previous selection is erased. The rating2 button is then set be selected,
			 * making the button appear as selected.
			 * 
			 * The image in the array photos in imageLibrary is then set to the rating value 2 using
			 * setRating(int rating).
			 */
			
			ratingGroup.clearSelection();
			rating2.setSelected(true);

			imageLibrary.getPhotos().get(counter).setRating(2);
		}
	}

	class rating3Listener implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			/*
			 * When rating3 button is pressed, the selection of the ratingGroup is cleared
			 * so the previous selection is erased. The rating3 button is then set be selected,
			 * making the button appear as selected.
			 * 
			 * The image in the array photos in imageLibrary is then set to the rating value 3 using
			 * setRating(int rating).
			 */
			
			ratingGroup.clearSelection();
			rating3.setSelected(true);

			imageLibrary.getPhotos().get(counter).setRating(3);
		}
	}

	class rating4Listener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			
			/*
			 * When rating4 button is pressed, the selection of the ratingGroup is cleared
			 * so the previous selection is erased. The rating4 button is then set be selected,
			 * making the button appear as selected.
			 * 
			 * The image in the array photos in imageLibrary is then set to the rating value 4 using
			 * setRating(int rating).
			 */
			
			ratingGroup.clearSelection();
			rating4.setSelected(true);

			imageLibrary.getPhotos().get(counter).setRating(4);
		}
	}

	class rating5Listener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			
			/*
			 * When rating5 button is pressed, the selection of the ratingGroup is cleared
			 * so the previous selection is erased. The rating5 button is then set be selected,
			 * making the button appear as selected.
			 * 
			 * The image in the array photos in imageLibrary is then set to the rating value 5 using
			 * setRating(int rating).
			 */

			ratingGroup.clearSelection();
			rating5.setSelected(true);

			imageLibrary.getPhotos().get(counter).setRating(5);
		}
	}

	private void displayImage(int i) {
		
		/*
		 * Displays the image that holds the index of the int parameter,
		 * which should be displayed in the imagePanel.
		 * 
		 * @param i - the value of the int counter should be taken in to display the image
		 * that is to be displayed in the index of the ArrayList in the PhotoContainer imageLibrary.
		 */
		
		Image img = imageLibrary.getPhotos().get(i).getImageData().getScaledInstance(400,500, Image.SCALE_SMOOTH); // an Image is set to the scaled version (fit to imagePanel size) of the image loaded into imageLibrary as img.
		
		ImageIcon icon = new ImageIcon(img); // ImageIcon icon is set equal to the scaled image to be displayed.
		imagePresented.setIcon(icon); // the JLabel that is to be displayed on the imagePanel has icon set to it, as icon.
		
		caption.setText(imageLibrary.getPhotos().get(counter).getCaption()); // sets the text of the caption for the current image based on the counter value, retrieving it from the stored image in imageLibrary.
		title.setText(imageLibrary.getPhotos().get(counter).getFilename().substring(7,15)); // // sets the text of the title for the current image based on the counter value, retrieving it from the stored image in imageLibrary.
		
		if(imageLibrary.getPhotos().get(counter).getRating() == 1) {
			// if the default rating of the image is 1, the rating1 button is set to selected.
			rating1.setSelected(true);
		}
		if(imageLibrary.getPhotos().get(counter).getRating() == 2) {
			// if the default rating of the image is 2, the rating2 button is set to selected.
			rating2.setSelected(true);
		}
		if(imageLibrary.getPhotos().get(counter).getRating() == 3) {
			// if the default rating of the image is 3, the rating3 button is set to selected.
			rating3.setSelected(true);
		}
		if(imageLibrary.getPhotos().get(counter).getRating() == 4) {
			// if the default rating of the image is 4, the rating4 button is set to selected.
			rating4.setSelected(true);
		}
		if(imageLibrary.getPhotos().get(counter).getRating() == 5) {
			// if the default rating of the image is 5, the rating5 button is set to selected.
			rating5.setSelected(true);
		}
	}
	
	private void createRatingButtons() {
		
		/*
		 *  Creates each rating button,
		 * 
		 *  First, setting each with a label of the associated value.
		 *  Second, creating the associated ActionListener to the rating button.
		 *  Third, adding the associated ActionListener to the rating button structure.
		 *  
		 *  Finally, creating a button group for the rating buttons, then adding each button to the group.
		 */

		rating1 = new JRadioButton("1");
		rating1Listener = new rating1Listener();
		rating1.addActionListener(rating1Listener);

		rating2 = new JRadioButton("2");
		rating2Listener = new rating2Listener();
		rating2.addActionListener(rating2Listener);

		rating3 = new JRadioButton("3");
		rating3Listener = new rating3Listener();
		rating3.addActionListener(rating3Listener);

		rating4 = new JRadioButton("4");
		rating4Listener = new rating4Listener();
		rating4.addActionListener(rating4Listener);

		rating5 = new JRadioButton("5");
		rating5Listener = new rating5Listener();
		rating5.addActionListener(rating5Listener);

		ratingGroup = new ButtonGroup();
		ratingGroup.add(rating1);
		ratingGroup.add(rating2);
		ratingGroup.add(rating3);
		ratingGroup.add(rating3);
		ratingGroup.add(rating4);
		ratingGroup.add(rating5);

	}

	private void createImagePanel() {
		
		/*
		 * Creates the panel for the image icon in the imagePresented label to be 
		 * displayed in.
		 */
		
		imagePanel = new JPanel();

		imagePresented = new JLabel();

		displayImage(counter); // Calls the displayImage(counter) function to load the image icon to the panel displayed.

		imagePanel.setSize(400,500); // sets the size if the JPanel imagePanel.
		imagePanel.setLocation(200,50); // sets the location of the panel on the frame.

		imagePanel.add(imagePresented); // adds the imagePresented label to the image panel.
		add(imagePanel); // adds the image panel to the frame.
	}

	private void createRatingPanel() {
		
		/*
		 *  Creates the rating panel as a grid layout, with
		 *  each rating radio button in it.
		 */
		
		createRatingButtons(); // creates the rating radio buttons.
		
		ratingPanel = new JPanel();
		
		ratingPanel.setLayout(new GridLayout(1,5)); // sets the grid layout to have the buttons across the screen horizontally.
		ratingPanel.setBorder(new TitledBorder(new EtchedBorder(), "Rating")); // creates a boarder for the panel and indicates the area as a rating area.
		
		// Each rating radio button is added to the rating panel.
		ratingPanel.add(rating1); 
		ratingPanel.add(rating2);
		ratingPanel.add(rating3);
		ratingPanel.add(rating4);
		ratingPanel.add(rating5);
		
		ratingPanel.setSize(725,100); // size of the panel is set.
		ratingPanel.setLocation(30,625); // location of panel on frame is set.
		
		add(ratingPanel); // panel added to the frame.
	}
	
	private void createNextAndPrevPanels() {
		
		/*
		 * Create the next and previous panels that hold the next and previous buttons.
		 * 
		 * Each button undergoes the same process.
		 * 
		 * The button is created with a label on it either "Next" or "Previous".
		 * The panel is created for each.
		 * The action listener is created for each button and then
		 * added to the corresponding button.
		 * The button is added to the panel.
		 * 
		 * The location on the frame is set.
		 * The size of the panel is set.
		 * 
		 * The panel is added to the Frame.
		 */
		
		nextButton = new JButton("Next");
		nextPanel = new JPanel();
		nextButtonListener = new nextButtonListener();
		nextButton.addActionListener(nextButtonListener);
		nextPanel.add(nextButton);
		
		nextPanel.setLocation(650,325);
		nextPanel.setSize(75,100);
		
		add(nextPanel);

		prevButton = new JButton("Previous");
		prevPanel = new JPanel();
		prevButtonListener = new prevButtonListener();
		prevButton.addActionListener(prevButtonListener);
		prevPanel.add(prevButton);
		
		prevPanel.setLocation(50,325);
		prevPanel.setSize(100,100);
		
		add(prevPanel);
	}
	
	private void createCaptionAndTitlePanel() {
		
		/*
		 * The panels for the caption and title are created.
		 * 
		 * The Label to go in each panel is created.
		 * The size is set.
		 * The location on the frame is set.
		 * Each are added to the frame.
		 */
		caption = new JLabel();
		caption.setLocation(380,560);
		caption.setSize(100,50);
		add(caption);
		
		title = new JLabel();
		title.setLocation(385,0);
		title.setSize(150,50);
		add(title);
	}
	
	private void createAndShowGUI() {
		
		/*
		 * Creates the GUI by calling each helper method created,
		 * creating and added all panels.
		 */
		
		this.setLayout(null); // the layout of the frame is set to null before the methods are called to allow for the changing of location and size.
		
		createCaptionAndTitlePanel();

		createNextAndPrevPanels();
		
		createRatingPanel();
		
		createImagePanel();
		
	}

	public static void main(String[] args) {
		PhotoViewer myViewer = new PhotoViewer();
		myViewer.setTitle("Photo Viewer");  
		myViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// the relative image directory.
		String imageDirectory = "images\\"; // for Windows

		Photo p1 = new Photo (imageDirectory + "img1.jpg","ZigZag Bridge", "2015-06-30", 2) ;
		p1.loadImageData(imageDirectory + "img1.jpg") ;

		Photo p2 = new Photo(imageDirectory + "img2.jpg","Island View",  "2016-01-26", 4);
		p2.loadImageData(imageDirectory + "img2.jpg");
		
		Photo p3 = new Photo(imageDirectory + "img3.jpg","Tall Trees", "2017-01-26", 3);
		p3.loadImageData(imageDirectory + "img3.jpg");

		Photo p4 = new Photo( imageDirectory + "img4.jpg","Made Friends", "2018-01-26", 5);
		p4.loadImageData(imageDirectory + ""
				+ "img4.jpg");

		Photo p5 = new Photo( imageDirectory + "img5.jpg", "Bryce Canyon", "2016-01-25", 3);
		p5.loadImageData(imageDirectory + "img5.jpg");
		
		myViewer.setImageLibrary(new Library("Test Library", 1));

		myViewer.getImageLibrary().addPhoto(p1);
		myViewer.getImageLibrary().addPhoto(p2);
		myViewer.getImageLibrary().addPhoto(p3);
		myViewer.getImageLibrary().addPhoto(p4);
		myViewer.getImageLibrary().addPhoto(p5);
		
		javax.swing.SwingUtilities.invokeLater(()->myViewer.createAndShowGUI()); // The createAndShowGUI() method is called once the photos are added to the container in the created PhotoViewer (myViewer).
		Collections.sort(myViewer.getImageLibrary().getPhotos()); // images (Photos) stored are correctly sorted by the date.
		myViewer.setVisible(true);
	}
}
