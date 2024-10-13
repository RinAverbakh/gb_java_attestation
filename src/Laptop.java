import java.util.Objects;

public class Laptop {

    private String os;
    private String color;

    public Laptop (String os, String color) {
        this.os = os;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getOs() {
        return os;
    }

    @Override
    public String toString() {
        return "Laptop - [OS - " + os + " , COLOR - " + color + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Laptop laptop = (Laptop) obj;

        return os.equals(laptop.os) && color.equals(laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(os, color);
    }
}
