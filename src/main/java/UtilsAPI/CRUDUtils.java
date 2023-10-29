package UtilsAPI;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import pOJOs.User;

public class CRUDUtils {
	
private Map<Integer, User> mapOfUsers = new HashMap<Integer, User>();
	
public void addUser(User user) {
	if(user!=null) {		
		mapOfUsers.put(new Random().nextInt()  , user);
	}
	System.out.println("user added");
}
public User getUserByUserName(String userName) {
	User returnUser = null;
	for(User user : mapOfUsers.values()) {
		if(user.getUsername().equals(userName)) {
			returnUser = user;
			break;
		}
	}
	return returnUser;
}
public Map<Integer, User> getAllUser() {
	return mapOfUsers;
}
public void deleteUserByUserName(String userName) {
	for(User user : mapOfUsers.values()) {
		if(user.getUsername().equals(userName)) {
			mapOfUsers.remove(user);
			System.out.println("user deleted");
			break;
		}
	}
}

}
