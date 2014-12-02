package com.google.gcloud.datastore;

public interface BatchWriter extends DatastoreWriter {

  void submit();
}