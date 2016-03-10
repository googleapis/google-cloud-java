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
import com.google.gcloud.dns.DnsRecord;
import com.google.gcloud.dns.Zone;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * A snippet for Google Cloud DNS showing how to create a DNS records.
 */
public class CreateAndListDnsRecords {

  public static void main(String... args) {
    // Create a service object.
    // The project ID and credentials will be inferred from the environment.
    Dns dns = DnsOptions.defaultInstance().service();

    // Change this to a zone name that exists within your project
    String zoneName = "some-sample-zone";

    // Get zone from the service
    Zone zone = dns.getZone(zoneName);

    // Prepare a <i>www.<zone-domain>.</i> type A record with ttl of 24 hours
    String ip = "12.13.14.15";
    DnsRecord toCreate = DnsRecord.builder("www." + zone.dnsName(), DnsRecord.Type.A)
        .ttl(24, TimeUnit.HOURS)
        .addRecord(ip)
        .build();

    // Make a change
    ChangeRequest.Builder changeBuilder = ChangeRequest.builder().add(toCreate);

    // Verify a www.<zone-domain>. type A record does not exist yet.
    // If it does exist, we will overwrite it with our prepared record.
    Iterator<DnsRecord> recordIterator = zone.listDnsRecords().iterateAll();
    while (recordIterator.hasNext()) {
      DnsRecord current = recordIterator.next();
      if (toCreate.name().equals(current.name()) && toCreate.type().equals(current.type())) {
        changeBuilder.delete(current);
      }
    }

    // Build and apply the change request to our zone
    zone.applyChangeRequest(changeBuilder.build());
  }
}
