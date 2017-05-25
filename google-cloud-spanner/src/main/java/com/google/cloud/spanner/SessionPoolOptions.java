/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import com.google.common.base.Preconditions;

/** Options for the session pool used by {@code DatabaseClient}. */
public class SessionPoolOptions {
  private final int minSessions;
  private final int maxSessions;
  private final int maxIdleSessions;
  private final float writeSessionsFraction;
  private final ActionOnExhaustion actionOnExhaustion;
  private final int keepAliveIntervalMinutes;

  private SessionPoolOptions(Builder builder) {
    this.minSessions = builder.minSessions;
    this.maxSessions = builder.maxSessions;
    this.maxIdleSessions = builder.maxIdleSessions;
    this.writeSessionsFraction = builder.writeSessionsFraction;
    this.actionOnExhaustion = builder.actionOnExhaustion;
    this.keepAliveIntervalMinutes = builder.keepAliveIntervalMinutes;
  }

  public int getMinSessions() {
    return minSessions;
  }

  public int getMaxSessions() {
    return maxSessions;
  }

  public int getMaxIdleSessions() {
    return maxIdleSessions;
  }

  public float getWriteSessionsFraction() {
    return writeSessionsFraction;
  }

  public int getKeepAliveIntervalMinutes() {
    return keepAliveIntervalMinutes;
  }

  public boolean isFailIfPoolExhausted() {
    return actionOnExhaustion == ActionOnExhaustion.FAIL;
  }

  public boolean isBlockIfPoolExhausted() {
    return actionOnExhaustion == ActionOnExhaustion.BLOCK;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  private static enum ActionOnExhaustion {
    BLOCK,
    FAIL,
  }

  /** Builder for creating SessionPoolOptions. */
  public static class Builder {
    private int minSessions;
    private int maxSessions = Integer.MAX_VALUE;
    private int maxIdleSessions;
    private float writeSessionsFraction = 0.2f;
    private ActionOnExhaustion actionOnExhaustion = ActionOnExhaustion.BLOCK;
    private int keepAliveIntervalMinutes = 30;

    /**
     * Minimum number of sessions that this pool will always maintain. These will be created eagerly
     * in parallel. Defaults to 0.
     */
    public Builder setMinSessions(int minSessions) {
      Preconditions.checkArgument(
          maxSessions >= minSessions, "Min sessions must be <= max sessions");
      this.minSessions = minSessions;
      return this;
    }

    /**
     * Maximum number of sessions that this pool will have. If current numbers of sessions in the
     * pool is less than this and they are all busy, then a new session will be created for any new
     * operation. If current number of in use sessions is same as this and a new request comes, pool
     * can either block or fail. Defaults to unlimited.
     */
    public Builder setMaxSessions(int maxSessions) {
      Preconditions.checkArgument(
          maxSessions >= minSessions, "Max sessions must be >= min" + "sessions");
      this.maxSessions = maxSessions;
      return this;
    }

    /**
     * Maximum number of idle sessions that this pool will maintain. Pool will close any sessions
     * beyond this but making sure to always have at least as many sessions as specified by {@link
     * #setMinSessions}. To determine how many sessions are idle we look at maximum number of
     * sessions used concurrently over a window of time. Any sessions beyond that are idle. Defaults
     * to 0.
     */
    public Builder setMaxIdleSessions(int maxIdleSessions) {
      this.maxIdleSessions = maxIdleSessions;
      return this;
    }

    /**
     * How frequently to keep alive idle sessions. This should be less than 60 since an idle session
     * is automatically closed after 60 minutes. Sessions will be kept alive by sending a dummy
     * query "Select 1". Default value is 30 minutes.
     */
    public Builder setKeepAliveIntervalMinutes(int intervalMinutes) {
      Preconditions.checkArgument(
          intervalMinutes < 60, "Keep alive interval should be less than" + "60 minutes");
      this.keepAliveIntervalMinutes = intervalMinutes;
      return this;
    }

    /**
     * If all sessions are in use and and {@code maxSessions} has been reached, fail the request by
     * throwing a {@link SpannerException} with the error code {@code RESOURCE_EXHAUSTED}. Default
     * behavior is to block for a session to become available.
     */
    public Builder setFailIfPoolExhausted() {
      this.actionOnExhaustion = ActionOnExhaustion.FAIL;
      return this;
    }

    /**
     * If all sessions are in use and there is no more room for creating new sessions, block for a
     * session to become available. Default behavior is same.
     */
    public Builder setBlockIfPoolExhausted() {
      this.actionOnExhaustion = ActionOnExhaustion.BLOCK;
      return this;
    }

    /**
     * Fraction of sessions to be kept prepared for write transactions. This is an optimisation to
     * avoid the cost of sending a BeginTransaction() rpc. If all such sessions are in use and a
     * write request comes, we will make the BeginTransaction() rpc inline. It must be between 0 and
     * 1(inclusive).
     *
     * <p>Default value is 0.2.
     */
    public Builder setWriteSessionsFraction(float writeSessionsFraction) {
      Preconditions.checkArgument(
          writeSessionsFraction >= 0 && writeSessionsFraction <= 1,
          "Fraction of write sessions must be between 0 and 1 (inclusive)");
      this.writeSessionsFraction = writeSessionsFraction;
      return this;
    }

    /** Build a SessionPoolOption object */
    public SessionPoolOptions build() {
      return new SessionPoolOptions(this);
    }
  }
}
