/*
 * Copyright 2017 Google LLC
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
 * A QuerySnapshot contains the results of a query. It can contain zero or more DocumentSnapshot
 * objects.
 */
public class QuerySnapshot extends GenericQuerySnapshot<Query> {
  protected QuerySnapshot(Query query, Timestamp readTime) {
    super(query, readTime, null, null);
  }

  protected QuerySnapshot(
      Query query,
      Timestamp readTime,
      final List<QueryDocumentSnapshot> documents,
      final List<DocumentChange> documentChanges) {
    super(query, readTime, documents, documentChanges);
  }

  /** Creates a new QuerySnapshot representing the results of a Query with added documents. */
  public static QuerySnapshot withDocuments(
      final Query query, Timestamp readTime, final List<QueryDocumentSnapshot> documents) {
    return new QuerySnapshot(query, readTime, documents, null);
  }

  /** Creates a new QuerySnapshot representing a snapshot of a Query with changed documents. */
  public static QuerySnapshot withChanges(
      final Query query,
      Timestamp readTime,
      final DocumentSet documentSet,
      final List<DocumentChange> documentChanges) {
    return new QuerySnapshot(query, readTime, documentSet.toList(), documentChanges);
  }
}
