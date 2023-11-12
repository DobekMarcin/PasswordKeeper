package md.programy.modelFX;

import javafx.beans.property.*;
import javafx.scene.control.Button;

public class PasswordFX {

    private LongProperty id = new SimpleLongProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty link = new SimpleStringProperty();
    private StringProperty login = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private Button copyButton = new Button();
    {
        copyButton.setText("Kopiuj");
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLink() {
        return link.get();
    }

    public StringProperty linkProperty() {
        return link;
    }

    public void setLink(String link) {
        this.link.set(link);
    }

    public String getLogin() {
        return login.get();
    }

    public StringProperty loginProperty() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public Button getCopyButton() {
        return copyButton;
    }

    public void setCopyButton(Button copyButton) {
        this.copyButton = copyButton;
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
