package md.programy.utils.converters;

import md.programy.database.model.Password;
import md.programy.modelFX.PasswordFX;

public class PasswordConverter {

    public static Password convertToPassword(PasswordFX passwordFX){
        Password password = new Password();
        password.setId(passwordFX.getId());
        password.setName(passwordFX.getName());
        password.setLink(passwordFX.getLink());
        password.setLogin(passwordFX.getLogin());
        password.setPassword(passwordFX.getPassword());
        password.setDescription(passwordFX.getDescription());
        return password;
    }

    public static PasswordFX convertToPasswordFX(Password password){
        PasswordFX passwordFX = new PasswordFX();
        passwordFX.setId(password.getId());
        passwordFX.setLink(password.getLink());
        passwordFX.setName(password.getName());
        passwordFX.setLogin(password.getLogin());
        passwordFX.setPassword(password.getPassword());
        passwordFX.setDescription(password.getDescription());
        return  passwordFX;
    }
}
