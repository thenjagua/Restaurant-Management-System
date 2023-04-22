public class User {
    protected int id;
    protected String name;
    protected String address;
    protected int phoneNo;
    private UserDataOperationInterface operation;


    public void updateInfo(UserDataOperationInterface myDataOperation, User _user, int _phoneNo, String _address) {
        operation = myDataOperation;
        operation.updateUserDetails(_user, _phoneNo, _address);
    }

    public void printUserInfo(UserDataOperationInterface myDataOperation, User user) {
        operation = myDataOperation;
        operation.printDetails(user);
    }
}