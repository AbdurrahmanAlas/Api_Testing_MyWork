package pojos.JsonPlace_Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PojoHerokuappBookingdate {


     /*
    {
       "checkin":"2021-06-01",
       "checkout":"2021-06-10"
     }
     */

    private String checkin;
    private String checkout;
}
