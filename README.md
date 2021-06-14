# desafio-quality


## Use Cases

### US001 - Calcule o total de metros quadrados de uma propriedade
```
POST /properties/totalSquareMeters
```
Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| prop_name | String | Número que identifica o usuário atual |
| prop_district | String | Número que identifica o usuário a seguir |
| rooms | List | lista de quartos de uma propriedade  |
| room_name | String | nome do quarto  |
| room_width| Double | Comprimento do quarto  |
| room_length | Double | largura do quarto  |

Exemplo de Json de envio: 
````json
{
  "rooms": [
    {
      "room_name": "Quarto1",
      "room_width": 20.0,
      "room_length": 10.0
    },
    {
      "room_name": "Quarto2",
      "room_width": 10.0,
      "room_length": 10.0
    },
    {
      "room_name": "Quarto3",
      "room_width": 10.0,
      "room_length": 10.0
    },
    {
      "room_name": "Quarto4",
      "room_width": 10.0,
      "room_length": 10.0
    }
  ],
  "prop_name": "Apartamento",
  "prop_district": "Bananal"
}

````


Retorno :

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | Sucesso ao Seguir Vendedor |
| 400 | BAD REQUEST | Dados da Requisição errados |

Exemplo de Json Em Caso de Sucesso :
```json
{
    "prop_name": "Apartamento",
    "total_square_meters": 400.0
}

```

Exemplo de Json de Retorno Em Caso De Erro :
````json
{
    "status": "BAD_REQUEST",
    "message": "Errors in send data of request",
    "timestamp": "11-13-2021 04:13:54",
    "debugMessage": "Validation failed for argument [0] in public org.springframework.http.ResponseEntity<com.example.desafioquality.aplication.response.TotalSquareMetersResponse> com.example.desafioquality.aplication.controller.PropertyController.totalSquareMeters(com.example.desafioquality.aplication.request.PropertyRequest) with 2 errors: [Field error in object 'propertyRequest' on field 'districtName': rejected value [null]; codes [NotBlank.propertyRequest.districtName,NotBlank.districtName,NotBlank.java.lang.String,NotBlank]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [propertyRequest.districtName,districtName]; arguments []; default message [districtName]]; default message [The neighborhood cannot be empty.]] [Field error in object 'propertyRequest' on field 'propertyName': rejected value [null]; codes [NotBlank.propertyRequest.propertyName,NotBlank.propertyName,NotBlank.java.lang.String,NotBlank]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [propertyRequest.propertyName,propertyName]; arguments []; default message [propertyName]]; default message [Property name cannot be empty.]] ",
    "errors": [
        {
            "message": "The neighborhood cannot be empty.",
            "object": "propertyRequest",
            "field": "districtName"
        },
        {
            "message": "Property name cannot be empty.",
            "object": "propertyRequest",
            "field": "propertyName"
        }
    ]
}
````
### US002 - indica o valor de uma propriedade com base em seus quartos e medidas. 
Lembre-se que os preços por metro quadrado são determinados de acordo com o bairro.
```
POST /properties/value
```
Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| prop_name | String | Número que identifica o usuário atual |
| prop_district | String | Número que identifica o usuário a seguir |
| rooms | List | lista de quartos de uma propriedade  |
| room_name | String | nome do quarto  |
| room_width| Double | Comprimento do quarto  |
| room_length | Double | largura do quarto  |

Exemplo de Json de envio:
````json
{
  "rooms": [
    {
      "room_name": "Qaarto",
      "room_width": 10.0,
      "room_length": 10.0

    },
    {
      "room_name": "Quarto",
      "room_width": 10.0,
      "room_length": 10.0
    },
    {
      "room_name": "Quarto",
      "room_width": 10.0,
      "room_length": 10.0
    },
    {
      "room_name": "Quarto",
      "room_width": 10.0,
      "room_length": 10.0
    }
  ],
  "prop_name": "Apartamento",
  "prop_district": "Centro"
}

````


Retorno :

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | Sucesso ao Seguir Vendedor |
| 400 | BAD REQUEST | Dados da Requisição errados |
| 404 | NOT FOUND | Bairro não encontrado |

