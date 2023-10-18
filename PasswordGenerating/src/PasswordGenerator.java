import java.util.Random;
public class PasswordGenerator {
    public static final String LOWERCASE_CHARACTER = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIALSYMBOLS = "-=~!@#$%^&*()_+[]{}|;':,./<>?";
    private final Random random;
    public PasswordGenerator() { random = new Random(); }
    public String generatorPassword(int length, boolean includeUppercase, boolean includeLowercase,
                                    boolean includeNumbers, boolean includeSpecialSymbols) {
        StringBuilder passwordBuilder = new StringBuilder();
        String validCharacters = "";
        if (includeUppercase) validCharacters += UPPERCASE_CHARACTER;
        if (includeLowercase) validCharacters += LOWERCASE_CHARACTER;
        if (includeNumbers) validCharacters += NUMBERS;
        if (includeSpecialSymbols) validCharacters += SPECIALSYMBOLS;
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validCharacters.length());
            char randomChar = validCharacters.charAt(randomIndex);
            passwordBuilder.append(randomChar);
        }
        return passwordBuilder.toString(); 
    }
}
