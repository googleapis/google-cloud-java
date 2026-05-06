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
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.BaseEncoding;
import com.google.protobuf.ByteString;
import com.google.type.Expr;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Class for Identity and Access Management (IAM) policies. IAM policies are used to specify access
 * settings for Cloud Platform resources. A policy is a list of bindings. A binding assigns a set of
 * identities to a role, where the identities can be user accounts, Google groups, Google domains,
 * and service accounts. A role is a named list of permissions defined by IAM.
 *
 * @see <a href="https://cloud.google.com/iam/docs/reference/rest/v1/Policy">Policy</a>
 */
public final class Policy implements Serializable {

  private static final long serialVersionUID = -3348914530232544290L;
  private final ImmutableList<Binding> bindingsList;
  private final String etag;
  private final int version;

  /*
   * Return true if Policy is version 3 OR bindings has a conditional binding.
   * Return false if Policy is version 1 AND bindings does not have a conditional binding.
   */
  private static boolean isConditional(int version, List<Binding> bindingsList) {
    for (Binding binding : bindingsList) {
      if (binding.getCondition() != null) {
        return true;
      }
    }
    if (version == 3) {
      return true;
    }
    return false;
  }

  public abstract static class Marshaller<T> {

    @InternalApi("This class should only be extended within google-cloud-java")
    protected Marshaller() {}

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
      ImmutableList.Builder<Binding> bindingsListBuilder = ImmutableList.builder();
      for (com.google.iam.v1.Binding bindingPb : policyPb.getBindingsList()) {
        Binding.Builder convertedBinding =
            Binding.newBuilder()
                .setRole(bindingPb.getRole())
                .setMembers(bindingPb.getMembersList());
        if (bindingPb.hasCondition()) {
          Expr expr = bindingPb.getCondition();
          convertedBinding.setCondition(
              Condition.newBuilder()
                  .setTitle(expr.getTitle())
                  .setDescription(expr.getDescription())
                  .setExpression(expr.getExpression())
                  .build());
        }
        bindingsListBuilder.add(convertedBinding.build());
      }
      return newBuilder()
          .setBindings(bindingsListBuilder.build())
          .setEtag(
              policyPb.getEtag().isEmpty()
                  ? null
                  : BaseEncoding.base64().encode(policyPb.getEtag().toByteArray()))
          .setVersion(policyPb.getVersion())
          .build();
    }

