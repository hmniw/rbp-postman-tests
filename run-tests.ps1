$collection='room_controller_tests.postman_collection'
$environment='environment_variables.postman_environment'
$output=$(newman run $collection -e $environment -r htmlextra --reporter-htmlextra-title "RBP Postman Test Report")

Write-Host $output