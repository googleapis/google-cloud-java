/*
 * Copyright 2016 Google LLC
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

package com.google.cloud;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.BetaApi;
import java.io.Serializable;
import org.threeten.bp.Duration;
import com.google.api.gax.retrying.RetrySettings;

/**
 * This class represents an options wrapper around the {@link RetrySettings} class and is an
 * alternative way of initializing it. The retry options are usually provided in a form of varargs
 * for methods that wait for changes in the status of a resource, do poll operations or retry on
 * failures.
 */
@BetaApi
public class RetryOption implements Serializable {

  private static final long serialVersionUID = 3622837212525370224L;

  private enum OptionType {
    TOTAL_TIMEOUT,
    INITIAL_RETRY_DELAY,
    RETRY_DELAY_MULTIPLIER,
    MAX_RETRY_DELAY,
    MAX_ATTEMPTS,
    JITTERED
  }

  private final OptionType type;
  private final Object value;

  private RetryOption(OptionType type, Object value) {
    this.type = checkNotNull(type);
    this.value = checkNotNull(value);
  }

  /** See {@link RetrySettings#getTotalTimeout()}. */
  public static RetryOption totalTimeout(Duration totalTimeout) {
    return new RetryOption(OptionType.TOTAL_TIMEOUT, totalTimeout);
  }

  /** See {@link RetrySettings#getInitialRetryDelay()}. */
  public static RetryOption initialRetryDelay(Duration initialRetryDelay) {
    return new RetryOption(OptionType.INITIAL_RETRY_DELAY, initialRetryDelay);
  }

  /** See {@link RetrySettings#getRetryDelayMultiplier()}. */
  public static RetryOption retryDelayMultiplier(double retryDelayMultiplier) {
    return new RetryOption(OptionType.RETRY_DELAY_MULTIPLIER, retryDelayMultiplier);
  }

  /** See {@link RetrySettings#getMaxRetryDelay()}. */
  public static RetryOption maxRetryDelay(Duration maxRetryDelay) {
    return new RetryOption(OptionType.MAX_RETRY_DELAY, maxRetryDelay);
  }

  /** See {@link RetrySettings#getMaxAttempts()}. */
  public static RetryOption maxAttempts(int maxAttempts) {
    return new RetryOption(OptionType.MAX_ATTEMPTS, maxAttempts);
  }

  /** See {@link RetrySettings#isJittered()} ()}. */
  public static RetryOption jittered(boolean jittered) {
    return new RetryOption(OptionType.JITTERED, jittered);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    RetryOption that = (RetryOption) o;

    if (type != that.type) {
      return false;
    }
    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    int result = type.hashCode();
    result = 31 * result + value.hashCode();
    return result;
  }

  /**
   * Creates a new {@code RetrySettings} instance, merging provided settings and multiple {@code
   * RetryOptions}, each of which represents a single property in {@code RetrySettings}. It is an
   * alternative way of initializing {@link RetrySettings} instances.
   *
   * @param settings retry settings
   * @param options zero or more Retry
   * @return new {@code RetrySettings} instance, which is a result of merging {@code options} into
   *     {@code settings}, i.e. each element in {@code options}, if present, overrides corresponding
   *     property in {@code settings}
   */
  public static RetrySettings mergeToSettings(RetrySettings settings, RetryOption... options) {
    if (options.length <= 0) {
      return settings;
    }
    RetrySettings.Builder builder = settings.toBuilder();
    for (RetryOption option : options) {
      switch (option.type) {
        case TOTAL_TIMEOUT:
          builder.setTotalTimeout((Duration) option.value);
          break;
        case INITIAL_RETRY_DELAY:
          builder.setInitialRetryDelay((Duration) option.value);
          break;
        case RETRY_DELAY_MULTIPLIER:
          builder.setRetryDelayMultiplier((Double) option.value);
          break;
        case MAX_RETRY_DELAY:
          builder.setMaxRetryDelay((Duration) option.value);
          break;
        case MAX_ATTEMPTS:
          builder.setMaxAttempts((Integer) option.value);
          break;
        case JITTERED:
          builder.setJittered((Boolean) option.value);
          break;
        default:
          throw new IllegalArgumentException("Unknown option type: " + option.type);
      }
    }
    return builder.build();
  }
}
