# Leitor de CPF de arquivo de extensão csv

## Argumento
  --csv.path = caminho do arquivo csv; <br/>
  --server.port = porta do servidor, por padrão estará na 8085;
  
  
## Endpoint
 * `cpfs` =  GET - Retorna a lista de CPF. <br/>
 
 Exemplo: 
    http://localhost:8085/api/cpfReader/cpfs

## Execução
Abra o prompt de comando ou shell na raiz do projeto e faça a seguinte instrução: `mvnw clean package && java -jar target/cpfReader-0.0.1.jar --csv.path=<Caminho do arquivo csv>`. 
<br/>

Exemplo: <br/>
 <b>java -jar target/cpfReader-0.0.1.jar --csv.path="C:\projetos\arquivos\cadastro-candidatos.csv"</b>

