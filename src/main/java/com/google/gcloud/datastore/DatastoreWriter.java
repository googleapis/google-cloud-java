package com.google.gcloud.datastore;

/**
 * An interface to represent Google Cloud Datastore write operations.
 */
public interface DatastoreWriter {

  /**
   * A Datastore add operation.
   * The operation will fail if an entity with the same key already exists.
   */
  void add(Entity... entity);

  /**
   * A Datastore update operation.
   * The operation will fail if an entity with the same key does not already exist.
   */
  void update(Entity... entity);

  /**
   * A Datastore put (a.k.a upsert) operation.
   * The operation will add or modify the entities.
   */
  void put(Entity... entity);

  /**
   * A datastore delete operation.
   * It is OK request a deletion of a non-existing entity.
   */
  void delete(Key... key);
}
