'use strict';

(function(global) {

  /**
   * Create an instance of each auth type that the venue uses, passing in
   * options provided by the server. The auth type list and options are
   * provided through the renderContext.authTypes object. Each auth type is
   * also given a reference to the render context.
   *
   * View lib/pages.js to see how renderContext is generated.
   */
  global.instantiateAuthTypes = function instantiateAuthTypes(renderContext) {
    var authTypes = renderContext.authTypes;
    var authInstances = [];

    authTypes.forEach(function(type) {
      var className = type.clientClassName;
      var options = type.clientClassOptions;
      options.allAuthInstances = authInstances;
      options.renderContext = renderContext;
      options.$parent = $('#auth-options');

      authInstances.push(new global[className](options));
    });

    // Allow the instances to run some code after they are all loaded.
    authInstances.forEach(function(instance) {
      instance.onAllTypesLoaded();
    });
  }

})(window);
