# Histórias de Usuário

## Histórias de Usuário

### US1 - Consultar pedido de aluguel

*Como* cliente,  
*Quero* consultar pedidos de aluguel,  
*Para* checar o status dos meus pedidos e verificar se o contrato foi executado.  

**Critérios de aceitação:**
- O cliente deve poder visualizar uma lista de todos os seus pedidos de aluguel.
- O cliente deve ser capaz de ver detalhes específicos de cada pedido, incluindo status (em análise, aprovado, cancelado).
- O cliente deve ser capaz de filtrar os pedidos por data, status e tipo de automóvel.
- O cliente deve poder ver um histórico de alterações feitas ao pedido.

### US2 - Avaliar pedidos

*Como* agente,  
*Quero* avaliar pedidos de aluguel,  
*Para* decidir se o contrato deve ser aprovado ou não e realizar a execução do contrato quando aprovado.  

**Critérios de aceitação:**
- O agente deve poder visualizar a lista de pedidos pendentes de avaliação.
- O agente deve ter acesso a todos os detalhes financeiros e pessoais relevantes para a avaliação.
- O agente deve poder aprovar ou rejeitar um pedido e registrar observações ou motivos para a decisão.
- O sistema deve atualizar o status do pedido com base na decisão do agente (aprovado, rejeitado).
- O sistema deve notificar o cliente sobre a decisão.

### US3 - Modificar pedido de aluguel

*Como* cliente,  
*Quero* modificar um pedido de aluguel,  
*Para* ajustar detalhes como data de início, data de término ou tipo de automóvel, conforme necessário.  

**Critérios de aceitação:**
- O cliente deve poder editar um pedido existente, com exceção dos dados que não podem ser alterados (por exemplo, informações já processadas).
- O sistema deve permitir que o cliente faça alterações apenas se o pedido ainda não foi avaliado pelos agentes.
- O cliente deve ser notificado das mudanças e o pedido deve ser reavaliado se necessário.
- O sistema deve mostrar um resumo das alterações feitas.

### US4 - Cancelar pedido de aluguel

*Como* cliente,  
*Quero* cancelar um pedido de aluguel,  
*Para* cancelar um pedido que não será mais necessário.  

**Critérios de aceitação:**
- O cliente deve poder solicitar o cancelamento de um pedido que ainda não foi avaliado ou aprovado.
- O sistema deve permitir o cancelamento e atualizar o status do pedido para "Cancelado".
- O cliente deve receber uma confirmação de que o pedido foi cancelado.
- O sistema deve registrar o motivo do cancelamento, se fornecido pelo cliente.

### US5 - Registrar novo automóvel

*Como* agente,  
*Quero* registrar um novo automóvel no sistema,  
*Para* que ele possa ser disponibilizado para aluguel pelos clientes.  

**Critérios de aceitação:**
- O agente deve ser capaz de inserir dados do automóvel, incluindo matrícula, ano, marca, modelo e placa.
- O sistema deve validar que os dados inseridos são únicos e corretos.
- O automóvel registrado deve aparecer como disponível para aluguel.
- O sistema deve permitir a edição dos dados do automóvel após o registro, se necessário.

### US6 - Conceder contrato de crédito

*Como* banco (agente),  
*Quero* conceder um contrato de crédito associado a um pedido de aluguel,  
*Para* permitir ao cliente financiar o aluguel do automóvel.  

**Critérios de aceitação:**
- O banco deve poder visualizar pedidos que necessitam de contrato de crédito.
- O banco deve ter acesso a informações financeiras do cliente para avaliar o crédito.
- O banco deve poder conceder ou recusar o crédito e registrar a decisão.
- O sistema deve associar o contrato de crédito aprovado ao pedido de aluguel e notificar o cliente.
