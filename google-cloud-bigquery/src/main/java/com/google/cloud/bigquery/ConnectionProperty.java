/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public final class ConnectionProperty {

  static final Function<
          com.google.api.services.bigquery.model.ConnectionProperty, ConnectionProperty>
      FROM_PB_FUNCTION =
          new Function<
              com.google.api.services.bigquery.model.ConnectionProperty, ConnectionProperty>() {
            @Override
            public ConnectionProperty apply(
                com.google.api.services.bigquery.model.ConnectionProperty connectionProperty) {
              return ConnectionProperty.fromPb(connectionProperty);
            }
          };
  static final Function<
          ConnectionProperty, com.google.api.services.bigquery.model.ConnectionProperty>
      TO_PB_FUNCTION =
          new Function<
              ConnectionProperty, com.google.api.services.bigquery.model.ConnectionProperty>() {
            @Override
            public com.google.api.services.bigquery.model.ConnectionProperty apply(
                ConnectionProperty connectionProperty) {
              return connectionProperty.toPb();
            }
          };

  private final String key;
  private final String value;

  /** A builder for {@code ConnectionProperty} objects. */
  public static final class Builder {
    private String key;
    private String value;

    private Builder() {}
    ;

    private Builder(ConnectionProperty properties) {
      this.key = properties.key;
      this.value = properties.value;
    }

    /** [Required] Name of the connection property to set. */
    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    /** [Required] Value of the connection property. */
    public Builder setValue(String value) {
      this.value = value;
      return this;
    }

    /** Creates a {@code ConnectionProperty} object. */
    public ConnectionProperty build() {
      return new ConnectionProperty(this);
    }
  }

  private ConnectionProperty(Builder builder) {
    this.key = checkNotNull(builder.key, "Required key is null or empty");
    this.value = checkNotNull(builder.value, "Required value is null or empty");
  }

  /** Return the key of property. */
  public String getKey() {
    return key;
  }

  /** Return the value of property. */
  public String getValue() {
    return value;
  }

  /** Return a connection property for the given key and value. */
  public static ConnectionProperty of(String key, String value) {
    return newBuilder().setKey(key).setValue(value).build();
  }

  /** Returns a builder for the {@code ConnectionProperty} object. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns a builder for the {@code ConnectionProperty} object. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("key", key).add("value", value).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(key, value);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(ConnectionProperty.class)
            && java.util.Objects.equals(toPb(), ((ConnectionProperty) obj).toPb());
  }

  com.google.api.services.bigquery.model.ConnectionProperty toPb() {
    com.google.api.services.bigquery.model.ConnectionProperty properties =
        new com.google.api.services.bigquery.model.ConnectionProperty();
    properties.setKey(key);
    properties.setValue(value);
    return properties;
  }

  static ConnectionProperty fromPb(
      com.google.api.services.bigquery.model.ConnectionProperty properties) {
    Builder builder = newBuilder();
    builder.setKey(properties.getKey());
    builder.setValue(properties.getValue());
    return builder.build();
  }
}
