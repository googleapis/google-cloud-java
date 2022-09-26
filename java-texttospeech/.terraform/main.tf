terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "texttospeech_api" {
  service            = "texttospeech.googleapis.com"
  disable_on_destroy = false
}
resource "time_sleep" "wait_90_seconds" {
  depends_on      = [google_project_service.texttospeech_api]
  create_duration = "90s"
}

