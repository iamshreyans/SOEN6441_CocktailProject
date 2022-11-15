package data;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Drinks {


    @JsonProperty("idDrink")
    String id;
    @JsonProperty("strDrink")
    String drinkName;
    @JsonProperty("strCategory")
    String category;
    @JsonProperty("strAlcoholic")
    String alcoholic;

    public Drinks(){}

    public Drinks(String id, String drinkName, String category, String alcoholic) {
        this.id = id;
        this.drinkName = drinkName;
        this.category = category;
        this.alcoholic = alcoholic;
    }

    public String getId() {
        return id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object object) {

        Drinks dr = (Drinks) object;

        if(this.id.equals(dr.id) && this.drinkName.equals(dr.drinkName)
                && this.category.equals(dr.category) && this.alcoholic.equals(dr.alcoholic)){
            return true;
        }

        return false;
    }

    public String getAlcoholic() {
        return alcoholic;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAlcoholic(String alcoholic) {
        this.alcoholic = alcoholic;
    }
    @Override
    public String toString() {
        return "Drinks{" +
                "id=" + id +
                ", drinkName='" + drinkName + '\'' +
                ", category='" + category + '\'' +
                ", Alcoholic='" + alcoholic + '\'' +
                '}';
    }
}
