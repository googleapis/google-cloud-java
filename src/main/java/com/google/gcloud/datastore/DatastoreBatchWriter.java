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

/**
 * An interface to represent a batch of write operations.
 * All write operation for a batch writer will be applied to the Datastore in one RPC call.
 */
interface DatastoreBatchWriter extends DatastoreWriter {

  /**
   * {@inheritDoc}
   * This operation will be converted to {@link #put} operation for entities that were already
   *     marked for deletion in this writer.
   * @throws com.google.gcloud.datastore.DatastoreServiceException if a given entity already added
   *     to this writer or if not active
   */
  @Override
  void add(Entity... entity);

  /**
   * Datastore add operation.
   * This method will automatically allocate id for any entity with an incomplete key.
   *
   * @throws IllegalArgumentException if any of the given entities is missing a key
   * @throws com.google.gcloud.datastore.DatastoreServiceException if a given entity with a
   *     complete key was already added to this writer or if not active
   */
  void add(PartialEntity... entity);

  /**
   * {@inheritDoc}
   * This operation will be converted to {@link #put} operation for entities that were already
   *     added or put in this writer
   * @throws com.google.gcloud.datastore.DatastoreServiceException if an entity is marked for
   *     deletion in this writer or if not active
   */
  @Override
  void update(Entity... entity);

  /**
   * {@inheritDoc}
   * This operation will also remove from this batch any prior writes for entities with the same
   *     keys
   * @throws com.google.gcloud.datastore.DatastoreServiceException if not active
   */
  @Override
  void delete(Key... key);

  /**
   * {@inheritDoc}
   * This operation will also remove from this writer any prior writes for the same entities.
   * @throws com.google.gcloud.datastore.DatastoreServiceException if not active
   */
  @Override
  void put(Entity... entity);

  /**
   * Returns {@code true} if still active (write operations were not sent to the Datastore).
   */
  boolean active();
}
