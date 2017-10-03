/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A client to Google Cloud Firestore API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>==================== FirestoreAdminClient ====================
 *
 * <p>Service Description: The Cloud Firestore Admin API.
 *
 * <p>This API provides several administrative services for Cloud Firestore.
 *
 * <p># Concepts
 *
 * <p>Project, Database, Namespace, Collection, and Document are used as defined in the Google Cloud
 * Firestore API.
 *
 * <p>Operation: An Operation represents work being performed in the background.
 *
 * <p># Services
 *
 * <p>## Index
 *
 * <p>The index service manages Cloud Firestore indexes.
 *
 * <p>Index creation is performed asynchronously. An Operation resource is created for each such
 * asynchronous operation. The state of the operation (including any errors encountered) may be
 * queried via the Operation resource.
 *
 * <p>## Metadata
 *
 * <p>Provides metadata and statistical information about data in Cloud Firestore. The data provided
 * as part of this API may be stale.
 *
 * <p>## Operation
 *
 * <p>The Operations collection provides a record of actions performed for the specified Project
 * (including any Operations in progress). Operations are not created directly but through calls on
 * other collections or resources.
 *
 * <p>An Operation that is not yet done may be cancelled. The request to cancel is asynchronous and
 * the Operation may continue to run for some time after the request to cancel is made.
 *
 * <p>An Operation that is done may be deleted so that it is no longer listed as part of the
 * Operation collection.
 *
 * <p>Operations are created by service `FirestoreAdmin`, but are accessed via service
 * `google.longrunning.Operations`.
 *
 * <p>Sample for FirestoreAdminClient:
 *
 * <pre>
 * <code>
 * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
 *   String formattedParent = FirestoreAdminClient.formatDatabaseName("[PROJECT]", "[DATABASE]");
 *   Index index = Index.newBuilder().build();
 *   Operation response = firestoreAdminClient.createIndex(formattedParent, index);
 * }
 * </code>
 * </pre>
 *
 * =============== FirestoreClient ===============
 *
 * <p>Service Description: The Cloud Firestore service.
 *
 * <p>This service exposes several types of comparable timestamps:
 *
 * <p>&#42; `create_time` - The time at which a document was created. Changes only when a document
 * is deleted, then re-created. Increases in a strict monotonic fashion. &#42; `update_time` - The
 * time at which a document was last updated. Changes every time a document is modified. Does not
 * change when a write results in no modifications. Increases in a strict monotonic fashion. &#42;
 * `read_time` - The time at which a particular state was observed. Used to denote a consistent
 * snapshot of the database or the time at which a Document was observed to not exist. &#42;
 * `commit_time` - The time at which the writes in a transaction were committed. Any read with an
 * equal or greater `read_time` is guaranteed to see the effects of the transaction.
 *
 * <p>Sample for FirestoreClient:
 *
 * <pre>
 * <code>
 * try (FirestoreClient firestoreClient = FirestoreClient.create()) {
 *   Document document = Document.newBuilder().build();
 *   DocumentMask updateMask = DocumentMask.newBuilder().build();
 *   Document response = firestoreClient.updateDocument(document, updateMask);
 * }
 * </code>
 * </pre>
 */
package com.google.cloud.firestore.v1beta1;
