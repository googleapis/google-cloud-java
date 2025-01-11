/*
 * Copyright 2025 Google LLC
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
 * A client to Cloud Firestore API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= FirestoreAdminClient =======================
 *
 * <p>Service Description: The Cloud Firestore Admin API.
 *
 * <p>This API provides several administrative services for Cloud Firestore.
 *
 * <p>Project, Database, Namespace, Collection, Collection Group, and Document are used as defined
 * in the Google Cloud Firestore API.
 *
 * <p>Operation: An Operation represents work being performed in the background.
 *
 * <p>The index service manages Cloud Firestore indexes.
 *
 * <p>Index creation is performed asynchronously. An Operation resource is created for each such
 * asynchronous operation. The state of the operation (including any errors encountered) may be
 * queried via the Operation resource.
 *
 * <p>The Operations collection provides a record of actions performed for the specified Project
 * (including any Operations in progress). Operations are not created directly but through calls on
 * other collections or resources.
 *
 * <p>An Operation that is done may be deleted so that it is no longer listed as part of the
 * Operation collection. Operations are garbage collected after 30 days. By default, ListOperations
 * will only return in progress and failed operations. To list completed operation, issue a
 * ListOperations request with the filter `done: true`.
 *
 * <p>Operations are created by service `FirestoreAdmin`, but are accessed via service
 * `google.longrunning.Operations`.
 *
 * <p>Sample for FirestoreAdminClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
 *   IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]");
 *   Index response = firestoreAdminClient.getIndex(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.firestore.v1;

import javax.annotation.Generated;
