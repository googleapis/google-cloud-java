/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A client to Cloud Datastore API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= DatastoreAdminClient =======================
 *
 * <p>Service Description: Google Cloud Datastore Admin API
 *
 * <p>The Datastore Admin API provides several admin services for Cloud Datastore.
 *
 * <p>----------------------------------------------------------------------------- ## Concepts
 *
 * <p>Project, namespace, kind, and entity as defined in the Google Cloud Datastore API.
 *
 * <p>Operation: An Operation represents work being performed in the background.
 *
 * <p>EntityFilter: Allows specifying a subset of entities in a project. This is specified as a
 * combination of kinds and namespaces (either or both of which may be all).
 *
 * <p>----------------------------------------------------------------------------- ## Services
 *
 * <p># Export/Import
 *
 * <p>The Export/Import service provides the ability to copy all or a subset of entities to/from
 * Google Cloud Storage.
 *
 * <p>Exported data may be imported into Cloud Datastore for any Google Cloud Platform project. It
 * is not restricted to the export source project. It is possible to export from one project and
 * then import into another.
 *
 * <p>Exported data can also be loaded into Google BigQuery for analysis.
 *
 * <p>Exports and imports are performed asynchronously. An Operation resource is created for each
 * export/import. The state (including any errors encountered) of the export/import may be queried
 * via the Operation resource.
 *
 * <p># Index
 *
 * <p>The index service manages Cloud Datastore composite indexes.
 *
 * <p>Index creation and deletion are performed asynchronously. An Operation resource is created for
 * each such asynchronous operation. The state of the operation (including any errors encountered)
 * may be queried via the Operation resource.
 *
 * <p># Operation
 *
 * <p>The Operations collection provides a record of actions performed for the specified project
 * (including any operations in progress). Operations are not created directly but through calls on
 * other collections or resources.
 *
 * <p>An operation that is not yet done may be cancelled. The request to cancel is asynchronous and
 * the operation may continue to run for some time after the request to cancel is made.
 *
 * <p>An operation that is done may be deleted so that it is no longer listed as part of the
 * Operation collection.
 *
 * <p>ListOperations returns all pending operations, but not completed operations.
 *
 * <p>Operations are created by service DatastoreAdmin, but are accessed via service
 * google.longrunning.Operations.
 *
 * <p>Sample for DatastoreAdminClient:
 *
 * <pre>{@code
 * try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
 *   GetIndexRequest request =
 *       GetIndexRequest.newBuilder()
 *           .setProjectId("projectId-894832108")
 *           .setIndexId("indexId1943291277")
 *           .build();
 *   Index response = datastoreAdminClient.getIndex(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.datastore.admin.v1;

import javax.annotation.Generated;
