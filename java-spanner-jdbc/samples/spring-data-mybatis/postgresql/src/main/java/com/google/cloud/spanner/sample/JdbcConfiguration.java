/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.spanner.sample;

import com.google.cloud.spanner.jdbc.CloudSpannerJdbcConnection;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcOperations;

@Configuration
public class JdbcConfiguration {

  /** Returns true if the current database is a Cloud Spanner PostgreSQL database. */
  public static boolean isCloudSpannerPG(JdbcOperations operations) {
    return Boolean.TRUE.equals(
        operations.execute(
            (ConnectionCallback<Boolean>)
                connection ->
                    connection.isWrapperFor(CloudSpannerJdbcConnection.class)
                        && com.google.cloud.spanner.Dialect.POSTGRESQL.equals(
                            connection.unwrap(CloudSpannerJdbcConnection.class).getDialect())));
  }
}
