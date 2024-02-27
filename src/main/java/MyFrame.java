import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MyFrame extends JFrame implements ActionListener {

    Calendar calendar;

    SimpleDateFormat currentTimeFormat;
    SimpleDateFormat dayOfWeekFormat;
    SimpleDateFormat dateFormat;

    JLabel currentTimeLabel;
    JLabel dayOfWeekLabel;
    JLabel dateLabel;


    JMenuBar menuBar;

    JMenu TimeCustomizationsMenu;
    JMenu dayCustomizationsMenu;
    JMenu dateCustomizationsMenu;

    JMenuItem BackgroundColorItem;
    JMenuItem timeTextColorItem;
    JMenuItem timeTextBoldItem;
    JMenuItem timeTextItalic;
    JSpinner timeTextSpinner;
    JComboBox timeFontBox;
    JLabel timeSizeLabel;
    JPanel timeSizePanel;
    JLabel timeFontLabel;
    JPanel timeFontPanel;

    JMenuItem dayTextColorItem;
    JMenuItem dayTextBoldItem;
    JMenuItem dayTextItalic;
    JMenuItem dayTextUppercase;
    JMenuItem dayTextLowercase;
    JSpinner dayTextSpinner;
    JComboBox dayFontBox;
    JLabel daySizeLabel;
    JPanel daySizePanel;
    JLabel dayFontLabel;
    JPanel dayFontPanel;

    JMenuItem dateTextColorItem;
    JMenuItem dateTextBoldItem;
    JMenuItem dateTextItalic;
    JMenuItem dateTextUppercase;
    JMenuItem dateTextLowercase;
    JSpinner dateTextSpinner;
    JComboBox dateFontBox;
    JLabel dateSizeLabel;
    JPanel dateSizePanel;
    JLabel dateFontLabel;
    JPanel dateFontPanel;

    String currentTime;
    String dayOfWeek;
    String date;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clock");
        this.setSize(800,400);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.LIGHT_GRAY);


        // Current Time
        currentTimeFormat = new SimpleDateFormat("hh: mm: ss a");

        currentTimeLabel = new JLabel();
        currentTimeLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 100));
        currentTimeLabel.setForeground(Color.BLACK);
        currentTimeLabel.setBackground(getContentPane().getBackground());
        currentTimeLabel.setOpaque(true);

        currentTime = currentTimeFormat.format(Calendar.getInstance().getTime());
        currentTimeLabel.setText(currentTime);


        // Day of Week
        dayOfWeekFormat = new SimpleDateFormat("EEEE");

        dayOfWeekLabel = new JLabel();
        dayOfWeekLabel.setFont(new Font("Chalkboard", Font.PLAIN, 65));
        dayOfWeekLabel.setForeground(Color.BLACK);
        dayOfWeekLabel.setBackground(getContentPane().getBackground());
        dayOfWeekLabel.setOpaque(true);

        dayOfWeek = dayOfWeekFormat.format(Calendar.getInstance().getTime());
        dayOfWeekLabel.setText(dayOfWeek);


        // Date
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
        dateLabel = new JLabel();
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Chalkboard", Font.PLAIN, 55));
        dateLabel.setForeground(Color.BLACK);
        dateLabel.setBackground(getContentPane().getBackground());
        dateLabel.setOpaque(true);

        date = dateFormat.format(Calendar.getInstance().getTime());
        dateLabel.setText(date);


        // Menu Items

        // Time
        BackgroundColorItem = new JMenuItem("Background Color");
        timeTextColorItem = new JMenuItem("Text Color");

        timeTextBoldItem = new JMenuItem("Bold");
        timeTextItalic = new JMenuItem("Italic");


        // JSpinner
        timeTextSpinner = new JSpinner();
        timeTextSpinner.setValue(100);
        timeTextSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentTimeLabel.setFont(new Font(currentTimeLabel.getFont().getFamily(),Font.PLAIN,(int) timeTextSpinner.getValue()));
            }
        });

        // ComboBox
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        timeFontBox = new JComboBox<>(fonts);
        timeFontBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFont = (String) timeFontBox.getSelectedItem();
                Font currentFont = currentTimeLabel.getFont();
                int size = currentFont.getSize();
                int style = currentFont.getStyle();
                currentTimeLabel.setFont(new Font(selectedFont, style, size));
            }
        });

        timeFontLabel = new JLabel("Font");

        // JPanel
        timeFontPanel = new JPanel(new FlowLayout());
        timeFontPanel.add(timeFontLabel);
        timeFontPanel.add(timeFontBox);

        timeSizeLabel = new JLabel("Size");

        // JPanel
        timeSizePanel = new JPanel(new FlowLayout());
        timeSizePanel.add(timeSizeLabel);
        timeSizePanel.add(timeTextSpinner);


        // Day
        dayTextColorItem = new JMenuItem("Text Color");
        dayTextBoldItem = new JMenuItem("Bold");
        dayTextItalic = new JMenuItem("Italic");
        dayTextUppercase = new JMenuItem("Uppercase");
        dayTextLowercase = new JMenuItem("Lowercase");

        // JSpinner
        dayTextSpinner = new JSpinner();
        dayTextSpinner.setValue(65);
        dayTextSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                dayOfWeekLabel.setFont(new Font(dayOfWeekLabel.getFont().getFamily(),Font.PLAIN,(int) dayTextSpinner.getValue()));
            }
        });

        // ComboBox
        dayFontBox = new JComboBox<>(fonts);
        dayFontBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFont = (String) dayFontBox.getSelectedItem();
                Font currentFont = dayOfWeekLabel.getFont();
                int size = currentFont.getSize();
                int style = currentFont.getStyle();
                dayOfWeekLabel.setFont(new Font(selectedFont, style, size));
            }
        });

        dayFontLabel = new JLabel("Font");

        // JPanel
        dayFontPanel = new JPanel(new FlowLayout());
        dayFontPanel.add(dayFontLabel);
        dayFontPanel.add(dayFontBox);

        daySizeLabel = new JLabel("Size");

        // JPanel
        daySizePanel = new JPanel(new FlowLayout());
        daySizePanel.add(daySizeLabel);
        daySizePanel.add(dayTextSpinner);

        // Date
        dateTextColorItem = new JMenuItem("Text Color");

        dateTextBoldItem = new JMenuItem("Bold");
        dateTextItalic = new JMenuItem("Italic");
        dateTextUppercase = new JMenuItem("Uppercase");
        dateTextLowercase = new JMenuItem("Lowercase");;

        // JSpinner
        dateTextSpinner = new JSpinner();
        dateTextSpinner.setValue(65);
        dateTextSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                dateLabel.setFont(new Font(dateFontLabel.getFont().getFamily(),Font.PLAIN,(int) dateTextSpinner.getValue()));
            }
        });

        dateSizeLabel = new JLabel("Size");

        // JPanel
        dateSizePanel = new JPanel(new FlowLayout());
        dateSizePanel.add(dateSizeLabel);
        dateSizePanel.add(dateTextSpinner);

        // ComboBox
        dateFontBox = new JComboBox<>(fonts);
        dateFontBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFont = (String) dateFontBox.getSelectedItem();
                Font currentFont = dateLabel.getFont();
                int size = currentFont.getSize();
                int style = currentFont.getStyle();
                dateLabel.setFont(new Font(selectedFont, style, size));
            }
        });

        dateFontLabel = new JLabel("Font");

        // JPanel
        dateFontPanel = new JPanel(new FlowLayout());
        dateFontPanel.add(dateFontLabel);
        dateFontPanel.add(dateFontBox);



        // Menus
        TimeCustomizationsMenu = new JMenu("Time Customizations");
        TimeCustomizationsMenu.add(BackgroundColorItem);
        TimeCustomizationsMenu.add(timeTextColorItem);
        TimeCustomizationsMenu.add(timeTextBoldItem);
        TimeCustomizationsMenu.add(timeTextItalic);
        //TimeCustomizationsMenu.add(timeFontPanel);
        TimeCustomizationsMenu.add(timeSizePanel);

        BackgroundColorItem.addActionListener(this);
        timeTextColorItem.addActionListener(this);

        timeTextBoldItem.addActionListener(this);
        timeTextItalic.addActionListener(this);


        dayCustomizationsMenu = new JMenu("Day Customizations");
        dayCustomizationsMenu.add(dayTextColorItem);
        dayCustomizationsMenu.add(dayTextBoldItem);
        dayCustomizationsMenu.add(dayTextItalic);
        dayCustomizationsMenu.add(dayTextUppercase);
        dayCustomizationsMenu.add(dayTextLowercase);
        //dayCustomizationsMenu.add(dayFontPanel);
        dayCustomizationsMenu.add(daySizePanel);

        dayTextColorItem.addActionListener(this);
        dayTextBoldItem.addActionListener(this);
        dayTextItalic.addActionListener(this);
        dayTextUppercase.addActionListener(this);
        dayTextLowercase.addActionListener(this);


        dateCustomizationsMenu = new JMenu("Date Customizations");
        dateCustomizationsMenu.add(dateTextColorItem);
        dateCustomizationsMenu.add(dateTextBoldItem);
        dateCustomizationsMenu.add(dateTextItalic);
        dateCustomizationsMenu.add(dateTextUppercase);
        dateCustomizationsMenu.add(dateTextLowercase);
        //dateCustomizationsMenu.add(dateFontPanel);
        dateCustomizationsMenu.add(dateSizePanel);

        dateTextColorItem.addActionListener(this);
        dateTextBoldItem.addActionListener(this);
        dateTextItalic.addActionListener(this);
        dateTextUppercase.addActionListener(this);
        dateTextLowercase.addActionListener(this);

        // Menu Bars
        menuBar = new JMenuBar();
        menuBar.add(TimeCustomizationsMenu);
        menuBar.add(dayCustomizationsMenu);
        menuBar.add(dateCustomizationsMenu);


        this.setJMenuBar(menuBar);
        this.add(dayOfWeekLabel);
        this.add(currentTimeLabel);
        this.add(dateLabel);
        //this.getContentPane().setBackground(Color.BLACK);

        this.setVisible(true);

        // Calling Method setTime
        setTime();

    }
    // Method setTime
    public void setTime() {
        while(true) {
            currentTime = currentTimeFormat.format(Calendar.getInstance().getTime());
            currentTimeLabel.setText(currentTime);

            dayOfWeek = dayOfWeekFormat.format(Calendar.getInstance().getTime());
            dayOfWeekLabel.setText(dayOfWeek);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }	// Will update every second
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        // Background Color Menu Item under Time Customizations Menu
        if (e.getSource()==BackgroundColorItem) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = colorChooser.showDialog(null, "Color", Color.LIGHT_GRAY);
            this.getContentPane().setBackground(color);
            currentTimeLabel.setBackground(color);
            dayOfWeekLabel.setBackground(color);
            dateLabel.setBackground(color);
        }


        // Time Font Combo Box under Time Customizations Menu
        if(e.getSource()==timeFontBox) {
            currentTimeLabel.setFont(new Font((String)timeFontBox.getSelectedItem(), Font.PLAIN, currentTimeLabel.getFont().getSize()));			}

        // Day Font Combo Box under Day Customizations Menu
        if(e.getSource()==dayFontBox) {
            dayOfWeekLabel.setFont(new Font((String)dayFontBox.getSelectedItem(),Font.PLAIN,dayOfWeekLabel.getFont().getSize()));
        }

        // Date Font Combo Box under Date Customizations Menu
        if(e.getSource()==dateFontBox) {
            dateLabel.setFont(new Font((String)dateFontBox.getSelectedItem(),Font.PLAIN,dateLabel.getFont().getSize()));
        }


        // Time Text Color Menu Item under Time Customizations Menu
        if (e.getSource()==timeTextColorItem) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = colorChooser.showDialog(null,"Color",Color.BLACK);
            currentTimeLabel.setForeground(color);
        }

        // Day Text Color Menu Item under Day Customizations Menu
        if (e.getSource()==dayTextColorItem) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = colorChooser.showDialog(null,"Color",Color.BLACK);
            dayOfWeekLabel.setForeground(color);
        }

        // Date Text Color Menu Item under Date Customizations Menu
        if (e.getSource()==dateTextColorItem) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = colorChooser.showDialog(null,"Color",Color.BLACK);
            dateLabel.setForeground(color);
        }


        // Time Text Bold Menu Item under Time Customizations Menu
        if (e.getSource()==timeTextBoldItem) {
            Font currentFont = currentTimeLabel.getFont();
            int style = currentFont.getStyle();

            if ((style & Font.BOLD) == 0) {
                currentTimeLabel.setFont(currentFont.deriveFont(style | Font.BOLD));
            } else {
                currentTimeLabel.setFont(currentFont.deriveFont(style & ~Font.BOLD));
            }
        }

        // Day Text Bold Menu Item under Day Customizations Menu
        if (e.getSource()==dayTextBoldItem) {
            Font currentFont = dayOfWeekLabel.getFont();
            int style = currentFont.getStyle();

            if ((style & Font.BOLD) == 0) {
                dayOfWeekLabel.setFont(currentFont.deriveFont(style | Font.BOLD));
            } else {
                dayOfWeekLabel.setFont(currentFont.deriveFont(style & ~Font.BOLD));
            }
        }

        // Date Text Bold Menu Item under Date Customizations Menu

        if (e.getSource()==dateTextBoldItem) {
            Font currentFont = dateLabel.getFont();
            int style = currentFont.getStyle();

            if ((style & Font.BOLD) == 0) {
                dateLabel.setFont(currentFont.deriveFont(style | Font.BOLD));
            } else {
                dateLabel.setFont(currentFont.deriveFont(style & ~Font.BOLD));
            }
        }

        // Time Text Italic Menu Item under Time Customizations Menu
        if(e.getSource()==timeTextItalic) {
            Font currentFont = currentTimeLabel.getFont();
            int style = currentFont.getStyle();

            if ((style & Font.BOLD) == 0) {
                currentTimeLabel.setFont(currentFont.deriveFont(style | Font.ITALIC));
            } else {
                currentTimeLabel.setFont(currentFont.deriveFont(style & ~Font.ITALIC));
            }
        }

        // Day Text Italic Menu Item under Day Customizations Menu
        if(e.getSource()==dayTextItalic) {
            Font currentFont = dayOfWeekLabel.getFont();
            int style = currentFont.getStyle();

            if ((style & Font.BOLD) == 0) {
                dayOfWeekLabel.setFont(currentFont.deriveFont(style | Font.ITALIC));
            } else {
                dayOfWeekLabel.setFont(currentFont.deriveFont(style & ~Font.ITALIC));
            }
        }

        // Date Text Italic Menu Item under Date Customizations Menu
        if(e.getSource()==dateTextItalic) {
            Font currentFont = dateLabel.getFont();
            int style = currentFont.getStyle();

            if ((style & Font.BOLD) == 0) {
                dateLabel.setFont(currentFont.deriveFont(style | Font.ITALIC));
            } else {
                dateLabel.setFont(currentFont.deriveFont(style & ~Font.ITALIC));
            }
        }


        // Day Text Uppercase Menu Item under Day Customizations Menu
        if(e.getSource()==dayTextUppercase) {
            String currentText = dayOfWeekLabel.getText();
            String uppercasedText = currentText.toUpperCase();
            dayOfWeekLabel.setText(uppercasedText);

        }

        // Date Text Uppercase Menu Item under Date Customizations Menu
        if(e.getSource()==dateTextUppercase) {
            String currentText = dateLabel.getText();
            String uppercasedText = currentText.toUpperCase();
            dateLabel.setText(uppercasedText);

        }


        // Day Text Lowercase Menu Item under Day Customizations Menu
        if(e.getSource()==dayTextLowercase) {
            String currentText = dayOfWeekLabel.getText();
            String lowercasedText = currentText.toLowerCase();
            dayOfWeekLabel.setText(lowercasedText);

        }

        // Date Text Lowercase Menu Item under Date Customizations Menu
        if(e.getSource()==dateTextLowercase) {
            String currentText = dateLabel.getText();
            String lowercasedText = currentText.toLowerCase();
            dateLabel.setText(lowercasedText);

        }
    }

}