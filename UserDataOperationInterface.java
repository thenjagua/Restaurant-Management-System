public interface UserDataOperationInterface {
//interface to update user details
    public User updateUserDetails(User currentUser, int phoneNo, String address);
//Interface to print user details
    public void printDetails(User user);

}