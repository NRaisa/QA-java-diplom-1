import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParamTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
        };
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();

        assertEquals("Incorrect values ingredient type", type, actual);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();

        assertEquals("Incorrect values ingredient name", name, actual);
    }

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();

        assertEquals("Incorrect values ingredient price", price, actual, 0);
    }
}
