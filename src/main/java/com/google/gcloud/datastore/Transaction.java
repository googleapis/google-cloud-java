package com.google.gcloud.datastore;

import java.util.Iterator;

/**
 * A Google cloud datastore transaction.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/transactions">Google Cloud Datastore transactions</a>
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
  QueryResult<PartialEntity> runQuery(Query query);

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
}