    @Override
    protected com.google.iam.v1.Policy toPb(Policy policy) {
      com.google.iam.v1.Policy.Builder policyBuilder = com.google.iam.v1.Policy.newBuilder();
      List<com.google.iam.v1.Binding> bindingPbList = new LinkedList<>();
      for (Binding binding : policy.getBindingsList()) {
        com.google.iam.v1.Binding.Builder bindingBuilder = com.google.iam.v1.Binding.newBuilder();
        bindingBuilder.setRole(binding.getRole());
        bindingBuilder.addAllMembers(binding.getMembers());
        if (binding.getCondition() != null) {
          Condition condition = binding.getCondition();
          bindingBuilder.setCondition(
              Expr.newBuilder()
                  .setTitle(condition.getTitle())
                  .setDescription(condition.getDescription())
                  .setExpression(condition.getExpression())
                  .build());
        }
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

  /** A builder for {@code Policy} objects. */
  public static class Builder {
    private final List<Binding> bindingsList = new ArrayList<Binding>();
    private String etag;
    private int version;

    @InternalApi("This class should only be extended within google-cloud-java")
    protected Builder() {}

    @InternalApi("This class should only be extended within google-cloud-java")
    protected Builder(Policy policy) {
      bindingsList.addAll(policy.bindingsList);
      setEtag(policy.etag);
      setVersion(policy.version);
    }

    /**
     * Replaces the builder's map of bindings with the given map of bindings.
     *
     * @throws NullPointerException if the given map is null or contains any null keys or values
     * @throws IllegalArgumentException if any identities in the given map are null or if policy
     *     version is equal to 3 or has conditional bindings because conditional policies are not
     *     supported
     */
    public final Builder setBindings(Map<Role, Set<Identity>> bindings) {
      checkNotNull(bindings, "The provided map of bindings cannot be null.");
      checkArgument(
          !isConditional(this.version, this.bindingsList),
          "setBindings() is only supported with version 1 policies and non-conditional policies");
      for (Map.Entry<Role, Set<Identity>> binding : bindings.entrySet()) {
        checkNotNull(binding.getKey(), "The role cannot be null.");
        Set<Identity> identities = binding.getValue();
        checkNotNull(identities, "A role cannot be assigned to a null set of identities.");
        checkArgument(!identities.contains(null), "Null identities are not permitted.");
      }
      // convert into List format
      this.bindingsList.clear();
      for (Map.Entry<Role, Set<Identity>> binding : bindings.entrySet()) {
        Binding.Builder bindingBuilder = Binding.newBuilder();
        bindingBuilder.setRole(binding.getKey().getValue());
        ImmutableList.Builder<String> membersBuilder = ImmutableList.builder();
        for (Identity identity : binding.getValue()) {
          membersBuilder.add(identity.strValue());
        }
        bindingBuilder.setMembers(membersBuilder.build());
        this.bindingsList.add(bindingBuilder.build());
      }
      return this;
    }

    /**
     * Replaces the builder's List of bindings with the given List of Bindings.
     *
     * @throws NullPointerException if the given list is null, role is null, or contains any null
     *     members in bindings
     */
    public final Builder setBindings(List<Binding> bindings) {
      this.bindingsList.clear();
      for (Binding binding : bindings) {
        Binding.Builder bindingBuilder = Binding.newBuilder();
        bindingBuilder.setMembers(ImmutableList.copyOf(binding.getMembers()));
        bindingBuilder.setRole(binding.getRole());
        bindingBuilder.setCondition(binding.getCondition());
        this.bindingsList.add(bindingBuilder.build());
      }
      return this;
    }

    /**
     * Removes the role (and all identities associated with that role) from the policy.
     *
     * @throws IllegalArgumentException if policy version is equal to 3 or has conditional bindings
     *     because conditional policies are not supported
     */
    public final Builder removeRole(Role role) {
      checkArgument(
          !isConditional(this.version, this.bindingsList),
          "removeRole() is only supported with version 1 policies and non-conditional policies");
      Iterator iterator = bindingsList.iterator();

      while (iterator.hasNext()) {
        Binding binding = (Binding) iterator.next();
        if (binding.getRole().equals(role.getValue())) {
          iterator.remove();
          return this;
        }
      }
      return this;
    }

    /**
     * Adds one or more identities to the policy under the role specified.
     *
     * @throws NullPointerException if the role or any of the identities is null.
     * @throws IllegalArgumentException if policy version is equal to 3 or has conditional bindings.
     */
    public final Builder addIdentity(Role role, Identity first, Identity... others) {
      checkArgument(
          !isConditional(this.version, this.bindingsList),
          "addIdentity() is only supported with version 1 policies and non-conditional policies");
      String nullIdentityMessage = "Null identities are not permitted.";
      checkNotNull(first, nullIdentityMessage);
      checkNotNull(others, nullIdentityMessage);
      checkNotNull(role, "The role cannot be null.");
      for (int i = 0; i < bindingsList.size(); i++) {
        Binding binding = bindingsList.get(i);
        if (binding.getRole().equals(role.getValue())) {
          Binding.Builder bindingBuilder = binding.toBuilder();
          ImmutableSet.Builder<String> membersBuilder = ImmutableSet.builder();
          membersBuilder.addAll(binding.getMembers());
          membersBuilder.add(first.strValue());
          for (Identity identity : others) {
            membersBuilder.add(identity.strValue());
          }
          bindingBuilder.setMembers(membersBuilder.build());
          bindingsList.set(i, bindingBuilder.build());
          return this;
        }
      }
      // Binding does not yet exist.
      Binding.Builder bindingBuilder = Binding.newBuilder().setRole(role.getValue());
      ImmutableSet.Builder<String> membersBuilder = ImmutableSet.builder();
      membersBuilder.add(first.strValue());
      for (Identity identity : others) {
        membersBuilder.add(identity.strValue());
      }
      bindingBuilder.setMembers(membersBuilder.build());
      bindingsList.add(bindingBuilder.build());
      return this;
    }

    /**
     * Removes one or more identities from an existing binding. Does nothing if the binding
     * associated with the provided role doesn't exist.
     *
     * @throws IllegalArgumentException if policy version is equal to 3 or has conditional bindings
     */
    public final Builder removeIdentity(Role role, Identity first, Identity... others) {
      checkArgument(
          !isConditional(this.version, this.bindingsList),
          "removeIdentity() is only supported with version 1 policies and non-conditional policies");
      String nullIdentityMessage = "Null identities are not permitted.";
      checkNotNull(first, nullIdentityMessage);
      checkNotNull(others, nullIdentityMessage);
      checkNotNull(role, "The role cannot be null.");
      for (int i = 0; i < bindingsList.size(); i++) {
        Binding binding = bindingsList.get(i);
        if (binding.getRole().equals(role.getValue())) {
          Binding.Builder bindingBuilder = binding.toBuilder().removeMembers(first.strValue());
          for (Identity identity : others) {
            bindingBuilder.removeMembers(identity.strValue());
          }
          Binding updatedBindings = bindingBuilder.build();
          bindingsList.set(i, updatedBindings);
          break;
        }
      }

      Iterator iterator = bindingsList.iterator();
      while (iterator.hasNext()) {
        Binding binding = (Binding) iterator.next();
        if (binding.getRole().equals(role.getValue()) && binding.getMembers().size() == 0) {
          iterator.remove();
          break;
        }
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
     * applied to the same version of the policy. If no etag is provided in the call to
     * setIamPolicy, then the existing policy is overwritten blindly.
     */
    public final Builder setEtag(String etag) {
      this.etag = etag;
      return this;
    }

    /** Sets the version of the policy. */
    public final Builder setVersion(int version) {
      this.version = version;
      return this;
    }

    /** Creates a {@code Policy} object. */
    public final Policy build() {
      return new Policy(this);
    }
  }

  private Policy(Builder builder) {
    this.bindingsList = ImmutableList.copyOf(builder.bindingsList);
    this.etag = builder.etag;
    this.version = builder.version;
  }

  /** Returns a builder containing the properties of this IAM Policy. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /**
   * Returns the map of bindings that comprises the policy.
   *
   * @throws IllegalArgumentException if policy version is equal to 3 or has conditional bindings
   */
  public Map<Role, Set<Identity>> getBindings() {
    checkArgument(
        !isConditional(this.version, this.bindingsList),
        "getBindings() is only supported with version 1 policies and non-conditional policies");
    ImmutableMap.Builder<Role, Set<Identity>> bindingsV1Builder = ImmutableMap.builder();
    for (Binding binding : bindingsList) {
      ImmutableSet.Builder<Identity> identities = ImmutableSet.builder();
      for (String member : binding.getMembers()) {
        identities.add(Identity.valueOf(member));
      }
      bindingsV1Builder.put(Role.of(binding.getRole()), identities.build());
    }
    return bindingsV1Builder.build();
  }

  /** Returns the list of bindings that comprises the policy for version 3. */
  public ImmutableList<Binding> getBindingsList() {
    return bindingsList;
  }

  /**
   * Returns the policy's etag.
   *
   * <p>Etags are used for optimistic concurrency control as a way to help prevent simultaneous
   * updates of a policy from overwriting each other. It is strongly suggested that systems make use
   * of the etag in the read-modify-write cycle to perform policy updates in order to avoid race
   * conditions. An etag is returned in the response to getIamPolicy, and systems are expected to
   * put that etag in the request to setIamPolicy to ensure that their change will be applied to the
   * same version of the policy. If no etag is provided in the call to setIamPolicy, then the
   * existing policy is overwritten blindly.
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
        .add("bindings", bindingsList)
        .add("etag", etag)
        .add("version", version)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getClass(), bindingsList, etag, version);
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
    if (bindingsList == null && other.getBindingsList() == null) {
      return true;
    }
    if ((bindingsList == null && other.getBindingsList() != null)
        || bindingsList != null && other.getBindingsList() == null
        || bindingsList.size() != other.getBindingsList().size()) {
      return false;
    }
    for (Binding binding : bindingsList) {
      if (!other.getBindingsList().contains(binding)) {
        return false;
      }
    }
    return Objects.equals(etag, other.getEtag()) && version == other.getVersion();
  }

  /** Returns a builder for {@code Policy} objects. */
  public static Builder newBuilder() {
    return new Builder();
  }
}
