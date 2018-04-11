/*
 * Copyright 2018 Google Inc.
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

import static com.google.common.base.Preconditions.checkNotNull;

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
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
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
      "enable", ENABLE_OPTIONS
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

  private AlertPolicyServiceClient alertPolicyClient;
  private NotificationChannelServiceClient notificationChannelClient;
  private PrintStream outputStream;
  private Gson gson = new Gson();

  private AlertSample() throws IOException {
    this(AlertPolicyServiceClient.create(), NotificationChannelServiceClient.create(), System.out);
  }

  AlertSample(AlertPolicyServiceClient alertPolicyClient,
              NotificationChannelServiceClient notificationChannelClient,
              PrintStream os) {
    this.alertPolicyClient = checkNotNull(alertPolicyClient);
    this.notificationChannelClient = notificationChannelClient;
    outputStream = checkNotNull(os);
  }

  public static void main(String[] args) throws IOException {
    AlertSample sample = createAlertSample();

    if (args.length == 0) {
      usage(System.out, null);
      return;
    }
    String command = args[0];
    Options expectedOptions = COMMAND_OPTIONS.getOrDefault(command, BASE_OPTIONS);

    CommandLine cl = parseCommandLine(args, expectedOptions);

    String projectId = cl.hasOption(PROJECT_ID_OPTION.getOpt())
        ? cl.getOptionValue(PROJECT_ID_OPTION.getOpt())
        : System.getenv("GOOGLE_PROJECT_ID");

    if (Strings.isNullOrEmpty(projectId)) {
      projectId = System.getenv("DEVSHELL_PROJECT_ID");
    }

    if (Strings.isNullOrEmpty(projectId)) {
      usage(sample.outputStream,
          "Error: --project-id arg required unless provided by the GOOGLE_PROJECT_ID "
              + "or DEVSHELL_PROJECT_ID environment variables.");
      return;
    }

    switch (command) {
      case "list":
        sample.listAlertPolicies(projectId);
        break;
      case "backup":
        sample.backupPolicies(projectId,
            cl.getOptionValue(FILE_PATH_OPTION.getOpt()));
        break;
      case "restore":
        sample.restorePolicies(projectId,
            cl.getOptionValue(FILE_PATH_OPTION.getOpt()));
        break;
      case "replace-channels":
        sample.replaceChannels(projectId,
            cl.getOptionValue(ALERT_ID_OPTION.getOpt()),
            cl.getOptionValues(CHANNEL_ID_OPTION.getOpt()));
        break;
      case "enable":
        sample.enablePolicies(projectId,
            cl.getOptionValue(FILTER_OPTION.getOpt()), true);
        break;
      case "disable":
        sample.enablePolicies(projectId,
            cl.getOptionValue(FILTER_OPTION.getOpt()), false);
        break;
      default:
        usage(sample.outputStream, null);
    }
  }

  private static CommandLine parseCommandLine(String[] args, Options expectedOptions) {
    CommandLine cl;
    try {
      cl = PARSER.parse(expectedOptions, args);
    } catch (ParseException pe) {
      usage(System.out, "Exception parsing command line arguments.");
      throw new RuntimeException("Exception parsing command line arguments.", pe);
    }
    return cl;
  }

  private static AlertSample createAlertSample() throws IOException {
    AlertSample sample;
    try {
      sample = new AlertSample();
    } catch (Exception e) {
      usage(System.out, "Exception creating alert sample.");
      throw e;
    }
    return sample;
  }

  // [START monitoring_alert_list_policies]
  void listAlertPolicies(String projectId) {
    ListAlertPoliciesPagedResponse response = alertPolicyClient.listAlertPolicies(ProjectName.of(
        projectId));

    for (AlertPolicy policy : response.iterateAll()) {
      outputStream.println(policy.getDisplayName());
      if (policy.hasDocumentation() && policy.getDocumentation().getContent() != null) {
        outputStream.println(policy.getDocumentation().getContent());
      }
    }
  }
  // [END monitoring_alert_list_policies]

  // [START monitoring_alert_backup_policies]
  void backupPolicies(String projectId, String filePath) throws IOException {
    List<AlertPolicy> alertPolicies = getAlertPolicies(projectId);
    List<NotificationChannel> notificationChannels = getNotificationChannels(projectId);
    writePoliciesBackupFile(projectId, filePath, alertPolicies, notificationChannels);
    outputStream.println(String.format("Saved policies to %s", filePath));
  }

  private List<AlertPolicy> getAlertPolicies(String projectId) {
    List<AlertPolicy> alertPolicies = Lists.newArrayList();
    ListAlertPoliciesPagedResponse response =
        alertPolicyClient.listAlertPolicies(ProjectName.of(projectId));

    for (AlertPolicy policy : response.iterateAll()) {
      alertPolicies.add(policy);
    }
    return alertPolicies;
  }

  // [START monitoring_alert_list_channels]
  private List<NotificationChannel> getNotificationChannels(String projectId) {
    List<NotificationChannel> notificationChannels = Lists.newArrayList();
    ListNotificationChannelsPagedResponse listNotificationChannelsResponse =
        notificationChannelClient.listNotificationChannels(ProjectName.of(projectId));
    for (NotificationChannel channel : listNotificationChannelsResponse.iterateAll()) {
      notificationChannels.add(channel);
    }
    return notificationChannels;
  }
  // [END monitoring_alert_list_channels]

  private void writePoliciesBackupFile(String projectId,
                                       String filePath,
                                       List<AlertPolicy> alertPolicies,
                                       List<NotificationChannel> notificationChannels)
      throws IOException {
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
  void restorePolicies(String projectId, String filePath) throws IOException {
    FileReader reader = new FileReader(filePath);
    BufferedReader bufferedReader = new BufferedReader(reader);

    JsonObject backupContent = getPolicyJsonContents(filePath, bufferedReader, gson);
    String backupProjectId = backupContent.get("project_id").getAsString();
    boolean isSameProject = projectId.equals(backupProjectId);

    AlertPolicy[] policies = gson.fromJson(backupContent.get("policies"), AlertPolicy[].class);
    List<NotificationChannel> notificationChannels = readNotificationChannelsJson(backupContent);
    Map<String, String> restoredChannelIds = restoreNotificationChannels(projectId,
        notificationChannels,
        isSameProject);
    List<AlertPolicy> policiesToRestore = reviseRestoredPolicies(policies,
        isSameProject,
        restoredChannelIds);

    restoreRevisedPolicies(projectId, isSameProject, policiesToRestore);
  }

  private List<AlertPolicy> reviseRestoredPolicies(AlertPolicy[] policies,
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
  private void restoreRevisedPolicies(String projectId,
                                      boolean isSameProject,
                                      List<AlertPolicy> policies) {
    for (AlertPolicy policy : policies) {
      if (!isSameProject) {
        policy = alertPolicyClient.createAlertPolicy(ProjectName.of(projectId), policy);
      } else {
        try {
          alertPolicyClient.updateAlertPolicy(null, policy);
        } catch (Exception e) {
          policy = alertPolicyClient.createAlertPolicy(ProjectName.of(projectId),
              policy.toBuilder().clearName().build());
        }
      }
      outputStream.println(String.format("Restored %s", policy.getName()));
    }
  }
  // [END monitoring_alert_create_policy]

  private List<NotificationChannel> readNotificationChannelsJson(JsonObject backupContent) {
    if (backupContent.has("notification_channels")) {
      NotificationChannel[] channels = gson.fromJson(backupContent.get("notification_channels"),
          NotificationChannel[].class);
      return Lists.newArrayList(channels);
    }
    return Lists.newArrayList();
  }

  // [START monitoring_alert_create_channel]
  // [START monitoring_alert_update_channel]
  private Map<String, String> restoreNotificationChannels(String projectId,
                                                          List<NotificationChannel> channels,
                                                          boolean isSameProject) {
    Map<String, String> newChannelNames = Maps.newHashMap();
    for (NotificationChannel channel : channels) {
      // Update channel name if project ID is different.
      boolean channelUpdated = false;
      if (isSameProject) {
        try {
          NotificationChannel updatedChannel = notificationChannelClient.updateNotificationChannel(
              NOTIFICATION_CHANNEL_UPDATE_MASK,
              channel);
          newChannelNames.put(channel.getName(), updatedChannel.getName());
          channelUpdated = true;
        } catch (Exception e) {
          channelUpdated = false;
        }
      }
      if (!channelUpdated) {
        NotificationChannel newChannel = notificationChannelClient.createNotificationChannel(
            ProjectName.of(projectId),
            channel
                .toBuilder()
                .clearName()
                .clearVerificationStatus()
                .build());
        newChannelNames.put(channel.getName(), newChannel.getName());
      }
    }
    return newChannelNames;
  }
  // [END monitoring_alert_create_channel]
  // [END monitoring_alert_update_channel]
  
  private JsonObject getPolicyJsonContents(String filePath, BufferedReader content, Gson gson) {
    try {
      return gson.fromJson(content, JsonObject.class);
    } catch (JsonSyntaxException jse) {
      throw new RuntimeException(String.format("Could not parse policies file %s", filePath), jse);
    }
  }
  // [END monitoring_alert_restore_policies]

  // [START monitoring_alert_replace_channels]
  void replaceChannels(String projectId, String alertPolicyId, String[] channelIds) {
    AlertPolicy.Builder policyBuilder = AlertPolicy
        .newBuilder()
        .setName(AlertPolicyName.of(projectId, alertPolicyId).toString());
    for (String channelId : channelIds) {
      policyBuilder.addNotificationChannels(
          NotificationChannelName.of(projectId, channelId).toString());
    }
    AlertPolicy result = alertPolicyClient.updateAlertPolicy(
        FieldMask.newBuilder().addPaths("notification_channels").build(), policyBuilder.build());
    outputStream.println(String.format("Updated %s", result.getName()));
  }
  // [END monitoring_alert_replace_channels]

  // [START monitoring_alert_enable_policies]
  // [START monitoring_alert_disable_policies]
  void enablePolicies(String projectId,
                      String filter,
                      boolean enable) {
    ListAlertPoliciesPagedResponse response = alertPolicyClient
        .listAlertPolicies(ListAlertPoliciesRequest.newBuilder()
            .setName(projectId)
            .setFilter(filter)
            .build());

    for (AlertPolicy policy : response.iterateAll()) {
      if (policy.getEnabled().getValue() == enable) {
        outputStream.println(String.format("Policy %s is already %b.", policy.getName(), enable));
        continue;
      }
      AlertPolicy updatedPolicy = AlertPolicy
          .newBuilder()
          .setName(AlertPolicyName.of(projectId, policy.getName()).toString())
          .setEnabled(BoolValue.newBuilder().setValue(enable))
          .build();
      AlertPolicy result = alertPolicyClient.updateAlertPolicy(
          FieldMask.newBuilder().addPaths("enabled").build(), updatedPolicy);
      outputStream.println(String.format(
          "%s %s", result.getName(), result.getEnabled().getValue() ? "Enabled" : "Disabled"));
    }

  }
  // [END monitoring_alert_enable_policies]
  // [END monitoring_alert_disable_policies]

  private static void usage(PrintStream ps) {
    usage(ps, null);
  }

  private static void usage(PrintStream ps, String message) {
    Optional.ofNullable(message).ifPresent(ps::println);
    ps.println("Usage:");
    ps.printf(
        "\tjava %s \"<command>\" \"<args>\"\n"
            + "Args:\n"
            + "\t%s\n"
            + "Commands:\n"
            + "\tlist:\t\t\t\tList existing alert policies for project.\n"
            + "\tbackup:\t\t\t\tBackup existing alert policies & notification channels to a file.\n"
            + "\t\t\t\t\t\t\tArgs:\n"
            + "\t\t\t\t\t\t\t\t%s\n"
            + "\t\t\t\t\t\t\t\t%s\n"
            + "\trestore:\t\t\tRestore alerts and notification channels from a backed-up file.\n"
            + "\t\t\t\t\t\t\tArgs:\n"
            + "\t\t\t\t\t\t\t\t%s\n"
            + "\t\t\t\t\t\t\t\t%s\n"
            + "\treplace-channels:\tReplace the notification channels for an alert.\n"
            + "\t\t\t\t\t\t\tArgs:\n"
            + "\t\t\t\t\t\t\t\t%s\n"
            + "\t\t\t\t\t\t\t\t%s\n"
            + "\tenable:\t\t\t\tEnable alert policies in project.\n"
            + "\t\t\t\t\t\t\tArgs:\n"
            + "\t\t\t\t\t\t\t\t%s\n"
            + "\tdisable:\t\t\tDisable alert policies in project.\n"
            + "\t\t\t\t\t\t\tArgs:\n"
            + "\t\t\t\t\t\t\t\t%s\n",
        AlertSample.class.getCanonicalName(),
        formatArgString(PROJECT_ID_OPTION),
        formatArgString(FILE_PATH_OPTION),
        formatArgString(CHANNEL_ID_OPTION),
        formatArgString(FILE_PATH_OPTION),
        formatArgString(CHANNEL_ID_OPTION),
        formatArgString(ALERT_ID_OPTION),
        formatArgString(CHANNEL_ID_OPTION),
        formatArgString(FILTER_OPTION),
        formatArgString(FILTER_OPTION));
  }

  private static String formatArgString(Option option) {
    return String.format("--%s (%s):\t%s",
        option.getLongOpt(),
        option.getOpt(),
        option.getDescription());
  }
}
