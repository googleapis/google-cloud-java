package com.google.gcloud.datastore;

import java.util.Iterator;

/**
 * The result of a Google Cloud Datastore query submission.
 * Typically the result's type would be casted to its expected type (The {@link #getResultType()}
 * method could be used when the type is not known).
 *
 * @param V the type of values the result holds.
 */
public interface QueryResult<V extends Object> extends Iterator<V> {

  /**
   * The result's type.
   *    FULL: A complete {@link Entity}.
   *    PROJECTION: A partial entity, represented by {@link PartialEntity}.
   *    KEY_ONLY: An entity's {@link Key}.
   */
  enum Type {

    FULL(Entity.class),
    PROJECTION(PartialEntity.class),
    KEY_ONLY(Key.class);

    private final Class<?> resultClass;

    Type(Class<?> resultClass) {
      this.resultClass = resultClass;
    }

    Class<?> getResultClass() {
      return resultClass;
    }
  }

  /**
   * This method can be used to verify the result type and to cast its value type accordingly.
   * <pre> {@code
   * Type.FULL -> (QueryResult<Entity>)
   * Type.PROJECTION -> (QueryResult<PartialEntity>)
   * Type.KEY_ONLY -> (QueryResult<Key>)
   * } </pre>
   */
  Type getType();

  /**
   * Return the Cursor for the next result. Not currently implemented (depends on v1beta3).
   */
  Cursor getCursor();
}
