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
import com.google.gcloud.BasePage;
import com.google.gcloud.Page;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class BlobPageTest {

  private static final Iterable<BlobInfo> FIRST_PAGE_RESULTS = ImmutableList.of(
      BlobInfo.builder("b1", "n1").build(),
      BlobInfo.builder("b2", "n2").build());

  private static final Iterable<BlobInfo> SECOND_PAGE_RESULTS = ImmutableList.of(
      BlobInfo.builder("b1", "n1").build(),
      BlobInfo.builder("b2", "n2").build());

  private BasePage<BlobInfo> firstPage;
  private BasePage<BlobInfo> secondPage;
  private Storage storage;
  private BlobPage blobPage;

  @Before
  public void setUp() throws Exception {
    firstPage = createStrictMock(BasePage.class);
    secondPage = createStrictMock(BasePage.class);
    storage = createStrictMock(Storage.class);
    blobPage = new BlobPage(storage, firstPage);
  }

  @Test
  public void testPage() throws Exception {
    expect(firstPage.iterator()).andReturn(FIRST_PAGE_RESULTS.iterator());
    replay(firstPage);
    Iterator<BlobInfo> firstPageIterator = FIRST_PAGE_RESULTS.iterator();
    Iterator<Blob> pageIterator = blobPage.iterator();
    while (pageIterator.hasNext() && firstPageIterator.hasNext()) {
      assertEquals(firstPageIterator.next(), pageIterator.next().info());
    }
    assertFalse(pageIterator.hasNext());
    assertFalse(firstPageIterator.hasNext());
    verify(firstPage);
  }

  @Test
  public void testCursor() throws Exception {
    expect(firstPage.nextPageCursor()).andReturn("c");
    replay(firstPage);
    assertEquals("c", blobPage.nextPageCursor());
    verify(firstPage);
  }

  @Test
  public void testNextPage() throws Exception {
    expect(firstPage.nextPage()).andReturn(secondPage);
    expect(secondPage.iterator()).andReturn(SECOND_PAGE_RESULTS.iterator());
    replay(firstPage);
    replay(secondPage);
    Page<Blob> nextPageResult = blobPage.nextPage();
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
