/*
 * Copyright 2017 Google Inc.
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

// [START logging_list_logs]
import com.google.api.gax.paging.Page;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;

public class ListLogs {

  public static void main(String... args) throws Exception {

    try (Logging logging = LoggingOptions.getDefaultInstance().getService()) {

      // List all log names
      Page<String> logNames = logging.listLogs();
      while (logNames != null) {
        for (String logName : logNames.iterateAll()) {
          System.out.println(logName);
        }
        logNames = logNames.getNextPage();
      }
    }
  }
}
// [END logging_list_logs]
