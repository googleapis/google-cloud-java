/*
 * Copyright 2017 Google LLC
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
package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.spanner.SessionPoolOptions.InactiveTransactionRemovalOptions;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/** Unit tests for {@link com.google.cloud.spanner.SessionPoolOptions} */
@RunWith(Parameterized.class)
public class SessionPoolOptionsTest {
  @Parameter public int minSessions;

  @Parameter(1)
  public int maxSessions;

  @Parameters(name = "min sessions = {0}, max sessions = {1}")
  public static Collection<Object[]> data() {
    List<Object[]> params = new ArrayList<>();
    params.add(new Object[] {1, 1});
    params.add(new Object[] {500, 600});
    params.add(new Object[] {600, 500});

    return params;
  }

  @Test
  public void setMinMaxSessions() {
    try {
      SessionPoolOptions options =
          SessionPoolOptions.newBuilder()
              .setMinSessions(minSessions)
              .setMaxSessions(maxSessions)
              .build();
      if (minSessions > maxSessions) {
        fail("Expected exception");
      }
      assertThat(minSessions).isEqualTo(options.getMinSessions());
      assertThat(maxSessions).isEqualTo(options.getMaxSessions());
    } catch (IllegalArgumentException ex) {
      if (minSessions <= maxSessions) {
        throw ex;
      }
      assertNotNull(ex.getMessage());
    }
  }

  /**
   * Setting MaxSessions to a value lower than the default MinSessions should be allowed, and should
   * cause the MinSessions to be set to the same value as the MaxSessions.
   */
  @Test
  public void setOnlyMaxSessions() {
    final int defaultMinSessions = 100;
    // Set max sessions > DEFAULT_MIN_SESSIONS.
    SessionPoolOptions options =
        SessionPoolOptions.newBuilder().setMaxSessions(defaultMinSessions + 1).build();
    assertThat(options.getMaxSessions()).isEqualTo(defaultMinSessions + 1);
    assertThat(options.getMinSessions()).isEqualTo(defaultMinSessions);
    // Set max sessions < DEFAULT_MIN_SESSIONS.
    options = SessionPoolOptions.newBuilder().setMaxSessions(defaultMinSessions - 1).build();
    assertThat(options.getMaxSessions()).isEqualTo(defaultMinSessions - 1);
    assertThat(options.getMinSessions()).isEqualTo(defaultMinSessions - 1);
  }

