# Build/Run

```
./mvnw spring-boot:run
```

# Test

```
curl    --header "Content-Type: application/json" \
        --request POST \
        --data '{"name": "bbb","email": "abc@email.com","dateOne": "2020-07-28","dateTwo": "2020-07-28","dateThree": "2020-07-28","dateFour": "2020-07-28T21:45:08","dateFive": "2020-07-28T21:45:08.969752-03:00[America/Sao_Paulo]"}' \
        http://localhost:8080/users
```

See log output:
```
2020-11-24 14:36:21.285  INFO 320 --- [nio-8080-exec-7] bcp.crud.UserController                  : Create user: 
User [id=0
, name=bbb
, email=abc@email.com
, dateOne....(java.util.Date)...........2020-07-27 21:00:00 [Mon Jul 27 21:00:00 BRT 2020]
, dateTwo....(java.sql.Date)............2020-07-27 21:00:00 [2020-07-27]
, dateThree..(java.time.LocalDate)......2020-07-28          [2020-07-28]
, dateFour...(java.time.LocalDateTime)..2020-07-28 21:45:08 [2020-07-28T21:45:08]
, dateFive...(java.time.ZonedDateTime)..2020-07-29 00:45:08 [2020-07-29T00:45:08.969752Z[UTC]]
  {Default TZsun.util.calendar.ZoneInfo[id="America/Sao_Paulo",offset=-10800000,dstSavings=0,useDaylight=false,transitions=93,lastRule=null]} ]

```
