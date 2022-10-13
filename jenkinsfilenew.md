pipeline {
    agent { label 'GAMEOFLIFE' }
    parameters { 
        string(name: 'MAVEN', defaultValue: 'MAVEN1', description: 'forgameoflife')
      choice(name: 'branch_1', choices: ['master', 'branch1'], description: 'forgameoflife')
      }
        stages{
            stage('vcs'){
                git branch: '${params.branch1}',
                 url:'https://github.com/maheshryali/game-of-life.git'
            }
            stage('build'){
                sh "${params.MAVEN}
            }
            }
}