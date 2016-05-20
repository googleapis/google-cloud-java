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

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * A class providing access to the current time in milliseconds. This class is mainly used for
 * testing and will be replaced by Java8's {@code java.time.Clock}.
 *
 * <p>Implementations should implement {@code Serializable} wherever possible and must document
 * whether or not they do support serialization.
 */
public abstract class Clock {

  private static final Clock DEFAULT_TIME_SOURCE = new DefaultClock();

  /**
   * Returns current time in milliseconds according to this clock.
   */
  public abstract long millis();

  /**
   * Returns the default clock. Default clock uses {@link System#currentTimeMillis()} to get time
   * in milliseconds.
   */
  public static Clock defaultClock() {
    return DEFAULT_TIME_SOURCE;
  }

  private static class DefaultClock extends Clock implements Serializable {

    private static final long serialVersionUID = -5077300394286703864L;

    @Override
    public long millis() {
      return System.currentTimeMillis();
    }

    private Object readResolve() throws ObjectStreamException {
      return DEFAULT_TIME_SOURCE;
    }
  }
}
