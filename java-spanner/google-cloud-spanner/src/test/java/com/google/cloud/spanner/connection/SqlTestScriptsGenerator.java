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

/**
 * Class that runs all generators of SQL test scripts for the Connection API.
 *
 * <p>Run this generator if new client side statements have been added, or if any existing client
 * side statements have been modified. The generator can be executed from the command line in the
 * google-cloud-spanner directory like this: <code>
 * mvn -Ddo_log_statements=true exec:java -Dexec.mainClass=com.google.cloud.spanner.connection.SqlTestScriptsGenerator -Dexec.classpathScope="test"
 * </code>
 */
public class SqlTestScriptsGenerator {

  /** Main method for generating the test script */
  public static void main(String[] args) throws Exception {
    for (Dialect dialect : Dialect.values()) {
      ClientSideStatementsTest.generateTestScript(dialect);
    }
    ConnectionImplGeneratedSqlScriptTest.generateTestScript();
  }
}
