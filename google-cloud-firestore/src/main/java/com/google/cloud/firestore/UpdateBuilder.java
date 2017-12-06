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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.firestore.v1beta1.CommitRequest;
import com.google.firestore.v1beta1.CommitResponse;
import com.google.firestore.v1beta1.Write;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Abstract class that collects and bundles all write operations for {@link Transaction} and {@link
 * WriteBatch}.
 */
abstract class UpdateBuilder<T extends UpdateBuilder> {

  FirestoreImpl firestore;
  private List<Write> writes;

  UpdateBuilder(FirestoreImpl firestore) {
    this.firestore = firestore;
    this.writes = new ArrayList<>();
  }

  /**
   * Turns a field map that contains field paths into a nested map. Turns {a.b : c} into {a : {b :
   * c}}.
   */
  private static Map<String, Object> expandObject(Map<FieldPath, Object> data) {
    Map<String, Object> result = new HashMap<>();

    SortedSet<FieldPath> sortedFields = new TreeSet<>(data.keySet());

    FieldPath lastField = null;

    for (FieldPath field : sortedFields) {
      if (lastField != null && lastField.isPrefixOf(field)) {
        throw new IllegalArgumentException(
            String.format("Detected ambiguous definition for field '%s'.", lastField));
      }

      List<String> segments = field.getSegments();
      Object value = data.get(field);
      Map<String, Object> currentMap = result;

      for (int i = 0; i < segments.size(); ++i) {
        if (i == segments.size() - 1) {
          currentMap.put(segments.get(i), value);
        } else {
          if (!currentMap.containsKey(segments.get(i))) {
            currentMap.put(segments.get(i), new HashMap<>());
          }

          currentMap = (Map<String, Object>) currentMap.get(segments.get(i));
        }
      }

      lastField = field;
    }

    return result;
  }

  /**
   * Creates a new Document at the DocumentReference's location. It fails the write if the document
   * exists.
   *
   * @param documentReference The DocumentReference to create.
   * @param fields A map of the fields and values for the document.
   * @return The instance for chaining.
   */
  @Nonnull
  public T create(
      @Nonnull DocumentReference documentReference, @Nonnull Map<String, Object> fields) {
    return performCreate(documentReference, fields);
  }

  private T performCreate(
      @Nonnull DocumentReference documentReference, @Nonnull Map<String, Object> fields) {
    DocumentSnapshot documentSnapshot =
        DocumentSnapshot.fromObject(firestore, documentReference, fields);
    Write.Builder write = Write.newBuilder();
    write.setUpdate(documentSnapshot.toPb());
    write.getCurrentDocumentBuilder().setExists(false);
    writes.add(write.build());

    DocumentTransform transform =
        DocumentTransform.fromFieldPathMap(
            documentReference, convertToFieldPaths(fields, /* splitOnDots= */ false));
    if (!transform.isEmpty()) {
      writes.add(transform.toPb());
    }

    return (T) this;
  }

  /**
   * Creates a new Document at the DocumentReference location. It fails the write if the document
   * exists.
   *
   * @param documentReference The DocumentReference to create.
   * @param pojo A map of the fields and values for the document.
   * @return The instance for chaining.
   */
  @Nonnull
  public T create(@Nonnull DocumentReference documentReference, @Nonnull Object pojo) {
    Object data = CustomClassMapper.convertToPlainJavaTypes(pojo);
    if (!(data instanceof Map)) {
      FirestoreException.invalidState("Can't set a document's data to an array or primitive");
    }
    return performCreate(documentReference, (Map<String, Object>) data);
  }

  /**
   * Overwrites the document referred to by this DocumentReference. If the document doesn't exist
   * yet, it will be created. If a document already exists, it will be overwritten.
   *
   * @param documentReference The DocumentReference to overwrite.
   * @param fields A map of the field paths and values for the document.
   * @return The instance for chaining.
   */
  @Nonnull
  public T set(@Nonnull DocumentReference documentReference, @Nonnull Map<String, Object> fields) {
    return set(documentReference, fields, SetOptions.OVERWRITE);
  }

