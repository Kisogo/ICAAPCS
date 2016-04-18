'use strict';

(function(global) {

  /**
   * Repeatedly ask the user for a voucher code and display an invalid code
   * alert until a correct code is entered.
   */
  global.promptForVoucherCode = function(callback) {
    var prompter = new VoucherCodePrompter();
    prompter.loop(callback);
  }

  function VoucherCodePrompter(callback) {
    this._callback = callback;
  }

  VoucherCodePrompter.prototype.loop = function loop(callback) {
    var self = this;
    var loop = self.loop.bind(self, callback);

    this.showTextBox(function(code) {
      if (code.length === 0) {
        messageBoxes.alert('Please enter a voucher code.', loop);
        return;
      }

      self.checkVoucherCode(code, function(err, status) {
        if (err || !status || status === 'error' || status === 'not found') {
          messageBoxes.alert('The code you entered is invalid.', loop);
          return;
        }

        if (status === 'used') {
          messageBoxes.alert('The code you entered has already been used.',
            loop);
          return;
        }

        callback();
      });
    });
  }

  VoucherCodePrompter.prototype.showTextBox = function showTextBox(callback) {
    messageBoxes.textBox('To connect to the Wi-Fi, enter your voucher code ' +
      'below.', callback);
  }

  /**
   * Attempt to associate the voucher code with our session. Return the result
   * status, which should be one of 'ok', 'used', 'not found' or 'error'.
   */
  VoucherCodePrompter.prototype.checkVoucherCode =
    function checkVoucherCode(code, callback) {

    $.ajax({
      url: '/voucher-codes/use/' + encodeURIComponent(code),
      type: 'POST',
      data: '{}',
      processData: false,
      contentType: 'application/json; charset=UTF-8',
      success: function(result) {
        callback(null, result.status);
      },
      error: function(err) {
        callback.bind(null, 'error');
      }
    });
  }

})(window);