package utils;

public class TestDataManager {
    private static String registeredEmail;
    private static String registeredPassword;
    
    public static void setRegisteredCredentials(String email, String password) {
        registeredEmail = email;
        registeredPassword = password;
    }
    
    public static String getRegisteredEmail() {
        return registeredEmail;
    }
    
    public static String getRegisteredPassword() {
        return registeredPassword;
    }
}
