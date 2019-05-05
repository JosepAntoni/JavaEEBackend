package bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tipolocal")
public class BeanTipoLocal {

    @DatabaseField(id = true, columnName = "coditipolocal")
    public int id;

    @DatabaseField(columnName = "nomtipolocalca", canBeNull = false)
    public String nameCA;

    @DatabaseField(columnName = "nomtipolocales", canBeNull = false)
    public String nameES;

    @DatabaseField(columnName = "nomtipolocalen", canBeNull = false)
    public String nameEN;
}
