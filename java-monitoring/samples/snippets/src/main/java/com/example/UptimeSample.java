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

import com.google.api.MonitoredResource;
import com.google.cloud.monitoring.v3.UptimeCheckServiceClient;
import com.google.cloud.monitoring.v3.UptimeCheckServiceClient.ListUptimeCheckConfigsPagedResponse;
import com.google.cloud.monitoring.v3.UptimeCheckServiceClient.ListUptimeCheckIpsPagedResponse;
import com.google.common.base.Strings;
import com.google.monitoring.v3.CreateUptimeCheckConfigRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsRequest;
import com.google.monitoring.v3.ListUptimeCheckIpsRequest;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.UpdateUptimeCheckConfigRequest;
import com.google.monitoring.v3.UptimeCheckConfig;
import com.google.monitoring.v3.UptimeCheckConfig.HttpCheck;
import com.google.monitoring.v3.UptimeCheckConfigName;
import com.google.monitoring.v3.UptimeCheckIp;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;

import java.io.IOException;
import java.util.Optional;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class UptimeSample {

  private static final Option PROJECT_ID_OPTION = Option.builder("p")
      .longOpt("projectid")
      .desc("Your Google project id.")
      .hasArg()
      .argName("PROJECT_ID")
      .build();
  private static final Option DISPLAY_NAME_OPTION = Option.builder("n")
      .longOpt("name")
      .desc("[create/get/delete]: Display name of uptime check.")
      .hasArg()
      .argName("DISPLAY_NAME")
      .required(false)
      .build();
  private static final Option HOST_NAME_OPTION = Option.builder("o")
      .longOpt("hostname")
      .desc("[create]: Host name of uptime check to create.")
      .hasArg()
      .argName("HOST_NAME")
      .required(false)
      .build();
  private static final Option PATH_NAME_OPTION = Option.builder("a")
      .longOpt("pathname")
      .desc("[create/update]: Path name of uptime check to create/update.")
      .hasArg()
      .argName("HOST_NAME")
      .required(false)
      .build();

  private static final Options OPTIONS = new Options()
      .addOption(PROJECT_ID_OPTION)
      .addOption(DISPLAY_NAME_OPTION)
      .addOption(HOST_NAME_OPTION)
      .addOption(PATH_NAME_OPTION);

  private static final CommandLineParser PARSER = new DefaultParser();

  public static void main(String... args) throws IOException {
    CommandLine cl;
    try {
      cl = PARSER.parse(OPTIONS, args);
    } catch (ParseException pe) {
      usage("Exception parsing command line arguments.");
      throw new RuntimeException("Exception parsing command line arguments.", pe);
    }

    String projectId = cl.getOptionValue(
        PROJECT_ID_OPTION.getOpt(),
        System.getenv("GOOGLE_CLOUD_PROJECT"));

    String command = Optional
        .of(cl.getArgList())
        .filter(l -> l.size() > 0)
        .map(l -> Strings.emptyToNull(l.get(0)))
        .orElse(null);
    if (command == null) {
      usage(null);
      return;
    }

    switch (command.toLowerCase()) {
      case "create":
        createUptimeCheck(
            projectId,
            cl.getOptionValue(DISPLAY_NAME_OPTION.getOpt(), "new uptime check"),
            cl.getOptionValue(HOST_NAME_OPTION.getOpt(), "example.com"),
            cl.getOptionValue(PATH_NAME_OPTION.getOpt(), "/")
        );
        break;
      case "update":
        updateUptimeCheck(
            projectId,
            cl.getOptionValue(DISPLAY_NAME_OPTION.getOpt(), "new uptime check"),
            cl.getOptionValue(HOST_NAME_OPTION.getOpt(), "example.com"),
            cl.getOptionValue(PATH_NAME_OPTION.getOpt(), "/")
        );
        break;
      case "list":
        listUptimeChecks(projectId);
        break;
      case "listips":
        listUptimeCheckIPs();
        break;
      case "get":
        getUptimeCheckConfig(
            projectId,
            cl.getOptionValue(DISPLAY_NAME_OPTION.getOpt(), "new uptime check"));
        break;
      case "delete":
        deleteUptimeCheckConfig(
            projectId,
            cl.getOptionValue(DISPLAY_NAME_OPTION.getOpt(), "new uptime check"));
        break;
      default:
        usage(null);
    }
  }

  // [START monitoring_uptime_check_create]]
  private static void createUptimeCheck(
      String projectId, String displayName, String hostName, String pathName) throws IOException {
    CreateUptimeCheckConfigRequest request = CreateUptimeCheckConfigRequest
        .newBuilder()
        .setParent(ProjectName.format(projectId))
        .setUptimeCheckConfig(UptimeCheckConfig
            .newBuilder()
            .setDisplayName(displayName)
            .setMonitoredResource(MonitoredResource
                .newBuilder()
                .setType("uptime_url")
                .putLabels("host", hostName))
            .setHttpCheck(HttpCheck
                .newBuilder()
                .setPath(pathName)
                .setPort(80))
            .setTimeout(Duration.newBuilder().setSeconds(10))
            .setPeriod(Duration.newBuilder().setSeconds(300)))
        .build();
    try (UptimeCheckServiceClient client = UptimeCheckServiceClient.create()) {
      UptimeCheckConfig config = client.createUptimeCheckConfig(request);
      System.out.println("Uptime check created: " + config.getDisplayName());
    } catch (Exception e) {
      usage("Exception creating uptime check: " + e.toString());
      throw e;
    }
  }
  // [END monitoring_uptime_check_create]]

  // [START monitoring_uptime_check_update]]
  private static void updateUptimeCheck(
      String projectId, String displayName, String hostName, String pathName) throws IOException {
    String fullCheckName = UptimeCheckConfigName.format(projectId, displayName);

    UpdateUptimeCheckConfigRequest request = UpdateUptimeCheckConfigRequest
        .newBuilder()
        .setUpdateMask(FieldMask
            .newBuilder()
            .addPaths("http_check.path"))
        .setUptimeCheckConfig(UptimeCheckConfig
            .newBuilder()
            .setName(fullCheckName)
            .setMonitoredResource(MonitoredResource
                .newBuilder()
                .setType("uptime_url")
                .putLabels("host", hostName))
            .setHttpCheck(HttpCheck
                .newBuilder()
                .setPath(pathName)
                .setPort(80))
            .setTimeout(Duration.newBuilder().setSeconds(10))
            .setPeriod(Duration.newBuilder().setSeconds(300)))
        .build();
    try (UptimeCheckServiceClient client = UptimeCheckServiceClient.create()) {
      UptimeCheckConfig config = client.updateUptimeCheckConfig(request);
      System.out.println("Uptime check updated: \n" + config.toString());
    } catch (Exception e) {
      usage("Exception updating uptime check: " + e.toString());
      throw e;
    }
  }
  // [END monitoring_uptime_check_update]]

  // [START monitoring_uptime_check_list_configs]]
  private static void listUptimeChecks(String projectId) throws IOException {
    ListUptimeCheckConfigsRequest request = ListUptimeCheckConfigsRequest
        .newBuilder()
        .setParent(ProjectName.format(projectId))
        .build();
    try (UptimeCheckServiceClient client = UptimeCheckServiceClient.create()) {
      ListUptimeCheckConfigsPagedResponse response = client.listUptimeCheckConfigs(request);
      for (UptimeCheckConfig config : response.iterateAll()) {
        System.out.println(config.getDisplayName());
      }
    } catch (Exception e) {
      usage("Exception listing uptime checks: " + e.toString());
      throw e;
    }
  }
  // [END monitoring_uptime_check_list_configs]]

  // [START monitoring_uptime_check_list_ips]]
  private static void listUptimeCheckIPs() throws IOException {
    try (UptimeCheckServiceClient client = UptimeCheckServiceClient.create()) {
      ListUptimeCheckIpsPagedResponse response =
          client.listUptimeCheckIps(ListUptimeCheckIpsRequest.newBuilder().build());
      for (UptimeCheckIp config : response.iterateAll()) {
        System.out.println(config.getRegion() + " - " + config.getIpAddress());
      }
    } catch (Exception e) {
      usage("Exception listing uptime IPs: " + e.toString());
      throw e;
    }
  }
  // [END monitoring_uptime_check_list_ips]]

  // [START monitoring_uptime_check_get]]
  private static void getUptimeCheckConfig(String projectId, String checkName) throws IOException {
    try (UptimeCheckServiceClient client = UptimeCheckServiceClient.create()) {
      String fullCheckName = UptimeCheckConfigName.format(projectId, checkName);
      UptimeCheckConfig config = client.getUptimeCheckConfig(fullCheckName);
      if (config != null) {
        System.out.println(config.toString());
      } else {
        System.out.println(
            "No uptime check config found with name " + checkName + " in project " + projectId);
      }
    } catch (Exception e) {
      usage("Exception getting uptime check: " + e.toString());
      throw e;
    }
  }
  // [END monitoring_uptime_check_get]]

  // [START monitoring_uptime_check_delete]]
  private static void deleteUptimeCheckConfig(String projectId, String checkName)
      throws IOException {
    try (UptimeCheckServiceClient client = UptimeCheckServiceClient.create()) {
      client.deleteUptimeCheckConfig(UptimeCheckConfigName.format(projectId, checkName));
    } catch (Exception e) {
      usage("Exception deleting uptime check: " + e.toString());
      throw e;
    }
  }
  // [END monitoring_uptime_check_delete]]

  private static void usage(String message) {
    Optional.ofNullable(message).ifPresent(System.out::println);
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp("[create|list|listIPs|get|delete]",
        "Performs operations on monitoring uptime checks.", OPTIONS, "", true);
  }
}
