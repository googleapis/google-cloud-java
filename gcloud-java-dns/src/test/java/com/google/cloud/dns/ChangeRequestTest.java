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

package com.google.cloud.dns;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChangeRequestTest {

  private static final String ZONE_NAME = "dns-zone-name";
  private static final ChangeRequestInfo CHANGE_REQUEST_INFO = ChangeRequest.builder()
      .add(RecordSet.builder("name", RecordSet.Type.A).build())
      .delete(RecordSet.builder("othername", RecordSet.Type.AAAA).build())
      .build();
  private static final DnsOptions OPTIONS = createStrictMock(DnsOptions.class);

  private Dns dns;
  private ChangeRequest changeRequest;
  private ChangeRequest changeRequestPending;
  private ChangeRequest changeRequestPartial;

  @Before
  public void setUp() throws Exception {
    dns = createStrictMock(Dns.class);
    expect(dns.options()).andReturn(OPTIONS).times(3);
    replay(dns);
    changeRequest = new ChangeRequest(dns, ZONE_NAME, new ChangeRequestInfo.BuilderImpl(
        CHANGE_REQUEST_INFO.toBuilder()
            .startTimeMillis(132L)
            .generatedId("12")
            .status(ChangeRequest.Status.DONE)
            .build()));
    changeRequestPending = new ChangeRequest(dns, ZONE_NAME, new ChangeRequestInfo.BuilderImpl(
        CHANGE_REQUEST_INFO.toBuilder()
            .startTimeMillis(132L)
            .generatedId("12")
            .status(ChangeRequest.Status.PENDING)
            .build()));
    changeRequestPartial = new ChangeRequest(dns, ZONE_NAME,
        new ChangeRequest.BuilderImpl(CHANGE_REQUEST_INFO));
    reset(dns);
  }

  @After
  public void tearDown() throws Exception {
    verify(dns);
  }

  @Test
  public void testConstructor() {
    expect(dns.options()).andReturn(OPTIONS);
    replay(dns);
    assertEquals(new ChangeRequest(dns, ZONE_NAME,
        new ChangeRequestInfo.BuilderImpl(CHANGE_REQUEST_INFO)), changeRequestPartial);
    assertNotNull(changeRequest.dns());
    assertEquals(ZONE_NAME, changeRequest.zone());
    assertSame(dns, changeRequestPartial.dns());
    assertEquals(ZONE_NAME, changeRequestPartial.zone());
  }

  @Test
  public void testFromPb() {
    expect(dns.options()).andReturn(OPTIONS).times(2);
    replay(dns);
    assertEquals(changeRequest, ChangeRequest.fromPb(dns, ZONE_NAME, changeRequest.toPb()));
    assertEquals(changeRequestPartial,
        ChangeRequest.fromPb(dns, ZONE_NAME, changeRequestPartial.toPb()));
  }

  @Test
  public void testEqualsAndToBuilder() {
    expect(dns.options()).andReturn(OPTIONS).times(2);
    replay(dns);
    ChangeRequest compare = changeRequest.toBuilder().build();
    assertEquals(changeRequest, compare);
    assertEquals(changeRequest.hashCode(), compare.hashCode());
    compare = changeRequestPartial.toBuilder().build();
    assertEquals(changeRequestPartial, compare);
    assertEquals(changeRequestPartial.hashCode(), compare.hashCode());
  }

  @Test
  public void testBuilder() {
    // one for each build() call because it invokes a constructor
    expect(dns.options()).andReturn(OPTIONS).times(9);
    replay(dns);
    String id = changeRequest.generatedId() + "aaa";
    assertEquals(id, changeRequest.toBuilder().generatedId(id).build().generatedId());
    ChangeRequest modified =
        changeRequest.toBuilder().status(ChangeRequest.Status.PENDING).build();
    assertEquals(ChangeRequest.Status.PENDING, modified.status());
    modified = changeRequest.toBuilder().clearDeletions().build();
    assertTrue(modified.deletions().isEmpty());
    modified = changeRequest.toBuilder().clearAdditions().build();
    assertTrue(modified.additions().isEmpty());
    modified = changeRequest.toBuilder().additions(ImmutableList.<RecordSet>of()).build();
    assertTrue(modified.additions().isEmpty());
    modified = changeRequest.toBuilder().deletions(ImmutableList.<RecordSet>of()).build();
    assertTrue(modified.deletions().isEmpty());
    RecordSet cname = RecordSet.builder("last", RecordSet.Type.CNAME).build();
    modified = changeRequest.toBuilder().add(cname).build();
    assertTrue(modified.additions().contains(cname));
    modified = changeRequest.toBuilder().delete(cname).build();
    assertTrue(modified.deletions().contains(cname));
    modified = changeRequest.toBuilder().startTimeMillis(0L).build();
    assertEquals(Long.valueOf(0), modified.startTimeMillis());
  }

  @Test
  public void testApplyTo() {
    expect(dns.applyChangeRequest(ZONE_NAME, changeRequest)).andReturn(changeRequest);
    expect(dns.applyChangeRequest(ZONE_NAME, changeRequest,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.START_TIME)))
        .andReturn(changeRequest);
    replay(dns);
    assertSame(changeRequest, changeRequest.applyTo(ZONE_NAME));
    assertSame(changeRequest, changeRequest.applyTo(ZONE_NAME,
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.START_TIME)));
  }

  @Test
  public void testReload() {
    expect(dns.getChangeRequest(ZONE_NAME, changeRequest.generatedId())).andReturn(changeRequest);
    expect(dns.getChangeRequest(ZONE_NAME, changeRequest.generatedId(),
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.START_TIME)))
        .andReturn(changeRequest);
    replay(dns);
    assertSame(changeRequest, changeRequest.reload());
    assertSame(changeRequest, changeRequest.reload(
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.START_TIME)));
  }

  @Test
  public void testIsDone() {
    replay(dns);
    assertTrue(changeRequest.isDone());
    verify(dns);
    reset(dns);
    expect(dns.getChangeRequest(ZONE_NAME, changeRequest.generatedId(),
        Dns.ChangeRequestOption.fields(Dns.ChangeRequestField.STATUS)))
        .andReturn(changeRequest);
    replay(dns);
    assertTrue(changeRequestPending.isDone());
    verify(dns);
  }
}
