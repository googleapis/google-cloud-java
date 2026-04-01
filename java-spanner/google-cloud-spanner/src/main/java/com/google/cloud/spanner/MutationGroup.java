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

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.spanner.v1.BatchWriteRequest;
import java.util.ArrayList;
import java.util.List;

/** Represents a group of Cloud Spanner mutations to be committed together. */
public class MutationGroup {
  private final ImmutableList<Mutation> mutations;

  private MutationGroup(ImmutableList<Mutation> mutations) {
    this.mutations = mutations;
  }

  /** Creates a {@code MutationGroup} given a vararg of mutations. */
  public static MutationGroup of(Mutation... mutations) {
    Preconditions.checkArgument(mutations.length > 0, "Should pass in at least one mutation.");
    return new MutationGroup(ImmutableList.copyOf(mutations));
  }

  /** Creates a {@code MutationGroup} given an iterable of mutations. */
  public static MutationGroup of(Iterable<Mutation> mutations) {
    return new MutationGroup(ImmutableList.copyOf(mutations));
  }

  /** Returns corresponding mutations for this MutationGroup. */
  public ImmutableList<Mutation> getMutations() {
    return mutations;
  }

  static BatchWriteRequest.MutationGroup toProto(final MutationGroup mutationGroup) {
    List<com.google.spanner.v1.Mutation> mutationsProto = new ArrayList<>();
    Mutation.toProtoAndReturnRandomMutation(mutationGroup.getMutations(), mutationsProto);
    return BatchWriteRequest.MutationGroup.newBuilder().addAllMutations(mutationsProto).build();
  }

  static List<BatchWriteRequest.MutationGroup> toListProto(
      final Iterable<MutationGroup> mutationGroups) {
    List<BatchWriteRequest.MutationGroup> mutationGroupsProto = new ArrayList<>();
    for (MutationGroup group : mutationGroups) {
      mutationGroupsProto.add(toProto(group));
    }
    return mutationGroupsProto;
  }
}
