# Chamados-Delas
*Sistema de atendimento de chamados - projeto final ElasTech SoulCode*

## 📖 Sobre o Projeto

Bem-vindo ao repositório **CHAMADO DELAS**! Este projeto foi desenvolvido para fornecer uma solução completa de gerenciamento de chamados técnicos, permitindo que usuários solicitem assistência e técnicos gerenciem esses chamados de forma eficiente.

## 💡 Funcionalidades
### 📘 Tela Inicial
- Descrição: A tela inicial apresenta uma breve introdução ao sistema de chamados técnicos, explicando suas funcionalidades e benefícios.
- Imagens: Exibe imagens ilustrativas do sistema para familiarizar o usuário com a interface.
- Desenvolvedores: Inclui uma seção com informações sobre os desenvolvedores do projeto.
### 🔐 Tela de Login
- Login e Cadastro: Permite que usuários e técnicos façam login no sistema ou se cadastrem, caso ainda não possuam uma conta.
- Verificação de Login: Apenas usuários registrados podem acessar o sistema. Novos usuários devem se cadastrar para obter acesso.
- Banco de Dados: Utiliza o banco de dados MySQL para armazenar e gerenciar as informações de login e cadastro.
### 👤 Tela do Usuário
- Informações do Usuário: Exibe os dados do usuário logado em uma área visível da tela.
- Visualização de Chamados: Permite ao usuário visualizar todos os chamados que ele criou anteriormente.
  
  - Detalhes dos Chamados: Cada chamado exibido inclui informações como:
    - Nome do Usuário
    - Setor
    - Descrição do Problema
    - Prioridade (Baixa, Média, Alta)
    - Data de Início
    - Outros detalhes relevantes
      
- Criação de Novos Chamados: O usuário pode criar novos chamados através de um formulário.
  - Campos do Formulário: O formulário deve ser detalhado e incluir campos como:
    - Nome do Usuário
    - Setor
    - Descrição do Problema
    - Prioridade (Baixa, Média, Alta)
    - Data de Início
    - Outros detalhes importantes
  - Cadastro no Banco de Dados: Os dados dos novos chamados são enviados e registrados no banco de dados MySQL.

### 🛠️ Tela do Técnico
- Visualização de Chamados Disponíveis: O técnico pode ver uma lista de chamados que ainda não foram atribuídos.
- Chamados Atribuídos: Exibe os chamados que já estão atribuídos ao técnico.
- Detalhes do Chamado: Ao clicar em um chamado, o técnico pode visualizar todas as informações detalhadas do chamado.
- Modificação de Status: O técnico pode atualizar o status do chamado para uma das seguintes opções:
   - "Aguardando técnico"
   - "Em atendimento"
   - "Escalado para outro setor"

### 📊 Painel Administrativo
- Visão Geral do Sistema: Oferece uma visão abrangente do uso do sistema com dados essenciais.
  - Número de Chamados: Exibe estatísticas sobre o número de chamados em aberto, em execução e aguardando.
- Gerenciamento de Elementos-Chave:
  - Setores da Empresa: Permite o gerenciamento e cadastro de setores.
  - Tipos de Prioridade: Permite a definição e gerenciamento dos diferentes níveis de prioridade dos chamados.
- Flexibilidade e Adaptabilidade: Possibilita o cadastramento e atualização de informações vitais, adaptando-se às necessidades do ambiente corporativo.

## 💻 Tecnologias Utilizadas
- Frontend: Desenvolvido utilizando HTML, CSS(Tailwind) e JavaScript para criar uma interface intuitiva e interativa para os usuários.
- Backend: Desenvolvido com Java e Spring para gerenciar as rotas e a lógica do servidor, proporcionando uma base sólida e escalável para o sistema.
- Banco de Dados: Utilizado MySQL para armazenar informações dos chamados e usuários, garantindo segurança e eficiência na gestão dos dados.
- Autenticação: Sistema de autenticação para garantir a segurança e a privacidade dos dados dos usuários.

## 🤝 Participantes
- Alyce Quegi
- Érica Vieira
- Giulia Faria
- Jéssica Leite
- Julia Domingues
