/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.telemetry.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TelemetryManagerTest {

  @BeforeEach
  @AfterEach
  public void cleanUp() {
    TelemetryManager.closeInstance();
  }

  @Test
  public void testGetInstance_returnsSameSingletonInstance() {
    TelemetryManager manager1 = TelemetryManager.getInstance();
    TelemetryManager manager2 = TelemetryManager.getInstance();

    assertNotNull(manager1);
    assertSame(manager1, manager2);
    assertTrue(TelemetryManager.isInitialized());
    assertNotNull(manager1.getBatcher());
  }

  @Test
  public void testInit_withDisabledConfig_doesNotInitializeInstance() {
    TelemetryConfiguration config = TelemetryConfiguration.builder().setEnabled(false).build();
    ClearcutTransport transport = new ClearcutTransport(config);

    TelemetryManager.init(config, transport);

    assertFalse(TelemetryManager.isInitialized());
  }

  @Test
  public void testInit_withEnabledConfig_initializesCustomInstance() {
    TelemetryConfiguration config = TelemetryConfiguration.builder().setEnabled(true).build();
    ClearcutTransport transport = new ClearcutTransport(config);

    TelemetryManager.init(config, transport);

    assertTrue(TelemetryManager.isInitialized());
    assertNotNull(TelemetryManager.getInstance().getBatcher());
  }

  @Test
  public void testCloseInstance_resetsSingletonState() {
    TelemetryManager.getInstance();
    assertTrue(TelemetryManager.isInitialized());

    TelemetryManager.closeInstance();
    assertFalse(TelemetryManager.isInitialized());
  }

  @Test
  public void testRunSafely_executesRunnableSuccessfully() {
    AtomicBoolean executed = new AtomicBoolean(false);

    TelemetryManager.runSafely(() -> executed.set(true));

    assertTrue(executed.get());
  }

  @Test
  public void testRunSafely_swallowsExceptionsWithoutThrowing() {
    AtomicBoolean lineAfterException = new AtomicBoolean(false);

    TelemetryManager.runSafely(
        () -> {
          throw new RuntimeException("Simulated telemetry exception");
        });
    lineAfterException.set(true);

    assertTrue(lineAfterException.get());
  }

  @Test
  public void testRunSafely_handlesNullActionGracefully() {
    TelemetryManager.runSafely(null);
    // Verifies no NullPointerException is thrown
  }

  @Test
  public void testToStatementType() {
    assertEquals(
        StatementType.STATEMENT_TYPE_SELECT,
        TelemetryManager.toStatementType(QueryStatistics.StatementType.SELECT));
    assertEquals(
        StatementType.STATEMENT_TYPE_INSERT,
        TelemetryManager.toStatementType(QueryStatistics.StatementType.INSERT));
    assertEquals(
        StatementType.STATEMENT_TYPE_UPDATE,
        TelemetryManager.toStatementType(QueryStatistics.StatementType.UPDATE));
    assertEquals(
        StatementType.STATEMENT_TYPE_DELETE,
        TelemetryManager.toStatementType(QueryStatistics.StatementType.DELETE));
    assertEquals(
        StatementType.STATEMENT_TYPE_MERGE,
        TelemetryManager.toStatementType(QueryStatistics.StatementType.MERGE));
    assertEquals(
        StatementType.STATEMENT_TYPE_CREATE_TABLE,
        TelemetryManager.toStatementType(QueryStatistics.StatementType.CREATE_TABLE));
    assertEquals(
        StatementType.STATEMENT_TYPE_CREATE_MODEL,
        TelemetryManager.toStatementType(QueryStatistics.StatementType.CREATE_MODEL));
    assertEquals(
        StatementType.STATEMENT_TYPE_CREATE_VIEW,
        TelemetryManager.toStatementType(QueryStatistics.StatementType.CREATE_VIEW));
    assertEquals(
        StatementType.STATEMENT_TYPE_DROP_TABLE,
        TelemetryManager.toStatementType(QueryStatistics.StatementType.DROP_TABLE));
    assertEquals(
        StatementType.STATEMENT_TYPE_DROP_VIEW,
        TelemetryManager.toStatementType(QueryStatistics.StatementType.DROP_VIEW));
    assertEquals(
        StatementType.STATEMENT_TYPE_ALTER_TABLE,
        TelemetryManager.toStatementType(QueryStatistics.StatementType.ALTER_TABLE));
    assertEquals(
        StatementType.STATEMENT_TYPE_ALTER_VIEW,
        TelemetryManager.toStatementType(QueryStatistics.StatementType.ALTER_VIEW));
    assertEquals(
        StatementType.STATEMENT_TYPE_SCRIPT,
        TelemetryManager.toStatementType(QueryStatistics.StatementType.SCRIPT));

    assertEquals(StatementType.STATEMENT_TYPE_UNSPECIFIED, TelemetryManager.toStatementType(null));
  }

  @Test
  public void testToAuthenticationType() {
    assertEquals(
        AuthenticationType.AUTHENTICATION_TYPE_SERVICE_ACCOUNT,
        TelemetryManager.toAuthenticationType(0));
    assertEquals(
        AuthenticationType.AUTHENTICATION_TYPE_USER_AUTHENTICATION,
        TelemetryManager.toAuthenticationType(1));
    assertEquals(
        AuthenticationType.AUTHENTICATION_TYPE_APPLICATION_DEFAULT_CREDENTIALS,
        TelemetryManager.toAuthenticationType(2));
    assertEquals(
        AuthenticationType.AUTHENTICATION_TYPE_EXTERNAL, TelemetryManager.toAuthenticationType(3));
    assertEquals(
        AuthenticationType.AUTHENTICATION_TYPE_TOKEN, TelemetryManager.toAuthenticationType(4));

    assertEquals(
        AuthenticationType.AUTHENTICATION_TYPE_CUSTOM, TelemetryManager.toAuthenticationType(5));
    assertEquals(
        AuthenticationType.AUTHENTICATION_TYPE_CUSTOM, TelemetryManager.toAuthenticationType(100));
  }

  @Test
  public void testCalculateBucketIndex() {
    int index1 = TelemetryManager.calculateBucketIndex(5); // < 10, index 0
    assertEquals(0, index1);

    int index2 = TelemetryManager.calculateBucketIndex(150); // < 250, index 3
    assertEquals(3, index2);

    int index3 = TelemetryManager.calculateBucketIndex(20000); // Overflow > 10000, index 8
    assertEquals(8, index3);
  }

  @Test
  public void testOptOutConfiguration() {
    Properties props = new Properties();

    // Default is true
    assertTrue(TelemetryConfiguration.builder().resolveEnabledFlag(props).build().isEnabled());

    // Disabled via lowercase
    props.setProperty("enableDiagnosticTelemetry", "false");
    assertFalse(TelemetryConfiguration.builder().resolveEnabledFlag(props).build().isEnabled());

    // Disabled via uppercase and "0"
    props.clear();
    props.setProperty("EnableDiagnosticTelemetry", "0");
    assertFalse(TelemetryConfiguration.builder().resolveEnabledFlag(props).build().isEnabled());

    // Enabled via "1"
    props.clear();
    props.setProperty("EnableDiagnosticTelemetry", "1");
    assertTrue(TelemetryConfiguration.builder().resolveEnabledFlag(props).build().isEnabled());
  }
}
