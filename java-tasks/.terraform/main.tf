terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}
module "project-services" {
  source = "terraform-google-modules/project-factory/google//modules/project_services"

  project_id                  = var.inputs.project_id
  enable_apis                 = var.inputs.should_enable_apis_on_apply
  disable_services_on_destroy = var.inputs.should_disable_apis_on_destroy
  activate_apis               = ["cloudtasks.googleapis.com"]
}
resource "time_sleep" "for_90s_allowTasksToFullyEnable" {
  depends_on      = [module.project-services]
  create_duration = "90s"
}