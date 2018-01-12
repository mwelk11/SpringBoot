module.exports = function(grunt) {
    grunt.initConfig({
        jshint: {
            files: ['Gruntfile.js', 'scripts/**/*.js'],
            options: {
                devel: true,
                browser: true,
                jasmine: true,
                undef: true,
                unused: true,
                globals: {
                    angular: true,
                    app: true,
                    module: true,
                    inject: true
                }
            }
        },
        karma: {
            unit: {
                options: {
                    frameworks: ['jasmine'],
                    singleRun: false,
                    browsers: ['PhantomJS', 'Chrome'],
                    files: [
                        'bower_components/angular/angular.js',
                        'bower_components/angular-route/angular-route.js',
                        'bower_components/angular-mocks/angular-mocks.js',
                        'scripts/**/*.js'
                    ]
                }
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-karma');

    grunt.registerTask('test', ['jshint', 'karma']);
    grunt.registerTask('default', ['jshint', 'karma']);

};
