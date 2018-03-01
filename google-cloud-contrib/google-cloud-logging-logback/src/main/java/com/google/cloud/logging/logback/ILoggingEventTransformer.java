/*
 * Copyright 2018 Google LLC
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

package com.google.cloud.logging.logback;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.google.cloud.logging.LogEntry;

/**
 * Interface to customize how an {@link ILoggingEvent} (from the Logback)
 * are transformed into a {@link LogEntry} used by Google Stackdriver Logging.
 *
 * <p>This is distinct from a {@link com.google.cloud.logging.LoggingEnhancer}
 * because this has access to the original logging event. (Enhancers do not.)
 *
 * <p>See {@link LoggingEventTransformerUtils} for boilerplate code useful when writing these.
 *
 */
public interface ILoggingEventTransformer {
  /**
   * Create a LogEntry.Builder from a ILoggingEvent.
   *
   * <p>The returned builder may be modified further by
   * {@link com.google.cloud.logging.LoggingEnhancer}s in an appender.
   *
   * @param e The original logging event from Logback
   * @return A LogEntry.Builder with at least payload and standard metadata set
   */
  LogEntry.Builder logEntryBuilderFor(ILoggingEvent e);
}

