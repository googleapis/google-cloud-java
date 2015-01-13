package com.google.gcloud.datastore;

import java.util.List;

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
   * @throws DatastoreServiceException upon failure
   */
  Transaction newTransaction(TransactionOption... options);

  /**
   * Returns a new Batch for processing multiple write operations in one request.
   */
  Batch newBatch(BatchOption... options);

  /**
   * Allocate a unique id for the given key.
   * The returned key will have the same information (dataset, kind, namespace and ancestors)
   * as the given key and will have a newly assigned id.
   *
   * @throws DatastoreServiceException upon failure
   */
  Key allocateId(PartialKey key);

  /**
   * Returns a list of keys using the allocated ids ordered by the input.
   *
   * @throws DatastoreServiceException upon failure
   * @see #allocateId(PartialKey)
   */
  List<Key> allocateId(PartialKey... key);

  /**
   * Datastore add operation.
   * This method will automatically allocate an id if necessary.
   *
   * @param entity the entity to add
   * @return an {@code Entity} with the same properties and a key that is either newly allocated
   *     or the same one if was already complete
   * @throws DatastoreServiceException upon failure
   * @throws IllegalArgumentException if the given entity is missing a key
   */
  Entity add(PartialEntity entity);

  /**
   * Datastore add operation.
   * This method will automatically allocate id for any entity with incomplete key.
   *
   * @return a list of {@code Entity} ordered by input with the same properties and a key that is
   *     either newly allocated or the same one if was already complete
   * @throws DatastoreServiceException upon failure
   * @throws IllegalArgumentException if any of the given entities is missing a key
   * @see #add(PartialEntity)
   */
  List<Entity> add(PartialEntity... entity);

  /**
   * {@inheritDoc}
   * @throws DatastoreServiceException upon failure
   */
  @Override
  void add(Entity... entity);

  /**
   * {@inheritDoc}
   * @throws DatastoreServiceException upon failure
   */
  @Override
  void update(Entity... entity);

  /**
   * {@inheritDoc}
   * @throws DatastoreServiceException upon failure
   */
  @Override
  void put(Entity... entity);

  /**
   * {@inheritDoc}
   * @throws DatastoreServiceException upon failure
   */
  @Override
  void delete(Key... key);
}
