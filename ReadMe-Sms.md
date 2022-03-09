
# Send Sms - Twilio - Spring Application

Create twilio demo-account for sending sms , then go to :

**https://console.twilio.com/?frameUrl=%2Fconsole%3Fx-target-region%3Dus1&newCustomer=true**

<br/>

```
http://localhost:8080/
```

![1](https://i.imgur.com/tdqi8AK.png)



<br/>
<br/>

___
___

<br/>
<br/>
<br/>

## Postman testing :

### Request - Post :

Request :
```
http://localhost:8080/sms
```

Body :
```
{
    "to":"+21658344116",
    "message":"Welcome to Women Empowerment app - this sms message will be send to your verified phone number"
}
```

<br/>

![2](https://i.imgur.com/dFV8key.png)
