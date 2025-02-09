# ExamSimulator

ExamSimulator é uma aplicação web open source para cadastro e execução de simulados para provas de certificação na área de TI. O sistema oferece recursos como simulação de exames, histórico de desempenho com gráficos de evolução, curadoria de questões, gamificação, relatórios administrativos e integrações com serviços gratuitos (como APIs de IA, analytics, doações e anúncios).

## Índice
- [Visão Geral](#visão-geral)
- [Funcionalidades](#funcionalidades)
- [Arquitetura](#arquitetura)
- [Backlog e Próximos Passos](#backlog-e-próximos-passos)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Visão Geral

O objetivo do ExamSimulator é ajudar usuários a se prepararem para exames de certificação em TI por meio de simulados realistas, feedback detalhado e acompanhamento do desempenho ao longo do tempo. O sistema oferece uma interface intuitiva (frontend em português) e uma API robusta (código em inglês) construída com boas práticas de desenvolvimento, incluindo TDD, SOLID e Clean Code.

## Funcionalidades

- **Módulo de Usuários:**
    - Cadastro e autenticação com verificação via e-mail.
    - Gerenciamento de perfil e histórico de certificações.
    - Integração com gamificação (níveis, pontos e badges).

- **Módulo de Simulados e Exames:**
    - Criação e gerenciamento de simulados por administradores.
    - Associação de exames a categorias e certificações.
    - Execução de simulado com registro de tentativas e feedback detalhado.

- **Módulo de Questões e Curadoria:**
    - Envio de novas questões pelos usuários.
    - Área de curadoria para revisão e aprovação das questões.
    - Geração de feedback automatizado via IA e manual durante a curadoria.

- **Histórico e Análise de Desempenho:**
    - Registro de tentativas (Attempt e AttemptHistory).
    - Geração de gráficos de evolução e relatórios de desempenho.

- **Módulo Administrativo:**
    - Dashboard para gerenciamento de simulados, usuários e conteúdos.
    - Relatórios detalhados de acessos, desempenho e análises.
    - Área para doações e integração de anúncios.

## Arquitetura

A aplicação é estruturada em módulos para facilitar a manutenção e a expansão futura:

- **Backend:**  
  Desenvolvido em Kotlin com Spring Boot, seguindo TDD, SOLID e Clean Code.  
  Utiliza MySQL como banco de dados e integra serviços gratuitos para IA, analytics, doações e anúncios.

- **Frontend:**  
  Interface web responsiva construída com HTML, CSS e JavaScript (framework a definir), totalmente em português.

- **Camadas:**
    - **Apresentação:** Interface responsiva para interação com o usuário.
    - **API:** Conjunto de endpoints REST que expõem as funcionalidades do sistema.
    - **Negócio:** Serviços que encapsulam as regras de negócio (ex.: cálculo de score, validação de respostas, curadoria de questões).
    - **Persistência:** Repositórios utilizando Spring Data JPA para acesso ao MySQL.
    - **Integração:** Módulos para integração com APIs de IA, ferramentas de analytics, plataformas de doações e redes de anúncios.

## Backlog e Próximos Passos

### Fase 1: Finalização da Modelagem e Validação
- [ ] Revisar e consolidar as entidades principais: `User`, `Question`, `Answer`, `Exam`, `Category`, `Certification`, `Attempt`, `AttemptHistory`, `History`, `Review`, `Report`.
- [ ] Implementar validadores usando Bean Validation (`@NotNull`, `@Size`, `@Email`, etc.).
- [ ] Adicionar controle de concorrência com `@Version` nas entidades críticas.

### Fase 2: Configuração do Projeto e Infraestrutura
- [ ] Configurar o repositório no GitHub e estabelecer CI/CD com ferramentas gratuitas.
- [ ] Configurar o ambiente de desenvolvimento com Spring Boot, MySQL e o framework de frontend escolhido.
- [ ] Criar Dockerfiles para facilitar a implantação (opcional).
- [ ] Integrar serviços gratuitos para analytics, IA, doações e anúncios.

### Fase 3: Desenvolvimento dos Módulos Centrais
- **Usuários:**
    - [ ] Implementar cadastro, login, verificação de e-mail e recuperação de senha.
    - [ ] Expandir o perfil do usuário com dados para gamificação (nível, pontos, badges).
- **Simulados e Exames:**
    - [ ] Desenvolver funcionalidades de criação, gerenciamento e execução de simulados.
    - [ ] Registrar tentativas e calcular score, progresso e feedback.
- **Questões e Curadoria:**
    - [ ] Implementar envio de questões pelos usuários e fluxo de curadoria.
    - [ ] Integrar IA para gerar explicações automáticas e permitir edições manuais.
- **Histórico e Análise:**
    - [ ] Implementar o registro de tentativas e geração de gráficos de evolução.
    - [ ] Desenvolver relatórios detalhados e dashboards administrativos.

### Fase 4: Desenvolvimento da Área Administrativa e Funcionalidades Extras
- [ ] Criar dashboards para gerenciamento de simulados, usuários e conteúdos.
- [ ] Integrar ferramentas de analytics para monitoramento de acessos e desempenho.
- [ ] Implementar a área de doações e integração com redes de anúncios.
- [ ] Desenvolver sistema de notificações (por e-mail ou push notifications).

### Fase 5: Testes, Documentação e Deploy
- [ ] Escrever testes unitários e de integração seguindo TDD.
- [ ] Realizar testes de usabilidade e performance.
- [ ] Documentar a API e criar um guia de contribuição para o GitHub.
- [ ] Implantar a aplicação em ambiente de produção e monitorar o desempenho.

## Contribuição

Contribuições para o ExamSimulator são bem-vindas!  
Consulte nosso [Guia de Contribuição](CONTRIBUTING.md) para mais detalhes sobre como contribuir com o projeto.

## Licença

Este projeto é licenciado sob a [Licença MIT](LICENSE).