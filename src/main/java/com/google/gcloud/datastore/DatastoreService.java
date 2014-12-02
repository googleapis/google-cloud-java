package com.google.gcloud.datastore;

import java.util.Iterator;

public interface DatastoreService extends DatastoreReader, DatastoreWriter {

  enum QueryType {
    PROJECTION,
    FULL;
  }

  /*
  interface QueryResult<T> {

  }

  // consider 2 types of queries regualr and Gql
  interface Query {
    QueryResult<T> keysOnly(QueryType query);
  }
*/


  DatastoreServiceOptions getOptions();

  KeyBuilder newKeyBuilder(String kind);

  /**
   * Returns a new Datastore transaction.
   *
   * @throws DatastoreServiceExcepiton upon failure
   */
  Transaction newTransaction(TransactionOption... transactionOption);

  BatchWriter newBatchWriter(BatchWriteOption... batchWriteOption);

  /**
   * Returns a key with a newly allocated id.
   *
   * @throws DatastoreServiceExcepiton upon failure
   */
  Key allocateId(PartialKey key);

  /**
   * Returns a list of keys using the allocated ids ordered by the input.
   *
   * @throws DatastoreServiceExcepiton upon failure
   */
  // results are returned using request order
  Iterator<Key> allocateIds(PartialKey... key);
}
