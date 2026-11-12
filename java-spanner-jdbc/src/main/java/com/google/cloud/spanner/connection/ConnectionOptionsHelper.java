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
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.connection.StatementExecutor.StatementExecutorType;
import io.opentelemetry.api.OpenTelemetry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import org.jspecify.annotations.Nullable;

@InternalApi
public class ConnectionOptionsHelper {

  private static final String OPEN_TELEMETRY_PROPERTY_KEY = "openTelemetry";
  private static final String USER_PROPERTY_NAME = "user";

  @InternalApi
  public static ConnectionOptions.Builder useDirectExecutorIfNotUseVirtualThreads(
      String connectionUri, ConnectionOptions.Builder builder) {
    return useDirectExecutorIfNotUseVirtualThreads(connectionUri, null, builder);
  }

  @InternalApi
  public static ConnectionOptions.Builder useDirectExecutorIfNotUseVirtualThreads(
      String connectionUri, @Nullable Properties info, ConnectionOptions.Builder builder) {
    boolean useVirtualThreads = false;
    String uriValue =
        ConnectionOptions.parseUriProperty(
            connectionUri, ConnectionProperties.USE_VIRTUAL_THREADS.getKey());
    if (uriValue != null) {
      useVirtualThreads = Boolean.parseBoolean(uriValue);
    } else if (info != null) {
      String infoValue = getPropertyFromInfo(info, ConnectionProperties.USE_VIRTUAL_THREADS);
      if (infoValue != null) {
        useVirtualThreads = Boolean.parseBoolean(infoValue);
      }
    }
    if (!useVirtualThreads) {
      return builder.setStatementExecutorType(StatementExecutorType.DIRECT_EXECUTOR);
    }
    return builder;
  }

  /**
   * Applies properties from the given {@link Properties} object to the {@link
   * ConnectionOptions.Builder} without string concatenation or delimiter injection.
   *
   * <p>Properties specified in the connection URI take precedence over properties in the {@link
   * Properties} object, conforming to JDBC 4.3 specification §9.2.
   *
   * @return warning message if lenient mode is enabled and unknown properties were found, or {@code
   *     null} otherwise.
   * @throws SpannerException if lenient mode is not enabled and unknown properties are present in
   *     {@code info}.
   */
  @Nullable
  @InternalApi
  public static String applyProperties(
      ConnectionOptions.Builder builder, String connectionUri, @Nullable Properties info) {
    applyUserFromUri(builder, connectionUri);
    Map<String, Object> allProperties = collectProperties(info);
    if (allProperties.isEmpty()) {
      return null;
    }
    boolean isLenient = isLenient(connectionUri, allProperties);
    String warning = validateProperties(allProperties, isLenient);
    applyPropertiesToBuilder(builder, connectionUri, allProperties);
    return warning;
  }

  private static void applyUserFromUri(ConnectionOptions.Builder builder, String connectionUri) {
    if (ConnectionOptions.parseUriProperty(connectionUri, ConnectionOptions.USERNAME_PROPERTY_NAME)
        == null) {
      String uriUser = ConnectionOptions.parseUriProperty(connectionUri, USER_PROPERTY_NAME);
      if (uriUser != null) {
        setPropertyValue(builder, ConnectionProperties.USERNAME, uriUser);
      }
    }
  }

