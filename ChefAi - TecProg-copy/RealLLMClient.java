
import java.util.*;

public class RealLLMClient implements LLMClient {

    public List<Recipe> generateRecipes(User user){
        System.out.println("(Simulando chamada de API externa...)");
        return new MockLLMClient().generateRecipes(user);
    }
}
