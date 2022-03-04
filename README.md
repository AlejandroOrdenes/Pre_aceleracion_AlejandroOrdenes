# DisneyApi

#### API de Películas/Series Disney.

## Users

#### Registro y Login de Usuarios. Se hace a través de email y password.

### POST Register

```
http://localhost:8080/auth/register
```
#### Registro de usuario con email y password encriptado.

#### Se envía un email de conrmación a través de SendGrid, debe tener una API_KEY como variable local.

#### BODY raw

```
Example Request Register
```
###### {

```
"userName": "jannof@gmail.com",
"password": "123456789"
}
```
```
curl --location --request POST 'http://localhost:8080/auth/register' \
--data-raw '{
"userName": "jannof@gmail.com",
"password": "123456789"
}'
```
```
Documentation Settings
```

### POST Login

```
http://localhost:8080/auth/login
```
#### Login de Usuario con email y password registrados. Se crea un JWT para validación de usuario.

#### BODY raw

```
Example Request Login
```
## Genres

#### Géneros de películas y series asociados a cada una de ellas a travez de su Id.

### POST Create Genres

```
http://localhost:8080/genres
```
#### Creación de géneros de películas y series.

#### HEADERS

**Authorization**
BearereyJhbGciOiJIUzI1NiJ9eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MjYxNTAxLCJleHAiOjE2NDYyOTc1MDF

###### {

```
"username": "jannof@gmail.com",
"password": "123456789"
}
```
```
curl --location --request POST 'http://localhost:8080/auth/login' \
--data-raw '{
"username": "jannof@gmail.com",
"password": "123456789"
}'
```
```
Documentation Settings
```

Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MjYxNTAxLCJleHAiOjE2NDYyOTc1MDF9.-
aU4NZWvFY6dc7wSrBmLEfwAH-4pXoyERsbtyqZc-Zk

#### BODY raw

```
Example Request Create Genres
```
## Movies

#### Películas/Series de Disney con genero y personajes asociados.

### GET List Movies

```
http://localhost:8080/movies
```
#### Lista de todas las películas almacenadas.

###### {

```
"name": "Action",
"image": "action.jpg"
}
```
```
curl --location --request POST 'http://localhost:8080/genres' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0Ijox
--data-raw '{
"name": "Action",
"image": "action.jpg"
}'
```
```
Documentation Settings
```

#### HEADERS

**Authorization**
Bearer
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MzI4MDYwLCJleHAiOjE2NDYzNjQwNjB9.9ycsW
Ms1ZnacVfYymLXNQiy3m8RE-TKYFhzWbX2_rCI

```
Example Request List Movies
```
### GET Details Movie

```
http://localhost:8080/movies/
```
#### Búsqueda de películas por su id.

##### [

##### {

##### "title": "Luca",

##### "image": "image.jpg",

##### "creationDate": "2021-01-01"

##### },

##### {

##### "title": "Pulp Fiction",

##### "image": "image.jpg",

##### "creationDate":"1994-01-01"

```
curl --location --request GET 'http://localhost:8080/movies' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0Ijox
```
#### View More

```
Documentation Settings
```

#### HEADERS

**Authorization**
Bearer
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MzI4MDYwLCJleHAiOjE2NDYzNjQwNjB9.9ycsW
Ms1ZnacVfYymLXNQiy3m8RE-TKYFhzWbX2_rCI

```
Example Request Details Movie
```
### GET Filters Movies

```
http://localhost:8080/movies/lters?genreId=2&order=asc
```
#### Búsqueda de películas por ltros.

#### HEADERS

**Authorization**
Bearer
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MzMyMjAyLCJleHAiOjE2NDYzNjgyMDJ9.8pfKt8M
reo1TXzR4UHTPGwzbRQ0pTY3h4sLBpConDPA

##### {

##### "id": 2,

##### "title": "Luca",

##### "image": "image.jpg",

##### "creationDate": "2021-01-01",

##### "rating": 4,

##### "genreId": 2,

##### "characters": [

##### {

##### "id": 1,

