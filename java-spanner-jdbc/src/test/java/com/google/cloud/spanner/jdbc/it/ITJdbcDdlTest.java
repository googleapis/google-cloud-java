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

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.jdbc.JdbcSqlScriptVerifier;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/** Execute DDL statements using JDBC. */
@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
public class ITJdbcDdlTest extends ITAbstractJdbcTest {
  @ClassRule public static JdbcIntegrationTestEnv env = new JdbcIntegrationTestEnv();

  @Parameters(name = "Dialect = {0}")
  public static List<DialectTestParameter> data() {
    List<DialectTestParameter> params = new ArrayList<>();
    final Map<String, String> googleStandardSqlScripts =
        ImmutableMap.of("TEST_DDL", "ITDdlTest.sql");
    final Map<String, String> postgresScripts =
        ImmutableMap.of("TEST_DDL", "PostgreSQL/ITDdlTest.sql");
    params.add(
        new DialectTestParameter(
            Dialect.GOOGLE_STANDARD_SQL, null, googleStandardSqlScripts, null));

    params.add(new DialectTestParameter(Dialect.POSTGRESQL, null, postgresScripts, null));
    return params;
  }

  @Parameter public DialectTestParameter dialect;

  private Database database;

  @Before
  public void setup() {
    database = env.getOrCreateDatabase(getDialect(), Collections.emptyList());
  }

  @Override
  public Dialect getDialect() {
    return dialect.dialect;
  }

  @Test
  public void testSqlScript() throws Exception {
    JdbcSqlScriptVerifier verifier =
        new JdbcSqlScriptVerifier(new ITJdbcConnectionProvider(env, database));
    verifier.verifyStatementsInFile(
        dialect.executeQueriesFiles.get("TEST_DDL"), JdbcSqlScriptVerifier.class, false);
  }
}
