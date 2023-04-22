public class CustomerOperation implements UserDataOperationInterface {
  //Method ovvering as part of Polymorphism
    @Override

    public User updateUserDetails(User currentUser, int phoneNo, String address) {
        currentUser.phoneNo = phoneNo;
        currentUser.address = address;
        System.out.println("Updated the customer information");
        return currentUser;
    }

    @Override

    public void printDetails(User user) {
        System.out.println("--------------- CUSTOMER INFORMATION---------------------");
        System.out.println("ID: " + user.id);
        System.out.println("Name: " + user.name);
        System.out.println("Telephone: " + user.phoneNo);
        System.out.println("Address: " + user.address);
        System.out.println("------------CUSTOMER OF USER INFORMATION---------------------");

    }
}
