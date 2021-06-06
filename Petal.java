package p.labs.Lab04A;

public class Petal extends Bud{
    String color_petal;
    String form_petal;
    int number_petal;

    public Petal(String color_bud, String color_petal, String form_petal, int number_petal){
        super(color_bud);
        this.color_petal = color_petal;
        this.form_petal = form_petal;
        this.number_petal = number_petal;
    }

    public Petal(){
        System.out.println("Petal layout created");
    }

    public String getColor_petal() {
        return color_petal;
    }

    public void setColor_petal(String color_petal) {
        this.color_petal = color_petal;
    }

    public String getForm_petal() {
        return form_petal;
    }

    public void setForm_petal(String form_petal) {
        this.form_petal = form_petal;
    }

    public int getNumber_petal() {
        return number_petal;
    }

    public void setNumber_petal(int number_petal) {
        this.number_petal = number_petal;
    }

    @Override
    public String toString() {
        return "Цвет: " + color_petal + '\n'
                + "Форма: " + form_petal + '\n'
                + "Количество лепестков: " + number_petal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Petal petal = (Petal) o;
        if (number_petal != petal.number_petal) return false;
        return form_petal != null ? form_petal.equals(petal.form_petal) : petal.form_petal == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (color_petal != null ? color_petal.hashCode() : 0);
        result = 31 * result + (form_petal != null ? form_petal.hashCode() : 0);
        result = 31 * result + number_petal;
        return result;
    }

    public boolean blossom(String color, String form, int n){
        if(this.getNumber_petal() != 0 & this.getColor_petal() != null & this.getForm_petal() != null){ return false; }
        this.color_petal = color;
        this.form_petal = form;
        this.number_petal = n;
        this.color_bud = this.getColor_petal();
        return true;
    }

    public boolean wither(){
        if(this.getNumber_petal() == 0 || this.getColor_petal() == null || this.getForm_petal() == null){ return false; }
        this.color_petal = "темно " + getColor_petal();
        this.number_petal = 0;
        return true;
    }
}