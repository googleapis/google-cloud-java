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

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * A Page object wraps an API list method response.
 *
 * <p>Callers can iterate over the Page object to get all elements returned in the page. The Page
 * object also provides methods to retrieve additional pages using the page token, and to get the
 * API request and response objects.
 */
public interface Page<ResourceT> {
  /** Returns true if there are more pages that can be retrieved from the API. */
  boolean hasNextPage();

  /**
   * Returns the next page token from the response, or an empty string if there are no more pages.
   */
  String getNextPageToken();

  /**
   * Retrieves the next Page object using the next page token, or {@code null} if there are no more
   * pages. The hasNextPage() method can be used to check if a Page object is available.
   */
  Page<ResourceT> getNextPage();

  /**
   * Returns an iterable that traverses all the elements of the underlying data source. The data is
   * fetched lazily page by page, where each page may contain multiple elements. A new page is
   * fetched whenever the elements of any particular page are exhausted.
   */
  Iterable<ResourceT> iterateAll();

  /** Returns an iterable over the elements in this page. */
  Iterable<ResourceT> getValues();

  /**
   * Returns a stream that traverses all the elements of the underlying data source. The data is
   * fetched lazily page by page, where each page may contain multiple elements. A new page is
   * fetched whenever the elements of any particular page are exhausted.
   */
  default Stream<ResourceT> streamAll() {
    return StreamSupport.stream(iterateAll().spliterator(), false);
  }

  /** Returns a stream over the elements in this page. */
  default Stream<ResourceT> streamValues() {
    return StreamSupport.stream(getValues().spliterator(), false);
  }
}
