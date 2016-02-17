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

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * An Identity and Access Management (IAM) policy. It is used to specify access control policies for
 * Cloud Platform resources. A Policy consists of a list of ACLs (also known as bindings in Cloud
 * IAM documentation). An ACL binds a list of identities to a role, where the identities can be user
 * accounts, Google groups, Google domains, and service accounts. A role is a named list of
 * permissions defined by IAM.
 *
 * @see <a href="https://cloud.google.com/iam/reference/rest/v1/Policy">Policy</a>
 */
public class IamPolicy implements Serializable {

  static final long serialVersionUID = 1114489978726897720L;

  private final List<Acl> acls;
  private final String etag;
  private final int version;

  public static class Identity implements Serializable {

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

    Identity(Type type, String id) {
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
      return Objects.equals(toPb(), other.toPb());
    }

    String toPb() {
      switch (type) {
        case ALL_USERS:
          return "allUsers";
        case ALL_AUTHENTICATED_USERS:
          return "allAuthenticatedUsers";
        case USER:
          return "user:" + id;
        case SERVICE_ACCOUNT:
          return "serviceAccount:" + id;
        case GROUP:
          return "group:" + id;
        default:
          return "domain:" + id;
      }
    }

    static Identity fromPb(String identityStr) {
      String[] info = identityStr.split(":");
      switch (info[0]) {
        case "allUsers":
          return allUsers();
        case "allAuthenticatedUsers":
          return allAuthenticatedUsers();
        case "user":
          return user(info[1]);
        case "serviceAccount":
          return serviceAccount(info[1]);
        case "group":
          return group(info[1]);
        case "domain":
          return domain(info[1]);
        default:
          throw new IllegalArgumentException("Unexpected identity type: " + info[0]);
      }
    }
  }

  /**
   * An ACL binds a list of identities to a role, where the identities can be user accounts, Google
   * groups, Google domains, and service accounts. A role is a named list of permissions defined by
   * IAM.
   *
   * @see <a href="https://cloud.google.com/iam/reference/rest/v1/Policy#Binding">Binding</a>
   */
  public static class Acl implements Serializable {

    private static final long serialVersionUID = 3954282899483745158L;

    private final List<Identity> identities;
    private final String role;

    /**
     * An ACL builder.
     */
    public static class Builder {
      private final List<Identity> members = new LinkedList<>();
      private String role;

      Builder(String role) {
        this.role = role;
      }

      /**
       * Sets the role associated with this ACL.
       */
      public Builder role(String role) {
        this.role = role;
        return this;
      }

      /**
       * Replaces the builder's list of identities with the given list.
       */
      public Builder identities(List<Identity> identities) {
        this.members.clear();
        this.members.addAll(identities);
        return this;
      }

      /**
       * Adds one or more identities to the list of identities associated with the ACL.
       */
      public Builder addIdentity(Identity first, Identity... others) {
        members.add(first);
        members.addAll(Arrays.asList(others));
        return this;
      }

      /**
       * Removes the specified identity from the ACL.
       */
      public Builder removeIdentity(Identity identity) {
        members.remove(identity);
        return this;
      }

      public Acl build() {
        return new Acl(this);
      }
    }

    Acl(Builder builder) {
      identities = ImmutableList.copyOf(checkNotNull(builder.members));
      role = checkNotNull(builder.role);
    }

    /**
     * Returns the list of identities associated with this ACL.
     */
    public List<Identity> identities() {
      return identities;
    }

    /**
     * Returns the role associated with this ACL.
     */
    public String role() {
      return role;
    }

    /**
     * Returns an ACL builder for the specific role type.
     *
     * @param role string representing the role, without the "roles/" prefix.  An example of a valid
     *     legacy role is "viewer". An example of a valid service-specific role is
     *     "pubsub.publisher".
     */
    public static Builder builder(String role) {
      return new Builder(role);
    }

    /**
     * Returns an ACL for the role type and list of identities provided.
     *
     * @param role string representing the role, without the "roles/" prefix.  An example of a valid
     *     legacy role is "viewer". An example of a valid service-specific role is
     *     "pubsub.publisher".
     * @param members list of identities associated with the role.
     */
    public static Acl of(String role, List<Identity> members) {
      return new Acl(new Builder(role).identities(members));
    }

