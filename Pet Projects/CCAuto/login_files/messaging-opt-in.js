'use strict';

(function(global) {

  /**
   * Opt-in preference pop-up window
   */
  global.messagingOptIn = function(cb) {
    var theme = global.renderContext.theme;
    var venue = global.renderContext.venue;

    // Only show opt in window if venue's wifi_optin_type is equal to 2.
    if (venue.wifi_optin_type === 2 && !global.renderContext.isPreview) {
      messageBoxes.enqueue(new MessageBoxes.MessagingOptInWindow(
          {
            message: '',
            class: 'messaging-opt-in-window',
            okButtonTitle: theme.message_opt_in_ok_title,
            cancelButtonTitle: theme.message_opt_in_cancel_title,
            companyName: global.renderContext.whitelabel.comp_name
          }),
          function (clickedAgree) {
            // send AJAX requests to the server
            // so that we can save the response in session.
            $.ajax({
              url: '/opt-in-response',
              type: 'POST',
              data: {
                optIn: clickedAgree
              }
            })
            .done(function () {
              cb(clickedAgree);
            });
          }
        );
    }
    else {
      cb();
    }

    theme = undefined;
    venue = undefined;
  };

})(window);
