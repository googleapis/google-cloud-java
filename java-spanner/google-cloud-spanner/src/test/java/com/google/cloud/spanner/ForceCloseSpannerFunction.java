/*
 * Copyright 2021 Google LLC
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

import com.google.common.base.Function;
import java.util.concurrent.TimeUnit;

/** Class for tests that need to be able to force-close a {@link Spanner} instance. */
public class ForceCloseSpannerFunction implements Function<Spanner, Void> {
  private final long timeout;
  private final TimeUnit unit;

  public ForceCloseSpannerFunction(long timeout, TimeUnit unit) {
    this.timeout = timeout;
    this.unit = unit;
  }

  public Void apply(Spanner spanner) {
    if (spanner instanceof SpannerImpl) {
      ((SpannerImpl) spanner).close(timeout, unit);
    } else {
      spanner.close();
    }
    return null;
  }
}
