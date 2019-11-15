package ee.unit;

class Booking {
    private String fName;
    private String sName;
    private double price;
    private boolean deposit;
    private String checkInDate;
    private String checkOutDate;

    public Booking(String fName, String sName, double price, boolean deposit, String checkInDate, String checkOutDate) {
        this.fName = fName;
        this.sName = sName;
        this.price = price;
        this.deposit = deposit;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDeposit() {
        return deposit;
    }

    public void setDeposit(boolean deposit) {
        this.deposit = deposit;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}