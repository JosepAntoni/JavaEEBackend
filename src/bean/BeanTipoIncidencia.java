package bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "log.tipusIncidencia")
public class BeanTipoIncidencia {

    @DatabaseField(id = true, columnName = "codiTipusIncidencia")
    public int id;

    @DatabaseField(columnName = "descripcio", canBeNull = false)
    public String description;

}
