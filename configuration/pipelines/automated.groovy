#!/usr/bin/env groovy

CREDENTIALS_ID = 'github'

try {

    node( 'master' ) {

        stage( 'Initialise' ) {
            git url: 'https://github.com/hmniw/rbp-postman-tests.git', branch: 'master', credentialsId: CREDENTIALS_ID
        }

        stage( 'Install Dependencies' ) {
            sh 'npm install -g newman'
            sh 'npm install'
        }

        stage( 'Run Tests' ) {
            sh 'run-tests.sh'
        }

    }
} catch (exception) {
    currentBuild.result = 'FAILURE'
    throw exception
}