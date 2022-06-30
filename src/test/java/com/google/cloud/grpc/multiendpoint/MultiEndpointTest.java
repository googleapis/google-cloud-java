/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.grpc.multiendpoint;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.client.util.Sleeper;
import com.google.common.collect.ImmutableList;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit tests for MultiEndpoint.
 */
@RunWith(JUnit4.class)
public final class MultiEndpointTest {
  private final List<String> threeEndpoints =
      new ArrayList<>(ImmutableList.of("first", "second", "third"));

  private final List<String> fourEndpoints =
      new ArrayList<>(ImmutableList.of("four", "first", "third", "second"));

  private static final long RECOVERY_MS = 1000;

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  private MultiEndpoint initPlain(List<String> endpoints) {
    return new MultiEndpoint.Builder(endpoints).build();
  }

  private MultiEndpoint initWithRecovery(List<String> endpoints, long recoveryTimeOut) {
    return new MultiEndpoint.Builder(endpoints)
        .withRecoveryTimeout(Duration.ofMillis(recoveryTimeOut))
        .build();
  }

  @Test
  public void initPlain_raisesErrorWhenEmptyEndpoints() {
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("Endpoints list must not be empty.");
    initPlain(ImmutableList.of());
  }

  @Test
  public void initWithRecovery_raisesErrorWhenEmptyEndpoints() {
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("Endpoints list must not be empty.");
    initWithRecovery(ImmutableList.of(), RECOVERY_MS);
  }

  @Test
  public void getCurrent_returnsTopPriorityAvailableEndpointWithoutRecovery() {
    MultiEndpoint multiEndpoint = initPlain(threeEndpoints);

    // Returns first after creation.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // Second becomes available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), true);

    // Second is the current as the only available.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // Third becomes available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(2), true);

    // Second is still the current because it has higher priority.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // First becomes available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(0), true);

    // First becomes the current because it has higher priority.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // Second becomes unavailable.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), false);

    // Second becoming unavailable should not affect the current first.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // First becomes unavailable.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(0), false);

    // Third becomes the current as the only remaining available.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(2));

    // Third becomes unavailable.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(2), false);

    // After all endpoints became unavailable the multiEndpoint sticks to the last used endpoint.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(2));
  }

