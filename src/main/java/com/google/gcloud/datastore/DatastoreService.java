package com.google.gcloud.datastore;

import java.util.Iterator;

public interface DatastoreService extends DatastoreReader, DatastoreWriter {

  interface Query {

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

    boolean force();
  }

  public interface BatchWriter extends DatastoreWriter {

    void submit();
  }

  public interface BatchOptions {
  }

  DatastoreServiceOptions getOptions();

  Transaction newTransaction(TransactionOptions transactionOptions);

  BatchWriter newBatchWriter(BatchOptions batchOptions);

  Key allocateId(IncompleteKey key);

  // results are returned using request order
  Iterator<Key> allocateIds(IncompleteKey... key);
}
