package bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;
import java.util.Date;

@DatabaseTable(tableName = "log.incidencia")
public class BeanIncidencia {

    @DatabaseField(id = true, columnName = "idIncidencia")
    public int id;

    @DatabaseField(columnName = "data")
    public Date date;

    @DatabaseField(columnName = "dataHora")
    public Timestamp timestamp;

    @DatabaseField(columnName = "codiTipusIncidencia", foreign = true, foreignAutoRefresh = true)
    public BeanTipoIncidencia incidenceType;

}
