terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "dialogflow_api" {
  service            = "dialogflow.googleapis.com"
  disable_on_destroy = false
}

resource "google_dialogflow_agent" "design_time_agent" {
  display_name          = "google-cloud-java-tests"
  default_language_code = "en"
  time_zone             = "America/Los_Angeles"
  match_mode            = "MATCH_MODE_HYBRID"
  depends_on            = [google_project_service.dialogflow_api]
}
