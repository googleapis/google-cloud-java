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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.cloud.firestore.v1.FirestoreClient.ListDocumentsPagedResponse;
import com.google.common.base.Preconditions;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.ListDocumentsRequest;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A CollectionReference can be used for adding documents, getting document references, and querying
 * for documents (using the methods inherited from Query).
 *
 * <p><b>Subclassing Note</b>: Firestore classes are not meant to be subclassed except for use in
 * test mocks. Subclassing is not supported in production code and new SDK releases may break code
 * that does so.
 */
public class CollectionReference extends Query {

  /**
   * Creates a CollectionReference from a complete collection path.
   *
   * @param firestore The Firestore client.
   * @param collectionPath The Path of this collection.
   */
  CollectionReference(FirestoreImpl firestore, ResourcePath collectionPath) {
    super(firestore, collectionPath);
  }

  /**
   * The id of a collection refers to the last component of path pointing to a collection, e.g.
   * "collection-id" in "projects/project-id/databases/database-id/documents/collection-id".
   *
   * @return The ID of the collection.
   */
  @Nonnull
  public String getId() {
    return path.getId();
  }

  /**
   * Returns a DocumentReference to the containing Document if this is a subcollection, else null.
   *
   * @return A DocumentReference pointing to the parent document.
   */
  @Nullable
  public DocumentReference getParent() {
    ResourcePath parent = path.getParent();
    return parent.isDocument() ? new DocumentReference(firestore, parent) : null;
  }

  /**
   * A string representing the path of the referenced collection (relative to the root of the
   * database).
   *
   * @return The slash-separated path relative to the root of the database.
   */
  @Nonnull
  public String getPath() {
    return path.getPath();
  }

  /**
   * Returns a DocumentReference pointing to a new document with an auto-generated ID within this
   * collection.
   *
   * @return A DocumentReference pointing to a new document with an auto-generated ID.
   */
  @Nonnull
  public DocumentReference document() {
    return document(FirestoreImpl.autoId());
  }

  /**
   * Gets a DocumentReference instance that refers to the document that is a child of this
   * Collection.
   *
   * @param childPath A relative and slash-separated path to a document.
   * @return The DocumentReference instance.
   */
  @Nonnull
  public DocumentReference document(@Nonnull String childPath) {
    ResourcePath documentPath = path.append(childPath);
    Preconditions.checkArgument(
        documentPath.isDocument(),
        String.format("Path should point to a Document Reference: %s", path));
    return new DocumentReference(firestore, documentPath);
  }

  /**
   * Retrieves the list of documents in this collection.
   *
   * <p>The document references returned may include references to "missing documents", i.e.
   * document locations that have no document present but which contain subcollections with
   * documents. Attempting to read such a document reference (e.g. via `get()` or `onSnapshot()`)
   * will return a `DocumentSnapshot` whose `exists()` method returns false.
   *
   * @return The list of documents in this collection.
   */
  @Nonnull
  public Iterable<DocumentReference> listDocuments() {
    ListDocumentsRequest.Builder request = ListDocumentsRequest.newBuilder();
    request.setParent(path.getParent().toString());
    request.setCollectionId(this.getId());
    request.setMask(DocumentMask.getDefaultInstance());
    request.setShowMissing(true);

    final ListDocumentsPagedResponse response;

    try {
      response =
          ApiExceptions.callAndTranslateApiException(
              firestore.sendRequest(
                  request.build(), firestore.getClient().listDocumentsPagedCallable()));
    } catch (ApiException exception) {
      throw FirestoreException.apiException(exception);
    }

    return new Iterable<DocumentReference>() {
      @Override
      @Nonnull
      public Iterator<DocumentReference> iterator() {
        final Iterator<Document> iterator = response.iterateAll().iterator();
        return new Iterator<DocumentReference>() {
          @Override
          public boolean hasNext() {
            return iterator.hasNext();
          }

          @Override
          public DocumentReference next() {
            ResourcePath path = ResourcePath.create(iterator.next().getName());
            return document(path.getId());
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException("remove");
          }
        };
      }
    };
  }

  /**
   * Adds a new document to this collection with the specified data, assigning it a document ID
   * automatically.
   *
   * @param fields A Map containing the data for the new document.
   * @return An ApiFuture that will be resolved with the DocumentReference of the newly created
   *     document.
   * @see #document()
   */
  @Nonnull
  public ApiFuture<DocumentReference> add(@Nonnull final Map<String, Object> fields) {
    final DocumentReference documentReference = document();
    ApiFuture<WriteResult> createFuture = documentReference.create(fields);

    return ApiFutures.transform(
        createFuture,
        new ApiFunction<WriteResult, DocumentReference>() {
          @Override
          public DocumentReference apply(WriteResult writeResult) {
            return documentReference;
          }
        });
  }

  /**
   * Adds a new document to this collection with the specified POJO as contents, assigning it a
   * document ID automatically.
   *
   * @param pojo The POJO that will be used to populate the contents of the document
   * @return An ApiFuture that will be resolved with the DocumentReference of the newly created
   *     document.
   * @see #document()
   */
  public ApiFuture<DocumentReference> add(Object pojo) {
    Object converted = CustomClassMapper.convertToPlainJavaTypes(pojo);
    if (!(converted instanceof Map)) {
      FirestoreException.invalidState("Can't set a document's data to an array or primitive");
    }
    return add((Map<String, Object>) converted);
  }
}
