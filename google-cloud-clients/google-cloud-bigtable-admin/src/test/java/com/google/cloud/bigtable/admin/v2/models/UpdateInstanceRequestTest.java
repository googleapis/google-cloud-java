/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2.models;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.Instance.Type;
import com.google.bigtable.admin.v2.PartialUpdateInstanceRequest;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.FieldMask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UpdateInstanceRequestTest {
  @Test
  public void testEmpty() {
    UpdateInstanceRequest input = UpdateInstanceRequest.of("my-instance");

    Exception actualError = null;

    try {
      input.toProto(ProjectName.of("my-project"));
    } catch (Exception e) {
      actualError = e;
    }

    assertThat(actualError).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void testDisplayName() {
    UpdateInstanceRequest input =
        UpdateInstanceRequest.of("my-instance").setDisplayName("my display name");

    PartialUpdateInstanceRequest actual = input.toProto(ProjectName.of("my-project"));

    PartialUpdateInstanceRequest expected =
        PartialUpdateInstanceRequest.newBuilder()
            .setUpdateMask(FieldMask.newBuilder().addPaths("display_name"))
            .setInstance(
                Instance.newBuilder()
                    .setName("projects/my-project/instances/my-instance")
                    .setDisplayName("my display name"))
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testLabels() {
    UpdateInstanceRequest input =
        UpdateInstanceRequest.of("my-instance")
            .setAllLabels(
                ImmutableMap.of(
                    "label1", "value1",
                    "label2", "value2"));

    PartialUpdateInstanceRequest actual = input.toProto(ProjectName.of("my-project"));

    PartialUpdateInstanceRequest expected =
        PartialUpdateInstanceRequest.newBuilder()
            .setUpdateMask(FieldMask.newBuilder().addPaths("labels"))
            .setInstance(
                Instance.newBuilder()
                    .setName("projects/my-project/instances/my-instance")
                    .putLabels("label1", "value1")
                    .putLabels("label2", "value2"))
            .build();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testType() {
    UpdateInstanceRequest input = UpdateInstanceRequest.of("my-instance").setProductionType();

    PartialUpdateInstanceRequest actual = input.toProto(ProjectName.of("my-project"));

    PartialUpdateInstanceRequest expected =
        PartialUpdateInstanceRequest.newBuilder()
            .setUpdateMask(FieldMask.newBuilder().addPaths("type"))
            .setInstance(
                Instance.newBuilder()
                    .setName("projects/my-project/instances/my-instance")
                    .setType(Type.PRODUCTION))
            .build();

    assertThat(actual).isEqualTo(expected);
  }
}
