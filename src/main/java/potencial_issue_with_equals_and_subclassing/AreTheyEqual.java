package potencial_issue_with_equals_and_subclassing;

public class AreTheyEqual {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println("Objects rover and rover2 are equal: " + rover.equals(rover2));
        System.out.println("Objects rover2 and rover are equal: " + rover2.equals(rover));

        System.out.println("\nHint: Comment & uncomment equals() method in Labrador class." +
                "\n\nAnswer: \nMethod implementation is incorrect. It breaks equal() method's symmetric rule. " +
                "\nRepair: Make method equals() final in Dog class.");
    }
}
