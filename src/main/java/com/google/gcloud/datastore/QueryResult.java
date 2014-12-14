package com.google.gcloud.datastore;

import java.util.Iterator;

/**
 * The result of a Google Cloud Datastore query submission.
 * When the result is not typed it is possible to cast it to its appropriate type according to
 * the {@link #getType} result.
 *
 * @param V the type of values the result holds.
 */
public interface QueryResult<T> extends Iterator<T> {

  /**
   * Returns the actual type of the result's values.
   * When needed the result could be casted accordingly:
   * <pre> {@code
   * Type.FULL -> (QueryResult<Entity>)
   * Type.PROJECTION -> (QueryResult<PartialEntity>)
   * Type.KEY_ONLY -> (QueryResult<Key>)
   * } </pre>
   */
  Query.Type getType();

  /**
   * Return the Cursor for the next result. Not currently implemented (depends on v1beta3).
   */
  Cursor getCursor();
}
