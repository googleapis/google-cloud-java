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

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class InstanceTest {

  @Test
  public void testFromProto() {
    com.google.bigtable.admin.v2.Instance proto = com.google.bigtable.admin.v2.Instance.newBuilder()
        .setName("projects/my-project/instances/my-instance")
        .setDisplayName("my display name")
        .setType(com.google.bigtable.admin.v2.Instance.Type.PRODUCTION)
        .setState(com.google.bigtable.admin.v2.Instance.State.READY)
        .putLabels("label1", "value1")
        .putLabels("label2", "value2")
        .build();

    Instance result = Instance.fromProto(proto);

    assertThat(result.getId()).isEqualTo("my-instance");
    assertThat(result.getDisplayName()).isEqualTo("my display name");
    assertThat(result.getType()).isEqualTo(Instance.Type.PRODUCTION);
    assertThat(result.getState()).isEqualTo(Instance.State.READY);
    assertThat(result.getLabels()).containsExactly(
        "label1", "value1",
        "label2", "value2"
    );
  }

  @Test
  public void testRequiresName() {
    com.google.bigtable.admin.v2.Instance proto = com.google.bigtable.admin.v2.Instance.newBuilder()
        .setDisplayName("my display name")
        .setType(com.google.bigtable.admin.v2.Instance.Type.PRODUCTION)
        .setState(com.google.bigtable.admin.v2.Instance.State.READY)
        .putLabels("label1", "value1")
        .putLabels("label2", "value2")
        .build();

    Exception actualException = null;

    try {
      Instance.fromProto(proto);
    } catch (Exception e) {
      actualException = e;
    }

    assertThat(actualException).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void testTypeEnumUpToDate() {
    Multimap<Instance.Type, com.google.bigtable.admin.v2.Instance.Type> modelToProtoMap =
        ArrayListMultimap.create();

    for (com.google.bigtable.admin.v2.Instance.Type protoValue : com.google.bigtable.admin.v2.Instance.Type
        .values()) {
      Instance.Type modelValue = Instance.Type.fromProto(protoValue);
      modelToProtoMap.put(modelValue, protoValue);
    }

    // Make sure all model values are used
    assertThat(modelToProtoMap.keys()).containsAllIn(Arrays.asList(Instance.Type.values()));

    // Make sure unknown is handled properly (it has multiple mappings)
    assertThat(modelToProtoMap).valuesForKey(Instance.Type.NOT_KNOWN).containsExactly(
        com.google.bigtable.admin.v2.Instance.Type.TYPE_UNSPECIFIED,
        com.google.bigtable.admin.v2.Instance.Type.UNRECOGNIZED
    );

    // Make sure everything else has exactly 1 mapping
    modelToProtoMap.removeAll(Instance.Type.NOT_KNOWN);

    for (Instance.Type modelState : modelToProtoMap.keySet()) {
      Collection<com.google.bigtable.admin.v2.Instance.Type> protoStates = modelToProtoMap
          .get(modelState);

      assertThat(protoStates).hasSize(1);
    }
  }

  @Test
  public void testStateEnumUpToDate() {
    Multimap<Instance.State, com.google.bigtable.admin.v2.Instance.State> modelToProtoMap =
        ArrayListMultimap.create();

    for (com.google.bigtable.admin.v2.Instance.State protoValue : com.google.bigtable.admin.v2.Instance.State
        .values()) {
      Instance.State modelValue = Instance.State.fromProto(protoValue);
      modelToProtoMap.put(modelValue, protoValue);
    }

    // Make sure all model values are used
    assertThat(modelToProtoMap.keys()).containsAllIn(Arrays.asList(Instance.State.values()));

    // Make sure unknown is handled properly (it has multiple mappings)
    assertThat(modelToProtoMap).valuesForKey(Instance.State.NOT_KNOWN).containsExactly(
        com.google.bigtable.admin.v2.Instance.State.STATE_NOT_KNOWN,
        com.google.bigtable.admin.v2.Instance.State.UNRECOGNIZED
    );

    // Make sure everything else has exactly 1 mapping
    modelToProtoMap.removeAll(Instance.State.NOT_KNOWN);

    for (Instance.State modelState : modelToProtoMap.keySet()) {
      Collection<com.google.bigtable.admin.v2.Instance.State> protoStates = modelToProtoMap
          .get(modelState);

      assertThat(protoStates).hasSize(1);
    }
  }
}