  /**
   * Overwrites the document referred to by this DocumentReference. If the document doesn't exist
   * yet, it will be created. If you pass {@link SetOptions}, the provided data can be merged into
   * an existing document.
   *
   * @param documentReference The DocumentReference to overwrite.
   * @param fields A map of the field paths and values for the document.
   * @param options An object to configure the set behavior.
   * @return The instance for chaining.
   */
  @Nonnull
  public T set(
      @Nonnull DocumentReference documentReference,
      @Nonnull Map<String, Object> fields,
      @Nonnull SetOptions options) {
    return performSet(documentReference, fields, options);
  }

  /**
   * Overwrites the document referred to by this DocumentReference. If the document doesn't exist
   * yet, it will be created. If a document already exists, it will be overwritten.
   *
   * @param documentReference The DocumentReference to overwrite.
   * @param pojo The POJO that will be used to populate the document contents.
   * @return The instance for chaining.
   */
  @Nonnull
  public T set(@Nonnull DocumentReference documentReference, @Nonnull Object pojo) {
    return set(documentReference, pojo, SetOptions.OVERWRITE);
  }

  /**
   * Overwrites the document referred to by this DocumentReference. If the document doesn't exist
   * yet, it will be created. If you pass {@link SetOptions}, the provided data can be merged into
   * an existing document.
   *
   * @param documentReference The DocumentReference to overwrite.
   * @param pojo The POJO that will be used to populate the document contents.
   * @param options An object to configure the set behavior.
   * @return The instance for chaining.
   */
  @Nonnull
  public T set(
      @Nonnull DocumentReference documentReference,
      @Nonnull Object pojo,
      @Nonnull SetOptions options) {
    Object data = CustomClassMapper.convertToPlainJavaTypes(pojo);
    if (!(data instanceof Map)) {
      throw new IllegalArgumentException("Can't set a document's data to an array or primitive");
    }
    return performSet(documentReference, (Map<String, Object>) data, options);
  }

  private T performSet(
      @Nonnull DocumentReference documentReference,
      @Nonnull Map<String, Object> fields,
      @Nonnull SetOptions options) {
    Map<FieldPath, Object> documentData;

    if (options.getFieldMask() != null) {
      documentData = applyFieldMask(fields, options.getFieldMask(), FieldPath.empty());
    } else {
      documentData = convertToFieldPaths(fields, /* splitOnDots= */ false);
    }

    DocumentSnapshot document =
        DocumentSnapshot.fromObject(firestore, documentReference, expandObject(documentData));
    Write.Builder write = Write.newBuilder();
    write.setUpdate(document.toPb());

    if (options.isMerge()) {
      DocumentMask documentMask;
      if (options.getFieldMask() != null) {
        documentMask = new DocumentMask(options.getFieldMask());
      } else {
        documentMask = DocumentMask.fromObject(fields);
      }
      write.setUpdateMask(documentMask.toPb());
    }

    writes.add(write.build());

    DocumentTransform transform =
        DocumentTransform.fromFieldPathMap(documentReference, documentData);
    if (!transform.isEmpty()) {
      writes.add(transform.toPb());
    }

    return (T) this;
  }

  /** Removes all values in 'fields' that are not specified in 'fieldMask'. */
  private Map<FieldPath, Object> applyFieldMask(
      Map<String, Object> fields, List<FieldPath> fieldMask, FieldPath root) {
    Map<FieldPath, Object> filteredMap = new HashMap<>();

    for (Entry<String, Object> entry : fields.entrySet()) {
      FieldPath currentField = root.append(FieldPath.of(entry.getKey()));
      if (fieldMask.contains(currentField)) {
        filteredMap.put(currentField, entry.getValue());
      } else if (entry.getValue() instanceof Map) {
        filteredMap.putAll(
            applyFieldMask((Map<String, Object>) entry.getValue(), fieldMask, currentField));
      }
    }

    return filteredMap;
  }

  private Map<FieldPath, Object> convertToFieldPaths(
      @Nonnull Map<String, Object> fields, boolean splitOnDots) {
    Map<FieldPath, Object> fieldPaths = new HashMap<>();

    for (Map.Entry<String, Object> entry : fields.entrySet()) {
      if (splitOnDots) {
        fieldPaths.put(FieldPath.fromDotSeparatedString(entry.getKey()), entry.getValue());
      } else {
        fieldPaths.put(FieldPath.of(entry.getKey()), entry.getValue());
      }
    }

    return fieldPaths;
  }

