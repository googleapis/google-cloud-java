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
 * <p>Here's a simple usage example for using gcloud-java from App/Compute Engine. This example
 * shows how to create a Datastore entity. For the complete source code see
 * <a href="https://github.com/GoogleCloudPlatform/gcloud-java/tree/master/gcloud-java-examples/src/main/java/com/google/gcloud/examples/datastore/snippets/CreateEntity.java">
 * CreateEntity.java</a>.
 * <pre> {@code
 * Datastore datastore = DatastoreOptions.defaultInstance().service();
 * KeyFactory keyFactory = datastore.newKeyFactory().kind("keyKind");
 * Key key = keyFactory.newKey("keyName");
 * Entity entity = Entity.builder(key)
 *     .set("name", "John Doe")
 *     .set("age", 30)
 *     .set("access_time", DateTime.now())
 *     .build();
 * datastore.put(entity);
 * } </pre>
 * <p>
 * This second example shows how to get and update a Datastore entity if it exists. For the complete
 * source code see
 * <a href="https://github.com/GoogleCloudPlatform/gcloud-java/tree/master/gcloud-java-examples/src/main/java/com/google/gcloud/examples/datastore/snippets/UpdateEntity.java">
 * UpdateEntity.java</a>.
 * <pre> {@code
 * Datastore datastore = DatastoreOptions.defaultInstance().service();
 * KeyFactory keyFactory = datastore.newKeyFactory().kind("keyKind");
 * Key key = keyFactory.newKey("keyName");
 * Entity entity = datastore.get(key);
 * if (entity != null) {
 *   System.out.println("Updating access_time for " + entity.getString("name"));
 *   entity = Entity.builder(entity)
 *       .set("access_time", DateTime.now())
 *       .build();
 *   datastore.update(entity);
 * }} </pre>
 * <p>When using gcloud-java from outside of App/Compute Engine, you have to <a
 * href="https://github.com/GoogleCloudPlatform/gcloud-java#specifying-a-project-id">specify a
 * project ID</a> and
 * <a href="https://github.com/GoogleCloudPlatform/gcloud-java#authentication">provide
 * credentials</a>.
 *
 * @see <a href="https://cloud.google.com/datastore/">Google Cloud Datastore</a>
 */
package com.google.gcloud.datastore;
