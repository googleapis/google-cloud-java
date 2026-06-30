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

// [START logging_list_log_entries]
import com.google.api.gax.paging.Page;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Logging.EntryListOption;
import com.google.cloud.logging.LoggingOptions;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class ListLogEntries {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace the variable value with valid log name before running the sample
    // or provide it as an argument.
    String logName = args.length > 0 ? args[0] : "test-log";

    try (Logging logging = LoggingOptions.getDefaultInstance().getService()) {

      // When composing a filter, using indexed fields, such as timestamp, resource.type, logName
      // and
      // others can help accelerate the results
      // Full list of indexed fields here:
      // https://cloud.google.com/logging/docs/view/advanced-queries#finding-quickly
      // This sample restrict the results to only last minute to minimize number of API calls
      Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
      calendar.add(Calendar.MINUTE, -1);
      DateFormat rfc3339 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
      String logFilter =
          "logName=projects/"
              + logging.getOptions().getProjectId()
              + "/logs/"
              + logName
              + " AND timestamp>=\""
              + rfc3339.format(calendar.getTime())
              + "\"";

      // List all log entries
      Page<LogEntry> entries = logging.listLogEntries(EntryListOption.filter(logFilter));
      while (entries != null) {
        for (LogEntry logEntry : entries.iterateAll()) {
          System.out.println(logEntry);
        }
        entries = entries.getNextPage();
      }
    }
  }
}
// [END logging_list_log_entries]
