/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.examples.dns;

import com.google.cloud.dns.ChangeRequest;
import com.google.cloud.dns.ChangeRequestInfo;
import com.google.cloud.dns.Dns;
import com.google.cloud.dns.DnsOptions;
import com.google.cloud.dns.ProjectInfo;
import com.google.cloud.dns.RecordSet;
import com.google.cloud.dns.Zone;
import com.google.cloud.dns.ZoneInfo;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * An example of using Google Cloud DNS.
 *
 * <p>This example creates, deletes, gets, and lists zones. It also creates and deletes record sets
 * of type A, and lists record sets.
 *
 * <p>See the <a
 * href="https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/README.md">
 * README</a> for compilation instructions. Run this code with
 *
 * <pre>{@code target/appassembler/bin/DnsExample [<project_id>]
 * create <zone_name> <dns_name> <description> |
 * get <zone_name> |
 * delete <zone_name> |
 * list [<zone_name> [changes [descending | ascending] | records]] |
 * add-record <zone_name> <record_name> <ip> <ttl> |
 * delete-record <zone_name> <record_name> <ip> [<ttl>] |
 * quota}</pre>
 *
 * <p>The first parameter is an optional {@code project_id}. The project specified in the Google
 * Cloud SDK configuration (see {@code gcloud config list}) will be used if the project ID is not
 * supplied. The second parameter is a DNS operation (list, delete, create, ...). The remaining
 * arguments are specific to the operation. See each action's {@code run} method for the specific
 * arguments.
 */
public class DnsExample {

