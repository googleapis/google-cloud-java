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

import java.util.List;

/**
 * An interface to represent Google Cloud Datastore write operations.
 */
public interface DatastoreWriter {

  /**
   * Datastore add operation.
   * This method will automatically allocate an id if necessary.
   *
   * @param entity the entity to add
   * @return an {@code Entity} with the same properties and a key that is either newly allocated
   *     or the same one if key is already complete
   * @throws DatastoreException upon failure
   * @throws IllegalArgumentException if the given entity is missing a key
   */
  Entity add(FullEntity<?> entity);

  /**
   * Datastore add operation.
   * This method will automatically allocate id for any entity with an incomplete key.
   *
   * @return a list of {@code Entity} ordered by input with the same properties and a key that
   *     is either newly allocated or the same one if was already complete
   * @throws DatastoreException upon failure
   * @throws IllegalArgumentException if any of the given entities is missing a key
   * @see #add(FullEntity)
   */
  List<Entity> add(FullEntity<?>... entity);

  /**
   * A Datastore update operation.
   * The operation will fail if an entity with the same key does not already exist.
   */
  void update(Entity... entity);

  /**
   * A Datastore put (a.k.a upsert) operation.
   * The operation will add or modify the entities.
   */
  void put(Entity... entity);

  /**
   * A datastore delete operation.
   * It is OK request a deletion of a non-existing entity.
   */
  void delete(Key... key);
}
