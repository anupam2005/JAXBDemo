package com.anupam.jaxb;

import com.anupam.jaxb.domain.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.util.Arrays;

public class MarshellerDemo1 {

    public static void main(String[] args) throws JAXBException {

        PurchaseOrder purchaseOrder = createPurchaseOrder();

        //Create JAXBContext
        JAXBContext jaxbContext = JAXBContext.newInstance(PurchaseOrder.class);

        //Create Marshaller
        Marshaller marshaller = jaxbContext.createMarshaller();

        //Formatt the output
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        //Create JAXB element Wrapper
        QName rootElementName = new QName(null, "purchaseOrder");
        JAXBElement<PurchaseOrder> rootElement = new JAXBElement<PurchaseOrder>(rootElementName,PurchaseOrder.class,purchaseOrder);

        //Print output in console
        marshaller.marshal(rootElement,System.out);




    }

    private static PurchaseOrder createPurchaseOrder() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();

        Item item1 = new Item();
        item1.setProductName("Ballpoint Pen");
        item1.setQuantity(20);
        item1.setPrice(new BigDecimal("8.95"));
        item1.setComment("Blue ink");

        Item item2 = new Item();
        item2.setProductName("Pencil");
        item2.setQuantity(10);
        item2.setPrice(new BigDecimal("2.95"));

        purchaseOrder.setItems(Arrays.asList(item1, item2));

        Customer customer = new Customer();
        customer.setName("John Doe");

        Address address = new Address();
        address.setStreet("123 Main Street");
        address.setCity("Exampleville");
        address.setPostalCode("12345");
        address.setCountry("USA");

        customer.setShippingAddress(address);
        customer.setBillingAddress(address);
        customer.setLoyalty(Loyalty.SILVER);

        purchaseOrder.setCustomer(customer);

        return purchaseOrder;
    }
}
