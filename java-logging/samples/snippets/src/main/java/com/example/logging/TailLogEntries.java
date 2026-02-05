/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.logging;

// [START logging_tail_log_entries]
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.LogEntryServerStream;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Logging.TailOption;
import com.google.cloud.logging.LoggingOptions;

public class TailLogEntries {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Optionally provide the logname as an argument.
    String logName = args.length > 0 ? args[0] : "";

    LoggingOptions options = LoggingOptions.getDefaultInstance();
    try (Logging logging = options.getService()) {

      // Optionally compose a filter to tail log entries only from specific log
      LogEntryServerStream stream;

      if (logName != "") {
        stream =
            logging.tailLogEntries(
                TailOption.filter(
                    "logName=projects/" + options.getProjectId() + "/logs/" + logName));
      } else {
        stream = logging.tailLogEntries();
      }
      System.out.println("start streaming..");
      for (LogEntry log : stream) {
        System.out.println(log);
        // cancel infinite streaming after receiving first entry
        stream.cancel();
      }
    }
  }
}
// [END logging_tail_log_entries]