  @Test
  public void getCurrent_returnsTopPriorityAvailableEndpointWithRecovery()
      throws InterruptedException {
    MultiEndpoint multiEndpoint = initWithRecovery(threeEndpoints, RECOVERY_MS);

    // Returns first after creation.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // Second becomes available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), true);

    // First is still the current to allow it to become available within recovery timeout.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // After recovery timeout has passed.
    Sleeper.DEFAULT.sleep(RECOVERY_MS + 100);

    // Second becomes current as an available endpoint with top priority.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // Third becomes available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(2), true);

    // Second is still the current because it has higher priority.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // Second becomes unavailable.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), false);

    // Second is still current, allowing upto recoveryTimeout to recover.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // Halfway through recovery timeout the second recovers.
    Sleeper.DEFAULT.sleep(RECOVERY_MS / 2);
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), true);

    // Second is the current.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // After the initial recovery timeout, the second is still current.
    Sleeper.DEFAULT.sleep(RECOVERY_MS / 2 + 100);
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // Second becomes unavailable.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), false);

    // After recovery timeout has passed.
    Sleeper.DEFAULT.sleep(RECOVERY_MS + 100);

    // Changes to an available endpoint -- third.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(2));

    // First becomes available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(0), true);

    // First becomes current immediately.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // First becomes unavailable.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(0), false);

    // First is still current, allowing upto recoveryTimeout to recover.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // After recovery timeout has passed.
    Sleeper.DEFAULT.sleep(RECOVERY_MS + 100);

    // Changes to an available endpoint -- third.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(2));

    // Third becomes unavailable
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(2), false);

    // Third is still current, allowing upto recoveryTimeout to recover.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(2));

    // Halfway through recovery timeout the second becomes available.
    // Sleeper.defaultSleeper().sleep(Duration.ofMillis(RECOVERY_MS - 100));
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), true);

    // Second becomes current immediately.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // Second becomes unavailable.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), false);

    // Second is still current, allowing upto recoveryTimeout to recover.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // After recovery timeout has passed.
    Sleeper.DEFAULT.sleep(RECOVERY_MS + 100);

    // After all endpoints became unavailable the multiEndpoint sticks to the last used endpoint.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));
  }

  @Test
  public void setEndpoints_raisesErrorWhenEmptyEndpoints() {
    MultiEndpoint multiEndpoint = initPlain(threeEndpoints);
    expectedEx.expect(IllegalArgumentException.class);
    multiEndpoint.setEndpoints(ImmutableList.of());
  }

  @Test
  public void setEndpoints_updatesEndpoints() {
    MultiEndpoint multiEndpoint = initPlain(threeEndpoints);
    multiEndpoint.setEndpoints(fourEndpoints);

    // "first" which is now under index 1 still current because no other available.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(fourEndpoints.get(1));
  }

  @Test
  public void setEndpoints_updatesEndpointsWithRecovery() {
    MultiEndpoint multiEndpoint = initWithRecovery(threeEndpoints, RECOVERY_MS);
    multiEndpoint.setEndpoints(fourEndpoints);

    // "first" which is now under index 1 still current because no other available.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(fourEndpoints.get(1));
  }

  @Test
  public void setEndpoints_updatesEndpointsPreservingStates() {
    MultiEndpoint multiEndpoint = initPlain(threeEndpoints);

    // Second is available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), true);
    multiEndpoint.setEndpoints(fourEndpoints);

    // "second" which is now under index 3 still must remain available.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(fourEndpoints.get(3));
  }

  @Test
  public void setEndpoints_updatesEndpointsPreservingStatesWithRecovery()
      throws InterruptedException {
    MultiEndpoint multiEndpoint = initWithRecovery(threeEndpoints, RECOVERY_MS);

    // After recovery timeout has passed.
    Sleeper.DEFAULT.sleep(RECOVERY_MS + 100);

    // Second is available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), true);
    multiEndpoint.setEndpoints(fourEndpoints);

    // "second" which is now under index 3 still must remain available.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(fourEndpoints.get(3));
  }

  @Test
  public void setEndpoints_updatesEndpointsSwitchToTopPriorityAvailable() {
    MultiEndpoint multiEndpoint = initPlain(threeEndpoints);

    // Second and third is available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), true);
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(2), true);

    multiEndpoint.setEndpoints(fourEndpoints);

    // "third" which is now under index 2 must become current, because "second" has lower priority.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(fourEndpoints.get(2));
  }

  @Test
  public void setEndpoints_updatesEndpointsSwitchToTopPriorityAvailableWithRecovery()
      throws InterruptedException {
    MultiEndpoint multiEndpoint = initWithRecovery(threeEndpoints, RECOVERY_MS);

    // After recovery timeout has passed.
    Sleeper.DEFAULT.sleep(RECOVERY_MS + 100);

    // Second and third is available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), true);
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(2), true);

    multiEndpoint.setEndpoints(fourEndpoints);

    // "third" which is now under index 2 must become current, because "second" has lower priority.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(fourEndpoints.get(2));
  }

  @Test
  public void setEndpoints_updatesEndpointsRemovesOnlyActiveEndpoint() {
    List<String> extraEndpoints = new ArrayList<>(threeEndpoints);
    extraEndpoints.add("extra");
    MultiEndpoint multiEndpoint = initPlain(extraEndpoints);

    // Extra is available.
    multiEndpoint.setEndpointAvailable("extra", true);

    // Extra is removed.
    multiEndpoint.setEndpoints(fourEndpoints);

    // "four" which is under index 0 must become current, because no endpoints available.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(fourEndpoints.get(0));
  }

  @Test
  public void setEndpoints_updatesEndpointsRemovesOnlyActiveEndpointWithRecovery()
      throws InterruptedException {
    List<String> extraEndpoints = new ArrayList<>(threeEndpoints);
    extraEndpoints.add("extra");
    MultiEndpoint multiEndpoint = initWithRecovery(extraEndpoints, RECOVERY_MS);

    // After recovery timeout has passed.
    Sleeper.DEFAULT.sleep(RECOVERY_MS + 100);

    // Extra is available.
    multiEndpoint.setEndpointAvailable("extra", true);

    // Extra is removed.
    multiEndpoint.setEndpoints(fourEndpoints);

    // "four" which is under index 0 must become current, because no endpoints available.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(fourEndpoints.get(0));
  }

  @Test
  public void setEndpoints_recoveringEndpointGetsRemoved() throws InterruptedException {
    List<String> extraEndpoints = new ArrayList<>(threeEndpoints);
    extraEndpoints.add("extra");
    MultiEndpoint multiEndpoint = initWithRecovery(extraEndpoints, RECOVERY_MS);

    // After recovery timeout has passed.
    Sleeper.DEFAULT.sleep(RECOVERY_MS + 100);

    // Extra is available.
    multiEndpoint.setEndpointAvailable("extra", true);

    // Extra is recovering.
    multiEndpoint.setEndpointAvailable("extra", false);

    // Extra is removed.
    multiEndpoint.setEndpoints(fourEndpoints);

    // "four" which is under index 0 must become current, because no endpoints available.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(fourEndpoints.get(0));

    // After recovery timeout has passed.
    Sleeper.DEFAULT.sleep(RECOVERY_MS + 100);

    // "four" is still current.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(fourEndpoints.get(0));
  }
}
