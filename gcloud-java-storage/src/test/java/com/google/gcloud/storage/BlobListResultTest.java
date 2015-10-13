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

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.google.common.collect.ImmutableList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class BlobListResultTest {

  private static final Iterable<BlobInfo> FIRST_PAGE_RESULTS = ImmutableList.of(
      BlobInfo.builder("b1", "n1").build(),
      BlobInfo.builder("b2", "n2").build());

  private static final Iterable<BlobInfo> SECOND_PAGE_RESULTS = ImmutableList.of(
      BlobInfo.builder("b1", "n1").build(),
      BlobInfo.builder("b2", "n2").build());

  private BaseListResult<BlobInfo> firstPage;
  private BaseListResult<BlobInfo> secondPage;
  private Storage storage;
  private BlobListResult blobListResult;

  @Before
  public void setUp() throws Exception {
    firstPage = createStrictMock(BaseListResult.class);
    secondPage = createStrictMock(BaseListResult.class);
    storage = createStrictMock(Storage.class);
    blobListResult = new BlobListResult(storage, firstPage);
  }

  @Test
  public void testListResult() throws Exception {
    expect(firstPage.iterator()).andReturn(FIRST_PAGE_RESULTS.iterator());
    replay(firstPage);
    Iterator<BlobInfo> firstPageIterator = FIRST_PAGE_RESULTS.iterator();
    Iterator<Blob> blobListIterator = blobListResult.iterator();
    while (blobListIterator.hasNext() && firstPageIterator.hasNext()) {
      assertEquals(firstPageIterator.next(), blobListIterator.next().info());
    }
    assertFalse(blobListIterator.hasNext());
    assertFalse(firstPageIterator.hasNext());
    verify(firstPage);
  }

  @Test
  public void testCursor() throws Exception {
    expect(firstPage.nextPageCursor()).andReturn("c");
    replay(firstPage);
    assertEquals("c", blobListResult.nextPageCursor());
    verify(firstPage);
  }

  @Test
  public void testNextPage() throws Exception {
    expect(firstPage.nextPage()).andReturn(secondPage);
    expect(secondPage.iterator()).andReturn(SECOND_PAGE_RESULTS.iterator());
    replay(firstPage);
    replay(secondPage);
    ListResult<Blob> nextPageResult = blobListResult.nextPage();
    Iterator<BlobInfo> secondPageIterator = SECOND_PAGE_RESULTS.iterator();
    Iterator<Blob> blobListIterator = nextPageResult.iterator();
    while (blobListIterator.hasNext() && secondPageIterator.hasNext()) {
      assertEquals(secondPageIterator.next(), blobListIterator.next().info());
    }
    assertFalse(blobListIterator.hasNext());
    assertFalse(secondPageIterator.hasNext());
    verify(firstPage);
    verify(secondPage);
  }
}
