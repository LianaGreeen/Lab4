package p.labs.Lab04A;

public class Flower extends Petal{
    String name;
    String sort;

    public Flower(String name, String sort, String color_bud, String color_petal, String form_petal, int number_petal){
        super(color_bud, color_petal, form_petal, number_petal);
        this.name = name;
        this.sort = sort;
    }

    public Flower() {
        System.out.println("Flower layout created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Название: " + name + '\n' +  "Сорт: " + sort + '\n'
                + "Цвет: " + getColor_petal() + '\n' + "Форма: " + getForm_petal() + '\n'
                + "Количество: " + getNumber_petal()
                + '\n' + "Цвет бутона: " + getColor_bud();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Flower flower = (Flower) o;
        if (name != null ? !name.equals(flower.name) : flower.name != null) return false;
        return sort != null ? sort.equals(flower.sort) : flower.sort == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        return result;
    }
}