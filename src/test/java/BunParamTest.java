import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParamTest {

        private Bun bun;
        private String name;
        private float price;

        public BunParamTest(String name, float price){
            this.name = name;
            this.price = price;
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
        public void getName() {

            bun = new Bun(name, price);
            String actual = bun.getName();

            assertEquals("Incorrect values bun name", name, actual);
        }

        @Test
        public void getPrice() {
            bun = new Bun(name, price);
            float actual = bun.getPrice();

            assertEquals("Incorrect values bun price", price, actual, 0);
        }

}
