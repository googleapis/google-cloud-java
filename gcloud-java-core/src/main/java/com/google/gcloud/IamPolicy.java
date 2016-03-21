/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Base class for Identity and Access Management (IAM) policies. IAM policies are used to specify
 * access settings for Cloud Platform resources. A policy is a map of bindings. A binding assigns
 * a set of identities to a role, where the identities can be user accounts, Google groups, Google
 * domains, and service accounts. A role is a named list of permissions defined by IAM.
 *
 * @param <R> the data type of roles (should be serializable)
 * @see <a href="https://cloud.google.com/iam/reference/rest/v1/Policy">Policy</a>
 */
public abstract class IamPolicy<R> implements Serializable {

  private static final long serialVersionUID = 1114489978726897720L;

  private final Map<R, Set<Identity>> bindings;
  private final String etag;
  private final Integer version;

  /**
   * Builder for an IAM Policy.
   *
   * @param <R> the data type of roles
   * @param <B> the subclass extending this abstract builder
   */
  public abstract static class Builder<R, B extends Builder<R, B>> {

    private final Map<R, Set<Identity>> bindings = new HashMap<>();
    private String etag;
    private Integer version;

    /**
     * Constructor for IAM Policy builder.
     */
    protected Builder() {}

    /**
     * Replaces the builder's map of bindings with the given map of bindings.
     *
     * @throws IllegalArgumentException if the provided map is null or contain any null values
     */
    public final B bindings(Map<R, Set<Identity>> bindings) {
      checkArgument(bindings != null, "The provided map of bindings cannot be null.");
      for (Map.Entry<R, Set<Identity>> binding : bindings.entrySet()) {
        verifyBinding(binding.getKey(), binding.getValue());
      }
      this.bindings.clear();
      for (Map.Entry<R, Set<Identity>> binding : bindings.entrySet()) {
        this.bindings.put(binding.getKey(), new HashSet<Identity>(binding.getValue()));
      }
      return self();
    }

    private void verifyBinding(R role, Collection<Identity> identities) {
      checkArgument(role != null, "The role cannot be null.");
      checkArgument(identities != null, "A role cannot be assigned to a null set of identities.");
      checkArgument(!identities.contains(null), "Null identities are not permitted.");
    }

    /**
     * Removes the binding associated with the specified role.
     */
    public final B removeBinding(R role) {
      bindings.remove(role);
      return self();
    }

    /**
     * Adds one or more identities to the policy under the role specified. Creates a new role
     * binding if the binding corresponding to the given role did not previously exist.
     */
    public final B addIdentity(R role, Identity first, Identity... others) {
      List<Identity> toAdd = new LinkedList<>();
      toAdd.add(first);
      toAdd.addAll(Arrays.asList(others));
      verifyBinding(role, toAdd);
      Set<Identity> identities = bindings.get(role);
      if (identities == null) {
        identities = new HashSet<Identity>();
        bindings.put(role, identities);
      }
      identities.addAll(toAdd);
      return self();
    }

    /**
     * Removes one or more identities from an existing binding. Does nothing if the binding
     * associated with the provided role doesn't exist.
     */
    public final B removeIdentity(R role, Identity first, Identity... others) {
      Set<Identity> identities = bindings.get(role);
      if (identities != null) {
        identities.remove(first);
        identities.removeAll(Arrays.asList(others));
      }
      return self();
    }

    /**
     * Sets the policy's etag.
     *
     * <p>Etags are used for optimistic concurrency control as a way to help prevent simultaneous
     * updates of a policy from overwriting each other. It is strongly suggested that systems make
     * use of the etag in the read-modify-write cycle to perform policy updates in order to avoid
     * race conditions. An etag is returned in the response to getIamPolicy, and systems are
     * expected to put that etag in the request to setIamPolicy to ensure that their change will be
     * applied to the same version of the policy.  If no etag is provided in the call to
     * setIamPolicy, then the existing policy is overwritten blindly.
     */
    protected final B etag(String etag) {
      this.etag = etag;
      return self();
    }

    /**
     * Sets the version of the policy. The default version is 0, meaning only the "owner", "editor",
     * and "viewer" roles are permitted. If the version is 1, you may also use other roles.
     */
    protected final B version(Integer version) {
      this.version = version;
      return self();
    }

    @SuppressWarnings("unchecked")
    private B self() {
      return (B) this;
    }

    public abstract IamPolicy<R> build();
  }

  protected IamPolicy(Builder<R, ? extends Builder<R, ?>> builder) {
    ImmutableMap.Builder<R, Set<Identity>> bindingsBuilder = ImmutableMap.builder();
    for (Map.Entry<R, Set<Identity>> binding : builder.bindings.entrySet()) {
      bindingsBuilder.put(binding.getKey(), ImmutableSet.copyOf(binding.getValue()));
    }
    this.bindings = bindingsBuilder.build();
    this.etag = builder.etag;
    this.version = builder.version;
  }

  /**
   * Returns a builder containing the properties of this IAM Policy.
   */
  public abstract Builder<R, ? extends Builder<R, ?>> toBuilder();

  /**
   * The map of bindings that comprises the policy.
   */
  public Map<R, Set<Identity>> bindings() {
    return bindings;
  }

  /**
   * The policy's etag.
   *
   * <p>Etags are used for optimistic concurrency control as a way to help prevent simultaneous
   * updates of a policy from overwriting each other. It is strongly suggested that systems make
   * use of the etag in the read-modify-write cycle to perform policy updates in order to avoid
   * race conditions. An etag is returned in the response to getIamPolicy, and systems are
   * expected to put that etag in the request to setIamPolicy to ensure that their change will be
   * applied to the same version of the policy.  If no etag is provided in the call to
   * setIamPolicy, then the existing policy is overwritten blindly.
   */
  public String etag() {
    return etag;
  }

  /**
   * Sets the version of the policy. The default version is 0, meaning only the "owner", "editor",
   * and "viewer" roles are permitted. If the version is 1, you may also use other roles.
   */
  public Integer version() {
    return version;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(getClass(), bindings, etag, version);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == null || !getClass().equals(obj.getClass())) {
      return false;
    }
    @SuppressWarnings("rawtypes")
    IamPolicy other = (IamPolicy) obj;
    return Objects.equals(bindings, other.bindings())
        && Objects.equals(etag, other.etag())
        && Objects.equals(version, other.version());
  }
}
