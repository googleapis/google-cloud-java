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

import static com.google.cloud.firestore.telemetry.TraceUtil.ATTRIBUTE_KEY_DOC_COUNT;
import static com.google.cloud.firestore.telemetry.TraceUtil.ATTRIBUTE_KEY_IS_TRANSACTIONAL;
import static com.google.common.base.Predicates.not;
import static java.util.stream.Collectors.toCollection;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.InternalExtensionOnly;
import com.google.cloud.firestore.UserDataConverter.EncodingOptions;
import com.google.cloud.firestore.telemetry.TraceUtil;
import com.google.cloud.firestore.telemetry.TraceUtil.Scope;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.Write;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Abstract class that collects and bundles all write operations for {@link Transaction} and {@link
 * WriteBatch}.
 */
@InternalExtensionOnly
public abstract class UpdateBuilder<T> {
  static final class WriteOperation {
    final Write write;
    final DocumentReference documentReference;

    WriteOperation(DocumentReference documentReference, Write write) {
      this.documentReference = documentReference;
      this.write = write;
    }

    @Override
    public String toString() {
      return String.format("WriteOperation{write=%s, doc=%s}", write, documentReference);
    }
  }

  final FirestoreImpl firestore;

  // All reads and writes on `writes` must be done in a block that is synchronized on `writes`;
  // otherwise, you get undefined behavior.
  private final List<WriteOperation> writes = new ArrayList<>();

  protected volatile boolean committed;

  UpdateBuilder(FirestoreImpl firestore) {
    this.firestore = firestore;
  }

  /**
   * Wraps the result of the write operation before it is returned.
   *
   * <p>This method is used to generate the return value for all public methods. It allows
   * operations on Transaction and WriteBatch to return the object for chaining, while also allowing
   * BulkWriter operations to return the future directly.
   */
  abstract T wrapResult(int writeIndex);

  /**
   * Turns a field map that contains field paths into a nested map. Turns {a.b : c} into {a : {b :
   * c}}.
   */
  private static Map<String, Object> expandObject(Map<FieldPath, Object> data) {
    if (data instanceof SortedMap) {
      return expandObject((SortedMap<FieldPath, Object>) data);
    } else {
      return expandObject(new TreeMap<>(data));
    }
  }

