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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.example.library.v1.stub.LibraryServiceStub;
import com.google.cloud.example.library.v1.stub.LibraryServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This API represents a simple digital library. It lets you manage Shelf
 * resources and Book resources in the library. It defines the following resource model:
 *
 * <p>- The API has a collection of [Shelf][google.example.library.v1.Shelf] resources, named
 * `shelves/&#42;`
 *
 * <p>- Each Shelf has a collection of [Book][google.example.library.v1.Book] resources, named
 * `shelves/&#42;/books/&#42;`
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
 *   Shelf shelf = Shelf.newBuilder().build();
 *   Shelf response = libraryServiceClient.createShelf(shelf);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LibraryServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateShelf</td>
 *      <td><p> Creates a shelf, and returns the new Shelf.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createShelf(CreateShelfRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createShelf(Shelf shelf)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createShelfCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetShelf</td>
 *      <td><p> Gets a shelf. Returns NOT_FOUND if the shelf does not exist.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getShelf(GetShelfRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getShelf(ShelfName name)
 *           <li><p> getShelf(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getShelfCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListShelves</td>
 *      <td><p> Lists shelves. The order is unspecified but deterministic. Newly created shelves will not necessarily be added to the end of this list.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listShelves(ListShelvesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listShelvesPagedCallable()
 *           <li><p> listShelvesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteShelf</td>
 *      <td><p> Deletes a shelf. Returns NOT_FOUND if the shelf does not exist.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteShelf(DeleteShelfRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteShelf(ShelfName name)
 *           <li><p> deleteShelf(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteShelfCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> MergeShelves</td>
 *      <td><p> Merges two shelves by adding all books from the shelf named `other_shelf_name` to shelf `name`, and deletes `other_shelf_name`. Returns the updated shelf. The book ids of the moved books may not be the same as the original books.
 * <p>  Returns NOT_FOUND if either shelf does not exist. This call is a no-op if the specified shelves are the same.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> mergeShelves(MergeShelvesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> mergeShelves(ShelfName name, ShelfName otherShelf)
 *           <li><p> mergeShelves(ShelfName name, String otherShelf)
 *           <li><p> mergeShelves(String name, ShelfName otherShelf)
 *           <li><p> mergeShelves(String name, String otherShelf)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> mergeShelvesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBook</td>
 *      <td><p> Creates a book, and returns the new Book.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBook(CreateBookRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createBook(ShelfName parent, Book book)
 *           <li><p> createBook(String parent, Book book)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBook</td>
 *      <td><p> Gets a book. Returns NOT_FOUND if the book does not exist.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBook(GetBookRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBook(BookName name)
 *           <li><p> getBook(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBooks</td>
 *      <td><p> Lists books in a shelf. The order is unspecified but deterministic. Newly created books will not necessarily be added to the end of this list. Returns NOT_FOUND if the shelf does not exist.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBooks(ListBooksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBooks(ShelfName parent)
 *           <li><p> listBooks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBooksPagedCallable()
 *           <li><p> listBooksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBook</td>
 *      <td><p> Deletes a book. Returns NOT_FOUND if the book does not exist.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBook(DeleteBookRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteBook(BookName name)
 *           <li><p> deleteBook(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBook</td>
 *      <td><p> Updates a book. Returns INVALID_ARGUMENT if the name of the book is non-empty and does not equal the existing name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBook(UpdateBookRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateBook(Book book, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> MoveBook</td>
 *      <td><p> Moves a book to another shelf, and returns the new book. The book id of the new book may not be the same as the original book.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> moveBook(MoveBookRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> moveBook(BookName name, ShelfName otherShelfName)
 *           <li><p> moveBook(BookName name, String otherShelfName)
 *           <li><p> moveBook(String name, ShelfName otherShelfName)
 *           <li><p> moveBook(String name, String otherShelfName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> moveBookCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of LibraryServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LibraryServiceSettings libraryServiceSettings =
 *     LibraryServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LibraryServiceClient libraryServiceClient = LibraryServiceClient.create(libraryServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LibraryServiceSettings libraryServiceSettings =
 *     LibraryServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LibraryServiceClient libraryServiceClient = LibraryServiceClient.create(libraryServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LibraryServiceSettings libraryServiceSettings =
 *     LibraryServiceSettings.newHttpJsonBuilder().build();
 * LibraryServiceClient libraryServiceClient = LibraryServiceClient.create(libraryServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class LibraryServiceClient implements BackgroundResource {
  private final LibraryServiceSettings settings;
  private final LibraryServiceStub stub;

  /** Constructs an instance of LibraryServiceClient with default settings. */
  public static final LibraryServiceClient create() throws IOException {
    return create(LibraryServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LibraryServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LibraryServiceClient create(LibraryServiceSettings settings)
      throws IOException {
    return new LibraryServiceClient(settings);
  }

  /**
   * Constructs an instance of LibraryServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(LibraryServiceSettings).
   */
  public static final LibraryServiceClient create(LibraryServiceStub stub) {
    return new LibraryServiceClient(stub);
  }

  /**
   * Constructs an instance of LibraryServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LibraryServiceClient(LibraryServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LibraryServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LibraryServiceClient(LibraryServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LibraryServiceSettings getSettings() {
    return settings;
  }

  public LibraryServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a shelf, and returns the new Shelf.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   Shelf shelf = Shelf.newBuilder().build();
   *   Shelf response = libraryServiceClient.createShelf(shelf);
   * }
   * }</pre>
   *
   * @param shelf The shelf to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Shelf createShelf(Shelf shelf) {
    CreateShelfRequest request = CreateShelfRequest.newBuilder().setShelf(shelf).build();
    return createShelf(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a shelf, and returns the new Shelf.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   CreateShelfRequest request =
   *       CreateShelfRequest.newBuilder().setShelf(Shelf.newBuilder().build()).build();
   *   Shelf response = libraryServiceClient.createShelf(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Shelf createShelf(CreateShelfRequest request) {
    return createShelfCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a shelf, and returns the new Shelf.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   CreateShelfRequest request =
   *       CreateShelfRequest.newBuilder().setShelf(Shelf.newBuilder().build()).build();
   *   ApiFuture<Shelf> future = libraryServiceClient.createShelfCallable().futureCall(request);
   *   // Do something.
   *   Shelf response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateShelfRequest, Shelf> createShelfCallable() {
    return stub.createShelfCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a shelf. Returns NOT_FOUND if the shelf does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   ShelfName name = ShelfName.of("[SHELF_ID]");
   *   Shelf response = libraryServiceClient.getShelf(name);
   * }
   * }</pre>
   *
   * @param name The name of the shelf to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Shelf getShelf(ShelfName name) {
    GetShelfRequest request =
        GetShelfRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getShelf(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a shelf. Returns NOT_FOUND if the shelf does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   String name = ShelfName.of("[SHELF_ID]").toString();
   *   Shelf response = libraryServiceClient.getShelf(name);
   * }
   * }</pre>
   *
   * @param name The name of the shelf to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Shelf getShelf(String name) {
    GetShelfRequest request = GetShelfRequest.newBuilder().setName(name).build();
    return getShelf(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a shelf. Returns NOT_FOUND if the shelf does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   GetShelfRequest request =
   *       GetShelfRequest.newBuilder().setName(ShelfName.of("[SHELF_ID]").toString()).build();
   *   Shelf response = libraryServiceClient.getShelf(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Shelf getShelf(GetShelfRequest request) {
    return getShelfCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a shelf. Returns NOT_FOUND if the shelf does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   GetShelfRequest request =
   *       GetShelfRequest.newBuilder().setName(ShelfName.of("[SHELF_ID]").toString()).build();
   *   ApiFuture<Shelf> future = libraryServiceClient.getShelfCallable().futureCall(request);
   *   // Do something.
   *   Shelf response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetShelfRequest, Shelf> getShelfCallable() {
    return stub.getShelfCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists shelves. The order is unspecified but deterministic. Newly created shelves will not
   * necessarily be added to the end of this list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   ListShelvesRequest request =
   *       ListShelvesRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Shelf element : libraryServiceClient.listShelves(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListShelvesPagedResponse listShelves(ListShelvesRequest request) {
    return listShelvesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists shelves. The order is unspecified but deterministic. Newly created shelves will not
   * necessarily be added to the end of this list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   ListShelvesRequest request =
   *       ListShelvesRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Shelf> future = libraryServiceClient.listShelvesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Shelf element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListShelvesRequest, ListShelvesPagedResponse>
      listShelvesPagedCallable() {
    return stub.listShelvesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists shelves. The order is unspecified but deterministic. Newly created shelves will not
   * necessarily be added to the end of this list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   ListShelvesRequest request =
   *       ListShelvesRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListShelvesResponse response = libraryServiceClient.listShelvesCallable().call(request);
   *     for (Shelf element : response.getShelvesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListShelvesRequest, ListShelvesResponse> listShelvesCallable() {
    return stub.listShelvesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a shelf. Returns NOT_FOUND if the shelf does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   ShelfName name = ShelfName.of("[SHELF_ID]");
   *   libraryServiceClient.deleteShelf(name);
   * }
   * }</pre>
   *
   * @param name The name of the shelf to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteShelf(ShelfName name) {
    DeleteShelfRequest request =
        DeleteShelfRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteShelf(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a shelf. Returns NOT_FOUND if the shelf does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   String name = ShelfName.of("[SHELF_ID]").toString();
   *   libraryServiceClient.deleteShelf(name);
   * }
   * }</pre>
   *
   * @param name The name of the shelf to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteShelf(String name) {
    DeleteShelfRequest request = DeleteShelfRequest.newBuilder().setName(name).build();
    deleteShelf(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a shelf. Returns NOT_FOUND if the shelf does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   DeleteShelfRequest request =
   *       DeleteShelfRequest.newBuilder().setName(ShelfName.of("[SHELF_ID]").toString()).build();
   *   libraryServiceClient.deleteShelf(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteShelf(DeleteShelfRequest request) {
    deleteShelfCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a shelf. Returns NOT_FOUND if the shelf does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   DeleteShelfRequest request =
   *       DeleteShelfRequest.newBuilder().setName(ShelfName.of("[SHELF_ID]").toString()).build();
   *   ApiFuture<Empty> future = libraryServiceClient.deleteShelfCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteShelfRequest, Empty> deleteShelfCallable() {
    return stub.deleteShelfCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges two shelves by adding all books from the shelf named `other_shelf_name` to shelf `name`,
   * and deletes `other_shelf_name`. Returns the updated shelf. The book ids of the moved books may
   * not be the same as the original books.
   *
   * <p>Returns NOT_FOUND if either shelf does not exist. This call is a no-op if the specified
   * shelves are the same.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   ShelfName name = ShelfName.of("[SHELF_ID]");
   *   ShelfName otherShelf = ShelfName.of("[SHELF_ID]");
   *   Shelf response = libraryServiceClient.mergeShelves(name, otherShelf);
   * }
   * }</pre>
   *
   * @param name The name of the shelf we're adding books to.
   * @param otherShelf The name of the shelf we're removing books from and deleting.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Shelf mergeShelves(ShelfName name, ShelfName otherShelf) {
    MergeShelvesRequest request =
        MergeShelvesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setOtherShelf(otherShelf == null ? null : otherShelf.toString())
            .build();
    return mergeShelves(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges two shelves by adding all books from the shelf named `other_shelf_name` to shelf `name`,
   * and deletes `other_shelf_name`. Returns the updated shelf. The book ids of the moved books may
   * not be the same as the original books.
   *
   * <p>Returns NOT_FOUND if either shelf does not exist. This call is a no-op if the specified
   * shelves are the same.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   ShelfName name = ShelfName.of("[SHELF_ID]");
   *   String otherShelf = ShelfName.of("[SHELF_ID]").toString();
   *   Shelf response = libraryServiceClient.mergeShelves(name, otherShelf);
   * }
   * }</pre>
   *
   * @param name The name of the shelf we're adding books to.
   * @param otherShelf The name of the shelf we're removing books from and deleting.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Shelf mergeShelves(ShelfName name, String otherShelf) {
    MergeShelvesRequest request =
        MergeShelvesRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setOtherShelf(otherShelf)
            .build();
    return mergeShelves(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges two shelves by adding all books from the shelf named `other_shelf_name` to shelf `name`,
   * and deletes `other_shelf_name`. Returns the updated shelf. The book ids of the moved books may
   * not be the same as the original books.
   *
   * <p>Returns NOT_FOUND if either shelf does not exist. This call is a no-op if the specified
   * shelves are the same.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   String name = ShelfName.of("[SHELF_ID]").toString();
   *   ShelfName otherShelf = ShelfName.of("[SHELF_ID]");
   *   Shelf response = libraryServiceClient.mergeShelves(name, otherShelf);
   * }
   * }</pre>
   *
   * @param name The name of the shelf we're adding books to.
   * @param otherShelf The name of the shelf we're removing books from and deleting.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Shelf mergeShelves(String name, ShelfName otherShelf) {
    MergeShelvesRequest request =
        MergeShelvesRequest.newBuilder()
            .setName(name)
            .setOtherShelf(otherShelf == null ? null : otherShelf.toString())
            .build();
    return mergeShelves(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges two shelves by adding all books from the shelf named `other_shelf_name` to shelf `name`,
   * and deletes `other_shelf_name`. Returns the updated shelf. The book ids of the moved books may
   * not be the same as the original books.
   *
   * <p>Returns NOT_FOUND if either shelf does not exist. This call is a no-op if the specified
   * shelves are the same.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   String name = ShelfName.of("[SHELF_ID]").toString();
   *   String otherShelf = ShelfName.of("[SHELF_ID]").toString();
   *   Shelf response = libraryServiceClient.mergeShelves(name, otherShelf);
   * }
   * }</pre>
   *
   * @param name The name of the shelf we're adding books to.
   * @param otherShelf The name of the shelf we're removing books from and deleting.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Shelf mergeShelves(String name, String otherShelf) {
    MergeShelvesRequest request =
        MergeShelvesRequest.newBuilder().setName(name).setOtherShelf(otherShelf).build();
    return mergeShelves(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges two shelves by adding all books from the shelf named `other_shelf_name` to shelf `name`,
   * and deletes `other_shelf_name`. Returns the updated shelf. The book ids of the moved books may
   * not be the same as the original books.
   *
   * <p>Returns NOT_FOUND if either shelf does not exist. This call is a no-op if the specified
   * shelves are the same.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   MergeShelvesRequest request =
   *       MergeShelvesRequest.newBuilder()
   *           .setName(ShelfName.of("[SHELF_ID]").toString())
   *           .setOtherShelf(ShelfName.of("[SHELF_ID]").toString())
   *           .build();
   *   Shelf response = libraryServiceClient.mergeShelves(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Shelf mergeShelves(MergeShelvesRequest request) {
    return mergeShelvesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges two shelves by adding all books from the shelf named `other_shelf_name` to shelf `name`,
   * and deletes `other_shelf_name`. Returns the updated shelf. The book ids of the moved books may
   * not be the same as the original books.
   *
   * <p>Returns NOT_FOUND if either shelf does not exist. This call is a no-op if the specified
   * shelves are the same.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   MergeShelvesRequest request =
   *       MergeShelvesRequest.newBuilder()
   *           .setName(ShelfName.of("[SHELF_ID]").toString())
   *           .setOtherShelf(ShelfName.of("[SHELF_ID]").toString())
   *           .build();
   *   ApiFuture<Shelf> future = libraryServiceClient.mergeShelvesCallable().futureCall(request);
   *   // Do something.
   *   Shelf response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MergeShelvesRequest, Shelf> mergeShelvesCallable() {
    return stub.mergeShelvesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a book, and returns the new Book.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   ShelfName parent = ShelfName.of("[SHELF_ID]");
   *   Book book = Book.newBuilder().build();
   *   Book response = libraryServiceClient.createBook(parent, book);
   * }
   * }</pre>
   *
   * @param parent The name of the shelf in which the book is created.
   * @param book The book to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Book createBook(ShelfName parent, Book book) {
    CreateBookRequest request =
        CreateBookRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBook(book)
            .build();
    return createBook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a book, and returns the new Book.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   String parent = ShelfName.of("[SHELF_ID]").toString();
   *   Book book = Book.newBuilder().build();
   *   Book response = libraryServiceClient.createBook(parent, book);
   * }
   * }</pre>
   *
   * @param parent The name of the shelf in which the book is created.
   * @param book The book to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Book createBook(String parent, Book book) {
    CreateBookRequest request =
        CreateBookRequest.newBuilder().setParent(parent).setBook(book).build();
    return createBook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a book, and returns the new Book.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   CreateBookRequest request =
   *       CreateBookRequest.newBuilder()
   *           .setParent(ShelfName.of("[SHELF_ID]").toString())
   *           .setBook(Book.newBuilder().build())
   *           .build();
   *   Book response = libraryServiceClient.createBook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Book createBook(CreateBookRequest request) {
    return createBookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a book, and returns the new Book.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   CreateBookRequest request =
   *       CreateBookRequest.newBuilder()
   *           .setParent(ShelfName.of("[SHELF_ID]").toString())
   *           .setBook(Book.newBuilder().build())
   *           .build();
   *   ApiFuture<Book> future = libraryServiceClient.createBookCallable().futureCall(request);
   *   // Do something.
   *   Book response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBookRequest, Book> createBookCallable() {
    return stub.createBookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a book. Returns NOT_FOUND if the book does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   BookName name = BookName.of("[SHELF]", "[BOOK]");
   *   Book response = libraryServiceClient.getBook(name);
   * }
   * }</pre>
   *
   * @param name The name of the book to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Book getBook(BookName name) {
    GetBookRequest request =
        GetBookRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a book. Returns NOT_FOUND if the book does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   String name = BookName.of("[SHELF]", "[BOOK]").toString();
   *   Book response = libraryServiceClient.getBook(name);
   * }
   * }</pre>
   *
   * @param name The name of the book to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Book getBook(String name) {
    GetBookRequest request = GetBookRequest.newBuilder().setName(name).build();
    return getBook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a book. Returns NOT_FOUND if the book does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   GetBookRequest request =
   *       GetBookRequest.newBuilder().setName(BookName.of("[SHELF]", "[BOOK]").toString()).build();
   *   Book response = libraryServiceClient.getBook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Book getBook(GetBookRequest request) {
    return getBookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a book. Returns NOT_FOUND if the book does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   GetBookRequest request =
   *       GetBookRequest.newBuilder().setName(BookName.of("[SHELF]", "[BOOK]").toString()).build();
   *   ApiFuture<Book> future = libraryServiceClient.getBookCallable().futureCall(request);
   *   // Do something.
   *   Book response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBookRequest, Book> getBookCallable() {
    return stub.getBookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists books in a shelf. The order is unspecified but deterministic. Newly created books will
   * not necessarily be added to the end of this list. Returns NOT_FOUND if the shelf does not
   * exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   ShelfName parent = ShelfName.of("[SHELF_ID]");
   *   for (Book element : libraryServiceClient.listBooks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The name of the shelf whose books we'd like to list.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBooksPagedResponse listBooks(ShelfName parent) {
    ListBooksRequest request =
        ListBooksRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listBooks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists books in a shelf. The order is unspecified but deterministic. Newly created books will
   * not necessarily be added to the end of this list. Returns NOT_FOUND if the shelf does not
   * exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   String parent = ShelfName.of("[SHELF_ID]").toString();
   *   for (Book element : libraryServiceClient.listBooks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent The name of the shelf whose books we'd like to list.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBooksPagedResponse listBooks(String parent) {
    ListBooksRequest request = ListBooksRequest.newBuilder().setParent(parent).build();
    return listBooks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists books in a shelf. The order is unspecified but deterministic. Newly created books will
   * not necessarily be added to the end of this list. Returns NOT_FOUND if the shelf does not
   * exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   ListBooksRequest request =
   *       ListBooksRequest.newBuilder()
   *           .setParent(ShelfName.of("[SHELF_ID]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Book element : libraryServiceClient.listBooks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBooksPagedResponse listBooks(ListBooksRequest request) {
    return listBooksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists books in a shelf. The order is unspecified but deterministic. Newly created books will
   * not necessarily be added to the end of this list. Returns NOT_FOUND if the shelf does not
   * exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   ListBooksRequest request =
   *       ListBooksRequest.newBuilder()
   *           .setParent(ShelfName.of("[SHELF_ID]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Book> future = libraryServiceClient.listBooksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Book element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBooksRequest, ListBooksPagedResponse> listBooksPagedCallable() {
    return stub.listBooksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists books in a shelf. The order is unspecified but deterministic. Newly created books will
   * not necessarily be added to the end of this list. Returns NOT_FOUND if the shelf does not
   * exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   ListBooksRequest request =
   *       ListBooksRequest.newBuilder()
   *           .setParent(ShelfName.of("[SHELF_ID]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBooksResponse response = libraryServiceClient.listBooksCallable().call(request);
   *     for (Book element : response.getBooksList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBooksRequest, ListBooksResponse> listBooksCallable() {
    return stub.listBooksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a book. Returns NOT_FOUND if the book does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   BookName name = BookName.of("[SHELF]", "[BOOK]");
   *   libraryServiceClient.deleteBook(name);
   * }
   * }</pre>
   *
   * @param name The name of the book to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBook(BookName name) {
    DeleteBookRequest request =
        DeleteBookRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteBook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a book. Returns NOT_FOUND if the book does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   String name = BookName.of("[SHELF]", "[BOOK]").toString();
   *   libraryServiceClient.deleteBook(name);
   * }
   * }</pre>
   *
   * @param name The name of the book to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBook(String name) {
    DeleteBookRequest request = DeleteBookRequest.newBuilder().setName(name).build();
    deleteBook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a book. Returns NOT_FOUND if the book does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   DeleteBookRequest request =
   *       DeleteBookRequest.newBuilder()
   *           .setName(BookName.of("[SHELF]", "[BOOK]").toString())
   *           .build();
   *   libraryServiceClient.deleteBook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBook(DeleteBookRequest request) {
    deleteBookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a book. Returns NOT_FOUND if the book does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   DeleteBookRequest request =
   *       DeleteBookRequest.newBuilder()
   *           .setName(BookName.of("[SHELF]", "[BOOK]").toString())
   *           .build();
   *   ApiFuture<Empty> future = libraryServiceClient.deleteBookCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBookRequest, Empty> deleteBookCallable() {
    return stub.deleteBookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a book. Returns INVALID_ARGUMENT if the name of the book is non-empty and does not
   * equal the existing name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   Book book = Book.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Book response = libraryServiceClient.updateBook(book, updateMask);
   * }
   * }</pre>
   *
   * @param book The name of the book to update.
   * @param updateMask Required. Mask of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Book updateBook(Book book, FieldMask updateMask) {
    UpdateBookRequest request =
        UpdateBookRequest.newBuilder().setBook(book).setUpdateMask(updateMask).build();
    return updateBook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a book. Returns INVALID_ARGUMENT if the name of the book is non-empty and does not
   * equal the existing name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   UpdateBookRequest request =
   *       UpdateBookRequest.newBuilder()
   *           .setBook(Book.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Book response = libraryServiceClient.updateBook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Book updateBook(UpdateBookRequest request) {
    return updateBookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a book. Returns INVALID_ARGUMENT if the name of the book is non-empty and does not
   * equal the existing name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   UpdateBookRequest request =
   *       UpdateBookRequest.newBuilder()
   *           .setBook(Book.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Book> future = libraryServiceClient.updateBookCallable().futureCall(request);
   *   // Do something.
   *   Book response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBookRequest, Book> updateBookCallable() {
    return stub.updateBookCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a book to another shelf, and returns the new book. The book id of the new book may not be
   * the same as the original book.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   BookName name = BookName.of("[SHELF]", "[BOOK]");
   *   ShelfName otherShelfName = ShelfName.of("[SHELF_ID]");
   *   Book response = libraryServiceClient.moveBook(name, otherShelfName);
   * }
   * }</pre>
   *
   * @param name The name of the book to move.
   * @param otherShelfName The name of the destination shelf.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Book moveBook(BookName name, ShelfName otherShelfName) {
    MoveBookRequest request =
        MoveBookRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setOtherShelfName(otherShelfName == null ? null : otherShelfName.toString())
            .build();
    return moveBook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a book to another shelf, and returns the new book. The book id of the new book may not be
   * the same as the original book.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   BookName name = BookName.of("[SHELF]", "[BOOK]");
   *   String otherShelfName = ShelfName.of("[SHELF_ID]").toString();
   *   Book response = libraryServiceClient.moveBook(name, otherShelfName);
   * }
   * }</pre>
   *
   * @param name The name of the book to move.
   * @param otherShelfName The name of the destination shelf.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Book moveBook(BookName name, String otherShelfName) {
    MoveBookRequest request =
        MoveBookRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setOtherShelfName(otherShelfName)
            .build();
    return moveBook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a book to another shelf, and returns the new book. The book id of the new book may not be
   * the same as the original book.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   String name = BookName.of("[SHELF]", "[BOOK]").toString();
   *   ShelfName otherShelfName = ShelfName.of("[SHELF_ID]");
   *   Book response = libraryServiceClient.moveBook(name, otherShelfName);
   * }
   * }</pre>
   *
   * @param name The name of the book to move.
   * @param otherShelfName The name of the destination shelf.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Book moveBook(String name, ShelfName otherShelfName) {
    MoveBookRequest request =
        MoveBookRequest.newBuilder()
            .setName(name)
            .setOtherShelfName(otherShelfName == null ? null : otherShelfName.toString())
            .build();
    return moveBook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a book to another shelf, and returns the new book. The book id of the new book may not be
   * the same as the original book.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   String name = BookName.of("[SHELF]", "[BOOK]").toString();
   *   String otherShelfName = ShelfName.of("[SHELF_ID]").toString();
   *   Book response = libraryServiceClient.moveBook(name, otherShelfName);
   * }
   * }</pre>
   *
   * @param name The name of the book to move.
   * @param otherShelfName The name of the destination shelf.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Book moveBook(String name, String otherShelfName) {
    MoveBookRequest request =
        MoveBookRequest.newBuilder().setName(name).setOtherShelfName(otherShelfName).build();
    return moveBook(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a book to another shelf, and returns the new book. The book id of the new book may not be
   * the same as the original book.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   MoveBookRequest request =
   *       MoveBookRequest.newBuilder()
   *           .setName(BookName.of("[SHELF]", "[BOOK]").toString())
   *           .setOtherShelfName(ShelfName.of("[SHELF_ID]").toString())
   *           .build();
   *   Book response = libraryServiceClient.moveBook(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Book moveBook(MoveBookRequest request) {
    return moveBookCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a book to another shelf, and returns the new book. The book id of the new book may not be
   * the same as the original book.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LibraryServiceClient libraryServiceClient = LibraryServiceClient.create()) {
   *   MoveBookRequest request =
   *       MoveBookRequest.newBuilder()
   *           .setName(BookName.of("[SHELF]", "[BOOK]").toString())
   *           .setOtherShelfName(ShelfName.of("[SHELF_ID]").toString())
   *           .build();
   *   ApiFuture<Book> future = libraryServiceClient.moveBookCallable().futureCall(request);
   *   // Do something.
   *   Book response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MoveBookRequest, Book> moveBookCallable() {
    return stub.moveBookCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListShelvesPagedResponse
      extends AbstractPagedListResponse<
          ListShelvesRequest,
          ListShelvesResponse,
          Shelf,
          ListShelvesPage,
          ListShelvesFixedSizeCollection> {

    public static ApiFuture<ListShelvesPagedResponse> createAsync(
        PageContext<ListShelvesRequest, ListShelvesResponse, Shelf> context,
        ApiFuture<ListShelvesResponse> futureResponse) {
      ApiFuture<ListShelvesPage> futurePage =
          ListShelvesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListShelvesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListShelvesPagedResponse(ListShelvesPage page) {
      super(page, ListShelvesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListShelvesPage
      extends AbstractPage<ListShelvesRequest, ListShelvesResponse, Shelf, ListShelvesPage> {

    private ListShelvesPage(
        PageContext<ListShelvesRequest, ListShelvesResponse, Shelf> context,
        ListShelvesResponse response) {
      super(context, response);
    }

    private static ListShelvesPage createEmptyPage() {
      return new ListShelvesPage(null, null);
    }

    @Override
    protected ListShelvesPage createPage(
        PageContext<ListShelvesRequest, ListShelvesResponse, Shelf> context,
        ListShelvesResponse response) {
      return new ListShelvesPage(context, response);
    }

    @Override
    public ApiFuture<ListShelvesPage> createPageAsync(
        PageContext<ListShelvesRequest, ListShelvesResponse, Shelf> context,
        ApiFuture<ListShelvesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListShelvesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListShelvesRequest,
          ListShelvesResponse,
          Shelf,
          ListShelvesPage,
          ListShelvesFixedSizeCollection> {

    private ListShelvesFixedSizeCollection(List<ListShelvesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListShelvesFixedSizeCollection createEmptyCollection() {
      return new ListShelvesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListShelvesFixedSizeCollection createCollection(
        List<ListShelvesPage> pages, int collectionSize) {
      return new ListShelvesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBooksPagedResponse
      extends AbstractPagedListResponse<
          ListBooksRequest, ListBooksResponse, Book, ListBooksPage, ListBooksFixedSizeCollection> {

    public static ApiFuture<ListBooksPagedResponse> createAsync(
        PageContext<ListBooksRequest, ListBooksResponse, Book> context,
        ApiFuture<ListBooksResponse> futureResponse) {
      ApiFuture<ListBooksPage> futurePage =
          ListBooksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListBooksPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListBooksPagedResponse(ListBooksPage page) {
      super(page, ListBooksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBooksPage
      extends AbstractPage<ListBooksRequest, ListBooksResponse, Book, ListBooksPage> {

    private ListBooksPage(
        PageContext<ListBooksRequest, ListBooksResponse, Book> context,
        ListBooksResponse response) {
      super(context, response);
    }

    private static ListBooksPage createEmptyPage() {
      return new ListBooksPage(null, null);
    }

    @Override
    protected ListBooksPage createPage(
        PageContext<ListBooksRequest, ListBooksResponse, Book> context,
        ListBooksResponse response) {
      return new ListBooksPage(context, response);
    }

    @Override
    public ApiFuture<ListBooksPage> createPageAsync(
        PageContext<ListBooksRequest, ListBooksResponse, Book> context,
        ApiFuture<ListBooksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBooksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBooksRequest, ListBooksResponse, Book, ListBooksPage, ListBooksFixedSizeCollection> {

    private ListBooksFixedSizeCollection(List<ListBooksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBooksFixedSizeCollection createEmptyCollection() {
      return new ListBooksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBooksFixedSizeCollection createCollection(
        List<ListBooksPage> pages, int collectionSize) {
      return new ListBooksFixedSizeCollection(pages, collectionSize);
    }
  }
}
