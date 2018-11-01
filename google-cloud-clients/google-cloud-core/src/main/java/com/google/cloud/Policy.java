/*
 * Copyright 2016 Google LLC
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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.ApiFunction;
import com.google.api.core.InternalApi;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.io.BaseEncoding;
import com.google.protobuf.ByteString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Class for Identity and Access Management (IAM) policies. IAM policies are used to specify access
 * settings for Cloud Platform resources. A policy is a map of bindings. A binding assigns a set of
 * identities to a role, where the identities can be user accounts, Google groups, Google domains,
 * and service accounts. A role is a named list of permissions defined by IAM.
 *
 * @see <a href="https://cloud.google.com/iam/reference/rest/v1/Policy">Policy</a>
 */
public final class Policy implements Serializable {

  private static final long serialVersionUID = -3348914530232544290L;

  private final Map<Role, Set<Identity>> bindings;
  private final String etag;
  private final int version;

  public abstract static class Marshaller<T> {

    @InternalApi("This class should only be extended within google-cloud-java")
    protected Marshaller() {
    }

    protected static final ApiFunction<String, Identity> IDENTITY_VALUE_OF_FUNCTION =
        new ApiFunction<String, Identity>() {
          @Override
          public Identity apply(String identityPb) {
            return Identity.valueOf(identityPb);
          }
        };
    protected static final ApiFunction<Identity, String> IDENTITY_STR_VALUE_FUNCTION =
        new ApiFunction<Identity, String>() {
          @Override
          public String apply(Identity identity) {
            return identity.strValue();
          }
        };

    protected abstract Policy fromPb(T policyPb);

    protected abstract T toPb(Policy policy);
  }

  public static class DefaultMarshaller extends Marshaller<com.google.iam.v1.Policy> {

    @Override
    protected Policy fromPb(com.google.iam.v1.Policy policyPb) {
      Map<Role, Set<Identity>> bindings = new HashMap<>();
      for (com.google.iam.v1.Binding bindingPb : policyPb.getBindingsList()) {
        bindings.put(Role.of(bindingPb.getRole()),
            ImmutableSet.copyOf(
                Lists.transform(bindingPb.getMembersList(), new Function<String, Identity>() {
                  @Override
                  public Identity apply(String s) {
                    return IDENTITY_VALUE_OF_FUNCTION.apply(s);
                  }
                })));
      }
      return newBuilder()
          .setBindings(bindings)
          .setEtag(policyPb.getEtag().isEmpty() ? null
              : BaseEncoding.base64().encode(policyPb.getEtag().toByteArray()))
          .setVersion(policyPb.getVersion())
          .build();
    }

    @Override
    protected com.google.iam.v1.Policy toPb(Policy policy) {
      com.google.iam.v1.Policy.Builder policyBuilder = com.google.iam.v1.Policy.newBuilder();
      List<com.google.iam.v1.Binding> bindingPbList = new LinkedList<>();
      for (Map.Entry<Role, Set<Identity>> binding : policy.getBindings().entrySet()) {
        com.google.iam.v1.Binding.Builder bindingBuilder = com.google.iam.v1.Binding.newBuilder();
        bindingBuilder.setRole(binding.getKey().getValue());
        bindingBuilder.addAllMembers(
            Lists.transform(new ArrayList<>(binding.getValue()), new Function<Identity, String>() {
              @Override
              public String apply(Identity identity) {
                return IDENTITY_STR_VALUE_FUNCTION.apply(identity);
              }
            }));
        bindingPbList.add(bindingBuilder.build());
      }
      policyBuilder.addAllBindings(bindingPbList);
      if (policy.etag != null) {
        policyBuilder.setEtag(ByteString.copyFrom(BaseEncoding.base64().decode(policy.etag)));
      }
      policyBuilder.setVersion(policy.version);
      return policyBuilder.build();
    }
  }

  /**
   * A builder for {@code Policy} objects.
   */
  public static class Builder {

    private final Map<Role, Set<Identity>> bindings = new HashMap<>();
    private String etag;
    private int version;

    @InternalApi("This class should only be extended within google-cloud-java")
    protected Builder() {
    }

    @InternalApi("This class should only be extended within google-cloud-java")
    protected Builder(Policy policy) {
      setBindings(policy.bindings);
      setEtag(policy.etag);
      setVersion(policy.version);
    }


