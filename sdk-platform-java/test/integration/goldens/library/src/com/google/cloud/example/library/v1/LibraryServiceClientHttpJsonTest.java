/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.example.library.v1;

import static com.google.cloud.example.library.v1.LibraryServiceClient.ListBooksPagedResponse;
import static com.google.cloud.example.library.v1.LibraryServiceClient.ListShelvesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.example.library.v1.stub.HttpJsonLibraryServiceStub;
import com.google.common.collect.Lists;
import com.google.example.library.v1.Book;
import com.google.example.library.v1.BookName;
import com.google.example.library.v1.ListBooksResponse;
import com.google.example.library.v1.ListShelvesRequest;
import com.google.example.library.v1.ListShelvesResponse;
import com.google.example.library.v1.Shelf;
import com.google.example.library.v1.ShelfName;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class LibraryServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static LibraryServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonLibraryServiceStub.getMethodDescriptors(),
            LibraryServiceSettings.getDefaultEndpoint());
    LibraryServiceSettings settings =
        LibraryServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                LibraryServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LibraryServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void createShelfTest() throws Exception {
    Shelf expectedResponse =
        Shelf.newBuilder()
            .setName(ShelfName.of("[SHELF_ID]").toString())
            .setTheme("theme110327241")
            .build();
    mockService.addResponse(expectedResponse);

    Shelf shelf = Shelf.newBuilder().build();

    Shelf actualResponse = client.createShelf(shelf);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createShelfExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Shelf shelf = Shelf.newBuilder().build();
      client.createShelf(shelf);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getShelfTest() throws Exception {
    Shelf expectedResponse =
        Shelf.newBuilder()
            .setName(ShelfName.of("[SHELF_ID]").toString())
            .setTheme("theme110327241")
            .build();
    mockService.addResponse(expectedResponse);

    ShelfName name = ShelfName.of("[SHELF_ID]");

    Shelf actualResponse = client.getShelf(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getShelfExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ShelfName name = ShelfName.of("[SHELF_ID]");
      client.getShelf(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getShelfTest2() throws Exception {
    Shelf expectedResponse =
        Shelf.newBuilder()
            .setName(ShelfName.of("[SHELF_ID]").toString())
            .setTheme("theme110327241")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "shelves/shelve-6552";

    Shelf actualResponse = client.getShelf(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getShelfExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "shelves/shelve-6552";
      client.getShelf(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listShelvesTest() throws Exception {
    Shelf responsesElement = Shelf.newBuilder().build();
    ListShelvesResponse expectedResponse =
        ListShelvesResponse.newBuilder()
            .setNextPageToken("")
            .addAllShelves(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListShelvesRequest request =
        ListShelvesRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListShelvesPagedResponse pagedListResponse = client.listShelves(request);

    List<Shelf> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getShelvesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listShelvesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListShelvesRequest request =
          ListShelvesRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listShelves(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteShelfTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ShelfName name = ShelfName.of("[SHELF_ID]");

    client.deleteShelf(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteShelfExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ShelfName name = ShelfName.of("[SHELF_ID]");
      client.deleteShelf(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteShelfTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "shelves/shelve-6552";

    client.deleteShelf(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteShelfExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "shelves/shelve-6552";
      client.deleteShelf(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void mergeShelvesTest() throws Exception {
    Shelf expectedResponse =
        Shelf.newBuilder()
            .setName(ShelfName.of("[SHELF_ID]").toString())
            .setTheme("theme110327241")
            .build();
    mockService.addResponse(expectedResponse);

    ShelfName name = ShelfName.of("[SHELF_ID]");
    ShelfName otherShelf = ShelfName.of("[SHELF_ID]");

    Shelf actualResponse = client.mergeShelves(name, otherShelf);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void mergeShelvesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ShelfName name = ShelfName.of("[SHELF_ID]");
      ShelfName otherShelf = ShelfName.of("[SHELF_ID]");
      client.mergeShelves(name, otherShelf);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void mergeShelvesTest2() throws Exception {
    Shelf expectedResponse =
        Shelf.newBuilder()
            .setName(ShelfName.of("[SHELF_ID]").toString())
            .setTheme("theme110327241")
            .build();
    mockService.addResponse(expectedResponse);

    ShelfName name = ShelfName.of("[SHELF_ID]");
    String otherShelf = "otherShelf-193668870";

    Shelf actualResponse = client.mergeShelves(name, otherShelf);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void mergeShelvesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ShelfName name = ShelfName.of("[SHELF_ID]");
      String otherShelf = "otherShelf-193668870";
      client.mergeShelves(name, otherShelf);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void mergeShelvesTest3() throws Exception {
    Shelf expectedResponse =
        Shelf.newBuilder()
            .setName(ShelfName.of("[SHELF_ID]").toString())
            .setTheme("theme110327241")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "shelves/shelve-6552";
    ShelfName otherShelf = ShelfName.of("[SHELF_ID]");

    Shelf actualResponse = client.mergeShelves(name, otherShelf);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void mergeShelvesExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "shelves/shelve-6552";
      ShelfName otherShelf = ShelfName.of("[SHELF_ID]");
      client.mergeShelves(name, otherShelf);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void mergeShelvesTest4() throws Exception {
    Shelf expectedResponse =
        Shelf.newBuilder()
            .setName(ShelfName.of("[SHELF_ID]").toString())
            .setTheme("theme110327241")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "shelves/shelve-6552";
    String otherShelf = "otherShelf-193668870";

    Shelf actualResponse = client.mergeShelves(name, otherShelf);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void mergeShelvesExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "shelves/shelve-6552";
      String otherShelf = "otherShelf-193668870";
      client.mergeShelves(name, otherShelf);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBookTest() throws Exception {
    Book expectedResponse =
        Book.newBuilder()
            .setName(BookName.of("[SHELF]", "[BOOK]").toString())
            .setAuthor("author-1406328437")
            .setTitle("title110371416")
            .setRead(true)
            .build();
    mockService.addResponse(expectedResponse);

    ShelfName parent = ShelfName.of("[SHELF_ID]");
    Book book = Book.newBuilder().build();

    Book actualResponse = client.createBook(parent, book);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBookExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ShelfName parent = ShelfName.of("[SHELF_ID]");
      Book book = Book.newBuilder().build();
      client.createBook(parent, book);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBookTest2() throws Exception {
    Book expectedResponse =
        Book.newBuilder()
            .setName(BookName.of("[SHELF]", "[BOOK]").toString())
            .setAuthor("author-1406328437")
            .setTitle("title110371416")
            .setRead(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "shelves/shelve-4649";
    Book book = Book.newBuilder().build();

    Book actualResponse = client.createBook(parent, book);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createBookExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "shelves/shelve-4649";
      Book book = Book.newBuilder().build();
      client.createBook(parent, book);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBookTest() throws Exception {
    Book expectedResponse =
        Book.newBuilder()
            .setName(BookName.of("[SHELF]", "[BOOK]").toString())
            .setAuthor("author-1406328437")
            .setTitle("title110371416")
            .setRead(true)
            .build();
    mockService.addResponse(expectedResponse);

    BookName name = BookName.of("[SHELF]", "[BOOK]");

    Book actualResponse = client.getBook(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBookExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BookName name = BookName.of("[SHELF]", "[BOOK]");
      client.getBook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBookTest2() throws Exception {
    Book expectedResponse =
        Book.newBuilder()
            .setName(BookName.of("[SHELF]", "[BOOK]").toString())
            .setAuthor("author-1406328437")
            .setTitle("title110371416")
            .setRead(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "shelves/shelve-382/books/book-382";

    Book actualResponse = client.getBook(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getBookExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "shelves/shelve-382/books/book-382";
      client.getBook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBooksTest() throws Exception {
    Book responsesElement = Book.newBuilder().build();
    ListBooksResponse expectedResponse =
        ListBooksResponse.newBuilder()
            .setNextPageToken("")
            .addAllBooks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ShelfName parent = ShelfName.of("[SHELF_ID]");

    ListBooksPagedResponse pagedListResponse = client.listBooks(parent);

    List<Book> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBooksList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBooksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ShelfName parent = ShelfName.of("[SHELF_ID]");
      client.listBooks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBooksTest2() throws Exception {
    Book responsesElement = Book.newBuilder().build();
    ListBooksResponse expectedResponse =
        ListBooksResponse.newBuilder()
            .setNextPageToken("")
            .addAllBooks(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "shelves/shelve-4649";

    ListBooksPagedResponse pagedListResponse = client.listBooks(parent);

    List<Book> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBooksList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBooksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "shelves/shelve-4649";
      client.listBooks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBookTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    BookName name = BookName.of("[SHELF]", "[BOOK]");

    client.deleteBook(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBookExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BookName name = BookName.of("[SHELF]", "[BOOK]");
      client.deleteBook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBookTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "shelves/shelve-382/books/book-382";

    client.deleteBook(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteBookExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "shelves/shelve-382/books/book-382";
      client.deleteBook(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBookTest() throws Exception {
    Book expectedResponse =
        Book.newBuilder()
            .setName(BookName.of("[SHELF]", "[BOOK]").toString())
            .setAuthor("author-1406328437")
            .setTitle("title110371416")
            .setRead(true)
            .build();
    mockService.addResponse(expectedResponse);

    Book book =
        Book.newBuilder()
            .setName(BookName.of("[SHELF]", "[BOOK]").toString())
            .setAuthor("author-1406328437")
            .setTitle("title110371416")
            .setRead(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Book actualResponse = client.updateBook(book, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateBookExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Book book =
          Book.newBuilder()
              .setName(BookName.of("[SHELF]", "[BOOK]").toString())
              .setAuthor("author-1406328437")
              .setTitle("title110371416")
              .setRead(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBook(book, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void moveBookTest() throws Exception {
    Book expectedResponse =
        Book.newBuilder()
            .setName(BookName.of("[SHELF]", "[BOOK]").toString())
            .setAuthor("author-1406328437")
            .setTitle("title110371416")
            .setRead(true)
            .build();
    mockService.addResponse(expectedResponse);

    BookName name = BookName.of("[SHELF]", "[BOOK]");
    ShelfName otherShelfName = ShelfName.of("[SHELF_ID]");

    Book actualResponse = client.moveBook(name, otherShelfName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void moveBookExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BookName name = BookName.of("[SHELF]", "[BOOK]");
      ShelfName otherShelfName = ShelfName.of("[SHELF_ID]");
      client.moveBook(name, otherShelfName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void moveBookTest2() throws Exception {
    Book expectedResponse =
        Book.newBuilder()
            .setName(BookName.of("[SHELF]", "[BOOK]").toString())
            .setAuthor("author-1406328437")
            .setTitle("title110371416")
            .setRead(true)
            .build();
    mockService.addResponse(expectedResponse);

    BookName name = BookName.of("[SHELF]", "[BOOK]");
    String otherShelfName = "otherShelfName-1942963547";

    Book actualResponse = client.moveBook(name, otherShelfName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void moveBookExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BookName name = BookName.of("[SHELF]", "[BOOK]");
      String otherShelfName = "otherShelfName-1942963547";
      client.moveBook(name, otherShelfName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void moveBookTest3() throws Exception {
    Book expectedResponse =
        Book.newBuilder()
            .setName(BookName.of("[SHELF]", "[BOOK]").toString())
            .setAuthor("author-1406328437")
            .setTitle("title110371416")
            .setRead(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "shelves/shelve-382/books/book-382";
    ShelfName otherShelfName = ShelfName.of("[SHELF_ID]");

    Book actualResponse = client.moveBook(name, otherShelfName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void moveBookExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "shelves/shelve-382/books/book-382";
      ShelfName otherShelfName = ShelfName.of("[SHELF_ID]");
      client.moveBook(name, otherShelfName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void moveBookTest4() throws Exception {
    Book expectedResponse =
        Book.newBuilder()
            .setName(BookName.of("[SHELF]", "[BOOK]").toString())
            .setAuthor("author-1406328437")
            .setTitle("title110371416")
            .setRead(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "shelves/shelve-382/books/book-382";
    String otherShelfName = "otherShelfName-1942963547";

    Book actualResponse = client.moveBook(name, otherShelfName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void moveBookExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "shelves/shelve-382/books/book-382";
      String otherShelfName = "otherShelfName-1942963547";
      client.moveBook(name, otherShelfName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
