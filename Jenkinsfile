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
                echo 'this is success'
                input {
                    message "Should we continue?"
                    ok "Yes, we should."
                    submitter "alice,bob"
                }
                build job: 'triggerd'
            }
        }
}
