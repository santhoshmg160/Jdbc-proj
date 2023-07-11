public class ContactModel {
    
    private String name;
    private long contactNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public String toString() {
        return "Name: " + name + " contactNo:" +  contactNo;
    }
}
