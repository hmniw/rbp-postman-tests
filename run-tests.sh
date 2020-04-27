PM_ENV_VAR_PATH="environment_variables.postman_environment.json"

run_collection() {
    collection=$1
    newman run ${collection} -e ${PM_ENV_VAR_PATH} -r htmlextra --reporter-htmlextra-title "RBP Postman Test Report"

    if [ "$?" == 1 ]; then
        echo "should fail the build"\
        exit 1
    fi

    sleep 1
}

rm -r newman

run_collection room_controller_tests.postman_collection.json