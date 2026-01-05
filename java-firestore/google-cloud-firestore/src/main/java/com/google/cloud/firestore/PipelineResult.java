/*
 * Copyright 2025 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.encoding.CustomClassMapper;
import com.google.common.base.Preconditions;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.Value;
import com.google.firestore.v1.Write;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A PipelineResult contains data read from a Firestore Pipeline. The data can be extracted with the
 * {@link #getData()} or {@link #get(String)} methods.
 *
 * <p>If the PipelineResult represents a non-document result, getReference() will return a null
 * value.
 *
 * <p><b>Subclassing Note</b>: Firestore classes are not meant to be subclassed except for use in
 * test mocks. Subclassing is not supported in production code and new SDK releases may break code
 * that does so.
 */
@InternalExtensionOnly
@BetaApi
public final class PipelineResult {

  private final FirestoreRpcContext<?> rpcContext;
  @Nullable private final DocumentReference docRef;
  @Nullable private final Map<String, Value> fields;
  @Nonnull private final Timestamp executionTime;
  @Nullable private final Timestamp updateTime;
  @Nullable private final Timestamp createTime;

  PipelineResult(
      FirestoreRpcContext<?> rpcContext,
      @Nullable DocumentReference docRef,
      @Nullable Map<String, Value> fields,
      @Nonnull Timestamp executionTime,
      @Nullable Timestamp updateTime,
      @Nullable Timestamp createTime) { // Elevated access level for mocking.
    this.rpcContext = rpcContext;
    this.docRef = docRef;
    this.fields = fields;
    this.executionTime = executionTime;
    if (updateTime != null && updateTime.equals(Timestamp.ofTimeMicroseconds(0))) {
      updateTime = null;
    }
    this.updateTime = updateTime;

    if (createTime != null && createTime.equals(Timestamp.ofTimeMicroseconds(0))) {
      createTime = null;
    }
    this.createTime = createTime;
  }

  /**
   * Returns the ID of the document represented by this result. Returns null if this result is not
   * corresponding to a Firestore document.
   */
  @Nullable
  @BetaApi
  public String getId() {
    return docRef.getId();
  }

  static PipelineResult fromDocument(
      FirestoreRpcContext<?> rpcContext, Timestamp executionTime, Document document) {
    return new PipelineResult(
        rpcContext,
        document.getName().isEmpty()
            ? null
            : new DocumentReference(rpcContext, ResourcePath.create(document.getName())),
        document.getFieldsMap(),
        executionTime,
        Timestamp.fromProto(document.getUpdateTime()),
        Timestamp.fromProto(document.getCreateTime()));
  }

  /** Returns the time at which the pipeline producing this result is executed. */
  @Nullable
  @BetaApi
  public Timestamp getExecutionTime() {
    return executionTime;
  }

  /**
   * Returns the time at which this document was last updated. Returns null if this result is not
   * corresponding to a Firestore document.
   */
  @Nullable
  @BetaApi
  public Timestamp getUpdateTime() {
    return updateTime;
  }

  /**
   * Returns the time at which this document was created. Returns null if this result is not
   * corresponding to a Firestore document.
   */
  @Nullable
  @BetaApi
  public Timestamp getCreateTime() {
    return createTime;
  }

  /**
   * Returns whether or not the field exists in the document. Returns false if the document does not
   * exist.
   *
   * @return whether the document existed in this snapshot.
   */
  @BetaApi
  public boolean exists() {
    return fields != null;
  }

  /**
   * Returns the fields of the result as a Map or null if the result doesn't exist. Field values
   * will be converted to their native Java representation.
   *
   * @return The fields of the document as a Map or null if the result doesn't exist.
   */
  @Nonnull
  @BetaApi
  public Map<String, Object> getData() {
    if (fields == null) {
      return null;
    }

    Map<String, Object> decodedFields = new HashMap<>();
    for (Map.Entry<String, Value> entry : fields.entrySet()) {
      Object decodedValue = UserDataConverter.decodeValue(rpcContext, entry.getValue());
      decodedFields.put(entry.getKey(), decodedValue);
    }
    return decodedFields;
  }

