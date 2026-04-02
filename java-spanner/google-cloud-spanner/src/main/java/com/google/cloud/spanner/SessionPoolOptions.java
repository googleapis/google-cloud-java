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

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;
import static com.google.api.gax.util.TimeConversionUtils.toThreetenDuration;

import com.google.api.core.InternalApi;
import com.google.api.core.ObsoleteApi;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.time.Duration;
import java.util.Locale;
import java.util.Objects;

/**
 * Options for the session pool used by {@code DatabaseClient}.
 *
 * @deprecated The Spanner Java client uses a single multiplexed session. All options related to the
 *     session pool are no longer functional and will be removed in a future version.
 */
@Deprecated
public class SessionPoolOptions {
  @Deprecated
  enum Position {
    FIRST,
    LAST,
    RANDOM
  }

  // Default number of channels * 100.
  private static final int DEFAULT_MAX_SESSIONS = 400;
  private static final int DEFAULT_MIN_SESSIONS = 100;
  private static final int DEFAULT_INC_STEP = 25;
  private static final int EXPERIMENTAL_HOST_REGULAR_SESSIONS = 0;
  private static final ActionOnExhaustion DEFAULT_ACTION = ActionOnExhaustion.BLOCK;
  private final int minSessions;
  private final int maxSessions;
  private final int incStep;

  /**
   * Use {@link #minSessions} instead to set the minimum number of sessions in the pool to maintain.
   * Creating a larger number of sessions during startup is relatively cheap as it is executed with
   * the BatchCreateSessions RPC.
   */
  @Deprecated private final int maxIdleSessions;

  /**
   * The session pool no longer prepares a fraction of the sessions with a read/write transaction.
   * This setting therefore does not have any meaning anymore, and may be removed in the future.
   */
  @Deprecated private final float writeSessionsFraction;

  private final ActionOnExhaustion actionOnExhaustion;
  private final long loopFrequency;
  private final Duration multiplexedSessionMaintenanceLoopFrequency;
  private final int keepAliveIntervalMinutes;
  private final Duration removeInactiveSessionAfter;
  private final ActionOnSessionNotFound actionOnSessionNotFound;
  private final ActionOnSessionLeak actionOnSessionLeak;
  private final boolean trackStackTraceOfSessionCheckout;
  private final InactiveTransactionRemovalOptions inactiveTransactionRemovalOptions;

  /**
   * Use {@link #acquireSessionTimeout} instead to specify the total duration to wait while
   * acquiring session for a transaction.
   */
  @Deprecated private final long initialWaitForSessionTimeoutMillis;

  private final boolean autoDetectDialect;
  private final Duration waitForMinSessions;
  private final Duration acquireSessionTimeout;
  private final Position releaseToPosition;
  private final long randomizePositionQPSThreshold;

  /** Property for allowing mocking of session maintenance clock. */
  private final Clock poolMaintainerClock;

  private final boolean useMultiplexedSession;

  private final boolean useMultiplexedSessionForRW;

  private final boolean useMultiplexedSessionForPartitionedOps;

  // TODO: Change to use java.time.Duration.
  private final Duration multiplexedSessionMaintenanceDuration;
  private final boolean skipVerifyingBeginTransactionForMuxRW;

