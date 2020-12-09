**JAXB - Java Arachiteacture for XML binding**

Converts java objects to xml & vice versa.

Apart from the other xml processing apis
DOM - Document Object Model
SAX - Simple API for XML
StAX - Streaming API for XML

DOM - In memory tree-node, Easy to use, doesn't scale well for larger documents. Package: org.w3c.dom

SAX -  Event-Based (Push based - Parser in control), use callback methods, does not load full doc in memory. Cumbersome to use but efficient with larger docs too.
Package: org.xml.sax

StAX - Event-Based (Pull based - Program in control), Easier that SAX but still lower-level API (more boilerplate)

JAXB- High level API, Needs XSD and java code both, Code first (Java -> XSL)& configuration first (XSD -> Java).

xml namespaces are like java packages. The looks like an http url but does not have to point to an actual resource on the web. Java parsers consider them just as another string.

The entry point of this API is class JAXBContext
Factory method: newInstance
JAVA to XML -> Marshelling
XML to JAVA -> Unmarshelling
Binder
JAXBIntrospector

The factory method provides a way to implement alternative implementation
e.g. Eclipselink MoXy

An alternative implementation is used for:
Extra features
Better performance

Best Practices:

Create JAXBXontext only once & reuse
-Expensive to create
-ThreadSafe

Do not reuse Marsheller, Unmarsheller
-Not threadsafe
-Not expensive to create
