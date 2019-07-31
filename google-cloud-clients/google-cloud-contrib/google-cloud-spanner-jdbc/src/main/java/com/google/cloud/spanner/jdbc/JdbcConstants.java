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

import com.google.cloud.spanner.jdbc.StatementResult.ResultType;
import java.sql.ResultSet;
import java.sql.Statement;

/** Constants for special values used by the Cloud Spanner JDBC driver. */
public final class JdbcConstants {
  /**
   * Special value that is used to indicate that a statement returned a {@link ResultSet}. The
   * method {@link Statement#getUpdateCount()} will return this value if the previous statement that
   * was executed with {@link Statement#execute(String)} returned a {@link ResultSet}.
   */
  public static final int STATEMENT_RESULT_SET = -1;
  /**
   * Special value that is used to indicate that a statement had no result. The method {@link
   * Statement#getUpdateCount()} will return this value if the previous statement that was executed
   * with {@link Statement#execute(String)} returned {@link ResultType#NO_RESULT}, such as DDL
   * statements {@link ResultType}.
   */
  public static final int STATEMENT_NO_RESULT = -2;

  /** No instantiation */
  private JdbcConstants() {}
}
