package ui.level2.factory;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * An abstract class representing the login user interface.  It extends {@link JFrame}
 * to provide a window and implements the {@link UI} interface for UI component
 * initialization.  This class provides a basic login form with username and
 * password fields and a login button.  Subclasses are expected to provide
 * specific frame initialization behavior.
 *
 * @author [Your Name Here]  (Replace with the actual author name)
 * @version 1.0
 * @since [Insert version here, e.g., "1.0"]
 */
public interface UI {

    /**
     * Initializes the login process.
     * This method calls {@link #initDefault()}, {@link #initPanel()},
     * and {@link #addButtonListener()} to set up the login UI.
     */
	
	public void initDefault();

    /**
     * Initializes default frame properties.
     * Sets the default close operation, centers the frame on the screen,
     * and calls the abstract {@link #initFrame()} method for further customization.
     */
	
	public JPanel initPanel();

    /**
     * Initializes the panel containing the login form elements.
     * Creates a JPanel with a GridLayout and adds labels, text fields,
     * and the login button.
     *
     * @return A JPanel containing the login form elements.
     */
	public void addButtonListener();
}
