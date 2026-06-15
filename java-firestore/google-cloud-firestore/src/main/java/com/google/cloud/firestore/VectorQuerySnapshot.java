/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.firestore;

import com.google.cloud.Timestamp;
import java.util.List;

/**
 * A VectorQuerySnapshot contains the results of a VectorQuery. It can contain zero or more
 * DocumentSnapshot objects.
 */
public class VectorQuerySnapshot extends GenericQuerySnapshot<VectorQuery> {
  protected VectorQuerySnapshot(
      VectorQuery query,
      Timestamp readTime,
      final List<QueryDocumentSnapshot> documents,
      final List<DocumentChange> documentChanges) {
    super(query, readTime, documents, documentChanges);
  }

  /**
   * Creates a new VectorQuerySnapshot representing the results of a VectorQuery with added
   * documents.
   */
  public static VectorQuerySnapshot withDocuments(
      final VectorQuery query, Timestamp readTime, final List<QueryDocumentSnapshot> documents) {
    return new VectorQuerySnapshot(query, readTime, documents, null);
  }
}
