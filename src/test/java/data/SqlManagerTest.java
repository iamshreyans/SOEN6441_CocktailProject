package data;

import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class SqlManagerTest {
    SqlManager manager = new SqlManager(true);

    @Before
     public void before(){
        manager.createTableIfNotExists();
    }

    @Test
    public void insertRecord() {
    }

    @Test
    public void selectAllDrinks() {
        List<Drinks> drinksList = new ArrayList<>();
        Drinks obj1= new Drinks("1111","Beer","Wheat Beer","Alcoholic");
        Drinks obj2= new Drinks("1211","Whiskey","Scotch","Alcoholic");
        drinksList.add(obj1);
        drinksList.add(obj2);

        for(int i=0; i<drinksList.size(); i++){

            manager.insertRecord(drinksList.get(i));
        }

        List<Drinks> result= manager.selectAllDrinks();

        assertArrayEquals(drinksList.toArray(),result.toArray());
    }

    @Test
    public void searchDrinksByName() {
        List<Drinks> drinksList = new ArrayList<>();
        Drinks obj1= new Drinks("1111","Beer","Wheat Beer","Alcoholic");
        Drinks obj2= new Drinks("1211","Whiskey","Scotch","Alcoholic");
        drinksList.add(obj1);
        drinksList.add(obj2);

        for(int i=0; i<drinksList.size(); i++){

            manager.insertRecord(drinksList.get(i));
        }

        List<Drinks> result= manager.searchDrinksByName("Beer");

        assertEquals(obj1,result.get(0));
    }
}