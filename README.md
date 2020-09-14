<h3>Consumindo API externa via backend SpringBoot</h3>

**1° Passo:** Leitura da documentação "https://developers.adiq.io/manual/ecommerce#funcionalidades" Adiq.
<br>
**2° Passo:** Testando token de acesso informado pela documentação. 

Post: https://ecommerce-hml.adiq.io/auth/oauth2/v1/token

Body:<br>
{<br>
  "grantType": "client_credentials"<br>
}

Header:
Authorization: Basic ZGV2ZWxvcGVycy5hZGlxLmlv

Observação: O token fornecido pela documentação está inválido, impossibilitando seu uso.

**3° Passo:** foi criado a model SolicitarPagamento com o endPoint (Não foi possível neste estágio criar os relacionamentos ManyToOne e OneToMany):

{<br>
           "paymentAuthorization":{<br>
              "paymentId":"020080286103040952150000006201850000000000",<br>
              "statusDescription":"Autorizada e disponível para captura",<br>
              "transactionDate":"2019-06-27T16:34:28.508Z"<br>
           }<br>
}

O Método CancelarPagamento:
{<br>
  "amount": 1035,<br>
  "sellers": [<br>
    {<br>
      "id": "900",<br>
      "amount": 690,<br>
      "items": [<br>
        {<br>
          "id": "P115DU90",<br>
          "amount": 345<br>
        },<br>
        {<br>
          "id": "P115DU91",<br>
          "amount": 345<br>
        }<br>
      ]<br>
    },<br>
    {<br>
      "id": "901",<br>
      "amount": 345,<br>
      "items": [<br>
        {<br>
          "id": "P115DU92",<br>
          "amount": 345<br>
        }<br>
      ]<br>
    }<br>
  ],<br>
  "merchantId": "01700553554800"<br>
}<br>

O método SolicitarPagamento:

{<br>
        "payment": {<br>
        "transactionType": "credit",<br>
        "amount": 1035,<br>
        "currencyCode": "brl",<br>
        "productType": "avista",<br>
        "installments": 1,<br>
        "captureType": "ac",<br>
        "recurrent": false<br>
        },<br>
        "cardInfo": {<br>
        "vaultId": "f851b514-301a-4e26-8314-3567c1b17aad",<br>
        "numberToken": "2c44f9e6-c242-4c92-8129-eeef72b26336",<br>
        "cardholderName": "JOSE SILVA",<br>
        "securityCode": "123",<br>
        "brand": "visa",<br>
        "expirationMonth": "01",<br>
        "expirationYear": "19"<br>
        },<br>
        "sellerInfo": {<br>
        "orderNumber": "0000000001",<br>
        "softDescriptor": "PAG*TESTE",<br>
        "dynamicMcc": 9999,<br>
        "code3DS": "7608b985-22d1-4771-8bbb-63d3a4a86283",<br>
        "urlSite3DS": "https://loja.virtual.com.br"<br>
        },<br>
        "customer": {<br>
        "documentType": "cpf",<br>
        "documentNumber": "05002827063",<br>
        "firstName": "JOAO",<br>
        "lastName": "PAULO",<br>
        "email": "joaopaulo@teste.com.br",<br>
        "phoneNumber": "1199995555",<br>
        "address": "Nome da Rua",<br>
        "complement": "Complemento",<br>
        "city": "São Paulo",<br>
        "state": "SP",<br>
        "zipCode": "02471220",<br>
        "ipAddress": "127.0.0.1",<br>
        "mobilePhoneNumber":"11912344567",<br>
        "country":"BR"<br>
        },<br>
        "deviceInfo": {<br>
        "httpAcceptBrowserValue": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,/;q=0.8",<br>
        "httpAcceptContent": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,/;q=0.8",<br>
        "httpBrowserLanguage": "pt-BR",<br>
        "httpBrowserJavaEnabled": "N",<br>
        "httpBrowserJavaScriptEnabled": "N",<br>
        "httpBrowserColorDepth": "24",<br>
        "httpBrowserScreenHeight": "985",<br>
        "httpBrowserScreenWidth": "2049",<br>
        "httpBrowserTimeDifference": "180",<br>
        "userAgentBrowserValue": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36"<br>
        }<br><br>
        "sellers": [<br>
        {<br>
        "id": "900",<br>
        "amount": 690,<br>
        "items": [<br>
        {<br>
        "id": "P115DU90",<br>
        "description": "Produto 1",<br>
        "amount": 345,<br>
        "ratePercent": 0,<br>
        "rateAmount": 0<br>
        },<br>
        {<br>
        "id": "P115DU91",<br>
        "description": "Produto 2",<br>
        "amount": 345,<br>
        "ratePercent": 0,<br>
        "rateAmount": 0<br>
        }<br>
        ]<br>
        },<br>
        {<br>
        "id": "901",<br>
        "amount": 345,<br>
        "items": [<br>
        {<br>
        "id": "P115DU92",<br>
        "description": "Produto 1",<br>
        "amount": 345,<br>
        "ratePercent": 0,<br>
        "rateAmount": 0<br>
        }<br>
        ]<br>
        }<br>
        ]<br>
        }<br>


**4° Passo:** Construção da API consumida via RestTemplate
Foram construídos três métodos (acessado por http://localhost:8080/paymentAdiq):
- Método para Get: ConsultarPagamento,
- Método para Post: RealizarPagamento;
- Método para Put: CancelarPagamento;

**5° Passo:** Por fim, foi nececessário realizar o deploy criando o arquivo .jar (Pois a máquina em que foi criada o projeto não tem requisitos técnicos para utilizar o Docker).
Criando o arquivo .jar, pela pasta "target" é possível executar pelo git bash.

4