Exemplo de Json Em Caso de Sucesso:
```json
{
  "property_name": "Apartamento",
  "property_district": "Centro",
  "property_value": 8029600.0
}
```

Exemplo de Json de Retorno Em Caso De Erro :
````json
{
    "status": "BAD_REQUEST",
    "message": "Errors in send data of request",
    "timestamp": "11-13-2021 04:13:54",
    "debugMessage": "Validation failed for argument [0] in public org.springframework.http.ResponseEntity<com.example.desafioquality.aplication.response.TotalSquareMetersResponse> com.example.desafioquality.aplication.controller.PropertyController.totalSquareMeters(com.example.desafioquality.aplication.request.PropertyRequest) with 2 errors: [Field error in object 'propertyRequest' on field 'districtName': rejected value [null]; codes [NotBlank.propertyRequest.districtName,NotBlank.districtName,NotBlank.java.lang.String,NotBlank]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [propertyRequest.districtName,districtName]; arguments []; default message [districtName]]; default message [The neighborhood cannot be empty.]] [Field error in object 'propertyRequest' on field 'propertyName': rejected value [null]; codes [NotBlank.propertyRequest.propertyName,NotBlank.propertyName,NotBlank.java.lang.String,NotBlank]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [propertyRequest.propertyName,propertyName]; arguments []; default message [propertyName]]; default message [Property name cannot be empty.]] ",
    "errors": [
        {
            "message": "The neighborhood cannot be empty.",
            "object": "propertyRequest",
            "field": "districtName"
        },
        {
            "message": "Property name cannot be empty.",
            "object": "propertyRequest",
            "field": "propertyName"
        }
    ]
}
````
### US003 - Calcule o total de metros quadrados de uma propriedade
```
POST /properties/roomBiggest
```
Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| prop_name | String | Número que identifica o usuário atual |
| prop_district | String | Número que identifica o usuário a seguir |
| rooms | List | lista de quartos de uma propriedade  |
| room_name | String | nome do quarto  |
| room_width| Double | Comprimento do quarto  |
| room_length | Double | largura do quarto  |

Exemplo de Json de envio:
````json
{
  "rooms": [
    {
      "room_name": "Quarto1",
      "room_width": 20.0,
      "room_length": 10.0
    },
    {
      "room_name": "Quarto2",
      "room_width": 10.0,
      "room_length": 10.0
    },
    {
      "room_name": "Quarto3",
      "room_width": 10.0,
      "room_length": 10.0
    },
    {
      "room_name": "Quarto4",
      "room_width": 10.0,
      "room_length": 10.0
    }
  ],
  "prop_name": "Apartamento",
  "prop_district": "Bananal"
}

````


Retorno :

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | Sucesso ao Seguir Vendedor |
| 400 | BAD REQUEST | Dados da Requisição errados |
| 404 | NOT FOUND | Não foi encontrado um quarto maior |

Exemplo de Json Em Caso de Sucesso :
```json
{
  "room_biggest_name": "Qaarto1",
  "room_biggest_width": 20.0,
  "room_biggest_length": 10.0,
  "room_biggest_square_meters": 200.0
}
```

Exemplo de Json de Retorno Em Caso De Erro :
````json
{
    "status": "BAD_REQUEST",
    "message": "Errors in send data of request",
    "timestamp": "11-13-2021 04:13:54",
    "debugMessage": "Validation failed for argument [0] in public org.springframework.http.ResponseEntity<com.example.desafioquality.aplication.response.TotalSquareMetersResponse> com.example.desafioquality.aplication.controller.PropertyController.totalSquareMeters(com.example.desafioquality.aplication.request.PropertyRequest) with 2 errors: [Field error in object 'propertyRequest' on field 'districtName': rejected value [null]; codes [NotBlank.propertyRequest.districtName,NotBlank.districtName,NotBlank.java.lang.String,NotBlank]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [propertyRequest.districtName,districtName]; arguments []; default message [districtName]]; default message [The neighborhood cannot be empty.]] [Field error in object 'propertyRequest' on field 'propertyName': rejected value [null]; codes [NotBlank.propertyRequest.propertyName,NotBlank.propertyName,NotBlank.java.lang.String,NotBlank]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [propertyRequest.propertyName,propertyName]; arguments []; default message [propertyName]]; default message [Property name cannot be empty.]] ",
    "errors": [
        {
            "message": "The neighborhood cannot be empty.",
            "object": "propertyRequest",
            "field": "districtName"
        },
        {
            "message": "Property name cannot be empty.",
            "object": "propertyRequest",
            "field": "propertyName"
        }
    ]
}
````

