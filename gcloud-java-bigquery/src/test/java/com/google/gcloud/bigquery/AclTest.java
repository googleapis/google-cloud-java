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

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;

import com.google.api.services.bigquery.model.Dataset;
import com.google.gcloud.bigquery.Acl.Domain;
import com.google.gcloud.bigquery.Acl.Entity;
import com.google.gcloud.bigquery.Acl.Entity.Type;
import com.google.gcloud.bigquery.Acl.Group;
import com.google.gcloud.bigquery.Acl.Role;
import com.google.gcloud.bigquery.Acl.User;
import com.google.gcloud.bigquery.Acl.View;

import org.junit.Test;

public class AclTest {

  @Test
  public void testDomainEntity() {
    Domain entity = new Domain("d1");
    assertEquals("d1", entity.domain());
    assertEquals(Type.DOMAIN, entity.type());
    Dataset.Access pb = entity.toPb();
    assertEquals(entity, Entity.fromPb(pb));
  }

  @Test
  public void testGroupEntity() {
    Group entity = new Group("g1");
    assertEquals("g1", entity.identifier());
    assertEquals(Type.GROUP, entity.type());
    Dataset.Access pb = entity.toPb();
    assertEquals(entity, Entity.fromPb(pb));
  }

  @Test
  public void testSpecialGroupEntity() {
    Group entity = Group.ofAllAuthenticatedUsers();
    assertEquals("allAuthenticatedUsers", entity.identifier());
    entity = Group.ofProjectWriters();
    assertEquals("projectWriters", entity.identifier());
    entity = Group.ofProjectReaders();
    assertEquals("projectReaders", entity.identifier());
    entity = Group.ofProjectOwners();
    assertEquals("projectOwners", entity.identifier());
  }

  @Test
  public void testUserEntity() {
    User entity = new User("u1");
    assertEquals("u1", entity.email());
    assertEquals(Type.USER, entity.type());
    Dataset.Access pb = entity.toPb();
    assertEquals(entity, Entity.fromPb(pb));
  }

  @Test
  public void testViewEntity() {
    TableId viewId = TableId.of("project", "dataset", "view");
    View entity = new View(viewId);
    assertEquals(viewId, entity.id());
    assertEquals(Type.VIEW, entity.type());
    Dataset.Access pb = entity.toPb();
    assertEquals(entity, Entity.fromPb(pb));
  }

  @Test
  public void testAcl() {
    Acl acl = new Acl(Group.ofAllAuthenticatedUsers(), Role.READER);
    assertEquals(Group.ofAllAuthenticatedUsers(), acl.entity());
    assertEquals(Role.READER, acl.role());
    Dataset.Access pb = acl.toPb();
    assertEquals(acl, Acl.fromPb(pb));
    View view = new View(TableId.of("project", "dataset", "view"));
    acl = new Acl(view);
    assertEquals(view, acl.entity());
    assertEquals(null, acl.role());
  }
}
