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

/**
 * A client to the Google Cloud Datastore.
 *
 * <p>A simple usage example:
 * <pre> {@code
 * DatastoreOptions options = DatastoreOptions.builder().projectId(PROJECT_ID).build();
 * Datastore datastore = DatastoreFactory.instance().get(options);
 * KeyFactory keyFactory = datastore.newKeyFactory().kind(kind);
 * Key key = keyFactory.newKey(keyName);
 * Entity entity = datastore.get(key);
 * if (entity == null) {
 *   entity = Entity.builder(key)
 *       .set("name", "John Do")
 *       .set("age", LongValue.builder(100).indexed(false).build())
 *       .set("updated", false)
 *       .build();
 *   datastore.put(entity);
 * } else {
 *   boolean updated = entity.getBoolean("updated");
 *   if (!updated) {
 *     String[] name = entity.getString("name").split(" ");
 *     entity = Entity.builder(entity)
 *         .set("name", name[0])
 *         .set("last_name", StringValue.builder(name[1]).indexed(false).build())
 *         .set("updated", true)
 *         .remove("old_property")
 *         .set("new_property", 1.1)
 *         .build();
 *     datastore.update(entity);
 *   }
 * }
 * } </pre>
 *
 * @see <a href="https://cloud.google.com/datastore/">Google Cloud Datastore</a>
 */
package com.google.gcloud.datastore;
