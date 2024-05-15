package utility;

public class CreateUrl {
    public static String baseURI = "https://api.github.com";

    public static String getBaseURI() {
        return baseURI;
    }

    public static String getBaseURI(String endpoint) {
        return baseURI + endpoint;
    }
}
