/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.trace.v2;

import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.devtools.cloudtrace.v2.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by Google")
public class VPCServiceControlTest {
  private abstract class Delay {
    public abstract void eval();
  }

  private static boolean isRejected(Delay delayed) {
    try {
      delayed.eval();
    } catch (PermissionDeniedException e) {
      return e.getMessage().contains("Request is prohibited by organization's policy");
    } catch (Exception e) {
    }
    return false;
  }

  static final String PROJECT_OUTSIDE =
      System.getenv("GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT");
  static final String PROJECT_INSIDE = System.getenv("PROJECT_ID");
  static final String IS_INSIDE_VPCSC = System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC");

  @BeforeClass
  public static void setUpClass() {
    Assume.assumeTrue(
        "GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT environment variable needs to be set to a GCP project that is outside the VPC perimeter",
        PROJECT_OUTSIDE != null && !PROJECT_OUTSIDE.isEmpty());
    Assume.assumeTrue(
        "PROJECT_ID environment variable needs to be set to a GCP project that is inside the VPC perimeter",
        PROJECT_INSIDE != null && !PROJECT_INSIDE.isEmpty());
  }

  @Test
  @SuppressWarnings("all")
  public void patchTracesTest() throws Exception {
    final TraceServiceClient client = TraceServiceClient.create();
    final List<Span> spans = new ArrayList<>();
    spans.add(Span.newBuilder().build());

    Delay delayedInside =
        new Delay() {
          @Override
          public void eval() {
            client.batchWriteSpans(PROJECT_INSIDE, spans);
          }
        };

    Delay delayedOutside =
        new Delay() {
          @Override
          public void eval() {
            client.batchWriteSpans(PROJECT_OUTSIDE, spans);
          }
        };

    Assert.assertTrue(!isRejected(delayedInside));
    Assert.assertTrue(isRejected(delayedOutside));

    client.close();
  }
}
