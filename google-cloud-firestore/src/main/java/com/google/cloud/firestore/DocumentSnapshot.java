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

import com.google.cloud.firestore.UserDataConverter.EncodingOptions;
import com.google.common.base.Preconditions;
import com.google.firestore.v1beta1.Document;
import com.google.firestore.v1beta1.Value;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.threeten.bp.Instant;

/**
 * A DocumentSnapshot contains data read from a document in a Firestore database. The data can be
 * extracted with the getData or get methods.
 */
public final class DocumentSnapshot {

  private final FirestoreImpl firestore;
  private final DocumentReference docRef;
  @Nullable private final Map<String, Value> fields;
  @Nullable private Instant readTime;
  @Nullable private Instant updateTime;
  @Nullable private Instant createTime;

  DocumentSnapshot(
      FirestoreImpl firestore,
      DocumentReference docRef,
      @Nullable Map<String, Value> fields,
      @Nullable Instant readTime,
      @Nullable Instant updateTime,
      @Nullable Instant createTime) {
    this.firestore = firestore;
    this.docRef = docRef;
    this.fields = fields;
    this.readTime = readTime;
    this.updateTime = updateTime;
    this.createTime = createTime;
  }

  /**
   * Returns the ID of the document contained in this snapshot.
   *
   * @return The id of the document.
   */
  @Nonnull
  public String getId() {
    return docRef.getId();
  }

  static DocumentSnapshot fromObject(
      FirestoreImpl firestore,
      DocumentReference docRef,
      Map<String, Object> values,
      EncodingOptions options) {
    Map<String, Value> fields = new HashMap<>();
    for (Map.Entry<String, Object> entry : values.entrySet()) {
      Value encodedValue =
          UserDataConverter.encodeValue(FieldPath.of(entry.getKey()), entry.getValue(), options);
      if (encodedValue != null) {
        fields.put(entry.getKey(), encodedValue);
      }
    }
    return new DocumentSnapshot(firestore, docRef, fields, null, null, null);
  }

  static DocumentSnapshot fromDocument(
      FirestoreImpl firestore, Timestamp readTime, Document document) {
    Timestamp updateTime = document.getUpdateTime();
    Timestamp createTime = document.getCreateTime();
    return new DocumentSnapshot(
        firestore,
        new DocumentReference(firestore, ResourcePath.create(document.getName())),
        document.getFieldsMap(),
        Instant.ofEpochSecond(readTime.getSeconds(), readTime.getNanos()),
        Instant.ofEpochSecond(updateTime.getSeconds(), updateTime.getNanos()),
        Instant.ofEpochSecond(createTime.getSeconds(), createTime.getNanos()));
  }

  static DocumentSnapshot fromMissing(
      FirestoreImpl firestore, DocumentReference documentReference, Instant readTime) {
    return new DocumentSnapshot(firestore, documentReference, null, readTime, null, null);
  }

  private Object decodeValue(Value v) {
    Value.ValueTypeCase typeCase = v.getValueTypeCase();
    switch (typeCase) {
      case NULL_VALUE:
        return null;
      case BOOLEAN_VALUE:
        return v.getBooleanValue();
      case INTEGER_VALUE:
        return v.getIntegerValue();
      case DOUBLE_VALUE:
        return v.getDoubleValue();
      case TIMESTAMP_VALUE:
        Timestamp timestamp = v.getTimestampValue();
        long milliseconds =
            TimeUnit.SECONDS.toMillis(timestamp.getSeconds())
                + TimeUnit.NANOSECONDS.toMillis(timestamp.getNanos());
        return new Date(milliseconds);
      case STRING_VALUE:
        return v.getStringValue();
      case BYTES_VALUE:
        return Blob.fromByteString(v.getBytesValue());
      case REFERENCE_VALUE:
        String pathName = v.getReferenceValue();
        return new DocumentReference(firestore, ResourcePath.create(pathName));
      case GEO_POINT_VALUE:
        return new GeoPoint(
            v.getGeoPointValue().getLatitude(), v.getGeoPointValue().getLongitude());
      case ARRAY_VALUE:
        List<Object> list = new ArrayList<>();
        List<Value> lv = v.getArrayValue().getValuesList();
        for (Value iv : lv) {
          list.add(decodeValue(iv));
        }
        return list;
      case MAP_VALUE:
        Map<String, Object> outputMap = new HashMap<>();
        Map<String, Value> inputMap = v.getMapValue().getFieldsMap();
        for (Map.Entry<String, Value> entry : inputMap.entrySet()) {
          outputMap.put(entry.getKey(), decodeValue(entry.getValue()));
        }
        return outputMap;
      default:
        throw FirestoreException.invalidState(String.format("Unknown Value Type: %s", typeCase));
    }
  }

  /**
   * Returns the time at which this snapshot was read.
   *
   * @return The read time of this snapshot.
   */
  @Nullable
  public Instant getReadTime() {
    return readTime;
  }

  /**
   * Returns the time at which this document was last updated. Returns null for non-existing
   * documents.
   *
   * @return The last time the document in the snapshot was updated. Null if the document doesn't
   *     exist.
   */
  @Nullable
  public Instant getUpdateTime() {
    return updateTime;
  }

  /**
   * Returns the time at which this document was created. Returns null for non-existing documents.
   *
   * @return The last time the document in the snapshot was created. Null if the document doesn't
   *     exist.
   */
  @Nullable
  public Instant getCreateTime() {
    return createTime;
  }

  /**
   * Returns whether the backing document exists in Firestore.
   *
   * @return whether the document existed in this snapshot.
   */
  public boolean exists() {
    return fields != null;
  }

