** BEACON API **

Create Beacon ->

$ curl -H "Accept: application/json" -H "Content-Type: application/json" -X POST http://localhost:8080/beacon/newbeacon -d @new-beacon.json
{"beaconId":1,"name":"Beacon1","merchantId":1,"type":"proximity"}

new-beacon.json as follows:

{
    "name": "Beacon1",
    "merchantId": 1,
    "type": "proximity"
}

List all Beacons ->

$ curl http://localhost:8080/beacon/all | jq -r
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100    67    0    67    0     0   5937      0 --:--:-- --:--:-- --:--:--  6090
[
  {
    "beaconId": 1,
    "name": "Beacon1",
    "merchantId": 1,
    "type": "proximity"
  }
]

Find my merchant id ->

$ curl http://localhost:8080/beacon/merchant/1 | jq -r
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100    65    0    65    0     0   3101      0 --:--:-- --:--:-- --:--:--  3250
{
  "beaconId": 1,
  "name": "Beacon1",
  "merchantId": 1,
  "type": "proximity"
}

Delete beacon by ID ->

$ curl -X DELETE http://localhost:8080/beacon/deletebeacon/1

** CUSTOMERREGISTRATION API **

Create Customer Registration ->

$ curl -H "Accept: application/json" -H "Content-Type: application/json" -X POST http://localhost:8080/custreg/newcustreg -d @new-custreg.json
{"customerRegistrationId":{"beaconId":1,"customerId":1},"checkIn":1335205543511,"checkOut":1335205543511}

new-custreg.json as follows:

{
    "customerRegistrationId":
       {"beaconId": 1,
        "customerId": 1},
    "checkIn": "2012-04-23T18:25:43.511Z",
    "checkOut": "2012-04-23T18:25:43.511Z"
}

View All Customer Registrations:

$ curl http://localhost:8080/custreg/all | jq -r
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   107    0   107    0     0   4566      0 --:--:-- --:--:-- --:--:--  4652
[
  {
    "customerRegistrationId": {
      "beaconId": 1,
      "customerId": 1
    },
    "checkIn": 1335205544000,
    "checkOut": 1335205544000
  }
]

View customer registrations by customerId ->

$ curl http://localhost:8080/custreg/allregbycustomer/1 | jq -r
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   107    0   107    0     0   6261      0 --:--:-- --:--:-- --:--:--  6687
[
  {
    "customerRegistrationId": {
      "beaconId": 1,
      "customerId": 1
    },
    "checkIn": 1335205544000,
    "checkOut": 1335205544000
  }
]

Delete customer registration using beaconId and customerId in that order ->

$ curl -X DELETE http://localhost:8080/custreg/deletecustreg/1/1

