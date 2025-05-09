package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JPanel mainPanel;

    public Home() {
        setTitle("Airline Reservation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Load background image
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        Image bg = bgIcon.getImage();
        JLabel background = new JLabel(new ImageIcon(bg));
        background.setLayout(new BorderLayout());
        setContentPane(background);

        // Header (title only, no icon)
        JPanel header = new JPanel();
        header.setBackground(new Color(0, 0, 0, 100));
        header.setPreferredSize(new Dimension(100, 90));
        header.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));

        JLabel title = new JLabel("Airline Reservation System");
        title.setFont(new Font("Segoe UI", Font.BOLD, 32));
        title.setForeground(Color.WHITE);

        header.add(title);
        background.add(header, BorderLayout.NORTH);

        // Sidebar menu
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(0, 0, 0, 130));
        sidebar.setPreferredSize(new Dimension(260, getHeight()));
        sidebar.setLayout(new GridLayout(6, 1, 0, 10));
        String[] buttonNames = {
            "Flight Details",
            "Add Customer Details",
            "Book Flight",
            "Journey Details",
            "Cancel Ticket",
            "Boarding Pass"
        };

        for (String name : buttonNames) {
            JButton btn = new JButton(name);
            btn.setFocusPainted(false);
            btn.setBackground(new Color(220, 20, 60)); // CRIMSON RED
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
            btn.addActionListener(this);
            sidebar.add(btn);
        }

        background.add(sidebar, BorderLayout.WEST);

        // Center panel (empty or future widgets)
        mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BorderLayout());
        background.add(mainPanel, BorderLayout.CENTER);

        // Welcome message at the bottom
        JPanel footer = new JPanel();
        footer.setBackground(new Color(0, 0, 0, 100));
        footer.setPreferredSize(new Dimension(100, 60));

        JLabel welcome = new JLabel("Welcome to Airline Reservation System", JLabel.CENTER);
        welcome.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        welcome.setForeground(Color.WHITE);

        footer.add(welcome);
        background.add(footer, BorderLayout.SOUTH);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();

        switch (text) {
            case "Add Customer Details":
                new AddCustomer();
                break;
            case "Flight Details":
                new FlightInfo();
                break;
            case "Book Flight":
                new BookFlight();
                break;
            case "Journey Details":
                new JourneyDetails();
                break;
            case "Cancel Ticket":
                new Cancel();
                break;
            case "Boarding Pass":
                JOptionPane.showMessageDialog(this, "Boarding Pass feature coming soon!");
                break;
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
