package bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "eaccessible.local")
public class BeanLocal {

    @DatabaseField(columnName = "codilocal", id = true)
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

    @DatabaseField(columnName = "observacions", canBeNull = true)
    public String observations;

    @DatabaseField(columnName = "verificat", defaultValue = "0")
    public char verified;
    
    @DatabaseField(columnName = "urlca", canBeNull = true)
    public String urlCA;
    
    @DatabaseField(columnName = "urles", canBeNull = true)
    public String urlES;
    
    @DatabaseField(columnName = "urlen", canBeNull = true)
    public String urlEN;
    
    @DatabaseField(columnName = "urlgooglemapsca", canBeNull = true)
    public String urlGoogleMapsCA;
    
    @DatabaseField(columnName = "urlgooglemapses", canBeNull = true)
    public String urlGoogleMapsES;
    
    @DatabaseField(columnName = "urlgooglemapsen", canBeNull = true)
    public String urlGoogleMapsEN;
}
