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

import bean.BeanAccessibilitat;
import bean.BeanCaracteristica;
import bean.BeanCaracteristicaTipoLocal;
import bean.BeanLocal;
import bean.BeanNivell;
import bean.BeanTipoLocal;

public class AccessibleDbContext {

    private static Dao<BeanAccessibilitat, Integer> accessibilityDao;
    private static final String eAccessibleJNDI = "java:jboss/PostgreSQL/eAccessible";
    private static Dao<BeanCaracteristica, Integer> characteristicDao;
    private static Dao<BeanCaracteristicaTipoLocal, Integer> characteristicLocalTypeDao;
    private static Dao<BeanNivell, Integer> levelDao;
    private static Dao<BeanLocal, Integer> localDao;
    private static Dao<BeanTipoLocal, Integer> localTypeDao;

    public static Dao<BeanAccessibilitat, Integer> getAccessibilityDao() {
        if (accessibilityDao != null) {
            return accessibilityDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = AccessibleDbContext.getConnectionSource()) {
            accessibilityDao = DaoManager.createDao(dataSourceConnectionSource, BeanAccessibilitat.class);
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getAccessibilityDao();
    }

    public static Dao<BeanCaracteristica, Integer> getCharacteristicDao() {
        if (characteristicDao != null) {
            return characteristicDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = AccessibleDbContext.getConnectionSource()) {
            characteristicDao = DaoManager.createDao(dataSourceConnectionSource, BeanCaracteristica.class);
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getCharacteristicDao();
    }

    public static Dao<BeanCaracteristicaTipoLocal, Integer> getCharacteristicLocalTypeDao() {
        if (characteristicLocalTypeDao != null) {
            return characteristicLocalTypeDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = AccessibleDbContext.getConnectionSource()) {
            characteristicLocalTypeDao = DaoManager.createDao(dataSourceConnectionSource, BeanCaracteristicaTipoLocal.class);
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getCharacteristicLocalTypeDao();
    }

    public static Dao<BeanNivell, Integer> getLevelDao() {
        if (levelDao != null) {
            return levelDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = AccessibleDbContext.getConnectionSource()) {
            levelDao = DaoManager.createDao(dataSourceConnectionSource, BeanNivell.class);
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getLevelDao();
    }

    public static Dao<BeanLocal, Integer> getLocalDao() {
        if (localDao != null) {
            return localDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = AccessibleDbContext.getConnectionSource()) {
            localDao = DaoManager.createDao(dataSourceConnectionSource, BeanLocal.class);
            return localDao;
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getLocalDao();
    }

    public static Dao<BeanTipoLocal, Integer> getLocalTypeDao() {
        if (localTypeDao != null) {
            return localTypeDao;
        }
        try (final DataSourceConnectionSource dataSourceConnectionSource = AccessibleDbContext.getConnectionSource()) {
            localTypeDao = DaoManager.createDao(dataSourceConnectionSource, BeanTipoLocal.class);
        } catch (NamingException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return getLocalTypeDao();
    }

    private static DataSource getDataSource() throws NamingException {
        final InitialContext cxt = new InitialContext();
        return (DataSource) cxt.lookup(eAccessibleJNDI);
    }

    private static DataSourceConnectionSource getConnectionSource() throws NamingException, SQLException {
        return new DataSourceConnectionSource(getDataSource(), new PostgresDatabaseType());
    }

}