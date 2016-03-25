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

/**
 * A client to the Google Cloud DNS.
 *
 * <p>Here are two simple usage examples from within Compute/App Engine.
 *
 * The first snippet shows how to create a zone resource. The complete source code can be found on
 * <a href="https://github.com/GoogleCloudPlatform/gcloud-java/tree/master/gcloud-java-examples/src/main/java/com/google/gcloud/examples/dns/snippets/CreateAndListZones.java">
 * CreateAndListZones.java</a>. Note that you need to replace the {@code domainName} with a domain
 * name that you own and the ownership of which you verified with Google.
 *
 * <pre> {@code
 * Dns dns = DnsOptions.defaultInstance().service();
 * String zoneName = "my-unique-zone";
 * String domainName = "someexampledomain.com.";
 * String description = "This is a gcloud-java-dns sample zone.";
 * ZoneInfo zoneInfo = ZoneInfo.of(zoneName, domainName, description);
 * Zone createdZone = dns.create(zoneInfo);
 * } </pre>
 *
 * <p>The second example shows how to create records inside a zone. The complete code can be found
 * on <a href="https://github.com/GoogleCloudPlatform/gcloud-java/tree/master/gcloud-java-examples/src/main/java/com/google/gcloud/examples/dns/snippets/CreateAndListDnsRecords.java">
 * CreateAndListDnsRecords.java</a>.
 *
 * <pre> {@code
 * Dns dns = DnsOptions.defaultInstance().service();
 * String zoneName = "my-unique-zone";
 * Zone zone = dns.getZone(zoneName);
 * String ip = "12.13.14.15";
 * RecordSet toCreate = RecordSet.builder("www.someexampledomain.com.", RecordSet.Type.A)
 *   .ttl(24, TimeUnit.HOURS)
 *   .addRecord(ip)
 *   .build();
 * ChangeRequestInfo changeRequest = ChangeRequestInfo.builder().add(toCreate).build();
 * zone.applyChangeRequest(changeRequest);
 * } </pre>
 *
 * <p>When using gcloud-java from outside of App/Compute Engine, you have to <a
 * href="https://github.com/GoogleCloudPlatform/gcloud-java#specifying-a-project-id">specify a
 * project ID</a> and <a href="https://github.com/GoogleCloudPlatform/gcloud-java#authentication">provide
 * credentials</a>.
 *
 * @see <a href="https://cloud.google.com/dns/">Google Cloud DNS</a>
 */
package com.google.gcloud.dns;
