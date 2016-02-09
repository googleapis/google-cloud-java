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

package com.google.gcloud.dns;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.RetryParams;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

public class SerializationTest {

  private static final ZoneInfo FULL_ZONE_INFO = Zone.builder("some zone name")
      .creationTimeMillis(132L)
      .description("some descriptions")
      .dnsName("www.example.com")
      .id("123333")
      .nameServers(ImmutableList.of("server 1", "server 2"))
      .nameServerSet("specificationstring")
      .build();
  private static final ZoneInfo PARTIAL_ZONE_INFO = Zone.builder("some zone name")
      .build();
  private static final ProjectInfo PARTIAL_PROJECT_INFO = ProjectInfo.builder().id("13").build();
  private static final ProjectInfo FULL_PROJECT_INFO = ProjectInfo.builder()
      .id("342")
      .number(new BigInteger("2343245"))
      .quota(new ProjectInfo.Quota(12, 13, 14, 15, 16, 17))
      .build();
  private static final Dns.ZoneListOption ZONE_LIST_OPTION =
      Dns.ZoneListOption.dnsName("www.example.com.");
  private static final Dns.DnsRecordListOption DNS_REOCRD_LIST_OPTION =
      Dns.DnsRecordListOption.fields(Dns.DnsRecordField.TTL);
  private static final Dns.ChangeRequestListOption CHANGE_REQUEST_LIST_OPTION =
      Dns.ChangeRequestListOption.fields(Dns.ChangeRequestField.STATUS);
  private static final Dns.ZoneOption ZONE_OPTION =
      Dns.ZoneOption.fields(Dns.ZoneField.CREATION_TIME);
  private static final Dns.ChangeRequestOption CHANGE_REQUEST_OPTION =
      Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS);
  private static final Dns.ProjectOption PROJECT_OPTION =
      Dns.ProjectOption.fields(Dns.ProjectField.QUOTA);
  private static final DnsOptions OPTIONS = DnsOptions.builder()
      .projectId("some-unnecessary-project-ID")
      .retryParams(RetryParams.defaultInstance())
      .build();
  private static final Dns DNS = OPTIONS.service();
  private static final Zone FULL_ZONE = new Zone(DNS, new ZoneInfo.BuilderImpl(FULL_ZONE_INFO));
  private static final Zone PARTIAL_ZONE =
      new Zone(DNS, new ZoneInfo.BuilderImpl(PARTIAL_ZONE_INFO));
  private static final ChangeRequest CHANGE_REQUEST_PARTIAL = ChangeRequest.builder().build();
  private static final DnsRecord DNS_RECORD_PARTIAL =
      DnsRecord.builder("www.www.com", DnsRecord.Type.AAAA).build();
  private static final DnsRecord DNS_RECORD_COMPLETE =
      DnsRecord.builder("www.sadfa.com", DnsRecord.Type.A)
          .ttl(12, TimeUnit.HOURS)
          .addRecord("record")
          .build();
  private static final ChangeRequest CHANGE_REQUEST_COMPLETE = ChangeRequest.builder()
      .add(DNS_RECORD_COMPLETE)
      .delete(DNS_RECORD_PARTIAL)
      .status(ChangeRequest.Status.PENDING)
      .id("some id")
      .startTimeMillis(132L)
      .build();


  @Test
  public void testModelAndRequests() throws Exception {
    Serializable[] objects = {FULL_ZONE_INFO, PARTIAL_ZONE_INFO, ZONE_LIST_OPTION,
        DNS_REOCRD_LIST_OPTION, CHANGE_REQUEST_LIST_OPTION, ZONE_OPTION, CHANGE_REQUEST_OPTION,
        PROJECT_OPTION, PARTIAL_PROJECT_INFO, FULL_PROJECT_INFO, OPTIONS, FULL_ZONE, PARTIAL_ZONE,
        OPTIONS, CHANGE_REQUEST_PARTIAL, DNS_RECORD_PARTIAL, DNS_RECORD_COMPLETE,
        CHANGE_REQUEST_COMPLETE};
    for (Serializable obj : objects) {
      Object copy = serializeAndDeserialize(obj);
      assertEquals(obj, obj);
      assertEquals(obj, copy);
      assertNotSame(obj, copy);
      assertEquals(copy, copy);
    }
  }

  @SuppressWarnings("unchecked")
  private <T> T serializeAndDeserialize(T obj) throws IOException, ClassNotFoundException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
      output.writeObject(obj);
    }
    try (ObjectInputStream input =
             new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()))) {
      return (T) input.readObject();
    }
  }
}
