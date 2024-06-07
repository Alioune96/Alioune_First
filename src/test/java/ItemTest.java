import com.techelevator.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
    private Item testerForreal;

    @Before
    public void settersFirst(){
        String name = "chips";
        double price = 1.8;
        String chipTypes = "Potatoes";
        testerForreal=new Item(name,price,chipTypes);
    }

    @Test
    public void testingfirstGetter(){
        String testerForNow = "chips";

        Assert.assertEquals(testerForNow,testerForreal.getName());

    }

    @Test
    public void testerForgettingBalance(){
        double forTester = 1.8;

        Assert.assertEquals(forTester,testerForreal.getItemCost(),0.01);
    }

    @Test
    public void testerForchipType(){
        String types= "Potatoes";

        Assert.assertEquals(types,testerForreal.getTypeOfItem());
    }


}
