package data;

import java.util.List;

public class JsonResponse {
    List<Drinks> drinks;

    public void setDrinks(List<Drinks> drinks) {
        this.drinks = drinks;
    }

    public List<Drinks> getDrinks() {
        return drinks;
    }
}
