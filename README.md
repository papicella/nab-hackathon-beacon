# HACKATHON SERVICE ENGINE API'S

## BEACON API

Pivotal Cloud Foundry End point as follows FOR BEACON API

```
http://nabhackathon-beacon.cfapps.io
```

- Create Beacon 

```POST /beacon/newbeacon```

with body:

```
{
    "name": "Beacon1",
    "merchantId": 1,
    "type": "proximity"
}
```

- List all Beacons 

```GET /beacon/all```

- Find my merchantId

```GET /beacon/merchant/merchantId```

- Delete beacon by beaconId

```DELETE beacon/deletebeacon/beaconId```

# CUSTOMER REGISTRATION API 

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

