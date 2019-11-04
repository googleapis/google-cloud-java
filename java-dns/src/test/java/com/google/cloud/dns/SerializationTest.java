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

package com.google.cloud.dns;

import com.google.cloud.BaseSerializationTest;
import com.google.cloud.NoCredentials;
import com.google.cloud.Restorable;
import com.google.cloud.ServiceOptions;
import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

public class SerializationTest extends BaseSerializationTest {

  private static final ZoneInfo FULL_ZONE_INFO =
      Zone.of("some zone name", "www.example.com", "some descriptions")
          .toBuilder()
          .setCreationTimeMillis(132L)
          .setGeneratedId("123333")
          .setNameServers(ImmutableList.of("server 1", "server 2"))
          .setNameServerSet("specificationstring")
          .build();
  private static final ZoneInfo PARTIAL_ZONE_INFO =
      Zone.of("some zone name", "www.example.com", "some descriptions").toBuilder().build();
  private static final ProjectInfo PARTIAL_PROJECT_INFO =
      ProjectInfo.newBuilder().setId("13").build();
  private static final ProjectInfo FULL_PROJECT_INFO =
      ProjectInfo.newBuilder()
          .setId("342")
          .setNumber(new BigInteger("2343245"))
          .setQuota(new ProjectInfo.Quota(12, 13, 14, 15, 16, 17))
          .build();
  private static final Dns.ZoneListOption ZONE_LIST_OPTION =
      Dns.ZoneListOption.dnsName("www.example.com.");
  private static final Dns.RecordSetListOption RECORD_SET_LIST_OPTION =
      Dns.RecordSetListOption.fields(Dns.RecordSetField.TTL);
  private static final Dns.ChangeRequestListOption CHANGE_REQUEST_LIST_OPTION =
      Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.STATUS);
  private static final Dns.ZoneOption ZONE_OPTION =
      Dns.ZoneOption.fields(Dns.ZoneField.CREATION_TIME);
  private static final Dns.ChangeRequestOption CHANGE_REQUEST_OPTION =
      Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS);
  private static final Dns.ProjectOption PROJECT_OPTION =
      Dns.ProjectOption.fields(Dns.ProjectField.QUOTA);
  private static final DnsOptions OPTIONS =
      DnsOptions.newBuilder()
          .setProjectId("some-unnecessary-project-ID")
          .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
          .build();
  private static final Dns DNS = OPTIONS.getService();
  private static final Zone FULL_ZONE = new Zone(DNS, new ZoneInfo.BuilderImpl(FULL_ZONE_INFO));
  private static final Zone PARTIAL_ZONE =
      new Zone(DNS, new ZoneInfo.BuilderImpl(PARTIAL_ZONE_INFO));
  private static final ChangeRequestInfo CHANGE_REQUEST_INFO_PARTIAL =
      ChangeRequest.newBuilder().build();
  private static final ChangeRequest CHANGE_REQUEST_PARTIAL =
      new ChangeRequest(
          DNS, "name", new ChangeRequestInfo.BuilderImpl(CHANGE_REQUEST_INFO_PARTIAL));
  private static final RecordSet RECORD_SET_PARTIAL =
      RecordSet.newBuilder("www.www.com", RecordSet.Type.AAAA).build();
  private static final RecordSet RECORD_SET_COMPLETE =
      RecordSet.newBuilder("www.sadfa.com", RecordSet.Type.A)
          .setTtl(12, TimeUnit.HOURS)
          .addRecord("record")
          .build();
  private static final ChangeRequestInfo CHANGE_REQUEST_INFO_COMPLETE =
      ChangeRequestInfo.newBuilder()
          .add(RECORD_SET_COMPLETE)
          .delete(RECORD_SET_PARTIAL)
          .setStatus(ChangeRequest.Status.PENDING)
          .setGeneratedId("some id")
          .setStartTime(132L)
          .build();
  private static final ChangeRequest CHANGE_REQUEST_COMPLETE =
      new ChangeRequest(
          DNS, "name", new ChangeRequestInfo.BuilderImpl(CHANGE_REQUEST_INFO_COMPLETE));

  @Override
  protected Serializable[] serializableObjects() {
    DnsOptions options =
        DnsOptions.newBuilder()
            .setCredentials(NoCredentials.getInstance())
            .setProjectId("id1")
            .build();
    DnsOptions otherOptions = options.toBuilder().build();
    return new Serializable[] {
      FULL_ZONE_INFO,
      PARTIAL_ZONE_INFO,
      ZONE_LIST_OPTION,
      RECORD_SET_LIST_OPTION,
      CHANGE_REQUEST_LIST_OPTION,
      ZONE_OPTION,
      CHANGE_REQUEST_OPTION,
      PROJECT_OPTION,
      PARTIAL_PROJECT_INFO,
      FULL_PROJECT_INFO,
      OPTIONS,
      FULL_ZONE,
      PARTIAL_ZONE,
      OPTIONS,
      CHANGE_REQUEST_INFO_PARTIAL,
      CHANGE_REQUEST_PARTIAL,
      RECORD_SET_PARTIAL,
      RECORD_SET_COMPLETE,
      CHANGE_REQUEST_INFO_COMPLETE,
      CHANGE_REQUEST_COMPLETE,
      options,
      otherOptions
    };
  }

  @Override
  protected Restorable<?>[] restorableObjects() {
    return new Restorable<?>[0];
  }
}
