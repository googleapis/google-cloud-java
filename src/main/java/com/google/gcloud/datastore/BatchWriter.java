package com.google.gcloud.datastore;

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
