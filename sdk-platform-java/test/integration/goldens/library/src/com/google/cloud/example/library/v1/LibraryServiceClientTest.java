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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.example.library.v1.Book;
import com.google.example.library.v1.BookName;
import com.google.example.library.v1.CreateBookRequest;
import com.google.example.library.v1.CreateShelfRequest;
import com.google.example.library.v1.DeleteBookRequest;
import com.google.example.library.v1.DeleteShelfRequest;
import com.google.example.library.v1.GetBookRequest;
import com.google.example.library.v1.GetShelfRequest;
import com.google.example.library.v1.ListBooksRequest;
import com.google.example.library.v1.ListBooksResponse;
import com.google.example.library.v1.ListShelvesRequest;
import com.google.example.library.v1.ListShelvesResponse;
import com.google.example.library.v1.MergeShelvesRequest;
import com.google.example.library.v1.MoveBookRequest;
import com.google.example.library.v1.Shelf;
import com.google.example.library.v1.ShelfName;
import com.google.example.library.v1.UpdateBookRequest;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class LibraryServiceClientTest {
  private static MockLibraryService mockLibraryService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private LibraryServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockLibraryService = new MockLibraryService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockLibraryService));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    LibraryServiceSettings settings =
        LibraryServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = LibraryServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createShelfTest() throws Exception {
    Shelf expectedResponse =
        Shelf.newBuilder()
            .setName(ShelfName.of("[SHELF_ID]").toString())
            .setTheme("theme110327241")
            .build();
    mockLibraryService.addResponse(expectedResponse);

    Shelf shelf = Shelf.newBuilder().build();

    Shelf actualResponse = client.createShelf(shelf);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateShelfRequest actualRequest = ((CreateShelfRequest) actualRequests.get(0));

    Assert.assertEquals(shelf, actualRequest.getShelf());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createShelfExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

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
    mockLibraryService.addResponse(expectedResponse);

    ShelfName name = ShelfName.of("[SHELF_ID]");

    Shelf actualResponse = client.getShelf(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetShelfRequest actualRequest = ((GetShelfRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getShelfExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

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
    mockLibraryService.addResponse(expectedResponse);

    String name = "name3373707";

    Shelf actualResponse = client.getShelf(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetShelfRequest actualRequest = ((GetShelfRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getShelfExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

    try {
      String name = "name3373707";
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
    mockLibraryService.addResponse(expectedResponse);

    ListShelvesRequest request =
        ListShelvesRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListShelvesPagedResponse pagedListResponse = client.listShelves(request);

    List<Shelf> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getShelvesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListShelvesRequest actualRequest = ((ListShelvesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listShelvesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

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
    mockLibraryService.addResponse(expectedResponse);

    ShelfName name = ShelfName.of("[SHELF_ID]");

    client.deleteShelf(name);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteShelfRequest actualRequest = ((DeleteShelfRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteShelfExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

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
    mockLibraryService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteShelf(name);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteShelfRequest actualRequest = ((DeleteShelfRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteShelfExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

    try {
      String name = "name3373707";
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
    mockLibraryService.addResponse(expectedResponse);

    ShelfName name = ShelfName.of("[SHELF_ID]");
    ShelfName otherShelf = ShelfName.of("[SHELF_ID]");

    Shelf actualResponse = client.mergeShelves(name, otherShelf);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MergeShelvesRequest actualRequest = ((MergeShelvesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(otherShelf.toString(), actualRequest.getOtherShelf());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void mergeShelvesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

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
    mockLibraryService.addResponse(expectedResponse);

    ShelfName name = ShelfName.of("[SHELF_ID]");
    String otherShelf = "otherShelf-193668870";

    Shelf actualResponse = client.mergeShelves(name, otherShelf);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MergeShelvesRequest actualRequest = ((MergeShelvesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(otherShelf, actualRequest.getOtherShelf());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void mergeShelvesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

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
    mockLibraryService.addResponse(expectedResponse);

    String name = "name3373707";
    ShelfName otherShelf = ShelfName.of("[SHELF_ID]");

    Shelf actualResponse = client.mergeShelves(name, otherShelf);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MergeShelvesRequest actualRequest = ((MergeShelvesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(otherShelf.toString(), actualRequest.getOtherShelf());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void mergeShelvesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

    try {
      String name = "name3373707";
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
    mockLibraryService.addResponse(expectedResponse);

    String name = "name3373707";
    String otherShelf = "otherShelf-193668870";

    Shelf actualResponse = client.mergeShelves(name, otherShelf);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MergeShelvesRequest actualRequest = ((MergeShelvesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(otherShelf, actualRequest.getOtherShelf());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void mergeShelvesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

    try {
      String name = "name3373707";
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
    mockLibraryService.addResponse(expectedResponse);

    ShelfName parent = ShelfName.of("[SHELF_ID]");
    Book book = Book.newBuilder().build();

    Book actualResponse = client.createBook(parent, book);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBookRequest actualRequest = ((CreateBookRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(book, actualRequest.getBook());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

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
    mockLibraryService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Book book = Book.newBuilder().build();

    Book actualResponse = client.createBook(parent, book);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBookRequest actualRequest = ((CreateBookRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(book, actualRequest.getBook());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockLibraryService.addResponse(expectedResponse);

    BookName name = BookName.of("[SHELF]", "[BOOK]");

    Book actualResponse = client.getBook(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBookRequest actualRequest = ((GetBookRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

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
    mockLibraryService.addResponse(expectedResponse);

    String name = "name3373707";

    Book actualResponse = client.getBook(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBookRequest actualRequest = ((GetBookRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

    try {
      String name = "name3373707";
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
    mockLibraryService.addResponse(expectedResponse);

    ShelfName parent = ShelfName.of("[SHELF_ID]");

    ListBooksPagedResponse pagedListResponse = client.listBooks(parent);

    List<Book> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBooksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBooksRequest actualRequest = ((ListBooksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBooksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

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
    mockLibraryService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBooksPagedResponse pagedListResponse = client.listBooks(parent);

    List<Book> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBooksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBooksRequest actualRequest = ((ListBooksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBooksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBooks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBookTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockLibraryService.addResponse(expectedResponse);

    BookName name = BookName.of("[SHELF]", "[BOOK]");

    client.deleteBook(name);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBookRequest actualRequest = ((DeleteBookRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

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
    mockLibraryService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteBook(name);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBookRequest actualRequest = ((DeleteBookRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

    try {
      String name = "name3373707";
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
    mockLibraryService.addResponse(expectedResponse);

    Book book = Book.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Book actualResponse = client.updateBook(book, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBookRequest actualRequest = ((UpdateBookRequest) actualRequests.get(0));

    Assert.assertEquals(book, actualRequest.getBook());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

    try {
      Book book = Book.newBuilder().build();
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
    mockLibraryService.addResponse(expectedResponse);

    BookName name = BookName.of("[SHELF]", "[BOOK]");
    ShelfName otherShelfName = ShelfName.of("[SHELF_ID]");

    Book actualResponse = client.moveBook(name, otherShelfName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MoveBookRequest actualRequest = ((MoveBookRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(otherShelfName.toString(), actualRequest.getOtherShelfName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void moveBookExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

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
    mockLibraryService.addResponse(expectedResponse);

    BookName name = BookName.of("[SHELF]", "[BOOK]");
    String otherShelfName = "otherShelfName-1942963547";

    Book actualResponse = client.moveBook(name, otherShelfName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MoveBookRequest actualRequest = ((MoveBookRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(otherShelfName, actualRequest.getOtherShelfName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void moveBookExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

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
    mockLibraryService.addResponse(expectedResponse);

    String name = "name3373707";
    ShelfName otherShelfName = ShelfName.of("[SHELF_ID]");

    Book actualResponse = client.moveBook(name, otherShelfName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MoveBookRequest actualRequest = ((MoveBookRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(otherShelfName.toString(), actualRequest.getOtherShelfName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void moveBookExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

    try {
      String name = "name3373707";
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
    mockLibraryService.addResponse(expectedResponse);

    String name = "name3373707";
    String otherShelfName = "otherShelfName-1942963547";

    Book actualResponse = client.moveBook(name, otherShelfName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLibraryService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MoveBookRequest actualRequest = ((MoveBookRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(otherShelfName, actualRequest.getOtherShelfName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void moveBookExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLibraryService.addException(exception);

    try {
      String name = "name3373707";
      String otherShelfName = "otherShelfName-1942963547";
      client.moveBook(name, otherShelfName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
