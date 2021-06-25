package main.com.company;

import java.util.List;
import java.util.Optional;

public class AccessManager implements DataBase {

public static boolean dataСhecking ( String password, String loginOrId){

    // Поиск соответствия:

    //Формат входа
    // ID + password
    // login + password

    boolean authorization = DataBase.users.stream().anyMatch(user-> user.getPassword().
            equals(password)&& user.getLogin().equals(loginOrId) || user.getPassword().
            equals(password) && (user.getId().equals(loginOrId)));



    return authorization;
}

}
