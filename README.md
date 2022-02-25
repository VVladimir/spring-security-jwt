# spring-security-jwt
Spring security JWT

post http://localhost:8080/api/v1/auth/login
body
````json
{
"email":"user@mail.com",
"password":"user"
}
````
response
````json
{
"email": "user@mail.com",
"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQG1haWwuY29tIiwicm9sZSI6IlVTRVIiLCJpYXQiOjE2NDU4MjMyODYsImV4cCI6MTY0NjQyODA4Nn0.Y2Qcmn1OJxW1Kp9oZUSb-XJKfTB86CutirgZ8MyiMyU"
}
````