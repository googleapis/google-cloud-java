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
import com.google.gcloud.BaseIamPolicy.Identity;
import com.google.gcloud.PageImpl;
import com.google.gcloud.RetryParams;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;

public class SerializationTest {

private static final ResourceManager RESOURCE_MANAGER =
      ResourceManagerOptions.defaultInstance().service();
  private static final ProjectInfo PARTIAL_PROJECT_INFO = ProjectInfo.builder("id1").build();
  private static final ProjectInfo FULL_PROJECT_INFO = ProjectInfo.builder("id")
      .name("name")
      .labels(ImmutableMap.of("key", "value"))
      .projectNumber(123L)
      .state(ProjectInfo.State.ACTIVE)
      .createTimeMillis(1234L)
      .build();
  private static final Project PROJECT =
      new Project(RESOURCE_MANAGER, new ProjectInfo.BuilderImpl(FULL_PROJECT_INFO));
  private static final PageImpl<Project> PAGE_RESULT =
      new PageImpl<>(null, "c", Collections.singletonList(PROJECT));
  private static final ResourceManager.ProjectGetOption PROJECT_GET_OPTION =
      ResourceManager.ProjectGetOption.fields(ResourceManager.ProjectField.NAME);
  private static final ResourceManager.ProjectListOption PROJECT_LIST_OPTION =
      ResourceManager.ProjectListOption.filter("name:*");
  private static final Identity IDENTITY = Identity.user("abc@gmail.com");
  private static final IamPolicy POLICY =
      IamPolicy.builder().addBinding("viewer", ImmutableList.of(IDENTITY)).build();

  @Test
  public void testServiceOptions() throws Exception {
    ResourceManagerOptions options = ResourceManagerOptions.builder().build();
    ResourceManagerOptions serializedCopy = serializeAndDeserialize(options);
    assertEquals(options, serializedCopy);
    options = options.toBuilder()
        .projectId("some-unnecessary-project-ID")
        .retryParams(RetryParams.defaultInstance())
        .build();
    serializedCopy = serializeAndDeserialize(options);
    assertEquals(options, serializedCopy);
  }

  @Test
  public void testModelAndRequests() throws Exception {
    Serializable[] objects = {PARTIAL_PROJECT_INFO, FULL_PROJECT_INFO, PROJECT, PAGE_RESULT,
        PROJECT_GET_OPTION, PROJECT_LIST_OPTION, IDENTITY, POLICY};
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
