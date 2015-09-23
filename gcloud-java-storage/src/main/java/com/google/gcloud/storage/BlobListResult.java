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

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Iterator;
import java.util.Objects;

/**
 * Implementation of a paginated list of Google Cloud storage {@code Blob}.
 */
public class BlobListResult implements ListResult<Blob> {

  private final ListResult<BlobInfo> infoList;
  private final Storage storage;

  private class BlobListIterator implements Iterator<Blob> {

    private final Iterator<BlobInfo> blobInfoIterator;

    public BlobListIterator() {
      this.blobInfoIterator = infoList.iterator();
    }

    @Override
    public boolean hasNext() {
      return blobInfoIterator.hasNext();
    }

    @Override
    public Blob next() {
      return new Blob(storage, blobInfoIterator.next());
    }

    @Override
    public void remove() {
      blobInfoIterator.remove();
    }
  }

  public BlobListResult(Storage storage, ListResult<BlobInfo> infoList) {
    this.storage = checkNotNull(storage);
    this.infoList = checkNotNull(infoList);
  }

  @Override
  public String nextPageCursor() {
    return infoList.nextPageCursor();
  }

  @Override
  public ListResult<Blob> nextPage() {
    ListResult<BlobInfo> nextPageInfoList = infoList.nextPage();
    if (nextPageInfoList == null) {
      return null;
    }
    return new BlobListResult(storage, nextPageInfoList);
  }

  @Override
  public Iterator<Blob> iterator() {
    return new BlobListIterator();
  }

  @Override
  public int hashCode() {
    return Objects.hash(infoList);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof BlobListResult)) {
      return false;
    }
    BlobListResult other = (BlobListResult) obj;
    return Objects.equals(infoList, other.infoList);
  }
}
