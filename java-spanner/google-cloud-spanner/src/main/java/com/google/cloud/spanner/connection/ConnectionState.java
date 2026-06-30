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

import static com.google.cloud.spanner.connection.ConnectionProperties.CONNECTION_PROPERTIES;
import static com.google.cloud.spanner.connection.ConnectionProperties.CONNECTION_STATE_TYPE;
import static com.google.cloud.spanner.connection.ConnectionProperty.castProperty;
import static com.google.cloud.spanner.connection.ConnectionPropertyValue.cast;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.connection.ConnectionProperty.Context;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Suppliers;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.function.Supplier;
import javax.annotation.Nullable;

class ConnectionState {
  /** The type of connection state that is used. */
  enum Type {
    /**
     * Transactional connection state will roll back changes to connection properties that have been
     * done during a transaction if the transaction is rolled back.
     */
    TRANSACTIONAL,
    /**
     * Non-transactional connection state directly applies connection property changes during
     * transactions to the main set of properties. Note that non-transactional connection state does
     * support local properties. These are property changes that are only visible during the current
     * transaction, and that are lost after committing or rolling back the current transaction.
     */
    NON_TRANSACTIONAL,
  }

  private final Object lock = new Object();

  private final Supplier<Type> type;

  /** properties contain the current connection properties of a connection. */
  private final Map<String, ConnectionPropertyValue<?>> properties;

  /**
   * transactionProperties are the modified connection properties during a transaction. This is only
   * used for {@link ConnectionState} that is marked as {@link Type#TRANSACTIONAL}.
   */
  private Map<String, ConnectionPropertyValue<?>> transactionProperties;

  /** localProperties are the modified local properties during a transaction. */
  private Map<String, ConnectionPropertyValue<?>> localProperties;

  /** Constructs a non-transactional {@link ConnectionState} with the given initial values. */
  ConnectionState(Map<String, ConnectionPropertyValue<?>> initialValues) {
    this(initialValues, Suppliers.ofInstance(Type.NON_TRANSACTIONAL));
  }

  /**
   * Constructs a {@link ConnectionState} with the given initial values. The type will be
   * transactional or non-transactional based on the value that is returned by the given supplier.
   * The type is determined lazily to allow connections to determine the default based on the
   * dialect, and the dialect is not known directly when a connection is created.
   */
  ConnectionState(
      Map<String, ConnectionPropertyValue<?>> initialValues,
      Supplier<Type> defaultConnectionStateTypeSupplier) {
    this.properties = new HashMap<>(CONNECTION_PROPERTIES.size());
    for (Entry<String, ConnectionProperty<?>> entry : CONNECTION_PROPERTIES.entrySet()) {
      this.properties.put(
          entry.getKey(),
          entry.getValue().createInitialValue(cast(initialValues.get(entry.getKey()))));
    }
    // Add any additional non-core values from the options.
    for (Entry<String, ConnectionPropertyValue<?>> entry : initialValues.entrySet()) {
      if (!this.properties.containsKey(entry.getKey())) {
        setValue(
            castProperty(entry.getValue().getProperty()),
            cast(entry.getValue()).getValue(),
            Context.STARTUP,
            /* inTransaction= */ false);
      }
    }
    Type configuredType = getValue(CONNECTION_STATE_TYPE).getValue();
    if (configuredType == null) {
      this.type = defaultConnectionStateTypeSupplier;
    } else {
      this.type = Suppliers.ofInstance(configuredType);
    }
  }

  @VisibleForTesting
  Type getType() {
    return this.type.get();
  }

  boolean hasTransactionalChanges() {
    synchronized (lock) {
      return this.transactionProperties != null || this.localProperties != null;
    }
  }

  /**
   * Returns an unmodifiable map with all the property values of this {@link ConnectionState}. The
   * map cannot be modified, but any changes to the current (committed) state will be reflected in
   * the map that is returned by this method.
   */
  Map<String, ConnectionPropertyValue<?>> getAllValues() {
    synchronized (lock) {
      return Collections.unmodifiableMap(this.properties);
    }
  }

  /** Returns the current value of the specified setting. */
  <T> ConnectionPropertyValue<T> getValue(ConnectionProperty<T> property) {
    synchronized (lock) {
      return internalGetValue(property, true);
    }
  }

  /** Returns the current value of the specified setting or null if undefined. */
  @Nullable
  <T> ConnectionPropertyValue<T> tryGetValue(ConnectionProperty<T> property) {
    synchronized (lock) {
      return internalGetValue(property, false);
    }
  }

  private <T> ConnectionPropertyValue<T> internalGetValue(
      ConnectionProperty<T> property, boolean throwForUnknownParam) {
    if (localProperties != null && localProperties.containsKey(property.getKey())) {
      return cast(localProperties.get(property.getKey()));
    }
    if (transactionProperties != null && transactionProperties.containsKey(property.getKey())) {
      return cast(transactionProperties.get(property.getKey()));
    }
    if (properties.containsKey(property.getKey())) {
      return cast(properties.get(property.getKey()));
    }
    if (throwForUnknownParam) {
      throw unknownParamError(property);
    }
    return null;
  }

