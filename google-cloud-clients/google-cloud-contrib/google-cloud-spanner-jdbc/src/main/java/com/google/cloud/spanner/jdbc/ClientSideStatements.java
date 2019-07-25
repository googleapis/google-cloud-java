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

import com.google.cloud.spanner.jdbc.ClientSideStatementImpl.CompileException;
import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.util.Set;

/** This class reads and parses the {@link ClientSideStatement}s from the json file. */
class ClientSideStatements {
  private static final String STATEMENTS_DEFINITION_FILE = "ClientSideStatements.json";
  static final ClientSideStatements INSTANCE = importStatements();

  /**
   * Reads statement definitions from ClientSideStatements.json and parses these as Java objects.
   */
  private static ClientSideStatements importStatements() {
    Gson gson = new Gson();
    return gson.fromJson(
        new InputStreamReader(
            ClientSideStatements.class.getResourceAsStream(STATEMENTS_DEFINITION_FILE)),
        ClientSideStatements.class);
  }

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
