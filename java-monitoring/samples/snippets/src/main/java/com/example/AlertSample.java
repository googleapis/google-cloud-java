/*
 * Copyright 2018 Google LLC
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

package com.example;

import com.google.cloud.monitoring.v3.AlertPolicyServiceClient;
import com.google.cloud.monitoring.v3.AlertPolicyServiceClient.ListAlertPoliciesPagedResponse;
import com.google.cloud.monitoring.v3.NotificationChannelServiceClient;
import com.google.cloud.monitoring.v3.NotificationChannelServiceClient.ListNotificationChannelsPagedResponse;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.monitoring.v3.AlertPolicy;
import com.google.monitoring.v3.AlertPolicyName;
import com.google.monitoring.v3.ListAlertPoliciesRequest;
import com.google.monitoring.v3.NotificationChannel;
import com.google.monitoring.v3.NotificationChannelName;
import com.google.monitoring.v3.ProjectName;
import com.google.protobuf.BoolValue;
import com.google.protobuf.FieldMask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class AlertSample {

  private static final Option PROJECT_ID_OPTION = Option.builder("p")
      .longOpt("projectid")
      .desc("Your Google project id.")
      .hasArg()
      .argName("PROJECT_ID")
      .build();
  private static final Option FILE_PATH_OPTION = Option.builder("j")
      .longOpt("jsonPath")
      .desc("Path to json file where alert polices are saved and restored.")
      .hasArg()
      .argName("JSON_PATH")
      .build();
  private static final Option ALERT_ID_OPTION = Option.builder("a")
      .required()
      .longOpt("alert-id")
      .desc("The id of the alert policy whose channels will be replaced.")
      .hasArg()
      .argName("ALERT_ID")
      .build();
  private static final Option CHANNEL_ID_OPTION = Option.builder("c")
      .longOpt("channel-id")
      .desc("A channel id.  Repeat this option to set multiple channel ids.")
      .hasArg()
      .argName("CHANNEL_ID")
      .build();
  private static final Option FILTER_OPTION = Option.builder("d")
      .longOpt("filter")
      .desc("See https://cloud.google.com/monitoring/api/v3/filters.")
      .hasArg()
      .argName("FILTER")
      .build();

  private static final Options BASE_OPTIONS = new Options()
      .addOption(PROJECT_ID_OPTION);
  private static final Options BACKUP_OPTIONS = new Options()
      .addOption(PROJECT_ID_OPTION)
      .addOption(FILE_PATH_OPTION);
  private static final Options REPLACE_CHANNELS_OPTIONS = new Options()
      .addOption(PROJECT_ID_OPTION)
      .addOption(ALERT_ID_OPTION)
      .addOption(CHANNEL_ID_OPTION);
  private static final Options ENABLE_OPTIONS = new Options()
      .addOption(PROJECT_ID_OPTION)
      .addOption(FILTER_OPTION);

  private static Map<String, Options> COMMAND_OPTIONS = ImmutableMap.of(
      "backup", BACKUP_OPTIONS,
      "restore", BACKUP_OPTIONS,
      "replace-channels", REPLACE_CHANNELS_OPTIONS,
      "enable", ENABLE_OPTIONS,
      "disable", ENABLE_OPTIONS
  );

  private static final CommandLineParser PARSER = new DefaultParser();

  private static final FieldMask NOTIFICATION_CHANNEL_UPDATE_MASK = FieldMask
      .newBuilder()
      .addPaths("type")
      .addPaths("name")
      .addPaths("displayName")
      .addPaths("description")
      .addPaths("labels")
      .addPaths("userLabels")
      .build();

  private static Gson gson = new Gson();

  public static void main(String... args) throws IOException {
    if (args.length == 0) {
      usage(null);
      return;
    }
    String command = args[0];
    Options expectedOptions = COMMAND_OPTIONS.getOrDefault(command, BASE_OPTIONS);

    CommandLine cl = parseCommandLine(args, expectedOptions);

    String projectId = cl.hasOption(PROJECT_ID_OPTION.getOpt())
        ? cl.getOptionValue(PROJECT_ID_OPTION.getOpt())
        : System.getenv("GOOGLE_CLOUD_PROJECT");

    if (Strings.isNullOrEmpty(projectId)) {
      projectId = System.getenv("DEVSHELL_PROJECT_ID");
    }

    if (Strings.isNullOrEmpty(projectId)) {
      usage("Error: --project-id arg required unless provided by the GOOGLE_CLOUD_PROJECT "
          + "or DEVSHELL_PROJECT_ID environment variables.");
      return;
    }

    switch (command) {
      case "list":
        listAlertPolicies(projectId);
        break;
      case "backup":
        backupPolicies(projectId, cl.getOptionValue(FILE_PATH_OPTION.getOpt()));
        break;
      case "restore":
        restorePolicies(projectId, cl.getOptionValue(FILE_PATH_OPTION.getOpt()));
        break;
      case "replace-channels":
        replaceChannels(
            projectId,
            cl.getOptionValue(ALERT_ID_OPTION.getOpt()),
            cl.getOptionValues(CHANNEL_ID_OPTION.getOpt()));
        break;
      case "enable":
        enablePolicies(projectId, cl.getOptionValue(FILTER_OPTION.getOpt()), true);
        break;
      case "disable":
        enablePolicies(projectId, cl.getOptionValue(FILTER_OPTION.getOpt()), false);
        break;
      default:
        usage(null);
    }
  }

  private static CommandLine parseCommandLine(String[] args, Options expectedOptions) {
    CommandLine cl;
    try {
      cl = PARSER.parse(expectedOptions, args);
    } catch (ParseException pe) {
      usage("Exception parsing command line arguments.");
      throw new RuntimeException("Exception parsing command line arguments.", pe);
    }
    return cl;
  }

  // [START monitoring_alert_list_policies]
  private static void listAlertPolicies(String projectId) throws IOException {
    try (AlertPolicyServiceClient client = AlertPolicyServiceClient.create()) {
      ListAlertPoliciesPagedResponse response = client.listAlertPolicies(ProjectName.of(projectId));

      System.out.println("Alert Policies:");
      for (AlertPolicy policy : response.iterateAll()) {
        System.out.println(
            String.format("\nPolicy %s\nalert-id: %s", policy.getDisplayName(), policy.getName()));
        int channels = policy.getNotificationChannelsCount();
        if (channels > 0) {
          System.out.println("notification-channels:");
          for (int i = 0; i < channels; i++) {
            System.out.println("\t" + policy.getNotificationChannels(i));
          }
        }
        if (policy.hasDocumentation() && policy.getDocumentation().getContent() != null) {
          System.out.println(policy.getDocumentation().getContent());
        }
      }
    }
  }
  // [END monitoring_alert_list_policies]

  // [START monitoring_alert_backup_policies]
  private static void backupPolicies(String projectId, String filePath) throws IOException {
    List<AlertPolicy> alertPolicies = getAlertPolicies(projectId);
    List<NotificationChannel> notificationChannels = getNotificationChannels(projectId);
    writePoliciesBackupFile(projectId, filePath, alertPolicies, notificationChannels);
    System.out.println(String.format("Saved policies to %s", filePath));
  }

  private static List<AlertPolicy> getAlertPolicies(String projectId) throws IOException {
    List<AlertPolicy> alertPolicies = Lists.newArrayList();
    try (AlertPolicyServiceClient client = AlertPolicyServiceClient.create()) {
      ListAlertPoliciesPagedResponse response = client.listAlertPolicies(ProjectName.of(projectId));

      for (AlertPolicy policy : response.iterateAll()) {
        alertPolicies.add(policy);
      }
    }
    return alertPolicies;
  }

  // [START monitoring_alert_list_channels]
  private static List<NotificationChannel> getNotificationChannels(String projectId)
      throws IOException {
    List<NotificationChannel> notificationChannels = Lists.newArrayList();
    try (NotificationChannelServiceClient client = NotificationChannelServiceClient.create()) {
      ListNotificationChannelsPagedResponse listNotificationChannelsResponse =
          client.listNotificationChannels(ProjectName.of(projectId));
      for (NotificationChannel channel : listNotificationChannelsResponse.iterateAll()) {
        notificationChannels.add(channel);
      }
    }
    return notificationChannels;
  }
  // [END monitoring_alert_list_channels]

  private static void writePoliciesBackupFile(
      String projectId,
      String filePath,
      List<AlertPolicy> alertPolicies,
      List<NotificationChannel> notificationChannels) throws IOException {
    JsonObject backupContents = new JsonObject();
    backupContents.add("project_id", new JsonPrimitive(projectId));
    JsonArray policiesJson = new JsonArray();
    for (AlertPolicy policy : alertPolicies) {
      policiesJson.add(gson.toJsonTree(policy));
    }
    backupContents.add("policies", policiesJson);

    JsonArray notificationsJson = new JsonArray();
    for (NotificationChannel channel : notificationChannels) {
      notificationsJson.add(gson.toJsonTree(channel));
    }
    backupContents.add("notification_channels", notificationsJson);

    FileWriter writer = new FileWriter(filePath);
    writer.write(backupContents.toString());
    writer.close();
  }
  // [END monitoring_alert_backup_policies]

  // [START monitoring_alert_restore_policies]
  private static void restorePolicies(String projectId, String filePath) throws IOException {
    FileReader reader = new FileReader(filePath);
    BufferedReader bufferedReader = new BufferedReader(reader);

    JsonObject backupContent = getPolicyJsonContents(filePath, bufferedReader);
    String backupProjectId = backupContent.get("project_id").getAsString();
    boolean isSameProject = projectId.equals(backupProjectId);

    AlertPolicy[] policies = gson.fromJson(backupContent.get("policies"), AlertPolicy[].class);
    List<NotificationChannel> notificationChannels = readNotificationChannelsJson(backupContent);
    Map<String, String> restoredChannelIds = restoreNotificationChannels(projectId,
        notificationChannels,
        isSameProject);
    List<AlertPolicy> policiesToRestore =
        reviseRestoredPolicies(policies, isSameProject, restoredChannelIds);

    restoreRevisedPolicies(projectId, isSameProject, policiesToRestore);
  }

  private static List<AlertPolicy> reviseRestoredPolicies(
      AlertPolicy[] policies,
      boolean isSameProject,
      Map<String, String> restoredChannelIds) {
    List<AlertPolicy> newPolicies = Lists.newArrayListWithCapacity(policies.length);
    for (AlertPolicy policy : policies) {
      AlertPolicy.Builder policyBuilder = policy
          .toBuilder()
          .clearNotificationChannels()
          .clearMutationRecord()
          .clearCreationRecord();
      // Update restored notification channel names.
      for (String channelName : policy.getNotificationChannelsList()) {
        String newChannelName = restoredChannelIds.get(channelName);
        if (!Strings.isNullOrEmpty(newChannelName)) {
          policyBuilder.addNotificationChannels(newChannelName);
        }
      }
      if (!isSameProject) {
        policyBuilder.clearName();
        policyBuilder.clearConditions();
        for (AlertPolicy.Condition condition : policy.getConditionsList()) {
          policyBuilder.addConditions(condition.toBuilder().clearName());
        }
      }
      newPolicies.add(policyBuilder.build());
    }
    return newPolicies;
  }

  // [START monitoring_alert_create_policy]
  private static void restoreRevisedPolicies(
      String projectId,
      boolean isSameProject,
      List<AlertPolicy> policies) throws IOException {
    try (AlertPolicyServiceClient client = AlertPolicyServiceClient.create()) {
      for (AlertPolicy policy : policies) {
        if (!isSameProject) {
          policy = client.createAlertPolicy(ProjectName.of(projectId), policy);
        } else {
          try {
            client.updateAlertPolicy(null, policy);
          } catch (Exception e) {
            policy = client.createAlertPolicy(
                ProjectName.of(projectId),
                policy.toBuilder().clearName().build());
          }
        }
        System.out.println(String.format("Restored %s", policy.getName()));
      }
    }
  }
  // [END monitoring_alert_create_policy]

  private static List<NotificationChannel> readNotificationChannelsJson(JsonObject backupContent) {
    if (backupContent.has("notification_channels")) {
      NotificationChannel[] channels = gson.fromJson(backupContent.get("notification_channels"),
          NotificationChannel[].class);
      return Lists.newArrayList(channels);
    }
    return Lists.newArrayList();
  }

  // [START monitoring_alert_create_channel]
  // [START monitoring_alert_update_channel]
  private static Map<String, String> restoreNotificationChannels(
      String projectId,
      List<NotificationChannel> channels,
      boolean isSameProject) throws IOException {
    Map<String, String> newChannelNames = Maps.newHashMap();
    try (NotificationChannelServiceClient client = NotificationChannelServiceClient.create()) {
      for (NotificationChannel channel : channels) {
        // Update channel name if project ID is different.
        boolean channelUpdated = false;
        if (isSameProject) {
          try {
            NotificationChannel updatedChannel =
                client.updateNotificationChannel(NOTIFICATION_CHANNEL_UPDATE_MASK, channel);
            newChannelNames.put(channel.getName(), updatedChannel.getName());
            channelUpdated = true;
          } catch (Exception e) {
            channelUpdated = false;
          }
        }
        if (!channelUpdated) {
          NotificationChannel newChannel = client.createNotificationChannel(
              ProjectName.of(projectId),
              channel
                  .toBuilder()
                  .clearName()
                  .clearVerificationStatus()
                  .build());
          newChannelNames.put(channel.getName(), newChannel.getName());
        }
      }
    }
    return newChannelNames;
  }
  // [END monitoring_alert_create_channel]
  // [END monitoring_alert_update_channel]

  private static JsonObject getPolicyJsonContents(String filePath, BufferedReader content) {
    try {
      return gson.fromJson(content, JsonObject.class);
    } catch (JsonSyntaxException jse) {
      throw new RuntimeException(String.format("Could not parse policies file %s", filePath), jse);
    }
  }
  // [END monitoring_alert_restore_policies]

  // [START monitoring_alert_replace_channels]
  private static void replaceChannels(String projectId, String alertPolicyId, String[] channelIds)
      throws IOException {
    AlertPolicy.Builder policyBuilder = AlertPolicy
        .newBuilder()
        .setName(AlertPolicyName.of(projectId, alertPolicyId).toString());
    for (String channelId : channelIds) {
      policyBuilder.addNotificationChannels(
          NotificationChannelName.of(projectId, channelId).toString());
    }
    try (AlertPolicyServiceClient client = AlertPolicyServiceClient.create()) {
      AlertPolicy result = client.updateAlertPolicy(
          FieldMask.newBuilder().addPaths("notification_channels").build(), policyBuilder.build());
      System.out.println(String.format("Updated %s", result.getName()));
    }
  }
  // [END monitoring_alert_replace_channels]

  // [START monitoring_alert_enable_policies]
  // [START monitoring_alert_disable_policies]
  private static void enablePolicies(String projectId, String filter, boolean enable)
      throws IOException {
    try (AlertPolicyServiceClient client = AlertPolicyServiceClient.create()) {
      ListAlertPoliciesPagedResponse response = client
          .listAlertPolicies(ListAlertPoliciesRequest.newBuilder()
              .setName(ProjectName.of(projectId).toString())
              .setFilter(filter)
              .build());

      for (AlertPolicy policy : response.iterateAll()) {
        if (policy.getEnabled().getValue() == enable) {
          System.out.println(String.format(
              "Policy %s is already %b.", policy.getName(), enable ? "enabled" : "disabled"));
          continue;
        }
        AlertPolicy updatedPolicy = AlertPolicy
            .newBuilder()
            .setName(policy.getName())
            .setEnabled(BoolValue.newBuilder().setValue(enable))
            .build();
        AlertPolicy result = client.updateAlertPolicy(
            FieldMask.newBuilder().addPaths("enabled").build(), updatedPolicy);
        System.out.println(String.format(
            "%s %s",
            result.getDisplayName(),
            result.getEnabled().getValue() ? "enabled" : "disabled"));
      }
    }
  }
  // [END monitoring_alert_enable_policies]
  // [END monitoring_alert_disable_policies]

  private static void usage(String message) {
    Optional.ofNullable(message).ifPresent(System.out::println);
    System.out.println();
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp("list", "Lists alert policies.", BASE_OPTIONS, "", true);
    System.out.println();
    formatter.printHelp(
        "[backup|restore]",
        "Backs up or restores alert policies.",
        BACKUP_OPTIONS,
        "",
        true);
    System.out.println();
    formatter.printHelp(
        "replace-channels",
        "Replaces alert policy notification channels.",
        REPLACE_CHANNELS_OPTIONS,
        "",
        true);
    System.out.println();
    formatter.printHelp(
        "[enable|disable]",
        "Enables/disables alert policies.",
        ENABLE_OPTIONS,
        "",
        true);
  }
}