    /**
     * Replaces the builder's map of bindings with the given map of bindings.
     *
     * @throws NullPointerException if the given map is null or contains any null keys or values
     * @throws IllegalArgumentException if any identities in the given map are null
     */
    public final Builder setBindings(Map<Role, Set<Identity>> bindings) {
      checkNotNull(bindings, "The provided map of bindings cannot be null.");
      for (Map.Entry<Role, Set<Identity>> binding : bindings.entrySet()) {
        checkNotNull(binding.getKey(), "The role cannot be null.");
        Set<Identity> identities = binding.getValue();
        checkNotNull(identities, "A role cannot be assigned to a null set of identities.");
        checkArgument(!identities.contains(null), "Null identities are not permitted.");
      }
      this.bindings.clear();
      for (Map.Entry<Role, Set<Identity>> binding : bindings.entrySet()) {
        this.bindings.put(binding.getKey(), new HashSet<>(binding.getValue()));
      }
      return this;
    }

    /**
     * Removes the role (and all identities associated with that role) from the policy.
     */
    public final Builder removeRole(Role role) {
      bindings.remove(role);
      return this;
    }

    /**
     * Adds one or more identities to the policy under the role specified.
     *
     * @throws NullPointerException if the role or any of the identities is null.
     */
    public final Builder addIdentity(Role role, Identity first, Identity... others) {
      String nullIdentityMessage = "Null identities are not permitted.";
      checkNotNull(first, nullIdentityMessage);
      checkNotNull(others, nullIdentityMessage);
      for (Identity identity : others) {
        checkNotNull(identity, nullIdentityMessage);
      }
      Set<Identity> toAdd = new LinkedHashSet<>();
      toAdd.add(first);
      toAdd.addAll(Arrays.asList(others));
      Set<Identity> identities = bindings.get(checkNotNull(role, "The role cannot be null."));
      if (identities == null) {
        identities = new HashSet<>();
        bindings.put(role, identities);
      }
      identities.addAll(toAdd);
      return this;
    }

    /**
     * Removes one or more identities from an existing binding. Does nothing if the binding
     * associated with the provided role doesn't exist.
     */
    public final Builder removeIdentity(Role role, Identity first, Identity... others) {
      Set<Identity> identities = bindings.get(role);
      if (identities != null) {
        identities.remove(first);
        identities.removeAll(Arrays.asList(others));
      }
      if (identities != null && identities.isEmpty()) {
        bindings.remove(role);
      }
      return this;
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
    public final Builder setEtag(String etag) {
      this.etag = etag;
      return this;
    }


    /**
     * Sets the version of the policy. The default version is 0, meaning only the "owner", "editor",
     * and "viewer" roles are permitted. If the version is 1, you may also use other roles.
     */
    protected final Builder setVersion(int version) {
      this.version = version;
      return this;
    }

    /**
     * Creates a {@code Policy} object.
     */
    public final Policy build() {
      return new Policy(this);
    }
  }

  private Policy(Builder builder) {
    ImmutableMap.Builder<Role, Set<Identity>> bindingsBuilder = ImmutableMap.builder();
    for (Map.Entry<Role, Set<Identity>> binding : builder.bindings.entrySet()) {
      bindingsBuilder.put(binding.getKey(), ImmutableSet.copyOf(binding.getValue()));
    }
    this.bindings = bindingsBuilder.build();
    this.etag = builder.etag;
    this.version = builder.version;
  }

  /**
   * Returns a builder containing the properties of this IAM Policy.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }


  /**
   * Returns the map of bindings that comprises the policy.
   */
  public Map<Role, Set<Identity>> getBindings() {
    return bindings;
  }


  /**
   * Returns the policy's etag.
   *
   * <p>Etags are used for optimistic concurrency control as a way to help prevent simultaneous
   * updates of a policy from overwriting each other. It is strongly suggested that systems make
   * use of the etag in the read-modify-write cycle to perform policy updates in order to avoid
   * race conditions. An etag is returned in the response to getIamPolicy, and systems are
   * expected to put that etag in the request to setIamPolicy to ensure that their change will be
   * applied to the same version of the policy.  If no etag is provided in the call to
   * setIamPolicy, then the existing policy is overwritten blindly.
   */
  public String getEtag() {
    return etag;
  }


  /**
   * Returns the version of the policy. The default version is 0, meaning only the "owner",
   * "editor", and "viewer" roles are permitted. If the version is 1, you may also use other roles.
   */
  public int getVersion() {
    return version;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("bindings", bindings)
        .add("etag", etag)
        .add("version", version)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getClass(), bindings, etag, version);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Policy)) {
      return false;
    }
    Policy other = (Policy) obj;
    return Objects.equals(bindings, other.getBindings())
        && Objects.equals(etag, other.getEtag())
        && Objects.equals(version, other.getVersion());
  }


  /**
   * Returns a builder for {@code Policy} objects.
   */
  public static Builder newBuilder() {
    return new Builder();
  }
}
