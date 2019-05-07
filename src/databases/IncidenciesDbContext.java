package databases;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.PostgresDatabaseType;
import com.j256.ormlite.jdbc.DataSourceConnectionSource;

import bean.BeanIncidencia;
import bean.BeanTipoIncidencia;

public class IncidenciesDbContext {

    public static BeanTipoIncidencia getAllLocalsIncidenceType = new BeanTipoIncidencia();
    public static BeanTipoIncidencia addLocalIncidenceType = new BeanTipoIncidencia();
    public static BeanTipoIncidencia deleteLocalIncidenceType = new BeanTipoIncidencia();
    public static BeanTipoIncidencia getLocalIncidenceType = new BeanTipoIncidencia();
    public static BeanTipoIncidencia validateLocalIncidenceType = new BeanTipoIncidencia();

    static {
        getAllLocalsIncidenceType.id = 1;
        getAllLocalsIncidenceType.description = "GET_ALL_LOCALS";

        addLocalIncidenceType.id = 2;
        addLocalIncidenceType.description = "ADD_LOCAL";

        deleteLocalIncidenceType.id = 3;
        deleteLocalIncidenceType.description = "DELETE_LOCAL";

        getLocalIncidenceType.id = 4;
        getLocalIncidenceType.description = "GET_LOCAL";

        validateLocalIncidenceType.id = 5;
        validateLocalIncidenceType.description = "VALIDATE_LOCAL";
    }

    private static Dao<BeanTipoIncidencia, Integer> incidenceTypeDao;
    private static Dao<BeanIncidencia, Integer> incidenceDao;

    public static Dao<BeanTipoIncidencia, Integer> getIncidenceTypeDao() {
        if (incidenceTypeDao != null) {
            return incidenceTypeDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = IncidenciesDbContext.getConnectionSource()) {
            incidenceTypeDao = DaoManager.createDao(dataSourceConnectionSource, BeanTipoIncidencia.class);
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getIncidenceTypeDao();
    }

    public static Dao<BeanIncidencia, Integer> getIncidenceDao() {
        if (incidenceDao != null) {
            return incidenceDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = IncidenciesDbContext.getConnectionSource()) {
            incidenceDao = DaoManager.createDao(dataSourceConnectionSource, BeanIncidencia.class);
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getIncidenceDao();
    }
    private static final String incidenciaJNDI = "java:jboss/PostgreSQL/incidencia";

    private static DataSource getDataSource() throws NamingException {
        final InitialContext cxt = new InitialContext();
        return (DataSource) cxt.lookup(incidenciaJNDI);
    }

    private static DataSourceConnectionSource getConnectionSource() throws NamingException, SQLException {
        return new DataSourceConnectionSource(getDataSource(), new PostgresDatabaseType());
    }

}