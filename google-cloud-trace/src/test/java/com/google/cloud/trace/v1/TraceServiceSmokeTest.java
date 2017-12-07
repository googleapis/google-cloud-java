/*
 * Copyright 2017, Google LLC All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.trace.v1;

import static com.google.cloud.trace.v1.PagedResponseWrappers.ListTracesPagedResponse;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@javax.annotation.Generated("by GAPIC")
public class TraceServiceSmokeTest {
  public static void main(String args[]) {
    Logger.getLogger("").setLevel(Level.WARNING);
    try {
      Options options = new Options();
      options.addOption("h", "help", false, "show usage");
      options.addOption(
          Option.builder()
              .longOpt("project_id")
              .desc("Project id")
              .hasArg()
              .argName("PROJECT-ID")
              .required(true)
              .build());
      CommandLine cl = (new DefaultParser()).parse(options, args);
      if (cl.hasOption("help")) {
        HelpFormatter formater = new HelpFormatter();
        formater.printHelp("TraceServiceSmokeTest", options);
      }
      executeNoCatch(cl.getOptionValue("project_id"));
      System.out.println("OK");
    } catch (Exception e) {
      System.err.println("Failed with exception:");
      e.printStackTrace(System.err);
      System.exit(1);
    }
  }

  public static void executeNoCatch(String projectId) throws Exception {
    try (TraceServiceClient client = TraceServiceClient.create()) {
      String projectId2 = projectId;

      ListTracesPagedResponse pagedResponse = client.listTraces(projectId2);
      System.out.println(ReflectionToStringBuilder.toString(pagedResponse));
    }
  }
}
