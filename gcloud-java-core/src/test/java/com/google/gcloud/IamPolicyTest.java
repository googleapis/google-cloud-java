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

package com.google.gcloud;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.IamPolicy.Acl;
import com.google.gcloud.IamPolicy.Identity;

import org.junit.Test;

public class IamPolicyTest {

  private static final Identity ALL_USERS = Identity.allUsers();
  private static final Identity ALL_AUTH_USERS = Identity.allAuthenticatedUsers();
  private static final Identity USER = Identity.user("abc@gmail.com");
  private static final Identity SERVICE_ACCOUNT =
      Identity.serviceAccount("service-account@gmail.com");
  private static final Identity GROUP = Identity.group("group@gmail.com");
  private static final Identity DOMAIN = Identity.domain("google.com");
  private static final Acl ACL1 = Acl.of("viewer", USER, SERVICE_ACCOUNT, ALL_USERS);
  private static final Acl ACL2 = Acl.of("editor", ALL_AUTH_USERS, GROUP, DOMAIN);
  private static final IamPolicy FULL_POLICY =
      IamPolicy.builder().addAcl(ACL1, ACL2).etag("etag").version(1).build();
  private static final IamPolicy SIMPLE_POLICY = IamPolicy.builder().addAcl(ACL1, ACL2).build();

  @Test
  public void testIdentityOf() {
    assertEquals(Identity.Type.ALL_USERS, ALL_USERS.type());
    assertEquals(null, ALL_USERS.id());
    assertEquals(Identity.Type.ALL_AUTHENTICATED_USERS, ALL_AUTH_USERS.type());
    assertEquals(null, ALL_AUTH_USERS.id());
    assertEquals(Identity.Type.USER, USER.type());
    assertEquals("abc@gmail.com", USER.id());
    assertEquals(Identity.Type.SERVICE_ACCOUNT, SERVICE_ACCOUNT.type());
    assertEquals("service-account@gmail.com", SERVICE_ACCOUNT.id());
    assertEquals(Identity.Type.GROUP, GROUP.type());
    assertEquals("group@gmail.com", GROUP.id());
    assertEquals(Identity.Type.DOMAIN, DOMAIN.type());
    assertEquals("google.com", DOMAIN.id());
  }

  @Test
  public void testAclBuilder() {
    Acl acl = Acl.builder("owner").addIdentity(USER, GROUP).build();
    assertEquals("owner", acl.role());
    assertEquals(ImmutableList.of(USER, GROUP), acl.identities());
    acl = acl.toBuilder().role("viewer").removeIdentity(GROUP).build();
    assertEquals("viewer", acl.role());
    assertEquals(ImmutableList.of(USER), acl.identities());
    acl = acl.toBuilder().identities(ImmutableList.of(SERVICE_ACCOUNT)).build();
    assertEquals("viewer", acl.role());
    assertEquals(ImmutableList.of(SERVICE_ACCOUNT), acl.identities());
  }

  @Test
  public void testAclOf() {
    assertEquals("viewer", ACL1.role());
    assertEquals(ImmutableList.of(USER, SERVICE_ACCOUNT, ALL_USERS), ACL1.identities());
    Acl aclFromList = Acl.of("editor", ImmutableList.of(USER, SERVICE_ACCOUNT));
    assertEquals("editor", aclFromList.role());
    assertEquals(ImmutableList.of(USER, SERVICE_ACCOUNT), aclFromList.identities());
  }

  @Test
  public void testAclToBuilder() {
    assertEquals(ACL1, ACL1.toBuilder().build());
  }

  @Test
  public void testIamPolicyBuilder() {
    assertEquals(ImmutableList.of(ACL1, ACL2), FULL_POLICY.acls());
    assertEquals("etag", FULL_POLICY.etag());
    assertEquals(1, FULL_POLICY.version());
    IamPolicy policy = FULL_POLICY.toBuilder().acls(ImmutableList.of(ACL2)).build();
    assertEquals(ImmutableList.of(ACL2), policy.acls());
    assertEquals("etag", policy.etag());
    assertEquals(1, policy.version());
    policy = SIMPLE_POLICY.toBuilder().removeAcl(ACL2).build();
    assertEquals(ImmutableList.of(ACL1), policy.acls());
    assertEquals(null, policy.etag());
    assertEquals(0, policy.version());
  }

  @Test
  public void testIamPolicyToBuilder() {
    assertEquals(FULL_POLICY, FULL_POLICY.toBuilder().build());
    assertEquals(SIMPLE_POLICY, SIMPLE_POLICY.toBuilder().build());
  }
}
