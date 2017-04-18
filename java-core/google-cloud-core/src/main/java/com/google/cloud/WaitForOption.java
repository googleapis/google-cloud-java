/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.core.BetaApi;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * This class represents options for methods that wait for changes in the status of a resource.
 */
@BetaApi
public abstract class WaitForOption implements Serializable {

  private static final long serialVersionUID = 8443451708032349243L;

  private final OptionType optionType;

  enum OptionType {
    CHECKING_PERIOD,
    TIMEOUT
  }

  private WaitForOption(OptionType optionType) {
    this.optionType = optionType;
  }

  /**
   * This class represents an option to set how frequently the resource status should be checked.
   * Objects of this class keep the actual period and related time unit for the checking period.
   */
  public static final class CheckingPeriod extends WaitForOption {

    private static final long serialVersionUID = -2481062893220539210L;
    private static final CheckingPeriod DEFAULT = new CheckingPeriod(500, TimeUnit.MILLISECONDS);

    private final long period;
    private final TimeUnit unit;

    private CheckingPeriod(long period, TimeUnit unit) {
      super(OptionType.CHECKING_PERIOD);
      this.period = period;
      this.unit = unit;
    }


    /**
     * Returns the checking period.
     */
    public long getPeriod() {
      return period;
    }


    /**
     * Returns the time unit for {@link #getPeriod()}.
     */
    public TimeUnit getUnit() {
      return unit;
    }

    /**
     * Blocks the current thread for the amount of time specified by this object.
     *
     * @throws InterruptedException if the current thread was interrupted
     */
    public void sleep() throws InterruptedException {
      unit.sleep(period);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (obj == null || !(obj instanceof CheckingPeriod)) {
        return false;
      }
      CheckingPeriod other = (CheckingPeriod) obj;
      return baseEquals(other)
          && Objects.equals(period, other.period)
          && Objects.equals(unit, other.unit);
    }

    @Override
    public int hashCode() {
      return Objects.hash(baseHashCode(), period, unit);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("period", period)
          .add("unit", unit)
          .toString();
    }

    /**
     * Returns the {@code CheckingPeriod} option specified in {@code options}. If no
     * {@code CheckingPeriod} could be found among {@code options}, the default checking period (500
     * milliseconds) is used.
     */
    public static CheckingPeriod getOrDefault(WaitForOption... options) {
      return getOrDefaultInternal(OptionType.CHECKING_PERIOD, DEFAULT, options);
    }
  }

  /**
   * This class represents an option to set the maximum time to wait for the resource's status to
   * reach the desired state.
   */
  public static final class Timeout extends WaitForOption {

    private static final long serialVersionUID = -7120401111985321932L;
    private static final Timeout DEFAULT = new Timeout(-1);

    private final long timeoutMillis;

    private Timeout(long timeoutMillis) {
      super(OptionType.TIMEOUT);
      this.timeoutMillis = timeoutMillis;
    }


    /**
     * Returns the timeout in milliseconds.
     */
    public long getTimeoutMillis() {
      return timeoutMillis;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (obj == null || !(obj instanceof Timeout)) {
        return false;
      }
      Timeout other = (Timeout) obj;
      return baseEquals(other) && Objects.equals(timeoutMillis, other.timeoutMillis);
    }

    @Override
    public int hashCode() {
      return Objects.hash(baseHashCode(), timeoutMillis);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("timeoutMillis", timeoutMillis)
          .toString();
    }

    /**
     * Returns the {@code Timeout} option specified in {@code options}. If no {@code Timeout} could
     * be found among {@code options}, no timeout will be used.
     */
    public static Timeout getOrDefault(WaitForOption... options) {
      return getOrDefaultInternal(OptionType.TIMEOUT, DEFAULT, options);
    }
  }

  OptionType getOptionType() {
    return optionType;
  }

  final boolean baseEquals(WaitForOption option) {
    return Objects.equals(option.optionType, option.optionType);
  }

  final int baseHashCode() {
    return Objects.hash(optionType);
  }

  @SuppressWarnings("unchecked")
  private static <T extends WaitForOption> T getOrDefaultInternal(OptionType optionType,
      T defaultValue, WaitForOption... options) {
    T foundOption = null;
    for (WaitForOption option : options) {
      if (option.optionType.equals(optionType)) {
        checkArgument(foundOption == null, "Duplicate option %s", option);
        foundOption = (T) option;
      }
    }
    return foundOption != null ? foundOption : defaultValue;
  }

  /**
   * Returns an option to set how frequently the resource status should be checked.
   *
   * @param checkEvery the checking period
   * @param unit the time unit of the checking period
   */
  public static CheckingPeriod checkEvery(long checkEvery, TimeUnit unit) {
    checkArgument(checkEvery >= 0, "checkEvery must be >= 0");
    return new CheckingPeriod(checkEvery, unit);
  }

  /**
   * Returns an option to set the maximum time to wait.
   *
   * @param timeout the maximum time to wait, expressed in {@code unit}
   * @param unit the time unit of the timeout
   */
  public static Timeout timeout(long timeout, TimeUnit unit) {
    checkArgument(timeout >= 0, "timeout must be >= 0");
    return new Timeout(unit.toMillis(timeout));
  }
}