### US004 - Determine o número de metros quadrados que cada cômodo possui
```
POST /properties/roomsSquareMeters
```
Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| prop_name | String | Número que identifica o usuário atual |
| prop_district | String | Número que identifica o usuário a seguir |
| rooms | List | lista de quartos de uma propriedade  |
| room_name | String | nome do quarto  |
| room_width| Double | Comprimento do quarto  |
| room_length | Double | largura do quarto  |

Exemplo de Json de envio:
````json
{
  "rooms": [
    {
      "room_name": "Quarto1",
      "room_width": 20.0,
      "room_length": 10.0
    },
    {
      "room_name": "Quarto2",
      "room_width": 10.0,
      "room_length": 10.0
    },
    {
      "room_name": "Quarto3",
      "room_width": 10.0,
      "room_length": 10.0
    },
    {
      "room_name": "Quarto4",
      "room_width": 10.0,
      "room_length": 10.0
    }
  ],
  "prop_name": "Apartamento",
  "prop_district": "Bananal"
}

````


Retorno :

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | Sucesso ao Seguir Vendedor |
| 400 | BAD REQUEST | Dados da Requisição errados |

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| prop_name | String | Número que identifica o usuário atual |
| rooms | List | lista de quartos de uma propriedade  |
| room_name | String | nome do quarto  |
| room_width| Double | Comprimento do quarto  |
| room_length | Double | largura do quarto  |
| room_square_meters | Double | metros quadrados do quarto  |

Exemplo de Json Em Caso de Sucesso:
```json
{
  "rooms": [
    {
      "room_name": "Qaarto",
      "room_width": 10.0,
      "room_length": 10.0,
      "room_square_meters": 100.0
    },
    {
      "room_name": "Quarto",
      "room_width": 10.0,
      "room_length": 10.0,
      "room_square_meters": 100.0
    },
    {
      "room_name": "Quarto",
      "room_width": 10.0,
      "room_length": 10.0,
      "room_square_meters": 100.0
    },
    {
      "room_name": "Quarto",
      "room_width": 10.0,
      "room_length": 10.0,
      "room_square_meters": 100.0
    }
  ],
  "property_name": "Apartamento"
}
```

Exemplo de Json de Retorno Em Caso De Erro :
````json
{
    "status": "BAD_REQUEST",
    "message": "Errors in send data of request",
    "timestamp": "11-13-2021 04:13:54",
    "debugMessage": "Validation failed for argument [0] in public org.springframework.http.ResponseEntity<com.example.desafioquality.aplication.response.TotalSquareMetersResponse> com.example.desafioquality.aplication.controller.PropertyController.totalSquareMeters(com.example.desafioquality.aplication.request.PropertyRequest) with 2 errors: [Field error in object 'propertyRequest' on field 'districtName': rejected value [null]; codes [NotBlank.propertyRequest.districtName,NotBlank.districtName,NotBlank.java.lang.String,NotBlank]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [propertyRequest.districtName,districtName]; arguments []; default message [districtName]]; default message [The neighborhood cannot be empty.]] [Field error in object 'propertyRequest' on field 'propertyName': rejected value [null]; codes [NotBlank.propertyRequest.propertyName,NotBlank.propertyName,NotBlank.java.lang.String,NotBlank]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [propertyRequest.propertyName,propertyName]; arguments []; default message [propertyName]]; default message [Property name cannot be empty.]] ",
    "errors": [
        {
            "message": "The neighborhood cannot be empty.",
            "object": "propertyRequest",
            "field": "districtName"
        },
        {
            "message": "Property name cannot be empty.",
            "object": "propertyRequest",
            "field": "propertyName"
        }
    ]
}
````