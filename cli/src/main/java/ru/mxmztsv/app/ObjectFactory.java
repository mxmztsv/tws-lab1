
package ru.mxmztsv.app;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.mxmztsv.app package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
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

    private final static QName _ClientSearchResponse_QNAME = new QName("http://app.mxmztsv.ru/", "ClientSearchResponse");
    private final static QName _ParseException_QNAME = new QName("http://app.mxmztsv.ru/", "ParseException");
    private final static QName _SearchClients_QNAME = new QName("http://app.mxmztsv.ru/", "searchClients");
    private final static QName _SearchClientsResponse_QNAME = new QName("http://app.mxmztsv.ru/", "searchClientsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.mxmztsv.app
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClientSearchResponseType }
     * 
     */
    public ClientSearchResponseType createClientSearchResponseType() {
        return new ClientSearchResponseType();
    }

    /**
     * Create an instance of {@link ParseException }
     * 
     */
    public ParseException createParseException() {
        return new ParseException();
    }

    /**
     * Create an instance of {@link SearchClients }
     * 
     */
    public SearchClients createSearchClients() {
        return new SearchClients();
    }

    /**
     * Create an instance of {@link SearchClientsResponse }
     * 
     */
    public SearchClientsResponse createSearchClientsResponse() {
        return new SearchClientsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientSearchResponseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClientSearchResponseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://app.mxmztsv.ru/", name = "ClientSearchResponse")
    public JAXBElement<ClientSearchResponseType> createClientSearchResponse(ClientSearchResponseType value) {
        return new JAXBElement<ClientSearchResponseType>(_ClientSearchResponse_QNAME, ClientSearchResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}
     */
    @XmlElementDecl(namespace = "http://app.mxmztsv.ru/", name = "ParseException")
    public JAXBElement<ParseException> createParseException(ParseException value) {
        return new JAXBElement<ParseException>(_ParseException_QNAME, ParseException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchClients }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchClients }{@code >}
     */
    @XmlElementDecl(namespace = "http://app.mxmztsv.ru/", name = "searchClients")
    public JAXBElement<SearchClients> createSearchClients(SearchClients value) {
        return new JAXBElement<SearchClients>(_SearchClients_QNAME, SearchClients.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchClientsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchClientsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://app.mxmztsv.ru/", name = "searchClientsResponse")
    public JAXBElement<SearchClientsResponse> createSearchClientsResponse(SearchClientsResponse value) {
        return new JAXBElement<SearchClientsResponse>(_SearchClientsResponse_QNAME, SearchClientsResponse.class, null, value);
    }

}
