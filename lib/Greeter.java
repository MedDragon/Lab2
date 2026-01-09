public class Greeter {
    String who;
    Greeter(String who) {
        this.who = who;
    }
    String greet() {
        return "Hello, " + who;
    }
}
