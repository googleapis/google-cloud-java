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

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.jdbc.JdbcConnectionGeneratedSqlScriptTest.TestConnectionProvider;
import java.sql.Connection;
import java.sql.Statement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * As JDBC connections store the statement timeout on {@link Statement} objects instead of on the
 * {@link Connection}, the JDBC driver needs to set and reset the connection timeout on the
 * underlying connection after each statement execution. JDBC also uses seconds as the time unit for
 * timeouts, while the underlying {@link com.google.cloud.spanner.connection.Connection}s use
 * milliseconds. This test script tests a number of special cases regarding this.
 */
@RunWith(Parameterized.class)
public class JdbcTimeoutSqlTest {

  @Parameter public Dialect dialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Test
  public void testTimeoutScript() throws Exception {
    JdbcSqlScriptVerifier verifier = new JdbcSqlScriptVerifier(new TestConnectionProvider(dialect));
    String prefix = dialect == Dialect.POSTGRESQL ? "PostgreSQL/" : "";
    verifier.verifyStatementsInFile(prefix + "TimeoutSqlScriptTest.sql", getClass(), false);
  }
}
