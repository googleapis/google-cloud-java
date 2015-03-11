/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.datastore;

import java.util.Iterator;
import java.util.List;

/**
 * An interface to represent Google Cloud Datastore read operations.
 */
public interface DatastoreReader {

  /**
   * Returns an {@link Entity} for the given {@link Key} or {@code null} if does not exists.
   *
   * @throws DatastoreServiceException upon failure.
   */
  Entity<Key> get(Key key);

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
  Iterator<Entity<Key>> get(Key... key);

  /**
   * Returns a list with a value for each given key (ordered by input).
   * A {@code null} would be returned for non-existing keys.
   * When possible prefer using {@link #get(Key...)} which does not eagerly loads the results.
   */
  List<Entity<Key>> fetch(Key... keys);

  /**
   * Submit a {@link Query} and returns its result.
   *
   * @throws DatastoreServiceException upon failure.
   */
  <T> QueryResults<T> run(Query<T> query);
}
