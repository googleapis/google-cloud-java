/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import javax.annotation.Nonnull;

/**
 * A DocumentChange represents a change to the documents matching a query. It contains the document
 * affected and a the type of change that occurred (added, modifed, or removed).
 */
public class DocumentChange {
  /** An enumeration of snapshot diff types. */
  public enum Type {
    /** Indicates a new document was added to the set of documents matching the query. */
    ADDED,
    /** Indicates a document within the query was modified. */
    MODIFIED,
    /**
     * Indicates a document within the query was removed (either deleted or no longer matches the
     * query.
     */
    REMOVED
  }

  private final Type type;

  private final DocumentSnapshot document;

  /** The index in the old snapshot, after processing all previous changes. */
  private final int oldIndex;

  /** The index in the new snapshot, after processing all previous changes. */
  private final int newIndex;

  DocumentChange(DocumentSnapshot document, Type type, int oldIndex, int newIndex) {
    this.type = type;
    this.document = document;
    this.oldIndex = oldIndex;
    this.newIndex = newIndex;
  }

  @Nonnull
  public Type getType() {
    return type;
  }

  @Nonnull
  public DocumentSnapshot getDocument() {
    return document;
  }

  /**
   * The index of the changed document in the result set immediately prior to this DocumentChange
   * (i.e. supposing that all prior DocumentChange objects have been applied). Returns -1 for
   * 'added' events.
   */
  public int getOldIndex() {
    return oldIndex;
  }

  /**
   * The index of the changed document in the result set immediately after this DocumentChange (i.e.
   * supposing that all prior DocumentChange objects and the current DocumentChange object have been
   * applied). Returns -1 for 'removed' events.
   */
  public int getNewIndex() {
    return newIndex;
  }
}
