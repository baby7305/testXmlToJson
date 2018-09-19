
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DataSwitching_QNAME = new QName("http://webservice.mesesb.saicmotor.com/", "dataSwitching");
    private final static QName _MesEsbResponse_QNAME = new QName("http://type.webservice.mesesb.saicmotor.com/", "mesEsbResponse");
    private final static QName _MesEsbRequest_QNAME = new QName("http://type.webservice.mesesb.saicmotor.com/", "mesEsbRequest");
    private final static QName _DataSwitchingResponse_QNAME = new QName("http://webservice.mesesb.saicmotor.com/", "dataSwitchingResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MesEsbRequest }
     * 
     */
    public MesEsbRequest createMesEsbRequest() {
        return new MesEsbRequest();
    }

    /**
     * Create an instance of {@link MesEsbResponse }
     * 
     */
    public MesEsbResponse createMesEsbResponse() {
        return new MesEsbResponse();
    }

    /**
     * Create an instance of {@link DataSwitching }
     * 
     */
    public DataSwitching createDataSwitching() {
        return new DataSwitching();
    }

    /**
     * Create an instance of {@link DataSwitchingResponse }
     * 
     */
    public DataSwitchingResponse createDataSwitchingResponse() {
        return new DataSwitchingResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataSwitching }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.mesesb.saicmotor.com/", name = "dataSwitching")
    public JAXBElement<DataSwitching> createDataSwitching(DataSwitching value) {
        return new JAXBElement<DataSwitching>(_DataSwitching_QNAME, DataSwitching.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MesEsbResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://type.webservice.mesesb.saicmotor.com/", name = "mesEsbResponse")
    public JAXBElement<MesEsbResponse> createMesEsbResponse(MesEsbResponse value) {
        return new JAXBElement<MesEsbResponse>(_MesEsbResponse_QNAME, MesEsbResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MesEsbRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://type.webservice.mesesb.saicmotor.com/", name = "mesEsbRequest")
    public JAXBElement<MesEsbRequest> createMesEsbRequest(MesEsbRequest value) {
        return new JAXBElement<MesEsbRequest>(_MesEsbRequest_QNAME, MesEsbRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataSwitchingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.mesesb.saicmotor.com/", name = "dataSwitchingResponse")
    public JAXBElement<DataSwitchingResponse> createDataSwitchingResponse(DataSwitchingResponse value) {
        return new JAXBElement<DataSwitchingResponse>(_DataSwitchingResponse_QNAME, DataSwitchingResponse.class, null, value);
    }

}
