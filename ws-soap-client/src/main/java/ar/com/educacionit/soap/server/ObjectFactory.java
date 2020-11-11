
package ar.com.educacionit.soap.server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ar.com.educacionit.soap.server package. 
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

    private final static QName _WSSoapException_QNAME = new QName("http://server.soap.educacionit.com.ar/", "WSSoapException");
    private final static QName _CreateProductoResponse_QNAME = new QName("http://server.soap.educacionit.com.ar/", "createProductoResponse");
    private final static QName _ListAll_QNAME = new QName("http://server.soap.educacionit.com.ar/", "listAll");
    private final static QName _GetProductoByCodigo_QNAME = new QName("http://server.soap.educacionit.com.ar/", "getProductoByCodigo");
    private final static QName _CreateProducto_QNAME = new QName("http://server.soap.educacionit.com.ar/", "createProducto");
    private final static QName _ListAllResponse_QNAME = new QName("http://server.soap.educacionit.com.ar/", "listAllResponse");
    private final static QName _GetProductoByCodigoResponse_QNAME = new QName("http://server.soap.educacionit.com.ar/", "getProductoByCodigoResponse");
    private final static QName _DuplicatesSoapException_QNAME = new QName("http://server.soap.educacionit.com.ar/", "DuplicatesSoapException");
    private final static QName _EliminarProducto_QNAME = new QName("http://server.soap.educacionit.com.ar/", "eliminarProducto");
    private final static QName _EliminarProductoResponse_QNAME = new QName("http://server.soap.educacionit.com.ar/", "eliminarProductoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ar.com.educacionit.soap.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DuplicatesSoapException }
     * 
     */
    public DuplicatesSoapException createDuplicatesSoapException() {
        return new DuplicatesSoapException();
    }

    /**
     * Create an instance of {@link EliminarProducto }
     * 
     */
    public EliminarProducto createEliminarProducto() {
        return new EliminarProducto();
    }

    /**
     * Create an instance of {@link EliminarProductoResponse }
     * 
     */
    public EliminarProductoResponse createEliminarProductoResponse() {
        return new EliminarProductoResponse();
    }

    /**
     * Create an instance of {@link ListAllResponse }
     * 
     */
    public ListAllResponse createListAllResponse() {
        return new ListAllResponse();
    }

    /**
     * Create an instance of {@link CreateProducto }
     * 
     */
    public CreateProducto createCreateProducto() {
        return new CreateProducto();
    }

    /**
     * Create an instance of {@link GetProductoByCodigoResponse }
     * 
     */
    public GetProductoByCodigoResponse createGetProductoByCodigoResponse() {
        return new GetProductoByCodigoResponse();
    }

    /**
     * Create an instance of {@link GetProductoByCodigo }
     * 
     */
    public GetProductoByCodigo createGetProductoByCodigo() {
        return new GetProductoByCodigo();
    }

    /**
     * Create an instance of {@link CreateProductoResponse }
     * 
     */
    public CreateProductoResponse createCreateProductoResponse() {
        return new CreateProductoResponse();
    }

    /**
     * Create an instance of {@link ListAll }
     * 
     */
    public ListAll createListAll() {
        return new ListAll();
    }

    /**
     * Create an instance of {@link WSSoapException }
     * 
     */
    public WSSoapException createWSSoapException() {
        return new WSSoapException();
    }

    /**
     * Create an instance of {@link CreateProductoDTO }
     * 
     */
    public CreateProductoDTO createCreateProductoDTO() {
        return new CreateProductoDTO();
    }

    /**
     * Create an instance of {@link Producto }
     * 
     */
    public Producto createProducto() {
        return new Producto();
    }

    /**
     * Create an instance of {@link TipoProducto }
     * 
     */
    public TipoProducto createTipoProducto() {
        return new TipoProducto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WSSoapException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.educacionit.com.ar/", name = "WSSoapException")
    public JAXBElement<WSSoapException> createWSSoapException(WSSoapException value) {
        return new JAXBElement<WSSoapException>(_WSSoapException_QNAME, WSSoapException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.educacionit.com.ar/", name = "createProductoResponse")
    public JAXBElement<CreateProductoResponse> createCreateProductoResponse(CreateProductoResponse value) {
        return new JAXBElement<CreateProductoResponse>(_CreateProductoResponse_QNAME, CreateProductoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.educacionit.com.ar/", name = "listAll")
    public JAXBElement<ListAll> createListAll(ListAll value) {
        return new JAXBElement<ListAll>(_ListAll_QNAME, ListAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductoByCodigo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.educacionit.com.ar/", name = "getProductoByCodigo")
    public JAXBElement<GetProductoByCodigo> createGetProductoByCodigo(GetProductoByCodigo value) {
        return new JAXBElement<GetProductoByCodigo>(_GetProductoByCodigo_QNAME, GetProductoByCodigo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.educacionit.com.ar/", name = "createProducto")
    public JAXBElement<CreateProducto> createCreateProducto(CreateProducto value) {
        return new JAXBElement<CreateProducto>(_CreateProducto_QNAME, CreateProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.educacionit.com.ar/", name = "listAllResponse")
    public JAXBElement<ListAllResponse> createListAllResponse(ListAllResponse value) {
        return new JAXBElement<ListAllResponse>(_ListAllResponse_QNAME, ListAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductoByCodigoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.educacionit.com.ar/", name = "getProductoByCodigoResponse")
    public JAXBElement<GetProductoByCodigoResponse> createGetProductoByCodigoResponse(GetProductoByCodigoResponse value) {
        return new JAXBElement<GetProductoByCodigoResponse>(_GetProductoByCodigoResponse_QNAME, GetProductoByCodigoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DuplicatesSoapException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.educacionit.com.ar/", name = "DuplicatesSoapException")
    public JAXBElement<DuplicatesSoapException> createDuplicatesSoapException(DuplicatesSoapException value) {
        return new JAXBElement<DuplicatesSoapException>(_DuplicatesSoapException_QNAME, DuplicatesSoapException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.educacionit.com.ar/", name = "eliminarProducto")
    public JAXBElement<EliminarProducto> createEliminarProducto(EliminarProducto value) {
        return new JAXBElement<EliminarProducto>(_EliminarProducto_QNAME, EliminarProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.educacionit.com.ar/", name = "eliminarProductoResponse")
    public JAXBElement<EliminarProductoResponse> createEliminarProductoResponse(EliminarProductoResponse value) {
        return new JAXBElement<EliminarProductoResponse>(_EliminarProductoResponse_QNAME, EliminarProductoResponse.class, null, value);
    }

}
