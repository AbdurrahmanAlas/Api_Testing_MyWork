package pojos.Herokuapp2_Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pojos.JsonPlace_Pojo.PojoHerokuappBookingdate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PojoHerokuapp2Booking {

     /*
    {
      "firstname":"Ahmet",
      "lastname":"Bulut",
      "totalprice":500,
      "depositpaid":false,
      "bookingdates":{
          "checkin":"2021-06-01",
          "checkout":"2021-06-10"
                      }
      ,
      "additionalneeds":"wi-fi"
     }
     */


    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean  depositpaid;
    private String additionalneeds;
    private PojoHerokuappBookingdate bookingdates2;


}
