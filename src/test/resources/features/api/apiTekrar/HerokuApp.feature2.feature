
Feature: Post ornegi HerokuApp
   #  /*
    #    https://restful-booker.herokuapp.com/booking url’ine
    #    asagidaki body'ye sahip bir POST request gonderdigimizde
    #    donen response’un id disinda asagidaki gibi oldugunu test edin.
    #
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

  @newher
  Scenario: Post HerokuApp

    * Herokuapp URL ve body hazirla
    * Herokuapp Expected Data hazirla
    * Herokuapp Response kaydet
    * Assertion yap
