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

package com.google.cloud.examples.logging.snippets;

import com.google.cloud.logging.LoggingHandler;
import java.util.logging.Logger;

/**
 * A snippet showing how to use {@link java.util.logging.Logger} to log entries to Stackdriver
 * Logging. The snippet shows how to install a Stackdriver Logging handler using {@link
 * com.google.cloud.logging.LoggingHandler#addHandler(Logger, LoggingHandler)}. Notice that this
 * could also be done through the {@code logging.properties} file, adding the following line:
 *
 * <pre>
 * {@code com.google.cloud.examples.logging.snippets.AddLoggingHandler.handlers=com.google.cloud.logging.LoggingHandler}
 * </pre>
 */
public class AddLoggingHandler {

  private static final Logger LOGGER = Logger.getLogger(AddLoggingHandler.class.getName());

  public static void main(String... args) {
    // Add the Stackdriver Logging handler
    LoggingHandler.addHandler(LOGGER, new LoggingHandler());

    // log using the logger
    LOGGER.warning("test warning");
  }
}
