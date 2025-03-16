//факультет

public class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = Utils.formatEntityName(name);
    }

    public final void rename(String name) {
        this.name = Utils.formatEntityName(name);
    }

    public final String getName() {
        return name;
    }
}