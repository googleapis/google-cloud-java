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

package com.google.cloud.logging;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.Logging.WriteOption;

import java.util.List;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * A logging handler that asynchronously outputs logs generated with
 * {@link java.util.logging.Logger} to Stackdriver Logging.
 *
 * <p>Java logging levels (see {@link java.util.logging.Level}) are mapped to the following Google
 * Stackdriver Logging severities:
 *
 * <table summary="Mapping of Java logging level to Stackdriver Logging severities">
 * <tr><th width="50%">Java Level</th><th>Stackdriver Logging Severity</th></tr>
 * <tr><td>SEVERE</td><td>ERROR</td></tr>
 * <tr><td>WARNING</td><td>WARNING</td></tr>
 * <tr><td>INFO</td><td>INFO</td></tr>
 * <tr><td>CONFIG</td><td>INFO</td></tr>
 * <tr><td>FINE</td><td>DEBUG</td></tr>
 * <tr><td>FINER</td><td>DEBUG</td></tr>
 * <tr><td>FINEST</td><td>DEBUG</td></tr>
 * </table>
 *
 * <p>Original Java logging levels are added as labels (with {@code levelName} and
 * {@code levelValue} keys, respectively) to the corresponding Stackdriver Logging {@link LogEntry}.
 * You can read entry labels using {@link LogEntry#getLabels()}. To use logging levels that correspond
 * to Stackdriver Logging severities you can use {@link LoggingLevel}.
 *
 * <p><b>Configuration</b>: By default each {@code AsyncLoggingHandler} is initialized using the
 * following {@code LogManager} configuration properties (that you can set in the
 * {@code logging.properties} file. If properties are not defined (or have invalid values) then the
 * specified default values are used.
 * <ul>
 * <li>{@code com.google.cloud.logging.AsyncLoggingHandler.log} the log name (defaults to
 *     {@code java.log}).
 * <li>{@code com.google.cloud.logging.AsyncLoggingHandler.level} specifies the default level for
 *     the handler (defaults to {@code Level.INFO}).
 * <li>{@code com.google.cloud.logging.AsyncLoggingHandler.filter} specifies the name of a
 *     {@link Filter} class to use (defaults to no filter).
 * <li>{@code com.google.cloud.logging.AsyncLoggingHandler.formatter} specifies the name of a
 *     {@link Formatter} class to use (defaults to {@link SimpleFormatter}).
 * <li>{@code com.google.cloud.logging.AsyncLoggingHandler.flushSize} specifies the maximum size of
 *     the log buffer. Once reached, logs are transmitted to the Stackdriver Logging service
 *     (defaults to 1).
 * <li>{@code com.google.cloud.logging.AsyncLoggingHandler.flushLevel} specifies the flush log
 *     level. When a log with this level is published, logs are transmitted to the Stackdriver
 *     Logging service (defaults to {@link LoggingLevel#ERROR}).
 * </ul>
 *
 * <p>To add a {@code LoggingHandler} to an existing {@link Logger} and be sure to avoid infinite
 * recursion when logging, use the {@link #addHandler(Logger, LoggingHandler)} method. Alternatively
 * you can add the handler via {@code logging.properties}. For example using the following line:
 * <pre>
 * {@code com.example.mypackage.handlers=com.google.cloud.logging.AsyncLoggingHandler}
 * </pre>
 */
public class AsyncLoggingHandler extends LoggingHandler {

  public AsyncLoggingHandler() {
    super();
  }

  public AsyncLoggingHandler(String logName) {
    super(logName);
  }

  public AsyncLoggingHandler(String logName, LoggingOptions options) {
    super(logName, options);
  }

  public AsyncLoggingHandler(String logName, LoggingOptions options, MonitoredResource resource) {
    super(logName, options, resource);
  }

  @Override
  void write(List<LogEntry> entries, WriteOption... options) {
    getLogging().writeAsync(entries, options);
  }
}
