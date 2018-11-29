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
import com.google.cloud.firestore.UserDataConverter.EncodingOptions;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.firestore.v1beta1.CommitRequest;
import com.google.firestore.v1beta1.CommitResponse;
import com.google.firestore.v1beta1.Write;
import com.google.protobuf.ByteString;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Tracing;
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

  private static class Mutation {
    Write.Builder document;
    Write.Builder transform;
    com.google.firestore.v1beta1.Precondition precondition;
  }

  final FirestoreImpl firestore;
  private final List<Mutation> mutations;
  private boolean committed;

  UpdateBuilder(FirestoreImpl firestore) {
    this.firestore = firestore;
    this.mutations = new ArrayList<>();
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
        DocumentSnapshot.fromObject(
            firestore, documentReference, fields, UserDataConverter.NO_DELETES);
    DocumentTransform documentTransform =
        DocumentTransform.fromFieldPathMap(
            documentReference, convertToFieldPaths(fields, /* splitOnDots= */ false));

    Mutation mutation = addMutation();
    mutation.precondition = Precondition.exists(false).toPb();

    if (!documentSnapshot.isEmpty() || documentTransform.isEmpty()) {
      mutation.document = documentSnapshot.toPb();
    }

    if (!documentTransform.isEmpty()) {
      mutation.transform = documentTransform.toPb();
    }

    return (T) this;
  }

  /** Adds a new mutation to the batch. */
  private Mutation addMutation() {
    Preconditions.checkState(
        !committed, "Cannot modify a WriteBatch that has already been committed.");
    Mutation mutation = new Mutation();
    mutations.add(mutation);
    return mutation;
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
      documentData = applyFieldMask(fields, options.getFieldMask());
    } else {
      documentData = convertToFieldPaths(fields, /* splitOnDots= */ false);
    }

    DocumentSnapshot documentSnapshot =
        DocumentSnapshot.fromObject(
            firestore, documentReference, expandObject(documentData), options.getEncodingOptions());
    FieldMask documentMask = FieldMask.EMPTY_MASK;
    DocumentTransform documentTransform =
        DocumentTransform.fromFieldPathMap(documentReference, documentData);

    if (options.isMerge()) {
      if (options.getFieldMask() != null) {
        List<FieldPath> fieldMask = new ArrayList<>(options.getFieldMask());
        fieldMask.removeAll(documentTransform.getFields());
        documentMask = new FieldMask(fieldMask);
      } else {
        documentMask = FieldMask.fromObject(fields);
      }
    }

    Mutation mutation = addMutation();

    boolean hasDocumentData = !documentSnapshot.isEmpty() || !documentMask.isEmpty();

    if (!options.isMerge()) {
      mutation.document = documentSnapshot.toPb();
    } else if (hasDocumentData || documentTransform.isEmpty()) {
      mutation.document = documentSnapshot.toPb();
      mutation.document.setUpdateMask(documentMask.toPb());
    }

    if (!documentTransform.isEmpty()) {
      mutation.transform = documentTransform.toPb();
    }

    return (T) this;
  }

  /** Removes all values in 'fields' that are not specified in 'fieldMask'. */
  private Map<FieldPath, Object> applyFieldMask(
      Map<String, Object> fields, List<FieldPath> fieldMask) {
    List<FieldPath> remainingFields = new ArrayList<>(fieldMask);
    Map<FieldPath, Object> filteredData =
        applyFieldMask(fields, remainingFields, FieldPath.empty());

    if (!remainingFields.isEmpty()) {
      throw new IllegalArgumentException(
          String.format(
              "Field masks contains invalid path. No data exist at field '%s'.",
              remainingFields.get(0)));
    }

    return filteredData;
  }

  /**
   * Strips all values in 'fields' that are not specified in 'fieldMask'. Modifies 'fieldMask'
   * inline and removes all matched fields.
   */
  private Map<FieldPath, Object> applyFieldMask(
      Map<String, Object> fields, List<FieldPath> fieldMask, FieldPath root) {
    Map<FieldPath, Object> filteredMap = new HashMap<>();

    for (Entry<String, Object> entry : fields.entrySet()) {
      FieldPath currentField = root.append(FieldPath.of(entry.getKey()));
      if (fieldMask.remove(currentField)) {
        filteredMap.put(currentField, entry.getValue());
      } else if (entry.getValue() instanceof Map) {
        filteredMap.putAll(
            applyFieldMask((Map<String, Object>) entry.getValue(), fieldMask, currentField));
      } else if (entry.getValue() == FieldValue.DELETE_SENTINEL) {
        throw new IllegalArgumentException(
            String.format(
                "Cannot specify FieldValue.delete() for non-merged field '%s'.", currentField));
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
    return performUpdate(
        documentReference,
        convertToFieldPaths(fields, /* splitOnDots= */ true),
        Precondition.exists(true));
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
    Preconditions.checkArgument(
        !options.hasExists(), "Precondition 'exists' cannot be specified for update() calls.");
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
    return performUpdate(
        documentReference,
        Precondition.exists(true),
        FieldPath.fromDotSeparatedString(field),
        value,
        moreFieldsAndValues);
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
    return performUpdate(
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
    Preconditions.checkArgument(
        !options.hasExists(), "Precondition 'exists' cannot be specified for update() calls.");
    return performUpdate(
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
    Preconditions.checkArgument(
        !options.hasExists(), "Precondition 'exists' cannot be specified for update() calls.");
    return performUpdate(documentReference, options, fieldPath, value, moreFieldsAndValues);
  }

  private T performUpdate(
      @Nonnull DocumentReference documentReference,
      @Nonnull Precondition options,
      @Nonnull FieldPath fieldPath,
      @Nullable Object value,
      Object[] moreFieldsAndValues) {
    Map<FieldPath, Object> fields = new HashMap<>();
    fields.put(fieldPath, value);

    Preconditions.checkArgument(
        moreFieldsAndValues.length % 2 == 0, "moreFieldsAndValues must be key-value pairs.");
    for (int i = 0; i < moreFieldsAndValues.length; i += 2) {
      Object objectPath = moreFieldsAndValues[i];
      Object objectValue = moreFieldsAndValues[i + 1];

      FieldPath currentPath;

      if (objectPath instanceof String) {
        currentPath = FieldPath.fromDotSeparatedString((String) objectPath);
      } else if (objectPath instanceof FieldPath) {
        currentPath = (FieldPath) objectPath;
      } else {
        throw new IllegalArgumentException(
            "Field '" + objectPath + "' is not of type String or Field Path.");
      }

      if (fields.containsKey(currentPath)) {
        throw new IllegalArgumentException(
            "Field value for field '" + objectPath + "' was specified multiple times.");
      }

      fields.put(currentPath, objectValue);
    }

    return performUpdate(documentReference, fields, options);
  }

  private T performUpdate(
      @Nonnull DocumentReference documentReference,
      @Nonnull final Map<FieldPath, Object> fields,
      @Nonnull Precondition precondition) {
    Preconditions.checkArgument(!fields.isEmpty(), "Data for update() cannot be empty.");

    Map<String, Object> deconstructedMap = expandObject(fields);
    DocumentSnapshot documentSnapshot =
        DocumentSnapshot.fromObject(
            firestore,
            documentReference,
            deconstructedMap,
            new EncodingOptions() {
              @Override
              public boolean allowDelete(FieldPath fieldPath) {
                return fields.containsKey(fieldPath);
              }

              @Override
              public boolean allowTransform() {
                return true;
              }
            });
    List<FieldPath> fieldPaths = new ArrayList<>(fields.keySet());
    DocumentTransform documentTransform =
        DocumentTransform.fromFieldPathMap(documentReference, fields);
    fieldPaths.removeAll(documentTransform.getFields());
    FieldMask fieldMask = new FieldMask(fieldPaths);

    Mutation mutation = addMutation();
    mutation.precondition = precondition.toPb();

    if (!documentSnapshot.isEmpty() || !fieldMask.isEmpty()) {
      mutation.document = documentSnapshot.toPb();
      mutation.document.setUpdateMask(fieldMask.toPb());
    }

    if (!documentTransform.isEmpty()) {
      mutation.transform = documentTransform.toPb();
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
    Mutation mutation = addMutation();
    mutation.document = Write.newBuilder().setDelete(documentReference.getName());

    if (!precondition.isEmpty()) {
      mutation.precondition = precondition.toPb();
    }

    return (T) this;
  }

  /** Commit the current batch. */
  ApiFuture<List<WriteResult>> commit(@Nullable ByteString transactionId) {
    Tracing.getTracer()
        .getCurrentSpan()
        .addAnnotation(
            "CloudFirestore.Commit",
            ImmutableMap.of("numDocuments", AttributeValue.longAttributeValue(mutations.size())));

    final CommitRequest.Builder request = CommitRequest.newBuilder();
    request.setDatabase(firestore.getDatabaseName());

    for (Mutation mutation : mutations) {
      Preconditions.checkState(
          mutation.document != null || mutation.transform != null,
          "Either a write or transform must be set");

      if (mutation.precondition != null) {
        (mutation.document != null ? mutation.document : mutation.transform)
            .setCurrentDocument(mutation.precondition);
      }

      if (mutation.document != null) {
        request.addWrites(mutation.document);
      }

      if (mutation.transform != null) {
        request.addWrites(mutation.transform);
      }
    }

    if (transactionId != null) {
      request.setTransaction(transactionId);
    }

    committed = true;

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
                request.getWritesCount() == writeResults.size(),
                "Expected one write result per operation, but got %s results for %s operations.",
                writeResults.size(),
                request.getWritesCount());

            Iterator<Mutation> mutationIterator = mutations.iterator();
            Iterator<com.google.firestore.v1beta1.WriteResult> responseIterator =
                writeResults.iterator();

            while (mutationIterator.hasNext()) {
              Mutation mutation = mutationIterator.next();

              // Don't return both write results for a write that contains a transform, as the fact
              // that we have to split one write operation into two distinct write requests is an
              // implementation detail.
              if (mutation.document != null && mutation.transform != null) {
                // The document transform is always sent last and produces the latest update time.
                responseIterator.next();
              }

              result.add(
                  WriteResult.fromProto(responseIterator.next(), commitResponse.getCommitTime()));
            }

            return result;
          }
        });
  }

  /** Checks whether any updates have been queued. */
  boolean isEmpty() {
    return mutations.isEmpty();
  }
}
