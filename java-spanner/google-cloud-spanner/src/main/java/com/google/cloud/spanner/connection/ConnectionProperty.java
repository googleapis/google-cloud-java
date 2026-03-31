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

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.common.base.Strings;
import java.util.Locale;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * {@link ConnectionProperty} is a variable for a connection. The total set of connection properties
 * is the state of a connection, and determine the behavior of that connection. For example, a
 * connection with a {@link ConnectionProperty} READONLY=true and AUTOCOMMIT=false will use
 * read-only transactions by default, while a connection with READONLY=false and AUTOCOMMIT=false
 * will use read/write transactions.
 *
 * <p>Connection properties are stored in a {@link ConnectionState} instance. {@link
 * ConnectionState} can be transactional. That is; changes to a connection property during a
 * transaction will be undone if the transaction is rolled back. Transactional connection state is
 * the default for PostgreSQL-dialect databases. For GoogleSQL-dialect databases, transactional
 * connection state is an opt-in.
 */
public class ConnectionProperty<T> {

  /**
   * Context indicates when a {@link ConnectionProperty} may be set. Each higher-ordinal value
   * includes the preceding values, meaning that a {@link ConnectionProperty} with {@link
   * Context#USER} can be set both at connection startup and during the connection's lifetime.
   */
  public enum Context {
    /** The property can only be set at startup of the connection. */
    STARTUP,
    /**
     * The property can be set at startup or by a user during the lifetime of a connection. The
     * value is persisted until it is changed again by the user.
     */
    USER,
  }

  /** Utility method for doing an unchecked cast to a typed {@link ConnectionProperty}. */
  static <T> ConnectionProperty<T> castProperty(ConnectionProperty<?> property) {
    //noinspection unchecked
    return (ConnectionProperty<T>) property;
  }

  /**
   * Utility method for creating a key for a {@link ConnectionProperty}. The key of a property is
   * always lower-case and consists of '[extension.]name'.
   */
  @Nonnull
  static String createKey(String extension, @Nonnull String name) {
    ConnectionPreconditions.checkArgument(
        !Strings.isNullOrEmpty(name), "property name must be a non-empty string");
    return extension == null
        ? name.toLowerCase(Locale.ENGLISH)
        : extension.toLowerCase(Locale.ENGLISH) + "." + name.toLowerCase(Locale.ENGLISH);
  }

  /** Utility method for creating a typed {@link ConnectionProperty}. */
  @Nonnull
  static <T> ConnectionProperty<T> create(
      @Nonnull String name,
      String description,
      T defaultValue,
      ClientSideStatementValueConverter<T> converter,
      Context context) {
    return create(name, description, defaultValue, null, converter, context);
  }

  /** Utility method for creating a typed {@link ConnectionProperty}. */
  @Nonnull
  static <T> ConnectionProperty<T> create(
      @Nonnull String name,
      String description,
      T defaultValue,
      T[] validValues,
      ClientSideStatementValueConverter<T> converter,
      Context context) {
    return new ConnectionProperty<>(
        null, name, description, defaultValue, validValues, converter, context);
  }

  /**
   * The 'extension' of this property. This is (currently) only used for PostgreSQL-dialect
   * databases.
   */
  private final String extension;

  @Nonnull private final String name;

  @Nonnull private final String key;

  @Nonnull private final String description;

  private final T defaultValue;

  private final T[] validValues;

  private final ClientSideStatementValueConverter<T> converter;

  private final Context context;

  ConnectionProperty(
      String extension,
      @Nonnull String name,
      @Nonnull String description,
      T defaultValue,
      T[] validValues,
      ClientSideStatementValueConverter<T> converter,
      Context context) {
    ConnectionPreconditions.checkArgument(
        !Strings.isNullOrEmpty(name), "property name must be a non-empty string");
    ConnectionPreconditions.checkArgument(
        !Strings.isNullOrEmpty(description), "property description must be a non-empty string");
    this.extension = extension == null ? null : extension.toLowerCase(Locale.ENGLISH);
    this.name = name.toLowerCase(Locale.ENGLISH);
    this.description = description;
    this.defaultValue = defaultValue;
    this.validValues = validValues;
    this.converter = converter;
    this.context = context;
    this.key = createKey(this.extension, this.name);
  }

  @Override
  public String toString() {
    return this.key;
  }

  @Override
  public int hashCode() {
    return this.key.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ConnectionProperty)) {
      return false;
    }
    ConnectionProperty<?> other = (ConnectionProperty<?>) o;
    return this.key.equals(other.key);
  }

  ConnectionPropertyValue<T> createInitialValue(@Nullable ConnectionPropertyValue<T> initialValue) {
    return initialValue == null
        ? new ConnectionPropertyValue<>(this, this.defaultValue, this.defaultValue)
        : initialValue.copy();
  }

  @Nullable
  ConnectionPropertyValue<T> convert(@Nullable String stringValue) {
    if (stringValue == null) {
      return null;
    }
    T convertedValue = this.converter.convert(stringValue);
    if (convertedValue == null) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT, "Invalid value for property " + this + ": " + stringValue);
    }
    return new ConnectionPropertyValue<>(this, convertedValue, convertedValue);
  }

  @Nonnull
  public String getKey() {
    return this.key;
  }

  public boolean hasExtension() {
    return this.extension != null;
  }

  public String getExtension() {
    return this.extension;
  }

  @Nonnull
  public String getName() {
    return this.name;
  }

  @Nonnull
  public String getDescription() {
    return this.description;
  }

  public T getDefaultValue() {
    return this.defaultValue;
  }

  public T[] getValidValues() {
    return this.validValues;
  }

  public Context getContext() {
    return this.context;
  }
}
