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
   * Returns an {@link Entity} for each given {@link Key} that exists in the Datastore.
   * The order of the result is unspecified.
   * Results are loaded lazily therefore it is possible to get a {@code DatastoreServiceException}
   * from the returned {@code Iterator}'s {@link Iterator#hasNext hasNext} or
   * {@link Iterator#next next} methods.
   *
   * @throws DatastoreServiceException upon failure.
   * @see #get(Key)
   */
  Iterator<Entity> get(Key... key);

  /**
   * Submit a {@link Query} and returns its result.
   *
   * @throws DatastoreServiceException upon failure.
   */
  <T> QueryResult<T> run(Query<T> query);
}
