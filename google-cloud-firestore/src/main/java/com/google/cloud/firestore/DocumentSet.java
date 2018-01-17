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

import com.google.cloud.firestore.collection.ImmutableSortedMap;
import com.google.cloud.firestore.collection.ImmutableSortedSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/**
 * An immutable set of documents (unique by key) ordered by the given comparator or ordered by key
 * by default if no document is present.
 */
class DocumentSet implements Iterable<QueryDocumentSnapshot> {
  private static final ImmutableSortedMap<ResourcePath, QueryDocumentSnapshot> EMPTY_DOCUMENT_MAP =
      ImmutableSortedMap.Builder.emptyMap(ResourcePath.comparator());

  /** Returns an empty DocumentSet sorted by the given comparator, then by keys. */
  static DocumentSet emptySet(final Comparator<QueryDocumentSnapshot> comparator) {
    return new DocumentSet(
        EMPTY_DOCUMENT_MAP,
        new ImmutableSortedSet<>(Collections.<QueryDocumentSnapshot>emptyList(), comparator));
  }

  /**
   * An index of the documents in the DocumentSet, indexed by document key. The index exists to
   * guarantee the uniqueness of document keys in the set and to allow lookup and removal of
   * documents by key.
   */
  private final ImmutableSortedMap<ResourcePath, QueryDocumentSnapshot> keyIndex;

  /**
   * The main collection of documents in the DocumentSet. The documents are ordered by the provided
   * comparator. The collection exists in addition to the index to allow ordered traversal of the
   * DocumentSet.
   */
  private final ImmutableSortedSet<QueryDocumentSnapshot> sortedSet;

  private DocumentSet(
      ImmutableSortedMap<ResourcePath, QueryDocumentSnapshot> keyIndex,
      ImmutableSortedSet<QueryDocumentSnapshot> sortedSet) {
    this.keyIndex = keyIndex;
    this.sortedSet = sortedSet;
  }

  int size() {
    return keyIndex.size();
  }

  boolean isEmpty() {
    return keyIndex.isEmpty();
  }

  /** Returns true iff this set contains a document with the given key. */
  boolean contains(ResourcePath key) {
    return keyIndex.containsKey(key);
  }

  /** Returns the document from this set with the given key if it exists or null if it doesn't. */
  @Nullable
  QueryDocumentSnapshot getDocument(ResourcePath key) {
    return keyIndex.get(key);
  }

  /**
   * Returns the index of the provided key in the document set, or -1 if the document key is not
   * present in the set;
   */
  int indexOf(ResourcePath key) {
    QueryDocumentSnapshot document = keyIndex.get(key);
    if (document == null) {
      return -1;
    }
    return sortedSet.indexOf(document);
  }

  /**
   * Returns a new DocumentSet that contains the given document, replacing any old document with the
   * same key.
   */
  DocumentSet add(QueryDocumentSnapshot document) {
    // Remove any prior mapping of the document's key before adding, preventing sortedSet from
    // accumulating values that aren't in the index.
    DocumentSet removed = remove(document.getReference().getResourcePath());

    ImmutableSortedMap<ResourcePath, QueryDocumentSnapshot> newKeyIndex =
        removed.keyIndex.insert(document.getReference().getResourcePath(), document);
    ImmutableSortedSet<QueryDocumentSnapshot> newSortedSet = removed.sortedSet.insert(document);
    return new DocumentSet(newKeyIndex, newSortedSet);
  }

  /** Returns a new DocumentSet with the document for the provided key removed. */
  DocumentSet remove(ResourcePath key) {
    QueryDocumentSnapshot document = keyIndex.get(key);
    if (document == null) {
      return this;
    }

    ImmutableSortedMap<ResourcePath, QueryDocumentSnapshot> newKeyIndex = keyIndex.remove(key);
    ImmutableSortedSet<QueryDocumentSnapshot> newSortedSet = sortedSet.remove(document);
    return new DocumentSet(newKeyIndex, newSortedSet);
  }

  /** Returns a copy of the documents in this set as array. This is O(n) in the size of the set. */
  List<QueryDocumentSnapshot> toList() {
    List<QueryDocumentSnapshot> documents = new ArrayList<>(size());
    for (QueryDocumentSnapshot document : this) {
      documents.add(document);
    }
    return documents;
  }

  @Override
  public Iterator<QueryDocumentSnapshot> iterator() {
    return sortedSet.iterator();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }

    DocumentSet documentSet = (DocumentSet) other;

    if (size() != documentSet.size()) {
      return false;
    }

    Iterator<QueryDocumentSnapshot> thisIterator = iterator();
    Iterator<QueryDocumentSnapshot> otherIterator = documentSet.iterator();
    while (thisIterator.hasNext()) {
      DocumentSnapshot thisDoc = thisIterator.next();
      DocumentSnapshot otherDoc = otherIterator.next();
      if (!thisDoc.equals(otherDoc)) {
        return false;
      }
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = 0;
    for (DocumentSnapshot document : this) {
      result = 31 * result + document.hashCode();
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("[");
    boolean first = true;
    for (DocumentSnapshot doc : this) {
      if (first) {
        first = false;
      } else {
        builder.append(", ");
      }
      builder.append(doc);
    }
    builder.append("]");
    return builder.toString();
  }
}
