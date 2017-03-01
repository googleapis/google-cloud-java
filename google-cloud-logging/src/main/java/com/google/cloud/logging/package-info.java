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

/**
 * A client to Stackdriver Logging.
 *
 * <p>Here's a simple usage example for using google-cloud from Compute Engine/App Engine Flexible.
 * This example shows how to write and list log entries. For the complete source code see
 * <a href="https://github.com/GoogleCloudPlatform/google-cloud-java/tree/master/google-cloud-examples/src/main/java/com/google/cloud/examples/logging/snippets/WriteAndListLogEntries.java">
 * WriteAndListLogEntries.java</a>.
 * <pre> {@code
 * LoggingOptions options = LoggingOptions.getDefaultInstance();
 * try(Logging logging = options.getService()) {
 *
 *   LogEntry firstEntry = LogEntry.newBuilder(StringPayload.of("message"))
 *       .setLogName("test-log")
 *       .setResource(MonitoredResource.builder("global")
 *           .addLabel("project_id", options.getProjectId())
 *           .build())
 *       .build();
 *   logging.write(Collections.singleton(firstEntry));
 *
 *   Page<LogEntry> entries = logging.listLogEntries(
 *   EntryListOption.filter("logName=projects/" + options.getProjectId() + "/logs/test-log"));
 *   Iterator<LogEntry> entryIterator = entries.iterateAll();
 *   while (entryIterator.hasNext()) {
 *     System.out.println(entryIterator.next());
 *   }
 * }}</pre>
 *
 * <p>This second example shows how to use a {@link java.util.logging.Logger} to write log entries
 * to Stackdriver Logging. The snippet installs a Stackdriver Logging handler using
 * {@code LoggingHandler.addHandler(Logger, LoggingHandler)}. Notice that this could also be done
 * through the {@code logging.properties} file, adding the following line:
 * <pre>
 * {@code com.google.cloud.examples.logging.snippets.AddLoggingHandler.handlers=com.google.cloud.logging.LoggingHandler}
 * </pre>
 * For the complete source code see
 * <a href="https://github.com/GoogleCloudPlatform/google-cloud-java/tree/master/google-cloud-examples/src/main/java/com/google/cloud/examples/logging/snippets/AddLoggingHandler.java">
 * AddLoggingHandler.java</a>.
 * <pre> {@code
 * Logger logger = Logger.getLogger(AddLoggingHandler.class.getName());
 * LoggingHandler.addHandler(logger, new LoggingHandler());
 * logger.warning("test warning");
 * }</pre>
 *
 * @see <a href="https://cloud.google.com/logging/">Stackdriver Logging</a>
 */
package com.google.cloud.logging;
