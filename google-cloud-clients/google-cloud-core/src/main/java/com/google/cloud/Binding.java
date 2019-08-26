/*
 * Copyright 2019 Google LLC
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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.InternalApi;
import com.google.common.base.MoreObjects;
import java.util.*;

public class Binding {
  private Role role;
  private Set<Identity> identities;
  private Condition condition;

  public static class Builder {
    private Role role;
    private Set<Identity> identities;
    private Condition condition;

    @InternalApi("This class should only be extended within google-cloud-java")
    protected Builder() {}

    @InternalApi("This class should only be extended within google-cloud-java")
    protected Builder(Binding binding) {
      setRole(binding.role);
      setIdentities(binding.identities);
      setCondition(binding.condition);
    }

    public final Binding.Builder setRole(Role role) {
      this.role = role;
      return this;
    }

    public final Binding.Builder setIdentities(Set<Identity> identities) {
      this.identities = identities;
      return this;
    }

    public final Binding.Builder setCondition(Condition condition) {
      this.condition = condition;
      return this;
    }

    /**
     * Adds one or more identities to the binding
     *
     * @throws NullPointerException if any of the identities is null.
     */
    public final Builder addIdentity(Identity first, Identity... others) {
      String nullIdentityMessage = "Null identities are not permitted.";
      checkNotNull(first, nullIdentityMessage);
      checkNotNull(others, nullIdentityMessage);
      for (Identity identity : others) {
        checkNotNull(identity, nullIdentityMessage);
      }
      Set<Identity> toAdd = new LinkedHashSet<>();
      toAdd.add(first);
      toAdd.addAll(Arrays.asList(others));
      if (identities == null) {
        identities = new HashSet<>();
      }
      identities.addAll(toAdd);
      return this;
    }

    /**
     * Removes one or more identities from an existing binding. Does nothing if the binding
     * associated with the provided role doesn't exist.
     */
    public final Builder removeIdentity(Identity first, Identity... others) {
      if (identities != null) {
        identities.remove(first);
        identities.removeAll(Arrays.asList(others));
      }
      return this;
    }

    /** Creates a {@code Policy} object. */
    public final Binding build() {
      return new Binding(this);
    }
  }

  private Binding(Binding.Builder builder) {
    this.role = builder.role;
    this.identities = builder.identities;
    this.condition = builder.condition;
  }

  public Binding.Builder toBuilder() {
    return new Binding.Builder(this);
  }

  public Role getRole() {
    return this.role;
  }

  public Set<Identity> getIdentities() {
    return this.identities;
  }

  public Condition getCondition() {
    return this.condition;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("role", role)
        .add("identities", identities)
        .add("condition", condition)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getClass(), role, identities, condition);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Binding)) {
      return false;
    }
    Binding other = (Binding) obj;
    return Objects.equals(role, other.getRole())
        && Objects.equals(identities, other.getIdentities())
        && Objects.equals(condition, other.getCondition());
  }

  /** Returns a builder for {@code Policy} objects. */
  public static Binding.Builder newBuilder() {
    return new Binding.Builder();
  }
}
