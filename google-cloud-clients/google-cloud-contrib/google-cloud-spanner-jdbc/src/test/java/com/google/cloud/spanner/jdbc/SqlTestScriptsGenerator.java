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

/** Class that runs all generators of SQL test scripts for the Connection API */
public class SqlTestScriptsGenerator {

  /** Main method for generating the test script */
  public static void main(String[] args) throws Exception {
    ClientSideStatementsTest.generateTestScript();
    ConnectionImplGeneratedSqlScriptTest.generateTestScript();
  }
}
