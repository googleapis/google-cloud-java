package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;

import java.util.Iterator;

/**
 * The result of a Google Cloud Datastore query submission.
 * When the result is not typed it is possible to cast it to its appropriate type according to
 * the {@link #getType} value.
 *
 * @param V the type of values the result holds.
 */
public interface QueryResult<T> extends Iterator<T> {

  /**
   * Possible results types are:
   *   FULL: A complete {@link Entity}.
   *   PROJECTION: A partial entity, represented by {@link PartialEntity}.
   *   KEY_ONLY: An entity's {@link Key}.
   */
  enum Type {

    FULL {
      @Override
      @SuppressWarnings("unchecked")
      Entity convert(DatastoreV1.Entity value) {
        return Entity.fromPb(value);
      }
    },

    PROJECTION  {

      @Override
      @SuppressWarnings("unchecked")
      PartialEntity convert(DatastoreV1.Entity value) {
        return PartialEntity.fromPb(value);
      }
    },

    KEY_ONLY {

      @Override
      @SuppressWarnings("unchecked")
      Key convert(DatastoreV1.Entity value) {
        return Key.fromPb(value.getKey());
      }
    };

    abstract <T> T convert(DatastoreV1.Entity value);
  }

  /**
   * Returns the actual type of the result's values.
   * When needed the result could be casted accordingly:
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
