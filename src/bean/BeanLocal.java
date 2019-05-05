package bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "local")
public class BeanLocal {

    @DatabaseField(id = true, columnName = "codilocal")
    public int id;

    @DatabaseField(columnName = "coditipolocal", foreign = true, foreignAutoRefresh = true)
    public BeanTipoLocal localType;

    @DatabaseField(columnName = "codicarrer")
    public int idStreet;

    @DatabaseField(columnName = "nomcarrer")
    public String street;

    @DatabaseField(columnName = "nomvia")
    public String streetType;

    @DatabaseField(columnName = "numero")
    public int number;

    @DatabaseField(columnName = "nomlocal")
    public String name;

    @DatabaseField(columnName = "observacions")
    public String observations;

    @DatabaseField(columnName = "verificat")
    public char verified;
    
    @DatabaseField(columnName = "urlca")
    public String urlCA;
    
    @DatabaseField(columnName = "urles")
    public String urlES;
    
    @DatabaseField(columnName = "urlen")
    public String urlEN;
    
    @DatabaseField(columnName = "urlgooglemapsca")
    public String urlGoogleMapsCA;
    
    @DatabaseField(columnName = "urlgooglemapses")
    public String urlGoogleMapsES;
    
    @DatabaseField(columnName = "urlgooglemapsen")
    public String urlGoogleMapsEN;
}
