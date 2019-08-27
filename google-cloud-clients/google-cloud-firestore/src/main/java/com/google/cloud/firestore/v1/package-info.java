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
 * A client to Google Cloud Firestore API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>=============== FirestoreClient ===============
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
@Generated("by gapic-generator")
package com.google.cloud.firestore.v1;

import javax.annotation.Generated;
