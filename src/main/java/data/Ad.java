package data;

import static java.lang.Integer.parseInt;

/**
 * Created by zhabenya on 17.03.16.
 */
public class Ad {

    private int id;
    private String header;
    private String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", header='" + header + '\'' +
                '}';
    }

    public static int getAdIdFromTable(String trLocator){
        return parseInt(trLocator.substring(trLocator.indexOf("_") + 1));
    }
}
