package com.google.gcloud.datastore;

import java.util.Iterator;

/**
 * A Google cloud datastore transaction.
 * Any write operation that is applied on a transaction will only be sent
 * to the Datastore upon {@link #commit}. A call to {@link #rollback} will invalidate
 * the transaction and discard the changes. Any read operation that is done by a transaction
 * will be part of it and therefore a {@code commit} is guaranteed to fail if an entity
 * was modified outside of the transaction after it was read. Write operation on this
 * transaction will not be reflected by read operation (as the changes are only sent to
 * the Datastore upon {@code commit}.
 * A usage example:
 * <pre> {@code
 *   Transaction transaction = datastore.newTransaction();
 *   try {
 *     Entity entity = transaction.get(key);
 *     if (!entity.contains("last_name") || entity.isNull("last_name")) {
 *       String[] name = entity.getString("name").split(" ");
 *       entity = Entity.builder(entity).remove("name").set("first_name", name[0])
 *           .set("last_name", name[1]).build();
 *       transaction.update(entity);
 *       transaction.commit();
 *     }
 *   } finally {
 *     if (transaction.active()) {
 *       transaction.rollback();
 *     }
 *   }
 * } </pre>
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/transactions">Google Cloud Datastore transactions</a>
 *
 */
public interface Transaction extends DatastoreReader, DatastoreWriter {

  /**
   * {@inheritDoc}
   * The requested entity will be part of this Datastore transaction (so a commit is guaranteed
   * to fail if entity was changed by others after it was seen by this transaction) but any
   * write changes in this transaction will not be reflected by the returned entity.
   *
   * @throws DatastoreServiceException upon failure.
   */
  @Override
  Entity get(Key key);

  /**
   * {@inheritDoc}
   * The requested entities will be part of this Datastore transaction (so a commit is guaranteed
   * to fail if any of the entities was changed by others after they were seen by this transaction)
   * but any write changes in this transaction will not be reflected by the returned entities.
   *
   * @throws DatastoreServiceException upon failure.
   */
  @Override
  Iterator<Entity> get(Key key, Key... others);

  /**
   * {@inheritDoc}
   * The entities returned by the result of this query will be part of this Datastore transaction
   * (so a commit is guaranteed to fail if any of the entities was changed by others after the
   * query was performed) but any write changes in this transaction will not be reflected by
   * the result.
   *
   * @throws DatastoreServiceException upon failure.
   */
  @Override
  <T> QueryResult<T> runQuery(Query<T> query);

  /**
   * Commit the transaction.
   *
   * @throws DatastoreServiceException if could not commit the transaction
   */
  void commit();

  /**
   * Rollback the transaction.
   */
  void rollback();

  /**
   * Returns {@code true} if the transaction is still active (was not committed or rolledback).
   */
  boolean active();
}