    /**
     * Returns an ACL for the role type and identities provided.
     *
     * @param role string representing the role, without the "roles/" prefix.  An example of a valid
     *     legacy role is "viewer". An example of a valid service-specific role is
     *     "pubsub.publisher".
     * @param first identity associated with the role.
     * @param others any other identities associated with the role.
     */
    public static Acl of(String role, Identity first, Identity... others) {
      return new Acl(new Builder(role).addIdentity(first, others));
    }

    public Builder toBuilder() {
      return new Builder(role).identities(identities);
    }

    @Override
    public int hashCode() {
      return Objects.hash(identities, role);
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof Acl)) {
        return false;
      }
      Acl other = (Acl) obj;
      return Objects.equals(toPb(), other.toPb());
    }

    com.google.api.services.cloudresourcemanager.model.Binding toPb() {
      com.google.api.services.cloudresourcemanager.model.Binding bindingPb =
          new com.google.api.services.cloudresourcemanager.model.Binding();
      bindingPb.setMembers(Lists.transform(identities, new Function<Identity, String>() {
        @Override
        public String apply(Identity identity) {
          return identity.toPb();
        }
      }));
      bindingPb.setRole("roles/" + role);
      return bindingPb;
    }

    static Acl fromPb(com.google.api.services.cloudresourcemanager.model.Binding bindingPb) {
      return of(
          bindingPb.getRole().substring("roles/".length()),
          Lists.transform(bindingPb.getMembers(), new Function<String, Identity>() {
            @Override
            public Identity apply(String memberPb) {
              return Identity.fromPb(memberPb);
            }
          }));
    }
  }

  /**
   * Builder for an IAM Policy.
   */
  public static class Builder {

    private final List<Acl> acls = new LinkedList<>();
    private String etag;
    private int version;

    /**
     * Replaces the builder's list of ACLs with the given list of ACLs.
     */
    public Builder acls(List<Acl> acls) {
      this.acls.clear();
      this.acls.addAll(acls);
      return this;
    }

    /**
     * Adds one or more ACLs to the policy.
     */
    public Builder addAcl(Acl first, Acl... others) {
      acls.add(first);
      acls.addAll(Arrays.asList(others));
      return this;
    }

    /**
     * Removes the specified ACL.
     */
    public Builder removeAcl(Acl acl) {
      acls.remove(acl);
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
    public Builder etag(String etag) {
      this.etag = etag;
      return this;
    }

    /**
     * Sets the version of the policy. The default version is 0.
     */
    public Builder version(int version) {
      this.version = version;
      return this;
    }

    public IamPolicy build() {
      return new IamPolicy(this);
    }
  }

  IamPolicy(Builder builder) {
    acls = ImmutableList.copyOf(builder.acls);
    etag = builder.etag;
    version = builder.version;
  }

  /**
   * The list of ACLs specified in the policy.
   */
  public List<Acl> acls() {
    return acls;
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

  @Override
  public int hashCode() {
    return Objects.hash(acls, etag, version);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof IamPolicy)) {
      return false;
    }
    IamPolicy other = (IamPolicy) obj;
    return Objects.equals(toPb(), other.toPb());
  }

  public static Builder builder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder().acls(acls).etag(etag).version(version);
  }

  com.google.api.services.cloudresourcemanager.model.Policy toPb() {
    com.google.api.services.cloudresourcemanager.model.Policy policyPb =
        new com.google.api.services.cloudresourcemanager.model.Policy();
    policyPb.setBindings(Lists.transform(
        acls, new Function<Acl, com.google.api.services.cloudresourcemanager.model.Binding>() {
          @Override
          public com.google.api.services.cloudresourcemanager.model.Binding apply(Acl acl) {
            return acl.toPb();
          }
        }));
    policyPb.setEtag(etag);
    policyPb.setVersion(version);
    return policyPb;
  }

  static IamPolicy fromPb(com.google.api.services.cloudresourcemanager.model.Policy policyPb) {
    Builder builder = new Builder();
    builder.acls(Lists.transform(
        policyPb.getBindings(),
        new Function<com.google.api.services.cloudresourcemanager.model.Binding, Acl>() {
          @Override
          public Acl apply(com.google.api.services.cloudresourcemanager.model.Binding binding) {
            return Acl.fromPb(binding);
          }
        }));
    return builder.etag(policyPb.getEtag()).version(policyPb.getVersion()).build();
  }
}
