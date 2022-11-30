#!/bin/bash
#input -> text file that lists versionless coordinates

#example ->
#com.google.cloud:google-cloud-storage
#com.google.cloud:google-cloud-vision

#Output:
#cloud_java_client_library_release_dates.csv that holds the data defined below. It has artifact_id,service_name,version, and release_date columns.

cat ./dashboard/libraries.txt | while read line; do

  group_id=${line%:*}
  artifact_id=${line#*:}
  new_group_id="${group_id//.//}"
  service_name=${artifact_id#*-cloud-}

  if [[ "${artifact_id}" == *storage* ]]; then
    service_name=bigstore
  fi

  URL=https://repo1.maven.org/maven2/$new_group_id/$artifact_id

  ./dashboard/fetch_library_release_date.sh $URL $artifact_id $service_name

done

sed 's/ \+/,/g' cloud_java_client_library_release_dates_tsv.txt > ./dashboard/cloud_java_client_library_release_dates.csv
sed -i '1s/^/version,release_date,artifact_id,service_name\n/' ./dashboard/cloud_java_client_library_release_dates.csv

rm -f cloud_java_client_library_release_dates_tsv.txt
