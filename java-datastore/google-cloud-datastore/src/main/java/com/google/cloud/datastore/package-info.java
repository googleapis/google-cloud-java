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

/**
 * A client for Cloud Datastore – A highly-scalable NoSQL database for web and mobile applications.
 *
 * <p>Here's a simple usage example for using google-cloud from App/Compute Engine. This example
 * shows how to create a Datastore entity. For the complete source code see <a
 * href="https://github.com/googleapis/google-cloud-java/tree/main/google-cloud-examples/src/main/java/com/google/cloud/examples/datastore/snippets/CreateEntity.java">
 * CreateEntity.java</a>.
 *
 * <pre>{@code
 * Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
 * KeyFactory keyFactory = datastore.newKeyFactory().setKind("keyKind");
 * Key key = keyFactory.newKey("keyName");
 * Entity entity = Entity.newBuilder(key)
 *     .set("name", "John Doe")
 *     .set("age", 30)
 *     .set("access_time", Timestamp.now())
 *     .build();
 * datastore.put(entity);
 * }</pre>
 *
 * <p>This second example shows how to get and update a Datastore entity if it exists. For the
 * complete source code see <a
 * href="https://github.com/googleapis/google-cloud-java/blob/4f9e98b21264028901878b8a11204868eca858ce/google-cloud-examples/src/main/java/com/google/cloud/examples/datastore/snippets/UpdateEntity.java">
 * UpdateEntity.java</a>.
 *
 * <pre>{@code
 * Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
 * KeyFactory keyFactory = datastore.newKeyFactory().setKind("keyKind");
 * Key key = keyFactory.newKey("keyName");
 * Entity entity = datastore.get(key);
 * if (entity != null) {
 *   System.out.println("Updating access_time for " + entity.getString("name"));
 *   entity = Entity.newBuilder(entity)
 *       .set("access_time", Timestamp.now())
 *       .build();
 *   datastore.update(entity);
 * }
 * }</pre>
 *
 * <p>When using google-cloud from outside of App/Compute Engine, you have to <a
 * href="https://github.com/googleapis/google-cloud-java#specifying-a-project-id">specify a project
 * ID</a> and <a href="https://github.com/googleapis/google-cloud-java#authentication">provide
 * credentials</a>.
 *
 * @see <a href="https://cloud.google.com/datastore/">Google Cloud Datastore</a>
 */
package com.google.cloud.datastore;
