/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.spanner.jdbc.it;

import com.google.cloud.spanner.Dialect;
import java.util.Map;

public class DialectTestParameter {

  final Dialect dialect;
  final String createTableFile;
  final Map<String, String> executeQueriesFiles;
  final String[] queries;

  DialectTestParameter(
      Dialect dialect,
      String createTableFile,
      Map<String, String> executeQueriesFiles,
      String[] queries) {
    this.dialect = dialect;
    this.createTableFile = createTableFile;
    this.executeQueriesFiles = executeQueriesFiles;
    this.queries = queries;
  }

  DialectTestParameter(Dialect dialect) {
    this.dialect = dialect;
    this.createTableFile = "";
    this.executeQueriesFiles = null;
    this.queries = null;
  }

  public String toString() {
    return this.dialect.name();
  }
}
