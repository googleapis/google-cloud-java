/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.examples;

import com.google.gcloud.resourcemanager.ProjectInfo;
import com.google.gcloud.resourcemanager.ResourceManager;
import com.google.gcloud.resourcemanager.ResourceManagerOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * An example of using the Google Cloud Resource Manager.
 * <p>
 * This example creates, gets, and lists projects.
 * <p>
 * Steps needed for running the example:<ol>
 * <li>login using gcloud SDK - {@code gcloud auth login}.</li>
 * <li>compile using maven - {@code mvn compile}</li>
 * <li>run using maven - {@code mvn exec:java
 * -Dexec.mainClass="com.google.gcloud.examples.ResourceManagerExample"
 * -Dexec.args="[create|get|list projectId]"}</li>
 * </ol>
 */
public class ResourceManagerExample {

  private static final String DEFAULT_ACTION = "list";
  private static final Map<String, ResourceManagerAction> ACTIONS = new HashMap<>();

  private interface ResourceManagerAction {
    void run(ResourceManager resourceManager, String... args);
    String getRequiredParams();
  }

  private static class CreateAction implements ResourceManagerAction {
    @Override
    public void run(ResourceManager resourceManager, String... args) {
      if (args.length > 0) {
        String projectId = args[0];
        ProjectInfo project = resourceManager.create(ProjectInfo.builder(projectId).build());
        System.out.printf(
            "Successfully created project '%s': %s.%n", projectId, projectDetails(project));
      } else {
        System.out.println("Error: must supply a globally unique project ID for your new project.");
      }
    }

    @Override
    public String getRequiredParams() {
      return "projectId";
    }
  }

  private static class GetAction implements ResourceManagerAction {
    @Override
    public void run(ResourceManager resourceManager, String... args) {
      if (args.length > 0) {
        String projectId = args[0];
        ProjectInfo project = resourceManager.get(projectId);
        if (project != null) {
          System.out.printf(
              "Successfully got project '%s': %s.%n", projectId, projectDetails(project));
        } else {
          System.out.printf("Could not find project '%s'.%n", projectId);
        }
      } else {
        System.out.println(
            "Error: must supply a project ID corresponding to a project for which you have viewing"
            + " permissions. You can create a project and then call get using the same project ID"
            + " if you have no other projects to use in this test.");
      }
    }

    @Override
    public String getRequiredParams() {
      return "projectId";
    }
  }

  private static class ListAction implements ResourceManagerAction {
    @Override
    public void run(ResourceManager resourceManager, String... args) {
      System.out.println("Projects you can view:");
      for (ProjectInfo project : resourceManager.list().values()) {
        System.out.println(projectDetails(project));
      }
    }

    @Override
    public String getRequiredParams() {
      return "";
    }
  }

  static {
    ACTIONS.put("create", new CreateAction());
    ACTIONS.put("get", new GetAction());
    ACTIONS.put("list", new ListAction());
  }

  private static String projectDetails(ProjectInfo project) {
    return "{projectId:" + project.projectId() + ", projectNumber:" + project.projectNumber()
        + ", createTimeMillis:" + project.createTimeMillis() + ", state:" + project.state() + "}";
  }

  public static void main(String... args) {
    String actionName = args.length > 0 ? args[0].toLowerCase() : DEFAULT_ACTION;
    ResourceManagerAction action = ACTIONS.get(actionName);
    if (action == null) {
      StringBuilder actionAndParams = new StringBuilder();
      for (Map.Entry<String, ResourceManagerAction> entry : ACTIONS.entrySet()) {
        actionAndParams.append(entry.getKey());
        String param = entry.getValue().getRequiredParams();
        if (param != null && !param.isEmpty()) {
          actionAndParams.append(' ').append(param);
        }
        actionAndParams.append('|');
      }
      actionAndParams.setLength(actionAndParams.length() - 1);
      System.out.printf(
          "Usage: %s [%s]%n", ResourceManagerExample.class.getSimpleName(), actionAndParams);
      return;
    }

    // If you want to access a local Resource Manager emulator (after creating and starting the
    // LocalResourceManagerHelper), use the following code instead:
    // ResourceManager resourceManager = LocalResourceManagerHelper.options().service();
    ResourceManager resourceManager = ResourceManagerOptions.defaultInstance().service();
    args = args.length > 1 ? Arrays.copyOfRange(args, 1, args.length) : new String[] {};
    action.run(resourceManager, args);
  }
}
