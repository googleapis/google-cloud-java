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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.ApiFunction;
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
  public static final class Type extends StringEnumValue {
    private static final long serialVersionUID = 3809891273596003916L;

    private Type(String constant) {
      super(constant);
    }

    private static final ApiFunction<String, Type> CONSTRUCTOR =
        new ApiFunction<String, Type>() {
          @Override
          public Type apply(String constant) {
            return new Type(constant);
          }
        };

    private static final StringEnumType<Type> type = new StringEnumType(
        Type.class,
        CONSTRUCTOR);

    /**
     * Represents anyone who is on the internet; with or without a Google account.
     */
    public static final Type ALL_USERS = type.createAndRegister("ALL_USERS");

    /**
     * Represents anyone who is authenticated with a Google account or a service account.
     */
    public static final Type ALL_AUTHENTICATED_USERS = type.createAndRegister("ALL_AUTHENTICATED_USERS");

    /**
     * Represents a specific Google account.
     */
    public static final Type USER = type.createAndRegister("USER");

    /**
     * Represents a service account.
     */
    public static final Type SERVICE_ACCOUNT = type.createAndRegister("SERVICE_ACCOUNT");

    /**
     * Represents a Google group.
     */
    public static final Type GROUP = type.createAndRegister("GROUP");

    /**
     * Represents all the users of a Google Apps domain name.
     */
    public static final Type DOMAIN = type.createAndRegister("DOMAIN");

    /**
     * Represents owners of a Google Cloud Platform project.
     */
    public static final Type PROJECT_OWNER = type.createAndRegister("PROJECT_OWNER");

    /**
     * Represents editors of a Google Cloud Platform project.
     */
    public static final Type PROJECT_EDITOR = type.createAndRegister("PROJECT_EDITOR");

    /**
     * Represents viewers of a Google Cloud Platform project.
     */
    public static final Type PROJECT_VIEWER = type.createAndRegister("PROJECT_VIEWER");

    /**
     * Get the Type for the given String constant, and throw an exception if the constant is
     * not recognized.
     */
    public static Type valueOfStrict(String constant) {
      return type.valueOfStrict(constant);
    }

    /**
     * Get the Type for the given String constant, and allow unrecognized values.
     */
    public static Type valueOf(String constant) {
      return type.valueOf(constant);
    }

    /**
     * Return the known values for Type.
     */
    public static Type[] values() {
      return type.values();
    }
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
    String protobufString = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, type.toString());
    if (value == null) {
      return protobufString;
    } else {
      return protobufString + ":" + value;
    }
  }

  /**
   * Converts a string to an {@code Identity}. Used primarily for converting protobuf-generated
   * policy identities to {@code Identity} objects.
   */
  public static Identity valueOf(String identityStr) {
    String[] info = identityStr.split(":");
    Type type = Type.valueOf(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, info[0]));
    if (info.length == 1) {
      return new Identity(type, null);
    } else if (info.length == 2){
      return new Identity(type, info[1]);
    } else {
      throw new IllegalArgumentException("Illegal identity string: \"" + identityStr + "\"");
    }
  }
}
