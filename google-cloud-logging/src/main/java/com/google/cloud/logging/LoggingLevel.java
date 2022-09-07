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

import java.util.logging.Level;

/**
 * This class adds some additional Java logging levels for Cloud Logging. Added levels fill in the
 * gap between Java logging levels and Cloud Logging severities.
 *
 * <p>Added levels in descending order are (between parenthesis the relation with Java logging
 * levels):
 *
 * <ul>
 *   <li>EMERGENCY
 *   <li>ALERT
 *   <li>CRITICAL
 *   <li>ERROR ({@code WARNING < ERROR < SEVERE})
 *   <li>NOTICE ({@code INFO < NOTICE < WARNING})
 *   <li>DEBUG ({@code ALL < DEBUG < FINES}T
 * </ul>
 *
 * <p>Notice that {@code ERROR} is lower than {@link java.util.logging.Level#SEVERE} but higher than
 * {@link java.util.logging.Level#WARNING}. {@code DEBUG} instead is lower than {@link
 * java.util.logging.Level#FINEST} but higher than {@link java.util.logging.Level#ALL}.
 */
@SuppressWarnings("ShouldNotSubclass")
public final class LoggingLevel extends Level {

  private static final long serialVersionUID = -6455416241709366337L;

  /**
   * A level to be used for debug or trace information. This level is initialized to {@code 250}.
   */
  public static final LoggingLevel DEBUG = new LoggingLevel("DEBUG", 250, Severity.DEBUG);

  /**
   * A level to be used when normal events occur, such as start up and shut down. This level is
   * initialized to {@code 850}.
   */
  public static final LoggingLevel NOTICE = new LoggingLevel("NOTICE", 850, Severity.NOTICE);

  /**
   * A level to be used when events occur that are likely to cause problems. This level is
   * initialized to {@code 950}.
   */
  public static final LoggingLevel ERROR = new LoggingLevel("ERROR", 950, Severity.ERROR);

  /**
   * A level to be used when critical events cause more severe problems or brief outages. This level
   * is initialized to {@code 1050}.
   */
  public static final LoggingLevel CRITICAL = new LoggingLevel("CRITICAL", 1050, Severity.CRITICAL);

  /**
   * A level to be used when a person must take an action immediately. This level is initialized to
   * {@code 1100}.
   */
  public static final LoggingLevel ALERT = new LoggingLevel("ALERT", 1100, Severity.ALERT);

  /**
   * A levet to be used when one or more systems are unusable. This level is initialized to {@code
   * 1150}.
   */
  public static final LoggingLevel EMERGENCY =
      new LoggingLevel("EMERGENCY", 1150, Severity.EMERGENCY);

  private final Severity severity;

  private LoggingLevel(String name, int value, Severity severity) {
    super(name, value);
    this.severity = severity;
  }

  /** Returns the Cloud Logging severity associated with this logging level. */
  public Severity getSeverity() {
    return severity;
  }
}