  @Test
  public void setValidMinSessions() {
    SessionPoolOptions.newBuilder().setMinSessions(0).build();
    SessionPoolOptions.newBuilder().setMinSessions(1).build();
    SessionPoolOptions.newBuilder().setMinSessions(400).build();
    SessionPoolOptions.newBuilder()
        .setMaxSessions(Integer.MAX_VALUE)
        .setMinSessions(Integer.MAX_VALUE)
        .build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void setNegativeMinSessions() {
    SessionPoolOptions.newBuilder().setMinSessions(-1);
  }

  @Test
  public void setValidMaxSessions() {
    SessionPoolOptions.newBuilder().setMaxSessions(1).build();
    SessionPoolOptions.newBuilder().setMaxSessions(400).build();
    SessionPoolOptions.newBuilder().setMaxSessions(Integer.MAX_VALUE).build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void setZeroMaxSessions() {
    SessionPoolOptions.newBuilder().setMaxSessions(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setNegativeMaxSessions() {
    SessionPoolOptions.newBuilder().setMaxSessions(-1);
  }

  @Test
  public void verifyDefaultInactiveTransactionRemovalOptions() {
    SessionPoolOptions sessionPoolOptions = SessionPoolOptions.newBuilder().build();
    InactiveTransactionRemovalOptions inactiveTransactionRemovalOptions =
        sessionPoolOptions.getInactiveTransactionRemovalOptions();

    assertTrue(sessionPoolOptions.warnInactiveTransactions());
    assertFalse(sessionPoolOptions.warnAndCloseInactiveTransactions());
    assertFalse(sessionPoolOptions.closeInactiveTransactions());
    assertEquals(0.95, inactiveTransactionRemovalOptions.getUsedSessionsRatioThreshold(), 0.0);
    assertEquals(Duration.ofMinutes(2), inactiveTransactionRemovalOptions.getExecutionFrequency());
    assertEquals(Duration.ofMinutes(60), inactiveTransactionRemovalOptions.getIdleTimeThreshold());
  }

  @Test
  public void setWarnIfInactiveTransactions() {
    SessionPoolOptions sessionPoolOptions =
        SessionPoolOptions.newBuilder().setWarnIfInactiveTransactions().build();

    assertTrue(sessionPoolOptions.warnInactiveTransactions());
    assertFalse(sessionPoolOptions.warnAndCloseInactiveTransactions());
    assertFalse(sessionPoolOptions.closeInactiveTransactions());
  }

  @Test
  public void setWarnAndCloseIfInactiveTransactions() {
    SessionPoolOptions sessionPoolOptions =
        SessionPoolOptions.newBuilder().setWarnAndCloseIfInactiveTransactions().build();

    assertFalse(sessionPoolOptions.warnInactiveTransactions());
    assertTrue(sessionPoolOptions.warnAndCloseInactiveTransactions());
    assertFalse(sessionPoolOptions.closeInactiveTransactions());
  }

  @Test
  public void setCloseIfInactiveTransactions() {
    SessionPoolOptions sessionPoolOptions =
        SessionPoolOptions.newBuilder().setCloseIfInactiveTransactions().build();

    assertFalse(sessionPoolOptions.warnInactiveTransactions());
    assertFalse(sessionPoolOptions.warnAndCloseInactiveTransactions());
    assertTrue(sessionPoolOptions.closeInactiveTransactions());
  }

  @Test
  public void testSetUsedSessionsRatioThreshold() {
    double threshold = ThreadLocalRandom.current().nextDouble();
    InactiveTransactionRemovalOptions inactiveTransactionRemovalOptions =
        InactiveTransactionRemovalOptions.newBuilder()
            .setUsedSessionsRatioThreshold(threshold)
            .build();
    assertEquals(
        threshold, inactiveTransactionRemovalOptions.getUsedSessionsRatioThreshold(), 0.0d);
  }

  @Test
  public void testBlockIfPoolExhausted() {
    assertTrue(SessionPoolOptions.newBuilder().build().isBlockIfPoolExhausted());
    assertTrue(
        SessionPoolOptions.newBuilder().setBlockIfPoolExhausted().build().isBlockIfPoolExhausted());
    assertFalse(
        SessionPoolOptions.newBuilder().setFailIfPoolExhausted().build().isBlockIfPoolExhausted());
  }

  @Test
  public void testFailIfSessionNotFound() {
    assertFalse(SessionPoolOptions.newBuilder().build().isFailIfSessionNotFound());
    assertTrue(
        SessionPoolOptions.newBuilder()
            .setFailIfSessionNotFound()
            .build()
            .isFailIfSessionNotFound());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setNegativeExecutionFrequency() {
    InactiveTransactionRemovalOptions inactiveTransactionRemovalOptions =
        InactiveTransactionRemovalOptions.newBuilder()
            .setExecutionFrequency(Duration.ofMillis(-1))
            .build();
    SessionPoolOptions.newBuilder()
        .setInactiveTransactionRemovalOptions(inactiveTransactionRemovalOptions);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setNegativeIdleTimeThreshold() {
    InactiveTransactionRemovalOptions inactiveTransactionRemovalOptions =
        InactiveTransactionRemovalOptions.newBuilder()
            .setIdleTimeThreshold(Duration.ofMillis(-1))
            .build();
    SessionPoolOptions.newBuilder()
        .setInactiveTransactionRemovalOptions(inactiveTransactionRemovalOptions);
  }

  @Test
  public void setAcquireSessionTimeout() {
    SessionPoolOptions sessionPoolOptions1 =
        SessionPoolOptions.newBuilder()
            .setAcquireSessionTimeoutDuration(Duration.ofSeconds(20))
            .build();
    SessionPoolOptions sessionPoolOptions2 =
        SessionPoolOptions.newBuilder()
            .setAcquireSessionTimeoutDuration(Duration.ofMillis(Long.MAX_VALUE))
            .build();

    assertEquals(Duration.ofSeconds(20), sessionPoolOptions1.getAcquireSessionTimeout());
    assertEquals(Duration.ofMillis(Long.MAX_VALUE), sessionPoolOptions2.getAcquireSessionTimeout());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setAcquireSessionTimeout_valueLessThanLowerBound() {
    SessionPoolOptions.newBuilder().setAcquireSessionTimeoutDuration(Duration.ofMillis(0)).build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void setAcquireSessionTimeout_valueMoreThanUpperBound() {
    SessionPoolOptions.newBuilder()
        .setAcquireSessionTimeoutDuration(Duration.ofSeconds(Long.MAX_VALUE))
        .build();
  }

  @Test
  public void verifyDefaultAcquireSessionTimeout() {
    SessionPoolOptions sessionPoolOptions = SessionPoolOptions.newBuilder().build();

    assertEquals(Duration.ofSeconds(60), sessionPoolOptions.getAcquireSessionTimeout());
  }

  @Test
  public void testRandomizePositionQPSThreshold() {
    assertEquals(0L, SessionPoolOptions.newBuilder().build().getRandomizePositionQPSThreshold());
    assertEquals(
        4L,
        SessionPoolOptions.newBuilder()
            .setRandomizePositionQPSThreshold(4L)
            .build()
            .getRandomizePositionQPSThreshold());
    assertEquals(
        10L,
        SessionPoolOptions.newBuilder()
            .setRandomizePositionQPSThreshold(4L)
            .setRandomizePositionQPSThreshold(10L)
            .build()
            .getRandomizePositionQPSThreshold());
    assertEquals(
        0L,
        SessionPoolOptions.newBuilder()
            .setRandomizePositionQPSThreshold(0L)
            .build()
            .getRandomizePositionQPSThreshold());
    assertThrows(
        IllegalArgumentException.class,
        () -> SessionPoolOptions.newBuilder().setRandomizePositionQPSThreshold(-1L));
  }

  @Test
  public void testUseMultiplexedSession() {
    assumeFalse(TestHelper.isMultiplexSessionDisabled());
    // skip these tests since this configuration can have dual behaviour in different test-runners
    assumeFalse(SessionPoolOptions.newBuilder().build().getUseMultiplexedSession());
    assertEquals(false, SessionPoolOptions.newBuilder().build().getUseMultiplexedSession());
    assertEquals(
        true,
        SessionPoolOptions.newBuilder()
            .setUseMultiplexedSession(true)
            .build()
            .getUseMultiplexedSession());
    assertEquals(
        false,
        SessionPoolOptions.newBuilder()
            .setUseMultiplexedSession(true)
            .setUseMultiplexedSession(false)
            .build()
            .getUseMultiplexedSession());
  }

  @Test
  public void testUseMultiplexedSessionForRW() {
    // skip these tests since this configuration can have dual behaviour in different test-runners
    assumeFalse(TestHelper.isMultiplexSessionDisabled());
    assumeFalse(
        Boolean.parseBoolean(System.getenv("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS_FOR_RW")));
    assumeFalse(SessionPoolOptions.newBuilder().build().getUseMultiplexedSession());
    assumeFalse(SessionPoolOptions.newBuilder().build().getUseMultiplexedSessionForRW());

    // Verify default client behavior for multiplexed sessions in R/W transactions
    assertEquals(false, SessionPoolOptions.newBuilder().build().getUseMultiplexedSessionForRW());

    // Client will use multiplexed sessions for R/W transactions if both the fields are set to true.
    assertEquals(
        true,
        SessionPoolOptions.newBuilder()
            .setUseMultiplexedSession(true)
            .setUseMultiplexedSessionForRW(true)
            .build()
            .getUseMultiplexedSessionForRW());
    // Client will not use multiplexed sessions for R/W transactions, since one of the field is set
    // to false.
    assertEquals(
        false,
        SessionPoolOptions.newBuilder()
            .setUseMultiplexedSession(true)
            .setUseMultiplexedSessionForRW(false)
            .build()
            .getUseMultiplexedSessionForRW());
    // Client will not use multiplexed sessions for R/W transactions, since one of the field is set
    // to false.
    assertEquals(
        false,
        SessionPoolOptions.newBuilder()
            .setUseMultiplexedSession(false)
            .setUseMultiplexedSessionForRW(true)
            .build()
            .getUseMultiplexedSessionForRW());
    // Client will not use multiplexed sessions for R/W transactions, since both the fields are set
    // to false.
    assertEquals(
        false,
        SessionPoolOptions.newBuilder()
            .setUseMultiplexedSession(false)
            .setUseMultiplexedSessionForRW(false)
            .build()
            .getUseMultiplexedSessionForRW());
  }

  @Test
  public void testMultiplexedSessionMaintenanceDuration() {
    assertEquals(
        Duration.ofDays(7),
        SessionPoolOptions.newBuilder().build().getMultiplexedSessionMaintenanceDuration());
    assertEquals(
        Duration.ofDays(2),
        SessionPoolOptions.newBuilder()
            .setMultiplexedSessionMaintenanceDuration(Duration.ofDays(2))
            .build()
            .getMultiplexedSessionMaintenanceDuration());
    assertEquals(
        Duration.ofDays(10),
        SessionPoolOptions.newBuilder()
            .setMultiplexedSessionMaintenanceDuration(Duration.ofDays(2))
            .setMultiplexedSessionMaintenanceDuration(Duration.ofDays(10))
            .build()
            .getMultiplexedSessionMaintenanceDuration());
  }

  @Test
  public void testToBuilder() {
    assertToBuilderRoundtrip(SessionPoolOptions.newBuilder().build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setUseMultiplexedSession(ThreadLocalRandom.current().nextBoolean())
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setUseMultiplexedSessionForRW(ThreadLocalRandom.current().nextBoolean())
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setMinSessions(ThreadLocalRandom.current().nextInt(400))
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setMaxSessions(ThreadLocalRandom.current().nextInt(1, 1000))
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setIncStep(ThreadLocalRandom.current().nextInt(1, 1000))
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setMaxIdleSessions(ThreadLocalRandom.current().nextInt(1000))
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setWriteSessionsFraction(ThreadLocalRandom.current().nextFloat())
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setInactiveTransactionRemovalOptions(
                InactiveTransactionRemovalOptions.newBuilder()
                    .setUsedSessionsRatioThreshold(ThreadLocalRandom.current().nextDouble())
                    .build())
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setLoopFrequency(ThreadLocalRandom.current().nextInt(1000))
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setMultiplexedSessionMaintenanceLoopFrequency(
                java.time.Duration.ofMillis(ThreadLocalRandom.current().nextInt(1000)))
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setKeepAliveIntervalMinutes(ThreadLocalRandom.current().nextInt(60))
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setRemoveInactiveSessionAfterDuration(
                Duration.ofMillis(ThreadLocalRandom.current().nextLong(10000)))
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder().setCloseIfInactiveTransactions().build());
    assertToBuilderRoundtrip(SessionPoolOptions.newBuilder().setFailOnSessionLeak().build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setTrackStackTraceOfSessionCheckout(ThreadLocalRandom.current().nextBoolean())
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setInitialWaitForSessionTimeoutMillis(ThreadLocalRandom.current().nextLong(1000))
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setAutoDetectDialect(ThreadLocalRandom.current().nextBoolean())
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setWaitForMinSessionsDuration(
                Duration.ofMillis(ThreadLocalRandom.current().nextLong(10000)))
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setAcquireSessionTimeoutDuration(
                Duration.ofMillis(ThreadLocalRandom.current().nextLong(1, 10000)))
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setRandomizePositionQPSThreshold(ThreadLocalRandom.current().nextLong(10000))
            .build());
    assertToBuilderRoundtrip(
        SessionPoolOptions.newBuilder()
            .setMultiplexedSessionMaintenanceDuration(
                Duration.ofMillis(ThreadLocalRandom.current().nextLong(10000)))
            .build());
  }

  static void assertToBuilderRoundtrip(SessionPoolOptions options) {
    assertEquals(options, options.toBuilder().build());
  }
}
