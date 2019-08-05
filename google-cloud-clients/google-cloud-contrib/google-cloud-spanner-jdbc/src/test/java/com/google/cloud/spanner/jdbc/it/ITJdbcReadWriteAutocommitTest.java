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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.jdbc.CloudSpannerJdbcConnection;
import com.google.cloud.spanner.jdbc.ITAbstractJdbcTest;
import com.google.cloud.spanner.jdbc.JdbcSqlScriptVerifier;
import com.google.cloud.spanner.jdbc.SqlScriptVerifier;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ITJdbcReadWriteAutocommitTest extends ITAbstractJdbcTest {

  @Rule public ExpectedException exception = ExpectedException.none();

  @Override
  protected void appendConnectionUri(StringBuilder uri) {
    uri.append(";autocommit=true");
  }

  @Override
  public boolean doCreateDefaultTestTable() {
    return true;
  }

  @Test
  public void test01_SqlScript() throws Exception {
    JdbcSqlScriptVerifier verifier = new JdbcSqlScriptVerifier(new ITJdbcConnectionProvider());
    verifier.verifyStatementsInFile(
        "ITReadWriteAutocommitSpannerTest.sql", SqlScriptVerifier.class, true);
  }

  @Test
  public void test02_WriteMutation() throws Exception {
    try (CloudSpannerJdbcConnection connection = createConnection()) {
      connection.write(
          Mutation.newInsertBuilder("TEST").set("ID").to(9999L).set("NAME").to("FOO").build());
      java.sql.Statement statement = connection.createStatement();
      statement.execute("SHOW VARIABLE COMMIT_TIMESTAMP");
      try (java.sql.ResultSet rs = statement.getResultSet()) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getTimestamp(1), is(notNullValue()));
      }
    }
  }
}
