package com.google.gcloud.datastore;

public interface BatchWriter extends DatastoreWriter {

  /**
   * Submit the batch to the Datastore.
   *
   * @throws DatastoreServiceException if there was any failure.
   */
  void submit();
}
