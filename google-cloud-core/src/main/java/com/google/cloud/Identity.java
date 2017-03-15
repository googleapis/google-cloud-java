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

package com.google.cloud;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.CaseFormat;

import java.io.Serializable;
import java.util.Objects;

/**
 * An identity in a {@link Policy}. The following types of identities are permitted in IAM policies:
 * <ul>
 * <li>Google account
 * <li>Service account
 * <li>Google group
 * <li>Google Apps domain
 * </ul>
 *
 * <p>There are also two special identities that represent all users and all Google-authenticated
 * accounts.
 *
 * @see <a href="https://cloud.google.com/iam/docs/overview#concepts_related_to_identity">Concepts
 *     related to identity</a>
 */
public final class Identity implements Serializable {

  private static final long serialVersionUID = -8181841964597657446L;

  private final Type type;
  private final String value;

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
    DOMAIN,
    
    /**
     * Represents owners of a Google Cloud Platform project.
     */
    PROJECT_OWNER,
    
    /**
     * Represents editors of a Google Cloud Platform project.
     */
    PROJECT_EDITOR,
    
    /**
     * Represents viewers of a Google Cloud Platform project.
     */
    PROJECT_VIEWER
  }

  private Identity(Type type, String value) {
    this.type = type;
    this.value = value;
  }


  public Type getType() {
    return type;
  }


  /**
   * Returns the string identifier for this identity. The value corresponds to:
   * <ul>
   *   <li>email address (for identities of type {@code USER}, {@code SERVICE_ACCOUNT}, and
   *       {@code GROUP})
   *   <li>domain (for identities of type {@code DOMAIN})
   *   <li>{@code null} (for identities of type {@code ALL_USERS} and
   *       {@code ALL_AUTHENTICATED_USERS})
   * </ul>
   */
  public String getValue() {
    return value;
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
  
  /**
   * Returns a new project owner identity.
   * @param projectId A Google Cloud Platform project ID. For example, <I>my-sample-project</I>.
   */
  public static Identity projectOwner(String projectId) {
    return new Identity(Type.PROJECT_OWNER, checkNotNull(projectId));
  }
  
  /**
   * Returns a new project editor identity.
   * @param projectId A Google Cloud Platform project ID. For example, <I>my-sample-project</I>.
   */
  public static Identity projectEditor(String projectId) {
    return new Identity(Type.PROJECT_EDITOR, checkNotNull(projectId));
  }
  
  /**
   * Returns a new project viewer identity.
   * @param projectId A Google Cloud Platform project ID. For example, <I>my-sample-project</I>.
   */
  public static Identity projectViewer(String projectId) {
    return new Identity(Type.PROJECT_VIEWER, checkNotNull(projectId));
  }

  @Override
  public String toString() {
    return strValue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, type);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Identity)) {
      return false;
    }
    Identity other = (Identity) obj;
    return Objects.equals(value, other.getValue()) && Objects.equals(type, other.getType());
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
        return "user:" + value;
      case SERVICE_ACCOUNT:
        return "serviceAccount:" + value;
      case GROUP:
        return "group:" + value;
      case DOMAIN:
        return "domain:" + value;
      case PROJECT_OWNER:
        return "projectOwner:" + value;
      case PROJECT_EDITOR:
        return "projectEditor:" + value;
      case PROJECT_VIEWER:
        return "projectViewer:" + value;
      default:
        throw new IllegalStateException("Unexpected identity type: " + type);
    }
  }

  /**
   * Converts a string to an {@code Identity}. Used primarily for converting protobuf-generated
   * policy identities to {@code Identity} objects.
   */
  public static Identity valueOf(String identityStr) {
    String[] info = identityStr.split(":");
    Type type = Type.valueOf(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, info[0]));
    switch (type) {
      case ALL_USERS:
        return Identity.allUsers();
      case ALL_AUTHENTICATED_USERS:
        return Identity.allAuthenticatedUsers();
      case USER:
        return Identity.user(info[1]);
      case SERVICE_ACCOUNT:
        return Identity.serviceAccount(info[1]);
      case GROUP:
        return Identity.group(info[1]);
      case DOMAIN:
        return Identity.domain(info[1]);
      case PROJECT_OWNER:
        return Identity.projectOwner(info[1]);
      case PROJECT_EDITOR:
        return Identity.projectEditor(info[1]);
      case PROJECT_VIEWER:
        return Identity.projectViewer(info[1]);
      default:
        throw new IllegalStateException("Unexpected identity type " + type);
    }
  }
}