  /**
   * Updates fields in the document referred to by this DocumentReference. If the document doesn't
   * exist yet, the update will fail.
   *
   * @param documentReference The DocumentReference to update.
   * @param fields A Map containing the fields and values with which to update the document.
   * @return The instance for chaining.
   */
  @Nonnull
  public T update(
      @Nonnull DocumentReference documentReference, @Nonnull Map<String, Object> fields) {
    return update(documentReference, fields, Precondition.exists(true));
  }

  /**
   * Updates fields in the document referred to by this DocumentReference. If the document doesn't
   * exist yet, the update will fail.
   *
   * @param documentReference The DocumentReference to update.
   * @param fields A Map containing the fields and values with which to update the document.
   * @param options Preconditions to enforce on this update.
   * @return The instance for chaining.
   */
  @Nonnull
  public T update(
      @Nonnull DocumentReference documentReference,
      @Nonnull Map<String, Object> fields,
      Precondition options) {
    return performUpdate(
        documentReference, convertToFieldPaths(fields, /* splitOnDots= */ true), options);
  }

  /**
   * Updates the fields in the document referred to by this DocumentReference. If the document
   * doesn't exist yet, the update will fail.
   *
   * @param documentReference The DocumentReference to update.
   * @param field The first field to set.
   * @param value The first value to set.
   * @param moreFieldsAndValues String and Object pairs with more fields to be set.
   * @return The instance for chaining.
   */
  @Nonnull
  public T update(
      @Nonnull DocumentReference documentReference,
      @Nonnull String field,
      @Nullable Object value,
      Object... moreFieldsAndValues) {
    return update(documentReference, Precondition.exists(true), field, value, moreFieldsAndValues);
  }

  /**
   * Updates the fields in the document referred to by this DocumentReference. If the document
   * doesn't exist yet, the update will fail.
   *
   * @param documentReference The DocumentReference to update.
   * @param fieldPath The first field to set.
   * @param value The first value to set.
   * @param moreFieldsAndValues String and Object pairs with more fields to be set.
   * @return The instance for chaining.
   */
  @Nonnull
  public T update(
      @Nonnull DocumentReference documentReference,
      @Nonnull FieldPath fieldPath,
      @Nullable Object value,
      Object... moreFieldsAndValues) {
    return update(
        documentReference, Precondition.exists(true), fieldPath, value, moreFieldsAndValues);
  }

  /**
   * Updates the fields in the document referred to by this DocumentReference. If the document
   * doesn't exist yet, the update will fail.
   *
   * @param documentReference The DocumentReference to update.
   * @param options Preconditions to enforce on this update.
   * @param field The first field to set.
   * @param value The first value to set.
   * @param moreFieldsAndValues String and Object pairs with more fields to be set.
   * @return The instance for chaining.
   */
  @Nonnull
  public T update(
      @Nonnull DocumentReference documentReference,
      @Nonnull Precondition options,
      @Nonnull String field,
      @Nullable Object value,
      Object... moreFieldsAndValues) {
    return update(
        documentReference,
        options,
        FieldPath.fromDotSeparatedString(field),
        value,
        moreFieldsAndValues);
  }

  /**
   * Updates the fields in the document referred to by this DocumentReference. If the document
   * doesn't exist yet, the update will fail.
   *
   * @param documentReference The DocumentReference to update.
   * @param options Preconditions to enforce on this update.
   * @param fieldPath The first field to set.
   * @param value The first value to set.
   * @param moreFieldsAndValues String and Object pairs with more fields to be set.
   * @return The instance for chaining.
   */
  @Nonnull
  public T update(
      @Nonnull DocumentReference documentReference,
      @Nonnull Precondition options,
      @Nonnull FieldPath fieldPath,
      @Nullable Object value,
      Object... moreFieldsAndValues) {
    Map<FieldPath, Object> fields = new HashMap<>();
    fields.put(fieldPath, value);

    Preconditions.checkArgument(
        moreFieldsAndValues.length % 2 == 0, "moreFieldsAndValues must be key-value pairs.");
    for (int i = 0; i < moreFieldsAndValues.length; i += 2) {
      Object objectPath = moreFieldsAndValues[i];
      Object objectValue = moreFieldsAndValues[i + 1];

      if (objectPath instanceof String) {
        fields.put(FieldPath.fromDotSeparatedString((String) objectPath), objectValue);
      } else if (objectPath instanceof FieldPath) {
        fields.put((FieldPath) objectPath, objectValue);
      } else {
        throw new IllegalArgumentException(
            "Field '" + objectPath + "' is not of type String or Field Path.");
      }
    }

    return performUpdate(documentReference, fields, options);
  }

