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

                    input {
                           message "Should we continue?"
                           ok "Yes, we should."
                           submitter "alice,bob"
                           parameters {
                            string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
                        }

                    build job: 'triggerd'
                }
                }
            }
        }
}
