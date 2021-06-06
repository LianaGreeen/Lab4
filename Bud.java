package p.labs.Lab04A;

public class Bud {
    String color_bud;

    public Bud(String color_bud) {
        this.color_bud = color_bud;
    }

    public Bud(){
        System.out.println("Bud layout created");
    }

    public String getColor_bud() {
        return color_bud;
    }

    public void setColor_bud(String color_bud) {
        this.color_bud = color_bud;
    }

    @Override
    public String toString() {
        return "Цвет бутона: " + color_bud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bud bud = (Bud) o;
        return color_bud != null ? color_bud.equals(bud.color_bud) : bud.color_bud == null;
    }

    @Override
    public int hashCode() {
        return color_bud != null ? color_bud.hashCode() : 0;
    }
}