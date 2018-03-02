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

package com.example.loggingtransformers;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Payload;
import com.google.cloud.logging.logback.ILoggingEventTransformer;
import com.google.cloud.logging.logback.LoggingEventTransformerUtils;
import com.google.common.collect.ImmutableMap;

/**
 * Example Logging Transformer that sets a jsonPayload instead of a string payload.
 */
public final class TestJsonPayloadTransformer implements ILoggingEventTransformer {
  @Override
  public LogEntry.Builder logEntryBuilderFor(final ILoggingEvent e) {

    final ImmutableMap<String, String> payload = new ImmutableMap.Builder<String, String>()
        .put("loggerName", e.getLoggerName())
        .put("message", e.getMessage())
        .build();
    final Payload.JsonPayload entryPayload = Payload.JsonPayload.of(payload);
    final LogEntry.Builder builder = LogEntry.newBuilder(entryPayload);
    LoggingEventTransformerUtils.addCommonLogMetadata(builder, e);
    return builder;
  }
}
