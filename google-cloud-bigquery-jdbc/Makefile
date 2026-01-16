CONTAINER_NAME=jdbc
PACKAGE_DESTINATION=$(PWD)/drivers
SRC="$(PWD)/.."
skipSurefire ?= true

# no indendation for ifndef\endif due to their evaluation before execution
.check-env: |
ifndef GOOGLE_APPLICATION_CREDENTIALS
	$(error GOOGLE_APPLICATION_CREDENTIALS is required to run tests)
endif

install:
	mvn clean install

clean:
	mvn clean

lint:
	mvn com.spotify.fmt:fmt-maven-plugin:format

unittest: |
	mvn -B -ntp \
		-DtrimStackTrace=false \
		-Dclirr.skip=true \
		-Denforcer.skip=true \
		-Dtest=$(test) \
		test

# Important: By default, this command will skip unittests.
# To include unit tests, run: make integration-test skipSurefire=false
integration-test: .check-env
	mvn -B -ntp \
		-Penable-integration-tests \
		-DtrimStackTrace=false \
		-DskipSurefire=$(skipSurefire) \
		-Dclirr.skip=true \
		-Denforcer.skip=true \
		-Dit.failIfNoSpecifiedTests=false \
		-Dit.test=$(test) \
		integration-test

unit-test-coverage:
	$(MAKE) unittest
	mvn -B -ntp jacoco:report
	BUILD_DIR=$$(mvn -B -ntp help:evaluate -Dexpression=project.build.directory -q -DforceStdout); \
	cd $$BUILD_DIR/site && zip -r $$OLDPWD/jacoco-unittests.zip jacoco && cd $$OLDPWD

full-coverage: .check-env
	$(MAKE) integration-test skipSurefire=false test=ITBigQueryJDBCTest,ITNightlyBigQueryTest
	mvn -B -ntp jacoco:report
	BUILD_DIR=$$(mvn -B -ntp  help:evaluate -Dexpression=project.build.directory -q -DforceStdout); \
	cd $$BUILD_DIR/site && zip -r $$OLDPWD/jacoco-full.zip jacoco && cd $$OLDPWD

package: 
	mvn clean package \
		-DincludeScope=runtime \
		-Dmaven.test.skip=true
	mvn dependency:copy-dependencies \
		-DincludeScope=runtime
	${MAKE} generate-dependency-list

package-all-dependencies:
	mvn package \
		-DincludeScope=runtime \
		-Dmaven.test.skip=true \
		-P=release-all-dependencies

package-all-dependencies-shaded:
	mvn package \
		-DincludeScope=runtime \
		-Dmaven.test.skip=true \
		-P=release-all-dependencies,release-all-dependencies-shaded

generate-dependency-list:
	mvn -B dependency:list \
		-f pom.xml \
		-DincludeScope=runtime | grep :jar: | sed -E "s/^.* ([^: ]+):([^:]+):([^:]+):([^:]+).*/<dependency><groupId>\1<\/groupId><artifactId>\2<\/artifactId><version>\4<\/version><\/dependency>/g" > dependencies.txt

# Commands for dockerized environments
.docker-run: | 
	docker run -it \
		-v $(GOOGLE_APPLICATION_CREDENTIALS):/auth/application_creds.json \
		-v "$(GOOGLE_APPLICATION_CREDENTIALS).p12":/auth/application_creds.p12 \
		-e "GOOGLE_APPLICATION_CREDENTIALS=/auth/application_creds.json" \
		-v $(SRC):/src \
		-e "SA_EMAIL=test_email" \
		-e "SA_SECRET=/auth/application_creds.json" \
		-e "SA_SECRET_P12=/auth/application_creds.p12" \
		$(CONTAINER_NAME) $(args)

docker-build:
	docker build -t $(CONTAINER_NAME) -f Dockerfile ..

docker-session:
	$(MAKE) .docker-run args="bash"

docker-package-all-dependencies: docker-build
	mkdir -p $(PACKAGE_DESTINATION)
	docker run \
		-v $(SRC):/src \
		-v $(PACKAGE_DESTINATION):/pkg \
		$(CONTAINER_NAME) \
		sh -c "make package-all-dependencies && \
			cp --no-preserve=ownership /mvn/test-target/google-cloud-bigquery-jdbc-*.jar /pkg && \
			rm -f /pkg/*tests.jar"

docker-package-all-dependencies-shaded: docker-build
	mkdir -p $(PACKAGE_DESTINATION)
	docker run \
		-v $(SRC):/src \
		-v $(PACKAGE_DESTINATION):/pkg \
		$(CONTAINER_NAME) \
		sh -c "make package-all-dependencies-shaded && \
			cp --no-preserve=ownership /mvn/test-target/google-cloud-bigquery-jdbc-*.jar /pkg && \
			rm -f /pkg/*tests.jar"

docker-package: docker-build
	mkdir -p $(PACKAGE_DESTINATION)
	docker run \
		-v $(SRC):/src \
		-v $(PACKAGE_DESTINATION):/pkg \
		$(CONTAINER_NAME) \
		sh -c "make package && \
			mkdir -p /tmp/package && \
			cp --no-preserve=ownership /mvn/test-target/google-cloud-bigquery-jdbc-*.jar /tmp/package && \
			rm -f /pkg/*tests.jar && \
			cp --no-preserve=ownership dependencies.txt /tmp/package && \
			rm dependencies.txt && \
			cp --no-preserve=ownership /mvn/test-target/dependency/*.jar /tmp/package && \
			zip -j -r /pkg/google-cloud-bigquery-jdbc-$$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout).zip /tmp/package"

docker-unittest: |
	$(MAKE) .docker-run args="make unittest test=$(test)"

docker-integration-test: .check-env
	$(MAKE) .docker-run args="make integration-test test=$(test) skipSurefire=$(skipSurefire)"

docker-coverage: 
	$(MAKE) .docker-run args="make unit-test-coverage"
	$(MAKE) .docker-run args="make full-coverage"