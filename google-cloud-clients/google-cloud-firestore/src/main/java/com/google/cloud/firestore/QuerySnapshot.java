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
import com.google.cloud.firestore.DocumentChange.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * A QuerySnapshot contains the results of a query. It can contain zero or more DocumentSnapshot
 * objects.
 */
public abstract class QuerySnapshot implements Iterable<QueryDocumentSnapshot> {

  private final Query query;
  private final Timestamp readTime;

  private QuerySnapshot(Query query, Timestamp readTime) {
    this.query = query;
    this.readTime = readTime;
  }

  /** Creates a new QuerySnapshot representing the results of a Query with added documents. */
  public static QuerySnapshot withDocuments(
      final Query query, Timestamp readTime, final List<QueryDocumentSnapshot> documents) {
    return new QuerySnapshot(query, readTime) {
      volatile List<DocumentChange> documentChanges;

      @Nonnull
      @Override
      public List<QueryDocumentSnapshot> getDocuments() {
        return Collections.unmodifiableList(documents);
      }

      @Nonnull
      @Override
      public List<DocumentChange> getDocumentChanges() {
        if (documentChanges == null) {
          synchronized (documents) {
            if (documentChanges == null) {
              documentChanges = new ArrayList<>();
              for (int i = 0; i < documents.size(); ++i) {
                documentChanges.add(new DocumentChange(documents.get(i), Type.ADDED, -1, i));
              }
            }
          }
        }
        return Collections.unmodifiableList(documentChanges);
      }

      @Override
      public int size() {
        return documents.size();
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
        return Objects.equals(query, that.query)
            && Objects.equals(this.size(), that.size())
            && Objects.equals(this.getDocuments(), that.getDocuments());
      }

      @Override
      public int hashCode() {
        return Objects.hash(query, this.getDocuments());
      }
    };
  }

  /** Creates a new QuerySnapshot representing a snapshot of a Query with changed documents. */
  public static QuerySnapshot withChanges(
      final Query query,
      Timestamp readTime,
      final DocumentSet documentSet,
      final List<DocumentChange> documentChanges) {
    return new QuerySnapshot(query, readTime) {
      volatile List<QueryDocumentSnapshot> documents;

      @Nonnull
      @Override
      public List<QueryDocumentSnapshot> getDocuments() {
        if (documents == null) {
          synchronized (documentSet) {
            if (documents == null) {
              documents = documentSet.toList();
            }
          }
        }
        return Collections.unmodifiableList(documents);
      }

      @Nonnull
      @Override
      public List<DocumentChange> getDocumentChanges() {
        return Collections.unmodifiableList(documentChanges);
      }

      @Override
      public int size() {
        return documentSet.size();
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
        return Objects.equals(query, that.query)
            && Objects.equals(this.size(), that.size())
            && Objects.equals(this.getDocumentChanges(), that.getDocumentChanges())
            && Objects.equals(this.getDocuments(), that.getDocuments());
      }

      @Override
      public int hashCode() {
        return Objects.hash(query, this.getDocumentChanges(), this.getDocuments());
      }
    };
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
  public Timestamp getReadTime() {
    return readTime;
  }

  /**
   * Returns the documents in this QuerySnapshot as a List in order of the query.
   *
   * @return The list of documents.
   */
  @Nonnull
  public abstract List<QueryDocumentSnapshot> getDocuments();

  /**
   * Returns the list of documents that changed since the last snapshot. If it's the first snapshot
   * all documents will be in the list as added changes.
   *
   * @return The list of documents that changed since the last snapshot.
   */
  @Nonnull
  public abstract List<DocumentChange> getDocumentChanges();

  /** Returns true if there are no documents in the QuerySnapshot. */
  public boolean isEmpty() {
    return this.size() == 0;
  }

  /** Returns the number of documents in the QuerySnapshot. */
  public abstract int size();

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

  /**
   * Returns true if the document data in this QuerySnapshot equals the provided snapshot.
   *
   * @param obj The object to compare against.
   * @return Whether this QuerySnapshot is equal to the provided object.
   */
  @Override
  public abstract boolean equals(Object obj);

  @Override
  public abstract int hashCode();
}
