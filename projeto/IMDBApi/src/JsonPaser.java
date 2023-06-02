import java.util.regex.Pattern;

public class JsonPaser {
    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[.+]\\.*");
    private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?\":\"(.*?)\"");

    public List<Map<String,String>> 
}

