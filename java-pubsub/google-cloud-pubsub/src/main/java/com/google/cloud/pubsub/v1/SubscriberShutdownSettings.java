/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.pubsub.v1;

import com.google.common.base.Preconditions;
import java.time.Duration;

/**
 * Settings for configuring the shutdown behavior of a {@link Subscriber}.
 *
 * <p>This class allows customization of how the subscriber handles outstanding messages during
 * shutdown, including whether to wait for processing to complete or to immediately nack messages,
 * and an optional timeout for the shutdown process.
 */
public final class SubscriberShutdownSettings {

  /** Defines the behavior for handling outstanding messages during subscriber shutdown. */
  public enum ShutdownMode {
    /**
     * The subscriber will wait for all outstanding messages to be processed (acked or nacked by the
     * user's message receiver) before completing the shutdown.
     */
    WAIT_FOR_PROCESSING,
    /**
     * The subscriber will immediately nack all outstanding messages and attempt to shut down as
     * quickly as possible. Messages delivered to the user callback but not yet acked/nacked will
     * also be nacked.
     */
    NACK_IMMEDIATELY
  }

  private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(-1); // Indicates no timeout
  private static final ShutdownMode DEFAULT_MODE = ShutdownMode.WAIT_FOR_PROCESSING;

  private final ShutdownMode mode;
  private final Duration timeout;

  private SubscriberShutdownSettings(Builder builder) {
    this.mode = builder.mode;
    this.timeout = builder.timeout;
  }

  /** Returns the configured shutdown mode. */
  public ShutdownMode getMode() {
    return mode;
  }

  /** Returns the configured shutdown timeout. A negative duration indicates no timeout. */
  public Duration getTimeout() {
    return timeout;
  }

  /** Returns a new builder for {@code SubscriberShutdownSettings}. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Builder for {@code SubscriberShutdownSettings}. */
  public static final class Builder {
    private ShutdownMode mode = DEFAULT_MODE;
    private Duration timeout = DEFAULT_TIMEOUT;

    private Builder() {}

    /** Sets the shutdown mode. Defaults to {@link ShutdownMode#WAIT_FOR_PROCESSING}. */
    public Builder setMode(ShutdownMode mode) {
      this.mode = Preconditions.checkNotNull(mode);
      return this;
    }

    /**
     * Sets the shutdown timeout. Defaults to a negative duration, indicating no timeout.
     *
     * <p>A positive duration specifies the maximum time to wait for shutdown to complete. A
     * duration of zero indicates an immediate, forceful shutdown. A negative duration indicates an
     * indefinite wait.
     */
    public Builder setTimeout(Duration timeout) {
      this.timeout = Preconditions.checkNotNull(timeout);
      return this;
    }

    /** Builds an instance of {@code SubscriberShutdownSettings}. */
    public SubscriberShutdownSettings build() {
      return new SubscriberShutdownSettings(this);
    }
  }
}
