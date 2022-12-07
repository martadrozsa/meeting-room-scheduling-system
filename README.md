Ordem para subir os serviços
Config-server
Eureka
Gateway
Room
Employee
Scheduler

Eureka - servidor onde os microsserviços se registram, pode ser em portas aleatórias
o servidor eureka trata de registrar todas as instâncias, caso seja mais de uma, e quando precisamos do microsserviço, chamamos apenas pelo nome dele
as configs de portas e localicação são automáticas 



- service-discovery nos ajuda a encontrar serviços para que possamos, de forma dinâmica, fazer as requisições para instâncias efêmeras (pouca duração)
novas máquinas com ips e portas diferentes são criadas e destruídas o tempo todo.

-o serviçe discovery nos proverá um repositório atualizado de todas as máquinas onlibe disponíveis para que possamos fazer nossas requisições
para que o projeto seja apenas servidor e não cliente
deve-se colocar essas duas confis


serviços que precisar descobrir outros serviços e serviços que precisam ser descobertos se registam no eureka
se tornando eureka-client
eureka-server monitora os serviços e as instâncias

por exemplo: quando ms-agenda precisa descobrir se tem salas vagas para criar um agendamento,
ele envia para o eureka o nome do ms-sala e assim o eureka retorna para o ms-agenda o endereço do ms-sala (host e porta)


## TODO:

- DONE [**ms-funcionario**] Conectando com base real
- DONE [**ms-funcionario**] Configuração do banco de dados deve vir do proj-config

- DONE [**ms-sala**] Conectando com base real
- DONE [**ms-sala**] Configuração do banco de dados deve vir do proj-config


- DONE [**ms-agenda**] Conectando com base real
- DONE [**ms-agenda**] Endpoint de POST para criar agendamento de acordo com as business rules
- DONE [**ms-agenda**] Endpoint de GET para buscar agendamento de acordo com as business rules

- DONE [extra] Tratamento de erro nos ms

- DONE [**ms-eureka**] Todos os serviços estarem configurados para se registrar no Eureka
- DONE [**ms-eureka**] Todos os serviços que se comunicam com outros serviços, usar o Eureka para descobrir o endereço dos serviços
    - DONE [**ms-agenda**] se comunica com o ms-funcionario, ms-sala e proj-config
    - DONE [**ms-gateway**] se comunica com os ms de domínio

- DONE [**ms-config**] Tem que fornecer a configuração de banco que será consumida pelos ms


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
