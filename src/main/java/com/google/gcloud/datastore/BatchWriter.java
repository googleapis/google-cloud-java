package com.google.gcloud.datastore;

/**
 * An interface to represent a batch of write operations.
 * Any write operation that is applied on a batch will only be sent
 * to the Datastore upon {@link #submit} and with as few RPC calls as possible.
 * A usage example:
 * <pre> {@code
 *   Entity entity1 = datastore.get(key1);
 *   BatchWriter batchWriter = datastore.newBatchWriter();
 *   Entity entity2 = Entity.builder(key2).set("name", "John").build();
 *   entity1 = Entity.builder(entity1).clear().setNull("bla").build();
 *   Entity entity3 = Entity.builder(key3).set("title", new StringValue("title")).build();
 *   batchWriter.update(entity1);
 *   batchWriter.add(entity2, entity3);
 *   batchWriter.submit();
 * } </pre>
 */
public interface BatchWriter extends DatastoreWriter {

  /**
   * {@inheritDoc}
   * This operation will be converted to {@link #put} operation for entities that were already
   *     marked for deletion in this batch.
   * @throws DatastoreServiceException if a given entity already added to this batch or if batch
   *     is no longer active
   */
  @Override
  void add(Entity... entity);

  /**
   * {@inheritDoc}
   * This operation will be converted to {@link #put} operation for entities that were already
   *     added or put in this batch.
   * @throws DatastoreServiceException if an entity is marked for deletion in this batch or if
   *     batch is no longer active
   */
  @Override
  void update(Entity... entity);

  /**
   * {@inheritDoc}
   * This operation will also remove from this batch any prior writes for entities with the same
   *     keys.
   * @throws DatastoreServiceException if batch is no longer active
   */
  @Override
  public void delete(Key... key);

  /**
   * {@inheritDoc}
   * This operation will also remove from this batch any prior writes for the same entities.
   * @throws DatastoreServiceException if batch is no longer active
   */
  @Override
  public void put(Entity... entity);

  /**
   * Submit the batch to the Datastore.
   *
   * @throws DatastoreServiceException if there was any failure or if batch is not longer active
   */
  void submit();

  /**
   * Returns {@code true} if batch is still active (was not submitted).
   */
  boolean active();
}
