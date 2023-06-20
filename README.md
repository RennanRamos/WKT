# WKT
<h3>
  Versões:
</h3>

Java versão 17;

<br/>

NPM versão 9.5.1;

<br/>

Node versão 18.16.0;

<br/>

<h3>
  Intalação/Execução:
</h3>

Ter o MySql funcionando localmente (https://dev.mysql.com/downloads/installer/) pagina do dowload do MySql.

Fazer o clone do projeto `git clone git@github.com:RennanRamos/WKT.git`.

Abrir o projeto na sua IDE de preferência.

<br/>

<h3>
Passos execução Spring/Java:
</h3>

No arquivo application.properties `WKT/WKT-Spring/src/main/resources/application.properties` insira as suas configurações de banco geradas no MySql.

<br/>

Exemplo de como deve ficar a configuração:

<br/>

`spring.datasource.url=jdbc:mysql://localhost:3306/seuDB?allowPublicKeyRetrieval=True&useSSL=false&serverTimezone=UTC`

<br/>

`spring.datasource.username=SeuUser`

<br/>

`spring.datasource.password=SuaSenha`

<br/>

Após vá no arquivo WktApplication.java `WKT/WKT-Spring/src/main/java/com/rennan/wkt/WktApplication.java` 
e insira o caminho absoludo do JSON `WKT/WKT-Spring/src/main/resources/json/data_1.json` na linha 36.

Feito isso execute o seu projeto Spring na IDE ou use `npm install` e depois `mvn spring-boot:run`.

<br/>

<h3>
Passos execução Angular/TypeScript:
</h3>

Na raiz do seu projeto angular `WKT/WKT-Angular` em um terminal execute o comando `npm install` para instalar as dependências.

Feito isso use o `npm run start` para executar seu projeto angular e acesse o `http://localhost:4200` para verificar a aplicação.






