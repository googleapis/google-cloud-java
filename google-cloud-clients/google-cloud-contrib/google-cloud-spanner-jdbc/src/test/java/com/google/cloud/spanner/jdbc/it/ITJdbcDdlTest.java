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

package com.google.cloud.spanner.jdbc.it;

import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.jdbc.ITAbstractJdbcTest;
import com.google.cloud.spanner.jdbc.JdbcSqlScriptVerifier;
import com.google.cloud.spanner.jdbc.SqlScriptVerifier;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Execute DDL statements using JDBC. */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITJdbcDdlTest extends ITAbstractJdbcTest {

  @Test
  public void testSqlScript() throws Exception {
    JdbcSqlScriptVerifier verifier = new JdbcSqlScriptVerifier(new ITJdbcConnectionProvider());
    verifier.verifyStatementsInFile("ITDdlTest.sql", SqlScriptVerifier.class);
  }
}
