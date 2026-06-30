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

/**
 * A JDBC driver for Cloud Spanner - A no-compromise relational database service.
 *
 * <p>Example for creating a JDBC connection to Cloud Spanner.
 *
 * <pre>{@code
 * String projectId = "my-project";
 * String instanceId = "my-instance";
 * String databaseId = "my-database";
 *
 * try (Connection connection =
 *     DriverManager.getConnection(
 *         String.format(
 *             "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
 *             projectId, instanceId, databaseId))) {
 *   try (Statement statement = connection.createStatement()) {
 *     try (ResultSet rs = statement.executeQuery("SELECT CURRENT_TIMESTAMP()")) {
 *       while (rs.next()) {
 *         System.out.printf(
 *             "Connected to Cloud Spanner at [%s]%n", rs.getTimestamp(1).toString());
 *       }
 *     }
 *   }
 * }
 * }</pre>
 *
 * @see <a
 *     href="https://googleapis.dev/java/google-cloud-spanner-jdbc/latest/com/google/cloud/spanner/jdbc/JdbcDriver.html">JdbcDriver
 *     java doc</a> for all supported connection URL properties.
 * @see <a href="https://cloud.google.com/spanner/docs/use-oss-jdbc">Cloud Spanner JDBC Driver</a>
 */
package com.google.cloud.spanner.jdbc;
