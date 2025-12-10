
import java.util.*;

public class HealthySuggestor extends RecipeSuggestor {

    public HealthySuggestor(LLMClient client){
        super(client);
    }

    public List<Recipe> suggestRecipes(User user){
        return client.generateRecipes(user);
    }
}
