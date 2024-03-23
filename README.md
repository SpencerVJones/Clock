# Digital Clock GUI
A sleek and customizable Java Swing application designed to provide users with a stylish digital clock display. Beyond just telling time, ClockGUI offers an array of customization options, allowing users to tailor the appearance of the clock to their liking. With features like adjustable font styles, sizes, and colors, along with the ability to transform text case, this application ensures that your desktop clock not only keeps you punctual but also complements your personal aesthetic.


## Features
- Display of current time, day of the week, and date.
- Customizable appearance:
  - Background color
  - Text color
  - Font family
  - Font size
  - Text style (bold/italic)
  - Day and date text conversion between uppercase and lowercase.
  - Menu bar with options to customize time, day, and date.
  - Dynamic updating of time and date every second.
- Unit tests to ensure functionality and correctness.

## Usage
1. Clone the repository to your local machine.
2.  **Running the Application**:
   - Compile the Java files:
     ```
     javac Main.java MyFrame.java MyFrameTest.java
     ```
   - Run the Main class:
     ```
     java Main
     ```
      This will launch the clock GUI.
3. **Customizing the Clock**:
   - Use the menu bar at the top to access customization options for time, day, and date.
   - Customize features such as background color, text color, font family, font size, font style (bold/italic), and text case (uppercase/lowercase).
   - Select your preferences from the menu options to apply changes to the clock display.
4. **Playing with Features**:
   - Experiment with different font styles, sizes, and colors to personalize the clock according to your preferences.
   - Toggle between bold and italic styles for text.
   - Change the font family to see how it affects the appearance of the clock.
   - Adjust the font size to make the text larger or smaller.
5. **Exiting the Application**:
   - Close the clock window to exit the application.

## Testing
The project includes comprehensive unit tests to verify the functionality of the clock customization features and time updates.
1. **Test Setup**:
   - The unit tests are implemented using JUnit.
   - Each aspect of the clock's functionality, such as font customization and time updates, is tested individually.
2. **Running the Tests**:
   - Compile the test files:
     ```
     javac -cp .:junit-4.XX.jar MyFrameTest.java
     ```
   - Run the tests:
     ```
     java -cp .:junit-4.XX.jar:hamcrest-core-1.XX.jar org.junit.runner.JUnitCore MyFrameTest
     ```
       - Replace `XX` with the appropriate version numbers of JUnit and Hamcrest.
3. **Test Cases**:
   - Test cases cover scenarios such as:
     - Changing background color and verifying the color change.
     - Modifying text color and ensuring the color update.
     - Adjusting font size and confirming the size change.
     - Toggling between bold and italic styles for text.
     - Testing dynamic time updates to ensure accurate time display.
4. **Validation**:
   - Each test case validates specific features or behavior of the clock GUI.
   - Tests are designed to ensure that customization options work as expected and that the clock updates correctly over time.


## Technologies Used
- **Java**: The application is implemented in Java programming language.
- **Java Swing**: Used for creating the graphical user interface.
- **JUnit**: Utilized for unit testing to ensure the correctness of the application.
- **AWT (Abstract Window Toolkit)**: Used for basic windowing functions, graphics, and user interface components.
- **SimpleDateFormat**: Utilized for formatting date and time.
- **JMenuBar, JMenu, JMenuItem**: Components of Java Swing used for creating menus and menu items.
- **JLabel**: Used to display text and images.
- **JColorChooser**: Enables users to select colors.
- **JComboBox**: A component that combines a button or editable field and a drop-down list.
- **JSpinner**: Used for selecting numeric values.
- **Font**: Represents fonts, which are used to render text.
- **IDE:** IntelliJ IDEA Ultimate

## Contributing
Contributions are welcome! 

### You can contribute by:
-  Reporting bugs
-  Suggesting new features
-  Submitting pull requests to improve the codebase
