pipeline {
    agent any

    stages {
        stage('clone') {
            steps {
                echo 'clone'
            }
        }

        stage('Unit test') {
            steps {
                echo 'unit test'
                echo 'unit test'
                echo 'unit test'
                echo 'unit test'

            }


        }
    }
    post {
            always {
                echo 'I will always say Hello again!'
            }
            success {
                steps {
                    echo 'this is success'
                    build job: 'triggerd'
                }
            }
        }
}
