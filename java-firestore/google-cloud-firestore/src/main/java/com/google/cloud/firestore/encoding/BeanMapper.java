/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.firestore.encoding;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.IgnoreExtraProperties;
import com.google.cloud.firestore.annotation.PropertyName;
import com.google.cloud.firestore.annotation.ServerTimestamp;
import com.google.cloud.firestore.annotation.ThrowOnExtraProperties;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.time.Instant;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;

/** Base bean mapper class, providing common functionality for class and record serialization. */
abstract class BeanMapper<T> {
  private final Class<T> clazz;
  // Whether to throw exception if there are properties we don't know how to set to
  // custom object fields/setters or record components during deserialization.
  private final boolean throwOnUnknownProperties;
  // Whether to log a message if there are properties we don't know how to set to
  // custom object fields/setters or record components during deserialization.
  private final boolean warnOnUnknownProperties;
  // A set of property names that were annotated with @ServerTimestamp.
  final HashSet<String> serverTimestamps;
  // A set of property names that were annotated with @DocumentId. These properties will be
  // populated with document ID values during deserialization, and be skipped during
  // serialization.
  final HashSet<String> documentIdPropertyNames;

  BeanMapper(Class<T> clazz) {
    this.clazz = clazz;
    throwOnUnknownProperties = clazz.isAnnotationPresent(ThrowOnExtraProperties.class);
    warnOnUnknownProperties = !clazz.isAnnotationPresent(IgnoreExtraProperties.class);
    serverTimestamps = new HashSet<>();
    documentIdPropertyNames = new HashSet<>();
  }

  Class<T> getClazz() {
    return clazz;
  }

  boolean isThrowOnUnknownProperties() {
    return throwOnUnknownProperties;
  }

  boolean isWarnOnUnknownProperties() {
    return warnOnUnknownProperties;
  }

  /**
   * Serialize an object to a map.
   *
   * @param object the object to serialize
   * @param path the path to a specific field/component in an object, for use in error messages
   * @return the map
   */
  abstract Map<String, Object> serialize(T object, DeserializeContext.ErrorPath path);

  /**
   * Deserialize a map to an object.
   *
   * @param values the map to deserialize
   * @param types generic type mappings
   * @param context context information about the deserialization operation
   * @return the deserialized object
   */
  abstract T deserialize(
      Map<String, Object> values,
      Map<TypeVariable<Class<T>>, Type> types,
      DeserializeContext context);

  T deserialize(Map<String, Object> values, DeserializeContext context) {
    return deserialize(values, Collections.emptyMap(), context);
  }

  protected void verifyValidType(T object) {
    if (!clazz.isAssignableFrom(object.getClass())) {
      throw new IllegalArgumentException(
          "Can't serialize object of class "
              + object.getClass()
              + " with BeanMapper for class "
              + clazz);
    }
  }

  protected Type resolveType(Type type, Map<TypeVariable<Class<T>>, Type> types) {
    if (type instanceof TypeVariable) {
      Type resolvedType = types.get(type);
      if (resolvedType == null) {
        throw new IllegalStateException("Could not resolve type " + type);
      }

      return resolvedType;
    }

    return type;
  }

  protected void checkForDocIdConflict(
      String docIdPropertyName,
      Collection<String> deserializedProperties,
      DeserializeContext context) {
    if (deserializedProperties.contains(docIdPropertyName)) {
      String message =
          "'"
              + docIdPropertyName
              + "' was found from document "
              + context.documentRef.getPath()
              + ", cannot apply @DocumentId on this property for class "
              + clazz.getName();
      throw new RuntimeException(message);
    }
  }

  protected Object getSerializedValue(
      String property, Object propertyValue, DeserializeContext.ErrorPath path) {
    if (serverTimestamps.contains(property) && propertyValue == null) {
      // Replace null ServerTimestamp-annotated fields with the sentinel.
      return FieldValue.serverTimestamp();
    } else {
      return CustomClassMapper.serialize(propertyValue, path.child(property));
    }
  }

  protected void applyFieldAnnotations(Field field) {
    Class<?> fieldType = field.getType();
    if (field.isAnnotationPresent(ServerTimestamp.class)) {
      validateServerTimestampType("Field", "is", fieldType);
      serverTimestamps.add(propertyName(field));
    }
    if (field.isAnnotationPresent(DocumentId.class)) {
      validateDocumentIdType("Field", "is", fieldType);
      documentIdPropertyNames.add(propertyName(field));
    }
  }

  protected void validateDocumentIdType(String fieldDescription, String operation, Type type) {
    if (type != String.class && type != DocumentReference.class) {
      throw new IllegalArgumentException(
          fieldDescription
              + " is annotated with @DocumentId but "
              + operation
              + " "
              + type
              + " instead of String or DocumentReference.");
    }
  }

  protected void validateServerTimestampType(String fieldDescription, String operation, Type type) {
    if (type != Date.class && type != Timestamp.class && type != Instant.class) {
      throw new IllegalArgumentException(
          fieldDescription
              + " is annotated with @ServerTimestamp but "
              + operation
              + " "
              + type
              + " instead of Date, Timestamp, or Instant.");
    }
  }

  protected String propertyName(Field field) {
    String annotatedName = annotatedName(field);
    return annotatedName != null ? annotatedName : field.getName();
  }

  protected String annotatedName(AccessibleObject obj) {
    if (obj.isAnnotationPresent(PropertyName.class)) {
      PropertyName annotation = obj.getAnnotation(PropertyName.class);
      return annotation.value();
    }

    return null;
  }

  protected void hardAssert(boolean assertion, String message) {
    if (!assertion) {
      throw new RuntimeException("Hard assert failed: " + message);
    }
  }
}
