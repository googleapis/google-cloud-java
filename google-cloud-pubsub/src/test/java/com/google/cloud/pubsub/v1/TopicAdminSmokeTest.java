/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.pubsub.v1;

import static com.google.cloud.pubsub.v1.TopicAdminClient.ListTopicsPagedResponse;

import com.google.common.base.Preconditions;
import com.google.pubsub.v1.ProjectName;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.cloud.testing.SmokeTest;
import org.junit.experimental.categories.Category;
import org.junit.Test;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;



@Category(SmokeTest.class)
@javax.annotation.Generated("by GAPIC")
public class TopicAdminSmokeTest {
  @Test
  public void run() {
    Logger.getLogger("").setLevel(Level.WARNING);
    try {
      String projectId = getProjectId();
      executeNoCatch(projectId);
      System.out.println("OK");
    } catch (Exception e) {
      System.err.println("Failed with exception:");
      e.printStackTrace(System.err);
      System.exit(1);
    }
  }

  public static void main(String args[]) {
    Logger.getLogger("").setLevel(Level.WARNING);
    try {
      String projectId = getProjectId();
      if (projectId == null) {
        projectId = tryParseProjectIdFromCmdline(args);
      }
      executeNoCatch(projectId);
      System.out.println("OK");
    } catch (Exception e) {
      System.err.println("Failed with exception:");
      e.printStackTrace(System.err);
      System.exit(1);
    }
  }

  public static void executeNoCatch(String projectId) throws Exception {
    Preconditions.checkArgument(projectId != null, "A project ID is required.");
    try (TopicAdminClient client = TopicAdminClient.create()) {
      ProjectName project = ProjectName.of(projectId);

      ListTopicsPagedResponse pagedResponse = client.listTopics(project);
      System.out.println(pagedResponse.toString());
    }
  }

  private static String tryParseProjectIdFromCmdline(String args[]) {
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
        formater.printHelp("TopicAdminSmokeTest", options);
      }
      return cl.getOptionValue("project_id");                   
    } catch (Exception e) {
      System.err.println("Failed with exception:");
      e.printStackTrace(System.err);
      System.exit(1);
    }
    return "";
  }

  private static String getProjectId() {
    final String PROJECT_ENV_NAME = "GOOGLE_CLOUD_PROJECT";
    final String LEGACY_PROJECT_ENV_NAME = "GCLOUD_PROJECT";
    String projectId = System.getProperty(PROJECT_ENV_NAME, System.getenv(PROJECT_ENV_NAME));
    if (projectId == null) {
      projectId =
          System.getProperty(LEGACY_PROJECT_ENV_NAME, System.getenv(LEGACY_PROJECT_ENV_NAME));
    }
    return projectId;
  }
}
