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

package com.google.cloud.spanner.connection;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.connection.ClientSideStatementImpl.CompileException;
import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.util.Set;

/** This class reads and parses the {@link ClientSideStatement}s from the json file. */
class ClientSideStatements {
  private static final String GSQL_STATEMENTS_DEFINITION_FILE = "ClientSideStatements.json";
  private static final String PG_STATEMENTS_DEFINITION_FILE = "PG_ClientSideStatements.json";
  private static final ClientSideStatements GSQL_STATEMENTS = importGsqlStatements();
  private static final ClientSideStatements PG_STATEMENTS = importPgStatements();

  static ClientSideStatements getInstance(Dialect dialect) {
    switch (dialect) {
      case GOOGLE_STANDARD_SQL:
        return GSQL_STATEMENTS;
      case POSTGRESQL:
        return PG_STATEMENTS;
      default:
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT, "Unknown or unsupported dialect: " + dialect);
    }
  }

  /**
   * Reads statement definitions from ClientSideStatements.json and parses these as Java objects.
   */
  private static ClientSideStatements importGsqlStatements() {
    Gson gson = new Gson();
    return gson.fromJson(
        new InputStreamReader(
            ClientSideStatements.class.getResourceAsStream(GSQL_STATEMENTS_DEFINITION_FILE)),
        ClientSideStatements.class);
  }

  /**
   * Reads statement definitions from PG_ClientSideStatements.json and parses these as Java objects.
   */
  private static ClientSideStatements importPgStatements() {
    Gson gson = new Gson();
    return gson.fromJson(
        new InputStreamReader(
            ClientSideStatements.class.getResourceAsStream(PG_STATEMENTS_DEFINITION_FILE)),
        ClientSideStatements.class);
  }

  // This field is set automatically by the importStatements / pgImportStatements methods.
  private Set<ClientSideStatementImpl> statements;

  private ClientSideStatements() {}

  /** Compiles and returns all statements from the resource file. */
  Set<ClientSideStatementImpl> getCompiledStatements() throws CompileException {
    for (ClientSideStatementImpl statement : statements) {
      statement.compile();
    }
    return statements;
  }
}
