/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.internal.dp;

import com.google.api.core.InternalApi;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DirectPathCompatibleTracer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@InternalApi
public class DirectAccessInvestigator {
  private static final Logger LOG = Logger.getLogger(DirectAccessInvestigator.class.getName());

  /** Metric reason codes for Direct Access failures. */
  public enum FailureReason {
    NOT_IN_GCP("not_in_gcp"),
    METADATA_UNREACHABLE("metadata_unreachable"),
    NO_IP_ASSIGNED("no_ip_assigned"),
    LOOPBACK_DOWN("loopback_misconfigured"),
    LOOPBACK_V4_MISSING("loopback_misconfigured_ipv4"),
    LOOPBACK_V6_MISSING("loopback_misconfigured_ipv6"),
    USER_DISABLED("user_disabled"),
    UNKNOWN("unknown");

    private final String value;

    FailureReason(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  // This is only called when direct access check fails.
  public static void investigateAndReport(
      DirectPathCompatibleTracer tracer, @Nullable Throwable originalError) {
    try {
      // TODO: Implement checks in a future PR.
      // For now, default to returning "unknown".
      recordAndLog(
          tracer,
          FailureReason.UNKNOWN,
          "Direct Access investigation: Defaulting to unknown failure reason for now.",
          originalError);
    } catch (Exception e) {
      LOG.log(Level.WARNING, "Failed to record results of the Direct Access investigation", e);
    }
  }

  /** Helper method to consistently log the failure reason and record it to the tracer. */
  private static void recordAndLog(
      DirectPathCompatibleTracer tracer,
      FailureReason reason,
      String logMessage,
      @Nullable Throwable error) {
    if (error != null) {
      LOG.log(Level.FINE, logMessage, error);
    } else {
      LOG.log(Level.FINE, logMessage);
    }
    tracer.recordFailure(reason);
  }
}
