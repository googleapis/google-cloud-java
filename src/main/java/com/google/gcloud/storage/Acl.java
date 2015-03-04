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

package com.google.gcloud.storage;

import java.io.Serializable;

public abstract class Acl implements Serializable {

  private static final long serialVersionUID = 6435575339887912222L;

  private final Type type;
  private final Role role;

  public enum Role {
    OWNER,
    READER,
    WRITER
  }

  public enum Type {
    DOMAIN,
    GROUP,
    USER,
    PROJECT
  }

  public static class Builder {
    private Builder() {

    }

    Acl build()
  }

  public static class Domain extends Acl {

    private final String domain;

    Domain(Role role, String domain) {
      super(Type.USER, role);
      this.email = email;
    }

    public static User domain(Role role, String domain) {
      return new User(role, email);
    }
  }

  public static class User extends Acl {

    private static final long serialVersionUID = 3076518036392737008L;

    private final String email;

    User(Role role, String email) {
      super(Type.USER, role);
      this.email = email;
    }

    String email() {
      return email;
    }

    public static User email(Role role, String email) {
      return new User(role, email);
    }

    public static User allUsers(Role role) {
      return email(role, "allUsers");
    }

    public static User allAuthenticatedUsers(Role role) {
      return email(role, "allAuthenticatedUsers");
    }
  }


  Acl(Type type, Role role) {
    this.type = type;
    this.role = role;
  }


  public Type type() {
    return type;
  }

  public Role role() {
    return role;
  }

  public Builder toBuilder() {

  }

  public static Builder builder() {
    return new Builder();
  }
}
