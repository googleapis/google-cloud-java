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

package com.google.gcloud.examples.dns.snippets;

import com.google.gcloud.dns.ChangeRequest;
import com.google.gcloud.dns.Dns;
import com.google.gcloud.dns.DnsOptions;
import com.google.gcloud.dns.RecordSet;
import com.google.gcloud.dns.Zone;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * A snippet for Google Cloud DNS showing how to create and update a resource record set.
 */
public class CreateOrUpdateRecordSets {

  public static void main(String... args) {
    // Create a service object.
    // The project ID and credentials will be inferred from the environment.
    Dns dns = DnsOptions.defaultInstance().service();

    // Change this to a zone name that exists within your project
    String zoneName = "my-unique-zone";

    // Get zone from the service
    Zone zone = dns.getZone(zoneName);

    // Prepare a <i>www.<zone-domain>.</i> type A record set with ttl of 24 hours
    String ip = "12.13.14.15";
    RecordSet toCreate = RecordSet.builder("www." + zone.dnsName(), RecordSet.Type.A)
        .ttl(24, TimeUnit.HOURS)
        .addRecord(ip)
        .build();

    // Make a change
    ChangeRequest.Builder changeBuilder = ChangeRequest.builder().add(toCreate);

    // Verify a www.<zone-domain>. type A record does not exist yet.
    // If it does exist, we will overwrite it with our prepared record.
    Iterator<RecordSet> recordSetIterator = zone.listRecordSets().iterateAll();
    while (recordSetIterator.hasNext()) {
      RecordSet current = recordSetIterator.next();
      if (toCreate.name().equals(current.name()) && toCreate.type().equals(current.type())) {
        changeBuilder.delete(current);
      }
    }

    // Build and apply the change request to our zone
    ChangeRequest changeRequest = changeBuilder.build();
    zone.applyChangeRequest(changeRequest);
  }
}
