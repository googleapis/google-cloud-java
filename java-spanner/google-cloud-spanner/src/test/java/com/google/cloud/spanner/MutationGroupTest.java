/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.spanner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;
import com.google.spanner.v1.BatchWriteRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link MutationGroup}. */
@RunWith(JUnit4.class)
public class MutationGroupTest {
  private final Random random = new Random();

  private Mutation getRandomMutation() {
    return Mutation.newInsertBuilder(String.valueOf(random.nextInt()))
        .set("ID")
        .to(random.nextInt())
        .set("NAME")
        .to(String.valueOf(random.nextInt()))
        .build();
  }

  private BatchWriteRequest.MutationGroup getMutationGroupProto(ImmutableList<Mutation> mutations) {
    List<com.google.spanner.v1.Mutation> mutationsProto = new ArrayList<>();
    Mutation.toProtoAndReturnRandomMutation(mutations, mutationsProto);
    return BatchWriteRequest.MutationGroup.newBuilder().addAllMutations(mutationsProto).build();
  }

  @Test
  public void ofVarargTest() {
    Mutation[] mutations =
        new Mutation[] {
          getRandomMutation(), getRandomMutation(), getRandomMutation(), getRandomMutation()
        };
    MutationGroup mutationGroup = MutationGroup.of(mutations);
    assertArrayEquals(mutations, mutationGroup.getMutations().toArray());
    assertEquals(
        MutationGroup.toProto(mutationGroup),
        getMutationGroupProto(ImmutableList.copyOf(mutations)));
  }

  @Test
  public void ofIterableTest() {
    ImmutableList<Mutation> mutations =
        ImmutableList.of(
            getRandomMutation(), getRandomMutation(), getRandomMutation(), getRandomMutation());
    MutationGroup mutationGroup = MutationGroup.of(mutations);
    assertEquals(mutations, mutationGroup.getMutations());
    assertEquals(MutationGroup.toProto(mutationGroup), getMutationGroupProto(mutations));
  }

  @Test
  public void toProtoTest() {
    Mutation[] mutations =
        new Mutation[] {
          getRandomMutation(), getRandomMutation(), getRandomMutation(), getRandomMutation()
        };
    MutationGroup mutationGroup = MutationGroup.of(mutations);
    assertEquals(
        MutationGroup.toProto(mutationGroup),
        getMutationGroupProto(ImmutableList.copyOf(mutations)));
  }

  @Test
  public void toListProtoTest() {
    Mutation[] mutations1 =
        new Mutation[] {
          getRandomMutation(), getRandomMutation(), getRandomMutation(), getRandomMutation()
        };
    Mutation[] mutations2 =
        new Mutation[] {
          getRandomMutation(), getRandomMutation(), getRandomMutation(), getRandomMutation()
        };
    Mutation[] mutations3 =
        new Mutation[] {
          getRandomMutation(), getRandomMutation(), getRandomMutation(), getRandomMutation()
        };
    List<MutationGroup> mutationGroups =
        ImmutableList.of(
            MutationGroup.of(mutations1),
            MutationGroup.of(mutations2),
            MutationGroup.of(mutations3));
    List<BatchWriteRequest.MutationGroup> mutationGroupsProto =
        MutationGroup.toListProto(mutationGroups);
    assertEquals(
        mutationGroupsProto.get(0), getMutationGroupProto(ImmutableList.copyOf(mutations1)));
    assertEquals(
        mutationGroupsProto.get(1), getMutationGroupProto(ImmutableList.copyOf(mutations2)));
    assertEquals(
        mutationGroupsProto.get(2), getMutationGroupProto(ImmutableList.copyOf(mutations3)));
  }
}
