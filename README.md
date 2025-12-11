# ChefAI — Sugestor de Receitas Inteligente

### Sobre o projeto

* O ChefAI é um sistema desenvolvido em Java, utilizando o BlueJ, com o objetivo de sugerir receitas rápidas (até 30 minutos) com base nos ingredientes informados pelo usuário.
* O projeto foi criado como atividade prática para aplicar os conceitos de Programação Orientada a Objetos (POO) e integração com APIs de Language Models (LLMs), utilizando boas práticas de organização de código e segurança.

### Objetivos do sistema

* Ajudar usuários a aproveitarem melhor os ingredientes disponíveis
* Sugerir até 3 receitas rápidas
* Considerar restrições alimentares
* Demonstrar a aplicação prática de POO

### Conceitos de POO aplicados
* Encapsulamento
* Abstração
* Herança
* Polimorfismo
* Composição

### Exemplos no projeto:

User, Ingredient e Recipe → encapsulamento

User contém lista de Ingredient → composição

SuggestorBase → abstração

SuggestorRapido e SuggestorSaudavel → herança

LLMClient + MockLLMClient → polimorfismo

### Diagrama de Classes

```mermaid
classDiagram
    %% Entidades Principais
    class User {
        -String nome
        -List~Ingredient~ ingredients
        -String dietaryRestriction
        +addIngredient(Ingredient) void
        +getIngredients() List~Ingredient~
        +setDietaryRestriction(String) void
        +getDietaryRestriction() String
    }
    
    class Ingredient {
        -String name
        -int quantity
        -String unit
        +getDetails() String
        +getName() String
        +getQuantity() int
    }
    
    class Recipe {
        -String title
        -int estimatedTime
        -List~String~ steps
        -List~Ingredient~ ingredients
        -String category
        +displayRecipe() void
        +getTitle() String
        +getEstimatedTime() int
    }
    
    %% Sistema de Sugestão
    class SuggestorBase {
        <<abstract>>
        -LLMClient llmClient
        +suggestRecipes(User) List~Recipe~*
        #formatPrompt(User) String
        #processResponse(String) List~Recipe~
    }
    
    class SuggestorRapido {
        +suggestRecipes(User) List~Recipe~
        -filterQuickRecipes(List~Recipe~) List~Recipe~
    }
    
    class SuggestorSaudavel {
        +suggestRecipes(User) List~Recipe~
        -validateHealthyRecipe(Recipe) boolean
        -calculateNutrients(Recipe) Map
    }
    
    %% Integração com LLM
    class LLMClient {
        <<interface>>
        +generateSuggestion(String prompt) String*
        +configureAPI(String key) void
    }
    
    class RealLLMClient {
        -String apiKey
        -String endpoint
        +generateSuggestion(String prompt) String
        +validateConnection() boolean
    }
    
    class MockLLMClient {
        -List~String~ mockResponses
        +generateSuggestion(String prompt) String
        +addMockResponse(String) void
    }
    
    %% Gerenciamento de Configuração
    class Configuration {
        -Properties properties
        -String configFile
        +loadConfig() void
        +getProperty(String key) String
        +getLLMClientType() String
        +getAPIKey() String
    }
    
    %% Relacionamentos
    User "1" --* "many" Ingredient : contém
    Recipe "1" --* "many" Ingredient : utiliza
    
    SuggestorBase <|-- SuggestorRapido : herda
    SuggestorBase <|-- SuggestorSaudavel : herda
    
    LLMClient <|.. RealLLMClient : implementa
    LLMClient <|.. MockLLMClient : implementa
    
    SuggestorBase --> LLMClient : utiliza
    SuggestorBase --> User : processa
    SuggestorBase --> Recipe : retorna
    
    Configuration ..> RealLLMClient : fornece configuração
    Configuration ..> SuggestorBase : configura
```

**Legenda do Diagrama:**
- `-` = privado, `+` = público, `#` = protegido
- `<<abstract>>` = classe abstrata, `<<interface>>` = interface
- `--*` = composição, `<|--` = herança, `<|..` = implementação

### Tecnologias utilizadas

* Java
* BlueJ
* Integração simulada com LLM (modo mock)
* API configurável via arquivo externo

### Configuração do projeto

* Clone ou baixe o repositório
* Abra a pasta no BlueJ
* Copie o arquivo:
* config.properties.example → config.properties

(Opcional) Insira sua API key real dentro do arquivo config.properties

### Exemplos de uso

*Entrada:*

Nome: Gio

Ingrediente: ovo

Quantidade: 2

Restrição: nenhuma


*Saída:*

=== Omelete Rápida ===

Tempo estimado: 10 minutos

...

### Segurança
* Chaves de API não são armazenadas no código
* Utilização de arquivo externo config.properties
* Versão mock disponível para testes offline
