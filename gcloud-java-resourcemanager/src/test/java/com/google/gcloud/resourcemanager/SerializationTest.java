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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SerializationTest {

  private static final ResourceId RESOURCE_ID =
      ResourceId.of("some id", ResourceId.Type.ORGANIZATION);
  private static final Binding OWNER_BINDING;
  private static final Binding EDITOR_BINDING;
  private static final Binding VIEWER_BINDING;
  private static final Binding EMPTY_BINDING = Policy.Binding.builder().build();
  static {
    List<Member> ownerMemberList = new ArrayList<>();
    List<Member> editorMemberList = new ArrayList<>();
    List<Member> viewerMemberList = new ArrayList<>();
    ownerMemberList.add(Member.user("first-owner@email.com"));
    ownerMemberList.add(Member.group("group-of-owners@email.com"));
    OWNER_BINDING = Policy.Binding.builder().role(RoleType.OWNER).members(ownerMemberList).build();
    editorMemberList.add(Member.serviceAccount("editor@someemail.com"));
    EDITOR_BINDING =
        Policy.Binding.builder().role(RoleType.EDITOR).members(editorMemberList).build();
    viewerMemberList.add(Member.serviceAccount("app@someemail.com"));
    viewerMemberList.add(Member.user("viewer@email.com"));
    VIEWER_BINDING =
        Policy.Binding.builder().role(RoleType.VIEWER).members(viewerMemberList).build();
  }
  private static final Policy POLICY =
      Policy.builder()
          .addBinding(OWNER_BINDING)
          .addBinding(EDITOR_BINDING)
          .addBinding(VIEWER_BINDING)
          .version(1)
          .etag("some-etag-value")
          .build();
  private static final Policy EMPTY_POLICY = Policy.builder().build();
  private static final ProjectInfo PROJECT_INFO1 = ProjectInfo.builder("id1").build();
  private static final ProjectInfo PROJECT_INFO2;
  static {
    Map<String, String> labels = new HashMap<String, String>();
    labels.put("key", "value");
    PROJECT_INFO2 =
        new ProjectInfo("name", "id", labels, 123L, ProjectInfo.State.ACTIVE, 1234L, RESOURCE_ID);
  }
  private static final PageImpl<ProjectInfo> PAGE_RESULT =
      new PageImpl<>(null, "c", Collections.singletonList(PROJECT_INFO1));

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
        EDITOR_BINDING, VIEWER_BINDING, EMPTY_BINDING, POLICY, EMPTY_POLICY, PROJECT_INFO1,
        PROJECT_INFO2, PAGE_RESULT};
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