  /**
   * Returns the fields of the document as a Map. Field values will be converted to their native
   * Java representation.
   *
   * @return The fields of the document as a Map.
   * @throws IllegalStateException if the document doesn't exist.
   */
  @Nonnull
  public Map<String, Object> getData() {
    Preconditions.checkState(exists(), "Cannot call getData() on missing document.");
    Map<String, Object> decodedFields = new HashMap<>();
    for (Map.Entry<String, Value> entry : fields.entrySet()) {
      decodedFields.put(entry.getKey(), decodeValue(entry.getValue()));
    }
    return decodedFields;
  }

  /**
   * Returns the contents of the document converted to a POJO.
   *
   * @param valueType The Java class to create.
   * @return The contents of the document in an object of type T.
   * @throws IllegalStateException if the document doesn't exist.
   */
  @Nonnull
  public <T> T toObject(@Nonnull Class<T> valueType) {
    return CustomClassMapper.convertToCustomClass(getData(), valueType);
  }

  /**
   * Returns whether or not the field exists in the document.
   *
   * @param field the path to the field.
   * @return true iff the field exists.
   * @throws IllegalStateException if the document doesn't exist.
   */
  public boolean contains(@Nonnull String field) {
    return contains(FieldPath.fromDotSeparatedString(field));
  }

  /**
   * Returns whether or not the field exists in the document.
   *
   * @param fieldPath the path to the field.
   * @return true iff the field exists.
   * @throws IllegalStateException if the document doesn't exist.
   */
  public boolean contains(@Nonnull FieldPath fieldPath) {
    return this.extractField(fieldPath) != null;
  }

  /**
   * Returns the value at the field or null if the field doesn't exist.
   *
   * @param field The path to the field.
   * @return The value at the given field or null.
   * @throws IllegalStateException if the document doesn't exist.
   */
  @Nullable
  public Object get(@Nonnull String field) {
    return get(FieldPath.fromDotSeparatedString(field));
  }

  /**
   * Returns the value at the field or null if the field doesn't exist.
   *
   * @param fieldPath The path to the field.
   * @return The value at the given field or null.
   * @throws IllegalStateException if the document doesn't exist.
   */
  @Nullable
  public Object get(@Nonnull FieldPath fieldPath) {
    Value value = extractField(fieldPath);

    if (value == null) {
      return null;
    }

    return decodeValue(value);
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
   * Returns the value of the field as a boolean. If the value is not a boolean this will throw a
   * runtime exception
   *
   * @param field The path to the field.
   * @return The value of the field.
   * @throws IllegalStateException if the document doesn't exist.
   */
  @Nullable
  public Boolean getBoolean(@Nonnull String field) {
    return (Boolean) get(field);
  }

  /**
   * Returns the value of the field as a double. If the value is not a double this will throw a
   * runtime exception.
   *
   * @param field The path to the field.
   * @return The value of the field.
   * @throws IllegalStateException if the document doesn't exist.
   */
  @Nullable
  public Double getDouble(@Nonnull String field) {
    return (Double) get(field);
  }

  /**
   * Returns the value of the field as a String. If the value is not a String this will throw a
   * runtime exception
   *
   * @param field The path to the field.
   * @return The value of the field.
   * @throws IllegalStateException if the document doesn't exist.
   */
  @Nullable
  public String getString(@Nonnull String field) {
    return (String) get(field);
  }

  /**
   * Returns the value of the field as a long. If the value is not a long this will throw a runtime
   * exception
   *
   * @param field The path to the field.
   * @return The value of the field.
   * @throws IllegalStateException if the document doesn't exist.
   */
  @Nullable
  public Long getLong(@Nonnull String field) {
    return (Long) get(field);
  }

  /**
   * Returns the value of the field as a Date. If the value is not a Date this will throw a runtime
   * exception
   *
   * @param field The path to the field.
   * @return The value of the field.
   * @throws IllegalStateException if the document doesn't exist.
   */
  @Nullable
  public Date getDate(@Nonnull String field) {
    return (Date) get(field);
  }

  /**
   * Returns the value of the field as a Blob. If the value is not a Blob this will throw a runtime
   * exception
   *
   * @param field The path to the field.
   * @return The value of the field.
   * @throws IllegalStateException if the document doesn't exist.
   */
  @Nullable
  public Blob getBlob(@Nonnull String field) {
    return (Blob) get(field);
  }

  /**
   * Returns the value of the field as a GeoPoint. If the value is not a GeoPoint this will throw a
   * runtime exception
   *
   * @param field The path to the field.
   * @return The value of the field.
   * @throws IllegalStateException if the document doesn't exist.
   */
  @Nullable
  public GeoPoint getGeoPoint(@Nonnull String field) {
    return (GeoPoint) get(field);
  }

  /**
   * Gets the reference to the document.
   *
   * @return The reference to the document.
   */
  @Nonnull
  public DocumentReference getReference() {
    return docRef;
  }

  Document.Builder toPb() {
    Preconditions.checkState(exists(), "Can't call toDocument() on a document that doesn't exist");
    Document.Builder document = Document.newBuilder();
    document.setName(docRef.getName());
    document.putAllFields(fields);
    return document;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentSnapshot that = (DocumentSnapshot) o;
    return Objects.equals(firestore, that.firestore)
        && Objects.equals(docRef, that.docRef)
        && Objects.equals(fields, that.fields)
        && Objects.equals(readTime, that.readTime)
        && Objects.equals(updateTime, that.updateTime)
        && Objects.equals(createTime, that.createTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firestore, docRef, fields, readTime, updateTime, createTime);
  }
}
