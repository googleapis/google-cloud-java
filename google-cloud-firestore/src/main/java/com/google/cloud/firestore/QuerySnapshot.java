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

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.threeten.bp.Instant;

/**
 * A QuerySnapshot contains the results of a query. It can contain zero or more DocumentSnapshot
 * objects.
 */
public final class QuerySnapshot implements Iterable<QueryDocumentSnapshot> {

  private final Query query;
  private final DocumentSet documentSet;
  @Nullable private volatile List<QueryDocumentSnapshot> documentSnapshots;
  private final Instant readTime;
  private final List<DocumentChange> documentChanges;

  QuerySnapshot(
      Query query,
      Instant readTime,
      List<QueryDocumentSnapshot> results,
      List<DocumentChange> documentChanges) {
    this.query = query;
    this.documentSet = null;
    this.documentSnapshots = results;
    this.readTime = readTime;
    this.documentChanges = documentChanges;
  }

  QuerySnapshot(
      Query query, Instant readTime, DocumentSet results, List<DocumentChange> documentChanges) {
    this.query = query;
    this.documentSet = results;
    this.readTime = readTime;
    this.documentChanges = documentChanges;
  }

  /**
   * Returns the query for the snapshot.
   *
   * @return The backing query that produced this snapshot.
   */
  @Nonnull
  public Query getQuery() {
    return query;
  }

  /**
   * Returns the time at which this snapshot was read.
   *
   * @return The read time of this snapshot.
   */
  @Nonnull
  public Instant getReadTime() {
    return readTime;
  }

  /**
   * Returns the documents in this QuerySnapshot as a List in order of the query.
   *
   * @return The list of documents.
   */
  @Nonnull
  public List<QueryDocumentSnapshot> getDocuments() {
    if (documentSnapshots == null) {
      Preconditions.checkState(documentSet != null);
      synchronized (documentSet) {
        if (documentSnapshots == null) {
          documentSnapshots = documentSet.toList();
        }
      }
    }

    return Collections.unmodifiableList(documentSnapshots);
  }

  /**
   * Returns the list of documents that changed since the last snapshot. If it's the first snapshot
   * all documents will be in the list as added changes.
   *
   * @return The list of documents that changed since the last snapshot.
   */
  @Nonnull
  public List<DocumentChange> getDocumentChanges() {
    return Collections.unmodifiableList(documentChanges);
  }

  /** Returns true if there are no documents in the QuerySnapshot. */
  public boolean isEmpty() {
    return documentSnapshots != null ? documentSnapshots.isEmpty() : documentSet.isEmpty();
  }

  /** Returns the number of documents in the QuerySnapshot. */
  public int size() {
    return documentSnapshots != null ? documentSnapshots.size() : documentSet.size();
  }

  @Override
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
    List<T> results = new ArrayList<>();

    for (DocumentSnapshot documentSnapshot : getDocuments()) {
      results.add(CustomClassMapper.convertToCustomClass(documentSnapshot.getData(), clazz));
    }

    return results;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuerySnapshot that = (QuerySnapshot) o;
    return Objects.equals(query, that.query) && Objects.equals(readTime, that.readTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(query, readTime);
  }
}
