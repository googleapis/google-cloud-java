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

package com.google.cloud.spanner.jdbc;

import com.google.cloud.spanner.connection.ConnectionOptionsHelper;
import com.google.cloud.spanner.connection.ConnectionProperties;
import com.google.cloud.spanner.connection.ConnectionProperty;
import com.google.common.collect.ImmutableList;
import java.sql.DriverPropertyInfo;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;
import org.jspecify.annotations.Nullable;

class ConnectionPropertiesHelper {
  static ImmutableList<ConnectionProperty<?>> VALID_CONNECTION_PROPERTIES =
      ImmutableList.copyOf(
          ConnectionProperties.VALID_CONNECTION_PROPERTIES.stream()
              .sorted(Comparator.comparing(ConnectionProperty::getName))
              .collect(Collectors.toList()));

  static DriverPropertyInfo toDriverPropertyInfo(
      String connectionUri,
      @Nullable Map<String, Object> properties,
      ConnectionProperty<?> connectionProperty) {
    String value =
        ConnectionOptionsHelper.parseUriProperty(connectionUri, connectionProperty.getKey());
    if (value == null
        && !connectionProperty.getKey().equalsIgnoreCase(connectionProperty.getName())) {
      value = ConnectionOptionsHelper.parseUriProperty(connectionUri, connectionProperty.getName());
    }
    if (value == null && properties != null) {
      value = ConnectionOptionsHelper.getPropertyFromProperties(properties, connectionProperty);
    }
    if (value == null) {
      value =
          connectionProperty.getDefaultValue() == null
              ? null
              : connectionProperty.getDefaultValue().toString();
    }
    DriverPropertyInfo result = new DriverPropertyInfo(connectionProperty.getName(), value);
    result.description = connectionProperty.getDescription();
    result.choices =
        connectionProperty.getValidValues() == null
            ? null
            : Arrays.stream(connectionProperty.getValidValues())
                .map(Objects::toString)
                .toArray(String[]::new);
    return result;
  }

  static DriverPropertyInfo toDriverPropertyInfo(
      String connectionUri, @Nullable Properties info, ConnectionProperty<?> connectionProperty) {
    return toDriverPropertyInfo(
        connectionUri,
        info == null ? null : ConnectionOptionsHelper.collectProperties(info),
        connectionProperty);
  }

  static String getConnectionPropertyName(ConnectionProperty<?> connectionProperty) {
    return connectionProperty.getName();
  }

  private ConnectionPropertiesHelper() {}
}
