package com.example.chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRegisterGUI extends JFrame implements ActionListener {

    private final JTextField usernameField;
    private final JTextField emailField;
    private final JTextField passwordField;
    private static JTextField confirmPasswordField;

    public LoginRegisterGUI(JTextField confirmPasswordField) {
        LoginRegisterGUI.confirmPasswordField = confirmPasswordField;
        setTitle("Login/Register");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components for login form
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        // Create components for registration form
        JLabel newUsernameLabel = new JLabel("Username:");
        JTextField newUsernameField = new JTextField();
        JLabel newEmailLabel = new JLabel("Email:");
        JTextField newEmailField = new JTextField();
        JLabel newPasswordLabel = new JLabel("Password:");
        JPasswordField newPasswordField = new JPasswordField();
        JLabel confirmPasswordRegisterLabel = new JLabel("Confirm Password:");
        JPasswordField confirmPasswordRegisterField = new JPasswordField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();
        JLabel genderLabel = new JLabel("Gender:");
        String[] genderOptions = {"Male", "Female"};
        JComboBox<String> genderComboBox = new JComboBox<>(genderOptions);
        JButton registerButton = new JButton("Register");

        // Create panel to hold components for login form
        JPanel loginPanel = new JPanel(new GridLayout(4, 2));
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(emailLabel);
        loginPanel.add(emailField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginButton.addActionListener(this);

        // Create panel to hold components for registration form
        JPanel registerPanel = new JPanel(new GridLayout(9, 2));
        registerPanel.add(newUsernameLabel);
        registerPanel.add(newUsernameField);
        registerPanel.add(newEmailLabel);
        registerPanel.add(newEmailField);
        registerPanel.add(newPasswordLabel);
        registerPanel.add(newPasswordField);
        registerPanel.add(confirmPasswordRegisterLabel);
        registerPanel.add(confirmPasswordRegisterField);
        registerPanel.add(ageLabel);
        registerPanel.add(ageField);
        registerPanel.add(genderLabel);
        registerPanel.add(genderComboBox);
        registerPanel.add(registerButton);
        registerButton.addActionListener(this);

        // Create tabbed pane to switch between login and registration forms
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Login", loginPanel);
        tabbedPane.addTab("Register", registerPanel);

        // Add tabbed pane to frame
        getContentPane().add(tabbedPane);

        // Center window on screen
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Login")) {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();

            // Check if email is valid
            if (!email.contains("@")) {
                JOptionPane.showMessageDialog(this, "Invalid email address");
                return;
            }

            try (Connection connection = DBConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE Username = ? AND Email = ? AND Password = ?")) {
                statement.setString(1, username);
                statement.setString(2, email);
                statement.setString(3, password);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(this, "Successful login", "Login successful", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Wrong username or email or password.", "Login failed", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred during login.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(this, "Logged in as " + username);
        } else if (actionCommand.equals("Register")) {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            String confirmPassword = confirmPasswordField.getText();


            // Check if email is valid
            if (!email.contains("@")) {
                JOptionPane.showMessageDialog(this, "Invalid email address");
                return;
            }

            // Check if password and confirm password match
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match");
                return;
            }

            try (Connection connection = DBConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement("INSERT INTO Users (Username, Email, Password) VALUES (?, ?, ?)")) {
                statement.setString(1, username);
                statement.setString(2, email);
                statement.setString(3, password);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "User registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to register user.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred during login.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(this, "Registered as " + username);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginRegisterGUI loginRegisterGUI = new LoginRegisterGUI(confirmPasswordField);
            loginRegisterGUI.setVisible(true);
        });
    }
}