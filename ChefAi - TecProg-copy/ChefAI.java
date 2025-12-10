import java.util.*;

public class ChefAI {

    private LLMClient client;
    private Scanner sc;

    public ChefAI(LLMClient client){
        this.client = client;
        sc = new Scanner(System.in);
    }

    public void start(){
        System.out.println("=== ChefAI - Sugestor Inteligente ===");

        System.out.print("Nome do usuario: ");
        String nome = sc.nextLine();
        User user = new User(nome);

        System.out.println("\nInforme ingredientes (Enter para parar):");

        while(true){
            System.out.print("Ingrediente: ");
            String ing = sc.nextLine();
            if(ing.isEmpty()) break;

            System.out.print("Quantidade: ");
            String qtd = sc.nextLine();

            user.addIngredient(new Ingredient(ing, qtd));
        }

        System.out.print("Restricoes (ex: vegetariano, sem lactose): ");
        String r = sc.nextLine();
        user.setRestriction(r);

        System.out.print("Tipo de refeicao (cafe, almoco, jantar): ");
        String tipo = sc.nextLine();
        user.setMealType(tipo);

        RecipeSuggestor suggestor;

        if(r.toLowerCase().contains("veget")){
            suggestor = new HealthySuggestor(client);
        } else {
            suggestor = new FastSuggestor(client);
        }

        List<Recipe> recipes = suggestor.suggestRecipes(user);

        if(recipes.isEmpty()){
            System.out.println("Nenhuma receita encontrada.");
        } else {
            for(Recipe rcp : recipes){
                rcp.print(user);
            }
        }
    }
}
