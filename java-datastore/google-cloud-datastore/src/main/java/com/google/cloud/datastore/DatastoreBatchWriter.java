/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;

import com.google.api.core.InternalExtensionOnly;
import java.util.List;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * An interface to represent a batch of write operations. All write operation for a batch writer
 * will be applied to the Datastore in one RPC call.
 *
 * <p><b> WARNING: This class maintains an internal state in terms of {@link
 * java.util.LinkedHashMap} and {@link java.util.LinkedHashSet} which gets updated on every method
 * call performing CRUD operations to record the mutations. Since {@link java.util.LinkedHashMap} is
 * not thread safe as per its <a
 * href="https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html">documentation</a>,
 * This class too should not be treated as a thread safe class. </b>
 */
@NotThreadSafe
@InternalExtensionOnly
public interface DatastoreBatchWriter extends DatastoreWriter {

  /**
   * Datastore add operation. This method will also allocate id for any entity with an incomplete
   * key. As opposed to {@link #add(FullEntity)} and {@link #add(FullEntity...)}, this method will
   * defer any necessary id allocation to submit time.
   *
   * @throws IllegalArgumentException if any of the given entities is missing a key
   * @throws DatastoreException if a given entity with a complete key was already added to this
   *     writer or if not active
   */
  void addWithDeferredIdAllocation(FullEntity<?>... entities);

  /**
   * {@inheritDoc} If {@code entity} has a complete key and was already marked for deletion in this
   * writer, the operation will be changed to {@link #put}.
   *
   * @throws DatastoreException if a given entity with the same complete key was already added to
   *     this writer, if writer is not active or if id allocation for an entity with an incomplete
   *     key failed
   */
  @Override
  Entity add(FullEntity<?> entity);

  /**
   * {@inheritDoc} For entities with complete keys that were marked for deletion in this writer the
   * operation will be changed to {@link #put}.
   *
   * @throws DatastoreException if a given entity with the same complete key was already added to
   *     this writer, if writer is not active or if id allocation for an entity with an incomplete
   *     key failed
   */
  @Override
  List<Entity> add(FullEntity<?>... entities);

  /**
   * {@inheritDoc} This operation will be converted to {@link #put} operation for entities that were
   * already added or put in this writer.
   *
   * @throws DatastoreException if an entity is marked for deletion in this writer or if not active
   */
  @Override
  void update(Entity... entities);

  /**
   * {@inheritDoc} This operation will also remove from this batch any prior writes for entities
   * with the same keys.
   *
   * @throws DatastoreException if not active
   */
  @Override
  void delete(Key... keys);

  /**
   * Datastore put operation. This method will also allocate id for any entity with an incomplete
   * key. As opposed to {@link #put(FullEntity)} and {@link #put(FullEntity...)}, this method will
   * defer any necessary id allocation to submit time.
   *
   * @throws IllegalArgumentException if any of the given entities is missing a key
   * @throws DatastoreException if not active
   */
  void putWithDeferredIdAllocation(FullEntity<?>... entities);

  /**
   * {@inheritDoc} This operation will also remove from this writer any prior writes for the same
   * entity.
   *
   * @throws DatastoreException if not active or if id allocation for an entity with an incomplete
   *     key failed
   */
  @Override
  Entity put(FullEntity<?> entity);

  /**
   * {@inheritDoc} This operation will also remove from this writer any prior writes for the same
   * entities.
   *
   * @throws DatastoreException if not active or if id allocation for an entity with an incomplete
   *     key failed
   */
  @Override
  List<Entity> put(FullEntity<?>... entities);

  /** Returns {@code true} if still active (write operations were not sent to the Datastore). */
  boolean isActive();
}
