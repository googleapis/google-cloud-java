package com.google.gcloud.datastore;

/**
 * A Google cloud datastore transaction.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/transactions">Google Cloud Datastore transactions</a>
 */
public interface Transaction extends DatastoreReader, DatastoreWriter {

  /**
   * Commit the transaction.
   *
   * @throws DatastoreServiceException if could not commit the transaction
   */
  void commit();

  /**
   * Rollback the transaction.
   */
  void rollback();
}
