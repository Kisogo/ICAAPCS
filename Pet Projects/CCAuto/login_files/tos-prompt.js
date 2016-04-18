'use strict';

(function(global) {

  /**
   * Terms of service pop-up window
   */
  global.tosPrompt = function(okCallback, cancelCallback) {
    var theme = global.renderContext.theme;

    messageBoxes.enqueue(new MessageBoxes.OptInWindow(
        {
          message: theme.opt_in_msg,
          class: 'tos-prompt',
          okButtonTitle: theme.opt_in_ok_title,
          cancelButtonTitle: theme.opt_in_cancel_title,
          showCheckbox: theme.opt_in_show_checkbox,
          allowOptoutSignin: theme.allow_optout_signin
        }),
        function(clickedOk, optoutSignin) {
          if (clickedOk) {
            okCallback(optoutSignin);
          }
          else if (typeof cancelCallback === 'function')
            cancelCallback();
        }
      );

    theme = undefined;
  }

})(window);
