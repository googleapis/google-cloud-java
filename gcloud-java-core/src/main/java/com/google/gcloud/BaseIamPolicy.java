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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Base class for Identity and Access Management (IAM) policies. IAM policies are used to specify
 * access settings for Cloud Platform resources. A Policy consists of a list of bindings. An binding
 * assigns a list of identities to a role, where the identities can be user accounts, Google groups,
 * Google domains, and service accounts. A role is a named list of permissions defined by IAM.
 *
 * @see <a href="https://cloud.google.com/iam/reference/rest/v1/Policy">Policy</a>
 */
public abstract class BaseIamPolicy<R> implements Serializable {

  private static final long serialVersionUID = 1114489978726897720L;

  private final Map<R, List<Identity>> bindings;
  private final String etag;
  private final int version;

  public static final class Identity implements Serializable {

    private static final long serialVersionUID = 30811617560110848L;

    private final Type type;
    private final String id;

    /**
     * The types of IAM identities.
     */
    public enum Type {
      /**
       * Represents anyone who is on the internet; with or without a Google account.
       */
      ALL_USERS,

      /**
       * Represents anyone who is authenticated with a Google account or a service account.
       */
      ALL_AUTHENTICATED_USERS,

      /**
       * Represents a specific Google account.
       */
      USER,

      /**
       * Represents a service account.
       */
      SERVICE_ACCOUNT,

      /**
       * Represents a Google group.
       */
      GROUP,

      /**
       * Represents all the users of a Google Apps domain name.
       */
      DOMAIN
    }

    private Identity(Type type, String id) {
      this.type = type;
      this.id = id;
    }

    public Type type() {
      return type;
    }

    /**
     * Returns the string identifier for this identity. The id corresponds to:
     * <ul>
     *   <li>email address (for identities of type {@code USER}, {@code SERVICE_ACCOUNT}, and
     *       {@code GROUP})
     *   <li>domain (for identities of type {@code DOMAIN})
     *   <li>null (for identities of type {@code ALL_USERS} and {@code ALL_AUTHENTICATED_USERS})
     * </ul>
     */
    public String id() {
      return id;
    }

    /**
     * Returns a new identity representing anyone who is on the internet; with or without a Google
     * account.
     */
    public static Identity allUsers() {
      return new Identity(Type.ALL_USERS, null);
    }

    /**
     * Returns a new identity representing anyone who is authenticated with a Google account or a
     * service account.
     */
    public static Identity allAuthenticatedUsers() {
      return new Identity(Type.ALL_AUTHENTICATED_USERS, null);
    }

    /**
     * Returns a new user identity.
     *
     * @param email An email address that represents a specific Google account. For example,
     *     alice@gmail.com or joe@example.com.
     */
    public static Identity user(String email) {
      return new Identity(Type.USER, checkNotNull(email));
    }

    /**
     * Returns a new service account identity.
     *
     * @param email An email address that represents a service account. For example,
     *     my-other-app@appspot.gserviceaccount.com.
     */
    public static Identity serviceAccount(String email) {
      return new Identity(Type.SERVICE_ACCOUNT, checkNotNull(email));
    }

    /**
     * Returns a new group identity.
     *
     * @param email An email address that represents a Google group. For example,
     *     admins@example.com.
     */
    public static Identity group(String email) {
      return new Identity(Type.GROUP, checkNotNull(email));
    }

    /**
     * Returns a new domain identity.
     *
     * @param domain A Google Apps domain name that represents all the users of that domain. For
     *     example, google.com or example.com.
     */
    public static Identity domain(String domain) {
      return new Identity(Type.DOMAIN, checkNotNull(domain));
    }

    @Override
    public int hashCode() {
      return Objects.hash(id, type);
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof Identity)) {
        return false;
      }
      Identity other = (Identity) obj;
      return Objects.equals(id, other.id()) && Objects.equals(type, other.type());
    }
  }

  /**
   * Builder for an IAM Policy.
   */
  protected abstract static class BaseBuilder<R, B extends BaseBuilder<R, B>> {

    private final Map<R, List<Identity>> bindings = new HashMap<>();
    private String etag;
    private int version;

    /**
     * Replaces the builder's list of bindings with the given list of bindings.
     */
    public B bindings(Map<R, List<Identity>> bindings) {
      this.bindings.clear();
      this.bindings.putAll(bindings);
      return self();
    }

    /**
     * Adds one or more bindings to the policy.
     */
    public B addBinding(R role, List<Identity> identities) {
      bindings.put(role, ImmutableList.copyOf(identities));
      return self();
    }

    /**
     * Removes the specified ACL.
     */
    public B removeBinding(R role) {
      bindings.remove(role);
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
    protected B etag(String etag) {
      this.etag = etag;
      return self();
    }

    /**
     * Sets the version of the policy. The default version is 0, meaning roles that are in alpha
     * (non-legacy) roles are not permitted. If the version is 1, you may use roles other than
     * "owner", "editor", and "viewer".
     */
    protected B version(int version) {
      this.version = version;
      return self();
    }

    @SuppressWarnings("unchecked")
    private B self() {
      return (B) this;
    }

    public abstract BaseIamPolicy<R> build();
  }

  protected BaseIamPolicy(BaseBuilder<R, ? extends BaseBuilder<R, ?>> builder) {
    this.bindings = builder.bindings;
    this.etag = builder.etag;
    this.version = builder.version;
  }

  /**
   * The list of ACLs specified in the policy.
   */
  public Map<R, List<Identity>> bindings() {
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
   * The version of the policy. The default version is 0.
   */
  public int version() {
    return version;
  }

  public int baseHashCode() {
    return Objects.hash(bindings, etag, version);
  }

  public boolean baseEquals(Object obj) {
    if (!(obj instanceof BaseIamPolicy)) {
      return false;
    }
    @SuppressWarnings("rawtypes")
    BaseIamPolicy other = (BaseIamPolicy) obj;
    return Objects.equals(bindings, other.bindings())
        && Objects.equals(etag, other.etag())
        && Objects.equals(version, other.version());
  }
}
