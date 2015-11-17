/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.resourcemanager;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A Google Cloud IAM Policy object
 */
public class Policy implements Serializable {

  private static final long serialVersionUID = 3493286111316914094L;
  private final List<Binding> bindings;
  private final Integer version;
  private final String etag;

  public static enum MemberType {
    ALL_USERS("allUsers"),
    ALL_AUTHENTICATED_USERS("allAuthenticatedUsers"),
    USER("user:"),
    SERVICE_ACCOUNT("serviceAccount:"),
    GROUP("group:"),
    DOMAIN("domain:");

    private final String prefix;

    MemberType(String prefix) {
      this.prefix = prefix;
    }

    String prefix() {
      return prefix;
    }
  }

  public enum RoleType {
    OWNER,
    EDITOR,
    VIEWER;
  }

  /**
   * Represents a member belonging to an IAM policy binding
   */
  public static final class Member implements Serializable {

    private static final long serialVersionUID = 6496912037577986137L;
    private final MemberType memberType;
    private final String emailOrDomain;

    Member(MemberType memberType, String emailOrDomain) {
      this.memberType = memberType;
      this.emailOrDomain = emailOrDomain;
    }

    public static Member allUsers() {
      throw new UnsupportedOperationException(
          "Google Cloud Resource Manager does not support the \"all users\" member type yet.");
      // return new Member(MemberType.ALL_USERS, null);
    }

    public static Member allAuthenticatedUsers() {
      throw new UnsupportedOperationException("Google Cloud Resource Manager does not support the "
          + "\"all authenticated users\" member type yet.");
      // return new Member(MemberType.ALL_AUTHENTICATED_USERS, null);
    }

    public static Member user(String email) {
      return new Member(MemberType.USER, email);
    }

    public static Member serviceAccount(String email) {
      return new Member(MemberType.SERVICE_ACCOUNT, email);
    }

    public static Member group(String email) {
      return new Member(MemberType.GROUP, email);
    }

    public static Member domain(String domain) {
      throw new UnsupportedOperationException(
          "Google Cloud Resource Manager does not support domain members yet.");
      // return new Member(MemberType.DOMAIN, domain);
    }

    public MemberType type() {
      return memberType;
    }

    public String emailOrDomain() {
      return emailOrDomain;
    }

    @Override
    public int hashCode() {
      return Objects.hash(memberType, emailOrDomain);
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof Member && Objects.equals(this.memberType, ((Member) obj).memberType)
          && Objects.equals(this.emailOrDomain, ((Member) obj).emailOrDomain);
    }

    String toPb() {
      return emailOrDomain != null ? memberType.prefix() + emailOrDomain : memberType.prefix();
    }

    static Member fromPb(String memberPb) {
      String[] memberInfo = memberPb.split(":", 2);
      String memberStr = memberInfo[0];
      String emailOrDomain = (memberInfo.length > 1) ? memberInfo[1] : null;
      switch (memberStr) {
        case "allUsers":
          return new Member(MemberType.ALL_USERS, null);
        case "allAuthenticatedUsers":
          return new Member(MemberType.ALL_AUTHENTICATED_USERS, null);
        case "user":
          return new Member(MemberType.USER, checkNotNull(emailOrDomain));
        case "serviceAccount":
          return new Member(MemberType.SERVICE_ACCOUNT, checkNotNull(emailOrDomain));
        case "group":
          return new Member(MemberType.GROUP, checkNotNull(emailOrDomain));
        case "domain":
          return new Member(MemberType.DOMAIN, checkNotNull(emailOrDomain));
        default:
          throw new UnsupportedOperationException("Unsupported member type: " + memberStr);
      }
    }
  }

  /**
   * Represents an IAM policy binding
   */
  public static class Binding implements Serializable {

    private static final long serialVersionUID = -8493421092718338925L;
    private final RoleType role;
    private final List<Member> members;

    public static class Builder {
      private RoleType role;
      private List<Member> members;

      Builder() {
        members = new ArrayList<Member>();
      }

      public Builder role(RoleType role) {
        this.role = role;
        return this;
      }

      public Builder members(List<Member> members) {
        this.members = Lists.newArrayList(checkNotNull(members));
        return this;
      }

      public Builder clearMembers() {
        this.members = new ArrayList<>();
        return this;
      }

