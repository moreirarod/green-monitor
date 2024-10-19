# Green Monitor
## Descrição do Projeto

**Green Monitor** é um projeto em Java utilizando Spring Boot para monitoramento de dados, containerizado com Docker e configurado para CI/CD utilizando GitHub Actions.

## Pré-requisitos

Certifique-se de ter os seguintes itens instalados antes de iniciar o projeto:

- Java 21 (JDK)
- Maven (para build do projeto)
- Docker e Docker Compose
- Conta no Docker Hub para armazenar imagens Docker
- Git para controle de versão

## Como inicializar e executar o projeto
### Clonar o Repositório
    
    git clone https://github.com/usuario/green-monitor.git
    cd green-monitor

### Compilar o Projeto

Compile o projeto utilizando o Maven:

    mvn clean package

### Executar com Docker

Para rodar o projeto utilizando Docker, siga os passos abaixo:

1. **Build da Imagem Docker:**

        docker build -t rfariam/green-monitor:latest .

2. **Executar o Projeto com Docker Compose: Certifique-se de que o docker-compose.yml está configurado corretamente:**

        docker-compose up -d

3. **Acessar a Aplicação:** A aplicação estará disponível em http://localhost:3000.

### Variáveis de Ambiente

As seguintes variáveis de ambiente são necessárias para o funcionamento do projeto:

- DATABASE_URL: URL do banco de dados.
- DOCKER_HUB_USERNAME: Usuário do Docker Hub para autenticação.
- DOCKER_HUB_PASSWORD: Senha ou Token de acesso ao Docker Hub.

### Testes

Para executar os testes do projeto, utilize:

    mvn test

## CI/CD com GitHub Actions

O projeto possui um pipeline de CI/CD configurado para:

- Compilar e construir a imagem Docker.
- Fazer o push da imagem para o Docker Hub.
- Implantar a aplicação nos ambientes staging e production automaticamente.

Os arquivos de configuração do pipeline estão localizados em:

- .github/workflows/ci-cd.yml

## Contribuição

1. Faça um fork do projeto.
2. Crie uma nova branch (git checkout -b feature/nova-feature).
3. Commit suas mudanças (git commit -m 'Add nova feature').
4. Faça um push para a branch (git push origin feature/nova-feature).
5. Abra um Pull Request.

## Autor

Rodrigo Faria Moreira
