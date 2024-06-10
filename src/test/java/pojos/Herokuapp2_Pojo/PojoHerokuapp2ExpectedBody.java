package pojos.Herokuapp2_Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PojoHerokuapp2ExpectedBody {

       /*
    {
                    "bookingid":24,
                    "booking":{
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
                    }
     */

    private int bookingId;
    private PojoHerokuapp2Booking booking;




}