  /**
   * Returns the contents of the document converted to a POJO or null if the result doesn't exist.
   *
   * @param valueType The Java class to create
   * @return The contents of the document in an object of type T or null if the result doesn't
   *     exist.
   */
  @Nullable
  @BetaApi
  <T> T toObject(@Nonnull Class<T> valueType) {
    Map<String, Object> data = getData();
    return data == null ? null : CustomClassMapper.convertToCustomClass(data, valueType, docRef);
  }

  /**
   * Returns whether or not the field exists in the document. Returns false if the result does not
   * exist.
   *
   * @param field the path to the field.
   * @return true iff the field exists.
   */
  @BetaApi
  public boolean contains(@Nonnull String field) {
    return contains(FieldPath.fromDotSeparatedString(field));
  }

  /**
   * Returns whether or not the field exists in the document. Returns false if the result does not
   * exist.
   *
   * @param fieldPath the path to the field.
   * @return true iff the field exists.
   */
  @BetaApi
  public boolean contains(@Nonnull FieldPath fieldPath) {
    return this.extractField(fieldPath) != null;
  }

  /**
   * Returns the value at the field or null if the field doesn't exist.
   *
   * @param field The path to the field.
   * @return The value at the given field or null.
   */
  @Nullable
  @BetaApi
  public Object get(@Nonnull String field) {
    return get(FieldPath.fromDotSeparatedString(field));
  }

  /**
   * Returns the value at the field, converted to a POJO, or null if the field or result doesn't
   * exist.
   *
   * @param field The path to the field
   * @param valueType The Java class to convert the field value to.
   * @return The value at the given field or null.
   */
  @Nullable
  @BetaApi
  public <T> T get(@Nonnull String field, @Nonnull Class<T> valueType) {
    return get(FieldPath.fromDotSeparatedString(field), valueType);
  }

  /**
   * Returns the value at the field or null if the field doesn't exist.
   *
   * @param fieldPath The path to the field.
   * @return The value at the given field or null.
   */
  @Nullable
  @BetaApi
  public Object get(@Nonnull FieldPath fieldPath) {
    Value value = extractField(fieldPath);

    if (value == null) {
      return null;
    }

    return UserDataConverter.decodeValue(rpcContext, value);
  }

  /**
   * Returns the value at the field, converted to a POJO, or null if the field or result doesn't
   * exist.
   *
   * @param fieldPath The path to the field
   * @param valueType The Java class to convert the field value to.
   * @return The value at the given field or null.
   */
  @Nullable
  @BetaApi
  public <T> T get(@Nonnull FieldPath fieldPath, Class<T> valueType) {
    Object data = get(fieldPath);
    return data == null ? null : CustomClassMapper.convertToCustomClass(data, valueType, docRef);
  }

  /** Returns the Value Proto at 'fieldPath'. Returns null if the field was not found. */
  @Nullable
  Value extractField(@Nonnull FieldPath fieldPath) {
    Value value = null;

    if (fields != null) {
      Iterator<String> components = fieldPath.getSegments().iterator();
      value = fields.get(components.next());

      while (value != null && components.hasNext()) {
        if (value.getValueTypeCase() != Value.ValueTypeCase.MAP_VALUE) {
          return null;
        }
        value = value.getMapValue().getFieldsOrDefault(components.next(), null);
      }
    }

    return value;
  }

  /**
   * Returns the value of the field as a boolean.
   *
   * @param field The path to the field.
   * @throws RuntimeException if the value is not a Boolean.
   * @return The value of the field.
   */
  @Nullable
  @BetaApi
  public Boolean getBoolean(@Nonnull String field) {
    return (Boolean) get(field);
  }

  /**
   * Returns the value of the field as a double.
   *
   * @param field The path to the field.
   * @throws RuntimeException if the value is not a Number.
   * @return The value of the field.
   */
  @Nullable
  @BetaApi
  public Double getDouble(@Nonnull String field) {
    Number number = (Number) get(field);
    return number == null ? null : number.doubleValue();
  }

