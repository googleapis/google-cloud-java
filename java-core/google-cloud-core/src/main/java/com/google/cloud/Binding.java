/*
 * Copyright 2020 Google LLC
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

package com.google.cloud;

import static com.google.common.base.Predicates.in;
import static com.google.common.base.Predicates.not;

import com.google.api.core.BetaApi;
import com.google.auto.value.AutoValue;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Class for Identity and Access Management (IAM) policies. IAM policies are used to specify access
 * settings for Cloud Platform resources. A policy is a list of bindings. A binding assigns a set of
 * identities to a role, where the identities can be user accounts, Google groups, Google domains,
 * and service accounts. A role is a named list of permissions defined by IAM.
 *
 * @see <a href="https://cloud.google.com/iam/docs/reference/rest/v1/Policy">Policy</a>
 */
@BetaApi("This is a Beta API is not stable yet and may change in the future.")
@AutoValue
public abstract class Binding {
  /** Get IAM Policy Binding Role */
  public abstract String getRole();

  /** Get IAM Policy Binding Members */
  public abstract ImmutableList<String> getMembers();

  /** Get IAM Policy Binding Condition */
  @Nullable
  public abstract Condition getCondition();

  /** Create a Binding.Builder from an existing Binding */
  public abstract Builder toBuilder();

  /** Create a new Binding.Builder */
  public static Builder newBuilder() {
    List<String> emptyMembers = ImmutableList.of();
    return new AutoValue_Binding.Builder().setMembers(emptyMembers);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * Set IAM Role for Policy Binding
     *
     * @throws NullPointerException if the role is null.
     */
    public abstract Builder setRole(String role);

    /**
     * Set IAM Members for Policy Binding
     *
     * @throws NullPointerException if a member is null.
     */
    public abstract Builder setMembers(Iterable<String> members);

    /** Set IAM Condition for Policy Binding */
    public abstract Builder setCondition(Condition condition);

    /** Internal use to getMembers() in addMembers() and removeMembers() */
    abstract ImmutableList<String> getMembers();

    /**
     * Add members to Policy Binding.
     *
     * @throws NullPointerException if a member is null.
     */
    public Builder addMembers(String member, String... moreMembers) {
      ImmutableList.Builder<String> membersBuilder = ImmutableList.builder();
      membersBuilder.addAll(getMembers());
      membersBuilder.addAll(Lists.asList(member, moreMembers));
      setMembers(membersBuilder.build());
      return this;
    }

    /**
     * Remove members to Policy Binding.
     *
     * @throws NullPointerException if a member is null.
     */
    public Builder removeMembers(String... members) {
      Predicate<String> selectMembersNotInList = not(in(Arrays.asList(members)));
      Collection<String> filter = Collections2.filter(getMembers(), selectMembersNotInList);
      setMembers(filter);
      return this;
    }

    public abstract Binding build();
  }
}
