run_collection() {
    collection=$1
    ${PM_NEWMAN_PATH} run ${PM_COLLECTION_PATH} -e ${PM_ENV_VAR_PATH} -r htmlextra --reporter-htmlextra-title "RBP Postman Test Report"

    if [ "$?" == 1 ]; then
        echo "should fail the build"\
        exit 1
    fi

    sleep 1
}

run_collection