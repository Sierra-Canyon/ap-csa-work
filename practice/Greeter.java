/*
 * The first program. Five lines, and its only job is to prove that the
 * toolchain you installed actually works.
 *
 * From the top of this repository:
 *
 *     cd practice
 *     javac Greeter.java
 *     java Greeter
 *
 * You should see: Ready to compile.
 *
 * Then rename this file to greeter.java, lower case g, and compile it again.
 * Read the error. That is the file-name rule, and meeting it once here is
 * cheaper than meeting it at eleven at night in October.
 */
public class Greeter {
    public static void main(String[] args) {
        System.out.println("Ready to compile.");
        String name = "Ada";
        System.out.println(name.length());

        int count = 3;
        if (count > 0) {
            System.out.println(name.substring(0, name.length()));
        }
    }
}
