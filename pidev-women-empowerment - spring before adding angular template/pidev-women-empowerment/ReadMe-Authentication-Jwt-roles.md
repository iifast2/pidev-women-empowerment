


# Start : 



# POSTMAN : 
<br/>
<br/>
<br/>

📧 ✔️Will send an email each time the userSeeder creates the admins & mangers accounts
<br/>
<br/>

## Generate Bearer jwt Token - POST :
(will displat your JWT bearer token so you can access everything later on ):
```
http://localhost:8080/token
```
```
{
    "username" : "admin",
    "password" : "admin"
}
```
Will display the token for you :

![alt text](https://i.imgur.com/8Uo4fke.png)
**Jwt Token :**
```
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInNjb3BlcyI6IlJPTEVfQURNSU4iLCJpYXQiOjE2NDYyNDc4NDksImV4cCI6MTY0NjMzNDI0OX0.HcW59lXvv2-_R_pRer9QpsNvDZwv2kmOHcBHPHtO2KI
```
<br/>

________

<br/>



## Authorization - GET : 

(will use the jwt bearer token to get access to your admin / profile info)

Add / Paste your token to **Authorisation > Type > Bearer Token**
```
http://localhost:8080/auth
```

This will display your admin info : 
```
{
    "id": 1,
    "firstName": null,
    "lastName": null,
    "username": "admin",
    "salary": 1150,
    "birthdate": "1997/6/7",
    "address": "address",
    "leaveBalance": 30,
    "rib": null,
    "facebook": null,
    "instagram": null,
    "linkedin": null,
    "cin": "0788888887",
    "email": "admin@gmail.com",
    "notifications": [],
    "roles": [
        {
            "id": 1,
            "name": "ADMIN",
            "description": "ADMIN"
        }
    ],
    "requests": []
}
```


![pic1](https://i.imgur.com/AZoKcox.png)

![pic2](https://i.imgur.com/CC257PD.png)


<br/>

________

<br/>


## FindAll / FetchAll - GET : 

( fetchall : this will display all the application users and thier infos )

```
http://localhost:8080/users
```

add this to request body and _**add your jwt / bearer token**_  to the **authorization** : 
```
{
    "username" : "admin",
    "password" : "admin"
}
```

![fetchall](https://i.imgur.com/NVhwN0s.png)

<br/>

________

<br/>


## FetchByID / FindByID - GET  : 
(fetch user by id , don't forget to add your bearer token to the **Authorization** )

```
http://localhost:8080/users/3
```
this will display the user with id : 3 
```
{
    "id": 3,
    "firstName": null,
    "lastName": null,
    "username": "manager",
    "salary": 1150,
    "birthdate": "1999/6/7",
    "address": "address",
    "leaveBalance": 30,
    "rib": null,
    "facebook": null,
    "instagram": null,
    "linkedin": null,
    "cin": "07887877",
    "email": "adminnnnn@gmail.com",
    "notifications": [],
    "roles": [
        {
            "id": 3,
            "name": "MANAGER",
            "description": "MANAGER"
        }
    ],
    "requests": []
}
```



![findbyid](https://i.imgur.com/j0DptED.png)


<br/>

________

<br/>

## FindByUserName - GET :
( find by username : /users/username/{us} )


```
http://localhost:8080/users/username/admin1
```

![findbyusername](https://i.imgur.com/OxFUlt4.png)

<br/>

________

<br/>


## Change Password - GET 
(change password : /password )

```
http://localhost:8080/password
```




<br/>

________

<br/>



## Modify users - PUT
(modify : /users )

```
http://localhost:8080/users
```

```

{
    "id": 4,
    "firstName": null,
    "lastName": null,
    "username": "userr",
    "birthdate": null,
    "address": "rue esprit",
    "email": "Authdaritnn@gmail.com",
    "notifications": null,
    "roles": ["ADMIN"]
    }
    
```

![modify_user](https://i.imgur.com/ExjHFUS.png)


## Add User - POST : 

```
http://localhost:8080/users
```

```
{
    "username" : "user1",
    "password" : "user",
    "email": "adminuser@gmail.com",
    "roles": ["ADMIN"]
}
```

![add-user](https://i.imgur.com/FkkDDVQ.png)







<br/>

________
________

<br/>











# QRCode Generator 


## QrCode - GET : 
( this will generate a QRCode for you + add the authorization jwt bearer token before you send HTTP Request ) : 

```
http://localhost:8080/genrateAndDownloadQRCode/SILVER_IMAGE_PATH/350/350
```











<br/><br/><br/><br/><br/><br/><br/>
_____





















