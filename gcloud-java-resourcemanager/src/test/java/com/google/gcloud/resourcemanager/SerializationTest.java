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

package com.google.gcloud.resourcemanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.AuthCredentials;
import com.google.gcloud.PageImpl;
import com.google.gcloud.RetryParams;
import com.google.gcloud.resourcemanager.Policy.Binding;
import com.google.gcloud.resourcemanager.Policy.Member;
import com.google.gcloud.resourcemanager.Policy.RoleType;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class SerializationTest {

  private static final ResourceId RESOURCE_ID = ResourceId.of("some id", "organization");
  private static final List<Member> OWNER_MEMBER_LIST = ImmutableList.of(
      Member.user("first-owner@email.com"), Member.group("group-of-owners@email.com"));
  private static final List<Member> EDITOR_MEMBER_LIST =
      ImmutableList.of(Member.serviceAccount("editor@someemail.com"));
  private static final List<Member> VIEWER_MEMBER_LIST =
      ImmutableList.of(Member.serviceAccount("app@someemail.com"), Member.user("viewer@email.com"));
  private static final Binding OWNER_BINDING =
      Policy.Binding.builder().role(RoleType.OWNER).members(OWNER_MEMBER_LIST).build();
  private static final Binding EDITOR_BINDING =
      Policy.Binding.builder().role(RoleType.EDITOR).members(EDITOR_MEMBER_LIST).build();
  private static final Binding VIEWER_BINDING =
      Policy.Binding.builder().role(RoleType.VIEWER).members(VIEWER_MEMBER_LIST).build();
  private static final Policy EMPTY_POLICY = Policy.builder().build();
  private static final Policy FULL_POLICY =
      Policy.builder()
          .addBinding(OWNER_BINDING)
          .addBinding(EDITOR_BINDING)
          .addBinding(VIEWER_BINDING)
          .version(1)
          .etag("some-etag-value")
          .build();
  private static final ProjectInfo PARTIAL_PROJECT_INFO = ProjectInfo.builder("id1").build();
  private static final ProjectInfo FULL_PROJECT_INFO =
      ProjectInfo.builder("id")
          .name("name")
          .labels(ImmutableMap.of("key", "value"))
          .number(123L)
          .state(ProjectInfo.State.ACTIVE)
          .createTimeMillis(1234L)
          .parent(RESOURCE_ID)
          .build();
  private static final PageImpl<ProjectInfo> PAGE_RESULT =
      new PageImpl<>(null, "c", Collections.singletonList(PARTIAL_PROJECT_INFO));

  @Test
  public void testServiceOptions() throws Exception {
    ResourceManagerOptions options = ResourceManagerOptions.builder().build();
    ResourceManagerOptions serializedCopy = serializeAndDeserialize(options);
    assertEquals(options, serializedCopy);
    options =
        options.toBuilder()
            .projectId("some-unnecessary-project-ID")
            .retryParams(RetryParams.defaultInstance())
            .authCredentials(AuthCredentials.noCredentials())
            .build();
    serializedCopy = serializeAndDeserialize(options);
    assertEquals(options, serializedCopy);
  }

  @Test
  public void testModelAndRequests() throws Exception {
    Serializable[] objects = {RESOURCE_ID, OWNER_BINDING.members().get(0), OWNER_BINDING,
        EDITOR_BINDING, VIEWER_BINDING, EMPTY_POLICY, FULL_POLICY, PARTIAL_PROJECT_INFO,
        FULL_PROJECT_INFO, PAGE_RESULT};
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
