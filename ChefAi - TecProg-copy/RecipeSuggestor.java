
import java.util.*;

public abstract class RecipeSuggestor {

    protected LLMClient client;

    public RecipeSuggestor(LLMClient client){
        this.client = client;
    }

    public abstract List<Recipe> suggestRecipes(User user);
}
