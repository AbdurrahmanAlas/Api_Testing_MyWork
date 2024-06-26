

Feature: CommonAPI


  @biz
  Scenario: Post ornegi

    * URL ve body hazirla
    * Expected Data hazirla
    * Response'i kaydet
    * Assertion



    #  /*
    #    https://restful-booker.herokuapp.com/booking url’ine
    #    asagidaki body'ye sahip bir POST request gonderdigimizde
    #    donen response’un id disinda asagidaki gibi oldugunu test edin.
    #    	                Request body
    #    	           {
    #    	                "firstname" : "Ahmet",
    #    	                "lastname" : “Bulut",
    #    	                "totalprice" : 500,
    #    	                "depositpaid" : false,
    #    	                "bookingdates" : {
    #    	                         "checkin" : "2021-06-01",
    #    	                         "checkout" : "2021-06-10"
    #    	                                  },
    #    	                "additionalneeds" : "wi-fi"
    #    	            }
    #
    #
    #    	            	Response Body = Expected Data
    #    	            	{
    #                    "bookingid":24,
    #                    "booking":{
    #                        "firstname":"Ahmet",
    #                        "lastname":"Bulut",
    #                        "totalprice":500,
    #                        "depositpaid":false,
    #                        "bookingdates":{
    #                            "checkin":"2021-06-01",
    #                            "checkout":"2021-06-10"
    #                                        }
    #                        ,
    #                        "additionalneeds":"wi-fi"
    #                              }
    #                    }
    #         */