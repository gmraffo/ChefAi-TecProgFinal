import java.util.*;

public class MockLLMClient implements LLMClient {

    public List<Recipe> generateRecipes(User user){

        List<Recipe> list = new ArrayList<Recipe>();

        List<String> ing1 = Arrays.asList("2 ovos", "sal", "manteiga");
        List<String> st1 = Arrays.asList("Quebrar os ovos", "Bater", "Fritar");

        List<String> ing2 = Arrays.asList("pao", "queijo", "presunto");
        List<String> st2 = Arrays.asList("Montar sanduiche", "Levar a frigideira");

        List<String> ing3 = Arrays.asList("banana", "aveia", "ovo");
        List<String> st3 = Arrays.asList("Misturar tudo", "Fritar em pequenas porcoes");

        list.add(new Recipe("Omelete Rapida", ing1, st1, 10));
        list.add(new Recipe("Misto Quente", ing2, st2, 8));
        list.add(new Recipe("Panqueca de Banana", ing3, st3, 15));

        return list;
    }
}
