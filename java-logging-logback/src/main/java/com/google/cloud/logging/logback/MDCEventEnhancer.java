/*
 * Copyright 2019 Google LLC
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
import java.util.Map;

/**
 * MDCEventEnhancer takes values found in the MDC property map and adds them as labels to the {@link
 * LogEntry}. This {@link LoggingEventEnhancer} is turned on by default. If you wish to filter which
 * MDC values get added as labels to your {@link LogEntry}, implement a {@link LoggingEventEnhancer}
 * and add its classpath to your {@code logback.xml}. If any {@link LoggingEventEnhancer} is added
 * this class is no longer registered.
 */
final class MDCEventEnhancer implements LoggingEventEnhancer {

  @Override
  public void enhanceLogEntry(LogEntry.Builder builder, ILoggingEvent e) {
    for (Map.Entry<String, String> entry : e.getMDCPropertyMap().entrySet()) {
      if (null != entry.getKey() && null != entry.getValue()) {
        builder.addLabel(entry.getKey(), entry.getValue());
      }
    }
  }
}