  private static Map<String, Object> expandObject(SortedMap<FieldPath, Object> data) {
    Map<String, Object> result = new HashMap<>();

    FieldPath lastField = null;

    for (Entry<FieldPath, Object> entry : data.entrySet()) {
      FieldPath field = entry.getKey();
      if (lastField != null && lastField.isPrefixOf(field)) {
        throw new IllegalArgumentException(
            String.format("Detected ambiguous definition for field '%s'.", lastField));
      }

      Iterator<String> iterator = field.getSegments().iterator();
      if (iterator.hasNext()) {
        String segment = iterator.next();
        Map<String, Object> currentMap = result;
        while (iterator.hasNext()) {
          currentMap =
              (Map<String, Object>) currentMap.computeIfAbsent(segment, key -> new HashMap<>());
          segment = iterator.next();
        }
        currentMap.put(segment, entry.getValue());
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
        DocumentTransform.fromFieldPathMap(convertToFieldPaths(fields));

    Write.Builder write = documentSnapshot.toPb();
    write.setCurrentDocument(Precondition.exists(false).toPb());

    if (!documentTransform.isEmpty()) {
      write.addAllUpdateTransforms(documentTransform.toPb());
    }

    return addWrite(documentReference, write);
  }

  /**
   * Creates a new Document at the DocumentReference location. It fails the write if the document
   * exists.
   *
   * @param documentReference The DocumentReference to create.
   * @param pojo The POJO that will be used to populate the document contents.
   * @return The instance for chaining.
   */
  @Nonnull
  public T create(@Nonnull DocumentReference documentReference, @Nonnull Object pojo) {
    Object data = CustomClassMapper.convertToPlainJavaTypes(pojo);
    if (!(data instanceof Map)) {
      throw FirestoreException.forInvalidArgument(
          "Can't set a document's data to an array or primitive");
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
      documentData = convertToFieldPaths(fields);
    }

    DocumentSnapshot documentSnapshot =
        DocumentSnapshot.fromObject(
            firestore, documentReference, expandObject(documentData), options.getEncodingOptions());
    FieldMask documentMask = FieldMask.EMPTY_MASK;
    DocumentTransform documentTransform = DocumentTransform.fromFieldPathMap(documentData);

    if (options.getFieldMask() != null) {
      TreeSet<FieldPath> fieldPaths =
          options.getFieldMask().stream()
              .filter(not(documentTransform.getFields()::contains))
              .collect(toCollection(TreeSet::new));
      documentMask = new FieldMask(fieldPaths);
    } else if (options.isMerge()) {
      documentMask = FieldMask.fromObject(fields);
    }

    Write.Builder write = documentSnapshot.toPb();
    if (!documentTransform.isEmpty()) {
      write.addAllUpdateTransforms(documentTransform.toPb());
    }

    if (options.isMerge() || options.getFieldMask() != null) {
      write.setUpdateMask(documentMask.toPb());
    }

    return addWrite(documentReference, write);
  }

  private T addWrite(DocumentReference documentReference, Write.Builder write) {
    WriteOperation operation = new WriteOperation(documentReference, write.build());
    int writeIndex;
    synchronized (writes) {
      Preconditions.checkState(
          !committed,
          String.format("Cannot modify a %s that has already been committed.", className()));
      writes.add(operation);
      writeIndex = writes.size() - 1;
    }
    return wrapResult(writeIndex);
  }

  protected String className() {
    return this.getClass().getSimpleName();
  }

  /** Removes all values in 'fields' that are not specified in 'fieldMask'. */
  private static Map<FieldPath, Object> applyFieldMask(
      Map<String, Object> fields, List<FieldPath> fieldMask) {
    Set<FieldPath> remainingFields = new HashSet<>(fieldMask);
    Map<FieldPath, Object> filteredData =
        applyFieldMask(fields, remainingFields, FieldPath.empty());

    if (!remainingFields.isEmpty()) {
      throw new IllegalArgumentException(
          String.format(
              "Field masks contains invalid path. No data exist at field '%s'.",
              remainingFields.iterator().next()));
    }

    return filteredData;
  }

  /**
   * Strips all values in 'fields' that are not specified in 'fieldMask'. Modifies 'fieldMask'
   * inline and removes all matched fields.
   */
  private static Map<FieldPath, Object> applyFieldMask(
      Map<String, Object> fields, Set<FieldPath> fieldMask, FieldPath root) {
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

  private static Map<FieldPath, Object> convertToFieldPaths(@Nonnull Map<String, Object> fields) {
    Map<FieldPath, Object> fieldPaths = new HashMap<>();
    fields.forEach((k, v) -> fieldPaths.put(FieldPath.of(k), v));
    return fieldPaths;
  }

  private static SortedMap<FieldPath, Object> convertToSplitOnDotsFieldPaths(
      @Nonnull Map<String, Object> fields) {
    SortedMap<FieldPath, Object> fieldPaths = new TreeMap<>();
    fields.forEach((k, v) -> fieldPaths.put(FieldPath.fromDotSeparatedString(k), v));
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
        documentReference, convertToSplitOnDotsFieldPaths(fields), Precondition.exists(true));
  }

  /**
   * Updates fields in the document referred to by this DocumentReference. If the document doesn't
   * exist yet, the update will fail.
   *
   * @param documentReference The DocumentReference to update.
   * @param fields A Map containing the fields and values with which to update the document.
   * @param precondition Precondition to enforce on this update.
   * @return The instance for chaining.
   */
  @Nonnull
  public T update(
      @Nonnull DocumentReference documentReference,
      @Nonnull Map<String, Object> fields,
      Precondition precondition) {
    Preconditions.checkArgument(
        !Boolean.FALSE.equals(precondition.getExists()),
        "Precondition 'exists' cannot have the value 'false' for update() calls.");
    return performUpdate(documentReference, convertToSplitOnDotsFieldPaths(fields), precondition);
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
   * @param precondition Precondition to enforce on this update.
   * @param field The first field to set.
   * @param value The first value to set.
   * @param moreFieldsAndValues String and Object pairs with more fields to be set.
   * @return The instance for chaining.
   */
  @Nonnull
  public T update(
      @Nonnull DocumentReference documentReference,
      @Nonnull Precondition precondition,
      @Nonnull String field,
      @Nullable Object value,
      Object... moreFieldsAndValues) {
    Preconditions.checkArgument(
        !Boolean.FALSE.equals(precondition.getExists()),
        "Precondition 'exists' cannot have the value 'false' for update() calls.");
    return performUpdate(
        documentReference,
        precondition,
        FieldPath.fromDotSeparatedString(field),
        value,
        moreFieldsAndValues);
  }

  /**
   * Updates the fields in the document referred to by this DocumentReference. If the document
   * doesn't exist yet, the update will fail.
   *
   * @param documentReference The DocumentReference to update.
   * @param precondition Precondition to enforce on this update.
   * @param fieldPath The first field to set.
   * @param value The first value to set.
   * @param moreFieldsAndValues String and Object pairs with more fields to be set.
   * @return The instance for chaining.
   */
  @Nonnull
  public T update(
      @Nonnull DocumentReference documentReference,
      @Nonnull Precondition precondition,
      @Nonnull FieldPath fieldPath,
      @Nullable Object value,
      Object... moreFieldsAndValues) {
    Preconditions.checkArgument(
        !Boolean.FALSE.equals(precondition.getExists()),
        "Precondition 'exists' cannot have the value 'false' for update() calls.");
    return performUpdate(documentReference, precondition, fieldPath, value, moreFieldsAndValues);
  }

  private T performUpdate(
      @Nonnull DocumentReference documentReference,
      @Nonnull Precondition precondition,
      @Nonnull FieldPath fieldPath,
      @Nullable Object value,
      Object[] moreFieldsAndValues) {
    Object data = CustomClassMapper.convertToPlainJavaTypes(value);
    SortedMap<FieldPath, Object> fields = new TreeMap<>();
    fields.put(fieldPath, data);

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

    return performUpdate(documentReference, fields, precondition);
  }

  private T performUpdate(
      @Nonnull DocumentReference documentReference,
      @Nonnull final SortedMap<FieldPath, Object> fields,
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
    DocumentTransform documentTransform = DocumentTransform.fromFieldPathMap(fields);
    TreeSet<FieldPath> fieldPaths =
        fields.keySet().stream()
            .filter(not(documentTransform.getFields()::contains))
            .collect(toCollection(TreeSet::new));
    FieldMask fieldMask = new FieldMask(fieldPaths);

    Write.Builder write = documentSnapshot.toPb();
    write.setCurrentDocument(precondition.toPb());
    write.setUpdateMask(fieldMask.toPb());

    if (!documentTransform.isEmpty()) {
      write.addAllUpdateTransforms(documentTransform.toPb());
    }

    return addWrite(documentReference, write);
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
    Write.Builder write = Write.newBuilder().setDelete(documentReference.getName());

    if (!precondition.isEmpty()) {
      write.setCurrentDocument(precondition.toPb());
    }

    return addWrite(documentReference, write);
  }

  /** Commit the current batch. */
  ApiFuture<List<WriteResult>> commit(@Nullable ByteString transactionId) {
    TraceUtil.Span span =
        firestore
            .getOptions()
            .getTraceUtil()
            .startSpan(
                transactionId == null
                    ? TraceUtil.SPAN_NAME_BATCH_COMMIT
                    : TraceUtil.SPAN_NAME_TRANSACTION_COMMIT);
    span.setAttribute(ATTRIBUTE_KEY_DOC_COUNT, writes.size());
    span.setAttribute(ATTRIBUTE_KEY_IS_TRANSACTIONAL, transactionId != null);
    try (Scope ignored = span.makeCurrent()) {
      // Sequence is thread safe.
      //
      // 1. Set committed = true
      // 2. Build commit request
      //
      // Step 1 sets uses volatile property to ensure committed is visible to all
      // threads immediately.
      //
      // Step 2 uses `forEach(..)` that is synchronized, therefore will be blocked
      // until any writes are complete.
      //
      // Writes will verify `committed==false` within synchronized block of code
      // before appending writes. Since committed is set to true before accessing
      // writes, we are ensured that no more writes will be appended after commit
      // accesses writes.
      committed = true;
      CommitRequest request = buildCommitRequest(transactionId);

      ApiFuture<CommitResponse> response =
          firestore.sendRequest(request, firestore.getClient().commitCallable());

      ApiFuture<List<WriteResult>> returnValue =
          ApiFutures.transform(
              response,
              commitResponse -> {
                Timestamp commitTime = commitResponse.getCommitTime();
                return commitResponse.getWriteResultsList().stream()
                    .map(writeResult -> WriteResult.fromProto(writeResult, commitTime))
                    .collect(Collectors.toList());
              },
              MoreExecutors.directExecutor());
      span.endAtFuture(returnValue);
      return returnValue;
    } catch (Exception error) {
      span.end(error);
      throw error;
    }
  }

  private CommitRequest buildCommitRequest(ByteString transactionId) {
    CommitRequest.Builder builder = CommitRequest.newBuilder();
    builder.setDatabase(firestore.getDatabaseName());
    forEachWrite(builder::addWrites);
    if (transactionId != null) {
      builder.setTransaction(transactionId);
    }
    return builder.build();
  }

  /** Checks whether any updates have been queued. */
  boolean isEmpty() {
    synchronized (writes) {
      return writes.isEmpty();
    }
  }

  void forEachWrite(Consumer<Write> consumer) {
    synchronized (writes) {
      for (WriteOperation writeOperation : writes) {
        consumer.accept(writeOperation.write);
      }
    }
  }

  /** Get the number of writes. */
  public int getMutationsSize() {
    synchronized (writes) {
      return writes.size();
    }
  }

  @Override
  public String toString() {
    final String writesAsString;
    synchronized (writes) {
      writesAsString = writes.toString();
    }

    return String.format(
        "%s{writes=%s, committed=%s}", getClass().getSimpleName(), writesAsString, committed);
  }
}
