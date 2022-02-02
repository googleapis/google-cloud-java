/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;

import com.google.api.services.bigquery.model.Dataset;
import com.google.cloud.bigquery.Acl.DatasetAclEntity;
import com.google.cloud.bigquery.Acl.Domain;
import com.google.cloud.bigquery.Acl.Entity;
import com.google.cloud.bigquery.Acl.Entity.Type;
import com.google.cloud.bigquery.Acl.Group;
import com.google.cloud.bigquery.Acl.IamMember;
import com.google.cloud.bigquery.Acl.Role;
import com.google.cloud.bigquery.Acl.User;
import com.google.cloud.bigquery.Acl.View;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class AclTest {

  @Test
  public void testDatasetEntity() {
    DatasetId datasetId = DatasetId.of("dataset");
    List<String> targetTypes = ImmutableList.of("VIEWS");
    DatasetAclEntity entity = new DatasetAclEntity(datasetId, targetTypes);
    assertEquals(datasetId, entity.getId());
    assertEquals(targetTypes, entity.getTargetTypes());
    Dataset.Access pb = entity.toPb();
    assertEquals(entity, Entity.fromPb(pb));
  }

  @Test
  public void testDomainEntity() {
    Domain entity = new Domain("d1");
    assertEquals("d1", entity.getDomain());
    assertEquals(Type.DOMAIN, entity.getType());
    Dataset.Access pb = entity.toPb();
    assertEquals(entity, Entity.fromPb(pb));
  }

  @Test
  public void testGroupEntity() {
    Group entity = new Group("g1");
    assertEquals("g1", entity.getIdentifier());
    assertEquals(Type.GROUP, entity.getType());
    Dataset.Access pb = entity.toPb();
    assertEquals(entity, Entity.fromPb(pb));
  }

  @Test
  public void testSpecialGroupEntity() {
    Group entity = Group.ofAllAuthenticatedUsers();
    assertEquals("allAuthenticatedUsers", entity.getIdentifier());
    Dataset.Access pb = entity.toPb();
    assertEquals(entity, Entity.fromPb(pb));
    entity = Group.ofProjectWriters();
    assertEquals("projectWriters", entity.getIdentifier());
    pb = entity.toPb();
    assertEquals(entity, Entity.fromPb(pb));
    entity = Group.ofProjectReaders();
    assertEquals("projectReaders", entity.getIdentifier());
    pb = entity.toPb();
    assertEquals(entity, Entity.fromPb(pb));
    entity = Group.ofProjectOwners();
    assertEquals("projectOwners", entity.getIdentifier());
    pb = entity.toPb();
    assertEquals(entity, Entity.fromPb(pb));
  }

  @Test
  public void testUserEntity() {
    User entity = new User("u1");
    assertEquals("u1", entity.getEmail());
    assertEquals(Type.USER, entity.getType());
    Dataset.Access pb = entity.toPb();
    assertEquals(entity, Entity.fromPb(pb));
  }

  @Test
  public void testViewEntity() {
    TableId viewId = TableId.of("project", "dataset", "view");
    View entity = new View(viewId);
    assertEquals(viewId, entity.getId());
    assertEquals(Type.VIEW, entity.getType());
    Dataset.Access pb = entity.toPb();
    assertEquals(entity, Entity.fromPb(pb));
  }

  @Test
  public void testRoutineEntity() {
    RoutineId routineId = RoutineId.of("project", "dataset", "routine");
    Acl.Routine entity = new Acl.Routine(routineId);
    assertEquals(routineId, entity.getId());
    assertEquals(Type.ROUTINE, entity.getType());
    Dataset.Access pb = entity.toPb();
    assertEquals(entity, Entity.fromPb(pb));
  }

  @Test
  public void testIamMemberEntity() {
    IamMember entity = new IamMember("member1");
    assertEquals("member1", entity.getIamMember());
    Dataset.Access pb = entity.toPb();
    assertEquals(entity, Entity.fromPb(pb));
  }

  @Test
  public void testOf() {
    Acl acl = Acl.of(Group.ofAllAuthenticatedUsers(), Role.READER);
    assertEquals(Group.ofAllAuthenticatedUsers(), acl.getEntity());
    assertEquals(Role.READER, acl.getRole());
    Dataset.Access pb = acl.toPb();
    assertEquals(acl, Acl.fromPb(pb));
    View view = new View(TableId.of("project", "dataset", "view"));
    acl = Acl.of(view);
    assertEquals(view, acl.getEntity());
    assertEquals(null, acl.getRole());
    Acl.Routine routine = new Acl.Routine(RoutineId.of("project", "dataset", "routine"));
    acl = Acl.of(routine);
    assertEquals(routine, acl.getEntity());
    assertEquals(null, acl.getRole());
  }
}
