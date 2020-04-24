PM_ENV_VAR_PATH="environment._variables.postman_envrionment.json"

run_collection() {
    collection=$1
    newman run ${collection} -e ${PM_ENV_VAR_PATH}

    if [ "$?" == 1 ]; then
        echo "should fail the build"\
        exit 1
    fi

    sleep 1
}

run_collection room_controller_tests.postman_collection.json