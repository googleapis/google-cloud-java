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
import com.google.cloud.logging.Payload;

/**
 * Simple LoggingEvent transformer which logs message and stacktraces as a {@link LogEntry} with a
 * stringPayload.
 */
public final class StringPayloadTransformer implements ILoggingEventTransformer {
  @Override
  public LogEntry.Builder logEntryBuilderFor(final ILoggingEvent e) {
    final StringBuilder payload = new StringBuilder(e.getFormattedMessage()).append('\n');
    LoggingEventTransformerUtils.writeStack(e.getThrowableProxy(), "", payload);

    final Payload.StringPayload entryPayload = Payload.StringPayload.of(payload.toString().trim());
    final LogEntry.Builder builder = LogEntry.newBuilder(entryPayload);
    LoggingEventTransformerUtils.addCommonLogMetadata(builder, e);
    return builder;
  }
}
