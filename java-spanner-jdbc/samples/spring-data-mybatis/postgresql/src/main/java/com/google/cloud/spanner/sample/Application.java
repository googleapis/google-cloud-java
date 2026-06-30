/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.spanner.sample;

import com.google.cloud.spanner.connection.SpannerPool;
import com.google.cloud.spanner.sample.entities.Album;
import com.google.cloud.spanner.sample.entities.Singer;
import com.google.cloud.spanner.sample.entities.Track;
import com.google.cloud.spanner.sample.mappers.AlbumMapper;
import com.google.cloud.spanner.sample.mappers.SingerMapper;
import com.google.cloud.spanner.sample.service.AlbumService;
import com.google.cloud.spanner.sample.service.SingerService;
import java.util.concurrent.ThreadLocalRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
  private static final Logger logger = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    EmulatorInitializer emulatorInitializer = new EmulatorInitializer();
    try {
      SpringApplication application = new SpringApplication(Application.class);
      application.addListeners(emulatorInitializer);
      application.run(args).close();
    } finally {
      SpannerPool.closeSpannerPool();
      emulatorInitializer.stopEmulator();
    }
  }

  private final DatabaseSeeder databaseSeeder;

  private final SingerService singerService;

  private final AlbumService albumService;

  private final SingerMapper singerMapper;

  private final AlbumMapper albumMapper;

  public Application(
      SingerService singerService,
      AlbumService albumService,
      DatabaseSeeder databaseSeeder,
      SingerMapper singerMapper,
      AlbumMapper albumMapper) {
    this.databaseSeeder = databaseSeeder;
    this.singerService = singerService;
    this.albumService = albumService;
    this.singerMapper = singerMapper;
    this.albumMapper = albumMapper;
  }

  @Override
  public void run(String... args) {

    // Set the system property 'drop_schema' to true to drop any existing database
    // schema when the application is executed.
    if (Boolean.parseBoolean(System.getProperty("drop_schema", "false"))) {
      logger.info("Dropping existing schema if it exists");
      databaseSeeder.dropDatabaseSchemaIfExists();
    }

    logger.info("Creating database schema if it does not already exist");
    databaseSeeder.createDatabaseSchemaIfNotExists();
    logger.info("Deleting existing test data");
    databaseSeeder.deleteTestData();
    logger.info("Inserting fresh test data");
    databaseSeeder.insertTestData();

    Iterable<Singer> allSingers = singerMapper.findAll();
    for (Singer singer : allSingers) {
      logger.info(
          "Found singer: {} with {} albums",
          singer,
          albumMapper.countAlbumsBySingerId(singer.getId()));
      for (Album album : albumMapper.findAlbumsBySingerId(singer.getId())) {
        logger.info("\tAlbum: {}, released at {}", album, album.getReleaseDate());
      }
    }

    // Create a new singer and three albums in a transaction.
    Singer insertedSinger =
        singerService.createSingerAndAlbums(
            new Singer("Amethyst", "Jiang"),
            new Album(DatabaseSeeder.randomTitle()),
            new Album(DatabaseSeeder.randomTitle()),
            new Album(DatabaseSeeder.randomTitle()));
    logger.info(
        "Inserted singer {} {} {}",
        insertedSinger.getId(),
        insertedSinger.getFirstName(),
        insertedSinger.getLastName());

    // Create a new Album and some Tracks in a read/write transaction.
    // Track is an interleaved table.
    Album album = new Album(DatabaseSeeder.randomTitle());
    album.setSingerId(insertedSinger.getId());
    albumService.createAlbumAndTracks(
        album,
        new Track(album, 1, DatabaseSeeder.randomTitle(), 3.14d),
        new Track(album, 2, DatabaseSeeder.randomTitle(), 3.14d),
        new Track(album, 3, DatabaseSeeder.randomTitle(), 3.14d),
        new Track(album, 4, DatabaseSeeder.randomTitle(), 3.14d),
        new Track(album, 5, DatabaseSeeder.randomTitle(), 3.14d),
        new Track(album, 6, DatabaseSeeder.randomTitle(), 3.14d),
        new Track(album, 7, DatabaseSeeder.randomTitle(), 3.14d));
    logger.info("Inserted album {}", album.getTitle());

    // List all singers that have a last name starting with an 'J'.
    logger.info("All singers with a last name starting with an 'J':");
    for (Singer singer : singerMapper.findSingersByLastNameStartingWith("J")) {
      logger.info("\t{}", singer.getFullName());
    }

    // The singerService.listSingersWithLastNameStartingWith(..) method uses a read-only
    // transaction. You should prefer read-only transactions to read/write transactions whenever
    // possible, as read-only transactions do not take locks.
    logger.info("All singers with a last name starting with an 'A', 'B', or 'C'.");
    for (Singer singer : singerService.listSingersWithLastNameStartingWith("A", "B", "C")) {
      logger.info("\t{}", singer.getFullName());
    }

    // Execute an insert-or-update for a Singer record.
    // For this, we either get a random Singer from the database, or create a new Singer entity
    // and assign it a random ID.
    logger.info("Executing an insert-or-update statement for a Singer record");
    Singer singer;
    if (ThreadLocalRandom.current().nextBoolean()) {
      singer = singerMapper.getRandom();
    } else {
      singer = new Singer();
      singer.setId(ThreadLocalRandom.current().nextLong());
    }
    singer.setFirstName("Beatriz");
    singer.setLastName("Russel");
    singer.setActive(true);
    // This executes an INSERT ... ON CONFLICT DO UPDATE statement.
    singerMapper.insertOrUpdate(singer);
  }
}
