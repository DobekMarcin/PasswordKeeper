package md.programy.modelFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import md.programy.database.model.Password;
import md.programy.database.repository.PasswordRepository;
import md.programy.utils.converters.PasswordConverter;

import java.util.ArrayList;
import java.util.List;

public class ListPasswordModel {

    private ObservableList<PasswordFX> passwordFXObservableList = FXCollections.observableArrayList();
    private List<PasswordFX> passwordFXList = new ArrayList<PasswordFX>();

    private PasswordRepository passwordRepository = new PasswordRepository();
    public void init(){
        passwordRepository.createDefaultPassword("Facebook","www.facebook.pl","admin","admin","To jest hasło");
        passwordRepository.createDefaultPassword("Gmail","www.gmail.com","test@gmail.com","testujemy","To jest hasło");
        passwordRepository.createDefaultPassword("Onet poczta","www.onet.poczta.pl","marcin@poczta.onet.pl","password","To jest hasło");
        passwordRepository.createDefaultPassword("Filmweb","www.filmweb.com","admin","admin","To jest hasło");

        List<Password> passwordList = passwordRepository.getAllPassword();

        passwordList.forEach(item->{
                PasswordFX passwordFX = PasswordConverter.convertToPasswordFX(item);
                passwordFXObservableList.add(passwordFX);
        });
    }

    public ObservableList<PasswordFX> getPasswordFXObservableList() {
        return passwordFXObservableList;
    }

    public void setPasswordFXObservableList(ObservableList<PasswordFX> passwordFXObservableList) {
        this.passwordFXObservableList = passwordFXObservableList;
    }
}
