package com.google.gcloud.datastore;

/**
 * A Google cloud datastore transaction.
 */
public interface Transaction extends DatastoreReader, DatastoreWriter {

  void commit();

  void rollback();
}
