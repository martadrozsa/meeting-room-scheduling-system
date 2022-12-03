
start project 
docker-compose up
para criar os schemas e depois quando subir o projeto


## TODO:

- DONE [**ms-funcionario**] Conectando com base real
- [**ms-funcionario**] Configuração do banco de dados deve vir do proj-config


- DONE [**ms-sala**] Conectando com base real
- [**ms-sala**] Configuração do banco de dados deve vir do proj-config


- DONE [**ms-agenda**] Conectando com base real
- [**ms-agenda**] Endpoint de POST pra criar agendamento de acordo com as business rules
- [**ms-agenda**] Endpoint de GET pra buscar agendamento de acordo com as business rules

- [extra] Tratamento de erro nos ms

- [**ms-eureka**] Todos os serviços estarem configurados pra se registrar no Eureka
- [**ms-eureka**] Todos os serviços que se comunicam com outros serviços, usar o Eureka pra descobrir o endereço dos
  serviços
    - ms-agenda se comunica com o ms-funcionario, ms-sala e proj-config
    - ms-gateway se comunica com os ms de domínio


- [**ms-config**] Tem que fornecer a configuração de banco que será consumida pelos ms


- [**ms-gateway**] Expõe todos os endpoints dos microserviços. Configurar as rotas e hosts pra expor os endpoints
    - Criar collection no postman pra testar. Gerar os curls e fornecer no trabalho.

### O projeto atual

1. Serviço de ms-funcionario, que permite a realização do CRUD.

    * Atualmente a configuração do banco de dados está para o H2 no próprio serviço
    * Deverá ser alterado a configuração do banco para utilizar do proj-config

2. Serviço de ms-sala, permite a realização do CRUD
    * Atualmente a configuração do banco de dados está para o H2 no próprio serviço
    * Deverá ser alterado a configuração do banco para utilizar do proj-config

3. Serviço de ms-agenda, deverá ser desenvolvido. Apenas consta a informação do Model e DTO (deverá ser exibido no retorno e inclusão dos serviços).  
   Deverá conter dois endpoints:
    1. inclusão com method POST
    2. listar todos method GET

> ### *Atenção*
> Observe que neste serviço de ms-agenda é fundamental que exista uma comunicação com os outros servios (sala e funcionário)


4. O ms-eureka não está configurado, será necessário configurar o serviço e alterar os serviços existentes para que se registrem

> ### *Atenção*
> Configure o ms-agenda, ms-funcionario, ms-sala e proj-gateway para registrar o **Eureka**  
> Utilize a porta padrão do Eureka 8761  
> Para acesso via browser use http://localhost:8761/eureka  
> Para acesso via Postman use http://localhost:8761/eureka/apps

5. O ms-config deverá conter a configuração de banco de dados de todos os demais serviços. Pode ser utilizado qualquer banco de dados relacional.
> ### *Atenção*
> As tabelas do banco de dados não possuiem relações, pois a ideia é simular bases de dados distribuídas.   
> Portanto, você pode usar mais de um banco de dados

6. O ms-gateway deverá ser configurado para exibir os endpoints dos microserviços como se fosse um só, portanto o ms-funcionario, ms-agenda e ms-sala devem está acessíveis apartir do endereço do gateway.

## Critérios
1. Organização do código - 2 pontos
2. Todos os serviços funcionando e configurados para trabalharem em conjunto - 4 pontos
3. Atender os endpoints solicitados com o formato solicitado de inclusão e resposta (AgendaDTO) - 4 pontos

Pontos extras
1. Utilizar mais de um banco de dados
2. Desenvolver tratamento de erros nos erros nos endpoints solicitados
