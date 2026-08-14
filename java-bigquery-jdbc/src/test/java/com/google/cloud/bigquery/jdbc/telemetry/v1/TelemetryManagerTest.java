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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
