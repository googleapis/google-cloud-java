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
import static org.junit.Assert.assertThrows;

import com.google.api.client.util.Sleeper;
import com.google.cloud.grpc.multiendpoint.Endpoint.EndpointState;
import com.google.common.collect.ImmutableList;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for MultiEndpoint. */
@RunWith(JUnit4.class)
public final class MultiEndpointTest {

  private final List<String> threeEndpoints =
      new ArrayList<>(ImmutableList.of("first", "second", "third"));

  private final List<String> fourEndpoints =
      new ArrayList<>(ImmutableList.of("fourth", "first", "third", "second"));

  private static final long RECOVERY_MS = 20;
  private static final long DELAY_MS = 40;
  private static final long MARGIN_MS = 10;

  private void sleep(long millis) throws InterruptedException {
    Sleeper.DEFAULT.sleep(millis);
  }

  private MultiEndpoint initPlain(List<String> endpoints) {
    return new MultiEndpoint.Builder(endpoints).build();
  }

  private MultiEndpoint initWithRecovery(List<String> endpoints, long recoveryTimeOut) {
    return new MultiEndpoint.Builder(endpoints)
        .withRecoveryTimeout(Duration.ofMillis(recoveryTimeOut))
        .build();
  }

  private MultiEndpoint initWithDelays(
      List<String> endpoints, long recoveryTimeOut, long switchingDelay) {
    return new MultiEndpoint.Builder(endpoints)
        .withRecoveryTimeout(Duration.ofMillis(recoveryTimeOut))
        .withSwitchingDelay(Duration.ofMillis(switchingDelay))
        .build();
  }

  @Test
  public void constructor_raisesErrorWhenEmptyEndpoints() {
    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> initPlain(ImmutableList.of()));
    assertThat(thrown).hasMessageThat().contains("Endpoints list must not be empty.");

    thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> initWithRecovery(ImmutableList.of(), RECOVERY_MS));
    assertThat(thrown).hasMessageThat().contains("Endpoints list must not be empty.");
  }

  @Test
  public void constructor_currentIsFirstAfterInit() {
    MultiEndpoint multiEndpoint = initWithDelays(threeEndpoints, RECOVERY_MS, DELAY_MS);

    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));
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

    assertThat(multiEndpoint.getFallbackCnt()).isEqualTo(0);
    assertThat(multiEndpoint.getRecoverCnt()).isEqualTo(0);
    assertThat(multiEndpoint.getReplaceCnt()).isEqualTo(0);

    // Returns first after creation.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // Second becomes available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), true);

    // First is still the current to allow it to become available within recovery timeout.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // After recovery timeout has passed.
    sleep(RECOVERY_MS + MARGIN_MS);

    // first -> second is a fallback.
    assertThat(multiEndpoint.getFallbackCnt()).isEqualTo(1);
    assertThat(multiEndpoint.getRecoverCnt()).isEqualTo(0);
    assertThat(multiEndpoint.getReplaceCnt()).isEqualTo(0);

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
    sleep(RECOVERY_MS / 2);
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), true);

    // Second is the current.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // After the initial recovery timeout, the second is still current.
    sleep(RECOVERY_MS / 2 + MARGIN_MS);
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // Second becomes unavailable.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), false);

    // After recovery timeout has passed.
    sleep(RECOVERY_MS + MARGIN_MS);

    // Changes to an available endpoint -- third.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(2));

    // second -> third is a fallback.
    assertThat(multiEndpoint.getFallbackCnt()).isEqualTo(2);
    assertThat(multiEndpoint.getRecoverCnt()).isEqualTo(0);
    assertThat(multiEndpoint.getReplaceCnt()).isEqualTo(0);

    // First becomes available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(0), true);

    // First becomes current immediately.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // third -> first is a recovery.
    assertThat(multiEndpoint.getFallbackCnt()).isEqualTo(2);
    assertThat(multiEndpoint.getRecoverCnt()).isEqualTo(1);
    assertThat(multiEndpoint.getReplaceCnt()).isEqualTo(0);

    // First becomes unavailable.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(0), false);

    // First is still current, allowing upto recoveryTimeout to recover.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // After recovery timeout has passed.
    sleep(RECOVERY_MS + MARGIN_MS);

    // Changes to an available endpoint -- third.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(2));

    // Third becomes unavailable
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(2), false);

    // Third is still current, allowing upto recoveryTimeout to recover.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(2));

    // Halfway through recovery timeout the second becomes available.
    sleep(RECOVERY_MS / 2);
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), true);

    // Second becomes current immediately.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // Second becomes unavailable.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), false);

    // Second is still current, allowing upto recoveryTimeout to recover.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // After recovery timeout has passed.
    sleep(RECOVERY_MS + MARGIN_MS);

    // After all endpoints became unavailable the multiEndpoint sticks to the last used endpoint.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));
  }

  @Test
  public void setEndpoints_raisesErrorWhenEmptyEndpoints() {
    MultiEndpoint multiEndpoint = initPlain(threeEndpoints);
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class, () -> multiEndpoint.setEndpoints(ImmutableList.of()));
    assertThat(thrown).hasMessageThat().contains("Endpoints list must not be empty.");
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
    sleep(RECOVERY_MS + MARGIN_MS);

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
    sleep(RECOVERY_MS + MARGIN_MS);

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

    assertThat(multiEndpoint.getFallbackCnt()).isEqualTo(0);
    assertThat(multiEndpoint.getRecoverCnt()).isEqualTo(0);
    assertThat(multiEndpoint.getReplaceCnt()).isEqualTo(0);

    // Extra is available.
    multiEndpoint.setEndpointAvailable("extra", true);

    // Switch "first" -> "extra" is a fallback as "extra" has lower priority.
    assertThat(multiEndpoint.getFallbackCnt()).isEqualTo(1);
    assertThat(multiEndpoint.getRecoverCnt()).isEqualTo(0);
    assertThat(multiEndpoint.getReplaceCnt()).isEqualTo(0);

    // Extra is removed.
    multiEndpoint.setEndpoints(fourEndpoints);

    // Switch "extra" -> "first" is of "replace" type, because "extra" is no longer in the list of
    // endpoints.
    assertThat(multiEndpoint.getFallbackCnt()).isEqualTo(1);
    assertThat(multiEndpoint.getRecoverCnt()).isEqualTo(0);
    assertThat(multiEndpoint.getReplaceCnt()).isEqualTo(1);


    // "fourth" which is under index 0 must become current, because no endpoints available.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(fourEndpoints.get(0));
  }

  @Test
  public void setEndpoints_updatesEndpointsRemovesOnlyActiveEndpointWithRecovery()
      throws InterruptedException {
    List<String> extraEndpoints = new ArrayList<>(threeEndpoints);
    extraEndpoints.add("extra");
    MultiEndpoint multiEndpoint = initWithRecovery(extraEndpoints, RECOVERY_MS);

    // After recovery timeout has passed.
    sleep(RECOVERY_MS + MARGIN_MS);

    // Extra is available.
    multiEndpoint.setEndpointAvailable("extra", true);

    // Extra is removed.
    multiEndpoint.setEndpoints(fourEndpoints);

    // "fourth" which is under index 0 must become current, because no endpoints available.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(fourEndpoints.get(0));
  }

  @Test
  public void setEndpoints_recoveringEndpointGetsRemoved() throws InterruptedException {
    List<String> extraEndpoints = new ArrayList<>(threeEndpoints);
    extraEndpoints.add("extra");
    MultiEndpoint multiEndpoint = initWithRecovery(extraEndpoints, RECOVERY_MS);

    // After recovery timeout has passed.
    sleep(RECOVERY_MS + MARGIN_MS);

    // Extra is available.
    multiEndpoint.setEndpointAvailable("extra", true);

    // Extra is recovering.
    multiEndpoint.setEndpointAvailable("extra", false);

    // Extra is removed.
    multiEndpoint.setEndpoints(fourEndpoints);

    // "fourth" which is under index 0 must become current, because no endpoints available.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(fourEndpoints.get(0));

    // After recovery timeout has passed.
    sleep(RECOVERY_MS + MARGIN_MS);

    // "fourth" is still current.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(fourEndpoints.get(0));
  }

  @Test
  public void setEndpointAvailable_subsequentUnavailableShouldNotExtendRecoveryTimeout()
      throws InterruptedException {
    // All endpoints are recovering.
    MultiEndpoint multiEndpoint = initWithRecovery(threeEndpoints, RECOVERY_MS);

    // Before recovery timeout repeat unavailable signal.
    sleep(RECOVERY_MS / 2);
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(0), false);

    // After the initial timeout it must become unavailable.
    sleep(RECOVERY_MS / 2 + MARGIN_MS);
    assertThat(multiEndpoint.getEndpointsMap().get(threeEndpoints.get(0)).getState())
        .isEqualTo(EndpointState.UNAVAILABLE);
  }

  @Test
  public void setEndpointAvailable_recoveredUnavailableRace() throws InterruptedException {
    // All endpoints are recovering.
    MultiEndpoint multiEndpoint = initWithRecovery(threeEndpoints, RECOVERY_MS);

    for (int i = 0; i < 100; i++) {
      // Right at the recovery timeout we enable the "first". This should race with the "first"
      // becoming unavailable from its recovery timer. If this race condition is not covered then
      // the test will most likely fail or at least be flaky.
      sleep(RECOVERY_MS);
      multiEndpoint.setEndpointAvailable(threeEndpoints.get(0), true);

      sleep(MARGIN_MS);
      assertThat(multiEndpoint.getEndpointsMap().get(threeEndpoints.get(0)).getState())
          .isEqualTo(EndpointState.AVAILABLE);

      // Send it back to recovery state and start recovery timer.
      multiEndpoint.setEndpointAvailable(threeEndpoints.get(0), false);
    }
  }

  @Test
  public void setEndpointAvailable_doNotSwitchToUnavailableFromAvailable()
      throws InterruptedException {
    MultiEndpoint multiEndpoint = initWithDelays(threeEndpoints, RECOVERY_MS, DELAY_MS);
    // Second and third endpoint are available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), true);
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(2), true);

    sleep(RECOVERY_MS + MARGIN_MS);
    // Second is current.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // First becomes available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(0), true);

    // Switching is planned to "first" after switching delay. "second" is still current.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // Almost at switching delay the "first" endpoint becomes unavailable again.
    sleep(DELAY_MS - MARGIN_MS);
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(0), false);

    // After switching delay the current must be "second". No switching to "first" should occur.
    sleep(2 * MARGIN_MS);
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));
  }

  @Test
  public void setEndpointAvailable_doNotSwitchPreemptively() throws InterruptedException {
    MultiEndpoint multiEndpoint = initWithDelays(threeEndpoints, RECOVERY_MS, DELAY_MS);

    // All unavailable after recovery timeout.
    sleep(RECOVERY_MS + MARGIN_MS);

    // Only second endpoint is available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(1), true);

    // After switching delay the second should be current.
    sleep(DELAY_MS + MARGIN_MS);
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    // Third becomes available. This shouldn't schedule the switch as second is still
    // the most preferable.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(2), true);

    sleep(DELAY_MS / 2);
    // Halfway to switch delay the first endpoint becomes available.
    multiEndpoint.setEndpointAvailable(threeEndpoints.get(0), true);

    sleep(DELAY_MS / 2 + MARGIN_MS);
    // After complete switching delay since third become available, the second should still be
    // current because we didn't schedule the switch when third became available.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(1));

    sleep(DELAY_MS / 2);
    // But after switching delay passed since first became available it should become current.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));
  }

  @Test
  public void setEndpoints_switchingDelayed() throws InterruptedException {
    MultiEndpoint multiEndpoint = initWithDelays(threeEndpoints, RECOVERY_MS, DELAY_MS);
    // All endpoints are available.
    threeEndpoints.forEach(e -> multiEndpoint.setEndpointAvailable(e, true));

    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // Prepend a new endpoint and make it available.
    List<String> extraEndpoints = new ArrayList<>();
    extraEndpoints.add("extra");
    extraEndpoints.addAll(threeEndpoints);

    multiEndpoint.setEndpoints(extraEndpoints);
    multiEndpoint.setEndpointAvailable("extra", true);

    // The current endpoint should not change instantly.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // But after switching delay it should.
    sleep(DELAY_MS + MARGIN_MS);
    assertThat(multiEndpoint.getCurrentId()).isEqualTo("extra");

    // Make current endpoint unavailable.
    multiEndpoint.setEndpointAvailable("extra", false);

    // Should wait for recovery timeout.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo("extra");

    // Should switch to a healthy endpoint after recovery timeout and not the switching delay.
    sleep(RECOVERY_MS + MARGIN_MS);
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // Prepend another endpoint.
    List<String> updatedEndpoints = new ArrayList<>();
    updatedEndpoints.add("extra2");
    updatedEndpoints.addAll(extraEndpoints);

    multiEndpoint.setEndpoints(updatedEndpoints);
    // Now the endpoints are:
    // extra2 UNAVAILABLE
    // extra UNAVAILABLE
    // first AVAILABLE <-- current
    // second AVAILABLE
    // third AVAILABLE

    // Make "extra" endpoint available.
    multiEndpoint.setEndpointAvailable("extra", true);

    // Should wait for the switching delay.
    // Halfway it should be still "first" endpoint.
    sleep(DELAY_MS / 2);
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // Now another higher priority endpoint becomes available.
    multiEndpoint.setEndpointAvailable("extra2", true);

    // Still "first" endpoint is current because switching delay has not passed.
    assertThat(multiEndpoint.getCurrentId()).isEqualTo(threeEndpoints.get(0));

    // After another half of the switching delay has passed it should switch to the "extra2" because
    // it is a top priority available endpoint at the moment.
    sleep(DELAY_MS / 2 + MARGIN_MS);
    assertThat(multiEndpoint.getCurrentId()).isEqualTo("extra2");
  }
}