```
curl --location --request GET 'http://localhost:8080/movies/2' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0Ijox
```
#### View More

```
Documentation Settings
```

reo1TXzR4UHTPGwzbRQ0pTY3h4sLBpConDPA

#### PARAMS

**title**

Luca

**genreId**
2

**order**
asc

```
Example Request Filters Movies
```
### POST Create Movie

```
http://localhost:8080/movies
```
#### Registro de películas/series con su respectiva información.

#### HEADERS

**Authorization**
Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MjYxNTAxLCJleHAiOjE2NDYyOTc1MDF9.-
aU4NZWvFY6dc7wSrBmLEfwAH-4pXoyERsbtyqZc-Zk

#### BODY raw

```
curl --location --request GET 'http://localhost:8080/movies/filters?genreId=2&order=asc' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0Ijox
```
###### {

```
"title":"Pulp Fiction",
"image":"image.jpg",
"creationDate": "1994-01-01",
"rating": 5,
"genreId": 1
}
```
```
Documentation Settings
```

```
Example Request Create Movie
```
### PUT Update Movie

```
http://localhost:8080/movies/
```
#### Actualizar películas según su Id.

#### HEADERS

**Authorization**
Bearer
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MzEzMjY5LCJleHAiOjE2NDYzNDkyNjl9.RIV5-
5v6yywjEp1fWhFpj_1brsBICOIqI0uyao6-LfU

#### BODY raw

```
Example Request Update Movie
```
```
curl --location --request POST 'http://localhost:8080/movies' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0Ijox
--data-raw '{
"title":"Pulp Fiction",
"image":"image.jpg",
"creationDate": "1994-01-01",
"rating": 5,
"genreId": 1
}'
```
###### {

```
"id": 1,
"title": "Lion King",
"image": "lionKing.jpg",
"creationDate": "1998-01-01",
"rating": 5,
"genreId": 2
}
```
```
Documentation Settings
```

### DEL Delete Movie

```
http://localhost:8080/movies/
```
#### Borrar películas según su Id.

#### HEADERS

**Authorization**
Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MzE2NzE3LCJleHAiOjE2NDYzNTI3MTd9.-
G2mV5hxB-IcFJbdFCVEDbU_y8_zrEuI8KmF3oC-y4g

```
Example Request Delete Movie
```
### POST Add Character

```
http://localhost:8080/movies/2/character/
```
#### HEADERS

```
curl --location --request PUT 'http://localhost:8080/movies/1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0Ijox
--data-raw ' {
"id": 1,
"title": "Lion King",
"image": "lionKing.jpg",
"creationDate": "1998-01-01",
"rating": 5,
"genreId": 2
}'
```
```
curl --location --request DELETE 'http://localhost:8080/movies/1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0Ijox
```
#### View More

```
Documentation Settings
```

**Authorization**
Bearer

eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MzEyMTgwLCJleHAiOjE2NDYzNDgxODB9.m4HE
FhnB3RK75CdJxBVsLb8oKwytXC_7pfe4XXdNBiE

```
Example Request Add Character
```
### DEL Remove Character

```
http://localhost:8080/movies/2/character/
```
#### Remover personaje de una película. Se debe asignar el Id de la película en donde se encuentra el personaje

#### y él Id del personaje a remover.

#### HEADERS

**Authorization**
Bearer
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MzI3MTg0LCJleHAiOjE2NDYzNjMxODR9.QCDW
Fb-Q7oonZkgAKWod11NhLzkg0MyG0O6vi_Ys

```
Example Request Remove Character
```
## Characters

```
curl --location --request POST 'http://localhost:8080/movies/2/character/1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0Ijox
```
```
curl --location --request DELETE 'http://localhost:8080/movies/2/character/2' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0Ijox
```
```
Documentation Settings
```

### GET List Characters

```
http://localhost:8080/characters
```
#### Listado de todos los personajes almacenados.

#### HEADERS

**Authorization**
Bearer
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MzIzNzkxLCJleHAiOjE2NDYzNTk3OTF9.hTJ80aSJ
WHohGBi84Vrn5ubJTskTfrFIQKmhgBQIZW

