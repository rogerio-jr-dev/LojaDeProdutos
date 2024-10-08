package entities;

public final class ImportedProduct extends Product {

    private Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }
    public Double getCustomsFee() {
        return customsFee;
    }
    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }
    @Override
    public final String priceTag(){
        return getName() + "$ " + String.format("%.2f", totalPrice()) + " (Customs fee: $ " + customsFee + ")";
    }

    public final Double totalPrice(){
        return customsFee + getPrice();
    }
}
