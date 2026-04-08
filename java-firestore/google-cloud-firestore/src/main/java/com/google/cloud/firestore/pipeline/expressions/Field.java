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

package com.google.cloud.firestore.pipeline.expressions;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.cloud.firestore.FieldPath;
import com.google.cloud.firestore.Pipeline;
import com.google.common.base.Objects;
import com.google.firestore.v1.Value;
import javax.annotation.Nullable;

/**
 * Represents a reference to a field in a Firestore document.
 *
 * <p>Field references are used to access document field values in expressions and to specify fields
 * for sorting, filtering, and projecting data in Firestore pipelines.
 *
 * <p>You can create a `Field` instance using the static {@link #field(String)} method:
 *
 * <pre>{@code
 * // Create a Field instance for the 'name' field
 * Field nameField = Field.of("name");
 *
 * // Create a Field instance for a nested field 'address.city'
 * Field cityField = Field.of("address.city");
 * }</pre>
 */
public final class Field extends Expression implements Selectable {
  public static final String DOCUMENT_ID = "__name__";
  private final FieldPath path;
  @Nullable private Pipeline pipeline; // Nullable

  private Field(FieldPath path) {
    this.path = path;
  }

  /**
   * Creates a {@code Field} instance representing the field at the given path.
   *
   * <p>The path can be a simple field name (e.g., "name") or a dot-separated path to a nested field
   * (e.g., "address.city").
   *
   * <p>Example:
   *
   * <pre>{@code
   * // Create a Field instance for the 'title' field
   * Field titleField = Field.of("title");
   *
   * // Create a Field instance for a nested field 'author.firstName'
   * Field authorFirstNameField = Field.of("author.firstName");
   * }</pre>
   *
   * @param path The path to the field.
   * @return A new {@code Field} instance representing the specified field.
   */
  @InternalApi
  public static Field ofUserPath(String path) {
    if (path.equals(DOCUMENT_ID)) {
      return new Field(FieldPath.documentId());
    }
    return new Field(FieldPath.fromDotSeparatedString(path));
  }

  @InternalApi
  public static Field ofServerPath(String path) {
    if (path.equals(DOCUMENT_ID)) {
      return new Field(FieldPath.documentId());
    }
    return new Field(FieldPath.fromServerFormat(path));
  }

  @InternalApi
  public Value toProto() {
    return Value.newBuilder().setFieldReferenceValue(path.toString()).build();
  }

  /**
   * Evaluates to the distance in meters between the location specified by this field and the query
   * location.
   *
   * <p>This Expression can only be used within a {@code Search} stage.
   *
   * @param location Compute distance to this {@link com.google.cloud.firestore.GeoPoint}.
   * @return A new {@link Expression} representing the geoDistance operation.
   */
  @BetaApi
  public Expression geoDistance(com.google.cloud.firestore.GeoPoint location) {
    return Expression.geoDistance(this, location);
  }

  /**
   * Perform a full-text search on this field.
   *
   * <p>This Expression can only be used within a {@code Search} stage.
   *
   * @param rquery Define the search query using the rquery DTS.
   */
  @InternalApi
  BooleanExpression matches(String rquery) {
    return Expression.matches(this, rquery);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Field field = (Field) o;
    return Objects.equal(path, field.path) && Objects.equal(pipeline, field.pipeline);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(path, pipeline);
  }

  @InternalApi
  public FieldPath getPath() {
    return path;
  }
}
