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

package org.slf4j.impl.logging;

import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import java.util.List;

public class CloudLogging implements ILogging {

  private Logging logging;

  @Override
  public void init() {
    logging = LoggingOptions.getDefaultInstance().getService();
    Runtime.getRuntime().addShutdownHook(new ShutdownService());
  }

  @Override
  public void write(List<LogEntry> logEntries) {
    logging.writeAsync(logEntries);
  }

  class ShutdownService extends Thread {

    @Override
    public void run() {
      try {
        logging.close();
      } catch (Exception e) {
        System.err.println("Error closing cloud logger : " + e.getMessage());
      }
    }
  }
}
