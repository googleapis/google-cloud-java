package com.google.gcloud.datastore;

import java.util.Iterator;

/**
 * An interface for Google Cloud Datastore.
 */
public interface DatastoreService extends DatastoreReader, DatastoreWriter {

  /**
   * Returns the {@code DatastoreServiceOptions} for this service.
   */
  DatastoreServiceOptions getOptions();

  /**
   * Returns a key builder for the requested {@code kind}.
   * The key would be initialized with the this service dataset and default namespace.
   */
  KeyBuilder newKeyBuilder(String kind);

  /**
   * Returns a new Datastore transaction.
   *
   * @throws DatastoreServiceExcepiton upon failure
   */
  Transaction newTransaction(TransactionOption... transactionOption);

  /**
   * Returns a new Batch writer for processing multiple write operations
   * in one request.
   */
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
  Iterator<Key> allocateIds(PartialKey... key);

  /**
   * @see DatastoreWriter#add(Entity...)
   * @throws DatastoreServiceExcepiton upon failure
   */
  @Override
  void add(Entity... entity);

  /**
   * @see DatastoreWriter#update(Entity...)
   * @throws DatastoreServiceExcepiton upon failure
   */
  @Override
  void update(Entity... entity);

  /**
   * @see DatastoreWriter#put(Entity...)
   * @throws DatastoreServiceExcepiton upon failure
   */
  @Override
  void put(Entity... entity);

  /**
   * @see DatastoreWriter#delete(Key...)
   * @throws DatastoreServiceExcepiton upon failure
   */
  @Override
  void delete(Key... key);
}
