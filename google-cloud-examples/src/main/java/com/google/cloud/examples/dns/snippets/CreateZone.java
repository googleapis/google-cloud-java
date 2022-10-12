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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in README's and javadoc. Any change to this file should be reflected in
 * the project's README's and package-info.java.
 */

package com.google.cloud.examples.dns.snippets;

import com.google.cloud.dns.Dns;
import com.google.cloud.dns.DnsOptions;
import com.google.cloud.dns.Zone;
import com.google.cloud.dns.ZoneInfo;

/**
 * A snippet for Google Cloud DNS showing how to create a zone. You will need to change the {@code
 * domainName} to a domain name, the ownership of which you should verify with Google.
 */
public class CreateZone {

  public static void main(String... args) {
    // Create a service object
    // The project ID and credentials will be inferred from the environment.
    Dns dns = DnsOptions.getDefaultInstance().getService();

    // Create a zone metadata object
    String zoneName = "my-unique-zone"; // Change this zone name which is unique within your project
    String domainName = "someexampledomain.com."; // Change this to a domain which you own
    String description = "This is a google-cloud-dns sample zone.";
    ZoneInfo zoneInfo = ZoneInfo.of(zoneName, domainName, description);

    // Create zone in Google Cloud DNS
    Zone zone = dns.create(zoneInfo);
    System.out.printf("Zone was created and assigned ID %s.%n", zone.getGeneratedId());
  }
}
