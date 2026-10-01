class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    private String otp; // write-only

    public MovieBookingProfile() {}

    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isConfirmed() { return confirmed; }
    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }

    public void setOtp(String otp) { this.otp = otp; }
    // No getter for otp → write-only
}
