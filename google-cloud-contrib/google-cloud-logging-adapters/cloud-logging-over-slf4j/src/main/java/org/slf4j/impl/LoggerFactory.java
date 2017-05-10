/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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
package org.slf4j.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class LoggerFactory implements ILoggerFactory {

  private final ConcurrentMap<String, Logger> loggerMap;

  LoggerFactory() {
    loggerMap = new ConcurrentHashMap<>();
    CloudLoggingAdapter.lazyInit();
  }

  /** Return an appropriate {@link CloudLoggingAdapter} instance by name. */
  public Logger getLogger(String name) {
    Logger simpleLogger = loggerMap.get(name);
    if (simpleLogger != null) {
      return simpleLogger;
    } else {
      Logger newInstance = new CloudLoggingAdapter(name);
      Logger oldInstance = loggerMap.putIfAbsent(name, newInstance);
      return oldInstance == null ? newInstance : oldInstance;
    }
  }
}
