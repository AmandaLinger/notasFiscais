<h1>📑​ Sistema back-end de notas fiscais</h1>

<h3>Tecnologias utilizadas:</h3>
<p>⛏️​ Java 21</p>
<p>⛏️​ Spring Boot</p>
<p>⛏️​ Lombok</p>
<p>⛏️​ PostgreSql</p>
<p>⛏️​ Docker</p>
<p>⛏️​ Maven</p>
<p>⛏️​ Spring Boot</p>
<p>⛏️​ Postman</p>


<h2>Modelos Json para requisições:</h2>
<h3>👤​ Cliente</h3>
<h4>POST de cliente:</h4>
<p>http://localhost:8080/cliente</p>
<p>Body: {
    "nome": "Julia",
    "codigo": 5
}</p>

<h4>GET ALL de clientes:</h4>
<p>http://localhost:8080/cliente</p>

<h4>GET cliente específico</h4>
<p>http://localhost:8080/cliente/1</p>

<h4>PUT de cliente:</h4>
<p>http://localhost:8080/cliente</p>
<p>Body: {
    "nome": "amanda marques",
    "codigo": 225
}</p>

<h4>DELETE de cliente:</h4>
<p>http://localhost:8080/cliente/1</p>
</br>
</br>
<h3>💻​ Produto</h3>
<h4>POST de produto:</h4>
<p>http://localhost:8080/produto</p>
<p>Body: {
    "nome": "nokia 2010",
    "preco": 700.00,
    "descricao": "Alta capacidade de bateria",
    "quantidade": 5

}</p>

<h4>GET ALL de produtos:</h4>
<p>http://localhost:8080/produto</p>

<h4>GET produto específico</h4>
<p>http://localhost:8080/produto/1</p>

<h4>PUT de produto:</h4>
<p>http://localhost:8080/produto/1</p>
<p>Body: {
        "nome": "samsung s21",
        "preco": 1700.99,
        "descricao": "celular última geração 8GB RAM",
        "quantidade": 50
}</p>

<h4>DELETE de produto:</h4>
<p>http://localhost:8080/produto/1</p>
</br>
</br>
<h3>📑​ Nota Fiscal</h3>
<h4>POST de nota fiscal:</h4>
<p>http://localhost:8080/notaFiscal</p>
<p>Body: {
  "numeroNotaFiscal": 215,
  "codigoCliente": 2,
  "itens": [
    {
      "produtoId": 6,
      "quantidade": 2
    }
  ]
}</p>

<h4>GET ALL de nota fiscal:</h4>
<p>http://localhost:8080/notaFiscal</p>

<h4>GET nota fiscal específica</h4>
<p>http://localhost:8080/notaFiscal/1</p>

<h4>PUT de nota fiscal:</h4>
<p>http://localhost:8080/notaFiscal/1</p>
<p>Body: [
  {
    "produtoId": 9,
    "quantidade": 2,
    "precoUnitario": 1518.00
  }]</p>

<h4>DELETE de nota fiscal:</h4>
<p>http://localhost:8080/notaFiscal/1</p>
