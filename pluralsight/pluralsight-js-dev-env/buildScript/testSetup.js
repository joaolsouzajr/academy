//This file isn't transpiled, so must use comomnJS and ES5

//Register babel to transpile before our ntest run
require('babel-register')();

//Disable webpack features that Mocha doesn't understand.
require.extensions['.css'] = function() {};
