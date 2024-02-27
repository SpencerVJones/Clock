import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.Assert.*;

public class MyFrameTest {

    private MyFrame frame;

    @Before
    public void setUp() {
        frame = new MyFrame();
        frame.setVisible(false); // Prevents GUI from showing during tests
    }

    @Test
    public void testFrameInitialization() {
        assertEquals("Clock", frame.getTitle());
        assertEquals(800, frame.getWidth());
        assertEquals(400, frame.getHeight());
        assertTrue(frame.getLayout() instanceof FlowLayout);
        assertEquals(Color.LIGHT_GRAY, frame.getContentPane().getBackground());
        assertEquals(3, frame.getContentPane().getComponentCount());
        assertTrue(frame.getContentPane().getComponent(0) instanceof JLabel); // dayOfWeekLabel
        assertTrue(frame.getContentPane().getComponent(1) instanceof JLabel); // currentTimeLabel
        assertTrue(frame.getContentPane().getComponent(2) instanceof JLabel); // dateLabel
    }

    @Test
    public void testMenuCustomizations() {
        // Changing background color
        JMenuItem backgroundColorItem = frame.BackgroundColorItem;
        simulateAction(backgroundColorItem);
        assertEquals(Color.LIGHT_GRAY, frame.getContentPane().getBackground());

        // Changing text color
        JMenuItem timeTextColorItem = frame.timeTextColorItem;
        JMenuItem dayTextColorItem = frame.dayTextColorItem;
        JMenuItem dateTextColorItem = frame.dateTextColorItem;
        simulateAction(timeTextColorItem);
        simulateAction(dayTextColorItem);
        simulateAction(dateTextColorItem);
        assertEquals(Color.BLACK, frame.currentTimeLabel.getForeground());
        assertEquals(Color.BLACK, frame.dayOfWeekLabel.getForeground());
        assertEquals(Color.BLACK, frame.dateLabel.getForeground());

        // Toggling bold and italic styles
        JMenuItem timeTextBoldItem = frame.timeTextBoldItem;
        JMenuItem dayTextBoldItem = frame.dayTextBoldItem;
        JMenuItem dateTextBoldItem = frame.dateTextBoldItem;
        JMenuItem timeTextItalic = frame.timeTextItalic;
        JMenuItem dayTextItalic = frame.dayTextItalic;
        JMenuItem dateTextItalic = frame.dateTextItalic;
        simulateAction(timeTextBoldItem);
        simulateAction(dayTextBoldItem);
        simulateAction(dateTextBoldItem);
        simulateAction(timeTextItalic);
        simulateAction(dayTextItalic);
        simulateAction(dateTextItalic);
        assertTrue(frame.currentTimeLabel.getFont().isBold());
        assertTrue(frame.dayOfWeekLabel.getFont().isBold());
        assertTrue(frame.dateLabel.getFont().isBold());
        assertTrue(frame.currentTimeLabel.getFont().isItalic());
        assertTrue(frame.dayOfWeekLabel.getFont().isItalic());
        assertTrue(frame.dateLabel.getFont().isItalic());

        // Changing font family
        JComboBox<String> timeFontBox = frame.timeFontBox;
        JComboBox<String> dayFontBox = frame.dayFontBox;
        JComboBox<String> dateFontBox = frame.dateFontBox;
        timeFontBox.setSelectedItem("Arial");
        dayFontBox.setSelectedItem("Verdana");
        dateFontBox.setSelectedItem("Courier New");
        simulateAction(timeFontBox);
        simulateAction(dayFontBox);
        simulateAction(dateFontBox);
        assertEquals("Arial", frame.currentTimeLabel.getFont().getFamily());
        assertEquals("Verdana", frame.dayOfWeekLabel.getFont().getFamily());
        assertEquals("Courier New", frame.dateLabel.getFont().getFamily());
    }

    @Test
    public void testTimeUpdates() {
        String initialTime = frame.currentTime;
        String initialDay = frame.dayOfWeek;
        String initialDate = frame.date;

        // Simulate time passing
        frame.setTime();

        assertNotEquals(initialTime, frame.currentTime);
        assertNotEquals(initialDay, frame.dayOfWeek);
        assertNotEquals(initialDate, frame.date);
    }

    @Test
    public void testFontAndSizeCustomizations() {
        JSpinner timeTextSpinner = frame.timeTextSpinner;
        JSpinner dayTextSpinner = frame.dayTextSpinner;
        JSpinner dateTextSpinner = frame.dateTextSpinner;
        timeTextSpinner.setValue(20);
        dayTextSpinner.setValue(20);
        dateTextSpinner.setValue(20);
        simulateAction(timeTextSpinner);
        simulateAction(dayTextSpinner);
        simulateAction(dateTextSpinner);
        assertEquals(20, frame.currentTimeLabel.getFont().getSize());
        assertEquals(20, frame.dayOfWeekLabel.getFont().getSize());
        assertEquals(20, frame.dateLabel.getFont().getSize());
    }

    private void simulateAction(AbstractButton component) {
        for (ActionListener listener : component.getActionListeners()) {
            listener.actionPerformed(new ActionEvent(component, ActionEvent.ACTION_PERFORMED, ""));
        }
    }

    private void simulateAction(JComboBox<String> comboBox) {
        for (ActionListener listener : comboBox.getActionListeners()) {
            listener.actionPerformed(new ActionEvent(comboBox, ActionEvent.ACTION_PERFORMED, ""));
        }
    }

    private void simulateAction(JSpinner spinner) {
        for (ChangeListener listener : spinner.getChangeListeners()) {
            listener.stateChanged(null);
        }
    }
}