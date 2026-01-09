public class Hello {
    public static void main( String argv[] ) {
        String name = "World"; // Default is "World"
        if ( argv.length != 0 ) {
             name = argv[0];
        }
        Greeter greeter = new Greeter(name);
        System.out.println(greeter.greet());
    }
}
