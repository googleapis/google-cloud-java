/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.resourcemanager;

import com.google.cloud.BaseSerializationTest;
import com.google.cloud.PageImpl;
import com.google.cloud.Restorable;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Collections;

public class SerializationTest extends BaseSerializationTest {

  private static final ResourceManager RESOURCE_MANAGER =
      ResourceManagerOptions.getDefaultInstance().getService();
  private static final ProjectInfo PARTIAL_PROJECT_INFO = ProjectInfo.newBuilder("id1").build();
  private static final ProjectInfo FULL_PROJECT_INFO =
      ProjectInfo.newBuilder("id")
          .setName("name")
          .setLabels(ImmutableMap.of("key", "value"))
          .setProjectNumber(123L)
          .setState(ProjectInfo.State.ACTIVE)
          .setCreateTimeMillis(1234L)
          .build();
  private static final Project PROJECT =
      new Project(RESOURCE_MANAGER, new ProjectInfo.BuilderImpl(FULL_PROJECT_INFO));
  private static final PageImpl<Project> PAGE_RESULT =
      new PageImpl<>(null, "c", Collections.singletonList(PROJECT));
  private static final ResourceManager.ProjectGetOption PROJECT_GET_OPTION =
      ResourceManager.ProjectGetOption.fields(ResourceManager.ProjectField.NAME);
  private static final ResourceManager.ProjectListOption PROJECT_LIST_OPTION =
      ResourceManager.ProjectListOption.filter("name:*");
  private static final ResourceManagerException RESOURCE_MANAGER_EXCEPTION =
      new ResourceManagerException(42, "message");

  @Override
  protected Serializable[] serializableObjects() {
    ResourceManagerOptions options = ResourceManagerOptions.newBuilder().build();
    ResourceManagerOptions otherOptions =
        options.toBuilder().setProjectId("some-unnecessary-project-ID").build();
    return new Serializable[] {
      PARTIAL_PROJECT_INFO,
      FULL_PROJECT_INFO,
      PROJECT,
      PAGE_RESULT,
      PROJECT_GET_OPTION,
      PROJECT_LIST_OPTION,
      RESOURCE_MANAGER_EXCEPTION,
      options,
      otherOptions
    };
  }

  @Override
  protected Restorable<?>[] restorableObjects() {
    return null;
  }
}
