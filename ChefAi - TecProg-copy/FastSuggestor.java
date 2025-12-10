import java.util.*;

public class FastSuggestor extends RecipeSuggestor {

    public FastSuggestor(LLMClient client){
        super(client);
    }

    public List<Recipe> suggestRecipes(User user){
        return client.generateRecipes(user);
    }
}
