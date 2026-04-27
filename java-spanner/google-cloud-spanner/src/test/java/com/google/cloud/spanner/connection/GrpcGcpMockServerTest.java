/*
 * Copyright 2026 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.StatementResult.ResultType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GrpcGcpMockServerTest extends AbstractMockServerTest {

  @Before
  public void setup() {
    SpannerPool.closeSpannerPool();
  }

  @After
  public void teardown() {
    SpannerPool.closeSpannerPool();
  }

  private void verifyConnectionWorks(Connection connection) {
    StatementResult result = connection.execute(Statement.of("SELECT 1"));
    assertEquals(ResultType.RESULT_SET, result.getResultType());
    try (ResultSet rs = result.getResultSet()) {
      assertTrue(rs.next());
      assertEquals(1L, rs.getLong(0));
      assertFalse(rs.next());
    }
  }

  @Test
  public void testDisableGrpcGcp() {
    try (Connection connection = createConnection(";enableGrpcGcp=false")) {
      Spanner spanner = ((ConnectionImpl) connection).getSpanner();
      assertFalse(spanner.getOptions().isGrpcGcpExtensionEnabled());
      verifyConnectionWorks(connection);
    }
  }

  @Test
  public void testEnableGrpcGcp() {
    try (Connection connection = createConnection(";enableGrpcGcp=true")) {
      Spanner spanner = ((ConnectionImpl) connection).getSpanner();
      assertTrue(spanner.getOptions().isGrpcGcpExtensionEnabled());
      verifyConnectionWorks(connection);
    }
  }

  @Test
  public void testDefaultGrpcGcp() {
    try (Connection connection = createConnection()) {
      Spanner spanner = ((ConnectionImpl) connection).getSpanner();
      // Default should be true in SpannerOptions
      assertTrue(spanner.getOptions().isGrpcGcpExtensionEnabled());
      verifyConnectionWorks(connection);
    }
  }
}
