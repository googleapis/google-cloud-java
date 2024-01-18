/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.examples.resourcemanager;

import com.google.cloud.resourcemanager.Project;
import com.google.cloud.resourcemanager.ProjectInfo;
import com.google.cloud.resourcemanager.ResourceManager;
import com.google.cloud.resourcemanager.ResourceManagerOptions;
import com.google.common.base.Joiner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * An example of using Google Cloud Resource Manager.
 *
 * <p>This example creates, deletes, gets, and lists projects.
 *
 * <p>See the <a
 * href="https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/README.md">
 * README</a> for compilation instructions. Run this code with
 *
 * <pre>{@code target/appassembler/bin/ResourceManagerExample
 * [list | [create | delete | get] projectId]}</pre>
 */
public class ResourceManagerExample {

  private static final String DEFAULT_ACTION = "list";
  private static final Map<String, ResourceManagerAction> ACTIONS = new HashMap<>();

  private interface ResourceManagerAction {
    void run(ResourceManager resourceManager, String... args);

    String[] getRequiredParams();

    String[] getOptionalParams();
  }

  private static class CreateAction implements ResourceManagerAction {
    @Override
    public void run(ResourceManager resourceManager, String... args) {
      String projectId = args[0];
      Map<String, String> labels = new HashMap<>();
      for (int i = 1; i < args.length; i += 2) {
        if (i + 1 < args.length) {
          labels.put(args[i], args[i + 1]);
        } else {
          labels.put(args[i], "");
        }
      }
      Project project =
          resourceManager.create(ProjectInfo.newBuilder(projectId).setLabels(labels).build());
      System.out.printf(
          "Successfully created project '%s': %s.%n", projectId, projectDetails(project));
    }

    @Override
    public String[] getRequiredParams() {
      return new String[] {"project-id"};
    }

    @Override
    public String[] getOptionalParams() {
      return new String[] {"label-key-1", "label-value-1", "label-key-2", "label-value-2", "..."};
    }
  }

  private static class DeleteAction implements ResourceManagerAction {
    @Override
    public void run(ResourceManager resourceManager, String... args) {
      String projectId = args[0];
      System.out.printf("Going to delete project \"%s\". Are you sure [y/N]: ", projectId);
      Scanner scanner = new Scanner(System.in);
      if (scanner.nextLine().toLowerCase().equals("y")) {
        resourceManager.delete(projectId);
        System.out.printf("Successfully deleted project %s.%n", projectId);
      } else {
        System.out.printf("Will not delete project %s.%n", projectId);
      }
      scanner.close();
    }

    @Override
    public String[] getRequiredParams() {
      return new String[] {"project-id"};
    }

    @Override
    public String[] getOptionalParams() {
      return new String[] {};
    }
  }

  private static class GetAction implements ResourceManagerAction {
    @Override
    public void run(ResourceManager resourceManager, String... args) {
      String projectId = args[0];
      ProjectInfo project = resourceManager.get(projectId);
      if (project != null) {
        System.out.printf(
            "Successfully got project '%s': %s.%n", projectId, projectDetails(project));
      } else {
        System.out.printf("Could not find project '%s'.%n", projectId);
      }
    }

    @Override
    public String[] getRequiredParams() {
      return new String[] {"project-id"};
    }

    @Override
    public String[] getOptionalParams() {
      return new String[] {};
    }
  }

  private static class ListAction implements ResourceManagerAction {
    @Override
    public void run(ResourceManager resourceManager, String... args) {
      System.out.println("Projects you can view:");
      for (ProjectInfo project : resourceManager.list().getValues()) {
        System.out.println(projectDetails(project));
      }
    }

    @Override
    public String[] getRequiredParams() {
      return new String[] {};
    }

    @Override
    public String[] getOptionalParams() {
      return new String[] {};
    }
  }

  static {
    ACTIONS.put("create", new CreateAction());
    ACTIONS.put("delete", new DeleteAction());
    ACTIONS.put("get", new GetAction());
    ACTIONS.put("list", new ListAction());
  }

  private static String projectDetails(ProjectInfo project) {
    return new StringBuilder()
        .append("{projectId:")
        .append(project.getProjectId())
        .append(", projectNumber:")
        .append(project.getProjectNumber())
        .append(", createTimeMillis:")
        .append(project.getCreateTimeMillis())
        .append(", state:")
        .append(project.getState())
        .append(", labels:")
        .append(project.getLabels())
        .append("}")
        .toString();
  }

  private static void addUsage(
      String actionName, ResourceManagerAction action, StringBuilder usage) {
    usage.append(actionName);
    Joiner joiner = Joiner.on(" ");
    String[] requiredParams = action.getRequiredParams();
    if (requiredParams.length > 0) {
      usage.append(' ');
      joiner.appendTo(usage, requiredParams);
    }
    String[] optionalParams = action.getOptionalParams();
    if (optionalParams.length > 0) {
      usage.append(" [");
      joiner.appendTo(usage, optionalParams);
      usage.append(']');
    }
  }

  public static void main(String... args) {
    String actionName = args.length > 0 ? args[0].toLowerCase() : DEFAULT_ACTION;
    ResourceManagerAction action = ACTIONS.get(actionName);
    if (action == null) {
      StringBuilder actionAndParams = new StringBuilder();
      for (Map.Entry<String, ResourceManagerAction> entry : ACTIONS.entrySet()) {
        addUsage(entry.getKey(), entry.getValue(), actionAndParams);
        actionAndParams.append('|');
      }
      actionAndParams.setLength(actionAndParams.length() - 1);
      System.out.printf(
          "Usage: %s [%s]%n", ResourceManagerExample.class.getSimpleName(), actionAndParams);
      return;
    }

    // If you want to access a local Resource Manager emulator (after creating and starting the
    // LocalResourceManagerHelper), use the following code instead:
    // ResourceManager resourceManager = LocalResourceManagerHelper.getOptions().getService();
    ResourceManager resourceManager = ResourceManagerOptions.getDefaultInstance().getService();
    args = args.length > 1 ? Arrays.copyOfRange(args, 1, args.length) : new String[] {};
    if (args.length < action.getRequiredParams().length) {
      StringBuilder usage = new StringBuilder();
      usage.append("Usage: ");
      addUsage(actionName, action, usage);
      System.out.println(usage);
    } else {
      action.run(resourceManager, args);
    }
  }
}
