package com.google.gcloud.datastore;

import java.util.Iterator;

/**
 * A result of Google Cloud Datastore query.
 */
public interface QueryResult<V extends Object> extends Iterator<V> {

  /**
   * The type of the result.
   *    Full: A complete {@link Entity}.
   *    PROJECTION: A partial entity, represented by {@link PartialEntity}.
   *    KEY_ONLY: An entity's {@link Key}.
   */
  enum ResultType {
    FULL,
    PROJECTION,
    KEY_ONLY;
  }

  /**
   * This method should be used to cast the result to its appropriate type.
   * <pre> {@code
   * ResultType.FULL -> (QueryResult<Entity>)
   * ResultType.PROJECTION -> (QueryResult<PartialEntity>)
   * ResultType.KEY_ONLY -> (QueryResult<Key>)
   * } </pre>
   */
  ResultType getResultType();

  /**
   * Return the Cursor for the next result. Not currently implemented (depends on v1beta3).
   */
  Cursor getCursor();
}
