# Web Service Exemplo

## Descrição
Este projeto é um exemplo de web service desenvolvido com Spring Boot. Ele permite processar dados e realizar consultas externas a uma API de previsão do tempo.

## Como executar

1. **Pré-requisitos**:
   - Docker
   - Java 11

2. **Rodando com Docker**:
   - Execute o comando: `docker-compose up --build`

3. **Endpoints**:
   - `GET /api/consulta`: Realiza uma consulta externa à API de previsão do tempo.
   - `POST /api/processar`: Recebe dados JSON e retorna um processamento.
   - `GET /api/sobre`: Exibe informações sobre o projeto.

## Exemplo de Requisição e Resposta

### Requisição POST /api/processar
```json
{
  "origem": "São Paulo",
  "destino": "Rio de Janeiro"
}
