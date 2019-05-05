package backendServlet;

import javax.jws.WebMethod;
import javax.jws.WebService;

import bean.*;
import databases.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService()
public class SoapWebService {

    @WebMethod()
    public List<BeanTipoLocal> getAllLocalTypes() {
        try {
            return AccessibleDbContext.getLocalTypeDao().queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public List<BeanCaracteristica> getCharacteristics(final BeanLocal localType) {
        try {
            final List<BeanCaracteristica> result = new ArrayList<>();
            for (BeanCaracteristicaTipoLocal characteristicLocalType : AccessibleDbContext.getCharacteristicLocalTypeDao().queryForEq("coditipolocal", localType)) {
                result.add(AccessibleDbContext.getCharacteristicDao().queryForId(characteristicLocalType.characteristic.id));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public BeanLocal addLocal(final BeanLocal local) {
        addIncidence(IncidenciesDbContext.addLocalIncidenceType);
        try {
            local.id = (int) Date.from(Instant.now()).getTime();
            AccessibleDbContext.getLocalDao().create(local);
            return local;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public List<BeanAccessibilitat> addAccessibility(final List<BeanAccessibilitat> accessibilityList) {
        try {
            final List<BeanAccessibilitat> result = new ArrayList<>();
            for (final BeanAccessibilitat accessibility : accessibilityList) {
                accessibility.id = (int) Date.from(Instant.now()).getTime();
                AccessibleDbContext.getAccessibilityDao().create(accessibility);
                result.add(accessibility);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addIncidence(final BeanTipoIncidencia incidenceType) {
        try {
            final BeanIncidencia incidence = new BeanIncidencia();
            incidence.id = (int) Date.from(Instant.now()).getTime();
            incidence.date = Date.from(Instant.now());
            incidence.timestamp = Timestamp.from(Instant.now());
            incidence.incidenceType = incidenceType;
            IncidenciesDbContext.getIncidenceDao().create(incidence);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @WebMethod()
    public List<BeanLocal> getAllLocals() {
        addIncidence(IncidenciesDbContext.getAllLocalsIncidenceType);
        try {
            return AccessibleDbContext.getLocalDao().queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public BeanLocal getLocal(final int id) {
        addIncidence(IncidenciesDbContext.getLocalIncidenceType);
        try {
            return AccessibleDbContext.getLocalDao().queryForId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public List<BeanAccessibilitat> getAccesibilityByLocal(final BeanLocal local) {
        try {
            return AccessibleDbContext.getAccessibilityDao().queryForEq("codilocal", local.id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public void deleteLocalById(final int id) {
        addIncidence(IncidenciesDbContext.deleteLocalIncidenceType);
        try {
            for (final BeanAccessibilitat accessibility : AccessibleDbContext.getAccessibilityDao().queryForEq("codilocal", id)) {
                AccessibleDbContext.getAccessibilityDao().delete(accessibility);
            }
            AccessibleDbContext.getLocalDao().deleteById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public void validateLocal(final BeanLocal local) {
        addIncidence(IncidenciesDbContext.validateLocalIncidenceType);
        try {
            local.verified = '1';
            AccessibleDbContext.getLocalDao().update(local);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public List<BeanLocal> getLocalsByName(final String name) {
        addIncidence(IncidenciesDbContext.getLocalIncidenceType);
        try {
            return AccessibleDbContext.getLocalDao().queryForEq("nomlocal", name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public List<BeanIncidencia> getIncidencesByIncidenceType(final BeanTipoIncidencia incidenceType) {
        try {
            return IncidenciesDbContext.getIncidenceDao().queryForEq("codiTipusIncidencia", incidenceType.id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public List<BeanTipoIncidencia> getAllIncidenceTypes() {
        try {
            return IncidenciesDbContext.getIncidenceTypeDao().queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public BeanTipoLocal getLocalType(int id) {
        try {
            return AccessibleDbContext.getLocalTypeDao().queryForId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod()
    public BeanTipoIncidencia getIncidenceType(int id) {
        try {
            return IncidenciesDbContext.getIncidenceTypeDao().queryForId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}