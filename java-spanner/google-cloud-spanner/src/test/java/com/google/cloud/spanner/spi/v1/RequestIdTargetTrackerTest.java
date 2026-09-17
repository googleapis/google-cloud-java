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

package com.google.cloud.spanner.spi.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.XGoogSpannerRequestId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RequestIdTargetTrackerTest {

  private static final String ENDPOINT = "endpoint-1.example.com:443";
  private static final String DATABASE_SCOPE = "projects/p/instances/i/databases/d";

  @Before
  public void setUp() {
    RequestIdTargetTracker.clear();
  }

  @After
  public void tearDown() {
    RequestIdTargetTracker.clear();
  }

  @Test
  public void trackingIsDisabledUntilSomethingIsRecorded() {
    assertFalse(RequestIdTargetTracker.isTracking());

    assertNull(RequestIdTargetTracker.get(requestId(1, 1, 100, 1)));
    RequestIdTargetTracker.remove(requestId(1, 1, 100, 1));
    RequestIdTargetTracker.removeLogicalKey("1.100");

    assertFalse(RequestIdTargetTracker.isTracking());
  }

  @Test
  public void recordEnablesTrackingAndStoresTheTarget() {
    XGoogSpannerRequestId requestId = requestId(1, 1, 100, 1);
    RequestIdTargetTracker.record(
        requestId.getLogicalRequestKey(), DATABASE_SCOPE, ENDPOINT, 42L, true);

    assertTrue(RequestIdTargetTracker.isTracking());

    RequestIdTargetTracker.RoutingTarget routingTarget = RequestIdTargetTracker.get(requestId);
    assertNotNull(routingTarget);
    assertEquals(DATABASE_SCOPE, routingTarget.databaseScope);
    assertEquals(ENDPOINT, routingTarget.targetEndpoint);
    assertEquals(42L, routingTarget.operationUid);
    assertTrue(routingTarget.preferLeader);
  }

  /**
   * The tracking key must be stable across attempts of the same logical RPC, because the endpoint
   * is recorded when the call starts but the latency is attributed after the channel id and attempt
   * number have already been mutated by {@code RequestIdInterceptor}.
   */
  @Test
  public void targetIsFoundAcrossAttemptsOfTheSameRequest() {
    RequestIdTargetTracker.record(
        requestId(7, 1, 100, 1).getLogicalRequestKey(), DATABASE_SCOPE, ENDPOINT, 42L, false);

    XGoogSpannerRequestId laterAttempt = requestId(7, 4, 100, 3);
    RequestIdTargetTracker.RoutingTarget routingTarget = RequestIdTargetTracker.get(laterAttempt);

    assertNotNull(routingTarget);
    assertEquals(ENDPOINT, routingTarget.targetEndpoint);
  }

  @Test
  public void targetsOfDifferentRequestsAreIndependent() {
    RequestIdTargetTracker.record(
        requestId(1, 1, 100, 1).getLogicalRequestKey(), DATABASE_SCOPE, ENDPOINT, 1L, false);

    assertNotNull(RequestIdTargetTracker.get(requestId(1, 1, 100, 1)));
    assertNull(RequestIdTargetTracker.get(requestId(1, 1, 101, 1)));
    assertNull(RequestIdTargetTracker.get(requestId(2, 1, 100, 1)));
  }

  @Test
  public void recordIsIgnoredForIncompleteInput() {
    RequestIdTargetTracker.record(null, DATABASE_SCOPE, ENDPOINT, 1L, false);
    RequestIdTargetTracker.record("", DATABASE_SCOPE, ENDPOINT, 1L, false);
    RequestIdTargetTracker.record("1.100", DATABASE_SCOPE, null, 1L, false);
    RequestIdTargetTracker.record("1.100", DATABASE_SCOPE, "", 1L, false);

    assertFalse(RequestIdTargetTracker.isTracking());
    assertNull(RequestIdTargetTracker.get(requestId(1, 1, 100, 1)));
  }

  @Test
  public void removeInvalidatesTheTarget() {
    XGoogSpannerRequestId requestId = requestId(1, 1, 100, 1);
    RequestIdTargetTracker.record(
        requestId.getLogicalRequestKey(), DATABASE_SCOPE, ENDPOINT, 1L, false);
    assertNotNull(RequestIdTargetTracker.get(requestId));

    RequestIdTargetTracker.remove(requestId);

    assertNull(RequestIdTargetTracker.get(requestId));
  }

  @Test
  public void removeLogicalKeyInvalidatesTheTarget() {
    XGoogSpannerRequestId requestId = requestId(1, 1, 100, 1);
    RequestIdTargetTracker.record(
        requestId.getLogicalRequestKey(), DATABASE_SCOPE, ENDPOINT, 1L, false);
    assertNotNull(RequestIdTargetTracker.get(requestId));

    RequestIdTargetTracker.removeLogicalKey(requestId.getLogicalRequestKey());

    assertNull(RequestIdTargetTracker.get(requestId));
  }

  @Test
  public void nullRequestIdIsHandled() {
    RequestIdTargetTracker.record("1.100", DATABASE_SCOPE, ENDPOINT, 1L, false);

    assertNull(RequestIdTargetTracker.get(null));
    RequestIdTargetTracker.remove(null);
    RequestIdTargetTracker.removeLogicalKey(null);
    RequestIdTargetTracker.removeLogicalKey("");

    assertNotNull(RequestIdTargetTracker.get(requestId(1, 1, 100, 1)));
  }

  private static XGoogSpannerRequestId requestId(
      long clientId, long channelId, long requestNumber, long attempt) {
    return XGoogSpannerRequestId.of(clientId, channelId, requestNumber, attempt);
  }
}
