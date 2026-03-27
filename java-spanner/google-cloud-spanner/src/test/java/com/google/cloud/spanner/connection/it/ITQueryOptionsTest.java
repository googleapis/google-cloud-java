/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner.connection.it;

import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest;
import com.google.cloud.spanner.connection.SqlScriptVerifier;
import com.google.cloud.spanner.connection.SqlScriptVerifier.SpannerGenericConnection;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITQueryOptionsTest extends ITAbstractSpannerTest {

  private static final String TEST_QUERY_OPTIONS = "ITSqlScriptTest_TestQueryOptions.sql";

  private SqlScriptVerifier verifier;

  @Before
  public void setUp() {
    verifier = new SqlScriptVerifier();
  }

  @Test
  public void verifiesQueryOptions() throws Exception {
    try (ITConnection connection = createConnection()) {
      verifier.verifyStatementsInFile(
          SpannerGenericConnection.of(connection), TEST_QUERY_OPTIONS, SqlScriptVerifier.class);
    }
  }
}
