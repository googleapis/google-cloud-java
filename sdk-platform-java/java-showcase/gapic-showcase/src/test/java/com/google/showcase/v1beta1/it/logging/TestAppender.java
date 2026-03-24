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

package com.google.showcase.v1beta1.it.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import java.util.ArrayList;
import java.util.List;

/** Logback appender used to set up tests. */
public class TestAppender extends AppenderBase<ILoggingEvent> {
  public List<ILoggingEvent> events = new ArrayList<>();

  @Override
  protected void append(ILoggingEvent eventObject) {
    // triggering Logback to capture the current MDC context and store it with the log event
    // the default ListAppender does not capture MDC contents
    eventObject.getMDCPropertyMap();

    events.add(eventObject);
  }

  public void clearEvents() {
    events.clear();
  }
}
