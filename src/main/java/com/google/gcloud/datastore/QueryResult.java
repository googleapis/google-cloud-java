package com.google.gcloud.datastore;

import java.util.Iterator;

/**
 * The result of a Google Cloud Datastore query submission.
 * When result is not typed it is possible to cast it to its appropriate type according to
 * the {@link #resultClass} value.
 *
 * @param V the type of the results value.
 */
public interface QueryResult<T> extends Iterator<T> {

  /**
   * Returns the actual class of the result's values.
   */
  Class<?> resultClass();

  /**
   * Returns the Cursor for the next result. Not currently implemented (depends on v1beta3).
   */
  Cursor cursor();
}
