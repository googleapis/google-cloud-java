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
import com.google.cloud.firestore.encoding.CustomClassMapper;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * Abstract. A GenericQuerySnapshot represents the results of a query that returns documents. It can
 * contain zero or more DocumentSnapshot objects.
 */
public abstract class GenericQuerySnapshot<QueryT> implements Iterable<QueryDocumentSnapshot> {
  protected final QueryT query;
  protected final Timestamp readTime;

  private List<DocumentChange> documentChanges;
  private final List<QueryDocumentSnapshot> documents;

  // Elevated access level for mocking.
  protected GenericQuerySnapshot(
      QueryT query,
      Timestamp readTime,
      @Nonnull final List<QueryDocumentSnapshot> documents,
      final List<DocumentChange> documentChanges) {
    this.query = query;
    this.readTime = readTime;
    this.documentChanges =
        documentChanges != null ? Collections.unmodifiableList(documentChanges) : documentChanges;
    this.documents = Collections.unmodifiableList(documents);
  }

  /**
   * Returns the query for the snapshot.
   *
   * @return The backing query that produced this snapshot.
   */
  @Nonnull
  public QueryT getQuery() {
    return query;
  }

  /**
   * Returns the time at which this snapshot was read.
   *
   * @return The read time of this snapshot.
   */
  @Nonnull
  public Timestamp getReadTime() {
    return readTime;
  }

  /**
   * Returns the documents in this QuerySnapshot as a List in order of the query.
   *
   * @return The list of documents.
   */
  @Nonnull
  public List<QueryDocumentSnapshot> getDocuments() {
    return this.documents;
  }

  /** Returns true if there are no documents in the QuerySnapshot. */
  public boolean isEmpty() {
    return this.size() == 0;
  }

  @Nonnull
  public Iterator<QueryDocumentSnapshot> iterator() {
    return getDocuments().iterator();
  }

  /**
   * Returns the contents of the documents in the QuerySnapshot, converted to the provided class, as
   * a list.
   *
   * @param clazz The POJO type used to convert the documents in the list.
   */
  @Nonnull
  public <T> List<T> toObjects(@Nonnull Class<T> clazz) {
    List<QueryDocumentSnapshot> documents = getDocuments();
    List<T> results = new ArrayList<>(documents.size());
    for (DocumentSnapshot documentSnapshot : documents) {
      results.add(
          CustomClassMapper.convertToCustomClass(
              documentSnapshot.getData(), clazz, documentSnapshot.getReference()));
    }

    return results;
  }

  /**
   * Returns the list of documents that changed since the last snapshot. If it's the first snapshot
   * all documents will be in the list as added changes.
   *
   * @return The list of documents that changed since the last snapshot.
   */
  @Nonnull
  public List<DocumentChange> getDocumentChanges() {
    if (documentChanges == null) {
      synchronized (documents) {
        if (documentChanges == null) {
          int size = documents.size();
          ImmutableList.Builder<DocumentChange> builder =
              ImmutableList.builderWithExpectedSize(size);
          for (int i = 0; i < size; ++i) {
            builder.add(new DocumentChange(documents.get(i), DocumentChange.Type.ADDED, -1, i));
          }
          documentChanges = builder.build();
        }
      }
    }

    return documentChanges;
  }

  /** Returns the number of DocumentSnapshots in this snapshot. */
  public int size() {
    return getDocuments().size();
  }

  /**
   * Tests for equality with this object.
   *
   * @param o is tested for equality with this object.
   * @return `true` if equal, otherwise `false`
   */
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenericQuerySnapshot that = (GenericQuerySnapshot) o;
    return Objects.equals(query, that.query)
        && Objects.equals(this.getDocumentChanges(), that.getDocumentChanges())
        && Objects.equals(this.getDocuments(), that.getDocuments());
  }

  @Override
  public int hashCode() {
    return Objects.hash(query, this.getDocumentChanges(), this.getDocuments());
  }
}
