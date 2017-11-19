package springbootstarter.greeting;

public class Greeting {

    private long id;
    private String name;
    private String content;
    private static final String template = "Hello, %s!";

    public Greeting() {

    }

    public Greeting(long id, String name) {
        this.id = id;
        this.name = name;
        setContent();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setContent() {
        this.content = String.format(template, name);
    }

}