  /**
   * Returns the value of the field as a String.
   *
   * @param field The path to the field.
   * @throws RuntimeException if the value is not a String.
   * @return The value of the field.
   */
  @Nullable
  @BetaApi
  public String getString(@Nonnull String field) {
    return (String) get(field);
  }

  /**
   * Returns the value of the field as a long.
   *
   * @param field The path to the field.
   * @throws RuntimeException if the value is not a Number.
   * @return The value of the field.
   */
  @Nullable
  @BetaApi
  public Long getLong(@Nonnull String field) {
    Number number = (Number) get(field);
    return number == null ? null : number.longValue();
  }

  /**
   * Returns the value of the field as a Date.
   *
   * @param field The path to the field.
   * @throws RuntimeException if the value is not a Date.
   * @return The value of the field.
   */
  @Nullable
  @BetaApi
  public Date getDate(@Nonnull String field) {
    Timestamp timestamp = getTimestamp(field);
    return timestamp == null ? null : timestamp.toDate();
  }

  /**
   * Returns the value of the field as a {@link Timestamp}.
   *
   * @param field The path to the field.
   * @throws RuntimeException if the value is not a Date.
   * @return The value of the field.
   */
  @Nullable
  @BetaApi
  public Timestamp getTimestamp(@Nonnull String field) {
    return (Timestamp) get(field);
  }

  /**
   * Returns the value of the field as a Blob.
   *
   * @param field The path to the field.
   * @throws RuntimeException if the value is not a Blob.
   * @return The value of the field.
   */
  @Nullable
  @BetaApi
  public Blob getBlob(@Nonnull String field) {
    return (Blob) get(field);
  }

  /**
   * Returns the value of the field as a GeoPoint.
   *
   * @param field The path to the field.
   * @throws RuntimeException if the value is not a GeoPoint.
   * @return The value of the field.
   */
  @Nullable
  @BetaApi
  public GeoPoint getGeoPoint(@Nonnull String field) {
    return (GeoPoint) get(field);
  }

  /**
   * Gets the reference to the document.
   *
   * @return The reference to the document.
   */
  @BetaApi
  public DocumentReference getReference() {
    return docRef;
  }

  /** Checks whether this DocumentSnapshot contains any fields. */
  boolean isEmpty() {
    return fields == null || fields.isEmpty();
  }

  Map<String, Value> getProtoFields() {
    return fields;
  }

  Write.Builder toPb() {
    Preconditions.checkState(exists(), "Can't call toDocument() on a document that doesn't exist");
    Write.Builder write = Write.newBuilder();
    Document.Builder document = write.getUpdateBuilder();
    document.setName(docRef.getName());
    document.putAllFields(fields);
    return write;
  }

  Document.Builder toDocumentPb() {
    Preconditions.checkState(exists(), "Can't call toDocument() on a document that doesn't exist");
    Document.Builder document = Document.newBuilder();
    return document
        .setName(docRef.getName())
        .putAllFields(fields)
        .setCreateTime(createTime.toProto())
        .setUpdateTime(updateTime.toProto());
  }

  /**
   * Returns true if the document's data and path in this DocumentSnapshot equals the provided
   * snapshot.
   *
   * @param obj The object to compare against.
   * @return Whether this DocumentSnapshot is equal to the provided object.
   */
  @Override
  @BetaApi
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || !(obj instanceof PipelineResult)) {
      return false;
    }
    PipelineResult that = (PipelineResult) obj;
    return Objects.equals(rpcContext, that.rpcContext)
        && Objects.equals(docRef, that.docRef)
        && Objects.equals(fields, that.fields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rpcContext, docRef, fields);
  }

  @Override
  public String toString() {
    return String.format(
        "%s{doc=%s, fields=%s, executionTime=%s, updateTime=%s, createTime=%s}",
        getClass().getSimpleName(), docRef, fields, executionTime, updateTime, createTime);
  }
}
