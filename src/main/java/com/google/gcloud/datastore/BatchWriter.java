package com.google.gcloud.datastore;

/**
 * An interface to represent a batch of write operations.
 * Any write operation that is applied on a batch will only be sent
 * to the Datastore upon {@link #submit} and with as few RPC calls as possible.
 */
public interface BatchWriter extends DatastoreWriter {

  /**
   * {@inheritDoc}
   * @throws DatastoreServiceException if a given entity already added to this batch
   */
  @Override
  void add(Entity... entity);

  /**
   * {@inheritDoc}
   * @throws DatastoreServiceException if an entity is marked for deletion in this batch
   */
  @Override
  void update(Entity... entity);

  /**
   * Submit the batch to the Datastore.
   *
   * @throws DatastoreServiceException if there was any failure.
   */
  void submit();
}
