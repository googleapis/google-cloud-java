package com.google.gcloud.datastore;

import java.util.Iterator;
import java.util.Map;

public interface DatastoreService {

  interface DatastoreReader {

    Map<String, Property<?, ?, ?>> get(Key key);

    // return the result in the given order
    Iterator<Map<String, Property<?, ?, ?>>> get(Iterator<Key> key);

    // query result item is a tuple of (key, value...) where values may be empty
    //QueryResult runQuery(Query query);
  }


  interface DatastoreWriter {

    Key add(IncompleteKey key, Map<String, Property<?, ?, ?>> values);

    void update(Key key , Map<String, Property<?, ?, ?>> values);

    Key put(IncompleteKey key, Map<String, Property<?, ?, ?>> values);

    void delete(Key key);
  }


  public interface Transaction extends DatastoreReader, DatastoreWriter {

    void commit();

    void rollback();
  }

  public interface TransactionOptions {

    enum IsolationLevel {
      SERIALIZABLE, SNAPSHOT;
    }

    IsolationLevel getIsolationLevel();
  }

  public interface Batch extends DatastoreWriter {

    @Override
    void add(Key key, Map<String, Property<?, ?, ?>> values);

    @Override
    void update(Key key , Map<String, Property<?, ?, ?>> values);

    @Override
    void put(Key key, Map<String, Property<?, ?, ?>> values);

    void submit();
  }

  public interface BatchOptions {

  }

  DatastoreServiceOptions getOptions();

  Transaction newTransaction(TransactionOptions tsOptions);

  Batch newBatch();

  P

  Key allocateId(IncompleteKey key);

  // results are returned in request order
  Iterator<Key> allocateIds(Iterator<IncompleteKey> key);
}
