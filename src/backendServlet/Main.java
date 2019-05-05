package backendServlet;

import javax.xml.ws.Endpoint;

public class Main {

    public static void main(String[] argv) {
        final SoapWebService implementor = new SoapWebService();
        final String address = "http://localhost:8080/eAccessible/SoapWebService";
        Endpoint.publish(address, implementor);
    }

}