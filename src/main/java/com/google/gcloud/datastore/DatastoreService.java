package com.google.gcloud.datastore;

import java.util.Iterator;

/**
 * An interface for Google Cloud Datastore dataset.
 */
public interface DatastoreService extends DatastoreReaderWriter {

  /**
   * Returns the {@code DatastoreServiceOptions} for this service.
   */
  DatastoreServiceOptions options();

  /**
   * Returns a new Datastore transaction.
   *
   * @throws DatastoreServiceExcepiton upon failure
   */
  Transaction newTransaction(TransactionOption... options);

  /**
   * Returns a new Batch writer for processing multiple write operations
   * in one request.
   */
  BatchWriter newBatchWriter(BatchWriteOption... options);

  /**
   * Allocate a unique id for the given key.
   * The returned key will have the same information (dataset, kind, namespace and ancestors)
   * as the given key and will have a newly assigned id.
   *
   * @throws DatastoreServiceExcepiton upon failure
   */
  Key allocateId(PartialKey key);

  /**
   * Returns a list of keys using the allocated ids ordered by the input.
   *
   * @see #allocateId(PartialKey)
   * @throws DatastoreServiceExcepiton upon failure
   */
  Iterator<Key> allocateId(PartialKey key, PartialKey... others);

  /**
   * {@inheritDoc}
   * @throws DatastoreServiceExcepiton upon failure
   */
  @Override
  void add(Entity... entity);

  /**
   * {@inheritDoc}
   * @throws DatastoreServiceExcepiton upon failure
   */
  @Override
  void update(Entity... entity);

  /**
   * {@inheritDoc}
   * @throws DatastoreServiceExcepiton upon failure
   */
  @Override
  void put(Entity... entity);

  /**
   * {@inheritDoc}
   * @throws DatastoreServiceExcepiton upon failure
   */
  @Override
  void delete(Key... key);
}