  private T performUpdate(
      @Nonnull DocumentReference documentReference,
      @Nonnull Map<FieldPath, Object> fields,
      Precondition options) {
    Map<String, Object> deconstructedMap = expandObject(fields);
    DocumentSnapshot document =
        DocumentSnapshot.fromObject(firestore, documentReference, deconstructedMap);
    DocumentMask documentMask = new DocumentMask(fields.keySet());

    Write.Builder write = Write.newBuilder();
    write.setUpdate(document.toPb());
    write.setCurrentDocument(options.toPb());
    write.setUpdateMask(documentMask.toPb());
    writes.add(write.build());

    DocumentTransform transform = DocumentTransform.fromFieldPathMap(documentReference, fields);
    if (!transform.isEmpty()) {
      writes.add(transform.toPb());
    }

    return (T) this;
  }

  /**
   * Deletes the document referred to by this DocumentReference.
   *
   * @param documentReference The DocumentReference to delete.
   * @param precondition Precondition for the delete operation.
   * @return The instance for chaining.
   */
  @Nonnull
  public T delete(
      @Nonnull DocumentReference documentReference, @Nonnull Precondition precondition) {
    return performDelete(documentReference, precondition);
  }

  /**
   * Deletes the document referred to by this DocumentReference.
   *
   * @param documentReference The DocumentReference to delete.
   * @return The instance for chaining.
   */
  @Nonnull
  public T delete(@Nonnull DocumentReference documentReference) {
    return performDelete(documentReference, Precondition.NONE);
  }

  private T performDelete(
      @Nonnull DocumentReference documentReference, @Nonnull Precondition precondition) {
    Write.Builder writeBuilder = Write.newBuilder();
    writeBuilder.setDelete(documentReference.getName());
    writeBuilder.setCurrentDocument(precondition.toPb());
    writes.add(writeBuilder.build());
    return (T) this;
  }

  /** Commit the current batch. */
  ApiFuture<List<WriteResult>> commit(@Nullable ByteString transactionId) {
    // We create our own copy of this list since we need to access it when processing the response.
    final ImmutableList<Write> writeRequests = ImmutableList.copyOf(this.writes);

    CommitRequest.Builder request = CommitRequest.newBuilder();
    request.setDatabase(firestore.getDatabaseName());
    request.addAllWrites(writeRequests);

    if (transactionId != null) {
      request.setTransaction(transactionId);
    }

    ApiFuture<CommitResponse> response =
        firestore.sendRequest(request.build(), firestore.getClient().commitCallable());

    return ApiFutures.transform(
        response,
        new ApiFunction<CommitResponse, List<WriteResult>>() {
          @Override
          public List<WriteResult> apply(CommitResponse commitResponse) {
            List<com.google.firestore.v1beta1.WriteResult> writeResults =
                commitResponse.getWriteResultsList();

            List<WriteResult> result = new ArrayList<>();

            Preconditions.checkState(
                writeRequests.size() == writeResults.size(),
                "Expected one write result per operation, but got %s results for %s operations.",
                writeResults.size(),
                writeRequests.size());

            UnmodifiableIterator<Write> requestIterator = writeRequests.iterator();
            Iterator<com.google.firestore.v1beta1.WriteResult> responseIterator =
                writeResults.iterator();

            while (requestIterator.hasNext() && responseIterator.hasNext()) {
              // Don't return write results for DocumentTransforms, as the fact
              // that we have to split one write operation into two distinct
              // write requests is an implementation detail.
              switch (requestIterator.next().getOperationCase()) {
                case UPDATE: // Fall through
                case DELETE:
                  result.add(
                      WriteResult.fromProto(
                          responseIterator.next(), commitResponse.getCommitTime()));
                  break;
                default:
                  break;
              }
            }

            return result;
          }
        });
  }

  /** Checks whether any updates have been queued. */
  boolean isEmpty() {
    return writes.isEmpty();
  }
}
