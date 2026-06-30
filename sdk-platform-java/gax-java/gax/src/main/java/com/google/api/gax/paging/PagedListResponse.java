/*
 * Copyright 2016 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.paging;

/**
 * Response for paged results from a list API method
 *
 * <p>This class is used to access the results of a paged list API method. The management of page
 * tokens can be handled automatically, or by the caller. Results can be accessed on a per-element
 * or per-page basis.
 */
public interface PagedListResponse<ResourceT> {
  /**
   * Returns an iterable that traverses all of the elements of the underlying data source. The data
   * is fetched lazily page by page, where each page may contain multiple elements. A new page is
   * fetched whenever the elements of any particular page are exhausted. This method is not
   * thread-safe.
   */
  Iterable<ResourceT> iterateAll();

  /** Returns the current page of results. Note: This method is not thread-safe. */
  Page<ResourceT> getPage();

  /**
   * Return an iterable over all Page objects. Page objects are retrieved lazily via API calls until
   * all elements have been retrieved.
   */
  Iterable<? extends Page<ResourceT>> iteratePages();

  /**
   * Returns the token for the next page or an empty string if no more results. Note: This method is
   * not thread-safe.
   */
  String getNextPageToken();

  /**
   * Returns a collection of elements with a fixed size set by the collectionSize parameter. The
   * collection will only contain fewer than collectionSize elements if there are no more pages to
   * be retrieved from the server.
   *
   * <p>NOTE: it is an error to call this method if the optional parameter 'page_size' has not been
   * set in the original API call. It is also an error if the collectionSize parameter is less than
   * the page_size.
   */
  FixedSizeCollection<ResourceT> expandToFixedSizeCollection(int collectionSize);

  /**
   * Returns an iterable over fixed size collections of results. The collections are retrieved
   * lazily from the underlying API.
   *
   * <p>Each collection will have collectionSize elements, with the exception of the final
   * collection which may contain fewer elements.
   *
   * <p>NOTE: it is an error to call this method if the optional parameter 'page_size' has not been
   * set in the original API call. It is also an error if the collectionSize parameter is less than
   * the page_size.
   */
  Iterable<? extends FixedSizeCollection<ResourceT>> iterateFixedSizeCollections(
      int collectionSize);
}
