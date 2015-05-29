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
 * An interface to represent a batch of write operations.
 * Any write operation that is applied on a batch will only be sent
 * to the Datastore upon {@link #submit}.
 * A usage example:
 * <pre> {@code
 *   Entity entity1 = datastore.get(key1);
 *   Batch batch = datastore.newBatch();
 *   Entity entity2 = Entity.builder(key2).set("name", "John").build();
 *   entity1 = Entity.builder(entity1).clear().setNull("bla").build();
 *   Entity entity3 = Entity.builder(key3).set("title", "title").build();
 *   batch.update(entity1);
 *   batch.add(entity2, entity3);
 *   batch.submit();
 * } </pre>
 */
public interface Batch extends DatastoreBatchWriter {

  interface Response {
    List<Key> generatedKeys();
  }

  /**
   * Submit the batch to the Datastore.
   *
   * @throws DatastoreException if there was any failure or if batch is not longer active
   */
  Response submit();

  /**
   * Returns the batch associated {@link Datastore}.
   */
  Datastore datastore();
}
