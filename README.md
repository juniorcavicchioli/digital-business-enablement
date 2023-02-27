# Digital Business Enablement

Uma API para o sistema de avaliação de empresas e negócios.

## Endpoints
- Conta
    - [Sign up](#sign-up)
    - [Log in](#log-in)
    - [Excluir conta](#excluir-conta)
    - [Detalhes](#detalhes-conta)
- Empresa
    - [Cadastrar](#cadastrar-empresa)
    - [Detalhes](#detalhes-empresa)
- Avaliação
    - [Criar](#criar-avaliacao)
    - [Excluir](#excluir-avaliacao)
    - [Editar](#editar-avaliacao)
    - [Julgar](#julgar-avaliacao)
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
    email: 'exemplo@exemplo.com',
    senha: '123456789',
    senhaConfirmar: '123456789',
    nome: 'Fulano',
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
    email: 'exemplo@exemplo.com',
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
    senha: '123456789'
}
```

*Resposta*
| código | descrição 
|-|-
|200| conta apagada
|401| senha incorreta

### Detalhes conta
---

`GET` /techbridge/api/conta/{id}

*Campos de requisição*

| campo | tipo | obrigatório | descrição|
| - |-|:-:|-|
|contaId| inteiro | sim | id da conta|

*Exemplo de resposta*
```
{
    email: 'exemplo@exemplo.com',
    nome: 'Fulano',
    contaId: 1
}
```

*Resposta*
| código | descrição 
|-|-
|200| os dados foram retornados |
|404| nao foi encontrada uma conta com esse ID |

### Cadastrar empresa
---
`POST` /techbridge/api/empresa

*Campos de requisição*

| campo | tipo | obrigatório | descrição|
| - |-|:-:|-|
razaoSocial| texto | sim | nome social da empresa
nome | texto | nao | nome oficial da empresa
ramo | texto | sim | ramo de atuação da empresa
CNPJ | texto | nao | CNPJ da empresa
endereco | texto | nao | endereco da empresa
empresaId | inteiro | sim | ID da empresa

*Exemplo de requisição*
```
{
    razaoSocial: 'The Code of Duty',
    nome: 'Techbridge LTDA'
    ramo: 'Consultoria de TI',
    CNPJ: '12.345.678/0001-00',
    endereco: 'Rua Advanced Warfare, 1, São Paulo-SP, 12345-123',
    empresaId: 2
}
```

*Resposta*
| código | descrição 
|-|-
|201| empresa cadastrada
|400| empresa já cadastrada

### Detalhes empresa
---

`GET` /techbridge/api/empresa/{id}

*Campos de requisição*

| campo | tipo | obrigatório | descrição|
| - |-|:-:|-|
|empresaId| inteiro | sim | id da empresa|

*Exemplo de resposta*
```
{
    razaoSocial: 'The Code of Duty',
    nome: 'Techbridge LTDA'
    ramo: 'Consultoria de TI',
    CNPJ: '12.345.678/0001-00',
    endereco: 'Rua Advanced Warfare, 1, São Paulo-SP, 12345-123',
    empresaId: 2
}
```

*Resposta*
| código | descrição 
|-|-
|200| os dados foram retornados |
|404| nao foi encontrada uma conta com esse ID |


### Criar avaliacao

`POST` /techbridge/api/avaliacao

*Campos de requisição*

| campo | tipo | obrigatório | descrição|
| - |-|:-:|-|
contaId | inteiro | sim | ID da conta que está avaliando
nota | inteiro | sim | avaliação do usuário sobre a empresa
comentario | texto | nao | justificativa para a nota dada pelo usuário
empresaId | inteiro | sim | ID da empresa avaliada
julgamento | inteiro | sim | Status atual da avaliação julgada por outros usuários
avaliacaoId| inteiro | sim | ID da avaliação

*Exemplo de requisição*
```
{
    contaId: 1,
    nota: 4,
    comentario: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit',
    empresaId: 2,
    julgamento: 0,
    avaliacaoId: 3
}
```

*Resposta*
| código | descrição 
|-|-
|201| o usuário foi cadastrado
|400| campos obrigatórios não preenchidos|
|401| usuário já possui uma avaliação feita

### Excluir avaliacao
---
`DELETE` /techbridge/api/avaliacao/excluir

*Campos de requisição*

| campo | tipo | obrigatório | descrição|
| - |-|:-:|-|
|contaId| inteiro | sim | id da conta|
|avaliacaoId| inteiro | sim | id da avaliação

*Exemplo de requisição*
```
{
    contaId: 1,
    avaliacaoId: 3
}
```

*Resposta*
| código | descrição 
|-|-
|200| avaliação apagada
|401| usuário não autorizado a apagar avaliação

### Editar avaliacao

`PUT` /techbridge/api/avaliacao/editar

*Campos de requisição*

| campo | tipo | obrigatório | descrição|
| - |-|:-:|-|
avaliacaoId| inteiro | sim | ID da avaliação
contaId | inteiro | sim | ID da conta que está avaliando
novoComentario | texto | nao | nova justificativa para a nota dada pelo usuário
novaNota | inteiro | nao | nova avaliação do usuário sobre a empresa

*Exemplo de requisição*
```
{
    avaliacaoId: 3,
    contaId: 1,
    novoComentario: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit',
    novaNota: 5
}
```

*Resposta*
| código | descrição 
|-|-
|200| Avaliação editada
|401| usuário não autorizado
|400| nenhum campo preenchido

### Julgar avaliacao
---
Aumenta ou diminui o julgamento de uma avaliação

`PUT` /techbridge/api/avaliacao/julgar

*Campos de requisição*

| campo | tipo | obrigatório | descrição|
| - |-|:-:|-|
avaliacaoId| inteiro | sim | ID da avaliação que está sendo julgada
contaId | inteiro | sim | ID da conta que está julgando

*Exemplo de requisição*
```
{
    avaliacaoId: 3,
    contaId: 1,
}
```

*Resposta*
| código | descrição 
|-|-
|200| Avaliação julgada
|200| Julgamento removido