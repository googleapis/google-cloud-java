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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

/** Test-only access to {@link TelemetryManager}'s package-private lifecycle state. */
public final class TelemetryTestUtils {
  private TelemetryTestUtils() {}

  /** Initializes {@link TelemetryManager} with a mock transport that appends payloads. */
  public static void initCapturingPayloads(List<TelemetryPayload> captured) {
    TelemetryConfiguration config = TelemetryConfiguration.builder().setEnabled(true).build();
    ClearcutTransport transport = mock(ClearcutTransport.class);
    when(transport.send(any()))
        .thenAnswer(
            invocation -> {
              captured.add(invocation.getArgument(0));
              return new TransportResult(true, -1);
            });
    TelemetryManager.init(config, transport);
  }

  /** Flushes and closes the shared instance so captured payloads are delivered. */
  public static void flush() {
    TelemetryManager.closeInstance();
  }

  /** Closes the shared instance and clears the global opt-out kill switch. */
  public static void reset() {
    TelemetryManager.closeInstance();
    TelemetryManager.resetGlobalDisableForTest();
  }
}
