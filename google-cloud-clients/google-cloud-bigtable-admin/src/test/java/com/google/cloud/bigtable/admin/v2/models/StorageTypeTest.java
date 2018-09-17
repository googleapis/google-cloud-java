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
public class StorageTypeTest {

  @Test
  public void testUpToDate() {
    Multimap<StorageType, com.google.bigtable.admin.v2.StorageType> modelToProtoMap =
        ArrayListMultimap.create();

    for (com.google.bigtable.admin.v2.StorageType protoValue : com.google.bigtable.admin.v2.StorageType
        .values()) {
      StorageType modelValue = StorageType.fromProto(protoValue);
      modelToProtoMap.put(modelValue, protoValue);
    }

    // Make sure all model values are used
    assertThat(modelToProtoMap.keys()).containsAllIn(Arrays.asList(StorageType.values()));

    // Make sure unknown is handled properly (it has multiple mappings)
    assertThat(modelToProtoMap).valuesForKey(StorageType.NOT_KNOWN).containsExactly(
        com.google.bigtable.admin.v2.StorageType.UNRECOGNIZED,
        com.google.bigtable.admin.v2.StorageType.STORAGE_TYPE_UNSPECIFIED
    );

    // Make sure everything else has exactly 1 mapping
    modelToProtoMap.removeAll(StorageType.NOT_KNOWN);

    for (StorageType modelState : modelToProtoMap.keySet()) {
      Collection<com.google.bigtable.admin.v2.StorageType> protoStates = modelToProtoMap
          .get(modelState);

      assertThat(protoStates).hasSize(1);
    }
  }
}