# database

[db-engines](https://db-engines.com/en/articles)
- Relational DBMS

  - Relational database management systems (RDBMS) support the relational (=table-oriented) data model. The schema of a table (=relation schema) is defined by the table name and a fixed number of attributes with fixed data types. A record (=entity) corresponds to a row in the table and consists of the values of each attribute. A relation thus consists of a set of uniform records.

  - Examples:
    1.  Oracle
    2.  MySQL
    3.  Microsoft SQL Server
    4.  PostgreSQL
    5.  IBM Db2


- Key value stores
  - Key value stores are probably the simplest form of database management systems. They can only store pairs of keys and values, as well as retrieve values when a key is known.

  -  These simple systems are normally not adequate for complex applications. On the other hand, it is exactly this simplicity, that makes such systems attractive in certain circumstances. For example resource-efficient key-value stores are often applied in embedded systems or as high performance in-process databases.

  - Examples
    1.  Redis [link](https://github.com/abhishek-honey/database/tree/master/redis)
    2.  Amazon DynamoDB
    3.  Microsoft Azure Cosmos DB
    4.  Memcached
    5.  Hazelcast


- Document stores
  - Document stores, also called document-oriented database systems, are characterized by their schema-free organization of data.

  - Document stores often use internal notations, which can be processed directly in applications, mostly JSON. JSON documents of course can also be stored as pure text in key-value stores or relational database systems. That would, however, require client-side processing of the structures, which has the disadvantage that the features offered by document stores (such as secondary indexes) are not available.
  - Examples

    1.  MongoDB
    2.  Amazon DynamoDB
    3.  Microsoft Azure Cosmos DB
    4.  Couchbase
    5.  CouchDB


- Time Series DBMS
  - A Time Series DBMS is a database management system that is optimized for handling time series data: each entry is associated with a timestamp.

  - For example, time series data may be produced by sensors, smart meters or RFIDs in the so-called Internet of Things, or may depict the stock tickers of a high frequency stock trading system.
  - Examples

    1.  InfluxDB
    2.  Kdb+
    3.  Prometheus
    4.  Graphite
    5.  RRDtool


- Graph DBMS
  - Graph DBMS, also called graph-oriented DBMS or graph database, represent data in graph structures as nodes and edges, which are relationships between nodes. They allow easy processing of data in that form, and simple calculation of specific properties of the graph, such as the number of steps needed to get from one node to another node.

  - Graph DBMSs usually don't provide indexes on all nodes, direct access to nodes based on attribute values is not possible in these cases.
  - Examples

    1.  Neo4j
    2.  Microsoft Azure Cosmos DB
    3.  ArangoDB
    4.  OrientDB
    5.  Virtuoso


- Search engines
  - Search engines are NoSQL database management systems dedicated to the search for data content.

  - Features
    *   Support for complex search expressions
    *   Full text search
    *   Stemming (reducing inflected words to their stem)
    *   Ranking and grouping of search results
    *   Geospatial search
    *   Distributed search for high scalability

  - Examples
    1.  Neo4j
    2.  Microsoft Azure Cosmos DB
    3.  ArangoDB
    4.  OrientDB
    5.  Virtuoso


- Object oriented DBMS
  - Object oriented database management systems (often referred to as object databases) were developed in the 1980s motivated by the common use of object-oriented programming languages. The goal was to be able to simply store the objects in a database in a way that corresponds to their representation in a programming language, without the need of conversion or decomposition. Additionally, the relationships between the objects, e.g. inheritance should also be maintained in the database.

  - An object oriented DBMS thus follows an object oriented data model with classes (the schema of objects), properties and methods. An object is always managed as a whole. This means for example, that the insertion of an object, which in a relational system would probably be stored in multiple tables, will be performed automatically as one atomic transaction - without any action by the application program . Reading an object can also be done as a single operation and without complex joins.
  - Examples

    1.  InterSystems Caché
    2.  Versant Object Database
    3.  Db4o
    4.  ObjectStore
    5.  Matisse


- RDF stores
  - The Resource Description Framework (RDF) is a methodology for the description of information, originally developed for describing metadata of IT resources. Today it is used much more generally, often in connection with the sematic web, but also in other applications.

  - The RDF model represents information as triples in the form of subject-predicate-object.

  - Examples
    1.  MarkLogic
    2.  Apache Jena - TDB
    3.  Virtuoso
    4.  Amazon Neptune
    5.  GraphDB


- Wide column stores
  - Wide column stores, also called extensible record stores, store data in records with an ability to hold very large numbers of dynamic columns. Since the column names as well as the record keys are not fixed, and since a record can have billions of columns, wide column stores can be seen as two-dimensional key-value stores.

  - Examples
    1.  Cassandra
    2.  HBase
    3.  Microsoft Azure Cosmos DB


- Multivalue DBMS
  - Multivalue DBMS are database management systems, which - similar to relational systems - store data in tables. However, other than RDBMSs, they can assign more than one value to a record's attribute. As this contradicts the first normal form, these systems are sometimes called NF2 (non-first normal form) systems.

  - Examples
    1.  Adabas
    2.  UniData,UniVerse
    3.  jBASE


- Native XML DBMS
  - Native XML DBMS's (sometimes abbreviated as NXD) are database management systems, whose internal data model corresponds to XML documents.

  - In contrast to XML-enabled DBMS's, which use for example a relational data model and are only capable of also storing data as XML documents, Native XML DBMS's use the full power of XML. They can represent hierarchical data, they understand embedded PCDATA declarations in XML elements, and they support XML-specific query languages such as XPath, XQuery or XSLT.

  - Examples
    1.  MarkLogic
    2.  Oracle Berkeley DB
    3.  Virtuoso


- Event Stores
  - Event stores are database management systems implementing the concept of event sourcing. They persists all state changing events for an object together with a timestamp, thereby creating time series for individual objects. The current state of an object can be inferred by replaying all events for that object from time 0 till the current time.

  - In contrast, the other types of DBMS store the current state of an object (and loose the history, if not explicitly modelled).

  - As an example, for a shopping cart object each insertion of a product (product name, quantity, price) would be persisted as a new event.

  - Examples
    1.  Event Store
    2.  IBM Db2 Event Store
    3.  NEventStore


- Content stores
  - Content stores, also called content repositories, are database management systems specialized in the management of digital content, such as text, pictures or videos, including their metadata.

  - In addition to the storage and queries, normally using SQL or XPath, features that are typically supported are full text search, versioning, hierarchically structured content, and access control.

  - Examples
    1.  Jackrabbit
    2.  ModeShape


- Navigational DBMS
  - The term navigational DBMS describes a class of database management systems, that allow access to data sets only via linked records. Such systems were developed in the 1960s. They were the first established systems able to manage large amounts of data. Depending on the flexibility of linking, they are grouped into hierarchical DBMS and network DBMS.

  - Examples
    1.  IMS by IBM, and
    2.  IDMS by Computer Associates
