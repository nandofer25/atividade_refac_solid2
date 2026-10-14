# API de Livros — versão refatorada com SOLID

Projeto Spring Boot com Java 21, Spring Data JPA e banco H2 em memória.

## Endpoints
- `GET /livros`: lista os livros.
- `POST /livros`: cadastra um livro.
- `PUT /livros/{id}`: atualiza um livro.
- `DELETE /livros/{id}`: remove um livro (livros da categoria `RARO` não podem ser removidos).

Exemplo de cadastro:
```json
{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "preco": 120.0,
  "categoria": "TECNOLOGIA"
}
```

## Organização
- `controllers`: endpoints HTTP e tratamento de erros.
- `contracts`: interfaces e contratos.
- `entities`: entidade JPA `Livro`.
- `repositories`: acesso aos dados.
- `services`: regras de negócio, relatórios e e-mail.
- `services/descontos`: estratégias de desconto por categoria.

## SOLID aplicado
- **SRP (Responsabilidade Única):** controller, serviço de livros, descontos, relatório, e-mail, ERP e etiquetas têm responsabilidades separadas.
- **OCP (Aberto/Fechado):** `DescontoService` recebe uma lista de `PoliticaDesconto`. Para adicionar uma categoria, crie uma nova implementação e não altere o serviço central.
- **LSP (Substituição de Liskov):** cada estratégia de desconto implementa `PoliticaDesconto` e pode ser usada pelo serviço sem alterar seu fluxo.
- **ISP (Segregação de Interfaces):** contratos separados para livros, relatórios, e-mail, ERP e etiquetas; cada implementação assume apenas o contrato correspondente.
- **DIP (Inversão de Dependência):** o Spring injeta dependências por construtor; o mecanismo de desconto depende da abstração `PoliticaDesconto`, não de classes concretas.

## Regras mantidas
- Título obrigatório e preço maior que zero.
- Descontos no cadastro: ROMANCE 10%, TECNOLOGIA 20%, INFANTIL 30%, HQ 40%.
- Atualização não reaplica desconto automaticamente.
- Livros da categoria `RARO` não podem ser removidos.
- PDF, ERP e etiquetas continuam explicitamente não implementados; agora estão isolados em serviços próprios.

## Executar
Abra o projeto no IntelliJ com JDK 21 e execute `AtividadeRefacApplication`.
O banco H2 é em memória e reinicia com a aplicação.
