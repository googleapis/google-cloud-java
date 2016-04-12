/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in README's and javadoc. Any change to this file should be reflected in
 * the project's README's and package-info.java.
 */

package com.google.cloud.examples.dns.snippets;

import com.google.cloud.dns.ChangeRequest;
import com.google.cloud.dns.ChangeRequestInfo;
import com.google.cloud.dns.Dns;
import com.google.cloud.dns.DnsOptions;
import com.google.cloud.dns.RecordSet;
import com.google.cloud.dns.Zone;
import com.google.cloud.dns.ZoneInfo;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * A complete snippet for Google Cloud DNS showing how to create and delete a zone. It also shows
 * how to create, list and delete record sets, and how to list changes.
 */
public class ManipulateZonesAndRecordSets {

  public static void main(String... args) {
    Dns dns = DnsOptions.defaultInstance().service();

    // Create a zone metadata object
    String zoneName = "my-unique-zone"; // Change this zone name which is unique within your project
    String domainName = "someexampledomain.com."; // Change this to a domain which you own
    String description = "This is a gcloud-java-dns sample zone.";
    ZoneInfo zoneInfo = ZoneInfo.of(zoneName, domainName, description);

    // Create zone in Google Cloud DNS
    Zone zone = dns.create(zoneInfo);
    System.out.printf("Zone was created and assigned ID %s.%n", zone.generatedId());

    // Print assigned name servers
    List<String> nameServers = zone.nameServers();
    for (String nameServer : nameServers) {
      System.out.println(nameServer);
    }

    // Prepare a www.someexampledomain.com. type A record with ttl of 24 hours
    String ip = "12.13.14.15";
    RecordSet toCreate = RecordSet.builder("www.someexampledomain.com.", RecordSet.Type.A)
        .ttl(24, TimeUnit.HOURS)
        .addRecord(ip)
        .build();

    // Make a change
    ChangeRequestInfo.Builder changeBuilder = ChangeRequestInfo.builder().add(toCreate);

    // Verify the type A record does not exist yet.
    // If it does exist, we will overwrite it with our prepared record.
    Iterator<RecordSet> recordSetIterator = zone.listRecordSets().iterateAll();
    while (recordSetIterator.hasNext()) {
      RecordSet current = recordSetIterator.next();
      if (toCreate.name().equals(current.name()) && toCreate.type().equals(current.type())) {
        changeBuilder.delete(current);
      }
    }

    // Build and apply the change request to our zone
    ChangeRequestInfo changeRequest = changeBuilder.build();
    zone.applyChangeRequest(changeRequest);

    while (ChangeRequestInfo.Status.PENDING.equals(changeRequest.status())) {
      try {
        Thread.sleep(500L);
      } catch (InterruptedException e) {
        System.err.println("The thread was interrupted while waiting...");
      }
      changeRequest = dns.getChangeRequest(zone.name(), changeRequest.generatedId());
    }
    System.out.println("The change request has been applied.");

    // List all your zones
    Iterator<Zone> zoneIterator = dns.listZones().iterateAll();
    int counter = 1;
    while (zoneIterator.hasNext()) {
      System.out.printf("#%d.: %s%n%n", counter, zoneIterator.next());
      counter++;
    }

    // List the record sets in a particular zone
    recordSetIterator = zone.listRecordSets().iterateAll();
    System.out.println(String.format("Record sets inside %s:", zone.name()));
    while (recordSetIterator.hasNext()) {
      System.out.println(recordSetIterator.next());
    }

    // List the change requests applied to a particular zone
    Iterator<ChangeRequest> changeIterator = zone.listChangeRequests().iterateAll();
    System.out.println(String.format("The history of changes in %s:", zone.name()));
    while (changeIterator.hasNext()) {
      System.out.println(changeIterator.next());
    }

    // Make a change for deleting the record sets
    changeBuilder = ChangeRequestInfo.builder();
    while (recordSetIterator.hasNext()) {
      RecordSet current = recordSetIterator.next();
      // SOA and NS records cannot be deleted
      if (!RecordSet.Type.SOA.equals(current.type()) && !RecordSet.Type.NS.equals(current.type())) {
        changeBuilder.delete(current);
      }
    }

    // Build and apply the change request to our zone if it contains records to delete
    changeRequest = changeBuilder.build();
    if (!changeRequest.deletions().isEmpty()) {
      ChangeRequest pendingRequest = dns.applyChangeRequest(zoneName, changeRequest);

      // Wait for the change request to complete
      while (!pendingRequest.isDone()) {
        System.out.println("Waiting for change to complete. Going to sleep for 500ms...");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          System.err.println("The thread was interrupted while waiting for change request to be "
              + "processed.");
        }
      }
    }

    // Delete the zone
    boolean result = dns.delete(zoneName);
    if (result) {
      System.out.println("Zone was deleted.");
    } else {
      System.out.println("Zone was not deleted because it does not exist.");
    }
  }
}
