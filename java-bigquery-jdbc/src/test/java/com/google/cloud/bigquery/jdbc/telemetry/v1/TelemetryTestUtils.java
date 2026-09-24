package com.google.cloud.bigquery.jdbc.telemetry.v1;

/** Test-only access to {@link TelemetryManager}'s package-private lifecycle state. */
public final class TelemetryTestUtils {
  private TelemetryTestUtils() {}

  /** Closes the shared instance and clears the global opt-out kill switch. */
  public static void reset() {
    TelemetryManager.closeInstance();
    TelemetryManager.resetGlobalDisableForTest();
  }
}