  private static final Map<String, DnsAction> ACTIONS = new HashMap<>();
  private static final DateTimeFormatter FORMATTER =
      DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC);

  private interface DnsAction {
    void run(Dns dns, String... args);

    String params();

    boolean check(String... args);
  }

  private static class CreateZoneAction implements DnsAction {

    /** Creates a zone with the provided name, DNS name and description (in this order). */
    @Override
    public void run(Dns dns, String... args) {
      String zoneName = args[0];
      String dnsName = args[1];
      String description = args[2];
      ZoneInfo zoneInfo = ZoneInfo.of(zoneName, dnsName, description);
      Zone zone = dns.create(zoneInfo);
      System.out.printf(
          "Successfully created zone with name %s which was assigned ID %s.%n",
          zone.getName(), zone.getGeneratedId());
    }

    @Override
    public String params() {
      return "<zone_name> <dns_name> <description>";
    }

    @Override
    public boolean check(String... args) {
      return args.length == 3;
    }
  }

  private static class ListZonesAction implements DnsAction {

    /** Lists all zones within the project. */
    @Override
    public void run(Dns dns, String... args) {
      Iterator<Zone> zoneIterator = dns.listZones().iterateAll().iterator();
      if (zoneIterator.hasNext()) {
        System.out.println("The project contains the following zones:");
        while (zoneIterator.hasNext()) {
          printZone(zoneIterator.next());
        }
      } else {
        System.out.println("Project contains no zones.");
      }
    }

    @Override
    public String params() {
      return "";
    }

    @Override
    public boolean check(String... args) {
      return args.length == 0;
    }
  }

  private static class GetZoneAction implements DnsAction {

    /** Gets details about a zone with the given name. */
    @Override
    public void run(Dns dns, String... args) {
      String zoneName = args[0];
      Zone zone = dns.getZone(zoneName);
      if (zone == null) {
        System.out.printf("No zone with name '%s' exists.%n", zoneName);
      } else {
        printZone(zone);
      }
    }

    @Override
    public String params() {
      return "<zone_name>";
    }

    @Override
    public boolean check(String... args) {
      return args.length == 1;
    }
  }

  private static class DeleteZoneAction implements DnsAction {

    /** Deletes a zone with the given name. */
    @Override
    public void run(Dns dns, String... args) {
      String zoneName = args[0];
      boolean deleted = dns.delete(zoneName);
      if (deleted) {
        System.out.printf("Zone %s was deleted.%n", zoneName);
      } else {
        System.out.printf("Zone %s was NOT deleted. It does not exist.%n", zoneName);
      }
    }

    @Override
    public String params() {
      return "<zone_name>";
    }

    @Override
    public boolean check(String... args) {
      return args.length == 1;
    }
  }

  private static class DeleteDnsRecordAction implements DnsAction {

    /**
     * Deletes a DNS record of type A from the given zone. The last parameter is ttl and it is not
     * required. If ttl is not provided, a default value of 0 is used. The service requires a
     * precise match (including ttl) for deleting a record.
     */
    @Override
    public void run(Dns dns, String... args) {
      String zoneName = args[0];
      String recordName = args[1];
      String ip = args[2];
      int ttl = 0;
      if (args.length > 3) {
        ttl = Integer.parseInt(args[3]);
      }
      RecordSet recordSet =
          RecordSet.newBuilder(recordName, RecordSet.Type.A)
              .setRecords(ImmutableList.of(ip))
              .setTtl(ttl, TimeUnit.SECONDS)
              .build();
      ChangeRequestInfo changeRequest = ChangeRequest.newBuilder().delete(recordSet).build();
      changeRequest = dns.applyChangeRequest(zoneName, changeRequest);
      System.out.printf(
          "The request for deleting A record %s for zone %s was successfully "
              + "submitted and assigned ID %s.%n",
          recordName, zoneName, changeRequest.getGeneratedId());
      System.out.print("Waiting for deletion to happen...");
      waitForChangeToFinish(dns, zoneName, changeRequest);
      System.out.printf("%nThe deletion has been completed.%n");
    }

    @Override
    public String params() {
      return "<zone_name> <record_name> <ip_address> [<ttl>]";
    }

    @Override
    public boolean check(String... args) {
      if (args.length == 4) {
        // to check that it can be parsed
        Integer.parseInt(args[3]);
        return true;
      } else {
        return args.length == 3;
      }
    }
  }

  private static class AddDnsRecordAction implements DnsAction {

    /**
     * Adds a record set of type A. The last parameter is ttl and is not required. If ttl is not
     * provided, a default value of 0 will be used.
     */
    @Override
    public void run(Dns dns, String... args) {
      String zoneName = args[0];
      String recordName = args[1];
      String ip = args[2];
      int ttl = 0;
      if (args.length > 3) {
        ttl = Integer.parseInt(args[3]);
      }
      RecordSet recordSet =
          RecordSet.newBuilder(recordName, RecordSet.Type.A)
              .setRecords(ImmutableList.of(ip))
              .setTtl(ttl, TimeUnit.SECONDS)
              .build();
      ChangeRequestInfo changeRequest = ChangeRequest.newBuilder().add(recordSet).build();
      changeRequest = dns.applyChangeRequest(zoneName, changeRequest);
      System.out.printf(
          "The request for adding A record %s for zone %s was successfully "
              + "submitted and assigned ID %s.%n",
          recordName, zoneName, changeRequest.getGeneratedId());
      System.out.print("Waiting for addition to happen...");
      waitForChangeToFinish(dns, zoneName, changeRequest);
      System.out.printf("The addition has been completed.%n");
    }

    @Override
    public String params() {
      return "<zone_name> <record_name> <ip_address> [<ttl>]";
    }

    @Override
    public boolean check(String... args) {
      if (args.length == 4) {
        // to check that it can be parsed
        Integer.parseInt(args[3]);
        return true;
      } else {
        return args.length == 3;
      }
    }
  }

  private static class ListDnsRecordsAction implements DnsAction {

    /** Lists all the record sets in the given zone. */
    @Override
    public void run(Dns dns, String... args) {
      String zoneName = args[0];
      Iterator<RecordSet> iterator = dns.listRecordSets(zoneName).iterateAll().iterator();
      if (iterator.hasNext()) {
        System.out.printf("Record sets for zone %s:%n", zoneName);
        while (iterator.hasNext()) {
          RecordSet recordSet = iterator.next();
          System.out.printf(
              "%nRecord name: %s%nTTL: %s%nRecords: %s%n",
              recordSet.getName(),
              recordSet.getTtl(),
              Joiner.on(", ").join(recordSet.getRecords()));
        }
      } else {
        System.out.printf("Zone %s has no record sets records.%n", zoneName);
      }
    }

    @Override
    public String params() {
      return "<zone_name> records";
    }

    @Override
    public boolean check(String... args) {
      return args.length == 2;
    }
  }

  private static class ListChangesAction implements DnsAction {

    /**
     * Lists all the changes for a given zone. Optionally, an order ("descending" or "ascending")
     * can be specified using the last parameter.
     */
    @Override
    public void run(Dns dns, String... args) {
      String zoneName = args[0];
      Iterator<ChangeRequest> iterator;
      if (args.length > 2) {
        Dns.SortingOrder sortOrder = Dns.SortingOrder.valueOf(args[2].toUpperCase());
        iterator =
            dns.listChangeRequests(zoneName, Dns.ChangeRequestListOption.sortOrder(sortOrder))
                .iterateAll()
                .iterator();
      } else {
        iterator = dns.listChangeRequests(zoneName).iterateAll().iterator();
      }
      if (iterator.hasNext()) {
        System.out.printf("Change requests for zone %s:%n", zoneName);
        while (iterator.hasNext()) {
          ChangeRequest change = iterator.next();
          System.out.printf("%nID: %s%n", change.getGeneratedId());
          System.out.printf("Status: %s%n", change.status());
          System.out.printf(
              "Started: %s%n", FORMATTER.format(Instant.ofEpochMilli(change.getStartTimeMillis())));
          System.out.printf("Deletions: %s%n", Joiner.on(", ").join(change.getDeletions()));
          System.out.printf("Additions: %s%n", Joiner.on(", ").join(change.getAdditions()));
        }
      } else {
        System.out.printf("Zone %s has no change requests.%n", zoneName);
      }
    }

    @Override
    public String params() {
      return "<zone_name> changes [descending | ascending]";
    }

    @Override
    public boolean check(String... args) {
      return args.length == 2
          || (args.length == 3
              && ImmutableList.of("descending", "ascending").contains(args[2].toLowerCase()));
    }
  }

  private static class ListAction implements DnsAction {

    /**
     * Invokes a list action. If no parameter is provided, lists all zones. If zone name is the only
     * parameter provided, lists both record sets and changes. Otherwise, invokes listing changes or
     * zones based on the parameter provided.
     */
    @Override
    public void run(Dns dns, String... args) {
      if (args.length == 0) {
        new ListZonesAction().run(dns);
      } else {
        if (args.length == 1 || "records".equals(args[1])) {
          new ListDnsRecordsAction().run(dns, args);
        }
        if (args.length == 1 || "changes".equals(args[1])) {
          new ListChangesAction().run(dns, args);
        }
      }
    }

    @Override
    public boolean check(String... args) {
      if (args.length == 0 || args.length == 1) {
        return true;
      }
      if ("records".equals(args[1])) {
        return new ListDnsRecordsAction().check(args);
      }
      if ("changes".equals(args[1])) {
        return new ListChangesAction().check(args);
      }
      return false;
    }

    @Override
    public String params() {
      return "[<zone_name> [changes [descending | ascending] | records]]";
    }
  }

  private static class GetProjectAction implements DnsAction {

    @Override
    public void run(Dns dns, String... args) {
      ProjectInfo project = dns.getProject();
      ProjectInfo.Quota quota = project.getQuota();
      System.out.printf("Project id: %s%nQuota:%n", dns.getOptions().getProjectId());
      System.out.printf("\tZones: %d%n", quota.getZones());
      System.out.printf("\tRecord sets per zone: %d%n", quota.getRrsetsPerZone());
      System.out.printf("\tRecord sets per DNS record: %d%n", quota.getResourceRecordsPerRrset());
      System.out.printf("\tAdditions per change: %d%n", quota.getRrsetAdditionsPerChange());
      System.out.printf("\tDeletions per change: %d%n", quota.getRrsetDeletionsPerChange());
      System.out.printf("\tTotal data size per change: %d%n", quota.getTotalRrdataSizePerChange());
    }

    @Override
    public String params() {
      return "";
    }

    @Override
    public boolean check(String... args) {
      return args.length == 0;
    }
  }

  static {
    ACTIONS.put("create", new CreateZoneAction());
    ACTIONS.put("delete", new DeleteZoneAction());
    ACTIONS.put("get", new GetZoneAction());
    ACTIONS.put("list", new ListAction());
    ACTIONS.put("add-record", new AddDnsRecordAction());
    ACTIONS.put("delete-record", new DeleteDnsRecordAction());
    ACTIONS.put("quota", new GetProjectAction());
  }

  private static void printZone(Zone zone) {
    System.out.printf("%nName: %s%n", zone.getName());
    System.out.printf("ID: %s%n", zone.getGeneratedId());
    System.out.printf("Description: %s%n", zone.getDescription());
    System.out.printf(
        "Created: %s%n", FORMATTER.format(Instant.ofEpochMilli(zone.getCreationTimeMillis())));
    System.out.printf("Name servers: %s%n", Joiner.on(", ").join(zone.getNameServers()));
  }

  private static ChangeRequestInfo waitForChangeToFinish(
      Dns dns, String zoneName, ChangeRequestInfo request) {
    ChangeRequestInfo current = request;
    while (current.status().equals(ChangeRequest.Status.PENDING)) {
      System.out.print(".");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        System.err.println("Thread was interrupted while waiting.");
      }
      current = dns.getChangeRequest(zoneName, current.getGeneratedId());
    }
    return current;
  }

  private static void printUsage() {
    StringBuilder actionAndParams = new StringBuilder();
    for (Map.Entry<String, DnsAction> entry : ACTIONS.entrySet()) {
      actionAndParams.append(System.lineSeparator()).append('\t').append(entry.getKey());
      String param = entry.getValue().params();
      if (param != null && !param.isEmpty()) {
        actionAndParams.append(' ').append(param);
      }
    }
    System.out.printf(
        "Usage: %s [<project_id>] operation <args>*%s%n",
        DnsExample.class.getSimpleName(), actionAndParams);
  }

  public static void main(String... args) throws Exception {
    if (args.length < 1) {
      System.out.println("Missing required action");
      printUsage();
      return;
    }
    String projectId = null;
    DnsAction action;
    String actionName;
    if (args.length >= 2 && !ACTIONS.containsKey(args[0])) {
      actionName = args[1];
      projectId = args[0];
      args = Arrays.copyOfRange(args, 2, args.length);
    } else {
      actionName = args[0];
      args = Arrays.copyOfRange(args, 1, args.length);
    }
    action = ACTIONS.get(actionName);
    if (action == null) {
      System.out.printf("Unrecognized action %s.%n", actionName);
      printUsage();
      return;
    }
    boolean valid = false;
    try {
      valid = action.check(args);
    } catch (NumberFormatException ex) {
      System.out.printf("Invalid input for action '%s'.%n", actionName);
      System.out.println("Ttl must be an integer.");
      System.out.printf("Expected: %s%n", action.params());
      return;
    } catch (Exception ex) {
      System.out.println("Failed to parse request.");
      System.out.printf("Expected: %s%n", action.params());
      ex.printStackTrace();
      return;
    }
    if (valid) {
      DnsOptions.Builder optionsBuilder = DnsOptions.newBuilder();
      if (projectId != null) {
        optionsBuilder.setProjectId(projectId);
      }
      Dns dns = optionsBuilder.build().getService();
      action.run(dns, args);
    } else {
      System.out.printf("Invalid input for action '%s'%n", actionName);
      System.out.printf("Expected: %s%n", action.params());
    }
  }
}
