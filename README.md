# Digital Business Enablement

Uma API para o sistema de avaliação de empresas e negócios.

## Endpoints
- Conta
    - [Sign up](#sign-up)
    - [Log in](#log-in)
    - [Excluir registro](#excluir-conta)
    - [Detalhes](#detalhes-conta)
- 
### Sign up
---
`POST` /techbridge/api/conta

*Campos de requisição*

| campo | tipo | obrigatório | descrição|
| - |-|:-:|-|
| email | texto | sim | email da conta|
| senha | texto | sim | senha da conta|
| nome | texto | sim | nome do usuário|
| contaId | inteiro | sim | id da conta|

*Exemplo de requisição*
```
{
    email: exemplo@exemplo.com,
    senha: 123456789,
    senhaConfirmar: 123456789,
    nome: Fulano,
    contaId: 1
}
```

*Resposta*
| código | descrição 
|-|-
|201| o usuário foi cadastrado
|400| email inválido
|400| senhas inválidas
|400| senhas não coincidem

### Log in
---
`GET` /techbridge/api/conta/login

*Campos de requisição*

| campo | tipo | obrigatório | descrição|
| - |-|:-:|-|
| email | texto | sim | email da conta|
| senha | texto | sim | senha da conta|

*Exemplo de requisição*
```
{
    email: exemplo@exemplo.com,
    senha: 123456789
}
```

*Resposta*
| código | descrição 
|-|-
|200| dados de login encontrados e validados
|400| email inválido
|401| conta não encontrada

### Excluir conta
---
`DELETE` /techbridge/api/conta/excluir

*Campos de requisição*

| campo | tipo | obrigatório | descrição|
| - |-|:-:|-|
|contaId| inteiro | sim | id da conta|
|senha | texto | sim | senha da conta|

*Exemplo de requisição*
```
{
    contaId: 1,
    senha: 123456789
}
```

*Resposta*
| código | descrição 
|-|-
|200| conta apagada
|401| senha incorreta

### Detalhes registro
---

`GET` /techbridge/api/conta/{id}

*Campos de requisição*

| campo | tipo | obrigatório | descrição|
| - |-|:-:|-|
|contaId| inteiro | sim | id da conta|

*Exemplo de resposta*
```
{
    email: exemplo@exemplo.com,
    nome: Fulano,
    contaId: 1
}
```

*Resposta*
| código | descrição 
|-|-
|200| os dados foram retornados |
|404| nao foi encontrada uma conta com esse ID |
