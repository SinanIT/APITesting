package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDatePojo {

    private String checkin;
    private String checkout;

    public String getCheckIn() {
        return checkin;
    }

    public void setCheckIn(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckOut() {
        return checkout;
    }

    public void setCheckOut(String checkout) {
        this.checkout = checkout;
    }

    public BookingDatePojo(){
    }

    public BookingDatePojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
