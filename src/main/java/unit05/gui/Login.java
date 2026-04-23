package unit05.gui;

import javax.swing.*;
import javax.swing.event.CaretListener;
import java.awt.*;

/**
 * This class provides a simple Login GUI example.
 * It demonstrates basic Swing components, layout management, event handling,
 * and simple authentication logic. It also includes validation to enable the
 * login button only when inputs meet minimum length requirements.
 */
public class Login extends JFrame {

    private static final int MAX_ATTEMPTS = 3;
    private static final int MIN_LENGTH = 5;
    private int attempts = 0;

    private final JTextField usernameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JButton loginButton = new JButton("Login");

    public Login() {
        // Fenster-Konfiguration: Basis-Einstellungen für das Hauptfenster
        setTitle("Secure Login System");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // UI Aufbau: Trennung von Layout und Logik
        setupUI();
        
        // Event-Handling: Registrierung der Listener
        setupListeners();
    }

    private void setupUI() {
        // Wir verwenden ein Panel mit Padding für ein sauberes Erscheinungsbild
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Eingabebereich: GridLayout für konsistente Beschriftungen und Felder
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.add(new JLabel("Username:"));
        inputPanel.add(usernameField);
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);

        // Login-Button initial deaktiviert, bis Validierung erfolgt
        loginButton.setEnabled(false);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(loginButton, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void setupListeners() {
        // CaretListener reagiert auf Positionsänderungen des Cursors und Texteingaben.
        // Er ist einfach zu implementieren und für diese Validierung zweckdienlich.
        CaretListener validationListener = e -> validateInputs();

        usernameField.addCaretListener(validationListener);
        passwordField.addCaretListener(validationListener);

        loginButton.addActionListener(e -> handleLogin());
    }

    /**
     * Überprüft, ob die Eingaben die Mindestlänge erfüllen, um den Button zu aktivieren.
     * Zentralisierte Validierung verhindert Code-Duplizierung.
     */
    private void validateInputs() {
        boolean isValid = usernameField.getText().length() >= MIN_LENGTH 
                       && passwordField.getPassword().length >= MIN_LENGTH;
        loginButton.setEnabled(isValid);
    }

    /**
     * Verarbeitet den Login-Versuch.
     * Trennung der Validierungslogik von der UI-Logik.
     */
    private void handleLogin() {
        attempts++;

        if (attempts > MAX_ATTEMPTS) {
            JOptionPane.showMessageDialog(this, "Too many attempts. System locking.", "Security Alert", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if (user.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please enter a username", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Authentifizierungs-Logik: Einfache Rollenzuweisung
        if (authenticate(user, pass)) {
            openDashboard(user);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean authenticate(String user, String pass) {
        // Einfache Mock-Validierung: Benutzername entspricht Passwort
        return user.equals(pass) && (user.equals("junior") || user.equals("senior") || user.equals("admin"));
    }

    private void openDashboard(String role) {
        // Strategie-Pattern Ansatz: Fenster basierend auf der Rolle öffnen
        JFrame dashboard = switch (role) {
            case "junior" -> new JuniorWindow();
            case "senior" -> new SeniorWindow();
            case "admin" -> new AdminWindow();
            default -> null;
        };

        if (dashboard != null) {
            dashboard.setVisible(true);
            this.dispose();
        }
    }
}
