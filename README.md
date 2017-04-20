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

## CUSTOMER REGISTRATION API

Pivotal Cloud Foundry End point as follows FOR CUSTOMER REGISTRATION API

```
http://nabhackathon-beacon.cfapps.io
```

- Create Customer Registration

```POST /custreg/newcustreg ```

with body: 

```
{
    "customerRegistrationId":
       {"beaconId": 1,
        "customerId": 1},
    "checkIn": "2012-04-23T18:25:43.511Z",
    "checkOut": "2012-04-23T18:25:43.511Z"
}
```

- View All Customer Registrations

```GET /custreg/all ```

- View customer registrations by customerId 

```GET /custreg/allregbycustomer/customerId ```

- Delete customer registration using beaconId and customerId 

```DELETE custreg/deletecustreg/beaconId/customerId```

<hr />
Pas Apicella [papicella at pivotal.io] is a Senior Platform Architect at Pivotal Australia 