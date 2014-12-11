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

  /**
   * Returns {@code true} if batch is still active (was not submitted).
   */
  boolean active();
}
