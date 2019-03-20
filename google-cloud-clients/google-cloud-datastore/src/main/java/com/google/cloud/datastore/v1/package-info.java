/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A client to Google Cloud Datastore API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>=============== DatastoreClient ===============
 *
 * <p>Service Description: Each RPC normalizes the partition IDs of the keys in its input entities,
 * and always returns entities with keys with normalized partition IDs. This applies to all keys and
 * entities, including those in values, except keys with both an empty path and an empty or unset
 * partition ID. Normalization of input keys sets the project ID (if not already set) to the project
 * ID from the request.
 *
 * <p>Sample for DatastoreClient:
 *
 * <pre>
 * <code>
 * try (DatastoreClient datastoreClient = DatastoreClient.create()) {
 *   String projectId = "";
 *   ReadOptions readOptions = ReadOptions.newBuilder().build();
 *   List&lt;Key&gt; keys = new ArrayList&lt;&gt;();
 *   LookupResponse response = datastoreClient.lookup(projectId, readOptions, keys);
 * }
 * </code>
 * </pre>
 */
package com.google.cloud.datastore.v1;
