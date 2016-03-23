package data;

import static java.lang.Integer.parseInt;

/**
 * Created by zhabenya on 17.03.16.
 */
public class Advertisement {

    private int id;
    private String header;
    private String price;
    private String tableLocator;

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

    public String getTableLocator() {
        return tableLocator;
    }

    public void setTableLocator(String tableLocator) {
        this.tableLocator = tableLocator;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", header='" + header + '\'' +
                '}';
    }

    public static int getAdIdFromTable(String trLocator){
        return parseInt(trLocator.substring(trLocator.indexOf("_") + 1));
    }
}
