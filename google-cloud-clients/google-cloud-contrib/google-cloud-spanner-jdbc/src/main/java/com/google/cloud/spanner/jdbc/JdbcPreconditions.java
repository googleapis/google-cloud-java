/*
 * Copyright 2019 Google LLC
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

import com.google.rpc.Code;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import javax.annotation.Nullable;

/**
 * Convenience class for throwing {@link SQLException}s when a certain condition has not been met.
 */
class JdbcPreconditions {

  /**
   * Ensures the truth of an expression involving a parameter to a method.
   *
   * @param expression the boolean expression that should be true.
   * @param value the parameter value that is being checked.
   * @throws JdbcSqlException with {@link Code#INVALID_ARGUMENT} if {@code expression} is false
   */
  static void checkArgument(boolean expression, Object value) throws SQLException {
    if (!expression) {
      throw JdbcSqlExceptionFactory.of("invalid argument: " + value, Code.INVALID_ARGUMENT);
    }
  }

  /**
   * Ensures the truth of an expression involving the state of the calling instance, but not
   * involving any parameters to the calling method.
   *
   * @param expression a boolean expression
   * @param errorMessage the exception message to use if the check fails; will be converted to a
   *     string using {@link String#valueOf(Object)}
   * @throws JdbcSqlException with {@link Code#FAILED_PRECONDITION} if {@code expression} is false
   */
  static void checkState(boolean expression, @Nullable Object errorMessage) throws SQLException {
    if (!expression) {
      throw JdbcSqlExceptionFactory.of(String.valueOf(errorMessage), Code.FAILED_PRECONDITION);
    }
  }

  /**
   * Ensures the support of a certain JDBC feature.
   *
   * @param expression the boolean expression that indicates whether the feature is supported.
   * @param message the exception message to use if the feature is not supported.
   * @throws SQLFeatureNotSupportedException if the feature is not supported.
   */
  static void checkSqlFeatureSupported(boolean expression, String message)
      throws SQLFeatureNotSupportedException {
    if (!expression) {
      throw JdbcSqlExceptionFactory.unsupported(message);
    }
  }
}
