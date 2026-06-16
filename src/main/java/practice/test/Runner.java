package practice.test;

public class Runner {
        public static void main(String[] args) {
            Parent1.staticMethod();
            Child1.staticMethod();
            Parent1 parent = new Child1();

            parent.staticMethod();
        }
}
