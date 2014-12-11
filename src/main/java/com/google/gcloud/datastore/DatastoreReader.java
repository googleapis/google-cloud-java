package com.google.gcloud.datastore;

import java.util.Iterator;

/**
 * An interface to represent Google Cloud Datastore read operations.
 */
public interface DatastoreReader {

  /**
   * Returns an {@link Entity} for the given {@link Key} or {@code null} if does not exists.
   *
   * @throws DatastoreServiceException upon failure.
   */
  Entity get(Key key);

  /**
   * Returns an {@link Entity} for each given {@link Key} or {@code null} if does not exists
   * ordered by input.
   *
   * @throws DatastoreServiceException upon failure.
   */
  Iterator<Entity> get(Key key, Key... others);

  /**
   * Submit a {@link Query} and returns its result.
   *
   * @throws DatastoreServiceException upon failure.
   */
  <T> QueryResult<T> runQuery(Query<T> query);
}
