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

package com.google.cloud.spanner.connection;

import com.google.api.core.InternalApi;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.connection.ConnectionProperty.Context;
import com.google.common.base.Preconditions;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Value holder for a {@link ConnectionProperty} in a {@link ConnectionOptions} or {@link
 * ConnectionState}.
 */
@InternalApi
public class ConnectionPropertyValue<T> {
  static <T> ConnectionPropertyValue<T> cast(ConnectionPropertyValue<?> value) {
    //noinspection unchecked
    return (ConnectionPropertyValue<T>) value;
  }

  /** Creates a {@link ConnectionPropertyValue} with the given property and value. */
  public static <T> ConnectionPropertyValue<T> of(
      ConnectionProperty<T> property, @Nullable T value) {
    Preconditions.checkNotNull(property, "property must not be null");
    if (!property.isValidValue(value)) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT, "Invalid value for property " + property + ": " + value);
    }
    return new ConnectionPropertyValue<>(property, value, value);
  }

  private final ConnectionProperty<T> property;
  private final @Nullable T resetValue;

  private @Nullable T value;

  ConnectionPropertyValue(
      ConnectionProperty<T> property, @Nullable T resetValue, @Nullable T value) {
    this.property = property;
    this.resetValue = resetValue;
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ConnectionPropertyValue)) {
      return false;
    }
    ConnectionPropertyValue<T> other = cast((ConnectionPropertyValue<?>) o);
    return Objects.equals(this.property, other.property)
        && Objects.equals(this.resetValue, other.resetValue)
        && Objects.equals(this.value, other.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.property, this.resetValue, this.value);
  }

  public ConnectionProperty<T> getProperty() {
    return property;
  }

  public @Nullable T getResetValue() {
    return resetValue;
  }

  public @Nullable T getValue() {
    return value;
  }

  void setValue(T value, Context context) {
    ConnectionPreconditions.checkState(
        property.getContext().ordinal() >= context.ordinal(),
        "Property has context "
            + property.getContext()
            + " and cannot be set in context "
            + context);
    this.value = value;
  }

  ConnectionPropertyValue<T> copy() {
    return new ConnectionPropertyValue<>(this.property, this.resetValue, this.value);
  }
}
