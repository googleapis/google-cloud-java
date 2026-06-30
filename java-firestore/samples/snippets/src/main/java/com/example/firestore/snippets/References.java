/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.firestore.snippets;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;

/** Examples of references to a collection, document in a collection and subcollection. */
public class References {

  private final Firestore db;

  public References(Firestore db) {
    this.db = db;
  }

  /**
   * Return a reference to collection.
   *
   * @return collection reference
   */
  public CollectionReference getCollectionRef() {
    // [START firestore_data_reference_collection]
    // Reference to the collection "users"
    CollectionReference collection = db.collection("users");
    // [END firestore_data_reference_collection]
    return collection;
  }

  /**
   * Return a reference to a document.
   *
   * @return document reference
   */
  public DocumentReference getDocumentRef() {
    // [START firestore_data_reference_document]
    // Reference to a document with id "alovelace" in the collection "users"
    DocumentReference document = db.collection("users").document("alovelace");
    // [END firestore_data_reference_document]
    return document;
  }

  /**
   * Return a reference to a document using path.
   *
   * @return document reference
   */
  public DocumentReference getDocumentRefUsingPath() {
    // [START firestore_data_reference_document_path]
    // Reference to a document with id "alovelace" in the collection "users"
    DocumentReference document = db.document("users/alovelace");
    // [END firestore_data_reference_document_path]
    return document;
  }

  /**
   * Return a reference to a document in a sub-collection.
   *
   * @return document reference in a subcollection
   */
  public DocumentReference getSubCollectionDocumentRef() {
    // [START firestore_data_reference_subcollection]
    // Reference to a document in subcollection "messages"
    DocumentReference document =
        db.collection("rooms").document("roomA").collection("messages").document("message1");
    // [END firestore_data_reference_subcollection]
    return document;
  }
}
