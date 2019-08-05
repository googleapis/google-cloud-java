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

/**
 * Base interface for all Cloud Spanner {@link SQLException}s. All {@link SQLException}s that are
 * thrown by the Cloud Spanner JDBC driver implement this interface.
 */
public interface JdbcSqlException {

  /** @see Throwable#getMessage() */
  String getMessage();

  /** @see Throwable#getCause() */
  Throwable getCause();

  /** @see SQLException#getSQLState() */
  String getSQLState();

  /** Returns the gRPC error code as an int */
  int getErrorCode();

  /** Returns the corresponding gRPC code for this exception */
  Code getCode();
}
