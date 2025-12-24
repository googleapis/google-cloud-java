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

package com.google.cloud.logging;

import com.google.logging.type.LogSeverity;

/**
 * The severity of the event described in a log entry. These guideline severity levels are ordered,
 * with numerically smaller levels treated as less severe than numerically larger levels. If the
 * source of the log entries uses a different set of severity levels, the client should select the
 * closest corresponding {@code Severity} value.
 */
public enum Severity {

  /** The None severity level. Should not be used with log entries. */
  NONE(LogSeverity.UNRECOGNIZED),

  /** The log entry has no assigned severity level. */
  DEFAULT(LogSeverity.DEFAULT),

  /** Debug or trace information. */
  DEBUG(LogSeverity.DEBUG),

  /** Routine information, such as ongoing status or performance. */
  INFO(LogSeverity.INFO),

  /** Normal but significant events, such as start up, shut down, or configuration. */
  NOTICE(LogSeverity.NOTICE),

  /** Warning events might cause problems. */
  WARNING(LogSeverity.WARNING),

  /** Error events are likely to cause problems. */
  ERROR(LogSeverity.ERROR),

  /** Critical events cause more severe problems or brief outages. */
  CRITICAL(LogSeverity.CRITICAL),

  /** A person must take an action immediately. */
  ALERT(LogSeverity.ALERT),

  /** One or more systems are unusable. */
  EMERGENCY(LogSeverity.EMERGENCY);

  private final LogSeverity versionPb;

  Severity(LogSeverity versionPb) {
    this.versionPb = versionPb;
  }

  LogSeverity toPb() {
    return versionPb;
  }

  static Severity fromPb(LogSeverity severityPb) {
    switch (severityPb) {
      case DEFAULT:
        return DEFAULT;
      case DEBUG:
        return DEBUG;
      case INFO:
        return INFO;
      case NOTICE:
        return NOTICE;
      case WARNING:
        return WARNING;
      case ERROR:
        return ERROR;
      case CRITICAL:
        return CRITICAL;
      case ALERT:
        return ALERT;
      case EMERGENCY:
        return EMERGENCY;
      case UNRECOGNIZED:
        break;
    }
    throw new IllegalArgumentException(severityPb + " is not a valid severity");
  }
}
