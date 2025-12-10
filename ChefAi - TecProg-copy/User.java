
import java.util.*;

public class User {

    private String name;
    private List<Ingredient> ingredients;
    private String restriction;
    private String mealType;

    public User(String name){
        this.name = name;
        ingredients = new ArrayList<Ingredient>();
    }

    public void addIngredient(Ingredient i){
        ingredients.add(i);
    }

    public List<Ingredient> getIngredients(){
        return ingredients;
    }

    public String getName(){
        return name;
    }

    public void setRestriction(String r){
        restriction = r;
    }

    public String getRestriction(){
        return restriction;
    }

    public void setMealType(String t){
        mealType = t;
    }

    public String getMealType(){
        return mealType;
    }
}
