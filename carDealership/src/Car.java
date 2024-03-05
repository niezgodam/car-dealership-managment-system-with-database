public class Car {
    private String mark;
    private String model;
    private int year;
    private int horsepower;
    private String color;
    private int price;

    public Car(String mark, String model, int year, int horsepower, String color, int price) {
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.horsepower = horsepower;
        this.color = color;
        this.price = price;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mark: " + mark + ", Model: " + model + ", Year: " + year + ", Power: " + horsepower + ", Color: " + color + ", Price: " + price;
    }
}
