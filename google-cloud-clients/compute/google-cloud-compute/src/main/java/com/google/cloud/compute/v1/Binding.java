/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** Associates `members` with a `role`. */
public final class Binding implements ApiMessage {
  private final Expr condition;
  private final List<String> members;
  private final String role;

  private Binding() {
    this.condition = null;
    this.members = null;
    this.role = null;
  }

  private Binding(Expr condition, List<String> members, String role) {
    this.condition = condition;
    this.members = members;
    this.role = role;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("condition".equals(fieldName)) {
      return condition;
    }
    if ("members".equals(fieldName)) {
      return members;
    }
    if ("role".equals(fieldName)) {
      return role;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /**
   * The condition that is associated with this binding. NOTE: An unsatisfied condition will not
   * allow user access via current binding. Different bindings, including their conditions, are
   * examined independently.
   */
  public Expr getCondition() {
    return condition;
  }

  /**
   * Specifies the identities requesting access for a Cloud Platform resource. `members` can have
   * the following values:
   *
   * <p>&#42; `allUsers`: A special identifier that represents anyone who is on the internet; with
   * or without a Google account.
   *
   * <p>&#42; `allAuthenticatedUsers`: A special identifier that represents anyone who is
   * authenticated with a Google account or a service account.
   *
   * <p>&#42; `user:{emailid}`: An email address that represents a specific Google account. For
   * example, `alice{@literal @}gmail.com` .
   *
   * <p>&#42; `serviceAccount:{emailid}`: An email address that represents a service account. For
   * example, `my-other-app{@literal @}appspot.gserviceaccount.com`.
   *
   * <p>&#42; `group:{emailid}`: An email address that represents a Google group. For example,
   * `admins{@literal @}example.com`.
   *
   * <p>&#42; `domain:{domain}`: The G Suite domain (primary) that represents all the users of that
   * domain. For example, `google.com` or `example.com`.
   */
  public List<String> getMembersList() {
    return members;
  }

  /**
   * Role that is assigned to `members`. For example, `roles/viewer`, `roles/editor`, or
   * `roles/owner`.
   */
  public String getRole() {
    return role;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Binding prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Binding getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Binding DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Binding();
  }

  public static class Builder {
    private Expr condition;
    private List<String> members;
    private String role;

    Builder() {}

    public Builder mergeFrom(Binding other) {
      if (other == Binding.getDefaultInstance()) return this;
      if (other.getCondition() != null) {
        this.condition = other.condition;
      }
      if (other.getMembersList() != null) {
        this.members = other.members;
      }
      if (other.getRole() != null) {
        this.role = other.role;
      }
      return this;
    }

    Builder(Binding source) {
      this.condition = source.condition;
      this.members = source.members;
      this.role = source.role;
    }

    /**
     * The condition that is associated with this binding. NOTE: An unsatisfied condition will not
     * allow user access via current binding. Different bindings, including their conditions, are
     * examined independently.
     */
    public Expr getCondition() {
      return condition;
    }

    /**
     * The condition that is associated with this binding. NOTE: An unsatisfied condition will not
     * allow user access via current binding. Different bindings, including their conditions, are
     * examined independently.
     */
    public Builder setCondition(Expr condition) {
      this.condition = condition;
      return this;
    }

    /**
     * Specifies the identities requesting access for a Cloud Platform resource. `members` can have
     * the following values:
     *
     * <p>&#42; `allUsers`: A special identifier that represents anyone who is on the internet; with
     * or without a Google account.
     *
     * <p>&#42; `allAuthenticatedUsers`: A special identifier that represents anyone who is
     * authenticated with a Google account or a service account.
     *
     * <p>&#42; `user:{emailid}`: An email address that represents a specific Google account. For
     * example, `alice{@literal @}gmail.com` .
     *
     * <p>&#42; `serviceAccount:{emailid}`: An email address that represents a service account. For
     * example, `my-other-app{@literal @}appspot.gserviceaccount.com`.
     *
     * <p>&#42; `group:{emailid}`: An email address that represents a Google group. For example,
     * `admins{@literal @}example.com`.
     *
     * <p>&#42; `domain:{domain}`: The G Suite domain (primary) that represents all the users of
     * that domain. For example, `google.com` or `example.com`.
     */
    public List<String> getMembersList() {
      return members;
    }

    /**
     * Specifies the identities requesting access for a Cloud Platform resource. `members` can have
     * the following values:
     *
     * <p>&#42; `allUsers`: A special identifier that represents anyone who is on the internet; with
     * or without a Google account.
     *
     * <p>&#42; `allAuthenticatedUsers`: A special identifier that represents anyone who is
     * authenticated with a Google account or a service account.
     *
     * <p>&#42; `user:{emailid}`: An email address that represents a specific Google account. For
     * example, `alice{@literal @}gmail.com` .
     *
     * <p>&#42; `serviceAccount:{emailid}`: An email address that represents a service account. For
     * example, `my-other-app{@literal @}appspot.gserviceaccount.com`.
     *
     * <p>&#42; `group:{emailid}`: An email address that represents a Google group. For example,
     * `admins{@literal @}example.com`.
     *
     * <p>&#42; `domain:{domain}`: The G Suite domain (primary) that represents all the users of
     * that domain. For example, `google.com` or `example.com`.
     */
    public Builder addAllMembers(List<String> members) {
      if (this.members == null) {
        this.members = new LinkedList<>();
      }
      this.members.addAll(members);
      return this;
    }

    /**
     * Specifies the identities requesting access for a Cloud Platform resource. `members` can have
     * the following values:
     *
     * <p>&#42; `allUsers`: A special identifier that represents anyone who is on the internet; with
     * or without a Google account.
     *
     * <p>&#42; `allAuthenticatedUsers`: A special identifier that represents anyone who is
     * authenticated with a Google account or a service account.
     *
     * <p>&#42; `user:{emailid}`: An email address that represents a specific Google account. For
     * example, `alice{@literal @}gmail.com` .
     *
     * <p>&#42; `serviceAccount:{emailid}`: An email address that represents a service account. For
     * example, `my-other-app{@literal @}appspot.gserviceaccount.com`.
     *
     * <p>&#42; `group:{emailid}`: An email address that represents a Google group. For example,
     * `admins{@literal @}example.com`.
     *
     * <p>&#42; `domain:{domain}`: The G Suite domain (primary) that represents all the users of
     * that domain. For example, `google.com` or `example.com`.
     */
    public Builder addMembers(String members) {
      if (this.members == null) {
        this.members = new LinkedList<>();
      }
      this.members.add(members);
      return this;
    }

    /**
     * Role that is assigned to `members`. For example, `roles/viewer`, `roles/editor`, or
     * `roles/owner`.
     */
    public String getRole() {
      return role;
    }

    /**
     * Role that is assigned to `members`. For example, `roles/viewer`, `roles/editor`, or
     * `roles/owner`.
     */
    public Builder setRole(String role) {
      this.role = role;
      return this;
    }

    public Binding build() {

      return new Binding(condition, members, role);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCondition(this.condition);
      newBuilder.addAllMembers(this.members);
      newBuilder.setRole(this.role);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Binding{"
        + "condition="
        + condition
        + ", "
        + "members="
        + members
        + ", "
        + "role="
        + role
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Binding) {
      Binding that = (Binding) o;
      return Objects.equals(this.condition, that.getCondition())
          && Objects.equals(this.members, that.getMembersList())
          && Objects.equals(this.role, that.getRole());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(condition, members, role);
  }
}
