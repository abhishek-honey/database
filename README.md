# database

[db-engines](https://db-engines.com/en/articles)
- Relational DBMS

  - Relational database management systems (RDBMS) support the relational (=table-oriented) data model. The schema of a table (=relation schema) is defined by the table name and a fixed number of attributes with fixed data types. A record (=entity) corresponds to a row in the table and consists of the values of each attribute. A relation thus consists of a set of uniform records.

  - Examples:
    1. Oracle
    - MySQL
    - Microsoft SQL Server
    - PostgreSQL
    - IBM Db2


- Key value stores
  - Key value stores are probably the simplest form of database management systems. They can only store pairs of keys and values, as well as retrieve values when a key is known.

  -  These simple systems are normally not adequate for complex applications. On the other hand, it is exactly this simplicity, that makes such systems attractive in certain circumstances. For example resource-efficient key-value stores are often applied in embedded systems or as high performance in-process databases.

  - Examples
    1. Redis [link](https://github.com/abhishek-honey/database/tree/master/redis)
    - Amazon DynamoDB
    - Microsoft Azure Cosmos DB
    - Memcached
    - Hazelcast


- Document stores
  - Document stores, also called document-oriented database systems, are characterized by their schema-free organization of data.

  - Document stores often use internal notations, which can be processed directly in applications, mostly JSON. JSON documents of course can also be stored as pure text in key-value stores or relational database systems. That would, however, require client-side processing of the structures, which has the disadvantage that the features offered by document stores (such as secondary indexes) are not available.
  - Examples
    1. MongoDB
    - Amazon DynamoDB
    - Microsoft Azure Cosmos DB
    - Couchbase
    - CouchDB


- Time Series DBMS
  - A Time Series DBMS is a database management system that is optimized for handling time series data: each entry is associated with a timestamp.

  - For example, time series data may be produced by sensors, smart meters or RFIDs in the so-called Internet of Things, or may depict the stock tickers of a high frequency stock trading system.
  - Examples
    1. InfluxDB
    - Kdb+
    - Prometheus
    - Graphite
    - RRDtool


- Graph DBMS
  - Graph DBMS, also called graph-oriented DBMS or graph database, represent data in graph structures as nodes and edges, which are relationships between nodes. They allow easy processing of data in that form, and simple calculation of specific properties of the graph, such as the number of steps needed to get from one node to another node.

  - Graph DBMSs usually don't provide indexes on all nodes, direct access to nodes based on attribute values is not possible in these cases.
  - Examples
    1.  Neo4j
    - Microsoft Azure Cosmos DB
    - ArangoDB
    - OrientDB
    - Virtuoso


- Search engines
  - Search engines are NoSQL database management systems dedicated to the search for data content.

  - Support for complex search expressions

  - Full text search

  - Stemming (reducing inflected words to their stem)

  - Ranking and grouping of search results

  - Geospatial search

  - Distributed search for high scalability
  - Examples
    1.  Neo4j
    - Microsoft Azure Cosmos DB
    - ArangoDB
    - OrientDB
    - Virtuoso
- Object oriented DBMS

- RDF stores

- Wide column stores

- Multivalue DBMS

- Native XML DBMS

- Event Stores

- Content stores

- Navigational DBMS
