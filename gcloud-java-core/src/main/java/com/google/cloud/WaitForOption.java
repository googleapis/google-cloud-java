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

import static com.google.cloud.WaitForOption.Option.CHECKING_PERIOD;
import static com.google.cloud.WaitForOption.Option.TIMEOUT;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * This class represents options for methods that wait for changes in the status of a resource.
 */
public final class WaitForOption implements Serializable {

  private static final long serialVersionUID = 8443451708032349243L;

  private final Option option;
  private final Object value;

  /**
   * This class holds the actual period and related time unit for the checking period.
   */
  public static final class CheckingPeriod implements Serializable {

    private static final long serialVersionUID = -2481062893220539210L;

    private final long period;
    private final TimeUnit unit;

    private CheckingPeriod(long period, TimeUnit unit) {
      this.period = period;
      this.unit = unit;
    }

    /**
     * Returns the checking period.
     */
    public long period() {
      return period;
    }

    /**
     * Returns the time unit for {@link #period()}.
     */
    public TimeUnit unit() {
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
      return Objects.equals(period, other.period) && Objects.equals(unit, other.unit);
    }

    @Override
    public int hashCode() {
      return Objects.hash(period, unit);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("period", period)
          .add("unit", unit)
          .toString();
    }

    /**
     * Returns the default checking period (500 milliseconds).
     */
    public static CheckingPeriod defaultInstance() {
      return new CheckingPeriod(500, TimeUnit.MILLISECONDS);
    }
  }

  public enum Option {
    CHECKING_PERIOD,
    TIMEOUT;

    @SuppressWarnings("unchecked")
    <T> T get(Map<Option, ?> options) {
      return (T) options.get(this);
    }

    public Long getLong(Map<Option, ?> options) {
      return get(options);
    }

    public CheckingPeriod getCheckingPeriod(Map<Option, ?> options) {
      return get(options);
    }
  }

  private WaitForOption(Option option, Object value) {
    this.option = option;
    this.value = value;
  }

  /**
   * Returns the option's type.
   */
  public Option option() {
    return option;
  }

  /**
   * Returns the option's value.
   */
  public Object value() {
    return value;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !(obj instanceof WaitForOption)) {
      return false;
    }
    WaitForOption other = (WaitForOption) obj;
    return Objects.equals(option, other.option) && Objects.equals(value, other.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(option, value);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", option.name().toLowerCase())
        .add("value", value)
        .toString();
  }

  /**
   * Returns an option to set how frequently the resource status should be checked.
   *
   * @param checkEvery the checking period
   * @param unit the time unit of the checking period
   */
  public static WaitForOption checkEvery(long checkEvery, TimeUnit unit) {
    checkArgument(checkEvery >= 0, "checkEvery must be >= 0");
    return new WaitForOption(CHECKING_PERIOD, new CheckingPeriod(checkEvery, unit));
  }

  /**
   * Returns an option to set the maximum time to wait.
   *
   * @param timeout the maximum time to wait, expressed in {@code unit}
   * @param unit the time unit of the timeout
   */
  public static WaitForOption timeout(long timeout, TimeUnit unit) {
    checkArgument(timeout >= 0, "timeout must be >= 0");
    return new WaitForOption(TIMEOUT, TimeUnit.MILLISECONDS.convert(timeout, unit));
  }

  public static Map<Option, Object> asMap(WaitForOption... options) {
    Map<Option, Object> optionMap = Maps.newEnumMap(Option.class);
    for (WaitForOption waitOption : options) {
      Object prev = optionMap.put(waitOption.option(), waitOption.value());
      checkArgument(prev == null, "Duplicate option %s", waitOption);
    }
    return optionMap;
  }
}
