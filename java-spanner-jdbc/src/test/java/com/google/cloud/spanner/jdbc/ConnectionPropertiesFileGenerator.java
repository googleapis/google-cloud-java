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

import com.google.cloud.spanner.connection.ConnectionProperty;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/** Generator for the documentation/connection_properties.md file. */
public class ConnectionPropertiesFileGenerator {

  public static void main(String[] args) throws IOException {
    StringBuilder builder =
        new StringBuilder("# Supported Connection Properties\n\n")
            .append(
                "This file contains all supported connection properties for the Spanner JDBC driver. "
                    + "These properties can be specified both in the connection URL and in the Properties map "
                    + "that is used to create a connection.\n\n"
                    + "The 'Context' value indicates whether the property can only be set when a connection is "
                    + "created (STARTUP), or whether the value can also be changed after a connection has been "
                    + "created.\n\n");
    builder.append("| Name | Description | Default | Enum values | Context |\n");
    builder.append("|------|-------------|---------|-------------|---------|\n");
    for (ConnectionProperty<?> connectionProperty :
        ConnectionPropertiesHelper.VALID_CONNECTION_PROPERTIES) {
      builder
          .append("| ")
          .append(connectionProperty.getName())
          .append(" | ")
          .append(connectionProperty.getDescription().replace("\n", " "))
          .append(" | ")
          .append(
              connectionProperty.getDefaultValue() == null
                  ? ""
                  : connectionProperty.getDefaultValue().toString())
          .append(" | ")
          .append(getValidValues(connectionProperty))
          .append(" | ")
          .append(connectionProperty.getContext())
          .append(" |\n");
    }
    try (BufferedWriter writer =
        new BufferedWriter(new FileWriter("documentation/connection_properties.md"))) {
      writer.write(builder.toString());
    }
  }

  static <T> String getValidValues(ConnectionProperty<T> connectionProperty) {
    return connectionProperty.getValidValues() == null
        ? ""
        : Arrays.stream(connectionProperty.getValidValues())
            .map(Objects::toString)
            .collect(Collectors.joining(", "));
  }
}
