package art.kadawi.stayalive.duration;

public class UnitNames {
    private String single;
    private String pair;
    private String many;

    public UnitNames() {
    }

    public UnitNames(String single, String pair, String many) {
        this.single = single;
        this.pair = pair;
        this.many = many;
    }

    public String getSingle() {
        return single;
    }

    public String getPair() {
        return pair;
    }

    public String getMany() {
        return many;
    }

    public String format(long value) {
        if (value == 1) {
            return single;
        } else if (value == 2) {
            return pair;
        }
        return value + " " + many;
    }
}
