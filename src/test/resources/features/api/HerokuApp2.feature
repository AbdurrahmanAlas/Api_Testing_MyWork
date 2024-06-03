

#3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
#parametrelerini yazarak
# “firstname” degeri “Jim” ve
# “lastname” degeri “Jackson”
# olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
#donen response’un status code’unun 200 oldugunu
# ve “Jim Jackson” ismine sahip
#en az bir booking oldugunu test edin.

#     {
#     "firstname": "John",
#     "lastname": "Smith",
#     "totalprice": 111,
#     "depositpaid": true,
#     "bookingdates": {
#     "checkin": "2018-01-01",
#     "checkout": "2019-01-01"
#     },
#     "additionalneeds": "Breakfast"
#     } 1112

  Feature: Get_PojoClass

    @dummy
    Scenario: Get sorgusu
      * Herokuapp Api gerekli URL icin "booking" path param ve "Jim" query param hazirla
      * Herokuapp Api Get Request donen Response i kaydet
      * Herokuapp Api Get Request donen Response i assert et
