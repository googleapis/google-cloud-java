#!/bin/bash

set -e

SITE_VERSION=$1
SITE_VERSION_BASE=$(sed -r 's/([0-9]+\.[0-9]+\.[0-9]+).*/\1/' <<< "$SITE_VERSION")

echo "Creating site for google-cloud-java $SITE_VERSION_BASE"

if [ -z "$SITE_VERSION_BASE" ]; then
    echo "First arg (version) not provided, so we're exiting."
    exit 1
fi

git clone --branch gh-pages --single-branch https://github.com/GoogleCloudPlatform/google-cloud-java/ tmp_gh-pages
mkdir -p tmp_gh-pages/$SITE_VERSION_BASE
mvn site -DskipTests -Djava.util.logging.config.file=logging.properties

version_bases=(${SITE_VERSION_BASE} latest)
rm -rf tmp_gh-pages/latest
mkdir tmp_gh-pages/latest
for version_base in ${version_bases[@]}
do
  mvn site:stage --quiet -Djava.util.logging.config.file=logging.properties -DtopSiteURL=https://googlecloudplatform.github.io/google-cloud-java/site/${version_base}/
  cd tmp_gh-pages
  cp -r ../target/staging/*/* $version_base
  sed -i "s/{{SITE_VERSION}}/$SITE_VERSION/g" ${version_base}/index.html # Update "Quickstart with Maven" to reflect version change
  git add $version_base
  cd ..
done

cd tmp_gh-pages
echo "<html><head><meta http-equiv=\"refresh\" content=\"0; URL='https://GoogleCloudPlatform.github.io/google-cloud-java/${SITE_VERSION_BASE}/index.html'\" /></head><body></body></html>" > index.html
git add index.html
echo "<html><head><script>window.location.replace('/google-cloud-java/${SITE_VERSION_BASE}/apidocs' + location.search)</script></head><body></body></html>" > apidocs/index.html
git add apidocs/index.html

echo "Site generated under tmp_gh-pages/. The changes must be committed from that directory."
