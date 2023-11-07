package md.programy.modelFX;

import md.programy.database.repository.UserRepository;

public class UserModel {

    private UserFX userFx = new UserFX();
    private UserRepository userRepository = new UserRepository();

    public Boolean checkUser() {
        Long result = userRepository.checkUser(userFx.getLogin(), userFx.getPassword());
        return result == 1 ? true : false;
    }

    public void createAdmin() {
        Long userCount = userRepository.getAllUserCount();
        if (userCount == 0) {
            userRepository.createAdmin("admin", "admin");
        }}

    public void resetAdmin() {
        userRepository.deleteAllUser();
        Long userCount = userRepository.getAllUserCount();
        if (userCount == 0) userRepository.createAdmin("admin", "admin");
    }


    public UserFX getUserFx() {
        return userFx;
    }

    public void setUserFx(UserFX userFx) {
        this.userFx = userFx;
    }
}
