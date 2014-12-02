package com.google.gcloud.datastore;

public interface Transaction extends DatastoreReader, DatastoreWriter {

  void commit();

  void rollback();
}