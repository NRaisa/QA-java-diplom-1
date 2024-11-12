import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParamTest {
    private Burger burger;
    private Ingredient sauce;
    private Ingredient filling;
    private final String name;
    private final float price;

    public BurgerParamTest(String name, float price){
        this.name = name;
        this.price = price;
    }

  @Before
    public void createNewInstance() {
        sauce = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        filling = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        burger = new Burger();
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float expected = bun.price * 2 + sauce.price + filling.price;
        float actual = burger.getPrice();

        assertEquals("Incorrect values burger price", expected, actual, 0);
    }

}
