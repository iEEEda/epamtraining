public class Pizza {

    private String type;    // normal or calzone
    private String[] ingredients = new String[7]; // ingredients can be created using enum
    private String name;
    private byte amount;
    public Pizza(String name, String type, byte amount){
        if(name.length() < 4 && name.length() > 20) {
            this.name = "";
        } else {
            this.name = name;
        }
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAmount() {
        return amount;
    }

    public void setAmount(byte amount) {
        this.amount = amount;
    }

    public String addIngredient(String... ingredients){
        if(this.ingredients[6] != null){
            return "The pizza is already full";
        } else {
            for (int i = 0; i < this.ingredients.length; i++) {
                if(this.ingredients[i].equals(ingredients[i])) {
                    return "Check the order again";
                    break;
                } else if(this.ingredients[i] == null){

                }
            }
        }
    }
}
