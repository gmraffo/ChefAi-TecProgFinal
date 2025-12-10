
import java.util.*;

public class Recipe {

    private String title;
    private List<String> ingredients;
    private List<String> steps;
    private int time;

    public Recipe(String title, List<String> ingredients, List<String> steps, int time){
        this.title = title;
        this.ingredients = ingredients;
        this.steps = steps;
        this.time = time;
    }

    public void print(User user){
        System.out.println("\n==============================");
        System.out.println("Receita: " + title);
        System.out.println("Tempo estimado: " + time + " min");

        System.out.println("\nIngredientes:");
        for(String i : ingredients){
            System.out.println(" - " + i);
        }

        System.out.println("\nModo de preparo:");
        int c = 1;
        for(String s : steps){
            System.out.println(c + ". " + s);
            c++;
        }
    }
}