  private SessionPoolOptions(Builder builder) {
    // minSessions > maxSessions is only possible if the user has only set a value for maxSessions.
    // We allow that to prevent code that only sets a value for maxSessions to break if the
    // maxSessions value is less than the default for minSessions.
    this.minSessions =
        builder.isExperimentalHost
            ? EXPERIMENTAL_HOST_REGULAR_SESSIONS
            : Math.min(builder.minSessions, builder.maxSessions);
    this.maxSessions =
        builder.isExperimentalHost ? EXPERIMENTAL_HOST_REGULAR_SESSIONS : builder.maxSessions;
    this.incStep = builder.incStep;
    this.maxIdleSessions = builder.maxIdleSessions;
    this.writeSessionsFraction = builder.writeSessionsFraction;
    this.actionOnExhaustion = builder.actionOnExhaustion;
    this.actionOnSessionNotFound = builder.actionOnSessionNotFound;
    this.actionOnSessionLeak = builder.actionOnSessionLeak;
    this.trackStackTraceOfSessionCheckout = builder.trackStackTraceOfSessionCheckout;
    this.initialWaitForSessionTimeoutMillis = builder.initialWaitForSessionTimeoutMillis;
    this.loopFrequency = builder.loopFrequency;
    this.multiplexedSessionMaintenanceLoopFrequency =
        builder.multiplexedSessionMaintenanceLoopFrequency;
    this.keepAliveIntervalMinutes = builder.keepAliveIntervalMinutes;
    this.removeInactiveSessionAfter = builder.removeInactiveSessionAfter;
    this.autoDetectDialect = builder.autoDetectDialect;
    this.waitForMinSessions = builder.waitForMinSessions;
    this.acquireSessionTimeout = builder.acquireSessionTimeout;
    this.releaseToPosition = builder.releaseToPosition;
    this.randomizePositionQPSThreshold = builder.randomizePositionQPSThreshold;
    this.inactiveTransactionRemovalOptions = builder.inactiveTransactionRemovalOptions;
    this.poolMaintainerClock = builder.poolMaintainerClock;
    // useMultiplexedSession priority => Environment var > private setter > client default
    Boolean useMultiplexedSessionFromEnvVariable = getUseMultiplexedSessionFromEnvVariable();
    this.useMultiplexedSession =
        builder.isExperimentalHost
            || ((useMultiplexedSessionFromEnvVariable != null)
                ? useMultiplexedSessionFromEnvVariable
                : builder.useMultiplexedSession);
    // useMultiplexedSessionForRW priority => Environment var > private setter > client default
    Boolean useMultiplexedSessionForRWFromEnvVariable =
        getUseMultiplexedSessionForRWFromEnvVariable();
    this.useMultiplexedSessionForRW =
        builder.isExperimentalHost
            || ((useMultiplexedSessionForRWFromEnvVariable != null)
                ? useMultiplexedSessionForRWFromEnvVariable
                : builder.useMultiplexedSessionForRW);
    // useMultiplexedSessionPartitionedOps priority => Environment var > private setter > client
    // default
    Boolean useMultiplexedSessionFromEnvVariablePartitionedOps =
        getUseMultiplexedSessionFromEnvVariablePartitionedOps();
    this.useMultiplexedSessionForPartitionedOps =
        builder.isExperimentalHost
            || ((useMultiplexedSessionFromEnvVariablePartitionedOps != null)
                ? useMultiplexedSessionFromEnvVariablePartitionedOps
                : builder.useMultiplexedSessionPartitionedOps);
    this.multiplexedSessionMaintenanceDuration = builder.multiplexedSessionMaintenanceDuration;
    this.skipVerifyingBeginTransactionForMuxRW =
        builder.isExperimentalHost || builder.skipVerifyingBeginTransactionForMuxRW;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof SessionPoolOptions)) {
      return false;
    }
    SessionPoolOptions other = (SessionPoolOptions) o;
    return Objects.equals(this.minSessions, other.minSessions)
        && Objects.equals(this.maxSessions, other.maxSessions)
        && Objects.equals(this.incStep, other.incStep)
        && Objects.equals(this.maxIdleSessions, other.maxIdleSessions)
        && Objects.equals(this.writeSessionsFraction, other.writeSessionsFraction)
        && Objects.equals(this.actionOnExhaustion, other.actionOnExhaustion)
        && Objects.equals(this.actionOnSessionNotFound, other.actionOnSessionNotFound)
        && Objects.equals(this.actionOnSessionLeak, other.actionOnSessionLeak)
        && Objects.equals(
            this.trackStackTraceOfSessionCheckout, other.trackStackTraceOfSessionCheckout)
        && Objects.equals(
            this.initialWaitForSessionTimeoutMillis, other.initialWaitForSessionTimeoutMillis)
        && Objects.equals(this.loopFrequency, other.loopFrequency)
        && Objects.equals(
            this.multiplexedSessionMaintenanceLoopFrequency,
            other.multiplexedSessionMaintenanceLoopFrequency)
        && Objects.equals(this.keepAliveIntervalMinutes, other.keepAliveIntervalMinutes)
        && Objects.equals(this.removeInactiveSessionAfter, other.removeInactiveSessionAfter)
        && Objects.equals(this.autoDetectDialect, other.autoDetectDialect)
        && Objects.equals(this.waitForMinSessions, other.waitForMinSessions)
        && Objects.equals(this.acquireSessionTimeout, other.acquireSessionTimeout)
        && Objects.equals(this.releaseToPosition, other.releaseToPosition)
        && Objects.equals(this.randomizePositionQPSThreshold, other.randomizePositionQPSThreshold)
        && Objects.equals(
            this.inactiveTransactionRemovalOptions, other.inactiveTransactionRemovalOptions)
        && Objects.equals(this.poolMaintainerClock, other.poolMaintainerClock)
        && Objects.equals(this.useMultiplexedSession, other.useMultiplexedSession)
        && Objects.equals(this.useMultiplexedSessionForRW, other.useMultiplexedSessionForRW)
        && Objects.equals(
            this.multiplexedSessionMaintenanceDuration, other.multiplexedSessionMaintenanceDuration)
        && Objects.equals(
            this.skipVerifyingBeginTransactionForMuxRW,
            other.skipVerifyingBeginTransactionForMuxRW);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        this.minSessions,
        this.maxSessions,
        this.incStep,
        this.maxIdleSessions,
        this.writeSessionsFraction,
        this.actionOnExhaustion,
        this.actionOnSessionNotFound,
        this.actionOnSessionLeak,
        this.trackStackTraceOfSessionCheckout,
        this.initialWaitForSessionTimeoutMillis,
        this.loopFrequency,
        this.multiplexedSessionMaintenanceLoopFrequency,
        this.keepAliveIntervalMinutes,
        this.removeInactiveSessionAfter,
        this.autoDetectDialect,
        this.waitForMinSessions,
        this.acquireSessionTimeout,
        this.releaseToPosition,
        this.randomizePositionQPSThreshold,
        this.inactiveTransactionRemovalOptions,
        this.poolMaintainerClock,
        this.useMultiplexedSession,
        this.useMultiplexedSessionForRW,
        this.multiplexedSessionMaintenanceDuration,
        this.skipVerifyingBeginTransactionForMuxRW);
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  @Deprecated
  public int getMinSessions() {
    return minSessions;
  }

  @Deprecated
  public int getMaxSessions() {
    return maxSessions;
  }

  int getIncStep() {
    return incStep;
  }

  /**
   * @deprecated Use a higher value for {@link SessionPoolOptions.Builder#setMinSessions(int)}
   *     instead of setting this option.
   */
  @Deprecated
  public int getMaxIdleSessions() {
    return maxIdleSessions;
  }

  /**
   * @deprecated This value is no longer used. The session pool does not prepare any sessions for
   *     read/write transactions. Instead, a transaction will be started by including a
   *     BeginTransaction option with the first statement of a transaction. This method may be
   *     removed in a future release.
   */
  @Deprecated
  public float getWriteSessionsFraction() {
    return writeSessionsFraction;
  }

  long getLoopFrequency() {
    return loopFrequency;
  }

  Duration getMultiplexedSessionMaintenanceLoopFrequency() {
    return this.multiplexedSessionMaintenanceLoopFrequency;
  }

  @Deprecated
  public int getKeepAliveIntervalMinutes() {
    return keepAliveIntervalMinutes;
  }

  /** This method is obsolete. Use {@link #getRemoveInactiveSessionAfterDuration()} instead. */
  @ObsoleteApi("Use getRemoveInactiveSessionAfterDuration() instead")
  public org.threeten.bp.Duration getRemoveInactiveSessionAfter() {
    return toThreetenDuration(getRemoveInactiveSessionAfterDuration());
  }

  @Deprecated
  public Duration getRemoveInactiveSessionAfterDuration() {
    return removeInactiveSessionAfter;
  }

  @Deprecated
  public boolean isFailIfPoolExhausted() {
    return actionOnExhaustion == ActionOnExhaustion.FAIL;
  }

  @Deprecated
  public boolean isBlockIfPoolExhausted() {
    return actionOnExhaustion == ActionOnExhaustion.BLOCK;
  }

  public boolean isAutoDetectDialect() {
    return autoDetectDialect;
  }

  InactiveTransactionRemovalOptions getInactiveTransactionRemovalOptions() {
    return inactiveTransactionRemovalOptions;
  }

  boolean closeInactiveTransactions() {
    return inactiveTransactionRemovalOptions.actionOnInactiveTransaction
        == ActionOnInactiveTransaction.CLOSE;
  }

  boolean warnAndCloseInactiveTransactions() {
    return inactiveTransactionRemovalOptions.actionOnInactiveTransaction
        == ActionOnInactiveTransaction.WARN_AND_CLOSE;
  }

  boolean warnInactiveTransactions() {
    return inactiveTransactionRemovalOptions.actionOnInactiveTransaction
        == ActionOnInactiveTransaction.WARN;
  }

  @VisibleForTesting
  long getInitialWaitForSessionTimeoutMillis() {
    return initialWaitForSessionTimeoutMillis;
  }

  @VisibleForTesting
  boolean isFailIfSessionNotFound() {
    return actionOnSessionNotFound == ActionOnSessionNotFound.FAIL;
  }

  @VisibleForTesting
  boolean isFailOnSessionLeak() {
    return actionOnSessionLeak == ActionOnSessionLeak.FAIL;
  }

  @VisibleForTesting
  Clock getPoolMaintainerClock() {
    return poolMaintainerClock;
  }

  @Deprecated
  public boolean isTrackStackTraceOfSessionCheckout() {
    return trackStackTraceOfSessionCheckout;
  }

  Duration getWaitForMinSessions() {
    return waitForMinSessions;
  }

  @VisibleForTesting
  Duration getAcquireSessionTimeout() {
    return acquireSessionTimeout;
  }

  Position getReleaseToPosition() {
    return releaseToPosition;
  }

  long getRandomizePositionQPSThreshold() {
    return randomizePositionQPSThreshold;
  }

  @VisibleForTesting
  @InternalApi
  public boolean getUseMultiplexedSession() {
    return useMultiplexedSession;
  }

  @VisibleForTesting
  @InternalApi
  protected boolean getUseMultiplexedSessionBlindWrite() {
    return getUseMultiplexedSession();
  }

  @VisibleForTesting
  @InternalApi
  public boolean getUseMultiplexedSessionForRW() {
    // Multiplexed sessions for R/W are enabled only if both global multiplexed sessions and
    // read-write multiplexed session flags are set to true.
    return getUseMultiplexedSession() && useMultiplexedSessionForRW;
  }

  @VisibleForTesting
  @InternalApi
  public boolean getUseMultiplexedSessionPartitionedOps() {
    return getUseMultiplexedSession() && useMultiplexedSessionForPartitionedOps;
  }

  private static Boolean getUseMultiplexedSessionFromEnvVariable() {
    return parseBooleanEnvVariable("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS");
  }

  @VisibleForTesting
  @InternalApi
  protected static Boolean getUseMultiplexedSessionFromEnvVariablePartitionedOps() {
    return parseBooleanEnvVariable("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS_PARTITIONED_OPS");
  }

  private static Boolean parseBooleanEnvVariable(String variableName) {
    String envVariable = System.getenv(variableName);
    if (envVariable != null && envVariable.length() > 0) {
      if ("true".equalsIgnoreCase(envVariable) || "false".equalsIgnoreCase(envVariable)) {
        return Boolean.parseBoolean(envVariable);
      } else {
        throw new IllegalArgumentException(variableName + " should be either true or false.");
      }
    }
    return null;
  }

  private static Boolean getUseMultiplexedSessionForRWFromEnvVariable() {
    // Checks the value of env, GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS_FOR_RW
    // This returns null until RW is supported.
    return parseBooleanEnvVariable("GOOGLE_CLOUD_SPANNER_MULTIPLEXED_SESSIONS_FOR_RW");
  }

  Duration getMultiplexedSessionMaintenanceDuration() {
    return multiplexedSessionMaintenanceDuration;
  }

  @VisibleForTesting
  @InternalApi
  boolean getSkipVerifyBeginTransactionForMuxRW() {
    return skipVerifyingBeginTransactionForMuxRW;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  private enum ActionOnExhaustion {
    BLOCK,
    FAIL,
  }

  private enum ActionOnSessionNotFound {
    RETRY,
    FAIL
  }

  private enum ActionOnSessionLeak {
    WARN,
    FAIL
  }

  @VisibleForTesting
  enum ActionOnInactiveTransaction {
    WARN,
    WARN_AND_CLOSE,
    CLOSE
  }

  /** Configuration options for task to clean up inactive transactions. */
  static class InactiveTransactionRemovalOptions {

    /** Option to set the behaviour when there are inactive transactions. */
    private final ActionOnInactiveTransaction actionOnInactiveTransaction;

    /**
     * Frequency for closing inactive transactions. Between two consecutive task executions, it's
     * ensured that the duration is greater or equal to this duration.
     */
    private final Duration executionFrequency;

    /**
     * Long-running transactions will be cleaned up if utilisation is greater than the below value.
     */
    private final double usedSessionsRatioThreshold;

    /**
     * A transaction is considered to be idle if it has not been used for a duration greater than
     * the below value.
     */
    private final Duration idleTimeThreshold;

    InactiveTransactionRemovalOptions(final Builder builder) {
      this.actionOnInactiveTransaction = builder.actionOnInactiveTransaction;
      this.idleTimeThreshold = builder.idleTimeThreshold;
      this.executionFrequency = builder.executionFrequency;
      this.usedSessionsRatioThreshold = builder.usedSessionsRatioThreshold;
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof InactiveTransactionRemovalOptions)) {
        return false;
      }
      InactiveTransactionRemovalOptions other = (InactiveTransactionRemovalOptions) o;
      return Objects.equals(this.actionOnInactiveTransaction, other.actionOnInactiveTransaction)
          && Objects.equals(this.idleTimeThreshold, other.idleTimeThreshold)
          && Objects.equals(this.executionFrequency, other.executionFrequency)
          && Objects.equals(this.usedSessionsRatioThreshold, other.usedSessionsRatioThreshold);
    }

    @Override
    public int hashCode() {
      return Objects.hash(
          this.actionOnInactiveTransaction,
          this.idleTimeThreshold,
          this.executionFrequency,
          this.usedSessionsRatioThreshold);
    }

    Duration getExecutionFrequency() {
      return executionFrequency;
    }

    double getUsedSessionsRatioThreshold() {
      return usedSessionsRatioThreshold;
    }

    Duration getIdleTimeThreshold() {
      return idleTimeThreshold;
    }

    static InactiveTransactionRemovalOptions.Builder newBuilder() {
      return new Builder();
    }

    static class Builder {
      private ActionOnInactiveTransaction actionOnInactiveTransaction =
          ActionOnInactiveTransaction.WARN;
      private Duration executionFrequency = Duration.ofMinutes(2);
      private double usedSessionsRatioThreshold = 0.95;
      private Duration idleTimeThreshold = Duration.ofMinutes(60L);

      public Builder() {}

      InactiveTransactionRemovalOptions build() {
        validate();
        return new InactiveTransactionRemovalOptions(this);
      }

      private void validate() {
        Preconditions.checkArgument(
            executionFrequency.toMillis() > 0,
            "Execution frequency %s should be positive",
            executionFrequency.toMillis());
        Preconditions.checkArgument(
            idleTimeThreshold.toMillis() > 0,
            "Idle Time Threshold duration %s should be positive",
            idleTimeThreshold.toMillis());
      }

      @VisibleForTesting
      InactiveTransactionRemovalOptions.Builder setActionOnInactiveTransaction(
          final ActionOnInactiveTransaction actionOnInactiveTransaction) {
        this.actionOnInactiveTransaction = actionOnInactiveTransaction;
        return this;
      }

      @VisibleForTesting
      InactiveTransactionRemovalOptions.Builder setExecutionFrequency(
          final Duration executionFrequency) {
        this.executionFrequency = executionFrequency;
        return this;
      }

      @VisibleForTesting
      InactiveTransactionRemovalOptions.Builder setUsedSessionsRatioThreshold(
          final double usedSessionsRatioThreshold) {
        this.usedSessionsRatioThreshold = usedSessionsRatioThreshold;
        return this;
      }

      @VisibleForTesting
      InactiveTransactionRemovalOptions.Builder setIdleTimeThreshold(
          final Duration idleTimeThreshold) {
        this.idleTimeThreshold = idleTimeThreshold;
        return this;
      }
    }
  }

  /** Builder for creating SessionPoolOptions. */
  public static class Builder {
    private boolean minSessionsSet = false;
    private int minSessions = DEFAULT_MIN_SESSIONS;
    private int maxSessions = DEFAULT_MAX_SESSIONS;
    private int incStep = DEFAULT_INC_STEP;

    /** Set a higher value for {@link #minSessions} instead of using this field. */
    @Deprecated private int maxIdleSessions;

    /**
     * The session pool no longer prepares a fraction of the sessions with a read/write transaction.
     * This setting therefore does not have any meaning anymore, and may be removed in the future.
     */
    @Deprecated private float writeSessionsFraction = 0.2f;

    private ActionOnExhaustion actionOnExhaustion = DEFAULT_ACTION;
    private long initialWaitForSessionTimeoutMillis = 30_000L;
    private ActionOnSessionNotFound actionOnSessionNotFound = ActionOnSessionNotFound.RETRY;
    private ActionOnSessionLeak actionOnSessionLeak = ActionOnSessionLeak.WARN;

    /**
     * Capture the call stack of the thread that checked out a session of the pool. This will
     * pre-create a com.google.cloud.spanner.SessionPool.LeakedSessionException already when a
     * session is checked out. This can be disabled by users, for example if their monitoring
     * systems log the pre-created exception. If disabled, the
     * com.google.cloud.spanner.SessionPool.LeakedSessionException will only be created when an
     * actual session leak is detected. The stack trace of the exception will in that case not
     * contain the call stack of when the session was checked out.
     */
    private boolean trackStackTraceOfSessionCheckout = true;

    private InactiveTransactionRemovalOptions inactiveTransactionRemovalOptions =
        InactiveTransactionRemovalOptions.newBuilder().build();
    private long loopFrequency = 10 * 1000L;
    private Duration multiplexedSessionMaintenanceLoopFrequency = Duration.ofMinutes(10);
    private int keepAliveIntervalMinutes = 30;
    private Duration removeInactiveSessionAfter = Duration.ofMinutes(55L);
    private boolean autoDetectDialect = false;
    private Duration waitForMinSessions = Duration.ZERO;
    private Duration acquireSessionTimeout = Duration.ofSeconds(60);
    private final Position releaseToPosition = getReleaseToPositionFromSystemProperty();

    /**
     * The session pool will randomize the position of a session that is being returned when this
     * threshold is exceeded. That is: If the transactions per second exceeds this threshold, then
     * the session pool will use a random order for the sessions instead of LIFO. The default is 0,
     * which means that the option is disabled.
     */
    private long randomizePositionQPSThreshold = 0L;

    // This field controls the default behavior of session management in Java client.
    // Set useMultiplexedSession to true to make multiplexed session the default.
    private boolean useMultiplexedSession = true;

    // This field controls the default behavior of session management for RW operations in Java
    // client.
    // Set useMultiplexedSessionForRW to true to make multiplexed session for RW operations the
    // default.
    private boolean useMultiplexedSessionForRW = true;

    // This field controls the default behavior of session management for Partitioned operations in
    // Java client.
    // Set useMultiplexedSessionPartitionedOps to true to make multiplexed session for Partitioned
    // operations the default.
    private boolean useMultiplexedSessionPartitionedOps = true;

    private Duration multiplexedSessionMaintenanceDuration = Duration.ofDays(7);
    private Clock poolMaintainerClock = Clock.INSTANCE;
    private boolean skipVerifyingBeginTransactionForMuxRW = false;
    private boolean isExperimentalHost = false;

    private static Position getReleaseToPositionFromSystemProperty() {
      // NOTE: This System property is a beta feature. Support for it can be removed in the future.
      String key = "com.google.cloud.spanner.session_pool_release_to_position";
      if (System.getProperties().containsKey(key)) {
        try {
          return Position.valueOf(System.getProperty(key).toUpperCase(Locale.ENGLISH));
        } catch (Throwable ignore) {
          // fallthrough and return the default.
        }
      }
      return Position.FIRST;
    }

    public Builder() {}

    private Builder(SessionPoolOptions options) {
      this.minSessionsSet = true;
      this.minSessions = options.minSessions;
      this.maxSessions = options.maxSessions;
      this.incStep = options.incStep;
      this.maxIdleSessions = options.maxIdleSessions;
      this.writeSessionsFraction = options.writeSessionsFraction;
      this.actionOnExhaustion = options.actionOnExhaustion;
      this.initialWaitForSessionTimeoutMillis = options.initialWaitForSessionTimeoutMillis;
      this.actionOnSessionNotFound = options.actionOnSessionNotFound;
      this.actionOnSessionLeak = options.actionOnSessionLeak;
      this.trackStackTraceOfSessionCheckout = options.trackStackTraceOfSessionCheckout;
      this.loopFrequency = options.loopFrequency;
      this.multiplexedSessionMaintenanceLoopFrequency =
          options.multiplexedSessionMaintenanceLoopFrequency;
      this.keepAliveIntervalMinutes = options.keepAliveIntervalMinutes;
      this.removeInactiveSessionAfter = options.removeInactiveSessionAfter;
      this.autoDetectDialect = options.autoDetectDialect;
      this.waitForMinSessions = options.waitForMinSessions;
      this.acquireSessionTimeout = options.acquireSessionTimeout;
      this.randomizePositionQPSThreshold = options.randomizePositionQPSThreshold;
      this.inactiveTransactionRemovalOptions = options.inactiveTransactionRemovalOptions;
      this.useMultiplexedSession = options.useMultiplexedSession;
      this.useMultiplexedSessionForRW = options.useMultiplexedSessionForRW;
      this.useMultiplexedSessionPartitionedOps = options.useMultiplexedSessionForPartitionedOps;
      this.multiplexedSessionMaintenanceDuration = options.multiplexedSessionMaintenanceDuration;
      this.poolMaintainerClock = options.poolMaintainerClock;
      this.skipVerifyingBeginTransactionForMuxRW = options.skipVerifyingBeginTransactionForMuxRW;
    }

    /**
     * Minimum number of sessions that this pool will always maintain. These will be created eagerly
     * in parallel. Defaults to 100.
     */
    @Deprecated
    public Builder setMinSessions(int minSessions) {
      Preconditions.checkArgument(minSessions >= 0, "minSessions must be >= 0");
      this.minSessionsSet = true;
      this.minSessions = minSessions;
      return this;
    }

    /**
     * Maximum number of sessions that this pool will have. If current numbers of sessions in the
     * pool is less than this and they are all busy, then a new session will be created for any new
     * operation. If current number of in use sessions is same as this and a new request comes, pool
     * can either block or fail. Defaults to 400.
     */
    @Deprecated
    public Builder setMaxSessions(int maxSessions) {
      Preconditions.checkArgument(maxSessions > 0, "maxSessions must be > 0");
      this.maxSessions = maxSessions;
      return this;
    }

    /**
     * Number of sessions to batch create when the pool needs at least one more session. Defaults to
     * 25.
     */
    Builder setIncStep(int incStep) {
      Preconditions.checkArgument(incStep > 0, "incStep must be > 0");
      this.incStep = incStep;
      return this;
    }

    /**
     * Maximum number of idle sessions that this pool will maintain. Pool will close any sessions
     * beyond this but making sure to always have at least as many sessions as specified by {@link
     * #setMinSessions}. To determine how many sessions are idle we look at maximum number of
     * sessions used concurrently over a window of time. Any sessions beyond that are idle. Defaults
     * to 0.
     *
     * @deprecated set a higher value for {@link #setMinSessions(int)} instead of using this
     *     configuration option. This option will be removed in a future release.
     */
    @Deprecated
    public Builder setMaxIdleSessions(int maxIdleSessions) {
      this.maxIdleSessions = maxIdleSessions;
      return this;
    }

    Builder setLoopFrequency(long loopFrequency) {
      this.loopFrequency = loopFrequency;
      return this;
    }

    Builder setMultiplexedSessionMaintenanceLoopFrequency(Duration frequency) {
      this.multiplexedSessionMaintenanceLoopFrequency = frequency;
      return this;
    }

    Builder setInactiveTransactionRemovalOptions(
        InactiveTransactionRemovalOptions inactiveTransactionRemovalOptions) {
      this.inactiveTransactionRemovalOptions = inactiveTransactionRemovalOptions;
      return this;
    }

    /**
     * This method is obsolete. Use {@link #setRemoveInactiveSessionAfterDuration(Duration)}
     * instead.
     */
    @ObsoleteApi("Use setRemoveInactiveSessionAfterDuration(Duration) instead")
    @Deprecated
    public Builder setRemoveInactiveSessionAfter(org.threeten.bp.Duration duration) {
      return setRemoveInactiveSessionAfterDuration(toJavaTimeDuration(duration));
    }

    @Deprecated
    public Builder setRemoveInactiveSessionAfterDuration(Duration duration) {
      this.removeInactiveSessionAfter = duration;
      return this;
    }

    /**
     * How frequently to keep alive idle sessions. This should be less than 60 since an idle session
     * is automatically closed after 60 minutes. Sessions will be kept alive by sending a dummy
     * query "Select 1". Default value is 30 minutes.
     */
    @Deprecated
    public Builder setKeepAliveIntervalMinutes(int intervalMinutes) {
      this.keepAliveIntervalMinutes = intervalMinutes;
      return this;
    }

    /**
     * If all sessions are in use and {@code maxSessions} has been reached, fail the request by
     * throwing a {@link SpannerException} with the error code {@code RESOURCE_EXHAUSTED}. Default
     * behavior is to block the request.
     */
    @Deprecated
    public Builder setFailIfPoolExhausted() {
      this.actionOnExhaustion = ActionOnExhaustion.FAIL;
      return this;
    }

    /**
     * If all sessions are in use and there is no more room for creating new sessions, block for a
     * session to become available. Default behavior is same.
     *
     * <p>By default the requests are blocked for 60s and will fail with a `SpannerException` with
     * error code `ResourceExhausted` if this timeout is exceeded. If you wish to block for a
     * different period use the option {@link Builder#setAcquireSessionTimeoutDuration(Duration)}
     * ()}
     */
    @Deprecated
    public Builder setBlockIfPoolExhausted() {
      this.actionOnExhaustion = ActionOnExhaustion.BLOCK;
      return this;
    }

    /**
     * If there are inactive transactions, log warning messages with the origin of such transactions
     * to aid debugging. A transaction is classified as inactive if it executes for more than a
     * system defined duration.
     *
     * <p>This option won't change the state of the transactions. It only generates warning logs
     * that can be used for debugging.
     *
     * @return this builder for chaining
     */
    @Deprecated
    public Builder setWarnIfInactiveTransactions() {
      this.inactiveTransactionRemovalOptions =
          InactiveTransactionRemovalOptions.newBuilder()
              .setActionOnInactiveTransaction(ActionOnInactiveTransaction.WARN)
              .build();
      return this;
    }

    /**
     * If there are inactive transactions, release the resources consumed by such transactions. A
     * transaction is classified as inactive if it executes for more than a system defined duration.
     * The option would also produce necessary warning logs through which it can be debugged as to
     * what resources were released due to this option.
     *
     * <p>Use the option {@link Builder#setWarnIfInactiveTransactions()} if you only want to log
     * warnings about long-running transactions.
     *
     * @return this builder for chaining
     */
    @Deprecated
    public Builder setWarnAndCloseIfInactiveTransactions() {
      this.inactiveTransactionRemovalOptions =
          InactiveTransactionRemovalOptions.newBuilder()
              .setActionOnInactiveTransaction(ActionOnInactiveTransaction.WARN_AND_CLOSE)
              .build();
      return this;
    }

    @InternalApi
    public Builder setExperimentalHost() {
      this.isExperimentalHost = true;
      return this;
    }

    /**
     * If there are inactive transactions, release the resources consumed by such transactions. A
     * transaction is classified as inactive if it executes for more than a system defined duration.
     *
     * <p>Use the option {@link Builder#setWarnIfInactiveTransactions()} if you only want to log
     * warnings about long-running sessions.
     *
     * <p>Use the option {@link Builder#setWarnAndCloseIfInactiveTransactions()} if you want to log
     * warnings along with closing the long-running transactions.
     *
     * @return this builder for chaining
     */
    @VisibleForTesting
    Builder setCloseIfInactiveTransactions() {
      this.inactiveTransactionRemovalOptions =
          InactiveTransactionRemovalOptions.newBuilder()
              .setActionOnInactiveTransaction(ActionOnInactiveTransaction.CLOSE)
              .build();
      return this;
    }

    @VisibleForTesting
    Builder setPoolMaintainerClock(Clock poolMaintainerClock) {
      this.poolMaintainerClock = Preconditions.checkNotNull(poolMaintainerClock);
      return this;
    }

    /**
     * Sets whether the client should use multiplexed session or not. If set to true, the client
     * optimises and runs multiple applicable requests concurrently on a single session. A single
     * multiplexed session is sufficient to handle all concurrent traffic.
     *
     * <p>When set to false, the client uses the regular session cached in the session pool for
     * running 1 concurrent transaction per session. We require to provision sufficient sessions by
     * making use of {@link SessionPoolOptions#minSessions} and {@link
     * SessionPoolOptions#maxSessions} based on the traffic load. Failing to do so will result in
     * higher latencies.
     */
    Builder setUseMultiplexedSession(boolean useMultiplexedSession) {
      this.useMultiplexedSession = useMultiplexedSession;
      return this;
    }

    /**
     * Sets whether the client should use multiplexed session for R/W operations or not. This method
     * is intentionally package-private and intended for internal use.
     */
    @InternalApi
    @VisibleForTesting
    Builder setUseMultiplexedSessionForRW(boolean useMultiplexedSessionForRW) {
      this.useMultiplexedSessionForRW = useMultiplexedSessionForRW;
      return this;
    }

    /**
     * Sets whether the client should use multiplexed session for Partitioned operations or not.
     * This method is intentionally package-private and intended for internal use.
     */
    Builder setUseMultiplexedSessionPartitionedOps(boolean useMultiplexedSessionPartitionedOps) {
      this.useMultiplexedSessionPartitionedOps = useMultiplexedSessionPartitionedOps;
      return this;
    }

    @VisibleForTesting
    Builder setMultiplexedSessionMaintenanceDuration(
        Duration multiplexedSessionMaintenanceDuration) {
      this.multiplexedSessionMaintenanceDuration = multiplexedSessionMaintenanceDuration;
      return this;
    }

    // The additional BeginTransaction RPC for multiplexed session read-write is causing
    // unexpected behavior in mock Spanner tests that rely on mocking the BeginTransaction RPC.
    // Invoking this method with `true` skips sending the BeginTransaction RPC when the multiplexed
    // session is created for the first time during client initialization.
    // This is only used for tests.
    @VisibleForTesting
    Builder setSkipVerifyingBeginTransactionForMuxRW(
        boolean skipVerifyingBeginTransactionForMuxRW) {
      this.skipVerifyingBeginTransactionForMuxRW = skipVerifyingBeginTransactionForMuxRW;
      return this;
    }

    /**
     * Sets whether the client should automatically execute a background query to detect the dialect
     * that is used by the database or not. Set this option to true if you do not know what the
     * dialect of the database will be.
     *
     * <p>Note that you can always call {@link DatabaseClient#getDialect()} to get the dialect of a
     * database regardless of this setting, but by setting this to true, the value will be
     * pre-populated and cached in the client.
     *
     * @param autoDetectDialect Whether the client should automatically execute a background query
     *     to detect the dialect of the underlying database
     * @return this builder for chaining
     */
    public Builder setAutoDetectDialect(boolean autoDetectDialect) {
      this.autoDetectDialect = autoDetectDialect;
      return this;
    }

    /**
     * The initial number of milliseconds to wait for a session to become available when one is
     * requested. The session pool will keep retrying to get a session, and the timeout will be
     * doubled for each new attempt. The default is 30 seconds.
     */
    @VisibleForTesting
    Builder setInitialWaitForSessionTimeoutMillis(long timeout) {
      this.initialWaitForSessionTimeoutMillis = timeout;
      return this;
    }

    /**
     * If a session has been invalidated by the server, the SessionPool will by default retry the
     * session. Set this option to throw an exception instead of retrying.
     */
    @VisibleForTesting
    Builder setFailIfSessionNotFound() {
      this.actionOnSessionNotFound = ActionOnSessionNotFound.FAIL;
      return this;
    }

    @VisibleForTesting
    Builder setFailOnSessionLeak() {
      this.actionOnSessionLeak = ActionOnSessionLeak.FAIL;
      return this;
    }

    /**
     * Sets whether the session pool should capture the call stack trace when a session is checked
     * out of the pool. This will internally prepare a
     * com.google.cloud.spanner.SessionPool.LeakedSessionException that will only be thrown if the
     * session is actually leaked. This makes it easier to debug session leaks, as the stack trace
     * of the thread that checked out the session will be available in the exception.
     *
     * <p>Some monitoring tools might log these exceptions even though they are not thrown. This
     * option can be used to suppress the creation and logging of these exceptions.
     */
    @Deprecated
    public Builder setTrackStackTraceOfSessionCheckout(boolean trackStackTraceOfSessionCheckout) {
      this.trackStackTraceOfSessionCheckout = trackStackTraceOfSessionCheckout;
      return this;
    }

    /**
     * @deprecated This configuration value is no longer in use. The session pool does not prepare
     *     any sessions for read/write transactions. Instead, a transaction will automatically be
     *     started by the first statement that is executed by a transaction by including a
     *     BeginTransaction option with that statement.
     *     <p>This method may be removed in a future release.
     */
    @Deprecated
    public Builder setWriteSessionsFraction(float writeSessionsFraction) {
      this.writeSessionsFraction = writeSessionsFraction;
      return this;
    }

    /** This method is obsolete. Use {@link #setWaitForMinSessionsDuration(Duration)} instead. */
    @ObsoleteApi("Use setWaitForMinSessionsDuration(Duration) instead")
    public Builder setWaitForMinSessions(org.threeten.bp.Duration waitForMinSessions) {
      return setWaitForMinSessionsDuration(toJavaTimeDuration(waitForMinSessions));
    }

    /**
     * If greater than zero, waits for the session pool to have at least {@link
     * SessionPoolOptions#minSessions} before returning the database client to the caller. Note that
     * this check is only done during the session pool creation. This is usually done asynchronously
     * in order to provide the client back to the caller as soon as possible. We don't recommend
     * using this option unless you are executing benchmarks and want to guarantee the session pool
     * has min sessions in the pool before continuing.
     *
     * <p>Defaults to zero (initialization is done asynchronously).
     */
    public Builder setWaitForMinSessionsDuration(Duration waitForMinSessions) {
      this.waitForMinSessions = waitForMinSessions;
      return this;
    }

    /** This method is obsolete. Use {@link #setAcquireSessionTimeoutDuration(Duration)} instead. */
    @ObsoleteApi("Use setAcquireSessionTimeoutDuration(Duration) instead")
    @Deprecated
    public Builder setAcquireSessionTimeout(org.threeten.bp.Duration acquireSessionTimeout) {
      return setAcquireSessionTimeoutDuration(toJavaTimeDuration(acquireSessionTimeout));
    }

    /**
     * If greater than zero, we wait for said duration when no sessions are available in the
     * SessionPool. The default is a 60s timeout. Set the value to null to disable the timeout.
     */
    @Deprecated
    public Builder setAcquireSessionTimeoutDuration(Duration acquireSessionTimeout) {
      try {
        if (acquireSessionTimeout != null) {
          Preconditions.checkArgument(
              acquireSessionTimeout.toMillis() > 0,
              "acquireSessionTimeout should be greater than 0 ns");
        }
      } catch (ArithmeticException ex) {
        throw new IllegalArgumentException(
            "acquireSessionTimeout in millis should be lesser than Long.MAX_VALUE");
      }
      this.acquireSessionTimeout = acquireSessionTimeout;
      return this;
    }

    Builder setRandomizePositionQPSThreshold(long randomizePositionQPSThreshold) {
      Preconditions.checkArgument(
          randomizePositionQPSThreshold >= 0L, "randomizePositionQPSThreshold must be >= 0");
      this.randomizePositionQPSThreshold = randomizePositionQPSThreshold;
      return this;
    }

    /** Build a SessionPoolOption object */
    public SessionPoolOptions build() {
      validate();
      return new SessionPoolOptions(this);
    }

    private void validate() {
      if (minSessionsSet) {
        Preconditions.checkArgument(
            maxSessions >= minSessions,
            "Min sessions(%s) must be <= max sessions(%s)",
            minSessions,
            maxSessions);
      }
      Preconditions.checkArgument(
          keepAliveIntervalMinutes < 60, "Keep alive interval should be less than" + "60 minutes");
    }
  }
}
