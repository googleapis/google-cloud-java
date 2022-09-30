/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.dialogflow.v2;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.protobuf.Value;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

public class ContextManagementSmokeTest {
  private static final String PROJECT_ENV_NAME = "GOOGLE_CLOUD_PROJECT";
  private static final String LEGACY_PROJECT_ENV_NAME = "GCLOUD_PROJECT";
  private static String SESSION_ID = UUID.randomUUID().toString();

  public static void main(String args[]) {
    Logger.getLogger("").setLevel(Level.WARNING);
    try {
      listContexts(SESSION_ID, getProjectId());
      System.out.println("OK");
    } catch (IOException e) {
      System.err.println("Failed with exception:");
      e.printStackTrace(System.err);
      System.exit(1);
    }
  }

  @Test
  public void run() {
    main(null);
  }

  /**
   * Lists contexts
   *
   * @param sessionId Identifier of the DetectIntent session.
   * @param projectId Project/Agent Id.
   * @return List of Contexts found.
   */
  public static List<Context> listContexts(String sessionId, String projectId) throws IOException {
    List<Context> contexts = Lists.newArrayList();
    // Instantiates a client
    try (ContextsClient contextsClient = ContextsClient.create()) {
      // Set the session name using the sessionId (UUID) and projectId (my-project-id)
      SessionName session = SessionName.of(projectId, sessionId);

      // Performs the list contexts request
      for (Context context : contextsClient.listContexts(session).iterateAll()) {
        System.out.format("Context name: %s\n", context.getName());
        System.out.format("Lifespan Count: %d\n", context.getLifespanCount());
        System.out.format("Fields:\n");
        for (Map.Entry<String, Value> entry : context.getParameters().getFieldsMap().entrySet()) {
          if (entry.getValue().hasStructValue()) {
            System.out.format("\t%s: %s\n", entry.getKey(), entry.getValue());
          }
        }

        contexts.add(context);
      }
    }
    return contexts;
  }

  private static String getProjectId() {
    String projectId = System.getProperty(PROJECT_ENV_NAME, System.getenv(PROJECT_ENV_NAME));
    if (projectId == null) {
      projectId =
          System.getProperty(LEGACY_PROJECT_ENV_NAME, System.getenv(LEGACY_PROJECT_ENV_NAME));
    }
    Preconditions.checkArgument(projectId != null, "A project ID is required.");
    return projectId;
  }
}
