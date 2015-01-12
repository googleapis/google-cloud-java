package com.google.gcloud.datastore;

/**
 * An interface to represent a batch of write operations.
 * Any write operation that is applied on a batch will only be sent
 * to the Datastore upon {@link #submit}.
 * A usage example:
 * <pre> {@code
 *   Entity entity1 = datastore.get(key1);
 *   Batch batch = datastore.newBatch();
 *   Entity entity2 = Entity.builder(key2).set("name", "John").build();
 *   entity1 = Entity.builder(entity1).clear().setNull("bla").build();
 *   Entity entity3 = Entity.builder(key3).set("title", "title").build();
 *   batch.update(entity1);
 *   batch.add(entity2, entity3);
 *   batch.submit();
 * } </pre>
 */
public interface Batch extends DatastoreBatchWriter {

  interface Response extends DatastoreBatchWriter.Response {
  }

  /**
   * Submit the batch to the Datastore.
   *
   * @throws DatastoreServiceException if there was any failure or if batch is not longer active
   */
  Response submit();
}