```
Example Request List Characters
```
### GET Details Character

```
http://localhost:8080/characters/
```
#### Lista personaje con todos sus atributos, la búsqueda es según su Id.

##### [

##### {

##### "image": "luca.jpg",

##### "name": "Luca"

##### },

##### {

##### "image": "giulia.jpg",

##### "name": "Giulia MArcovaldo"

##### }

##### ]

```
curl --location --request GET 'http://localhost:8080/characters' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0Ijox
```
#### View More

```
Documentation Settings
```

#### HEADERS

**Authorization**
Bearer
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MzI2MTk1LCJleHAiOjE2NDYzNjIxOTV9.vSy3nIV
LN3hMukiXwdDOeCG1cPDYZ-kaAqpRuAbiNw

```
Example Request Details Character
```
### GET Filters Characters

```
http://localhost:8080/characters/lters?movies=
```
#### HEADERS

**Authorization**
Bearer
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MzM0NTc5LCJleHAiOjE2NDYzNzA1Nzl9.losROae
-W50t6bdE2M5SIahEoeoMfnn2ZAf3GOsHJjA

#### PARAMS

##### {

##### "id": 1,

##### "image": "luca.jpg",

##### "name": "Luca",

##### "age": 15,

##### "weight": 40.0,

##### "history": "Italian Kid",

##### "movies": [

##### {

##### "id": 2,

```
curl --location --request GET 'http://localhost:8080/characters/2' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0Ijox
```
#### View More

```
Documentation Settings
```

**name**
luca

**age**

15

**weight**
40

**movies**
2

```
Example Request Filters Characters
```
### POST Create Character

```
http://localhost:8080/characters
```
#### Creación de personajes con su respectiva información.

#### HEADERS

**Authorization**
Bearer
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MzEyMTgwLCJleHAiOjE2NDYzNDgxODB9.m4HE
FhnB3RK75CdJxBVsLb8oKwytXC_7pfe4XXdNBiE

#### BODY raw

```
curl --location --request GET 'http://localhost:8080/characters/filters?movies=2' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0Ijox
```
###### {

```
"name":"Luca",
"age": 15,
"history": "Italian Kid",
"weight": 40,
"image": "luca.jpg"
}
```
```
Documentation Settings
```

```
Example Request Create Character
```
### PUT Update Character

```
http://localhost:8080/characters/
```
#### Actualizar personajes según su Id.

#### HEADERS

**Authorization**
Bearer
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MzI1OTA0LCJleHAiOjE2NDYzNjE5MDR9.JGkixbqF
F2NGMP7XS_iEzHcvj6WovE-fBxoTSSN2-qs

#### BODY raw

```
Example Request Update Character
```
```
curl --location --request POST 'http://localhost:8080/characters' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0Ijox
--data-raw '{
"name":"Luca",
"age": 15,
"history": "Italian Kid",
"weight": 40,
"image": "luca.jpg"
}'
```
###### {

```
"id": 2,
"image": "Scorfano.jpg",
"name": "Alberto Scorfano",
"age": 18,
"weight": 40.0,
"history": "Italian Kid"
}
```
```
Documentation Settings
```

### DEL Delete Character

```
http://localhost:8080/characters/
```
#### Para eliminar un personaje, primero se debe remover de la o las películas en que se encuentre.

#### HEADERS

**Authorization**
Bearer
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0IjoxNjQ2MzI2MTk1LCJleHAiOjE2NDYzNjIxOTV9.vSy3nIV
LN3hMukiXwdDOeCG1cPDYZ-kaAqpRuAbiNw

```
Example Request Delete Character
```
```
curl --location --request PUT 'http://localhost:8080/characters/2' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0Ijox
--data-raw ' {
"id": 2,
"image": "Scorfano.jpg",
"name": "Alberto Scorfano",
"age": 18,
"weight": 40.0,
"history": "Italian Kid"
}'
```
```
curl --location --request DELETE 'http://localhost:8080/characters/2' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW5ub2ZAZ21haWwuY29tIiwiaWF0Ijox
```
