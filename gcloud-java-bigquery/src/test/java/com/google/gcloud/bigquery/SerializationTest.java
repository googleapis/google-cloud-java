/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.AuthCredentials;
import com.google.gcloud.RetryParams;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class SerializationTest {

  private static final Acl DOMAIN_ACCESS =
      new Acl(new Acl.Domain("domain"), Acl.Role.WRITER);
  private static final Acl GROUP_ACCESS =
      new Acl(Acl.Group.ofAllAuthenticatedUsers(), Acl.Role.READER);
  private static final Acl USER_ACCESS = new Acl(new Acl.User("user"), Acl.Role.OWNER);
  private static final Acl VIEW_ACCESS =
      new Acl(new Acl.View(TableId.of("project", "dataset", "table")), Acl.Role.WRITER);
  private static final List<Acl> ACCESS_RULES = ImmutableList.of(DOMAIN_ACCESS, GROUP_ACCESS,
      VIEW_ACCESS, USER_ACCESS);
  private static final Long CREATION_TIME = System.currentTimeMillis() - 10;
  private static final Long DEFAULT_TABLE_EXPIRATION = 100L;
  private static final String DESCRIPTION = "Description";
  private static final String ETAG = "0xFF00";
  private static final String FRIENDLY_NAME = "friendlyDataset";
  private static final String ID = "P/D:1";
  private static final Long LAST_MODIFIED = CREATION_TIME + 50;
  private static final String LOCATION = "";
  private static final String SELF_LINK = "http://bigquery/p/d";
  private static final DatasetId DATASET_ID = DatasetId.of("project", "dataset");
  private static final DatasetInfo DATASET_INFO = DatasetInfo.builder(DATASET_ID)
      .acl(ACCESS_RULES)
      .creationTime(CREATION_TIME)
      .defaultTableLifetime(DEFAULT_TABLE_EXPIRATION)
      .description(DESCRIPTION)
      .etag(ETAG)
      .friendlyName(FRIENDLY_NAME)
      .id(ID)
      .lastModified(LAST_MODIFIED)
      .location(LOCATION)
      .selfLink(SELF_LINK)
      .build();
  private static final TableId TABLE_ID = TableId.of("project", "dataset", "table");

  @Test
  public void testServiceOptions() throws Exception {
    BigQueryOptions options = BigQueryOptions.builder()
        .projectId("p1")
        .authCredentials(AuthCredentials.createForAppEngine())
        .build();
    BigQueryOptions serializedCopy = serializeAndDeserialize(options);
    assertEquals(options, serializedCopy);

    options = options.toBuilder()
        .projectId("p2")
        .retryParams(RetryParams.getDefaultInstance())
        .authCredentials(AuthCredentials.noCredentials())
        .build();
    serializedCopy = serializeAndDeserialize(options);
    assertEquals(options, serializedCopy);
  }

  @Test
  public void testModelAndRequests() throws Exception {
    Serializable[] objects = {DOMAIN_ACCESS, GROUP_ACCESS, USER_ACCESS, VIEW_ACCESS, DATASET_ID,
        DATASET_INFO, TABLE_ID};
    for (Serializable obj : objects) {
      Object copy = serializeAndDeserialize(obj);
      assertEquals(obj, obj);
      assertEquals(obj, copy);
      assertNotSame(obj, copy);
      assertEquals(copy, copy);
    }
  }

  @SuppressWarnings("unchecked")
  private <T extends java.io.Serializable> T serializeAndDeserialize(T obj)
      throws IOException, ClassNotFoundException {
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