  /**
   * Sets the value of the specified property. The new value will be persisted if the current
   * transaction is committed or directly if the connection state is non-transactional. The value
   * will be lost if the transaction is rolled back and the connection state is transactional.
   */
  <T> void setValue(
      ConnectionProperty<T> property, T value, Context context, boolean inTransaction) {
    ConnectionPreconditions.checkState(
        property.getContext().ordinal() >= context.ordinal(),
        "Property has context "
            + property.getContext()
            + " and cannot be set in context "
            + context);
    synchronized (lock) {
      if (!inTransaction
          || getType() == Type.NON_TRANSACTIONAL
          || context.ordinal() < Context.USER.ordinal()) {
        internalSetValue(property, value, properties, context);
        return;
      }

      if (transactionProperties == null) {
        transactionProperties = new HashMap<>();
      }
      internalSetValue(property, value, transactionProperties, context);
      // Remove the setting from the local settings if it's there, as the new transaction setting is
      // the one that should be used.
      if (localProperties != null) {
        localProperties.remove(property.getKey());
      }
    }
  }

  /**
   * Sets the value of the specified setting for the current transaction. This value is lost when
   * the transaction is committed or rolled back. This can be used to temporarily set a value only
   * during a transaction, for example if a user wants to disable internal transaction retries only
   * for a single transaction.
   */
  <T> void setLocalValue(ConnectionProperty<T> property, T value) {
    ConnectionPreconditions.checkState(
        property.getContext().ordinal() >= Context.USER.ordinal(),
        "setLocalValue is only supported for properties with context USER or higher.");
    synchronized (lock) {
      if (localProperties == null) {
        localProperties = new HashMap<>();
      }
      // Note that setting a local setting does not remove it from the transaction settings. This
      // means that a commit will persist the setting in transactionSettings.
      internalSetValue(property, value, localProperties, Context.USER);
    }
  }

  /**
   * Resets the value of the specified property. The new value will be persisted if the current
   * transaction is committed or directly if the connection state is non-transactional. The value
   * will be lost if the transaction is rolled back and the connection state is transactional.
   */
  <T> void resetValue(ConnectionProperty<T> property, Context context, boolean inTransaction) {
    synchronized (lock) {
      ConnectionPropertyValue<T> currentValue = getValue(property);
      if (currentValue == null) {
        setValue(property, null, context, inTransaction);
      } else {
        setValue(property, currentValue.getResetValue(), context, inTransaction);
      }
    }
  }

  /** Persists the new value for a property to the given map of properties. */
  private <T> void internalSetValue(
      ConnectionProperty<T> property,
      T value,
      Map<String, ConnectionPropertyValue<?>> currentProperties,
      Context context) {
    checkValidValue(property, value);
    ConnectionPropertyValue<T> newValue = cast(currentProperties.get(property.getKey()));
    if (newValue == null) {
      ConnectionPropertyValue<T> existingValue = cast(properties.get(property.getKey()));
      if (existingValue == null) {
        if (!property.hasExtension()) {
          throw unknownParamError(property);
        }
        newValue = new ConnectionPropertyValue<T>(property, null, null);
      } else {
        newValue = existingValue.copy();
      }
    }
    newValue.setValue(value, context);
    currentProperties.put(property.getKey(), newValue);
  }

  static <T> void checkValidValue(ConnectionProperty<T> property, T value) {
    if (property.getValidValues() == null || property.getValidValues().length == 0) {
      return;
    }
    if (Arrays.stream(property.getValidValues())
        .noneMatch(validValue -> Objects.equals(validValue, value))) {
      throw invalidParamValueError(property, value);
    }
  }

  /** Creates an exception for an invalid value for a connection property. */
  static <T> SpannerException invalidParamValueError(ConnectionProperty<T> property, T value) {
    return SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT,
        String.format("invalid value \"%s\" for configuration property \"%s\"", value, property));
  }

  /** Creates an exception for an unknown connection property. */
  static SpannerException unknownParamError(ConnectionProperty<?> property) {
    return SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT,
        String.format("unrecognized configuration property \"%s\"", property));
  }

  /**
   * Commits the current transaction and persists any changes to the settings (except local
   * changes).
   */
  void commit() {
    synchronized (lock) {
      if (transactionProperties != null) {
        for (ConnectionPropertyValue<?> value : transactionProperties.values()) {
          properties.put(value.getProperty().getKey(), value);
        }
      }
      this.localProperties = null;
      this.transactionProperties = null;
    }
  }

  /** Rolls back the current transaction and abandons any pending changes to the settings. */
  void rollback() {
    synchronized (lock) {
      this.localProperties = null;
      this.transactionProperties = null;
    }
  }
}
