/*
 * Copyright 2020 Google LLC
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

// [START logging_get_sink]
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Sink;

/** Retrieve Cloud Logging Sink metadata. */
public class GetSinkMetadata {
  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    // The Name of your sink
    String sinkName = "sink-name"; // i.e my-sink

    getSinkMetadata(sinkName);
  }

  public static void getSinkMetadata(String sinkName) throws Exception {
    // Instantiates a logging client
    try (Logging logging = LoggingOptions.getDefaultInstance().getService()) {

      Sink sink = logging.getSink(sinkName);

      // print sink metadata
      System.out.println("Name:" + sink.getName());
      System.out.println("Version Format:" + sink.getVersionFormat());
      System.out.println("Filter:" + sink.getFilter());
      System.out.println("Destination:" + sink.getDestination());
    }
  }
}
// [END logging_get_sink]