      public Builder addMember(Member member) {
        this.members.add(member);
        return this;
      }

      public Builder removeMember(Member member) {
        this.members.remove(member);
        return this;
      }

      public Binding build() {
        return new Binding(role, members);
      }
    }

    private Binding(RoleType role, List<Member> members) {
      this.role = checkNotNull(role);
      this.members = ImmutableList.copyOf(members);
    }

    public static Binding of(RoleType role, List<Member> members) {
      return new Binding(role, members);
    }

    public RoleType role() {
      return role;
    }

    public List<Member> members() {
      return members;
    }

    public static Builder builder() {
      return new Builder();
    }

    public Builder toBuilder() {
      return new Builder().role(role).members(members);
    }

    com.google.api.services.cloudresourcemanager.model.Binding toPb() {
      com.google.api.services.cloudresourcemanager.model.Binding bindingPb =
          new com.google.api.services.cloudresourcemanager.model.Binding();
      bindingPb.setRole("roles/" + role.toString().toLowerCase());
      List<String> membersPb = new ArrayList<>(members.size());
      for (Member member : members) {
        membersPb.add(member.toPb());
      }
      bindingPb.setMembers(membersPb);
      return bindingPb;
    }

    static Binding fromPb(com.google.api.services.cloudresourcemanager.model.Binding bindingPb) {
      RoleType role =
          (bindingPb.getRole() == null)
              ? null : RoleType.valueOf(bindingPb.getRole().split("/")[1].toUpperCase());
      List<Member> members = new ArrayList<>();
      if (bindingPb.getMembers() != null) {
        for (String memberPb : bindingPb.getMembers()) {
          members.add(Member.fromPb(memberPb));
        }
      }
      return new Binding(role, members);
    }

    @Override
    public int hashCode() {
      return Objects.hash(role, members);
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof Binding && Objects.equals(toPb(), ((Binding) obj).toPb());
    }
  }

  public static final class Builder {
    private List<Binding> bindings;
    private String etag;
    private Integer version;

    private Builder() {
      bindings = new ArrayList<>();
    }

    public Builder addBinding(Binding binding) {
      this.bindings.add(binding);
      return this;
    }

    public Builder removeBinding(Binding binding) {
      this.bindings.remove(binding);
      return this;
    }

    public Builder clearBindings() {
      this.bindings = new ArrayList<>();
      return this;
    }

    public Builder bindings(List<Binding> bindings) {
      this.bindings = new ArrayList<>(checkNotNull(bindings));
      return this;
    }

    public Builder etag(String etag) {
      this.etag = etag;
      return this;
    }

    public Builder version(Integer version) {
      this.version = version;
      return this;
    }

    public Policy build() {
      return new Policy(this);
    }
  }

  Policy(Builder builder) {
    bindings = ImmutableList.copyOf(builder.bindings);
    version = builder.version;
    etag = builder.etag;
  }

  public List<Binding> bindings() {
    return bindings;
  }

  public Integer version() {
    return version;
  }

  public String etag() {
    return etag;
  }

  public static Builder builder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder().bindings(bindings).etag(etag).version(version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bindings, etag, version);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Policy && Objects.equals(toPb(), ((Policy) obj).toPb());
  }

  com.google.api.services.cloudresourcemanager.model.Policy toPb() {
    com.google.api.services.cloudresourcemanager.model.Policy policyPb =
        new com.google.api.services.cloudresourcemanager.model.Policy();
    List<com.google.api.services.cloudresourcemanager.model.Binding> bindingsPb = new ArrayList<>();
    for (Binding binding : bindings) {
      bindingsPb.add(binding.toPb());
    }
    policyPb.setBindings(bindingsPb);
    policyPb.setVersion(version);
    policyPb.setEtag(etag);
    return policyPb;
  }

  static Policy fromPb(com.google.api.services.cloudresourcemanager.model.Policy policyPb) {
    Builder policyBuilder = Policy.builder();
    if (policyPb.getBindings() != null) {
      for (com.google.api.services.cloudresourcemanager.model.Binding bindingPb :
          policyPb.getBindings()) {
        policyBuilder.addBinding(Binding.fromPb(bindingPb));
      }
    }
    policyBuilder.version(policyPb.getVersion());
    policyBuilder.etag(policyPb.getEtag());
    return policyBuilder.build();
  }
}
