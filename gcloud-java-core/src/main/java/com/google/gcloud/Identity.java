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

import java.io.Serializable;
import java.util.Objects;

/**
 * An identity in an {@link IamPolicy}.
 */
public final class Identity implements Serializable {

  private static final long serialVersionUID = -8181841964597657446L;

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
   *     <I>alice@gmail.com</I> or <I>joe@example.com</I>.
   */
  public static Identity user(String email) {
    return new Identity(Type.USER, checkNotNull(email));
  }

  /**
   * Returns a new service account identity.
   *
   * @param email An email address that represents a service account. For example,
   *     <I>my-other-app@appspot.gserviceaccount.com</I>.
   */
  public static Identity serviceAccount(String email) {
    return new Identity(Type.SERVICE_ACCOUNT, checkNotNull(email));
  }

  /**
   * Returns a new group identity.
   *
   * @param email An email address that represents a Google group. For example,
   *     <I>admins@example.com</I>.
   */
  public static Identity group(String email) {
    return new Identity(Type.GROUP, checkNotNull(email));
  }

  /**
   * Returns a new domain identity.
   *
   * @param domain A Google Apps domain name that represents all the users of that domain. For
   *     example, <I>google.com</I> or <I>example.com</I>.
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

  /**
   * Returns the string value associated with the identity. Used primarily for converting from
   * {@code Identity} objects to strings for protobuf-generated policies.
   */
  public String strValue() {
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
      case DOMAIN:
        return "domain:" + id;
      default:
        throw new IllegalArgumentException("Unexpected identity type: " + type);
    }
  }

  /**
   * Converts a string to an {@code Identity}. Used primarily for converting protobuf-generated
   * policy identities to {@code Identity} objects.
   */
  public static Identity valueOf(String identityStr) {
    String[] info = identityStr.split(":");
    switch (info[0]) {
      case "allUsers":
        return Identity.allUsers();
      case "allAuthenticatedUsers":
        return Identity.allAuthenticatedUsers();
      case "user":
        return Identity.user(info[1]);
      case "serviceAccount":
        return Identity.serviceAccount(info[1]);
      case "group":
        return Identity.group(info[1]);
      case "domain":
        return Identity.domain(info[1]);
      default:
        throw new IllegalArgumentException("Unexpected identity type: " + info[0]);
    }
  }
}
