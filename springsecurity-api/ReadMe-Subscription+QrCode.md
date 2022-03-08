# women empowerment subscriptions


## QrCode - GET :
( this will generate a QRCode for you + add the authorization jwt bearer token before you send HTTP Request ) :

```
http://localhost:8080/genrateAndDownloadQRCode/SILVER_IMAGE_PATH/350/350
```


<br/>

________

<br/>


##CRUD :
GET / fetch All / fetch by id
```
http://localhost:8080/sub/allsubscriptions
http://localhost:8080/sub/subscriptions/{id}
```

POST / ADD
```
http://localhost:8080/sub/addsubscriptions

{
    "title": "Subscription silver couture",
    "niveau": "SILVER",
    "datedebut": "2022-02-24",
    "datefin": "2022-03-30"
}

```


PUT  / MODIFY
```
http://localhost:8080/sub/modifysubscriptions

{
    "idSubscription": 1,
    "title": "Subscription bronze couture",
    "niveau": "BRONZE"
}

```



DELETE
/empty

```
http://localhost:8080/sub/deletesubscriptions/{id}

```
