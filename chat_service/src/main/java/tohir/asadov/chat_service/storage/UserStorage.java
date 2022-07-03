package tohir.asadov.chat_service.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

public class UserStorage {

    private static UserStorage instance;
    private Set<String> users;

    private UserStorage(){
        users = new HashSet<>();
    }

    public static synchronized UserStorage getInstance(){
        if (instance==null){
            instance = new UserStorage();
        }
        return instance;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUser(String userName) throws Exception {
        if (users.contains(userName)){
            throw new Exception("User already with exists username: " + userName);
        }
        users.add(userName);
    }
}