  @Nullable
  private static String validateProperties(Map<String, Object> allProperties, boolean isLenient) {
    List<String> invalidProperties = findInvalidProperties(allProperties);
    if (invalidProperties.isEmpty()) {
      return null;
    }
    if (!isLenient) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT,
          String.format(
              "Invalid properties found in connection properties. Add lenient=true to ignore"
                  + " unknown properties. Invalid properties: %s",
              String.join(", ", invalidProperties)));
    }
    return String.format(
        "Invalid properties found in connection properties: %s",
        String.join(", ", invalidProperties));
  }

  private static List<String> findInvalidProperties(Map<String, Object> allProperties) {
    List<String> invalidProperties = new ArrayList<>();
    for (Map.Entry<String, Object> entry : allProperties.entrySet()) {
      String propertyName = entry.getKey();
      Object rawValue = entry.getValue();
      if (OPEN_TELEMETRY_PROPERTY_KEY.equalsIgnoreCase(propertyName)) {
        continue;
      }
      boolean isKnown =
          ConnectionProperties.CONNECTION_PROPERTIES.containsKey(
              propertyName.toLowerCase(Locale.ENGLISH));
      if (!isKnown) {
        // Unknown property:
        // If the value is not a String (e.g. an internal connection pool config object)
        // or is an empty string, skip it to maintain backwards compatibility with
        // connection pools.
        if (!(rawValue instanceof String) || ((String) rawValue).isEmpty()) {
          continue;
        }
        invalidProperties.add(propertyName);
      }
    }
    return invalidProperties;
  }

  private static void applyPropertiesToBuilder(
      ConnectionOptions.Builder builder, String connectionUri, Map<String, Object> properties) {
    for (Map.Entry<String, Object> entry : properties.entrySet()) {
      if (entry.getValue() == null) {
        continue;
      }
      String propertyName = entry.getKey();
      if (OPEN_TELEMETRY_PROPERTY_KEY.equalsIgnoreCase(propertyName)) {
        continue;
      }
      ConnectionProperty<?> property =
          ConnectionProperties.CONNECTION_PROPERTIES.get(propertyName.toLowerCase(Locale.ENGLISH));
      if (property != null) {
        applyPropertyIfAbsentInUri(builder, connectionUri, property, entry.getValue());
      }
    }
  }

  private static void applyPropertyIfAbsentInUri(
      ConnectionOptions.Builder builder,
      String connectionUri,
      ConnectionProperty<?> property,
      Object value) {
    String uriValue = parseUriProperty(connectionUri, property.getKey());
    if (uriValue == null && !property.getKey().equalsIgnoreCase(property.getName())) {
      uriValue = parseUriProperty(connectionUri, property.getName());
    }
    if (uriValue == null) {
      setPropertyValue(builder, property, String.valueOf(value));
    }
  }

  @InternalApi
  public static Map<String, Object> collectProperties(@Nullable Properties info) {
    if (info == null || (info.isEmpty() && info.stringPropertyNames().isEmpty())) {
      return Collections.emptyMap();
    }
    Map<String, Object> allProperties = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    for (Map.Entry<Object, Object> entry : info.entrySet()) {
      if (entry.getKey() instanceof String) {
        allProperties.put((String) entry.getKey(), entry.getValue());
      }
    }
    // Normalize 'user' to 'username' for direct properties first so that an explicit 'user'
    // in main properties takes precedence over any 'username' or 'user' in default properties.
    normalizeUserProperty(allProperties);
    applyDefaultUserProperty(allProperties, info);
    for (String stringName : info.stringPropertyNames()) {
      if (!USER_PROPERTY_NAME.equalsIgnoreCase(stringName)
          && !ConnectionOptions.USERNAME_PROPERTY_NAME.equalsIgnoreCase(stringName)
          && !allProperties.containsKey(stringName)) {
        allProperties.put(stringName, info.getProperty(stringName));
      }
    }
    return allProperties;
  }

  /**
   * Applies the default 'username' or 'user' property from the underlying defaults in {@code info}
   * to {@code allProperties} if neither was explicitly set in the main properties. If both
   * 'username' and 'user' exist in defaults, 'username' is preferred deterministically.
   */
  private static void applyDefaultUserProperty(Map<String, Object> allProperties, Properties info) {
    if (allProperties.containsKey(ConnectionOptions.USERNAME_PROPERTY_NAME)) {
      return;
    }
    String defaultUsernameKey =
        findStringKeyIgnoreCase(info, ConnectionOptions.USERNAME_PROPERTY_NAME);
    if (defaultUsernameKey != null) {
      allProperties.put(
          ConnectionOptions.USERNAME_PROPERTY_NAME, info.getProperty(defaultUsernameKey));
    } else {
      String defaultUserKey = findStringKeyIgnoreCase(info, USER_PROPERTY_NAME);
      if (defaultUserKey != null) {
        allProperties.put(
            ConnectionOptions.USERNAME_PROPERTY_NAME, info.getProperty(defaultUserKey));
      }
    }
  }

  private static @Nullable String findStringKeyIgnoreCase(Properties info, String key) {
    for (String stringName : info.stringPropertyNames()) {
      if (stringName.equalsIgnoreCase(key)) {
        return stringName;
      }
    }
    return null;
  }

  private static void normalizeUserProperty(Map<String, Object> properties) {
    if (properties.containsKey(ConnectionOptions.USERNAME_PROPERTY_NAME)) {
      properties.remove(USER_PROPERTY_NAME);
    } else if (properties.containsKey(USER_PROPERTY_NAME)) {
      properties.put(
          ConnectionOptions.USERNAME_PROPERTY_NAME, properties.remove(USER_PROPERTY_NAME));
    }
  }

  private static boolean isLenient(String connectionUri, Map<String, Object> properties) {
    String uriLenient =
        ConnectionOptions.parseUriProperty(connectionUri, ConnectionOptions.LENIENT_PROPERTY_NAME);
    if (uriLenient != null) {
      return Boolean.parseBoolean(uriLenient);
    }
    Object lenientValue = properties.get(ConnectionOptions.LENIENT_PROPERTY_NAME);
    if (lenientValue != null) {
      return Boolean.parseBoolean(String.valueOf(lenientValue));
    }
    return false;
  }

  @Nullable
  @InternalApi
  public static String getPropertyFromProperties(
      @Nullable Map<String, Object> properties, ConnectionProperty<?> connectionProperty) {
    if (properties == null || properties.isEmpty()) {
      return null;
    }
    Object value = properties.get(connectionProperty.getKey());
    if (value == null
        && !connectionProperty.getKey().equalsIgnoreCase(connectionProperty.getName())) {
      value = properties.get(connectionProperty.getName());
    }
    return value == null ? null : String.valueOf(value);
  }

  @Nullable
  @InternalApi
  public static String getPropertyFromInfo(
      @Nullable Properties info, ConnectionProperty<?> connectionProperty) {
    if (info == null) {
      return null;
    }
    String key = findStringKeyIgnoreCase(info, connectionProperty.getKey());
    if (key == null
        && !connectionProperty.getKey().equalsIgnoreCase(connectionProperty.getName())) {
      key = findStringKeyIgnoreCase(info, connectionProperty.getName());
    }
    if (key == null
        && connectionProperty.getKey().equalsIgnoreCase(ConnectionOptions.USERNAME_PROPERTY_NAME)) {
      key = findStringKeyIgnoreCase(info, USER_PROPERTY_NAME);
    }
    return key == null ? null : info.getProperty(key);
  }

  @Nullable
  @InternalApi
  public static String parseUriProperty(String uri, String property) {
    String value = ConnectionOptions.parseUriProperty(uri, property);
    if (value == null && ConnectionOptions.USERNAME_PROPERTY_NAME.equalsIgnoreCase(property)) {
      return ConnectionOptions.parseUriProperty(uri, USER_PROPERTY_NAME);
    }
    return value;
  }

  private static <T> void setPropertyValue(
      ConnectionOptions.Builder builder, ConnectionProperty<T> property, String stringValue) {
    try {
      ConnectionPropertyValue<T> converted = property.convert(stringValue);
      if (converted != null) {
        builder.setConnectionPropertyValue(property, converted.getValue());
      }
    } catch (SpannerException e) {
      if (!stringValue.isEmpty()) {
        throw e;
      }
      // Silently skip empty string values that cannot be converted (e.g. autocommit="",
      // minSessions="") to ensure compatibility with connection pools.
    }
  }

  @InternalApi
  public static boolean usesDirectExecutor(ConnectionOptions options) {
    return options.getStatementExecutorType() == StatementExecutorType.DIRECT_EXECUTOR;
  }

  @InternalApi
  public static OpenTelemetry getOpenTelemetry(ConnectionOptions options) {
    return options.getOpenTelemetry();
  }

  @Nullable
  @InternalApi
  public static Object getInitialPropertyValue(ConnectionOptions options, String propertyName) {
    ConnectionPropertyValue<?> value =
        options.getInitialConnectionPropertyValues().get(propertyName.toLowerCase(Locale.ENGLISH));
    return value == null ? null : value.getValue();
  }

  private ConnectionOptionsHelper() {}
}
