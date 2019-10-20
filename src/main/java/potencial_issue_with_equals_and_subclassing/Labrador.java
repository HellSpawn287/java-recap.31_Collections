package potencial_issue_with_equals_and_subclassing;

public class Labrador extends Dog {
    public Labrador(String name) {
        super(name);
    }

    /*@Override //Comment
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Labrador){
            String objName = ((Labrador) o).getName();
            return this.getName().equals(objName);
        }

        return false;
    }*/ //Comment
}
