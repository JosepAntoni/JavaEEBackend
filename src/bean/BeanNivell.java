package bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "nivell")
public class BeanNivell {

    @DatabaseField(id = true, columnName = "codinivell")
    public int id;

    @DatabaseField(columnName = "nomnivellca")
    public String nameCA;

    @DatabaseField(columnName = "nomnivelles")
    public String nameES;

    @DatabaseField(columnName = "nomnivellen")
    public String nameEN;

}
