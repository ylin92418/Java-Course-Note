package regExExample;

import java.util.regex.Pattern;

public class RegExTester {
    public static void main(String[] args) {
        // ^ stands for the beginning of a new line
        // (): a pattern
        // .+: any kinds of character and have more than 0 element inside
        // (.+): "avjd;" is valid, "" is invalid
        // $: the end of a line
        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);

        String email = "jeff@gmail.com";

        System.out.println(pattern.matcher(email).matches());
    }
}
